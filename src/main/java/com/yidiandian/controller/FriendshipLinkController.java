package com.yidiandian.controller;

import com.yidiandian.service.FriendshipLinkService;
import com.yidiandian.view.FriendshipLinkView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/12 18:17
 * @Email: 15290810931@163.com
 */
@Slf4j
@Controller
public class FriendshipLinkController {

    FriendshipLinkService friendshipLinkService;

    @PostMapping("/findFriendshipLink")
    public List<FriendshipLinkView> findFriendshipLink(@RequestBody FriendshipLinkView view){
        return friendshipLinkService.findFriendshipLink(view);
    }


}
