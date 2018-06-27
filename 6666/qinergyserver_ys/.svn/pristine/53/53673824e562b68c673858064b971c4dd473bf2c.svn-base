/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.others;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.IntegratMonitorDao;
import com.qinergy.dao.integratmonitor.acchp.AcchpDao;
import com.qinergy.dao.integratmonitor.ctl.CtlDao;
import com.qinergy.dao.integratmonitor.dcchp.DcchpDao;
import com.qinergy.dao.integratmonitor.dctdev.DctdevDao;
import com.qinergy.dao.integratmonitor.lneptt.LnepttDao;
import com.qinergy.dao.integratmonitor.pcs.PcsDao;
import com.qinergy.dao.integratmonitor.pvs.PvsDao;
import com.qinergy.dao.others.OthersDao;
import com.qinergy.dao.statisticanalysis.analysis.EfficAnalysisDao;
import com.qinergy.dao.system.SystemDao;
import com.qinergy.dao.utils.UtilsDao;
import com.qinergy.util.DateUtil;

/**
 * 其它类型接口实现类(包含共用型接口)
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

@Service
public class OthersServiceImpl implements OthersService {

	@Autowired
	OthersDao othersDao;
	
	@Autowired
	UtilsDao utilsDao;
	
	@Autowired
	CtlDao ctlDao;
	
	@Autowired
	DctdevDao dctdevDao;
	
	@Autowired
	LnepttDao lnepttDao;
	
	@Autowired
	IntegratMonitorDao integratMonitorDao;
	
	@Autowired
	EfficAnalysisDao analysisDao;
	
	@Autowired
	PvsDao pvsDao;
	
	@Autowired
	PcsDao pcsDao;
	
	@Autowired
	AcchpDao acchpDao;
	
	@Autowired
	DcchpDao dcchpDao;

	
	/*------------------------------------考核管理Start------------------------------------*/
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPwsAssMagInfByPwsId(Map<String, Object> map) throws Exception {
		// 时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);// 格式化为年月
		
		Calendar calendar = Calendar.getInstance();
		// 将时间转换成时间戳
		if(map != null && map.get("date") != null && !map.get("date").toString().isEmpty()){
			
			calendar.setTime(sdf.parse(map.get("date").toString()));
			
		}else{
			
			calendar.setTime(new Date());
		}
		// 获取年
		int year = calendar.get(Calendar.YEAR);
		// 获取月
		int month = calendar.get(Calendar.MONTH)+1;
		// 获取某年某月1日的时间
		String sta_tim = DateUtil.getYearMonthDayString(year, month, 1);
		// 获取到查询月下一月1日0点0分0秒的时间
		String end_tim = DateUtil.addMonth(sta_tim);
		
		map.put("sta_tim", sta_tim);
		
		map.put("end_tim", end_tim);
		
		// 通过电站ID获取考核管理页面中除了12个月考核评分外的所有数据
		List<Map<String, Object>> pwsAssMagInfLst = othersDao.getPwsAssMagInfByPwsId(map);
		
		List<Map<String, Object>> dayMonYearTimLst = new ArrayList<Map<String,Object>>();
		
		if(map != null && map.get("date") != null && !map.get("date").toString().isEmpty()){
			// 获取某年、月、日起始和结束时间点集合
			dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("date").toString(),"3");
			
		}else{
			// 获取某年、月、日起始和结束时间点集合
			dayMonYearTimLst = DateUtil.getDayMonYearTimLst(sdf.format(new Date()),"3");
		}
		
		List<Map<String,Object>> assLst = new ArrayList<Map<String,Object>>();
		// 非空判断
		if (pwsAssMagInfLst == null || pwsAssMagInfLst.isEmpty()) {
			
			pwsAssMagInfLst = new ArrayList<Map<String,Object>>();
			
			Map<String,Object> pwsAssMagInfMap = new HashMap<String, Object>();
			
			pwsAssMagInfLst.add(pwsAssMagInfMap);
			
		}
		// 遍历考核评分集合
		for(Map<String,Object> pwsAssMagInfMap:pwsAssMagInfLst){
			
			if (dayMonYearTimLst != null && !dayMonYearTimLst.isEmpty()) {
				// 遍历设备信息列表（当前站内的所有设备信息列表）
				for (Map<String, Object> dayMonYearTimMap : dayMonYearTimLst) {
					
					Map<String,Object> assMap = new HashMap<String,Object>();
					
					map.put("sta_tim",dayMonYearTimMap.get("staTim"));
					
					map.put("end_tim",dayMonYearTimMap.get("endTim"));
					// 通过电站ID获取考核管理页面中12个月考核评分的所有数据 
					List<Map<String, Object>> pwsAssMagLst = othersDao.getPwsAssMagLstByPwsId(map);
					// 非空判断
					if(pwsAssMagLst != null && !pwsAssMagLst.isEmpty() && pwsAssMagLst.get(0) != null){
						// 获取评分
						assMap.put("ass_score", pwsAssMagLst.get(0).get("ass_score"));
					}
					// 获取统计时间 
					assMap.put("tol_tim", dayMonYearTimMap.get("staTim"));
					
					assLst.add(assMap);
				}
			}
			pwsAssMagInfMap.put("pwsAssMagLst", assLst);
		}
		
		return pwsAssMagInfLst;
	}
	
	/*------------------------------------考核管理End------------------------------------*/
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIntEquOpeInf(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
				
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 获取最后检修日期
		List<Map<String, Object>> lastOverhaulLst = othersDao.getLastOverhaulDate(map);
		// 非空判断
		if(lastOverhaulLst != null && !lastOverhaulLst.isEmpty() && lastOverhaulLst.get(0) != null){
			
			retMap.put("lastOverhaulLst", lastOverhaulLst);
		}
		
		// 获取最后维修日期
		List<Map<String, Object>> lasMaintenanceLst = othersDao.getLasMaintenanceDate(map);
		// 非空判断
		if(lasMaintenanceLst != null && !lasMaintenanceLst.isEmpty() && lasMaintenanceLst.get(0) != null){
			
			retMap.put("lasMaintenanceLst", lasMaintenanceLst);
		}
		// 获取下次检修日期
		List<Map<String, Object>> nextOverhaulLst = othersDao.getNextOverhaulDate(map);
		// 非空判断
		if(nextOverhaulLst != null && !nextOverhaulLst.isEmpty() && nextOverhaulLst.get(0) != null){
			
			retMap.put("nextOverhaulLst", nextOverhaulLst);
		}
		
		List<Map<String, Object>> relLst = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> relMap = new HashMap<String,Object>();
		// 获取某设备实时的告警信息
		List<Map<String, Object>> relFauLst = othersDao.getRelFauLst(map);
		// 对告警信息进行非空判断
		if(relFauLst != null && !relFauLst.isEmpty() && relFauLst.get(0) != null){
			// 遍历告警信息
			for(Map<String, Object> relFauMap:relFauLst){
				// 判断告警类型
				if(relFauMap.get("fau_level").toString().equals("1")){
					
					relMap.put("info", "告警");
					
				}else if(relFauMap.get("fau_level").toString().equals("2")){
					
					relMap.put("info", "故障");
					
					break;
					
				}else{
					
					relMap.put("info", "正常");
				}
			}
		}else{
			
			relMap.put("info", "正常");
		}
		
		relLst.add(relMap);
		// 对数据返回集合进行非空判断
		if(relLst != null && !relLst.isEmpty() && relLst.get(0) != null){
			
			retMap.put("alaStaLst", relLst);
		}
		// 获取累计维修次数
		List<Map<String, Object>> tolMaintenanceCountLst = othersDao.getTolMaintenanceCount(map);
		// 非空判断
		if(tolMaintenanceCountLst != null && !tolMaintenanceCountLst.isEmpty() && tolMaintenanceCountLst.get(0) != null){
			
			retMap.put("tolMaintenanceCountLst", tolMaintenanceCountLst);
		}
		
		retLst.add(retMap);
		// 返回数据
		return retLst;
	}
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAlaHistoryLst(Map<String, Object> map) throws Exception {
		
		return othersDao.getAlaHistoryLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAlaSta(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> relLst = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> relMap = new HashMap<String,Object>();
		//获取某设备实时的告警信息
		List<Map<String, Object>> relFauLst = othersDao.getRelFauLst(map);
		// 非空判断
		if(relFauLst != null && !relFauLst.isEmpty() && relFauLst.get(0) != null){
			// 获取的结果循环遍历
			for(Map<String, Object> relFauMap:relFauLst){
				// 判断告警级别,1为告警,2为故障,其它为正常
				if(relFauMap.get("fau_level").toString().equals("1")){
					
					relMap.put("info", "告警");
					
				}else if(relFauMap.get("fau_level").toString().equals("2")){
					
					relMap.put("info", "故障");
					
					break;
					
				}else{
					
					relMap.put("info", "正常");
				}
			}
		}
		
		relLst.add(relMap);
		
		return relLst;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getAlaHistoryLstCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> retLst = othersDao.getAlaHistoryLstCou(map);
		// 非空判断
		if (retLst != null && retLst.size() > 0) {
			// 取出集合中的元素,并返回
			for (Map<String, Object> retMap : retLst) {

				return retMap;
			}
		}
		return null;
	}	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMaintenanceLst(Map<String, Object> map) throws Exception {
		
		return othersDao.getMaintenanceLst(map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getMaintenanceLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = othersDao.getMaintenanceLstCou(map);
		// 非空判断
		if (retLst != null && retLst.size() > 0) {
			// 取出集合中的元素,并返回
			for (Map<String, Object> retMap : retLst) {
				
				return retMap;
			}
		}
		return null;
	}	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getOverhaulLst(Map<String, Object> map) throws Exception {
		
		return othersDao.getOverhaulLst(map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getOverhaulLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = othersDao.getOverhaulLstCou(map);
		// 非空判断
		if (retLst != null && retLst.size() > 0) {
			// 取出集合中的元素,并返回
			for (Map<String, Object> retMap : retLst) {
				
				return retMap;
			}
		}
		return null;
	}	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getNoticeInfByUseId(Map<String, Object> map) throws Exception {
		
		return othersDao.getSysAlarmByUseId(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updNoticeState(Map<String, Object> map) throws Exception {
		
		othersDao.updNoticeState(map);
	}
	/*-------------------------------------以下为与公告有关的所有接口-------------------------------------*/
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void insAnnInf(Map<String, Object> map) throws Exception {
		
		othersDao.insAnnInf(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updAnnInf(Map<String, Object> map) throws Exception {
		
		othersDao.updAnnInf(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void delAnnInf(Map<String, Object> map) throws Exception {
		
		othersDao.delAnnInf(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAnnInfById(Map<String, Object> map) throws Exception {
		
		return othersDao.getAnnInfById(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAnnInfLst(Map<String, Object> map) throws Exception {
		
		return othersDao.getAnnInfLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getAnnInfLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = othersDao.getAnnInfLstCou(map);
		// 非空判断
		if (retLst != null && retLst.size() > 0) {
			// 取出集合中的元素,并返回
			for (Map<String, Object> retMap : retLst) {
				
				return retMap;
			}
		}
		return null;
	}	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getFstPagOptInf(Map<String, Object> map) throws Exception {
		// 查询出总缺陷数
		List<Map<String, Object>> defCouLst = othersDao.getFstPagOptInf(map);
		
		HashMap<String, Object> retMap = new HashMap<String,Object>();
		
		map.put("check_sta", 5);
		// 查询出总消缺数
		List<Map<String, Object>> elmDefCouLst = othersDao.getFstPagOptInf(map);
		
		// 缺陷数
		Integer defCou = 0;
		// 消缺数
		Integer elmDefCou = 0;
		// 消缺率
		String elmDefRate = "0.0";
		// 对查询回的缺陷数进行非空判断
		if(defCouLst != null && !defCouLst.isEmpty() && defCouLst.get(0) != null){
			
			for(Map<String, Object> defCouMap : defCouLst){
				// 对缺陷数进行累加计算
				defCou = Integer.valueOf(defCouMap.get("defCou").toString());
				
			}
		}
		// 对查询回的消缺数进行非空判断
		if(elmDefCouLst != null && !elmDefCouLst.isEmpty() && elmDefCouLst.get(0) != null){
			
			for(Map<String, Object> elmDefCouMap : elmDefCouLst){
				// 对消缺数进行累加计算
				elmDefCou = Integer.valueOf(elmDefCouMap.get("defCou").toString());
			}
		}
		// 统计消缺率,如果缺陷数大于0,消缺数大于0
		if(defCou > 0 && elmDefCou>0){
			//对返回的数字进行保留4位小数的格式化
			DecimalFormat df = new DecimalFormat("######0.0000");   
			
			elmDefRate = df.format((elmDefCou*1.00)/(defCou*1.00));
		}
		
		
		retMap.put("defCou", defCou);
		
		retMap.put("elmDefCou", elmDefCou);
		
		retMap.put("elmDefRate", elmDefRate);
		
		return retMap;
	}	
	
	/*-------------------------------------以下为与计划充放电量有关的所有接口-------------------------------------*/
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void insPlanPhiPhe(Map<String, Object> map) throws Exception {
		
		othersDao.insPlanPhiPhe(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updPlanPhiPhe(Map<String, Object> map) throws Exception {
		
		othersDao.updPlanPhiPhe(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void delPlanPhiPheInf(Map<String, Object> map) throws Exception {
		
		othersDao.delPlanPhiPheInf(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPlanPhiPheInfById(Map<String, Object> map) throws Exception {
		
		return othersDao.getPlanPhiPheInfById(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPlanPhiPheLst(Map<String, Object> map) throws Exception {
		
		return othersDao.getPlanPhiPheLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getPlanPhiPheLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = othersDao.getPlanPhiPheLstCou(map);
		
		if (retLst != null && retLst.size() > 0) {
			
			for (Map<String, Object> retMap : retLst) {
				
				return retMap;
			}
		}
		return null;
	}
	/*-------------------------------------以下为与理论发电量有关的所有接口-------------------------------------*/
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void insFsbPower(Map<String, Object> map) throws Exception {
		
		othersDao.insFsbPower(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updFsbPower(Map<String, Object> map) throws Exception {
		
		othersDao.updFsbPower(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void delFsbPowerInf(Map<String, Object> map) throws Exception {
		
		othersDao.delFsbPowerInf(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFsbPowerInfById(Map<String, Object> map) throws Exception {
		
		return othersDao.getFsbPowerInfById(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFsbPowerLst(Map<String, Object> map) throws Exception {
		
		return othersDao.getFsbPowerLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getFsbPowerLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = othersDao.getFsbPowerLstCou(map);
		
		if (retLst != null && retLst.size() > 0) {
			
			for (Map<String, Object> retMap : retLst) {
				
				return retMap;
			}
		}
		return null;
	}
	
	/*-------------------------------------以下为与理论辐射量有关的所有接口-------------------------------------*/
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void insFsbHv(Map<String, Object> map) throws Exception {
		
		othersDao.insFsbHv(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updFsbHv(Map<String, Object> map) throws Exception {
		
		othersDao.updFsbHv(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void delFsbHvInf(Map<String, Object> map) throws Exception {
		
		othersDao.delFsbHvInf(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFsbHvInfById(Map<String, Object> map) throws Exception {
		
		return othersDao.getFsbHvInfById(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFsbHvLst(Map<String, Object> map) throws Exception {
		
		return othersDao.getFsbHvLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getFsbHvLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = othersDao.getFsbHvLstCou(map);
		
		if (retLst != null && retLst.size() > 0) {
			
			for (Map<String, Object> retMap : retLst) {
				
				return retMap;
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<Map<String, Object>> selPvPlanPower(Map<String, Object> map)
			throws Exception {
		return othersDao.selPvPlanPower(map);
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, Object> selPvPlanPowerCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = othersDao.selPvPlanPowerCou(map);

		if (retLst != null && retLst.size() > 0) {

			for (Map<String, Object> retMap : retLst) {

				return retMap;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void insOrUpdPvPlanPower(Map<String, Object> map) throws Exception {

		// 电量计划 光伏计划发电量表 增加 或修改
		if (map.get("id") != null && !map.get("id").equals(0)) {

			Map<String, Object> powerMap = new HashMap<String, Object>();
			// ID
			powerMap.put("id", map.get("id"));
			// 电站ID
			powerMap.put("pws_id", map.get("pws_id"));
			// 计划发电量
			powerMap.put("plan_power", map.get("plan_power"));
			// 计划时间
			powerMap.put("plan_tim", map.get("plan_tim"));
			// 修改时间
			powerMap.put("mod_tim", new Date());
			// 修改人ID
			powerMap.put("mod_use_id", map.get("mod_use_id"));
			// 电量计划 光伏计划发电量表 修改
			othersDao.updPvPlanPower(map);
		} else {

			Map<String, Object> powerMap = new HashMap<String, Object>();
			// 电站ID
			powerMap.put("pws_id", map.get("pws_id"));
			// 计划发电量
			powerMap.put("plan_power", map.get("plan_power"));
			// 计划时间
			powerMap.put("plan_tim", map.get("plan_tim"));
			// 创建时间
			powerMap.put("crt_tim", new Date());
			// 创建人ID
			powerMap.put("crt_use_id", map.get("crt_use_id"));
			// 电量计划 光伏计划发电量表 增加
			othersDao.insPvPlanPower(powerMap);
		}
	}
		
	/**
	 * 使用某条计划发电量ID获取计划发电量信息
	 */
	public List<Map<String, Object>> selPvPlanPowerById(Map<String, Object> map)
			throws Exception {
		// 电量计划    光伏计划发电量表    数据回显
		return othersDao.selPvPlanPowerById(map);
	}
	/**
	 * 电量计划 光伏计划发电量表 删除 
	 */
	public void delPvPlanPowerById(Map<String, Object> map)
			throws Exception {
		// 电量计划 光伏计划发电量表 删除
		othersDao.delPvPlanPowerById(map);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getRelFauLst(Map<String, Object> map) throws Exception {
		// 获取某设备类型所关联的告警码
		List<Map<String, Object>> alaCodLst = othersDao.getAlaCodByAppTypId(map);
		// 获取某设备实时的告警信息
		List<Map<String, Object>> relFauLst = othersDao.getRelFauLst(map);
		// 非空判断
		if(alaCodLst != null && !alaCodLst.isEmpty()){
			// 遍历所有告警码
			for(Map<String, Object> alaCodMap : alaCodLst){
				// 对实时告警信息进行非空判断
				if(relFauLst != null && !relFauLst.isEmpty()){
					// 遍历实时告警信息
					for(Map<String, Object> relFauMap : relFauLst){
						// 将实时告警信息与所有关联的告警码进行比对,如果比对成功,前台告警码处颜色标注(is_dpl=1为红色,is_dpl=0不变色)
						if(relFauMap.get("idx_pst") != null && alaCodMap.get("idx_pst").toString().equals(relFauMap.get("idx_pst").toString())){
							
							alaCodMap.put("is_dpl", 1);
						}
					}
				}
			}
		}
		// 对所有告警码进行非空判断
		if(alaCodLst != null && !alaCodLst.isEmpty()){
			
			for(Map<String, Object> alaCodMap : alaCodLst){
				// 对上一个方法中is_dpl字段没有填状态的用0进行补位
				if(alaCodMap.get("is_dpl") == null){
					
					alaCodMap.put("is_dpl", 0);
					
				}
			}
		}
		
		return alaCodLst;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getRelFauLstApp(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> relFauLst = othersDao.getRelFauLst(map);
		
		return relFauLst;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquHealthCurve(Map<String, Object> map) throws Exception {
		// 时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(sdf.format(new Date()), "2");
		// 获取某设备实时的告警信息
		List<Map<String, Object>> relFauLst = othersDao.getRelFauLst(map);
		
		String fau_info = "";
		// 告警信息非空判断
		if(relFauLst != null && !relFauLst.isEmpty()){
			
			for(Map<String, Object> relFauMap : relFauLst){
				// 获取告警信息
				fau_info = relFauMap.get("fau_info").toString();
			}
		}
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		// 日期信息非空判断
		if(monLst != null && !monLst.isEmpty()){
			// 遍历日期信息
			for(Map<String, Object> monMap:monLst){
				
				Map<String, Object> returnMap = new HashMap<String, Object>();

				map.put("sta_tim", monMap.get("staTim"));

				map.put("end_tim", monMap.get("endTim"));
				// 获取设备健康评分曲线
				List<Map<String, Object>> healthLst = othersDao.getEquHealthCurve(map);
				// 健康评分信息非空判断
				if(healthLst != null && !healthLst.isEmpty()){
					
					for (Map<String, Object> healthMap : healthLst) {
						// 获取设备健康评分
						returnMap.put("health_scor", healthMap.get("health_scor"));
					}
				}
				returnMap.put("tol_tim", map.get("sta_tim"));
				
				returnMap.put("fau_info", fau_info);
				
				returnLst.add(returnMap);
			}
		}
		
		return returnLst;
	}
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquHealthScor(Map<String, Object> map) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		// 设备数量
		Integer equCou = 0;
		// 设备健康评分数量(健康评分大于80分的,才记入计数器)
		Integer equHealthCou = 0;
		
		// 获取到use_id后,传入方法
		// 传入之后,得到与登录用户所关联的站信息
		// 通过表sys_dat_use_pws中的关联关系，查询出所有与此用户有关的站，放入站集合中
		List<Map<String, Object>> pwsInfLst = utilsDao.getPwsInfLstByPwsIdOpt(map);// 与此用户有关的所有站信息
		
		// 遍历站信息,再获取站内的设备信息
		if(pwsInfLst != null && !pwsInfLst.isEmpty()){
			
			for(Map<String, Object> pwsInfMap : pwsInfLst){
				
				map.put("pws_id", pwsInfMap.get("id"));
				
				// 获取到站内的设备信息,传入健康信息获取接口中
				List<Map<String, Object>> equLst = othersDao.getEquInfByPws(map);
				
				if(equLst != null && !equLst.isEmpty()){
					
					for(Map<String, Object> equMap : equLst){
						// 获取到站内的设备信息,传入健康信息获取接口中
						List<Map<String, Object>> healthLst = othersDao.getEquHealthScorTop(equMap);
						
						// 获取健康评分,并进行判断
						if(healthLst != null && !healthLst.isEmpty()){
							
							for(Map<String, Object> healthMap : healthLst){
								// 获取到设备的健康评分
								if(Double.valueOf(healthMap.get("health_scor").toString()) >= 80){
									// 如果超过80分就是优/良,累加
									equHealthCou = equHealthCou+1;
								}
							}
						}
						// 获取到设备总数
						equCou = equCou + 1;
					}
				}
			}
		}
		// 设备健康率计算
		Double equHealthRate = (equHealthCou*1.00)/(equCou*1.00);
		
		String equHealthSta = "";
		
		DecimalFormat df = new DecimalFormat("######0.0000");   

		// 获取设备健康率(保留4位小树格式化)
		returnMap.put("equHealthRate", df.format(equHealthRate));
		// 设备健康率大于等于90分,优秀
		if(equHealthRate*100 >= 90){
			
			equHealthSta = "优秀";
		// 设备健康率大于等于80分,良好
		}else if(equHealthRate*100 >= 80 && equHealthRate*100 < 90){
			
			equHealthSta = "良好";
		// 设备健康率大于等于70分,中等
		}else if(equHealthRate*100 >= 70 && equHealthRate*100 < 80){
			
			equHealthSta = "中等";
		// 设备健康率大于等于90分,差
		}else if(equHealthRate*100 < 70){
			
			equHealthSta = "差";
			
		}
		// 获取设备健康状态
		returnMap.put("equHealthSta", equHealthSta);
		
		returnLst.add(returnMap);
		
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getRidNumFauNumAscRateInf(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		// 获取到use_id后,传入方法
		// 传入之后,得到与登录用户所关联的站信息
		// 通过表sys_dat_use_pws中的关联关系，查询出所有与此用户有关的站，放入站集合中
		List<Map<String, Object>> pwsInfLst = utilsDao.getPwsInfLstByPwsIdOpt(map);// 与此用户有关的所有站信息
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		// 使用当前时间,获取全年12个月的时间段信息
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(sdf.format(new Date()), "3");
		
		if(monLst != null && !monLst.isEmpty()){
			
			for(Map<String, Object> monMap:monLst){
				// 消缺数
				Double ridNum = 0.0;
				// 总故障数
				Double tolFauNum = 0.0;
				// 电站效益提升率(权重)
				Double whtPwsEffAscRate = 0.0;
				// 电站总容量
				Double ratPow = 0.0;
				
				Map<String, Object> returnMap = new HashMap<String, Object>();
				
				// 遍历站信息,再获取站内的设备信息
				if(pwsInfLst != null && !pwsInfLst.isEmpty()){
					
					for(Map<String, Object> pwsInfMap : pwsInfLst){
						
						map.put("pws_id", pwsInfMap.get("id"));
						
						map.put("sta_tim", monMap.get("staTim"));
						
						map.put("end_tim", monMap.get("endTim"));
						
						// 通过电站ID获取月消缺率信息以及月总故障数以及电站效益提升率
						List<Map<String, Object>> ridFauAscLst = othersDao.getRidNumFauNumAscRateInf(map);
						
						if(ridFauAscLst != null && !ridFauAscLst.isEmpty()){
							
							for(Map<String, Object> ridFauAscMap : ridFauAscLst){
								// 消缺数
								if(ridFauAscMap != null && ridFauAscMap.get("rid_num")!= null && ridFauAscMap.get("rid_num").toString() != null && ridFauAscMap.get("rid_num").toString() != ""){
									
									ridNum = ridNum + Double.valueOf(ridFauAscMap.get("rid_num").toString());
									
								}
								// 当月总故障数
								if(ridFauAscMap != null && ridFauAscMap.get("tol_fau_num")!= null && ridFauAscMap.get("tol_fau_num").toString() != null && ridFauAscMap.get("tol_fau_num").toString() != ""){
									
									tolFauNum = tolFauNum + Double.valueOf(ridFauAscMap.get("tol_fau_num").toString());
									
								}
								// 电站效益提升率
								if(ridFauAscMap != null && ridFauAscMap.get("pws_eff_asc_rate")!= null && ridFauAscMap.get("pws_eff_asc_rate").toString() != null && ridFauAscMap.get("pws_eff_asc_rate").toString() != ""){
									
									ratPow = ratPow + Double.valueOf(pwsInfMap.get("rat_pow").toString());
									
									whtPwsEffAscRate = whtPwsEffAscRate + Double.valueOf(ridFauAscMap.get("pws_eff_asc_rate").toString())*Double.valueOf(pwsInfMap.get("rat_pow").toString());
									
								}
							}
						}
					}
					DecimalFormat df = new DecimalFormat("#0.00");   
					// 总消缺率
					if(tolFauNum == 0){
						
						returnMap.put("rid_rate", 0);
						
					}else{
						
						returnMap.put("rid_rate", df.format((ridNum/tolFauNum)*100));
					}
					// 总电站效益提升率
					if(ratPow == 0){
						
						returnMap.put("pws_eff_asc_rate", 0);
						
					}else{
						
						returnMap.put("pws_eff_asc_rate", df.format((whtPwsEffAscRate/ratPow)*100));
					}
					
					// 统计时间
					returnMap.put("tol_tim", map.get("sta_tim"));
					
					returnLst.add(returnMap);
				}
			}
		}
		
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updSysNoticeState(Map<String, Object> map) throws Exception {
		
		return  othersDao.updSysNoticeState(map);// 与此用户有关的所有站信息
		
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getSysNoticeInfByUseId(Map<String, Object> map) throws Exception {
		
		return  othersDao.getSysNoticeInfByUseId(map);// 与此用户有关的所有站信息
		
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getOptComCouAndOptUseCouLst() throws Exception {
		
		List<Map<String, Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> returnMap = new HashMap<String, Object>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 获取合作伙伴公司数量信息
		map.put("com_rol", 2);
		// 使用公司类型获取所有指定公司类型的数量
		List<Map<String,Object>> optComCouLst = othersDao.getAllComCountByComTyp(map);
		// 非空判断
		if(optComCouLst != null && !optComCouLst.isEmpty() && optComCouLst.get(0) != null){
			
			for(Map<String, Object> optComCouMap:optComCouLst){
				// 获取运维公司数量
				returnMap.put("optComCou", optComCouMap.get("cou"));
				
			}
		}
		
		// 获取所有运维人员数量
		List<Map<String,Object>> optUseCouLst = othersDao.getAllOptUseCou();
		// 非空判断
		if(optUseCouLst != null && !optUseCouLst.isEmpty() && optUseCouLst.get(0) != null){
			
			for(Map<String, Object> optUseCouMap:optUseCouLst){
				// 获取运维人员数量
				returnMap.put("optUseCou", optUseCouMap.get("cou"));
				
			}
		}
		
		returnLst.add(returnMap);
		
		return  returnLst;
		
	}
	
	/*-------------------------------------以下为综合监控 显示所有设备详情  接口  -------------------------------------*/
	
	/**
	 * 交流充电桩-详情,待机数据 （获取最新那条数据)
	 * 交流充电桩-详情,充电中实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getIscsAcchpStdAndRelByEquNumNew(Map<String, Object> map) throws Exception {
		
		//交流充电桩-详情,待机数据 （获取最新那条数据
		List<Map<String, Object>> stdLst = othersDao.getIscsAcchpStdInfByEquNumNew(map);
		// 交流充电桩-详情,充电中实时数据 （获取最新那条数据）
		List<Map<String, Object>> relLst = othersDao.getIscsAcchpRelInfByEquNumNew(map);
		
		Map<String,Object> newMap = new HashMap<String, Object>();
		
		newMap.put("stdLst", stdLst);
		
		newMap.put("relLst", relLst);
		
		return newMap;
	}
	
	
	/**
	 * 获取 交流配电柜  设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAcdbInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  othersDao.getAcdbInfByEquNumNew(map);
		
	}
	
	
	/**
	 * 查询储能电池  最新实时数据  根据编号
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  othersDao.getBmsInfoByEquNumNew(map);
		
	}
	
	
	/**
	 * 汇流箱-详情 （获取最新那条数据，包含支路电流数据）
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsBoxInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  othersDao.getIscsBoxInfByEquNumNew(map);
		
	}
	

	/**
	 * 控制器-详情 （获取最新那条数据，包含支路电流数据）
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getCtlInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  ctlDao.getCtlInfByEquNum(map);
		
	}
	
	
	/**
	 * 直流充电桩-详情,待机数据 （获取最新那条数据）
	 * 直流充电桩-详情,实时数据 （获取最新那条数据）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getIscsDcchpStdAndRelByEquNumNew(Map<String, Object> map) throws Exception {
		
		//直流充电桩-详情,待机数据 （获取最新那条数据）
		List<Map<String, Object>> stdLst = othersDao.getIscsDcchpStdInfByEquNumNew(map);
		// 直流充电桩-详情,实时数据 （获取最新那条数据）
		List<Map<String, Object>> relLst = othersDao.getIscsDcchpRelInfByEquNumNew(map);
		
		Map<String,Object> newMap = new HashMap<String, Object>();
		newMap.put("stdLst", stdLst);
		newMap.put("relLst", relLst);
		
		return newMap;
	}
	
	
	/**
	 * 获取 直流配电柜  设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDcdbInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  othersDao.getDcdbInfByEquNumNew(map);
		
	}
	
	/**
	 * 获取  获取 解列装置   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDctdevInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  dctdevDao.getDctdevInfByEquNum(map);
		
	}
	
	/**
	 * 获取 大屏第二屏数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBigSceensInf2(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> retMap = new HashMap<String,Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		// 日发电量(光伏)
		Double power = 0.0;
		// 月发电量（光伏）
		Double mon_power = 0.0;
		// 年发电量（光伏）
		Double year_power = 0.0;
		// 累计发电量（光伏）
		Double tol_power = 0.0;
		// 获取站点信息，使用ID(运维人员)
		List<Map<String, Object>> pwsInfLst = utilsDao.getPwsInfLstByPwsIdOpt(map);// 与此用户有关的所有站信息
		// 时间格式化
		List<Map<String, Object>> dayTwoLst = DateUtil.getDayMonYearTimLst(sdf.format(new Date()), "5");
		
		List<Map<String, Object>> pwsPowerLst = new ArrayList<Map<String,Object>>();
		
		// 遍历站信息,再获取站内的设备信息
		if(pwsInfLst != null && !pwsInfLst.isEmpty()){
			
			for(Map<String, Object> pwsInfMap : pwsInfLst){
				
				map.put("pws_id", pwsInfMap.get("id"));
				
				map.put("sta_tim", dayTwoLst.get(0).get("sta_tim"));
				
				map.put("end_tim", dayTwoLst.get(0).get("end_tim"));
				
				Map<String, Object> returnMap = new HashMap<String,Object>();
				// 获取电站天统计数据表（每天统计一次（建议凌晨0点到0点5分之间进行统计））(光伏逆变器)
				List<Map<String, Object>> pvLst = othersDao.getPwsStaPV(map);
				
				if(pvLst != null && !pvLst.isEmpty()){
					
					for(Map<String, Object> pvMap : pvLst){
						
						if(pvMap.get("power") != null){
							// 获取日发电量
							power = power+Double.valueOf(pvMap.get("power").toString());
						}
						
						if(pvMap.get("mon_power") != null){
							// 获取月发电量
							mon_power = mon_power+Double.valueOf(pvMap.get("mon_power").toString());
						}
						
						if(pvMap.get("year_power") != null){
							// 获取年发电量
							year_power = year_power+Double.valueOf(pvMap.get("year_power").toString());
						}
						
						if(pvMap.get("tol_power") != null){
							// 获取累计发电量
							tol_power = tol_power+Double.valueOf(pvMap.get("tol_power").toString());
						}
					}
				}
				
				// 获取电站分钟统计数据表（每天统计一次（建议凌晨0点到0点5分之间进行统计））(光伏逆变器)
				List<Map<String, Object>> pv15MinLst = othersDao.getPwsSta15MinPV(map);
				
				returnMap.put("pv15MinLst", pv15MinLst);
				
				pwsPowerLst.add(returnMap);
			}
		}
		
		retMap.put("power", new BigDecimal(power).toPlainString());
		
		retMap.put("mon_power", new BigDecimal(mon_power).toPlainString());
		
		retMap.put("year_power", new BigDecimal(year_power).toPlainString());
		
		retMap.put("tol_power", new BigDecimal(tol_power).toPlainString());
		// 时间格式化
		SimpleDateFormat sdfm = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdfm.format(new Date());
		// 每15分钟一个间隔获取1天96个时间的集合
		List<Map<String, Object>> minLst = DateUtil.getDayMonYearTimLst(crtTim, "1");
		
		List<Map<String, Object>> pv15MinPowerLst = new ArrayList<Map<String,Object>>();
		
		for(Map<String, Object> minMap:minLst){
			
			Map<String,Object> pv15MinPowerMap = new HashMap<String, Object>();
			
			Double pv15Power = null;
			
			// 将从96个时间点集合中取出的开始时间，取出并转化成long类型数字串
			long staTimL = sdfm.parse(minMap.get("sta_tim").toString()).getTime();
			// 将从96个时间点集合中取出的结束时间，取出并转化成long类型数字串
			long endTimL = sdfm.parse(minMap.get("end_tim").toString()).getTime();
			// 将从96个时间点集合中取出的展示时间，取出并转化成long类型数字串
			long tolTimL = Long.valueOf(minMap.get("tol_tim").toString());
			
			if(pwsPowerLst != null && !pwsPowerLst.isEmpty() && pwsPowerLst.get(0) != null){
				
				for(Map<String, Object> pwsPowerMap : pwsPowerLst){
					
					List<Map<String, Object>> pv15MinLst = (ArrayList<Map<String, Object>>)pwsPowerMap.get("pv15MinLst");
					
					if(pv15MinLst != null && !pv15MinLst.isEmpty() && pv15MinLst.get(0) != null){
						
						// 对曲线图点信息集合进行遍历
						Iterator<Map<String,Object>> it = pv15MinLst.iterator();
						
						while(it.hasNext()){
							
						    Map<String,Object> curMap = it.next();
						    // 将从数据库中取出的当前时间，取出并转化成long类型数字串
						    long crtTimL = sdfm.parse(curMap.get("crtTim").toString()).getTime();
						    // 判断返回数据的当前时间是否小于开始时间,如果小于则将该记录移除
						    if(crtTimL<staTimL){
						    	
						    	it.remove();
						    // 判断返回数据的当前时间是否大于开始时间小于结束时间,如果是则将数据进行累加,并将该数据删除
						    }  else if(staTimL<=crtTimL && endTimL>=crtTimL){
						    	
						    	if(pv15Power == null){
						    		
						    		pv15Power = 0.0;
						    	}
						    	if(curMap.get("pv_power") != null){
									
									pv15Power = pv15Power + Double.valueOf(curMap.get("pv_power").toString());
								}
						    	
						    	it.remove();
						    	
						    	break;
						    //如果当前时间大于结束时间,跳出循环
						    } else if(endTimL<crtTimL){
						    	
						    	break;
						    }
						}
					}
				}
			}
			
			if(pv15Power != null){
				// 获取光伏功率数据
				pv15MinPowerMap.put("power", new BigDecimal(pv15Power).toPlainString());
				
			}
			pv15MinPowerMap.put("tol_tim", tolTimL);
			
			pv15MinPowerLst.add(pv15MinPowerMap);
		}
		
		retMap.put("pv15MinPowerLst", pv15MinPowerLst);
		
		List<Map<String, Object>> planPVSLst = new ArrayList<Map<String,Object>>();
		
		// 年计划完成情况
		// 获取任意一年的 （eq: staTim:2017-1-1 & endTim:2018-1-1）
		List<Map<String, Object>> monTimPoint = DateUtil.getDayMonYearTimLst(crtTim, "3");
		
		Double realPvsPowerSum = 0.0;
		
		Double planPvsPowerSum = 0.0;
		
		if (monTimPoint != null && monTimPoint.size() > 0) {
			
			for (Map<String, Object> monthTim : monTimPoint) {
				
				Map<String, Object> mapParam = null;
				
				Double pvs_power = null;
				
				Double plan_power = null;
				
				Map<String, Object> mapResult = new HashMap<String, Object>();
				
				// 遍历站信息,再获取站内的设备信息
				if(pwsInfLst != null && !pwsInfLst.isEmpty()){
					
					for(Map<String, Object> pwsInfMap : pwsInfLst){
						
						mapParam = new HashMap<String, Object>();
						
						mapParam.put("pws_id", pwsInfMap.get("id"));
						
						mapParam.put("startTim", monthTim.get("staTim"));
						
						mapParam.put("endTim", monthTim.get("endTim"));
						
						// 获取 实际发电量
						List<Map<String, Object>> realPvsPower = analysisDao.getMonthDataStation(mapParam);
						
						if (realPvsPower != null && realPvsPower.size() > 0) {
							
							if(pvs_power==null){
								
								pvs_power = 0.0;
							}
							// 发电量累加计算
							if(realPvsPower.get(0).get("pvs_power")!=null){
								
								pvs_power = pvs_power+(Double)realPvsPower.get(0).get("pvs_power");
								
								realPvsPowerSum += (Double) realPvsPower.get(0).get("pvs_power");
							}
						}
						
						// 获取 计划发电量
						List<Map<String, Object>> planPvsPower = analysisDao.getPlanPvsPower(mapParam);
						
						if (planPvsPower != null && planPvsPower.size() > 0) {
							
							if(plan_power==null){
								
								plan_power = 0.0;
							}
							// 发电量累加计算
							if(planPvsPower.get(0).get("plan_power")!=null){
								
								plan_power = plan_power+(Double)planPvsPower.get(0).get("plan_power");
								
								planPvsPowerSum += (Double) planPvsPower.get(0).get("plan_power");
							}
						}
					}
				}
				
				if(pvs_power != null){
					
					mapResult.put("pvs_power", pvs_power);
					
				}
				
				if(plan_power != null){
					
					mapResult.put("plan_power", plan_power);
					
				}
				
				mapResult.put("tol_tim", monthTim.get("staTim"));
				
				planPVSLst.add(mapResult);
			}
			
			retMap.put("planPVSLst", planPVSLst);
			
			// 计算得到 完成率 并放入集合
			
			if(planPvsPowerSum > 0){
				
				retMap.put("planRate", new BigDecimal(realPvsPowerSum/planPvsPowerSum).toPlainString());
				
			}else{
				
				retMap.put("planRate", 0);
				
			}
		}

		Map<String, Object> mapParam = null;
		// 年计划完成情况
		// 获取任意一年的 （eq: staTim:2017-1-1 & endTim:2018-1-1）
		List<Map<String, Object>> monTimTwoPoint = DateUtil.getDayMonYearTimLst(crtTim, "5");
		// 最大效率
		Double maxComEff = 0.0;
		// 最小效率
		Double minComEff = 0.0;
		// 效率数
		Double comEffCount = 0.0;
		// 总效率数
		Double tolEffCount = 0.0;
		
		// 遍历站信息,再获取站内的设备信息
		if(pwsInfLst != null && !pwsInfLst.isEmpty()){
			
			for(Map<String, Object> pwsInfMap : pwsInfLst){
				
				mapParam = new HashMap<String, Object>();
				
				mapParam.put("pws_id", pwsInfMap.get("id"));
				
				mapParam.put("startTim", monTimTwoPoint.get(0).get("staTim"));
				
				mapParam.put("endTim", monTimTwoPoint.get(0).get("endTim"));
				// 获取电站效率集合
				List<Map<String, Object>> comEffLst = othersDao.getComEffLst(mapParam);
				// 综合效率
				Double comEff = 0.0;
				
				// 综合效率
				if (comEffLst != null && comEffLst.size() > 0) {
					
					comEff = (Double)comEffLst.get(0).get("com_eff");
					
					// 最小综合效率判断
					if(minComEff == 0.0){
						
						minComEff = comEff;
						
					} else if(minComEff > comEff){
						
						minComEff = comEff;
						
					}
					// 最大综合效率判断
					if(maxComEff < comEff){
						
						maxComEff = comEff;
						
					}
					// 有效综合效率数据个数
					comEffCount = comEffCount + 1;
					// 总综合效率
					tolEffCount = tolEffCount+comEff;
				}
			}
		}
		// 最大效率
		retMap.put("maxComEff", maxComEff);
		// 最小效率
		retMap.put("minComEff", minComEff);
		// 平均效率
		retMap.put("avgComEff", tolEffCount/comEffCount);
		
		// 建立最终结果返回集合
		// PVS
		// 正常运行状态计数器
		Integer norStatCountPV = 0;
		
		// 告警运行状态计数器
		Integer alaStatCountPV = 0;
		
		// 故障停机状态计数器
		Integer fauStatCountPV = 0;
		
		// PCS
		// 正常运行状态计数器
		Integer norStatCountPC = 0;
		
		// 告警运行状态计数器
		Integer alaStatCountPC = 0;
		
		// 故障停机状态计数器
		Integer fauStatCountPC = 0;
		
		// 充电桩
		// 离线状态计数器
		Integer offlineStatCount = 0;
		
		// 空闲状态计数器
		Integer idleStatCount = 0;
		
		// 充电中状态计数器
		Integer inChargeStatCount = 0;
		
		// 告警运行状态计数器
		Integer alaStatCount = 0;
		
		// 遍历站信息,再获取站内的设备信息
		if(pwsInfLst != null && !pwsInfLst.isEmpty()){
			
			for(Map<String, Object> pwsInfMap : pwsInfLst){
				
				mapParam = new HashMap<String, Object>();
				
				mapParam.put("pws_id", pwsInfMap.get("id"));
				
				mapParam.put("app_typ_ide", "GFNBQ");
				
				// 获取某电站中某设备类型的所有设备信息
				List<Map<String, Object>> equLst = othersDao.getEquLstByPwsEquTypIde(mapParam);
				
				if(equLst != null && !equLst.isEmpty()){
					
					for(Map<String, Object> equMap : equLst){
						// 获取PCS设备的最新实时数据(列表页中)
						
						map.put("equ_num", equMap.get("equ_num"));
						// 获取PVS设备的最新实时数据(列表页中)
						List<Map<String, Object>> pvsRelTimLst = pvsDao.getPvsInfByEquNum(map);
						
						// 1.不带stat，获取所有的状态数据
						if(pvsRelTimLst != null && !pvsRelTimLst.isEmpty()){
							
							for(Map<String, Object>  pvsRelTimMap : pvsRelTimLst){
								// 判断PCS实时状态
								if("0".equals(pvsRelTimMap.get("stat").toString())){
									
									norStatCountPV = norStatCountPV +1;
									
									equMap.put("stat", 0);
									
								}else if("1".equals(pvsRelTimMap.get("stat").toString())){
									
									norStatCountPV = norStatCountPV +1;
									
									equMap.put("stat", 1);
									
								}else if("2".equals(pvsRelTimMap.get("stat").toString())){
									
									norStatCountPV = norStatCountPV +1;
									
									equMap.put("stat", 2);
									
								}else if("3".equals(pvsRelTimMap.get("stat").toString())){
									
									alaStatCountPV = alaStatCountPV +1;
									
									equMap.put("stat", 3);
									
								}else if("4".equals(pvsRelTimMap.get("stat").toString())){
									
									fauStatCountPV = fauStatCountPV +1;
									
									equMap.put("stat", 4);
									
								}else if("5".equals(pvsRelTimMap.get("stat").toString())){
									
									norStatCountPV = norStatCountPV +1;
									
									equMap.put("stat", 5);
								}
								equMap.putAll(pvsRelTimMap);
							}
						}else{
							
							norStatCountPV = norStatCountPV+1;
							
							equMap.put("stat", 0);
						}
					}
				}
				
				
				// 获取某电站中某设备类型的所有设备信息
				mapParam.put("app_typ_ide", "CNNBQ");
				
				// 获取某电站中某设备类型的所有设备信息
				List<Map<String, Object>> equLstPCS = othersDao.getEquLstByPwsEquTypIde(mapParam);
				
				if(equLstPCS != null && !equLstPCS.isEmpty()){
					
					for(Map<String, Object> equPCSMap : equLstPCS){
						// 获取PCS设备的最新实时数据(列表页中)
						
						map.put("equ_num", equPCSMap.get("equ_num"));
						
						List<Map<String, Object>> pcsRelTimLst = pcsDao.getPcsInfByEquNum(map);
						
						// 1.不带stat，获取所有的状态数据
						if(pcsRelTimLst != null && !pcsRelTimLst.isEmpty()){
							
							for(Map<String, Object>  pcsRelTimMap : pcsRelTimLst){
								// 判断PCS实时状态
								if("0".equals(pcsRelTimMap.get("stat").toString())){
									
									norStatCountPC = norStatCountPC +1;
									
								}else if("1".equals(pcsRelTimMap.get("stat").toString())){
									
									norStatCountPC = norStatCountPC +1;
									
								}else if("2".equals(pcsRelTimMap.get("stat").toString())){
									
									norStatCountPC = norStatCountPC +1;
									
								}else if("3".equals(pcsRelTimMap.get("stat").toString())){
									
									alaStatCountPC = alaStatCountPC +1;
									
								}else if("4".equals(pcsRelTimMap.get("stat").toString())){
									
									fauStatCountPC = fauStatCountPC +1;
								}
							}
						}else{
							
							norStatCountPC = norStatCountPC+1;
						}
					}
				}
				
				mapParam.put("app_typ_ide", "JLCDZ");
				
				// 获取某电站中某设备类型的所有设备信息
				List<Map<String, Object>> equAcChpLst = othersDao.getEquLstByPwsEquTypIde(mapParam);
				// 获取某电站中某设备类型的所有设备信息(交流充电桩)
				
				mapParam.put("app_typ_ide", "ZLCDZ");
				List<Map<String, Object>> equDcChpLst = othersDao.getEquLstByPwsEquTypIde(mapParam);
				// 获取某电站中某设备类型的所有设备信息(直流充电桩)
				
				if(equAcChpLst != null && !equAcChpLst.isEmpty()){
					
					for(Map<String, Object> equAcChpMap : equAcChpLst){
						// 获取PCS设备的最新实时数据(列表页中)
						
						map.put("equ_num", equAcChpMap.get("equ_num"));
						
						List<Map<String, Object>> acchpRelTimLst = acchpDao.getAcchpInfByEquNum(map);
						
						// 1.不带stat，获取所有的状态数据
						if(acchpRelTimLst != null && !acchpRelTimLst.isEmpty()){
							
							for(Map<String, Object>  acchpRelTimMap : acchpRelTimLst){
								// 判断PCS实时状态
								if("0".equals(acchpRelTimMap.get("stat").toString())){
									
									offlineStatCount = offlineStatCount +1;
									
								}else if("1".equals(acchpRelTimMap.get("stat").toString())){
									
									idleStatCount = idleStatCount +1;
									
								}else if("2".equals(acchpRelTimMap.get("stat").toString())){
									
									inChargeStatCount = inChargeStatCount +1;
									
								}else if("3".equals(acchpRelTimMap.get("stat").toString())){
									
									alaStatCount = alaStatCount +1;
								}
							}
						}else{
							
							offlineStatCount = offlineStatCount+1;
						}
					}
				} 
				if(equDcChpLst != null && !equDcChpLst.isEmpty()){
					
					for(Map<String, Object> equDcChpMap : equDcChpLst){
						// 获取PCS设备的最新实时数据(列表页中)
						map.put("equ_num", equDcChpMap.get("equ_num"));
						
						List<Map<String, Object>> dcchpRelTimLst = dcchpDao.getDcchpInfByEquNum(map);
						
						// 1.不带stat，获取所有的状态数据
						if(dcchpRelTimLst != null && !dcchpRelTimLst.isEmpty()){
							
							for(Map<String, Object>  dcchpRelTimMap : dcchpRelTimLst){
								// 判断PCS实时状态
								if("0".equals(dcchpRelTimMap.get("stat").toString())){
									
									offlineStatCount = offlineStatCount +1;
									
								}else if("1".equals(dcchpRelTimMap.get("stat").toString())){
									
									idleStatCount = idleStatCount +1;
									
								}else if("2".equals(dcchpRelTimMap.get("stat").toString())){
									
									inChargeStatCount = inChargeStatCount +1;
									
								}else if("3".equals(dcchpRelTimMap.get("stat").toString())){
									
									alaStatCount = alaStatCount +1;
								}
							}
						}else{
							
							offlineStatCount = offlineStatCount+1;
						}
					}
				}
			}
		}
		// PCS
		retMap.put("norStatCountPV", norStatCountPV);	
		
		retMap.put("alaStatCountPV", alaStatCountPV);	
		
		retMap.put("fauStatCountPV", fauStatCountPV);		
		
		// PVS
		retMap.put("norStatCountPC", norStatCountPC);	
		
		retMap.put("alaStatCountPC", alaStatCountPC);	
		
		retMap.put("fauStatCountPC", fauStatCountPC);		
		
		// 充电桩
		// 离线状态计数器
		retMap.put("offlineStatCount", offlineStatCount);	
		
		// 空闲状态计数器
		retMap.put("idleStatCount", idleStatCount);	
		
		// 充电中状态计数器
		retMap.put("inChargeStatCount", inChargeStatCount);		
		
		// 告警运行状态计数器
		retMap.put("alaStatCount", alaStatCount);		
		
		List<Map<String, Object>> phiPhePCSLst = new ArrayList<Map<String,Object>>();
				
		if (monTimPoint != null && monTimPoint.size() > 0) {
			
			for (Map<String, Object> monthTim : monTimPoint) {
				
				Map<String, Object> mapResult = new HashMap<String, Object>();
				// 月充放电量统计
				
				Double phi = null;
				
				Double phe = null;
				// 遍历站信息,再获取站内的设备信息
				if(pwsInfLst != null && !pwsInfLst.isEmpty()){
					
					for(Map<String, Object> pwsInfMap : pwsInfLst){
						
						Map<String, Object> mapParamPCS = new HashMap<String, Object>();
						
						mapParamPCS.put("pws_id", pwsInfMap.get("id"));
						
						mapParamPCS.put("sta_tim", monthTim.get("staTim"));
						
						mapParamPCS.put("end_tim", monthTim.get("endTim"));
						
						// 获取 实际发电量
						List<Map<String, Object>> phiPheLst = othersDao.getPwsStaPCSLst(mapParamPCS);
						
						if (phiPheLst != null && !phiPheLst.isEmpty() && phiPheLst.get(0) != null && phiPheLst.size() > 0) {
						
							if(phi== null){
								
								phi = 0.0;
							}
							
							if(phiPheLst.get(0).get("phi")!=null){
								
								phi = phi+(Double)phiPheLst.get(0).get("phi");
							}
							
							if(phe== null){
								
								phe = 0.0;
							}
							if(phiPheLst.get(0).get("phi")!=null){
								
								phe = phe+(Double)phiPheLst.get(0).get("phe");
							}
						}
					}
				}
				
				if(phi != null){
					
					mapResult.put("phi", phi);
					
				}
				
				if(phe != null){
					
					mapResult.put("phe", phe);
					
				}
				
				mapResult.put("tol_tim", monthTim.get("staTim"));
				
				phiPhePCSLst.add(mapResult);
			}
			// 储能充放电量柱状图（30天）
			retMap.put("phiPhePCSLst", phiPhePCSLst);
		}
		
		// 充电量充放电情况
		// 获取总体充电量
		
		Map<String,Object> inpMap = new HashMap<String, Object>();
		
		inpMap.put("app_typ_ide", "JLCDZ");
		
		inpMap.put("use_id", map.get("use_id"));
		
		List<Map<String, Object>> acChpEquLst = othersDao.getEquLstByUseIdByAppTypIde(inpMap);
		
		inpMap.put("app_typ_ide", "ZLCDZ");
		
		List<Map<String, Object>> dcChpEquLst = othersDao.getEquLstByUseIdByAppTypIde(inpMap);
		
		// 累计充电有效小时数
		Double tolCumTime = 0.0;
		// 累计充电金额（分）
		Double tolCumPower = 0.0;
		// 累计充电次数
		Double tolChpCnt = 0.0;
		
		if(acChpEquLst != null && !acChpEquLst.isEmpty() && acChpEquLst.get(0) != null){
			
			for(Map<String, Object> acChpEquMap:acChpEquLst){
				// 使用设备编码，获取交流充电装设备的累计充电小时数、累计充电电量、累计充电次数
				List<Map<String, Object>> chpPowerLst = othersDao.getAcChpCumTimPowCntByEquNum(acChpEquMap);
				
				if(chpPowerLst != null && !chpPowerLst.isEmpty() && chpPowerLst.get(0) != null){
					
					if(chpPowerLst.get(0).get("cumTime") != null){
						
						tolCumTime = tolCumTime + Double.valueOf(chpPowerLst.get(0).get("cumTime").toString());
					}
					
					if(chpPowerLst.get(0).get("cumPower") != null){
						
						tolCumPower = tolCumPower + Double.valueOf(chpPowerLst.get(0).get("cumPower").toString());
					}
					
					if(chpPowerLst.get(0).get("chpCnt") != null){
						
						tolChpCnt = tolChpCnt + Double.valueOf(chpPowerLst.get(0).get("chpCnt").toString());
					}
				}
			}
		}
		// 对直流充电桩返回的数据集合进行非空判断
		if(dcChpEquLst != null && !dcChpEquLst.isEmpty() && dcChpEquLst.get(0) != null){
			
			for(Map<String, Object> dcChpEquMap:dcChpEquLst){
				// 使用设备编码，获取直流流充电装设备的累计充电小时数、累计充电电量、累计充电次数
				List<Map<String, Object>> chpPowerLst = othersDao.getDcChpCumTimPowCntByEquNum(dcChpEquMap);
				
				if(chpPowerLst != null && !chpPowerLst.isEmpty() && chpPowerLst.get(0) != null){
					
					if(chpPowerLst.get(0).get("cumTime") != null){
						
						tolCumTime = tolCumTime + Double.valueOf(chpPowerLst.get(0).get("cumTime").toString());
					}
					
					if(chpPowerLst.get(0).get("cumPower") != null){
						
						tolCumPower = tolCumPower + Double.valueOf(chpPowerLst.get(0).get("cumPower").toString());
					}
					
					if(chpPowerLst.get(0).get("chpCnt") != null){
						
						tolChpCnt = tolChpCnt + Double.valueOf(chpPowerLst.get(0).get("chpCnt").toString());
					}
				}
			}
		}
		
		retMap.put("tolCumTime", tolCumTime);
		
		retMap.put("tolCumPower", tolCumPower);
		
		retMap.put("tolChpCnt", tolChpCnt);
		
		// 使用用户ID获取依照地区排序后的充电容量排行
		List<Map<String, Object>> rankLst = othersDao.getChpRtdPowRankByRegByUse(map);
		
		if(rankLst != null && !rankLst.isEmpty()){
			
			for(Map<String, Object> rankMap:rankLst){
				
				rankMap.put("app_typ_ide", "JLCDZ");
				
				rankMap.put("use_id", map.get("use_id"));
				// 使用用户ID获取与该用户有关的所有设备（传入设备类型）
				List<Map<String, Object>> acChpEquRankLst = othersDao.getEquLstByUseIdByAppTypIde(rankMap);
				
				rankMap.put("app_typ_ide", "ZLCDZ");
				// 使用用户ID获取与该用户有关的所有设备（传入设备类型）
				List<Map<String, Object>> dcChpEquRankLst = othersDao.getEquLstByUseIdByAppTypIde(rankMap);
				// 充电桩总数量
				rankMap.put("chpEquCnt", acChpEquRankLst.size()+dcChpEquRankLst.size());
				
				// 充电有效小时数、充电次数
				Double cumTime = 0.0;
				
				Double chpCnt = 0.0;
				// 对交流充电桩排行数据进行非空判断
				if(acChpEquRankLst != null && !acChpEquRankLst.isEmpty() && acChpEquRankLst.get(0) != null){
					
					for(Map<String, Object> acChpEquMap:acChpEquRankLst){
						// 使用设备编码，获取交流充电装设备的累计充电小时数、累计充电电量、累计充电次数
						List<Map<String, Object>> chpPowerLst = othersDao.getAcChpCumTimPowCntByEquNum(acChpEquMap);
						
						if(chpPowerLst != null && !chpPowerLst.isEmpty() && chpPowerLst.get(0) != null && chpPowerLst.get(0).get("cumTime") != null){
							
							cumTime = cumTime + Double.valueOf(chpPowerLst.get(0).get("cumTime").toString());
						}
						
						if(chpPowerLst != null && !chpPowerLst.isEmpty() && chpPowerLst.get(0) != null && chpPowerLst.get(0).get("chpCnt") != null){
							
							chpCnt = chpCnt + Double.valueOf(chpPowerLst.get(0).get("chpCnt").toString());
						}
					}
				}
				// 对直流充电桩排行数据进行非空判断
				if(dcChpEquRankLst != null && !dcChpEquRankLst.isEmpty() && dcChpEquRankLst.get(0) != null){
					
					for(Map<String, Object> dcChpEquMap:dcChpEquRankLst){
						// 使用设备编码，获取直流流充电装设备的累计充电小时数、累计充电电量、累计充电次数 
						List<Map<String, Object>> chpPowerLst = othersDao.getDcChpCumTimPowCntByEquNum(dcChpEquMap);

						if(chpPowerLst != null && !chpPowerLst.isEmpty() && chpPowerLst.get(0) != null && chpPowerLst.get(0).get("cumTime") != null){
							
							cumTime = cumTime + Double.valueOf(chpPowerLst.get(0).get("cumTime").toString());
						}
						
						if(chpPowerLst != null && !chpPowerLst.isEmpty() && chpPowerLst.get(0) != null && chpPowerLst.get(0).get("chpCnt") != null){
							
							chpCnt = chpCnt + Double.valueOf(chpPowerLst.get(0).get("chpCnt").toString());
						}
					}
				}
				
				// 充电有效小时数
				rankMap.put("cumTime", cumTime);
				
				// 充电次数
				rankMap.put("chpCnt", chpCnt);
			}
		}
		retMap.put("rankLst", rankLst);
		
		retLst.add(retMap);
		
		return retLst;
		
	}
	/**
	 * 获取 环境检测仪   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  othersDao.getEnvInfByEquNumNew(map);
		
	}
	
	/**
	 * 获取  第二类大屏第一屏数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBigScreenOne(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> retMap = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		// 日发电量(光伏)
		Double power = 0.0;
		// 月发电量（光伏）
		Double mon_power = 0.0;
		// 年发电量（光伏）
		Double year_power = 0.0;
		// 累计发电量（光伏）
		Double tol_power = 0.0;
		// 获取站点信息，使用ID(运维人员)
		List<Map<String, Object>> pwsInfLst = utilsDao.getPwsInfLstByPwsIdOpt(map);// 与此用户有关的所有站信息
		// 获取某年、月、日起始和结束时间点集合
		List<Map<String, Object>> dayTwoLst = DateUtil.getDayMonYearTimLst(sdf.format(new Date()), "5");
		
		List<Map<String, Object>> pwsPowerLst = new ArrayList<Map<String,Object>>();
		
		// 遍历站信息,再获取站内的设备信息
		if(pwsInfLst != null && !pwsInfLst.isEmpty()){
			
			for(Map<String, Object> pwsInfMap : pwsInfLst){
				
				map.put("pws_id", pwsInfMap.get("id"));
				
				map.put("sta_tim", dayTwoLst.get(0).get("sta_tim"));
				
				map.put("end_tim", dayTwoLst.get(0).get("end_tim"));
				
				Map<String, Object> returnMap = new HashMap<String,Object>();
				// 获取电站天统计数据表（每天统计一次（建议凌晨0点到0点5分之间进行统计））(光伏逆变器)
				List<Map<String, Object>> pvLst = othersDao.getPwsStaPV(map);
				
				if(pvLst != null && !pvLst.isEmpty()){
					
					for(Map<String, Object> pvMap : pvLst){
						// 获取日发电量
						if(pvMap.get("power") != null){
							
							power = power+Double.valueOf(pvMap.get("power").toString());
						}
						// 获取月发电量
						if(pvMap.get("mon_power") != null){
							
							mon_power = mon_power+Double.valueOf(pvMap.get("mon_power").toString());
						}
						// 获取年发电量
						if(pvMap.get("year_power") != null){
							
							year_power = year_power+Double.valueOf(pvMap.get("year_power").toString());
						}
						// 获取累计发电量
						if(pvMap.get("tol_power") != null){
							
							tol_power = tol_power+Double.valueOf(pvMap.get("tol_power").toString());
						}
					}
				}
				
				// 获取电站分钟统计数据表（每天统计一次（建议凌晨0点到0点5分之间进行统计））(光伏逆变器)
				List<Map<String, Object>> pv15MinLst = othersDao.getPwsSta15MinPV(map);
				
				returnMap.put("pv15MinLst", pv15MinLst);
				
				pwsPowerLst.add(returnMap);
			}
		}
		
		retMap.put("power", new BigDecimal(power).toPlainString());
		
		retMap.put("mon_power", new BigDecimal(mon_power).toPlainString());
		
		retMap.put("year_power", new BigDecimal(year_power).toPlainString());
		
		retMap.put("tol_power", new BigDecimal(tol_power).toPlainString());
		
		// 发电量年柱状图
		// 使用当前时间,获取全年12个月的时间段信息
		List<Map<String, Object>> monLst = DateUtil.getDayMonYearTimLst(sdf.format(new Date()), "3");
		
		List<Map<String, Object>> retMonPVLst = new ArrayList<Map<String,Object>>();
		
		if(monLst != null && !monLst.isEmpty()){
			
			for(Map<String, Object> monMap:monLst){
				// 月发电量
				Double monPVNum = 0.0;
				
				Map<String, Object> returnMap = new HashMap<String, Object>();
				
				// 遍历站信息,再获取站内的设备信息
				if(pwsInfLst != null && !pwsInfLst.isEmpty()){
					
					for(Map<String, Object> pwsInfMap : pwsInfLst){
						
						map.put("pws_id", pwsInfMap.get("id"));
						
						map.put("sta_tim", monMap.get("staTim"));
						
						map.put("end_tim", monMap.get("endTim"));
						
						// 通过电站ID获取月消缺率信息以及月总故障数以及电站效益提升率
						List<Map<String, Object>> monPVLst = othersDao.getPwsStaMonPV(map);
						// 非空判断
						if(monPVLst != null && !monPVLst.isEmpty()){
							// 循环遍历
							for(Map<String, Object> monPVMap : monPVLst){
								
								if(monPVMap != null && monPVMap.get("pvs_power")!= null && monPVMap.get("pvs_power").toString() != null && monPVMap.get("pvs_power").toString() != ""){
									// 获取月发电量
									monPVNum = monPVNum + Double.valueOf(monPVMap.get("pvs_power").toString());
									
								}
							}
						}
					}
				}
				returnMap.put("monPVNum", new BigDecimal(monPVNum).toPlainString());
				
				returnMap.put("tol_tim", monMap.get("staTim"));
				
				retMonPVLst.add(returnMap);
			}
		}
		
		retMap.put("retMonPVLst", retMonPVLst);
		
		// 发电量月柱状图
		// 使用当前时间,获取全年12个月的时间段信息
		List<Map<String, Object>> dayLst = DateUtil.getDayMonYearTimLst(sdf.format(new Date()), "2");
		
		List<Map<String, Object>> retDayPVLst = new ArrayList<Map<String,Object>>();
		
		if(dayLst != null && !dayLst.isEmpty()){
			
			for(Map<String, Object> dayMap:dayLst){
				// 日发电量
				Double dayPVNum = 0.0;
				
				Map<String, Object> returnMap = new HashMap<String, Object>();
				
				// 遍历站信息,再获取站内的设备信息
				if(pwsInfLst != null && !pwsInfLst.isEmpty()){
					
					for(Map<String, Object> pwsInfMap : pwsInfLst){
						
						map.put("pws_id", pwsInfMap.get("id"));
						
						map.put("sta_tim", dayMap.get("staTim"));
						
						map.put("end_tim", dayMap.get("endTim"));
						
						// 通过电站ID获取月消缺率信息以及月总故障数以及电站效益提升率
						List<Map<String, Object>> dayPVLst = othersDao.getPwsStaDayPV(map);
						
						if(dayPVLst != null && !dayPVLst.isEmpty()){
							
							for(Map<String, Object> dayPVMap : dayPVLst){
								
								if(dayPVMap != null && dayPVMap.get("power")!= null && dayPVMap.get("power").toString() != null && dayPVMap.get("power").toString() != ""){
									// 获取日发电量
									dayPVNum = dayPVNum + Double.valueOf(dayPVMap.get("power").toString());
									
								}
							}
						}
					}
				}
				
				returnMap.put("dayPVNum", new BigDecimal(dayPVNum).toPlainString());
				
				returnMap.put("tol_tim", dayMap.get("staTim"));
				
				retDayPVLst.add(returnMap);
			}
		}
		retMap.put("retDayPVLst", retDayPVLst);
		
		SimpleDateFormat sdfm = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdfm.format(new Date());
		// 每15分钟一个间隔获取1天96个时间的集合
		List<Map<String, Object>> minLst = DateUtil.getDayMonYearTimLst(crtTim, "1");
		
		List<Map<String, Object>> pv15MinPowerLst = new ArrayList<Map<String,Object>>();
		
		for(Map<String, Object> minMap:minLst){
			
			Map<String,Object> pv15MinPowerMap = new HashMap<String, Object>();
			
			Double pv15Power = 0.0;
			
			Integer pv15Count = 0;
			
			// 将从96个时间点集合中取出的开始时间，取出并转化成long类型数字串
			long staTimL = sdfm.parse(minMap.get("sta_tim").toString()).getTime();
			// 将从96个时间点集合中取出的结束时间，取出并转化成long类型数字串
			long endTimL = sdfm.parse(minMap.get("end_tim").toString()).getTime();
			// 将从96个时间点集合中取出的展示时间，取出并转化成long类型数字串
			long tolTimL = Long.valueOf(minMap.get("tol_tim").toString());
			
			if(pwsPowerLst != null && !pwsPowerLst.isEmpty() && pwsPowerLst.get(0) != null){
				
				for(Map<String, Object> pwsPowerMap : pwsPowerLst){
					
					List<Map<String, Object>> pv15MinLst = (ArrayList<Map<String, Object>>)pwsPowerMap.get("pv15MinLst");
					
					if(pv15MinLst != null && !pv15MinLst.isEmpty() && pv15MinLst.get(0) != null){
						
						// 对曲线图点信息集合进行遍历
						Iterator<Map<String,Object>> it = pv15MinLst.iterator();
						
						while(it.hasNext()){
							
						    Map<String,Object> curMap = it.next();
						    // 将从数据库中取出的当前时间，取出并转化成long类型数字串
						    long crtTimL = sdfm.parse(curMap.get("crtTim").toString()).getTime();
						    
						    if(crtTimL<staTimL){
						    	
						    	it.remove();
						    	
						    }  else if(staTimL<=crtTimL && endTimL>=crtTimL){
						    	
						    	if(curMap.get("pv_power") != null){
						    		
						    		pv15Power = pv15Power + Double.valueOf(curMap.get("pv_power").toString());
						    	}
						    	
						    	pv15Count = pv15Count + 1;
						    	
						    	it.remove();
						    	
						    	break;
						    	
						    } else if(endTimL<crtTimL){
						    	
						    	break;
						    }
						}
					}
				}
			}
			
			if(pv15Count > 0){
				
				pv15MinPowerMap.put("power", new BigDecimal(pv15Power).toPlainString());
				
			}else{
				
				pv15MinPowerMap.put("power", null);
				
			}
			
			pv15MinPowerMap.put("tol_tim", tolTimL);
			
			pv15MinPowerLst.add(pv15MinPowerMap);
		}
		retMap.put("pv15MinPowerLst", pv15MinPowerLst);
		
		retLst.add(retMap);
		
		return retLst;
	}
	/**
	 * 获取   线路保护   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfByEquNum(Map<String, Object> map) throws Exception {
		
		return  lnepttDao.getLnepttInfByEquNum(map);
		
	}
	
	
	/**
	 * 获取   储能逆变器   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPcsInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  othersDao.getPcsInfByEquNumNew(map);
		
	}
	
	/**
	 * 获取   变压器   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsTranfRelInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  othersDao.getIscsTranfRelInfByEquNumNew(map);
		
	}
	
	
	/**
	 * 获取   电能质量监测   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPqsmsInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  othersDao.getPqsmsInfByEquNumNew(map);
		
	}
	
	
	/**
	 * 获取   光伏逆变器   设备的最新实时数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPvsInfByEquNumNew(Map<String, Object> map) throws Exception {
		
		return  othersDao.getPvsInfByEquNumNew(map);
		
	}
	
	
	
	/**
	 * 更新用户  站查看状态
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updUserSltOptStaByUserId(Map<String, Object> map) throws Exception {
		
		othersDao.updUserSltOptStaByUserId(map);
		
	}
	
	/**
	 * 更新用户  对告警信息是否可见
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updUserIsDefStaByUserId(Map<String, Object> map) throws Exception {
		
		othersDao.updUserIsDefStaByUserId(map);
		
	}
	
	/**
	 * 获取安卓最新版本
	 * 
	 * @param map
	 * @return 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getNewAppVarsion() throws Exception {
		
		return othersDao.getNewAppVarsion();
		
	}
	
	
}

