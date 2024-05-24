package com.dong.web.dao;

import com.dong.web.model.Pager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 * @author liudong 2024-05-24 10:10:58
 */
public class CommonDaoImpl {

    private SessionFactory sessionFactory;

    public Pager<?> findListByPage(Criteria criteria, int page) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // 分页查询数据
        criteria.setFirstResult((page - 1) * 10);
        criteria.setMaxResults(10);
        // 单独的 Criteria 来获取总数
        Criteria countCriteria = criteria;
        countCriteria.setProjection(Projections.rowCount());
        int total = Math.toIntExact((Long) countCriteria.uniqueResult());
        transaction.commit();
        session.close();
        return new Pager<>(page, total, criteria.list());
    }
}
