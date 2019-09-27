package com.yidiandian.service;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.view.UserInfoView;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/24 22:34
 * @Email: 15290810931@163.com
 */
public interface UserInfoService {

    /**
     * 添加用户
     * @return
     */
    UserInfo addUserInfo(UserInfoView userInfoView);

    /**
     * 查询用户信息
     * @return
     */
    UserInfo findUserInfo(UserInfoView userInfoView);
}
