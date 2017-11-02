/**
 * harvey studio.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.harvey.studio.alumni.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 页面跳转传送门.
 * @title TransferController
 * @description 系统各个页面的跳转. 
 * @author zw.han
 * @date 2016年12月31日
 * @version 1.0
 */
@Controller
public class TransferController {
    /**
     * 跳转至指定的页面.
     * @param to 目标页面
     * @return 跳转的目标url
     */
    @RequestMapping(value = "/transfer", method = { RequestMethod.GET })
    public String transfer(@RequestParam("to") String to) {
        return to;
    }

    /**
     * 跳转至主页面
     * @return 主页面url
     */
    @RequestMapping(value = "/index", method = { RequestMethod.GET })
    public String index() {
        return "mainpage/mainpage";
    }

}
