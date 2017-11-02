/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.business.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * person、班级信息关系表.
 * @title PersonClazzRel
 * @description person、班级信息关系表. 
 * @author zw.han
 * @date 2017年1月1日
 * @version 1.0
 */
public class PersonClazzRel implements Serializable {
    private static final long serialVersionUID = -2779248515890305587L;

    private Long id;
    private Long personId;
    private Long clazzId;
    private Date createdTime;

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
     * @return the personId
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * @return the clazzId
     */
    public Long getClazzId() {
        return clazzId;
    }

    /**
     * @param clazzId the clazzId to set
     */
    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    /**
     * @return the createdTime
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime the createdTime to set
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PersonClazzRel [id=" + id + ", personId=" + personId + ", clazzId=" + clazzId + ", createdTime="
                + createdTime + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clazzId == null) ? 0 : clazzId.hashCode());
        result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((personId == null) ? 0 : personId.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PersonClazzRel other = (PersonClazzRel) obj;
        if (clazzId == null) {
            if (other.clazzId != null) {
                return false;
            }
        } else if (!clazzId.equals(other.clazzId)) {
            return false;
        }
        if (createdTime == null) {
            if (other.createdTime != null) {
                return false;
            }
        } else if (!createdTime.equals(other.createdTime)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (personId == null) {
            if (other.personId != null) {
                return false;
            }
        } else if (!personId.equals(other.personId)) {
            return false;
        }
        return true;
    }
}
