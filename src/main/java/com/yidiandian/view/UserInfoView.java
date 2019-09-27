package com.yidiandian.view;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/24 23:21
 * @Email: 15290810931@163.com
 */
@Data
public class UserInfoView implements Serializable{

    private Integer id;

    @Basic
    @Column(name = "user_id",columnDefinition="varchar(100) COMMENT '用户id'")
    private String userId;

    @Basic
    @Column(name = "user_name",columnDefinition="varchar(100) COMMENT '用户名'")
    private String userName;

    @Basic
    @Column(name = "nick_name",columnDefinition="varchar(100) COMMENT '用户昵称'")
    private String nickName;

    @Basic
    @Column(name = "oldPassword",columnDefinition="varchar(200) COMMENT '旧密码'")
    private String oldPassword;

    @Basic
    @Column(name = "password",columnDefinition="varchar(200) COMMENT '用户密码'")
    private String password;

    @Basic
    @Column(name = "age",columnDefinition="int(11) COMMENT '用户年龄'")
    private Integer age;

    @Basic
    @Column(name = "birthday",columnDefinition="int(11) COMMENT '用户生日'")
    private Date birthday;

    @Basic
    @Column(name = "gender",columnDefinition="int(11) COMMENT '用户性别 1 男 2 女 3 保密'")
    private Integer gender;

    @Basic
    @Column(name = "address",columnDefinition="varchar(200) COMMENT '用户地址'")
    private String address;

    @Basic
    @Column(name = "email",columnDefinition="varchar(200) COMMENT '电子邮件'")
    private String email;

    @Basic
    @Column(name = "is_delete",columnDefinition="int(11) COMMENT '是否删除 1 未删除 2 已删除'")
    private Integer isDelete;

    @Basic
    @CreatedDate
    @Column(name = "create_time",columnDefinition="datetime COMMENT '创建时间'")
    private Date createTime;

    @Basic
    @LastModifiedDate
    @Column(name = "update_time",columnDefinition="datetime COMMENT '修改时间'")
    private Date updateTime;
}
