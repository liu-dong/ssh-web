package com.dong.web.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_operate_logs", schema = "meet", catalog = "")
public class OperateLogs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "account", nullable = false, length = 100)
    private String account;
    @Basic
    @Column(name = "operate_type", nullable = false, length = 10)
    private String operateType;
    @Basic
    @Column(name = "operate_time", nullable = false)
    private Timestamp operateTime;
    @Basic
    @Column(name = "module_name", nullable = false, length = 50)
    private String moduleName;
    @Basic
    @Column(name = "module_code", nullable = false, length = 50)
    private String moduleCode;
    @Basic
    @Column(name = "operate_object", nullable = false, length = 200)
    private String operateObject;
    @Basic
    @Column(name = "login_ip", nullable = true, length = 20)
    private String loginIp;
    @Basic
    @Column(name = "content", nullable = true, length = 2000)
    private String content;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;
    @Basic
    @Column(name = "update_time", nullable = true)
    private Timestamp updateTime;

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

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getOperateObject() {
        return operateObject;
    }

    public void setOperateObject(String operateObject) {
        this.operateObject = operateObject;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
