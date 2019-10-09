package com.yidiandian.interceptor;

import com.yidiandian.constant.Constants;
import com.yidiandian.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/9 17:03
 * @Email: 15290810931@163.com
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate<String,UserInfo> redisTemplate;

    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handle) throws IOException {

        //UserInfo userInfo  = (UserInfo) request.getSession().getAttribute("user");
        String struuid = null;
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            response.sendRedirect("/toLogin");
            return false;
        }else{
            for (Cookie cookie : cookies){
                if (cookie.getName().equalsIgnoreCase(Constants.COOKIE_KEY)){
                    struuid = cookie.getValue();
                }
            }
            if (StringUtils.isBlank(struuid)){
                log.info("cookie 为空，验证不通过");
                response.sendRedirect("/toLogin");
                return false;
            }
        }

        BoundHashOperations<String,Object,Object> boundHashOps = redisTemplate.boundHashOps(Constants.REDIS_USER_KEY);
        UserInfo user = (UserInfo) boundHashOps.get(struuid);
        if (user == null){
            log.info("redis未获取到 token");
            response.sendRedirect("/toLogin");
            return false;
        }else{
            log.info("redis 已获取token");
            return true;
        }
    }
}
