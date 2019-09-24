package com.yidiandian.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

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
@Table(name ="tb_user_info")
@org.hibernate.annotations.Table(appliesTo = "tb_user_info",comment="用户信息表")
public class UserInfo implements Serializable {
}
