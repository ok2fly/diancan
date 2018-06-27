/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.operations.training;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.operations.TrainingManagerDto;
import com.qinergy.dto.operations.TrainingManagerPlanDto;
import com.qinergy.dto.operations.TrainingTypeDto;

/**
 * @desc: 培训管理 / 培训计划接口
 * @author: Qist
 * @date: 2017年11月28日
 */
public interface TrainingManageService {
	
	/**
	 * @Title: insTrainingTyp  
	 * @Desc:  添加 培训类型 
	 * @return boolean
	 * @throws
	 */
	boolean insTrainingTyp(TrainingTypeDto trainingTypeDto) throws Exception;

	/**
	 * @Title: updTrainingTyp  
	 * @Desc:  修改 培训类型 
	 * @return boolean
	 * @throws
	 */
	boolean updTrainingTyp(TrainingTypeDto trainingTypeDto) throws Exception;

	/**
	 * @Title: delTrainingTyp  
	 * @Desc:  逻辑删除 培训类型
	 * @return boolean
	 * @throws
	 */
	boolean delTrainingTyp(String id, String use_id) throws Exception;
	
	/**
	 * @Title: getTrainingTypById  
	 * @Desc:  根据id 获取培训类型
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getTrainingTypById(String id) throws Exception;

	/**
	 * @Title: getTrainingTypList  
	 * @Desc:  获取培训类型 列表
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getTrainingTypList() throws Exception;
	
	/**************************************培 训 文 件**************************************
	 * @Title: uploadTrainFile  
	 * @Desc: 上传培训文件  
	 * @return boolean
	 * @throws
	 */
	boolean uploadTrainFile(MultipartFile file,Map<String, Object> map) throws Exception;
	
	/**
	 * @Title: downloadTrainFile  
	 * @Desc:  下载文件  
	 * @return boolean
	 * @throws
	 */
	boolean downloadTrainFile(HttpServletResponse response, int id, BaseTransferEntity baseTransferEntity) throws Exception;
		
	/**
	 * @Title: delTrainFile  
	 * @Desc:  逻辑删除文件 
	 * @return boolean
	 * @throws
	 */
	boolean delTrainFile(String id, String use_id) throws Exception;

	/**
	 * @Title: getFileById  
	 * @Desc:  根据id查询培训文件  
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getFileById(String id) throws Exception;
	
	/**
	 * @Title: getFileListByTrainNum  
	 * @Desc:  根据缺陷id 获取文件列表  
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getFileListByTrainNum(String train_num) throws Exception;
	
	/**
	 * @Title: insTraining  
	 * @Desc:  添加培训 信息 
	 * @return boolean
	 * @throws
	 */
	boolean insTraining (TrainingManagerDto managerDto) throws Exception;

	/**
	 * @Title: updTraining  
	 * @Desc:  修改培训 信息  
	 * @return boolean
	 * @throws
	 */
	boolean updTraining (TrainingManagerDto managerDto) throws Exception;

	/**
	 * @Title: delTrainingById  
	 * @Desc:  根据id 删除培训 信息  
	 * @return boolean
	 * @throws
	 */
	boolean delTrainingById(String id, String use_id) throws Exception;
	
	/**
	 * @Title: executeTraining  
	 * @Desc:  修改培训 状态  
	 * @return boolean
	 * @throws
	 */
	boolean executeTraining (String id, String use_id) throws Exception;
	
	/**
	 * @Title: delBatchTrainingById  
	 * @Desc:  批量删除培训 信息  
	 * @return boolean
	 * @throws
	 */
	boolean delBatchTrainingById(String ids, String use_id) throws Exception;
		
	/**
	 * @Title: getTrainingById  
	 * @Desc:  根据id 获取培训 信息  
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getTrainingById(String id) throws Exception;
		
	/**
	 * @Title: getTrainingList  
	 * @Desc:  获取培训 信息 列表 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getTrainingList(Map<String, Object> map) throws Exception;	
	
	/**
	 * @Title: getTrainingListCount  
	 * @Desc:  获取培训 信息 列表个数 
	 * @return int
	 * @throws
	 */
	int getTrainingListCount(Map<String, Object> map) throws Exception;
	
	/** 
	 * @Title: insTrainingPlan  
	 * @Desc:  添加培训计划信息 
	 * @return boolean
	 * @throws
	 */
	boolean insTrainingPlan(TrainingManagerPlanDto managerDto) throws Exception;
	
	/**
	 * @Title: updTrainingPlan  
	 * @Desc:  修改培训 信息  
	 * @return boolean
	 * @throws
	 */
	boolean updTrainingPlan(TrainingManagerPlanDto managerDto) throws Exception;

	/**
	 * @Title: delTrainingPlanById  
	 * @Desc:  根据id 删除培训 信息  
	 * @return boolean
	 * @throws
	 */
	boolean delTrainingPlanById(String id, String use_id) throws Exception;
	
	/**
	 * @Title: delBatchTrainingPlanById  
	 * @Desc: 批量删除培训 信息 
	 * @return boolean
	 * @throws
	 */
	boolean delBatchTrainingPlanById(String ids, String use_id) throws Exception;
		
	/**
	 * @Title: getTrainingPlanById  
	 * @Desc:  根据id 获取培训 信息   
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getTrainingPlanById(String id) throws Exception;
	
	
	/**
	 * @Title: getTrainingPlanList  
	 * @Desc:   获取培训计划信息 列表
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getTrainingPlanList(Map<String, Object> map) throws Exception;	
	
	/**
	 * @Title: getTrainingPlanListCount  
	 * @Desc:  获取培训计划信息 列表个数
	 * @return Map<String,Object>
	 * @throws
	 */
	int getTrainingPlanListCount(Map<String, Object> map) throws Exception;

	/**
	 * 使用培训名称获取培训类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTrainingTypByName(Map<String, Object> map) throws Exception;

}
