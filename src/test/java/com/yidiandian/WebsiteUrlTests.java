package com.yidiandian;

import com.alibaba.fastjson.JSON;
import com.yidiandian.constant.Constants;
import com.yidiandian.entity.WebsiteUrl;
import com.yidiandian.service.WebsiteUrlService;
import com.yidiandian.utils.DateUtils;
import com.yidiandian.view.WebsiteUrlView;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/12 17:24
 * @Email: 15290810931@163.com
 */
@Slf4j
@Component
public class WebsiteUrlTests extends BlogApplicationTests {

    @Autowired
    WebsiteUrlService websiteUrlService;

    @Test
    public void save(){
        WebsiteUrlView view = new WebsiteUrlView();
        view.setPlateId(1);
        view.setPlate("我的主页");
        view.setParentId(1);
        view.setUrlTitle("我的回答");
        view.setUrl("/my-answer");
        view.setSortId(1);
        view.setCreator(Constants.ADMIN);
        view.setModifier(Constants.ADMIN);

        WebsiteUrlView view1 = new WebsiteUrlView();
        view1.setPlateId(1);
        view1.setPlate("我的主页");
        view1.setParentId(1);
        view1.setUrlTitle("我的提问");
        view1.setUrl("/my-questions");
        view1.setSortId(1);
        view1.setCreator(Constants.ADMIN);
        view1.setModifier(Constants.ADMIN);

        WebsiteUrlView view2 = new WebsiteUrlView();
        view2.setPlateId(1);
        view2.setPlate("我的主页");
        view2.setParentId(1);
        view2.setUrlTitle("我的分享");
        view2.setUrl("/my-shared");
        view2.setSortId(1);
        view2.setCreator(Constants.ADMIN);
        view2.setModifier(Constants.ADMIN);

        WebsiteUrlView view3 = new WebsiteUrlView();
        view3.setPlateId(1);
        view3.setPlate("我的主页");
        view3.setParentId(1);
        view3.setUrlTitle("个人动态");
        view3.setUrl("/personal-dynamics");
        view3.setSortId(1);
        view3.setCreator(Constants.ADMIN);
        view3.setModifier(Constants.ADMIN);

        WebsiteUrlView view4 = new WebsiteUrlView();
        view4.setPlateId(1);
        view4.setPlate("我的主页");
        view4.setParentId(1);
        view4.setUrlTitle("我的关注");
        view4.setUrl("/my-follow");
        view4.setSortId(1);
        view4.setCreator(Constants.ADMIN);
        view4.setModifier(Constants.ADMIN);


        WebsiteUrlView view5 = new WebsiteUrlView();
        view5.setPlateId(1);
        view5.setPlate("我的主页");
        view5.setParentId(1);
        view5.setUrlTitle("我的收藏");
        view5.setUrl("/my-collection");
        view5.setSortId(1);
        view5.setCreator(Constants.ADMIN);
        view5.setModifier(Constants.ADMIN);

        WebsiteUrlView view6 = new WebsiteUrlView();
        view6.setPlateId(1);
        view6.setPlate("我的主页");
        view6.setParentId(1);
        view6.setUrlTitle("浏览记录");
        view6.setUrl("/my-browse-record");
        view6.setSortId(1);
        view6.setCreator(Constants.ADMIN);
        view6.setModifier(Constants.ADMIN);

        WebsiteUrlView view7 = new WebsiteUrlView();
        view7.setPlateId(1);
        view7.setPlate("我的主页");
        view7.setParentId(1);
        view7.setUrlTitle("账户设置");
        view7.setUrl("/account-settings");
        view7.setSortId(1);
        view7.setCreator(Constants.ADMIN);
        view7.setModifier(Constants.ADMIN);

        List params = Lists.newArrayList();
        params.add(view);params.add(view1);
        params.add(view2);params.add(view3);
        params.add(view4);params.add(view5);
        params.add(view6);params.add(view7);
       int result = websiteUrlService.batchInsertWebsiteUrl(params);
        log.info("保存返回的结果：{}", JSON.toJSON(result));
    }

    @Test
    public void findWebsiteUrl(){
        WebsiteUrlView view = new WebsiteUrlView();
        view.setSortDesc("ASC");
        List<WebsiteUrlView> websiteUrl = websiteUrlService.getWebsiteUrl(view);
        log.info("查询返回的结果：{}",JSON.toJSON(websiteUrl));
    }

    @Test
    public void diyDate(){
        String s = DateUtils.diyDate(new Date(), 5);
        log.info("s:{}",s);

    }
}
