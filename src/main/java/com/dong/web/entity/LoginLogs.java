package com.dong.web.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_login_logs", schema = "meet", catalog = "")
public class LoginLogs {
    
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "account", nullable = false, length = 100)
    private String account;
    @Basic
    @Column(name = "login_type", nullable = false)
    private Integer loginType;
    @Basic
    @Column(name = "login_time", nullable = false)
    private Date loginTime;
    @Basic
    @Column(name = "login_address", nullable = false, length = 200)
    private String loginAddress;
    @Basic
    @Column(name = "login_ip", nullable = false, length = 20)
    private String loginIp;
    @Basic
    @Column(name = "remark", nullable = true, length = 255)
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
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
