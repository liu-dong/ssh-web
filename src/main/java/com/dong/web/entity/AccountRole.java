package com.dong.web.entity;

import javax.persistence.*;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_account_role", schema = "meet", catalog = "")
public class AccountRole {
    
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "account_id", nullable = false, length = 36)
    private String accountId;
    @Basic
    @Column(name = "role_id", nullable = false, length = 36)
    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
