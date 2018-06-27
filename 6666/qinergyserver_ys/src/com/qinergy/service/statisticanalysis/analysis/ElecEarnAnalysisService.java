package com.qinergy.service.statisticanalysis.analysis;

import java.util.List;
import java.util.Map;

/**
 * @desc:	电量与收益分析service 接口
 * @author: Qist
 * @date: 2017年11月4日
 */
public interface ElecEarnAnalysisService {

	
	/**
	 * @Title: getFeaElecAnalysis  
	 * @Desc: 25年 理论和实际的数据分析
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getElecAnalysisBy25Year(String pws_id, String tim_point) throws Exception;
	
	/**
	 * @Title:    
	 * @Desc: 	预测下年上网电量
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getForeElecAnalysis(String pws_id, int type, String tim_point) throws Exception;
	
	
	/**
	 * @Title:    
	 * @Desc: 计划上网电量 一月一条数据     按年查询
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getPlanElecAnalysis(String pws_id, String tim_point) throws Exception;

	/**
	 * @Title:    
	 * @Desc: 计划上网电量 一月一条数据     按年查询(App)
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	Map<String, Object> getPlanElecAnalysisApp(String pws_id, String tim_point)
			throws Exception;
}
