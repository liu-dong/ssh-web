package com.dong.web.dao;

import com.dong.web.entity.Role;
import org.hibernate.SessionFactory;

/**
 * @author liudong 2024-05-24 17:48:39
 */
public interface RoleDao extends GenericDAO<Role, String> {


}

class RoleDaoImpl extends GenericDAOImpl<Role,String> implements RoleDao {

    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
