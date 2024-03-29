package com.xmcc.wx_sell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xmcc.wx_sell.entity.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author khaleesi
 * @create 2019-06-21 21:18 0231
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDto implements Serializable {

    @JsonProperty("id")
    private String productId;

    /** 名字. */
    @JsonProperty("name")
    private String productName;

    /** 单价. */
    @JsonProperty("price")
    private BigDecimal productPrice;


    /** 描述. */
    @JsonProperty("description")
    private String productDescription;

    /** 小图. */
    @JsonProperty("icon")
    private String productIcon;

    //一般情况都是根据数据库查询到productInfo来构建这个类
    public static ProductInfoDto build(ProductInfo productInfo){
        ProductInfoDto productInfoDto = new ProductInfoDto();
        //复制属性
        BeanUtils.copyProperties(productInfo,productInfoDto);
        return productInfoDto;

    }

}



