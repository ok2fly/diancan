package com.qinergy.dao.statisticanalysis.analysis;

import java.util.Map;

/**
 * @desc:	 电量与收益分析dao
 * @author: Qist
 * @date: 2017年11月4日
 */
public interface ElecEarnAnalysisDao {

	/**
	 * 理论上网电量和收益  一年一条
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getFeaElecAnalysis(Map<String, Object> map) throws Exception;

	
	/**
	 * 实际上网电量 和收益 一月一条 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getPracElecAndEarnAnalysis(Map<String, Object> map) throws Exception;
	
	/**
	 * 预测数据  按年统计
		数据类型（1：预测上网电量，2：预测上网收益，3：预测辐射量，4：预测上网电量（依据辐射量）） 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getForeElecAndEarnAnalysis(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据类型	1预测上网电量 （根据电量） 4预测上网电量 （根据辐射量）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getForeElecAnalysis(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取计划上网电量   一月一条 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getPlanElecAnalysis(Map<String, Object> map) throws Exception;
	
}
