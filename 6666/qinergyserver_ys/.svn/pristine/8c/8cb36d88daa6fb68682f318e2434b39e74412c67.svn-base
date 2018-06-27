package com.qinergy.dao.integratmonitor.bms;

import java.util.List;
import java.util.Map;

/**
 * 储能电池  接口
 * @author zy
 * 
 */
public interface BmsDao {
	
	/**
	 * 查询所有 储能电池 数据
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsInfo() throws Exception;
	
	/**
	 * 查询储能电池 根据编号查看详情
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsInfoNew(Map<String, Object> map) throws Exception;
	
	/**
	 * 查询储能电池 当天图表信息数据显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsInfoList(Map<String, Object> map) throws Exception;
	
	/**
	 * 查询储能电池 最新数据的设备和保修概况
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsInfoListById(Map<String, Object> map) throws Exception;
	
	
	
	
	/**
	 * 储能电池 按 年 查询图表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsInfoByYear(Map<String, Object> map) throws Exception;
	
	/**
	 * 储能电池 按 年 查询列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsInfoByYearList(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 * 储能电池 按 月 查询图表信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsInfoByMonth(Map<String, Object> map) throws Exception;
	
	/**
	 * 储能电池 按 月 查询列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsInfoByMonthList(Map<String, Object> map) throws Exception;
	
	
	 /**
	  * 储能电池 按  日  查询列表信息
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getBmsInfoByDayList(Map<String, Object> map) throws Exception;
	
	
	
	public List<Map<String, Object>> getBmsStatOne() throws Exception;
	
	public List<Map<String, Object>> getBmsStatTwo() throws Exception;
	
	public List<Map<String, Object>> getBmsStatThree() throws Exception;
	
	public List<Map<String, Object>> getBmsStatFour() throws Exception;
	
	public List<Map<String, Object>> getBmsStatFive() throws Exception;
	
	
	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsLstByPwsEquTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取 电池 设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsInfByEquNum(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> getBmsInfoByDayListCou(Map<String, Object> map) throws Exception;

	/**
	 * 储能电池 按  日  查询列表信息(分页) 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBmsInfoByDayGraph(Map<String, Object> map) throws Exception;
	
	
}
