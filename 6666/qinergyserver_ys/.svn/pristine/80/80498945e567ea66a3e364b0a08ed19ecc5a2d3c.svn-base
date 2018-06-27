package com.qinergy.service.integratmonitor.dcdc;

import java.util.List;
import java.util.Map;


/**
 * @desc: 
 * @author: Qist
 * @date: 2017年10月25日
 */
public interface DcdcService {

	// 1.设备统计页面展示 
	
	
	
	/**
	 * 废弃方法：设备各个状态及其数量展示
	 */
	List<Map<String, Object>> getDCDCStatCount(Map<String, Object> map) throws Exception;

	/**
	 *废弃方法： DCDC设备列表
	 */
	List<Map<String, Object>> getDCDCEquList(Map<String, Object> map) throws Exception;

	
	// 2.实时数据  
	/**
	 * 根据 设备编号 获取 DCDC 最新的一条实时数据 --数据 --告警牌
	 */
	Map<String, Object> getDCDCRealByNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据 设备编号 获取 DCDC 最新的一条实时数据 --数据 (所有字段)
	 */
	Map<String, Object> getDCDCRealsByNum(Map<String, Object> map) throws Exception;
	

	/**
	 * 高压侧电压、电流 低压侧电压电流 图表分析数据（当天的数据list）
	 */
	List<Map<String, Object>> getDCDCRealList(Map<String, Object> map) throws Exception;

	/**
	 * 设备静态信息
	 */
	Map<String, Object> getDCDCEquByNum(Map<String, Object> map) throws Exception;

	// 3.历史数据
	Integer getDCDCHistoryCount(Map<String, Object> map) throws Exception;

	/**
	 * 高压侧电压、电流 低压侧电压电流 图表分析数据（某一天的 数据00：00--23:59）
	 */

	List<Map<String, Object>> getDCDCHistoryList(Map<String, Object> map) throws Exception;

	
	
	/***************************4.健康状况 ***各个设备公用的方法****************************************/
	/**
	 * 历史告警记录 --关键字、告警级别、起始时间、结束时间（模糊查询字段） 分页
	 */
	List<Map<String, Object>> getDCDCFaultList(Map<String, Object> map) throws Exception;

	/**
	 * 设备维修记录 --关键字、起始时间、结束时间（模糊查询字段） 分页
	 */
	List<Map<String, Object>> getDCDCRepairList(Map<String, Object> map) throws Exception;

	/**
	 * 设备保养记录 --关键字、起始时间、结束时间（模糊查询字段） 分页
	 */
	List<Map<String, Object>> getDCDCMainList(Map<String, Object> map) throws Exception;

	/**
	 * 健康曲线
	 */
	List<Map<String, Object>> getDCDCHealthList(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getDcdcInfLst(Map<String, Object> map)
			throws Exception;

	List<Map<String, Object>> getDCDCHistoryGraph(Map<String, Object> map)
			throws Exception;

}
