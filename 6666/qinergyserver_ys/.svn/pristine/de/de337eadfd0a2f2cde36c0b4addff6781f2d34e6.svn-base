package com.qinergy.service.integratmonitor.transf;

import java.util.List;
import java.util.Map;

/**
 * @desc: 变压器设备 接口
 * @author: Qist
 * @date: 2017年10月26日
 */
public interface TransformerService {

	
	//	1.设备统计页面展示
	
	
	// 2.实时数据页面 
	
	/**
	 * @Title: getTransfRealByEquNum  
	 * @Desc: 根据设备编号  获取最新的一条实时数据 （数据  + 告警牌）
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getTransfRealByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * @Desc: 根据设备编号  获取最新的一条实时数据 全部字段
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getTransfRealsByEquNum(Map<String, Object> map) throws Exception;
	
	
	/**
	 * @Title: getTransfRealList  
	 * @Desc: 获取设备图表分析数据 （当天的数据集合） 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getTransfRealList(Map<String, Object> map) throws Exception;
	
	
	
	// 3.历史数据页面
	
	/**
	 * @Title: getTransfHistoryList  
	 * @Desc:  图表分析数据（某一天的 数据00：00--23:59） 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getTransfHistoryList(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * @Title: getTransfHistoryCount  
	 * @Desc: 图表分析数据的条数
	 * @return Integer
	 * @throws
	 */
	Integer getTransfHistoryCount(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getTransfInfLst(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getTransfHistoryGraph(Map<String, Object> map) throws Exception;
	
}
