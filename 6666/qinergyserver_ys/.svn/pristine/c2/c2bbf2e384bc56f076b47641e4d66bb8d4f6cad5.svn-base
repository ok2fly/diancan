package com.qinergy.service.statisticanalysis.analysis.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.statisticanalysis.analysis.PowerRationAnalysisDao;
import com.qinergy.service.statisticanalysis.analysis.PowerRationAnalysisService;
import com.qinergy.util.DateUtil;

@Service("rationAnalysisService")
public class PowerRationAnalysisServiceImpl implements PowerRationAnalysisService {

	@Autowired
	PowerRationAnalysisDao rationAnalysisDao;
	
	/**
	 * 功率预测与限电分析	 查询纬度为 天（间隔15分钟一个数据。一天一条）
	 */
	@Override
	public Map<String, Object> getPowerRation(String pws_id, String tim_point) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd ");
		// 时间初始化
		String initTim = DateUtil.initDate(new SimpleDateFormat("yyyy-MM-dd").parse(tim_point));// 初始化
		// 时间加1天
		String endTim = sdf.format(DateUtil.addDay(sdf.parse(initTim), 1)); // 选中日期加一天

		Map<String, Object> mapParam = new HashMap<String, Object>();
		
		mapParam.put("pws_id", pws_id);
		
		mapParam.put("val_sta", 1);	//统计有效标志（1有效2无效3数据丢失）
		
		mapParam.put("startTim", initTim);
		
		mapParam.put("endTim", endTim);
		
		//type 数据类型（1：光伏功率预测，2：负荷功率预测，3：调度功率）
		//1.获取一天的光伏功率预测
		mapParam.put("typ", 1);
		// 实际、预测、调度下发功率预测 
		List<Map<String, Object>> pVPowerRation = rationAnalysisDao.getPowerRation(mapParam);

		List<Map<String, Object>> pvFctPowerLst = new ArrayList<Map<String,Object>>();
		// 从数据库中获取的数据以十五分钟为一个数据点的方式进行数据格式化
		if(pVPowerRation != null && !pVPowerRation.isEmpty()){
			
			String fct_value = "fct_value";
			
			for(Map<String, Object> pvFctPowerCurvesMap : pVPowerRation){
				
				String day = sdfd.format(sdf.parse(pvFctPowerCurvesMap.get("tol_tim").toString()));
				
				for(int i = 0 ; i< 96 ; i++){
					
					Map<String, Object> pvFctPowerMap = new HashMap<String, Object>();
					
					String min = "";
					
					int hour = i/4;
					
					String tol_tim = " ";
					
					if(i%4 == 1){
						
						min = ":15:00";
						
					}else if(i%4 == 2){
						
						min = ":30:00";
						
					}else if(i%4 == 3){
						
						min = ":45:00";
						
					}else if(i%4 == 0){
						
						min = ":00:00";
					}
					if(hour<10){
						
						tol_tim = day+"0"+hour+min;
						
					}else{
						
						tol_tim = day+hour+min;
					}
					
					pvFctPowerMap.put("tol_tim", tol_tim);
					
					pvFctPowerMap.put("fct_value", pvFctPowerCurvesMap.get(fct_value+(i+1)));
					
					pvFctPowerLst.add(pvFctPowerMap);
				}
			}
		}else{
			// 从数据库中获取的数据以十五分钟为一个数据点的方式进行数据格式化
			pVPowerRation = new ArrayList<Map<String,Object>>();
			
			String day = sdfd.format(new Date());
			
			for(int i = 0 ; i< 96 ; i++){
				
				Map<String, Object> pvFctPowerMap = new HashMap<String, Object>();
				
				String min = "";
				
				int hour = i/4;
				
				String tol_tim = " ";
				
				if(i%4 == 1){
					
					min = ":15:00";
					
				}else if(i%4 == 2){
					
					min = ":30:00";
					
				}else if(i%4 == 3){
					
					min = ":45:00";
					
				}else if(i%4 == 0){
					
					min = ":00:00";
				}
				
				if(hour<10){
					
					tol_tim = day+"0"+hour+min;
					
				}else{
					
					tol_tim = day+hour+min;
				}
				
				pvFctPowerMap.put("tol_tim", tol_tim);
				
				pvFctPowerLst.add(pvFctPowerMap);
			}
		}
		
		//2：获取一天的实际发电功率
		mapParam.put("end_tim", endTim);
		// 获取曲线图的信息(光储网荷分析)
		List<Map<String, Object>> curLst = rationAnalysisDao.getStorNetCharge(mapParam);
		
		List<Map<String, Object>> loadPowerLst = new ArrayList<Map<String,Object>>();
		// 将上述曲线转换成15分钟曲线图方法
		List<Map<String, Object>> pcLst = DateUtil.getFifteenMinutesCurves(initTim, curLst);
		
		if(pcLst != null && !pcLst.isEmpty()){
			
			for(Map<String, Object> pcMap:pcLst){
				
				Map<String, Object> pvFctPowerMap = new HashMap<String, Object>();
				
				pvFctPowerMap.put("tol_tim", DateUtil.stampToDate(pcMap.get("tol_tim").toString()));
				
				pvFctPowerMap.put("fct_value", pcMap.get("pv_power"));
				
				loadPowerLst.add(pvFctPowerMap);
			}
		}
		
		//3：获取一天的调度功率
		mapParam.put("typ", 3);
		
		List<Map<String, Object>> dispPowerRation = rationAnalysisDao.getPowerRation(mapParam);

		List<Map<String, Object>> dispPowerLst = new ArrayList<Map<String,Object>>();
		
		// 从数据库中获取的数据以十五分钟为一个数据点的方式进行数据格式化
		if(dispPowerRation != null && !dispPowerRation.isEmpty()){
			
			String fct_value = "fct_value";
			
			for(Map<String, Object> dispPowerMap : dispPowerRation){
				
				String day = sdfd.format(sdf.parse(dispPowerMap.get("tol_tim").toString()));
				
				for(int i = 0 ; i< 96 ; i++){
					
					Map<String, Object> pvFctPowerMap = new HashMap<String, Object>();
					
					String min = "";
					
					int hour = i/4;
					
					String tol_tim = "";
					
					if(i%4 == 1){
						
						min = ":15:00";
						
					}else if(i%4 == 2){
						
						min = ":30:00";
						
					}else if(i%4 == 3){
						
						min = ":45:00";
						
					}else if(i%4 == 0){
						
						min = ":00:00";
					}
					
					if(hour<10){
						
						tol_tim = day+"0"+hour+min;
						
					}else{
						
						tol_tim = day+hour+min;
					}
					
					pvFctPowerMap.put("tol_tim", tol_tim);
					
					pvFctPowerMap.put("fct_value", dispPowerMap.get(fct_value+(i+1)));
					
					dispPowerLst.add(pvFctPowerMap);
				}
			}
		}else{
			// 从数据库中获取的数据以十五分钟为一个数据点的方式进行数据格式化
			dispPowerRation = new ArrayList<Map<String,Object>>();
			
			String day = sdfd.format(new Date());
			
			for(int i = 0 ; i< 96 ; i++){
				
				Map<String, Object> dispPowerMap = new HashMap<String, Object>();
				
				String min = "";
				
				int hour = i/4;
				
				String tol_tim = " ";
				
				if(i%4 == 1){
					
					min = ":15:00";
					
				}else if(i%4 == 2){
					
					min = ":30:00";
					
				}else if(i%4 == 3){
					
					min = ":45:00";
					
				}else if(i%4 == 0){
					
					min = ":00:00";
				}
				
				if(hour<10){
					
					tol_tim = day+"0"+hour+min;
					
				}else{
					
					tol_tim = day+hour+min;
				}
				
				dispPowerMap.put("tol_tim", tol_tim);
				
				dispPowerLst.add(dispPowerMap);
			}
		}
		
		resultMap.put("pVList", pvFctPowerLst);
		
		resultMap.put("loadList", loadPowerLst);
		
		resultMap.put("dispList", dispPowerLst);
		
		return resultMap;
	}


	/**
	 * 储能系统分析 查询纬度为年
	 */
	@Override
	public List<Map<String, Object>> getEnergyStorage(String pws_id, String tim_type, String tim_point) throws Exception {

		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();

		// 获取任意一年的 （eq: staTim:2017-1-1 & endTim:2018-1-1）（获取某年、月、日起始和结束时间点集合）
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimLst(tim_point, "3");
		if (yearTimPoint != null && yearTimPoint.size() > 0) {
			
			// 获取 一年中每个月的 startTim和endTim 集合
			Map<String, Object> mapParam = null;
			
			Map<String, Object> mapResult = null;
			
			for (Map<String, Object> monthTim : yearTimPoint) {
				
				mapParam = new HashMap<String, Object>();
				
				mapParam.put("pws_id", pws_id);
				
				mapParam.put("startTim", monthTim.get("staTim"));
				
				mapParam.put("endTim", monthTim.get("endTim"));
				
				mapResult = new HashMap<String, Object>();
				
				// 实际储能数据（储能系统分析）
				List<Map<String, Object>> energyStorage = rationAnalysisDao.getEnergyStorage(mapParam);
				
				if (energyStorage != null && energyStorage.size() > 0) {
					
					mapResult.put("pws_id", energyStorage.get(0).get("pws_id"));
					
					mapResult.put("pcs_phi", energyStorage.get(0).get("pcs_phi"));
					
					mapResult.put("pcs_phe", energyStorage.get(0).get("pcs_phe"));
				}
				// 计划储能数据（计划充放电）
				List<Map<String, Object>> energyStoragePlan = rationAnalysisDao.getEnergyStoragePlan(mapParam);
				
				if (energyStoragePlan != null && energyStoragePlan.size() > 0) {
				
					mapResult.put("pws_id", energyStoragePlan.get(0).get("pws_id"));
					
					mapResult.put("plan_phi", energyStoragePlan.get(0).get("plan_phi"));
					
					mapResult.put("plan_phe", energyStoragePlan.get(0).get("plan_phe"));
					
					mapResult.put("plan_tim", energyStoragePlan.get(0).get("plan_tim"));
				}
				
				mapResult.put("tol_tim", monthTim.get("staTim"));
				
				listResult.add(mapResult);
			}
		}
		return listResult;
	}


	/**
	 * 光储网荷分析 查询纬度为 天（间隔为15分钟）
	 */
	@Override
	public List<Map<String, Object>> getStorNetCharge(String pws_id, String tim_type, String tim_point) throws Exception {
		// 时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 时间初始化
		String initTim = DateUtil.initDate(new SimpleDateFormat("yyyy-MM-dd").parse(tim_point));// 初始化
		// 天数加1
		String endTim = sdf.format(DateUtil.addDay(sdf.parse(initTim), 1)); // 选中日期加一天

		Map<String, Object> mapParam = new HashMap<String, Object>();
		
		mapParam.put("pws_id", pws_id);
		
		mapParam.put("startTim", initTim);
		
		mapParam.put("endTim", endTim);
		
		mapParam.put("sta_tim", initTim);
		
		mapParam.put("end_tim", endTim);
		// 获取曲线图的信息（光储网荷分析）
		List<Map<String, Object>> curLst = rationAnalysisDao.getStorNetCharge(mapParam);
		// 获取15分钟曲线图方法
		return DateUtil.getFifteenMinutesCurves(initTim, curLst);
	}
	

}
