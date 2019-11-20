package com.yidiandian;


import com.yidiandian.constant.Constants;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.enums.GenderEnum;
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

/*	@Autowired
	UserInfoService userInfoService;

	@Test
	public void addUserInfoTest() {
		UserInfoView view = new UserInfoView();
		view.setUserName("凤凰小哥哥");
		view.setNickName("凤凰小哥哥");
		view.setHeadImage("http://www.baidu.com");
		view.setPassword("577521");
		view.setFamilyPhone("17621007255");
		view.setMobile("17621007255");
		view.setAge(18);
		view.setGender(GenderEnum.MAN.getCode());
		view.setEmail("17621007255@163.com");
		String birthday = "1993-08-23 00:00:00";
		view.setBirthday(DateUtils.strToDateLong(birthday));
		view.setTemporaryResidence("上海市松江区明丰公寓53号");
		view.setPermanentResidence("河南省商丘市民权县北关镇");
		view.setWorkResidence("上海市静安区嘉里中心T1座");
		view.setWeChat("perttyboy1140867582");
		view.setQq("1140867582");
		view.setCreator(Constants.ADMIN);
		view.setModifier(Constants.ADMIN);
		UserInfo result = userInfoService.addUserInfo(view);
		log.info("保存的结果：{}",result);

		UserInfoView view1 = new UserInfoView();
		view1.setUserName("张洁");
		view1.setNickName("小胖子凹凸曼");
		view1.setHeadImage("http://www.baidu.com");
		view1.setFamilyPhone("18101820186");
		view1.setMobile("18101820186");
		view1.setPassword("577521");
		view1.setAge(32);
		view1.setGender(GenderEnum.WOMAN.getCode());
		view1.setEmail("17621007255@163.com");
		view1.setBirthday(DateUtils.strToDateLong(birthday));
		view1.setTemporaryResidence("上海市嘉定区");
		view1.setPermanentResidence("江苏省淮安市");
		view1.setWorkResidence("未知");
		view1.setWeChat("zJ368368000");
		view1.setQq("1140867582");
		view1.setCreator(Constants.ADMIN);
		view1.setModifier(Constants.ADMIN);
		UserInfo result1 = userInfoService.addUserInfo(view1);
		log.info("保存的结果：{}",result1);
	}

	@Test
	public void findUserTest(){
		UserInfoView view = new UserInfoView();
		view.setNickName("凤凰小哥哥");
		view.setPassword("wtt19940512577");
		UserInfo userInfo = userInfoService.findUserInfo(view);
		log.info("查询得到的用户信息：{}",userInfo);
	}*/

/*	@Test
	public void updateUserTest(){
      UserInfoView view = new UserInfoView();
      view.setId(1);
      view.setPassword("577521");
      view.setNickName("小胖子凹凸曼");
      view.setOldPassword("577521");
      int update = userInfoService.changePassword(view);
      log.info("修改的结果：{}",update);
	}*/

}
