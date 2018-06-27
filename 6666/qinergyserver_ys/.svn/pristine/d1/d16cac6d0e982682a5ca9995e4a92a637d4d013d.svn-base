package com.qinergy.dao.integratmonitor.pqsms;

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
public interface PqsmsDao {
	
	/**
	 * 电能质量检测装置-详情 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPqsmsInfByEquNumTopOne(Map<String,Object> map) throws Exception;
	
	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（当天的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurves(Map<String,Object> map) throws Exception;
	
	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电压、电流2-50次谐波柱状图（当天的最新的那条数据））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPqsmsThdUIABCHistogram(Map<String,Object> map) throws Exception;
	
	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistory(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取PQSMS设备的最新实时数据(列表页中)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPqsmsInfByEquNum(Map<String,Object> map) throws Exception;

	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））(列表)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistoryLst(Map<String, Object> map) throws Exception;

	/**
	 * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））(列表,带分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistoryLstCou(Map<String, Object> map) throws Exception;
	
}
