package com.yidiandian.dao;

import com.yidiandian.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/24 22:35
 * @Email: 15290810931@163.com
 */
@Mapper
public interface UserInfoDao {

    UserInfo findUser();
}
