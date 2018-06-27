package com.qinergy.dao.integratmonitor.dctdev;

import java.util.List;
import java.util.Map;

/**
 * 储能电池  接口
 * @author zy
 * 
 */
public interface DctdevDao {

	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDctdevLstByPwsEquTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取 解列装置  设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDctdevInfByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 解列装置  查询最新设备和保修概况
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDctdevInfoNewById(Map<String, Object> map) throws Exception;
	
	/**
	 * 解列装置 当天 查询图表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDctdevNow(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取 解列装置  编号查看详情
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDctdevId(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 解列装置 按 年 查询图表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDetdevInfoByYear(Map<String, Object> map) throws Exception;
	/**
	 * 解列装置 按 年 查询列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDetdevInfoByYearList(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 环境监测仪 按 月 查询图表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDctdevInfoByMonth(Map<String, Object> map) throws Exception;
	/**
	 * 环境监测仪 按 月 查询列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDctdevInfoByMonthList(Map<String, Object> map) throws Exception;
	
	/**
	 * 解列装置 按 日 查询列表信息(列表)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDctdevInfoByDayList(Map<String, Object> map) throws Exception;

	/**
	 * 解列装置 按 日 查询列表信息(列表,分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDctdevInfoByDayListCou(Map<String, Object> map) throws Exception;

	/**
	 * 解列装置 按 日 查询列表信息(图表)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDctdevInfoByDayGraph(Map<String, Object> map) throws Exception;
}
