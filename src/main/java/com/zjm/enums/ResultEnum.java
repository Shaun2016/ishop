package com.zjm.enums;

/**
 * Created by ZJM on 2017/4/9.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"success"),
    NICKNAME_EXIST(100,"昵称已被使用"),
    USER_PASSWORD_ERROR(101,"用户名或密码错误"),
    PASSWORD_ERROR(102,"密码错误"),
    PHONE_EXIST(103,"手机号码已被注册"),
    COUNT_NOT_ENOUGH(104,"账户余额不足"),
    GOOD_NOT_ENOUGHT(105,"商品库存不足"),
    PAY_PASSWORD_ERROR(106,"支付密码错误"),
    DEAL_OERTIME(107,"交易超时")
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ResultEnum getEnumByCode(Integer code) {
        switch (code) {
            case -1:
                return UNKNOW_ERROR;
            case 0:
                return SUCCESS;
            case 100:
                return NICKNAME_EXIST;
            case 101:
                return USER_PASSWORD_ERROR;
            case 102:
                return PASSWORD_ERROR;
            case 103:
                return PHONE_EXIST;
            case 104:
                return COUNT_NOT_ENOUGH;
            case 105:
                return GOOD_NOT_ENOUGHT;
            case 106:
                return PAY_PASSWORD_ERROR;
            case 107:
                return DEAL_OERTIME;
             default:
                 return null;
        }
    }

}
