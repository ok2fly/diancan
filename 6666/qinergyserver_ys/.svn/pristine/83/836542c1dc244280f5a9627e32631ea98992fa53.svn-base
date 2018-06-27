package com.qinergy.controller.statisticanalysis.analysis;

import java.util.HashMap;
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
import com.qinergy.dto.common.BaseConstants;
import com.qinergy.service.statisticanalysis.analysis.EfficAnalysisService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;

/**
 * @desc: 电站分析（电站和设备分析）控制器
 * @author: Qist
 * @date: 2017年11月4日
 */
@Controller
@RequestMapping(value = "")
public class EfficAnalysisController {

	private static Logger log = Logger.getLogger(EfficAnalysisController.class);

	@Autowired
	EfficAnalysisService analysisService;

	BaseTransferEntity baseTransferEntity;

	/**
	 * @Title: getStationList
	 * @Desc: 根据公司id 获取所属电站列表
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getStationList")
	@ResponseBody
	public BaseTransferEntity getStationList(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		Map<String, Object> map = new HashMap<String, Object>();
		String com_id = request.getParameter("com_id");
		
		if(com_id == null || com_id == ""){
			log.error("StationAndEquAnalysisController: getStationList");
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc(" 参数com_id " + com_id);
			return baseTransferEntity;
		}
		
		map.put("com_id", com_id);
		map.put("del_flag", BaseConstants.DEL_FLAG_NO);
		try {

			List<Map<String, Object>> stationList = analysisService.getStationListByComId(map);
			baseTransferEntity.setData(stationList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("StationAndEquAnalysisController: getStationList:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getOverallEffic
	 * @Desc: 综合效率分析 图标数据 查询纬度为 年
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getOverallEffic")
	@ResponseBody
	public BaseTransferEntity getOverallEffic(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 1：按日 2： 按月 3：按年 4：多年
		String tim_type = request.getParameter("tim_type");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");

		try {
			List<Map<String, Object>> overallEffic = analysisService.getOverallEffic(pws_id, tim_type, tim_point);
			baseTransferEntity.setData(overallEffic);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("StationAndEquAnalysisController: getOverallEffic:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}
	
	/**
	 * @Title: getPlanComplRate
	 * @Desc: 计划完成率 分析 图标数据
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getPlanComplRate")
	@ResponseBody
	public BaseTransferEntity getPlanComplRate(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 1：按日 2： 按月 3：按年 4：多年
		String tim_type = request.getParameter("tim_type");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");

		try {
			List<Map<String, Object>> planComplRate = analysisService.getPlanComplRate(pws_id, tim_type, tim_point);
			baseTransferEntity.setData(planComplRate);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("StationAndEquAnalysisController: getPlanComplRate:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getDiscardRate
	 * @Desc: 弃光率 分析 图标数据
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getDiscardRate")
	@ResponseBody
	public BaseTransferEntity getDiscardRate(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 1：按日 2： 按月 3：按年 4：多年
		String tim_type = request.getParameter("tim_type");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");

		try {
			List<Map<String, Object>> discardRate = analysisService.getDiscardRate(pws_id, tim_type, tim_point);
			baseTransferEntity.setData(discardRate);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("StationAndEquAnalysisController: getDiscardRate:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getLossAnalysis
	 * @Desc: 损耗分析 图标数据
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getLossAnalysis")
	@ResponseBody
	public BaseTransferEntity getLossAnalysis(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 1：按日 2： 按月 3：按年 4：多年
		String tim_type = request.getParameter("tim_type");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");

		try {
			List<Map<String, Object>> lossAnalysis = analysisService.getLossAnalysis(pws_id, tim_type, tim_point);
			baseTransferEntity.setData(lossAnalysis);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("StationAndEquAnalysisController: getLossAnalysis:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getSolarEnergyResources
	 * @Desc: 太阳能资源 按天查询
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getSolarEnergyRes")
	@ResponseBody
	public BaseTransferEntity getSolarEnergyRes(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "2017-02-06 "
		String tim_point = request.getParameter("tim_point");

		try {
			List<Map<String, Object>> solarEnergyRes = analysisService.getSolarEnergyResources(pws_id, tim_point);
			baseTransferEntity.setData(solarEnergyRes);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("StationAndEquAnalysisController: getLossAnalysis:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}


	/**
	 * @Title: getInverterProp  
	 * @Desc:逆变器等效时 图标 分析数据 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getInverterProp")
	@ResponseBody
	public BaseTransferEntity getInverterProp(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "yyyy"
		String tim_point = request.getParameter("tim_point");
		
		try {
			List<Map<String, Object>> inverterProp = analysisService.getInverterProp(pws_id, tim_point);
			baseTransferEntity.setData(inverterProp);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("StationAndEquAnalysisController: getInverterProp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		
		
		return baseTransferEntity;
	}

}
