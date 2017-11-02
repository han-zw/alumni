/**
 * harvey stuidio.
 * Copyright (c) 2000-2016 All Rights Reserved.
 */
package com.harvey.studio.alumni.common.exception;

/**
 * alumini基础runtime exception 类.
 * @title AlumniRuntimeException
 * @description 其他runtime异常均需要继承此类. 
 * @author zw.han
 * @date 2016年12月31日
 * @version 1.0
 */
public class AlumniRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 855162794393086500L;

    public AlumniRuntimeException() {
    }

    public AlumniRuntimeException(String errMsg) {
        super(errMsg);
    }

    public AlumniRuntimeException(Throwable cause) {
        super(cause);
    }
}
