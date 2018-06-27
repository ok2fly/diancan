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
import com.qinergy.service.statisticanalysis.analysis.PowerRationAnalysisService;
import com.qinergy.util.MobileConfig;

/**
 * @desc: 功率预测与限电分析控制器
 * @author: Qist
 * @date: 2017年11月4日
 */
@Controller
@RequestMapping(value = "")
public class PowerRationAnalysisController {

	private static Logger log = Logger.getLogger(PowerRationAnalysisController.class);

	@Autowired
	PowerRationAnalysisService rationAnalysisService;

	BaseTransferEntity baseTransferEntity;

	/**
	 * @Title: getPowerRation
	 * @Desc: 功率预测与限电分析 查询纬度为 天（数据间隔为15分钟）
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getPowerRation")
	@ResponseBody
	public BaseTransferEntity getPowerRation(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");
		try {
			Map<String, Object> powerRation = rationAnalysisService.getPowerRation(pws_id, tim_point);
			baseTransferEntity.setData(powerRation);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("PowerRationAnalysisController: getPowerRation:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	
	/**
	 * @Title: getEnergyStorage  
	 * @Desc: 储能系统分析  查询纬度为年
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getEnergyStorage")
	@ResponseBody
	public BaseTransferEntity getEnergyStorage(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 1：按日 2： 按月 3：按年 4：多年
		String tim_type = request.getParameter("tim_type");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");
				
		try {

			List<Map<String, Object>> energyStorage = rationAnalysisService.getEnergyStorage(pws_id, tim_type, tim_point);
			baseTransferEntity.setData(energyStorage);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("PowerRationAnalysisController: getEnergyStorage:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
 
	
	
	
	/**
	 * @Title: getStorNetCharge  
	 * @Desc: 光储网荷分析  查询纬度为 天（数据间隔为15分钟） 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getStorNetCharge")
	@ResponseBody
	public BaseTransferEntity getStorNetCharge(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
	
		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 1：按日 2： 按月 3：按年 4：多年
		String tim_type = request.getParameter("tim_type");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");
		
		try {

			List<Map<String, Object>> storNetCharge = rationAnalysisService.getStorNetCharge(pws_id, tim_type, tim_point);
			baseTransferEntity.setData(storNetCharge);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("PowerRationAnalysisController: getEnergyStorage:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	
}
