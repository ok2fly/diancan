package com.qinergy.service.statisticanalysis.analysis.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.statisticanalysis.analysis.EfficAnalysisDao;
import com.qinergy.service.statisticanalysis.analysis.EfficAnalysisService;
import com.qinergy.util.DateUtil;

@Service("analysisService")
public class EfficAnalysisServiceImpl implements EfficAnalysisService {

	@Autowired
	EfficAnalysisDao analysisDao;

	@Override
	public List<Map<String, Object>> getStationListByComId(Map<String, Object> map) throws Exception {
		return analysisDao.getStationListByComId(map);
	}

	/**
	 * 综合效率分析接口
	 */
	@Override
	public List<Map<String, Object>> getOverallEffic(String pws_id, String tim_type, String tim_point) throws Exception {

		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		 
		if ("3".equals(tim_type)) {
			/** type = 4：一年的两个时间点 */

			// 获取某年、月、日起始和结束时间点集合(获取任意一年的 startTim和endTim)
			List<Map<String, Object>> monthTimList = DateUtil.getDayMonYearTimLst(tim_point, "3");

			if (monthTimList != null && monthTimList.size() > 0) {

				for (Map<String, Object> monthTim : monthTimList) {

					Map<String, Object> mapParam = new HashMap<String, Object>();
					
					Map<String, Object> returnMap = new HashMap<String, Object>();
					
					mapParam.put("pws_id", pws_id);
					
					mapParam.put("startTim", monthTim.get("staTim"));
					
					mapParam.put("endTim", monthTim.get("endTim"));

					// 获取一条 月统计数据
					List<Map<String, Object>> pvsLst = analysisDao.getOverallEfficPVS(mapParam);

					if(pvsLst != null && !pvsLst.isEmpty()){
						
						for(Map<String, Object> pvsMap:pvsLst){
							
							returnMap.put("pvs_power", pvsMap.get("pvs_power"));
						}
					}
					// 综合效率分析(效率)
					List<Map<String, Object>> effLst = analysisDao.getOverallEfficEff(mapParam);
					
					if(effLst != null && !effLst.isEmpty()){
						
						for(Map<String, Object> effMap:effLst){
							
							returnMap.put("whe_equ", effMap.get("whe_equ"));
							
							returnMap.put("com_eff", effMap.get("com_eff"));
							
							returnMap.put("plan_com_rate", effMap.get("plan_com_rate"));
							
							returnMap.put("int_cha", effMap.get("int_cha"));
						}
					}
					// 综合效率分析(辐射)
					List<Map<String, Object>> hvLst = analysisDao.getOverallEfficHv(mapParam);
					
					if(hvLst != null && !hvLst.isEmpty()){
						
						for(Map<String, Object> hvMap:hvLst){
							
							returnMap.put("radiation", hvMap.get("pvs_radiation_tol"));
						}
					}
					
					returnMap.put("tol_tim", monthTim.get("staTim"));

					listResult.add(returnMap);
				}
			}
		}

		return listResult;
	}

	/**
	 * 计划完成率
	 */
	@Override
	public List<Map<String, Object>> getPlanComplRate(String pws_id, String tim_type, String tim_point)
			throws Exception {

		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();

		/** type = 4：一年的两个时间点 */
		if ("3".equals(tim_type)) {
			// 获取某年、月、日起始和结束时间点集合(获取任意一年的 （eq: staTim:2017-1-1 & endTim:2018-1-1）)
			List<Map<String, Object>> monTimPoint = DateUtil.getDayMonYearTimLst(tim_point, "3");

			if (monTimPoint != null && monTimPoint.size() > 0) {

				Map<String, Object> mapParam = null;

				Double realPvsPowerSum = 0.0;
				
				Double planPvsPowerSum = 0.0;
				
				Map<String, Object> mapResult = null;
				// 时间点集合循环遍历
				for (Map<String, Object> monthTim : monTimPoint) {

					mapParam = new HashMap<String, Object>();
					
					mapParam.put("pws_id", pws_id);
					
					mapParam.put("startTim", monthTim.get("staTim"));
					
					mapParam.put("endTim", monthTim.get("endTim"));

					mapResult = new HashMap<String, Object>();
					// 获取 实际发电量
					List<Map<String, Object>> realPvsPower = analysisDao.getMonthDataStation(mapParam);
					
					if (realPvsPower != null && realPvsPower.size() > 0) {

						mapResult.put("pvs_power", realPvsPower.get(0).get("pvs_power"));
						
						realPvsPowerSum += (Double) realPvsPower.get(0).get("pvs_power");
					}

					// 获取 计划发电量
					List<Map<String, Object>> planPvsPower = analysisDao.getPlanPvsPower(mapParam);
					
					if (planPvsPower != null && planPvsPower.size() > 0) {
						
						mapResult.putAll(planPvsPower.get(0));
					
						if(planPvsPower.get(0).get("plan_power") != null){
							
							planPvsPowerSum += (Double) planPvsPower.get(0).get("plan_power");
						}
					}

					mapResult.put("tol_tim", monthTim.get("staTim"));
					
					listResult.add(mapResult);
				}

				// 计算得到 完成率 并放入集合
				if (planPvsPowerSum > 0) {
					
					mapResult = new HashMap<String, Object>();
					
					Double planRate = (realPvsPowerSum / planPvsPowerSum)*100;
					
					mapResult.put("planRate", planRate);
					
					listResult.add(mapResult);
				}
			}
		}

		return listResult;
	}

	/**
	 * 弃光率 统计数据
	 */
	@Override
	public List<Map<String, Object>> getDiscardRate(String pws_id, String tim_type, String tim_point) throws Exception {

		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();

		if ("3".equals(tim_type)) {
			// 按年 统计(查询一年的弃光率数据 (eq: tim_point:2017-01-01) )
			listResult = getDiscardRateByYear(pws_id, tim_point);
			
		} else if ("2".equals(tim_type)) {
			// 查询一个月的弃光率数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
			listResult = getDiscardRateByMonthSingle(pws_id, tim_point);
		}

		return listResult;
	}

	/** 
	 * 查询一年的弃光率数据 (eq: tim_point:2017-01-01) 
	 */
	private List<Map<String, Object>> getDiscardRateByYear(String pws_id, String tim_point) throws Exception {

		List<Map<String, Object>> yearListResult = new ArrayList<Map<String, Object>>();

		// 获取任意一年的 startTim和endTim( eq: staTim:2017-1-1 endTim:2018-1-1)
		List<Map<String, Object>> monTimPoint = DateUtil.getDayMonYearTimLst(tim_point, "4");

		if (monTimPoint != null && monTimPoint.size() > 0) {

			// 获取 一年中每个月的 startTim和endTim 集合
			if (monTimPoint != null && monTimPoint.size() > 0) {
				// 循环遍历月份时间点集合
				for (Map<String, Object> monthTim : monTimPoint) {
					
					if (monthTim != null && monthTim.size() > 0) {
						// 计算一个月弃光率的数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 月电量为日累加，月比率为日累加 /天数 
						Map<String, Object> discardRateSumByMonth = getDiscardRateSumByMonth(pws_id,(String) monthTim.get("staTim"), (String) monthTim.get("endTim"));
						
						if(discardRateSumByMonth == null || discardRateSumByMonth.isEmpty()){
							
							discardRateSumByMonth = new HashMap<String, Object>();
							
						}
						discardRateSumByMonth.put("tol_tim", monthTim.get("staTim"));
						
						yearListResult.add(discardRateSumByMonth);
					}
				}
			}
		}

		return yearListResult;
	}

	/** 
	 * 计算一个月弃光率的数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 月电量为日累加，月比率为日累加 /天数
	 */
	private Map<String, Object> getDiscardRateSumByMonth(String pws_id, String staTim, String endTim) throws Exception {
		
		Map<String, Object> sumMonth = new HashMap<String, Object>();

		// 变量声明
		Date tol_tim = null;
		
		Double dis_power = 0.0;
		
		Double mai_dis_power = 0.0;
		
		Double fal_dis_power = 0.0;
		
		Double rat_dis_power = 0.0;
		
		Double dis_rate = 0.0;
		
		Double mai_dis_rate = 0.0;
		
		Double fal_dis_rate = 0.0;
		
		Double rat_dis_rate = 0.0;
		// 查询一个月的弃光率数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
		List<Map<String, Object>> discardRateByMonth = getDiscardRateByMonth(pws_id,staTim,endTim);
		
		if (discardRateByMonth != null && discardRateByMonth.size() > 0) {
			
			for (Map<String, Object> discardRate : discardRateByMonth) {

				if (discardRate != null && !discardRate.isEmpty()) {
					// 变量赋值与累加计算
					tol_tim = (Date) discardRate.get("tol_tim");
					
					dis_power += (Double) discardRate.get("dis_power");
					
					mai_dis_power += (Double) discardRate.get("mai_dis_power");
					
					fal_dis_power += (Double) discardRate.get("fal_dis_power");
					
					rat_dis_power += (Double) discardRate.get("rat_dis_power");
					
					dis_rate += (Double) discardRate.get("dis_rate");
					
					mai_dis_rate += (Double) discardRate.get("mai_dis_rate");
					
					fal_dis_rate += (Double) discardRate.get("fal_dis_rate");
					
					rat_dis_rate += (Double) discardRate.get("rat_dis_rate");
					
				}
			}
			// 生成返回数据集合
			sumMonth.put("tol_tim_total", tol_tim);
			
			sumMonth.put("dis_power_total", dis_power);
			
			sumMonth.put("mai_dis_power_total", mai_dis_power);
			
			sumMonth.put("fal_dis_power_total", fal_dis_power);
			
			sumMonth.put("rat_dis_power_total", rat_dis_power);
			
			sumMonth.put("dis_rate",     (dis_rate / discardRateByMonth.size()));
			
			sumMonth.put("mai_dis_rate", (mai_dis_rate / discardRateByMonth.size()));
			
			sumMonth.put("fal_dis_rate", (fal_dis_rate / discardRateByMonth.size()));
			
			sumMonth.put("rat_dis_rate", (rat_dis_rate / discardRateByMonth.size()));
		}
		return sumMonth;
	}

	/** 
	 * 查询一个月的弃光率数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
	 */
	private List<Map<String, Object>> getDiscardRateByMonth(String pws_id, String staTim,String endTim)
			throws Exception {

		List<Map<String, Object>> monthListResult = new ArrayList<Map<String, Object>>();

		// 获取 一年中每个月的 startTim和endTim 集合
		List<Map<String, Object>> dayTimList = DateUtil.getDayMonYearTimBettwenLst(staTim,endTim, "2");

		Map<String, Object> mapParam = null;
		
		Map<String, Object> mapResult = null;
		
		if (dayTimList != null && dayTimList.size() > 0) {
		
			for (Map<String, Object> dayTim : dayTimList) {
				// 构建请求参数对象
				mapParam = new HashMap<String, Object>();
				
				mapParam.put("pws_id", pws_id);
			
				mapParam.put("startTim", dayTim.get("staTim"));
				
				mapParam.put("endTim", dayTim.get("endTim"));

				mapResult = new HashMap<String, Object>();
				// 获取 某一天的 弃光率 数据
				List<Map<String, Object>> discardRate = analysisDao.getDiscardRate(mapParam);
				
				if (discardRate != null && discardRate.size() > 0) {

					Double mai_dis_power = (Double) discardRate.get(0).get("mai_dis_power");
					
					Double fal_dis_power = (Double) discardRate.get(0).get("fal_dis_power");
					
					Double rat_dis_power = (Double) discardRate.get(0).get("rat_dis_power");
					// 计算一天的总弃光量
					Double dis_power = mai_dis_power + fal_dis_power + rat_dis_power;

					// 构建返回值集合
					mapResult.put("dis_power", dis_power);
					
					mapResult.put("mai_dis_power", mai_dis_power);
					
					mapResult.put("fal_dis_power", fal_dis_power);
					
					mapResult.put("rat_dis_power", rat_dis_power);
					
					mapResult.put("dis_rate", discardRate.get(0).get("dis_rate"));
					
					mapResult.put("mai_dis_rate", discardRate.get(0).get("mai_dis_rate"));
					
					mapResult.put("fal_dis_rate", discardRate.get(0).get("fal_dis_rate"));
					
					mapResult.put("rat_dis_rate", discardRate.get(0).get("rat_dis_rate"));
					
				}
				mapResult.put("tol_tim", dayTim.get("staTim"));
				
				monthListResult.add(mapResult);
			}
		}
		return monthListResult;
	}
	
	/** 
	 * 查询一个月的弃光率数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
	 */
	private List<Map<String, Object>> getDiscardRateByMonthSingle(String pws_id, String tim_point)
			throws Exception {
		
		List<Map<String, Object>> monthListResult = new ArrayList<Map<String, Object>>();
		
		// 获取 一年中每个月的 startTim和endTim 集合
		List<Map<String, Object>> dayTimList = DateUtil.getDayMonYearTimLst(tim_point, "2");
		
		Map<String, Object> mapParam = null;
		
		Map<String, Object> mapResult = null;
		
		if (dayTimList != null && dayTimList.size() > 0) {
			
			for (Map<String, Object> dayTim : dayTimList) {
				// 构建请求参数对象
				mapParam = new HashMap<String, Object>();
				
				mapParam.put("pws_id", pws_id);
				
				mapParam.put("startTim", dayTim.get("staTim"));
				
				mapParam.put("endTim", dayTim.get("endTim"));
				
				mapResult = new HashMap<String, Object>();
				// 获取 某一天的 弃光率 数据
				List<Map<String, Object>> discardRate = analysisDao.getDiscardRate(mapParam);
				
				if (discardRate != null && discardRate.size() > 0) {
					
					Double mai_dis_power = (Double) discardRate.get(0).get("mai_dis_power");
					
					Double fal_dis_power = (Double) discardRate.get(0).get("fal_dis_power");
					
					Double rat_dis_power = (Double) discardRate.get(0).get("rat_dis_power");
					// 计算一天的总弃光量
					Double dis_power = mai_dis_power + fal_dis_power + rat_dis_power;
					// 构建返回值集合
					mapResult.put("dis_power", dis_power);
					
					mapResult.put("mai_dis_power", mai_dis_power);
					
					mapResult.put("fal_dis_power", fal_dis_power);
					
					mapResult.put("rat_dis_power", rat_dis_power);
					
					mapResult.put("dis_rate", discardRate.get(0).get("dis_rate"));
					
					mapResult.put("mai_dis_rate", discardRate.get(0).get("mai_dis_rate"));
					
					mapResult.put("fal_dis_rate", discardRate.get(0).get("fal_dis_rate"));
					
					mapResult.put("rat_dis_rate", discardRate.get(0).get("rat_dis_rate"));
				}
				
				mapResult.put("tol_tim", dayTim.get("staTim"));
				
				monthListResult.add(mapResult);
			}
		}
		return monthListResult;
	}

	/**
	 * 能耗分析
	 */
	@Override
	public List<Map<String, Object>> getLossAnalysis(String pws_id, String tim_type, String tim_point) throws Exception {
		
		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();

		if ("3".equals(tim_type)) {
			// 按年 统计
			listResult = getLossAnalysisByYear(pws_id, tim_point);
		
		} else if ("2".equals(tim_type)) {
			// 询一个月的损耗数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
			listResult = getLossAnalysisByMonthSingle(pws_id, tim_point);
		}

		return listResult;
	}

	/** 
	 * 查询一个月的损耗数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
	 */
	private List<Map<String, Object>> getLossAnalysisByMonth(String pws_id, String staTim, String endTim)
			throws Exception {

		List<Map<String, Object>> monthListResult = new ArrayList<Map<String, Object>>();

		// 获取 一年中每个月的 startTim和endTim 集合
		List<Map<String, Object>> dayTimList = DateUtil.getDayMonYearTimBettwenLst(staTim, endTim, "2");

		Map<String, Object> mapParam = null;
		
		Map<String, Object> mapResult = null;
		
		if (dayTimList != null && dayTimList.size() > 0) {
			
			for (Map<String, Object> dayTim : dayTimList) {
				// 构建查询请求参数对象
				mapParam = new HashMap<String, Object>();
			
				mapParam.put("pws_id", pws_id);
				
				mapParam.put("startTim", dayTim.get("staTim"));
				
				mapParam.put("endTim", dayTim.get("endTim"));

				mapResult = new HashMap<String, Object>();
				// 获取 某一天的 弃光率 数据
				List<Map<String, Object>> lossAnalysis = analysisDao.getLossAnalysis(mapParam);

				if (lossAnalysis != null && lossAnalysis.size() > 0) {
					// 构建返回数据对象集合
					mapResult.put("tol_tim", lossAnalysis.get(0).get("tol_tim"));
					
					mapResult.put("loss_tol_whe_equ", lossAnalysis.get(0).get("loss_tol_whe_equ"));
					
					mapResult.put("loss_bot_sta_whe_equ", lossAnalysis.get(0).get("loss_bot_sta_whe_equ"));
					
					mapResult.put("loss_sel_bxch_whe_equ", lossAnalysis.get(0).get("loss_sel_bxch_whe_equ"));
					
					mapResult.put("loss_inv_whe_equ", lossAnalysis.get(0).get("loss_inv_whe_equ"));
					
					mapResult.put("loss_pv_arr_abs_whe_equ", lossAnalysis.get(0).get("loss_pv_arr_abs_whe_equ"));
					
					mapResult.put("loss_pv_arr_abs_whe_equ", lossAnalysis.get(0).get("loss_pv_arr_abs_whe_equ"));
					
					mapResult.put("loss_pv_arr_abs_whe_equ", lossAnalysis.get(0).get("loss_pv_arr_abs_whe_equ"));
				}
				monthListResult.add(mapResult);
			}
		}
		return monthListResult;
	}
	
	/** 
	 * 查询一个月的损耗数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
	 */
	private List<Map<String, Object>> getLossAnalysisByMonthSingle(String pws_id, String staTim)
			throws Exception {
		
		List<Map<String, Object>> monthListResult = new ArrayList<Map<String, Object>>();
		
		// 获取 一年中每个月的 startTim和endTim 集合
		List<Map<String, Object>> dayTimList = DateUtil.getDayMonYearTimLst(staTim,"2");
		
		Map<String, Object> mapParam = null;
		
		Map<String, Object> mapResult = null;
		
		if (dayTimList != null && dayTimList.size() > 0) {
			
			for (Map<String, Object> dayTim : dayTimList) {
				// 构建请求参数集合
				mapParam = new HashMap<String, Object>();
				
				mapParam.put("pws_id", pws_id);
				
				mapParam.put("startTim", dayTim.get("staTim"));
				
				mapParam.put("endTim", dayTim.get("endTim"));
				
				mapResult = new HashMap<String, Object>();
				// 获取 某一天的 损耗分析 数据
				List<Map<String, Object>> lossAnalysis = analysisDao.getLossAnalysis(mapParam);
				
				if (lossAnalysis != null && lossAnalysis.size() > 0) {
					// 构建返回数据集合
					mapResult.put("loss_tol_whe_equ", lossAnalysis.get(0).get("loss_tol_whe_equ"));
					
					mapResult.put("loss_bot_sta_whe_equ", lossAnalysis.get(0).get("loss_bot_sta_whe_equ"));
					
					mapResult.put("loss_sel_bxch_whe_equ", lossAnalysis.get(0).get("loss_sel_bxch_whe_equ"));
					
					mapResult.put("loss_inv_whe_equ", lossAnalysis.get(0).get("loss_inv_whe_equ"));
					
					mapResult.put("loss_pv_arr_abs_whe_equ", lossAnalysis.get(0).get("loss_pv_arr_abs_whe_equ"));
					
					mapResult.put("net_power_whe_equ", lossAnalysis.get(0).get("net_power_whe_equ"));
					
					mapResult.put("com_eff", lossAnalysis.get(0).get("com_eff"));
				}
				
				mapResult.put("tol_tim", dayTim.get("staTim"));
				
				monthListResult.add(mapResult);
			}
		}
		return monthListResult;
	}

	/** 
	 * 计算一个月损耗的数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
	 */
	private Map<String, Object> getLossAnalysisSumByMonth(String pws_id, String staTim, String endTim) throws Exception {
		
		Map<String, Object> sumMonth = new HashMap<String, Object>();

		// 变量声明
		
		Date tol_tim = null;
		Double loss_tol_whe_equ = 0.0;
		Double loss_bot_sta_whe_equ = 0.0;
		Double loss_sel_bxch_whe_equ = 0.0;
		Double loss_inv_whe_equ = 0.0;
		Double loss_pv_arr_abs_whe_equ = 0.0; 
		Double net_power_whe_equ = 0.0; 
		Double com_eff = 0.0; 

		// 查询一个月的损耗数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
		List<Map<String, Object>> lossAnalysisByMonth = getLossAnalysisByMonth(pws_id, staTim, endTim);
		
		if (lossAnalysisByMonth != null && lossAnalysisByMonth.size() > 0) {
			
			for (Map<String, Object> lossAnalysis : lossAnalysisByMonth) {
				
				if (lossAnalysis != null && !lossAnalysis.isEmpty()) {
					// 返回的损耗数据计算(累加)
					tol_tim  = (Date) lossAnalysis.get("tol_tim");
					
					loss_tol_whe_equ += (Double) lossAnalysis.get("loss_tol_whe_equ");
					
					loss_bot_sta_whe_equ += (Double) lossAnalysis.get("loss_bot_sta_whe_equ");
					
					loss_sel_bxch_whe_equ += (Double) lossAnalysis.get("loss_sel_bxch_whe_equ");
					
					loss_inv_whe_equ += (Double) lossAnalysis.get("loss_inv_whe_equ");
					
					loss_pv_arr_abs_whe_equ += (Double) lossAnalysis.get("loss_pv_arr_abs_whe_equ");
					
					net_power_whe_equ += (Double) lossAnalysis.get("net_power_whe_equ");
					
					com_eff += (Double) lossAnalysis.get("com_eff");
				}
			}
			// 构建返回数据集合
			sumMonth.put("tol_tim", tol_tim);
			
			sumMonth.put("loss_tol_whe_equ", loss_tol_whe_equ);
			
			sumMonth.put("loss_bot_sta_whe_equ", loss_bot_sta_whe_equ);
			
			sumMonth.put("loss_sel_bxch_whe_equ", loss_sel_bxch_whe_equ);
			
			sumMonth.put("loss_inv_whe_equ", loss_inv_whe_equ);
			
			sumMonth.put("loss_pv_arr_abs_whe_equ", loss_pv_arr_abs_whe_equ);
			
			sumMonth.put("net_power_whe_equ", net_power_whe_equ);
			
			sumMonth.put("com_eff", com_eff);
		}
		return sumMonth;
	}

	/** 
	 * 查询一年的弃光率数据 (eq: tim_point:2017-01-01) 
	 */
	private List<Map<String, Object>> getLossAnalysisByYear(String pws_id, String tim_point) throws Exception {

		List<Map<String, Object>> yearListResult = new ArrayList<Map<String, Object>>();

		// 获取任意一年的 startTim和endTim( eq: staTim:2017-1-1 endTim:2018-1-1)
		List<Map<String, Object>> yearTimPoint = DateUtil.getDayMonYearTimBettwenLst(tim_point, tim_point, "4");

		if (yearTimPoint != null && yearTimPoint.size() > 0) {

			// 获取 一年中每个月的 startTim和endTim 集合(获取某年、月、日起始和结束时间点集合(传入minDate与maxDate))
			List<Map<String, Object>> monthTimList = DateUtil.getDayMonYearTimBettwenLst((String) yearTimPoint.get(0)
					.get("staTim"), (String) yearTimPoint.get(0).get("endTim"), "3");
			
			if (monthTimList != null && monthTimList.size() > 0) {
				
				for (Map<String, Object> monthTim : monthTimList) {
					
					if (monthTim != null && monthTim.size() > 0) {
						// 计算一个月损耗的数据 ( staTim:2017-02-01 endTim:2017-03-01 ) 
						Map<String, Object> lossAnalysisSumByMonth = getLossAnalysisSumByMonth(pws_id,
								(String) monthTim.get("staTim"), (String) monthTim.get("endTim"));

						yearListResult.add(lossAnalysisSumByMonth);
					}
				}
			}
		}

		return yearListResult;
	}

	/**
	 * 太阳能资源  查询纬度为日
	 */
	@Override
	public List<Map<String, Object>> getSolarEnergyResources(String pws_id, String tim_point) throws Exception {
		// 时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String initTim = DateUtil.initDate(new SimpleDateFormat("yyyy-MM-dd").parse(tim_point));// 初始化
		
		String endTim = sdf.format(DateUtil.addDay(sdf.parse(initTim), 1)); // 选中日期加一天
		// 构建数据查询请求参数对象
		Map<String, Object> mapParam = new HashMap<String, Object>();
		
		mapParam.put("pws_id", pws_id);
		
		mapParam.put("startTim", initTim);
		
		mapParam.put("endTim", endTim);
		// 获取15分钟曲线图方法(太阳能资源 曲线)
		return DateUtil.getFifteenMinutesCurves(tim_point,analysisDao.getSolarEnergyResources(mapParam));
	}

	/**
	 * 逆变器性能  查询纬度为月
	 */
	@Override
	public List<Map<String, Object>> getInverterProp(String pws_id, String tim_point) throws Exception {

		// 当月第一天
		Date firstDayOfMonth = DateUtil.getFirstDayOfMonth(new SimpleDateFormat("yyyy-MM-dd").parse(tim_point));
		
		String startTim = new SimpleDateFormat("yyyy-MM-dd").format(firstDayOfMonth);
		
		String endTim = DateUtil.addMonth(startTim);  // 月份加一
		// 构建数据查询请求参数对象
		Map<String, Object> mapParam = new HashMap<String, Object>();
		
		mapParam.put("pws_id", pws_id);
		
		mapParam.put("startTim", startTim);
		
		mapParam.put("endTim", endTim);
		// 获取逆变器性能数据
		return analysisDao.getInverterProp(mapParam);
	}



}
