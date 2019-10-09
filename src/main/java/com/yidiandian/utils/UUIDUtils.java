package com.yidiandian.utils;

import java.util.UUID;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/9 16:40
 * @Email: 15290810931@163.com
 */
public class UUIDUtils {

    //生成uuid
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
