package com.dong.web.action;

import com.dong.web.model.Page;
import com.dong.web.model.PageVO;
import com.dong.web.model.dto.AccountDTO;
import com.dong.web.model.vo.AccountVO;
import com.dong.web.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liudong 2024-05-14 16:52:28
 */
@Getter
@Setter
public class AccountAction extends ActionSupport {

    /**
     * 分页
     */
    private Page page = new Page();
    /**
     * 分页结果
     */
    private PageVO<AccountVO> pageVO;

    /**
     * 账号id
     */
    private String accountId;

    /**
     * 页面类型 detail：查看，edit：编辑，add：新增
     */
    private String viewType;
    private AccountDTO dto = new AccountDTO();
    private AccountVO vo;


    private AccountService accountService;

    // 分页查询账号列表
    public String list() {
        pageVO = accountService.findListByPage(dto, page);
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
}
