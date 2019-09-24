package com.yidiandian.service.impl;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.jpa.UserInfoMapper;
import com.yidiandian.service.UserInfoService;
import com.yidiandian.view.UserInfoView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/24 22:34
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;
    /**
     * 添加用户
     *
     * @param userInfoView
     * @return
     */
    @Override
    public UserInfo addUserInfo(UserInfoView userInfoView) {
        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(UserInfoView.class, UserInfo.class, false);
        beanCopier.copy(userInfoView,userInfo,null);
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        return userInfoMapper.save(userInfo);
    }
}
