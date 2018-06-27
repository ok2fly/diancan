/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.integratmonitor.box;

import java.util.List;
import java.util.Map;


/**
 * TODO
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public interface BoxService {

	/**
	 * 汇流箱-详情 （获取最新那条数据，包含支路电流数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsBoxInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 汇流箱-详情 （获取汇流箱的温度曲线图数据以及离散率曲线图数据（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsBoxTempDisRateCurves(Map<String,Object> map) throws Exception;
	
	/**
	 * 汇流箱-详情 （获取汇流箱的温度曲线图数据以及离散率曲线图数据（历史的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsBoxTempDisRateCurvesHistory(Map<String,Object> map) throws Exception;
	
	
	/**
	 * 获取 汇流箱设备列表页的信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBoxInfLst(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getBoxInfStat(Map<String, Object> map) throws Exception;

	
	/**
	 * 汇流箱-详情 （获取汇流箱的温度曲线图数据以及离散率曲线图数据（历史的））(列表)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsBoxTempDisRateCurvesHistoryLst(Map<String, Object> map) throws Exception;

	
	/**
	 * 汇流箱-详情 （获取汇流箱的温度曲线图数据以及离散率曲线图数据（历史的））(列表,分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getIscsBoxTempDisRateCurvesHistoryLstCou(Map<String, Object> map) throws Exception;
}
