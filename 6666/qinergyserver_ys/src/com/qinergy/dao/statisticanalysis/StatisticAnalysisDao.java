package com.qinergy.dao.statisticanalysis;

import java.util.List;
import java.util.Map;

/**
 * @desc: StatisticAnalysisDao 实现类，无接口
 * @author iceX
 * @date 2016年7月8日15:53:32
 */
public interface StatisticAnalysisDao {
	
	/*--------------------------获取光伏逆变器报表信息Start--------------------------*/
	
	/**
	 * 获取统计信息（包含最大、最小、平均、统计）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPVStaMaxMinAvgSum(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取统计信息（包含最大、最小、平均、统计）(光伏设备详细信息统计)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPVInfStaMaxMinAvgSum(Map<String, Object> map) throws Exception;

	/**
	 * 获取统计信息（包含总计）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPVStaTol(Map<String, Object> map) throws Exception;

	/**
	 * 获取列表中的信息（所有逆变器的发电量数据，每天一条）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPVStaInfLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取列表中的信息（所有逆变器的详细数据，每天一条）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPVInfStaInfLst(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有逆变器的发电量统计信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPVStaInfLstTol(Map<String, Object> map) throws Exception;

	
	
	/*--------------------------获取光伏逆变器报表信息End--------------------------*/
	
	/*--------------------------获取储能逆变器报表信息Start--------------------------*/
	
	/**
	 * 获取统计信息（包含最大、最小、平均、统计）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPCStaMaxMinAvgSum(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取统计信息（包含最大、最小、平均、统计）(储能详情中的统计信息)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPCInfStaMaxMinAvgSum(Map<String, Object> map) throws Exception;

	/**
	 * 获取统计信息（包含总计）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPCStaTol(Map<String, Object> map) throws Exception;

	/**
	 * 获取列表中的信息（所有储能逆变器的充放电量数据，每天一条）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPCStaInfLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取列表中的信息（所有储能逆变器的统计数据，每天一条）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPCInfStaInfLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取所有储能逆变器的充放电量统计信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPCStaInfLstTol(Map<String, Object> map) throws Exception;
	
	/*--------------------------获取储能逆变器报表信息End--------------------------*/
	
	/*--------------------------获取充电桩报表信息Start--------------------------*/
	
	/**
	 * 获取统计信息（包含最大、最小、平均、统计）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChpStaMaxMinAvgSum(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取统计信息（包含最大、最小、平均、统计）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChpInfStaMaxMinAvgSum(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取统计信息（包含总计）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChpStaTol(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取列表中的信息（所有充电桩的充电量数据，每天一条）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChpStaInfLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取列表中的信息（所有充电桩的充电量数据，每天一条）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChpInfStaInfLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取所有充电桩的充电量统计信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getChpStaInfLstTol(Map<String, Object> map) throws Exception;

	
	/*--------------------------获取充电桩报表信息End--------------------------*/
	
	
	
	
	/*--------------------------电量计划Start--------------------------*/
	
	List<Map<String, Object>> getPlanPowerLst(Map<String, Object> map);
	
	List<Map<String, Object>> getPlanPowerLstCou(Map<String, Object> map);

	List<Map<String, Object>> getPlanPowerInfById(Map<String, Object> map);

	void insertPlanPower(Map<String, Object> map);

	void updatePlanPower(Map<String, Object> map);

	void deletePlanPower(Map<String, Object> map);
	
	

	List<Map<String, Object>> getFsbPowerLst(Map<String, Object> map);

	List<Map<String, Object>> getFsbPowerLstCou(Map<String, Object> map);

	List<Map<String, Object>> getFsbPowerInfById(Map<String, Object> map);

	void insertFsbPower(Map<String, Object> map);

	void updateFsbPower(Map<String, Object> map);

	void deleteFsbPower(Map<String, Object> map);
	
	

	List<Map<String, Object>> getFsbHvLst(Map<String, Object> map);

	List<Map<String, Object>> getFsbHvLstCou(Map<String, Object> map);

	List<Map<String, Object>> getFsbHvInfById(Map<String, Object> map);

	void insertFsbHv(Map<String, Object> map);

	void updateFsbHv(Map<String, Object> map);

	void deleteFsbHv(Map<String, Object> map);
	
	/*--------------------------电量计划End--------------------------*/
	
	
	
	/*------------------------------------采集数据查询Start------------------------------------*/
	/**
	 * 获取指定站点下储能逆变器设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquPcsHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下DC/DC设备在指定时间范围下的详情列表信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcdcHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下变压器设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquTransfHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下电表设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquMeterHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下电能质量检测装置设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquPqsmsHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下汇流箱设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquBoxHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下光伏逆变器设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquPvsHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下交流配电柜设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquAcdbHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下直流配电柜设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcdbHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下环境监测仪设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquEnvHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下储能电池设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquBmsHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下解列装置设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDctDevHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下线路保护设备在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquLnePttHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下直流充电桩充电流程信息数据在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcChpOrdHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下直流充电桩充电中实时数据在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcChpRelHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下直流充电桩待机状态信息数据在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcChpStdHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下电动汽车充电信息实时数据在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquChpCarStaHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下电动汽车充电过程信息数据在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquChpCarOrdHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下交流充电桩充电流程信息数据在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquAcChpOrdHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下交流充电桩充电中实时数据在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquAcChpRelHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下交流充电桩待机状态信息数据在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquAcChpStdHistoryInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下的控制器在指定时间范围下的详情列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquCtlHistoryInfLst(Map<String, Object> map);
	
	
	
	
	
	/**
	 * 获取指定站点下储能逆变器设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquPcsHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下DC/DC设备在指定时间范围下的详情列表信息 (分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcdcHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下变压器设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquTransfHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下电表设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquMeterHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下电能质量检测装置设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquPqsmsHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下汇流箱设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquBoxHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下光伏逆变器设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquPvsHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下交流配电柜设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquAcdbHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下直流配电柜设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcdbHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下环境监测仪设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquEnvHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下储能电池设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquBmsHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下解列装置设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDctDevHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下线路保护设备在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquLnePttHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下直流充电桩充电流程信息数据在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcChpOrdHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下直流充电桩充电中实时数据在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcChpRelHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下直流充电桩待机状态信息数据在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquDcChpStdHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下电动汽车充电信息实时数据在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquChpCarStaHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下电动汽车充电过程信息数据在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquChpCarOrdHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下交流充电桩充电流程信息数据在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquAcChpOrdHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下交流充电桩充电中实时数据在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquAcChpRelHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下交流充电桩待机状态信息数据在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquAcChpStdHistoryInfLstCou(Map<String, Object> map);
	/**
	 * 获取指定站点下的控制器在指定时间范围下的详情列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquCtlHistoryInfLstCou(Map<String, Object> map);
	
	/*------------------------------------采集数据查询End------------------------------------*/
	
	
	
	/*------------------------------------采集数据查询End------------------------------------*/
	/**
	 * 获取指定站点下的告警信息在指定时间范围下的列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquFauInfLst(Map<String, Object> map);
	/**
	 * 获取指定站点下的告警信息在指定时间范围下的列表信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getIscsEquFauInfLstCou(Map<String, Object> map);
	
	/*------------------------------------采集数据查询End------------------------------------*/
	
	/*------------------------------------年月电站报表Start------------------------------------*/
	/**
	 * 获取电站中月报表信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsMonthReportInfLst(Map<String, Object> map);
	/**
	 * 获取电站中年报表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsYearReportInfLst(Map<String, Object> map);
	
	/*------------------------------------年月电站报表End------------------------------------*/
	
	/*------------------------------------电站电表信息报表Start------------------------------------*/
	/**
	 * 获取电站中电表报表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsMeterReportInfLst(Map<String, Object> map);
	/**
	 * 获取电站中电表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsMeterInfLst(Map<String, Object> map);

	/**
	 * 获取电站中月报表信息(辐射)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsMonthReportInfLstHv(Map<String, Object> map);

	/**
	 * 获取电站中月报表信息(光伏逆变器)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsMonthReportInfLstPVS(Map<String, Object> map);

	/**
	 * 获取电站中月报表信息(储能逆变器)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsMonthReportInfLstPCS(Map<String, Object> map);

	/**
	 * 获取电站中月报表信息(充电桩)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsMonthReportInfLstChp(Map<String, Object> map);

	/**
	 * 获取电站中年报表信息(辐射)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsYearReportInfLstHv(Map<String, Object> map);

	/**
	 * 获取电站中年报表信息(光伏)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsYearReportInfLstPVS(Map<String, Object> map);

	/**
	 * 获取电站中年报表信息(储能)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsYearReportInfLstPCS(Map<String, Object> map);

	/**
	 * 获取电站中年报表信息(充电桩)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsYearReportInfLstChp(Map<String, Object> map);

	List<Map<String, Object>> getIscsEquMicHistoryInfLst(Map<String, Object> map);

	List<Map<String, Object>> getIscsEquMicHistoryInfLstCou(
			Map<String, Object> map);

	/*------------------------------------电站电表信息报表End------------------------------------*/
}
