package com.yidiandian.jpa;

import com.yidiandian.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/23 17:47
 * @Email: 15290810931@163.com
 */
public interface ArticleMapper extends JpaRepository<Article,Integer> {
}
