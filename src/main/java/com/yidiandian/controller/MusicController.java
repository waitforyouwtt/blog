package com.yidiandian.controller;

import com.yidiandian.service.MusicService;
import com.yidiandian.view.MusicView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/14 17:56
 * @Email: 15290810931@163.com
 */
@Slf4j
@Controller
public class MusicController {

    @Autowired
    MusicService musicService;

    @PostMapping("find-music")
    @ResponseBody
    public List<MusicView> findMusic(MusicView view){
       List<MusicView> findMusic = musicService.findMusic(view);
       return findMusic;
    }

    @PostMapping("/Musics")
    @ResponseBody
    public List<MusicView> Musics(@RequestBody MusicView params){
        List<MusicView> music = musicService.findMusic(params);
        return music;
    }
}
