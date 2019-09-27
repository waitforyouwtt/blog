package com.yidiandian.service.impl;

import com.yidiandian.constant.Constant;
import com.yidiandian.dao.UserInfoDao;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.enums.SystemCodeEnum;
import com.yidiandian.exceptions.MyException;
import com.yidiandian.jpa.UserInfoMapper;
import com.yidiandian.service.UserInfoService;
import com.yidiandian.utils.AesUtil;
import com.yidiandian.utils.SnowflakeIdWorker;
import com.yidiandian.view.UserInfoView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    SnowflakeIdWorker idWorker;

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
        userInfo.setUserId(idWorker.nextId()+"");
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        userInfo.setPassword(AesUtil.encrypt(Constant.SECRET_KEY,userInfoView.getPassword()));
        userInfo.setIsDelete(1);
        UserInfo result = null;
        try{
            result = userInfoMapper.save(userInfo);
        }catch (Exception e){
            log.info("添加用户信息异常：{}",e.getMessage());
            throw new MyException(SystemCodeEnum.ADD_USERINFO_EXCEPTION.getCode(),SystemCodeEnum.ADD_USERINFO_EXCEPTION.getMessage());
        }
        return result;
    }

    /**
     * 查询用户信息
     *
     * @param userInfoView
     * @return
     */
    @Override
    public UserInfo findUserInfo(UserInfoView userInfoView) {
        Optional<UserInfo> optional = userInfoMapper.findByNickNameAndPassword(userInfoView.getNickName(),AesUtil.encrypt(Constant.SECRET_KEY,userInfoView.getPassword()));
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    /**
     * 修改用户信息
     *
     * @param userInfoView
     */
    @Override
    public int updateUserInfo(UserInfoView userInfoView) {
        if (StringUtils.isBlank(userInfoView.getUserId())){
            throw new MyException(SystemCodeEnum.PARAMS_NOT_POINT.getCode(),SystemCodeEnum.PARAMS_NOT_POINT.getMessage());
        }
        Optional<UserInfo> optional = userInfoMapper.findById(userInfoView.getId());
        if (!optional.isPresent()){
            throw new MyException(SystemCodeEnum.RECORD_IS_NOT_EXIST.getCode(),SystemCodeEnum.RECORD_IS_NOT_EXIST.getMessage());
        }
        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(UserInfoView.class, UserInfo.class, false);
        beanCopier.copy(userInfoView,userInfo,null);
        return userInfoDao.updateUserInfo(userInfo);
    }

    /**
     * 修改密码
     *
     * @param userInfoView
     */
    @Override
    public int changePassword(UserInfoView userInfoView) {
        Optional<UserInfo> optional = userInfoMapper.findByNickNameAndPassword(userInfoView.getNickName(),AesUtil.encrypt(Constant.SECRET_KEY,userInfoView.getOldPassword()));
        if (!optional.isPresent()){
            throw new MyException(SystemCodeEnum.PASSWORD_ERROR.getCode(),SystemCodeEnum.PASSWORD_ERROR.getMessage());
        }
        UserInfo queryUserInfo = optional.get();
        String password = AesUtil.encrypt(Constant.SECRET_KEY,userInfoView.getPassword());
        String oldPassword = AesUtil.encrypt(Constant.SECRET_KEY,queryUserInfo.getPassword());
        if (password.equals(oldPassword)){
            throw new MyException(SystemCodeEnum.PASSWORD_EQUAL.getCode(),SystemCodeEnum.PASSWORD_EQUAL.getMessage());
        }
        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(UserInfoView.class, UserInfo.class, false);
        beanCopier.copy(userInfoView,userInfo,null);
        userInfo.setPassword(AesUtil.encrypt(Constant.SECRET_KEY,userInfoView.getPassword()));
        return userInfoDao.changePassword(userInfo);
    }
}
