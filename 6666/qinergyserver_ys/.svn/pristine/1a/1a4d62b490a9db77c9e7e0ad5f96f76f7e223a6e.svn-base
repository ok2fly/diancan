package com.qinergy.controller.statisticanalysis.analysis;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.service.statisticanalysis.analysis.EnergyConsumAnalysisService;
import com.qinergy.util.MobileConfig;

/**
 * @desc: 能耗分析控制器
 * @author: Qist
 * @date: 2017年11月4日
 */
@Controller
@RequestMapping(value = "")
public class EnergyConsAnalyController {

	private static Logger log = Logger.getLogger(EnergyConsAnalyController.class);

	@Autowired
	EnergyConsumAnalysisService consumAnalysisService;

	BaseTransferEntity baseTransferEntity;


	/**
	 * @Title: getElecStatistics  
	 * @Desc: 当月用电量 、率统计 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getElecStatistics")
	@ResponseBody
	public BaseTransferEntity getElecStatistics(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "yyyy-MM"
		String tim_point = request.getParameter("tim_point");

		try {
			Map<String, Object> elecStatistics = consumAnalysisService.getElecStatistics(pws_id, tim_point);
			baseTransferEntity.setData(elecStatistics);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("EnergyConsAnalyController: getElecStatistics:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getSynthElecAnalysis  
	 * @Desc: 综合电量分析 按年  
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getSynthElecAnalysis")
	@ResponseBody
	public BaseTransferEntity getSynthElecAnalysis(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		
		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");
				
		try {
			List<Map<String, Object>> synthElecAnalysis = consumAnalysisService.getSynthElecAnalysis(pws_id,tim_point);
			baseTransferEntity.setData(synthElecAnalysis);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("EnergyConsAnalyController: getSynthElecAnalysis:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}		
		
		return baseTransferEntity;
	}

	
	/**
	 * @Title: getElecAnalysis  
	 * @Desc: 厂用电量分析 取最近两年 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getElecAnalysis")
	@ResponseBody
	public BaseTransferEntity getElecAnalysis(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		
		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");
		
		try {
			Map<String, Object> elecAnalysis = consumAnalysisService.getElecAnalysis(pws_id, tim_point);
			baseTransferEntity.setData(elecAnalysis);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("EnergyConsAnalyController: getSynthElecAnalysis:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}	
		
		return baseTransferEntity;
	}
	
	
	/**
	 * @Title: getElecAnalysis  
	 * @Desc: 厂用电量分析 取最近两年   安卓接口
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getElecAnalysisApp")
	@ResponseBody
	public BaseTransferEntity getElecAnalysisApp(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		
		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");
		
		try {
			Map<String, Object> elecAnalysis = consumAnalysisService.getElecAnalysisApp(pws_id, tim_point);
			baseTransferEntity.setData(elecAnalysis);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("EnergyConsAnalyController: getElecAnalysisApp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}	
		
		return baseTransferEntity;
	}
	
	
}
