/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.business.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Person领域模型
 * @title PersonPo
 * @description person模型 
 * @author zw.han
 * @date 2017年1月1日
 * @version 1.0
 */
public class PersonPo implements Serializable {
    private static final long serialVersionUID = 7582408654371256316L;

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
        return "Person [id=" + id + ", name=" + name + ", studentNo=" + studentNo + ", city=" + city + ", area=" + area
                + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((area == null) ? 0 : area.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((studentNo == null) ? 0 : studentNo.hashCode());
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
        PersonPo other = (PersonPo) obj;
        if (area == null) {
            if (other.area != null) {
                return false;
            }
        } else if (!area.equals(other.area)) {
            return false;
        }
        if (city == null) {
            if (other.city != null) {
                return false;
            }
        } else if (!city.equals(other.city)) {
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
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (studentNo == null) {
            if (other.studentNo != null) {
                return false;
            }
        } else if (!studentNo.equals(other.studentNo)) {
            return false;
        }
        return true;
    }

}
