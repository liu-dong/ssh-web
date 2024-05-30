package com.dong.web.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_data_catalog_item", schema = "meet", catalog = "")
public class DataCatalogItem {
    
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "catalog_id", nullable = false, length = 36)
    private String catalogId;
    @Basic
    @Column(name = "item_code", nullable = false, length = 50)
    private String itemCode;
    @Basic
    @Column(name = "item_name", nullable = false, length = 50)
    private String itemName;
    @Basic
    @Column(name = "sort", nullable = true)
    private Short sort;
    @Basic
    @Column(name = "status", nullable = false)
    private Short status;
    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    private String remark;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    @Basic
    @Column(name = "create_user_id", nullable = true, length = 36)
    private String createUserId;
    @Basic
    @Column(name = "update_time", nullable = true)
    private Date updateTime;
    @Basic
    @Column(name = "update_user_id", nullable = true, length = 36)
    private String updateUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }
}
