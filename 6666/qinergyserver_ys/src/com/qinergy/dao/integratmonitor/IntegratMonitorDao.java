package com.qinergy.dao.integratmonitor;

import java.util.List;
import java.util.Map;

/**
 * @desc: IntegratMonitorDao 实现类，无接口
 * @author iceX
 * @date 2016年7月8日15:53:32
 */
public interface IntegratMonitorDao {
	

	/**
	 *  获取所有厂家的ID与厂家名称
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllManInf() throws Exception;
	
	/**
	 *  获取所有指定设备类型的设备型号
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllAppModInf(Map<String,Object> map) throws Exception;


	/**
	 * 查询信息，使用上级公司ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getComInfByFatId(Map<String, Object> map)
			throws Exception;

	/**
	 * 查询信息，使用公司ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getComInfById(Map<String, Object> map)
			throws Exception;

	/**
	 * 删除公司信息 
	 * @param map
	 * @throws Exception
	 */
	void delComInf(Map<String, Object> map) throws Exception;

	/**
	 * 删除部门信息
	 * @param map
	 * @throws Exception
	 */
	void delDepInf(Map<String, Object> map) throws Exception;

	/**
	 * 获取地区信息，使用地区ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRegInf(Map<String, Object> map)
			throws Exception;

    
    /*
	 * ##########################################
	 *              综合监控中与站有关的所有接口Start
	 * ##########################################
	 */
    
	/**
	 * 使用电站ID:pws_id,获取该电站中所有的设备类型，返回值中：equ_count设备数量、equ_typ_nam设备类型名称、app_typ_id设备类型ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
    List<Map<String, Object>> getPwsAllAppTypByPwsId(Map<String, Object> map) throws Exception;
    
    
    /*
   	 * ##########################################
   	 *              综合监控中与站有关的所有接口End
   	 * ##########################################
   	 */
    /**综合监控 start*/
    List<Map<String, Object>> getEquNumLstByPwsEquTyp(Map<String, Object> map) throws Exception;
    
    Map<String, Object> getEquStaticInfByNum(Map<String, Object> map) throws Exception;
    /**综合监控 end*/

    /**
	 * 通过电站ID获取电站详情页面中的电站基本信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfByPwsId(Map<String, Object> map) throws Exception;
	
	/**
	 * 通过电站ID获取电站详情页面中的电站图片信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsPicLstByPwsId(Map<String, Object> map) throws Exception;
	
	/**
	 * 通过电站ID获取电站详情页面中的光、储、充、负荷、馈网功率信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPvPcChaLoadLineInfLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取电站详情页面中的光、储、充、负荷、馈网功率信息最新一条
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPvPcChaLoadLineInfByPwsIdTop1(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取光伏月发电量柱状图
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPvPcChaLodMonPowerLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取光伏预测功率曲线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPvFctPowerCurvesLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取调度功率曲线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSchPowerCurvesLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取瞬时辐射和实际光伏功率曲线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getHvRealPowerCurvesLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取电站详情页面中的所有详细当前统计数据信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfTolTop1LstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取电站详情页面中计划年发电量与计划月发电量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsPlanMonYearPowerLstByPwsId(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据设备编号获取 设备变位信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDeflInfByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据设备编号获取 设备变位信息（分页）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDeflInfByEquNumCou(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取光伏月发电量柱状图
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMonPowerLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取月充放电量柱状图
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMonNetPowerLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取月馈网电量柱状图
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMonPcsLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取充电桩充电量柱状图
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMonChaLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取负荷用电量柱状图
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMonEleConLstByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(馈网)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfTolTop1LstByPwsIdNewWork(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(光伏)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfTolTop1LstByPwsIdPVS(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(储能逆变器)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfTolTop1LstByPwsIdPCS(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(充电桩)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfTolTop1LstByPwsIdChp(Map<String, Object> map) throws Exception;

	/**
	 * 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(负荷)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfTolTop1LstByPwsIdLoad(Map<String, Object> map) throws Exception;

}
