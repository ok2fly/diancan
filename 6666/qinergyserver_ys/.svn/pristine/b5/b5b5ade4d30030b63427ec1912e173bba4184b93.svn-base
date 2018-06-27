/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.integratmonitor.pvs;

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

public interface PvsService {

	/**
	 * 光伏逆变器-详情 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurves(Map<String,Object> map) throws Exception;
	
	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsDayPowerHistogram(Map<String,Object> map) throws Exception;
	
	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistory(Map<String,Object> map) throws Exception;
	
	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsDayPowerHistogramHistory(Map<String,Object> map) throws Exception;

	
	/**
	 * 获取PVS设备列表页的信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPvsInfLst(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getPvsInfStat(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistoryLst(Map<String, Object> map) throws Exception;

	Map<String, Object> getIscsPvsAcDcPIVDisRateCurvesHistoryLstCou(Map<String, Object> map) throws Exception;
}
