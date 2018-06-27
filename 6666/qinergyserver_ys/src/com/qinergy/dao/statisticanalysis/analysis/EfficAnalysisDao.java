package com.qinergy.dao.statisticanalysis.analysis;

import java.util.List;
import java.util.Map;

/**
 * @desc:	电站分析（电站和设备分析）dao
 * @author: Qist
 * @date: 2017年11月1日
 */
public interface EfficAnalysisDao {

	/**
	 * 根据公司id 获取所属电站列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getStationListByComId(Map<String, Object> map) throws Exception;
	
	/**
	 * 综合效率分析
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverallEffic(Map<String, Object> map) throws Exception;
	
	/**
	 * 公用：电站月运行报表数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMonthDataStation(Map<String, Object> map) throws Exception;
	
	/**
	 * 计划发电量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPlanPvsPower(Map<String, Object> map) throws Exception;
	
	/**
	 *  弃光率 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDiscardRate(Map<String, Object> map) throws Exception;
	
	/**
	 *  损耗分析
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getLossAnalysis(Map<String, Object> map) throws Exception;
	
	/**
	 *  太阳能资源 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSolarEnergyResources(Map<String, Object> map) throws Exception;
	
	/**
	 *  逆变器性能
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getInverterProp(Map<String, Object> map) throws Exception;

	/**
	 * 综合效率分析(光伏)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverallEfficPVS(Map<String, Object> map) throws Exception;

	/**
	 * 综合效率分析(效率)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverallEfficEff(Map<String, Object> map) throws Exception;

	/**
	 * 综合效率分析(辐射)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverallEfficHv(Map<String, Object> map) throws Exception;

	
}
