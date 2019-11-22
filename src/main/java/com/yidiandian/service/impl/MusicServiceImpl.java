package com.yidiandian.service.impl;

import com.alibaba.fastjson.JSON;
import com.yidiandian.constant.Constants;
import com.yidiandian.dao.MusicDao;
import com.yidiandian.entity.Article;
import com.yidiandian.entity.Music;
import com.yidiandian.enums.DeleteEnum;
import com.yidiandian.jpa.MusicMapper;
import com.yidiandian.service.MusicService;
import com.yidiandian.view.ArticleView;
import com.yidiandian.view.MusicView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/14 18:01
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicMapper musicMapper;

    @Autowired
    MusicDao musicDao;

    /**
     * 添加
     *
     * @param view
     */
    @Override
    public Music saveMusic(MusicView view) {
        Music music = new Music();
        BeanCopier beanCopier = BeanCopier.create(MusicView.class,Music.class,false);
        beanCopier.copy(view,music,null);
        music.setCreateTime(new Date());
        music.setUpdateTime(new Date());
        music.setIsLike(0);
        music.setIsCollect(0);
        if (StringUtils.isEmpty(view.getComment())){
          music.setComment(Constants.defaultValue);
        }
        music.setIsDelete(DeleteEnum.NORMAL.getCode());
        log.info("添加请求的参数：{}", JSON.toJSON(music));
        Music save = musicMapper.save(music);
        log.info("添加返回的结果：{}", JSON.toJSON(save));
        return save;
    }

    /**
     * 根据条件进行查询
     *
     * @param view
     */
    @Override
    public List<MusicView> findMusic(MusicView view) {
        log.info("根据条件进行查询请求参数：{}",JSON.toJSON(view));
        List<MusicView> views = new ArrayList<>();
        view.setIsDelete(DeleteEnum.NORMAL.getCode());
        if (!CollectionUtils.isEmpty(view.getIds())){
            view.setId(null);
        }
        List<Music> findMusics =  musicDao.findMusic(view);
        if (CollectionUtils.isEmpty(findMusics)){
            return new ArrayList<>();
        }
        getMusic(views,findMusics);
        return views;
    }

    /**
     * 后台添加音乐
     *
     * @param view
     * @return
     */
    @Override
    public int uploadMusic(MusicView view) {
        return 0;
    }

    private void getMusic(List<MusicView> views, List<Music> findMusics) {
        findMusics.stream().forEach(music -> {
            MusicView view = new MusicView();
            BeanCopier beanCopier = BeanCopier.create(Music.class,MusicView.class,false);
            beanCopier.copy(music,view,null);
            views.add(view);
        });
    }
}
