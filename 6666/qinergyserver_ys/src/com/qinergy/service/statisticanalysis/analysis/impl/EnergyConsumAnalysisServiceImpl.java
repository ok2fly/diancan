package com.qinergy.service.statisticanalysis.analysis.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.statisticanalysis.analysis.EnergyConsumAnalysisDao;
import com.qinergy.service.statisticanalysis.analysis.EnergyConsumAnalysisService;
import com.qinergy.util.DateUtil;

@Service("energyConsumAnalysisService")
public class EnergyConsumAnalysisServiceImpl implements EnergyConsumAnalysisService {

	@Autowired
	EnergyConsumAnalysisDao consumAnalysisDao;

	
	/**
	 * 用电量、率统计 按月 
	 */
	@Override
	public Map<String, Object> getElecStatistics(String pws_id, String tim_point) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 初始化tim_point ：get当月第一天	
		String staTim = DateUtil.formatYearMonToString(tim_point);
		// 月份加1
		String endTim = DateUtil.addMonth(staTim); // 月份加一

		Map<String, Object> mapParam = new HashMap<String, Object>();
		
		mapParam.put("pws_id", pws_id);
		
		mapParam.put("val_sta", 1);
		
		mapParam.put("staTim", staTim);
		
		mapParam.put("endTim", endTim);
		
		//当月数据(用电量、率统计 按月 )
		Map<String, Object> elecStatistics = consumAnalysisDao.getElecStatistics(mapParam);
		
		//获取年初时间点
		mapParam.put("staTim", tim_point);
		
		mapParam.put("endTim", DateUtil.addMonth(tim_point));
		
		//当年电量统计
		Map<String, Object> totalElecStatistics = consumAnalysisDao.getTotalElecStatistics(mapParam);
		
		if(elecStatistics != null && !elecStatistics.isEmpty()){
			
			resultMap.putAll(elecStatistics);
			
		}
		
		if(totalElecStatistics != null && !totalElecStatistics.isEmpty()){
			
			resultMap.putAll(totalElecStatistics);
		}
		
		return resultMap;
	}
	
	
	/**
	 * 综合电量分析 按年 
	 */
	@Override
	public List<Map<String, Object>> getSynthElecAnalysis(String pws_id, String tim_point)
			throws Exception {
		
		List<Map<String, Object>> lstResult = new ArrayList<Map<String,Object>>();

		// 获取任意一年的 startTim和endTim(获取某年、月、日起始和结束时间点集合)
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimLst(tim_point, "3");
		
		if (yearTimPoint != null && yearTimPoint.size() > 0) {
			
			for(Map<String, Object> yearTimPointMap:yearTimPoint){
				
				Map<String, Object> mapParam = new HashMap<String, Object>();
				
				mapParam.put("pws_id", pws_id);
				
				mapParam.put("val_sta", 1);
				
				mapParam.put("staTim", (String) yearTimPointMap.get("staTim"));
				
				mapParam.put("endTim", (String) yearTimPointMap.get("endTim"));
				// 用电量、率统计 按月 
				Map<String, Object> mapResult = consumAnalysisDao.getElecStatistics(mapParam);
				
				if(mapResult == null || mapResult.isEmpty()){
					
					mapResult = new HashMap<String, Object>();
				}
				// 时间格式化
				SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
				
				mapResult.put("tol_tim", sdf.parse(yearTimPointMap.get("staTim").toString()).getTime());
				
				lstResult.add(mapResult);
			}
		}	
			
		return lstResult;
	}

	
		
	/**
	 * 3. 取最近两年厂用电量分析
	 */  
	@Override
	public Map<String, Object> getElecAnalysis(String pws_id, String tim_point) throws Exception {
		
		Map<String, Object> mapResult = new LinkedHashMap<String, Object>();
		
		// 获取任意一年的 startTim和endTim	eq:'2017-10-1' ==> [2016-1-1, 2017-1-1]
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimBettwenLst(tim_point, tim_point, "4");
		
		Map<String, Object> mapParam = new HashMap<String, Object>();
		
		mapParam.put("pws_id", pws_id);
		
		mapParam.put("val_sta", 1);
		
		if (yearTimPoint != null && yearTimPoint.size() > 0) {
			
			String staTim = (String)yearTimPoint.get(0).get("staTim");
			
			String endTim = (String)yearTimPoint.get(0).get("endTim");
			// 获取一年的厂用电量(上一年)
			Map<String, Object> mapElec1 = getElecAnalysisByYear(staTim, endTim, mapParam);
			// 获取一年的厂用电量(本年度)
			Map<String, Object> mapElec2 = getElecAnalysisByYear(endTim, DateUtil.addYear(endTim, 1), mapParam);
			// 获取一年的厂用电量(App)(上一年)
			List<Map<String, Object>> elecAppLstLastYear = getElecAnalysisByYearAp(staTim, endTim, mapParam);
			// 获取一年的厂用电量(App)(本年度)
			List<Map<String, Object>> elecAppLstNowYear = getElecAnalysisByYearAp(endTim, DateUtil.addYear(endTim, 1), mapParam);
		
			mapResult.put("mapElec1", mapElec1);
			
			mapResult.put("mapElec2", mapElec2);
			
			mapResult.put("elecAppLstLastYear", elecAppLstLastYear);
			
			mapResult.put("elecAppLstNowYear", elecAppLstNowYear);
		}
		return mapResult;
	}
	
	
	
	/**	
	 * 获取一年的厂用电量
	 */
	private Map<String, Object> getElecAnalysisByYear(String staTim, String endTim, Map<String, Object> mapParam) throws ParseException,Exception{
		
		Map<String, Object> mapElec = new LinkedHashMap<String, Object>();
		// 获取 一年中每个月的 startTim和endTim 集合(获取某年、月、日起始和结束时间点集合(传入minDate与maxDate))
		List<Map<String, Object>> monthTimList = DateUtil.getDayMonYearTimBettwenLst(staTim, endTim, "3");
		
		if(monthTimList != null && monthTimList.size() > 0){
			
			double sum = 0.0;
			
			for (Map<String, Object> monthTim : monthTimList) {
				
				mapParam.put("staTim", monthTim.get("staTim"));
				
				mapParam.put("endTim", monthTim.get("endTim"));
				// 获取一条 月 数据(厂用电量分析 (按月累计，取最后一条))
				Map<String, Object> elecStatistics = consumAnalysisDao.getElecAnalysis(mapParam);
				
				if(elecStatistics != null && !elecStatistics.isEmpty()){
					
					double plt_pow_con = (Double)elecStatistics.get("plt_pow_con");// 当月累计值
					//key:月份 value:厂用电量值
					mapElec.put(DateUtil.getMonth((Date)elecStatistics.get("tol_tim")) + "", plt_pow_con); 
					
					sum += plt_pow_con;
				}
			}
			mapElec.put("sum",sum);
			// 年份加1
			mapElec.put("year", DateUtil.getYear(staTim));
		}
		
		return mapElec;
	}
	
	/**	
	 * 获取一年的厂用电量
	 */
	private List<Map<String, Object>> getElecAnalysisByYearAp(String staTim, String endTim, Map<String, Object> mapParam) throws ParseException,Exception{
		
		List<Map<String,Object>> retLst = new ArrayList<Map<String,Object>>();
		
		// 获取 一年中每个月的 startTim和endTim 集合(获取某年、月、日起始和结束时间点集合(传入minDate与maxDate))
		List<Map<String, Object>> monthTimList = DateUtil.getDayMonYearTimBettwenLst(staTim, endTim, "3");
		
		if(monthTimList != null && monthTimList.size() > 0){
			
			for (Map<String, Object> monthTim : monthTimList) {
				
				Map<String, Object> mapElec = new LinkedHashMap<String, Object>();
				
				mapParam.put("staTim", monthTim.get("staTim"));
				
				mapParam.put("endTim", monthTim.get("endTim"));
				// 获取一条 月 数据(厂用电量分析 (按月累计，取最后一条))
				Map<String, Object> elecStatistics = consumAnalysisDao.getElecAnalysis(mapParam);
				
				if(elecStatistics != null && !elecStatistics.isEmpty()){
					
					mapElec.put("plt_pow_con", elecStatistics.get("plt_pow_con"));
					
				}
				// 将时间转换为时间戳
				mapElec.put("date", DateUtil.dateToStamp(monthTim.get("staTim").toString()+" 00:00:00"));
				
				retLst.add(mapElec);
			}
		}
		
		return retLst;
	}
	
	/**
	 * 3. 取最近两年厂用电量分析 App端
	 */
	@Override   
	public Map<String, Object> getElecAnalysisApp(String pws_id, String tim_point) throws Exception {
		
		Map<String, Object> mapResult = new LinkedHashMap<String, Object>();
		
		// 获取任意一年的 startTim和endTim	eq:'2017-10-1' ==> [2016-1-1, 2017-1-1]
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimBettwenLst(tim_point, tim_point, "4");
	
		if (yearTimPoint != null && yearTimPoint.size() > 0) {
			
			String staTim = (String)yearTimPoint.get(0).get("staTim");
			
			String endTim = (String)yearTimPoint.get(0).get("endTim");
			
			Map<String, Object> mapParam = new HashMap<String, Object>();
			
			mapParam.put("pws_id", pws_id);
			
			mapParam.put("val_sta", 1);
			 
			//	获取去年的数据	(获取一年的厂用电量)
			Map<String, Object> firYearMap = getElecAnalysisByYearApp(staTim, endTim, mapParam);
			//	获取今年的数据	(获取一年的厂用电量)
			Map<String, Object> secYearMap = getElecAnalysisByYearApp(endTim, DateUtil.addYear(endTim, 1), mapParam);
			
			mapResult.put("firYearPower", firYearMap);
			
			mapResult.put("secYearPower", secYearMap);
		}
		
		return mapResult;
	}
	
	/**	
	 * 获取一年的厂用电量
	 */
	private Map<String, Object> getElecAnalysisByYearApp(String staTim, String endTim, Map<String, Object> mapParam) throws ParseException,Exception{
		// 获取某年、月、日起始和结束时间点集合(传入minDate与maxDate)
		List<Map<String, Object>> monthTimList = DateUtil.getDayMonYearTimBettwenLst(staTim, endTim, "3");
		
		Map<String, Object> mapRes = new LinkedHashMap<String, Object>();//存放一年的值
		
		if(monthTimList != null && monthTimList.size() > 0){
			
			double sum = 0.0;
			
			Map<String, Object> mapElec = null; 
			
			List<Map<String,Object>> powList = new ArrayList<Map<String,Object>>();	
			
			for (int i = 0; i < monthTimList.size(); i++) {
				
				mapParam.put("staTim", monthTimList.get(i).get("staTim"));
				
				mapParam.put("endTim", monthTimList.get(i).get("endTim"));
				
				// 获取一条 月 数据
				Map<String, Object> elecStatistics = consumAnalysisDao.getElecAnalysis(mapParam);
				
				double plt_pow_con = 0.0;
				
				mapElec = new LinkedHashMap<String, Object>();//存放每个月的值
				
				if(elecStatistics != null && !elecStatistics.isEmpty()){
					
					plt_pow_con = (Double)elecStatistics.get("plt_pow_con");// 当月累计值
					
					mapElec.put("monthPow", plt_pow_con);
					
				} else{
					
					mapElec.put("monthPow", 0.0);
				}
				
				powList.add(mapElec);
				
				sum += plt_pow_con;
			}
			
			mapRes.put("pow", powList);
			
			mapRes.put("sum", sum);
			// 年份加1
			mapRes.put("year", DateUtil.getYear(staTim));
		}
		
		return mapRes;
	}
}
