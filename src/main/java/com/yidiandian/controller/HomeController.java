package com.yidiandian.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/12 20:28
 * @Email: 15290810931@163.com
 */
@Slf4j
@Controller
public class HomeController {

    //我的回答
    @GetMapping("/my-answer")
    public String answer(){
        return "person-myanswer";
    }
    //我的提问
    @GetMapping("/my-questions")
    public String questions(){
        return "person-myquestion";
    }
    //我的分享
    @GetMapping("/my-shared")
    public String shared(){
        return "person-myshare";
    }
    //个人动态
    @GetMapping("/personal-dynamics")
    public String dynamics(){
        return "person-dynamic";
    }
    //我的关注
    @GetMapping("/my-follow")
    public String follow(){
        return "person-myfocus";
    }
    //我的收藏
    @GetMapping("/my-collection")
    public String collection(){
        return "person-mycollect";
    }
    //浏览记录
    @GetMapping("/my-browse-record")
    public String browseRecord(){
        return "person-myreaded";
    }
    //账户设置
    @GetMapping("/account-settings")
    public String personAccount(){
        return "person-account";
    }









}
