package com.dong.web.dao;

import com.dong.web.model.PageVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import java.util.function.Consumer;

/**
 * @author liudong 2024-05-24 10:10:58
 */
public interface CommonDao<E> {

    /**
     * 列表查询
     *
     * @param criteria
     * @param page
     * @return
     */
    PageVO<?> findListByPage(Criteria criteria, int page);

}

class CommonDaoImpl<E> implements CommonDao<E> {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> PageVO<T> findListByPage(Class<T> clazz, int page, Consumer<Criteria> conditions) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            // 查询数据列表
            Criteria criteria = session.createCriteria(clazz);
            conditions.accept(criteria);
            criteria.setFirstResult((page - 1) * 10);
            criteria.setMaxResults(10);
            // 查询数据总行数
            Criteria countCriteria = session.createCriteria(clazz);
            conditions.accept(countCriteria);
            countCriteria.setProjection(Projections.rowCount());
            int total = Math.toIntExact((Long) countCriteria.uniqueResult());
            transaction.commit();
            return new PageVO<>(page, total, criteria.list());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            // Handle exception
            System.err.println(e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public PageVO<?> findListByPage(Criteria criteria, int page) {
        return null;
    }

    
}
