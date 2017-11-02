/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.business.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级域模型.
 * @title Clazz
 * @description 班级域模型. 
 * @author zw.han
 * @date 2017年1月1日
 * @version 1.0
 */
public class Clazz implements Serializable {
    private static final long serialVersionUID = 6515749982443605498L;

    // 主键
    private Long id;
    // 班级名
    private String clazzName;
    // 创建者id
    private Long creator;
    // 创建时间
    private Date createdTime;
    // 修改时间
    private Date modifiedTime;

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
     * @return the clazzName
     */
    public String getClazzName() {
        return clazzName;
    }

    /**
     * @param clazzName the clazzName to set
     */
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    /**
     * @return the creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(Long creator) {
        this.creator = creator;
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

    /**
     * @return the modifiedTime
     */
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
        return "Clazz [id=" + id + ", clazzName=" + clazzName + ", creator=" + creator + ", createdTime=" + createdTime
                + ", modifiedTime=" + modifiedTime + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clazzName == null) ? 0 : clazzName.hashCode());
        result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
        result = prime * result + ((creator == null) ? 0 : creator.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
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
        Clazz other = (Clazz) obj;
        if (clazzName == null) {
            if (other.clazzName != null) {
                return false;
            }
        } else if (!clazzName.equals(other.clazzName)) {
            return false;
        }
        if (createdTime == null) {
            if (other.createdTime != null) {
                return false;
            }
        } else if (!createdTime.equals(other.createdTime)) {
            return false;
        }
        if (creator == null) {
            if (other.creator != null) {
                return false;
            }
        } else if (!creator.equals(other.creator)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (modifiedTime == null) {
            if (other.modifiedTime != null) {
                return false;
            }
        } else if (!modifiedTime.equals(other.modifiedTime)) {
            return false;
        }
        return true;
    }

}
