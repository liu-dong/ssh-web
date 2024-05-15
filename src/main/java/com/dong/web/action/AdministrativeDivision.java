package com.dong.web.action;

import javax.persistence.*;

/**
 * @author liudong 2024/5/15
 */
@Entity
@Table(name = "sys_administrative_division", schema = "meet", catalog = "")
public class AdministrativeDivision {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "parent_code", nullable = true, length = 10)
    private String parentCode;
    @Basic
    @Column(name = "division_code", nullable = true, length = 20)
    private String divisionCode;
    @Basic
    @Column(name = "division_name", nullable = true, length = 255)
    private String divisionName;
    @Basic
    @Column(name = "division_type", nullable = true)
    private Short divisionType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Short getDivisionType() {
        return divisionType;
    }

    public void setDivisionType(Short divisionType) {
        this.divisionType = divisionType;
    }
}
