package com.qinergy.dao.integratmonitor.acchp;

import java.util.List;
import java.util.Map;

/**
 * 交流充电桩 接口
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
public interface AcchpDao {
	
	/**
	 * 交流充电桩-详情,待机数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsAcchpStdInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 交流充电桩-详情,实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsAcchpRelInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 交流充电桩-详情 （获取交流充电桩设备的电流、电压曲线（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsAcchpRelUICurves(Map<String,Object> map) throws Exception;
	
	/**
	 * 交流充电桩-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））(使用订单信息获取)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsAcchpRelUICurvesHistory(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取交流充电桩设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAcchpInfByEquNum(Map<String,Object> map) throws Exception;

	/**
	 * 交流充电桩-详情 （获取订单信息）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsAcchpOrdInfLst(Map<String, Object> map) throws Exception;

	/**
	 * 交流充电桩-详情 （获取订单信息）（分页）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsAcchpOrdInfLstCou(Map<String, Object> map) throws Exception;
	
}
