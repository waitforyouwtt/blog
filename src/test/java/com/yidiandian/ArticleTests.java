package com.yidiandian;

import com.alibaba.fastjson.JSON;
import com.yidiandian.entity.Article;
import com.yidiandian.service.ArticleService;
import com.yidiandian.view.ArticleView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/23 18:07
 * @Email: 15290810931@163.com
 */
@Slf4j
@Component
public class ArticleTests extends BlogApplicationTests{

    @Autowired
    ArticleService articleService;

    @Test
    public void add(){
        ArticleView view = new ArticleView();
        view.setUserId("5775212");
        view.setColumnId(12);
        view.setTitle("倚天屠龙记2");
        view.setContent("倚天一出，谁与争锋。屠龙宝刀，莫敢不从。");
        view.setImage("www.baidu.com");
        view.setIsPublic(1);
        view.setIsTop(1);
        view.setChannelId("小说");
        view.setUrl("www.baidu.com");
        Article article = articleService.addArticle(view);
        log.info("添加返回的结果：{}", JSON.toJSON(article));
    }

}
