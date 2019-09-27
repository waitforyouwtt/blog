package com.yidiandian;


import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import com.yidiandian.utils.DateUtils;
import com.yidiandian.view.UserInfoView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class UserInfoTests extends BlogApplicationTests{

	@Autowired
	UserInfoService userInfoService;

	@Test
	public void addUserInfoTest() {
		UserInfoView view = new UserInfoView();
		view.setUserName("凤凰小哥哥2");
		view.setNickName("凤凰小哥哥2");
		view.setPassword("wtt19940512577");
		view.setAge(18);
		view.setGender(1);
		view.setEmail("17621007255@163.com");
		String birthday = "1993-08-23 00:00:00";
		view.setBirthday(DateUtils.strToDateLong(birthday));
		view.setAddress("河南商丘");
		UserInfo result = userInfoService.addUserInfo(view);
		log.info("保存的结果：{}",result);
	}

	@Test
	public void findUserTest(){
		UserInfoView view = new UserInfoView();
		view.setNickName("凤凰小哥哥2");
		view.setPassword("wtt19940512577");
		UserInfo userInfo = userInfoService.findUserInfo(view);
		log.info("查询得到的用户信息：{}",userInfo);
	}

}
