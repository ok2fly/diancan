/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.integratmonitor.pqsms;

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

public interface PqsmsService {

	/**
	 * 电能质量检测装置-详情 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPqsmsInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurves(Map<String,Object> map) throws Exception;
	
	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电压、电流2-50次谐波柱状图（当天的最新的那条数据））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPqsmsThdUIABCHistogram(Map<String,Object> map) throws Exception;
	
	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistory(Map<String,Object> map) throws Exception;

	
	/**
	 * 获取PVS设备列表页的信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPqsmsInfLst(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getPqsmsInfStat(Map<String, Object> map) throws Exception;
	
	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电压、电流2-50次谐波柱状图（当天的最新的那条数据））(App)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsPqsmsThdUIABCHistogramLst(Map<String, Object> map) throws Exception;

	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））(App)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsPqsmsThdUIABCHistogramHistoryLst(Map<String, Object> map) throws Exception;

	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））(列表)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistoryLst(Map<String, Object> map) throws Exception;

	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））(列表,带分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getIscsPqsmsUIPQsumCurvesHistoryLstCou(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getIscsPqsmsThdUIABCHistogramLstIos(
			Map<String, Object> map) throws Exception;
}
