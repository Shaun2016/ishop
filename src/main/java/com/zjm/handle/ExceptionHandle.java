package com.zjm.handle;

import com.zjm.enums.ResultEnum;
import com.zjm.exception.OrderException;
import com.zjm.exception.UserException;
import com.zjm.model.Result;
import com.zjm.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZJM on 2017/4/9.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        if(e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultUtil.error(ResultEnum.getEnumByCode(userException.getCode()));
        } else if(e instanceof OrderException) {
            return ResultUtil.error(ResultEnum.getEnumByCode(((OrderException) e).getCode()));
        }
        logger.error("【系统异常】{}",e);
        return ResultUtil.error(ResultEnum.getEnumByCode(-1));
    }
}
