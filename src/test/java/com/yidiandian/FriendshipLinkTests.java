package com.yidiandian;

import com.alibaba.fastjson.JSON;
import com.yidiandian.constant.Constants;
import com.yidiandian.dao.FriendshipLinkDao;
import com.yidiandian.service.FriendshipLinkService;
import com.yidiandian.view.FriendshipLinkView;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/12 17:24
 * @Email: 15290810931@163.com
 */
@Slf4j
@Component
public class FriendshipLinkTests extends BlogApplicationTests {

    @Autowired
    FriendshipLinkDao friendshipLinkDao;

    @Autowired
    FriendshipLinkService friendshipLinkService;

    @Test
    public void batchInsert(){
        List<FriendshipLinkView> views = Lists.newArrayList();
        FriendshipLinkView view0 = new FriendshipLinkView();
        view0.setParentId(0);
        view0.setUrlTitle("网站相关");
        view0.setUrl("https://www.baidu.com");
        view0.setCreator(Constants.ADMIN);
        view0.setModifier(Constants.ADMIN);

        FriendshipLinkView view1 = new FriendshipLinkView();
        view1.setParentId(0);
        view1.setUrlTitle("常用链接");
        view1.setUrl("https://www.baidu.com");
        view1.setCreator(Constants.ADMIN);
        view1.setModifier(Constants.ADMIN);

        FriendshipLinkView view2 = new FriendshipLinkView();
        view2.setParentId(0);
        view2.setUrlTitle("联系我们");
        view2.setUrl("https://www.baidu.com");
        view2.setCreator(Constants.ADMIN);
        view2.setModifier(Constants.ADMIN);

        FriendshipLinkView view3 = new FriendshipLinkView();
        view3.setParentId(0);
        view3.setUrlTitle("关注我们");
        view3.setUrl("https://www.baidu.com");
        view3.setCreator(Constants.ADMIN);
        view3.setModifier(Constants.ADMIN);

        FriendshipLinkView view4 = new FriendshipLinkView();
        view4.setParentId(0);
        view4.setUrlTitle("内容许可");
        view4.setUrl("https://www.baidu.com");
        view4.setCreator(Constants.ADMIN);
        view4.setModifier(Constants.ADMIN);
        views.add(view0);views.add(view1);
        views.add(view2);views.add(view3);
        views.add(view3);views.add(view4);
        log.info("批量添加的参数：{}",JSON.toJSON(views));
        int i = friendshipLinkDao.batchInsertFriendshipLink(views);
        log.info("返回的结果：{}", JSON.toJSON(i));
    }

    @Test
    public void batchInsertSun(){
        List<FriendshipLinkView> views = Lists.newArrayList();
        FriendshipLinkView view0 = new FriendshipLinkView();
        view0.setParentId(1);
        view0.setUrlTitle("关于我们");
        view0.setUrl("https://about-we.com");
        view0.setCreator(Constants.ADMIN);
        view0.setModifier(Constants.ADMIN);

        FriendshipLinkView view1 = new FriendshipLinkView();
        view1.setParentId(1);
        view1.setUrlTitle("服务条款");
        view1.setUrl("https://service-agreement.com");
        view1.setCreator(Constants.ADMIN);
        view1.setModifier(Constants.ADMIN);

        FriendshipLinkView view2 = new FriendshipLinkView();
        view2.setParentId(0);
        view2.setUrlTitle("帮助中心");
        view2.setUrl("https://help-center.com");
        view2.setCreator(Constants.ADMIN);
        view2.setModifier(Constants.ADMIN);

        FriendshipLinkView view3 = new FriendshipLinkView();
        view3.setParentId(2);
        view3.setUrlTitle("传智博客");
        view3.setUrl("https://www.chuanzhi-csdn.com");
        view3.setCreator(Constants.ADMIN);
        view3.setModifier(Constants.ADMIN);

        FriendshipLinkView view4 = new FriendshipLinkView();
        view4.setParentId(2);
        view4.setUrlTitle("传智论坛");
        view4.setUrl("https://www.chuanzhi-luntan.com");
        view4.setCreator(Constants.ADMIN);
        view4.setModifier(Constants.ADMIN);

        FriendshipLinkView view5 = new FriendshipLinkView();
        view5.setParentId(3);
        view5.setUrlTitle("联系我们");
        view5.setUrl("https://www.call-we.com");
        view5.setCreator(Constants.ADMIN);
        view5.setModifier(Constants.ADMIN);

        FriendshipLinkView view6 = new FriendshipLinkView();
        view6.setParentId(3);
        view6.setUrlTitle("加入我们");
        view6.setUrl("https://www.join-we.com");
        view6.setCreator(Constants.ADMIN);
        view6.setModifier(Constants.ADMIN);

        FriendshipLinkView view7 = new FriendshipLinkView();
        view7.setParentId(3);
        view7.setUrlTitle("建议反馈");
        view7.setUrl("https://www.feed-back.com");
        view7.setCreator(Constants.ADMIN);
        view7.setModifier(Constants.ADMIN);

        FriendshipLinkView view8 = new FriendshipLinkView();
        view8.setParentId(4);
        view8.setUrlTitle("微博");
        view8.setUrl("https://www.weibo.com");
        view8.setCreator(Constants.ADMIN);
        view8.setModifier(Constants.ADMIN);

        FriendshipLinkView view9 = new FriendshipLinkView();
        view9.setParentId(4);
        view9.setUrlTitle("twitter");
        view9.setUrl("https://www.twitter.com");
        view9.setCreator(Constants.ADMIN);
        view9.setModifier(Constants.ADMIN);

        FriendshipLinkView view10 = new FriendshipLinkView();
        view10.setParentId(5);
        view10.setUrlTitle("已获取国家认证");
        view10.setUrl("https://www.county.com");
        view10.setCreator(Constants.ADMIN);
        view10.setModifier(Constants.ADMIN);

        views.add(view0);views.add(view1);
        views.add(view2);views.add(view3);
        views.add(view3);views.add(view4);
        views.add(view5);views.add(view6);
        views.add(view7);views.add(view8);
        views.add(view9);views.add(view10);

        log.info("批量添加的参数：{}",JSON.toJSON(views));
        int i = friendshipLinkDao.batchInsertFriendshipLink(views);
        log.info("返回的结果：{}", JSON.toJSON(i));
    }

    @Test
    public void findFriendshipLink(){
        FriendshipLinkView view = new FriendshipLinkView();
        view.setParentId(1);
        List<FriendshipLinkView> friendshipLink = friendshipLinkService.findFriendshipLink(view);
        log.info("查询到的结果：{}",JSON.toJSON(friendshipLink));
    }

    @Test
    public void updateById(){
        FriendshipLinkView view = new FriendshipLinkView();
        view.setId(5);
        view.setUrlTitle("收藏我们");
        view.setIsDelete(1);

        int i = friendshipLinkDao.updateById(view);
        log.info("修改：{}",i);
    }
}
