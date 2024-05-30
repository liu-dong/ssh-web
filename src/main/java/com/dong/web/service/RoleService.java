package com.dong.web.service;

import com.dong.web.entity.AccountRole;
import com.dong.web.entity.Role;
import com.dong.web.model.PageVO;
import com.dong.web.model.Pagination;
import com.dong.web.model.dto.RoleDTO;
import com.dong.web.model.vo.RoleVO;

import java.util.List;
import java.util.Map;

public interface RoleService {

    /**
     * 查询角色信息列表
     *
     * @param dto
     * @param pagination
     * @return
     */
    PageVO<RoleVO> findRoleList(RoleDTO dto, Pagination pagination);

    /**
     * 保存角色信息
     *
     * @param dto
     * @return
     */
    Role saveRole(RoleDTO dto);

    /**
     * 查询角色信息详细页面
     *
     * @param id
     * @return
     */
    RoleVO getRoleDetail(String id);

    /**
     * 删除角色信息
     *
     * @param id
     */
    void deleteRole(String id);

    /**
     * 查询当前角色下账号信息
     *
     * @param dto
     * @return
     */
    List<Map<String, Object>> findRoleAccountList(RoleDTO dto);

    /**
     * 查询角色权限信息
     *
     * @param dto
     * @return
     */
    RoleDTO findRolePermissionList(RoleDTO dto);

    /**
     * 给角色分配账号
     *
     * @param dto
     * @return
     */
    List<AccountRole> assignAccounts(RoleDTO dto);

    /**
     * 给角色分配权限
     *
     * @param dto
     * @return
     */
    String assignPermissions(RoleDTO dto);
}
