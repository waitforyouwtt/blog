package com.yidiandian.view;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/13 20:11
 * @Email: 15290810931@163.com
 */
@Data
public class QuestionView implements Serializable{

    @Basic
    @Column(name = "title",columnDefinition="varchar(100) COMMENT '标题'")
    private String title;

    @Basic
    @Column(name = "content",columnDefinition="text COMMENT '标题'")
    private String content;

    @Basic
    @Column(name = "user_id",columnDefinition="varchar(100) COMMENT '用户ID'")
    private String userId;

    @Basic
    @Column(name = "nick_name",columnDefinition="varchar(100) COMMENT '用户昵称'")
    private String nickName;

    @Basic
    @Column(name = "visits",columnDefinition="int(11) DEFAULT 0 COMMENT '浏览量'")
    private Integer visits;

    @Basic
    @Column(name = "thumbup",columnDefinition="int(11) DEFAULT 0 COMMENT '点赞数'")
    private Integer thumbup;

    @Basic
    @Column(name = "reply",columnDefinition="int(11) DEFAULT 0 COMMENT '回复数'")
    private Integer reply;

    @Basic
    @Column(name = "solve",columnDefinition="int(11) default 1 COMMENT '是否解决 1 已解决 2 未解决'")
    private Integer solve;

    @Basic
    @Column(name = "reply_name",columnDefinition="varchar(100) COMMENT '回复人昵称'")
    private String replyName;

    @Basic
    @Column(name = "reply_time",columnDefinition="datetime COMMENT '回复日期'")
    private Date replyTime;

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
}
