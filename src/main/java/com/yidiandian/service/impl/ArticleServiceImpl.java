package com.yidiandian.service.impl;

import com.alibaba.fastjson.JSON;
import com.yidiandian.dao.ArticleDao;
import com.yidiandian.entity.Article;
import com.yidiandian.enums.DeleteEnum;
import com.yidiandian.jpa.ArticleMapper;
import com.yidiandian.service.ArticleService;
import com.yidiandian.view.ArticleView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/23 17:50
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleDao articleDao;
    /**
     * 添加文章
     *
     * @param view
     * @return
     */
    @Override
    public Article addArticle(ArticleView view) {
        Article article = new Article();
        BeanCopier beanCopier = BeanCopier.create(ArticleView.class,Article.class,false);
        beanCopier.copy(view,article,null);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        log.info("添加请求的参数：{}", JSON.toJSON(article));
        Article save = articleMapper.save(article);
        log.info("添加返回的结果：{}", JSON.toJSON(save));
        return save;
    }

    /**
     * 查询文章
     *
     * @param view
     */
    @Override
    public List<ArticleView> findByParams(ArticleView view) {

        List<ArticleView> views = new ArrayList<>();
        view.setIsDelete(DeleteEnum.NORMAL.getCode());
        List<Article> findArticles =  articleDao.findByParams(view);
        if (CollectionUtils.isEmpty(findArticles)){
            return new ArrayList<>();
        }
        getArticleList(views,findArticles);
        return views;
    }

    private void getArticleList(List<ArticleView> views, List<Article> findArticles) {
        findArticles.stream().forEach(article -> {
            ArticleView view = new ArticleView();
            BeanCopier beanCopier = BeanCopier.create(Article.class,ArticleView.class,false);
            beanCopier.copy(article,view,null);
            views.add(view);
        });
    }
}
