package com.xmcc.wx_sell.repository;

import com.xmcc.wx_sell.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author khaleesi
 * @create 2019-06-23 20:31
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
