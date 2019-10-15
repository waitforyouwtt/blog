package com.yidiandian.utils;

import com.yidiandian.constant.Constants;
import com.yidiandian.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/15 14:27
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class UserInfoSessionUtils {

    @Autowired
    RedisTemplate redisTemplate;

    public UserInfo findUserInfo(HttpServletRequest request){
        String struuid = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equalsIgnoreCase(Constants.COOKIE_KEY)){
                struuid = cookie.getValue();
            }
        }
        BoundHashOperations<String,Object,Object> boundHashOps = redisTemplate.boundHashOps(Constants.REDIS_USER_KEY);
        log.info("获取的redis 参数：{}",boundHashOps);
        return  (UserInfo) boundHashOps.get(struuid);
    }
}
