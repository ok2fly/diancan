/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.utils;

import java.util.List;
import java.util.Map;

/**
 * 工具类接口
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public interface UtilsService {

	
	
	/**
	 * 本接口为使用设备编号，获取该编号设备信息（设备详情页面中，右侧设备基础数据信息展示）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquInfByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取综合监控地图中的所有信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOrganizationHierarchyByUse(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取综合监控侧边栏数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIntMonLeftSide(Map<String, Object> map) throws Exception;
	
	/**
	 * 使用字典类型，获取字典表中字典信息下拉列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDicInfLstByDicTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据用户ID获取省份、城市、地区、电站间的从属关系
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsStaInfo(Map<String, Object> map) throws Exception;

	
	/**
	 * 首页电站数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getHomPagPwsCou(Map<String, Object> map) throws Exception;

	/**
	 * 使用设备类型唯一标识获取设备型号
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBasAppByAppTypIde(Map<String, Object> map) throws Exception;

	/**
	 * 获取设备类型列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBasPwsTypLst() throws Exception;

	/**
	 * 获取用户名称
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserName() throws Exception;

	/**
	 * 使用电站ID获取设备类型信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSysBasAppTypeByPwsId(Map<String, Object> map) throws Exception;

	/**
	 * 使用设备类型ID获取设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquNumBySysBasAppTypeId(Map<String, Object> map)
			throws Exception;

	/**
	 * 查询操作日志信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOptLogLst(Map<String, Object> map) throws Exception;

	/**
	 * 查询操作日志信息列表（分页）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getOptLogLstCou(Map<String, Object> map) throws Exception;

	/**
	 * 使用公司名称获取公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getComInfByComNam(Map<String, Object> map) throws Exception;
	
	/**
	 * 查询员工通讯录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getStaffAddressBook(Map<String, Object> map)
			throws Exception;

	
	/**
	 * 根据公司id 获取公司人员
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getUserNameByComId(Map<String, Object> map)
			throws Exception;

	/**
	 * 查询客户通讯录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getCustomerAddressBook(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取运维人员通讯录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUseByStaffAddressBook(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取客户通讯录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUseByCustomerAddressBook(
			Map<String, Object> map) throws Exception;

	/**
	 * 使用菜单ID与用户ID获取按钮列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSelectedButtonLstByModuleId(Map<String, Object> map) throws Exception;

	
	/**
	 * 查询本公司下所有运维人员
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOptUseInfInComLstByOptId(Map<String, Object> map)throws Exception;

	/**
	 * 获取员工通讯录总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getUseByStaffAddressBookCou(
			Map<String, Object> map) throws Exception;

	/**
	 * 运维人员经纬度信息上传
	 * @param map
	 * @throws Exception
	 */
	void insertUseLatLon(Map<String, Object> map) throws Exception;

	/**
	 * 获取客户通讯录总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getUseByCustomerAddressBookCou(Map<String, Object> map)throws Exception;

	/**
	 * 使用IP获取地区信息
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	String getCityByIp(String ip) throws Exception;

}
