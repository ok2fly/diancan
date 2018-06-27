package com.qinergy.dao.integratmonitor.pvs;

import java.util.List;
import java.util.Map;

/**
 * 光伏逆变器 接口
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
public interface PvsDao {
	
	/**
	 * 光伏逆变器-详情 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurves(Map<String,Object> map) throws Exception;
	
	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsDayPowerHistogram(Map<String,Object> map) throws Exception;
	
	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistory(Map<String,Object> map) throws Exception;
	
	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPvsDayPowerHistogramHistory(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取PVS设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPvsInfByEquNum(Map<String,Object> map) throws Exception;

	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（历史的）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistoryLst(Map<String, Object> map) throws Exception;

	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（历史的） 数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistoryLstCou(Map<String, Object> map) throws Exception;
	/**
	 * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））(上一天最后一条)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsPvsDayPowerHistogramFirst(
			Map<String, Object> map) throws Exception;
	
}
