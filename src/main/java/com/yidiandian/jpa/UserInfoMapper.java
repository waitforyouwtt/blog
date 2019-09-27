package com.yidiandian.jpa;

import com.yidiandian.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/24 23:19
 * @Email: 15290810931@163.com
 */
public interface UserInfoMapper extends JpaRepository<UserInfo,Integer>{

    Optional<UserInfo> findByNickNameAndPassword(String nickName, String password);

}
