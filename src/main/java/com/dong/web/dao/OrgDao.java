package com.dong.web.dao;

import com.dong.web.entity.Org;
import org.hibernate.SessionFactory;

/**
 * @author liudong 2024-05-24 17:48:39
 */
public interface OrgDao extends GenericDAO<Org, String> {


}

class OrgDaoImpl extends GenericDAOImpl<Org,String> implements OrgDao {

    public OrgDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
