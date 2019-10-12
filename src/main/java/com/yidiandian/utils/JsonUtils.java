package com.yidiandian.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/9 21:00
 * @Email: 15290810931@163.com
 */
public class JsonUtils {

    public static String toJson(Object object) {
        return !(object instanceof Integer) && !(object instanceof Long) && !(object instanceof Float) && !(object instanceof Double) && !(object instanceof Boolean) && !(object instanceof String) ? JSONObject.toJSONString(object) : String.valueOf(object);
    }
}
