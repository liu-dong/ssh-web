package com.dong.web.service.impl;

import cn.hutool.core.date.DateUtil;
import com.dong.web.dao.AccountDao;
import com.dong.web.entity.Account;
import com.dong.web.model.Pagination;
import com.dong.web.model.PageVO;
import com.dong.web.model.dto.AccountDTO;
import com.dong.web.model.vo.AccountVO;
import com.dong.web.service.AccountService;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author liudong 2024-05-23 16:22:13
 */
@Getter
@Setter
public class AccountServiceImpl implements AccountService {

    SessionFactory sessionFactory;
    AccountDao accountDao;

    @Override
    public PageVO<AccountVO> findListByPage(AccountDTO dto, Pagination pagination) {
        Session session = sessionFactory.openSession();
        // 创建 Criteria 对象
        Criteria criteria = createCriteriaWithConditions(session, dto);
        // 分页查询数据
        criteria.setFirstResult((pagination.getPage() - 1) * pagination.getLimit());
        criteria.setMaxResults(pagination.getLimit());
        List<AccountVO> dataList = criteria.list();
        // 单独的 Criteria 来获取总数
        Criteria countCriteria = createCriteriaWithConditions(session, dto);
        countCriteria.setProjection(Projections.rowCount());
        int total = Math.toIntExact((Long) countCriteria.uniqueResult());
        session.close();
        return new PageVO<>(pagination.getPage(), total, dataList);
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
        if (StringUtils.isNotBlank(dto.getId())) {
            entity = accountDao.getById(dto.getId());
        } else {
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
            entity.setCreateTime(new Date());
            entity.setPersonId("1");
        }
        BeanUtils.copyProperties(dto, entity, "id","lastLoginTime", "loginCount");
        entity.setPasswordHash(dto.getPassword());
        entity.setLoginCount(0);
        entity.setUpdateTime(new Date());
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
        vo.setLastLoginTime(DateUtil.formatDateTime(entity.getLastLoginTime()));
        return vo;
    }

    @Override
    public void delete(String accountId) {
        accountDao.deleteById(accountId);
    }
}
