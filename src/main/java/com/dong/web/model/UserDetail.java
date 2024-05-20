package com.dong.web.model;

import com.dong.web.entity.Account;

import java.util.List;
import java.util.Map;

/**
 * 用户信息
 *
 * @author liudong 2024-05-20 17:47:29
 */
public class UserDetail {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 单位id
     */
    private String orgId;

    /**
     * 单位名称
     */
    private String orgName;

    /**
     * 拥有角色
     */
    private List<Map<String, Object>> roles;

    /**
     * 拥有权限
     */
    private List<Map<String, Object>> permissions;

    public UserDetail(Account account) {
        this.userId = account.getId();
        this.username = account.getUsername();
        this.realName = account.getRealName();
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<Map<String, Object>> getRoles() {
        return roles;
    }

    public void setRoles(List<Map<String, Object>> roles) {
        this.roles = roles;
    }

    public List<Map<String, Object>> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Map<String, Object>> permissions) {
        this.permissions = permissions;
    }
}
