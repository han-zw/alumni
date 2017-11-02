/**
 * harvey studio.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.harvey.studio.alumni.web.utils;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.harvey.studio.alumni.common.utils.CommonConfigUtils;

/**
 * @title WebUtils
 * @description TODO 
 * @author zw.han
 * @date 2016年12月31日
 * @version 1.0
 */
public class WebUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebUtils.class);

    private static Configuration CONFIG = CommonConfigUtils.getConfig("dmeta-server.properties");

    private WebUtils() {
    }

    /**
     * 直接输出字符串到response
     * @param json 字符串
     */
    public static void printToJson(String json, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/json");
            response.setDateHeader("Expires", 0);
            PrintWriter out = response.getWriter();
            out.print(json);
            LOGGER.debug(json);
            out.flush();
            out.close();
        } catch (Exception e) {
            LOGGER.error("Error:" + e.getMessage(), e);
        }
    }

    /**
     * @param request http请求
     * @param name Cookie里面的key
     * @return 得到 Cookie 里面的name对应的value
     */
    public static String getValueFromCookie(HttpServletRequest request, String name) {
        String val = null;
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if (c.getName().equals(name)) {
                    val = c.getValue();
                    break;
                }
            }
        }

        if (StringUtils.isBlank(val)) {
            // 尝试通过header获取
            String cookieValue = request.getHeader("cookie");
            if (StringUtils.isBlank(cookieValue)) {
                return val;
            }

            String cookies[] = cookieValue.split("; ");
            for (String cookie : cookies) {
                String cookieSplit[] = cookie.split("=");
                if (cookieSplit.length == 2) {
                    String cookieName = cookieSplit[0];
                    if (cookieName.equals(name)) {
                        val = cookieSplit[1];
                        break;
                    }
                }
            }
        }

        return val;
    }

    /**
     * 新增cookie到response中.
     * @param name name
     * @param value value
     * @param response 添加cookie后带回
     */
    public static void addCookie(String name, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(CONFIG.getString("dmeta.server.cookie.domain"));
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
