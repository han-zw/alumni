/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.business.service;

import java.util.List;

import com.harvey.studio.alumni.business.domain.PersonPo;

/**
 * person服务接口.
 * @title PersonService
 * @description 定义person的操作方法。 
 * @author zw.han
 * @date 2017年2月25日
 * @version 1.0
 */
public interface PersonService {
    /**
     * 查询指定班级中的人员列表
     * @param clazzId 班级id，不能为null
     * @return 人员列表，可能为空集合.
     */
    List<PersonPo> queryByClazz(Long clazzId);
}
