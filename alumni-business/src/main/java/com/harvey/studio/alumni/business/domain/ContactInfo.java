/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.business.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 联系方式域模型
 * @title ContactInfo
 * @description 联系方式域模型 
 * @author zw.han
 * @date 2017年1月1日
 * @version 1.0
 */
public class ContactInfo implements Serializable {
    private static final long serialVersionUID = 3422657410076161598L;

    private Long id;
    private Long personId;
    private int type;
    private String content;
    private Date createdTime;
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
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
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
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
        result = prime * result + ((personId == null) ? 0 : personId.hashCode());
        result = prime * result + type;
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
        ContactInfo other = (ContactInfo) obj;
        if (content == null) {
            if (other.content != null) {
                return false;
            }
        } else if (!content.equals(other.content)) {
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
        if (modifiedTime == null) {
            if (other.modifiedTime != null) {
                return false;
            }
        } else if (!modifiedTime.equals(other.modifiedTime)) {
            return false;
        }
        if (personId == null) {
            if (other.personId != null) {
                return false;
            }
        } else if (!personId.equals(other.personId)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ContactInfo [id=" + id + ", personId=" + personId + ", type=" + type + ", content=" + content
                + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }

}
