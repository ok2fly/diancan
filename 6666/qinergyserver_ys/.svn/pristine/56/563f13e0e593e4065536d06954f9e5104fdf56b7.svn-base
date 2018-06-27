package com.qinergy.service.integratmonitor.pvs;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.pvs.PvsDao;
import com.qinergy.dao.others.OthersDao;
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
public class PvsServiceImpl implements PvsService{
	
	
	@Autowired
	PvsDao pvsDao;
	
	@Autowired
	OthersDao othersDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsInfByEquNumTopOne(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> retLst = pvsDao.getIscsPvsInfByEquNumTopOne(map);
		
		if(retLst != null && !retLst.isEmpty()){
			
			for(Map<String, Object> retMap:retLst){
				
				// 获取到站内的设备信息,传入健康信息获取接口中
				List<Map<String, Object>> healthLst = othersDao.getEquHealthScorTop(map);
				
				// 获取健康评分,并进行判断
				if(healthLst != null && !healthLst.isEmpty()){
					
					for(Map<String, Object> healthMap : healthLst){
						
						Double equHealthRate = Double.valueOf(healthMap.get("health_scor").toString());
						
						if(equHealthRate >= 90){
							
							retMap.put("healthStat", 1);
							
						}else if(equHealthRate >= 80 && equHealthRate < 90){
							
							retMap.put("healthStat", 2);
							
						}else if(equHealthRate >= 70 && equHealthRate < 80){
							
							retMap.put("healthStat", 3);
							
						}else if(equHealthRate < 70){
							
							retMap.put("healthStat", 4);
							
						}
					}
				}
			}
		}
		
		return retLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurves(Map<String,Object> map) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = pvsDao.getIscsPvsAcDcPIVDisRateCurves(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsDayPowerHistogram(Map<String, Object> map) throws Exception {
		
		Date crtTim = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		List<Map<String, Object>> hoursLst = DateUtil.getDayMonYearTimLst(sdf.format(crtTim), "4");
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		Double firstPowerDay = 0.0;
		
		if(hoursLst != null && !hoursLst.isEmpty()){
			
			for(Map<String, Object> hoursMap:hoursLst){
				
				Map<String,Object> retMap = new HashMap<String,Object>();
				
				map.put("sta_tim", hoursMap.get("sta_tim"));
				
				map.put("end_tim", hoursMap.get("end_tim"));
				
				String tol_tim = DateUtil.stampToDate(hoursMap.get("tol_tim").toString());
				
				if(tol_tim.split(" ")[1].equals("00:00:00")){
					
					List<Map<String, Object>> firstLst = pvsDao.getIscsPvsDayPowerHistogramFirst(map);
					
					if(firstLst != null && !firstLst.isEmpty() && firstLst.get(0) != null){
						
						for(Map<String, Object> firstMap:firstLst){
							
							firstPowerDay = Double.valueOf(firstMap.get("powerDay").toString());
						}
					}
				}
				
				List<Map<String, Object>> curLst = pvsDao.getIscsPvsDayPowerHistogram(map);
				
				if(curLst != null && !curLst.isEmpty() && curLst.get(0) != null){
					
					for(Map<String, Object> curMap:curLst){
						
						Double powerDay = Double.valueOf(curMap.get("powerDay").toString())-firstPowerDay;
						
						if(powerDay <0){
							
							powerDay = 0.0;
							
						}
						retMap.put("powerDay", powerDay);
						
						firstPowerDay = Double.valueOf(curMap.get("powerDay").toString());
					}
				}
				retMap.put("tol_tim", hoursMap.get("tol_tim"));
				
				retLst.add(retMap);
			}
		}
		return retLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistory(Map<String, Object> map) throws Exception {
		
		String crtTim = "";
		
		if(map != null && map.get("date") != null){
			
			crtTim = map.get("date").toString();
			
		}else{

			SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
			
			crtTim = sdf.format(crtTim);
		}
		
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = pvsDao.getIscsPvsAcDcPIVDisRateCurvesHistory(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsDayPowerHistogramHistory(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "2");
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		for(Map<String, Object> dayMonYearTimMap : dayMonYearTimLst){
			
			Map<String,Object> returnMap = new HashMap<String, Object>();
			
			map.put("sta_tim", dayMonYearTimMap.get("staTim"));
			
			map.put("end_tim", dayMonYearTimMap.get("endTim"));
			
			List<Map<String, Object>> iscsPvsDayPowerHistogramLst = pvsDao.getIscsPvsDayPowerHistogramHistory(map);
			
			if(iscsPvsDayPowerHistogramLst != null && !iscsPvsDayPowerHistogramLst.isEmpty()){
				
				for(Map<String, Object>  iscsPvsDayPowerHistogramMap : iscsPvsDayPowerHistogramLst){
					
					returnMap.putAll(iscsPvsDayPowerHistogramMap);
					
					returnMap.put("tol_tim", dayMonYearTimMap.get("staTim"));
				}
				
			}else{
				
				returnMap.put("powerDay", 0);
				
				returnMap.put("tol_tim", dayMonYearTimMap.get("staTim"));
			}
			
			returnLst.add(returnMap);
		}
		
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPvsInfLst(Map<String, Object> map) throws Exception {
		
		// 建立最终结果返回集合

		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = pvsDao.getEquLstByPwsEquTyp(map);
		
		// 通讯中断状态计数器
		Integer commStatCount = 0;
		
		// 正常运行状态计数器
		Integer norStatCount = 0;
		
		// 正常停机状态计数器
		Integer downStatCount = 0;
		
		// 告警运行状态计数器
		Integer alaStatCount = 0;
		
		// 故障停机状态计数器
		Integer fauStatCount = 0;
		
		// 限电运行状态计数器
		Integer ratPowerStatCount = 0;
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> pvsRelTimLst = pvsDao.getPvsInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(pvsRelTimLst != null && !pvsRelTimLst.isEmpty()){
					
					for(Map<String, Object>  pvsRelTimMap : pvsRelTimLst){
						// 判断PCS实时状态
						if("0".equals(pvsRelTimMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(pvsRelTimMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}else if("2".equals(pvsRelTimMap.get("stat").toString())){
							
							downStatCount = downStatCount +1;
							
							equMap.put("stat", 2);
							
						}else if("3".equals(pvsRelTimMap.get("stat").toString())){
							
							alaStatCount = alaStatCount +1;
							
							equMap.put("stat", 3);
							
						}else if("4".equals(pvsRelTimMap.get("stat").toString())){
							
							fauStatCount = fauStatCount +1;
							
							equMap.put("stat", 4);
							
						}else if("5".equals(pvsRelTimMap.get("stat").toString())){
							
							ratPowerStatCount = ratPowerStatCount +1;
							
							equMap.put("stat", 5);
						}
						equMap.putAll(pvsRelTimMap);
					}
				}else{
					
					commStatCount = commStatCount+1;
					
					equMap.put("stat", 0);
				}
			}
		}
		
		Map<String,Object> statMap = new HashMap<String,Object>();
		
		statMap.put("commStatCount", commStatCount);
		
		statMap.put("norStatCount", norStatCount);
		
		statMap.put("downStatCount", downStatCount);
		
		statMap.put("alaStatCount", alaStatCount);
		
		statMap.put("fauStatCount", fauStatCount);
		
		statMap.put("ratPowerStatCount", ratPowerStatCount);
		
		if(map.get("stat") != null && !map.get("stat").toString().isEmpty()){
			
			List<Map<String,Object>> retEquLst = new ArrayList<Map<String,Object>>();
			
			if(equLst != null && !equLst.isEmpty()){
				
				for(Map<String, Object> equMap : equLst){
					
					Map<String,Object> retMap = new HashMap<String, Object>();
					
					if(equMap.get("stat").toString().equals(map.get("stat").toString())){
						
						retMap.putAll(equMap);
						
						retEquLst.add(retMap);
					}
				}
			}
			statMap.put("pvsEquLst", retEquLst);
		}else{
			
			statMap.put("pvsEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}

	
	
	
	/**
	 * 状态查询
	 *
	 */
	@Override
	public List<Map<String, Object>> getPvsInfStat(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = pvsDao.getEquLstByPwsEquTyp(map);
		
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> pvsRelTimLst = pvsDao.getPvsInfByEquNum(map);
				
				if(pvsRelTimLst != null && !pvsRelTimLst.isEmpty()){
					
					for(Map<String, Object> stat : pvsRelTimLst ){
					
						map.put("stat", stat.get("stat"));
						
						List<Map<String, Object>> pcsLst = pvsDao.getPvsInfByEquNum(map);
						
						resultLst.addAll(pcsLst);
					}
				}
			}
		}
		return resultLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistoryLst(Map<String, Object> map) throws Exception {
		
		String crtTim = "";
		
		if(map != null && map.get("date") != null){
			
			crtTim = map.get("date").toString();
			
		}else{

			SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
			
			crtTim = sdf.format(crtTim);
		}
		
		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", dayMonYearTimLst.get(0).get("sta_tim"));
		
		map.put("end_tim", dayMonYearTimLst.get(0).get("end_tim"));
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = pvsDao.getIscsPvsAcDcPIVDisRateCurvesHistoryLst(map);
		
		return resultLst;
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getIscsPvsAcDcPIVDisRateCurvesHistoryLstCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "5");
		
		map.put("sta_tim", dayMonYearTimLst.get(0).get("sta_tim"));
		
		map.put("end_tim", dayMonYearTimLst.get(0).get("end_tim"));
		
		List<Map<String, Object>> couLst = pvsDao.getIscsPvsAcDcPIVDisRateCurvesHistoryLstCou(map);

		if (couLst != null && couLst.size() > 0) {

			for (Map<String, Object> couMap : couLst) {

				return couMap;
			}
		}
		return null;
	}
}
