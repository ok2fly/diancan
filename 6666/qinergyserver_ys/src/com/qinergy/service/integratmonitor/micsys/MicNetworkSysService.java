package com.qinergy.service.integratmonitor.micsys;

import java.util.List;
import java.util.Map;

/**
 * 
 * @desc: 微网系统 设备接口
 * @author: Qist
 * @date: 2017年10月27日
 */
public interface MicNetworkSysService {

	// 2.实时数据页面

	/**
	 * 
	 * @Title: getMicSysRealByEquNum
	 * @Desc: 根据设备编号 获取最新的一条实时数据 （无 告警牌）
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getMicSysRealByEquNum(Map<String, Object> map) throws Exception;

	/**
	 * @Desc: 根据设备编号 获取最新的一条实时数据 （全部字段）
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getMicSysRealsByEquNum(Map<String, Object> map) throws Exception;

	/**
	 * 
	 * @Title: getMicSysRealList
	 * @Desc: 获取设备图表分析数据 （当天的数据集合）
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getMicSysRealList(Map<String, Object> map) throws Exception;

	// 3.历史数据页面

	/**
	 * 
	 * @Title: getMicSysHistoryList
	 * @Desc: 图表分功率历史数据（某一天的 数据00：00--23:59）
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getMicSysHistoryList(Map<String, Object> map) throws Exception;

	/**
	 * 
	 * @Title: getMicSysHistoryCount
	 * @Desc: 图表分析历史数据的条数
	 * @return Integer
	 * @throws
	 */
	Integer getMicSysHistoryCount(Map<String, Object> map) throws Exception;

	/**
	 * 
	 * @Title: getMicSysSumPower
	 * @Desc: 统计某一天的电量 
	 * 			tim_typ: 2按月  3按年
	 * @return Map<String,Object>
	 * @throws
	 */
	List<Map<String, Object>> getMicsysTolPower(String equ_num, String day, String tim_typ) throws Exception;

	List<Map<String, Object>> getMicsysInfLst(Map<String, Object> map)
			throws Exception;

	
	
}
