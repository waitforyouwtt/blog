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

    @GetMapping("/my-answer")
    public String myAnswer(){
        return "person-myanswer";
    }


}
