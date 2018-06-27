/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.statisticanalysis.pwssta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;











import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.statisticanalysis.pwssta.PwsStaDao;
import com.qinergy.dao.system.SystemDao;
import com.qinergy.util.DateUtil;

/**
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @version 1.0
 * @since 1.0
 */

@Service
public class PwsStaServiceImpl implements PwsStaService {

	@Autowired
	PwsStaDao pwsStaDao;
	
	@Autowired
	SystemDao systemDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPwsStaInfo(Map<String, Object> map)
			throws Exception {
		return pwsStaDao.getPwsByComId(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getStaByPws(Map<String, Object> map)
			throws Exception {
		return pwsStaDao.getStaByPws(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSatInfoByStaId(Map<String, Object> map) throws Exception {
		
		List<Map<String,Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		String strings = map.get("strings").toString();
		// 将从前端返回回来的电站ID拼接串变成数组
		String[] pws_ids = strings.split("-");
		// 遍历电站ID数组
		for (int i = 0; i < pws_ids.length; i++) {
			
			HashMap<String, Object> returnMap = new HashMap<String, Object>();
			
			map.put("pws_id", pws_ids[i].toString());
			// 获取站点信息，使用ID
			List<Map<String, Object>> pwsLst = systemDao.getPwsInfLstByPwsId(map);
			
			String pws_nam = "";
			// 判断电站信息是否为空
			if(pwsLst != null && !pwsLst.isEmpty() && pwsLst.get(0) != null){
				
				for(Map<String, Object> pwsMap:pwsLst){
					
					pws_nam = pwsMap.get("pws_nam").toString();
							
					returnMap.put("pws_nam", pws_nam);
					
				}
			}
			// 获取某年、月、日起始和结束时间点集合
			List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(map.get("year").toString()+"-1-1", "3");
			
			List<Map<String, Object>> saInfLst = new ArrayList<Map<String,Object>>();
			// 对时间点集合进行非空判断
			if(monLst != null && !monLst.isEmpty()){
				// 循环遍历
				for(Map<String, Object> monMap:monLst){
					
					map.put("sta_tim", monMap.get("staTim"));
					
					map.put("end_tim", monMap.get("endTim"));
					
					Map<String, Object> saInfMap = new HashMap<String,Object>();
					// 根据站点查询信息 年(光伏)
					List<Map<String, Object>> saInfPVSLst = pwsStaDao.getSatInfoByStaIdPVS(map);
					
					if(saInfPVSLst != null && !saInfPVSLst.isEmpty() && saInfPVSLst.get(0) != null){
						
						for(Map<String, Object> saInfPVSMap : saInfPVSLst){
							
							saInfMap.put("pow_gen_eff_hours", saInfPVSMap.get("pow_gen_eff_hours"));
							
							saInfMap.put("power", saInfPVSMap.get("power"));
						}
					}
					
					// 根据站点查询信息 年(储能)
					List<Map<String, Object>> saInfPCSLst = pwsStaDao.getSatInfoByStaIdPCS(map);
					
					if(saInfPCSLst != null && !saInfPCSLst.isEmpty() && saInfPCSLst.get(0) != null){
						
						for(Map<String, Object> saInfPCSMap : saInfPCSLst){
							
							saInfMap.put("ene_stg_rvn", saInfPCSMap.get("ene_stg_rvn"));
						}
					}
					// 根据站点查询信息 年(充电桩)
					List<Map<String, Object>> saInfChpLst = pwsStaDao.getSatInfoByStaIdChp(map);
					
					if(saInfChpLst != null && !saInfChpLst.isEmpty() && saInfChpLst.get(0) != null){
						
						for(Map<String, Object> saInfChpMap : saInfChpLst){
							
							saInfMap.put("cha_vol", saInfChpMap.get("cha_vol"));
							
							saInfMap.put("cha_gen_eff_hours", saInfChpMap.get("cha_gen_eff_hours"));
						}
					}
					// 根据站点查询信息 年(耗损)
					List<Map<String, Object>> saInfLossLst = pwsStaDao.getSatInfoByStaIdLoss(map);
					
					if(saInfLossLst != null && !saInfLossLst.isEmpty() && saInfLossLst.get(0) != null){
						
						for(Map<String, Object> saInfLossMap : saInfLossLst){
							
							saInfMap.put("loss", saInfLossMap.get("loss"));
						}
					}
					// 根据站点查询信息 年(故障)
					List<Map<String, Object>> saInfFauLst = pwsStaDao.getSatInfoByStaIdFau(map);
					
					if(saInfFauLst != null && !saInfFauLst.isEmpty() && saInfFauLst.get(0) != null){
						
						for(Map<String, Object> saInfFauMap : saInfFauLst){
							
							saInfMap.put("fal_equ_num", saInfFauMap.get("fal_equ_num"));
						}
					}
					
					saInfMap.put("tol_tim", monMap.get("staTim"));
					
					saInfLst.add(saInfMap);
				}
			}
			
			returnMap.put("saInfLst", saInfLst);
			
			returnLst.add(returnMap);
		}
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSatInfoByStaIdMonth(Map<String, Object> map) throws Exception {
		
		List<Map<String,Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		String strings = map.get("strings").toString();
		// 将从前端返回回来的电站ID拼接串变成数组
		String[] pws_ids = strings.split("-");
		// 遍历电站ID数组
		for (int i = 0; i < pws_ids.length; i++) {
			
			HashMap<String, Object> returnMap = new HashMap<String, Object>();
			
			map.put("pws_id", pws_ids[i].toString());
			// 获取站点信息，使用ID
			List<Map<String, Object>> pwsLst = systemDao.getPwsInfLstByPwsId(map);
			
			String pws_nam = "";
			// 非空判断
			if(pwsLst != null && !pwsLst.isEmpty() && pwsLst.get(0) != null){
				// 循环遍历，获取电站名称
				for(Map<String, Object> pwsMap:pwsLst){
					
					pws_nam = pwsMap.get("pws_nam").toString();
							
					returnMap.put("pws_nam", pws_nam);
					
				}
			}
			// 获取某年、月、日起始和结束时间点集合
			List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(map.get("year").toString()+"-1", "2");
			
			List<Map<String, Object>> saInfLst = new ArrayList<Map<String,Object>>();
			// 时间点集合非空判断
			if(monLst != null && !monLst.isEmpty()){
				
				// 时间点集合循环遍历
				for(Map<String, Object> monMap:monLst){
					
					map.put("sta_tim", monMap.get("staTim"));
					
					map.put("end_tim", monMap.get("endTim"));
					
					Map<String, Object> saInfMap = new HashMap<String,Object>();
					// 根据站点查询信息 年(光伏)
					List<Map<String, Object>> saInfPVSLst = pwsStaDao.getSatInfoByStaIdPVS(map);
					
					if(saInfPVSLst != null && !saInfPVSLst.isEmpty() && saInfPVSLst.get(0) != null){
						
						for(Map<String, Object> saInfPVSMap : saInfPVSLst){
							
							saInfMap.put("pow_gen_eff_hours", saInfPVSMap.get("pow_gen_eff_hours"));
							
							saInfMap.put("power", saInfPVSMap.get("power"));
						}
					}
					
					// 根据站点查询信息 年(储能)
					List<Map<String, Object>> saInfPCSLst = pwsStaDao.getSatInfoByStaIdPCS(map);
					
					if(saInfPCSLst != null && !saInfPCSLst.isEmpty() && saInfPCSLst.get(0) != null){
						
						for(Map<String, Object> saInfPCSMap : saInfPCSLst){
							
							saInfMap.put("ene_stg_rvn", saInfPCSMap.get("ene_stg_rvn"));
						}
					}
					// 根据站点查询信息 年(充电桩)
					List<Map<String, Object>> saInfChpLst = pwsStaDao.getSatInfoByStaIdChp(map);
					
					if(saInfChpLst != null && !saInfChpLst.isEmpty() && saInfChpLst.get(0) != null){
						
						for(Map<String, Object> saInfChpMap : saInfChpLst){
							
							saInfMap.put("cha_vol", saInfChpMap.get("cha_vol"));
							
							saInfMap.put("cha_gen_eff_hours", saInfChpMap.get("cha_gen_eff_hours"));
						}
					}
					// 根据站点查询信息 年(耗损)
					List<Map<String, Object>> saInfLossLst = pwsStaDao.getSatInfoByStaIdLoss(map);
					
					if(saInfLossLst != null && !saInfLossLst.isEmpty() && saInfLossLst.get(0) != null){
						
						for(Map<String, Object> saInfLossMap : saInfLossLst){
							
							saInfMap.put("loss", saInfLossMap.get("loss"));
						}
					}
					// 根据站点查询信息 年(故障)
					List<Map<String, Object>> saInfFauLst = pwsStaDao.getSatInfoByStaIdFau(map);
					
					if(saInfFauLst != null && !saInfFauLst.isEmpty() && saInfFauLst.get(0) != null){
						
						for(Map<String, Object> saInfFauMap : saInfFauLst){
							
							saInfMap.put("fal_equ_num", saInfFauMap.get("fal_equ_num"));
						}
					}
					
					saInfMap.put("tol_tim", monMap.get("staTim"));
					
					saInfLst.add(saInfMap);
				}
			}
			
			returnMap.put("saInfLst", saInfLst);
			
			returnLst.add(returnMap);
		}
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPower(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> newList= new ArrayList<Map<String, Object>>();
		//获取计划发电量集合
		List<Map<String, Object>> planPower = 	pwsStaDao.getPlanPower(map);
		//获取实际发电量集合
		List<Map<String, Object>> realPower = pwsStaDao.getMonthPower(map);
		
		Map<String, Object> newMap = new HashMap<String, Object>();
		
		for (int i = 0; i < planPower.size(); i++ ) {
			
			for (int j = 0; i < realPower.size(); j++ ) {
				// 判断计划发电时间与实际发电时间以及计划发电站名称与实际发电站名称是否相同，相同则进行赋值处理
				if (planPower.get(i).get("plan_tim").equals(realPower.get(j).get("tol_tim")) && 
						planPower.get(i).get("pws_nam").equals(realPower.get(j).get("pws_nam"))) {
					
					
					newMap.put("pws_nam",planPower.get(i).get("pws_nam"));
					
					newMap.put("tim",planPower.get(i).get("plan_tim"));
					
					newMap.put("plan_power",planPower.get(i).get("plan_power"));
					
					newMap.put("pvs_power", realPower.get(j).get("pvs_power"));
					
					newList.add(newMap);
					
				}else{
					
					newMap.put("pws_nam",planPower.get(j).get("pws_nam"));
					
					newMap.put("tim",planPower.get(i).get("plan_tim"));
					
					newMap.put("plan_power",planPower.get(i).get("plan_power"));
					
					newMap.put("pvs_power",realPower.get(j).get("pvs_power"));
					
					newList.add(newMap);
					
				}
				
				return newList;
			}
		}
		return newList;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPowerNew(Map<String, Object> map) throws Exception {
		// 获取月份集合
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(map.get("year").toString(), "3");
		// 通过站点ID获取到站点信息
		List<Map<String, Object>> staLst = systemDao.getPwsNamByPwsId(map);
		// 遍历返回的月份集合
		for (Map<String, Object> monMap : monLst) {
			
			monMap.get("sta_tim");
			
			monMap.get("end_tim");
			
			monMap.put("pws_id", map.get("pws_id"));
			// 将站点信息填写回返回的集合中
			if(staLst != null && !staLst.isEmpty()){
				
				for(Map<String, Object> staMap : staLst){
					
					monMap.put("pws_nam", staMap.get("pws_nam").toString());
				}
			}
			// 获取指定时间的计划电量
			List<Map<String, Object>> planLst = pwsStaDao.getPowerByPlan(monMap);
			
			if(planLst != null && !planLst.isEmpty()){
				
				for(Map<String, Object> planMap : planLst){
					
					monMap.put("plan_power", planMap.get("plan_power"));
				}
			}
			// 获取指定时间的实际电量
			List<Map<String, Object>> realLst = pwsStaDao.getPowerByReal(monMap);
			
			if(realLst != null && !realLst.isEmpty() && realLst.get(0) != null){
				
				for(Map<String, Object> realMap : realLst){
					
					monMap.put("real_power", realMap.get("pvs_power"));
				}
			}
		}
		
		return monLst;
	
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPhiPheNew(Map<String, Object> map) throws Exception {
		// 获取月份集合
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(map.get("year").toString(), "3");
		// 通过站点ID获取到站点信息
		List<Map<String, Object>> staLst = systemDao.getPwsNamByPwsId(map);
		// 遍历返回的月份集合
		for (Map<String, Object> monMap : monLst) {
			
			monMap.get("sta_tim");
			
			monMap.get("end_tim");
			
			monMap.put("pws_id", map.get("pws_id"));
			// 将站点信息填写回返回的集合中
			if(staLst != null && !staLst.isEmpty()){
				
				for(Map<String, Object> staMap : staLst){
					
					monMap.put("pws_nam", staMap.get("pws_nam").toString());
				}
			}
			// 获取指定时间的计划电量
			List<Map<String, Object>> planLst = pwsStaDao.getPhiPheByPlan(monMap);
			
			if(planLst != null && !planLst.isEmpty()){
				
				for(Map<String, Object> planMap : planLst){
					
					monMap.put("plan_phi", planMap.get("plan_phi"));
					
					monMap.put("plan_phe", planMap.get("plan_phe"));
				}
			}
			// 获取指定时间的实际电量
			List<Map<String, Object>> realLst = pwsStaDao.getPhiPheByReal(monMap);
			
			if(realLst != null && !realLst.isEmpty() && realLst.get(0) != null){
				
				for(Map<String, Object> realMap : realLst){
					
					monMap.put("pcs_phi", realMap.get("pcs_phi"));
					
					monMap.put("pcs_phe", realMap.get("pcs_phe"));
				}
			}
		}
		
		return monLst;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPhiPheSaMon(Map<String, Object> map) throws Exception {
		// 获取月份集合
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(map.get("year").toString(), "3");
		// 通过站点ID获取到站点信息
		List<Map<String, Object>> staLst = systemDao.getPwsNamByPwsId(map);
		// 遍历返回的月份集合
		for (Map<String, Object> monMap : monLst) {
			
			monMap.get("sta_tim");
			
			monMap.get("end_tim");
			
			monMap.put("pws_id", map.get("pws_id"));
			// 将站点信息填写回返回的集合中
			if(staLst != null && !staLst.isEmpty()){
				
				for(Map<String, Object> staMap : staLst){
					
					monMap.put("pws_nam", staMap.get("pws_nam").toString());
				}
			}
			// 获取指定时间的计划电量
			List<Map<String, Object>> planLst = pwsStaDao.getPhiPheByPlan(monMap);
			
			if(planLst != null && !planLst.isEmpty()){
				
				for(Map<String, Object> planMap : planLst){
					
					monMap.put("plan_phi", planMap.get("plan_phi"));
					
					monMap.put("plan_phe", planMap.get("plan_phe"));
				}
			}else{
				// 如果返回的电量为空，则用0补位
				monMap.put("plan_phi", 0);
				
				monMap.put("plan_phe", 0);
			}
			// 获取指定时间的实际电量
			List<Map<String, Object>> realLst = pwsStaDao.getPhiPheByReal(monMap);
			
			if(realLst != null && !realLst.isEmpty()){
				
				for(Map<String, Object> realMap : realLst){
					
					if(realMap != null && !realMap.isEmpty()){
						
						monMap.put("real_phi", realMap.get("pcs_phi"));
						
						monMap.put("real_phe", realMap.get("pcs_phe"));
					}
				}
			}else{
				// 如果返回的电量为空，则用0补位
				monMap.put("real_phi", 0);
				
				monMap.put("real_phe", 0);
			}
		}
		
		return monLst;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFalEquNum(Map<String, Object> map) throws Exception {
		// 故障数量 前5
		List<Map<String, Object>> topList = pwsStaDao.getFalEquNumTop(map);
		// 故障数量 后5
		List<Map<String, Object>> boottomList = pwsStaDao.getFalEquNumBoottom(map);
		
		List<Map<String, Object>> getFalEquNum = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> newMap = new HashMap<String, Object>();
		
		newMap.put("topList", topList);
		
		newMap.put("boottomList", boottomList);
		
		getFalEquNum.add(newMap);
		
		return getFalEquNum;
		
	}
	
	
	//排行榜（业主）
	//发电量排行榜 TOP5bottom5
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPowerRankByComOwner(Map<String, Object> map) throws Exception {
		
		String sta_tim = "";
		String end_tim = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
			
		// 如果查询纬度为月
		if(map.get("type").toString().equals("2")){
			
			System.out.println(map.get("date").toString()+"**********");
			
			// 获取到查询月1日0点0分0秒的时间
			sta_tim = sdf.format(sdf.parse(map.get("date").toString()));
			// 获取到查询月下一月1日0点0分0秒的时间
			end_tim = DateUtil.addMonth(sta_tim);
			
			// 如果查询纬度为年
		}else if(map.get("type").toString().equals("1")){
			
			Calendar calendar = Calendar.getInstance();
			
			calendar.setTime(sdf.parse(map.get("date").toString()));
			
			int year = calendar.get(Calendar.YEAR);
			// 获取到查询年1月1日0点0分0秒的时间
			sta_tim = DateUtil.getYearMonthDayString(year, 1, 1);
			// 获取到查询年下一年1月1日0点0分0秒的时间
			end_tim = DateUtil.getYearMonthDayString(year+1, 1, 1);
		}
		
		//获取公司信息
		List<Map<String, Object>> comUseList = systemDao.getComInfAndUseInfByUseId(map);
		
		Map<String, Object> inputMap = new HashMap<String,Object>();
		
		Map<String, Object> returnMap = new HashMap<String,Object>();
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		inputMap.put("sta_tim", sta_tim); 
		
		inputMap.put("end_tim", end_tim); 
		
		for(Map<String, Object> comUse : comUseList){
			//公司类型为 1  运维
			if("1".equals(comUse.get("use_typ").toString())){
				
				inputMap.put("use_id",map.get("use_id").toString());
				
				inputMap.put("pws_id",map.get("pws_id").toString());
				
				System.out.println(inputMap+"============");
				
				//查询运维 前五 后五
				List<Map<String, Object>> powerListTop = pwsStaDao.getPowerRankByComTop5Opm(inputMap);
				
				List<Map<String, Object>> powerListBottom =  pwsStaDao.getPowerRankByComBottom5Opm(inputMap);
				
				if(powerListTop != null && !powerListTop.isEmpty()){
					
					for(Map<String, Object> top : powerListTop){
						
						if(top.get("power") == null || top.get("power").toString().isEmpty()){
							
							top.put("power", 0);
						}
					}
					returnMap.put("powerListTop", powerListTop);
				}
				

				if(powerListBottom != null && !powerListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : powerListBottom){
						
						if(bottom.get("power") == null || bottom.get("power").toString().isEmpty()){
							
							bottom.put("power", 0);
						}
					}
					returnMap.put("powerListBottom", powerListBottom);
				}
				
				//查询运维 前五 后五(故障数)
				List<Map<String, Object>> faultListTop = pwsStaDao.getFaultRankByComTop5Opm(inputMap);
				
				List<Map<String, Object>> faultListBottom = pwsStaDao.getFaultRankByComBottom5Opm(inputMap);
				
				if(faultListTop != null && !faultListTop.isEmpty()){
					
					for(Map<String, Object> top : faultListTop){
						
						if(top.get("fal_equ_num") == null || top.get("fal_equ_num").toString().isEmpty()){
							
							top.put("fal_equ_num", 0);
						}
					}
					returnMap.put("faultListTop", faultListTop);
				}
				

				if(faultListBottom != null && !faultListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : faultListBottom){
						
						if(bottom.get("fal_equ_num") == null || bottom.get("fal_equ_num").toString().isEmpty()){
							
							bottom.put("fal_equ_num", 0);
						}
					}
					returnMap.put("faultListBottom", faultListBottom);
				}
				
				//查询运维 前五 后五(发电有效小时数)
				List<Map<String, Object>> powGenEffHourListTop = pwsStaDao.getPowGenEffHourRankByComTop5Opm(inputMap);
				
				List<Map<String, Object>> powGenEffHourListBottom = pwsStaDao.getPowGenEffHourRankByComBottom5Opm(inputMap);
				
				if(powGenEffHourListTop != null && !powGenEffHourListTop.isEmpty()){
					
					for(Map<String, Object> top : powGenEffHourListTop){
						
						if(top.get("pow_gen_eff_hours") == null || top.get("pow_gen_eff_hours").toString().isEmpty()){
							
							top.put("pow_gen_eff_hours", 0);
						}
					}
					returnMap.put("powGenEffHourListTop", powGenEffHourListTop);
				}
				
				
				if(powGenEffHourListBottom != null && !powGenEffHourListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : powGenEffHourListBottom){
						
						if(bottom.get("pow_gen_eff_hours") == null || bottom.get("pow_gen_eff_hours").toString().isEmpty()){
							
							bottom.put("pow_gen_eff_hours", 0);
						}
					}
					returnMap.put("powGenEffHourListBottom", powGenEffHourListBottom);
				}
				
				//查询运维 前五 后五(充电量)
				List<Map<String, Object>> chaVolListTop = pwsStaDao.getChaVolRankByComTop5Opm(inputMap);
				
				List<Map<String, Object>> chaVolListBottom = pwsStaDao.getChaVolRankByComBottom5Opm(inputMap);
				
				if(chaVolListTop != null && !chaVolListTop.isEmpty()){
					
					for(Map<String, Object> top : chaVolListTop){
						
						if(top.get("cha_vol") == null || top.get("cha_vol").toString().isEmpty()){
							
							top.put("cha_vol", 0);
						}
					}
					returnMap.put("chaVolListTop", chaVolListTop);
				}
				
				
				if(chaVolListBottom != null && !chaVolListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : chaVolListBottom){
						
						if(bottom.get("cha_vol") == null || bottom.get("cha_vol").toString().isEmpty()){
							
							bottom.put("cha_vol", 0);
						}
					}
					returnMap.put("chaVolListBottom", chaVolListBottom);
				}
				
				//查询运维 前五 后五(充电有效小时数)
				List<Map<String, Object>> chaGenEffHourListTop = pwsStaDao.getChaGenEffHourRankByComTop5Opm(inputMap);
				
				List<Map<String, Object>> chaGenEffHourListBottom = pwsStaDao.getChaGenEffHourRankByComBottom5Opm(inputMap);
				
				if(chaGenEffHourListTop != null && !chaGenEffHourListTop.isEmpty()){
					
					for(Map<String, Object> top : chaGenEffHourListTop){
						
						if(top.get("cha_gen_eff_hours") == null || top.get("cha_gen_eff_hours").toString().isEmpty()){
							
							top.put("cha_gen_eff_hours", 0);
						}
					}
					returnMap.put("chaGenEffHourListTop", chaGenEffHourListTop);
				}
				
				
				if(chaGenEffHourListBottom != null && !chaGenEffHourListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : chaGenEffHourListBottom){
						
						if(bottom.get("cha_gen_eff_hours") == null || bottom.get("cha_gen_eff_hours").toString().isEmpty()){
							
							bottom.put("cha_gen_eff_hours", 0);
						}
					}
					returnMap.put("chaGenEffHourListBottom", chaGenEffHourListBottom);
				}
			}else if("2".equals(comUse.get("use_typ").toString())){
				//公司级别 2
				if("2".equals(comUse.get("com_lev").toString())){
					
					inputMap.put("com_fat_id",comUse.get("id").toString());
					
				}else if("3".equals(comUse.get("com_lev").toString())){
					
					inputMap.put("com_id", comUse.get("id").toString());
					
				}
				inputMap.put("pws_id", map.get("pws_id").toString());
				
				//查询业主 前五 后五(电量)
				List<Map<String, Object>> powerListTop = pwsStaDao.getPowerRankByComTop5Owner(inputMap);
				
				List<Map<String, Object>> powerListBottom = pwsStaDao.getPowerRankByComBottom5Owner(inputMap);
				
				if(powerListTop != null && !powerListTop.isEmpty()){
					
					for(Map<String, Object> top : powerListTop){
						
						if(top.get("power") == null || top.get("power").toString().isEmpty()){
							
							top.put("power", 0);
						}
					}
					returnMap.put("powerListTop", powerListTop);
				}
				

				if(powerListBottom != null && !powerListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : powerListBottom){
						
						if(bottom.get("power") == null || bottom.get("power").toString().isEmpty()){
							
							bottom.put("power", 0);
						}
					}
					returnMap.put("powerListBottom", powerListBottom);
				}
				
				//查询业主 前五 后五(故障数)
				List<Map<String, Object>> faultListTop = pwsStaDao.getFaultRankByComTop5Owner(inputMap);
				
				List<Map<String, Object>> faultListBottom = pwsStaDao.getFaultRankByComBottom5Owner(inputMap);
				
				if(faultListTop != null && !faultListTop.isEmpty()){
					
					for(Map<String, Object> top : faultListTop){
						
						if(top.get("fal_equ_num") == null || top.get("fal_equ_num").toString().isEmpty()){
							
							top.put("fal_equ_num", 0);
						}
					}
					returnMap.put("faultListTop", faultListTop);
				}
				

				if(faultListBottom != null && !faultListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : faultListBottom){
						
						if(bottom.get("fal_equ_num") == null || bottom.get("fal_equ_num").toString().isEmpty()){
							
							bottom.put("fal_equ_num", 0);
						}
					}
					returnMap.put("faultListBottom", faultListBottom);
				}
				
				//查询业主 前五 后五(发电有效小时数)
				List<Map<String, Object>> powGenEffHourListTop = pwsStaDao.getPowGenEffHourRankByComTop5Owner(inputMap);
				
				List<Map<String, Object>> powGenEffHourListBottom = pwsStaDao.getPowGenEffHourRankByComBottom5Owner(inputMap);
				
				if(powGenEffHourListTop != null && !powGenEffHourListTop.isEmpty()){
					
					for(Map<String, Object> top : powGenEffHourListTop){
						
						if(top.get("pow_gen_eff_hours") == null || top.get("pow_gen_eff_hours").toString().isEmpty()){
							
							top.put("pow_gen_eff_hours", 0);
						}
					}
					returnMap.put("powGenEffHourListTop", powGenEffHourListTop);
				}
				
				
				if(powGenEffHourListBottom != null && !powGenEffHourListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : powGenEffHourListBottom){
						
						if(bottom.get("pow_gen_eff_hours") == null || bottom.get("pow_gen_eff_hours").toString().isEmpty()){
							
							bottom.put("pow_gen_eff_hours", 0);
						}
					}
					returnMap.put("powGenEffHourListBottom", powGenEffHourListBottom);
				}
				
				//查询业主 前五 后五(充电量)
				List<Map<String, Object>> chaVolListTop = pwsStaDao.getChaVolRankByComTop5Owner(inputMap);
				
				List<Map<String, Object>> chaVolListBottom = pwsStaDao.getChaVolRankByComBottom5Owner(inputMap);
				
				if(chaVolListTop != null && !chaVolListTop.isEmpty()){
					
					for(Map<String, Object> top : chaVolListTop){
						
						if(top.get("cha_vol") == null || top.get("cha_vol").toString().isEmpty()){
							
							top.put("cha_vol", 0);
						}
					}
					returnMap.put("chaVolListTop", chaVolListTop);
				}
				
				
				if(chaVolListBottom != null && !chaVolListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : chaVolListBottom){
						
						if(bottom.get("cha_vol") == null || bottom.get("cha_vol").toString().isEmpty()){
							
							bottom.put("cha_vol", 0);
						}
					}
					returnMap.put("chaVolListBottom", chaVolListBottom);
				}
				
				//查询业主 前五 后五(充电有效小时数)
				List<Map<String, Object>> chaGenEffHourListTop = pwsStaDao.getChaGenEffHourRankByComTop5Owner(inputMap);
				
				List<Map<String, Object>> chaGenEffHourListBottom = pwsStaDao.getChaGenEffHourRankByComBottom5Owner(inputMap);
				
				if(chaGenEffHourListTop != null && !chaGenEffHourListTop.isEmpty()){
					
					for(Map<String, Object> top : chaGenEffHourListTop){
						
						if(top.get("cha_gen_eff_hours") == null || top.get("cha_gen_eff_hours").toString().isEmpty()){
							
							top.put("cha_gen_eff_hours", 0);
						}
					}
					returnMap.put("chaGenEffHourListTop", chaGenEffHourListTop);
				}
				
				
				if(chaGenEffHourListBottom != null && !chaGenEffHourListBottom.isEmpty()){
					
					for(Map<String, Object> bottom : chaGenEffHourListBottom){
						
						if(bottom.get("cha_gen_eff_hours") == null || bottom.get("cha_gen_eff_hours").toString().isEmpty()){
							
							bottom.put("cha_gen_eff_hours", 0);
						}
					}
					returnMap.put("chaGenEffHourListBottom", chaGenEffHourListBottom);
				}
			}
		}
		
		returnLst.add(returnMap);
		
		return returnLst;
	}
}
