package com.yidiandian.view;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/14 17:58
 * @Email: 15290810931@163.com
 */
@Data
public class MusicView {

    private Integer id;

    private List<Integer> ids;

    @Basic
    @Column(name = "user_id",columnDefinition="varchar(100) COMMENT '用户ID'")
    private String userId;

    @Basic
    @Column(name = "music_name",columnDefinition="varchar(100) COMMENT '歌曲名字'")
    private String musicName;

    @Basic
    @Column(name = "music_url",columnDefinition="varchar(100) COMMENT '歌曲url链接'")
    private String musicUrl;

    @Basic
    @Column(name = "music_img",columnDefinition="varchar(100) COMMENT '歌曲封面背景图片'")
    private String musicImg;

    @Basic
    @Column(name = "singer",columnDefinition="varchar(100) COMMENT '歌手'")
    private String singer;

    @Basic
    @Column(name = "lyric_content",columnDefinition="text COMMENT '歌曲歌词'")
    private String lyricContent;

    @Basic
    @Column(name = "music_duration",columnDefinition="int(11) COMMENT '歌曲时长'")
    private int musicDuration;

    @Basic
    @Column(name = "music_video",columnDefinition="blob COMMENT '歌曲视频'")
    private int musicVideo;

    @Basic
    @Column(name = "is_like",columnDefinition="int(11) COMMENT '是否喜欢 1 喜欢 2 不喜欢'")
    private Integer isLike;

    @Basic
    @Column(name = "is_collect",columnDefinition="int(11) COMMENT '是否收藏 1 收藏 2 不收藏'")
    private Integer isCollect;

    @Basic
    @Column(name = "comment",columnDefinition="varchar(100) COMMENT '评论'")
    private String comment;

    @Basic
    @Column(name = "comment_time",columnDefinition="datetime COMMENT '评论时间'")
    private Date commentTime;

    @Basic
    @Column(name = "is_delete",columnDefinition="int(11) COMMENT '是否删除 1 未删除 2 已删除'")
    private Integer isDelete;

    @Basic
    @Column(name = "creator",columnDefinition="varchar(100) COMMENT '创建人'")
    private String creator;

    @Basic
    @Column(name = "modifier",columnDefinition="varchar(100) COMMENT '更新人'")
    private String modifier;

    @Basic
    @Column(name = "create_time",columnDefinition="datetime COMMENT '创建时间'")
    private Date createTime;

    @Basic
    @Column(name = "update_time",columnDefinition="datetime COMMENT '修改时间'")
    private Date updateTime;

    private MultipartFile musicImgFile;

    private MultipartFile musicVideoFile;

    private byte [] musicImgByte;

    private byte [] musicVideoByte;
}
