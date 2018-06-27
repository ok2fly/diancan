package com.qinergy.controller.statisticanalysis.analysis;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.service.statisticanalysis.analysis.SolarResourAnalysisService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;

/**
 * @desc: 太阳能资源分析控制器
 * @author: Qist
 * @date: 2017年11月4日
 */
@Controller
@RequestMapping(value = "")
public class SolarResourAnalysisController {

	private static Logger log = Logger.getLogger(SolarResourAnalysisController.class);

	@Autowired
	SolarResourAnalysisService solarResourAnalysisService;

	BaseTransferEntity baseTransferEntity;

	/**
	 * @Title: getSolarResources  
	 * @Desc:  辐射量对比 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getSolarResources")
	@ResponseBody
	public BaseTransferEntity getSolarResources(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "yyyy"
		String tim_point = request.getParameter("tim_point");

		String formatYear = DateUtil.formatYearToString(tim_point);
		try {
			Map<String, Object> solarResources = solarResourAnalysisService.getSolarResources(pws_id, formatYear);
			baseTransferEntity.setData(solarResources);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("SolarResourAnalysisController: getSolarData:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}
	
	/**
	 * @Title: getSolarResources  
	 * @Desc:  辐射量对比 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getSolarResourcesAp")
	@ResponseBody
	public BaseTransferEntity getSolarResourcesAp(HttpServletRequest request, HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();
		
		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "yyyy"
		String tim_point = request.getParameter("tim_point");
		
		String formatYear = DateUtil.formatYearToString(tim_point);
		try {
			
			Map<String, Object> solarResources = solarResourAnalysisService.getSolarResourcesAp(pws_id, formatYear);
			
			baseTransferEntity.setData(solarResources);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			baseTransferEntity.setData(null);
			
			log.error("SolarResourAnalysisController: getSolarResourcesAp:--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * @Title: getSolarResourcesApp  
	 * @Desc:  辐射量对比  App接口
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getSolarResourcesApp")
	@ResponseBody
	public BaseTransferEntity getSolarResourcesApp(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		
		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");
		String formatYear = DateUtil.formatYearToString(tim_point);
		try {
			Map<String, Object> solarResources = solarResourAnalysisService.getSolarResourcesApp(pws_id, formatYear);
			baseTransferEntity.setData(solarResources);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("SolarResourAnalysisController: getSolarData:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}

	
	
	/**
	* 获取综合监控  环境检测仪当天数据
	* @param request
	* @param response
	* @return
	*/
	@RequestMapping("/service/getSolarDataByEnvInfo")
	@ResponseBody
	public BaseTransferEntity getSolarDataByEnvInfo(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 站ID
			String pws_id = request.getParameter("pws_id");
			
			if(pws_id == null || pws_id == ""){
				log.error("getSolarDataByEnvInfo-- pws_id：站ID 参数为空！！！--------->");
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
				baseTransferEntity.setDesc("缺少 站ID 参数！！！");
				return baseTransferEntity;
			}
			
			Map<String, Object> solarDataByEnvInfo = solarResourAnalysisService.getSolarDataByEnvInfo(pws_id);

			baseTransferEntity.setData(solarDataByEnvInfo);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("EnvController getEnvInfoNew--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	
	
	
	/**
	 * @Title: getOverallEffic
	 * @Desc: 太阳能资源分布数据
	 * @return BaseTransferEntity
	 * @throws

	@RequestMapping("/service/getSolarData")
	@ResponseBody
	public BaseTransferEntity getSolarData(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		// 电站id
		String pws_id = request.getParameter("pws_id");
		// 当前时间点 "2017-02-06"
		String tim_point = request.getParameter("tim_point");

		try {
			List<Map<String, Object>> solarData = solarResourAnalysisService.getSolarData(pws_id, tim_point);
			baseTransferEntity.setData(solarData);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("SolarResourAnalysisController: getSolarData:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}
	 */
	
	
	
}
