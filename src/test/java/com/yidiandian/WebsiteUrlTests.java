package com.yidiandian;

import com.alibaba.fastjson.JSON;
import com.yidiandian.constant.Constants;
import com.yidiandian.entity.WebsiteUrl;
import com.yidiandian.service.WebsiteUrlService;
import com.yidiandian.view.WebsiteUrlView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        WebsiteUrl websiteUrl = websiteUrlService.saveWebsiteUrl(view);
        log.info("保存返回的结果：{}", JSON.toJSON(websiteUrl));

        WebsiteUrlView view1 = new WebsiteUrlView();
        view1.setPlateId(1);
        view1.setPlate("我的主页");
        view1.setParentId(1);
        view1.setUrlTitle("我的提问");
        view1.setUrl("/my-questions");
        view1.setSortId(1);
        view1.setCreator(Constants.ADMIN);
        view1.setModifier(Constants.ADMIN);
        WebsiteUrl websiteUrl1 = websiteUrlService.saveWebsiteUrl(view1);
        log.info("保存返回的结果：{}", JSON.toJSON(websiteUrl1));

        WebsiteUrlView view2 = new WebsiteUrlView();
        view2.setPlateId(1);
        view2.setPlate("我的主页");
        view2.setParentId(1);
        view2.setUrlTitle("我的分享");
        view2.setUrl("/my-shared");
        view2.setSortId(1);
        view2.setCreator(Constants.ADMIN);
        view2.setModifier(Constants.ADMIN);
        WebsiteUrl websiteUrl2 = websiteUrlService.saveWebsiteUrl(view2);
        log.info("保存返回的结果：{}", JSON.toJSON(websiteUrl2));
    }

    @Test
    public void findWebsiteUrl(){
        WebsiteUrlView view = new WebsiteUrlView();
        view.setUrlTitle("我的提问");
        List<WebsiteUrlView> websiteUrl = websiteUrlService.getWebsiteUrl(view);
        log.info("查询返回的结果：{}",websiteUrl);
    }
}
