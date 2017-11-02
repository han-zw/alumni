/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.web.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;
import com.harvey.studio.alumni.common.consts.Consts;
import com.harvey.studio.alumni.web.utils.WebUtils;

/**
 * 登录检查Filter.
 * @title LoginCheckFilter
 * @description 对web request进行检查，如果当前用户尚未登录则跳转至登录页面。  
 * @author zw.han
 * @date 2017年11月2日
 * @version 1.0
 */
public class LoginCheckFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCheckFilter.class);

    // 白名单
    private static List<String> whiteList = new ArrayList<>();
    // 登录页面url
    private static String LOGIN_URL;

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化URL白名单
        String whiteListStr = getProperty(filterConfig, "whiteList");
        if (StringUtils.isNotBlank(whiteListStr)) {
            whiteList = Splitter.on(';').trimResults().omitEmptyStrings().splitToList(whiteListStr);
        }

        LOGIN_URL = getProperty(filterConfig, "loginUrl");
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            String uri = request.getRequestURI();
            uri = StringUtils.removeStart(uri, request.getContextPath());
            // 判断是否在白名单中
            if (this.inWhiteList(uri)) {
                chain.doFilter(request, response);
                return;
            }

            //判断是否为登录页面
            if ((uri + "?ft=" + request.getParameter("ft")).equals(LOGIN_URL)) {
                chain.doFilter(request, response);
                return;
            }

            // 判断是否已经是合法登录用户
            if (this.hasLogin(request)) {
                chain.doFilter(request, response);
                return;
            }
        } catch (Exception e) {
            LOGGER.error("user login check exception", e);
        }

        // 未登录用户，跳转至登录页面
        LOGGER.info("has not login, redirect to login page:{}", LOGIN_URL);
        response.sendRedirect(request.getContextPath() + LOGIN_URL);
    }

    private boolean hasLogin(HttpServletRequest request) throws Exception {
        String user = WebUtils.getValueFromCookie(request, Consts.COOKIE_USER_KEY);
        if (StringUtils.isBlank(user)) {
            LOGGER.debug("not login, will be redirected.");
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

    private String getProperty(FilterConfig filterConfig, String name) {
        String value = filterConfig.getInitParameter(name);
        if (StringUtils.isNotBlank(value)) {
            return value;
        }
        return filterConfig.getServletContext().getInitParameter(name);
    }

    private boolean inWhiteList(String uri) {
        if (StringUtils.isBlank(uri)) {
            return false;
        }
        for (String wl : whiteList) {
            if (uri.endsWith(wl)) {
                return true;
            }
        }
        return false;
    }

}
