package com.qinergy.service.integratmonitor.box;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.box.BoxDao;
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
public class BoxServiceImpl implements BoxService{
	
	
	@Autowired
	BoxDao boxDao;
	
	@Autowired
	OthersDao othersDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsBoxInfByEquNumTopOne(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> retLst = boxDao.getIscsBoxInfByEquNumTopOne(map);
		
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
	public List<Map<String, Object>> getIscsBoxTempDisRateCurves(Map<String,Object> map) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst =  boxDao.getIscsBoxTempDisRateCurves(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsBoxTempDisRateCurvesHistory(Map<String, Object> map) throws Exception {
		
		String crtTim = map.get("date").toString();
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> minLst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", minLst.get(0).get("sta_tim"));
		
		map.put("end_tim", minLst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst =  boxDao.getIscsBoxTempDisRateCurvesHistory(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsBoxTempDisRateCurvesHistoryLst(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "5");
		
		map.put("sta_tim", dayMonYearTimLst.get(0).get("sta_tim"));
		
		map.put("end_tim", dayMonYearTimLst.get(0).get("end_tim"));
		
		List<Map<String, Object>> iscsPvsAcDcPIVDisRateCurvesHistoryLst = boxDao.getIscsBoxTempDisRateCurvesHistoryLst(map);
		
		
		return iscsPvsAcDcPIVDisRateCurvesHistoryLst;
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getIscsBoxTempDisRateCurvesHistoryLstCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "5");
		
		map.put("sta_tim", dayMonYearTimLst.get(0).get("sta_tim"));
		
		map.put("end_tim", dayMonYearTimLst.get(0).get("end_tim"));
		
		List<Map<String, Object>> couLst = boxDao.getIscsBoxTempDisRateCurvesHistoryLstCou(map);

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
	public List<Map<String, Object>> getBoxInfLst(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = boxDao.getEquLstByPwsEquTyp(map);
		
		// 通讯中断状态计数器
		Integer commStatCount = 0;
		
		// 正常运行状态计数器
		Integer norStatCount = 0;
		
		// 告警运行状态计数器
		Integer alaStatCount = 0;
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> boxRelTimLst = boxDao.getBoxInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(boxRelTimLst != null && !boxRelTimLst.isEmpty()){
					
					for(Map<String, Object>  boxRelTimMap : boxRelTimLst){
						// 判断PCS实时状态
						if("0".equals(boxRelTimMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(boxRelTimMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}else if("2".equals(boxRelTimMap.get("stat").toString())){
							
							alaStatCount = alaStatCount +1;
							
							equMap.put("stat", 2);
							
						}
						equMap.putAll(boxRelTimMap);
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
		
		statMap.put("alaStatCount", alaStatCount);
		
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
			statMap.put("boxEquLst", retEquLst);
		}else{
			
			statMap.put("boxEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}
	
	/**
	 * 状态查询
	 *
	 */
	@Override
	public List<Map<String, Object>> getBoxInfStat(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = boxDao.getEquLstByPwsEquTyp(map);
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> pvsRelTimLst = boxDao.getBoxInfByEquNum(map);
				
				if(pvsRelTimLst != null && !pvsRelTimLst.isEmpty()){
					
					for(Map<String, Object> stat : pvsRelTimLst ){
					
						map.put("stat", stat.get("stat"));
						
						List<Map<String, Object>> pcsLst = boxDao.getBoxInfByEquNum(map);
						
						resultLst.addAll(pcsLst);
					}
				}
			}
		}
		return resultLst;
	}
}
