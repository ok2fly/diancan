package com.qinergy.service.integratmonitor.pqsms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.pqsms.PqsmsDao;
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
public class PqsmsServiceImpl implements PqsmsService{
	
	
	@Autowired
	PqsmsDao pqsmsDao;
	
	@Autowired
	OthersDao othersDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsInfByEquNumTopOne(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = pqsmsDao.getIscsPqsmsInfByEquNumTopOne(map);
		
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
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurves(Map<String,Object> map) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = pqsmsDao.getIscsPqsmsUIPQsumCurves(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsThdUIABCHistogram(Map<String,Object> map) throws Exception {
		
		return pqsmsDao.getIscsPqsmsThdUIABCHistogram(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistoryLst(Map<String,Object> map) throws Exception {
		
		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "5");
		
		map.put("sta_tim", dayMonYearTimLst.get(0).get("sta_tim"));
		
		map.put("end_tim", dayMonYearTimLst.get(0).get("end_tim"));
		
		return pqsmsDao.getIscsPqsmsUIPQsumCurvesHistoryLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getIscsPqsmsUIPQsumCurvesHistoryLstCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "5");
		
		map.put("sta_tim", dayMonYearTimLst.get(0).get("sta_tim"));
		
		map.put("end_tim", dayMonYearTimLst.get(0).get("end_tim"));
		
		List<Map<String, Object>> couLst = pqsmsDao.getIscsPqsmsUIPQsumCurvesHistoryLstCou(map);

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
	public List<Map<String, Object>> getIscsPqsmsThdUIABCHistogramLst(Map<String,Object> map) throws Exception {
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> returnMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> pqsmsLst = pqsmsDao.getIscsPqsmsThdUIABCHistogram(map);
		
		List<Map<String, Object>> thduaLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thdubLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thducLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thdiaLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thdibLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thdicLst = new ArrayList<Map<String,Object>>();
		
		if(pqsmsLst != null && !pqsmsLst.isEmpty()){
			
			for(Map<String, Object> pqsmsMap : pqsmsLst){
				
				for(int i=2;i<=50;i++){
					
					Map<String,Object> thduaMap = new HashMap<String, Object>();
					
					thduaMap.put("key", "thdua"+i);
					
					thduaMap.put("value", pqsmsMap.get("thdua"+i));
					
					thduaLst.add(thduaMap);
					
					Map<String,Object> thdubMap = new HashMap<String, Object>();
					
					thdubMap.put("key", "thdub"+i);
					
					thdubMap.put("value", pqsmsMap.get("thdub"+i));
					
					thdubLst.add(thdubMap);
					
					Map<String,Object> thducMap = new HashMap<String, Object>();
					
					thducMap.put("key", "thduc"+i);
					
					thducMap.put("value", pqsmsMap.get("thduc"+i));
					
					thducLst.add(thducMap);
					
					Map<String,Object> thdiaMap = new HashMap<String, Object>();
					
					thdiaMap.put("key", "thdia"+i);
					
					thdiaMap.put("value", pqsmsMap.get("thdia"+i));
					
					thdiaLst.add(thdiaMap);
					
					Map<String,Object> thdibMap = new HashMap<String, Object>();
					
					thdibMap.put("key", "thdib"+i);
					
					thdibMap.put("value", pqsmsMap.get("thdib"+i));
					
					thdibLst.add(thdibMap);
					
					Map<String,Object> thdicMap = new HashMap<String, Object>();
					
					thdicMap.put("key", "thdic"+i);
					
					thdicMap.put("value", pqsmsMap.get("thdic"+i));
					
					thdicLst.add(thdicMap);
				}
			}
		}
		
		returnMap.put("thduaLst", thduaLst);
		
		returnMap.put("thdubLst", thdubLst);
		
		returnMap.put("thducLst", thducLst);
		
		returnMap.put("thdiaLst", thdiaLst);
		
		returnMap.put("thdibLst", thdibLst);
		
		returnMap.put("thdicLst", thdicLst);
		
		returnLst.add(returnMap);
		
		return returnLst;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsThdUIABCHistogramLstIos(Map<String,Object> map) throws Exception {
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> pqsmsLst = pqsmsDao.getIscsPqsmsThdUIABCHistogram(map);
		
		if(pqsmsLst != null && !pqsmsLst.isEmpty()){
			
			for(Map<String, Object> pqsmsMap : pqsmsLst){
				
				for(int i=2;i<=50;i++){
					
					Map<String,Object> thdMap = new HashMap<String, Object>();
					
					thdMap.put("thdua", pqsmsMap.get("thdua"+i));
					
					thdMap.put("thdub", pqsmsMap.get("thdub"+i));
					
					thdMap.put("thduc", pqsmsMap.get("thduc"+i));
					
					thdMap.put("thdia", pqsmsMap.get("thdia"+i));
					
					thdMap.put("thdib", pqsmsMap.get("thdib"+i));
					
					thdMap.put("thdic", pqsmsMap.get("thdic"+i));
					
					thdMap.put("xCount", i);
					
					returnLst.add(thdMap);
				}
			}
		}else{
			for(int i=2;i<=50;i++){
				
				Map<String,Object> thdMap = new HashMap<String, Object>();
				
				thdMap.put("xCount", i);
				
				returnLst.add(thdMap);
			}
		}
		
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsThdUIABCHistogramHistoryLst(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(), "1");
		
		map.put("sta_tim", dayMonYearTimLst.get(0).get("sta_tim"));
		
		map.put("end_tim", dayMonYearTimLst.get(0).get("end_tim"));
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> returnMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> pqsmsLst = pqsmsDao.getIscsPqsmsThdUIABCHistogram(map);
		
		List<Map<String, Object>> thduaLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thdubLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thducLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thdiaLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thdibLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> thdicLst = new ArrayList<Map<String,Object>>();
		
		if(pqsmsLst != null && !pqsmsLst.isEmpty()){
			
			for(Map<String, Object> pqsmsMap : pqsmsLst){
				
				for(int i=2;i<=50;i++){
					
					Map<String,Object> thduaMap = new HashMap<String, Object>();
					
					thduaMap.put("key", "thdua"+i);
					
					thduaMap.put("index", i+"");
					
					thduaMap.put("value", pqsmsMap.get("thdua"+i));
					
					thduaLst.add(thduaMap);
					
					Map<String,Object> thdubMap = new HashMap<String, Object>();
					
					thdubMap.put("key", "thdub"+i);
					
					thdubMap.put("index", i+"");
					
					thdubMap.put("value", pqsmsMap.get("thdub"+i));
					
					thdubLst.add(thdubMap);
					
					Map<String,Object> thducMap = new HashMap<String, Object>();
					
					thducMap.put("key", "thduc"+i);
					
					thducMap.put("index", i+"");
					
					thducMap.put("value", pqsmsMap.get("thduc"+i));
					
					thducLst.add(thducMap);
					
					Map<String,Object> thdiaMap = new HashMap<String, Object>();
					
					thdiaMap.put("key", "thdia"+i);
					
					thdiaMap.put("index", i+"");
					
					thdiaMap.put("value", pqsmsMap.get("thdia"+i));
					
					thdiaLst.add(thdiaMap);
					
					Map<String,Object> thdibMap = new HashMap<String, Object>();
					
					thdibMap.put("key", "thdib"+i);
					
					thdibMap.put("index", i+"");
					
					thdibMap.put("value", pqsmsMap.get("thdib"+i));
					
					thdibLst.add(thdibMap);
					
					Map<String,Object> thdicMap = new HashMap<String, Object>();
					
					thdicMap.put("key", "thdic"+i);
					
					thdicMap.put("index", i+"");
					
					thdicMap.put("value", pqsmsMap.get("thdic"+i));
					
					thdicLst.add(thdicMap);
				}
			}
		}
		
		returnMap.put("thduaLst", thduaLst);
		
		returnMap.put("thdubLst", thdubLst);
		
		returnMap.put("thducLst", thducLst);
		
		returnMap.put("thdiaLst", thdiaLst);
		
		returnMap.put("thdibLst", thdibLst);
		
		returnMap.put("thdicLst", thdicLst);
		
		returnLst.add(returnMap);
		
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistory(Map<String, Object> map) throws Exception {
		
		String crtTim = map.get("date").toString();
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = pqsmsDao.getIscsPqsmsUIPQsumCurvesHistory(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPqsmsInfLst(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = pqsmsDao.getEquLstByPwsEquTyp(map);
		
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
				
				List<Map<String, Object>> pvsRelTimLst = pqsmsDao.getPqsmsInfByEquNum(map);
				
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
							
							alaStatCount = alaStatCount +1;
							
							equMap.put("stat", 2);
							
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
			statMap.put("pqsmsEquLst", retEquLst);
		}else{
			
			statMap.put("pqsmsEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}

	
	
	
	/**
	 * 状态查询
	 *
	 */
	@Override
	public List<Map<String, Object>> getPqsmsInfStat(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = pqsmsDao.getEquLstByPwsEquTyp(map);
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> pvsRelTimLst = pqsmsDao.getPqsmsInfByEquNum(map);
				
				if(pvsRelTimLst != null && !pvsRelTimLst.isEmpty()){
					
					for(Map<String, Object> stat : pvsRelTimLst ){
					
						map.put("stat", stat.get("stat"));
						
						List<Map<String, Object>> pcsLst = pqsmsDao.getPqsmsInfByEquNum(map);
						
						resultLst.addAll(pcsLst);
					}
				}
			}
		}
		return resultLst;
	}
}
