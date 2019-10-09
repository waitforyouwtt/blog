package com.yidiandian.controller;

import com.alibaba.fastjson.JSON;
import com.yidiandian.constant.Constants;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.enums.BusinessEnum;
import com.yidiandian.service.UserInfoService;
import com.yidiandian.utils.UUIDUtils;
import com.yidiandian.view.UserInfoView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/9 15:50
 * @Email: 15290810931@163.com
 */
@Slf4j
@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/login")
    @ResponseBody
    public boolean login(UserInfoView userInfoView, HttpServletRequest request, HttpServletResponse response) {

        log.info("用户登录请求参数：{}", JSON.toJSON(userInfoView));
        HashMap<String, String> result = new HashMap<>(16);
        UserInfo userInfo = userInfoService.findUserInfo(userInfoView);
        log.info("用户登录请求返回结果：{}", JSON.toJSON(userInfo));

        if (userInfo == null) {
            result.put("code", BusinessEnum.LOGIN_ERROR.getCode().toString());
            result.put("message", BusinessEnum.LOGIN_ERROR.getMsg());
            return false;
        } else {
            //request.getSession().setAttribute("user", userInfo);
            String uuid = UUIDUtils.getUUID();
            Cookie cookie = new Cookie(Constants.COOKIE_KEY, uuid);
            response.addCookie(cookie);//返回客户端
            BoundHashOperations<String, Object, Object> boundHashOps = redisTemplate.boundHashOps(Constants.REDIS_USER_KEY);
            boundHashOps.put(uuid, userInfo);
            result.put("code", BusinessEnum.LOGIN_SUCCESS.getCode().toString());
            result.put("message", BusinessEnum.LOGIN_SUCCESS.getMsg());
            return true;
        }
    }
}
