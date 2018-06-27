/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.statisticanalysis;

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

public interface StatisticAnalysisService {
	/**
	 * 获取光伏设备月报表信息以及年报表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPVStaMonYear(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取光伏设备时间段报表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPVInfStaBetweenDay(Map<String, Object> map) throws Exception;

	/**
	 * 获取储能设备月报表信息以及年报表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPCStaMonYear(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取储能设备时间段报表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPCInfStaBetweenDay(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取充电桩月报表信息以及年报表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChpStaMonYear(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取充电桩时间段报表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChpInfStaBetweenDay(Map<String, Object> map) throws Exception;

	
	
	
	/*--------------------------电量计划Start--------------------------*/
	
	/**
	 * 获取计划发电量列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPlanPowerLst(Map<String, Object> map) throws Exception;

	/**
	 * 获取计划发电量列表（分页）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getPlanPowerLstCou(Map<String, Object> map) throws Exception;

	/**
	 * 获取某一条计划发电量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPlanPowerInfById(Map<String, Object> map) throws Exception;

	/**
	 * 添加计划发电量信息
	 * @param map
	 * @throws Exception
	 */
	void insertPlanPower(Map<String, Object> map) throws Exception;

	/**
	 * 修改计划发电量信息
	 * @param map
	 * @throws Exception
	 */
	void updatePlanPower(Map<String, Object> map) throws Exception;

	/**
	 * 删除计划发电量信息
	 * @param map
	 * @throws Exception
	 */
	void deletePlanPower(Map<String, Object> map) throws Exception;
	

	/**
	 * 获取理论发电量信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFsbPowerLst(Map<String, Object> map) throws Exception;

	/**
	 * 获取理论发电量信息列表(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getFsbPowerLstCou(Map<String, Object> map) throws Exception;

	/**
	 * 获取某一条理论发电量信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFsbPowerInfById(Map<String, Object> map) throws Exception;

	/**
	 * 添加理论发电量信息
	 * @param map
	 * @throws Exception
	 */
	void insertFsbPower(Map<String, Object> map) throws Exception;

	/**
	 * 修改理论发电量信息
	 * @param map
	 * @throws Exception
	 */
	void updateFsbPower(Map<String, Object> map) throws Exception;

	/**
	 * 删除理论发电量信息
	 * @param map
	 * @throws Exception
	 */
	void deleteFsbPower(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 * 获取理论辐射量列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFsbHvLst(Map<String, Object> map) throws Exception;

	/**
	 * 获取理论辐射量列表(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getFsbHvLstCou(Map<String, Object> map) throws Exception;

	/**
	 * 获取某一条理论辐射量信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFsbHvInfById(Map<String, Object> map) throws Exception;

	/**
	 * 添加理论辐射量
	 * @param map
	 * @throws Exception
	 */
	void insertFsbHv(Map<String, Object> map) throws Exception;

	/**
	 * 修改理论辐射量
	 * @param map
	 * @throws Exception
	 */
	void updateFsbHv(Map<String, Object> map) throws Exception;

	/**
	 * 删除理论辐射量
	 * @param map
	 * @throws Exception
	 */
	void deleteFsbHv(Map<String, Object> map) throws Exception;
	
	/*--------------------------电量计划End--------------------------*/
	
	
	/*------------------------------------采集数据查询Start------------------------------------*/
	/**
	 * 获取采集数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getCollectDataLst(Map<String, Object> map);
	/**
	 * 获取采集数据(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getCollectDataLstCou(Map<String, Object> map);
	
	/*------------------------------------采集数据查询End------------------------------------*/
	
	/*------------------------------------告警数据查询Start------------------------------------*/
	/**
	 * 获取告警数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFatDataLst(Map<String, Object> map);
	/**
	 * 获取告警数据(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getFatDataLstCou(Map<String, Object> map);
	
	/*------------------------------------告警数据查询End------------------------------------*/
	
	/*------------------------------------年月电站报表Start------------------------------------*/
	/**
	 * 获取电站中年月报表信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsYearMonthReportInfLst(Map<String, Object> map) throws Exception;
	
	/*------------------------------------年月电站报表End------------------------------------*/
	
	/*------------------------------------电站电表报表Start------------------------------------*/
	/**
	 * 获取电站中电表报表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsMeterReportInfLst(Map<String, Object> map) throws Exception;
	
	/*------------------------------------电站电表报表End------------------------------------*/
}
