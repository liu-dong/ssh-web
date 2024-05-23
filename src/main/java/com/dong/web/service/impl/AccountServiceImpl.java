package com.dong.web.service.impl;

import com.dong.web.model.Pager;
import com.dong.web.model.dto.AccountDTO;
import com.dong.web.model.vo.AccountVO;
import com.dong.web.service.AccountService;

/**
 * @author liudong 2024-05-23 16:22:13
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public Pager<AccountVO> findListByPage(AccountDTO dto, int page) {
        return null;
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
}
