package com.qinergy.service.integratmonitor.bms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.bms.BmsDao;
import com.qinergy.dao.others.OthersDao;
import com.qinergy.util.DateUtil;


/**
 * 
 * @author zy
 *
 */

@Service
public class BmsServiceImpl implements BmsService{
	

	@Autowired
	OthersDao othersDao;
	
	@Autowired
	BmsDao bmsDao;

	@Override
	public List<Map<String, Object>> getBmsInfo() throws Exception {
		return bmsDao.getBmsInfo();
		
	}

	@Override
	public List<Map<String, Object>> getBmsInfoNew(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = bmsDao.getBmsInfoNew(map);
		
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

	@Override
	public List<Map<String, Object>> getBmsInfoList(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		list = bmsDao.getBmsInfoList(map);
		
		return list;
	}

	@Override
	public List<Map<String, Object>> getBmsInfoListById(Map<String, Object> map)
			throws Exception {
		return bmsDao.getBmsInfoListById(map);
	}

	@Override
	public Map<String, Object> getBmsInfoByYearList(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> listyear = bmsDao.getBmsInfoByYear(map);
		List<Map<String, Object>> listlast = bmsDao.getBmsInfoByYearList(map);
		Map<String, Object> mapnew = new HashMap<String, Object>();
		mapnew.put("listyear", listyear);
		mapnew.put("listlast", listlast);
		return mapnew;
	}

	@Override
	public Map<String, Object> getBmsInfoByMonthList(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> listmonth = bmsDao.getBmsInfoByMonth(map);
		List<Map<String, Object>> listlast = bmsDao.getBmsInfoByMonthList(map);
		Map<String, Object> mapnew = new HashMap<String, Object>();
		mapnew.put("listmonth", listmonth);
		mapnew.put("listlast", listlast);
		return mapnew;
	}

	@Override
	public List<Map<String, Object>> getBmsInfoByDayList(Map<String, Object> map)
			throws Exception {
		
		return bmsDao.getBmsInfoByDayList(map);
	}

	@Override
	public Map<String, Object> getBmsStatLev() throws Exception {
		List<Map<String, Object>> listOne =  bmsDao.getBmsStatOne();
		List<Map<String, Object>> listTwo = bmsDao.getBmsStatTwo();
		List<Map<String, Object>> listThree = bmsDao.getBmsStatThree();
		List<Map<String, Object>> listFour = bmsDao.getBmsStatFour();
		List<Map<String, Object>> listFive = bmsDao.getBmsStatFive();
		Map<String, Object> mapnew = new HashMap<String, Object>();
		mapnew.put("listOne", listOne);
		mapnew.put("listTwo", listTwo);
		mapnew.put("listThree", listThree);
		mapnew.put("listFour", listFour);
		mapnew.put("listFive", listFive);
		return mapnew;
	}

	@Override
	public List<Map<String, Object>> getBmsInfLst(Map<String, Object> map)
			throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = bmsDao.getBmsLstByPwsEquTyp(map);
		
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
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> bmsRelTimLst = bmsDao.getBmsInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(bmsRelTimLst != null && !bmsRelTimLst.isEmpty()){
					
					for(Map<String, Object>  bmsRelTimMap : bmsRelTimLst){
						// 判断PCS实时状态
						if("0".equals(bmsRelTimMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(bmsRelTimMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}else if("2".equals(bmsRelTimMap.get("stat").toString())){
							
							downStatCount = downStatCount +1;
							
							equMap.put("stat", 2);
							
						}else if("3".equals(bmsRelTimMap.get("stat").toString())){
							
							alaStatCount = alaStatCount +1;
							
							equMap.put("stat", 3);
							
						}else if("4".equals(bmsRelTimMap.get("stat").toString())){
							
							fauStatCount = fauStatCount +1;
							
							equMap.put("stat", 4);
						}
						equMap.putAll(bmsRelTimMap);
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
			statMap.put("bmsEquLst", retEquLst);
		}else{
			
			statMap.put("bmsEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}
	

	/**
	 * 状态查询
	 *
	 */
	@Override
	public List<Map<String, Object>> getBmsInfStat(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = bmsDao.getBmsLstByPwsEquTyp(map);
		
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> pcsRelTimLst = bmsDao.getBmsInfByEquNum(map);
				
				if(pcsRelTimLst != null && !pcsRelTimLst.isEmpty()){
					
					for(Map<String, Object> stat : pcsRelTimLst ){
					
					map.put("stat", stat.get("stat"));
					
					List<Map<String, Object>> pcsLst = bmsDao.getBmsInfByEquNum(map);
					
					resultLst.addAll(pcsLst);
					}
			}
		}
		
		/*Map<String,Object> statMap = new HashMap<String,Object>();
		
		statMap.put("pcsLst", equMap);
				
		resultLst.add(statMap);*/
		
	}
		return resultLst;
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoByDayGraph(Map<String, Object> map) throws Exception {
		
		String crtTim = map.get("year").toString();
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> minLst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", minLst.get(0).get("sta_tim"));
		
		map.put("end_tim", minLst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = bmsDao.getBmsInfoByDayGraph(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getBmsInfoByDayListCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> couLst = bmsDao.getBmsInfoByDayListCou(map);

		if (couLst != null && couLst.size() > 0) {

			for (Map<String, Object> couMap : couLst) {

				return couMap;
			}
		}
		return null;
	}

}
