package com.dong.web.service;

import com.dong.web.entity.Account;
import com.dong.web.model.Page;
import com.dong.web.model.PageVO;
import com.dong.web.model.dto.AccountDTO;
import com.dong.web.model.vo.AccountVO;

/**
 * @author liudong 2024-05-23 16:13:25
 */
public interface AccountService {

    PageVO<AccountVO> findListByPage(AccountDTO dto, Page page);

    Account save(AccountDTO dto);

    AccountVO detail(String accountId);

    void delete(String accountId);

}
