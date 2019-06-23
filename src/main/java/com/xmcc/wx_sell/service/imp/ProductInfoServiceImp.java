package com.xmcc.wx_sell.service.imp;

import com.xmcc.wx_sell.common.ProductEnums;
import com.xmcc.wx_sell.common.ResultEnums;
import com.xmcc.wx_sell.common.ResultResponse;
import com.xmcc.wx_sell.dto.ProductCategoryDto;
import com.xmcc.wx_sell.dto.ProductInfoDto;
import com.xmcc.wx_sell.entity.ProductCategory;
import com.xmcc.wx_sell.entity.ProductInfo;
import com.xmcc.wx_sell.repository.ProductCategoryRepository;
import com.xmcc.wx_sell.repository.ProductInfoRepository;
import com.xmcc.wx_sell.service.ProductInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author khaleesi
 * @create 2019-06-21 21:52
 */
@Service
public class ProductInfoServiceImp implements ProductInfoService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public ResultResponse queryList() {
        //查询所有分类
        List<ProductCategory> all = productCategoryRepository.findAll();
        //将查询出来的转成dto
        List<ProductCategoryDto> productCategoryDtoList =
           all.stream().map(productCategory -> ProductCategoryDto.build(productCategory)).collect(Collectors.toList());
        //判断集合是否为空
        if(CollectionUtils.isEmpty(all)){
            return ResultResponse.fail();
        }
        //获取类目的编号集合
        List<Integer> typeList =
           all.stream().map(productCategoryDto -> productCategoryDto.getCategoryType()).collect(Collectors.toList());
        //根据TypeList查询商品列表
        List<ProductInfo> productInfoList =
                productInfoRepository.findByProductStatusAndCategoryTypeIn(ResultEnums.PRODUCT_UP.getCode(), typeList);
        //对目标集合进行遍历 取出每个商品的类目编号设置到对应的目录中
        //将productInfo 设置到foods中
        //过滤：不同的type,进行不同的封装
        //将productInfo转成一个dto类型
        List<ProductCategoryDto> productCategoryDtos = productCategoryDtoList.parallelStream().map(productCategoryDto -> {
            productCategoryDto.setProductInfoDtoList(productInfoList.stream().filter(productInfo ->
                    productInfo.getCategoryType() == productCategoryDto.getCategoryType())
                    .map(productInfo -> ProductInfoDto.build(productInfo)).collect(Collectors.toList()));
            return productCategoryDto;
        }).collect(Collectors.toList());


        return ResultResponse.success(productCategoryDtos);
    }

    @Override
    public ResultResponse<ProductInfo> queryById(String productId) {
        if(StringUtils.isBlank(productId)){
            return ResultResponse.fail(ResultEnums.PARAM_ERROR.getMsg());
        }
        Optional<ProductInfo> byId = productInfoRepository.findById(productId);
        if(!byId.isPresent()){
            return ResultResponse.fail(ResultEnums.NOT_EXITS.getMsg());
        }
        ProductInfo productInfo = byId.get();
        if(productInfo.getProductStatus()==ResultEnums.PRODUCT_DOWN.getCode()){
             return ResultResponse.fail(ResultEnums.PRODUCT_DOWN.getMsg());
        }
        return ResultResponse.success(productInfo);
    }

    @Override
    public void updateProduct(ProductInfo productInfo) {
        ProductInfo save = productInfoRepository.save(productInfo);
    }
}
