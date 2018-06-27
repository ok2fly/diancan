package com.qinergy.dao.statisticanalysis.pwssta;

import java.util.List;
import java.util.Map;

/**
 * @author zy
 */
public interface PwsStaDao {
	
	/**
	 *  根据公司id查询地区
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPwsByComId(Map<String, Object> map) throws Exception;
	
	/**
	 *  根据地区查询站点
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getStaByPws(Map<String, Object> map) throws Exception;
	
	 /**
	  * 根据站点查询信息 年
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getSatInfoByStaId(Map<String, Object> map) throws Exception;
	
	 /**
	  * 根据站点查询信息 月
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getSatInfoByStaIdMonth(Map<String, Object> map) throws Exception;
	
	
	/**
	 *  计划发电量-
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPlanPower(Map<String, Object> map) throws Exception;
	
	 /**
	  * 实际发电量-
	  * @param map
	  * @return
	  * @throws Exception
	  */
	 public List<Map<String, Object>> getMonthPower(Map<String, Object> map) throws Exception;
	
	/**
	 *  计划、实际
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPowerNew(Map<String, Object> map) throws Exception;

	 /**
	  * 获取计划发电量
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getPowerByPlan(Map<String, Object> map) throws Exception;

	/**
	 *  获取实际发电量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPowerByReal(Map<String, Object> map) throws Exception;

	 /**
	  * 获取计划充放电量
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getPhiPheByPlan(Map<String, Object> map)
			throws Exception;

	/**
	 *  获取实际充放电量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPhiPheByReal(Map<String, Object> map)
			throws Exception;

	 /**
	  * 故障数量 前5
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getFalEquNumTop(Map<String, Object> map) throws Exception;

	 /**
	  * 故障数量 后5
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getFalEquNumBoottom(Map<String, Object> map) throws Exception;
	
	
	
	//排行榜（业主）
	 /**
	  * 发电量排行榜 TOP5 Bottom5
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getPowerRankByComTop5Owner(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getPowerRankByComBottom5Owner(Map<String, Object> map) throws Exception;

	/**
	 * 故障排行  TOP5 Bottom5
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFaultRankByComTop5Owner(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getFaultRankByComBottom5Owner(Map<String, Object> map) throws Exception;
	
	/**
	 * 发电有效小时数   TOP5 Bottom5
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPowGenEffHourRankByComTop5Owner(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getPowGenEffHourRankByComBottom5Owner(Map<String, Object> map) throws Exception;
	
	/**
	 * 充电量   TOP5 Bottom5
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChaVolRankByComTop5Owner(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getChaVolRankByComBottom5Owner(Map<String, Object> map) throws Exception;
	
	/**
	 * 充电有效小时数   TOP5 Bottom5
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChaGenEffHourRankByComTop5Owner(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getChaGenEffHourRankByComBottom5Owner(Map<String, Object> map) throws Exception;
	
	
	
	//排行榜（运维公司）
	/**
	 * 发电量排行榜 TOP5 Bottom5
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPowerRankByComTop5Opm(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getPowerRankByComBottom5Opm(Map<String, Object> map) throws Exception;

	/**
	 * 故障排行  TOP5 Bottom5
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFaultRankByComTop5Opm(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getFaultRankByComBottom5Opm(Map<String, Object> map) throws Exception;
	
	/**
	 * 发电有效小时数  TOP5 Bottom5
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPowGenEffHourRankByComTop5Opm(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getPowGenEffHourRankByComBottom5Opm(Map<String, Object> map) throws Exception;
	
	/**
	 * 充电量  TOP5 Bottom5
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChaVolRankByComTop5Opm(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getChaVolRankByComBottom5Opm(Map<String, Object> map) throws Exception;
	
	/**
	 * 充电有效小时数  TOP5 Bottom5
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChaGenEffHourRankByComTop5Opm(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> getChaGenEffHourRankByComBottom5Opm(Map<String, Object> map) throws Exception;

	/**
	 * 根据站点查询信息 年(光伏)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSatInfoByStaIdPVS(Map<String, Object> map) throws Exception;

	/**
	 * 根据站点查询信息 年(充电桩)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSatInfoByStaIdChp(Map<String, Object> map) throws Exception;

	/**
	 * 根据站点查询信息 年(耗损)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSatInfoByStaIdLoss(Map<String, Object> map) throws Exception;

	/**
	 * 根据站点查询信息 年(故障)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSatInfoByStaIdFau(Map<String, Object> map) throws Exception;

	/**
	 * 根据站点查询信息 年(储能)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSatInfoByStaIdPCS(Map<String, Object> map) throws Exception;
	
	
}
