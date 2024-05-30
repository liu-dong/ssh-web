package com.dong.web.service.impl;

import com.dong.util.CommonUtils;
import com.dong.util.ObjectUtils;
import com.dong.web.dao.CommonDao;
import com.dong.web.dao.PermissionDao;
import com.dong.web.entity.Permission;
import com.dong.web.model.PageVO;
import com.dong.web.model.Pagination;
import com.dong.web.model.dto.PermissionDTO;
import com.dong.web.model.vo.PermissionVO;
import com.dong.web.service.PermissionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;
    @Autowired
    CommonDao commonDao;

    /**
     * 查询权限信息列表
     *
     * @param dto
     * @param pagination
     * @return
     */
    @Override
    public PageVO<PermissionVO> findPermissionList(PermissionDTO dto, Pagination pagination) {
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<>();
        sql.append(" SELECT id,permission_code permissionCode,permission_name permissionName,permission_type permissionType,create_time createTime ");
        sql.append(" FROM sys_permission ");
        sql.append(" WHERE 1=1 ");
        if (StringUtils.isNotBlank(dto.getPermissionCode())) {
            sql.append(" AND permission_code LIKE ? ");
            params.add("%" + dto.getPermissionCode().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getPermissionName())) {
            sql.append(" AND permission_name LIKE ? ");
            params.add("%" + dto.getPermissionName().trim() + "%");
        }
        sql.append(" ORDER BY create_time DESC ");
        return commonDao.findListBySql(pagination, sql, params, PermissionVO.class);
    }

    @Override
    public List<Map<String, Object>> getPermissionTree(PermissionDTO dto) {
        List<Permission> permissionList = permissionDao.findAll();
        List<Map<String, Object>> listMap = new ArrayList<>();
        // 实体类list转map对象list
        for (Permission permission : permissionList) {
            Map<String, Object> map = ObjectUtils.objectToMap(permission);
            map.put("children", new ArrayList<>());
            listMap.add(map);
        }
        // 递归生成树结构
        return CommonUtils.listToTreeByRecursive(listMap);
    }

    /**
     * 保存权限信息
     *
     * @param dto
     * @return
     */
    @Override
    public Permission savePermission(PermissionDTO dto) {
        Permission entity = new Permission();
        if (StringUtils.isEmpty(dto.getId())) {// 新增
            entity.setId(CommonUtils.getUUID());
            entity.setCreateTime(new Date());
        } else {
            entity = permissionDao.getById(dto.getId());
            entity.setUpdateTime(new Date());
        }
        entity.setPermissionCode(dto.getPermissionCode());
        entity.setPermissionName(dto.getPermissionName());
        entity.setPermissionType(dto.getPermissionType());
        entity.setParentId(dto.getParentId());
        entity.setResourceId(dto.getResourceId());
        entity.setUpdateTime(new Date());
        entity = permissionDao.save(entity);
        return permissionDao.save(entity);
    }

    /**
     * 查询权限信息详细页面
     *
     * @param id
     * @return
     */
    @Override
    public Permission getPermission(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("查询失败，id不能为空!");
        }
        return permissionDao.getById(id);
    }

    /**
     * 删除权限信息
     *
     * @param id
     */
    @Override
    public void deletePermission(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("删除失败，id不能为空!");
        }
        permissionDao.deleteById(id);
    }

}
