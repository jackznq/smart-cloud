
set character set utf8;
-- 创建数据库
create database `home_work` default character set utf8 collate utf8_general_ci;

use `home_work`;

SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `attachment` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '附件原始名字',
  `size` varchar(45) NOT NULL COMMENT '附件大小',
  `class_name` varchar(100) NOT NULL COMMENT '附件对应的model的class name',
  `data_id` bigint(12) DEFAULT NULL COMMENT '业务数据ID',
  `type` varchar(45) NOT NULL COMMENT '附件类型',
  `bucket` varchar(100) DEFAULT NULL,
  `key` varchar(45) DEFAULT NULL,
  `upload_id` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `class_info` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) NOT NULL COMMENT '班级名称',
  `school_name` varchar(45) NOT NULL COMMENT '学校名称',
  `contact_tel` varchar(20) NOT NULL COMMENT '创建班级的用户的联系电话',
  `location` varchar(100) NOT NULL COMMENT '班级所在的省市信息，如：浙江省-杭州市/江苏省-南京市',
  `student_num` int(3) NOT NULL COMMENT '班级的学生人数',
  `creator_id` bigint(12) NOT NULL COMMENT '班级创建人的ID，首个创建班级的用户为班级管理员',
  `create_time` datetime NOT NULL,
  `class_status` int(1) NOT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '班级状态：1 有效 0 无效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `class_student_list` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(45) NOT NULL COMMENT '学生姓名',
  `student_no` varchar(20) NOT NULL COMMENT '学号',
  `class_id` bigint(12) NOT NULL COMMENT '班级ID',
  `creator_id` bigint(12) NOT NULL COMMENT '学生信息登记人的id',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `group_info` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(45) NOT NULL COMMENT '小组名称',
  `group_status` int(1) NOT NULL COMMENT '小组状态 :1 正常 0:停用 ',
  `creator_id` bigint(12) NOT NULL COMMENT '小组创建人的ID',
  `class_id` bigint(12) NOT NULL COMMENT '班级id',
  `create_time` datetime NOT NULL COMMENT '小组信息表',
  `update_time` datetime DEFAULT NULL COMMENT '小组所在的班级ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `group_member` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '小组成员表',
  `group_id` bigint(12) NOT NULL COMMENT '小组ID',
  `student_id` bigint(12) NOT NULL COMMENT '学生信息表 关联 class_student_list 的id',
  `class_id` bigint(12) NOT NULL COMMENT '班级ID',
  `create_time` datetime NOT NULL,
  `creator_id` bigint(12) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `item_member` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `work_item_id` bigint(12) NOT NULL COMMENT '作业ID 关联work_item表',
  `class_id` bigint(12) DEFAULT NULL COMMENT '班级id 关联 class_info',
  `group_id` bigint(12) DEFAULT NULL COMMENT '小组id 关联group_info',
  `student_id` bigint(12) DEFAULT NULL COMMENT '学生id 关联class_student_list',
  `user_id` bigint(12) DEFAULT NULL COMMENT '当前登录用户的id',
  `submit_state` int(1) DEFAULT NULL COMMENT '作业状态：0 未提交 1 已提交',
  `submit_date` datetime DEFAULT NULL COMMENT '提交日期',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `work_item` (
  `id` bigint(12) NOT NULL,
  `subject` varchar(45) NOT NULL COMMENT '科目',
  `submit_date` datetime NOT NULL COMMENT '提交日期',
  `date_desc` varchar(45) DEFAULT NULL COMMENT '日期描述',
  `confirm_type` varchar(20) DEFAULT NULL COMMENT '确认方式：签名确认、拍照确认、语音确认、视频确认',
  `score_type` varchar(40) DEFAULT NULL COMMENT '评分制：等第制、十分制、百分制',
  `detail` varchar(1000) DEFAULT NULL COMMENT '详细描述',
  `release` int(1) DEFAULT NULL COMMENT '是否发布到班级或小组中',
  `work_type` int(1) DEFAULT NULL COMMENT '作业类型：0 班级作业 1 小组作业',
  `creator_id` bigint(12) NOT NULL COMMENT '作业发布人的ID',
  `create_time` datetime NOT NULL,
  `state` int(1) NOT NULL COMMENT '状态:0 无效 1: 有效',
  `update_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;