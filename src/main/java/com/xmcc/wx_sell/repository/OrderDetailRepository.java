package com.xmcc.wx_sell.repository;

import com.xmcc.wx_sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author khaleesi
 * @create 2019-06-23 20:29
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
