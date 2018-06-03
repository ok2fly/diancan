package com.gcfd.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBTable {
	
	private static final Logger logger = LoggerFactory.getLogger(CreateDBTable.class);

	public static String getApplyTable(String activityId){
		
		return "CREATE TABLE act_qrs_apply_"+activityId +" ("+
				"`id` varchar(36) NOT NULL COMMENT '报名ID', `userId` varchar(36) DEFAULT NULL COMMENT '用户ID',"+
				"`activityId` varchar(36) DEFAULT NULL COMMENT '活动ID',`activityName` varchar(36) DEFAULT NULL COMMENT '活动Name',"+
				"`educationId` varchar(15) DEFAULT NULL COMMENT '教育ID',`qx` varchar(6) DEFAULT NULL COMMENT '区县代码',"+
				"`name` varchar(128) DEFAULT NULL COMMENT '姓名（数据持久不变，记录报名时的静态）',`userClass` varchar(20) DEFAULT NULL COMMENT '班级 同上',"+
				" `gradeName` varchar(20) DEFAULT NULL COMMENT '年级 同上',`schoolId` varchar(36) DEFAULT NULL COMMENT '学校ID 同上',"+
				"`phone` varchar(11) DEFAULT NULL COMMENT '11位手机号',`position` varchar(50) DEFAULT NULL COMMENT '行政老师职位',"+
				"`teacherIda` varchar(36) DEFAULT NULL COMMENT '第一责任老师',`teacherIdb` varchar(36) DEFAULT NULL COMMENT '第二责任老师 支持允许二个责任老师',"+
				"`parentId` varchar(120) DEFAULT NULL COMMENT '家长Id  多个家长逗号隔开',`childId` varchar(120) DEFAULT NULL COMMENT '小孩Id  多个小孩逗号隔开',"+
				"`createTime` datetime DEFAULT NULL COMMENT '报名时间',`checkTime` datetime DEFAULT NULL COMMENT '审核时间',"+
				"`checkZt` char(1) DEFAULT '1' COMMENT '1 报名审核中 2 审核通过 3 审核未通过',`userType` varchar(10) DEFAULT NULL COMMENT '1001 学生 2001 普通教师 2002 班主任 2003 行政老师 3001 家长 4001 专家 5001 后台用户',"+
			    "`isDel` char(1) DEFAULT 'F' COMMENT 'F 有效报名 T 注销报名（删除报名，报名取消）',PRIMARY KEY (`id`),"+
				"KEY `INDEX_USERID_ACTIVITY_ID` (`userId`,`activityId`),KEY `INDEX_ACTIVITY_ID_QX_SCHOOL` (`activityId`,`qx`,`schoolId`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
	
	public static String getPaperTable(String activityId){
		return "CREATE TABLE act_qrs_paper_"+activityId+" (`id` varchar(36) NOT NULL COMMENT '试卷ID',"+
				"`activityName` varchar(128) DEFAULT NULL COMMENT '活动名称',`activityId` varchar(36) DEFAULT NULL COMMENT '活动ID',"+
				"`expName` varchar(50) DEFAULT NULL COMMENT '试卷名称',`expRemark` varchar(300) DEFAULT NULL COMMENT '试卷备注（注解/简介）',"+
				"`createUserId` varchar(36) DEFAULT NULL COMMENT '创建者ID',`createUser` varchar(128) DEFAULT NULL COMMENT '创建者姓名',"+
				"`createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '试卷创建时间',`expUrl` varchar(200) DEFAULT NULL COMMENT '试卷URL（实现了静态试卷才用）',"+
				"`isDel` char(1) DEFAULT 'F' COMMENT 'F 有效试卷 T 注销试卷', `score` double(5,2) DEFAULT NULL COMMENT '试卷分数',"+
				"`schoolLength` varchar(36) DEFAULT NULL COMMENT '1 小学 2初中 3高中 4大学',`paperType` char(4) DEFAULT NULL, PRIMARY KEY (`id`), UNIQUE KEY `UNIQUE_EXPNAME` (`expName`),"+
				"KEY `INDEX_ACTUVITY_ID` (`activityId`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
					
	}
	
	public static String getQuestionTable(String activityId){
		
		return "CREATE TABLE act_qrs_question_"+activityId +" (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动确认题目ID',"+
				"`cpId` varchar(36) NOT NULL COMMENT '试卷ID',`cpName` varchar(50) DEFAULT NULL COMMENT '试卷名字',"+
				"`cqId` varchar(36) NOT NULL COMMENT '原始题目ID',`caId` varchar(36) DEFAULT NULL COMMENT '活动ID',"+
				"`questionName` varchar(36) DEFAULT NULL COMMENT '题目别名',"+
				"`question` varchar(10000) DEFAULT NULL COMMENT '试题内容',`answerA` varchar(500) DEFAULT NULL COMMENT '答案A',"+
				"`answerB` varchar(500) DEFAULT NULL COMMENT '答案B',`answerC` varchar(500) DEFAULT NULL COMMENT '答案C',"+
				"`answerD` varchar(500) DEFAULT NULL COMMENT '答案D',`answerE` varchar(500) DEFAULT NULL COMMENT '答案E',"+
				"`answer` varchar(20) DEFAULT NULL COMMENT '正确答案',`isDel` char(1) DEFAULT 'F' COMMENT 'F 有效 T 无效题目',"+
				"`type` char(1) DEFAULT NULL COMMENT '1 自主命题 2 非自主命题',`score` double(5,2) DEFAULT NULL COMMENT '题目分数',"+
				"`questionType` char(4) DEFAULT NULL COMMENT '自主命题题目类型',PRIMARY KEY (`id`),"+
				"KEY `INDEX_CQUESTION_CPID` (`cpId`)) ENGINE=InnoDB AUTO_INCREMENT=515 DEFAULT CHARSET=utf8";
	}
	
	public static String getAnswerPaPerTable(String activityId){
		return "CREATE TABLE act_qrs_answerpaper_"+activityId+" (`id` varchar(36) NOT NULL COMMENT '答卷ID',"+
				"`paperId` varchar(36) DEFAULT NULL COMMENT '试卷ID',`paperName` varchar(36) DEFAULT NULL COMMENT '试卷名称',"+
				"`activityId` varchar(36) DEFAULT NULL COMMENT '活动ID',`userId` varchar(36) DEFAULT NULL COMMENT '答题者ID',"+
				" `userName` varchar(20) DEFAULT NULL COMMENT '答题者姓名',`zt` char(1) DEFAULT NULL COMMENT '1 答题中 2 提交 3 判分结束',"+
				"`examinerId` varchar(36) DEFAULT NULL COMMENT '判卷人ID',`examinerName` varchar(20) DEFAULT NULL COMMENT '判卷人姓名',"+
				"`examineTime` datetime DEFAULT NULL COMMENT '判卷时间',`score` double(5,2) DEFAULT NULL COMMENT '考试总成绩',"+
				"`visitType` char(4) DEFAULT NULL COMMENT '1 computer 2 WeChat 3 IOS 4 Android',`qxId` varchar(6) DEFAULT NULL COMMENT '区县ID',"+
				"`schoolId` varchar(36) DEFAULT NULL COMMENT '学校ID',`gradeId` varchar(20) DEFAULT NULL COMMENT '年级',"+
				"`classId` varchar(20) DEFAULT NULL COMMENT '班级',`submitTime` datetime DEFAULT NULL COMMENT '提交时间',"+
				"`isDel` char(1) DEFAULT 'F' COMMENT 'F 有效 T 注销',`paperType` char(4) DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
	public static String getAnswerQuestionTable(String activityId){
		
		return "CREATE TABLE act_qrs_answerquestion_"+activityId+" (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '答题ID',"+
				"`activityId` varchar(36) DEFAULT NULL COMMENT '活动ID',`answerPaperId` varchar(36) DEFAULT NULL COMMENT '答卷ID',"+
				"`paperId` varchar(36) DEFAULT NULL COMMENT '试卷ID',`paperName` varchar(30) DEFAULT NULL COMMENT '试卷名称',"+
				"`questionId` varchar(36) NOT NULL COMMENT '题目ID',`questionContent` varchar(10000) DEFAULT NULL COMMENT '题目内容',"+
				"`persistentId` varchar(50) DEFAULT NULL COMMENT '管道编码处理ID',`oldAnswer` varchar(100) DEFAULT NULL COMMENT '答案转码前路径',"+
				"`answer` varchar(2000) DEFAULT NULL COMMENT '答案，逗号隔开(A,B,C,D)如自主命题可以是作文也可以网络地址(只限于视频、语音、图片)',"+
				"`result` double(5,2) DEFAULT NULL COMMENT '答题得分',`answerTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '答题时间',"+
				"`questionView` varchar(2000) DEFAULT NULL COMMENT '题目意见',`userId` varchar(36) NOT NULL COMMENT '答题用户ID',"+
				"`examinerName` varchar(20) DEFAULT NULL COMMENT '判卷人姓名',`examinerId` varchar(36) DEFAULT NULL COMMENT '判题人ID',"+
				"`examineTime` datetime DEFAULT NULL COMMENT '判题时间',`examineView` varchar(300) DEFAULT NULL COMMENT '判题意见',"+
				"`type` char(1) DEFAULT NULL COMMENT '题目类型',`questionType` char(4) DEFAULT NULL COMMENT '所属题目',"+
				"`answerType` char(4) DEFAULT NULL COMMENT '答案类型',`qxId` varchar(6) DEFAULT NULL COMMENT '区县ID',"+
				"`schoolId` varchar(36) DEFAULT NULL COMMENT '学校ID',`gradeId` varchar(20) DEFAULT NULL COMMENT '年级',"+
				"`classId` varchar(20) DEFAULT NULL COMMENT '班级',`zt` char(1) DEFAULT NULL COMMENT '1 答题中 2 提交 3 已判卷',"+
				"`checkZt` char(1) DEFAULT NULL COMMENT '0 未审批 1 通过 2 未通过 3 删除 4 审批中 5 可展出 6 可收集',"+
				"`visitType` char(4) DEFAULT NULL COMMENT '1 电脑 2 微信 3 IOS 4 安卓',"+
				"`isSure` varchar(36) NOT NULL COMMENT '题目是否回答正确 正确T',"+
				"PRIMARY KEY (`questionId`,`userId`,`isSure`),"+
				"KEY `IDX_AID_PID_CZT` (`paperId`,`checkZt`),KEY `IDX_CU_QE_AN_USERID` (`userId`),KEY `INDEX_CQA_APID` (`answerPaperId`),KEY `IDX_ACPID_ZT_CZT_AST` (`answerTime`),"+
				"KEY `IDX_ACPID_SCH_GRID_CLID` (`schoolId`,`gradeId`,`classId`),KEY `IDX_CU_QE_AN_EXID` (`examinerId`),KEY `IDX_AID_typ_CZT_ZT` (`type`,`checkZt`,`zt`,`schoolId`),"+
				"KEY `id` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
	
	public static String getMarkTable(String activityId){
		
		return "CREATE TABLE act_qrs_mark_"+activityId+" (`activityId` varchar(36) NOT NULL COMMENT '活动ID',"+
				"`userId` varchar(36) NOT NULL COMMENT '用户ID',`paperId` varchar(36) DEFAULT NULL COMMENT '试卷ID',"+
				"`paperName` varchar(30) DEFAULT NULL COMMENT '试卷名字',`mark` double(5,2) DEFAULT NULL COMMENT '成绩',"+
				"`orderNum` int(255) DEFAULT NULL COMMENT '成绩排名',`userName` varchar(20) DEFAULT NULL COMMENT '用户名',"+
				"`qxId` varchar(36) DEFAULT NULL COMMENT '所在区县',`schoolId` varchar(50) DEFAULT NULL COMMENT '学校ID',"+
				"`schoolName` varchar(50) DEFAULT NULL COMMENT '学校名',`gradeId` varchar(50) DEFAULT NULL COMMENT '年级',"+
				"`classId` varchar(50) DEFAULT NULL COMMENT '班级',`examinerId` varchar(36) DEFAULT NULL COMMENT '判卷人ID',"+
				"`examinerName` varchar(20) DEFAULT NULL COMMENT '判卷人姓名',`createTime` datetime DEFAULT NULL COMMENT '创建时间',"+
				"`partition` int(11) DEFAULT NULL COMMENT '区号 比如（99.11分，区号9911）',PRIMARY KEY (`activityId`,`userId`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
	
	public static boolean createTable(String activityId){
			Connection conn = null;
			Statement state;
			try {
				conn = ConnectionUtil.getConnectionXml("saas");
				state = conn.createStatement();
			} catch (SQLException e) {
				logger.debug("-----------------数据库连接失败-----------------");
				return false;
			}
			try {
				state.executeUpdate(getApplyTable(activityId));              //创建报名表
				state.executeUpdate(getPaperTable(activityId));              //创建试卷表
				state.executeUpdate(getQuestionTable(activityId));			 //创建试题表
				state.executeUpdate(getAnswerPaPerTable(activityId));		 //创建答卷表
				state.executeUpdate(getAnswerQuestionTable(activityId));     //创建答题表
				state.executeUpdate(getMarkTable(activityId)); 				 //创建成绩表
			} catch (SQLException e) {
				logger.debug("-------------------创建表失败------------------");
				return false;
			} 
			
			ConnectionUtil.closeConnection(conn);
			logger.debug("-----------------创建表成功-----------------");
			return true;
		
	}
	
	public static void main(String[] args) {
		
		CreateDBTable.createTable("19201");
		
	}
}
