package com.dong.web.action;

import com.dong.web.model.Pagination;
import com.dong.web.model.PageVO;
import com.dong.web.model.dto.OrgDTO;
import com.dong.web.model.vo.OrgVO;
import com.dong.web.service.OrgService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liudong 2024-05-14 16:52:28
 */
@Getter
@Setter
public class OrgAction extends ActionSupport {

    /**
     * 分页
     */
    private Pagination pagination = new Pagination();
    /**
     * 分页结果
     */
    private PageVO<OrgVO> pageVO;

    /**
     * 账号id
     */
    private String orgId;

    /**
     * 页面类型 detail：查看，edit：编辑，add：新增
     */
    private String viewType;
    private OrgDTO dto = new OrgDTO();
    private OrgVO vo;


    private OrgService orgService;

    // 分页查询账号列表
    public String list() {
        pageVO = orgService.findOrgList(dto, pagination);
        return SUCCESS;
    }

    // 新增账号
    public String save() {
        orgService.saveOrg(dto);
        return SUCCESS;
    }

    // 查询账号详细信息
    public String detail() throws Exception {
        vo = orgService.getOrg(orgId);
        return SUCCESS;
    }

    // 删除账号
    public String delete() throws Exception {
        orgService.deleteOrg(orgId);
        return SUCCESS;
    }
}
