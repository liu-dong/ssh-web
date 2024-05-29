package com.dong.web.service.impl;

import com.dong.web.dao.AccountDao;
import com.dong.web.entity.Account;
import com.dong.web.model.Page;
import com.dong.web.model.PageVO;
import com.dong.web.model.dto.AccountDTO;
import com.dong.web.model.vo.AccountVO;
import com.dong.web.service.AccountService;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author liudong 2024-05-23 16:22:13
 */
@Getter
@Setter
public class AccountServiceImpl implements AccountService {

    SessionFactory sessionFactory;
    AccountDao accountDao;

    @Override
    public PageVO<AccountVO> findListByPage(AccountDTO dto, Page page) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // 创建 Criteria 对象
        Criteria criteria = createCriteriaWithConditions(session, dto);
        // 分页查询数据
        criteria.setFirstResult((page.getPage() - 1) * page.getLimit());
        criteria.setMaxResults(10);
        List<AccountVO> dataList = criteria.list();
        // 单独的 Criteria 来获取总数
        Criteria countCriteria = createCriteriaWithConditions(session, dto);
        countCriteria.setProjection(Projections.rowCount());
        int total = Math.toIntExact((Long) countCriteria.uniqueResult());
        transaction.commit();
        session.close();
        return new PageVO<>(page.getPage(), total, dataList);
    }

    private Criteria createCriteriaWithConditions(Session session, AccountDTO dto) {
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
        // 这里可以添加其他查询条件...
        return criteria;
    }

    @Override
    public Account save(AccountDTO dto) {
        Account entity = convertEntity(dto);
        return accountDao.save(entity);
    }

    private Account convertEntity(AccountDTO dto) {
        Account entity = new Account();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public AccountVO detail(String accountId) {
        Account entity = accountDao.getById(accountId);
        return convertVO(entity);
    }

    private AccountVO convertVO(Account entity) {
        AccountVO vo = new AccountVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public void delete(String accountId) {
        accountDao.deleteById(accountId);
    }
}
