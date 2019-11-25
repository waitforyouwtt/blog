package com.yidiandian.controller;

import com.alibaba.fastjson.JSON;
import com.yidiandian.constant.Constants;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.MusicService;
import com.yidiandian.utils.UserInfoSessionUtils;
import com.yidiandian.view.MusicView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    @Autowired
    UserInfoSessionUtils userInfoSessionUtils;

    @Value("${blog.musicVideoPath}")
    String musicVideoPath;

    @Value("${blog.musicImgPath}")
    String musicImgPath;

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

    @PostMapping("/upload-simple-file")
    @ResponseBody
    public Map<String,String> uploadSimpleFile(@RequestParam("file")MultipartFile file){

        log.info("接收的上传请求参数：{}",JSON.toJSON(file));
        Map <String,String> result = new HashMap<>(16);

        LocalDate now = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateDir = now.format(df);
        MusicView view = new MusicView();
        try{
            String fileCode  = String.valueOf(System.nanoTime());
            //获取文件名
            String oriFileName = file.getOriginalFilename();
            //获取文件的后缀名字
            String suffix = oriFileName.substring(oriFileName.lastIndexOf("."),oriFileName.length());
            //文件上传的路径
            String dirPath = musicImgPath;
            //获取文件上传的全路径
            String fullFilePath = dirPath+fileCode+suffix;
            log.info("上传文件存储路径：{}",fullFilePath);
            mkDir(new File(dirPath));
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fullFilePath));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
            //保存数据
            view.setMusicName(oriFileName.substring(0,oriFileName.lastIndexOf(".")));
            view.setMusicUrl(fullFilePath);
            log.info("保存的参数为：{}",JSON.toJSON(view));
            musicService.saveMusic(view);
        }catch (Exception e){
            log.info("上传文件异常：{}",e.getMessage());
            result.put("code","500");
            result.put("message","上传文件异常");
            return result;
        }
        result.put("code","200");
        result.put("message","成功");
        log.info("上文上传返回结果：{}",JSON.toJSON(result));
        return result;
    }

    @RequestMapping(value = "/upload-double-file",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> uploadDoubleFile(HttpServletRequest request,MusicView params){

        log.info("接收的上传请求参数：{}",JSON.toJSON(params));
        Map <String,String> result = new HashMap<>(16);

        //用list 接受上传的多个文件
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        MusicView view  = new MusicView();
        String fullFilePath = null;
        String singer = null;
        for (int i = 0; i < files.size(); i++ ){
            file =files.get(i);
            if (!file.isEmpty()){
                LocalDate now = LocalDate.now();
                DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyyMMdd");
                String dateDir = now.format(dfm);

                try{
                    String fileCode = String.valueOf(System.nanoTime());
                    //获取文件名
                    String oriFileName = file.getOriginalFilename();
                    //获取文件后缀名
                    String suffix = oriFileName.substring(oriFileName.lastIndexOf("."),oriFileName.length());
                    //文件上传路径
                    String dirPath = null;
                    if (".jpg".equals(suffix) || ".png".equals("suffix")){
                        dirPath =  Constants.path+musicImgPath;
                    }else if(".mp3".equals(suffix)){
                        dirPath =  Constants.path+musicVideoPath;
                    }
                    //fullFilePath = dirPath + fileCode+suffix;
                    fullFilePath = dirPath+oriFileName;
                    log.info("上传文件存储路径：{}",fullFilePath);
                    mkDir(new File(dirPath));
                    stream = new BufferedOutputStream(new FileOutputStream(fullFilePath));
                    stream.write(file.getBytes());
                    stream.flush();
                    stream.close();
                    //保存数据
                    view.setMusicName(oriFileName.substring(0,oriFileName.lastIndexOf(".")));
                    if (".jpg".equals(suffix) || ".png".equals(suffix)){
                        view.setMusicImg(oriFileName);
                    }
                    if (".mp3".equals(suffix)){
                        view.setMusicUrl(oriFileName);
                        log.info("suffix:{}",suffix);
                        view.setSinger(oriFileName.substring(0,oriFileName.indexOf("-")));
                    }
                }catch (Exception e){
                    log.info("上传文件异常：{}",e.getMessage());
                    result.put("code","500");
                    result.put("message","上传文件异常");
                    return result;
                }
            }
        }
        UserInfo userInfo = userInfoSessionUtils.findUserInfo(request);
        log.info("获取的用户信息：{}",userInfo);
        view.setCreator(userInfo.getNickName());
        view.setModifier(userInfo.getNickName());
        view.setUserId(userInfo.getUserId());
        view.setLyricContent(params.getLyricContent());
        view.setCommentTime(new Date());
        log.info("保存的参数是：{}",JSON.toJSON(view));
        musicService.saveMusic(view);

        result.put("code","200");
        result.put("message","成功");
        log.info("上文上传返回结果：{}",JSON.toJSON(result));
        return result;
    }

    /**
     * 判断文件夹是否存在
     * @param file
     */
    public static void mkDir(File file){
        if (file.getParentFile().exists()){
            file.mkdir();
        }else{
            mkDir(file.getParentFile());
            file.mkdir();
        }
    }

}
