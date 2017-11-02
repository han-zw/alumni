/**
 * harvey studio.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.harvey.studio.alumni.common.consts;

/**
 * 全局常量定义类.
 * @title Consts
 * @description 全局常量定义类. 
 * @author zw.han
 * @date 2016年12月31日
 * @version 1.0
 */
public final class Consts {
    public static final String SLASH = "/";
    public static final String UTF8 = "utf-8";
    public static final String EMPTY = "";
    public static final String SEMICOLON = ";";
    public static final String SPACE = " ";

    // 正确返回状态
    public static final int RESULT_CODE_SUCCESS = 0;
    // 默认内部错误编码
    public static final int RESULT_CODE_INTERNALERR = -1;

    // 安全认证相关常量
    public static final String COOKIE_USER_KEY = "alumni_user_key";
    public static final String COOKIE_USER_TOKEN = "alumni_user_token";
    public static final String COOKIE_USER_GROUP = "alumni_user_group";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_BEARER = "bearer";
}
