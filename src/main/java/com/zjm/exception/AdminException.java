package com.zjm.exception;

import com.zjm.enums.ResultEnum;

/**
 * Created by ZJM on 2017/4/13.
 */
public class AdminException extends RuntimeException {
    private int code;

    public AdminException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
