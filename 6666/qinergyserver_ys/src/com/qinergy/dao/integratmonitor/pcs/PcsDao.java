package com.qinergy.dao.integratmonitor.pcs;

import java.util.List;
import java.util.Map;

/**
 * 储能逆变器 接口
 * @author zy
 * 
 */
public interface PcsDao {
	
	/**
	 * 储能逆变器 通讯中断 数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsNum0(Map<String,Object> map) throws Exception;
	
	/**
	 * 储能逆变器 正常运行 数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsNum1(Map<String,Object> map) throws Exception;
	
	/**
	 * 储能逆变器 正常停机  数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsNum2(Map<String,Object> map) throws Exception;
	
	/**
	 * 储能逆变器 告警运行  数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsNum3(Map<String,Object> map) throws Exception;
	
	/**
	 * 储能逆变器 故障停机  数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsNum4(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取所有逆变器信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsAll() throws Exception;
	
	/**
	 * 储能逆变器 详情
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsInfoById(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取所有历史信息 显示当天的数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsHistory(Map<String,Object> map) throws Exception;
	
	/**
	 * 储能逆变器 获取所有历史信息  按照年份查询  图标信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsInfoByYear(Map<String,Object> map) throws Exception;
	
	/**
	 * 储能逆变器 获取所有历史信息  按照年份查询  列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsInfoByYearList(Map<String,Object> map) throws Exception;
	
	/**
	 * 储能逆变器 获取所有历史信息  按照月份查询  图标信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsInfoByMonth(Map<String,Object> map) throws Exception;
	
	/**
	 * 储能逆变器 获取所有历史信息  按照月份查询  列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsInfoByMonthList(Map<String,Object> map) throws Exception;
	
	/**
	 * 储能逆变器 获取所有历史信息  按照日查询  列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPcsInfoByDayList(Map<String,Object> map) throws Exception;
	
	 /**
	  * 获取所有实时数据  显示当天信息 图表显示 
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getPcsNow(Map<String,Object> map) throws Exception;

	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取PCS设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPcsInfByEquNum(Map<String, Object> map) throws Exception;

	/**
	 * 储能逆变器 获取所有历史信息  按照日查询  列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPcsInfoByDayListCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 储能逆变器 获取所有历史信息  按照日查询  列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPcsInfoByDayGraph(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取所有实时数据  显示当月信息 图表显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPcsNowMonth(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取所有实时数据  显示当月信息 图表显示(列表)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPcsHistoryMonthLst(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取所有实时数据  显示当月信息 图表显示(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPcsHistoryMonthLstCou(Map<String, Object> map)
			throws Exception;
	
}
