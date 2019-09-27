package com.yidiandian.enums;

/**
 * @Author: luoxian
 * @Date: 2019/5/21 17:21
 */
public enum SystemCodeEnum {

    OK(2000,"成功"),
    ERROR(2001,"失败"),
    LOGIN_ERROR(2002,"用户名或密码错误"),
    ACCESS_ERROR(2003,"权限不足"),
    REMOTE_ERROR(2004,"远程调用错误"),
    REP_ERROR(2005,"重复操作"),
    PARAMS_NOT_POINT(2006,"参数为空"),
    QUERRY_ERROR(2007,"查询错误"),
    EXCEPTION(500000,"系统异常"),
    ADD_USERINFO_EXCEPTION(3000,"用户添加异常"),
    RECORD_IS_NOT_EXIST(3001,"记录不存在"),
    PASSWORD_ERROR(3002,"您输入的旧密码错误，请重新输入"),
    PASSWORD_EQUAL(3003,"输入的新密码不能等于旧密码"),

    ;

    SystemCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String  message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
