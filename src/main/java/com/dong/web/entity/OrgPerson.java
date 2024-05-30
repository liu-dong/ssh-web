package com.dong.web.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_org_person", schema = "meet", catalog = "")
public class OrgPerson {
    
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "person_id", nullable = false, length = 36)
    private String personId;
    @Basic
    @Column(name = "org_id", nullable = false, length = 36)
    private String orgId;
    @Basic
    @Column(name = "create_time", nullable = true)
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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
