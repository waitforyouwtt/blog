package com.yidiandian.service.impl;

import com.alibaba.fastjson.JSON;
import com.yidiandian.dao.FriendshipLinkDao;
import com.yidiandian.entity.FriendshipLink;
import com.yidiandian.enums.BusinessEnum;
import com.yidiandian.enums.DeleteEnum;
import com.yidiandian.exceptions.MyException;
import com.yidiandian.service.FriendshipLinkService;
import com.yidiandian.view.FriendshipLinkView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/12 18:14
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class FriendshipLinkServiceImpl implements FriendshipLinkService {

    @Resource
    FriendshipLinkDao friendshipLinkDao;
    /**
     * 批量添加
     *
     * @param views
     * @return
     */
    @Override
    public int batchInsertFriendshipLink(List<FriendshipLinkView> views) {
        if (CollectionUtils.isEmpty(views)){
            throw new MyException(BusinessEnum.PARAMS_NOT_POINT.getCode(),BusinessEnum.PARAMS_NOT_POINT.getMsg());
        }
        return friendshipLinkDao.batchInsertFriendshipLink(views);
    }

    /**
     * 根据条件进行查找友情链接
     *
     * @param view
     * @return
     */
    @Override
    public List<FriendshipLinkView> findFriendshipLink(FriendshipLinkView view) {
        log.info("查询接受的参数是：{}", JSON.toJSON(view));
        List<FriendshipLinkView> views = new ArrayList<>();
        view.setIsDelete(DeleteEnum.NORMAL.getCode());
        List<FriendshipLink> friendshipLinks = friendshipLinkDao.findFriendshipLink(view);
        if (CollectionUtils.isEmpty(friendshipLinks)){
            return null;
        }
        getFriendshipLinks(views, friendshipLinks);
        return views;
    }

    /**
     * 修改
     *
     * @param view
     */
    @Override
    public int updateById(FriendshipLinkView view) {
        if (view.getId().toString() == null){
            throw new MyException(BusinessEnum.PARAMS_NOT_POINT.getCode(),BusinessEnum.PARAMS_NOT_POINT.getMsg());
        }
        log.info("update接收到的参数：{}",JSON.toJSON(view));
        return friendshipLinkDao.updateById(view);
    }

    private void getFriendshipLinks(List<FriendshipLinkView> views, List<FriendshipLink> friendshipLinks) {
        friendshipLinks.stream().forEach(friendshipLink -> {
            FriendshipLinkView friendshipLinkView = new FriendshipLinkView();
            BeanCopier beanCopier = BeanCopier.create(FriendshipLink.class,FriendshipLinkView.class,false);
            beanCopier.copy(friendshipLink,friendshipLinkView,null);
            views.add(friendshipLinkView);
        });
    }
}
