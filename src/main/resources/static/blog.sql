/*
Navicat MySQL Data Transfer

Source Server         : blog
Source Server Version : 50505
Source Host           : localhost:3307
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-11-19 18:13:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for college_student_report
-- ----------------------------
DROP TABLE IF EXISTS `college_student_report`;
CREATE TABLE `college_student_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户地址',
  `career_direction` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '职业方向',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `gender` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `labour_type` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '兼职类型：01 体力，02 脑力',
  `leisure_activities` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '业余活动',
  `pay_frequency` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '费用结算频率：01 周清，02 月清，03无所谓',
  `pay_type` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '费用结算方式：01 收入费用，02 固定薪酬，03无所谓',
  `phone` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `proposal` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户提议',
  `service_cus_gender` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '乐意服务人群性别：01 男，02 女，03，无所谓',
  `service_population` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '服务人群：01 小学生，02 中学生，03高中生，04外国人，05无所谓',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `user_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户Id',
  `user_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `work_resource` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '兼职途径',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='大学生调查问卷信息表';

-- ----------------------------
-- Records of college_student_report
-- ----------------------------
INSERT INTO `college_student_report` VALUES ('1', '静安区嘉里中心T1_11楼', '02', '2019-09-19 00:00:00', '01', '02', '01', '02', '02', '13761129175', '你好', '02', '02', '2019-09-19 00:00:00', '874997', 'waitforyou', '02');
INSERT INTO `college_student_report` VALUES ('2', '静安区嘉里中心T1_11楼', '02', '2019-09-19 00:00:00', '02', '01', '01,02', '02', '02,03', '13761129175', '你好', '02', '02,03', '2019-09-19 00:00:00', '233887', 'waitforyou', '02');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('8');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menu_title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menu_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单信息表';

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户ID',
  `column_id` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '专栏ID',
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '内容',
  `image` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文章封面图片',
  `is_public` int(11) DEFAULT 1 COMMENT '是否公开 1 公开 2 不公开',
  `is_top` int(11) DEFAULT 1 COMMENT '是否置顶 1 是 2 否',
  `visits` int(11) DEFAULT 0 COMMENT '浏览量',
  `thumbup` int(11) DEFAULT 0 COMMENT '点赞数',
  `comment` int(11) DEFAULT 0 COMMENT '评论数',
  `state` int(11) DEFAULT 1 COMMENT '审核状态 1 待审核 2 审核通过 3已拒绝',
  `channel_id` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属频道',
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文章链接',
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文章类型',
  `is_delete` int(11) DEFAULT 1 COMMENT '是否删除 1 未删除 2 已删除',
  `creator` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='文章信息表';

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES ('1', '577521', '1', '倚天屠龙记', null, 'www.baidu.com', '1', '1', null, null, null, null, '小说', 'www.baidu.com', null, null, null, null, '2019-10-23 18:14:41', '2019-10-23 18:14:41');
INSERT INTO `tb_article` VALUES ('2', '5775212', '12', '倚天屠龙记2', '倚天一出，谁与争锋。屠龙宝刀，莫敢不从。', 'www.baidu.com', '1', '1', null, null, null, null, '小说', 'www.baidu.com', null, null, null, null, '2019-11-11 17:43:06', '2019-11-11 17:43:06');
INSERT INTO `tb_article` VALUES ('3', '5775212', '12', '倚天屠龙记2', '倚天一出，谁与争锋。屠龙宝刀，莫敢不从。', 'www.baidu.com', '1', '1', null, null, null, null, '小说', 'www.baidu.com', null, null, null, null, '2019-11-12 19:30:20', '2019-11-12 19:30:20');
INSERT INTO `tb_article` VALUES ('4', '5775212', '12', '倚天屠龙记2', '倚天一出，谁与争锋。屠龙宝刀，莫敢不从。', 'www.baidu.com', '1', '1', null, null, null, null, '小说', 'www.baidu.com', null, null, null, null, '2019-11-12 19:31:03', '2019-11-12 19:31:03');
INSERT INTO `tb_article` VALUES ('5', '5775212', '12', '倚天屠龙记2', '倚天一出，谁与争锋。屠龙宝刀，莫敢不从。', 'www.baidu.com', '1', '1', null, null, null, null, '小说', 'www.baidu.com', null, null, null, null, '2019-11-12 19:31:55', '2019-11-12 19:31:55');
INSERT INTO `tb_article` VALUES ('6', '5775212', '12', '倚天屠龙记2', '倚天一出，谁与争锋。屠龙宝刀，莫敢不从。', 'www.baidu.com', '1', '1', null, null, null, null, '小说', 'www.baidu.com', null, null, null, null, '2019-11-12 19:32:37', '2019-11-12 19:32:37');
INSERT INTO `tb_article` VALUES ('7', '5775212', '12', '倚天屠龙记2', '倚天一出，谁与争锋。屠龙宝刀，莫敢不从。', 'www.baidu.com', '1', '1', null, null, null, null, '小说', 'www.baidu.com', null, null, null, null, '2019-11-12 19:33:14', '2019-11-12 19:33:14');
INSERT INTO `tb_article` VALUES ('8', '5775212', '12', '倚天屠龙记2', '倚天一出，谁与争锋。屠龙宝刀，莫敢不从。', 'www.baidu.com', '1', '1', null, null, null, null, '小说', 'www.baidu.com', null, null, null, null, '2019-11-12 19:34:37', '2019-11-12 19:34:37');

-- ----------------------------
-- Table structure for tb_categories
-- ----------------------------
DROP TABLE IF EXISTS `tb_categories`;
CREATE TABLE `tb_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categories_link_url` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类连接',
  `categories_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类名字',
  `parent_id` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '父级ID',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='类目标';

-- ----------------------------
-- Records of tb_categories
-- ----------------------------

-- ----------------------------
-- Table structure for tb_friendship_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_friendship_link`;
CREATE TABLE `tb_friendship_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '父级ID',
  `url_title` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'url名字',
  `url` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'url链接',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除 1 未删除 2 已删除',
  `status` int(11) DEFAULT NULL COMMENT '是否删除 1 有效 2 失效',
  `creator` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t1g02pnsa3pmj0fp7k23v749k` (`url_title`),
  UNIQUE KEY `UK_dh9bbuf85yfrml5hdfp0oniof` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='友情链接信息表';

-- ----------------------------
-- Records of tb_friendship_link
-- ----------------------------
INSERT INTO `tb_friendship_link` VALUES ('1', '0', '网站相关', 'https://about.website.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:10:33', '2019-11-13 14:10:33');
INSERT INTO `tb_friendship_link` VALUES ('2', '0', '常用链接', 'https://often.url.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:10:33', '2019-11-13 14:10:33');
INSERT INTO `tb_friendship_link` VALUES ('3', '0', '联系我们', 'https://www.contact.us.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:10:33', '2019-11-13 14:10:33');
INSERT INTO `tb_friendship_link` VALUES ('4', '0', '关注我们', 'https://www.follow.us.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:10:33', '2019-11-13 14:10:33');
INSERT INTO `tb_friendship_link` VALUES ('5', '0', '内容许可', 'https://www.content.ok.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:10:33', '2019-11-13 14:10:33');
INSERT INTO `tb_friendship_link` VALUES ('6', '1', '关于我们', 'https://about-us.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('7', '1', '服务条款', 'https://service-agreement.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('8', '1', '帮助中心', 'https://help-center.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('9', '2', 'blog博客', 'https://www.blog-csdn.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('10', '2', 'blog论坛', 'https://www.blog-talk.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('11', '3', 'CALL US', 'https://www.call-us.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('12', '3', '加入我们', 'https://www.join-us.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('13', '3', '建议反馈', 'https://www.feed-back.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('14', '4', '微博', 'https://www.weibo.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('15', '4', 'twitter', 'https://www.twitter.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');
INSERT INTO `tb_friendship_link` VALUES ('16', '5', '已获取国家认证', 'https://www.county.com', '1', null, 'Admin', 'Admin', '2019-11-13 14:25:19', '2019-11-13 14:25:19');

-- ----------------------------
-- Table structure for tb_music
-- ----------------------------
DROP TABLE IF EXISTS `tb_music`;
CREATE TABLE `tb_music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户ID',
  `music_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '歌曲名字',
  `music_url` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '歌曲url链接',
  `singer` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '歌手',
  `lyric` text COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '歌曲歌词',
  `music_duration` int(11) DEFAULT NULL COMMENT '歌曲时长',
  `music_video` blob DEFAULT NULL COMMENT '歌曲视频',
  `is_like` int(11) DEFAULT NULL COMMENT '是否喜欢 1 喜欢 2 不喜欢',
  `is_collect` int(11) DEFAULT NULL COMMENT '是否收藏 1 收藏 2 不收藏',
  `comment` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '评论',
  `comment_time` datetime DEFAULT NULL COMMENT '评论时间',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除 1 未删除 2 已删除',
  `creator` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='音乐信息表';

-- ----------------------------
-- Records of tb_music
-- ----------------------------
INSERT INTO `tb_music` VALUES ('1', '17621007255', '笑忘书', '/xiaowangshu', '王菲', '[00:00.00][00:01.00]笑忘书(国)[00:03.00]王菲[00:05.00][00:12.00]没 没有蜡烛 就不用勉强庆祝[00:17.00]没 没想到答案 就不用寻找题目[00:23.00]没 没有退路 问我也不要思路[00:29.00]没 没人去仰慕 那我就继续忙碌[00:34.00]lalala 思前想后[00:37.00]差一点忘记了怎么投诉[00:40.00]lalala 从此以后 不要犯同一个错误[00:46.00]将这样的感触 写一封情书送给我自己[00:51.00]感动得要哭 很久没哭[00:54.00]不失为天大的幸福 将这一份礼物[00:59.00]这一封情书 给自己祝福[01:02.00]可以不在乎 才能对别人在乎[01:20.00]有 一点帮助 就可以对谁倾诉[01:26.00]有 一个人保护 就不用自我保护[01:32.00]有 一点满足 就准备如何结束[01:37.00]有 一点点领悟 就可以往后回顾01:43.00]lalala 思前想后[01:46.00]差一点忘记了怎么投诉[01:49.00]lalala 从此以后 不要犯同一个错误[01:54.00]将这样的感触 写一封情书送给我自己[01:59.00]感动得要哭 很久没哭[02:03.00]不失为天大的幸福 将这一份礼物[02:08.00]这一封情书 给自己祝福[02:11.00]可以不在乎 才能对别人在乎[02:43.00]Lalalala....... Lalalala.......[02:55.00]从开始哭着忌妒 变成了笑着羡慕[03:00.00]时间是怎么样把握了我皮肤[03:03.00]只有我自己最清楚[03:06.00]将这样的感触 写一封情书送给我自己[03:11.00]感动得要哭 很久没哭[03:15.00]不失为天大的幸福 将这一份礼物[03:19.00]这一封情书 给自己祝福[03:22.00]可以不在乎 才能对别人在乎[03:28.00]让我亲手 将这样的感触[03:31.00]写一封情书送给我自己[03:34.00]感动得要哭 很久没哭[03:37.00]不失为天大的幸福[03:39.00]就好好将这一份礼物[03:42.00]这一封情书 给自己祝福[03:45.00]可以不在乎 才能对别人在乎', '205', null, '1', '1', '小姐姐好漂亮了，唱歌也好听', '2019-11-19 10:52:57', '1', 'Admin', 'Admin', '2019-11-19 09:40:49', '2019-11-19 09:40:51');
INSERT INTO `tb_music` VALUES ('2', '17621007255', '化身孤岛的鲸', '/huashengudaodejing', '李逸朗', '[00:00.00] 化身孤岛的鲸[00:03.00] 作词：沃特艾文儿[00:06.00] 作曲：徐浩[00:09.00] 编曲：伍昊予[00:12.00] 演唱：李逸朗[00:15.00] Lrc By：吉时雨[00:18.00] QQ：132 7269 041[00:21.00] www.cnLyric.com [00:25.64] 我是只化身孤岛的蓝鲸[00:28.94] 有着最巨大的身影[00:33.46] 鱼虾在身侧穿行[00:37.23] 也有飞鸟在背上停[00:42.48] 我路过太多太美的奇景[00:45.85] 如同伊甸般的仙境[00:50.11] 而大海太平太静[00:53.96] 多少故事无人倾听[00:58.91] 我爱地中海的天晴[01:02.55] 爱西伯利亚的雪景[01:06.30] 爱万丈高空的鹰[01:08.59] 爱肚皮下的藻荇[01:10.94] 我在尽心尽力地多情[01:14.20] 直到那一天[01:20.11] 你的衣衫破旧[01:22.19] 而歌声却温柔[01:24.19] 陪我漫无目的地四处漂流[01:28.24] 我的背脊如荒丘[01:30.49] 而你却微笑摆首[01:32.91] 把它当成整个宇宙[01:37.24] 你与太阳挥手[01:39.13] 也同海鸥问候[01:41.25] 陪我爱天爱地的四处风流[01:45.13] 只是遗憾你终究[01:47.33] 无法躺在我胸口[01:49.78] 欣赏夜空最辽阔的不朽[01:53.71] 把星子放入眸[02:03.33] 我是只化身孤岛的蓝鲸[02:06.98] 有着最巨大的身影[02:10.96] 鱼虾在身侧穿行[02:15.06] 也有飞鸟在背上停[02:20.18] 我有着太冷太清的天性[02:23.90] 对天上的她动过情[02:27.95] 而云朵太远太轻[02:32.21] 辗转之后各安天命[02:36.50] 我未入过繁华之境[02:40.35] 未听过喧嚣的声音[02:44.05] 未见过太多生灵[02:46.24] 未有过滚烫心情[02:48.77] 所以也未觉大洋正中[02:52.58] 有多么安静[02:57.10] 你的衣衫破旧[02:59.02] 而歌声却温柔[03:01.18] 陪我漫无目的四处漂流[03:05.32] 我的背脊如荒丘[03:07.34] 而你却微笑摆首[03:10.16] 把它当成整个宇宙03:13.96] 你与太阳挥手[03:15.97] 也同海鸥问候[03:18.13] 陪我爱天爱地的四处风流[03:22.12] 只是遗憾你终究[03:24.20] 无法躺在我胸口[03:27.06] 欣赏夜空最辽阔的不朽[03:30.54] 把星子放入眸[03:34.73] 你的指尖轻柔[03:36.91] 抚摸过我所有[03:39.15] 风浪冲撞出的丑陋疮口[03:43.03] 你眼中有春与秋[03:45.40] 胜过我见过爱过[03:47.78] 的一切山川与河流[03:51.98] 曾以为我肩头[03:53.90] 是那么的宽厚[03:55.92] 足够撑起海底那座琼楼[03:59.75] 而在你到来之后[04:02.09] 它显得如此清瘦[04:04.55] 我想给你能奔跑的岸头[04:08.20] 让你如同王后', '360', null, '1', '1', '第一次听，不是太有感觉', '2019-11-19 10:53:18', '1', 'Admin', 'Admin', '2019-11-19 09:43:47', '2019-11-19 09:43:53');
INSERT INTO `tb_music` VALUES ('3', '17621007255', '被驯服的象', '/beixunfudexiang', '蔡健雅', '[00:00.00]被驯服的象[00:04.64]蔡健雅[00:09.74][00:22.46]到底要笑得多虚伪　才能够融入这世界[00:28.13]每个人的脸上都像是贴了张一样的假面[00:33.71]想不起我在做什么　想不起我在想什么[00:39.12]想不起灵魂深处　到底发生了什么[00:43.95]迷雾 迷雾 在迷雾　我惊觉自己在原地踏步[00:49.03]到底是谁把我心蒙住　不想再糊涂[00:54.63]迷路 迷路 迷了路　我就彻底被这团迷雾困住[00:59.92]谁能够指引我一条路　带我走上正途[01:07.94][01:16.94]装不出融入的态度　空气里充斥着虚无[01:22.68]说什么都掩饰不了我这局外人的局促[01:28.21]想不通自己怎么了　想不通世界怎么了[01:33.61]想不通心灵深处　到底变成什么了[01:38.30]迷雾 迷雾 在迷雾　我惊觉自己在原地踏步[01:43.54]到底是谁把我心蒙住　不想再糊涂[01:49.24]迷路 迷路 迷了路　我就彻底被这团迷雾困住[01:54.46]谁能够指引我一条路　带我走上正途[02:00.34]掌声 若需要掌声　只要你愿当被驯服的象[02:08.16]这舞台你就可以上　荣耀 胜过被嘲笑[02:15.60]所以抛开自尊　咬紧牙根硬撑[02:21.92]迷雾 迷雾 在迷雾　我惊觉自己在原地踏步[02:27.11]到底是谁把我心蒙住　不想再糊涂[02:32.89]迷路 迷路 迷了路　我就彻底被这团迷雾困住[02:38.08]谁能够指引我一条路　带我走上正途[02:44.13]迷路 迷路 迷了路　我就彻底被这团迷雾困住[02:48.94]谁能够指引我一条路　带我走上正途[02:59.51]', '270', null, '1', '1', null, null, '1', 'Admin', 'Admin', '2019-11-19 09:45:13', '2019-11-19 09:45:16');

-- ----------------------------
-- Table structure for tb_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` text COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `user_id` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户ID',
  `nick_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `visits` int(11) DEFAULT 0 COMMENT '浏览量',
  `thumbup` int(11) DEFAULT 0 COMMENT '点赞数',
  `reply` int(11) DEFAULT 0 COMMENT '回复数',
  `solve` int(11) DEFAULT 1 COMMENT '是否解决 1 已解决 2 未解决',
  `reply_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '回复人昵称',
  `reply_time` datetime DEFAULT NULL COMMENT '回复日期',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除 1 未删除 2 已删除',
  `creator` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='问题信息表';

-- ----------------------------
-- Records of tb_question
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_info`;
CREATE TABLE `tb_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `head_image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户头像',
  `family_phone` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '家庭联系电话',
  `mobile` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户手机号',
  `password` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `age` int(11) DEFAULT NULL COMMENT '用户年龄',
  `birthday` datetime DEFAULT NULL COMMENT '用户生日',
  `gender` int(11) DEFAULT NULL COMMENT '用户性别 1 男 2 女 3 保密',
  `temporary_residence` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '暂住地',
  `permanent_residence` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '户口所在地',
  `work_residence` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工作所在地',
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电子邮件',
  `we_chat` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '微信',
  `qq` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '腾讯qq',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除 1 未删除 2 已删除',
  `creator` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of tb_user_info
-- ----------------------------
INSERT INTO `tb_user_info` VALUES ('1', '633990250171076608', '凤凰小哥哥', '凤凰小哥哥', 'http://www.baidu.com', '17621007255', '17621007255', 'q+OCvwWeY+WZnusw78zn1A==', '18', '1993-08-23 00:00:00', '1', '上海市松江区明丰公寓53号', '河南省商丘市民权县北关镇', '上海市静安区嘉里中心T1座', '17621007255@163.com', 'perttyboy1140867582', '1140867582', '1', 'Admin', 'Admin', '2019-10-16 11:30:54', '2019-11-12 19:30:21', null);
INSERT INTO `tb_user_info` VALUES ('2', '633990251546808320', '张洁', '小胖子凹凸曼', 'http://www.baidu.com', '18101820186', '18101820186', 'q+OCvwWeY+WZnusw78zn1A==', '32', '1993-08-23 00:00:00', '2', '上海市嘉定区', '江苏省淮安市', '未知', '17621007255@163.com', 'zJ368368000', '1140867582', '1', 'Admin', 'Admin', '2019-10-16 11:30:54', '2019-10-16 11:30:54', null);

-- ----------------------------
-- Table structure for tb_website_url
-- ----------------------------
DROP TABLE IF EXISTS `tb_website_url`;
CREATE TABLE `tb_website_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plate_id` int(11) DEFAULT NULL COMMENT '板块ID',
  `plate` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '板块',
  `parent_id` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '父级ID',
  `url_title` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'url名字',
  `url` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'url链接',
  `sort_id` int(11) DEFAULT NULL COMMENT '排序ID',
  `plate_delete` int(11) DEFAULT NULL COMMENT '板块是否删除 1 未删除 2 已删除',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除 1 未删除 2 已删除',
  `creator` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bxidhlpj4kuthqa2db06fhl7q` (`url_title`),
  UNIQUE KEY `UK_cms8a9r0q4thtvgr8ddmn2qlf` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='网站业务url信息表';

-- ----------------------------
-- Records of tb_website_url
-- ----------------------------
INSERT INTO `tb_website_url` VALUES ('1', '1', '我的主页', '1', '我的回答', '/my-answer', '1', '1', '1', 'Admin', 'Admin', '2019-11-13 18:22:48', '2019-11-13 18:22:48');
INSERT INTO `tb_website_url` VALUES ('2', '1', '我的主页', '1', '我的提问', '/my-questions', '2', '1', '1', 'Admin', 'Admin', '2019-11-13 18:22:48', '2019-11-13 18:22:48');
INSERT INTO `tb_website_url` VALUES ('3', '1', '我的主页', '1', '我的分享', '/my-shared', '3', '1', '1', 'Admin', 'Admin', '2019-11-13 18:22:48', '2019-11-13 18:22:48');
INSERT INTO `tb_website_url` VALUES ('4', '1', '我的主页', '1', '个人动态', '/personal-dynamics', '4', '1', '1', 'Admin', 'Admin', '2019-11-13 18:22:48', '2019-11-13 18:22:48');
INSERT INTO `tb_website_url` VALUES ('5', '1', '我的主页', '1', '我的关注', '/my-follow', '5', '1', '1', 'Admin', 'Admin', '2019-11-13 18:22:48', '2019-11-13 18:22:48');
INSERT INTO `tb_website_url` VALUES ('6', '1', '我的主页', '1', '我的收藏', '/my-collection', '6', '1', '1', 'Admin', 'Admin', '2019-11-13 18:22:48', '2019-11-13 18:22:48');
INSERT INTO `tb_website_url` VALUES ('7', '1', '我的主页', '1', '浏览记录', '/my-browse-record', '7', '1', '1', 'Admin', 'Admin', '2019-11-13 18:22:48', '2019-11-13 18:22:48');
INSERT INTO `tb_website_url` VALUES ('8', '1', '我的主页', '1', '账户设置', '/account-settings', '8', '1', '1', 'Admin', 'Admin', '2019-11-13 18:22:48', '2019-11-13 18:22:48');
INSERT INTO `tb_website_url` VALUES ('9', '2', '首页top left', '2', '头条', '/head-lines', '1', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('10', '2', '首页top left', '2', '问答', '/questions-and-answers', '2', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('11', '2', '首页top left', '2', '活动', '/activitys', '3', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('12', '2', '首页top left', '2', '吐槽', '/make-complaints', '4', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('13', '2', '首页top left', '2', '招聘', '/recruit', '5', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('14', '2', '首页top left', '2', '交友', '/make-friends', '6', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('15', '3', '首页top right', '3', '去分享', '/to-share', '1', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('16', '3', '首页top right', '3', '提问题', '/ask-questions', '2', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('17', '3', '首页top right', '3', '去吐槽', '/go-tucao', '3', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('18', '3', '首页top right', '3', '去约会', '/go-appointment', '4', '1', '1', 'Admin', 'Admin', null, null);
INSERT INTO `tb_website_url` VALUES ('19', '2', '首页top left', '2', '音乐', '/music', '7', '1', '1', 'Admin', 'Admin', null, null);
