package com.qinergy.dao.integratmonitor.lneptt;

import java.util.List;
import java.util.Map;


/**
 * 储能电池  接口
 * @author zy
 * 
 */
public interface LnepttDao {
	
	
	
	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getLnepttLstByPwsEquTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取 线路保护 设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getLnepttInfByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取 线路保护 编号查看详情
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getLnepttById(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取 线路保护 id查看设备和保修概况
	 */
	public List<Map<String, Object>> getLnepttInfoById(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取所有实时数据  显示当天信息 图表显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getLnepttNow(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 * 线路保护  获取所有历史信息  按照年份查询  图标信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getLnepttInfoByYear(Map<String, Object> map) throws Exception;
	
	/**
	 * 线路保护  获取所有历史信息  按照年份查询  列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getLnepttInfoByYearList(Map<String, Object> map) throws Exception;
	
	/**
	 * 线路保护  获取所有历史信息  按照月份查询  图标信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getLnepttInfoByMonth(Map<String, Object> map) throws Exception;
	
	/**
	 * 储能逆变器 获取所有历史信息  按照月份查询  列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getLnepttInfoByMonthList(Map<String, Object> map) throws Exception;
	
	/**
	 * 线路保护 获取所有历史信息  按照日查询  列表信息（信息列表）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getLnepttInfoByDayList(Map<String, Object> map) throws Exception;

	/**
	 * 线路保护 获取所有历史信息  按照日查询  列表信息（分页）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getLnepttInfoByDayListCou(Map<String, Object> map)
			throws Exception;

	 /**
	  * 线路保护 获取所有历史信息  按照日查询  列表信息(图表)
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getLnepttInfoByDayGraph(Map<String, Object> map)
			throws Exception;
	
}
