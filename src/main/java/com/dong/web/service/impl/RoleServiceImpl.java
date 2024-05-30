package com.dong.web.service.impl;

import com.dong.util.CommonUtils;
import com.dong.web.dao.AccountRoleDao;
import com.dong.web.dao.CommonDao;
import com.dong.web.dao.RoleDao;
import com.dong.web.dao.RolePermissionDao;
import com.dong.web.entity.AccountRole;
import com.dong.web.entity.Role;
import com.dong.web.entity.RolePermission;
import com.dong.web.model.PageVO;
import com.dong.web.model.Pagination;
import com.dong.web.model.dto.RoleDTO;
import com.dong.web.model.vo.RoleVO;
import com.dong.web.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;
    @Autowired
    AccountRoleDao accountRoleDao;
    @Autowired
    RolePermissionDao rolePermissionDao;
    @Autowired
    CommonDao commonDao;

    /**
     * 查询角色信息列表
     *
     * @param dto
     * @param pagination
     * @return
     */
    @Override
    public PageVO<RoleVO> findRoleList(RoleDTO dto, Pagination pagination) {
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<>();
        sql.append(" SELECT id,role_code roleCode,role_name roleName,remark,create_time createTime ");
        sql.append(" FROM sys_role ");
        sql.append(" WHERE 1=1 ");
        if (StringUtils.isNotBlank(dto.getRoleName())) {
            sql.append(" AND role_name LIKE ? ");
            params.add("%" + dto.getRoleName().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getRoleCode())) {
            sql.append(" AND role_code LIKE ? ");
            params.add("%" + dto.getRoleCode().trim() + "%");
        }
        sql.append(" ORDER BY create_time DESC ");
        return commonDao.findListBySql(pagination, sql, params, RoleVO.class);
    }

    /**
     * 保存角色信息
     *
     * @param dto
     * @return
     */
    @Override
    public Role saveRole(RoleDTO dto) {
        Role entity = new Role();
        if (StringUtils.isBlank(dto.getId())) {// 新增
            entity.setId(CommonUtils.getUUID());
            entity.setCreateTime(new Date());
        } else {
            entity = roleDao.getById(dto.getId());
        }
        entity.setRoleCode(dto.getRoleCode());
        entity.setRoleName(dto.getRoleName());
        entity.setRemark(dto.getRemark());
        entity.setUpdateTime(new Date());
        return roleDao.save(entity);
    }

    /**
     * 查询角色信息详细页面
     *
     * @param id
     * @return
     */
    @Override
    public RoleVO getRoleDetail(String id) {
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("id不能为空");
        }
        Role entity = roleDao.getById(id);
        return convertVO(entity);
    }

    private RoleVO convertVO(Role entity) {
        RoleVO vo = new RoleVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    /**
     * 删除角色信息
     *
     * @param id
     */
    @Override
    public void deleteRole(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("删除失败，id不能为空!");
        }
        roleDao.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> findRoleAccountList(RoleDTO dto) {
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>();
        sql.append(" SELECT a.id,a.username,a.real_name realName,a.user_type userType ");
        sql.append(" FROM sys_account a ");
        sql.append(" INNER JOIN sys_account_role ar ON ar.account_id = a.id ");
        sql.append(" INNER JOIN sys_role r ON r.id = ar.role_id ");
        sql.append(" WHERE r.role_code = ? ");
        if (StringUtils.isBlank(dto.getRoleCode())) {
            throw new RuntimeException("角色编码不能为空！");
        }
        param.add(dto.getRoleCode());
        sql.append(" ORDER BY a.create_time DESC ");
        int total = commonDao.getTotalBySql(sql, param);
        List<Map<String, Object>> dataList = new ArrayList<>();
        if (total > 0) {
            dataList = commonDao.findListBySql(sql, param);

        }
        return dataList;
    }

    @Override
    public RoleDTO findRolePermissionList(RoleDTO dto) {
        RoleDTO result = new RoleDTO();
        // 根据角色id查询出所有权限
        List<RolePermission> rolePermissionList = rolePermissionDao.findByRoleId(dto.getRoleId());
        if (!CollectionUtils.isEmpty(rolePermissionList)) {
            List<String> permissionIdList = new ArrayList<>();
            // 查询权限id集合
            for (RolePermission rolePermission : rolePermissionList) {
                permissionIdList.add(rolePermission.getPermissionId());
            }
            result.setRoleId(rolePermissionList.get(0).getRoleId());
            result.setPermissionIdList(permissionIdList);
        }
        return result;
    }

    @Transactional
    @Override
    public List<AccountRole> assignAccounts(RoleDTO dto) {
        if (StringUtils.isBlank(dto.getRoleId())) {
            throw new RuntimeException("角色id不能为空");
        }
        accountRoleDao.deleteAccountRoleByRoleId(dto.getRoleId());
        List<AccountRole> entityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dto.getAccountIdList())) {
            for (String accountId : dto.getAccountIdList()) {
                AccountRole entity = new AccountRole();
                entity.setId(CommonUtils.getUUID());
                entity.setAccountId(accountId);
                entity.setRoleId(dto.getRoleId());
                entityList.add(entity);
            }
            accountRoleDao.save(entityList);
        }
        return entityList;
    }

    @Transactional
    @Override
    public String assignPermissions(RoleDTO dto) {
        if (StringUtils.isBlank(dto.getRoleId())) {
            throw new RuntimeException("角色id不能为空");
        }
        rolePermissionDao.deleteByRoleId(dto.getRoleId());
        List<RolePermission> entityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dto.getPermissionIdList())) {
            for (String permission : dto.getPermissionIdList()) {
                RolePermission entity = new RolePermission();
                entity.setId(CommonUtils.getUUID());
                entity.setPermissionId(permission);
                entity.setRoleId(dto.getRoleId());
                entityList.add(entity);
            }
            rolePermissionDao.save(entityList);
        }
        return entityList.get(0).getRoleId();
    }
}
