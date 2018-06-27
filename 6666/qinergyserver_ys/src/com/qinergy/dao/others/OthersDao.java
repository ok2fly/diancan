package com.qinergy.dao.others;

import java.util.List;
import java.util.Map;

/**
 * @desc: OthersDao 实现类，无接口
 * @author iceX
 * @date 2016年7月8日15:53:32
 */
public interface OthersDao {
	
	/*------------------------------------考核管理Start------------------------------------*/
	/**
	 * 通过电站ID获取考核管理页面中除了12个月考核评分外的所有数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsAssMagInfByPwsId(Map<String, Object> map);
	/**
	 * 通过电站ID获取考核管理页面中12个月考核评分的所有数据 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsAssMagLstByPwsId(Map<String, Object> map);
	
	
	/*------------------------------------考核管理End------------------------------------*/
	/**
	 * 删除交流充电桩充电流程信息数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquAcChpOrd();
	/**
	 * 删除交流充电桩充电中实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquAcChpRel();
	/**
	 * 删除交流充电桩待机数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquAcChpStd();
	/**
	 * 删除交流配电柜数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquAcDb();
	/**
	 * 删除储能电池实时数据信息表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquBms();
	/**
	 * 删除汇流箱实时数据信息表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquBox();
	/**
	 * 删除电动汽车充电过程信息数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquChpCarOrd();
	/**
	 * 删除电动汽车充电信息实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquChpCarSta();
	/**
	 * 删除控制器信息实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquCtl();
	/**
	 * 删除直流充电桩充电流程信息数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquDcChpOrd();
	/**
	 * 删除直流充电桩充电中实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquDcChpRel();
	/**
	 * 删除直流充电桩待机状态信息数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquDcChpStd();
	/**
	 * 删除直流配电柜信息数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquDcDb();
	/**
	 * 删除DC/DC(直流转直流电源)信息数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquDcdc();
	/**
	 * 删除解列装置实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquDctDev();
	/**
	 * 删除环境监测仪实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquEnv();
	/**
	 * 删除线路保护实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquLnePtt();
	/**
	 * 删除电表实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquMeter();
	/**
	 * 删除微网系统实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquMicSys();
	/**
	 * 删除储能逆变器实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquPcs();
	/**
	 * 删除电能质量监测装置实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquPqsms();
	/**
	 * 删除光伏逆变器实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquPvs();
	/**
	 * 删除变压器实时数据表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delIscsEquTransf();
	
	/**
	 * 获取最后检修日期
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getLastOverhaulDate(Map<String, Object> map);
	
	/**
	 * 获取最后维修日期 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getLasMaintenanceDate(Map<String, Object> map);
	
	/**
	 * 获取下次检修日期
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getNextOverhaulDate(Map<String, Object> map);
	
	/**
	 * 获取告警状态信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAlaStaInf(Map<String, Object> map);
	
	/**
	 * 获取累计维修次数
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getTolMaintenanceCount(Map<String, Object> map);
	
	
	 /**
	  * 获取历史告警记录
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> getAlaHistoryLst(Map<String, Object> map);
	
	/**
	 *  获取历史告警记录(分页)
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAlaHistoryLstCou(Map<String, Object> map);
	
	/**
	 *  获取设备维修记录
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getMaintenanceLst(Map<String, Object> map);
	
	 /**
	  * 获取设备维修记录(分页)
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> getMaintenanceLstCou(Map<String, Object> map);
	
	/**
	 *  获取设备检修（保养）记录 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getOverhaulLst(Map<String, Object> map);
	
	/**
	 *  获取设备检修（保养）记录(分页)
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getOverhaulLstCou(Map<String, Object> map);
	
	
	/*-------------------------------------以下为与通知有关的所有接口-------------------------------------*/
	
	/**
	 *  获取系统中所有正在发生的告警信息，获取：设备类型唯一标识、设备编号、设备ID、电站ID、设备类型ID
	 * @return
	 */
	 List<Map<String, Object>> getSysAllGenAlaInf();
	
	 /**
	  * 使用正在发生的告警ID,获取与其有关的人员信息列表，is_def_sta = 1 
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> getUseIdLstByGenAlaId(Map<String, Object> map);
	
	/**
	 *  使用用户ID获取通知信息列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getNoticeInfByUseId(Map<String, Object> map);
	
	 /**
	  * 添加通知信息 
	  * @param map
	  */
	void insNoticeInf(Map<String, Object> map);
	
	/**
	 *  更新阅读状态（是否已阅读）
	 * @param map
	 */
	void updNoticeState(Map<String, Object> map);
	
	/*-------------------------------------以下为与公告有关的所有接口-------------------------------------*/
	
	/**
	 *  添加公告信息
	 * @param map
	 */
	 void insAnnInf(Map<String, Object> map);
	
	/**
	 *  更新阅读状态（是否已阅读）
	 * @param map
	 */
	void updAnnInf(Map<String, Object> map);
	
	/**
	 *  删除公告信息 
	 * @param map
	 */
	void delAnnInf(Map<String, Object> map);
	
	/**
	 *  使用公告ID获取公告信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAnnInfById(Map<String, Object> map);
	
	/**
	 *  获取公告信息列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAnnInfLst(Map<String, Object> map);
	
	/**
	 *  获取公告信息列表(分页)
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAnnInfLstCou(Map<String, Object> map);
	
	/**
	 *  获取首页中运维信息数据 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getFstPagOptInf(Map<String, Object> map);
	
	/*-------------------------------------以下为与计划充放电量有关的所有接口-------------------------------------*/
	
	/**
	 *  添加计划充放电量
	 * @param map
	 */
	 void insPlanPhiPhe(Map<String, Object> map);
	
	/**
	 *  修改计划充放电量
	 * @param map
	 */
	void updPlanPhiPhe(Map<String, Object> map);
	
	/**
	 *  删除计划充放电量信息
	 * @param map
	 */
	void delPlanPhiPheInf(Map<String, Object> map);
	
	/**
	 *  使用计划充放电量ID获取计划充放电量信息 -
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPlanPhiPheInfById(Map<String, Object> map);
	
	/**
	 *  获取计划充放电量信息列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPlanPhiPheLst(Map<String, Object> map);
	
	 /**
	  * 获取计划充放电量信息列表(分页)
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> getPlanPhiPheLstCou(Map<String, Object> map);
	 
	/**
	 *  电量计划 光伏计划发电量表 列表显示 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selPvPlanPower(Map<String, Object> map)
			throws Exception;
	 
	/**
	 *  电量计划 光伏计划发电量表 增加
	 * @param map
	 * @throws Exception
	 */
	void insPvPlanPower(Map<String, Object> map) throws Exception;
	 
	 /**
	  * 电量计划 光伏计划发电量表 修改
	  * @param map
	  * @throws Exception
	  */
	void updPvPlanPower(Map<String, Object> map) throws Exception;
	 
	/**
	 *  电量计划 光伏计划发电量表 数据回显
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selPvPlanPowerById(Map<String, Object> map)
			throws Exception;
	 
	/**
	 *  电量计划 光伏计划发电量表 删除 
	 * @param map
	 * @throws Exception
	 */
	void delPvPlanPowerById(Map<String, Object> map) throws Exception;
	
	/*-------------------------------------以下为与理论发电量有关的所有接口-------------------------------------*/
	
	 /**
	  * 添加理论发电量
	  * @param map
	  */
	 void insFsbPower(Map<String, Object> map);
	
	/**
	 *  修改理论发电量
	 * @param map
	 */
	void updFsbPower(Map<String, Object> map);
	 
	/**
	 *  删除理论发电量信息
	 * @param map
	 */
	void delFsbPowerInf(Map<String, Object> map);
	
	 /**
	  * 使用理论发电量ID获取理论发电量信息
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> getFsbPowerInfById(Map<String, Object> map);
	
	 /**
	  * 获取理论发电量信息列表
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> getFsbPowerLst(Map<String, Object> map);
	
	 
	 /**
	  * 获取理论发电量信息列表(分页)
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> getFsbPowerLstCou(Map<String, Object> map);
	
	/*-------------------------------------以下为与理论辐射量有关的所有接口-------------------------------------*/
	
	/**
	 *  添加理论辐射量
	 * @param map
	 */
	 void insFsbHv(Map<String, Object> map);
	
	/**
	 *  修改理论辐射量 
	 * @param map
	 */
	void updFsbHv(Map<String, Object> map);
	
	/**
	 *  删除理论辐射量信息 
	 * @param map
	 */
	void delFsbHvInf(Map<String, Object> map);
	
	/**
	 *  使用理论辐射量ID获取理论辐射量信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getFsbHvInfById(Map<String, Object> map);
	
	/**
	 *  获取理论辐射量信息列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getFsbHvLst(Map<String, Object> map);
	
	/**
	 *  获取理论辐射量信息列表(分页)
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getFsbHvLstCou(Map<String, Object> map);
	 
	 /**
	  * 获取某设备实时的告警信息
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getRelFauLst(Map<String, Object> map)
			throws Exception;
	 
	/**
	 *  获取某设备类型所关联的告警码
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAlaCodByAppTypId(Map<String, Object> map)
			throws Exception;
	
	/**
	 * 获取设备健康评分曲线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquHealthCurve(Map<String, Object> map) throws Exception;
	/**
	 * 获取设备健康评分(最新那条)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquHealthScorTop(Map<String, Object> map) throws Exception;
	/**
	 * 查询设备信息，以电站ID为条件 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquInfByPws(Map<String, Object> map) throws Exception;
	
	/**
	 * 添加系统通知信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	int insSysNoticeInf(Map<String, Object> map) throws Exception;
	
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
	 * 使用公司类型获取所有指定公司类型的数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAllComCountByComTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取所有运维人员数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAllOptUseCou() throws Exception;
	
	/**
	 * 通过电站ID获取月消缺率信息以及月总故障数以及电站效益提升率
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRidNumFauNumAscRateInf(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> selPvPlanPowerCou(Map<String, Object> map)
			throws Exception;
	
	/**
	 *  交流充电桩-详情,待机数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsAcchpStdInfByEquNumNew(Map<String, Object> map) throws Exception;
	/**
	 * 交流充电桩-详情,充电中实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsAcchpRelInfByEquNumNew(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取 交流配电柜  设备的最新实时数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAcdbInfByEquNumNew(Map<String, Object> map)throws Exception;
	
	/**
	 * 查询储能电池  最新实时数据  根据编号
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBmsInfoByEquNumNew(Map<String, Object> map)throws Exception;
	
	
	/**
	 * 汇流箱-详情 （获取最新那条数据，包含支路电流数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsBoxInfByEquNumNew(Map<String, Object> map)throws Exception;
	
	/**
	 * 直流充电桩-详情,待机数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsDcchpStdInfByEquNumNew(Map<String, Object> map) throws Exception;
	
	/**
	 * 直流充电桩-详情,实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsDcchpRelInfByEquNumNew(Map<String, Object> map) throws Exception;
	/**
	 *  获取 直流配电柜  设备的最新实时数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDcdbInfByEquNumNew(Map<String, Object> map)throws Exception;
	
	/**
	 * 获取电站天统计数据表（每天统计一次（建议凌晨0点到0点5分之间进行统计））(光伏逆变器)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsStaPV(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取电站月统计数据表（每天统计一次（建议凌晨0点到0点5分之间进行统计））(光伏逆变器)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsStaMonPV(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取电站天统计数据表（每天统计一次（建议凌晨0点到0点5分之间进行统计））(光伏逆变器)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsStaDayPV(Map<String, Object> map)
			throws Exception;
	
	List<Map<String, Object>> getPwsSta15MinPV(Map<String, Object> map)
			throws Exception;
	
	/**
	 *  获取 环境检测仪  设备的最新实时数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEnvInfByEquNumNew(Map<String, Object> map)throws Exception;
	/**
	 *  获取 储能逆变器  设备的最新实时数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPcsInfByEquNumNew(Map<String, Object> map)throws Exception;
	/**
	 *  获取电能质量监测  设备的最新实时数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPqsmsInfByEquNumNew(Map<String, Object> map)throws Exception;
	
	/**
	 *  获取  光伏逆变器  设备的最新实时数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPvsInfByEquNumNew(Map<String, Object> map)throws Exception;
	
	/**
	 * 获取电站效率集合
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getComEffLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取月充放电量数据 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsStaPCSLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 使用用户ID获取依照地区排序后的充电容量排行
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChpRtdPowRankByRegByUse(Map<String, Object> map) throws Exception;
	
	/**
	 * 使用用户ID获取与该用户有关的所有设备（传入设备类型）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquLstByUseIdByAppTypIde(Map<String, Object> map) throws Exception;
	
	/**
	 * 使用设备编码，获取交流充电装设备的累计充电小时数、累计充电电量、累计充电次数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAcChpCumTimPowCntByEquNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 使用设备编码，获取直流流充电装设备的累计充电小时数、累计充电电量、累计充电次数 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDcChpCumTimPowCntByEquNum(Map<String, Object> map) throws Exception;
	
	
	/**
	 *  更新用户  站查看状态
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void updUserSltOptStaByUserId(Map<String, Object> map) throws Exception;
	
	/**
	 *  更新用户  对告警信息是否可见
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void updUserIsDefStaByUserId(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> getUserInfByIsDefSta() throws Exception;
	
	/**
	 * 获取系统中与当前人有关的设备,以当前时间为准1分钟以内的所有发生告警的设备编号
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquNumByFau(Map<String,Object> inpMap)
			throws Exception;
	/**
	 * 更新阅读状态
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void updNoticeStateByEquNumFauTim(Map<String, Object> map);
	
	/**
	 * 获取某电站中某设备类型的所有设备信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getEquLstByPwsEquTypIde(Map<String, Object> map) throws Exception;
	
	/**
	 *  变压器-详情,实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsTranfRelInfByEquNumNew(Map<String, Object> map) throws Exception;
	
	 /**
	  * 获取安卓最新版本
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getNewAppVarsion() throws Exception;
	
	/**
	 *  使用用户ID获取告警列表信息，改列表中，不包含已关闭的通知信息(即，为用户展示的告警通知信息) 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	 List<Map<String, Object>> getSysAlarmByUseId(Map<String, Object> map)
			throws Exception;
}
