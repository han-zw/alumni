/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harvey.studio.alumni.business.domain.PersonPo;
import com.harvey.studio.alumni.business.service.PersonService;
import com.harvey.studio.alumni.common.consts.Consts;
import com.harvey.studio.alumni.common.model.GridDataResult;
import com.harvey.studio.alumni.web.vo.Person;

/**
 * Person模块controller.
 * @title PersonController
 * @description person相关的web交互 
 * @author zw.han
 * @date 2017年1月19日
 * @version 1.0
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * 查询指定班级的人员列表
     * @param clazzId 班级id
     * @return 包含人员列表的应答消息
     * @throws Exception 
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET })
    @ResponseBody
    public GridDataResult<Person> list(@RequestParam("clazzId") Long clazzId) throws Exception {
        if (clazzId == null || clazzId <= 0) {
            return GridDataResult.success();
        }

        List<PersonPo> personPos = personService.queryByClazz(clazzId);
        List<Person> persons = new ArrayList<Person>();
        for (PersonPo po : personPos) {
            persons.add(this.convert2Vo(po));
        }
        return new GridDataResult<Person>(Consts.RESULT_CODE_SUCCESS, persons, persons.size());
    }

    private Person convert2Vo(PersonPo po)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Person person = new Person();
        PropertyUtils.copyProperties(person, po);

        person.setContactInfos(null);
        return person;
    }
}
