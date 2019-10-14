package com.yidiandian.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/24 21:46
 * @Email: 15290810931@163.com
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping("/headline-logined")
    public String headlineLogined(){
        return "headline-logined";
    }

    //底部url链接显示
    @GetMapping("/footer")
    public String footer(){
        return "footer";
    }


}
