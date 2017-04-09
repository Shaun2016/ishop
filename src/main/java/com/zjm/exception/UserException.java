package com.zjm.exception;

import com.zjm.enums.ResultEnum;

/**
 * Created by ZJM on 2017/4/9.
 */
public class UserException extends RuntimeException{
    private Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
