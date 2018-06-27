package com.qinergy.service.statisticanalysis.analysis;

import java.util.List;
import java.util.Map;

/**
 * @desc: 能耗分析service 接口
 * @author: Qist
 * @date: 2017年11月4日
 */
public interface EnergyConsumAnalysisService {

	/**
	 * @Title: getElecStatistics  
	 * @Desc: 电量统计 按月 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getElecStatistics(String pws_id, String tim_point) throws Exception;

	/**
	 * @Title: getSynthElecAnalysis  
	 * @Desc: 综合电量分析 按年 
	 * @return  Map<String, Object>
	 * @throws
	 */
	List<Map<String, Object>> getSynthElecAnalysis(String pws_id, String tim_point) throws Exception;

	/**
	 * @Title: getElecAnalysis  
	 * @Desc: 厂用电量分析 取最近两年：今年和去年的
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getElecAnalysis(String pws_id, String tim_point) throws Exception;

	/**
	 * @Title: getElecAnalysis  
	 * @Desc: 厂用电量分析 取最近两年：今年和去年的(App)
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getElecAnalysisApp(String pws_id, String tim_point) throws Exception;

}
