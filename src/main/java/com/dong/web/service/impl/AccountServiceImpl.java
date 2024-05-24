package com.dong.web.service.impl;

import com.dong.web.entity.Account;
import com.dong.web.model.Pager;
import com.dong.web.model.dto.AccountDTO;
import com.dong.web.model.vo.AccountVO;
import com.dong.web.service.AccountService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
        Transaction transaction = session.beginTransaction();
        // 创建 Criteria 对象
        Criteria criteria = session.createCriteria(Account.class);
        // 根据AccountDTO的字段构建查询条件
        if (dto.getUsername() != null && !dto.getUsername().isEmpty()) {
            criteria.add(Restrictions.like("username", "%" + dto.getUsername() + "%"));
        }
        if (dto.getRealName() != null && !dto.getRealName().isEmpty()) {
            criteria.add(Restrictions.like("realName", "%" + dto.getRealName() + "%"));
        }
        if (dto.getUserStatus() != null) {
            criteria.add(Restrictions.eq("userStatus", dto.getUserStatus()));
        }
        // 分页查询数据
        criteria.setFirstResult((page - 1) * 10);
        criteria.setMaxResults(10);
        List<AccountVO> dataList = criteria.list();
        // 单独的 Criteria 来获取总数
        Criteria countCriteria = session.createCriteria(Account.class);
        countCriteria.setProjection(Projections.rowCount());
        int total = Math.toIntExact((Long) countCriteria.uniqueResult());
        transaction.commit();
        session.close();
        return new Pager<>(page, total, dataList);
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
