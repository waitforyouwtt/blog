package com.yidiandian.controller;

import com.yidiandian.service.MusicService;
import com.yidiandian.view.MusicView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        List<MusicView> musics = musicService.findMusic(params);
        model.addAttribute("music", musics.get(0));
        return "music";
    }

/*    @PostMapping("/music-details")
    @ResponseBody
    public MusicView musicDetails(@RequestBody MusicView params){
        List<MusicView> musics = musicService.findMusic(params);
        if (CollectionUtils.isEmpty(musics)){
            return null;
        }
        return musics.get(0);
    }*/
}
