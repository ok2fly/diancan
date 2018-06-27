package com.qinergy.service.integratmonitor.dcdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.bms.BmsDao;
import com.qinergy.dao.integratmonitor.dcdb.DcdbDao;
import com.qinergy.dao.others.OthersDao;

/**
 * 
 * @author zy
 *
 */
@Service
public class DcdbServiceImpl implements DcdbService{
	
	@Autowired
	BmsDao bmsDao;
	
	@Autowired
	DcdbDao dcdbDao;
	
	@Autowired
	OthersDao othersDao;

	@Override
	public List<Map<String, Object>> getDcdbInfByEquNum(Map<String, Object> map) throws Exception {
		
		//TODO  方法加入公共类
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = bmsDao.getBmsLstByPwsEquTyp(map);
		
		// 通讯中断状态计数器
		Integer commStatCount = 0;
		
		// 正常运行状态计数器
		Integer norStatCount = 0;
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> dcdbRelTimLst = dcdbDao.getDcdbInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(dcdbRelTimLst != null && !dcdbRelTimLst.isEmpty()){
					
					for(Map<String, Object>  dcdbRelTimMap : dcdbRelTimLst){
						// 判断PCS实时状态
						if("0".equals(dcdbRelTimMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(dcdbRelTimMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}
						equMap.putAll(dcdbRelTimMap);
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
			statMap.put("dcdbEquLst", retEquLst);
		}else{
			
			statMap.put("dcdbEquLst", equLst);
		}

		resultLst.add(statMap);

		return resultLst;
	}

	@Override
	public List<Map<String, Object>> getDcdbInfoNewById(Map<String, Object> map) throws Exception {
		
		return dcdbDao.getDcdbInfoNewById(map);
	}

	@Override
	public List<Map<String, Object>> getDcdbById(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = dcdbDao.getDcdbById(map);
		
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
}
