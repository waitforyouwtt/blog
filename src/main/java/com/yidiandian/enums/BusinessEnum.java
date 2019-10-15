package com.yidiandian.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 10:36
 * @Email: 15290810931@163.com
 * 业务信息枚举
 */
public enum BusinessEnum {

    //----------1.......用户信息错误-----------
    LOGIN_ERROR(1001,"用户名或密码错误,请重新输入"),
    LOGIN_SUCCESS(1002,"登录成功"),
    PASSWORD_EQUAL(1003,"输入的新密码不能等于旧密码"),


    //----------2.......信息错误---------
    PARAMS_NOT_POINT(2001,"参数为空"),
    PARAMS_ERROR(2002,"参数错误"),
    REMOTE_ERROR(2003,"远程调用错误"),
    REP_ERROR(2004,"重复操作"),
    RECORD_IS_NOT_EXIST(2005,"记录不存在"),
    ADD_ERROR(2006,"添加异常"),
    DELETE_ERROR(2007,"删除异常"),
    UPDATE_ERROR(2008,"修改异常"),
    QUERY_ERROR(2009,"查询异常"),



    ;
    private Integer code;
    private String msg;

    BusinessEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
