package com.xmcc.wx_sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author khaleesi
 * @create 2019-06-21 21:09
 */
@Entity
@Data
@DynamicUpdate
@Table(name="product_info")
public class ProductInfo implements Serializable {

    @Id
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价.
     * BigDecimal:他是String类型的
     * */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


}