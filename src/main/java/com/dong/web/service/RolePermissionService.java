package com.dong.web.service;

import com.dong.web.model.Pagination;
import com.dong.web.model.dto.RolePermissionDTO;

public interface RolePermissionService {

    /**
     * 查询角色权限信息列表
     *
     * @param dto
     * @param pagination
     * @return
     */
    Object findRolePermissionList(RolePermissionDTO dto, Pagination pagination);

    /**
     * 保存角色权限信息
     *
     * @param dto
     * @return
     */
    Object saveRolePermission(RolePermissionDTO dto);

    /**
     * 查询角色权限信息详细页面
     *
     * @param id
     * @return
     */
    Object getRolePermission(String id);

    /**
     * 删除角色权限信息
     *
     * @param id
     * @return
     */
    Object deleteRolePermission(String id);
}
