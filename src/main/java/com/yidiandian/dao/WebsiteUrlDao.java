package com.yidiandian.dao;

import com.yidiandian.entity.WebsiteUrl;
import com.yidiandian.view.WebsiteUrlView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/14 19:37
 * @Email: 15290810931@163.com
 */
@Mapper
public interface WebsiteUrlDao {

    List<WebsiteUrl> findWebsiteUrl(WebsiteUrlView view);

    /**
     * 批量添加
     * @param views
     * @return
     */
    int batchInsertWebsiteUrl(@Param("viewList") List<WebsiteUrlView> views);
}
