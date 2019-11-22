package com.yidiandian.service;

import com.yidiandian.entity.Article;
import com.yidiandian.view.ArticleView;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/23 17:48
 * @Email: 15290810931@163.com
 */
public interface ArticleService {

    /**
     * 添加文章
     * @param view
     * @return
     */
    Article addArticle(ArticleView view);

    /**
     * 查询文章
     */
    List<ArticleView> findByParams(ArticleView view);
}
