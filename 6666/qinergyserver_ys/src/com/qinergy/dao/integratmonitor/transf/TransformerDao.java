package com.qinergy.dao.integratmonitor.transf;

import java.util.List;
import java.util.Map;

/**
 * @desc: 变压器设备dao
 * @author: Qist
 * @date: 2017年10月26日
 */
public interface TransformerDao {
	

	/**
	 * 根据设备编号 获取最新的 设备状态数据 (数据  + 告警牌) 和设备页面公用的方法
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getTransfRealByEquNum(Map<String, Object> map) throws Exception;

	/**
	 * 根据设备编号 获取最新的 设备状态数据 全部字段
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getTransfRealsByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据设备编号 获取当天的设备分析数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTransfRealList(Map<String, Object> map) throws Exception;
	
	/**
	 * 历史分析根据设备编号 获取设备某一天的 数据00：00到23:59
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTransfHistoryList(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据设备编号 获取设备某一天的 数据00：00到23:59 的条数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Integer getTransfHistoryCount(Map<String, Object> map) throws Exception;

	/**
	 *  获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map)
			throws Exception;

	/**
	 *  获取变压器设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTransfInfByEquNum(Map<String, Object> map)
			throws Exception;

	 /**
	  * 历史分析根据设备编号 获取设备某一天的 数据00：00到23:59(图表)
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getTransfHistoryGraph(Map<String, Object> map)
			throws Exception;
}
