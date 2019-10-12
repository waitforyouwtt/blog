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
		view.setUserName("凤凰小哥哥");
		view.setNickName("凤凰小哥哥");
		view.setPassword("577521");
		view.setAge(18);
		view.setGender(1);
		view.setEmail("17621007255@163.com");
		String birthday = "1993-08-23 00:00:00";
		view.setBirthday(DateUtils.strToDateLong(birthday));
		view.setAddress("河南商丘");
		UserInfo result = userInfoService.addUserInfo(view);
		log.info("保存的结果：{}",result);

		UserInfoView view1 = new UserInfoView();
		view1.setUserName("张洁");
		view1.setNickName("小胖子凹凸曼");
		view1.setPassword("577521");
		view1.setAge(18);
		view1.setGender(1);
		view1.setEmail("17621007255@163.com");
		view1.setBirthday(DateUtils.strToDateLong(birthday));
		view1.setAddress("河南商丘");
		UserInfo result1 = userInfoService.addUserInfo(view1);
		log.info("保存的结果：{}",result);
	}

	@Test
	public void findUserTest(){
		UserInfoView view = new UserInfoView();
		view.setNickName("凤凰小哥哥");
		view.setPassword("wtt19940512577");
		UserInfo userInfo = userInfoService.findUserInfo(view);
		log.info("查询得到的用户信息：{}",userInfo);
	}

	@Test
	public void updateUserTest(){
      UserInfoView view = new UserInfoView();
      view.setId(1);
      view.setPassword("577521");
      view.setNickName("小胖子凹凸曼");
      view.setOldPassword("577521");
      int update = userInfoService.changePassword(view);
      log.info("修改的结果：{}",update);
	}

}
