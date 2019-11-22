package com.yidiandian.controller;

import com.yidiandian.service.FriendshipLinkService;
import com.yidiandian.view.FriendshipLinkView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/12 18:17
 * @Email: 15290810931@163.com
 */
@Slf4j
@Controller
public class FriendshipLinkController {

    @Autowired
    FriendshipLinkService friendshipLinkService;

    @PostMapping("/findFriendshipLinkAboutHead")
    @ResponseBody
    public List<FriendshipLinkView> findFriendshipLinkAboutHead(FriendshipLinkView view){
        view.setParentId(0);
        List<FriendshipLinkView> friendshipLink = friendshipLinkService.findFriendshipLink(view);
        return friendshipLink;
    }

    /**
     * [footerLink 网站相关]
     * @param view
     * @return
     */
    @PostMapping("/lineAboutWeb")
    @ResponseBody
    public List<FriendshipLinkView> lineAboutWeb(FriendshipLinkView view){
        view.setParentId(1);
        List<FriendshipLinkView> friendshipLink = friendshipLinkService.findFriendshipLink(view);
        return friendshipLink;
    }

    /**
     * [footerLink 常用链接]
     * @param view
     * @return
     */
    @PostMapping("/linkCommonly")
    @ResponseBody
    public List<FriendshipLinkView> linkCommonly(FriendshipLinkView view){
        view.setParentId(2);
        List<FriendshipLinkView> friendshipLink = friendshipLinkService.findFriendshipLink(view);
        return friendshipLink;
    }

    /**
     * [footerLink 联系我们]
     * @param view
     * @return
     */
    @PostMapping("/linkUS")
    @ResponseBody
    public List<FriendshipLinkView> linkUS(FriendshipLinkView view){
        view.setParentId(3);
        List<FriendshipLinkView> friendshipLink = friendshipLinkService.findFriendshipLink(view);
        return friendshipLink;
    }

    /**
     * [footerLink 联系我们]
     * @param view
     * @return
     */
    @PostMapping("/followUS")
    @ResponseBody
    public List<FriendshipLinkView> followUS(FriendshipLinkView view){
        view.setParentId(4);
        List<FriendshipLinkView> friendshipLink = friendshipLinkService.findFriendshipLink(view);
        return friendshipLink;
    }

}
