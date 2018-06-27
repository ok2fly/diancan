/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.statisticanalysis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.statisticanalysis.StatisticAnalysisDao;
import com.qinergy.dao.system.SystemDao;
import com.qinergy.util.DateUtil;

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

@Service
public class StatisticAnalysisServiceImpl implements StatisticAnalysisService {

	@Autowired
	StatisticAnalysisDao statisticAnalysisDao;

	@Autowired
	SystemDao systemDao;

	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPVStaMonYear(Map<String, Object> map) throws Exception {
		// 获取某年、月、日起始和结束时间点集合
		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), map.get("type").toString());

		// 获取该站内所有的光伏逆变器设备
		List<Map<String, Object>> equInfLst = systemDao.getEquInfLstByPwsIdAppTyp(map);
		// 返回值集合
		List<Map<String, Object>> returnLst = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		// 所有光伏设备,每一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合
		List<Map<String, Object>> maxMinAvgSumAndPowerLst = new ArrayList<Map<String, Object>>();
		
		for (Map<String, Object> dayMonYearTimMap : dayMonYearTimLst) {
			// 所有光伏设备,某一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合
			Map<String, Object> maxMinAvgSumAndPowerMap = new HashMap<String, Object>();

			Map<String, Object> inpMaxMinAvgSumMap = new HashMap<String, Object>();
			// 时间段开始时间
			inpMaxMinAvgSumMap.put("sta_tim", dayMonYearTimMap.get("staTim"));
			// 时间段结束时间
			inpMaxMinAvgSumMap.put("end_tim", dayMonYearTimMap.get("endTim"));
			// 电站ID(必输项)
			inpMaxMinAvgSumMap.put("pws_id", map.get("pws_id"));
			// 设备型号
			inpMaxMinAvgSumMap.put("app_mod", map.get("app_mod"));
			// 设备额定功率（容量）段，开始容量值
			inpMaxMinAvgSumMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
			// 设备额定功率（容量）段，结束容量值
			inpMaxMinAvgSumMap.put("end_rtd_pow", map.get("end_rtd_pow"));
			List<Map<String, Object>> powerLst = new ArrayList<Map<String, Object>>();
			// 获取时间段信息
			List<Map<String, Object>> maxMinAvgSumLst = statisticAnalysisDao.getPVStaMaxMinAvgSum(inpMaxMinAvgSumMap);

			if (maxMinAvgSumLst == null || maxMinAvgSumLst.isEmpty() || maxMinAvgSumLst.get(0) == null) {

				// 将补数信息，填写至返回的Map中
				maxMinAvgSumAndPowerMap.put("tol_tim", inpMaxMinAvgSumMap.get("sta_tim"));

				if (equInfLst != null && !equInfLst.isEmpty()) {

					for (Map<String, Object> equInfmap : equInfLst) {

						Map<String, Object> powerMap = new HashMap<String, Object>();

						powerMap.put("equ_num", equInfmap.get("equ_num"));

						powerLst.add(powerMap);
					}
				}
				maxMinAvgSumAndPowerMap.put("powerLst", powerLst);
			} else {
				// 遍历取回来的统计数据
				for (Map<String, Object> maxMinAvgSumMap : maxMinAvgSumLst) {

					// 将补数信息，填写至返回的Map中
					maxMinAvgSumAndPowerMap.put("tol_tim", inpMaxMinAvgSumMap.get("sta_tim"));

					maxMinAvgSumAndPowerMap.put("min_power", maxMinAvgSumMap.get("min_power"));

					maxMinAvgSumAndPowerMap.put("max_power", maxMinAvgSumMap.get("max_power"));

					maxMinAvgSumAndPowerMap.put("avg_power", maxMinAvgSumMap.get("avg_power"));
					
					maxMinAvgSumAndPowerMap.put("sum_power", maxMinAvgSumMap.get("sum_power"));

					if (equInfLst != null && !equInfLst.isEmpty()) {
						// 遍历设备信息列表（当前站内的所有设备信息列表）
						for (Map<String, Object> equInfmap : equInfLst) {
							// 将设备列表信息中的设备编号，传入获取电量信息的接口
							inpMaxMinAvgSumMap.put("equ_num",equInfmap.get("equ_num"));
							
							// 使用上面查出来的光伏设备编号以及给定的时间段，获取单位时间内的电量信息(1条)
							List<Map<String, Object>> staInfLst = statisticAnalysisDao.getPVStaInfLst(inpMaxMinAvgSumMap);
							// 判断获取回来的信息是否为空
							if (staInfLst != null && !staInfLst.isEmpty()) {

								for (Map<String, Object> staInfMap : staInfLst) {
									
									if(staInfMap != null && !staInfMap.isEmpty()){
										
										// 判断查询出来的电量值,是否小于由前台传过来的标记值,如果小于,将该值标记为黄色,如果不小于,则不标记
										if (map.get("flagValue") != null && !map.get("flagValue").toString().isEmpty() && Double.valueOf(staInfMap.get("power").toString()) < Double.valueOf(map.get("flagValue").toString())) {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 3);
											
										} else {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 0);
										}
										
										// 判断查询出来的电量值,是否是最小电量,如果为最小电量,则将该值标记为红色
										if (staInfMap.get("power").equals(maxMinAvgSumMap.get("min_power"))) {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 1);
											
										} else if (staInfMap.get("power").equals(maxMinAvgSumMap.get("max_power"))) {
											// 判断查询出来的电量值,是否是最大电量,如果为最大电量,则将该值标记为蓝色
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 2);
										}
									}else{
										staInfMap = new HashMap<String, Object>();

										staInfMap.put("equ_num",equInfmap.get("equ_num"));

										staInfMap.put("tol_tim",inpMaxMinAvgSumMap.get("sta_tim"));

									}
									powerLst.add(staInfMap);
								}
							} else { // 如果为空的话,创建一个返回值集合

								Map<String, Object> staInfMap = new HashMap<String, Object>();

								staInfMap.put("equ_num",equInfmap.get("equ_num"));

								staInfMap.put("tol_tim",inpMaxMinAvgSumMap.get("sta_tim"));

								powerLst.add(staInfMap);
							}
						}
					}
				}
				maxMinAvgSumAndPowerMap.put("powerLst", powerLst);
			}
			maxMinAvgSumAndPowerLst.add(maxMinAvgSumAndPowerMap);
		}
		// 将得到的所有光伏设备,每一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合放入返回集合中
		returnMap.put("maxMinAvgSumAndPowerLst", maxMinAvgSumAndPowerLst);
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		
		String sta_tim = "";
		
		String end_tim = "";
		// 如果查询纬度为月
		if(map.get("type").toString().equals("2")){
			// 获取到查询月1日0点0分0秒的时间
			sta_tim = sdf.format(sdf.parse(map.get("date").toString()));
			// 获取到查询月下一月1日0点0分0秒的时间
			end_tim = DateUtil.addMonth(sta_tim);
			
		// 如果查询纬度为年
		}else if(map.get("type").toString().equals("3")){
			
			Calendar calendar = Calendar.getInstance();
			
			calendar.setTime(sdf.parse(map.get("date").toString()));
			
			int year = calendar.get(Calendar.YEAR);
			// 获取到查询年1月1日0点0分0秒的时间
			sta_tim = DateUtil.getYearMonthDayString(year, 1, 1);
			// 获取到查询年下一年1月1日0点0分0秒的时间
			end_tim = DateUtil.getYearMonthDayString(year+1, 1, 1);
		}
		
		if (equInfLst != null && !equInfLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> equInfmap : equInfLst) {
				
				Map<String, Object> inpPVStaInfMap = new HashMap<String, Object>();
				
				// 时间段开始时间
				inpPVStaInfMap.put("sta_tim", sta_tim);
				// 时间段结束时间
				inpPVStaInfMap.put("end_tim", end_tim);
				// 电站ID(必输项)
				inpPVStaInfMap.put("pws_id", map.get("pws_id"));
				// 设备型号
				inpPVStaInfMap.put("app_mod", map.get("app_mod"));
				// 设备额定功率（容量）段，开始容量值
				inpPVStaInfMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
				// 设备额定功率（容量）段，结束容量值
				inpPVStaInfMap.put("end_rtd_pow", map.get("end_rtd_pow"));
				// 将设备列表信息中的设备编号，传入获取电量信息的接口
				inpPVStaInfMap.put("equ_num",equInfmap.get("equ_num"));
				// 获取制定光伏逆变器的指定时间段的电量统计数据
				List<Map<String, Object>> staInfTolLst = statisticAnalysisDao.getPVStaInfLstTol(inpPVStaInfMap);
				
				// 判断获取回来的信息是否为空,补0
				if (staInfTolLst != null && !staInfTolLst.isEmpty() && staInfTolLst.get(0) != null) {
					
					for(Map<String, Object> staInfTolMap : staInfTolLst){
						
						equInfmap.put("tol_power", staInfTolMap.get("tol_power"));
					}
				}
			}
		}
		// 将得到的所有光伏设备当月电量统计数据列表集合放入返回集合中
		returnMap.put("powerTolLst", equInfLst);
		
		Map<String, Object> inpTolPowerMap = new HashMap<String, Object>();
		
		// 时间段开始时间
		inpTolPowerMap.put("sta_tim", sta_tim);
		// 时间段结束时间
		inpTolPowerMap.put("end_tim", end_tim);
		// 电站ID(必输项)
		inpTolPowerMap.put("pws_id", map.get("pws_id"));
		// 设备型号
		inpTolPowerMap.put("app_mod", map.get("app_mod"));
		// 设备额定功率（容量）段，开始容量值
		inpTolPowerMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
		// 设备额定功率（容量）段，结束容量值
		inpTolPowerMap.put("end_rtd_pow", map.get("end_rtd_pow"));
		
		// 获取指定电站的指定时间段的电量统计数据
		List<Map<String, Object>> staTolLst = statisticAnalysisDao.getPVStaTol(inpTolPowerMap);
		
		// 判断获取回来的信息是否为空,补0
		if (staTolLst == null || staTolLst.isEmpty() || staTolLst.get(0) == null) {
			
			staTolLst = new ArrayList<Map<String,Object>>();
			
			Map<String, Object> staTolMap = new HashMap<String, Object>();
			
			staTolLst.add(staTolMap);
		}
		
		returnMap.put("staTolLst", staTolLst);
		
		returnLst.add(returnMap);
		
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPVInfStaBetweenDay(Map<String, Object> map) throws Exception {
		// 时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		
		String sta_tim = "";
		// 时间非空判断
		if(map.get("sta_tim") != null && !map.get("sta_tim").toString().isEmpty()){
			
			sta_tim = map.get("sta_tim").toString();
			
		}
		
		String end_tim = "";
		
		if(map.get("end_tim") != null && !map.get("end_tim").toString().isEmpty()){
			
			end_tim =  sdf.format(DateUtil.addDay(sdf.parse(map.get("end_tim").toString()), 1));
			
		}
		
		// 获取该站内所有的充电桩设备
		List<Map<String, Object>> equInfLst = systemDao.getEquInfLstByPwsIdAppTyp(map);
		
		// 所有光伏设备,每一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合
		List<Map<String, Object>> maxMinAvgSumAndChpLst = new ArrayList<Map<String, Object>>();
		// 变量声明
		// 最小
		Double min_power = null;
		Double min_cnv_eff = null;
		Double min_power_whe_equ = null;
		Double min_bra_u_dis_rate = null;
		Double min_good_run_time = null;
		Double min_fault_time = null;
		Double min_failure_time = null;
		Double min_com_int_time = null;
		// 最大
		Double max_power = null;
		Double max_cnv_eff = null;
		Double max_power_whe_equ = null;
		Double max_bra_u_dis_rate = null;
		Double max_good_run_time = null;
		Double max_fault_time = null;
		Double max_failure_time = null;
		Double max_com_int_time = null;
		// 平均
		Double avg_power = null;
		Double avg_cnv_eff = null;
		Double avg_power_whe_equ = null;
		Double avg_bra_u_dis_rate = null;
		Double avg_good_run_time = null;
		Double avg_fault_time = null;
		Double avg_failure_time = null;
		Double avg_com_int_time = null;
		// 合计
		Double sum_power = null;
		Double sum_cnv_eff = null;
		Double sum_power_whe_equ = null;
		Double sum_bra_u_dis_rate = null;
		Double sum_good_run_time = null;
		Double sum_fault_time = null;
		Double sum_failure_time = null;
		Double sum_com_int_time = null;
		// 平均值查数
		Integer cou_power = null;
		Integer cou_cnv_eff = null;
		Integer cou_power_whe_equ = null;
		Integer cou_bra_u_dis_rate = null;
		Integer cou_good_run_time = null;
		Integer cou_fault_time = null;
		Integer cou_failure_time = null;
		Integer cou_com_int_time = null;
		
		Map<String, Object> inpMaxMinAvgSumMap = new HashMap<String, Object>();
		// 时间段开始时间
		inpMaxMinAvgSumMap.put("sta_tim", sta_tim);
		// 时间段结束时间
		inpMaxMinAvgSumMap.put("end_tim", end_tim);
		// 电站ID(必输项)
		inpMaxMinAvgSumMap.put("pws_id", map.get("pws_id"));
		// 设备型号
		inpMaxMinAvgSumMap.put("app_mod", map.get("app_mod"));
		// 设备额定功率（容量）段，开始容量值
		inpMaxMinAvgSumMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
		// 设备额定功率（容量）段，结束容量值
		inpMaxMinAvgSumMap.put("end_rtd_pow", map.get("end_rtd_pow"));
		
		List<Map<String, Object>> chpLst = new ArrayList<Map<String,Object>>();
		
		if (equInfLst != null && !equInfLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> equInfmap : equInfLst) {
				// 将设备列表信息中的设备编号，传入获取电量信息的接口
				inpMaxMinAvgSumMap.put("equ_num",equInfmap.get("equ_num"));
				// 使用上面查出来的光伏设备编号以及给定的时间段，获取单位时间内的电量信息(1条)
				List<Map<String, Object>> staInfLst = statisticAnalysisDao.getPVInfStaInfLst(inpMaxMinAvgSumMap);
				// 判断获取回来的信息是否为空
				if (staInfLst.get(0) != null && !staInfLst.get(0).isEmpty()) {
					
					for (Map<String, Object> staInfMap : staInfLst) {
						// 充电量统计
						if(staInfMap != null && staInfMap.get("power") != null){
							// 取出充电量
							Double power = Double.valueOf(staInfMap.get("power").toString());
							// 如果最小充电量统计数据值为空,则赋值为0,方便下面计算
							if(min_power == null ){
								
								min_power = power;
							}
							// 判断取出的充电量与最小充电量哪个小,如果取出的充电量小,则将充电量赋给最小充电量
							if(power<min_power){
								
								min_power = power;
							}
							// 如果最大充电量统计数据值为空,则赋值为0,方便下面计算
							if(max_power == null ){
								
								max_power = power;
							}
							// 判断取出的充电量与最大充电量哪个大,如果取出的充电量大,则将充电量赋给最大充电量
							if(power>max_power){
								
								max_power = power;
							}
							
							// 如果有充电量的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_power == null ){
								
								cou_power = 0;
							}
							// 记录有多少个设备的充电量里面有值
							cou_power = cou_power+1;
							
							// 如果充电量合计字段为空,则赋值为0,方便下面计算
							if(sum_power == null ){
								
								sum_power = 0.0;
							}
							// 统计一共充了多少电
							sum_power = sum_power+power;
						}
						
						// 放电量统计
						if(staInfMap != null && staInfMap.get("power_whe_equ") != null){
							// 取出充电量
							Double power_whe_equ = Double.valueOf(staInfMap.get("power_whe_equ").toString());
							// 如果最小充电量统计数据值为空,则赋值为0,方便下面计算
							if(min_power_whe_equ == null ){
								
								min_power_whe_equ = power_whe_equ;
							}
							// 判断取出的充电量与最小充电量哪个小,如果取出的充电量小,则将充电量赋给最小充电量
							if(power_whe_equ<min_power_whe_equ){
								
								min_power_whe_equ = power_whe_equ;
							}
							// 如果最大充电量统计数据值为空,则赋值为0,方便下面计算
							if(max_power_whe_equ == null ){
								
								max_power_whe_equ = power_whe_equ;
							}
							// 判断取出的充电量与最大充电量哪个大,如果取出的充电量大,则将充电量赋给最大充电量
							if(power_whe_equ>max_power_whe_equ){
								
								max_power_whe_equ = power_whe_equ;
							}
							
							// 如果有充电量的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_power_whe_equ == null ){
								
								cou_power_whe_equ = 0;
							}
							// 记录有多少个设备的充电量里面有值
							cou_power_whe_equ = cou_power_whe_equ+1;
							
							// 如果充电量合计字段为空,则赋值为0,方便下面计算
							if(sum_power_whe_equ == null ){
								
								sum_power_whe_equ = 0.0;
							}
							// 统计一共充了多少电
							sum_power_whe_equ = sum_power_whe_equ+power_whe_equ;
						}
						
						// 等价充电时统计
						if(staInfMap != null && staInfMap.get("cnv_eff") != null){
							// 取出等价充电时
							Double cnv_eff = Double.valueOf(staInfMap.get("cnv_eff").toString());
							// 如果最小等价充电时统计数据值为空,则赋值为0,方便下面计算
							if(min_cnv_eff == null ){
								
								min_cnv_eff = cnv_eff;
							}
							// 判断取出的等价充电时与最小等价充电时哪个小,如果取出的等价充电时小,则将等价充电时赋给最小等价充电时
							if(cnv_eff<min_cnv_eff){
								
								min_cnv_eff = cnv_eff;
							}
							// 如果最大充电量统计数据值为空,则赋值为0,方便下面计算
							if(max_cnv_eff == null ){
								
								max_cnv_eff = cnv_eff;
							}
							// 判断取出的等价充电时与最大等价充电时哪个大,如果取出的等价充电时大,则将等价充电时赋给最大等价充电时
							if(cnv_eff>max_cnv_eff){
								
								max_cnv_eff = cnv_eff;
							}
							
							// 如果有等价充电时的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_cnv_eff == null ){
								
								cou_cnv_eff = 0;
							}
							// 记录有多少个设备的等价充电时里面有值
							cou_cnv_eff = cou_cnv_eff+1;
							
							// 如果等价充电时合计字段为空,则赋值为0,方便下面计算
							if(sum_cnv_eff == null ){
								
								sum_cnv_eff = 0.0;
							}
							// 统计一共有多少等价充电时
							sum_cnv_eff = sum_cnv_eff+cnv_eff;
						}
						
						
						// 充电时长统计
						if(staInfMap != null && staInfMap.get("bra_u_dis_rate") != null){
							// 取出等价充电时
							Double bra_u_dis_rate = Double.valueOf(staInfMap.get("bra_u_dis_rate").toString());
							// 如果最小充电时长统计数据值为空,则赋值为0,方便下面计算
							if(min_bra_u_dis_rate == null ){
								
								min_bra_u_dis_rate = bra_u_dis_rate;
							}
							// 判断取出的充电时长与最小充电时长哪个小,如果取出的充电时长小,则将充电时长赋给最小充电时长
							if(bra_u_dis_rate<min_bra_u_dis_rate){
								
								min_bra_u_dis_rate = bra_u_dis_rate;
							}
							// 如果最大充电时长统计数据值为空,则赋值为0,方便下面计算
							if(max_bra_u_dis_rate == null ){
								
								max_bra_u_dis_rate = bra_u_dis_rate;
							}
							// 判断取出的充电时长与最大充电时长哪个大,如果取出的充电时长大,则将充电时长赋给最大充电时长
							if(bra_u_dis_rate>max_bra_u_dis_rate){
								
								max_bra_u_dis_rate = bra_u_dis_rate;
							}
							
							// 如果有充电时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_bra_u_dis_rate == null ){
								
								cou_bra_u_dis_rate = 0;
							}
							// 记录有多少个设备的充电时长里面有值
							cou_bra_u_dis_rate = cou_bra_u_dis_rate+1;
							
							// 如果充电时长合计字段为空,则赋值为0,方便下面计算
							if(sum_bra_u_dis_rate == null ){
								
								sum_bra_u_dis_rate = 0.0;
							}
							// 统计一共有多少充电时长
							sum_bra_u_dis_rate = sum_bra_u_dis_rate+bra_u_dis_rate;
						}

						// 正常运行时长统计
						if(staInfMap != null && staInfMap.get("good_run_time") != null){
							// 取出正常运行时长
							Double good_run_time = Double.valueOf(staInfMap.get("good_run_time").toString());
							// 如果最小正常运行时长统计数据值为空,则赋值为0,方便下面计算
							if(min_good_run_time == null ){
								
								min_good_run_time = good_run_time;
							}
							// 判断取出的正常运行时长与最小正常运行时长哪个小,如果取出的正常运行时长小,则将正常运行时长赋给最小正常运行时长
							if(good_run_time<min_good_run_time){
								
								min_good_run_time = good_run_time;
							}
							// 如果最大正常运行时长统计数据值为空,则赋值为0,方便下面计算
							if(max_good_run_time == null ){
								
								max_good_run_time = good_run_time;
							}
							// 判断取出的正常运行时长与最大正常运行时长哪个大,如果取出的正常运行时长大,则将正常运行时长赋给最大正常运行时长
							if(good_run_time>max_good_run_time){
								
								max_good_run_time = good_run_time;
							}
							
							// 如果有正常运行时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_good_run_time == null ){
								
								cou_good_run_time = 0;
							}
							// 记录有多少个设备的正常运行时长里面有值
							cou_good_run_time = cou_good_run_time+1;
							
							// 如果正常运行时长合计字段为空,则赋值为0,方便下面计算
							if(sum_good_run_time == null ){
								
								sum_good_run_time = 0.0;
							}
							// 统计一共有多少正常运行时长
							sum_good_run_time = sum_good_run_time+good_run_time;
						}
						
						
						// 告警运行时长统计
						if(staInfMap != null && staInfMap.get("fault_time") != null){
							// 取出告警运行时长
							Double fault_time = Double.valueOf(staInfMap.get("fault_time").toString());
							// 如果最小告警运行时长统计数据值为空,则赋值为0,方便下面计算
							if(min_fault_time == null ){
								
								min_fault_time = fault_time;
							}
							// 判断取出的告警运行时长与最小告警运行时长哪个小,如果取出的告警运行时长小,则将告警运行时长赋给最小告警运行时长
							if(fault_time<min_fault_time){
								
								min_fault_time = fault_time;
							}
							// 如果最大告警运行时长统计数据值为空,则赋值为0,方便下面计算
							if(max_fault_time == null ){
								
								max_fault_time = fault_time;
							}
							// 判断取出的告警运行时长与最大告警运行时长哪个大,如果取出的告警运行时长大,则将告警运行时长赋给最大告警运行时长
							if(fault_time>max_fault_time){
								
								max_fault_time = fault_time;
							}
							
							// 如果有告警运行时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_fault_time == null ){
								
								cou_fault_time = 0;
							}
							// 记录有多少个设备的告警运行时长里面有值
							cou_fault_time = cou_fault_time+1;
							
							// 如果告警运行时长合计字段为空,则赋值为0,方便下面计算
							if(sum_fault_time == null ){
								
								sum_fault_time = 0.0;
							}
							// 统计一共有多少告警运行时长
							sum_fault_time = sum_fault_time+fault_time;
						}
						
						
						// 故障停机时长统计
						if(staInfMap != null && staInfMap.get("failure_time") != null){
							// 取出故障停机时长
							Double failure_time = Double.valueOf(staInfMap.get("failure_time").toString());
							// 如果最小故障停机时长统计数据值为空,则赋值为0,方便下面计算
							if(min_failure_time == null ){
								
								min_failure_time = failure_time;
							}
							// 判断取出的故障停机时长与最小故障停机时长哪个小,如果取出的故障停机时长小,则将故障停机时长赋给最小故障停机时长
							if(failure_time<min_failure_time){
								
								min_failure_time = failure_time;
							}
							// 如果最大故障停机时长统计数据值为空,则赋值为0,方便下面计算
							if(max_failure_time == null ){
								
								max_failure_time = failure_time;
							}
							// 判断取出的故障停机时长与最大故障停机时长哪个大,如果取出的故障停机时长大,则将故障停机时长赋给最大故障停机时长
							if(failure_time>max_failure_time){
								
								max_failure_time = failure_time;
							}
							
							// 如果有故障停机时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_failure_time == null ){
								
								cou_failure_time = 0;
							}
							// 记录有多少个设备的故障停机时长里面有值
							cou_failure_time = cou_failure_time+1;
							
							// 如果故障停机时长合计字段为空,则赋值为0,方便下面计算
							if(sum_failure_time == null ){
								
								sum_failure_time = 0.0;
							}
							// 统计一共有多少故障停机时长
							sum_failure_time = sum_failure_time+failure_time;
						}
						
						// 通讯中断时长统计
						if(staInfMap != null && staInfMap.get("com_int_time") != null){
							// 取出通讯中断时长
							Double com_int_time = Double.valueOf(staInfMap.get("com_int_time").toString());
							// 如果最小通讯中断时长统计数据值为空,则赋值为0,方便下面计算
							if(min_com_int_time == null ){
								
								min_com_int_time = com_int_time;
							}
							// 判断取出的通讯中断时长与最小通讯中断时长哪个小,如果取出的通讯中断时长小,则将通讯中断时长赋给最小通讯中断时长
							if(com_int_time<min_com_int_time){
								
								min_com_int_time = com_int_time;
							}
							// 如果最大通讯中断时长统计数据值为空,则赋值为0,方便下面计算
							if(max_com_int_time == null ){
								
								max_com_int_time = com_int_time;
							}
							// 判断取出的通讯中断时长与最大通讯中断时长哪个大,如果取出的通讯中断时长大,则将通讯中断时长赋给最大通讯中断时长
							if(com_int_time>max_com_int_time){
								
								max_com_int_time = com_int_time;
							}
							
							// 如果有通讯中断时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_com_int_time == null ){
								
								cou_com_int_time = 0;
							}
							// 记录有多少个设备的通讯中断时长里面有值
							cou_com_int_time = cou_com_int_time+1;
							
							// 如果通讯中断时长合计字段为空,则赋值为0,方便下面计算
							if(sum_com_int_time == null ){
								
								sum_com_int_time = 0.0;
							}
							// 统计一共有多少通讯中断时长
							sum_com_int_time = sum_com_int_time+com_int_time;
						}
						
						chpLst.add(staInfMap);
					}
				} 
			}
		}
		
		// 求充电量平均值
		if(sum_power != null && cou_power != null){
			
			avg_power = sum_power/cou_power;
			
		}
		
		// 求等价充电时平均值
		if(sum_power_whe_equ != null && cou_power_whe_equ != null){
			
			avg_power_whe_equ = sum_power_whe_equ/cou_power_whe_equ;
			
		}
		
		// 求充电时长平均值
		if(sum_cnv_eff != null && cou_cnv_eff != null){
			
			avg_cnv_eff = sum_cnv_eff/cou_cnv_eff;
			
		}
		
		// 求充电时长平均值
		if(sum_bra_u_dis_rate != null && cou_bra_u_dis_rate != null){
			
			avg_bra_u_dis_rate = sum_bra_u_dis_rate/cou_bra_u_dis_rate;
			
		}
		
		// 求正常运行时长平均值
		if(sum_good_run_time != null && cou_good_run_time != null){
			
			avg_good_run_time = sum_good_run_time/cou_good_run_time;
			
		}
		
		// 求告警运行时长平均值
		if(sum_fault_time != null && cou_fault_time != null){
			
			avg_fault_time = sum_fault_time/cou_fault_time;
			
		}
		
		// 求故障停机时长平均值
		if(sum_failure_time != null && cou_failure_time != null){
			
			avg_failure_time = sum_failure_time/cou_failure_time;
			
		}
		
		// 求通讯中断时长平均值
		if(sum_com_int_time != null && cou_com_int_time != null){
			
			avg_com_int_time = sum_com_int_time/cou_com_int_time;
			
		}

		if (chpLst != null && !chpLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> chpMap : chpLst) {
				
				if(chpMap != null){
					// 判断获取回来的信息是否为空
					// 判断查询出来的电量值,是否小于由前台传过来的标记值,如果小于,将该值标记为黄色,如果不小于,则不标记
					if (map.get("flagValue") != null && !map.get("flagValue").toString().isEmpty() && Double.valueOf(chpMap.get("power").toString()) < Double.valueOf(map.get("flagValue").toString())) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color", 3);
						
					} else {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color", 0);
					}
					
					// 判断查询出来的电量值,是否是最小电量,如果为最小电量,则将该值标记为红色
					if (chpMap.get("power") != null && Double.valueOf(chpMap.get("power").toString()).equals(min_power)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color", 1);
						
					} else if (chpMap.get("power") != null && Double.valueOf(chpMap.get("power").toString()).equals(max_power)) {
						// 判断查询出来的电量值,是否是最大电量,如果为最大电量,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color", 2);
					}
					
					// 判断查询出来的电量值,是否是最小电量,如果为最小电量,则将该值标记为红色
					if (chpMap.get("power_whe_equ") != null && Double.valueOf(chpMap.get("power_whe_equ").toString()).equals(min_power_whe_equ)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_we", 1);
						
					} else if (chpMap.get("power_whe_equ") != null && Double.valueOf(chpMap.get("power_whe_equ").toString()).equals(max_power_whe_equ)) {
						// 判断查询出来的电量值,是否是最大电量,如果为最大电量,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_we", 2);
					}else{
						
						chpMap.put("color_we", 0);
					}
					
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("cnv_eff") != null && Double.valueOf(chpMap.get("cnv_eff").toString()).equals(min_cnv_eff)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ce", 1);
						
					} else if (chpMap.get("cnv_eff") != null && Double.valueOf(chpMap.get("cnv_eff").toString()).equals(max_cnv_eff)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ce", 2);
					}else{
						
						chpMap.put("color_ce", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("bra_u_dis_rate") != null && Double.valueOf(chpMap.get("bra_u_dis_rate").toString()).equals(min_bra_u_dis_rate)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_budr", 1);
						
					} else if (chpMap.get("bra_u_dis_rate") != null && Double.valueOf(chpMap.get("bra_u_dis_rate").toString()).equals(max_bra_u_dis_rate)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_budr", 2);
					}else{
						
						chpMap.put("color_budr", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("good_run_time") != null && Double.valueOf(chpMap.get("good_run_time").toString()).equals(min_good_run_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_grt", 1);
						
					} else if (chpMap.get("good_run_time") != null && Double.valueOf(chpMap.get("good_run_time").toString()).equals(max_good_run_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_grt", 2);
					}else{
						
						chpMap.put("color_grt", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("fault_time") != null && Double.valueOf(chpMap.get("fault_time").toString()).equals(min_fault_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ft", 1);
						
					} else if (chpMap.get("fault_time") != null && Double.valueOf(chpMap.get("fault_time").toString()).equals(max_fault_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ft", 2);
					}else{
						
						chpMap.put("color_ft", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("failure_time") != null && Double.valueOf(chpMap.get("failure_time").toString()).equals(min_failure_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_flt", 1);
						
					} else if (chpMap.get("failure_time") != null && Double.valueOf(chpMap.get("failure_time").toString()).equals(max_failure_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_flt", 2);
						
					}else{
						
						chpMap.put("color_flt", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("com_int_time") != null && Double.valueOf(chpMap.get("com_int_time").toString()).equals(min_com_int_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_cit", 1);
						
					} else if (chpMap.get("com_int_time") != null && Double.valueOf(chpMap.get("com_int_time").toString()).equals(max_com_int_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_cit", 2);
						
					}else{
						
						chpMap.put("color_cit", 0);
					}
				}
			}
		}
		
		Map<String,Object> maxMinAvgSumAndChpMap = new HashMap<String, Object>();
		// 将补数信息，填写至返回的Map中
		maxMinAvgSumAndChpMap.put("tol_tim", inpMaxMinAvgSumMap.get("sta_tim"));
		
		maxMinAvgSumAndChpMap.put("min_power", min_power);
		maxMinAvgSumAndChpMap.put("min_power_whe_equ", min_power_whe_equ);
		maxMinAvgSumAndChpMap.put("min_cnv_eff", min_cnv_eff);
		maxMinAvgSumAndChpMap.put("min_bra_u_dis_rate", min_bra_u_dis_rate);
		maxMinAvgSumAndChpMap.put("min_good_run_time", min_good_run_time);
		maxMinAvgSumAndChpMap.put("min_fault_time", min_fault_time);
		maxMinAvgSumAndChpMap.put("min_failure_time", min_failure_time);
		maxMinAvgSumAndChpMap.put("min_com_int_time", min_com_int_time);
		
		maxMinAvgSumAndChpMap.put("max_power", max_power);
		maxMinAvgSumAndChpMap.put("max_power_whe_equ", max_power_whe_equ);
		maxMinAvgSumAndChpMap.put("max_cnv_eff", max_cnv_eff);
		maxMinAvgSumAndChpMap.put("max_bra_u_dis_rate", max_bra_u_dis_rate);
		maxMinAvgSumAndChpMap.put("max_good_run_time", max_good_run_time);
		maxMinAvgSumAndChpMap.put("max_fault_time", max_fault_time);
		maxMinAvgSumAndChpMap.put("max_failure_time", max_failure_time);
		maxMinAvgSumAndChpMap.put("max_com_int_time", max_com_int_time);
		
		maxMinAvgSumAndChpMap.put("avg_power", avg_power);
		maxMinAvgSumAndChpMap.put("avg_power_whe_equ", avg_power_whe_equ);
		maxMinAvgSumAndChpMap.put("avg_cnv_eff", avg_cnv_eff);
		maxMinAvgSumAndChpMap.put("avg_bra_u_dis_rate", avg_bra_u_dis_rate);
		maxMinAvgSumAndChpMap.put("avg_good_run_time", avg_good_run_time);
		maxMinAvgSumAndChpMap.put("avg_fault_time", avg_fault_time);
		maxMinAvgSumAndChpMap.put("avg_failure_time", avg_failure_time);
		maxMinAvgSumAndChpMap.put("avg_com_int_time", avg_com_int_time);
		
		maxMinAvgSumAndChpMap.put("sum_power", sum_power);
		maxMinAvgSumAndChpMap.put("sum_power_whe_equ", sum_power_whe_equ);
		maxMinAvgSumAndChpMap.put("sum_cnv_eff", sum_cnv_eff);
		maxMinAvgSumAndChpMap.put("sum_bra_u_dis_rate", sum_bra_u_dis_rate);
		maxMinAvgSumAndChpMap.put("sum_good_run_time", sum_good_run_time);
		maxMinAvgSumAndChpMap.put("sum_fault_time", sum_fault_time);
		maxMinAvgSumAndChpMap.put("sum_failure_time", sum_failure_time);
		maxMinAvgSumAndChpMap.put("sum_com_int_time", sum_com_int_time);
		
		maxMinAvgSumAndChpMap.put("pvLst", chpLst);
		
		maxMinAvgSumAndChpLst.add(maxMinAvgSumAndChpMap);
		
		return maxMinAvgSumAndChpLst;
	}
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPCStaMonYear(Map<String, Object> map) throws Exception {
		// 获取某年、月、日起始和结束时间点集合
		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), map.get("type").toString());
		
		// 获取该站内所有的光伏逆变器设备
		List<Map<String, Object>> equInfLst = systemDao.getEquInfLstByPwsIdAppTyp(map);
		// 返回值集合
		List<Map<String, Object>> returnLst = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		// 所有光伏设备,每一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合
		List<Map<String, Object>> maxMinAvgSumAndPhiPheLst = new ArrayList<Map<String, Object>>();
		
		for (Map<String, Object> dayMonYearTimMap : dayMonYearTimLst) {
			// 所有光伏设备,某一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合
			Map<String, Object> maxMinAvgSumAndPhiPheMap = new HashMap<String, Object>();
			
			Map<String, Object> inpMaxMinAvgSumMap = new HashMap<String, Object>();
			// 时间段开始时间
			inpMaxMinAvgSumMap.put("sta_tim", dayMonYearTimMap.get("staTim"));
			// 时间段结束时间
			inpMaxMinAvgSumMap.put("end_tim", dayMonYearTimMap.get("endTim"));
			// 电站ID(必输项)
			inpMaxMinAvgSumMap.put("pws_id", map.get("pws_id"));
			// 设备型号
			inpMaxMinAvgSumMap.put("app_mod", map.get("app_mod"));
			// 设备额定功率（容量）段，开始容量值
			inpMaxMinAvgSumMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
			// 设备额定功率（容量）段，结束容量值
			inpMaxMinAvgSumMap.put("end_rtd_pow", map.get("end_rtd_pow"));
			List<Map<String, Object>> phiPheLst = new ArrayList<Map<String, Object>>();
			// 获取时间段信息
			List<Map<String, Object>> maxMinAvgSumLst = statisticAnalysisDao.getPCStaMaxMinAvgSum(inpMaxMinAvgSumMap);
			
			if (maxMinAvgSumLst == null || maxMinAvgSumLst.isEmpty() || maxMinAvgSumLst.get(0) == null) {
				
				// 将补数信息，填写至返回的Map中
				maxMinAvgSumAndPhiPheMap.put("tol_tim", inpMaxMinAvgSumMap.get("sta_tim"));
				
				if (equInfLst != null && !equInfLst.isEmpty()) {
					
					for (Map<String, Object> equInfmap : equInfLst) {
						
						equInfmap.put("equ_num", equInfmap.get("equ_num"));
						
						phiPheLst.add(equInfmap);
					}
				}
				maxMinAvgSumAndPhiPheMap.put("phiPheLst", phiPheLst);
			} else {
				// 遍历取回来的统计数据
				for (Map<String, Object> maxMinAvgSumMap : maxMinAvgSumLst) {
					
					// 将补数信息，填写至返回的Map中
					maxMinAvgSumAndPhiPheMap.put("tol_tim", inpMaxMinAvgSumMap.get("sta_tim"));
					
					maxMinAvgSumAndPhiPheMap.put("min_phi", maxMinAvgSumMap.get("min_phi"));
					
					maxMinAvgSumAndPhiPheMap.put("min_phe", maxMinAvgSumMap.get("min_phe"));
					
					maxMinAvgSumAndPhiPheMap.put("max_phi", maxMinAvgSumMap.get("max_phi"));
					
					maxMinAvgSumAndPhiPheMap.put("max_phe", maxMinAvgSumMap.get("max_phe"));
					
					maxMinAvgSumAndPhiPheMap.put("avg_phi", maxMinAvgSumMap.get("avg_phi"));
					
					maxMinAvgSumAndPhiPheMap.put("avg_phe", maxMinAvgSumMap.get("avg_phe"));
					
					maxMinAvgSumAndPhiPheMap.put("sum_phi", maxMinAvgSumMap.get("sum_phi"));
					
					maxMinAvgSumAndPhiPheMap.put("sum_phe", maxMinAvgSumMap.get("sum_phe"));
					
					if (equInfLst != null && !equInfLst.isEmpty()) {
						// 遍历设备信息列表（当前站内的所有设备信息列表）
						for (Map<String, Object> equInfmap : equInfLst) {
							// 将设备列表信息中的设备编号，传入获取电量信息的接口
							inpMaxMinAvgSumMap.put("equ_num",equInfmap.get("equ_num"));
							// 使用上面查出来的光伏设备编号以及给定的时间段，获取单位时间内的电量信息(1条)
							List<Map<String, Object>> staInfLst = statisticAnalysisDao.getPCStaInfLst(inpMaxMinAvgSumMap);
							// 判断获取回来的信息是否为空
							if (staInfLst != null && !staInfLst.isEmpty()) {
								
								for (Map<String, Object> staInfMap : staInfLst) {
									
									if(staInfMap != null && !staInfMap.isEmpty()){
										
										// 判断查询出来的电量值,是否小于由前台传过来的标记值,如果小于,将该值标记为黄色,如果不小于,则不标记
										if (map.get("flagValue") != null && !map.get("flagValue").toString().isEmpty() && Double.valueOf(staInfMap.get("phi").toString()) < Double.valueOf(map.get("flagValue").toString())) {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 3);
											
										} else {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 0);
										}
										
										// 判断查询出来的电量值,是否小于由前台传过来的标记值,如果小于,将该值标记为黄色,如果不小于,则不标记
										if (map.get("flagValue") != null && !map.get("flagValue").toString().isEmpty() && Double.valueOf(staInfMap.get("phe").toString()) < Double.valueOf(map.get("flagValue").toString())) {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 3);
											
										} else {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 0);
										}
										
										// 判断查询出来的电量值,是否是最小电量,如果为最小电量,则将该值标记为红色
										if (staInfMap.get("phi").equals(maxMinAvgSumMap.get("min_phi"))) {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 1);
											
										} else if (staInfMap.get("phi").equals(maxMinAvgSumMap.get("max_phi"))) {
											// 判断查询出来的电量值,是否是最大电量,如果为最大电量,则将该值标记为蓝色
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 2);
										}
										
										// 判断查询出来的电量值,是否是最小电量,如果为最小电量,则将该值标记为红色
										if (staInfMap.get("phe").equals(maxMinAvgSumMap.get("min_phe"))) {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 1);
											
										} else if (staInfMap.get("phe").equals(maxMinAvgSumMap.get("max_phe"))) {
											// 判断查询出来的电量值,是否是最大电量,如果为最大电量,则将该值标记为蓝色
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 2);
										}
									}else{
										staInfMap = new HashMap<String, Object>();

										staInfMap.put("equ_num",equInfmap.get("equ_num"));

										staInfMap.put("tol_tim",inpMaxMinAvgSumMap.get("sta_tim"));

									}
									phiPheLst.add(staInfMap);
								}
							} else { // 如果为空的话,创建一个返回值集合
								
								Map<String, Object> staInfMap = new HashMap<String, Object>();
								
								staInfMap.put("equ_num",equInfmap.get("equ_num"));
								
								staInfMap.put("tol_tim",inpMaxMinAvgSumMap.get("sta_tim"));
								
								phiPheLst.add(staInfMap);
							}
						}
					}
				}
				maxMinAvgSumAndPhiPheMap.put("phiPheLst", phiPheLst);
			}
			maxMinAvgSumAndPhiPheLst.add(maxMinAvgSumAndPhiPheMap);
		}
		// 将得到的所有光伏设备,每一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合放入返回集合中
		returnMap.put("maxMinAvgSumAndPhiPheLst", maxMinAvgSumAndPhiPheLst);
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		
		String sta_tim = "";
		
		String end_tim = "";
		// 如果查询纬度为月
		if(map.get("type").toString().equals("2")){
			// 获取到查询月1日0点0分0秒的时间
			sta_tim = sdf.format(sdf.parse(map.get("date").toString()));
			// 获取到查询月下一月1日0点0分0秒的时间
			end_tim = DateUtil.addMonth(sta_tim);
			
			// 如果查询纬度为年
		}else if(map.get("type").toString().equals("3")){
			
			Calendar calendar = Calendar.getInstance();
			
			calendar.setTime(sdf.parse(map.get("date").toString()));
			
			int year = calendar.get(Calendar.YEAR);
			// 获取到查询年1月1日0点0分0秒的时间
			sta_tim = DateUtil.getYearMonthDayString(year, 1, 1);
			// 获取到查询年下一年1月1日0点0分0秒的时间
			end_tim = DateUtil.getYearMonthDayString(year+1, 1, 1);
		}
		
		if (equInfLst != null && !equInfLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> equInfmap : equInfLst) {
				
				Map<String, Object> inpPVStaInfMap = new HashMap<String, Object>();
				
				// 时间段开始时间
				inpPVStaInfMap.put("sta_tim", sta_tim);
				// 时间段结束时间
				inpPVStaInfMap.put("end_tim", end_tim);
				// 电站ID(必输项)
				inpPVStaInfMap.put("pws_id", map.get("pws_id"));
				// 设备型号
				inpPVStaInfMap.put("app_mod", map.get("app_mod"));
				// 设备额定功率（容量）段，开始容量值
				inpPVStaInfMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
				// 设备额定功率（容量）段，结束容量值
				inpPVStaInfMap.put("end_rtd_pow", map.get("end_rtd_pow"));
				// 将设备列表信息中的设备编号，传入获取电量信息的接口
				inpPVStaInfMap.put("equ_num",equInfmap.get("equ_num"));
				// 获取制定光伏逆变器的指定时间段的电量统计数据
				List<Map<String, Object>> staInfTolLst = statisticAnalysisDao.getPCStaInfLstTol(inpPVStaInfMap);
				
				// 判断获取回来的信息是否为空,补0
				if (staInfTolLst != null && !staInfTolLst.isEmpty() && staInfTolLst.get(0) != null) {
					
					for(Map<String, Object> staInfTolMap : staInfTolLst){
						
						equInfmap.put("tol_phi", staInfTolMap.get("tol_phi"));
						
						equInfmap.put("tol_phe", staInfTolMap.get("tol_phe"));
					}
				}
			}
		}
		// 将得到的所有光伏设备当月电量统计数据列表集合放入返回集合中
		returnMap.put("phiPheTolLst", equInfLst);
		
		Map<String, Object> inpTolPhiPheMap = new HashMap<String, Object>();
		
		// 时间段开始时间
		inpTolPhiPheMap.put("sta_tim", sta_tim);
		// 时间段结束时间
		inpTolPhiPheMap.put("end_tim", end_tim);
		// 电站ID(必输项)
		inpTolPhiPheMap.put("pws_id", map.get("pws_id"));
		// 设备型号
		inpTolPhiPheMap.put("app_mod", map.get("app_mod"));
		// 设备额定功率（容量）段，开始容量值
		inpTolPhiPheMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
		// 设备额定功率（容量）段，结束容量值
		inpTolPhiPheMap.put("end_rtd_pow", map.get("end_rtd_pow"));
		
		// 获取指定电站的指定时间段的电量统计数据
		List<Map<String, Object>> staTolLst = statisticAnalysisDao.getPCStaTol(inpTolPhiPheMap);
		
		// 判断获取回来的信息是否为空,补0
		if (staTolLst == null || staTolLst.isEmpty() || staTolLst.get(0) == null) {
			
			staTolLst = new ArrayList<Map<String,Object>>();
			
			Map<String, Object> staTolMap = new HashMap<String, Object>();
			
			staTolLst.add(staTolMap);
		}
		
		returnMap.put("staTolLst", staTolLst);
		
		returnLst.add(returnMap);
		
		return returnLst;
	}
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPCInfStaBetweenDay(Map<String, Object> map) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		
		String sta_tim = "";
		
		if(map.get("sta_tim") != null && !map.get("sta_tim").toString().isEmpty()){
			
			sta_tim = map.get("sta_tim").toString();
			
		}
		
		String end_tim = "";
		
		if(map.get("end_tim") != null && !map.get("end_tim").toString().isEmpty()){
			
			end_tim =  sdf.format(DateUtil.addDay(sdf.parse(map.get("end_tim").toString()), 1));
			
		}
		
		// 获取该站内所有的充电桩设备
		List<Map<String, Object>> equInfLst = systemDao.getEquInfLstByPwsIdAppTyp(map);
		
		// 所有光伏设备,每一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合
		List<Map<String, Object>> maxMinAvgSumAndChpLst = new ArrayList<Map<String, Object>>();
		// 最小
		Double min_phi = null;
		Double min_phe = null;
		Double min_cnv_eff = null;
		Double min_charge_time = null;
		Double min_good_run_time = null;
		Double min_fault_time = null;
		Double min_failure_time = null;
		Double min_com_int_time = null;
		// 最大
		Double max_phi = null;
		Double max_phe = null;
		Double max_cnv_eff = null;
		Double max_charge_time = null;
		Double max_good_run_time = null;
		Double max_fault_time = null;
		Double max_failure_time = null;
		Double max_com_int_time = null;
		// 平均
		Double avg_phi = null;
		Double avg_phe = null;
		Double avg_cnv_eff = null;
		Double avg_charge_time = null;
		Double avg_good_run_time = null;
		Double avg_fault_time = null;
		Double avg_failure_time = null;
		Double avg_com_int_time = null;
		// 合计
		Double sum_phi = null;
		Double sum_phe = null;
		Double sum_cnv_eff = null;
		Double sum_charge_time = null;
		Double sum_good_run_time = null;
		Double sum_fault_time = null;
		Double sum_failure_time = null;
		Double sum_com_int_time = null;
		// 平均值查数
		Integer cou_phi = null;
		Integer cou_phe = null;
		Integer cou_cnv_eff = null;
		Integer cou_charge_time = null;
		Integer cou_good_run_time = null;
		Integer cou_fault_time = null;
		Integer cou_failure_time = null;
		Integer cou_com_int_time = null;
		
		Map<String, Object> inpMaxMinAvgSumMap = new HashMap<String, Object>();
		// 时间段开始时间
		inpMaxMinAvgSumMap.put("sta_tim", sta_tim);
		// 时间段结束时间
		inpMaxMinAvgSumMap.put("end_tim", end_tim);
		// 电站ID(必输项)
		inpMaxMinAvgSumMap.put("pws_id", map.get("pws_id"));
		// 设备型号
		inpMaxMinAvgSumMap.put("app_mod", map.get("app_mod"));
		// 设备额定功率（容量）段，开始容量值
		inpMaxMinAvgSumMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
		// 设备额定功率（容量）段，结束容量值
		inpMaxMinAvgSumMap.put("end_rtd_pow", map.get("end_rtd_pow"));
		
		List<Map<String, Object>> chpLst = new ArrayList<Map<String,Object>>();
		
		if (equInfLst != null && !equInfLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> equInfmap : equInfLst) {
				// 将设备列表信息中的设备编号，传入获取电量信息的接口
				inpMaxMinAvgSumMap.put("equ_num",equInfmap.get("equ_num"));
				// 使用上面查出来的光伏设备编号以及给定的时间段，获取单位时间内的电量信息(1条)
				List<Map<String, Object>> staInfLst = statisticAnalysisDao.getPCInfStaInfLst(inpMaxMinAvgSumMap);
				// 判断获取回来的信息是否为空
				if (staInfLst != null && !staInfLst.isEmpty()) {
					
					for (Map<String, Object> staInfMap : staInfLst) {
						// 充电量统计
						if(staInfMap != null && staInfMap.get("phi") != null){
							// 取出充电量
							Double phi = Double.valueOf(staInfMap.get("phi").toString());
							// 如果最小充电量统计数据值为空,则赋值为0,方便下面计算
							if(min_phi == null ){
								
								min_phi = phi;
							}
							// 判断取出的充电量与最小充电量哪个小,如果取出的充电量小,则将充电量赋给最小充电量
							if(phi<min_phi){
								
								min_phi = phi;
							}
							// 如果最大充电量统计数据值为空,则赋值为0,方便下面计算
							if(max_phi == null ){
								
								max_phi = phi;
							}
							// 判断取出的充电量与最大充电量哪个大,如果取出的充电量大,则将充电量赋给最大充电量
							if(phi>max_phi){
								
								max_phi = phi;
							}
							
							// 如果有充电量的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_phi == null ){
								
								cou_phi = 0;
							}
							// 记录有多少个设备的充电量里面有值
							cou_phi = cou_phi+1;
							
							// 如果充电量合计字段为空,则赋值为0,方便下面计算
							if(sum_phi == null ){
								
								sum_phi = 0.0;
							}
							// 统计一共充了多少电
							sum_phi = sum_phi+phi;
						}
						
						// 放电量统计
						if(staInfMap != null && staInfMap.get("phe") != null){
							// 取出充电量
							Double phe = Double.valueOf(staInfMap.get("phe").toString());
							// 如果最小充电量统计数据值为空,则赋值为0,方便下面计算
							if(min_phe == null ){
								
								min_phe = phe;
							}
							// 判断取出的充电量与最小充电量哪个小,如果取出的充电量小,则将充电量赋给最小充电量
							if(phe<min_phe){
								
								min_phe = phe;
							}
							// 如果最大充电量统计数据值为空,则赋值为0,方便下面计算
							if(max_phe == null ){
								
								max_phe = phe;
							}
							// 判断取出的充电量与最大充电量哪个大,如果取出的充电量大,则将充电量赋给最大充电量
							if(phe>max_phe){
								
								max_phe = phe;
							}
							
							// 如果有充电量的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_phe == null ){
								
								cou_phe = 0;
							}
							// 记录有多少个设备的充电量里面有值
							cou_phe = cou_phe+1;
							
							// 如果充电量合计字段为空,则赋值为0,方便下面计算
							if(sum_phe == null ){
								
								sum_phe = 0.0;
							}
							// 统计一共充了多少电
							sum_phe = sum_phe+phe;
						}
						
						// 等价充电时统计
						if(staInfMap != null && staInfMap.get("cnv_eff") != null){
							// 取出等价充电时
							Double cnv_eff = Double.valueOf(staInfMap.get("cnv_eff").toString());
							// 如果最小等价充电时统计数据值为空,则赋值为0,方便下面计算
							if(min_cnv_eff == null ){
								
								min_cnv_eff = cnv_eff;
							}
							// 判断取出的等价充电时与最小等价充电时哪个小,如果取出的等价充电时小,则将等价充电时赋给最小等价充电时
							if(cnv_eff<min_cnv_eff){
								
								min_cnv_eff = cnv_eff;
							}
							// 如果最大充电量统计数据值为空,则赋值为0,方便下面计算
							if(max_cnv_eff == null ){
								
								max_cnv_eff = cnv_eff;
							}
							// 判断取出的等价充电时与最大等价充电时哪个大,如果取出的等价充电时大,则将等价充电时赋给最大等价充电时
							if(cnv_eff>max_cnv_eff){
								
								max_cnv_eff = cnv_eff;
							}
							
							// 如果有等价充电时的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_cnv_eff == null ){
								
								cou_cnv_eff = 0;
							}
							// 记录有多少个设备的等价充电时里面有值
							cou_cnv_eff = cou_cnv_eff+1;
							
							// 如果等价充电时合计字段为空,则赋值为0,方便下面计算
							if(sum_cnv_eff == null ){
								
								sum_cnv_eff = 0.0;
							}
							// 统计一共有多少等价充电时
							sum_cnv_eff = sum_cnv_eff+cnv_eff;
						}
						
						
						// 充电时长统计
						if(staInfMap != null && staInfMap.get("charge_time") != null){
							// 取出等价充电时
							Double charge_time = Double.valueOf(staInfMap.get("charge_time").toString());
							// 如果最小充电时长统计数据值为空,则赋值为0,方便下面计算
							if(min_charge_time == null ){
								
								min_charge_time = charge_time;
							}
							// 判断取出的充电时长与最小充电时长哪个小,如果取出的充电时长小,则将充电时长赋给最小充电时长
							if(charge_time<min_charge_time){
								
								min_charge_time = charge_time;
							}
							// 如果最大充电时长统计数据值为空,则赋值为0,方便下面计算
							if(max_charge_time == null ){
								
								max_charge_time = charge_time;
							}
							// 判断取出的充电时长与最大充电时长哪个大,如果取出的充电时长大,则将充电时长赋给最大充电时长
							if(charge_time>max_charge_time){
								
								max_charge_time = charge_time;
							}
							
							// 如果有充电时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_charge_time == null ){
								
								cou_charge_time = 0;
							}
							// 记录有多少个设备的充电时长里面有值
							cou_charge_time = cou_charge_time+1;
							
							// 如果充电时长合计字段为空,则赋值为0,方便下面计算
							if(sum_charge_time == null ){
								
								sum_charge_time = 0.0;
							}
							// 统计一共有多少充电时长
							sum_charge_time = sum_charge_time+charge_time;
						}

						// 正常运行时长统计
						if(staInfMap != null && staInfMap.get("good_run_time") != null){
							// 取出正常运行时长
							Double good_run_time = Double.valueOf(staInfMap.get("good_run_time").toString());
							// 如果最小正常运行时长统计数据值为空,则赋值为0,方便下面计算
							if(min_good_run_time == null ){
								
								min_good_run_time = good_run_time;
							}
							// 判断取出的正常运行时长与最小正常运行时长哪个小,如果取出的正常运行时长小,则将正常运行时长赋给最小正常运行时长
							if(good_run_time<min_good_run_time){
								
								min_good_run_time = good_run_time;
							}
							// 如果最大正常运行时长统计数据值为空,则赋值为0,方便下面计算
							if(max_good_run_time == null ){
								
								max_good_run_time = good_run_time;
							}
							// 判断取出的正常运行时长与最大正常运行时长哪个大,如果取出的正常运行时长大,则将正常运行时长赋给最大正常运行时长
							if(good_run_time>max_good_run_time){
								
								max_good_run_time = good_run_time;
							}
							
							// 如果有正常运行时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_good_run_time == null ){
								
								cou_good_run_time = 0;
							}
							// 记录有多少个设备的正常运行时长里面有值
							cou_good_run_time = cou_good_run_time+1;
							
							// 如果正常运行时长合计字段为空,则赋值为0,方便下面计算
							if(sum_good_run_time == null ){
								
								sum_good_run_time = 0.0;
							}
							// 统计一共有多少正常运行时长
							sum_good_run_time = sum_good_run_time+good_run_time;
						}
						
						
						// 告警运行时长统计
						if(staInfMap != null && staInfMap.get("fault_time") != null){
							// 取出告警运行时长
							Double fault_time = Double.valueOf(staInfMap.get("fault_time").toString());
							// 如果最小告警运行时长统计数据值为空,则赋值为0,方便下面计算
							if(min_fault_time == null ){
								
								min_fault_time = fault_time;
							}
							// 判断取出的告警运行时长与最小告警运行时长哪个小,如果取出的告警运行时长小,则将告警运行时长赋给最小告警运行时长
							if(fault_time<min_fault_time){
								
								min_fault_time = fault_time;
							}
							// 如果最大告警运行时长统计数据值为空,则赋值为0,方便下面计算
							if(max_fault_time == null ){
								
								max_fault_time = fault_time;
							}
							// 判断取出的告警运行时长与最大告警运行时长哪个大,如果取出的告警运行时长大,则将告警运行时长赋给最大告警运行时长
							if(fault_time>max_fault_time){
								
								max_fault_time = fault_time;
							}
							
							// 如果有告警运行时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_fault_time == null ){
								
								cou_fault_time = 0;
							}
							// 记录有多少个设备的告警运行时长里面有值
							cou_fault_time = cou_fault_time+1;
							
							// 如果告警运行时长合计字段为空,则赋值为0,方便下面计算
							if(sum_fault_time == null ){
								
								sum_fault_time = 0.0;
							}
							// 统计一共有多少告警运行时长
							sum_fault_time = sum_fault_time+fault_time;
						}
						
						
						// 故障停机时长统计
						if(staInfMap != null && staInfMap.get("failure_time") != null){
							// 取出故障停机时长
							Double failure_time = Double.valueOf(staInfMap.get("failure_time").toString());
							// 如果最小故障停机时长统计数据值为空,则赋值为0,方便下面计算
							if(min_failure_time == null ){
								
								min_failure_time = failure_time;
							}
							// 判断取出的故障停机时长与最小故障停机时长哪个小,如果取出的故障停机时长小,则将故障停机时长赋给最小故障停机时长
							if(failure_time<min_failure_time){
								
								min_failure_time = failure_time;
							}
							// 如果最大故障停机时长统计数据值为空,则赋值为0,方便下面计算
							if(max_failure_time == null ){
								
								max_failure_time = failure_time;
							}
							// 判断取出的故障停机时长与最大故障停机时长哪个大,如果取出的故障停机时长大,则将故障停机时长赋给最大故障停机时长
							if(failure_time>max_failure_time){
								
								max_failure_time = failure_time;
							}
							
							// 如果有故障停机时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_failure_time == null ){
								
								cou_failure_time = 0;
							}
							// 记录有多少个设备的故障停机时长里面有值
							cou_failure_time = cou_failure_time+1;
							
							// 如果故障停机时长合计字段为空,则赋值为0,方便下面计算
							if(sum_failure_time == null ){
								
								sum_failure_time = 0.0;
							}
							// 统计一共有多少故障停机时长
							sum_failure_time = sum_failure_time+failure_time;
						}
						
						// 通讯中断时长统计
						if(staInfMap != null && staInfMap.get("com_int_time") != null){
							// 取出通讯中断时长
							Double com_int_time = Double.valueOf(staInfMap.get("com_int_time").toString());
							// 如果最小通讯中断时长统计数据值为空,则赋值为0,方便下面计算
							if(min_com_int_time == null ){
								
								min_com_int_time = com_int_time;
							}
							// 判断取出的通讯中断时长与最小通讯中断时长哪个小,如果取出的通讯中断时长小,则将通讯中断时长赋给最小通讯中断时长
							if(com_int_time<min_com_int_time){
								
								min_com_int_time = com_int_time;
							}
							// 如果最大通讯中断时长统计数据值为空,则赋值为0,方便下面计算
							if(max_com_int_time == null ){
								
								max_com_int_time = com_int_time;
							}
							// 判断取出的通讯中断时长与最大通讯中断时长哪个大,如果取出的通讯中断时长大,则将通讯中断时长赋给最大通讯中断时长
							if(com_int_time>max_com_int_time){
								
								max_com_int_time = com_int_time;
							}
							
							// 如果有通讯中断时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_com_int_time == null ){
								
								cou_com_int_time = 0;
							}
							// 记录有多少个设备的通讯中断时长里面有值
							cou_com_int_time = cou_com_int_time+1;
							
							// 如果通讯中断时长合计字段为空,则赋值为0,方便下面计算
							if(sum_com_int_time == null ){
								
								sum_com_int_time = 0.0;
							}
							// 统计一共有多少通讯中断时长
							sum_com_int_time = sum_com_int_time+com_int_time;
						}
						
						chpLst.add(staInfMap);
					}
				} 
			}
		}
		
		// 求充电量平均值
		if(sum_phi != null && cou_phi != null){
			
			avg_phi = sum_phi/cou_phi;
			
		}
		
		// 求等价充电时平均值
		if(sum_phe != null && cou_phe != null){
			
			avg_phe = sum_phe/cou_phe;
			
		}
		
		// 求充电时长平均值
		if(sum_cnv_eff != null && cou_cnv_eff != null){
			
			avg_cnv_eff = sum_cnv_eff/cou_cnv_eff;
			
		}
		
		// 求充电时长平均值
		if(sum_charge_time != null && cou_charge_time != null){
			
			avg_charge_time = sum_charge_time/cou_charge_time;
			
		}
		
		// 求正常运行时长平均值
		if(sum_good_run_time != null && cou_good_run_time != null){
			
			avg_good_run_time = sum_good_run_time/cou_good_run_time;
			
		}
		
		// 求告警运行时长平均值
		if(sum_fault_time != null && cou_fault_time != null){
			
			avg_fault_time = sum_fault_time/cou_fault_time;
			
		}
		
		// 求故障停机时长平均值
		if(sum_failure_time != null && cou_failure_time != null){
			
			avg_failure_time = sum_failure_time/cou_failure_time;
			
		}
		
		// 求通讯中断时长平均值
		if(sum_com_int_time != null && cou_com_int_time != null){
			
			avg_com_int_time = sum_com_int_time/cou_com_int_time;
			
		}

		if (chpLst != null && !chpLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> chpMap : chpLst) {
				
				if(chpMap != null){
					// 判断获取回来的信息是否为空
					// 判断查询出来的电量值,是否小于由前台传过来的标记值,如果小于,将该值标记为黄色,如果不小于,则不标记
					if (map.get("flagValue") != null && !map.get("flagValue").toString().isEmpty() && Double.valueOf(chpMap.get("phi").toString()) < Double.valueOf(map.get("flagValue").toString())) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_i", 3);
						
					} else {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_i", 0);
					}
					
					if (map.get("flagValue") != null && !map.get("flagValue").toString().isEmpty() && Double.valueOf(chpMap.get("phe").toString()) < Double.valueOf(map.get("flagValue").toString())) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_e", 3);
						
					} else {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_e", 0);
					}
					
					// 判断查询出来的电量值,是否是最小电量,如果为最小电量,则将该值标记为红色
					if (chpMap.get("phi") != null && Double.valueOf(chpMap.get("phi").toString()).equals(min_phi)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_i", 1);
						
					} else if (chpMap.get("phi") != null && Double.valueOf(chpMap.get("phi").toString()).equals(max_phi)) {
						// 判断查询出来的电量值,是否是最大电量,如果为最大电量,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_i", 2);
					
					}else{
						
						chpMap.put("color_i", 0);
					}
					
					// 判断查询出来的电量值,是否是最小电量,如果为最小电量,则将该值标记为红色
					if (chpMap.get("phe") != null && Double.valueOf(chpMap.get("phe").toString()).equals(min_phe)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_e", 1);
						
					} else if (chpMap.get("phe") != null && Double.valueOf(chpMap.get("phe").toString()).equals(max_phe)) {
						// 判断查询出来的电量值,是否是最大电量,如果为最大电量,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_e", 2);
						
					}else{
						
						chpMap.put("color_e", 0);
					}
					
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("cnv_eff") != null && Double.valueOf(chpMap.get("cnv_eff").toString()).equals(min_cnv_eff)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ce", 1);
						
					} else if (chpMap.get("cnv_eff") != null && Double.valueOf(chpMap.get("cnv_eff").toString()).equals(max_cnv_eff)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ce", 2);
						
					}else{
						
						chpMap.put("color_ce", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("charge_time") != null && Double.valueOf(chpMap.get("charge_time").toString()).equals(min_charge_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ct", 1);
						
					} else if (chpMap.get("charge_time") != null && Double.valueOf(chpMap.get("charge_time").toString()).equals(max_charge_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ct", 2);
						
					}else{
						
						chpMap.put("color_ct", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("good_run_time") != null && Double.valueOf(chpMap.get("good_run_time").toString()).equals(min_good_run_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_grt", 1);
						
					} else if (chpMap.get("good_run_time") != null && Double.valueOf(chpMap.get("good_run_time").toString()).equals(max_good_run_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_grt", 2);
						
					}else{
						
						chpMap.put("color_grt", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("fault_time") != null && Double.valueOf(chpMap.get("fault_time").toString()).equals(min_fault_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ft", 1);
						
					} else if (chpMap.get("fault_time") != null && Double.valueOf(chpMap.get("fault_time").toString()).equals(max_fault_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ft", 2);
						
					}else{
						
						chpMap.put("color_ft", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("failure_time") != null && Double.valueOf(chpMap.get("failure_time").toString()).equals(min_failure_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_flt", 1);
						
					} else if (chpMap.get("failure_time") != null && Double.valueOf(chpMap.get("failure_time").toString()).equals(max_failure_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_flt", 2);
						
					}else{
						
						chpMap.put("color_flt", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("com_int_time") != null && Double.valueOf(chpMap.get("com_int_time").toString()).equals(min_com_int_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_cit", 1);
						
					} else if (chpMap.get("com_int_time") != null && Double.valueOf(chpMap.get("com_int_time").toString()).equals(max_com_int_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_cit", 2);
						
					}else{
						
						chpMap.put("color_cit", 0);
					}
				}
			}
		}
		
		Map<String,Object> maxMinAvgSumAndChpMap = new HashMap<String, Object>();
		// 将补数信息，填写至返回的Map中
		maxMinAvgSumAndChpMap.put("tol_tim", inpMaxMinAvgSumMap.get("sta_tim"));
		
		maxMinAvgSumAndChpMap.put("min_phi", min_phi);
		maxMinAvgSumAndChpMap.put("min_phe", min_phe);
		maxMinAvgSumAndChpMap.put("min_cnv_eff", min_cnv_eff);
		maxMinAvgSumAndChpMap.put("min_charge_time", min_charge_time);
		maxMinAvgSumAndChpMap.put("min_good_run_time", min_good_run_time);
		maxMinAvgSumAndChpMap.put("min_fault_time", min_fault_time);
		maxMinAvgSumAndChpMap.put("min_failure_time", min_failure_time);
		maxMinAvgSumAndChpMap.put("min_com_int_time", min_com_int_time);
		
		maxMinAvgSumAndChpMap.put("max_phi", max_phi);
		maxMinAvgSumAndChpMap.put("max_phe", max_phe);
		maxMinAvgSumAndChpMap.put("max_cnv_eff", max_cnv_eff);
		maxMinAvgSumAndChpMap.put("max_charge_time", max_charge_time);
		maxMinAvgSumAndChpMap.put("max_good_run_time", max_good_run_time);
		maxMinAvgSumAndChpMap.put("max_fault_time", max_fault_time);
		maxMinAvgSumAndChpMap.put("max_failure_time", max_failure_time);
		maxMinAvgSumAndChpMap.put("max_com_int_time", max_com_int_time);
		
		maxMinAvgSumAndChpMap.put("avg_phi", avg_phi);
		maxMinAvgSumAndChpMap.put("avg_phe", avg_phe);
		maxMinAvgSumAndChpMap.put("avg_cnv_eff", avg_cnv_eff);
		maxMinAvgSumAndChpMap.put("avg_charge_time", avg_charge_time);
		maxMinAvgSumAndChpMap.put("avg_good_run_time", avg_good_run_time);
		maxMinAvgSumAndChpMap.put("avg_fault_time", avg_fault_time);
		maxMinAvgSumAndChpMap.put("avg_failure_time", avg_failure_time);
		maxMinAvgSumAndChpMap.put("avg_com_int_time", avg_com_int_time);
		
		maxMinAvgSumAndChpMap.put("sum_phi", sum_phi);
		maxMinAvgSumAndChpMap.put("sum_phe", sum_phe);
		maxMinAvgSumAndChpMap.put("sum_cnv_eff", sum_cnv_eff);
		maxMinAvgSumAndChpMap.put("sum_charge_time", sum_charge_time);
		maxMinAvgSumAndChpMap.put("sum_good_run_time", sum_good_run_time);
		maxMinAvgSumAndChpMap.put("sum_fault_time", sum_fault_time);
		maxMinAvgSumAndChpMap.put("sum_failure_time", sum_failure_time);
		maxMinAvgSumAndChpMap.put("sum_com_int_time", sum_com_int_time);
		
		maxMinAvgSumAndChpMap.put("pcLst", chpLst);
		
		maxMinAvgSumAndChpLst.add(maxMinAvgSumAndChpMap);
		
		return maxMinAvgSumAndChpLst;
	}

	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChpStaMonYear(Map<String, Object> map) throws Exception {
		// 获取某年、月、日起始和结束时间点集合
		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), map.get("type").toString());
		
		// 获取该站内所有的光伏逆变器设备
		List<Map<String, Object>> equInfLst = systemDao.getChpInfLstByPwsIdAppTyp(map);
		// 返回值集合
		List<Map<String, Object>> returnLst = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		// 所有光伏设备,每一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合
		List<Map<String, Object>> maxMinAvgSumAndChpLst = new ArrayList<Map<String, Object>>();
		
		for (Map<String, Object> dayMonYearTimMap : dayMonYearTimLst) {
			// 所有光伏设备,某一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合
			Map<String, Object> maxMinAvgSumAndChpMap = new HashMap<String, Object>();
			
			Map<String, Object> inpMaxMinAvgSumMap = new HashMap<String, Object>();
			// 时间段开始时间
			inpMaxMinAvgSumMap.put("sta_tim", dayMonYearTimMap.get("staTim"));
			// 时间段结束时间
			inpMaxMinAvgSumMap.put("end_tim", dayMonYearTimMap.get("endTim"));
			// 电站ID(必输项)
			inpMaxMinAvgSumMap.put("pws_id", map.get("pws_id"));
			// 设备型号
			inpMaxMinAvgSumMap.put("app_mod", map.get("app_mod"));
			// 设备额定功率（容量）段，开始容量值
			inpMaxMinAvgSumMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
			// 设备额定功率（容量）段，结束容量值
			inpMaxMinAvgSumMap.put("end_rtd_pow", map.get("end_rtd_pow"));
			List<Map<String, Object>> chpLst = new ArrayList<Map<String, Object>>();
			// 获取时间段信息
			List<Map<String, Object>> maxMinAvgSumLst = statisticAnalysisDao.getChpStaMaxMinAvgSum(inpMaxMinAvgSumMap);
			
			if (maxMinAvgSumLst == null || maxMinAvgSumLst.isEmpty() || maxMinAvgSumLst.get(0) == null) {
				
				// 将补数信息，填写至返回的Map中
				maxMinAvgSumAndChpMap.put("tol_tim", inpMaxMinAvgSumMap.get("sta_tim"));
				
				if (equInfLst != null && !equInfLst.isEmpty()) {
					
					for (Map<String, Object> equInfmap : equInfLst) {
						
						equInfmap.put("equ_num", equInfmap.get("equ_num"));
						
						chpLst.add(equInfmap);
					}
				}
				
				maxMinAvgSumAndChpMap.put("chpLst", chpLst);
				
			} else {
				// 遍历取回来的统计数据
				for (Map<String, Object> maxMinAvgSumMap : maxMinAvgSumLst) {
					
					// 将补数信息，填写至返回的Map中
					maxMinAvgSumAndChpMap.put("tol_tim", inpMaxMinAvgSumMap.get("sta_tim"));
					
					maxMinAvgSumAndChpMap.put("min_cha_vol", maxMinAvgSumMap.get("min_cha_vol"));
					
					maxMinAvgSumAndChpMap.put("max_cha_vol", maxMinAvgSumMap.get("max_cha_vol"));
					
					maxMinAvgSumAndChpMap.put("avg_cha_vol", maxMinAvgSumMap.get("avg_cha_vol"));
					
					maxMinAvgSumAndChpMap.put("sum_cha_vol", maxMinAvgSumMap.get("sum_cha_vol"));
					
					if (equInfLst != null && !equInfLst.isEmpty()) {
						// 遍历设备信息列表（当前站内的所有设备信息列表）
						for (Map<String, Object> equInfmap : equInfLst) {
							// 将设备列表信息中的设备编号，传入获取电量信息的接口
							inpMaxMinAvgSumMap.put("equ_num",equInfmap.get("equ_num"));
							// 使用上面查出来的光伏设备编号以及给定的时间段，获取单位时间内的电量信息(1条)
							List<Map<String, Object>> staInfLst = statisticAnalysisDao.getChpStaInfLst(inpMaxMinAvgSumMap);
							// 判断获取回来的信息是否为空
							if (staInfLst != null && !staInfLst.isEmpty() && staInfLst.get(0) != null ) {
								
								for (Map<String, Object> staInfMap : staInfLst) {
									
									if(staInfMap != null && !staInfMap.isEmpty()){
										
										// 判断查询出来的电量值,是否小于由前台传过来的标记值,如果小于,将该值标记为黄色,如果不小于,则不标记
										if (map.get("flagValue") != null && !map.get("flagValue").toString().isEmpty() && Double.valueOf(staInfMap.get("cha_vol").toString()) < Double.valueOf(map.get("flagValue").toString())) {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 3);
											
										} else {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 0);
										}
										
										
										// 判断查询出来的电量值,是否是最小电量,如果为最小电量,则将该值标记为红色
										if (staInfMap.get("cha_vol").equals(maxMinAvgSumMap.get("min_cha_vol"))) {
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 1);
											
										} else if (staInfMap.get("cha_vol").equals(maxMinAvgSumMap.get("max_cha_vol"))) {
											// 判断查询出来的电量值,是否是最大电量,如果为最大电量,则将该值标记为蓝色
											
											// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
											staInfMap.put("color", 2);
										}
									}else{
										staInfMap = new HashMap<String, Object>();

										staInfMap.put("equ_num",equInfmap.get("equ_num"));

										staInfMap.put("tol_tim",inpMaxMinAvgSumMap.get("sta_tim"));

									}
									chpLst.add(staInfMap);
								}
							} else { // 如果为空的话,创建一个返回值集合
								
								Map<String, Object> staInfMap = new HashMap<String, Object>();
								
								staInfMap.put("equ_num",equInfmap.get("equ_num"));
								
								staInfMap.put("tol_tim",inpMaxMinAvgSumMap.get("sta_tim"));
								
								chpLst.add(staInfMap);
							}
						}
					}
				}
				maxMinAvgSumAndChpMap.put("chpLst", chpLst);
			}
			maxMinAvgSumAndChpLst.add(maxMinAvgSumAndChpMap);
		}
		// 将得到的所有光伏设备,每一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合放入返回集合中
		returnMap.put("maxMinAvgSumAndChpLst", maxMinAvgSumAndChpLst);
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		
		String sta_tim = "";
		
		String end_tim = "";
		// 如果查询纬度为月
		if(map.get("type").toString().equals("2")){
			// 获取到查询月1日0点0分0秒的时间
			sta_tim = sdf.format(sdf.parse(map.get("date").toString()));
			// 获取到查询月下一月1日0点0分0秒的时间
			end_tim = DateUtil.addMonth(sta_tim);
			
			// 如果查询纬度为年
		}else if(map.get("type").toString().equals("3")){
			
			Calendar calendar = Calendar.getInstance();
			
			calendar.setTime(sdf.parse(map.get("date").toString()));
			
			int year = calendar.get(Calendar.YEAR);
			// 获取到查询年1月1日0点0分0秒的时间
			sta_tim = DateUtil.getYearMonthDayString(year, 1, 1);
			// 获取到查询年下一年1月1日0点0分0秒的时间
			end_tim = DateUtil.getYearMonthDayString(year+1, 1, 1);
		}
		
		if (equInfLst != null && !equInfLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> equInfmap : equInfLst) {
				
				Map<String, Object> inpChpStaInfMap = new HashMap<String, Object>();
				
				// 时间段开始时间
				inpChpStaInfMap.put("sta_tim", sta_tim);
				// 时间段结束时间
				inpChpStaInfMap.put("end_tim", end_tim);
				// 电站ID(必输项)
				inpChpStaInfMap.put("pws_id", map.get("pws_id"));
				// 设备型号
				inpChpStaInfMap.put("app_mod", map.get("app_mod"));
				// 设备额定功率（容量）段，开始容量值
				inpChpStaInfMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
				// 设备额定功率（容量）段，结束容量值
				inpChpStaInfMap.put("end_rtd_pow", map.get("end_rtd_pow"));
				// 将设备列表信息中的设备编号，传入获取电量信息的接口
				inpChpStaInfMap.put("equ_num",equInfmap.get("equ_num"));
				// 获取制定光伏逆变器的指定时间段的电量统计数据
				List<Map<String, Object>> staInfTolLst = statisticAnalysisDao.getChpStaInfLstTol(inpChpStaInfMap);
				
				// 判断获取回来的信息是否为空,补0
				if (staInfTolLst != null && !staInfTolLst.isEmpty() && staInfTolLst.get(0) != null) {
					
					for(Map<String, Object> staInfTolMap : staInfTolLst){
						
						equInfmap.put("tol_cha_vol", staInfTolMap.get("tol_cha_vol"));
						
					}
				}
			}
		}
		// 将得到的所有光伏设备当月电量统计数据列表集合放入返回集合中
		returnMap.put("chpTolLst", equInfLst);
		
		Map<String, Object> inpTolChpMap = new HashMap<String, Object>();
		
		// 时间段开始时间
		inpTolChpMap.put("sta_tim", sta_tim);
		// 时间段结束时间
		inpTolChpMap.put("end_tim", end_tim);
		// 电站ID(必输项)
		inpTolChpMap.put("pws_id", map.get("pws_id"));
		// 设备型号
		inpTolChpMap.put("app_mod", map.get("app_mod"));
		// 设备额定功率（容量）段，开始容量值
		inpTolChpMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
		// 设备额定功率（容量）段，结束容量值
		inpTolChpMap.put("end_rtd_pow", map.get("end_rtd_pow"));
		
		// 获取指定电站的指定时间段的电量统计数据
		List<Map<String, Object>> staTolLst = statisticAnalysisDao.getChpStaTol(inpTolChpMap);
		
		// 判断获取回来的信息是否为空,补0
		if (staTolLst == null || staTolLst.isEmpty() || staTolLst.get(0) == null) {
			
			staTolLst = new ArrayList<Map<String,Object>>();
			
			Map<String, Object> staTolMap = new HashMap<String, Object>();
			
			staTolLst.add(staTolMap);
		}
		
		returnMap.put("staTolLst", staTolLst);
		
		returnLst.add(returnMap);
		
		return returnLst;
	}
	
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChpInfStaBetweenDay(Map<String, Object> map) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		
		String sta_tim = "";
		
		if(map.get("sta_tim") != null && !map.get("sta_tim").toString().isEmpty()){
			
			sta_tim = map.get("sta_tim").toString();
			
		}
		
		String end_tim = "";
		
		if(map.get("end_tim") != null && !map.get("end_tim").toString().isEmpty()){
			
			end_tim =  sdf.format(DateUtil.addDay(sdf.parse(map.get("end_tim").toString()), 1));
			
		}
		
		// 获取该站内所有的充电桩设备
		List<Map<String, Object>> equInfLst = systemDao.getChpInfLstByPwsIdAppTyp(map);
		
		// 所有光伏设备,每一天的最大电量、最小电量、平均电量、统计电量、每日电量列表集合
		List<Map<String, Object>> maxMinAvgSumAndChpLst = new ArrayList<Map<String, Object>>();
		// 最小
		Double min_cha_vol = null;
		Double min_cha_vol_whe_equ = null;
		Double min_cha_vol_tim = null;
		Double min_good_run_time = null;
		Double min_fault_time = null;
		Double min_failure_time = null;
		Double min_com_int_time = null;
		// 最大
		Double max_cha_vol = null;
		Double max_cha_vol_whe_equ = null;
		Double max_cha_vol_tim = null;
		Double max_good_run_time = null;
		Double max_fault_time = null;
		Double max_failure_time = null;
		Double max_com_int_time = null;
		// 平均
		Double avg_cha_vol = null;
		Double avg_cha_vol_whe_equ = null;
		Double avg_cha_vol_tim = null;
		Double avg_good_run_time = null;
		Double avg_fault_time = null;
		Double avg_failure_time = null;
		Double avg_com_int_time = null;
		// 合计
		Double sum_cha_vol = null;
		Double sum_cha_vol_whe_equ = null;
		Double sum_cha_vol_tim = null;
		Double sum_good_run_time = null;
		Double sum_fault_time = null;
		Double sum_failure_time = null;
		Double sum_com_int_time = null;
		// 平均值查数
		Integer cou_cha_vol = null;
		Integer cou_cha_vol_whe_equ = null;
		Integer cou_cha_vol_tim = null;
		Integer cou_good_run_time = null;
		Integer cou_fault_time = null;
		Integer cou_failure_time = null;
		Integer cou_com_int_time = null;
		
		Map<String, Object> inpMaxMinAvgSumMap = new HashMap<String, Object>();
		// 时间段开始时间
		inpMaxMinAvgSumMap.put("sta_tim", sta_tim);
		// 时间段结束时间
		inpMaxMinAvgSumMap.put("end_tim", end_tim);
		// 电站ID(必输项)
		inpMaxMinAvgSumMap.put("pws_id", map.get("pws_id"));
		// 设备型号
		inpMaxMinAvgSumMap.put("app_mod", map.get("app_mod"));
		// 设备额定功率（容量）段，开始容量值
		inpMaxMinAvgSumMap.put("sta_rtd_pow", map.get("sta_rtd_pow"));
		// 设备额定功率（容量）段，结束容量值
		inpMaxMinAvgSumMap.put("end_rtd_pow", map.get("end_rtd_pow"));
		
		List<Map<String, Object>> chpLst = new ArrayList<Map<String,Object>>();
		
		if (equInfLst != null && !equInfLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> equInfmap : equInfLst) {
				// 将设备列表信息中的设备编号，传入获取电量信息的接口
				inpMaxMinAvgSumMap.put("equ_num",equInfmap.get("equ_num"));
				// 使用上面查出来的光伏设备编号以及给定的时间段，获取单位时间内的电量信息(1条)
				List<Map<String, Object>> staInfLst = statisticAnalysisDao.getChpInfStaInfLst(inpMaxMinAvgSumMap);
				// 判断获取回来的信息是否为空
				if (staInfLst != null && !staInfLst.isEmpty()) {
					
					for (Map<String, Object> staInfMap : staInfLst) {
						// 充电量统计
						if(staInfMap != null && staInfMap.get("cha_vol") != null){
							// 取出充电量
							Double cha_vol = Double.valueOf(staInfMap.get("cha_vol").toString());
							// 如果最小充电量统计数据值为空,则赋值为0,方便下面计算
							if(min_cha_vol == null ){
								
								min_cha_vol = cha_vol;
							}
							// 判断取出的充电量与最小充电量哪个小,如果取出的充电量小,则将充电量赋给最小充电量
							if(cha_vol<min_cha_vol){
								
								min_cha_vol = cha_vol;
							}
							// 如果最大充电量统计数据值为空,则赋值为0,方便下面计算
							if(max_cha_vol == null ){
								
								max_cha_vol = cha_vol;
							}
							// 判断取出的充电量与最大充电量哪个大,如果取出的充电量大,则将充电量赋给最大充电量
							if(cha_vol>max_cha_vol){
								
								max_cha_vol = cha_vol;
							}
							
							// 如果有充电量的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_cha_vol == null ){
								
								cou_cha_vol = 0;
							}
							// 记录有多少个设备的充电量里面有值
							cou_cha_vol = cou_cha_vol+1;
							
							// 如果充电量合计字段为空,则赋值为0,方便下面计算
							if(sum_cha_vol == null ){
								
								sum_cha_vol = 0.0;
							}
							// 统计一共充了多少电
							sum_cha_vol = sum_cha_vol+cha_vol;
						}
						
						// 等价充电时统计
						if(staInfMap != null && staInfMap.get("cha_vol_whe_equ") != null){
							// 取出等价充电时
							Double cha_vol_whe_equ = Double.valueOf(staInfMap.get("cha_vol_whe_equ").toString());
							// 如果最小等价充电时统计数据值为空,则赋值为0,方便下面计算
							if(min_cha_vol_whe_equ == null ){
								
								min_cha_vol_whe_equ = cha_vol_whe_equ;
							}
							// 判断取出的等价充电时与最小等价充电时哪个小,如果取出的等价充电时小,则将等价充电时赋给最小等价充电时
							if(cha_vol_whe_equ<min_cha_vol_whe_equ){
								
								min_cha_vol_whe_equ = cha_vol_whe_equ;
							}
							// 如果最大充电量统计数据值为空,则赋值为0,方便下面计算
							if(max_cha_vol_whe_equ == null ){
								
								max_cha_vol_whe_equ = cha_vol_whe_equ;
							}
							// 判断取出的等价充电时与最大等价充电时哪个大,如果取出的等价充电时大,则将等价充电时赋给最大等价充电时
							if(cha_vol_whe_equ>max_cha_vol_whe_equ){
								
								max_cha_vol_whe_equ = cha_vol_whe_equ;
							}
							
							// 如果有等价充电时的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_cha_vol_whe_equ == null ){
								
								cou_cha_vol_whe_equ = 0;
							}
							// 记录有多少个设备的等价充电时里面有值
							cou_cha_vol_whe_equ = cou_cha_vol_whe_equ+1;
							
							// 如果等价充电时合计字段为空,则赋值为0,方便下面计算
							if(sum_cha_vol_whe_equ == null ){
								
								sum_cha_vol_whe_equ = 0.0;
							}
							// 统计一共有多少等价充电时
							sum_cha_vol_whe_equ = sum_cha_vol_whe_equ+cha_vol_whe_equ;
						}
						
						
						// 充电时长统计
						if(staInfMap != null && staInfMap.get("cha_vol_tim") != null){
							// 取出等价充电时
							Double cha_vol_tim = Double.valueOf(staInfMap.get("cha_vol_tim").toString());
							// 如果最小充电时长统计数据值为空,则赋值为0,方便下面计算
							if(min_cha_vol_tim == null ){
								
								min_cha_vol_tim = cha_vol_tim;
							}
							// 判断取出的充电时长与最小充电时长哪个小,如果取出的充电时长小,则将充电时长赋给最小充电时长
							if(cha_vol_tim<min_cha_vol_tim){
								
								min_cha_vol_tim = cha_vol_tim;
							}
							// 如果最大充电时长统计数据值为空,则赋值为0,方便下面计算
							if(max_cha_vol_tim == null ){
								
								max_cha_vol_tim = cha_vol_tim;
							}
							// 判断取出的充电时长与最大充电时长哪个大,如果取出的充电时长大,则将充电时长赋给最大充电时长
							if(cha_vol_tim>max_cha_vol_tim){
								
								max_cha_vol_tim = cha_vol_tim;
							}
							
							// 如果有充电时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_cha_vol_tim == null ){
								
								cou_cha_vol_tim = 0;
							}
							// 记录有多少个设备的充电时长里面有值
							cou_cha_vol_tim = cou_cha_vol_tim+1;
							
							// 如果充电时长合计字段为空,则赋值为0,方便下面计算
							if(sum_cha_vol_tim == null ){
								
								sum_cha_vol_tim = 0.0;
							}
							// 统计一共有多少充电时长
							sum_cha_vol_tim = sum_cha_vol_tim+cha_vol_tim;
						}
						

						// 正常运行时长统计
						if(staInfMap != null && staInfMap.get("good_run_time") != null){
							// 取出正常运行时长
							Double good_run_time = Double.valueOf(staInfMap.get("good_run_time").toString());
							// 如果最小正常运行时长统计数据值为空,则赋值为0,方便下面计算
							if(min_good_run_time == null ){
								
								min_good_run_time = good_run_time;
							}
							// 判断取出的正常运行时长与最小正常运行时长哪个小,如果取出的正常运行时长小,则将正常运行时长赋给最小正常运行时长
							if(good_run_time<min_good_run_time){
								
								min_good_run_time = good_run_time;
							}
							// 如果最大正常运行时长统计数据值为空,则赋值为0,方便下面计算
							if(max_good_run_time == null ){
								
								max_good_run_time = good_run_time;
							}
							// 判断取出的正常运行时长与最大正常运行时长哪个大,如果取出的正常运行时长大,则将正常运行时长赋给最大正常运行时长
							if(good_run_time>max_good_run_time){
								
								max_good_run_time = good_run_time;
							}
							
							// 如果有正常运行时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_good_run_time == null ){
								
								cou_good_run_time = 0;
							}
							// 记录有多少个设备的正常运行时长里面有值
							cou_good_run_time = cou_good_run_time+1;
							
							// 如果正常运行时长合计字段为空,则赋值为0,方便下面计算
							if(sum_good_run_time == null ){
								
								sum_good_run_time = 0.0;
							}
							// 统计一共有多少正常运行时长
							sum_good_run_time = sum_good_run_time+good_run_time;
						}
						
						
						// 告警运行时长统计
						if(staInfMap != null && staInfMap.get("fault_time") != null){
							// 取出告警运行时长
							Double fault_time = Double.valueOf(staInfMap.get("fault_time").toString());
							// 如果最小告警运行时长统计数据值为空,则赋值为0,方便下面计算
							if(min_fault_time == null ){
								
								min_fault_time = fault_time;
							}
							// 判断取出的告警运行时长与最小告警运行时长哪个小,如果取出的告警运行时长小,则将告警运行时长赋给最小告警运行时长
							if(fault_time<min_fault_time){
								
								min_fault_time = fault_time;
							}
							// 如果最大告警运行时长统计数据值为空,则赋值为0,方便下面计算
							if(max_fault_time == null ){
								
								max_fault_time = fault_time;
							}
							// 判断取出的告警运行时长与最大告警运行时长哪个大,如果取出的告警运行时长大,则将告警运行时长赋给最大告警运行时长
							if(fault_time>max_fault_time){
								
								max_fault_time = fault_time;
							}
							
							// 如果有告警运行时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_fault_time == null ){
								
								cou_fault_time = 0;
							}
							// 记录有多少个设备的告警运行时长里面有值
							cou_fault_time = cou_fault_time+1;
							
							// 如果告警运行时长合计字段为空,则赋值为0,方便下面计算
							if(sum_fault_time == null ){
								
								sum_fault_time = 0.0;
							}
							// 统计一共有多少告警运行时长
							sum_fault_time = sum_fault_time+fault_time;
						}
						
						
						// 故障停机时长统计
						if(staInfMap != null && staInfMap.get("failure_time") != null){
							// 取出故障停机时长
							Double failure_time = Double.valueOf(staInfMap.get("failure_time").toString());
							// 如果最小故障停机时长统计数据值为空,则赋值为0,方便下面计算
							if(min_failure_time == null ){
								
								min_failure_time = failure_time;
							}
							// 判断取出的故障停机时长与最小故障停机时长哪个小,如果取出的故障停机时长小,则将故障停机时长赋给最小故障停机时长
							if(failure_time<min_failure_time){
								
								min_failure_time = failure_time;
							}
							// 如果最大故障停机时长统计数据值为空,则赋值为0,方便下面计算
							if(max_failure_time == null ){
								
								max_failure_time = failure_time;
							}
							// 判断取出的故障停机时长与最大故障停机时长哪个大,如果取出的故障停机时长大,则将故障停机时长赋给最大故障停机时长
							if(failure_time>max_failure_time){
								
								max_failure_time = failure_time;
							}
							
							// 如果有故障停机时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_failure_time == null ){
								
								cou_failure_time = 0;
							}
							// 记录有多少个设备的故障停机时长里面有值
							cou_failure_time = cou_failure_time+1;
							
							// 如果故障停机时长合计字段为空,则赋值为0,方便下面计算
							if(sum_failure_time == null ){
								
								sum_failure_time = 0.0;
							}
							// 统计一共有多少故障停机时长
							sum_failure_time = sum_failure_time+failure_time;
						}
						
						// 通讯中断时长统计
						if(staInfMap != null && staInfMap.get("com_int_time") != null){
							// 取出通讯中断时长
							Double com_int_time = Double.valueOf(staInfMap.get("com_int_time").toString());
							// 如果最小通讯中断时长统计数据值为空,则赋值为0,方便下面计算
							if(min_com_int_time == null ){
								
								min_com_int_time = com_int_time;
							}
							// 判断取出的通讯中断时长与最小通讯中断时长哪个小,如果取出的通讯中断时长小,则将通讯中断时长赋给最小通讯中断时长
							if(com_int_time<min_com_int_time){
								
								min_com_int_time = com_int_time;
							}
							// 如果最大通讯中断时长统计数据值为空,则赋值为0,方便下面计算
							if(max_com_int_time == null ){
								
								max_com_int_time = com_int_time;
							}
							// 判断取出的通讯中断时长与最大通讯中断时长哪个大,如果取出的通讯中断时长大,则将通讯中断时长赋给最大通讯中断时长
							if(com_int_time>max_com_int_time){
								
								max_com_int_time = com_int_time;
							}
							
							// 如果有通讯中断时长的设备个数字段为空,则赋值为0,方便下面计算
							if(cou_com_int_time == null ){
								
								cou_com_int_time = 0;
							}
							// 记录有多少个设备的通讯中断时长里面有值
							cou_com_int_time = cou_com_int_time+1;
							
							// 如果通讯中断时长合计字段为空,则赋值为0,方便下面计算
							if(sum_com_int_time == null ){
								
								sum_com_int_time = 0.0;
							}
							// 统计一共有多少通讯中断时长
							sum_com_int_time = sum_com_int_time+com_int_time;
						}
						
						chpLst.add(staInfMap);
					}
				} 
			}
		}
		
		// 求充电量平均值
		if(sum_cha_vol != null && cou_cha_vol != null){
			
			avg_cha_vol = sum_cha_vol/cou_cha_vol;
			
		}
		
		// 求等价充电时平均值
		if(sum_cha_vol_whe_equ != null && cou_cha_vol_whe_equ != null){
			
			avg_cha_vol_whe_equ = sum_cha_vol_whe_equ/cou_cha_vol_whe_equ;
			
		}
		
		// 求充电时长平均值
		if(sum_cha_vol_tim != null && cou_cha_vol_tim != null){
			
			avg_cha_vol_tim = sum_cha_vol_tim/cou_cha_vol_tim;
			
		}
		
		// 求正常运行时长平均值
		if(sum_good_run_time != null && cou_good_run_time != null){
			
			avg_good_run_time = sum_good_run_time/cou_good_run_time;
			
		}
		
		// 求告警运行时长平均值
		if(sum_fault_time != null && cou_fault_time != null){
			
			avg_fault_time = sum_fault_time/cou_fault_time;
			
		}
		
		// 求故障停机时长平均值
		if(sum_failure_time != null && cou_failure_time != null){
			
			avg_failure_time = sum_failure_time/cou_failure_time;
			
		}
		
		// 求通讯中断时长平均值
		if(sum_com_int_time != null && cou_com_int_time != null){
			
			avg_com_int_time = sum_com_int_time/cou_com_int_time;
			
		}

		if (chpLst != null && !chpLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> chpMap : chpLst) {
				
				if(chpMap != null){
					
					// 判断获取回来的信息是否为空
					// 判断查询出来的电量值,是否小于由前台传过来的标记值,如果小于,将该值标记为黄色,如果不小于,则不标记
					if (map.get("flagValue") != null && !map.get("flagValue").toString().isEmpty() && Double.valueOf(chpMap.get("cha_vol").toString()) < Double.valueOf(map.get("flagValue").toString())) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color", 3);
						
					} else {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color", 0);
					}
					
					// 判断查询出来的电量值,是否是最小电量,如果为最小电量,则将该值标记为红色
					if (chpMap.get("cha_vol") != null && Double.valueOf(chpMap.get("cha_vol").toString()).equals(min_cha_vol)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color", 1);
						
					} else if (chpMap.get("cha_vol") != null && Double.valueOf(chpMap.get("cha_vol").toString()).equals(max_cha_vol)) {
						// 判断查询出来的电量值,是否是最大电量,如果为最大电量,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color", 2);
					}
					
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("cha_vol_whe_equ") != null && Double.valueOf(chpMap.get("cha_vol_whe_equ").toString()).equals(min_cha_vol_whe_equ)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_we", 1);
						
					} else if (chpMap.get("cha_vol_whe_equ") != null && Double.valueOf(chpMap.get("cha_vol_whe_equ").toString()).equals(max_cha_vol_whe_equ)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_we", 2);
						
					}else{
						
						chpMap.put("color_we", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("cha_vol_tim") != null && Double.valueOf(chpMap.get("cha_vol_tim").toString()).equals(min_cha_vol_tim)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_cvt", 1);
						
					} else if (chpMap.get("cha_vol_tim") != null && Double.valueOf(chpMap.get("cha_vol_tim").toString()).equals(max_cha_vol_tim)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_cvt", 2);
						
					}else{
						
						chpMap.put("color_cvt", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("good_run_time") != null && Double.valueOf(chpMap.get("good_run_time").toString()).equals(min_good_run_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_grt", 1);
						
					} else if (chpMap.get("good_run_time") != null && Double.valueOf(chpMap.get("good_run_time").toString()).equals(max_good_run_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_grt", 2);
						
					}else{
						
						chpMap.put("color_grt", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("fault_time") != null && Double.valueOf(chpMap.get("fault_time").toString()).equals(min_fault_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ft", 1);
						
					} else if (chpMap.get("fault_time") != null && Double.valueOf(chpMap.get("fault_time").toString()).equals(max_fault_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_ft", 2);
						
					}else{
						
						chpMap.put("color_ft", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("failure_time") != null && Double.valueOf(chpMap.get("failure_time").toString()).equals(min_failure_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_flt", 1);
						
					} else if (chpMap.get("failure_time") != null && Double.valueOf(chpMap.get("failure_time").toString()).equals(max_failure_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_flt", 2);
						
					}else{
						
						chpMap.put("color_flt", 0);
					}
					
					// 判断查询出来的转换效率,是否是最小转换效率,如果为最小转换效率,则将该值标记为红色
					if (chpMap.get("com_int_time") != null && Double.valueOf(chpMap.get("com_int_time").toString()).equals(min_com_int_time)) {
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_cit", 1);
						
					} else if (chpMap.get("com_int_time") != null && Double.valueOf(chpMap.get("com_int_time").toString()).equals(max_com_int_time)) {
						// 判断查询出来的转换效率,是否是最大转换效率,如果为最大转换效率,则将该值标记为蓝色
						
						// color为1时，显示红色。为2，显示蓝色。为3，显示黄色。为0，不显示颜色
						chpMap.put("color_cit", 2);
						
					}else{
						
						chpMap.put("color_cit", 0);
					}
				}
			}
		}
		
		Map<String,Object> maxMinAvgSumAndChpMap = new HashMap<String, Object>();
		// 将补数信息，填写至返回的Map中
		maxMinAvgSumAndChpMap.put("tol_tim", inpMaxMinAvgSumMap.get("sta_tim"));
		
		maxMinAvgSumAndChpMap.put("min_cha_vol", min_cha_vol);
		maxMinAvgSumAndChpMap.put("min_cha_vol_whe_equ", min_cha_vol_whe_equ);
		maxMinAvgSumAndChpMap.put("min_cha_vol_tim", min_cha_vol_tim);
		maxMinAvgSumAndChpMap.put("min_good_run_time", min_good_run_time);
		maxMinAvgSumAndChpMap.put("min_fault_time", min_fault_time);
		maxMinAvgSumAndChpMap.put("min_failure_time", min_failure_time);
		maxMinAvgSumAndChpMap.put("min_com_int_time", min_com_int_time);
		
		maxMinAvgSumAndChpMap.put("max_cha_vol", max_cha_vol);
		maxMinAvgSumAndChpMap.put("max_cha_vol_whe_equ", max_cha_vol_whe_equ);
		maxMinAvgSumAndChpMap.put("max_cha_vol_tim", max_cha_vol_tim);
		maxMinAvgSumAndChpMap.put("max_good_run_time", max_good_run_time);
		maxMinAvgSumAndChpMap.put("max_fault_time", max_fault_time);
		maxMinAvgSumAndChpMap.put("max_failure_time", max_failure_time);
		maxMinAvgSumAndChpMap.put("max_com_int_time", max_com_int_time);
		
		maxMinAvgSumAndChpMap.put("avg_cha_vol", avg_cha_vol);
		maxMinAvgSumAndChpMap.put("avg_cha_vol_whe_equ", avg_cha_vol_whe_equ);
		maxMinAvgSumAndChpMap.put("avg_cha_vol_tim", avg_cha_vol_tim);
		maxMinAvgSumAndChpMap.put("avg_good_run_time", avg_good_run_time);
		maxMinAvgSumAndChpMap.put("avg_fault_time", avg_fault_time);
		maxMinAvgSumAndChpMap.put("avg_failure_time", avg_failure_time);
		maxMinAvgSumAndChpMap.put("avg_com_int_time", avg_com_int_time);
		
		maxMinAvgSumAndChpMap.put("sum_cha_vol", sum_cha_vol);
		maxMinAvgSumAndChpMap.put("sum_cha_vol_whe_equ", sum_cha_vol_whe_equ);
		maxMinAvgSumAndChpMap.put("sum_cha_vol_tim", sum_cha_vol_tim);
		maxMinAvgSumAndChpMap.put("sum_good_run_time", sum_good_run_time);
		maxMinAvgSumAndChpMap.put("sum_fault_time", sum_fault_time);
		maxMinAvgSumAndChpMap.put("sum_failure_time", sum_failure_time);
		maxMinAvgSumAndChpMap.put("sum_com_int_time", sum_com_int_time);
		
		maxMinAvgSumAndChpMap.put("chpLst", chpLst);
		
		maxMinAvgSumAndChpLst.add(maxMinAvgSumAndChpMap);
		
		return maxMinAvgSumAndChpLst;
	}

	
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPlanPowerLst(Map<String, Object> map) throws Exception {
		
		return statisticAnalysisDao.getPlanPowerLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getPlanPowerLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> couLst = statisticAnalysisDao.getPlanPowerLstCou(map);
		
		if (couLst != null && couLst.size() > 0) {
			
			for (Map<String, Object> couMap : couLst) {
				
				return couMap;
			}
		}
		return null;
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPlanPowerInfById(Map<String, Object> map) throws Exception {
		
		return statisticAnalysisDao.getPlanPowerInfById(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertPlanPower(Map<String, Object> map) throws Exception {
		
		statisticAnalysisDao.insertPlanPower(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updatePlanPower(Map<String, Object> map) throws Exception {
		
		statisticAnalysisDao.updatePlanPower(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void deletePlanPower(Map<String, Object> map) throws Exception {
		
		statisticAnalysisDao.deletePlanPower(map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getFsbPowerLst(Map<String, Object> map) throws Exception {
		
		return statisticAnalysisDao.getFsbPowerLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getFsbPowerLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> couLst = statisticAnalysisDao.getFsbPowerLstCou(map);
		
		if (couLst != null && couLst.size() > 0) {
			
			for (Map<String, Object> couMap : couLst) {
				
				return couMap;
			}
		}
		return null;
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getFsbPowerInfById(Map<String, Object> map) throws Exception {
		
		return statisticAnalysisDao.getFsbPowerInfById(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertFsbPower(Map<String, Object> map) throws Exception {
		
		statisticAnalysisDao.insertFsbPower(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updateFsbPower(Map<String, Object> map) throws Exception {
		
		statisticAnalysisDao.updateFsbPower(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void deleteFsbPower(Map<String, Object> map) throws Exception {
		
		statisticAnalysisDao.deleteFsbPower(map);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getFsbHvLst(Map<String, Object> map) throws Exception {
		
		return statisticAnalysisDao.getFsbHvLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getFsbHvLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> couLst = statisticAnalysisDao.getFsbHvLstCou(map);
		
		if (couLst != null && couLst.size() > 0) {
			
			for (Map<String, Object> couMap : couLst) {
				
				return couMap;
			}
		}
		return null;
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getFsbHvInfById(Map<String, Object> map) throws Exception {
		
		return statisticAnalysisDao.getFsbHvInfById(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertFsbHv(Map<String, Object> map) throws Exception {
		
		statisticAnalysisDao.insertFsbHv(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updateFsbHv(Map<String, Object> map) throws Exception {
		
		statisticAnalysisDao.updateFsbHv(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void deleteFsbHv(Map<String, Object> map) throws Exception {
		
		statisticAnalysisDao.deleteFsbHv(map);
	}

	
	/*------------------------------------采集数据查询Start------------------------------------*/
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getCollectDataLst(Map<String, Object> map) {
		
		if(map.get("typ_ide").toString().equals("CNNBQ")){// CNNBQ代表查询储能逆变器，
			
			return statisticAnalysisDao.getIscsEquPcsHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("DCDC")){// DCDC代表查询DC/DC设备，
			
			return statisticAnalysisDao.getIscsEquDcdcHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("BYQ")){// BYQ代表查询变压器设备，
			
			return statisticAnalysisDao.getIscsEquTransfHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("DB")){// DB代表查询电表设备，
			
			return statisticAnalysisDao.getIscsEquMeterHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("DNZLJCZZ")){// DNZLJCZZ代表查询电能质量检测装置，
			
			return statisticAnalysisDao.getIscsEquPqsmsHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("HLX")){// HLX代表查询汇流箱设备，
			
			return statisticAnalysisDao.getIscsEquBoxHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("GFNBQ")){// GFNBQ代表查询光伏逆变器设备，

			return statisticAnalysisDao.getIscsEquPvsHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("JLPDG")){// JLPDG代表查询交流配电柜设备，
			
			return statisticAnalysisDao.getIscsEquAcdbHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("ZLPDG")){// ZLPDG代表查询直流配电柜设备,
			
			return statisticAnalysisDao.getIscsEquDcdbHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("HJJCY")){// HJJCY代表查询环境检测仪设备，
			
			return statisticAnalysisDao.getIscsEquEnvHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("CNDC")){// CNDC代表查询储能电池设备，
			
			return statisticAnalysisDao.getIscsEquBmsHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("JLZZ")){// JLZZ代表查询解列装置，
			
			return statisticAnalysisDao.getIscsEquDctDevHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("XLBH")){// XLBH代表查询线路保护设备，
			
			return statisticAnalysisDao.getIscsEquLnePttHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("ZLCDZLC")){// ZLCDZLC代表查询直流充电桩充电流程信息,
			
			return statisticAnalysisDao.getIscsEquDcChpOrdHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("ZLCDZSS")){// ZLCDZSS代表查询直流充电桩充电中实时数据，
			
			return statisticAnalysisDao.getIscsEquDcChpRelHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("ZLCDZDJ")){// ZLCDZDJ代表查询直流充电桩待机状态信息，
			
			return statisticAnalysisDao.getIscsEquDcChpStdHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("JLCDZLC")){// JLCDZLC代表查询交流充电桩充电流程信息,
			
			return statisticAnalysisDao.getIscsEquAcChpOrdHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("JLCDZSS")){// JLCDZSS代表查询交流充电桩充电中实时数据，
			
			return statisticAnalysisDao.getIscsEquAcChpRelHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("JLCDZDJ")){// JLCDZDJ代表查询交流充电桩待机状态信息，
			
			return statisticAnalysisDao.getIscsEquAcChpStdHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("DDQCGC")){// DDQCGC代表查询电动汽车充电过程信息，
			
			return statisticAnalysisDao.getIscsEquChpCarOrdHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("DDQCSS")){// DDQCSS代表查询电动汽车充电信息实时数据,
			
			return statisticAnalysisDao.getIscsEquChpCarStaHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("KZQ")){// KZQ代表查询控制器设备。
			
			return statisticAnalysisDao.getIscsEquCtlHistoryInfLst(map);
			
		}else if(map.get("typ_ide").toString().equals("WWXT")){// KZQ代表查询控制器设备。
			
			return statisticAnalysisDao.getIscsEquMicHistoryInfLst(map);
			
		}
		return null;
	}
	
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getCollectDataLstCou(Map<String, Object> map) {
		
		if(map.get("typ_ide").toString().equals("CNNBQ")){// CNNBQ代表查询储能逆变器，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquPcsHistoryInfLstCou(map);
			
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("DCDC")){// DCDC代表查询DC/DC设备，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquDcdcHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("BYQ")){// BYQ代表查询变压器设备，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquTransfHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("DB")){// DB代表查询电表设备，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquMeterHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("DNZLJCZZ")){// DNZLJCZZ代表查询电能质量检测装置，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquPqsmsHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("HLX")){// HLX代表查询汇流箱设备，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquBoxHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("GFNBQ")){// GFNBQ代表查询光伏逆变器设备，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquPvsHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("JLPDG")){// JLPDG代表查询交流配电柜设备，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquAcdbHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("ZLPDG")){// ZLPDG代表查询直流配电柜设备,
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquDcdbHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("HJJCY")){// HJJCY代表查询环境检测仪设备，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquEnvHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("CNDC")){// CNDC代表查询储能电池设备，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquBoxHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("JLZZ")){// JLZZ代表查询解列装置，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquDctDevHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("XLBH")){// XLBH代表查询线路保护设备，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquLnePttHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("ZLCDZLC")){// ZLCDZLC代表查询直流充电桩充电流程信息,
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquDcChpOrdHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("ZLCDZSS")){// ZLCDZSS代表查询直流充电桩充电中实时数据，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquDcChpRelHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("ZLCDZDJ")){// ZLCDZDJ代表查询直流充电桩待机状态信息，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquDcChpStdHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("JLCDZLC")){// JLCDZLC代表查询交流充电桩充电流程信息,
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquAcChpOrdHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("JLCDZSS")){// JLCDZSS代表查询交流充电桩充电中实时数据，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquAcChpRelHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("JLCDZDJ")){// JLCDZDJ代表查询交流充电桩待机状态信息，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquAcChpStdHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("DDQCGC")){// DDQCGC代表查询电动汽车充电过程信息，
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquChpCarOrdHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("DDQCSS")){// DDQCSS代表查询电动汽车充电信息实时数据,
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquChpCarStaHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
			
		}else if(map.get("typ_ide").toString().equals("KZQ")){// KZQ代表查询控制器设备。
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquCtlHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
		}else if(map.get("typ_ide").toString().equals("WWXT")){// KZQ代表查询控制器设备。
			
			List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquMicHistoryInfLstCou(map);
			
			if (couLst != null && couLst.size() > 0) {
				
				for (Map<String, Object> couMap : couLst) {
					
					return couMap;
				}
			}
			return null;
		}
		return null;
	}
	
	
	/*------------------------------------采集数据查询End------------------------------------*/
	
	
	/*------------------------------------告警数据查询Start------------------------------------*/
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getFatDataLst(Map<String, Object> map) {
		
		return statisticAnalysisDao.getIscsEquFauInfLst(map);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getFatDataLstCou(Map<String, Object> map) {
		
		List<Map<String, Object>> couLst =  statisticAnalysisDao.getIscsEquFauInfLstCou(map);
		
		if (couLst != null && couLst.size() > 0) {
			
			for (Map<String, Object> couMap : couLst) {
				
				return couMap;
			}
		}
		return null;
	}
	
	
	/*------------------------------------告警数据查询End------------------------------------*/
	
	/*------------------------------------年月电站报表Start------------------------------------*/
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getPwsYearMonthReportInfLst(Map<String, Object> map) throws ParseException {
	
		List<Map<String,Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		// type为1为月报表,type为2为年报表
		if(map.get("type").toString().equals("1")){
			// 获取某年、月、日起始和结束时间点集合
			List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "2");
			
			if(monLst != null && !monLst.isEmpty()){
				
				for(Map<String, Object> monMap:monLst){
					
					map.put("sta_tim", monMap.get("staTim"));
					
					map.put("end_tim", monMap.get("endTim"));
					
					Map<String,Object> returnMap = new HashMap<String, Object>();
					
					// 获取电站中月报表信息(光伏逆变器)
					List<Map<String, Object>> pvsLst = statisticAnalysisDao.getPwsMonthReportInfLstPVS(map);
					
					if(pvsLst.get(0) != null && !pvsLst.isEmpty()){
						
						for(Map<String, Object> pvsMap:pvsLst){
							
							returnMap.put("power", pvsMap.get("power"));
							
							returnMap.put("pow_gen_eff_hours", pvsMap.get("pow_gen_eff_hours"));
						}
					}
					
					// 获取电站中月报表信息(储能逆变器)
					List<Map<String, Object>> pcsLst = statisticAnalysisDao.getPwsMonthReportInfLstPCS(map);
					
					if(pcsLst.get(0) != null && !pcsLst.isEmpty()){
						
						for(Map<String, Object> pcsMap:pcsLst){
							
							returnMap.put("phi", pcsMap.get("phi"));
							
							returnMap.put("phe", pcsMap.get("phe"));
						}
					}
					
					// 获取电站中月报表信息(充电桩)
					List<Map<String, Object>> chpLst = statisticAnalysisDao.getPwsMonthReportInfLstChp(map);
					
					if(chpLst.get(0) != null && !chpLst.isEmpty()){
						
						for(Map<String, Object> chpMap:chpLst){
							
							returnMap.put("cha_vol", chpMap.get("cha_vol"));
							
							returnMap.put("cha_tim", chpMap.get("cha_tim"));
							
							returnMap.put("cha_gen_eff_hours", chpMap.get("cha_gen_eff_hours"));
						}
					}
					
					// 获取电站中月报表信息(辐射)
					List<Map<String, Object>> hvLst = statisticAnalysisDao.getPwsMonthReportInfLstHv(map);
					
					if(hvLst.get(0) != null && !hvLst.isEmpty()){
						
						for(Map<String, Object> hvMap:hvLst){
							
							returnMap.put("pvs_sun_hour", hvMap.get("pvs_sun_hour"));
							
							returnMap.put("pvs_pek_sun_hour", hvMap.get("pvs_pek_sun_hour"));
							
							returnMap.put("pvs_radiation_tol", hvMap.get("pvs_radiation_tol"));
						}
					}
					
					returnMap.put("tol_tim", monMap.get("staTim"));
					
					returnLst.add(returnMap);
				}
			}
		}else if(map.get("type").toString().equals("2")){
			// 获取某年、月、日起始和结束时间点集合
			List<Map<String, Object>> yearLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "3");
			
			if(yearLst != null && !yearLst.isEmpty()){
				
				for(Map<String, Object> yearMap:yearLst){
					
					map.put("sta_tim", yearMap.get("staTim"));
					
					map.put("end_tim", yearMap.get("endTim"));
					
					Map<String,Object> returnMap = new HashMap<String, Object>();
					
					// 获取电站中年报表信息(光伏)
					List<Map<String, Object>> pvsLst = statisticAnalysisDao.getPwsYearReportInfLstPVS(map);
					
					if(pvsLst.get(0) != null && !pvsLst.isEmpty()){
						
						for(Map<String, Object> pvsMap:pvsLst){
							
							returnMap.put("power", pvsMap.get("power"));
							
							returnMap.put("pow_gen_eff_hours", pvsMap.get("pow_gen_eff_hours"));
						}
					}
					
					// 获取电站中年报表信息(储能)
					List<Map<String, Object>> pcsLst = statisticAnalysisDao.getPwsYearReportInfLstPCS(map);
					
					if(pcsLst.get(0) != null && !pcsLst.isEmpty()){
						
						for(Map<String, Object> pcsMap:pcsLst){
							
							returnMap.put("phi", pcsMap.get("phi"));
							
							returnMap.put("phe", pcsMap.get("phe"));
						}
					}
					
					// 获取电站中年报表信息(充电桩)
					List<Map<String, Object>> chpLst = statisticAnalysisDao.getPwsYearReportInfLstChp(map);
					
					if(chpLst.get(0) != null && !chpLst.isEmpty()){
						
						for(Map<String, Object> chpMap:chpLst){
							
							returnMap.put("cha_vol", chpMap.get("cha_vol"));
							
							returnMap.put("cha_tim", chpMap.get("cha_tim"));
							
							returnMap.put("cha_gen_eff_hours", chpMap.get("cha_gen_eff_hours"));
						}
					}
					
					// 获取电站中年报表信息(辐射)
					List<Map<String, Object>> hvLst = statisticAnalysisDao.getPwsYearReportInfLstHv(map);
					
					if(hvLst.get(0) != null && !hvLst.isEmpty()){
						
						for(Map<String, Object> hvMap:hvLst){
							
							returnMap.put("pvs_sun_hour", hvMap.get("pvs_sun_hour"));
							
							returnMap.put("pvs_pek_sun_hour", hvMap.get("pvs_pek_sun_hour"));
							
							returnMap.put("pvs_radiation_tol", hvMap.get("pvs_radiation_tol"));
						}
					}
					
					returnMap.put("tol_tim", yearMap.get("staTim"));
					
					returnLst.add(returnMap);
				}
			}
		}
		
		return returnLst;
	}
	
	
	/*------------------------------------年月电站报表End------------------------------------*/
	
	
	
	/*------------------------------------电站电表信息报表Start------------------------------------*/
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPwsMeterReportInfLst(Map<String, Object> map) throws Exception {

		// 获取该站内所有的指定类型的电表设备集合
		List<Map<String, Object>> equInfLst = statisticAnalysisDao.getPwsMeterInfLst(map);
		
		if (equInfLst != null && !equInfLst.isEmpty()) {
			// 遍历设备信息列表（当前站内的所有设备信息列表）
			for (Map<String, Object> equInfmap : equInfLst) {
				
				equInfmap.put("sta_tim",map.get("sta_tim"));
				
				equInfmap.put("end_tim",map.get("end_tim"));
				// 使用上面查出来的电表设备编号以及给定的时间段，获取单位时间内的电表统计信息(1条)
				List<Map<String, Object>> staInfLst = statisticAnalysisDao.getPwsMeterReportInfLst(equInfmap);
				
				equInfmap.put("meterInfLst", staInfLst);
			}
		}
		
		return equInfLst;
	}
	
	/*------------------------------------电站电表信息报表End------------------------------------*/
}
