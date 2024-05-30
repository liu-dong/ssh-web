package com.dong.web.service.impl;

import com.dong.web.model.Pagination;
import com.dong.web.model.dto.RolePermissionDTO;
import com.dong.web.service.RolePermissionService;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    /**
     * 查询角色权限信息列表
     *
     * @param dto
     * @param pagination
     * @return
     */
    @Override
    public Object findRolePermissionList(RolePermissionDTO dto, Pagination pagination) {
        return null;
    }

    /**
     * 保存角色权限信息
     *
     * @param dto
     * @return
     */
    @Override
    public Object saveRolePermission(RolePermissionDTO dto) {
        return null;
    }

    /**
     * 查询角色权限信息详细页面
     *
     * @param id
     * @return
     */
    @Override
    public Object getRolePermission(String id) {
        return null;
    }

    /**
     * 删除角色权限信息
     *
     * @param id
     * @return
     */
    @Override
    public Object deleteRolePermission(String id) {
        return null;
    }

}
