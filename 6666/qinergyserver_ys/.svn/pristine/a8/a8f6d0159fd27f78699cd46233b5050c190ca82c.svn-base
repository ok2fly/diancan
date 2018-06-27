package com.qinergy.service.integratmonitor.meter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.meter.MeterDao;
import com.qinergy.dao.others.OthersDao;
import com.qinergy.service.integratmonitor.meter.MeterService;
import com.qinergy.util.DateUtil;

/**
 * @desc:  电表接口 实现类 ：实时数据、  历史数据
 * @author: Qist
 * @date: 2017年10月27日
 */
@Service("meterService")
public class MeterServiceImpl implements MeterService {

	@Autowired
	private MeterDao meterDao;
	
	@Autowired
	private OthersDao othersDao;

	
	@Override
	public Map<String, Object> getMeterRealByEquNum(Map<String, Object> map) throws Exception {
		
		Map<String, Object> retMap = meterDao.getMeterRealByEquNum(map);
		
		if(retMap != null && !retMap.isEmpty()){
				
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
		
		return retMap;
	}
	
	@Override
	public Map<String, Object> getMeterRealsByEquNum(Map<String, Object> map)
			throws Exception {
		return meterDao.getMeterRealsByEquNum(map);
	}

	@Override
	public List<Map<String, Object>> getMeterRealList(Map<String, Object> map)
			throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = meterDao.getMeterRealList(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}
	
	@Override
	public List<Map<String, Object>> getMeterRealListMonth(Map<String, Object> map) throws Exception {
		
		Date crtTim = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(sdf.format(crtTim), "2");
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		if(monLst != null && !monLst.isEmpty()){
			
			for(Map<String, Object> monMap:monLst){
				
				Map<String,Object> retMap = new HashMap<String,Object>();
				
				map.put("sta_tim", monMap.get("staTim"));
				
				map.put("end_tim", monMap.get("endTim"));
				
				List<Map<String, Object>> curLst = meterDao.getMeterRealListMonth(map);
				
				if(curLst != null && !curLst.isEmpty() && curLst.get(0) != null){
					
					for(Map<String, Object> curMap:curLst){
						
						retMap.put("phi", curMap.get("phi_power"));
						
						retMap.put("qhi", curMap.get("qhi_power"));
						
						retMap.put("phe", curMap.get("phe_power"));
						
						retMap.put("qhe", curMap.get("qhe_power"));
						
					}
				}
				retMap.put("tol_tim", DateUtil.dateToStamp(monMap.get("staTim").toString()+" 00:00:00"));
				
				retLst.add(retMap);
			}
		}
		return retLst;
	}
	
	@Override
	public List<Map<String, Object>> getMeterHistoryMonthGraph(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "2");
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		if(monLst != null && !monLst.isEmpty()){
			
			for(Map<String, Object> monMap:monLst){
				
				Map<String,Object> retMap = new HashMap<String,Object>();
				
				map.put("sta_tim", monMap.get("staTim"));
				
				map.put("end_tim", monMap.get("endTim"));
				
				List<Map<String, Object>> curLst = meterDao.getMeterRealListMonth(map);
				
				if(curLst != null && !curLst.isEmpty() && curLst.get(0) != null){
					
					for(Map<String, Object> curMap:curLst){
						
						retMap.put("phi", curMap.get("phi_power"));
						
						retMap.put("qhi", curMap.get("qhi_power"));
						
						retMap.put("phe", curMap.get("phe_power"));
						
						retMap.put("qhe", curMap.get("qhe_power"));
						
					}
				}
				retMap.put("tol_tim", DateUtil.dateToStamp(monMap.get("staTim").toString()+" 00:00:00"));
				
				retLst.add(retMap);
			}
		}
		return retLst;
	}

	@Override
	public List<Map<String, Object>> getMeterHistoryList(Map<String, Object> map) throws Exception {
		
		return meterDao.getMeterHistoryList(map);
	}
	
	@Override
	public List<Map<String, Object>> getMeterHistoryGraph(Map<String, Object> map) throws Exception {
		
		String crtTim = map.get("date").toString();
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = meterDao.getMeterRealList(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}

	@Override
	public Integer getMeterHistoryCount(Map<String, Object> map)
			throws Exception {
		
		Integer cou = 0;
		
		Map<String, Object> mhcMap = meterDao.getMeterHistoryCount(map);
		
		if(mhcMap != null && !mhcMap.isEmpty()){
			
			cou = Integer.valueOf(mhcMap.get("cou").toString());
			
		}
		return cou;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getMeterHistoryListMonth(Map<String, Object> map) throws Exception {
		
		map.put("sta_tim", map.get("date").toString());
		
		map.put("end_tim", DateUtil.addMonth(map.get("date").toString()));
		
		return meterDao.getMeterHistoryListMonth(map);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getMeterHistoryListMonthCou(Map<String, Object> map) throws Exception {
		
		map.put("sta_tim", map.get("date").toString());
		
		map.put("end_tim", DateUtil.addMonth(map.get("date").toString()));
		
		List<Map<String, Object>> couLst = meterDao.getMeterHistoryListMonthCou(map);

		if (couLst != null && couLst.size() > 0) {

			for (Map<String, Object> couMap : couLst) {

				return couMap;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getMeterInfLst(Map<String, Object> map) throws Exception {
		
		// 建立最终结果返回集合

		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = meterDao.getEquLstByPwsEquTyp(map);
		
		// 通讯中断状态计数器
		Integer commStatCount = 0;
		
		// 正常运行状态计数器
		Integer norStatCount = 0;
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> meterRelTimLst = meterDao.getMeterInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(meterRelTimLst != null && !meterRelTimLst.isEmpty()){
					
					for(Map<String, Object>  meterRelTimMap : meterRelTimLst){
						// 判断PCS实时状态
						if("0".equals(meterRelTimMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(meterRelTimMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}
						equMap.putAll(meterRelTimMap);
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
			statMap.put("meterEquLst", retEquLst);
		}else{
			
			statMap.put("meterEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}
}
