/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.integratmonitor.acchp;

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

public interface AcchpService {

	/**
	 * 交流充电桩-详情,待机数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsAcchpStdInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 交流充电桩-详情,实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsAcchpRelInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 交流充电桩-详情 （获取交流充电桩设备的电流、电压曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsAcchpRelUICurves(Map<String,Object> map) throws Exception;
	
	/**
	 * 交流充电桩-详情 （获取交流充电桩设备的电流、电压（历史的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsAcchpRelUICurvesHistory(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取交流充电桩的列表信息页面
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAcchpInfLst(Map<String,Object> map) throws Exception;

	
	/**
	 * 状态查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAcchpInfStat(Map<String, Object> map) throws Exception;

	/**
	 * 交流充电桩-详情 （获取订单信息）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsAcchpOrdInfLst(Map<String, Object> map) throws Exception;

	/**
	 * 交流充电桩-详情 （获取订单信息）（分页）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getIscsAcchpOrdInfLstCou(Map<String, Object> map) throws Exception;
}
