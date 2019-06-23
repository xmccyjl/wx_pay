package com.xmcc.wx_sell.service;

import com.xmcc.wx_sell.common.ResultResponse;
import com.xmcc.wx_sell.entity.ProductInfo;

/**
 * @author khaleesi
 * @create 2019-06-21 21:51
 */
public interface ProductInfoService {
    ResultResponse queryList();
    ResultResponse<ProductInfo> queryById(String productId);
    void updateProduct(ProductInfo productInfo);

}
