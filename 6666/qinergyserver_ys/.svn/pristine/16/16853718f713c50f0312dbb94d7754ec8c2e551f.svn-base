/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.integratmonitor;

import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public interface IntegratMonitorService {

	/**
	 * 获取所有厂家信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllManInf() throws Exception;

	/**
	 * 获取所有设备型号信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllAppModInf(Map<String, Object> map) throws Exception;

	/**
	 * 获取下级公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getComInfByFatId(Map<String, Object> map) throws Exception;


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
	 * 获取公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getComInfById(Map<String, Object> map) throws Exception;

	/**
	 * 获取地区信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRegInf(Map<String, Object> map) throws Exception;

	 /**综合监控 start*/
	/**
	 *获取某电站中  某种设备 所有设备编号 （所有设备通用接口）
	 */
    List<Map<String, Object>> getEquNumLstByPwsEquTyp(Map<String, Object> map) throws Exception;
    /**
	 *根据设备编号获取某电站中  某种设备 静态数据 （所有设备通用接口）
	 */
    Map<String, Object> getEquStaticInfByNum(Map<String, Object> map) throws Exception;
    
    /**综合监控 end*/
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
    
    /**
     * 获取电站详情页面的所有信息（除设备类型外）
     * @param map
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getPwsInfByPwsId(Map<String, Object> map) throws Exception;
    
    
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
    Map<String, Object> getDeflInfByEquNumCou(Map<String, Object> map) throws Exception;
    
    /*
   	 * ##########################################
   	 *              综合监控中与站有关的所有接口End
   	 * ##########################################
   	 */

}
