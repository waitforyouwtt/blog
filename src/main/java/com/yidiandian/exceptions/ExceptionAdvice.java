package com.yidiandian.exceptions;

import com.yidiandian.entity.Result;
import com.yidiandian.enums.SystemCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: luoxian
 * @Date: 2019/5/22 18:12
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultException(HttpServletRequest request, Exception e){
        e.printStackTrace();
        Result result = new Result();
        result.setFlag(false);
        result.setCode(SystemCodeEnum.EXCEPTION.getCode());
        result.setMessage(SystemCodeEnum.EXCEPTION.getMessage());
        result.setData(null);
        return result;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Result myException(HttpServletRequest request, MyException e){
        e.printStackTrace();
        Integer code = e.getCode();
        String msg = e.getMessage();
        if (e.getCode() == null){
            code = SystemCodeEnum.EXCEPTION.getCode();
        }
        if (e.getMessage() == null){
            msg = SystemCodeEnum.EXCEPTION.getMessage();
        }
        Result result = new Result();
        result.setFlag(false);
        result.setCode(code);
        result.setMessage(msg);
        result.setData(null);
        return result;
    }
}
