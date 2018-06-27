package com.qinergy.dao.integratmonitor.meter;

import java.util.List;
import java.util.Map;

/**
 * @desc: 电表设备dao
 * @author: Qist
 * @date: 2017年10月27日
 */
public interface MeterDao {
	
	/**
	 * 根据设备编号 获取最新的 设备状态数据 (数据 )
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getMeterRealByEquNum(Map<String, Object> map) throws Exception;

	/**
	 * 查询当天最新的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getMeterRealsByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据设备编号 获取当天的设备分析数据 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMeterRealList(Map<String, Object> map) throws Exception;
	
	/**
	 * 历史分析 根据设备编号 获取设备某一天的 数据00：00到23:59
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMeterHistoryList(Map<String, Object> map) throws Exception;

	/**
	 *  历史分析 根据设备编号 获取设备某一天的 数据00：00到23:59 的条数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getMeterHistoryCount(Map<String, Object> map) throws Exception;

	/**
	 * 获取Meter(电表)设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMeterInfByEquNum(Map<String, Object> map) throws Exception;

	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map) throws Exception;

	/**
	 * 历史分析 根据设备编号 获取设备某一天的 数据00：00到23:59
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMeterHistoryGraph(Map<String, Object> map) throws Exception;
	/**
	 * 根据设备编号 获取当月正反向电度数据(图表)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMeterRealListMonth(Map<String, Object> map)
			throws Exception;
	/**
	 * 根据设备编号 获取当月正反向电度数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMeterHistoryListMonth(Map<String, Object> map)
			throws Exception;
	/**
	 * 根据设备编号 获取当月正反向电度数据(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMeterHistoryListMonthCou(
			Map<String, Object> map) throws Exception;
	
}
