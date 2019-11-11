package com.yidiandian.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/16 14:49
 * @Email: 15290810931@163.com
 * 收藏
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name ="tb_article")
@org.hibernate.annotations.Table(appliesTo = "tb_article",comment="文章信息表")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id", sequenceName = "id", allocationSize=1)
    private Integer id;

    @Basic
    @Column(name = "user_id",columnDefinition="varchar(100) COMMENT '用户ID'")
    private String userId;

    @Basic
    @Column(name = "column_id",columnDefinition="varchar(20) COMMENT '专栏ID'")
    private Integer columnId;

    @Basic
    @Column(name = "title",columnDefinition="varchar(100) COMMENT '标题'")
    private String title;

    @Basic
    @Column(name = "content",columnDefinition="varchar(100) COMMENT '内容'")
    private String content;

    @Basic
    @Column(name = "image",columnDefinition="varchar(100) COMMENT '文章封面图片'")
    private String image;

    @Basic
    @Column(name = "is_public",columnDefinition="int(11) DEFAULT 1 COMMENT '是否公开 1 公开 2 不公开'")
    private Integer isPublic;

    @Basic
    @Column(name = "is_top",columnDefinition="int(11) DEFAULT 1 COMMENT '是否置顶 1 是 2 否'")
    private Integer isTop;

    @Basic
    @Column(name = "visits",columnDefinition="int(11) DEFAULT 0 COMMENT '浏览量'")
    private Integer visits;

    @Basic
    @Column(name = "thumbup",columnDefinition="int(11) DEFAULT 0 COMMENT '点赞数'")
    private Integer thumbup;

    @Basic
    @Column(name = "comment",columnDefinition="int(11) DEFAULT 0 COMMENT '评论数'")
    private Integer comment;

    @Basic
    @Column(name = "state",columnDefinition="int(11) default 1 COMMENT '审核状态 1 待审核 2 审核通过 3已拒绝'")
    private Integer state;

    @Basic
    @Column(name = "channel_id",columnDefinition="varchar(100)  COMMENT '所属频道'")
    private String channelId;

    @Basic
    @Column(name = "url",columnDefinition=" varchar(255)  COMMENT '文章链接'")
    private String url;

    @Basic
    @Column(name = "type",columnDefinition=" varchar(255)  COMMENT '文章类型'")
    private String type;

    @Basic
    @Column(name = "is_delete",columnDefinition="int(11) default 1 COMMENT '是否删除 1 未删除 2 已删除'")
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

}
