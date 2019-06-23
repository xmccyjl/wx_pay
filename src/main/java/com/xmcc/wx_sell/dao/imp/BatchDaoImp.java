package com.xmcc.wx_sell.dao.imp;

import com.xmcc.wx_sell.dao.BatchDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * @author khaleesi
 * @create 2019-06-23 21:02
 */
public class BatchDaoImp<T> implements BatchDao<T> {

    //自动寻找实现类
     @PersistenceContext
    private EntityManager em;
    @Override
    public void batchInsert(List<T> list) {
        int size =list.size();
        for(int i =0;i<size;i++){
            em.persist(list.get(i));
            if(i%100==0||i==size-1){
                em.flush();
                em.clear();
            }

        }

    }
}
