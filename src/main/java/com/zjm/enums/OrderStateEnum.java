package com.zjm.enums;

/**
 * Created by ZJM on 2017/5/15.
 */
public enum OrderStateEnum {
    WAIT_PAY(0,"待付款"),
    WAIT_DELIVERY (1,"待发货"),
    WAIT_REVIEW(2,"待收货"),
    WAIT_EVALUATE(3,"待评价"),
    TRADE_FINISH(4,"交易完成")
    ;

    private Integer code;

    private String msg;

    OrderStateEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
