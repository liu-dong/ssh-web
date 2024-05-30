package com.dong.web.action;

import com.dong.web.model.Pagination;
import com.dong.web.model.PageVO;
import com.dong.web.model.dto.RoleDTO;
import com.dong.web.model.vo.RoleVO;
import com.dong.web.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liudong 2024-05-14 16:52:28
 */
@Getter
@Setter
public class RoleAction extends ActionSupport {

    /**
     * 分页
     */
    private Pagination pagination = new Pagination();
    /**
     * 分页结果
     */
    private PageVO<RoleVO> pageVO;

    /**
     * 账号id
     */
    private String roleId;

    /**
     * 页面类型 detail：查看，edit：编辑，add：新增
     */
    private String viewType;
    private RoleDTO dto = new RoleDTO();
    private RoleVO vo;


    private RoleService roleService;

    // 分页查询账号列表
    public String list() {
        pageVO = roleService.findRoleList(dto, pagination);
        return SUCCESS;
    }

    // 新增账号
    public String save() {
        roleService.saveRole(dto);
        return SUCCESS;
    }

    // 查询账号详细信息
    public String detail() {
        vo = roleService.getRoleDetail(roleId);
        return SUCCESS;
    }

    // 删除账号
    public String delete() {
        roleService.deleteRole(roleId);
        return SUCCESS;
    }
}
