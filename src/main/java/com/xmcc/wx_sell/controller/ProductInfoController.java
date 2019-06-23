package com.xmcc.wx_sell.controller;

import com.xmcc.wx_sell.common.ResultResponse;
import com.xmcc.wx_sell.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author khaleesi
 * @create 2019-06-21 21:38
 */
@RestController
@RequestMapping("buyer/product")
@Api(description = "商品信息接口")
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;
    @RequestMapping("list")
    @ApiOperation(value = "查询商品列表")
    public ResultResponse list(){
        return productInfoService.queryList();
    }
}
