/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.others;

import java.util.List;
import java.util.Map;

/**
 * 其它类型接口类(包含共用型接口)
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public interface OthersService {
	
	/*------------------------------------考核管理Start------------------------------------*/
	/**
	 * 获取考核管理页面中所有的数据信息
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPwsAssMagInfByPwsId(Map<String, Object> map) throws Exception;

	/*------------------------------------考核管理End------------------------------------*/
	
	/**
	 * 获取综合监控中设备运维信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIntEquOpeInf(Map<String, Object> map) throws Exception;

	/**
	 * 获取告警历史信息集合
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAlaHistoryLst(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取告警历史信息集合（分页）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getAlaHistoryLstCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取设备维修信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getMaintenanceLst(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取设备维修信息列表（分页）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getMaintenanceLstCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取检修信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulLst(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取检修信息列表(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getOverhaulLstCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 使用用户ID获取告警信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getNoticeInfByUseId(Map<String, Object> map)
			throws Exception;

	/**
	 * 更新告警信息的是否已读状态
	 * @param map
	 * @throws Exception
	 */
	void updNoticeState(Map<String, Object> map) throws Exception;
	
	/*-------------------------------------以下为与公告有关的所有接口-------------------------------------*/
	/**
	 * 添加公告信息
	 * @param map
	 * @throws Exception
	 */
	void insAnnInf(Map<String, Object> map) throws Exception;
	/**
	 * 修改公告信息
	 * @param map
	 * @throws Exception
	 */
	void updAnnInf(Map<String, Object> map) throws Exception;
	
	/**
	 * 删除公告信息
	 * @param map
	 * @throws Exception
	 */
	void delAnnInf(Map<String, Object> map) throws Exception;
	
	/**
	 * 使用公告ID获取公告信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAnnInfById(Map<String, Object> map)
			throws Exception;
	
	/**
	 * 获取公告列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAnnInfLst(Map<String, Object> map)
			throws Exception;
	
	/**
	 * 获取公告列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getAnnInfLstCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 首页中运维信息统计与获取
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getFstPagOptInf(Map<String, Object> map)
			throws Exception;

	/*-------------------------------------以下为与计划充放电量有关的所有接口-------------------------------------*/
	
	/**
	 * 添加储能充放电计划
	 * @param map
	 * @throws Exception
	 */
	void insPlanPhiPhe(Map<String, Object> map) throws Exception;

	/**
	 * 修改储能充放电计划
	 * @param map
	 * @throws Exception
	 */
	void updPlanPhiPhe(Map<String, Object> map) throws Exception;

	/**
	 * 删除储能充放电计划
	 * @param map
	 * @throws Exception
	 */
	void delPlanPhiPheInf(Map<String, Object> map) throws Exception;

	/**
	 * 使用ID获取储能充放电计划
	 * @param map
	 * @throws Exception
	 */
	List<Map<String, Object>> getPlanPhiPheInfById(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取充放电计划列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPlanPhiPheLst(Map<String, Object> map)
			throws Exception;
	
	/**
	 * 获取充放电计划列表(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getPlanPhiPheLstCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 查询计划发电量列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selPvPlanPower(Map<String, Object> map)
			throws Exception;

	/**
	 * 删除计划发电量信息
	 * @param map
	 * @throws Exception
	 */
	void delPvPlanPowerById(Map<String, Object> map) throws Exception;

	/**
	 * 使用某条计划发电量ID获取计划发电量信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selPvPlanPowerById(Map<String, Object> map)
			throws Exception;

	/**
	 * 添加或修改计划发电量信息
	 * @param map
	 * @throws Exception
	 */
	void insOrUpdPvPlanPower(Map<String, Object> map)throws Exception;

	
	/*-------------------------------------以下为与理论发电量有关的所有接口-------------------------------------*/
	/**
	 * 添加理论发电量
	 * @param map
	 * @throws Exception
	 */
	void insFsbPower(Map<String, Object> map) throws Exception;

	/**
	 * 修改理论发电量
	 * @param map
	 * @throws Exception
	 */
	void updFsbPower(Map<String, Object> map) throws Exception;

	/**
	 * 删除理论发电量
	 * @param map
	 * @throws Exception
	 */
	void delFsbPowerInf(Map<String, Object> map) throws Exception;

	/**
	 * 获取某一条理论发电量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFsbPowerInfById(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取理论发电量列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFsbPowerLst(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取理论发电量列表(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getFsbPowerLstCou(Map<String, Object> map)
			throws Exception;

	/*-------------------------------------以下为与理论辐射量有关的所有接口-------------------------------------*/
	/**
	 * 添加理论辐射量数据
	 * @param map
	 * @throws Exception
	 */
	void insFsbHv(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改理论辐射量数据
	 * @param map
	 * @throws Exception
	 */
	void updFsbHv(Map<String, Object> map) throws Exception;

	/**
	 * 删除理论辐射量数据
	 * @param map
	 * @throws Exception
	 */
	void delFsbHvInf(Map<String, Object> map) throws Exception;

	/**
	 *获取某一条理论辐射量数据
	 * @param map
	 * @throws Exception
	 */
	List<Map<String, Object>> getFsbHvInfById(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取理论辐射量数据列表
	 * @param map
	 * @throws Exception
	 */
	List<Map<String, Object>> getFsbHvLst(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取理论辐射量数据列表（分页）
	 * @param map
	 * @throws Exception
	 */
	Map<String, Object> getFsbHvLstCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取设备告警牌的数据
	 * @param map
	 * @throws Exception
	 */
	List<Map<String, Object>> getRelFauLst(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取设备健康评分曲线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquHealthCurve(Map<String, Object> map)
			throws Exception;
	
	/**
	 * 获取首页设备健康状态以及设备健康率
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquHealthScor(Map<String, Object> map)
			throws Exception;

	
	/**
	 * 更新阅读状态（是否已阅读）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	int updSysNoticeState(Map<String, Object> map) throws Exception;

	/**
	 * 使用用户ID获取系统通知信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getSysNoticeInfByUseId(Map<String, Object> map) throws Exception;
	/**
	 * 获取合作伙伴数量与运维人员数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOptComCouAndOptUseCouLst() throws Exception;

	/**
	 * 通过电站ID获取月消缺率信息以及月总故障数以及电站效益提升率
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRidNumFauNumAscRateInf(Map<String, Object> map) throws Exception;

	/**
	 * 获取计划发电量列表（分页计数）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selPvPlanPowerCou(Map<String, Object> map)throws Exception;

	/**
	 * 获取某设备实时的告警信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRelFauLstApp(Map<String, Object> map)
			throws Exception;
	/**
	 * 交流充电桩-详情,待机数据 （获取最新那条数据)
	 * 交流充电桩-详情,充电中实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getIscsAcchpStdAndRelByEquNumNew(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取 交流配电柜  设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAcdbInfByEquNumNew(Map<String, Object> map)
			throws Exception;
	/**
	 * 查询储能电池  最新实时数据  根据编号
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBmsInfoByEquNumNew(Map<String, Object> map)
			throws Exception;
	/**
	 * 汇流箱-详情 （获取最新那条数据，包含支路电流数据）
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsBoxInfByEquNumNew(Map<String, Object> map)
			throws Exception;
	/**
	 * 控制器-详情 （获取最新那条数据，包含支路电流数据）
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getCtlInfByEquNumNew(Map<String, Object> map)
			throws Exception;
	/**
	 * 直流充电桩-详情,待机数据 （获取最新那条数据）
	 * 直流充电桩-详情,实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getIscsDcchpStdAndRelByEquNumNew(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取 直流配电柜  设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDcdbInfByEquNumNew(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取  获取 解列装置   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDctdevInfByEquNumNew(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取  第二类大屏第一屏数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBigScreenOne(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取 环境检测仪   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEnvInfByEquNumNew(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取   线路保护   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getLnepttInfByEquNum(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取   储能逆变器   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPcsInfByEquNumNew(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取   电能质量监测   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPqsmsInfByEquNumNew(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取   光伏逆变器   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPvsInfByEquNumNew(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取 大屏第二屏数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBigSceensInf2(Map<String, Object> map)
			throws Exception;
	/**
	 * 更新用户  站查看状态
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void updUserSltOptStaByUserId(Map<String, Object> map) throws Exception;
	/**
	 * 更新用户  对告警信息是否可见
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void updUserIsDefStaByUserId(Map<String, Object> map) throws Exception;

	/**
	 * 获取告警状态信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAlaSta(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取   变压器   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsTranfRelInfByEquNumNew(
			Map<String, Object> map) throws Exception;
	/**
	 * 获取安卓最新版本
	 * 
	 * @param map
	 * @return 
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getNewAppVarsion() throws Exception;
}
