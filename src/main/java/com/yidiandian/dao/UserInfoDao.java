package com.yidiandian.dao;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.view.UserInfoView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/24 22:35
 * @Email: 15290810931@163.com
 */
@Mapper
public interface UserInfoDao {
    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     *修改密码
     */
    int changePassword(UserInfo userInfo);
}
