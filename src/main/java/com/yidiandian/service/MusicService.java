package com.yidiandian.service;

import com.yidiandian.entity.Music;
import com.yidiandian.view.MusicView;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/14 17:59
 * @Email: 15290810931@163.com
 */
public interface MusicService {

    /**
     * 添加
     */
    Music saveMusic(MusicView view);

    /**
     * 根据条件进行查询
     */
    List<MusicView> findMusic(MusicView view);
}
