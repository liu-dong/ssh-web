package com.dong.web.action;

import com.dong.web.model.Pager;
import com.dong.web.model.dto.AccountDTO;
import com.dong.web.model.vo.AccountVO;
import com.dong.web.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author liudong 2024-05-14 16:52:28
 */
public class AccountAction extends ActionSupport {

    /**
     * 当前页码
     */
    private int page = 1;
    /**
     * 分页返回结果
     */
    private Pager<AccountVO> pager;
    /**
     * 账号id
     */
    private String accountId;
    private AccountDTO dto;
    private AccountVO vo;


    private AccountService accountService;

    // 分页查询账号列表
    public String list() {
        pager = accountService.findListByPage(dto, page);
        return SUCCESS;
    }

    // 新增账号
    public String save() {
        accountService.save(dto);
        return SUCCESS;
    }

    // 查询账号详细信息
    public String detail() {
        vo = accountService.detail(accountId);
        return SUCCESS;
    }

    // 删除账号
    public String delete() {
        accountService.delete(accountId);
        return SUCCESS;
    }

    public Pager<AccountVO> getPager() {
        return pager;
    }

    public void setPager(Pager<AccountVO> pager) {
        this.pager = pager;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public AccountDTO getDto() {
        return dto;
    }

    public void setDto(AccountDTO dto) {
        this.dto = dto;
    }

    public AccountVO getVo() {
        return vo;
    }

    public void setVo(AccountVO vo) {
        this.vo = vo;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
