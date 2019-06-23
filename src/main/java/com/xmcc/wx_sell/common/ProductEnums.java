package com.xmcc.wx_sell.common;

import lombok.Getter;

/**
 * @author khaleesi
 * @create 2019-06-21 20:26
 */
@Getter
public enum ProductEnums {

    PRODUCT_NOT_ENOUGH(1,"商品库存不足"),
    PRODUCT_UP(0,"正常"),
    PRODUCT_DOWN(1,"商品下架");

    private int code;
    private String msg;
    ProductEnums(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
