package com.yidiandian;

import com.alibaba.fastjson.JSON;
import com.yidiandian.service.MusicService;
import com.yidiandian.view.MusicView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MusicTests extends BlogApplicationTests{

	@Autowired
	MusicService musicService;


	@Test
	public void findMusicTest() {
		MusicView view = new MusicView();
		List<MusicView> music = musicService.findMusic(view);
		log.info("根据条件进行查询到的结果：{}", JSON.toJSON(music));
	}

}
