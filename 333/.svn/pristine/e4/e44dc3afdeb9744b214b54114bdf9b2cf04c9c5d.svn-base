# Host: 47.104.214.164  (Version 5.6.39)
# Date: 2018-04-23 10:09:57
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
  `status` enum('normal','release',' planning','development','abandoned') COLLATE utf8_bin DEFAULT NULL COMMENT 'API接口状态（正常，发布，规划，开发中，废弃）',
  `version` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '版本号',
  `access_token` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '访问令牌',
  `api_access_type` enum('get','post') COLLATE utf8_bin DEFAULT NULL COMMENT '接口访问方式',
  `api_url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '接口地址',
  `api_request_parameters` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '请求参数',
  `api_request_parameters_memo` varchar(2048) COLLATE utf8_bin DEFAULT NULL COMMENT '参数说明',
  `api_reponse_data` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT 'api返回结果',
  `api_reponse_data_memo` varchar(2048) COLLATE utf8_bin DEFAULT NULL COMMENT '返回结果说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='API基础表';

#
# Data for table "gcfd_api"
#


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='应用基础表';

#
# Data for table "gcfd_app"
#


#
# Structure for table "gcfd_auth"
#

CREATE TABLE `gcfd_auth` (
  `group_id` int(11) NOT NULL COMMENT '组ID',
  `app_id` int(11) NOT NULL COMMENT '应用ID',
  `api_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`group_id`,`app_id`,`api_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='授权表';

#
# Data for table "gcfd_auth"
#


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据源基础表';

#
# Data for table "gcfd_data_source"
#


#
# Structure for table "gcfd_group"
#

CREATE TABLE `gcfd_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组ID',
  `group_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '组名称',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限组表';

#
# Data for table "gcfd_group"
#


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
  `user_id` char(11) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户名（只使用手机号登录）',
  `user_pwd` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT 'MD5加密密码串',
  `user_sign` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '用户标示串',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

#
# Data for table "gcfd_user"
#

INSERT INTO `gcfd_user` VALUES ('1','123','123'),('2','123234','234235dfg');

#
# Structure for table "gcfd_user_app_data_rel"
#

CREATE TABLE `gcfd_user_app_data_rel` (
  `user_id` char(13) NOT NULL COMMENT '用户ID',
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
  `user_id` char(13) COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `group_id` int(11) NOT NULL COMMENT '组ID',
  PRIMARY KEY (`user_id`,`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户组关系表';

#
# Data for table "gcfd_user_group_rel"
#

