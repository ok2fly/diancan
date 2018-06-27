package com.qinergy.dao.statisticanalysis.analysis;

import java.util.List;
import java.util.Map;

/**
 * @desc:	 太阳能资源分析（电站和设备分析）dao
 * @author: Qist
 * @date: 2017年11月4日
 */
public interface SolarResourAnalysisDao {

	/**
	 * 实测辐射量  月统计
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getRealSolarResources(Map<String, Object> map) throws Exception;

	/**
	 * 理论辐射量 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFeaSolarResources(Map<String, Object> map) throws Exception;

//	Map<String, Object> getSolarData(Map<String, Object> map) throws Exception;

	/**
	 * 查询最大环境监测仪 数据  
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSolarDataEnvInfo(Map<String, Object> map) throws Exception;
	

}
