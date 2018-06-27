package com.qinergy.dao.integratmonitor.dcdc;

import java.util.List;
import java.util.Map;

/**
 * 	DCDC
 * @desc: 
 * @author: Qist
 * @date: 2017年10月25日
 */
public interface DcdcDao {
	
	/**
	 * 通过编号查询dcdc
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getDCDCRealByNum(Map<String, Object> map) throws Exception;
	
   /**
    * 查询最新的cdcd信息
    * @param map
    * @return
    * @throws Exception
    */
	Map<String, Object> getDCDCRealsByNum(Map<String, Object> map) throws Exception;

    /**
     * 根据设备编号 获取当天的设备分析数据 
     * @param map
     * @return
     * @throws Exception
     */
	List<Map<String, Object>> getDCDCRealList(Map<String, Object> map) throws Exception;

    /**
     * 根据设备编号获取 设备静态信息
     * @param map
     * @return
     * @throws Exception
     */
	Map<String, Object> getDCDCEquByNum(Map<String, Object> map) throws Exception;
	
    /**
     * 历史分析 根据设备编号 获取设备某一天的 数据00：00到23:59 的条数 
     * @param map
     * @return
     * @throws Exception
     */
	Map<String, Object> getDCDCHistoryCount(Map<String, Object> map) throws Exception;
	
	
	/***********************************************************************************/
   
	/**
	 * 历史分析 根据设备编号 获取设备某一天的 数据00：00到23:59
	 * @param map
	 * @return
	 * @throws Exception
	 */
    List<Map<String, Object>> getDCDCHistoryList(Map<String, Object> map) throws Exception;
	
    
	List<Map<String, Object>> getDCDCFaultList(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> getDCDCRepairList(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> getDCDCMainList(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> getDCDCHealthList(Map<String, Object> map) throws Exception;
	
	
	
	
	List<Map<String, Object>> getDCDCStatCount(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> getDCDCEquList(Map<String, Object> map) throws Exception;

	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取DC/DC设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDcdcInfByEquNum(Map<String, Object> map)
			throws Exception;
	/**
	 * 历史分析 根据设备编号 获取设备某一天的 数据00：00到23:59(图表)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDCDCHistoryGraph(Map<String, Object> map)
			throws Exception;
}
