package com.qinergy.dao.integratmonitor.env;

import java.util.List;
import java.util.Map;

/**
 * 环境检测仪  接口
 * @author zy
 * 
 */
public interface EnvDao {
	
	
	/**
	 * 查询所有 环境监测仪 数据
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEnvInfo() throws Exception;
	/**
	 * 查询最新 环境监测仪 数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEnvInfoNew(Map<String,Object> map) throws Exception;
	/**
	 * 环境监测仪 查询最新设备和保修概况
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEnvInfoNewById(Map<String,Object> map) throws Exception;
	
	
	/**
	 * 环境监测仪 按 年 查询图表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEnvInfoByYear(Map<String,Object> map) throws Exception;
	/**
	 * 环境监测仪 按 年 查询列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEnvInfoByYearList(Map<String,Object> map) throws Exception;
	
	
	
	
	/**
	 * 环境监测仪 按 月 查询图表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEnvInfoByMonth(Map<String,Object> map) throws Exception;
	/**
	 * 环境监测仪 按 月 查询列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEnvInfoByMonthList(Map<String,Object> map) throws Exception;
	
	
	
	/**
	 * 环境监测仪 按 日 查询列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEnvInfoByDayList(Map<String,Object> map) throws Exception;
	
	
	
	 /**
	  * 获取某电站中某设备类型的所有设备信息
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getEnvLstByPwsEquTyp(Map<String,Object> map) throws Exception;
	 /**
	  * 获取 设备的最新实时数据(列表页中)
	  * @param map
	  * @return
	  * @throws Exception
	  */
	 public List<Map<String, Object>> getEnvInfByEquNum(Map<String,Object> map) throws Exception;
	
	
	
	/**
	 *  获取  设备的日辐射
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEnvDayHg() throws Exception;

	/**
	 *  环境监测仪 按 日 查询列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEnvInfoByDayListCou(Map<String, Object> map)
			throws Exception;

	/**
	 *  环境监测仪 按 日 查询列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEnvInfoByYearGraph(Map<String, Object> map)
			throws Exception;

	/**
	 *  查询最新 环境监测仪 数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEnvInfoNewFirst(Map<String, Object> map)
			throws Exception;
	/**
	 *  获取某站内环境检测仪的设备数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquInfByPwsIdByForEnv(Map<String, Object> map)
			throws Exception;
	 /**
	  * 环境监测仪 按 日 查询列表信息
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getEnvInfoByYearGraphHistory(
			Map<String, Object> map) throws Exception;
}
