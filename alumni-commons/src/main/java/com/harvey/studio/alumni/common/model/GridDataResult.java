/**
 * harvey studio.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.harvey.studio.alumni.common.model;

import java.util.List;

import com.google.common.collect.Lists;
import com.harvey.studio.alumni.common.consts.Consts;

/**
 * Grid的数据模型
 * @title GridDataResult
 * @description Grid的数据模型 
 * @author hanzhiwei
 * @date 2017年02月25日
 * @version 1.0
 */
public class GridDataResult<E> {
    private int status = Consts.RESULT_CODE_SUCCESS;
    private String statusInfo = "SUCCESS"; // 操作结果描述信息

    private List<E> rows = Lists.newArrayList();

    private long total = 0;

    public static <E> GridDataResult<E> errorMessage(String errorMessage) {
        return new GridDataResult<E>(Consts.RESULT_CODE_INTERNALERR, errorMessage);
    }

    public static <E> GridDataResult<E> successDatas(List<E> rows, long total) {
        return new GridDataResult<E>(Consts.RESULT_CODE_SUCCESS, rows, total);
    }

    public static <E> GridDataResult<E> success() {
        return new GridDataResult<E>();
    }

    public GridDataResult() {
    }

    /**
     * <pre>
     * @param status
    
     * @param rows
     * @param total
     * </pre>
     */
    public GridDataResult(int status, List<E> rows, long total) {
        super();
        this.status = status;
        this.rows = rows;
        this.total = total;
    }

    /**
     * <pre>
     * @param status
     * @param statusInfo
     * </pre>
     */
    public GridDataResult(int status, String statusInfo) {
        super();
        this.status = status;
        this.statusInfo = statusInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("rawtypes")
        GridDataResult other = (GridDataResult) obj;
        if (rows == null) {
            if (other.rows != null) {
                return false;
            }
        } else if (!rows.equals(other.rows)) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (statusInfo == null) {
            if (other.statusInfo != null) {
                return false;
            }
        } else if (!statusInfo.equals(other.statusInfo)) {
            return false;
        }
        if (total != other.total) {
            return false;
        }
        return true;
    }

    public List<E> getRows() {
        return rows;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public long getTotal() {
        return total;
    }
}
