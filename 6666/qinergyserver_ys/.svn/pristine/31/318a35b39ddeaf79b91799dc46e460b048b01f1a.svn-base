package com.qinergy.controller.statisticanalysis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.qinergy.dto.Pager;
import com.qinergy.service.statisticanalysis.StatisticAnalysisService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.EhcacheUtil;
import com.qinergy.util.MobileConfig;

/**
 * 统计分析对前端页面接口类
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "")
public class StatisticAnalysisController {
	// 声明
    private static Logger log = Logger.getLogger(StatisticAnalysisController.class);

    @Autowired
    private StatisticAnalysisService statisticAnalysisService;

    @Autowired
    private EhcacheUtil ehcacheUtil;

    /**
	 * 获取光伏设备月报表信息以及年报表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPVStaMonYear")
	@ResponseBody
	public BaseTransferEntity getPVStaMonYear(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			
			// 查询的月份或年份(以:2017-01-01方式输入)
			String date = request.getParameter("date");
			// 时间查询类型(2为月查询,3为年查询)
			String type = request.getParameter("type");
			// 电站ID(必输项)
			String pws_id = request.getParameter("pws_id");
			// 设备型号
			String app_mod = request.getParameter("app_mod");
			// 设备额定功率（容量）段，开始容量值
			String sta_rtd_pow = request.getParameter("sta_rtd_pow");
			// 设备额定功率（容量）段，结束容量值
			String end_rtd_pow = request.getParameter("end_rtd_pow");
			// 标记电量
			String flagValue = request.getParameter("flagValue");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("date", date);

			map.put("type", type);
			
			map.put("pws_id", pws_id);
			
			map.put("app_mod", app_mod);
			
			map.put("sta_rtd_pow", sta_rtd_pow);
			
			map.put("end_rtd_pow", end_rtd_pow);
			// 设备类型(GFNBQ为光伏逆变器)
			map.put("typ_ide", "GFNBQ");
			
			map.put("flagValue", flagValue);
			
			List<Map<String, Object>> lst = statisticAnalysisService.getPVStaMonYear(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getPVStaMonYear--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
    
	/**
	 * 获取光伏设备时间段报表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPVInfStaBetweenDay")
	@ResponseBody
	public BaseTransferEntity getPVInfStaBetweenDay(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			// 时间段查询，开始时间
			String sta_tim = request.getParameter("sta_tim");
			// 时间段查询，结束时间
			String end_tim = request.getParameter("end_tim");
			// 电站ID(必输项)
			String pws_id = request.getParameter("pws_id");
			// 设备型号
			String app_mod = request.getParameter("app_mod");
			// 设备额定功率（容量）段，开始容量值
			String sta_rtd_pow = request.getParameter("sta_rtd_pow");
			// 设备额定功率（容量）段，结束容量值
			String end_rtd_pow = request.getParameter("end_rtd_pow");
			// 标记电量
			String flagValue = request.getParameter("flagValue");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("sta_tim", sta_tim);
			
			map.put("end_tim", end_tim);
			
			map.put("pws_id", pws_id);
			
			map.put("app_mod", app_mod);
			
			map.put("sta_rtd_pow", sta_rtd_pow);
			
			map.put("end_rtd_pow", end_rtd_pow);
			// 设备类型(GFNBQ为光伏逆变器)
			map.put("typ_ide", "GFNBQ");
			
			map.put("flagValue", flagValue);
			
			List<Map<String, Object>> lst = statisticAnalysisService.getPVInfStaBetweenDay(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getPVInfStaBetweenDay--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取储能设备月报表信息以及年报表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPCStaMonYear")
	@ResponseBody
	public BaseTransferEntity getPCStaMonYear(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			// 查询的月份或年份(以:2017-01-01方式输入)
			String date = request.getParameter("date");
			// 时间查询类型(2为月查询,3为年查询)
			String type = request.getParameter("type");
			// 电站ID(必输项)
			String pws_id = request.getParameter("pws_id");
			// 设备型号
			String app_mod = request.getParameter("app_mod");
			// 设备额定功率（容量）段，开始容量值(容量上限)
			String sta_rtd_pow = request.getParameter("sta_rtd_pow");
			// 设备额定功率（容量）段，结束容量值(容量下限)
			String end_rtd_pow = request.getParameter("end_rtd_pow");
			// 标记电量(只标识放电量)
			String flagValue = request.getParameter("flagValue");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("date", date);
			
			map.put("type", type);
			
			map.put("pws_id", pws_id);
			
			map.put("app_mod", app_mod);
			
			map.put("sta_rtd_pow", sta_rtd_pow);
			
			map.put("end_rtd_pow", end_rtd_pow);
			// 设备类型(CNNBQ为储能逆变器)
			map.put("typ_ide", "CNNBQ");
			
			map.put("flagValue", flagValue);
			
			List<Map<String, Object>> lst = statisticAnalysisService.getPCStaMonYear(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getPCStaMonYear--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取储能设备时间段报表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPCInfStaBetweenDay")
	@ResponseBody
	public BaseTransferEntity getPCInfStaBetweenDay(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			// 时间段查询，开始时间
			String sta_tim = request.getParameter("sta_tim");
			// 时间段查询，结束时间
			String end_tim = request.getParameter("end_tim");
			// 电站ID(必输项)
			String pws_id = request.getParameter("pws_id");
			// 设备型号
			String app_mod = request.getParameter("app_mod");
			// 设备额定功率（容量）段，开始容量值
			String sta_rtd_pow = request.getParameter("sta_rtd_pow");
			// 设备额定功率（容量）段，结束容量值
			String end_rtd_pow = request.getParameter("end_rtd_pow");
			// 标记电量
			String flagValue = request.getParameter("flagValue");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("sta_tim", sta_tim);
			
			map.put("end_tim", end_tim);
			
			map.put("pws_id", pws_id);
			
			map.put("app_mod", app_mod);
			
			map.put("sta_rtd_pow", sta_rtd_pow);
			
			map.put("end_rtd_pow", end_rtd_pow);
			// 设备类型(CNNBQ为储能逆变器)
			map.put("typ_ide", "CNNBQ");
			
			map.put("flagValue", flagValue);
			
			List<Map<String, Object>> lst = statisticAnalysisService.getPCInfStaBetweenDay(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getPCInfStaBetweenDay--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取充电桩月报表信息以及年报表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getChpStaMonYear")
	@ResponseBody
	public BaseTransferEntity getChpStaMonYear(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			// 查询的月份或年份(以:2017-01-01方式输入)
			String date = request.getParameter("date");
			// 时间查询类型(2为月查询,3为年查询)
			String type = request.getParameter("type");
			// 电站ID(必输项)
			String pws_id = request.getParameter("pws_id");
			// 设备型号
			String app_mod = request.getParameter("app_mod");
			// 设备额定功率（容量）段，开始容量值(容量上限)
			String sta_rtd_pow = request.getParameter("sta_rtd_pow");
			// 设备额定功率（容量）段，结束容量值(容量下限)
			String end_rtd_pow = request.getParameter("end_rtd_pow");
			// 标记电量(只标识放电量)
			String flagValue = request.getParameter("flagValue");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("date", date);
			
			map.put("type", type);
			
			map.put("pws_id", pws_id);
			
			map.put("app_mod", app_mod);
			
			map.put("sta_rtd_pow", sta_rtd_pow);
			
			map.put("end_rtd_pow", end_rtd_pow);
			// 设备类型(CDZ为充电桩)
			map.put("typ_ide", "CDZ");
			
			map.put("flagValue", flagValue);
			
			List<Map<String, Object>> lst = statisticAnalysisService.getChpStaMonYear(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getChpStaMonYear--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取充电桩设备时间段报表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getChpInfStaBetweenDay")
	@ResponseBody
	public BaseTransferEntity getChpInfStaBetweenDay(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			// 时间段查询，开始时间
			String sta_tim = request.getParameter("sta_tim");
			// 时间段查询，结束时间
			String end_tim = request.getParameter("end_tim");
			// 电站ID(必输项)
			String pws_id = request.getParameter("pws_id");
			// 设备型号
			String app_mod = request.getParameter("app_mod");
			// 设备额定功率（容量）段，开始容量值
			String sta_rtd_pow = request.getParameter("sta_rtd_pow");
			// 设备额定功率（容量）段，结束容量值
			String end_rtd_pow = request.getParameter("end_rtd_pow");
			// 标记电量
			String flagValue = request.getParameter("flagValue");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("sta_tim", sta_tim);
			
			map.put("end_tim", end_tim);
			
			map.put("pws_id", pws_id);
			
			map.put("app_mod", app_mod);
			
			map.put("sta_rtd_pow", sta_rtd_pow);
			
			map.put("end_rtd_pow", end_rtd_pow);
			
			map.put("flagValue", flagValue);
			
			List<Map<String, Object>> lst = statisticAnalysisService.getChpInfStaBetweenDay(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getChpInfStaBetweenDay--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取指定站点指定年份的计划发电量列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPlanPowerLst")
	@ResponseBody
	public BaseTransferEntity getPlanPowerLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 站ID
			String pws_id = request.getParameter("pws_id");
			
			// 设备型号ID
			String date = request.getParameter("date");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("pws_id", pws_id);
			
			SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
			
			if(date != null && !date.isEmpty()){
				
				Calendar calendar = Calendar.getInstance();
				
				calendar.setTime(sdf.parse(date));
				
				int year = calendar.get(Calendar.YEAR);
				
				map.put("staTim", DateUtil.getYearMonthDayString(year, 1, 1));
				
				map.put("endTim", DateUtil.getYearMonthDayString(year + 1, 1, 1));		
				
			}
			
			Map<String, Object> couMap = statisticAnalysisService.getPlanPowerLstCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));
			
			map.put("evertPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = statisticAnalysisService.getPlanPowerLst(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getPlanPowerLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获得某计划电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPlanPowerInfById")
	@ResponseBody
	public BaseTransferEntity getPlanPowerInfById(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String id = request.getParameter("id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			
			List<Map<String, Object>> lst = statisticAnalysisService.getPlanPowerInfById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getPlanPowerInfById--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 新增计划发电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertPlanPower")
	@ResponseBody
	public BaseTransferEntity insertPlanPower(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String pws_id = request.getParameter("pws_id");
			
			String plan_power = request.getParameter("plan_power");
			
			String plan_tim = request.getParameter("plan_tim");
			
			String crt_use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			map.put("plan_power", plan_power);
			
			map.put("plan_tim", plan_tim);
			
			map.put("crt_use_id", crt_use_id);
			
			map.put("crt_tim", new Date());
			
			statisticAnalysisService.insertPlanPower(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController insertPlanPower--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 修改计划发电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updatePlanPower")
	@ResponseBody
	public BaseTransferEntity updatePlanPower(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String id = request.getParameter("id");
			
			String pws_id = request.getParameter("pws_id");
			
			String plan_power = request.getParameter("plan_power");
			
			String plan_tim = request.getParameter("plan_tim");
			
			String mod_use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			
			map.put("pws_id", pws_id);
			
			map.put("plan_power", plan_power);
			
			map.put("plan_tim", plan_tim);
			
			map.put("mod_use_id", mod_use_id);
			
			map.put("mod_tim", new Date());
			
			statisticAnalysisService.updatePlanPower(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController updatePlanPower--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 删除计划发电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/deletePlanPower")
	@ResponseBody
	public BaseTransferEntity deletePlanPower(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String id = request.getParameter("id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			
			statisticAnalysisService.deletePlanPower(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController deletePlanPower--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取采集数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getCollectDataLst")
	@ResponseBody
	public BaseTransferEntity getCollectDataLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 站ID
			String pws_id = request.getParameter("pws_id");
			// 设备编码
			String equ_num = request.getParameter("equ_num");
			// 指定时间段开始时间
			String sta_tim = request.getParameter("sta_tim");
			// 指定时间段结束时间
			String end_tim = request.getParameter("end_tim");
			// 页面中应该有查询类型选择框，查询要查询的采集数据，采集数据中：
			// CNNBQ代表查询储能逆变器，
			// DCDC代表查询DC/DC设备，
			// BYQ代表查询变压器设备，
			// DB代表查询电表设备，
			// DNZLJCZZ代表查询电能质量检测装置，
			// HLX代表查询汇流箱设备，
			// GFNBQ代表查询光伏逆变器设备，
			// JLPDG代表查询交流配电柜设备，
			// ZLPDG代表查询直流配电柜设备,
			// HJJCY代表查询环境检测仪设备，
			// CNDC代表查询储能电池设备，
			// JLZZ代表查询解列装置，
			// XLBH代表查询线路保护设备，
			// ZLCDZLC代表查询直流充电桩充电流程信息,
			// ZLCDZSS代表查询直流充电桩充电中实时数据，
			// ZLCDZDJ代表查询直流充电桩待机状态信息，
			// JLCDZLC代表查询直流充电桩充电流程信息,
			// JLCDZSS代表查询直流充电桩充电中实时数据，
			// JLCDZDJ代表查询直流充电桩待机状态信息，
			// DDQCGC代表查询电动汽车充电过程信息，
			// DDQCSS代表查询电动汽车充电信息实时数据,
			// KZQ代表查询控制器设备。
			// 建议上述类型代码，写死在页面中
			String typ_ide = request.getParameter("typ_ide");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("pws_id", pws_id);
			
			map.put("equ_num", equ_num);
			
			map.put("sta_tim", sta_tim);
			
			if(end_tim!=null && !end_tim.isEmpty()){
				
				SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
				
				map.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));
			}
			
			map.put("typ_ide", typ_ide);
			
			Map<String, Object> couMap = statisticAnalysisService.getCollectDataLstCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = statisticAnalysisService.getCollectDataLst(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getCollectDataLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取告警数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getFatDataLst")
	@ResponseBody
	public BaseTransferEntity getFatDataLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 站ID
			String pws_id = request.getParameter("pws_id");
			// 设备编码
			String equ_num = request.getParameter("equ_num");
			// 指定时间段开始时间
			String sta_tim = request.getParameter("sta_tim");
			// 指定时间段结束时间
			String end_tim = request.getParameter("end_tim");
			// 设备类型唯一标识
			String typ_ide = request.getParameter("typ_ide");
			
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("pws_id", pws_id);
			
			map.put("equ_num", equ_num);
			
			map.put("sta_tim", sta_tim);
			
			if(end_tim != null && !end_tim.isEmpty()){
				
				map.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));
			}
			map.put("typ_ide", typ_ide);
			map.put("use_id", use_id);
			
			Map<String, Object> couMap = statisticAnalysisService.getFatDataLstCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = statisticAnalysisService.getFatDataLst(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getFatDataLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取电站中年月报表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsYearMonthReportInfLst")
	@ResponseBody
	public BaseTransferEntity getPwsYearMonthReportInfLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 站ID
			String pws_id = request.getParameter("pws_id");
			// 指定时间(都以：2017-01-01格式传入)
			String date = request.getParameter("date");
			// type为1为月报表,type为2为年报表
			String type = request.getParameter("type");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			map.put("date", date);
			
			map.put("type", type);
			
			List<Map<String, Object>> lst = statisticAnalysisService.getPwsYearMonthReportInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getPwsYearMonthReportInfLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取电站中电表报表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsMeterReportInfLst")
	@ResponseBody
	public BaseTransferEntity getPwsMeterReportInfLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 指定时间段，开始时间
			String sta_tim = request.getParameter("sta_tim");
			// 指定时间段，结束时间
			String end_tim = request.getParameter("end_tim");
			// 电表类型（1为关口表，2为光伏表，3为充电表，4为负荷表，5为储能表）
			String meter_typ = request.getParameter("meter_typ");
			// 电站ID
			String pws_id = request.getParameter("pws_id");
			// 设备额定功率（容量）段，开始容量值
			String sta_rtd_pow = request.getParameter("sta_rtd_pow");
			// 设备额定功率（容量）段，结束容量值
			String end_rtd_pow = request.getParameter("end_rtd_pow");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("sta_tim", sta_tim);
			
			map.put("end_tim", end_tim);
			
			map.put("meter_typ", meter_typ);
			
			map.put("pws_id", pws_id);
			
			map.put("sta_rtd_pow", sta_rtd_pow);
			
			map.put("end_rtd_pow", end_rtd_pow);
			
			List<Map<String, Object>> lst = statisticAnalysisService.getPwsMeterReportInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getPwsMeterReportInfLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
}
