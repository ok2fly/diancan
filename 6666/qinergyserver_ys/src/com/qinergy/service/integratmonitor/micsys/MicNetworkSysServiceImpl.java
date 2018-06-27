package com.qinergy.service.integratmonitor.micsys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.micsys.MicNetworkSysDao;
import com.qinergy.dao.others.OthersDao;
import com.qinergy.service.integratmonitor.micsys.MicNetworkSysService;
import com.qinergy.util.DateUtil;

/**
 * 
 * @desc: 微网系统 接口实现类
 * @author: Qist
 * @date: 2017年10月27日
 */
@Service("micNetworkSysService")
public class MicNetworkSysServiceImpl implements MicNetworkSysService {

	@Autowired
	MicNetworkSysDao micNetworkSysDao;
	
	@Autowired
	OthersDao othersDao;

	@Override
	public Map<String, Object> getMicSysRealByEquNum(Map<String, Object> map) throws Exception {

		Map<String, Object> retMap = micNetworkSysDao.getMicSysRealByEquNum(map);
		
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
	public Map<String, Object> getMicSysRealsByEquNum(Map<String, Object> map) throws Exception {
		return micNetworkSysDao.getMicSysRealsByEquNum(map);
	}

	@Override
	public List<Map<String, Object>> getMicSysRealList(Map<String, Object> map) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = micNetworkSysDao.getMicSysRealList(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}

	@Override
	public List<Map<String, Object>> getMicSysHistoryList(Map<String, Object> map) throws Exception {
		return micNetworkSysDao.getMicSysHistoryList(map);
	}

	@Override
	public Integer getMicSysHistoryCount(Map<String, Object> map) throws Exception {
		int count = 0;
		Map<String, Object> micCount = micNetworkSysDao.getMicSysHistoryCount(map);
		if(micCount != null && !micCount.isEmpty()){
			count = Integer.parseInt(micCount.get("cou").toString());
		}
		return count;
	}

	// 按月电量数据
	@Override
	public List<Map<String, Object>> getMicsysTolPower(String equ_num, String day, String tim_typ) throws Exception {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
		if("2".equals(tim_typ)){
			resultList = getMicsysYearPower(equ_num, day);
		}else if("3".equals(tim_typ)){
			resultList = getMicsysTolPowerByYear(equ_num, day);
		}
	return resultList;
	}
	
	
	// 按月电量数据
	public List<Map<String, Object>> getMicsysYearPower(String equ_num, String day) throws Exception {

		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("equ_num", equ_num);

		// 统计一天的电量
		Double power4Grid = 0.0; // 电网输入电量
		Double power2Grid = 0.0; // 馈网电量
		Double powerLoad = 0.0; // 负荷用电电量
		Double powerCharge = 0.0; // 储能充电电量
		Double powerDisCharge = 0.0; // 储能放电电量
		Double powerPV = 0.0; // 光伏发电电量
		Double powerEV = 0.0; // 充电桩用电电量
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<Map<String, Object>> timLst = DateUtil.getDayMonYearTimLst(
				sdf.format(DateUtil.getFirstDayOfMonth(sdf.parse(day))), "2");
		if (timLst != null && timLst.size() > 0) {
			for (Map<String, Object> timMap : timLst) {
				Map<String, Object> micsysPower = null;
				Map<String, Object> micsysPowerBef = null;

				if (timMap != null && timMap.size() > 0) {
					paramMap.put("startTim", (String) timMap.get("staTim"));
					paramMap.put("endTim", (String) timMap.get("endTim"));

					micsysPower = micNetworkSysDao.getMicSysTolPower(paramMap);

					// 一天前的时间点
					String befTim = DateUtil.getSpecifiedDayBefore((String) timMap.get("staTim"));
					List<Map<String, Object>> dayTimBef = DateUtil.getDayMonYearTimLst(befTim, "1");
					if (dayTimBef != null && dayTimBef.size() > 0) {
						paramMap.put("startTim", (String) dayTimBef.get(0).get("sta_tim"));
						paramMap.put("endTim", (String) dayTimBef.get(0).get("end_tim"));

						micsysPowerBef = micNetworkSysDao.getMicSysTolPower(paramMap);
					}

					if (micsysPower != null && micsysPowerBef != null && micsysPower.size() > 0
							&& micsysPowerBef.size() > 0) {
						power4Grid = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
						power2Grid = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
						powerLoad = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
						powerCharge = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
						powerDisCharge = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
						powerPV = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
						powerEV = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
					}
					resultMap.put("power4Grid", power4Grid);
					resultMap.put("power2Grid", power2Grid);
					resultMap.put("powerLoad", powerLoad);
					resultMap.put("powerCharge", powerCharge);
					resultMap.put("powerDisCharge", powerDisCharge);
					resultMap.put("powerPV", powerPV);
					resultMap.put("powerEV", powerEV);
					resultMap.put("crtTim", (String) timMap.get("end_tim"));

					resultList.add(resultMap);
				}
			}
		}
		return resultList;
	}

	
	// 按年统计电量
	public List<Map<String, Object>> getMicsysTolPowerByYear(String equ_num, String day) throws Exception {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("equ_num", equ_num);

		// 统计一个月的电量
		Double power4Grid = 0.0; // 电网输入电量
		Double power2Grid = 0.0; // 馈网电量
		Double powerLoad = 0.0; // 负荷用电电量
		Double powerCharge = 0.0; // 储能充电电量
		Double powerDisCharge = 0.0; // 储能放电电量
		Double powerPV = 0.0; // 光伏发电电量
		Double powerEV = 0.0; // 充电桩用电电量
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<Map<String, Object>> monthList = DateUtil.getDayMonYearTimLst(day, "3");
		if (monthList != null && monthList.size() > 0) {
			for (Map<String, Object> monthMap : monthList) {

				Map<String, Object> micsysPower = null;
				Map<String, Object> micsysPowerBef = null;
				if (monthMap != null && monthMap.size() > 0) {

					paramMap.put("startTim", (String) monthMap.get("staTim"));
					paramMap.put("endTim", (String) monthMap.get("endTim"));

					micsysPower = micNetworkSysDao.getMicSysTolPower(paramMap);

					// 一个月前的时间点 
					String befTim = DateUtil.redMonth((String) monthMap.get("staTim"));
					
					paramMap.put("startTim", (String) befTim);
					paramMap.put("endTim", (String) (String) monthMap.get("staTim"));

					micsysPowerBef = micNetworkSysDao.getMicSysTolPower(paramMap);
					
					if (micsysPower != null && micsysPowerBef != null && micsysPower.size() > 0
							&& micsysPowerBef.size() > 0) {
						power4Grid = (Double) micsysPower.get("power4Grid")- (Double) micsysPowerBef.get("power4Grid");
						power2Grid = (Double) micsysPower.get("power4Grid")- (Double) micsysPowerBef.get("power4Grid");
						powerLoad = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
						powerCharge = (Double) micsysPower.get("power4Grid")-(Double) micsysPowerBef.get("power4Grid");
						powerDisCharge=(Double) micsysPower.get("power4Grid")-(Double) micsysPowerBef.get("power4Grid");
						powerPV = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
						powerEV = (Double) micsysPower.get("power4Grid") - (Double) micsysPowerBef.get("power4Grid");
					}
					resultMap.put("power4Grid", power4Grid);
					resultMap.put("power2Grid", power2Grid);
					resultMap.put("powerLoad", powerLoad);
					resultMap.put("powerCharge", powerCharge);
					resultMap.put("powerDisCharge", powerDisCharge);
					resultMap.put("powerPV", powerPV);
					resultMap.put("powerEV", powerEV);
					resultMap.put("crtTim", (String) monthMap.get("staTim"));

					resultList.add(resultMap);
					
				}
			}
		}
		return resultList;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getMicsysInfLst(Map<String, Object> map) throws Exception {
		
		// 建立最终结果返回集合

		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = micNetworkSysDao.getEquLstByPwsEquTyp(map);
		
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
				
				List<Map<String, Object>> micsysRelTimLst = micNetworkSysDao.getMicsysInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(micsysRelTimLst != null && !micsysRelTimLst.isEmpty()){
					
					for(Map<String, Object>  micsysRelTimMap : micsysRelTimLst){
						// 判断PCS实时状态
						if("0".equals(micsysRelTimMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(micsysRelTimMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}else if("2".equals(micsysRelTimMap.get("stat").toString())){
							
							downStatCount = downStatCount +1;
							
							equMap.put("stat", 2);
							
						}else if("3".equals(micsysRelTimMap.get("stat").toString())){
							
							alaStatCount = alaStatCount +1;
							
							equMap.put("stat", 3);
							
						}else if("4".equals(micsysRelTimMap.get("stat").toString())){
							
							fauStatCount = fauStatCount +1;
							
							equMap.put("stat", 4);
							
						}
						equMap.putAll(micsysRelTimMap);
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
			statMap.put("micsysEquLst", retEquLst);
		}else{
			
			statMap.put("micsysEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}

}
