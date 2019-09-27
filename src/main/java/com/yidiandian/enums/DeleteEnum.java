package com.yidiandian.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/27 16:03
 * @Email: 15290810931@163.com
 */
public enum DeleteEnum {

    NORMAL(1,"正常"),
    DELETE(2,"删除");

    private Integer code;
    private String msg;

    DeleteEnum(Integer code, String msg) {
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
