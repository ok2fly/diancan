package com.qinergy.controller.utils;

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
import com.qinergy.dto.Pager;
import com.qinergy.service.utils.UtilsService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.EhcacheUtil;
import com.qinergy.util.MobileConfig;

/**
 * 共用性接口有关对前端页面接口类
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
public class UtilsController {
	// 声明
    private static Logger log = Logger
                .getLogger(UtilsController.class);

    @Autowired
    private UtilsService utilsService;

    @Autowired
    private EhcacheUtil ehcacheUtil;

    /**
	 * 本接口为使用设备编号，获取该编号设备信息（设备详情页面中，右侧设备基础数据信息展示）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping(value = "/service/getEquInfByEquNum")
	@ResponseBody
	public BaseTransferEntity getEquInfByEquNum(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String equ_num = request.getParameter("equ_num");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("equ_num", equ_num);

			List<Map<String, Object>> lst = utilsService.getEquInfByEquNum(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UtilsController getEquInfByEquNum--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
    
    /**
     * 获取综合监控地图中的所有信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/service/getOrganizationHierarchyByUse")
    @ResponseBody
    public BaseTransferEntity getOrganizationHierarchyByUse(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		// 登录用户ID
    		String use_id = request.getParameter("use_id");
    		// 用户类型（1.运维人员，2.其它人员）
    		String use_typ = request.getParameter("use_typ");
    		// 运维人员/站查看状态（1：可查看（如果为运维公司时，可查看子公司人员和站信息，如果为业主公司，可查看与该公司站关联的所有运维人员），
    		// 2：不可查看（如果为运维公司，只能查看自己公司的人与站以及与自己有关的站的信息，如果为业主公司时，只能查看与自己有关的所有站的信息，
    		// 不能查看运维人员信息）），用户新建时，默认可见
    		String slt_opt_sta = request.getParameter("slt_opt_sta");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("use_id", use_id);
    		
    		map.put("use_typ", use_typ);
    		
    		map.put("slt_opt_sta", slt_opt_sta);
    		
    		List<Map<String, Object>> lst = utilsService.getOrganizationHierarchyByUse(map);
    		// ohu代表着获取综合监控地图中的所有信息
    		ehcacheUtil.addToCache("ohu-"+use_id, lst);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("UtilsController getOrganizationHierarchyByUse--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    
    /**
     * 从缓存中获取综合监控地图中的所有信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/service/getOrgHieFromEcache")
    @ResponseBody
    public BaseTransferEntity getOrgHieFromEcache(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		// 登录用户ID
    		String use_id = request.getParameter("use_id");
    		
    		// ohu代表着获取综合监控地图中的所有信息
    		Object ohu = ehcacheUtil.getCacheElement("ohu-"+use_id);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(ohu);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("UtilsController getOrgHieFromEcache--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    /**
     * 获取综合监控侧边栏数据
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/service/getIntMonLeftSide")
    @ResponseBody
    public BaseTransferEntity getIntMonLeftSide(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		// 登录用户ID
    		String use_id = request.getParameter("use_id");
    		
    		Map<String,Object> map = new HashMap<String, Object>();
    		
    		map.put("use_id", use_id);
    		
    		List<Map<String, Object>> lst = utilsService.getIntMonLeftSide(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("UtilsController getIntMonLeftSide--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    /**
     * 根据用户ID获取首页电站数量
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/service/getHomPagPwsCou")
    @ResponseBody
    public BaseTransferEntity getHomPagPwsCou(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		// 登录用户ID
    		String use_id = request.getParameter("use_id");
    		
    		Map<String,Object> map = new HashMap<String, Object>();
    		
    		map.put("use_id", use_id);
    		
    		List<Map<String, Object>> lst = utilsService.getHomPagPwsCou(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("UtilsController getHomPagPwsCou--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    /**
     * 使用字典类型，获取字典表中字典信息下拉列表
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/service/getDicInfLstByDicTyp")
    @ResponseBody
    public BaseTransferEntity getDicInfLstByDicTyp(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		// 字典类型唯一标识（如：电表类型为DBLX）
    		String dic_typ_ide = request.getParameter("dic_typ_ide");
    		
    		Map<String,Object> map = new HashMap<String, Object>();
    		
    		map.put("dic_typ_ide", dic_typ_ide);
    		
    		List<Map<String, Object>> lst = utilsService.getDicInfLstByDicTyp(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("UtilsController getDicInfLstByDicTyp--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    
    /**
     * 根据用户ID获取省份、城市、地区、电站间的从属关系
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPwsStaInfoByUseId")
    @ResponseBody
    public BaseTransferEntity getPwsStaInfoByUseId(HttpServletRequest request, HttpServletResponse response) {

    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 获取用户id
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);

			List<Map<String, Object>> lst = utilsService.getPwsStaInfo(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UtilsController getPwsStaInfo--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
    }
    
    
    /**
     * 使用设备类型唯一标识获取设备型号
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBasAppByAppTypIde")
    @ResponseBody
    public BaseTransferEntity getBasAppByAppTypIde(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		// 设备类型唯一标识
    		String app_typ_ide = request.getParameter("app_typ_ide");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("app_typ_ide", app_typ_ide);
    		
    		List<Map<String, Object>> lst = utilsService.getBasAppByAppTypIde(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("UtilsController getBasAppByAppTypIde--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	
    	return baseTransferEntity;
    }
    
    /**
     * 获取设备类型列表
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBasPwsTypLst")
    @ResponseBody
    public BaseTransferEntity getBasPwsTypLst(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		List<Map<String, Object>> lst = utilsService.getBasPwsTypLst();
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("UtilsController getBasPwsTypLst--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	
    	return baseTransferEntity;
    }
    
    /**
     * 获取所有用户姓名
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getUserName")
    @ResponseBody
    public BaseTransferEntity getUserName(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		baseTransferEntity.setData(utilsService.getUserName());
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("UtilsController getBasPwsTypLst--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	
    	return baseTransferEntity;
    }
    
	/**
	 * 根据电站id获取所有设备类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getSysBasAppTypeByPwsId")
	@ResponseBody
	public BaseTransferEntity getSysBasAppTypeByPwsId(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 电站id
			String pws_id = request.getParameter("pws_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("pws_id", pws_id);

			List<Map<String, Object>> lst = utilsService.getSysBasAppTypeByPwsId(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("UtilsController getSysBasAppTypeByPwsId--------->"+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 根据设备类型id获取设备编号
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getEquNumBySysBasAppTypeId")
	@ResponseBody
	public BaseTransferEntity getEquNumBySysBasAppTypeId(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备类型id
			String app_typ_id = request.getParameter("app_typ_id");
			// 电站id
			String pws_id = request.getParameter("pws_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("app_typ_id", app_typ_id);
			
			map.put("pws_id", pws_id);

			List<Map<String, Object>> lst = utilsService.getEquNumBySysBasAppTypeId(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("UtilsController getEquNumBySysBasAppTypeId--------->"+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	/**
	 * 查询员工通讯录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getStaffAddressBook")
	@ResponseBody
	public BaseTransferEntity getStaffAddressBook(
			HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 用户ID
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			List<Map<String, Object>> lst = utilsService.getStaffAddressBook(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UtilsController getStaffAddressBook--------->"+ e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 查询员工通讯录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getUseByStaffAddressBook")
	@ResponseBody
	public BaseTransferEntity getUseByStaffAddressBook(
			HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			
			// 用户ID
			String use_id = request.getParameter("use_id");
			// 公司ID
			String com_id = request.getParameter("com_id");
			// 账号
			String acc_num = request.getParameter("acc_num");
			// 用户名称
			String use_nam = request.getParameter("use_nam");
			// 用户手机号码
			String use_mob = request.getParameter("use_mob");
			// 用户名或手机号码
			String word = request.getParameter("word");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			map.put("com_id", com_id);
			
			map.put("acc_num", acc_num);
			
			map.put("use_nam", use_nam);
			
			map.put("use_mob", use_mob);
			
			map.put("word", word);
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			Map<String, Object> couMap = utilsService.getUseByStaffAddressBookCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = utilsService.getUseByStaffAddressBook(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UtilsController getUseByStaffAddressBook--------->"+ e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 查询客户通讯录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getCustomerAddressBook")
	@ResponseBody
	public BaseTransferEntity getCustomerAddressBook(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 用户ID
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			List<Map<String, Object>> lst = utilsService.getCustomerAddressBook(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UtilsController getCustomerAddressBook--------->"+ e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 查询客户通讯录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getUseByCustomerAddressBook")
	@ResponseBody
	public BaseTransferEntity getUseByCustomerAddressBook(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			
			// 用户ID
			String use_id = request.getParameter("use_id");
			// 公司ID
			String com_id = request.getParameter("com_id");
			// 账号
			String acc_num = request.getParameter("acc_num");
			// 用户名称
			String use_nam = request.getParameter("use_nam");
			// 用户手机号码
			String use_mob = request.getParameter("use_mob");
			// 用户名或手机号码
			String word = request.getParameter("word");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			map.put("com_id", com_id);
			
			map.put("acc_num", acc_num);
			
			map.put("use_nam", use_nam);
			
			map.put("use_mob", use_mob);
			
			map.put("word", word);
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			Map<String, Object> couMap = utilsService.getUseByCustomerAddressBookCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = utilsService.getUseByCustomerAddressBook(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UtilsController getUseByCustomerAddressBook--------->"+ e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * 查询操作日志信息列表（分页）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getOptLogLst")
	@ResponseBody
	public BaseTransferEntity getOptLogLst(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 查询中开始时间条件
			String sta_tim = request.getParameter("sta_tim");
			// 查询中结束时间条件
			String end_tim = request.getParameter("end_tim");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("sta_tim", sta_tim);

			if(end_tim != null && !end_tim.isEmpty()){
				
				SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
				
				map.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));
			}
			
			Map<String, Object> couMap = utilsService.getOptLogLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = utilsService.getOptLogLst(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("OthersController getOptLogLst--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 根据公司id 获取公司人员
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getUserNameByComId")
	@ResponseBody
	public BaseTransferEntity getUserNameByComId(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 公司id
			String com_id = request.getParameter("com_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("com_id", com_id);

			List<Map<String, Object>> lst = utilsService.getUserNameByComId(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("UtilsController getEquNumBySysBasAppTypeId--------->"+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	
	/**
	 * 根据公司id 获取公司人员
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getSelectedButtonLstByModuleId")
	@ResponseBody
	public BaseTransferEntity getSelectedButtonLstByModuleId(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			// 用户ID
			String use_id = request.getParameter("use_id");
			// 公司ID
			String module_id = request.getParameter("module_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			map.put("module_id", module_id);
			
			List<Map<String, Object>> lst = utilsService.getSelectedButtonLstByModuleId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UtilsController getSelectedButtonLstByModuleId--------->"+ e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 添加用户定位信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/insertUseLatLon")
	@ResponseBody
	public BaseTransferEntity insertUseLatLon(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String use_id = request.getParameter("use_id");
			
			String use_lon = request.getParameter("use_lon");
			
			String use_lat = request.getParameter("use_lat");
			
			String crt_tim = request.getParameter("time");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			map.put("use_lon", use_lon);
			
			map.put("use_lat", use_lat);
			
			map.put("crt_tim", DateUtil.stampToDate(crt_tim));
			
			utilsService.insertUseLatLon(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UtilsController insertUseLatLon--------->"+ e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 使用IP获取地区信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getCityByIp")
	@ResponseBody
	public BaseTransferEntity getCityByIp(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String ip = request.getParameter("ip");
			
			String city = utilsService.getCityByIp(ip);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(city);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UtilsController getCityByIp--------->"+ e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
}
