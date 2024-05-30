package com.dong.web.dao;

import com.dong.web.entity.Permission;
import org.hibernate.SessionFactory;

/**
 * @author liudong 2024-05-24 17:48:39
 */
public interface PermissionDao extends GenericDAO<Permission, String> {


}

class PermissionDaoImpl extends GenericDAOImpl<Permission,String> implements PermissionDao {

    public PermissionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
