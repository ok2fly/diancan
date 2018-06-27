package com.qinergy.service.integratmonitor.pcs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.pcs.PcsDao;
import com.qinergy.dao.others.OthersDao;
import com.qinergy.util.DateUtil;


/**
 * 
 * @author zy
 *
 */

@Service
public class PcsServiceImpl implements PcsService{
	
	@Autowired
	PcsDao pcsDao;
	
	@Autowired
	OthersDao othersDao;
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsNum0(Map<String, Object> map) throws Exception {
		
		return pcsDao.getPcsNum0(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsNum1(Map<String, Object> map) throws Exception {
		
		return pcsDao.getPcsNum1(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsNum2(Map<String, Object> map) throws Exception {
		
		return pcsDao.getPcsNum2(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsNum3(Map<String, Object> map) throws Exception {
		
		return pcsDao.getPcsNum3(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsNum4(Map<String, Object> map) throws Exception {
		
		return pcsDao.getPcsNum4(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsAll() throws Exception {
		return pcsDao.getPcsAll();
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsInfoById(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = pcsDao.getPcsInfoById(map);
		
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
	public List<Map<String, Object>> getPcsHistory(Map<String,Object> map) throws Exception {
		return pcsDao.getPcsHistory(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsInfoByYear(Map<String, Object> map)
			throws Exception {
		return pcsDao.getPcsInfoByYear(map);
		
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsInfoByYearList(
			Map<String, Object> map) throws Exception {
		return pcsDao.getPcsInfoByYearList(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsInfoByMonth(Map<String, Object> map)
			throws Exception {
		return pcsDao.getPcsInfoByMonth(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsInfoByMonthList(
			Map<String, Object> map) throws Exception {
		return pcsDao.getPcsInfoByMonthList(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsInfoByDayList(Map<String, Object> map)
			throws Exception {
		return pcsDao.getPcsInfoByDayList(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsNow(Map<String,Object> map) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = pcsDao.getPcsNow(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsNowMonth(Map<String,Object> map) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);

		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(crtTim, "2");
		
		if(monLst != null && !monLst.isEmpty()){
			
			for(Map<String, Object> monMap:monLst){
				
				Map<String,Object> retMap = new HashMap<String,Object>();
				
				map.put("sta_tim", monMap.get("staTim"));
				
				map.put("end_tim", monMap.get("endTim"));
				
				List<Map<String, Object>> curLst = pcsDao.getPcsNowMonth(map);
				
				if(curLst != null && !curLst.isEmpty() && curLst.get(0) != null){
					
					for(Map<String, Object> curMap:curLst){
						
						retMap.put("phi", curMap.get("phi"));
						
						retMap.put("phe", curMap.get("phe"));
					}
				}
				retMap.put("tol_tim", DateUtil.dateToStamp(monMap.get("staTim").toString()+" 00:00:00"));
				
				retLst.add(retMap);
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
	public List<Map<String, Object>> getPcsHistoryMonth(Map<String,Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "2");
		
		if(monLst != null && !monLst.isEmpty()){
			
			for(Map<String, Object> monMap:monLst){
				
				Map<String,Object> retMap = new HashMap<String,Object>();
				
				map.put("sta_tim", monMap.get("staTim"));
				
				map.put("end_tim", monMap.get("endTim"));
				
				List<Map<String, Object>> curLst = pcsDao.getPcsNowMonth(map);
				
				if(curLst != null && !curLst.isEmpty() && curLst.get(0) != null){
					
					for(Map<String, Object> curMap:curLst){
						
						retMap.put("phi", curMap.get("phi"));
						
						retMap.put("phe", curMap.get("phe"));
					}
				}
				retMap.put("tol_tim", DateUtil.dateToStamp(monMap.get("staTim").toString()+" 00:00:00"));
				
				retLst.add(retMap);
			}
		}
		
		return retLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPcsInfLst(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = pcsDao.getEquLstByPwsEquTyp(map);
		
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
				
				List<Map<String, Object>> pcsRelTimLst = pcsDao.getPcsInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(pcsRelTimLst != null && !pcsRelTimLst.isEmpty()){
					
					for(Map<String, Object> pcsRelTimMap : pcsRelTimLst){
						// 判断PCS实时状态
						if("0".equals(pcsRelTimMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(pcsRelTimMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}else if("2".equals(pcsRelTimMap.get("stat").toString())){
							
							downStatCount = downStatCount +1;
							
							equMap.put("stat", 2);
							
						}else if("3".equals(pcsRelTimMap.get("stat").toString())){
							
							alaStatCount = alaStatCount +1;
							
							equMap.put("stat", 3);
							
						}else if("4".equals(pcsRelTimMap.get("stat").toString())){
							
							fauStatCount = fauStatCount +1;
							
							equMap.put("stat", 4);
						}
						equMap.putAll(pcsRelTimMap);
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
			statMap.put("pcsEquLst", retEquLst);
		}else{
			
			statMap.put("pcsEquLst", equLst);
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
	public List<Map<String, Object>> getPcsInfStat(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = pcsDao.getEquLstByPwsEquTyp(map);
		
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> pcsRelTimLst = pcsDao.getPcsInfByEquNum(map);
				
				resultLst.addAll(pcsRelTimLst);
				
			/*	if(pcsRelTimLst != null && !pcsRelTimLst.isEmpty()){
					
					for(Map<String, Object> stat : pcsRelTimLst ){
					
					map.put("stat", stat.get("stat"));
					
					List<Map<String, Object>> pcsLst = pcsDao.getPcsInfByEquNum(map);
					
						
					
					}
			}*/
		}
		
	}
		return resultLst;
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPcsInfByEquNum(Map<String,Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = pcsDao.getPcsInfByEquNum(map);
		
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
	public List<Map<String, Object>> getPcsInfoByDayGraph(Map<String,Object> map) throws Exception {
		
		String crtTim = map.get("year").toString();
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> minLst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", minLst.get(0).get("sta_tim"));
		
		map.put("end_tim", minLst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = pcsDao.getPcsInfoByDayGraph(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
		
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getPcsInfoByDayListCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> couLst = pcsDao.getPcsInfoByDayListCou(map);

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
	public Map<String, Object> getPcsHistoryMonthLstCou(Map<String, Object> map) throws Exception {

		Map<String,Object> inpMap = new HashMap<String, Object>();
		
		inpMap.put("sta_tim", map.get("date").toString());
		
		inpMap.put("end_tim", DateUtil.addMonth(map.get("date").toString()));
		
		inpMap.put("equ_num", map.get("equ_num"));
		
		List<Map<String, Object>> couLst = pcsDao.getPcsHistoryMonthLstCou(inpMap);
		
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
	public List<Map<String, Object>> getPcsHistoryMonthLst(Map<String,Object> map) throws Exception {

		Map<String,Object> inpMap = new HashMap<String, Object>();
		
		inpMap.put("sta_tim", map.get("date").toString());
		
		inpMap.put("end_tim", DateUtil.addMonth(map.get("date").toString()));
		
		inpMap.put("equ_num", map.get("equ_num"));
		
		inpMap.put("start", map.get("start"));
		
		inpMap.put("everyPage", map.get("everyPage"));
		
		inpMap.put("currentPage", map.get("currentPage"));
		
		return pcsDao.getPcsHistoryMonthLst(inpMap);
	}
}
