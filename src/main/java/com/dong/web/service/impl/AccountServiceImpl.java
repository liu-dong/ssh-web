package com.dong.web.service.impl;

import cn.hutool.core.date.DateUtil;
import com.dong.util.CommonUtils;
import com.dong.web.dao.AccountDao;
import com.dong.web.dao.CommonDao;
import com.dong.web.entity.Account;
import com.dong.web.model.PageVO;
import com.dong.web.model.Pagination;
import com.dong.web.model.dto.AccountDTO;
import com.dong.web.model.vo.AccountVO;
import com.dong.web.service.AccountService;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author liudong 2024-05-23 16:22:13
 */
@Getter
@Setter
public class AccountServiceImpl implements AccountService {

    CommonDao commonDao;
    AccountDao accountDao;

    @Override
    public PageVO<AccountVO> findListByPage(AccountDTO dto, Pagination pagination) {
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<>();
        sql.append(" SELECT id, username, user_type userType, person_id personId, real_name realName, ");
        sql.append(" phone, email, login_count, ");
        sql.append(" user_status userStatus, last_login_time lastLoginTime, create_time createTime ");
        sql.append(" FROM sys_account ");
        sql.append(" WHERE 1=1 ");
        //用户名
        if (StringUtils.isNotBlank(dto.getUsername())) {
            sql.append(" AND username LIKE ? ");
            params.add(CommonUtils.jointLike(dto.getUsername()));
        }
        //用户类型
        if (dto.getUserType() != null) {
            sql.append(" AND user_type = ? ");
            params.add(dto.getUserType());
        }
        sql.append(" ORDER BY create_time DESC ");
        return commonDao.findListBySql(pagination, sql, params, AccountVO.class);
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
