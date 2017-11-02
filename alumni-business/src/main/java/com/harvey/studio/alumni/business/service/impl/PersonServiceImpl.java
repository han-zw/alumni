/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.harvey.studio.alumni.business.dao.PersonPoDao;
import com.harvey.studio.alumni.business.domain.PersonPo;
import com.harvey.studio.alumni.business.service.PersonService;

/**
 * personService实现类.
 * @title PersonServiceImpl
 * @description personService实现类. 
 * @author zw.han
 * @date 2017年2月25日
 * @version 1.0
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonPoDao personDao;

    /* (non-Javadoc)
     * @see com.harvey.studio.alumni.business.service.PersonService#queryByClazz(java.lang.Long)
     */
    @Override
    public List<PersonPo> queryByClazz(Long clazzId) {
        Preconditions.checkNotNull(clazzId);

        return personDao.queryByClazz(clazzId);
    }

}
