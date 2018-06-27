package com.qinergy.dao.statisticanalysis.analysis;

import java.util.Map;

/**
 * @desc:	 能耗分析 dao
 * @author: Qist
 * @date: 2017年11月4日
 */
public interface EnergyConsumAnalysisDao {

	
	/**
	 * 用电量、率统计 按月 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getElecStatistics(Map<String, Object> map) throws Exception;
	
	/**
	 * 当年用电量统计
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getTotalElecStatistics(Map<String, Object> map) throws Exception;
	
	 /**
	  * 厂用电量分析  (按月累计，取最后一条)
	  * @param map
	  * @return
	  * @throws Exception
	  */
	Map<String, Object> getElecAnalysis(Map<String, Object> map) throws Exception;
	
}
