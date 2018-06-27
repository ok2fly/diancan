package com.qinergy.controller.statisticanalysis.analysis;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.common.BaseConstants;
import com.qinergy.service.statisticanalysis.analysis.ElecEarnAnalysisService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;

/**
 * @desc: 电量与收益分析控制器
 * @author: Qist
 * @date: 2017年11月4日
 */
@Controller
@RequestMapping(value = "")
public class ElecEarnAnalysisController {

	private static Logger log = Logger.getLogger(ElecEarnAnalysisController.class);

	@Autowired
	ElecEarnAnalysisService earnAnalysisService;

	BaseTransferEntity baseTransferEntity;

	/**
	 * @Title: get25YearElecAnalysis
	 * @Desc: 25年 理论和实际的分析数据
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getElecAnalysisBy25Year")
	@ResponseBody
	public BaseTransferEntity getElecAnalysisBy25Year(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "yyyy"
		String tim_point = request.getParameter("tim_point");
		String formatYear = DateUtil.formatYearToString(tim_point);
		
		try {
			List<Map<String, Object>> year25ElecAnalysis = earnAnalysisService.getElecAnalysisBy25Year(pws_id, formatYear);
			baseTransferEntity.setData(year25ElecAnalysis);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("ElecEarnAnalysisController: get25YearElecAnalysis:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getForeElecAnalysisByHv
	 * @Desc: 预测下年上网电量 --根据辐射量
	 * 			type= 4
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getForeElecAnalysisByHv")
	@ResponseBody
	public BaseTransferEntity getForeElecAnalysisByHv(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");

		try {
			Map<String, Object> nextYearElecAnalysis = earnAnalysisService.getForeElecAnalysis(pws_id,
					BaseConstants.TYPE_FORE_ONLINE_ENERGY_BY_RAD, tim_point);
			baseTransferEntity.setData(nextYearElecAnalysis);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("ElecEarnAnalysisController: getNextYearElecAnalysisByHv:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getForeElecAnalysisByElec
	 * @Desc: 预测下年上网电量 --根据往年电量 
	 * 			type= 1
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getForeElecAnalysisByElec")
	@ResponseBody
	public BaseTransferEntity getForeElecAnalysisByElec(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");

		try {
			Map<String, Object> nextYearElecAnalysis = earnAnalysisService.getForeElecAnalysis(pws_id,
					BaseConstants.TYPE_FORE_ONLINE_ENERGY, tim_point);
			baseTransferEntity.setData(nextYearElecAnalysis);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("ElecEarnAnalysisController: getNextYearElecAnalysisByElec:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getPlanElecAnalysis
	 * @Desc: 计划上网电量 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getPlanElecAnalysis")
	@ResponseBody
	public BaseTransferEntity getPlanElecAnalysis(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前年份 	"yyyy"
		String tim_point = request.getParameter("tim_point");
		
		try {
			Map<String, Object> planElecAnalysis = earnAnalysisService.getPlanElecAnalysis(pws_id, tim_point);
			baseTransferEntity.setData(planElecAnalysis);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("ElecEarnAnalysisController: getPlanElecAnalysis:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}
	
	/**
	 * @Title: getPlanElecAnalysis
	 * @Desc: 计划上网电量 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getPlanElecAnalysisApp")
	@ResponseBody
	public BaseTransferEntity getPlanElecAnalysisApp(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		
		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前年份 	"yyyy"
		String tim_point = request.getParameter("tim_point");
		
		try {
			Map<String, Object> planElecAnalysis = earnAnalysisService.getPlanElecAnalysisApp(pws_id, tim_point);
			baseTransferEntity.setData(planElecAnalysis);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("ElecEarnAnalysisController: getPlanElecAnalysis:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	

}
