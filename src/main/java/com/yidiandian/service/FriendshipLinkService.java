package com.yidiandian.service;

import com.yidiandian.view.FriendshipLinkView;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/12 18:12
 * @Email: 15290810931@163.com
 */
public interface FriendshipLinkService {
    /**
     * 批量添加
     * @param views
     * @return
     */
    int batchInsertFriendshipLink(List<FriendshipLinkView> views);

    /**
     * 根据条件进行查找友情链接
     * @param view
     * @return
     */
    List<FriendshipLinkView> findFriendshipLink(FriendshipLinkView view);
    /**
     * 修改
     */
    int updateById(FriendshipLinkView view);

}
