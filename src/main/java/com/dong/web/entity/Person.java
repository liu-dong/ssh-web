package com.dong.web.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_person", schema = "meet", catalog = "")
public class Person {
    
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "org_id", nullable = false, length = 36)
    private String orgId;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "identity_card", nullable = false, length = 36)
    private String identityCard;
    @Basic
    @Column(name = "age", nullable = true)
    private Integer age;
    @Basic
    @Column(name = "birthdate", nullable = true)
    private Date birthdate;
    @Basic
    @Column(name = "sex", nullable = true)
    private Short sex;
    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;
    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;
    @Basic
    @Column(name = "present_address", nullable = true, length = 100)
    private String presentAddress;
    @Basic
    @Column(name = "native_place", nullable = true, length = 100)
    private String nativePlace;
    @Basic
    @Column(name = "individual_resume", nullable = true, length = 255)
    private String individualResume;
    @Basic
    @Column(name = "delete_status", nullable = false)
    private Integer deleteStatus;
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getIndividualResume() {
        return individualResume;
    }

    public void setIndividualResume(String individualResume) {
        this.individualResume = individualResume;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
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
