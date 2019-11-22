package com.yidiandian.service;

import com.yidiandian.entity.WebsiteUrl;
import com.yidiandian.view.WebsiteUrlView;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/14 19:57
 * @Email: 15290810931@163.com
 */
public interface WebsiteUrlService {

    /**
     * 添加
     */
    WebsiteUrl saveWebsiteUrl(WebsiteUrlView view);

    /**
     * 批量添加
     * @param views
     * @return
     */
    int batchInsertWebsiteUrl(List<WebsiteUrlView> views);

    /**
     * 根据条件查询业务url 连接
     * @param view
     * @return
     */
    List<WebsiteUrlView> getWebsiteUrl(WebsiteUrlView view);
}
