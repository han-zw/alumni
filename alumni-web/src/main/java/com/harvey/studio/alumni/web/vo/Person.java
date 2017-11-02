/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.web.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.harvey.studio.alumni.business.domain.ContactInfo;

/**
 * Person业务对象模型.
 * @title Person
 * @description Person业务对象模型. 
 * @author zw.han
 * @date 2017年1月1日
 * @version 1.0
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -4170384468026335235L;

    // id
    private Long id;
    // 姓名
    private String name;
    // 学号
    private String studentNo;
    // 城市
    private String city;
    // 地区
    private String area;
    // 创建时间
    private Date createdTime;
    // 最后修改时间
    private Date modifiedTime;

    // 联系信息
    private List<ContactInfo> contactInfos;

    /**
     * @return the contactInfos
     */
    public List<ContactInfo> getContactInfos() {
        return contactInfos;
    }

    /**
     * @param contactInfos the contactInfos to set
     */
    public void setContactInfos(List<ContactInfo> contactInfos) {
        this.contactInfos = contactInfos;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the studentNo
     */
    public String getStudentNo() {
        return studentNo;
    }

    /**
     * @param studentNo the studentNo to set
     */
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the createdTime
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime the createdTime to set
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return the modifiedTime
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime the modifiedTime to set
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", studentNo=" + studentNo + ", city=" + city + ", area=" + area
                + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", contactInfos=" + contactInfos
                + "]";
    }

}
