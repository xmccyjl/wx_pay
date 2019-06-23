package com.xmcc.wx_sell.repository;

import com.xmcc.wx_sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author khaleesi
 * @create 2019-06-22 14:00
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}
