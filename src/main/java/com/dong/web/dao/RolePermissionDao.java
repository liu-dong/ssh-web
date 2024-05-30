package com.dong.web.dao;

import com.dong.web.entity.RolePermission;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;

/**
 * @author liudong 2024-05-24 17:48:39
 */
public interface RolePermissionDao extends GenericDAO<RolePermission, String> {


    List<RolePermission> findByRoleId(String roleId);

    void deleteByRoleId(String roleId);
}

class RolePermissionDaoImpl extends GenericDAOImpl<RolePermission,String> implements RolePermissionDao {

    public RolePermissionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<RolePermission> findByRoleId(String roleId) {
        return Collections.emptyList();
    }

    @Override
    public void deleteByRoleId(String roleId) {

    }
}
