package com.qinergy.service.statisticanalysis.analysis.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.statisticanalysis.analysis.ElecEarnAnalysisDao;
import com.qinergy.dao.system.SystemDao;
import com.qinergy.service.statisticanalysis.analysis.ElecEarnAnalysisService;
import com.qinergy.util.DateUtil;

@Service("elecEarnAnalysisService")
public class ElecEarnAnalysisServiceImpl implements ElecEarnAnalysisService {

	@Autowired
	ElecEarnAnalysisDao earnAnalysisDao;

	@Autowired
	SystemDao systemDao;
	
	/**
	 * 25年 理论和实际的数据分析
	 */
	@Override
	public List<Map<String, Object>> getElecAnalysisBy25Year(String pws_id, String tim_point) throws Exception {
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String, Object>>();
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("pws_id", pws_id);
		// 获取站点信息，使用ID
		List<Map<String, Object>> pwsInfLst = systemDao.getPwsInfLstByPwsId(map);
		
		tim_point = pwsInfLst.get(0).get("ope_tim").toString();
		// 年份加 n
		String nextYear = DateUtil.addYear(tim_point, 25);
		
		// 获取25年的数据
		List<Map<String, Object>> yearTim = DateUtil.getDayMonYearTimBettwenLst(tim_point, nextYear, "4");
		
		if (yearTim != null && !yearTim.isEmpty()) {
			
			for (Map<String, Object> yearMap : yearTim) {
				
				Map<String, Object> returnMap = new HashMap<String, Object>();
				
				yearMap.put("pws_id", pws_id);
				
				// 获取实际上网电量和收益  一年一条
				Map<String, Object> pracElecAnalysis = earnAnalysisDao.getPracElecAndEarnAnalysis(yearMap);
				
				if(pracElecAnalysis != null && !pracElecAnalysis.isEmpty()){
					
					returnMap.put("int_cha", pracElecAnalysis.get("int_cha"));
					
					returnMap.put("int_amo", pracElecAnalysis.get("int_amo"));
					
				}
				
				yearMap.put("type", 1);
				
				// 获取预测上网电量  一年一条
				Map<String, Object> fctElecAnalysis = earnAnalysisDao.getForeElecAndEarnAnalysis(yearMap);
				
				if(fctElecAnalysis != null && !fctElecAnalysis.isEmpty()){
					
					returnMap.put("fct_cha", fctElecAnalysis.get("sum_fct_value"));
					
				}
				yearMap.put("type", 2);
				
				// 获取预测上网收益  一年一条
				Map<String, Object> fctElecAnalysisAmo = earnAnalysisDao.getForeElecAndEarnAnalysis(yearMap);
				
				if(fctElecAnalysisAmo != null && !fctElecAnalysisAmo.isEmpty()){
					
					returnMap.put("fct_amo", fctElecAnalysisAmo.get("sum_fct_value"));
					
				}
				
				// 获取理论上网电量和收益  一年一条
				Map<String, Object> feaElecAnalysis = earnAnalysisDao.getFeaElecAnalysis(yearMap);
				
				if(feaElecAnalysis != null && !feaElecAnalysis.isEmpty()){
					
					returnMap.put("fsb_cha", feaElecAnalysis.get("fsb_power"));
					
					returnMap.put("fsb_amo", feaElecAnalysis.get("fsb_amo"));
					
				}
				
				returnMap.put("tol_tim", yearMap.get("staTim"));
				
				returnLst.add(returnMap);
			}
		}
		return returnLst;
	}
	
	
	/**
	 * 预测后两年年上网电量
	 */
	@Override
	public Map<String, Object> getForeElecAnalysis(String pws_id ,int type, String tim_point) throws Exception {
		
		Map<String, Object> mapResult = new HashMap<String, Object>();
	
		Map<String, Object> mapResult1 = new HashMap<String, Object>();
	
		Map<String, Object> mapResult2 = new HashMap<String, Object>();
		
		Map<String, Object> mapResult3 = new HashMap<String, Object>();
		
		//将 "yyyy" 格式初始化为"yyyy-MM-dd"
		String formatYear = DateUtil.formatYearToString(tim_point);
				
		// 获取任意一年的 startTim和endTim(获取某年、月、日起始和结束时间点集合(传入minDate与maxDate))
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimBettwenLst(DateUtil.addYear(formatYear, 1), DateUtil.addYear(formatYear, 1), "4");
		
		if (yearTimPoint != null && yearTimPoint.size() > 0) {
			
			String staTim = (String)yearTimPoint.get(0).get("staTim");
			
			String endTim = (String)yearTimPoint.get(0).get("endTim");
			// 查询参数构建
			Map<String, Object> mapParam = new HashMap<String, Object>();
			
			mapParam.put("pws_id", pws_id);
			
			mapParam.put("type", type);
			
			mapParam.put("val_sta", 1);
			
			mapParam.put("staTim", staTim);
			
			mapParam.put("endTim", endTim);
			// 根据类型 1预测上网电量 （根据电量） 4预测上网电量 （根据辐射量）
			mapResult1 = earnAnalysisDao.getForeElecAnalysis(mapParam);
			
			if(mapResult1 != null && !mapResult1.isEmpty()){
				
				mapResult1.put("year", "本年度预测上网电量");
			
			}else{
			
				mapResult1 = new HashMap<String, Object>();
			
				mapResult1.put("year", "本年度预测上网电量");
			}
			
			// 获取本年度的实际数据
			List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(formatYear, "3");
			
			Double sum_fct_value = null;
			
			if (monLst != null && !monLst.isEmpty()) {
				
				for (int i=0;i<monLst.size();i++) {
					
					monLst.get(i).put("pws_id", pws_id);
					
					// 获取实际上网电量和收益  一年一条
					Map<String, Object> pracElecAnalysis = earnAnalysisDao.getPracElecAndEarnAnalysis(monLst.get(i));
					
					if(pracElecAnalysis != null && !pracElecAnalysis.isEmpty()){
						
						mapResult2.put("fct_value"+(i+1), pracElecAnalysis.get("int_cha"));
						
						if(sum_fct_value == null){
							
							sum_fct_value=0.0;
						}
						
						if(pracElecAnalysis.get("int_cha") != null){
							
							sum_fct_value=sum_fct_value+Double.valueOf(pracElecAnalysis.get("int_cha").toString());
						}
					}
					if(sum_fct_value != null){
						
						mapResult2.put("sum_fct_value", sum_fct_value);
					}
				}
			}
		
			if(mapResult2 != null && !mapResult2.isEmpty()){
				
				mapResult2.put("year", "本年度实际上网电量");
			
			}else{
				
				mapResult2 = new HashMap<String, Object>();
			
				mapResult2.put("year", "本年度实际上网电量");
			}
			
			// 获取上一年度的实际数据
			List<Map<String, Object>> lastMonLst = DateUtil.getDayMonYearTimLst(DateUtil.redYear(formatYear), "3");
			
			Double sum_fct_value_lst = null;
			
			if (lastMonLst != null && !lastMonLst.isEmpty()) {
				
				for (int i=0;i<lastMonLst.size();i++) {
					
					lastMonLst.get(i).put("pws_id", pws_id);
					
					// 获取实际上网电量和收益  一年一条
					Map<String, Object> pracElecAnalysis = earnAnalysisDao.getPracElecAndEarnAnalysis(lastMonLst.get(i));
					
					if(pracElecAnalysis != null && !pracElecAnalysis.isEmpty()){
						
						mapResult3.put("fct_value"+(i+1), pracElecAnalysis.get("int_cha"));
						
						if(sum_fct_value_lst == null){
							
							sum_fct_value_lst=0.0;
						}
						
						if(pracElecAnalysis.get("int_cha") != null){
							
							sum_fct_value_lst=sum_fct_value_lst+Double.valueOf(pracElecAnalysis.get("int_cha").toString());
						}
					}
					if(sum_fct_value_lst != null){
						
						mapResult3.put("sum_fct_value", sum_fct_value_lst);
					}
				}
			}
			
			if(mapResult3 != null && !mapResult2.isEmpty()){
				
				mapResult3.put("year", "上年度实际上网电量");
				
			}else{
				
				mapResult3 = new HashMap<String, Object>();
				
				mapResult3.put("year", "上年度实际上网电量");
			}
		}
		
		mapResult.put("firstYear", mapResult1);
		
		mapResult.put("sceondYear", mapResult2);
		
		mapResult.put("thredYear", mapResult3);
		
		return mapResult;
	}	
		

	
	/**
	 * 近两年计划上网电量(App)
	 */
	@Override
	public Map<String, Object> getPlanElecAnalysisApp(String pws_id, String tim_point) throws Exception {
		
		Map<String, Object> mapResult = new LinkedHashMap<String, Object>();
		
		Map<String, Object> mapResult1 = new LinkedHashMap<String, Object>();
		
		Map<String, Object> mapResult2 = new LinkedHashMap<String, Object>();
		
		Map<String, Object> mapResult3 = new LinkedHashMap<String, Object>();
		
		//将 "yyyy" 格式初始化为"yyyy-MM-dd"
		String formatYear = DateUtil.formatYearToString(tim_point);
		
		//	param:2018-1-1		==>		[{staTim=2017-1-1, endTim=2018-1-1}](获取某年、月、日起始和结束时间点集合(传入minDate与maxDate))
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimBettwenLst(DateUtil.addYear(formatYear, 1), DateUtil.addYear(formatYear, 1), "4");
		
		if (yearTimPoint != null && yearTimPoint.size() > 0) {

			// 获取本年度的实际数据
			List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(formatYear, "3");
			
			Double sum_plan_value = null;
			
			if (monLst != null && !monLst.isEmpty()) {
				
				for (int i=0;i<monLst.size();i++) {
					
					monLst.get(i).put("pws_id", pws_id);
					
					// 获取实际上网电量和收益  一年一条
					Map<String, Object> pracElecAnalysis = earnAnalysisDao.getPlanElecAnalysis(monLst.get(i));
					
					if(pracElecAnalysis != null && !pracElecAnalysis.isEmpty()){
						
						mapResult1.put("plan_value"+(i+1), pracElecAnalysis.get("plan_power"));
						
						if(sum_plan_value == null){
							
							sum_plan_value=0.0;
						}
						// 非常判断
						if(pracElecAnalysis.get("plan_power") != null){
							
							sum_plan_value=sum_plan_value+Double.valueOf(pracElecAnalysis.get("plan_power").toString());
						}
					}
					mapResult1.put("sum_plan_value", sum_plan_value);
				}
			}
		
			if(mapResult1 != null && !mapResult1.isEmpty()){
				
				mapResult1.put("year", "本年度计划上网电量");
			
			}else{
				
				mapResult1 = new HashMap<String, Object>();
			
				mapResult1.put("year", "本年度计划上网电量");
			}
			
			Double sum_fct_value = null;
			// 月份集合非空判断
			if (monLst != null && !monLst.isEmpty()) {
				
				for (int i=0;i<monLst.size();i++) {
					
					monLst.get(i).put("pws_id", pws_id);
					
					// 获取实际上网电量和收益  一年一条
					Map<String, Object> pracElecAnalysis = earnAnalysisDao.getPracElecAndEarnAnalysis(monLst.get(i));
					
					if(pracElecAnalysis != null && !pracElecAnalysis.isEmpty()){
						
						mapResult2.put("fct_value"+(i+1), pracElecAnalysis.get("int_cha"));
						
						if(sum_fct_value == null){
							
							sum_fct_value=0.0;
						}
						
						if(pracElecAnalysis.get("int_cha") != null){
							
							sum_fct_value=sum_fct_value+Double.valueOf(pracElecAnalysis.get("int_cha").toString());
						}
					}
					
					mapResult2.put("sum_fct_value", sum_fct_value);
				}
			}
		
			if(mapResult2 != null && !mapResult2.isEmpty()){
				
				mapResult2.put("year", "本年度实际上网电量");
			
			}else{
				
				mapResult2 = new HashMap<String, Object>();
			
				mapResult2.put("year", "本年度实际上网电量");
			}
			
			
			// 获取上一年度的实际数据
			List<Map<String, Object>> lastMonLst = DateUtil.getDayMonYearTimLst(DateUtil.redYear(formatYear), "3");
			
			Double sum_fct_value_lst = null;
			
			if (lastMonLst != null && !lastMonLst.isEmpty()) {
				
				for (int i=0;i<lastMonLst.size();i++) {
					
					lastMonLst.get(i).put("pws_id", pws_id);
					
					// 获取实际上网电量和收益  一年一条
					Map<String, Object> pracElecAnalysis = earnAnalysisDao.getPracElecAndEarnAnalysis(lastMonLst.get(i));
					
					if(pracElecAnalysis != null && !pracElecAnalysis.isEmpty()){
						
						mapResult3.put("fct_value"+(i+1), pracElecAnalysis.get("int_cha"));
						
						if(sum_fct_value_lst == null){
							
							sum_fct_value_lst=0.0;
						}
						
						if(pracElecAnalysis.get("int_cha") != null){
							
							sum_fct_value_lst=sum_fct_value_lst+Double.valueOf(pracElecAnalysis.get("int_cha").toString());
						}
					}
					
					mapResult3.put("sum_fct_value", sum_fct_value_lst);
				}
			}
			
			if(mapResult3 != null && !mapResult2.isEmpty()){
				
				mapResult3.put("year", "上年度实际上网电量");
				
			}else{
				
				mapResult3 = new HashMap<String, Object>();
				
				mapResult3.put("year", "上年度实际上网电量");
			}
		}
		
		mapResult.put("firstYear", mapResult1);
		
		mapResult.put("sceondYear", mapResult2);
		
		mapResult.put("thredYear", mapResult3);
		
		return mapResult;
	}
	
	/**
	 * 近两年计划上网电量
	 */
	@Override
	public Map<String, Object> getPlanElecAnalysis(String pws_id, String tim_point) throws Exception {
		
		Map<String, Object> mapResult = new LinkedHashMap<String, Object>();
		
		Map<String, Object> mapResult1 = new LinkedHashMap<String, Object>();
		
		Map<String, Object> mapResult2 = new LinkedHashMap<String, Object>();
		
		Map<String, Object> mapResult3 = new LinkedHashMap<String, Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		//将 "yyyy" 格式初始化为"yyyy-MM-dd"
		String formatYear = DateUtil.formatYearToString(tim_point);
		
		//	param:2018-1-1		==>		[{staTim=2017-1-1, endTim=2018-1-1}](获取某年、月、日起始和结束时间点集合(传入minDate与maxDate))
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimBettwenLst(DateUtil.addYear(formatYear, 1), DateUtil.addYear(formatYear, 1), "4");
		
		if (yearTimPoint != null && yearTimPoint.size() > 0) {
			
			String staTim = (String)yearTimPoint.get(0).get("staTim");
			
			String endTim = (String)yearTimPoint.get(0).get("endTim");
			
			// 获取 一年中每个月的 startTim和endTim 集合
			List<Map<String, Object>> monthTimList = DateUtil.getDayMonYearTimBettwenLst(staTim,endTim, "3");
			
			Double sum_plan_power1 = null;
			
			for (int i = 0; i < monthTimList.size(); i++) {
				
				Map<String, Object> mapParam = new HashMap<String, Object>();
				
				mapParam.put("pws_id", pws_id);
				
				mapParam.put("staTim", monthTimList.get(i).get("staTim"));
				
				mapParam.put("endTim", monthTimList.get(i).get("endTim"));
				// 获取计划上网电量 一月一条 
				Map<String, Object> planMap = earnAnalysisDao.getPlanElecAnalysis(mapParam);
				
				if(planMap != null && !planMap.isEmpty()){
					// 获取计划发电时间
					String month = DateUtil.getMonth((Date)planMap.get("plan_tim")) + "";
					
					Double plan_power = null;
					// 计划发电量计算
					if(planMap.get("plan_power") != null){
						
						plan_power = Double.valueOf(planMap.get("plan_power").toString());
					}
					
					if(sum_plan_power1 == null){
						
						sum_plan_power1=0.0;
						
					}
					// 总计划发电量计算
					if(planMap.get("plan_power") != null){
						
						sum_plan_power1=sum_plan_power1+Double.valueOf(planMap.get("plan_power").toString());
					}
					
					mapResult1.put(month, plan_power);
					
				}
			}
			
			if(sum_plan_power1 != null){
				
				mapResult1.put("sum", sum_plan_power1);
				
			}
			
			mapResult1.put("year", "本年度计划上网电量");
			
			// 获取本年度的实际数据
			List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(formatYear, "3");
			
			Double sum_int_cha = null;
			
			if (monLst != null && !monLst.isEmpty()) {
				
				for (int i=0;i<monLst.size();i++) {
					
					monLst.get(i).put("pws_id", pws_id);
					
					// 获取实际上网电量和收益  一年一条
					Map<String, Object> pracElecAnalysis = earnAnalysisDao.getPracElecAndEarnAnalysis(monLst.get(i));
					
					if(pracElecAnalysis != null && !pracElecAnalysis.isEmpty()){
						
						String month = DateUtil.getMonth(sdf.parse(monLst.get(i).get("staTim").toString())) + "";
						
						Double int_cha = null;
						
						if(pracElecAnalysis.get("int_cha") != null){
							
							int_cha = Double.valueOf(pracElecAnalysis.get("int_cha").toString());
						}
						
						mapResult2.put(month, int_cha);
						
						if(sum_int_cha == null){
							
							sum_int_cha=0.0;
						}
						
						if(pracElecAnalysis.get("int_cha") != null){
							
							sum_int_cha=sum_int_cha+Double.valueOf(pracElecAnalysis.get("int_cha").toString());
						}
					}
					if(sum_int_cha != null){
						
						
					}
					mapResult2.put("sum", sum_int_cha);
				}
			}
			
			if(mapResult2 != null && !mapResult2.isEmpty()){
				
				mapResult2.put("year", "本年度实际上网电量");
				
			}else{
				
				mapResult2 = new HashMap<String, Object>();
				
				mapResult2.put("year", "本年度实际上网电量");
			}
			
			// 获取上一年度的实际数据
			List<Map<String, Object>> lastMonLst = DateUtil.getDayMonYearTimLst(DateUtil.redYear(formatYear), "3");
			
			Double sum_int_cha_lst = null;
			
			if (lastMonLst != null && !lastMonLst.isEmpty()) {
				
				for (int i=0;i<lastMonLst.size();i++) {
					
					lastMonLst.get(i).put("pws_id", pws_id);
					
					// 获取实际上网电量和收益  一年一条
					Map<String, Object> pracElecAnalysis = earnAnalysisDao.getPracElecAndEarnAnalysis(lastMonLst.get(i));
					
					if(pracElecAnalysis != null && !pracElecAnalysis.isEmpty()){
						
						String month = DateUtil.getMonth(sdf.parse(monLst.get(i).get("staTim").toString())) + "";
						
						Double int_cha = null;
						
						if(pracElecAnalysis.get("int_cha") != null){
							
							int_cha = Double.valueOf(pracElecAnalysis.get("int_cha").toString());
						}
						
						mapResult3.put(month, int_cha);
						
						if(sum_int_cha_lst == null){
							
							sum_int_cha_lst=0.0;
						}
						
						if(pracElecAnalysis.get("int_cha") != null){
							
							sum_int_cha_lst=sum_int_cha_lst+Double.valueOf(pracElecAnalysis.get("int_cha").toString());
						}
					}
					if(sum_int_cha_lst != null){
						
						mapResult3.put("sum", sum_int_cha_lst);
					}
				}
			}
			
			if(mapResult3 != null && !mapResult3.isEmpty()){
				
				mapResult3.put("year", "上年度实际上网电量");
				
			}else{
				
				mapResult3 = new HashMap<String, Object>();
				
				mapResult3.put("year", "上年度实际上网电量");
			}
			
		}
		
		mapResult.put("firstYear", mapResult1);
		
		mapResult.put("sceondYear", mapResult2);
		
		mapResult.put("thredYear", mapResult3);
		
		return mapResult;
	}
	
}
