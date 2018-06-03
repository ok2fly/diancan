# Host: 47.104.214.164  (Version 5.6.39)
# Date: 2018-05-15 16:48:13
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
  `api_request_parameters_memo` varchar(4096) COLLATE utf8_bin DEFAULT NULL COMMENT '参数说明',
  `api_reponse_data` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT 'api返回结果',
  `api_reponse_data_memo` varchar(4096) COLLATE utf8_bin DEFAULT NULL COMMENT '返回结果说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='API基础表';

#
# Data for table "gcfd_api"
#

INSERT INTO `gcfd_api` VALUES (1,'API-SCR-SCENCE-COUSUME-001','获取机构和餐桌信息','获取机构和餐桌信息','','development','1.0','','get','/service/scr/scence/consume/getBranchAndTableInfo/{branchId}/{tableNo}','branchId：机构编号\r\ntableNo：桌编号','示例：\r\nbranchId：B001 \r\ntableNo: 5c6a2f1571ef4208ba6a6621e392d08a\r\n','机构信息和桌信息','示例：\r\n{\"pagerCount\":1,\"pageNum\":1,\"rowCount\":0,\"pageSize\":20,\"pageStart\":0,\"netCode\":\"Q1001\",\"netMessage\":\"查询成功\",\"data\":{\"branch\":{\"id\":1,\"branchId\":\"B001\",\"branchName\":\"测试商户姓名\",\"branchShortName\":\"测试商户简称\",\"branchAddr\":\"测试商户地址\",\"branchNo\":\"测试商户工商编号\",\"branchContacts\":\"联系人\",\"branchContactsPhone\":\"联系电话\",\"memo\":\"备注\",\"branchPic\":\"机构图片\",\"branchDesc\":\"机构描述\"},\"table\":{\"id\":1,\"tableName\":\"VIP888\",\"tableCode\":\"5c6a2f1571ef4208ba6a6621e392d08a\",\"seq\":1,\"createUserId\":\"1001\",\"createTime\":1525798872000,\"lstModifyUserId\":null,\"lstModifyTime\":null,\"isDel\":\"F\",\"branchId\":\"B001\"}}}'),(2,'API-SCR-SCENCE-COUSUME-002','获取机构的活动信息','获取机构的活动信息','','normal','1.0','','get','/service/scr/scence/consume/getBranchActivityInfo/{branchId}','branchId：机构编号','示例：\r\nbranchId：B001','机构活动信息','示例：\r\n{\"pagerCount\":1,\"pageNum\":1,\"rowCount\":0,\"pageSize\":20,\"pageStart\":0,\"netCode\":\"Q1001\",\"netMessage\":\"查询成功\",\"data\":[{\"id\":1,\"activityName\":\"活动1\",\"startTime\":1523808000000,\"endTime\":1527085971000,\"createUserId\":null,\"createTime\":1524535542000,\"lstModifyUserId\":null,\"lstModifyTime\":1524535542000,\"isDel\":\"F\",\"branchId\":\"B001\",\"activityType\":\"1\",\"activityTypeName\":\"菜品特价\"},{\"id\":2,\"activityName\":\"活动2\",\"startTime\":1522679600000,\"endTime\":1527604404000,\"createUserId\":null,\"createTime\":1524535545000,\"lstModifyUserId\":null,\"lstModifyTime\":1524535545000,\"isDel\":\"F\",\"branchId\":\"B001\",\"activityType\":\"2\",\"activityTypeName\":\"订单折扣\"}]}'),(3,'API-SCR-SCENCE-COUSUME-003','获取用户标示和订单','获取用户标示和订单','','normal','1.0','','get','/service/scr/scence/consume/getUserSignAndOrderInfo/{branchId}/{tableNo}','branchId：机构编号\r\ntableNo：桌号','示例：\r\nbranchId：B001 \r\ntableNo: 5c6a2f1571ef4208ba6a6621e392d08a\r\n','用户标示和订单信息','示例：{\"pagerCount\":1,\"pageNum\":1,\"rowCount\":0,\"pageSize\":20,\"pageStart\":0,\"netCode\":\"Q1001\",\"netMessage\":\"查询成功\",\"data\":{\"userSign\":\"userSign\",\"order\":{\"id\":6,\"orderNo\":\"201805131430561193\",\"branchId\":\"B001\",\"clientId\":\"userSign\",\"orderType\":\"1\",\"total\":45.25,\"orderStatus\":\"1\",\"endTime\":null,\"parentId\":null,\"createUserId\":null,\"createTime\":1526193058000,\"lstModifyUserId\":null,\"lstModifyTime\":null,\"isDel\":\"F\",\"tableName\":null,\"productName\":null,\"memo\":null,\"amount\":0},\"orderDispatching\":{\"id\":14,\"orderNo\":\"201805131430561193\",\"clientId\":\"userSign\",\"clientName\":null,\"clientPhone\":null,\"clientAddr\":null,\"createUserId\":null,\"createTime\":1526193056000,\"lstModifyUserId\":null,\"lstModifyTime\":null,\"isDel\":\"F\",\"tableCode\":\"5c6a2f1571ef4208ba6a6621e392d08a\",\"tableName\":\"VIP888\"},\"orderPayInfo\":null,\"orderProductDetailList\":[{\"id\":20,\"orderNo\":\"201805131430561193\",\"productId\":1,\"productNo\":\"P001\",\"productName\":\"测试产品1\",\"origPrice\":20.00,\"amount\":1,\"specPrice\":10.00,\"realTotal\":10.00,\"createUserId\":null,\"createTime\":1526193056000,\"lstModifyUserId\":null,\"lstModifyTime\":null,\"isDel\":\"F\",\"isPreferentialInOrder\":null},{\"id\":21,\"orderNo\":\"201805131430561193\",\"productId\":1,\"productNo\":\"P001\",\"productName\":\"测试产品1\",\"origPrice\":20.00,\"amount\":1,\"specPrice\":15.00,\"realTotal\":15.00,\"createUserId\":null,\"createTime\":1526193057000,\"lstModifyUserId\":null,\"lstModifyTime\":null,\"isDel\":\"F\",\"isPreferentialInOrder\":null},{\"id\":22,\"orderNo\":\"201805131430561193\",\"productId\":2,\"productNo\":\"P002\",\"productName\":\"测试产品2\",\"origPrice\":30.00,\"amount\":1,\"specPrice\":30.00,\"realTotal\":30.00,\"createUserId\":null,\"createTime\":1526193057000,\"lstModifyUserId\":null,\"lstModifyTime\":null,\"isDel\":\"F\",\"isPreferentialInOrder\":null}],\"orderFeeDetailList\":[{\"id\":7,\"orderNo\":\"201805131430561193\",\"feeId\":1,\"feeName\":\"餐具费\",\"amount\":3,\"origPrice\":1.00,\"specPrice\":1.00,\"realTotal\":3.00,\"createUserId\":null,\"createTime\":null,\"lstModifyUserId\":null,\"lstModifyTime\":null,\"isDel\":\"F\",\"feeNo\":\"F001\"},{\"id\":8,\"orderNo\":\"201805131430561193\",\"feeId\":2,\"feeName\":\"订单折扣\",\"amount\":1,\"origPrice\":-12.75,\"specPrice\":-12.75,\"realTotal\":-12.75,\"createUserId\":null,\"createTime\":null,\"lstModifyUserId\":null,\"lstModifyTime\":null,\"isDel\":\"F\",\"feeNo\":\"F002\"}]}}'),(4,'API-SCR-SCENCE-COUSUME-004','获取机构的产品信息','获取机构的产品信息','','normal','1.0','','get','/service/scr/scence/consume/getProductMenu/{branchId}/{keywords}','branchId：机构编号\r\nkeywords：关键字 查询所有时为ALL','示例：\r\nbranchId：B001 \r\nkeywords: ALL\r\n','阶梯定价的产品信息','示例：{\"pagerCount\":1,\"pageNum\":1,\"rowCount\":0,\"pageSize\":20,\"pageStart\":0,\"netCode\":\"Q1001\",\"netMessage\":\"查询成功\",\"data\":[{\"id\":1,\"productNo\":\"P001\",\"productName\":\"测试产品1\",\"productBussinessType\":\"1\",\"productAttributeType\":\"1\",\"productSpecification\":null,\"productUnit\":null,\"productDesc\":null,\"prodcutPrice\":20.00,\"isPreferentialInOrder\":null,\"startAmount\":1,\"endAmount\":1,\"prodcutRealPrice\":10.00,\"productAttributeTypeName\":null},{\"id\":1,\"productNo\":\"P001\",\"productName\":\"测试产品1\",\"productBussinessType\":\"1\",\"productAttributeType\":\"1\",\"productSpecification\":null,\"productUnit\":null,\"productDesc\":null,\"prodcutPrice\":20.00,\"isPreferentialInOrder\":null,\"startAmount\":2,\"endAmount\":5,\"prodcutRealPrice\":15.00,\"productAttributeTypeName\":null},{\"id\":1,\"productNo\":\"P001\",\"productName\":\"测试产品1\",\"productBussinessType\":\"1\",\"productAttributeType\":\"1\",\"productSpecification\":null,\"productUnit\":null,\"productDesc\":null,\"prodcutPrice\":20.00,\"isPreferentialInOrder\":null,\"startAmount\":6,\"endAmount\":198,\"prodcutRealPrice\":20.00,\"productAttributeTypeName\":null},{\"id\":2,\"productNo\":\"P002\",\"productName\":\"测试产品2\",\"productBussinessType\":\"2\",\"productAttributeType\":\"2\",\"productSpecification\":null,\"productUnit\":null,\"productDesc\":null,\"prodcutPrice\":30.00,\"isPreferentialInOrder\":null,\"startAmount\":1,\"endAmount\":9,\"prodcutRealPrice\":30.00,\"productAttributeTypeName\":null},{\"id\":2,\"productNo\":\"P002\",\"productName\":\"测试产品2\",\"productBussinessType\":\"2\",\"productAttributeType\":\"2\",\"productSpecification\":null,\"productUnit\":null,\"productDesc\":null,\"prodcutPrice\":30.00,\"isPreferentialInOrder\":null,\"startAmount\":10,\"endAmount\":30,\"prodcutRealPrice\":15.00,\"productAttributeTypeName\":null},{\"id\":2,\"productNo\":\"P002\",\"productName\":\"测试产品2\",\"productBussinessType\":\"2\",\"productAttributeType\":\"2\",\"productSpecification\":null,\"productUnit\":null,\"productDesc\":null,\"prodcutPrice\":30.00,\"isPreferentialInOrder\":null,\"startAmount\":31,\"endAmount\":297,\"prodcutRealPrice\":30.00,\"productAttributeTypeName\":null},{\"id\":3,\"productNo\":\"P003\",\"productName\":\"测试产品3\",\"productBussinessType\":\"2\",\"productAttributeType\":\"3\",\"productSpecification\":null,\"productUnit\":null,\"productDesc\":null,\"prodcutPrice\":40.00,\"isPreferentialInOrder\":null,\"startAmount\":1,\"endAmount\":100,\"prodcutRealPrice\":40.00,\"productAttributeTypeName\":null}]}'),(5,'API-SCR-SCENCE-COUSUME-005','获取机构费用列表','获取机构固定费用列表信息','','normal','1.0','','get','/service/scr/scence/consume/getBranchFixedFeeList/{branchId}','branchId：机构编号','示例：\r\nbranchId：B001','固定费用列表信息','示例：\r\n{\"pagerCount\":1,\"pageNum\":1,\"rowCount\":0,\"pageSize\":20,\"pageStart\":0,\"netCode\":\"Q1001\",\"netMessage\":\"查询成功\",\"data\":[{\"id\":1,\"feeNo\":\"F001\",\"feeName\":\"餐具费\",\"feeType\":\"1\",\"productUnit\":\"位\",\"feePrice\":1.00,\"isPreferentialInOrder\":null,\"createUserId\":null,\"createTime\":1526007608000,\"lstModifyUserId\":null,\"lstModifyTime\":1526007608000,\"isDel\":\"F\",\"branchId\":\"B001\",\"num\":1}]}'),(6,'API-SCR-SCENCE-COUSUME-006','下单或加菜接口','下单或加菜接口','','normal','1.0','','post','/service/scr/scence/consume/order','branchId：机构编号\r\nuserSign：用户编号\r\norderProductListStr：订单产品列表\r\ntableNo：桌号\r\ntableName：桌名称\r\norderFeeDetailListStr：订单费用列表\r\nmemo：备注\r\norigOrderNo：原订单编号 没有时为空','示例：\r\nbranchId：B001\r\nuserSign：ajkdhakdha\r\norderProductListStr：1,P001,测试产品1,20.00,10.00,1,T;1,P001,测试产品1,20.00,15.00,1,T;2,P002,测试产品2,30.00,30.00,1,T\r\ntableNo：5c6a2f1571ef4208ba6a6621e392d08a\r\ntableName：VIP888\r\norderFeeDetailListStr：1,F001,餐具费,1.00,3\r\nmemo：备注\r\norigOrderNo：','下单验证信息或成功信息\r\n编码为：Q1001时为验证信息，验证主要为是否超过库存\r\nI1000：下单成功\r\nI1002：下单失败','示例：\r\n{\"pagerCount\":1,\"pageNum\":1,\"rowCount\":0,\"pageSize\":20,\"pageStart\":0,\"netCode\":\"I1000\",\"netMessage\":\"插入成功\",\"data\":null}'),(7,'API-SRC-APP-ORDER-001','新增餐桌','插入餐桌信息','','normal','1.0','','post','/service/scr/app/order','tableName：餐桌名称\r\nseq：顺序号','示例：\r\ntableName：A01桌\r\nseq：顺序号','插入结果','实例：\r\n{\"pagerCount\":1,\"pageNum\":1,\"rowCount\":0,\"pageSize\":20,\"pageStart\":0,\"netCode\":\"I1000\",\"netMessage\":\"插入成功\",\"data\":null}');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='应用基础表';

#
# Data for table "gcfd_app"
#

INSERT INTO `gcfd_app` VALUES (7,'SCR-APP-ORDER','订单','智慧云餐厅订单应用','','normal','1.0','upload/1526304853108order.png','http://www.baidu.com'),(8,'SCR-APP-PRODUCT','产品','产品以及定价管理','','normal','1.0','upload/1526356622387product.png','http://www.baidu.com'),(9,'SCR-APP-COOKER','后厨','后厨生产管理','','normal','1.0','upload/1526356846009cooker.png','http://www.baidu.com'),(10,'SCR-APP-WAITER','服务员','服务员上菜管理','','normal','1.0','upload/1526356928054waiter.png','http://www.baidu.com'),(11,'SCR-APP-SYS','系统设置','系统设置','','normal','1.0','upload/1526357110665sys.png','http://www.baidu.com');

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

INSERT INTO `gcfd_auth` VALUES (1,1,1),(1,1,2),(1,7,1),(1,7,3),(4,6,2),(4,6,3),(5,7,1),(5,7,2),(5,7,3),(6,7,1),(6,8,1),(6,9,1),(6,10,1),(6,11,1);

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "gcfd_branch"
#

INSERT INTO `gcfd_branch` VALUES (5,'B00000001','古成方德','古成方德','北京','11111111','18911102753','18911102753',NULL,NULL,NULL,'F');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限组表';

#
# Data for table "gcfd_group"
#

INSERT INTO `gcfd_group` VALUES (6,'智慧云餐厅管理组');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='场景基础表';

#
# Data for table "gcfd_scence"
#

INSERT INTO `gcfd_scence` VALUES (3,'SCR-SCENCE-CONSUME','消费场景','点菜,结算,开发票','','normal','1.0','upload/1526357279802cooker.png','');

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

INSERT INTO `gcfd_user` VALUES ('111','admin','NvN2AQf6zL0wQi+qqr2gug==',0,'18911102753','18911102753@189.cn','B00000001'),('2191EB76-6E08-435D-843D-149CD336B31B','zhangshb','NvN2AQf6zL0wQi+qqr2gug==',0,'18911102753','18911102753@189.cn','B00000001'),('wenwen12212001','wenwen','l7hCbRzPGodELNlx5+GgHw==',0,'13810491957','22221@139.com','B00000001');

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

INSERT INTO `gcfd_user_group_rel` VALUES ('001',1),('2191EB76-6E08-435D-843D-149CD336B31B',6),('C180373D-334A-446E-A126-747FC1A8AC04',1),('C180373D-334A-446E-A126-747FC1A8AC04',2),('C180373D-334A-446E-A126-747FC1A8AC04',3),('C180373D-334A-446E-A126-747FC1A8AC04',4),('C180373D-334A-446E-A126-747FC1A8AC04',5),('wenwen12212001',6);
