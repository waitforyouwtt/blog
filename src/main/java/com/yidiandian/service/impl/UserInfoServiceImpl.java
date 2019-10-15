package com.yidiandian.service.impl;

import com.yidiandian.constant.Constants;
import com.yidiandian.dao.UserInfoDao;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.enums.BusinessEnum;
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
        userInfo.setPassword(AesUtil.encrypt(Constants.SECRET_KEY,userInfoView.getPassword()));
        userInfo.setIsDelete(1);
        UserInfo result = null;
        try{
            result = userInfoMapper.save(userInfo);
        }catch (Exception e){
            log.info("添加用户信息异常：{}",e.getMessage());
            throw new MyException(BusinessEnum.ADD_ERROR.getCode(),BusinessEnum.ADD_ERROR.getMsg());
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
        UserInfo userInfo = null;
        if (StringUtils.isBlank(userInfoView.getUserName()) && StringUtils.isBlank(userInfoView.getNickName()) &&
        StringUtils.isBlank(userInfoView.getMobile()) && StringUtils.isBlank(userInfoView.getEmail())){
            throw new MyException(BusinessEnum.PARAMS_NOT_POINT.getCode(),BusinessEnum.PARAMS_NOT_POINT.getMsg());
        }
        if (StringUtils.isNoneBlank(userInfoView.getUserName()) && StringUtils.isNoneBlank(userInfoView.getPassword())){
            userInfo = findByUserName(userInfoView.getUserName(),userInfoView.getPassword());
        }
        if (StringUtils.isNoneBlank(userInfoView.getNickName()) && StringUtils.isNoneBlank(userInfoView.getPassword())){
            userInfo = findByNickName(userInfoView.getNickName(),userInfoView.getPassword());
        }
        if (StringUtils.isNoneBlank(userInfoView.getMobile()) && StringUtils.isNoneBlank(userInfoView.getPassword())){
            userInfo = findByMobile(userInfoView.getMobile(),userInfoView.getPassword());
        }
        if (StringUtils.isNoneBlank(userInfoView.getEmail()) && StringUtils.isNoneBlank(userInfoView.getPassword())){
            userInfo = findByMobile(userInfoView.getEmail(),userInfoView.getPassword());
        }
        return userInfo;
    }

    //根据用户名字和密码查询用户
    private UserInfo findByUserName(String userName,String password){
        Optional<UserInfo> optional = userInfoMapper.findByUserNameAndPassword(userName,AesUtil.encrypt(Constants.SECRET_KEY,password));
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    //根据用户名字和密码查询用户
    private UserInfo findByNickName(String nickName,String password){
        Optional<UserInfo> optional = userInfoMapper.findByNickNameAndPassword(nickName,AesUtil.encrypt(Constants.SECRET_KEY,password));
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    //根据用户手机号和密码查询用户
    private UserInfo findByMobile(String mobile,String password){
        Optional<UserInfo> optional = userInfoMapper.findByMobileAndPassword(mobile,AesUtil.encrypt(Constants.SECRET_KEY,password));
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    //根据用户邮箱和密码查询用户
    private UserInfo findByEmail(String email,String password){
        Optional<UserInfo> optional = userInfoMapper.findByEmailAndPassword(email,AesUtil.encrypt(Constants.SECRET_KEY,password));
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
            throw new MyException(BusinessEnum.PARAMS_NOT_POINT.getCode(),BusinessEnum.PARAMS_NOT_POINT.getMsg());
        }
        Optional<UserInfo> optional = userInfoMapper.findById(userInfoView.getId());
        if (!optional.isPresent()){
            throw new MyException(BusinessEnum.RECORD_IS_NOT_EXIST.getCode(),BusinessEnum.RECORD_IS_NOT_EXIST.getMsg());
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
        Optional<UserInfo> optional = userInfoMapper.findByNickNameAndPassword(userInfoView.getNickName(),AesUtil.encrypt(Constants.SECRET_KEY,userInfoView.getOldPassword()));
        if (!optional.isPresent()){
            throw new MyException(BusinessEnum.LOGIN_ERROR.getCode(),BusinessEnum.LOGIN_ERROR.getMsg());
        }
        UserInfo queryUserInfo = optional.get();
        String password = AesUtil.encrypt(Constants.SECRET_KEY,userInfoView.getPassword());
        String oldPassword = AesUtil.encrypt(Constants.SECRET_KEY,queryUserInfo.getPassword());
        if (password.equals(oldPassword)){
            throw new MyException(BusinessEnum.PASSWORD_EQUAL.getCode(),BusinessEnum.PASSWORD_EQUAL.getMsg());
        }
        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(UserInfoView.class, UserInfo.class, false);
        beanCopier.copy(userInfoView,userInfo,null);
        userInfo.setPassword(AesUtil.encrypt(Constants.SECRET_KEY,userInfoView.getPassword()));
        return userInfoDao.changePassword(userInfo);
    }
}
