package com.qinergy.dao.integratmonitor.ctl;

import java.util.List;
import java.util.Map;


/**
 * 储能电池  接口
 * @author zy
 * 
 */
public interface CtlDao {
	
	
	
	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBmsLstByPwsEquTyp(Map<String, Object> map) throws Exception;
	/**
	 * 获取 控制器 设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getCtlInfByEquNum(Map<String, Object> map) throws Exception;
	/**
	 * 获取 控制器 设备的状态信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getCtlStatByEquNum(Map<String, Object> map) throws Exception;
	
}
