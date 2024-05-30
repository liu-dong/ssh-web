package com.dong.web.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_role", schema = "meet", catalog = "")
public class Role {
    
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "role_code", nullable = false, length = 20)
    private String roleCode;
    @Basic
    @Column(name = "role_name", nullable = false, length = 100)
    private String roleName;
    @Basic
    @Column(name = "remark", nullable = true, length = 150)
    private String remark;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    @Basic
    @Column(name = "update_time", nullable = true)
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
