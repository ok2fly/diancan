package com.qinergy.service.statisticanalysis.analysis;

import java.util.List;
import java.util.Map;

/**
 * @desc: 电站分析（电站和设备分析）service 接口
 * @author: Qist
 * @date: 2017年11月1日
 */
public interface EfficAnalysisService {

	
	/**
	 * @Title: getStationListByComId  
	 * @Desc: 根据公司id 获取所属电站列表 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getStationListByComId(Map<String, Object> map) throws Exception;
	
	/**
	 * @Title: getOverallEffic  
	 * @Desc: 综合效率  （关口表功率/逆变器直流侧功率）	
	 * 				查询纬度为 年
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getOverallEffic(String pws_id, String tim_type, String tim_point) throws Exception;
	
	
	/**
	 * @Title: getPlanComplRate  
	 * @Desc: 计划完成率 
	 * 				查询纬度为年
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getPlanComplRate(String pws_id, String tim_type, String tim_point) throws Exception;
	
	/**
	 * @Title: getDiscardRate 
	 * @Desc: 弃光率
	 * 				查询纬度为月和年
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getDiscardRate(String pws_id, String tim_type, String tim_point) throws Exception;
	
	
	/**
	 * @Title: getLossAnalysis  
	 * @Desc: 损耗分析 
	 * 				查询纬度为月和年
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getLossAnalysis(String pws_id, String tim_type, String tim_point) throws Exception;
	
	
	/**
	 * @Title: getSolarEnergyResources  
	 * @Desc: 太阳能资源 
	 * 				查询纬度为日
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getSolarEnergyResources(String pws_id, String tim_point) throws Exception;
	
	/**
	 * @Title: getInverterProp  
	 * @Desc: 逆变器性能 
	 * 				查询纬度为月
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getInverterProp(String pws_id, String tim_point) throws Exception;
}
