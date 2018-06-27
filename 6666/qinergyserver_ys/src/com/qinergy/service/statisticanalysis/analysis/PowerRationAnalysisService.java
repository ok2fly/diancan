package com.qinergy.service.statisticanalysis.analysis;

import java.util.List;
import java.util.Map;

/**
 * @desc: 功率预测与限电分析
 * @author: Qist
 * @date: 2017年11月4日
 */
public interface PowerRationAnalysisService {

	
	
	/**
	 * @Title: getPowerRation  
	 * @Desc: 功率预测与限电分析	
	 * 				查询纬度为 天（间隔15分钟一个数据。一天一条）
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getPowerRation(String pws_id, String tim_point) throws Exception;
	
	/**
	 * @Title: getEnergyStorage  
	 * @Desc: 储能系统分析
	 * 				查询纬度为年
	 * TODO 按电站 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getEnergyStorage(String pws_id, String tim_type, String tim_point) throws Exception;
	
	/**
	 * @Title: getStorNetCharge 
	 * @Desc: 光储网荷分析
	 * 				查询纬度为 天（间隔为15分钟）
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getStorNetCharge(String pws_id, String tim_type, String tim_point) throws Exception;
	
	
	
}
