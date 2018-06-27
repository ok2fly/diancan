package com.qinergy.service.integratmonitor.meter;

import java.util.List;
import java.util.Map;

/**
 * 
 * @desc: 电表 设备接口
 * @author: Qist
 * @date: 2017年10月27日
 */
public interface MeterService {

	
	// 2.实时数据页面 
	
	/**
	 * @Title: getMeterRealByEquNum  
	 * @Desc: 根据设备编号  获取最新的一条实时数据 （无告警牌） 
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getMeterRealByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * @Title: getMeterRealByEquNum  
	 * @Desc: 根据设备编号  获取最新的一条实时数据 (全部字段)
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getMeterRealsByEquNum(Map<String, Object> map) throws Exception;
	
	
	/**
	 * @Title: getMeterRealList  
	 * @Desc: 获取设备图表分析数据 （当天的数据集合）  
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getMeterRealList(Map<String, Object> map) throws Exception;
	
	
	
	// 3.历史数据页面
	
	/**
	 * @Title: getMeterHistoryList  
	 * @Desc: 图表分析历史数据（某一天的 数据00：00--23:59）  
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getMeterHistoryList(Map<String, Object> map) throws Exception;
	
	/**
	 * @Title: getMeterHistoryCount  
	 * @Desc: 图表分析历史数据的条数 
	 * @return Integer
	 * @throws
	 */
	Integer getMeterHistoryCount(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getMeterInfLst(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getMeterHistoryGraph(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getMeterRealListMonth(Map<String, Object> map)
			throws Exception;

	List<Map<String, Object>> getMeterHistoryListMonth(Map<String, Object> map)
			throws Exception;

	Map<String, Object> getMeterHistoryListMonthCou(Map<String, Object> map)
			throws Exception;

	List<Map<String, Object>> getMeterHistoryMonthGraph(Map<String, Object> map)
			throws Exception;
	
	
	
}
