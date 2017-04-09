package com.zjm.util;

import com.zjm.enums.ResultEnum;
import com.zjm.model.Result;

/**
 * Created by ZJM on 2017/4/9.
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return  result;
    }

}