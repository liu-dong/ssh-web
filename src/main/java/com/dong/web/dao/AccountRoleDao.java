package com.dong.web.dao;

import com.dong.web.entity.AccountRole;
import org.hibernate.SessionFactory;

/**
 * @author liudong 2024-05-24 17:48:39
 */
public interface AccountRoleDao extends GenericDAO<AccountRole, String> {


    void deleteAccountRoleByRoleId(String roleId);
}

class AccountRoleDaoImpl extends GenericDAOImpl<AccountRole,String> implements AccountRoleDao {

    public AccountRoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void deleteAccountRoleByRoleId(String roleId) {

    }
}
