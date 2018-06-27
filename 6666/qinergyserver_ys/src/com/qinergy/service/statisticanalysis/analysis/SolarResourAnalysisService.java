package com.qinergy.service.statisticanalysis.analysis;

import java.util.Map;

/**
 * @desc:	 太阳能资源分析接口
 * @author: Qist
 * @date: 2017年11月4日
 */
public interface SolarResourAnalysisService {

	
	/**
	 * @Title: getRealSolarResources  
	 * @Desc: 理论辐射量和实际辐射量  查询最近12个月 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getSolarResources(String pws_id, String tim_point) throws Exception;
	
	/**
	 * @Title: getRealSolarResources  
	 * @Desc: 理论辐射量和实际辐射量  查询最近12个月  App接口
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getSolarResourcesApp(String pws_id, String tim_point) throws Exception;
	
	

	/**
	 * @Title: getSolarMaxDataEnvInfo  
	 * @Desc:  太阳能资源分布 数据  按天查询   
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getSolarDataByEnvInfo(String pws_id) throws Exception;

	/**
	 * @Title: getRealSolarResources  
	 * @Desc: 理论辐射量和实际辐射量  查询最近12个月 (App)
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getSolarResourcesAp(String pws_id, String tim_point)
			throws Exception;
	
	
}
