package com.dong.web.service.impl;

import com.dong.web.entity.Account;
import com.dong.web.model.Pager;
import com.dong.web.model.dto.AccountDTO;
import com.dong.web.model.vo.AccountVO;
import com.dong.web.service.AccountService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author liudong 2024-05-23 16:22:13
 */
public class AccountServiceImpl implements AccountService {

    private SessionFactory sessionFactory;

    @Override
    public Pager<AccountVO> findListByPage(AccountDTO dto, int page) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Account");
        query.setFirstResult((page - 1) * 10);
        query.setMaxResults(10);
        List<AccountVO> accountList = query.getResultList();
        session.close();
        return new Pager<>(page, 10, 10, 1, accountList);
    }

    @Override
    public void save(AccountDTO dto) {

    }

    @Override
    public AccountVO detail(String accountId) {
        return null;
    }

    @Override
    public void delete(String accountId) {

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
