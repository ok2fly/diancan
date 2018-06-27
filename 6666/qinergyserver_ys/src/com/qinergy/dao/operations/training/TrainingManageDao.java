package com.qinergy.dao.operations.training;

import java.util.List;
import java.util.Map;

/**
 * @desc: 培训管理 
 * @author: Qist
 * @date: 2017年11月28日
 */
public interface TrainingManageDao {
	
	/**
	 * 添加培训类型 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean insTrainingTyp(Map<String, Object> map) throws Exception;

	/**
	 * 修改培训类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean updTrainingTyp(Map<String, Object> map) throws Exception;

	/**
	 * 删除培训类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean delTrainingTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据id 查看培训类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getTrainingTypById(Map<String, Object> map) throws Exception;

	/**
	 * 培训类型 列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTrainingTypList(Map<String, Object> map) throws Exception;
		
	
	/**
	 * 培训 文件 添加 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean uploadTrainFile(Map<String, Object> map) throws Exception;
	
	/**
	 * 逻辑删除文件 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean delTrainFile(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据id查询培训文件
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getFileById(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据编号 获取文件列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFileListByTrainNum(Map<String, Object> map) throws Exception;	
	
		
		
	/**
	 * 培训管理 添加 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean insTraining(Map<String, Object> map) throws Exception;

	/**
	 * 修改培训信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean updTraining(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据id 修改培训 状态 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean executeTraining(Map<String, Object> map) throws Exception;
	
	/**
	 * 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean delTrainingById(Map<String, Object> map) throws Exception;
	
	 /**
	  * 根据ids 批量逻辑删除培训 管理信息
	  * @param map
	  * @return
	  * @throws Exception
	  */
	boolean delBatchTrainingById(Map<String, Object> map) throws Exception;
		
	 /**
	  * 根据id获取培训 管理信息
	  * @param map
	  * @return
	  * @throws Exception
	  */
	Map<String, Object> getTrainingById(Map<String, Object> map) throws Exception;
	
	 /**
	  * 培训列表信息
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getTrainingList(Map<String, Object> map) throws Exception;	
	
	 /**
	  * 培训列表信息  数量
	  * @param map
	  * @return
	  * @throws Exception
	  */
	Map<String, Object> getTrainingListCount(Map<String, Object> map) throws Exception;
	
	
	
	
	
	
	/**
	 * 培训计划添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean insTrainingPlan(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改培训计划管理
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean updTrainingPlan(Map<String, Object> map) throws Exception;
	
	/**
	 * 删除培训计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean delTrainingPlanById(Map<String, Object> map) throws Exception;

	/**
	 * 根据ids 批量逻辑删除培训 管理信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean delBatchTrainingPlanById(Map<String, Object> map) throws Exception;
	
	/**
	 *  根据id获取培训 管理信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getTrainingPlanById(Map<String, Object> map) throws Exception;
	
	/**
	 *  获取培训计划管理信息列表 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTrainingPlanList(Map<String, Object> map) throws Exception;	
	/**
	 *  获取培训计划管理信息列表  数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getTrainingPlanListCount(Map<String, Object> map) throws Exception;

	 /**
	  * 根据类型名称 查询 培训类型
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getTrainingTypByName(Map<String, Object> map)
			throws Exception;
		
		
		
}
