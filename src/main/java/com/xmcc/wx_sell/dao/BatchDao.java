package com.xmcc.wx_sell.dao;

import java.util.List;

/**
 * @author khaleesi
 * @create 2019-06-23 21:00
 */
public interface BatchDao<T>{
    void batchInsert(List<T> list);
}
