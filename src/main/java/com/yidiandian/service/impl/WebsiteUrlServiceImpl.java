package com.yidiandian.service.impl;

import com.alibaba.fastjson.JSON;
import com.yidiandian.dao.WebsiteUrlDao;
import com.yidiandian.entity.WebsiteUrl;
import com.yidiandian.enums.BusinessEnum;
import com.yidiandian.enums.DeleteEnum;
import com.yidiandian.enums.SortDescEnum;
import com.yidiandian.exceptions.MyException;
import com.yidiandian.jpa.WebsiteUrlMapper;
import com.yidiandian.service.WebsiteUrlService;
import com.yidiandian.view.WebsiteUrlView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/14 19:59
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class WebsiteUrlServiceImpl implements WebsiteUrlService {

    @Autowired
    WebsiteUrlDao websiteUrlDao;

    @Autowired
    WebsiteUrlMapper websiteUrlMapper;

    /**
     * 添加
     *
     * @param view
     */
    @Override
    public WebsiteUrl saveWebsiteUrl(WebsiteUrlView view) {
        WebsiteUrl websiteUrl = new WebsiteUrl();
        BeanCopier beanCopier = BeanCopier.create(WebsiteUrlView.class,WebsiteUrl.class,false);
        beanCopier.copy(view,websiteUrl,null);
        websiteUrl.setCreateTime(new Date());
        websiteUrl.setUpdateTime(new Date());
        websiteUrl.setPlateDelete(DeleteEnum.NORMAL.getCode());
        websiteUrl.setIsDelete(DeleteEnum.NORMAL.getCode());
        return websiteUrlMapper.save(websiteUrl);
    }

    /**
     * 批量添加
     *
     * @param views
     * @return
     */
    @Override
    public int batchInsertWebsiteUrl(List<WebsiteUrlView> views) {
        if (CollectionUtils.isEmpty(views)){
            throw new MyException(BusinessEnum.PARAMS_NOT_POINT.getCode(),BusinessEnum.PARAMS_NOT_POINT.getMsg());
        }
        return websiteUrlDao.batchInsertWebsiteUrl(views);
    }

    /**
     * 根据条件查询业务url 连接
     *
     * @param view
     * @return
     */
    @Override
    public List<WebsiteUrlView> getWebsiteUrl(WebsiteUrlView view) {
        log.info("查询接收到的参数：{}", JSON.toJSON(view));
        List<WebsiteUrlView> views = new ArrayList<>();
        if (!StringUtils.isEmpty(view.getSortDesc())){
            if (!view.getSortDesc().equals(SortDescEnum.ASC.getMsg()) && !view.getSortDesc().equals(SortDescEnum.DESC.getMsg())){
                throw new MyException(BusinessEnum.PARAMS_NOT_POINT.getCode(),BusinessEnum.PARAMS_NOT_POINT.getMsg());
            }
        }
        List<WebsiteUrl> websiteUrls = websiteUrlDao.findWebsiteUrl(view).stream().distinct().collect(Collectors.toList());
        if (CollectionUtils.isEmpty(websiteUrls)){
            return null;
        }
        getWebsiteUrl(views,websiteUrls);
        return views;
    }

    private void getWebsiteUrl(List<WebsiteUrlView> views, List<WebsiteUrl> websiteUrls) {
        websiteUrls.stream().forEach(websiteUrl -> {
            WebsiteUrlView websiteUrlView = new WebsiteUrlView();
            BeanCopier beanCopier = BeanCopier.create(WebsiteUrl.class,WebsiteUrlView.class,false);
            beanCopier.copy(websiteUrl,websiteUrlView,null);
            views.add(websiteUrlView);
        });
    }
}
