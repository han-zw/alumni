/**
 * harvey studio.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.harvey.studio.alumni.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.harvey.studio.alumni.common.model.ResultInfo;
import com.harvey.studio.alumni.common.utils.JsonUtils;
import com.harvey.studio.alumni.web.utils.WebUtils;

/**
 * 全局异常处理器
 * @title AlumniExceptionResolver
 * @description 全局异常处理器 
 * @author zw.han
 * @date 2016年12月31日
 * @version 1.0
 */
public class AlumniExceptionResolver implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(AlumniExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) {
        logger.error("Exception: ", ex); // 把漏网的异常信息记入日志
        String message = ex.getMessage();

        ResultInfo result = ResultInfo.errorMessage(message);
        WebUtils.printToJson(JsonUtils.toJson(result), response);
        return null;
    }
}
