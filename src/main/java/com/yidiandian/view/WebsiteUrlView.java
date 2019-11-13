package com.yidiandian.view;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/14 19:57
 * @Email: 15290810931@163.com
 */
@Data
public class WebsiteUrlView {

    private Integer id;

    @Basic
    @Column(name = "plate_id",columnDefinition="int(11) COMMENT '板块ID'")
    private Integer plateId;

    @Basic
    @Column(name = "plate",columnDefinition="varchar(100) COMMENT '板块'")
    private String plate;

    @Basic
    @Column(name = "parent_id",columnDefinition="varchar(100) COMMENT '父级ID'")
    private Integer parentId;

    @Basic
    @Column(name = "url_title",columnDefinition="varchar(200) COMMENT 'url名字'",unique = true)
    private String urlTitle;

    @Basic
    @Column(name = "url",columnDefinition="varchar(200) COMMENT 'url链接'",unique = true)
    private String url;

    @Basic
    @Column(name = "sort_id",columnDefinition="int(11) COMMENT '排序ID'")
    private Integer sortId;

    @Basic
    @Column(name = "sort_desc",columnDefinition="int(11) COMMENT '排序描述'")
    private String sortDesc;

    @Basic
    @Column(name = "plate_delete",columnDefinition="int(11) COMMENT '板块是否删除 1 未删除 2 已删除'")
    private Integer plateDelete;

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
