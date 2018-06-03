# Host: 47.104.214.164  (Version 5.6.39)
# Date: 2018-05-14 18:03:51
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
  `icon` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '应用图标',
  `app_url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT 'app入口地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='应用基础表';

#
# Data for table "gcfd_app"
#

INSERT INTO `gcfd_app` VALUES (1,'1001','baidu','百度','百度','release','1.2.3','upload/1526291061746baidu.png','http://www.baidu.com'),(2,'1002','qq','腾讯','','normal','2.1.1','upload/1526291178779aa.png','http://www.qq.com'),(3,'1003','xinliang','新浪','','development','2.12.1','upload/1526291396610sina.png','http://www.sina.com'),(4,'3214','淘宝','淘宝网','dfdf','release','1.2.3','upload/1526291490014taobao.png','https://www.taobao.com'),(5,'1236','addf','携程网','携程','release','10.32','upload/1526292026549xc.png','http://www.ctrip.com'),(6,'1005','hao123','好123','dfdf','release','1.23','upload/1526291858858123.png','http://www.hao123.com');

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

INSERT INTO `gcfd_auth` VALUES (1,1,1),(1,1,2),(4,6,2),(4,6,3),(5,1,1),(5,1,2),(5,2,1);

#
# Structure for table "gcfd_branch"
#

CREATE TABLE `gcfd_branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构ID',
  `branch_id` varchar(64) DEFAULT NULL COMMENT '机构编号',
  `branch_name` varchar(256) DEFAULT NULL COMMENT '机构名称',
  `branch_short_name` varchar(128) DEFAULT NULL COMMENT '机构地址',
  `branch_addr` varchar(256) DEFAULT NULL,
  `branch_no` varchar(64) DEFAULT NULL COMMENT '组织统一社会信用代码',
  `branch_contacts` varchar(16) DEFAULT NULL COMMENT '联系人',
  `branch_contacts_phone` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `memo` varchar(1024) DEFAULT NULL COMMENT '备注',
  `branch_pic` varchar(64) DEFAULT NULL,
  `branch_desc` varchar(2048) DEFAULT NULL,
  `is_del` char(1) DEFAULT '' COMMENT '是否删除 T是 F否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "gcfd_branch"
#

INSERT INTO `gcfd_branch` VALUES (1,'001','百度','百度',NULL,NULL,NULL,NULL,NULL,NULL,NULL,''),(2,'002','新浪新闻','新浪',NULL,NULL,NULL,NULL,NULL,NULL,NULL,''),(3,'003','腾讯视频','腾讯',NULL,NULL,NULL,NULL,NULL,NULL,NULL,''),(4,'004','亚马逊','亚马逊',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'');

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
  `branch_id` varchar(64) DEFAULT NULL COMMENT '机构ID',
  PRIMARY KEY (`data_source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='数据源基础表';

#
# Data for table "gcfd_data_source"
#

INSERT INTO `gcfd_data_source` VALUES (1,'sina.com','dfasdf','asdfas','asdf','use',NULL),(2,'baidu.com','baidu','baidu','dfdfdf','use',NULL);

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

INSERT INTO `gcfd_group_rel` VALUES (1,4),(1,5);

#
# Structure for table "gcfd_scence"
#

CREATE TABLE `gcfd_scence` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `scence_id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '场景ID',
  `scence_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '场景名称',
  `scence_bref_desc` varchar(512) COLLATE utf8_bin NOT NULL COMMENT '场景简述',
  `scence_desc` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '场景描述',
  `status` enum('normal','release','planning','development','abandoned') COLLATE utf8_bin NOT NULL COMMENT '场景状态（正常，发布，规划，开发中，废弃）',
  `version` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '版本号',
  `icon` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '场景图标',
  `scence_url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '场景入口地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='场景基础表';

#
# Data for table "gcfd_scence"
#

INSERT INTO `gcfd_scence` VALUES (1,'0001','场景1','备注','被','release','大幅度发','大幅度发','大幅度'),(2,'3322','dfdfdd','hjhj','hjhj','normal','1.9','upload/15261339310471298439887.jpg','hjh');

#
# Structure for table "gcfd_user"
#

CREATE TABLE `gcfd_user` (
  `user_id` varchar(36) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户名（只使用手机号登录）',
  `user_name` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `user_pwd` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'MD5加密密码串',
  `user_status` int(1) NOT NULL DEFAULT '0' COMMENT '用户标示串',
  `user_tel` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '用户电话号码',
  `user_email` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '用户电子邮件地址',
  `branch_id` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

#
# Data for table "gcfd_user"
#

INSERT INTO `gcfd_user` VALUES ('001','wenwen','RYwpT+Mvi3zt7CMLxjM6bA==',0,'15010491957','wgx521@139.com','001'),('002','sbc','abc',0,NULL,NULL,'002'),('0BCEAB6D-D415-44E2-ACB8-EBA083A31AF0','admin','u62NcsH6wdCBcnFYgHqHmA==',0,'18988989898','aaaa@163.com','001'),('0BD4FB9B-3972-4AD7-96C7-EBC1A09F6755','wen','R60gr24kzOzTJxT/br/eOg==',1,'13439576827','wgx521@139.com','003'),('4A27DB02-D325-4B79-875A-0129A42F8F9B','wenwenwen','fRE67aJvoezuqngNFTF5tw==',2,NULL,NULL,'002'),('738D9707-949C-40A6-855D-637973E63338','wgx','bhJXQIVfnIpMM1CYuW3ugA==',2,'15010392541','1@13.com','002'),('A8A6CDE6-5201-4159-8B96-C53DCA028C25','wgx521','wdSa9rJxFX7mdyhHyUrxeQ==',2,'15010491957','wgx521@139.com','004'),('C180373D-334A-446E-A126-747FC1A8AC04','wgx5210','fRE67aJvoezuqngNFTF5tw==',2,'15010498521','1@123.com','002'),('C7593EE5-4F4F-4A2C-BFB6-6232573097D2','dffdf','wdSa9rJxFX7mdyhHyUrxeQ==',2,NULL,NULL,'001');

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

INSERT INTO `gcfd_user_group_rel` VALUES ('001',1),('C180373D-334A-446E-A126-747FC1A8AC04',1),('C180373D-334A-446E-A126-747FC1A8AC04',2),('C180373D-334A-446E-A126-747FC1A8AC04',3),('C180373D-334A-446E-A126-747FC1A8AC04',4),('C180373D-334A-446E-A126-747FC1A8AC04',5);
