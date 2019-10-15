package com.yidiandian.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/15 10:19
 * @Email: 15290810931@163.com
 */
public enum  SortDescEnum {

    ASC(1,"ASC"),
    DESC(2,"DESC");

    private Integer code;

    private String msg;

    SortDescEnum(Integer code, String msg) {
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
