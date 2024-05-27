package com.dong.web.dao;

import com.dong.web.entity.Account;

/**
 * @author liudong 2024-05-24 17:48:39
 */
public interface AccountDao extends GenericDAO<Account, String> {


}

class AccountDaoImpl extends GenericDAOImpl<Account,String> implements AccountDao {

}
