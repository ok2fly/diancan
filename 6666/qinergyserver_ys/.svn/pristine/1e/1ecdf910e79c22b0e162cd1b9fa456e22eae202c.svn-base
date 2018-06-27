package com.qinergy.service.integratmonitor.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.ctl.CtlDao;

/**
 * 
 * @author zy
 *
 */
@Service
public class CtlServiceImpl implements CtlService{
	
	@Autowired
	CtlDao ctlDao;

	@Override
	public List<Map<String, Object>> getCtlInfByEquNum(Map<String, Object> map) throws Exception {
		
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = ctlDao.getBmsLstByPwsEquTyp(map);
		
		// 通讯中断状态计数器
		Integer commStatCount = 0;
		
		// 正常运行状态计数器
		Integer norStatCount = 0;
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> ctlRelTimLst = ctlDao.getCtlInfByEquNum(map);
				
				List<Map<String, Object>> ctlStaLst = ctlDao.getCtlStatByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(ctlRelTimLst != null && !ctlRelTimLst.isEmpty() && ctlRelTimLst.get(0) != null){
					
					for(Map<String, Object>  ctlRelTimMap : ctlRelTimLst){
						
						equMap.putAll(ctlRelTimMap);
					}
				}
				
				// 1.不带stat，获取所有的状态数据
				if(ctlStaLst != null && !ctlStaLst.isEmpty() && ctlStaLst.get(0) != null){
					
					for(Map<String, Object>  ctlStaMap : ctlStaLst){
						// 判断PCS实时状态
						if("0".equals(ctlStaMap.get("stat").toString())){
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(ctlStaMap.get("stat").toString())){
							
							norStatCount = norStatCount +1;
							
							equMap.put("stat", 1);
							
						}else{
							
							commStatCount = commStatCount +1;
							
							equMap.put("stat", 0);
						}
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
			statMap.put("ctlEquLst", retEquLst);
		}else{
			
			statMap.put("ctlEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}
}
