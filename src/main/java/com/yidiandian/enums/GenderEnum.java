package com.yidiandian.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/27 16:03
 * @Email: 15290810931@163.com
 */
public enum GenderEnum {

    MAN(1,"男"),
    WOMAN(2,"女"),
    SECRET(3,"保密");

    private Integer code;
    private String msg;

    GenderEnum(Integer code, String msg) {
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
