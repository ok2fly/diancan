package com.qinergy.service.integratmonitor.dcchp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.dcchp.DcchpDao;
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
public class DcchpServiceImpl implements DcchpService{
	
	
	@Autowired
	DcchpDao dcchpDao;
	
	@Autowired
	OthersDao othersDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpStdInfByEquNumTopOne(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = dcchpDao.getIscsDcchpStdInfByEquNumTopOne(map);
		
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
	public List<Map<String, Object>> getIscsDcchpRelInfByEquNumTopOne(Map<String, Object> map) throws Exception {
		
		return dcchpDao.getIscsDcchpRelInfByEquNumTopOne(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpRelUICurves(Map<String,Object> map) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = dcchpDao.getIscsDcchpRelUICurves(map);
		
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpRelUICurvesHistory(Map<String, Object> map) throws Exception {
		
		
		List<Map<String, Object>> iscsDcchpRelUICurvesHistoryLst = dcchpDao.getIscsDcchpRelUICurvesHistory(map);
		
		return iscsDcchpRelUICurvesHistoryLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpOrdInfLst(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> returnLst = dcchpDao.getIscsDcchpOrdInfLst(map);
		
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getIscsDcchpOrdInfLstCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> couLst = dcchpDao.getIscsDcchpOrdInfLstCou(map);

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
	public List<Map<String, Object>> getIscsCarStaInfLst(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> carLst = dcchpDao.getIscsCarStaInfLst(map);
		
		return carLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getDcchpInfLst(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = dcchpDao.getEquLstByPwsEquTyp(map);
		
		// 离线状态计数器
		Integer offlineStatCount = 0;
		
		// 空闲状态计数器
		Integer idleStatCount = 0;
		
		// 充电中状态计数器
		Integer inChargeStatCount = 0;
		
		// 告警运行状态计数器
		Integer alaStatCount = 0;
		
		// 预约状态计数器
		Integer bookingStatCount = 0;
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> dcchpRelTimLst = dcchpDao.getDcchpInfByEquNum(map);
				
				// 1.不带stat，获取所有的状态数据
				if(dcchpRelTimLst != null && !dcchpRelTimLst.isEmpty()){
					
					for(Map<String, Object>  dcchpRelTimMap : dcchpRelTimLst){
						// 判断PCS实时状态
						if("0".equals(dcchpRelTimMap.get("stat").toString())){
							
							offlineStatCount = offlineStatCount +1;
							
							equMap.put("stat", 0);
							
						}else if("1".equals(dcchpRelTimMap.get("stat").toString())){
							
							idleStatCount = idleStatCount +1;
							
							equMap.put("stat", 1);
							
						}else if("2".equals(dcchpRelTimMap.get("stat").toString())){
							
							inChargeStatCount = inChargeStatCount +1;
							
							equMap.put("stat", 2);
							
						}else if("3".equals(dcchpRelTimMap.get("stat").toString())){
							
							alaStatCount = alaStatCount +1;
							
							equMap.put("stat", 3);
							
						}else if("4".equals(dcchpRelTimMap.get("stat").toString())){
							
							bookingStatCount = bookingStatCount +1;
							
							equMap.put("stat", 4);
						}
						equMap.putAll(dcchpRelTimMap);
					}
				}else{
					
					offlineStatCount = offlineStatCount+1;
					
					equMap.put("stat", 0);
				}
			}
		}
		
		Map<String,Object> statMap = new HashMap<String,Object>();
		
		statMap.put("offlineStatCount", offlineStatCount);
		
		statMap.put("idleStatCount", idleStatCount);
		
		statMap.put("inChargeStatCount", inChargeStatCount);
		
		statMap.put("alaStatCount", alaStatCount);
		
		statMap.put("bookingStatCount", bookingStatCount);
		
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
			statMap.put("dcchpEquLst", retEquLst);
		}else{
			
			statMap.put("dcchpEquLst", equLst);
		}
		
		resultLst.add(statMap);
		
		return resultLst;
	}

	
	
	
	/**
	 * 状态查询
	 *
	 */
	@Override
	public List<Map<String, Object>> getDcchpInfStat(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = dcchpDao.getEquLstByPwsEquTyp(map);
		
		
		if(equLst != null && !equLst.isEmpty()){
			
			for(Map<String, Object> equMap : equLst){
				// 获取PCS设备的最新实时数据(列表页中)
				
				map.put("equ_num", equMap.get("equ_num"));
				
				List<Map<String, Object>> pvsRelTimLst = dcchpDao.getDcchpInfByEquNum(map);
				
				if(pvsRelTimLst != null && !pvsRelTimLst.isEmpty()){
					
					for(Map<String, Object> stat : pvsRelTimLst ){
					
						map.put("stat", stat.get("stat"));
						
						List<Map<String, Object>> pcsLst = dcchpDao.getDcchpInfByEquNum(map);
						
						resultLst.addAll(pcsLst);
					}
				}
			}
		}
		return resultLst;
	}
}
