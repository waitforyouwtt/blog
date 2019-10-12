package com.yidiandian.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/24 22:40
 * @Email: 15290810931@163.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name ="tb_user_info")
@org.hibernate.annotations.Table(appliesTo = "tb_user_info",comment="用户信息表")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id", sequenceName = "id", allocationSize=1)
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
    @Column(name = "mobile",columnDefinition="varchar(25) COMMENT '用户手机号'")
    private String mobile;

    @Basic
    @Column(name = "password",columnDefinition="varchar(200) COMMENT '用户密码'")
    private String password;

    @Basic
    @Column(name = "age",columnDefinition="int(11) COMMENT '用户年龄'")
    private Integer age;

    @Basic
    @Column(name = "birthday",columnDefinition="datetime COMMENT '用户生日'")
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
