# Host: 47.104.214.164  (Version 5.6.39)
# Date: 2018-05-03 11:38:19
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "gcfd_api"
#

CREATE TABLE `gcfd_api` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `api_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'api编号',
  `api_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'API名称',
  `api_bref_desc` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT 'API简述',
  `api_desc` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT 'API描述',
  `status` enum('normal','release','planning','development','abandoned') COLLATE utf8_bin DEFAULT NULL COMMENT 'API接口状态（正常，发布，规划，开发中，废弃）',
  `version` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '版本号',
  `access_token` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '访问令牌',
  `api_access_type` enum('get','post') COLLATE utf8_bin DEFAULT NULL COMMENT '接口访问方式',
  `api_url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '接口地址',
  `api_request_parameters` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '请求参数',
  `api_request_parameters_memo` varchar(2048) COLLATE utf8_bin DEFAULT NULL COMMENT '参数说明',
  `api_reponse_data` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT 'api返回结果',
  `api_reponse_data_memo` varchar(2048) COLLATE utf8_bin DEFAULT NULL COMMENT '返回结果说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='API基础表';

#
# Data for table "gcfd_api"
#

INSERT INTO `gcfd_api` VALUES (1,'1001','api1','','','development','1.2.3','','post','dhdhf','','','',''),(2,'1002','dfdf','dfdfdf','dfdf','normal','1.23.1','dfdf','get','dfd','dfd','dfd','dfd',''),(3,'1003','api3','','','release','1.2.3','','post','','','','','');

#
# Structure for table "gcfd_app"
#

CREATE TABLE `gcfd_app` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '应用ID',
  `app_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '应用名称',
  `app_bref_desc` varchar(512) COLLATE utf8_bin NOT NULL COMMENT '应用简述',
  `app_desc` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '应用描述',
  `status` enum('normal','release',' planning','development','abandoned') COLLATE utf8_bin NOT NULL COMMENT '应用状态（正常，发布，规划，开发中，废弃）',
  `version` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '版本号',
  `icon` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '应用图标',
  `app_url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT 'app入口地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='应用基础表';

#
# Data for table "gcfd_app"
#

INSERT INTO `gcfd_app` VALUES (1,'1001','baidu','测试','hah','release','1.2.3','upload/1525011404547baidu.png','www.baidu.com'),(2,'1002','qq','哈哈','','normal','2.1.1','upload/1525011499446qq.png','www.qq.com'),(3,'1003','xinliang','大大方方','','development','2.12.1','upload/1525011559003xinlang.png','www.sina.com'),(4,'1234','haha','dfdfdf','dfdf','release','1.2.3','upload/1524556464076123.jpg','dfdf'),(5,'1236','addf','dfdf','df','normal','10','upload/1524556566906123.jpg','dfd'),(6,'1005','hao123','dfdf','dfdf','release','1.23','upload/1525012123610hao.png','www.hao123.com');

#
# Structure for table "gcfd_auth"
#

CREATE TABLE `gcfd_auth` (
  `group_id` int(11) NOT NULL COMMENT '组ID',
  `app_id` int(11) NOT NULL COMMENT '应用ID',
  `api_id` int(11) NOT NULL COMMENT 'apiID',
  PRIMARY KEY (`group_id`,`app_id`,`api_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='授权表';

#
# Data for table "gcfd_auth"
#

INSERT INTO `gcfd_auth` VALUES (1,1,1),(1,2,1),(1,3,1);

#
# Structure for table "gcfd_data_source"
#

CREATE TABLE `gcfd_data_source` (
  `data_source_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数据源ID',
  `data_source_url` varchar(128) DEFAULT NULL COMMENT '数据源url',
  `data_source_user_name` varchar(64) DEFAULT NULL COMMENT '数据源用户名',
  `data_source_user_pwd` varchar(128) DEFAULT NULL COMMENT '数据源密码',
  `data_source_desc` varchar(256) DEFAULT NULL COMMENT '数据源描述',
  `data_source_status` enum('use','free') DEFAULT NULL COMMENT '数据源状态',
  PRIMARY KEY (`data_source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='数据源基础表';

#
# Data for table "gcfd_data_source"
#

INSERT INTO `gcfd_data_source` VALUES (1,'sina.com','dfasdf','asdfas','asdf','use'),(2,'baidu.com','baidu','baidu','dfdfdf','use');

#
# Structure for table "gcfd_group"
#

CREATE TABLE `gcfd_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组ID',
  `group_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '组名称',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限组表';

#
# Data for table "gcfd_group"
#

INSERT INTO `gcfd_group` VALUES (1,'A组'),(2,'B组'),(3,'C组'),(4,'D组'),(5,'E组');

#
# Structure for table "gcfd_group_rel"
#

CREATE TABLE `gcfd_group_rel` (
  `group_id` int(11) NOT NULL COMMENT '组ID',
  `authorize_group_id` int(11) NOT NULL COMMENT '可授权ID',
  PRIMARY KEY (`group_id`,`authorize_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='组授权表';

#
# Data for table "gcfd_group_rel"
#

INSERT INTO `gcfd_group_rel` VALUES (2,3),(2,4),(4,3),(5,3),(5,4);

#
# Structure for table "gcfd_scence"
#

CREATE TABLE `gcfd_scence` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `scence_id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '场景ID',
  `scence_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '场景名称',
  `scence_bref_desc` varchar(512) COLLATE utf8_bin NOT NULL COMMENT '场景简述',
  `scence_desc` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '场景描述',
  `status` enum('normal','release',' planning','development','abandoned') COLLATE utf8_bin NOT NULL COMMENT '场景状态（正常，发布，规划，开发中，废弃）',
  `version` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '版本号',
  `icon` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '场景图标',
  `scence_url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '场景入口地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='场景基础表';

#
# Data for table "gcfd_scence"
#


#
# Structure for table "gcfd_scence_data_rel"
#

CREATE TABLE `gcfd_scence_data_rel` (
  `scence_id` int(11) NOT NULL COMMENT '场景ID',
  `data_source_id` int(11) NOT NULL COMMENT '数据源ID',
  PRIMARY KEY (`scence_id`,`data_source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='场景数据源关系表';

#
# Data for table "gcfd_scence_data_rel"
#


#
# Structure for table "gcfd_user"
#

CREATE TABLE `gcfd_user` (
  `user_id` varchar(36) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户名（只使用手机号登录）',
  `user_name` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `user_pwd` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'MD5加密密码串',
  `user_sign` int(1) NOT NULL DEFAULT '0' COMMENT '用户标示串',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

#
# Data for table "gcfd_user"
#

INSERT INTO `gcfd_user` VALUES ('001','wenwen','RYwpT+Mvi3zt7CMLxjM6bA==',0),('002','sbc','abc',0),('0BD4FB9B-3972-4AD7-96C7-EBC1A09F6755','wen','fRE67aJvoezuqngNFTF5tw==',1);

#
# Structure for table "gcfd_user_app_data_rel"
#

CREATE TABLE `gcfd_user_app_data_rel` (
  `user_id` varchar(36) NOT NULL COMMENT '用户ID',
  `app_id` int(11) NOT NULL COMMENT '应用ID',
  `data_source_id` int(11) NOT NULL COMMENT '数据源ID',
  PRIMARY KEY (`user_id`,`app_id`,`data_source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户应用数据源关系表';

#
# Data for table "gcfd_user_app_data_rel"
#


#
# Structure for table "gcfd_user_group_rel"
#

CREATE TABLE `gcfd_user_group_rel` (
  `user_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `group_id` int(11) NOT NULL COMMENT '组ID',
  PRIMARY KEY (`user_id`,`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户组关系表';

#
# Data for table "gcfd_user_group_rel"
#

INSERT INTO `gcfd_user_group_rel` VALUES ('001',1);
