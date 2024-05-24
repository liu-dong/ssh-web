package com.dong.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author liudong 2024-05-24 17:54:10
 */
public interface GenericDAO<T, ID extends Serializable> {
    T getById(ID id);
    List<T> findAll();
    T save(T entity);
    void save(List<T> entities);
    T update(T entity);
    void delete(T entity);
    void delete(List<T> entities);
    void deleteById(ID id);
}


abstract class AbstractGenericDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private Class<T> entityClass;
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractGenericDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T getById(ID id) {
        return getSession().find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return getSession().createQuery("from " + entityClass.getName(), entityClass).getResultList();
    }

    @Override
    public T save(T entity) {
        getSession().save(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        getSession().update(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        T entity = getById(id);
        if (entity != null) {
            delete(entity);
        }
    }

    @Override
    public void save(List<T> entities) {
        Session session = getSession();
        for (int i = 0; i < entities.size(); i++) {
            session.save(entities.get(i));
            if (i % 20 == 0) { // 以每20个数据一批为例
                session.flush();
                session.clear();
            }
        }
    }

    @Override
    public void delete(List<T> entities) {
        Session session = getSession();
        for (int i = 0; i < entities.size(); i++) {
            session.delete(entities.get(i));
            if (i % 20 == 0) { // 和批量保存相似，批处理size为20
                session.flush();
                session.clear();
            }
        }
    }
}