/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.harvey.studio.alumni.business.domain.PersonPo;

/**
 * person表数据库操作接口.
 * @title PersonPoDao
 * @description 数据库操作. 
 * @author zw.han
 * @date 2017年1月1日
 * @version 1.0
 */
@Repository
public interface PersonPoDao {
    /**
     * 按照班级查询其下的所有人员列表
     * @param clazzId 班级id
     * @return 人员列表
     */
    List<PersonPo> queryByClazz(Long clazzId);
}
