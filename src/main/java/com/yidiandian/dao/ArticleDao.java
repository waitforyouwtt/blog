package com.yidiandian.dao;

import com.yidiandian.entity.Article;
import com.yidiandian.view.ArticleView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/14 10:45
 * @Email: 15290810931@163.com
 */
@Mapper
public interface ArticleDao {

    List<Article> findByParams(ArticleView view);
}
