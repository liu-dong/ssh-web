package com.dong.web.service;

import com.dong.web.entity.Permission;
import com.dong.web.model.PageVO;
import com.dong.web.model.Pagination;
import com.dong.web.model.dto.PermissionDTO;
import com.dong.web.model.vo.PermissionVO;

import java.util.List;
import java.util.Map;

public interface PermissionService {

    /**
     * 查询权限信息列表
     *
     * @param dto
     * @param pagination
     * @return
     */
    PageVO<PermissionVO> findPermissionList(PermissionDTO dto, Pagination pagination);

    /**
     * 查询权限树
     *
     * @param dto
     * @return
     */
    List<Map<String, Object>> getPermissionTree(PermissionDTO dto);

    /**
     * 保存权限信息
     *
     * @param dto
     * @return
     */
    Permission savePermission(PermissionDTO dto);

    /**
     * 查询权限信息详细页面
     *
     * @param id
     * @return
     */
    Permission getPermission(String id);

    /**
     * 删除权限信息
     *
     * @param id
     */
    void deletePermission(String id);
}
