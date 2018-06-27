package com.qinergy.dao.integratmonitor.micsys;

import java.util.List;
import java.util.Map;

public interface MicNetworkSysDao {

	/**
	 * 根据设备编号 获取最新的 设备状态数据 (数据 )
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getMicSysRealByEquNum(Map<String, Object> map) throws Exception;

	/**
	 * 查询最新的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getMicSysRealsByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据设备编号 获取当天的设备分析数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMicSysRealList(Map<String, Object> map) throws Exception;
	
	/**
	 *  历史分析 根据设备编号 获取设备某一天的 数据00：00到23:59
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMicSysHistoryList(Map<String, Object> map) throws Exception;
	
	/**
	 * 历史分析 根据设备编号 获取设备某一天的 数据的条数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getMicSysHistoryCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 历史分析 根据设备编号 获取设备 电量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getMicSysTolPower(Map<String, Object> map) throws Exception;

	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map)
			throws Exception;

	/**
	 *  获取微网（微型电网）的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMicsysInfByEquNum(Map<String, Object> map)
			throws Exception;
}
