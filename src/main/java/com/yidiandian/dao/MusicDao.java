package com.yidiandian.dao;

import com.yidiandian.entity.Music;
import com.yidiandian.view.MusicView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/14 18:05
 * @Email: 15290810931@163.com
 */
@Mapper
public interface MusicDao {

    List<Music> findMusic(MusicView view);
}
