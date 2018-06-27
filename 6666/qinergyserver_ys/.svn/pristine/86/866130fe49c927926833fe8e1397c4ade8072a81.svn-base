/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.integratmonitor.dcchp;

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

public interface DcchpService {

	/**
	 * 直流充电桩-详情,待机数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsDcchpStdInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 直流充电桩-详情,实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsDcchpRelInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 直流充电桩-详情 （获取直流充电桩设备的电流、电压曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsDcchpRelUICurves(Map<String,Object> map) throws Exception;
	
	/**
	 * 直流充电桩-详情 （获取直流充电桩设备的电流、电压（历史的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsDcchpRelUICurvesHistory(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取直流充电桩的列表信息页面
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDcchpInfLst(Map<String,Object> map) throws Exception;

	
	/**
	 * 状态查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDcchpInfStat(Map<String, Object> map) throws Exception;

	/**
	 * 直流充电桩-详情 （获取订单信息）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsDcchpOrdInfLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 直流充电桩-详情 （获取订单信息）(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getIscsDcchpOrdInfLstCou(Map<String, Object> map) throws Exception;

	/**
	 * 直流充电桩-详情 （获取直流充电桩充电的汽车信息）(使用订单编号)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsCarStaInfLst(Map<String, Object> map) throws Exception;
}
