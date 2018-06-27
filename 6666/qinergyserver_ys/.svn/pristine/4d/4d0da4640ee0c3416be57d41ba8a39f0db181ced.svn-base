/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.statisticanalysis.pwssta;

import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @version 1.0
 * @since 1.0
 */

public interface PwsStaService {

	/**
	 * 根据公司id查询地区
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPwsStaInfo(Map<String, Object> map) throws Exception;

	/**
	 * 根据地区查询站点
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getStaByPws(Map<String, Object> map) throws Exception;

	/**
	 * 获取某电站中的统计信息(光储充)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSatInfoByStaId(Map<String, Object> map) throws Exception;
	/**
	 * 获取某电站中的统计信息(光储充)(从月统计表中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSatInfoByStaIdMonth(Map<String, Object> map) throws Exception;

	/**
	 * 获取发电量信息集合（老接口，弃用）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPower(Map<String, Object> map) throws Exception;

	/**
	 * 获取发电量信息集合（新接口）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPowerNew(Map<String, Object> map) throws Exception;

	/**
	 * 获取储能月充放电量集合
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPhiPheSaMon(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取故障设备数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFalEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取电站排行信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPowerRankByComOwner(Map<String, Object> map) throws Exception;

	/**
	 * 获取储能充放电量集合（新接口）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPhiPheNew(Map<String, Object> map)
			throws Exception;
}
