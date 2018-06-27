package com.qinergy.service.statisticanalysis.analysis.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.statisticanalysis.analysis.SolarResourAnalysisDao;
import com.qinergy.service.statisticanalysis.analysis.SolarResourAnalysisService;
import com.qinergy.util.DateUtil;

/**
 * @desc: 电站分析（电站和设备分析）实现类
 * @author: Qist
 * @date: 2017年11月1日
 */
@Repository("solarResourAnalysisService")
public class SolarResourAnalysisServiceImpl extends BaseDao implements SolarResourAnalysisService {

	@Autowired
	SolarResourAnalysisDao solarResourAnalysisDao;

	/**
	 * 理论辐射量和实际辐射量  查询最近12个月  App接口
	 */
	@Override
	public Map<String, Object> getSolarResourcesApp(String pws_id, String tim_point) throws Exception {
		
		Map<String, Object> mapResult = new LinkedHashMap<String, Object>();
		
		List<Map<String,Object>> solarFreList = new ArrayList<Map<String,Object>>();	
		
		List<Map<String,Object>> solarRealList = new ArrayList<Map<String,Object>>();	
		
		// 获取任意一年的 startTim和endTim（获取某年、月、日起始和结束时间点集合(传入minDate与maxDate)）
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimBettwenLst(tim_point, tim_point, "4");
		
		if (yearTimPoint != null && yearTimPoint.size() > 0) {
			
			String endTim = (String)yearTimPoint.get(0).get("endTim");
		
			Map<String, Object> mapParam = new HashMap<String, Object>();
			
			mapParam.put("pws_id", pws_id);
			
			mapParam.put("staTim", endTim);
			
			mapParam.put("endTim", DateUtil.addYear(endTim, 1));
			
			// 1. 获取一年理论辐射量 
			List<Map<String, Object>> feaSolar = solarResourAnalysisDao.getFeaSolarResources(mapParam);
			
			if(feaSolar != null && feaSolar.size() > 0){
				
				Map<String, Object> solarFreMap = null; 
				
				for (int i = 0; i < feaSolar.size(); i++) {
					
					Map<String, Object> feaMap = feaSolar.get(i);
					
					if(feaMap != null && !feaMap.isEmpty()){
						
						solarFreMap = new LinkedHashMap<String, Object>(); //存放每个月的值
						
						Double fsb_hv = (Double)feaMap.get("fsb_hv");
						
						String month = feaMap.get("month").toString();
						
						solarFreMap.put("monthFre", fsb_hv);
						
						solarFreMap.put("month", month);
					}
					
					solarFreList.add(solarFreMap);
				}
			}
			
			// 2.获取当年 实测辐射量(一月一条) 
			// 获取某年、月、日起始和结束时间点集合(传入minDate与maxDate)
			List<Map<String, Object>> monthTimList = DateUtil.getDayMonYearTimBettwenLst(
					mapParam.get("staTim").toString(),mapParam.get("endTim").toString(), "3");
			
			Map<String, Object> solarRealMap = null; 
			
			for (int i = 0; i < monthTimList.size(); i++) {
				
				mapParam.put("staTim", monthTimList.get(i).get("staTim"));
				
				mapParam.put("endTim", monthTimList.get(i).get("endTim"));

				solarRealMap  = new LinkedHashMap<String, Object>();
				// 实测辐射量 月统计
				Map<String, Object> realSolar = solarResourAnalysisDao.getRealSolarResources(mapParam);
				
				if(realSolar != null && !realSolar.isEmpty()){
					
					solarRealMap.put("monthReal", realSolar.get("radiation"));
					
				}else{
					
					solarRealMap.put("monthReal", 0.0);
				}
				
				solarRealList.add(solarRealMap);
			}
		}
		
		mapResult.put("freList", solarFreList);
		
		mapResult.put("realList", solarRealList);
		
		return mapResult;
	}
	
	/**
	 * 理论辐射量和实际辐射量  查询最近12个月 
	 */
	@Override
	public Map<String, Object> getSolarResources(String pws_id, String tim_point) throws Exception {
		
		Map<String, Object> mapResult = new LinkedHashMap<String, Object>();
		
		Map<String, Object> mapReal1 = new LinkedHashMap<String, Object>();
		
		Map<String, Object> mapFre1 = new LinkedHashMap<String, Object>();
		
		// 获取任意一年的 startTim和endTim
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimBettwenLst(DateUtil.addYear(tim_point, 1), DateUtil.addYear(tim_point, 1), "4");
		
		if (yearTimPoint != null && yearTimPoint.size() > 0) {
			
			String staTim = (String)yearTimPoint.get(0).get("staTim");
			
			String endTim = (String)yearTimPoint.get(0).get("endTim");
			
			Map<String, Object> mapParam = new HashMap<String, Object>();
			
			mapParam.put("pws_id", pws_id);
			
			mapParam.put("sta_mon", 1);
			
			mapParam.put("end_mon", 13);
			
			// 1. 获取一年理论辐射量  
			List<Map<String, Object>> feaSolarResources = solarResourAnalysisDao.getFeaSolarResources(mapParam);
			
			Double sum_fsb_hv = 0.0;
			// 非空判断
			if(feaSolarResources != null && feaSolarResources.size() > 0){
				// 循环遍历
				for (int i = 0; i < feaSolarResources.size(); i++) {
					// 赋值与计算
					Map<String, Object> feaSolar = feaSolarResources.get(i);
					
					if(feaSolar != null && !feaSolar.isEmpty()){
						
						Double fsb_hv = (Double)feaSolar.get("fsb_hv");
						
						String month = feaSolar.get("month") + "";
						
						sum_fsb_hv += fsb_hv;
						
						mapFre1.put(month, fsb_hv);	
					}
				}
				
				mapFre1.put("sum", sum_fsb_hv);
				// 获取某个时间的年份
				mapFre1.put("year", DateUtil.getYear(staTim));
			}
			
			// 获取 一年中每个月的 startTim和endTim 集合
			String statimString = staTim;
			
			String endtimString = endTim;
			// 获取某年、月、日起始和结束时间点集合(传入minDate与maxDate)
			List<Map<String, Object>> monthTimList = DateUtil.getDayMonYearTimBettwenLst(statimString,endtimString, "3");
		
			for (int i = 0; i < monthTimList.size(); i++) {
				
				mapParam.put("staTim", monthTimList.get(i).get("staTim"));
				
				mapParam.put("endTim", monthTimList.get(i).get("endTim"));
				
				// 2.获取当年 实测辐射量(一月一条) 
				Map<String, Object> realSolar = solarResourAnalysisDao.getRealSolarResources(mapParam);
				
				if(realSolar != null && !realSolar.isEmpty()){
					// 获取某个时间的月份
					String month = DateUtil.getMonth((Date)realSolar.get("tol_tim")) + "";
					
					mapReal1.put(month, realSolar.get("radiation"));
				}
			}
			mapReal1.put("year", DateUtil.getYear(mapParam.get("staTim").toString()));
			
			mapResult.put("mapFre1", mapFre1);
			
			mapResult.put("mapReal1", mapReal1);
		}
		return mapResult;
	}
	
	/**
	 * 理论辐射量和实际辐射量  查询最近12个月 (App)
	 */
	@Override
	public Map<String, Object> getSolarResourcesAp(String pws_id, String tim_point) throws Exception {
		
		List<Map<String,Object>> retFreLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String,Object>> retRealLst = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> mapResult = new LinkedHashMap<String, Object>();
		
		// 获取任意一年的 startTim和endTim
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimBettwenLst(DateUtil.addYear(tim_point, 1), DateUtil.addYear(tim_point, 1), "4");
		
		if (yearTimPoint != null && yearTimPoint.size() > 0) {
			
			String staTim = yearTimPoint.get(0).get("staTim").toString();
			
			String endTim = yearTimPoint.get(0).get("endTim").toString();
			
			Map<String, Object> mapParam = new HashMap<String, Object>();
			
			mapParam.put("pws_id", pws_id);
			
			// 获取 一年中每个月的 startTim和endTim 集合
			for(int i=1;i<13;i++){
				
				mapParam.put("mon", i);
				
				Map<String, Object> mapFre1 = new LinkedHashMap<String, Object>();
				// 理论辐射量 
				List<Map<String, Object>> feaSolarResourcesLst = solarResourAnalysisDao.getFeaSolarResources(mapParam);
				// 非空判断
				if(feaSolarResourcesLst != null && !feaSolarResourcesLst.isEmpty() && feaSolarResourcesLst.get(0) != null){
					// 循环遍历
					for (Map<String, Object> feaSolarResourcesMap:feaSolarResourcesLst) {
						
						mapFre1.put("hv", feaSolarResourcesMap.get("fsb_hv"));
					}
				}
				// 将拼接的时间转换成时间戳
				mapFre1.put("date", DateUtil.dateToStamp(DateUtil.getYear(staTim)+"-"+i+"-01 00:00:00"));
				
				retFreLst.add(mapFre1);
			}
			
			// 1. 获取一年理论辐射量
			List<Map<String, Object>> monthTimList = DateUtil.getDayMonYearTimBettwenLst(staTim,endTim, "3");
			// 循环遍历
			for (int i = 0; i < monthTimList.size(); i++) {
				
				mapParam.put("staTim", monthTimList.get(i).get("staTim"));
				
				mapParam.put("endTim", monthTimList.get(i).get("endTim"));

				Map<String, Object> mapReal1 = new LinkedHashMap<String, Object>();
				
				// 2.获取当年 实测辐射量(一月一条)
				Map<String, Object> realSolar = solarResourAnalysisDao.getRealSolarResources(mapParam);
				// 非空判断
				if(realSolar != null && !realSolar.isEmpty()){
					
					mapReal1.put("hv", realSolar.get("radiation"));
				}
				// 将拼接的时间转换成时间戳
				mapReal1.put("date", DateUtil.dateToStamp(mapParam.get("staTim").toString()+" 00:00:00"));
				
				retRealLst.add(mapReal1);
			}
			
			mapResult.put("retFreLst", retFreLst);
			
			mapResult.put("retRealLst", retRealLst);
		}
		return mapResult;
	}
	
	
	/**
	 * 太阳能资源分布 数据  按天查询
	 */
	@Override
	public Map<String, Object> getSolarDataByEnvInfo(String pws_id) throws Exception {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("pws_id", pws_id);
		//设置从30天前的历史数据 中取最新的一条
		map.put("timPoint", DateUtil.getCertainDate(-30));
		
		//	环境监测仪 数据中最新值
		List<Map<String, Object>> envInfo = solarResourAnalysisDao.getSolarDataEnvInfo(map);
		
		Map<String,Object> resMap = null;
		// 非空判断
		if(envInfo != null && !envInfo.isEmpty()){
			
			Map<String, Object> maxMap = envInfo.get(0);
			
			resMap = new LinkedHashMap<String, Object>();
			
			Double rad0100W2m   = Double.valueOf(maxMap.get("rad0-100W-2m").toString());
			
			Double rad100200W2m = Double.valueOf(maxMap.get("rad100-200W-2m").toString());
			
			Double rad200300W2m = Double.valueOf(maxMap.get("rad200-300W-2m").toString());
			
			Double rad300400W2m = Double.valueOf(maxMap.get("rad300-400W-2m").toString());
			
			Double rad400500W2m = Double.valueOf(maxMap.get("rad400-500W-2m").toString());
			
			Double rad500600W2m = Double.valueOf(maxMap.get("rad500-600W-2m").toString());
			
			Double rad600700W2m = Double.valueOf(maxMap.get("rad600-700W-2m").toString());
			
			Double rad700800W2m = Double.valueOf(maxMap.get("rad700-800W-2m").toString());
			
			Double rad800900W2m = Double.valueOf(maxMap.get("rad800-900W-2m").toString());
			
			Double rad9001000W2m = Double.valueOf(maxMap.get("rad900-1000W-2m").toString());
			
			Double rad1000W2mThan = Double.valueOf(maxMap.get("rad1000W-2mThan").toString());
			//	计算当天 净值累计总和
			Double radSum = rad0100W2m + rad100200W2m + rad200300W2m + rad300400W2m + rad400500W2m +
					rad500600W2m + rad600700W2m + rad700800W2m + rad800900W2m + rad9001000W2m + rad1000W2mThan;
		
			resMap.put("rad0100W2m",  rad0100W2m);
			
			resMap.put("rad100200W2m", rad100200W2m);
			
			resMap.put("rad200300W2m", rad200300W2m);
			
			resMap.put("rad300400W2m", rad300400W2m);
			
			resMap.put("rad400500W2m", rad400500W2m);
			
			resMap.put("rad500600W2m", rad500600W2m);
			
			resMap.put("rad600700W2m", rad600700W2m);
			
			resMap.put("rad700800W2m", rad700800W2m);
			
			resMap.put("rad800900W2m", rad800900W2m);
			
			resMap.put("rad9001000W2m", rad9001000W2m);
			
			resMap.put("rad1000W2mThan", rad1000W2mThan);
			
			resMap.put("radSum", radSum);
		}
		return resMap;
	}

}
