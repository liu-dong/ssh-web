package com.dong.web.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * @author liudong 2024-05-24 17:48:39
 */
public class AccountDao extends HibernateDaoSupport {

    @Override
    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return super.createHibernateTemplate(sessionFactory);
    }

    
}
