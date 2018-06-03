# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: 47.104.214.164    Database: gcfd_portal
# ------------------------------------------------------
# Server version 5.6.39

DROP DATABASE IF EXISTS `gcfd_portal`;
CREATE DATABASE `gcfd_portal` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `gcfd_portal`;

#
# Source for table gcfd_api
#

DROP TABLE IF EXISTS `gcfd_api`;
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
# Dumping data for table gcfd_api
#

LOCK TABLES `gcfd_api` WRITE;
/*!40000 ALTER TABLE `gcfd_api` DISABLE KEYS */;
INSERT INTO `gcfd_api` VALUES (1,'1001','api1',X'',X'','development','1.2.3','','post',X'6468646866',X'',X'',X'',X'');
INSERT INTO `gcfd_api` VALUES (2,'1002','dfdf',X'646664666466',X'64666466','normal','1.23.1','dfdf','get',X'646664',X'646664',X'646664',X'646664',X'');
INSERT INTO `gcfd_api` VALUES (3,'1003','api3',X'',X'','release','1.2.3','','post',X'',X'',X'',X'',X'');
/*!40000 ALTER TABLE `gcfd_api` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table gcfd_app
#

DROP TABLE IF EXISTS `gcfd_app`;
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
# Dumping data for table gcfd_app
#

LOCK TABLES `gcfd_app` WRITE;
/*!40000 ALTER TABLE `gcfd_app` DISABLE KEYS */;
INSERT INTO `gcfd_app` VALUES (1,'1001','baidu',X'E6B58BE8AF95',X'686168','release','1.2.3','upload/1525011404547baidu.png',X'7777772E62616964752E636F6D');
INSERT INTO `gcfd_app` VALUES (2,'1002','qq',X'E59388E59388',X'','normal','2.1.1','upload/1525011499446qq.png',X'7777772E71712E636F6D');
INSERT INTO `gcfd_app` VALUES (3,'1003','xinliang',X'E5A4A7E5A4A7E696B9E696B9',X'','development','2.12.1','upload/1525011559003xinlang.png',X'7777772E73696E612E636F6D');
INSERT INTO `gcfd_app` VALUES (4,'1234','haha',X'646664666466',X'64666466','release','1.2.3','upload/1524556464076123.jpg',X'64666466');
INSERT INTO `gcfd_app` VALUES (5,'1236','addf',X'64666466',X'6466','normal','10','upload/1524556566906123.jpg',X'646664');
INSERT INTO `gcfd_app` VALUES (6,'1005','hao123',X'64666466',X'64666466','release','1.23','upload/1525012123610hao.png',X'7777772E68616F3132332E636F6D');
/*!40000 ALTER TABLE `gcfd_app` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table gcfd_auth
#

DROP TABLE IF EXISTS `gcfd_auth`;
CREATE TABLE `gcfd_auth` (
  `group_id` int(11) NOT NULL COMMENT '组ID',
  `app_id` int(11) NOT NULL COMMENT '应用ID',
  `api_id` int(11) NOT NULL COMMENT 'apiID',
  PRIMARY KEY (`group_id`,`app_id`,`api_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='授权表';

#
# Dumping data for table gcfd_auth
#

LOCK TABLES `gcfd_auth` WRITE;
/*!40000 ALTER TABLE `gcfd_auth` DISABLE KEYS */;
INSERT INTO `gcfd_auth` VALUES (1,1,1);
INSERT INTO `gcfd_auth` VALUES (4,6,2);
INSERT INTO `gcfd_auth` VALUES (4,6,3);
INSERT INTO `gcfd_auth` VALUES (5,1,1);
INSERT INTO `gcfd_auth` VALUES (5,1,2);
/*!40000 ALTER TABLE `gcfd_auth` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table gcfd_branch
#

DROP TABLE IF EXISTS `gcfd_branch`;
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
# Dumping data for table gcfd_branch
#

LOCK TABLES `gcfd_branch` WRITE;
/*!40000 ALTER TABLE `gcfd_branch` DISABLE KEYS */;
INSERT INTO `gcfd_branch` VALUES (1,'001','百度','百度',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'');
INSERT INTO `gcfd_branch` VALUES (2,'002','新浪新闻','新浪',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'');
INSERT INTO `gcfd_branch` VALUES (3,'003','腾讯视频','腾讯',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'');
INSERT INTO `gcfd_branch` VALUES (4,'004','亚马逊','亚马逊',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'');
/*!40000 ALTER TABLE `gcfd_branch` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table gcfd_data_source
#

DROP TABLE IF EXISTS `gcfd_data_source`;
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
# Dumping data for table gcfd_data_source
#

LOCK TABLES `gcfd_data_source` WRITE;
/*!40000 ALTER TABLE `gcfd_data_source` DISABLE KEYS */;
INSERT INTO `gcfd_data_source` VALUES (1,'sina.com','dfasdf','asdfas','asdf','use',NULL);
INSERT INTO `gcfd_data_source` VALUES (2,'baidu.com','baidu','baidu','dfdfdf','use',NULL);
/*!40000 ALTER TABLE `gcfd_data_source` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table gcfd_group
#

DROP TABLE IF EXISTS `gcfd_group`;
CREATE TABLE `gcfd_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组ID',
  `group_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '组名称',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限组表';

#
# Dumping data for table gcfd_group
#

LOCK TABLES `gcfd_group` WRITE;
/*!40000 ALTER TABLE `gcfd_group` DISABLE KEYS */;
INSERT INTO `gcfd_group` VALUES (1,'A缁?');
INSERT INTO `gcfd_group` VALUES (2,'B缁?');
INSERT INTO `gcfd_group` VALUES (3,'C缁?');
INSERT INTO `gcfd_group` VALUES (4,'D缁?');
INSERT INTO `gcfd_group` VALUES (5,'E缁?');
/*!40000 ALTER TABLE `gcfd_group` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table gcfd_group_rel
#

DROP TABLE IF EXISTS `gcfd_group_rel`;
CREATE TABLE `gcfd_group_rel` (
  `group_id` int(11) NOT NULL COMMENT '组ID',
  `authorize_group_id` int(11) NOT NULL COMMENT '可授权ID',
  PRIMARY KEY (`group_id`,`authorize_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='组授权表';

#
# Dumping data for table gcfd_group_rel
#

LOCK TABLES `gcfd_group_rel` WRITE;
/*!40000 ALTER TABLE `gcfd_group_rel` DISABLE KEYS */;
INSERT INTO `gcfd_group_rel` VALUES (1,4);
INSERT INTO `gcfd_group_rel` VALUES (1,5);
/*!40000 ALTER TABLE `gcfd_group_rel` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table gcfd_scence
#

DROP TABLE IF EXISTS `gcfd_scence`;
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
# Dumping data for table gcfd_scence
#

LOCK TABLES `gcfd_scence` WRITE;
/*!40000 ALTER TABLE `gcfd_scence` DISABLE KEYS */;
INSERT INTO `gcfd_scence` VALUES (1,'0001','鍦烘櫙1',X'E5A487E6B3A8',X'E8A2AB','release','澶у箙搴﹀彂',X'E5A4A7E5B985E5BAA6E58F91',X'E5A4A7E5B985E5BAA6');
INSERT INTO `gcfd_scence` VALUES (2,'3322','dfdfdd',X'686A686A',X'686A686A','normal','1.9',X'75706C6F61642F31353236313333393331303437313239383433393838372E6A7067',X'686A68');
/*!40000 ALTER TABLE `gcfd_scence` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table gcfd_user
#

DROP TABLE IF EXISTS `gcfd_user`;
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
# Dumping data for table gcfd_user
#

LOCK TABLES `gcfd_user` WRITE;
/*!40000 ALTER TABLE `gcfd_user` DISABLE KEYS */;
INSERT INTO `gcfd_user` VALUES ('001','wenwen','RYwpT+Mvi3zt7CMLxjM6bA==',0,'15010491957','wgx521@139.com','001');
INSERT INTO `gcfd_user` VALUES ('002','sbc','abc',0,NULL,NULL,'002');
INSERT INTO `gcfd_user` VALUES ('0BD4FB9B-3972-4AD7-96C7-EBC1A09F6755','wen','R60gr24kzOzTJxT/br/eOg==',1,'13439576827','wgx521@139.com','003');
INSERT INTO `gcfd_user` VALUES ('4A27DB02-D325-4B79-875A-0129A42F8F9B','wenwenwen','fRE67aJvoezuqngNFTF5tw==',2,NULL,NULL,'002');
INSERT INTO `gcfd_user` VALUES ('738D9707-949C-40A6-855D-637973E63338','wgx','bhJXQIVfnIpMM1CYuW3ugA==',2,'15010392541','1@13.com','002');
INSERT INTO `gcfd_user` VALUES ('A8A6CDE6-5201-4159-8B96-C53DCA028C25','wgx521','wdSa9rJxFX7mdyhHyUrxeQ==',2,'15010491957','wgx521@139.com','004');
INSERT INTO `gcfd_user` VALUES ('C180373D-334A-446E-A126-747FC1A8AC04','wgx5210','fRE67aJvoezuqngNFTF5tw==',2,'15010498521','1@123.com','002');
INSERT INTO `gcfd_user` VALUES ('C7593EE5-4F4F-4A2C-BFB6-6232573097D2','dffdf','wdSa9rJxFX7mdyhHyUrxeQ==',2,NULL,NULL,'001');
/*!40000 ALTER TABLE `gcfd_user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table gcfd_user_group_rel
#

DROP TABLE IF EXISTS `gcfd_user_group_rel`;
CREATE TABLE `gcfd_user_group_rel` (
  `user_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `group_id` int(11) NOT NULL COMMENT '组ID',
  PRIMARY KEY (`user_id`,`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户组关系表';

#
# Dumping data for table gcfd_user_group_rel
#

LOCK TABLES `gcfd_user_group_rel` WRITE;
/*!40000 ALTER TABLE `gcfd_user_group_rel` DISABLE KEYS */;
INSERT INTO `gcfd_user_group_rel` VALUES ('001',1);
INSERT INTO `gcfd_user_group_rel` VALUES ('C180373D-334A-446E-A126-747FC1A8AC04',1);
INSERT INTO `gcfd_user_group_rel` VALUES ('C180373D-334A-446E-A126-747FC1A8AC04',2);
INSERT INTO `gcfd_user_group_rel` VALUES ('C180373D-334A-446E-A126-747FC1A8AC04',3);
INSERT INTO `gcfd_user_group_rel` VALUES ('C180373D-334A-446E-A126-747FC1A8AC04',4);
INSERT INTO `gcfd_user_group_rel` VALUES ('C180373D-334A-446E-A126-747FC1A8AC04',5);
/*!40000 ALTER TABLE `gcfd_user_group_rel` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
