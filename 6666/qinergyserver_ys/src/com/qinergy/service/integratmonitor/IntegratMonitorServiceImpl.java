/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.integratmonitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.IntegratMonitorDao;
import com.qinergy.dao.system.SystemDao;
import com.qinergy.dao.utils.UtilsDao;
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
public class IntegratMonitorServiceImpl implements IntegratMonitorService {

	@Autowired
	private IntegratMonitorDao integratMonitorDao;
	
	@Autowired
	private SystemDao systemDao;
	
	@Autowired
	private UtilsDao utilsDao;
	

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getComInfByFatId(Map<String, Object> map)
			throws Exception {

		return integratMonitorDao.getComInfByFatId(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void delComInf(Map<String, Object> map) throws Exception {

		integratMonitorDao.delComInf(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void delDepInf(Map<String, Object> map) throws Exception {

		integratMonitorDao.delDepInf(map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getComInfById(Map<String, Object> map)
			throws Exception {

		return integratMonitorDao.getComInfById(map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getRegInf(Map<String, Object> map)
			throws Exception {

		return integratMonitorDao.getRegInf(map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getAllManInf() throws Exception {

		return integratMonitorDao.getAllManInf();
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getAllAppModInf(Map<String, Object> map)
			throws Exception {

		return integratMonitorDao.getAllAppModInf(map);
	}


	/*
	 * ########################################## 综合监控中与站有关的所有接口Start
	 * ##########################################
	 */

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPwsAllAppTypByPwsId(
			Map<String, Object> map) throws Exception {

		return integratMonitorDao.getPwsAllAppTypByPwsId(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPwsInfByPwsId(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		// 1.获取电站详情信息中的电站基本信息
		List<Map<String, Object>> pwsInfLst = integratMonitorDao.getPwsInfByPwsId(map);
		
		returnMap.put("pwsInfLst", pwsInfLst);
		// 2.获取电站详情信息中的图片信息
		
		List<Map<String, Object>> pwsPicInfLst = integratMonitorDao.getPwsPicLstByPwsId(map);
		
		returnMap.put("pwsPicInfLst", pwsPicInfLst);
		// 3.获取电站详情信息中的光、储、充、负荷功率曲线
		
		SimpleDateFormat sdfm = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdfm.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> pvPcChaLoadLineInfCurLst = integratMonitorDao.getPvPcChaLoadLineInfLstByPwsId(map);
		
		List<Map<String, Object>> pvPcChaLoadLineInfLst = DateUtil.getFifteenMinutesCurves(crtTim, pvPcChaLoadLineInfCurLst);
		
		List<Map<String, Object>> pvPcChaLoadLineInfTop1Lst = integratMonitorDao.getPvPcChaLoadLineInfByPwsIdTop1(map);
		
		returnMap.put("pvPcChaLoadLineInfLst", pvPcChaLoadLineInfLst);
		
		returnMap.put("pvPcChaLoadLineInfTop1Lst", pvPcChaLoadLineInfTop1Lst);
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(new Date());
		
		// 获取到查询年1月1日0点0分0秒的时间
		String date = sdf.format(new Date());
		
		List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(date, "2");
		
		List<Map<String, Object>> pvPcChaLodMonPowerLst = new ArrayList<Map<String,Object>>();
		
		for(Map<String, Object> dayMonYearTimMap : dayMonYearTimLst){
			
			map.put("sta_tim", dayMonYearTimMap.get("staTim"));
			
			map.put("end_tim", dayMonYearTimMap.get("endTim"));
			// 通过电站ID获取光伏月发电量柱状图
			List<Map<String, Object>> monPowerLst = integratMonitorDao.getMonPowerLstByPwsId(map);
			// 通过电站ID获取月充放电量柱状图
			List<Map<String, Object>> monNetPowerLst = integratMonitorDao.getMonNetPowerLstByPwsId(map);
			// 通过电站ID获取月馈网电量柱状图
			List<Map<String, Object>> monPcsLst = integratMonitorDao.getMonPcsLstByPwsId(map);
			// 通过电站ID获取充电桩充电量柱状图
			List<Map<String, Object>> monChaLst = integratMonitorDao.getMonChaLstByPwsId(map);
			// 通过电站ID获取负荷用电量柱状图
			List<Map<String, Object>> monEleConLst = integratMonitorDao.getMonEleConLstByPwsId(map);
		
			Map<String, Object> pvPcChaLodMonPowerMap = new HashMap<String,Object>();
			
			// 5.获取月发电量柱状图
			if(monPowerLst != null && !monPowerLst.isEmpty()){
				
				for(Map<String, Object> monPowerMap:monPowerLst){
					
					if(monPowerMap != null && monPowerMap.get("power") != null && !monPowerMap.get("power").toString().isEmpty()){
						
						pvPcChaLodMonPowerMap.put("power", monPowerMap.get("power"));
					}
				}
			}
			
			// 4.获取并网电量柱状图
			if(monNetPowerLst != null && !monNetPowerLst.isEmpty()){
				
				for(Map<String, Object> monNetPowerMap:monNetPowerLst){
					
					if(monNetPowerMap != null && monNetPowerMap.get("feed_net_power") != null && !monNetPowerMap.get("feed_net_power").toString().isEmpty()){
						
						pvPcChaLodMonPowerMap.put("feed_net_power", monNetPowerMap.get("feed_net_power"));
					}

					if(monNetPowerMap != null && monNetPowerMap.get("ipt_power") != null && !monNetPowerMap.get("ipt_power").toString().isEmpty()){
						
						pvPcChaLodMonPowerMap.put("ipt_power", monNetPowerMap.get("ipt_power"));
					}
				}
			}

			// 7.获取储能充放电量柱状图
			if(monPcsLst != null && !monPcsLst.isEmpty()){
				
				for(Map<String, Object> monPcsMap:monPcsLst){
					
					if(monPcsMap != null && monPcsMap.get("phi") != null && !monPcsMap.get("phi").toString().isEmpty()){
						
						pvPcChaLodMonPowerMap.put("phi", monPcsMap.get("phi"));
					}
					
					if(monPcsMap != null && monPcsMap.get("phe") != null && !monPcsMap.get("phe").toString().isEmpty()){
						
						pvPcChaLodMonPowerMap.put("phe", monPcsMap.get("phe"));
					}
				}
			}
			
			// 8.获取充电桩月充电量柱状图
			if(monChaLst != null && !monChaLst.isEmpty()){
				
				for(Map<String, Object> monChaMap:monChaLst){
					
					if(monChaMap != null && monChaMap.get("cha_vol") != null && !monChaMap.get("cha_vol").toString().isEmpty()){
						
						pvPcChaLodMonPowerMap.put("cha_vol", monChaMap.get("cha_vol"));
					}
				}
			}
			
			// 9.负荷系统用电量柱状图
			if(monEleConLst != null && !monEleConLst.isEmpty()){
				
				for(Map<String, Object> monEleConMap:monEleConLst){
					
					if(monEleConMap != null && monEleConMap.get("ele_con") != null && !monEleConMap.get("ele_con").toString().isEmpty()){
						
						pvPcChaLodMonPowerMap.put("ele_con", monEleConMap.get("ele_con"));
					}
				}
			}
			
			pvPcChaLodMonPowerMap.put("tol_tim", map.get("sta_tim"));
			
			pvPcChaLodMonPowerLst.add(pvPcChaLodMonPowerMap);
		}
		
		returnMap.put("pvPcChaLodMonPowerLst", pvPcChaLodMonPowerLst);
		
		// 获取光伏预测功率曲线
		List<Map<String, Object>> pvFctPowerCurvesLst = integratMonitorDao.getPvFctPowerCurvesLstByPwsId(map);
		
		List<Map<String, Object>> pvFctPowerLst = new ArrayList<Map<String,Object>>();
		
		if(pvFctPowerCurvesLst != null && !pvFctPowerCurvesLst.isEmpty()){
			
			String fct_value = "fct_value";
			
			for(Map<String, Object> pvFctPowerCurvesMap : pvFctPowerCurvesLst){
				
				String day = sdf.format(sdf.parse(pvFctPowerCurvesMap.get("tol_tim").toString()));
				
				for(int i = 0 ; i< 96 ; i++){
					
					Map<String, Object> pvFctPowerMap = new HashMap<String, Object>();
					
					String min = "";
					
					int hour = i/4;
					
					String tol_tim = "";
					
					if(i%4 == 1){
						
						min = ":15:00";
						
					}else if(i%4 == 2){
						
						min = ":30:00";
						
					}else if(i%4 == 3){
						
						min = ":45:00";
						
					}else if(i%4 == 0){
						
						min = ":00:00";
					}
					
					tol_tim = day+hour+min;
					
					pvFctPowerMap.put("tol_tim", tol_tim);
					
					pvFctPowerMap.put("pv_fct_power", pvFctPowerCurvesMap.get(fct_value+(i+1)));
					
					pvFctPowerLst.add(pvFctPowerMap);
				}
			}
		}
		
		returnMap.put("pvFctPowerLst", pvFctPowerLst);
		
		// 获取调度功率曲线
		List<Map<String, Object>> schPowerCurvesLst = integratMonitorDao.getSchPowerCurvesLstByPwsId(map);
		
		List<Map<String, Object>> schPowerLst = new ArrayList<Map<String,Object>>();
		
		if(schPowerCurvesLst != null && !schPowerCurvesLst.isEmpty()){
			
			String fct_value = "fct_value";
			
			for(Map<String, Object> schPowerCurvesMap : schPowerCurvesLst){
				
				String day = sdf.format(sdf.parse(schPowerCurvesMap.get("tol_tim").toString()));
				
				for(int i = 0 ; i< 96 ; i++){
					
					Map<String, Object> schPowerMap = new HashMap<String, Object>();
					
					String min = "";
					
					int hour = i/4;
					
					String tol_tim = "";
					
					if(i%4 == 1){
						
						min = ":15:00";
						
					}else if(i%4 == 2){
						
						min = ":30:00";
						
					}else if(i%4 == 3){
						
						min = ":45:00";
						
					}else if(i%4 == 0){
						
						min = ":00:00";
					}
					
					tol_tim = day+hour+min;
					
					schPowerMap.put("tol_tim", tol_tim);
					
					schPowerMap.put("sch_power", schPowerCurvesMap.get(fct_value+(i+1)));
					
					schPowerLst.add(schPowerMap);
				}
			}
		}
		returnMap.put("schPowerLst", schPowerLst);
		
		// 6.获取光伏发电曲线
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> hvRealPowerCurLst = integratMonitorDao.getHvRealPowerCurvesLstByPwsId(map);
		
		List<Map<String, Object>> hvRealPowerLst = DateUtil.getFifteenMinutesCurves(crtTim, hvRealPowerCurLst);
				
		returnMap.put("hvRealPowerLst", hvRealPowerLst);
		
		// 10.获取电站详情页面中的单个数据
		List<Map<String, Object>> pwsInfTolTop1Lst = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> pwsInfTolTop1Map = new HashMap<String,Object>();
		
		// 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(馈网)
		List<Map<String, Object>> pwsInfTolTop1NetWorkLst = integratMonitorDao.getPwsInfTolTop1LstByPwsIdNewWork(map);
		
		// 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(光伏)(累计)
		List<Map<String, Object>> pwsInfTolTop1PVSLstTol = integratMonitorDao.getPwsInfTolTop1LstByPwsIdPVS(map);
		
		// 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(光伏)(日)
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		
		List<Map<String, Object>> pwsInfTolTop1PVSLstDay = integratMonitorDao.getPwsInfTolTop1LstByPwsIdPVS(map);
		
		// 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(光伏)(月)
		
		Calendar cale = Calendar.getInstance();
		
		cale.setTime(new Date());
        
        int year = cale.get(Calendar.YEAR);
        
        int month = cale.get(Calendar.MONTH) + 1;
        
        map.put("sta_tim", DateUtil.getYearMonthDayString(year, month, 1));
        
        map.put("end_tim", DateUtil.addMonth(DateUtil.getYearMonthDayString(year, month, 1)));
        
		List<Map<String, Object>> pwsInfTolTop1PVSLstMon = integratMonitorDao.getPwsInfTolTop1LstByPwsIdPVS(map);
		
		// 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(光伏)(年)
		map.put("sta_tim", DateUtil.getYearMonthDayString(year, 1, 1));
		
		map.put("end_tim", DateUtil.getYearMonthDayString(year+1, 1, 1));
		
		List<Map<String, Object>> pwsInfTolTop1PVSLstYea = integratMonitorDao.getPwsInfTolTop1LstByPwsIdPVS(map);
		
		// 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(储能逆变器)
		List<Map<String, Object>> pwsInfTolTop1PCSLst = integratMonitorDao.getPwsInfTolTop1LstByPwsIdPCS(map);
		
		// 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(充电桩)
		List<Map<String, Object>> pwsInfTolTop1ChpLst = integratMonitorDao.getPwsInfTolTop1LstByPwsIdChp(map);
		
		// 通过电站ID获取电站详情页面中的所有详细当前统计数据信息(负荷)
		List<Map<String, Object>> pwsInfTolTop1LoadLst = integratMonitorDao.getPwsInfTolTop1LstByPwsIdLoad(map);
		
		if(pwsInfTolTop1NetWorkLst != null && !pwsInfTolTop1NetWorkLst.isEmpty()){
			
			for(Map<String, Object> pwsInfTolTop1NetWorkMap:pwsInfTolTop1NetWorkLst){
				
				pwsInfTolTop1Map.put("tol_feed_net_power", pwsInfTolTop1NetWorkMap.get("tol_feed_net_power"));
				
				pwsInfTolTop1Map.put("tol_ipt_power", pwsInfTolTop1NetWorkMap.get("tol_ipt_power"));
			}
		}
		
		if(pwsInfTolTop1PVSLstTol != null && !pwsInfTolTop1PVSLstTol.isEmpty()){
			
			for(Map<String, Object> pwsInfTolTop1PVSMap:pwsInfTolTop1PVSLstTol){
				
				pwsInfTolTop1Map.put("tol_power", pwsInfTolTop1PVSMap.get("tol_power"));
			}
		}
		
		if(pwsInfTolTop1PVSLstDay != null && !pwsInfTolTop1PVSLstDay.isEmpty()){
			
			for(Map<String, Object> pwsInfTolTop1PVSMap:pwsInfTolTop1PVSLstDay){
				
				pwsInfTolTop1Map.put("power", pwsInfTolTop1PVSMap.get("power"));
				
			}
		}
		
		if(pwsInfTolTop1PVSLstMon != null && !pwsInfTolTop1PVSLstMon.isEmpty()){
			
			for(Map<String, Object> pwsInfTolTop1PVSMap:pwsInfTolTop1PVSLstMon){
				
				pwsInfTolTop1Map.put("mon_power", pwsInfTolTop1PVSMap.get("mon_power"));
				
			}
		}
		
		if(pwsInfTolTop1PVSLstYea != null && !pwsInfTolTop1PVSLstYea.isEmpty()){
			
			for(Map<String, Object> pwsInfTolTop1PVSMap:pwsInfTolTop1PVSLstYea){
				
				pwsInfTolTop1Map.put("year_power", pwsInfTolTop1PVSMap.get("year_power"));
				
				pwsInfTolTop1Map.put("year_plan_com_rate", pwsInfTolTop1PVSMap.get("year_plan_com_rate"));
			}
		}
		
		if(pwsInfTolTop1PCSLst != null && !pwsInfTolTop1PCSLst.isEmpty()){
			
			for(Map<String, Object> pwsInfTolTop1PCSMap:pwsInfTolTop1PCSLst){
				
				pwsInfTolTop1Map.put("tol_phi", pwsInfTolTop1PCSMap.get("tol_phi"));
				
				pwsInfTolTop1Map.put("tol_phe", pwsInfTolTop1PCSMap.get("tol_phe"));
			}
		}
		
		if(pwsInfTolTop1ChpLst != null && !pwsInfTolTop1ChpLst.isEmpty()){
			
			for(Map<String, Object> pwsInfTolTop1ChpMap:pwsInfTolTop1ChpLst){
				
				pwsInfTolTop1Map.put("tol_cha_vol", pwsInfTolTop1ChpMap.get("tol_cha_vol"));
				
				pwsInfTolTop1Map.put("tol_cha_tim", pwsInfTolTop1ChpMap.get("tol_cha_tim"));
				
				pwsInfTolTop1Map.put("tol_cha_gen_eff_hours", pwsInfTolTop1ChpMap.get("tol_cha_gen_eff_hours"));
			}
		}
		
		if(pwsInfTolTop1LoadLst != null && !pwsInfTolTop1LoadLst.isEmpty()){
			
			for(Map<String, Object> pwsInfTolTop1LoadMap:pwsInfTolTop1LoadLst){
				
				pwsInfTolTop1Map.put("tol_ele_con", pwsInfTolTop1LoadMap.get("tol_ele_con"));
			}
		}
		
		pwsInfTolTop1Lst.add(pwsInfTolTop1Map);
		
		returnMap.put("pwsInfTolTop1Lst", pwsInfTolTop1Lst);
		
		// 11.获取计划发电量月数据、年数据
		
		String sta_tim = "";
		
		String end_tim = "";
		
		// 获取月计划发电量数据
		// 获取到查询月1日0点0分0秒的时间
		
		sta_tim = DateUtil.getYearMonthDayString(year, month, 1);
		// 获取到查询月下一月1日0点0分0秒的时间
		end_tim = DateUtil.addMonth(sta_tim);
		
		map.put("sta_tim", sta_tim);
		
		map.put("end_tim", end_tim);
		
		List<Map<String, Object>> pwsPlanMonPowerLst = integratMonitorDao.getPwsPlanMonYearPowerLstByPwsId(map);
			
		if(pwsPlanMonPowerLst != null && pwsPlanMonPowerLst.get(0) != null){
			
			
			returnMap.put("pwsPlanMonPowerLst", pwsPlanMonPowerLst);
		}
		
			
		// 获取年计划发电量数据
		
		
		// 获取到查询年1月1日0点0分0秒的时间
		sta_tim = DateUtil.getYearMonthDayString(year, 1, 1);
		// 获取到查询年下一年1月1日0点0分0秒的时间
		end_tim = DateUtil.getYearMonthDayString(year+1, 1, 1);
		
		map.put("sta_tim", sta_tim);
		
		map.put("end_tim", end_tim);
		
		List<Map<String, Object>> pwsPlanYearPowerLst = integratMonitorDao.getPwsPlanMonYearPowerLstByPwsId(map);
		
		if(pwsPlanYearPowerLst != null && pwsPlanYearPowerLst.get(0) != null){
			
			returnMap.put("pwsPlanYearPowerLst", pwsPlanYearPowerLst);
		}
		
		returnLst.add(returnMap);
		
		return returnLst;
	}


	/*
	 * ########################################## 综合监控中与站有关的所有接口End
	 * ##########################################
	 */

	/**
	 * 获取某电站中 某种设备 所有设备编号 （所有设备通用接口）
	 */
	@Override
	public List<Map<String, Object>> getEquNumLstByPwsEquTyp(
			Map<String, Object> map) throws Exception {
		
		return integratMonitorDao.getEquNumLstByPwsEquTyp(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getEquStaticInfByNum(Map<String, Object> map)
			throws Exception {
		return integratMonitorDao.getEquStaticInfByNum(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getDeflInfByEquNum(Map<String, Object> map) throws Exception {
		
		return integratMonitorDao.getDeflInfByEquNum(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getDeflInfByEquNumCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> couLst = integratMonitorDao.getDeflInfByEquNumCou(map);
		
		if (couLst != null && couLst.size() > 0) {
			
			for (Map<String, Object> couMap : couLst) {
				
				return couMap;
			}
		}
		return null;
	}

}
