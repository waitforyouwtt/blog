package com.yidiandian.dao;

import com.yidiandian.entity.FriendshipLink;
import com.yidiandian.view.FriendshipLinkView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/12 17:14
 * @Email: 15290810931@163.com
 */
@Mapper
public interface FriendshipLinkDao {

    /**
     * 批量插入
     * @param viewList
     * @return
     */
    int batchInsertFriendshipLink(@Param("viewList") List<FriendshipLinkView> viewList);

    /**
     * 根据条件进行查询
     * @param view
     * @return
     */
    List<FriendshipLink> findFriendshipLink(FriendshipLinkView view);
    /**
     * 修改
     * @param view
     * @return
     */
    int updateById (FriendshipLinkView view);
}
