package com.yidiandian.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    //头条
    @GetMapping("head-lines")
    public String headLines(){
        return "headline-logined";
    }
    //问答
    @GetMapping("/questions-and-answers")
    public String questionsAndAnswers(){
        return "qa-logined";
    }
    //活动
    @GetMapping("/activitys")
    public String activitys(){
        return "activity-index";
    }
    //吐槽
    @GetMapping("/make-complaints")
    public String makeComplaints(){
        return "spit-index";
    }
    //招聘
    @GetMapping("/recruit")
    public String recruit(){
        return "recruit-index";
    }
    //交友
    @GetMapping("make-friends")
    public String friends(){
        return "makeFriends-index";
    }
    //音乐
    @GetMapping("/music")
    public String music(){
        return "music-list";
    }
    //上传音乐
    @GetMapping("/to-upload-music")
    public String toUploadMusic(){
        return "upload-music";
    }









}
