package com.qinergy.dao.integratmonitor.acdb;

import java.util.List;
import java.util.Map;

/**
 * 储能电池  接口
 * @author zy
 * 
 */
public interface AcdbDao {
	
	
	/**
	 * 获取 交流配电柜  设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAcdbInfByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 交流配电柜   查询设备和保修概况
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAcdbInfoNewById(Map<String, Object> map) throws Exception;
	
	 /**
	  * 交流配电柜   查询设备详细信息
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getAcdbById(Map<String, Object> map) throws Exception;
}
