package com.yidiandian.controller;

import com.alibaba.fastjson.JSON;
import com.yidiandian.service.MusicService;
import com.yidiandian.view.MusicView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Arrays;
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

    @GetMapping("/music-details")
    public String musicDetails(MusicView params, Model model){
        int prve = params.getId()-1;
        int next = params.getId()+1;
        params.setIds(Arrays.asList(params.getId(),prve,next));
        List<MusicView> musics = musicService.findMusic(params);
        model.addAttribute("musics", JSON.toJSONString(musics));
        return "music";
    }

}
