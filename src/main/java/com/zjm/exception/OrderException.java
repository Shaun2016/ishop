package com.zjm.exception;

import com.zjm.enums.ResultEnum;

/**
 * Created by ZJM on 2017/5/15.
 */
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(ResultEnum resultEnum) {
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
