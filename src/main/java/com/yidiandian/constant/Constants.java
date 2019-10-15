package com.yidiandian.constant;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/27 15:02
 * @Email: 15290810931@163.com
 * 常量池
 */
public class Constants {
   //秘钥串
   public static final String  SECRET_KEY = "1A2Bc3d4E5C6F7G8H9IiJKMFDFDFJKF45678HGHJKLGHJK56789321BNM";

   //自定义cookie的key,代替用户登录时Session的管理

   public static final String COOKIE_KEY="loginKey";

   public static final String REDIS_USER_KEY="loginKey";

   public static final String ADMIN = "Admin";

   //过期时间
   public static final Integer expire = 30;
}
