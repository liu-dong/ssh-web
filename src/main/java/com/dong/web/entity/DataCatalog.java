package com.dong.web.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_data_catalog", schema = "meet", catalog = "")
public class DataCatalog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "catalog_code", nullable = false, length = 50)
    private String catalogCode;
    @Basic
    @Column(name = "catalog_name", nullable = false, length = 50)
    private String catalogName;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "status", nullable = false)
    private Short status;
    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    private String remark;
    @Basic
    @Column(name = "create_time", nullable = true)
    private Timestamp createTime;
    @Basic
    @Column(name = "create_user_id", nullable = true, length = 36)
    private String createUserId;
    @Basic
    @Column(name = "update_time", nullable = true)
    private Timestamp updateTime;
    @Basic
    @Column(name = "update_user_id", nullable = true, length = 36)
    private String updateUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }
}
