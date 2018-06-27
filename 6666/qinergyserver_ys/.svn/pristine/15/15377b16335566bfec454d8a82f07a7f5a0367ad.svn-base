package com.qinergy.controller.integratmonitor;

import java.text.SimpleDateFormat;
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
import com.qinergy.dto.PagerTwo;
import com.qinergy.service.integratmonitor.IntegratMonitorService;
import com.qinergy.service.login.UserService;
import com.qinergy.service.system.SystemService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.EhcacheUtil;
import com.qinergy.util.MobileConfig;

/**
 * 综合监控对前端页面接口类
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
public class IntegratMonitorController {
	// 声明
	private static Logger log = Logger.getLogger(IntegratMonitorController.class);

	@Autowired
	private IntegratMonitorService integratMonitorService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private UserService userService;

	@Autowired
	private EhcacheUtil ehcacheUtil;

	BaseTransferEntity baseTransferEntity;

	/*
	 * ########################################## 综合监控Start
	 * ##########################################
	 */



	/**
	 * 查询信息，使用上级公司ID
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getComInfByFatId")
	@ResponseBody
	public BaseTransferEntity getComInfByFatId(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String com_fat_id = request.getParameter("com_fat_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("com_fat_id", com_fat_id);

			List<Map<String, Object>> lst = integratMonitorService.getComInfByFatId(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("IntegratMonitorController getComInfByFatId--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 删除公司信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delComInf")
	@ResponseBody
	public BaseTransferEntity delComInf(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String com_id = request.getParameter("com_id");

			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("com_id", com_id);

			integratMonitorService.delComInf(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("操作者ID为：" + use_id + ",对公司表（bas_com）中的ID为：" + com_id + "的数据进行了删除操作！");

		} catch (Exception e) {

			log.error("IntegratMonitorController delComInf--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}




	/*
	 * ########################################## 综合监控End
	 * ##########################################
	 */



	/**
	 * 获取所有厂家的ID与厂家名称
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAllManInf")
	@ResponseBody
	public BaseTransferEntity getAllManInf(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			List<Map<String, Object>> lst = integratMonitorService.getAllManInf();

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("IntegratMonitorController login--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 获取所有设备为充电桩的型号
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAllAppModInf")
	@ResponseBody
	public BaseTransferEntity getAllAppModInf(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备类型唯一标识ID
			String typ_ide = request.getParameter("typ_ide");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("typ_ide", typ_ide);

			List<Map<String, Object>> lst = integratMonitorService.getAllAppModInf(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("IntegratMonitorController login--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}


	/**
	 * 获取应用在服务器主机上的实际根目录
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public static String getWebRootPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("/");
	}

	/*
	 * ##########################################
	 *              综合监控中与站有关的所有接口Start
	 * ##########################################
	 */
	/**
	 * 使用电站ID:pws_id,获取该电站中所有的设备类型，返回值中：equ_count设备数量、equ_typ_nam设备类型名称、app_typ_id设备类型ID
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsAllAppTypByPwsId")
	@ResponseBody
	public BaseTransferEntity getPwsAllAppTypByPwsId(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			String pws_id = request.getParameter("pws_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			List<Map<String, Object>> appTypLst = integratMonitorService.getPwsAllAppTypByPwsId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(appTypLst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("IntegratMonitorController getPwsAllAppTypByPwsId--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	/**
	 * 获取电站详情页面的所有信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsInfByPwsId")
	@ResponseBody
	public BaseTransferEntity getPwsInfByPwsId(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String pws_id = request.getParameter("pws_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			List<Map<String, Object>> pwsInfLst = integratMonitorService.getPwsInfByPwsId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(pwsInfLst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("IntegratMonitorController getPwsInfByPwsId--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	/**
	 * 获取电站详情页面的所有信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsInfByPwsIdApp")
	@ResponseBody
	public BaseTransferEntity getPwsInfByPwsIdApp(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String pws_id = request.getParameter("pws_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			List<Map<String, Object>> pwsInfLst = integratMonitorService.getPwsInfByPwsId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(pwsInfLst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("IntegratMonitorController getPwsInfByPwsId--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 根据设备编号获取 设备变位信息（分页）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDeflInfByEquNum")
	@ResponseBody
	public BaseTransferEntity getDeflInfByEquNum(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			PagerTwo page = new PagerTwo();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 设备编码
			String equ_num = request.getParameter("equ_num");
			// 查询中时间段开始时间
			String sta_tim = request.getParameter("sta_tim");
			// 查询中时间段结束时间
			String end_tim = request.getParameter("end_tim");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("equ_num", equ_num);
			
			map.put("sta_tim", sta_tim);
			
			if(end_tim != null && !end_tim.isEmpty()){
				
				SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
				
				map.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));
			}
			
			
			Map<String, Object> couMap = integratMonitorService.getDeflInfByEquNumCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));
			
			map.put("evertPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = integratMonitorService.getDeflInfByEquNum(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController getDeflInfByEquNum--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	/*
	 * ##########################################
	 *              综合监控中与站有关的所有接口End
	 * ##########################################
	 */
}
