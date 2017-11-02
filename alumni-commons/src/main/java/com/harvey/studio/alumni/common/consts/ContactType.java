/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.common.consts;

/**
 * 联系方式枚举.
 * @title ContactType
 * @description 联系方式枚举.1:手机号,2:qq号,3:微信,4:邮箱 
 * @author zw.han
 * @date 2017年1月1日
 * @version 1.0
 */
public enum ContactType {
    PHONE(1), QQ(2), WEIXIN(3), EMAIL(4);
    private final int val;

    private ContactType(int val) {
        this.val = val;
    }

    /**
     * @return the val
     */
    public int getVal() {
        return val;
    }
}
