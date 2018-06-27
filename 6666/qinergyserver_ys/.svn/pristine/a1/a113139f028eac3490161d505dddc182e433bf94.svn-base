package com.qinergy.service.integratmonitor.transf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.transf.TransformerDao;
import com.qinergy.dao.others.OthersDao;
import com.qinergy.service.integratmonitor.transf.TransformerService;
import com.qinergy.util.DateUtil;

/**
 * @desc: 变压器接口 实现类
 * @author: Qist
 * @date: 2017年10月26日
 */
@Service("transformerService")
public class TransformerServiceImpl implements TransformerService {

	@Autowired
	private TransformerDao transformerDao;
	
	@Autowired
	private OthersDao othersDao;
	
	@Override
	public Map<String, Object> getTransfRealByEquNum(Map<String, Object> map) throws Exception {

		Map<String, Object> retMap = transformerDao.getTransfRealByEquNum(map);
		
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
	public Map<String, Object> getTransfRealsByEquNum(Map<String, Object> map) throws Exception {
		
		return transformerDao.getTransfRealsByEquNum(map);
	}

	@Override
	public List<Map<String, Object>> getTransfRealList(Map<String, Object> map) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = transformerDao.getTransfRealList(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}


	@Override
	public List<Map<String, Object>> getTransfHistoryList(Map<String, Object> map) throws Exception {
		
		return transformerDao.getTransfHistoryList(map);
	}
	
	@Override
	public List<Map<String, Object>> getTransfHistoryGraph(Map<String, Object> map) throws Exception {
		
		String crtTim = map.get("date").toString();
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = transformerDao.getTransfHistoryGraph(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}

	@Override
	public Integer getTransfHistoryCount(Map<String, Object> map)
			throws Exception {
		return transformerDao.getTransfHistoryCount(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTransfInfLst(Map<String, Object> map) throws Exception {
		
		// 建立最终结果返回集合

		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = transformerDao.getEquLstByPwsEquTyp(map);
		
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
				
				List<Map<String, Object>> transfRelTimLst = transformerDao.getTransfInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(transfRelTimLst != null && !transfRelTimLst.isEmpty()){
					
					for(Map<String, Object>  transfRelTimMap : transfRelTimLst){
						// 判断PCS实时状态
						if("0".equals(transfRelTimMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(transfRelTimMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}else if("2".equals(transfRelTimMap.get("stat").toString())){
							
							alaStatCount = alaStatCount +1;
							
							equMap.put("stat", 2);
							
						}
						equMap.putAll(transfRelTimMap);
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
			statMap.put("transfEquLst", retEquLst);
		}else{
			
			statMap.put("transfEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}
}
