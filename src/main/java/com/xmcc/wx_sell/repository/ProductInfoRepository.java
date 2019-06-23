package com.xmcc.wx_sell.repository;

import com.xmcc.wx_sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author khaleesi
 * @create 2019-06-22 13:57
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    //根据类目的编号和状态查询商品
    List<ProductInfo> findByProductStatusAndCategoryTypeIn(Integer status,List<Integer> typeList);
}
