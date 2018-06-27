package com.qinergy.service.integratmonitor.lneptt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.lneptt.LnepttDao;
import com.qinergy.dao.others.OthersDao;
import com.qinergy.util.DateUtil;


/**
 * 
 * @author zy
 *
 */

@Service
public class LnepttServiceImpl implements LnepttService{
	
	@Autowired
	OthersDao othersDao;
	
	@Autowired
	LnepttDao lnepttDao;
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfByEquNum(Map<String, Object> map)
			throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = lnepttDao.getLnepttLstByPwsEquTyp(map);
		
		// 通讯中断状态计数器
		Integer commStatCount = 0;
		
		// 正常运行状态计数器
		Integer norStatCount = 0;
		
		// 故障保护计数器
		Integer downStatCount = 0;
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> lnepttRelTimLst = lnepttDao.getLnepttInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(lnepttRelTimLst != null && !lnepttRelTimLst.isEmpty()){
					
					for(Map<String, Object>  lnepttRelTimMap : lnepttRelTimLst){
						// 判断PCS实时状态
						if("0".equals(lnepttRelTimMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(lnepttRelTimMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}else if("2".equals(lnepttRelTimMap.get("stat").toString())){
							
							downStatCount = downStatCount +1;
							
							equMap.put("stat", 2);
							
						}
						equMap.putAll(lnepttRelTimMap);
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
			statMap.put("lnepttEquLst", retEquLst);
		}else{
			
			statMap.put("lnepttEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getLnepttById(Map<String, Object> map) throws Exception{
		
		List<Map<String, Object>> retLst = lnepttDao.getLnepttById(map);
		
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
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfoById(Map<String, Object> map) throws Exception {
		return lnepttDao.getLnepttInfoById(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */	
	@Override
	public List<Map<String, Object>> getLnepttNow(Map<String, Object> map) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst =  lnepttDao.getLnepttNow(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */	
	@Override
	public Map<String, Object> getLnepttInfoByYearList(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> listYear = lnepttDao.getLnepttInfoByYear(map);
		List<Map<String, Object>> listlast = lnepttDao.getLnepttInfoByYearList(map);
		Map<String, Object> mapnew = new HashMap<String, Object>();
		mapnew.put("listYear", listYear);
		mapnew.put("listlast", listlast);
		return mapnew;
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */	
	@Override
	public Map<String, Object> getLnepttInfoByMonthList(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> listMonth = lnepttDao.getLnepttInfoByMonth(map);
		List<Map<String, Object>> listlast = lnepttDao.getLnepttInfoByMonthList(map);
		Map<String, Object> mapnew = new HashMap<String, Object>();
		mapnew.put("listMonth", listMonth);
		mapnew.put("listlast", listlast);
		return mapnew;
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */	
	@Override
	public List<Map<String, Object>> getLnepttInfoByDayList(Map<String, Object> map) throws Exception {
		
		return lnepttDao.getLnepttInfoByDayList(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */	
	@Override
	public List<Map<String, Object>> getLnepttInfoByDayGraph(Map<String, Object> map) throws Exception {

		String crtTim = map.get("year").toString();
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst =  lnepttDao.getLnepttInfoByDayGraph(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
		
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getLnepttInfoByDayListCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> couLst = lnepttDao.getLnepttInfoByDayListCou(map);

		if (couLst != null && couLst.size() > 0) {

			for (Map<String, Object> couMap : couLst) {

				return couMap;
			}
		}
		return null;
	}
}
