package com.yidiandian.controller;

import com.yidiandian.service.WebsiteUrlService;
import com.yidiandian.view.WebsiteUrlView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/14 19:55
 * @Email: 15290810931@163.com
 */
@Controller
@Slf4j
public class WebsiteUrlController {

    @Autowired
    WebsiteUrlService websiteUrlService;

    //我的主页
    @PostMapping("/my-homepage")
    @ResponseBody
    public List<WebsiteUrlView> myHomepage(WebsiteUrlView view){
        view.setPlateId(1);
        List<WebsiteUrlView> findByParams = websiteUrlService.getWebsiteUrl(view);
        return findByParams;
    }

    //首页top left url
    @PostMapping("/homePageTopUrlLeft")
    @ResponseBody
    public List<WebsiteUrlView> homePageTopUrlLeft(WebsiteUrlView view){
        view.setPlateId(2);
        List<WebsiteUrlView> findByParams = websiteUrlService.getWebsiteUrl(view);
        return findByParams;
    }

    //首页top left right
    @PostMapping("/homePageTopUrlRight")
    @ResponseBody
    public List<WebsiteUrlView> homePageTopUrlRight(WebsiteUrlView view){
        view.setPlateId(3);
        List<WebsiteUrlView> findByParams = websiteUrlService.getWebsiteUrl(view);
        return findByParams;
    }
}
