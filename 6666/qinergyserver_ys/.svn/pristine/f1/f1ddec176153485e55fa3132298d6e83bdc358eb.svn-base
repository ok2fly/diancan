package com.qinergy.dao.statisticanalysis.analysis;

import java.util.List;
import java.util.Map;


/**
 * @desc: 功率预测与限电分析dao 
 * @author: Qist
 * @date: 2017年11月4日
 */
public interface PowerRationAnalysisDao {

	/**
	 * 实际、预测、调度下发功率预测 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPowerRation(Map<String, Object> map) throws Exception;
	
	/**
	 * 储能系统分析
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEnergyStorage(Map<String, Object> map) throws Exception;
	
	/**
	 * 计划充放电
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEnergyStoragePlan(Map<String, Object> map) throws Exception;
	
	/**
	 * 光储网荷分析
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getStorNetCharge(Map<String, Object> map) throws Exception;
	
}
