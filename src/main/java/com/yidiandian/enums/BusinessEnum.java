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
    LOGIN_SUCCESS(1002,"登录成功")


    ;

    //----------2.......信息错误---------

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
