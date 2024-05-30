package com.dong.web.entity;

import javax.persistence.*;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_role_permission", schema = "meet", catalog = "")
public class RolePermission {
    
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "role_id", nullable = false, length = 36)
    private String roleId;
    @Basic
    @Column(name = "permission_id", nullable = false, length = 36)
    private String permissionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
