package com.qinergy.controller.system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qinergy.base.BaseController;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.Pager;
import com.qinergy.dto.system.DataDicDto;
import com.qinergy.dto.system.DataDicTypeDto;
import com.qinergy.dto.system.UserRoleDto;
import com.qinergy.service.integratmonitor.IntegratMonitorService;
import com.qinergy.service.system.SystemService;
import com.qinergy.service.utils.UtilsService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.StringUtil;
import com.qinergy.util.http.HttpClientConnectionManager;

/**
 * 与系统管理有关对前端页面接口类
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
public class SystemController extends BaseController {

	private static Logger log = Logger.getLogger(SystemController.class);

	BaseTransferEntity baseTransferEntity;

	@Autowired
	private SystemService systemService;
	@Autowired
	private IntegratMonitorService integratMonitorService;
	@Autowired
	private UtilsService utilsService;

	public static DefaultHttpClient httpclient;

	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager
				.getSSLInstance(httpclient);
	}

	/*
	 * ########################################## 系统配置Start
	 * ##########################################
	 */
	/**
	 * 获取组织机构层级关系列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasComLev")
	@ResponseBody
	public BaseTransferEntity getBasComLev(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 获取用户id
			String userid = request.getParameter("id");
			// 公司角色（0代表自己公司，1代表业主公司，2代表合作伙伴）
			String com_rol = request.getParameter("com_rol");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("use_id", userid);

			map.put("com_rol", com_rol);

			// 获取层级关系列表
			lst = systemService.getOneselfComLst(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController getBasComLev--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}
	

	/**
	 * 获取组织机构层级关系列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getOrgFatComInfByComId")
	@ResponseBody
	public BaseTransferEntity getOrgFatComInfByComId(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		
		try {
			// 获取用户id
			String userid = request.getParameter("id");
			// (com_lev为1时，不需要传此参数)(上级公司ID)
			String com_fat_id = request.getParameter("com_fat_id");
			// 公司级别
			String com_lev = request.getParameter("com_lev");
			// 公司角色（0代表自己公司，1代表业主公司，2代表合作伙伴）(com_lev为1时，不需要传此参数)
			String com_rol = request.getParameter("com_rol");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", userid);
			
			map.put("com_lev", com_lev);
			
			if(!com_lev.equals("1")){
				
				map.put("com_rol", com_rol);
				
				map.put("com_fat_id", com_fat_id);
			}
				
			// 获取层级关系列表
			lst = systemService.getOrgFatComInfByComId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("SystemController getOrgFatComInfByComId--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 使用公司ID获取一、二、三级公司下的电站信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsIdByComId")
	@ResponseBody
	public BaseTransferEntity getPwsIdByComId(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		
		try {
			// 公司ID
			String com_id = request.getParameter("com_id");
			// 用户ID
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("com_id", com_id);
			
			map.put("use_id", use_id);
			
			// 获取层级关系列表
			lst = systemService.getPwsIdByComId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("SystemController getOrgFatComInfByComId--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}


	/**
	 * 本接口为获取平台中所有客户公司的信息接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getOwnerComLst")
	@ResponseBody
	public BaseTransferEntity getOwnerComLst(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 获取层级关系列表
			lst = systemService.getOwnerComLst();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController getOwnerComLst--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 本接口为获取平台中所有运维公司的信息接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getOptComLst")
	@ResponseBody
	public BaseTransferEntity getOptComLst(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 获取层级关系列表
			lst = systemService.getOptComLst();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController getOptComLst--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 本接口为获取平台中所有公司的信息接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getComLst")
	@ResponseBody
	public BaseTransferEntity getComLst(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 获取层级关系列表
			lst = systemService.getComLst();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("SystemController getComLst--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 组织机构 公司信息/业主信息/合作伙伴 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delComLev")
	@ResponseBody
	public BaseTransferEntity delComLev(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			String id = request.getParameter("id");
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			if (systemService.delComLev(map)) {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setDesc("公司信息删除成功");
				
			} else {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				
				baseTransferEntity.setDesc("删除失败,请确保该公司下无其它子公司");
			}
		} catch (Exception e) {
			log.error("SystemController delComLev--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * id查询公司详情 （公司信息）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasComInfo")
	@ResponseBody
	public BaseTransferEntity getBasComInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 公司ID
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			Map<String, Object> retMap = systemService.getBasComInfo(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(retMap);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController getBasComInfo--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 角色信息添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/insertUserRole")
	@ResponseBody
	public BaseTransferEntity insertUserRole(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 角色名称
			String rol_nam = request.getParameter("rol_nam");
			// 角色标识
			String rol_ide = request.getParameter("rol_ide");
			// 所属单位ID(查询表sys_bas_com,为该表主键)
			String com_id = request.getParameter("com_id");
			// 备注
			String remark = request.getParameter("remark");
			// 创建人ID
			String crt_use_id = request.getParameter("use_id");

			UserRoleDto userRoleDto = new UserRoleDto();

			userRoleDto.setRol_nam(rol_nam);

			userRoleDto.setCom_id(Integer.valueOf(com_id));

			userRoleDto.setRol_ide(rol_ide);

			userRoleDto.setCrt_use_id(Integer.valueOf(crt_use_id));

			userRoleDto.setRemark(remark);

			userRoleDto.setBud_tim(new Date());

			// 获取 角色名称 查看是否该角色名称已经被使用
			Map<String, Object> mapRolNam = new HashMap<String, Object>();
			mapRolNam.put("rol_nam", rol_nam);
			List<Map<String, Object>> LstRoleName = systemService
					.getUserRoleByRolNam(mapRolNam);

			if (LstRoleName != null && !LstRoleName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("角色名称重复，请重新填写！");
				return baseTransferEntity;
			}

			systemService.insertUserRole(userRoleDto);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData("");
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 角色信息 id 查看
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUserRoleById")
	@ResponseBody
	public BaseTransferEntity getUserRoleById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		List<Map<String, Object>> Lst = new ArrayList<Map<String, Object>>();
		try {
			// id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			Lst = systemService.getUserRoleById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(Lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 角色信息 修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/service/updateUserRole")
	@ResponseBody
	public BaseTransferEntity updateUserRole(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		List<Map<String, Object>> Lst = new ArrayList<Map<String, Object>>();
		try {
			// id
			String id = request.getParameter("id");

			// 角色名称
			String rol_nam = request.getParameter("rol_nam");

			// 角色标识
			String rol_ide = request.getParameter("rol_ide");

			// 备注
			String remark = request.getParameter("remark");

			// 修改人ID
			String mod_use_id = request.getParameter("mod_use_id");

			// 修改时间
			// String mod_tim = request.getParameter("mod_tim");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("rol_nam", rol_nam);
			map.put("rol_ide", rol_ide);
			map.put("remark", remark);
			map.put("mod_use_id", mod_use_id);
			map.put("mod_tim", new Date());

		/*	// 获取 角色名称 查看是否该角色名称已经被使用
			Map<String, Object> mapRolNam = new HashMap<String, Object>();
			mapRolNam.put("rol_nam", rol_nam);
			List<Map<String, Object>> LstRoleName = systemService
					.getUserRoleByRolNam(mapRolNam);

			if (LstRoleName != null && !LstRoleName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("类型名称重复，请重新填写！");
				return baseTransferEntity;
			}
*/
			Lst = systemService.updateUserRole(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(Lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController updateUserRole--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 组织机构 公司添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertComInfo")
	@ResponseBody
	public BaseTransferEntity insertComInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String com_nam = request.getParameter("com_nam");
			String com_ide = request.getParameter("com_ide");
			String com_add = request.getParameter("com_add");
			String com_sta = request.getParameter("com_sta");
			String com_con = request.getParameter("com_con");
			String com_tel = request.getParameter("com_tel");
			String com_typ_id = request.getParameter("com_typ_id");
			String com_fat_id = request.getParameter("com_fat_id");
			String com_lep = request.getParameter("com_lep");
			String com_lep_cod = request.getParameter("com_lep_cod");
			String com_lon = request.getParameter("com_lon");
			String com_lat = request.getParameter("com_lat");
			String com_sor = request.getParameter("com_sor");
			String com_cen_lon = request.getParameter("com_cen_lon");
			String com_cen_lat = request.getParameter("com_cen_lat");
			String com_zoo_lev = request.getParameter("com_zoo_lev");
			String com_lev = request.getParameter("com_lev");
			String com_rol = request.getParameter("com_rol");
			String pro_id = request.getParameter("pro_id");
			String cit_id = request.getParameter("cit_id");
			String are_id = request.getParameter("are_id");
			String remark = request.getParameter("remark");
			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("com_nam", com_nam);
			map.put("com_ide", com_ide);
			map.put("com_add", com_add);
			map.put("com_sta", com_sta);
			map.put("com_con", com_con);
			map.put("com_tel", com_tel);
			map.put("com_typ_id", com_typ_id);
			map.put("com_fat_id", com_fat_id);
			map.put("com_lep", com_lep);
			map.put("com_lep_cod", com_lep_cod);
			if (com_lon != null && !com_lon.isEmpty()
					&& !com_lon.equals("null") && !com_lon.equals("")) {

				map.put("com_lon", com_lon);

			} else {

				map.put("com_lon", 0);
			}
			if (com_lat != null && !com_lat.isEmpty()
					&& !com_lat.equals("null") && !com_lat.equals("")) {

				map.put("com_lat", com_lat);

			} else {

				map.put("com_lat", 0);
			}

			map.put("com_sor", com_sor);

			if (com_cen_lon != null && !com_cen_lon.isEmpty()
					&& !com_cen_lon.equals("null") && !com_cen_lon.equals("")) {

				map.put("com_cen_lon", com_cen_lon);

			} else {

				map.put("com_cen_lon", 0);
			}

			if (com_cen_lat != null && !com_cen_lat.isEmpty()
					&& !com_cen_lat.equals("null") && !com_cen_lat.equals("")) {

				map.put("com_cen_lat", com_cen_lat);

			} else {

				map.put("com_cen_lat", 0);
			}

			if (com_zoo_lev != null && !com_zoo_lev.isEmpty()
					&& !com_zoo_lev.equals("null") && !com_zoo_lev.equals("")) {

				map.put("com_zoo_lev", com_zoo_lev);

			} else {

				map.put("com_zoo_lev", 0);
			}

			if (com_lev != null && !com_lev.isEmpty()
					&& !com_lev.equals("null") && !com_lev.equals("")) {

				map.put("com_lev", com_lev);

			} else {

				map.put("com_lev", 0);
			}

			if (com_rol != null && !com_rol.isEmpty()
					&& !com_rol.equals("null") && !com_rol.equals("")) {

				map.put("com_rol", com_rol);

			} else {

				map.put("com_rol", 0);
			}
			map.put("pro_id", pro_id);
			map.put("cit_id", cit_id);
			map.put("are_id", are_id);
			map.put("remark", remark);
			map.put("use_id", use_id);
			map.put("tim", new Date());
			// 判断添加的公司名称是否存在
			List<Map<String, Object>> retLst = utilsService
					.getComInfByComNam(map);

			if (retLst != null && !retLst.isEmpty() && retLst.get(0) != null
					&& !retLst.get(0).isEmpty()) {

				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.error.datarepeat"));
				baseTransferEntity.setData("");
				baseTransferEntity.setDesc(MobileConfig
						.get("msg.global.error.datarepeat"));

			} else {

				systemService.insertComInfo(map);

				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.success"));
				baseTransferEntity.setData("");
				baseTransferEntity.setDesc(MobileConfig
						.get("msg.global.success"));
			}

		} catch (Exception e) {
			log.error(
					"SystemController insertComInfo--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 查询地区信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasRegInfById")
	@ResponseBody
	public BaseTransferEntity getBasRegInfById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			List<Map<String, Object>> regInfLst = systemService
					.getBasRegInfById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(regInfLst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 查询地区子信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasRegInfBySubId")
	@ResponseBody
	public BaseTransferEntity getBasRegInfByFatId(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("reg_fat_id", id);

			Map<String, Object> couMap = systemService
					.getBasRegInfByFatIdCou(map);

			if (couMap != null) {

				page.setTotalCount(Integer.parseInt(couMap.get("count")
						.toString()));

			} else {
				page.setTotalCount(0);
			}

			map.put("evertPage", page.getEveryPage());

			List<Map<String, Object>> regInfLst = systemService
					.getBasRegInfByFatId(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(regInfLst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 查询地区子信息(不分页)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasRegInfByFatIdNotPage")
	@ResponseBody
	public BaseTransferEntity getBasRegInfByFatIdNotPage(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("reg_fat_id", id);

			List<Map<String, Object>> regInfLst = systemService
					.getBasRegInfByFatIdNotPage(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(regInfLst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"UserController getBasRegInfByFatIdNotPage--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 组织机构修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updateComInfo")
	@ResponseBody
	public BaseTransferEntity updateComInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String id = request.getParameter("id");
			String com_nam = request.getParameter("com_nam");
			String com_add = request.getParameter("com_add");
			String com_ide = request.getParameter("com_ide");
			String com_sta = request.getParameter("com_sta");
			String com_con = request.getParameter("com_con");
			String com_tel = request.getParameter("com_tel");
			String com_typ_id = request.getParameter("com_typ_id");
			String com_fat_id = request.getParameter("com_fat_id");
			String com_lep = request.getParameter("com_lep");
			String com_lep_cod = request.getParameter("com_lep_cod");
			String com_lon = request.getParameter("com_lon");
			String com_lat = request.getParameter("com_lat");
			String com_sor = request.getParameter("com_sor");
			String com_cen_lon = request.getParameter("com_cen_lon");
			String com_cen_lat = request.getParameter("com_cen_lat");
			String com_zoo_lev = request.getParameter("com_zoo_lev");
			String pro_id = request.getParameter("pro_id");
			String cit_id = request.getParameter("cit_id");
			String are_id = request.getParameter("are_id");
			String com_lev = request.getParameter("com_lev");
			String com_rol = request.getParameter("com_rol");
			String remark = request.getParameter("remark");
			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("com_nam", com_nam);
			map.put("com_add", com_add);
			map.put("com_sta", com_sta);
			map.put("com_ide", com_ide);
			map.put("com_con", com_con);
			map.put("com_tel", com_tel);
			map.put("com_typ_id", com_typ_id);
			map.put("com_fat_id", com_fat_id);
			map.put("com_lep", com_lep);
			map.put("com_lep_cod", com_lep_cod);
			map.put("com_lep_cod", com_lep_cod);
			if (com_lon != null && !com_lon.isEmpty()
					&& !com_lon.equals("null") && !com_lon.equals("")) {

				map.put("com_lon", com_lon);

			} else {

				map.put("com_lon", 0);
			}
			if (com_lat != null && !com_lat.isEmpty()
					&& !com_lat.equals("null") && !com_lat.equals("")) {

				map.put("com_lat", com_lat);

			} else {

				map.put("com_lat", 0);
			}

			map.put("com_sor", com_sor);

			if (com_cen_lon != null && !com_cen_lon.isEmpty()
					&& !com_cen_lon.equals("null") && !com_cen_lon.equals("")) {

				map.put("com_cen_lon", com_cen_lon);

			} else {

				map.put("com_cen_lon", 0);
			}

			if (com_cen_lat != null && !com_cen_lat.isEmpty()
					&& !com_cen_lat.equals("null") && !com_cen_lat.equals("")) {

				map.put("com_cen_lat", com_cen_lat);

			} else {

				map.put("com_cen_lat", 0);
			}

			if (com_zoo_lev != null && !com_zoo_lev.isEmpty()
					&& !com_zoo_lev.equals("null") && !com_zoo_lev.equals("")) {

				map.put("com_zoo_lev", com_zoo_lev);

			} else {

				map.put("com_zoo_lev", 0);
			}

			if (com_lev != null && !com_lev.isEmpty()
					&& !com_lev.equals("null") && !com_lev.equals("")) {

				map.put("com_lev", com_lev);

			} else {

				map.put("com_lev", 0);
			}

			if (com_rol != null && !com_rol.isEmpty()
					&& !com_rol.equals("null") && !com_rol.equals("")) {

				map.put("com_rol", com_rol);

			} else {

				map.put("com_rol", 1);
			}
			map.put("com_sor", com_sor);
			map.put("pro_id", pro_id);
			map.put("cit_id", cit_id);
			map.put("are_id", are_id);
			map.put("remark", remark);
			map.put("use_id", use_id);
			map.put("tim", new Date());
			// 判断添加的公司名称是否存在
			List<Map<String, Object>> retLst = utilsService
					.getComInfByComNam(map);

			if (retLst != null && !retLst.isEmpty() && retLst.get(0) != null
					&& !retLst.get(0).isEmpty()
					&& !retLst.get(0).get("id").toString().equals(id)) {

				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.error.datarepeat"));
				baseTransferEntity.setData("");
				baseTransferEntity.setDesc(MobileConfig
						.get("msg.global.error.datarepeat"));

			} else {
				systemService.updateComInfo(map);

				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.success"));
				baseTransferEntity.setData("");
				baseTransferEntity.setDesc(MobileConfig
						.get("msg.global.success"));
			}
		} catch (Exception e) {
			log.error(
					"SystemController updateComInfo--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 部门修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updDep")
	@ResponseBody
	public BaseTransferEntity updDep(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String id = request.getParameter("id");

			String dep_nam = request.getParameter("dep_nam");

			String dep_sta = request.getParameter("dep_sta");

			String dep_sor = request.getParameter("dep_sor");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			map.put("dep_nam", dep_nam);

			map.put("dep_sta", dep_sta);

			map.put("dep_sor", dep_sor);

			systemService.updDep(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData("");
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 部门新增
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insDep")
	@ResponseBody
	public BaseTransferEntity insDep(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String dep_nam = request.getParameter("dep_nam");

			String dep_sta = request.getParameter("dep_sta");

			String dep_sor = request.getParameter("dep_sor");

			String com_id = request.getParameter("com_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("dep_nam", dep_nam);

			map.put("dep_sta", dep_sta);

			map.put("dep_sor", dep_sor);

			map.put("com_id", com_id);

			systemService.insDep(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData("");
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 查询三级地区列表,一级（省级）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasRegLst1Lev")
	@ResponseBody
	public BaseTransferEntity getBasRegLst1Lev(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("reg_adm_lev", 1);

			Map<String, Object> couMap = systemService.getBasRegLst1LevCou(map);

			if (couMap != null) {

				page.setTotalCount(Integer.parseInt(couMap.get("count")
						.toString()));

			} else {
				page.setTotalCount(0);
			}

			map.put("evertPage", page.getEveryPage());

			List<Map<String, Object>> lst = systemService.getBasRegLst1Lev(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController getBasRegLst1Lev--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 查询三级地区列表,一级（省级）(所有)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasRegLst1LevAll")
	@ResponseBody
	public BaseTransferEntity getBasRegLst1LevAll(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("reg_adm_lev", 1);

			List<Map<String, Object>> lst = systemService
					.getBasRegLst1LevAll(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController getBasRegLst1Lev--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 组织机构修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasRegLst2Or3Lev")
	@ResponseBody
	public BaseTransferEntity getBasRegLst2Or3Lev(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String reg_ide = request.getParameter("reg_ide");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("reg_ide", reg_ide);

			List<Map<String, Object>> lst = systemService
					.getBasRegLst2Or3Lev(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 获取所有设施类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasAppTypAll")
	@ResponseBody
	public BaseTransferEntity getBasAppTypAll(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String id = request.getParameter("id");

			String typ_nam = request.getParameter("typ_nam");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			map.put("typ_nam", typ_nam);

			List<Map<String, Object>> lst = systemService.getBasAppTypAll(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 使用ID获取设施信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasAppById")
	@ResponseBody
	public BaseTransferEntity getBasAppById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String app_id = request.getParameter("app_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("app_id", app_id);

			List<Map<String, Object>> lst = systemService.getBasAppById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"UserController getBasAppById--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 获取所有设施
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasApp")
	@ResponseBody
	public BaseTransferEntity getBasApp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 设施ID
			String app_id = request.getParameter("app_id");
			// 设施ID
			String app_typ_id = request.getParameter("id");
			// 设施类型
			String app_mod = request.getParameter("app_mod");
			// 生产厂家ID
			String man_id = request.getParameter("man_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("app_id", app_id);

			map.put("app_typ_id", app_typ_id);

			map.put("app_id", app_id);

			map.put("app_mod", app_mod);

			map.put("man_id", man_id);

			Map<String, Object> couMap = systemService.getBasAppCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));

			map.put("evertPage", page.getEveryPage());

			List<Map<String, Object>> lst = systemService.getBasApp(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 修改设施信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updAppInf")
	@ResponseBody
	public BaseTransferEntity updAppInf(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			// 设备型号ID
			String app_id = request.getParameter("app_id");
			// 设备类型ID
			String app_typ_id = request.getParameter("app_typ_id");
			// 设备型号
			String app_mod = request.getParameter("app_mod");
			// 生产厂家
			String man_id = request.getParameter("man_id");
			// 公司ID
			String com_id = request.getParameter("com_id");
			// 修改人ID
			String mod_use_id = request.getParameter("use_id");
			// 设备电流
			String rtd_elc = request.getParameter("rtd_elc");
			// 设备电压
			String rtd_vol = request.getParameter("rtd_vol");
			// 设备功率
			String rtd_pow = request.getParameter("rtd_pow");
			// 尺寸
			// String app_size = request.getParameter("size");

			String size_lon = request.getParameter("size_lon");
			String size_wid = request.getParameter("size_wid");
			String size_hig = request.getParameter("size_hig");

			String app_size = size_lon + "*" + size_wid + "*" + size_hig;

			// 重量
			String app_weight = request.getParameter("weight");
			// 海拔
			String app_altitude = request.getParameter("altitude");
			// 工作温度
			String work_temp = request.getParameter("work_temp");
			// 防护等级
			String prtc_grade = request.getParameter("prtc_grade");
			// 通讯类型
			String com_typ = request.getParameter("com_typ");
			// 通讯协议
			String com_pro = request.getParameter("com_pro");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("app_id", app_id);

			map.put("app_typ_id", app_typ_id);

			map.put("app_mod", app_mod);

			map.put("man_id", man_id);

			map.put("com_id", com_id);

			map.put("mod_use_id", mod_use_id);

			map.put("mod_tim", new Date());

			if (rtd_elc != null && !rtd_elc.isEmpty()
					&& !rtd_elc.equals("null") && !rtd_elc.equals("")) {

				map.put("rtd_elc", rtd_elc);

			} else {

				map.put("rtd_elc", 0);
			}

			if (rtd_vol != null && !rtd_vol.isEmpty()
					&& !rtd_vol.equals("null") && !rtd_vol.equals("")) {

				map.put("rtd_vol", rtd_vol);

			} else {

				map.put("rtd_vol", 0);
			}

			if (rtd_pow != null && !rtd_pow.isEmpty()
					&& !rtd_pow.equals("null") && !rtd_pow.equals("")) {

				map.put("rtd_pow", rtd_pow);

			} else {

				map.put("rtd_pow", 0);
			}

			map.put("app_size", app_size);

			if (app_weight != null && !app_weight.isEmpty()
					&& !app_weight.equals("null") && !app_weight.equals("")) {

				map.put("app_weight", app_weight);

			} else {

				map.put("app_weight", 0);
			}

			map.put("app_altitude", app_altitude);

			map.put("work_temp", work_temp);

			map.put("prtc_grade", prtc_grade);

			map.put("com_typ", com_typ);

			map.put("com_pro", com_pro);

			systemService.updAppInf(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("UserController updAppInf--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 添加设施信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insAppInf")
	@ResponseBody
	public BaseTransferEntity insAppInf(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备类型
			String app_typ_id = request.getParameter("app_typ_id");
			// 设备型号
			String app_mod = request.getParameter("app_mod");
			// 生产厂家
			String man_id = request.getParameter("man_id");
			// 创建单位ID即公司ID
			String com_id = request.getParameter("com_id");
			// 创建人标识
			String crt_use_id = request.getParameter("crt_use_id");
			// 设备电流
			String rtd_elc = request.getParameter("rtd_elc");
			// 设备电压
			String rtd_vol = request.getParameter("rtd_vol");
			// 设备功率
			String rtd_pow = request.getParameter("rtd_pow");

			String size_lon = request.getParameter("size_lon");
			String size_wid = request.getParameter("size_wid");
			String size_hig = request.getParameter("size_hig");

			// 尺寸
			// String app_size = request.getParameter("size");

			String app_size = size_lon + "*" + size_wid + "*" + size_hig;
			// 重量
			String app_weight = request.getParameter("weight");
			// 海拔
			String app_altitude = request.getParameter("altitude");
			// 工作温度
			String work_temp = request.getParameter("work_temp");
			// 防护等级
			String prtc_grade = request.getParameter("prtc_grade");
			// 通讯类型
			String com_typ = request.getParameter("com_typ");
			// 通讯协议
			String com_pro = request.getParameter("com_pro");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("app_typ_id", app_typ_id);

			map.put("app_mod", app_mod);

			map.put("man_id", man_id);

			map.put("com_id", com_id);

			map.put("crt_use_id", crt_use_id);

			map.put("crt_tim", new Date());

			if (rtd_elc != null && !rtd_elc.isEmpty()
					&& !rtd_elc.equals("null") && !rtd_elc.equals("")) {

				map.put("rtd_elc", rtd_elc);

			} else {

				map.put("rtd_elc", 0);
			}

			if (rtd_vol != null && !rtd_vol.isEmpty()
					&& !rtd_vol.equals("null") && !rtd_vol.equals("")) {

				map.put("rtd_vol", rtd_vol);

			} else {

				map.put("rtd_vol", 0);
			}

			if (rtd_pow != null && !rtd_pow.isEmpty()
					&& !rtd_pow.equals("null") && !rtd_pow.equals("")) {

				map.put("rtd_pow", rtd_pow);

			} else {

				map.put("rtd_pow", 0);
			}

			map.put("app_size", app_size);

			if (app_weight != null && !app_weight.isEmpty()
					&& !app_weight.equals("null") && !app_weight.equals("")) {

				map.put("app_weight", app_weight);

			} else {

				map.put("app_weight", 0);
			}

			map.put("app_altitude", app_altitude);

			map.put("work_temp", work_temp);

			map.put("prtc_grade", prtc_grade);

			map.put("com_typ", com_typ);

			map.put("com_pro", com_pro);

			systemService.insAppInf(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("SystemController insAppInf--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 删除设施信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delAppInf")
	@ResponseBody
	public BaseTransferEntity delAppInf(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String app_id = request.getParameter("app_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("app_id", app_id);

			systemService.delAppInf(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(null);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 修改设施类型信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updAppTyp")
	@ResponseBody
	public BaseTransferEntity updAppTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			// 设备类型名称
			String typ_nam = request.getParameter("typ_nam");
			// 设备类型标识
			String typ_ide = request.getParameter("typ_ide");
			// 备注
			String remark = request.getParameter("remark");
			// 修改人ID
			String mod_use_id = request.getParameter("use_id");
			// 设备类型ID
			String app_typ_id = request.getParameter("app_typ_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("typ_nam", typ_nam);

			map.put("typ_ide", typ_ide);

			map.put("remark", remark);

			map.put("mod_use_id", mod_use_id);

			map.put("mod_tim", new Date());

			map.put("app_typ_id", app_typ_id);

			systemService.updAppTyp(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("UserController updAppTyp--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 添加设施类型信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insAppTyp")
	@ResponseBody
	public BaseTransferEntity insAppTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备类型名称
			String typ_nam = request.getParameter("typ_nam");
			// 设备类型标识
			String typ_ide = request.getParameter("typ_ide");
			// 备注
			String remark = request.getParameter("remark");
			// 创建人ID
			String crt_use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("typ_nam", typ_nam);

			map.put("typ_ide", typ_ide);

			map.put("remark", remark);

			map.put("crt_use_id", crt_use_id);

			map.put("crt_tim", new Date());

			systemService.insAppTyp(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("UserController insAppTyp--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 删除设施类型信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delAppTyp")
	@ResponseBody
	public BaseTransferEntity delAppTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String app_typ_id = request.getParameter("app_typ_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("app_typ_id", app_typ_id);

			systemService.delAppTyp(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("UserController delAppTyp--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);

		}

		return baseTransferEntity;
	}

	/**
	 * 获取所有厂家类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasManTypAll")
	@ResponseBody
	public BaseTransferEntity getBasManTypAll(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			List<Map<String, Object>> lst = systemService.getBasManTypAll();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController login--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}


	/*
	 * ########################################## 系统配置End
	 * ##########################################
	 */
	/**
	 * 获取用户充电记录详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUserByLoginNamePC")
	@ResponseBody
	public BaseTransferEntity getUserByLoginNamePC(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 表dat_cha_rec ID
			String login_name = request.getParameter("login_name");

			String com_id = request.getParameter("com_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("login_name", login_name);

			map.put("com_id", com_id);

			List<Map<String, Object>> lst = systemService
					.getUserByLoginNamePC(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getUserByLoginNamePC--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 查询用户信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUserByLoginNamePCT")
	@ResponseBody
	public BaseTransferEntity getUserByLoginNamePCT(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 表dat_cha_rec ID
			String login_name = request.getParameter("login_name");

			String com_id = request.getParameter("com_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("login_name", login_name);

			map.put("com_id", com_id);

			Map<String, Object> couMap = systemService
					.getUserByLoginNamePCTCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));

			map.put("evertPage", page.getEveryPage());

			List<Map<String, Object>> lst = systemService
					.getUserByLoginNamePCT(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getUserByLoginNamePCT--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 获取所有单位类型信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAllComTyp")
	@ResponseBody
	public BaseTransferEntity getAllComTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			List<Map<String, Object>> lst = systemService.getAllComTyp();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getAllComTyp--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 获取所有单位名称
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAllComNam")
	@ResponseBody
	public BaseTransferEntity getAllComNam(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			List<Map<String, Object>> lst = systemService.getAllComNam();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getAllComNam--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 获取所有运维单位名称
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAllOptComNam")
	@ResponseBody
	public BaseTransferEntity getAllOptComNam(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			List<Map<String, Object>> lst = systemService.getAllOptComNam();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getAllOptComNam--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 获取所有业主单位名称
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAllOwnComNam")
	@ResponseBody
	public BaseTransferEntity getAllOwnComNam(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			List<Map<String, Object>> lst = systemService.getAllOwnComNam();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getAllOwnComNam--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}


	/**
	 * 新建字典信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insDic")
	@ResponseBody
	public BaseTransferEntity insDic(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String par_ide = request.getParameter("par_ide");

			String par_nam = request.getParameter("par_nam");

			String sor_num = request.getParameter("sor_num");

			String par_val = request.getParameter("par_val");

			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("par_ide", par_ide);

			map.put("par_nam", par_nam);

			map.put("sor_num", sor_num);

			map.put("par_val", par_val);

			systemService.insDic(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			log.info("ID为：" + use_id + "的用户对字典表的数据进行了添加操作！");
		} catch (Exception e) {

			log.error("SystemController insDic--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 获取指定字典信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDicById")
	@ResponseBody
	public BaseTransferEntity getDicById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String dic_id = request.getParameter("dic_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("dic_id", dic_id);

			List<Map<String, Object>> lst = systemService.getDicById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("SystemController getDicById--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 更新字典信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updDic")
	@ResponseBody
	public BaseTransferEntity updDic(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String dic_id = request.getParameter("dic_id");

			String par_ide = request.getParameter("par_ide");

			String par_nam = request.getParameter("par_nam");

			String sor_num = request.getParameter("sor_num");

			String par_val = request.getParameter("par_val");
			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("dic_id", dic_id);

			map.put("par_ide", par_ide);

			map.put("par_nam", par_nam);

			map.put("sor_num", sor_num);

			map.put("par_val", par_val);

			systemService.updDic(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			log.info("ID为：" + use_id + "的用户对字典表的ID为：" + dic_id + "的数据进行了修改操作！");
		} catch (Exception e) {

			log.error("SystemController updDic--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 获取厂家信息/列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getManInf")
	@ResponseBody
	public BaseTransferEntity getManInf(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 公司ID
			String man_id = request.getParameter("man_id");
			// 公司名称
			String man_nam = request.getParameter("man_nam");
			// 公司类型ID
			String man_typ_id = request.getParameter("man_typ_id");
			// 公司状态
			String man_sta = request.getParameter("man_sta");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("man_id", man_id);

			map.put("man_nam", man_nam);

			map.put("man_typ_id", man_typ_id);

			map.put("man_sta", man_sta);

			Map<String, Object> couMap = systemService.getManInfCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));

			map.put("evertPage", page.getEveryPage());

			List<Map<String, Object>> lst = systemService.getManInf(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("SystemController getManInf--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	/**
	 * 获取厂家信息/下拉框/全部
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getManInfAll")
	@ResponseBody
	public BaseTransferEntity getManInfAll(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			List<Map<String, Object>> lst = systemService.getManInfAll();
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("SystemController getManInfAll--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * 获取所有厂家类型列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAllManTyp")
	@ResponseBody
	public BaseTransferEntity getAllManTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			List<Map<String, Object>> lst = systemService.getAllManTyp();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getAllManTyp--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 添加厂家类型信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insManTyp")
	@ResponseBody
	public BaseTransferEntity insManTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 厂家类型标识
			String typ_ide = request.getParameter("typ_ide");
			// 厂家类型名称
			String typ_nam = request.getParameter("typ_nam");
			// 备注
			String remark = request.getParameter("remark");
			// 创建人ID
			String crt_use_id = request.getParameter("crt_use_id");
			// 创建时间
			String crt_tim = request.getParameter("crt_tim");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("typ_ide", typ_ide);

			map.put("typ_nam", typ_nam);

			map.put("remark", remark);

			map.put("crt_use_id", crt_use_id);

			map.put("crt_tim", crt_tim);

			systemService.insManTyp(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("ID为：" + crt_use_id + "的用户对厂家类型表的数据进行了添加操作！");

		} catch (Exception e) {

			log.error("SystemController insManTyp--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 修改厂家类型信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updManTyp")
	@ResponseBody
	public BaseTransferEntity updManTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 厂家ID
			String man_typ_id = request.getParameter("man_typ_id");
			// 厂家类型标识
			String typ_ide = request.getParameter("typ_ide");
			// 厂家类型名称
			String typ_nam = request.getParameter("typ_nam");
			// 备注
			String remark = request.getParameter("remark");
			// 修改人ID
			String mod_use_id = request.getParameter("use_id");
			// 修改时间
			String mod_tim = request.getParameter("mod_tim");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("man_typ_id", man_typ_id);

			map.put("typ_ide", typ_ide);

			map.put("typ_nam", typ_nam);

			map.put("remark", remark);

			map.put("mod_use_id", mod_use_id);

			map.put("mod_tim", mod_tim);

			systemService.updManTyp(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("ID为：" + mod_use_id + "的用户对厂家类型表的ID为：" + man_typ_id
					+ "的数据进行了修改操作！");

		} catch (Exception e) {

			log.error("SystemController updManTyp--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 删除厂家类型信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delManTyp")
	@ResponseBody
	public BaseTransferEntity delManTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String man_typ_id = request.getParameter("man_typ_id");

			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("man_typ_id", man_typ_id);

			systemService.delManTyp(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("ID为：" + use_id + "的用户对厂家类型表的ID为：" + man_typ_id
					+ "的数据进行了删除操作！");

		} catch (Exception e) {

			log.error("SystemController delManTyp--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 添加厂家信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insMan")
	@ResponseBody
	public BaseTransferEntity insMan(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String man_nam = request.getParameter("man_nam");
			String man_cot = request.getParameter("man_cot");
			String man_mob = request.getParameter("man_mob");
			String man_spa = request.getParameter("man_spa");
			String man_typ_id = request.getParameter("man_typ_id");
			String man_add = request.getParameter("man_add");
			String remark = request.getParameter("remark");
			String man_sta = request.getParameter("man_sta");
			String sta_lon = request.getParameter("sta_lon");
			String sta_lat = request.getParameter("sta_lat");
			String cre_pre_id = request.getParameter("cre_pre_id");
			String pro_id = request.getParameter("pro_id");
			String cit_id = request.getParameter("cit_id");
			String are_id = request.getParameter("are_id");
			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("man_nam", man_nam);

			map.put("man_cot", man_cot);

			map.put("man_mob", man_mob);

			map.put("man_spa", man_spa);

			if (man_typ_id != null && !man_typ_id.isEmpty()
					&& !man_typ_id.equals("null") && !man_typ_id.equals("")) {

				map.put("man_typ_id", man_typ_id);

			} else {

				map.put("man_typ_id", 0);
			}

			map.put("man_add", man_add);

			map.put("remark", remark);

			if (man_sta != null && !man_sta.isEmpty()
					&& !man_sta.equals("null") && !man_sta.equals("")) {

				map.put("man_sta", man_sta);

			} else {

				map.put("man_sta", 0);
			}

			if (sta_lon != null && !sta_lon.isEmpty()
					&& !sta_lon.equals("null") && !sta_lon.equals("")) {

				map.put("sta_lon", sta_lon);

			} else {

				map.put("sta_lon", 0);
			}

			if (sta_lat != null && !sta_lat.isEmpty()
					&& !sta_lat.equals("null") && !sta_lat.equals("")) {

				map.put("sta_lat", sta_lat);

			} else {

				map.put("sta_lat", 0);
			}
			map.put("cre_pre_id", cre_pre_id);

			if (pro_id != null && !pro_id.isEmpty() && !pro_id.equals("null")
					&& !pro_id.equals("")) {

				map.put("pro_id", pro_id);

			} else {

				map.put("pro_id", 0);
			}

			if (cit_id != null && !cit_id.isEmpty() && !cit_id.equals("null")
					&& !cit_id.equals("")) {

				map.put("cit_id", cit_id);

			} else {

				map.put("cit_id", 0);
			}

			if (are_id != null && !are_id.isEmpty() && !are_id.equals("null")
					&& !are_id.equals("")) {

				map.put("are_id", are_id);

			} else {

				map.put("are_id", 0);
			}

			map.put("crt_use_id", use_id);

			map.put("crt_tim", new Date());

			systemService.insMan(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("ID为：" + use_id + "的用户对厂家表的数据进行了添加操作！");

		} catch (Exception e) {

			log.error("SystemController insMan--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 修改厂家信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updMan")
	@ResponseBody
	public BaseTransferEntity updMan(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String man_id = request.getParameter("man_id");
			String man_nam = request.getParameter("man_nam");
			String man_cot = request.getParameter("man_cot");
			String man_mob = request.getParameter("man_mob");
			String man_spa = request.getParameter("man_spa");
			String man_typ_id = request.getParameter("man_typ_id");
			String man_add = request.getParameter("man_add");
			String remark = request.getParameter("remark");
			String man_sta = request.getParameter("man_sta");
			String sta_lon = request.getParameter("sta_lon");
			String sta_lat = request.getParameter("sta_lat");
			String cre_pre_id = request.getParameter("cre_pre_id");
			String pro_id = request.getParameter("pro_id");
			String cit_id = request.getParameter("cit_id");
			String are_id = request.getParameter("are_id");
			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("mod_use_id", use_id);

			map.put("mod_tim", new Date());
			
			map.put("man_id", man_id);

			map.put("man_nam", man_nam);

			map.put("man_cot", man_cot);

			map.put("man_mob", man_mob);

			map.put("man_spa", man_spa);

			if (man_typ_id != null && !man_typ_id.isEmpty()
					&& !man_typ_id.equals("null") && !man_typ_id.equals("")) {

				map.put("man_typ_id", man_typ_id);

			} else {

				map.put("man_typ_id", 0);
			}

			map.put("man_add", man_add);

			map.put("remark", remark);

			if (man_sta != null && !man_sta.isEmpty()
					&& !man_sta.equals("null") && !man_sta.equals("")) {

				map.put("man_sta", man_sta);

			} else {

				map.put("man_sta", 0);
			}

			if (sta_lon != null && !sta_lon.isEmpty()
					&& !sta_lon.equals("null") && !sta_lon.equals("")) {

				map.put("sta_lon", sta_lon);

			} else {

				map.put("sta_lon", 0);
			}

			if (sta_lat != null && !sta_lat.isEmpty()
					&& !sta_lat.equals("null") && !sta_lat.equals("")) {

				map.put("sta_lat", sta_lat);

			} else {

				map.put("sta_lat", 0);
			}
			map.put("cre_pre_id", cre_pre_id);

			if (pro_id != null && !pro_id.isEmpty() && !pro_id.equals("null")
					&& !pro_id.equals("")) {

				map.put("pro_id", pro_id);

			} else {

				map.put("pro_id", 0);
			}

			if (cit_id != null && !cit_id.isEmpty() && !cit_id.equals("null")
					&& !cit_id.equals("")) {

				map.put("cit_id", cit_id);

			} else {

				map.put("cit_id", 0);
			}

			if (are_id != null && !are_id.isEmpty() && !are_id.equals("null")
					&& !are_id.equals("")) {

				map.put("are_id", are_id);

			} else {

				map.put("are_id", 0);
			}

			systemService.updMan(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("ID为：" + use_id + "的用户对厂家表的ID为：" + man_id + "的数据进行了修改操作！");

		} catch (Exception e) {

			log.error("SystemController updMan--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 删除厂家信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delMan")
	@ResponseBody
	public BaseTransferEntity delMan(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String man_id = request.getParameter("man_id");

			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("man_id", man_id);

			systemService.delMan(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("ID为：" + use_id + "的用户对厂家表的ID为：" + man_id + "的数据进行了删除操作！");

		} catch (Exception e) {

			log.error("SystemController delMan--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 添加设备故障信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insFauTyp")
	@ResponseBody
	public BaseTransferEntity insFauTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String app_typ_id = request.getParameter("app_typ_id");

			String fau_typ = request.getParameter("fau_typ");

			String sor_num = request.getParameter("sor_num");

			String remark = request.getParameter("remark");
			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("app_typ_id", app_typ_id);

			map.put("fau_typ", fau_typ);

			map.put("sor_num", sor_num);

			map.put("remark", remark);

			systemService.insFauTyp(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			log.info("ID为：" + use_id + "的用户对故障表的数据进行了添加操作！");
		} catch (Exception e) {

			log.error(
					"SystemController getAllManTyp--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 修改设备故障信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updFauTyp")
	@ResponseBody
	public BaseTransferEntity updFauTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String fau_id = request.getParameter("fau_id");

			String app_typ_id = request.getParameter("app_typ_id");

			String fau_typ = request.getParameter("fau_typ");

			String sor_num = request.getParameter("sor_num");

			String remark = request.getParameter("remark");

			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("fau_id", fau_id);

			map.put("app_typ_id", app_typ_id);

			map.put("fau_typ", fau_typ);

			map.put("sor_num", sor_num);

			map.put("remark", remark);

			systemService.updFauTyp(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("ID为：" + use_id + "的用户对故障表中ID为" + fau_id + "的数据进行了修改操作！");

		} catch (Exception e) {

			log.error("SystemController updFauTyp--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 删除设备故障信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delFauTyp")
	@ResponseBody
	public BaseTransferEntity delFauTyp(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String fau_id = request.getParameter("fau_id");

			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("fau_id", fau_id);

			systemService.delFauTyp(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("ID为：" + use_id + "的用户对故障表中ID为" + fau_id + "的数据进行了删除操作！");

		} catch (Exception e) {

			log.error("SystemController delFauTyp--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 删除字典信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delDic")
	@ResponseBody
	public BaseTransferEntity delDic(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String dic_id = request.getParameter("dic_id");

			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("dic_id", dic_id);

			systemService.delDic(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("ID为：" + use_id + "的用户对字典表中ID为" + dic_id + "的数据进行了删除操作！");

		} catch (Exception e) {

			log.error("SystemController delDic--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 添加人员信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertUser")
	@ResponseBody
	public BaseTransferEntity insertUser(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 账号
			String acc_num = request.getParameter("acc_num");
			// 用户邮箱
			String use_mal = request.getParameter("use_mal");
			// 用户姓名
			String use_nam = request.getParameter("use_nam");
			// 用户性别(1为男，2为女，0为默认值，不予以显示)
			String use_sex = request.getParameter("use_sex");
			// 用户手机号码
			String use_mob = request.getParameter("use_mob");
			// 用户身份证号码
			String use_idc = request.getParameter("use_idc");
			// 用户通讯地址
			String use_add = request.getParameter("use_add");
			// 用户状态
			String use_sta = request.getParameter("use_sta");
			// 职位ID(查询bas_pos表，为该表ID)
			String pos_id = request.getParameter("pos_id");
			// 用户专业
			String use_maj = request.getParameter("use_maj");
			// 学历ID(查询表bas_edu学历表，为此表ID)
			String edu_id = request.getParameter("edu_id");
			// 参加工作时间
			String tak_tim = request.getParameter("tak_tim");
			// 籍贯
			String pla_ori = request.getParameter("pla_ori");
			// 备注
			String remark = request.getParameter("remark");
			// 密码
			String use_pas = request.getParameter("use_pas");
			// 角色ID(表bas_rol,为该表主键)
			String rol_id = request.getParameter("rol_id");
			// 公司ID(表bas_com,为该表主键)
			String com_id = request.getParameter("com_id");
			// 部门ID(表bas_dep,为该表主键)
			String dep_id = request.getParameter("dep_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("acc_num", acc_num);

			map.put("use_mal", use_mal);

			map.put("use_nam", use_nam);

			if (use_sex != null && !use_sex.isEmpty()
					&& !use_sex.equals("null") && !use_sex.equals("")) {

				map.put("use_sex", use_sex);

			} else {

				map.put("use_sex", 0);
			}

			map.put("use_mob", use_mob);

			map.put("use_idc", use_idc);

			map.put("use_add", use_add);

			if (use_sta != null && !use_sta.isEmpty()
					&& !use_sta.equals("null") && !use_sta.equals("")) {

				map.put("use_sta", use_sta);

			} else {

				map.put("use_sta", 0);
			}

			if (pos_id != null && !pos_id.isEmpty() && !pos_id.equals("null")
					&& !pos_id.equals("")) {

				map.put("pos_id", pos_id);

			} else {

				map.put("pos_id", 0);
			}
			map.put("use_maj", use_maj);

			if (edu_id != null && !edu_id.isEmpty() && !edu_id.equals("null")
					&& !edu_id.equals("")) {

				map.put("edu_id", edu_id);

			} else {

				map.put("edu_id", 0);
			}

			if (tak_tim != null && !tak_tim.isEmpty()
					&& !tak_tim.equals("null") && !tak_tim.equals("")) {

				map.put("tak_tim", tak_tim);

			} else {

				map.put("tak_tim", "1970-01-01 08:00:00");
			}
			map.put("pla_ori", pla_ori);

			map.put("remark", remark);

			if (use_pas != null && use_pas != "") {

				map.put("use_pas", StringUtil.md5Encrypt(use_pas, "UTF-8"));

			} else {

				map.put("use_pas", null);
			}

			if (rol_id != null && !rol_id.isEmpty() && !rol_id.equals("null")
					&& !rol_id.equals("")) {

				map.put("rol_id", rol_id);

			} else {

				map.put("rol_id", 0);
			}

			if (com_id != null && !com_id.isEmpty() && !com_id.equals("null")
					&& !com_id.equals("")) {

				map.put("com_id", com_id);

			} else {

				map.put("com_id", 0);
			}

			if (dep_id != null && !dep_id.isEmpty() && !dep_id.equals("null")
					&& !dep_id.equals("")) {

				map.put("dep_id", dep_id);

			} else {

				map.put("dep_id", 0);
			}
			systemService.insertUser(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("进行了用户创建操作，用户名为：" + use_mob);

		} catch (Exception e) {

			log.error("SystemController insertUser--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 修改人员信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updateUser")
	@ResponseBody
	public BaseTransferEntity updateUser(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 账户ID
			String use_id = request.getParameter("use_id");
			// 账号
			String acc_num = request.getParameter("acc_num");
			// 用户邮箱
			String use_mal = request.getParameter("use_mal");
			// 用户姓名
			String use_nam = request.getParameter("use_nam");
			// 用户性别(1为男，2为女，0为默认值，不予以显示)
			String use_sex = request.getParameter("use_sex");
			// 用户手机号码
			String use_mob = request.getParameter("use_mob");
			// 用户身份证号码
			String use_idc = request.getParameter("use_idc");
			// 用户通讯地址
			String use_add = request.getParameter("use_add");
			// 用户状态
			String use_sta = request.getParameter("use_sta");
			// 职位ID(查询bas_pos表，为该表ID)
			String pos_id = request.getParameter("pos_id");
			// 用户专业
			String use_maj = request.getParameter("use_maj");
			// 学历ID(查询表bas_edu学历表，为此表ID)
			String edu_id = request.getParameter("edu_id");
			// 参加工作时间
			String tak_tim = request.getParameter("tak_tim");
			// 籍贯
			String pla_ori = request.getParameter("pla_ori");
			// 备注
			String remark = request.getParameter("remark");
			// 密码
			String use_pas = request.getParameter("use_pas");
			// 角色ID(表bas_rol,为该表主键)
			String rol_id = request.getParameter("rol_id");
			// 公司ID(表bas_com,为该表主键)
			String com_id = request.getParameter("com_id");
			// 部门ID(表bas_dep,为该表主键)
			String dep_id = request.getParameter("dep_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", use_id);

			map.put("acc_num", acc_num);

			map.put("use_mal", use_mal);

			map.put("use_nam", use_nam);

			if (use_sex != null && !use_sex.isEmpty()
					&& !use_sex.equals("null") && !use_sex.equals("")) {

				map.put("use_sex", use_sex);

			} else {

				map.put("use_sex", 0);
			}

			map.put("use_mob", use_mob);

			map.put("use_idc", use_idc);

			map.put("use_add", use_add);

			if (use_sta != null && !use_sta.isEmpty()
					&& !use_sta.equals("null") && !use_sta.equals("")) {

				map.put("use_sta", use_sta);

			} else {

				map.put("use_sta", 0);
			}

			if (pos_id != null && !pos_id.isEmpty() && !pos_id.equals("null")
					&& !pos_id.equals("")) {

				map.put("pos_id", pos_id);

			} else {

				map.put("pos_id", 0);
			}
			map.put("use_maj", use_maj);

			if (edu_id != null && !edu_id.isEmpty() && !edu_id.equals("null")
					&& !edu_id.equals("")) {

				map.put("edu_id", edu_id);

			} else {

				map.put("edu_id", 0);
			}

			if (tak_tim != null && !tak_tim.isEmpty()
					&& !tak_tim.equals("null") && !tak_tim.equals("")) {

				map.put("tak_tim", tak_tim);

			} else {

				map.put("tak_tim", "1970-01-01 08:00:00");
			}
			map.put("pla_ori", pla_ori);

			map.put("remark", remark);

			if (use_pas != null && use_pas != "") {

				map.put("use_pas", StringUtil.md5Encrypt(use_pas, "UTF-8"));

			} else {

				map.put("use_pas", null);
			}

			if (rol_id != null && !rol_id.isEmpty() && !rol_id.equals("null")
					&& !rol_id.equals("")) {

				map.put("rol_id", rol_id);

			} else {

				map.put("rol_id", 0);
			}

			if (com_id != null && !com_id.isEmpty() && !com_id.equals("null")
					&& !com_id.equals("")) {

				map.put("com_id", com_id);

			} else {

				map.put("com_id", 0);
			}

			if (dep_id != null && !dep_id.isEmpty() && !dep_id.equals("null")
					&& !dep_id.equals("")) {

				map.put("dep_id", dep_id);

			} else {

				map.put("dep_id", 0);
			}

			systemService.updateUser(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("用户对ID为" + use_id + "的用户进行了修改操作！");

		} catch (Exception e) {

			log.error("SystemController updateUser--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 删除人员信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/deleteUser")
	@ResponseBody
	public BaseTransferEntity deleteUser(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", use_id);

			systemService.deleteUser(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("用户对ID为" + use_id + "的用户数据进行了删除操作！");

		} catch (Exception e) {

			log.error("SystemController deleteUser--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 查询角色信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAllRolInf")
	@ResponseBody
	public BaseTransferEntity getAllRolInf(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String com_id = request.getParameter("com_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("com_id", com_id);

			List<Map<String, Object>> lst = systemService.getAllRolInf(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getAllRolInf--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 查询职位信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPosInfLst")
	@ResponseBody
	public BaseTransferEntity getPosInfLst(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String com_id = request.getParameter("dep_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("dep_id", com_id);

			List<Map<String, Object>> lst = systemService.getPosInfLst(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getPosInfLst--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 查询部门信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDepInfLst")
	@ResponseBody
	public BaseTransferEntity getDepInfLst(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String com_id = request.getParameter("com_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("com_id", com_id);

			List<Map<String, Object>> lst = systemService.getDepInfLst(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getDepInfLst--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 查询学历信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getEduInfLst")
	@ResponseBody
	public BaseTransferEntity getEduInfLst(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Map<String, Object> map = new HashMap<String, Object>();

			List<Map<String, Object>> lst = systemService.getEduInfLst(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getEduInfLst--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 添加地区信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insReg")
	@ResponseBody
	public BaseTransferEntity insReg(HttpServletRequest request,
			HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String reg_nam = request.getParameter("reg_nam");

			String reg_fat_id = request.getParameter("reg_fat_id");

			String reg_lev = request.getParameter("reg_lev");

			String fir_let = request.getParameter("fir_let");

			String crt_use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("reg_nam", reg_nam);

			if (reg_fat_id != null && !reg_fat_id.isEmpty()
					&& !reg_fat_id.equals("null") && !reg_fat_id.equals("")) {

				map.put("reg_fat_id", reg_fat_id);

			} else {

				map.put("reg_fat_id", 0);
			}

			if (reg_lev != null && !reg_lev.isEmpty()
					&& !reg_lev.equals("null") && !reg_lev.equals("")) {

				map.put("reg_lev", reg_lev);

			} else {

				map.put("reg_lev", 0);
			}

			map.put("fir_let", fir_let);

			if (crt_use_id != null && !crt_use_id.isEmpty()
					&& !crt_use_id.equals("null") && !crt_use_id.equals("")) {

				map.put("crt_use_id", crt_use_id);

			} else {

				map.put("crt_use_id", 0);
			}

			map.put("crt_tim", new Date());

			systemService.insReg(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("SystemController insReg--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 修改地区信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updReg")
	@ResponseBody
	public BaseTransferEntity updReg(HttpServletRequest request,
			HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String reg_id = request.getParameter("id");

			String reg_nam = request.getParameter("reg_nam");

			String reg_fat_id = request.getParameter("reg_fat_id");

			String reg_lev = request.getParameter("reg_lev");

			String fir_let = request.getParameter("fir_let");

			String mod_use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("reg_id", reg_id);

			map.put("reg_nam", reg_nam);

			if (reg_fat_id != null && !reg_fat_id.isEmpty()
					&& !reg_fat_id.equals("null") && !reg_fat_id.equals("")) {

				map.put("reg_fat_id", reg_fat_id);

			} else {

				map.put("reg_fat_id", 0);
			}

			if (reg_lev != null && !reg_lev.isEmpty()
					&& !reg_lev.equals("null") && !reg_lev.equals("")) {

				map.put("reg_lev", reg_lev);

			} else {

				map.put("reg_lev", 0);
			}

			map.put("fir_let", fir_let);

			if (mod_use_id != null && !mod_use_id.isEmpty()
					&& !mod_use_id.equals("null") && !mod_use_id.equals("")) {

				map.put("mod_use_id", mod_use_id);

			} else {

				map.put("mod_use_id", 0);
			}

			map.put("mod_tim", new Date());

			systemService.updReg(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("SystemController updReg--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 删除地区信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delReg")
	@ResponseBody
	public BaseTransferEntity delReg(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String reg_id = request.getParameter("reg_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("reg_id", reg_id);

			if (systemService.delReg(map)) {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setDesc("地区信息删除成功");
				
			} else {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				
				baseTransferEntity.setDesc("删除失败,请确保该地区下的信息已被删除");
			}

		} catch (Exception e) {

			log.error("SystemController delReg--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 查询账户信息，使用ID
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUserById")
	@ResponseBody
	public BaseTransferEntity getUserById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("use_id", use_id);

			List<Map<String, Object>> lst = systemService.getUserById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getUserById--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 查询故障类型信息，使用ID
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getFauTypId")
	@ResponseBody
	public BaseTransferEntity getFauTypId(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String fau_id = request.getParameter("fau_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("fau_id", fau_id);

			List<Map<String, Object>> lst = systemService.getFauTypId(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getFauTypId--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 根据id查询（业主公司信息）/(合作伙伴信息)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasComInfoRol")
	@ResponseBody
	public BaseTransferEntity getBasComInfoRol(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// ID
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			List<Map<String, Object>> retMap = systemService
					.getBasComInfoRol(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(retMap);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController getBasComInfoRol--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 业主信息 添加/修改 判断id 是否为空 如果为空 就添加 不为空 则修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertOrUpdateComInfoRol")
	@ResponseBody
	public BaseTransferEntity updateComInfoRol(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String id = request.getParameter("id");
			String com_nam = request.getParameter("com_nam");
			String com_ide = request.getParameter("com_ide");
			String com_add = request.getParameter("com_add");
			String com_sta = request.getParameter("com_sta");
			String com_con = request.getParameter("com_con");
			String com_tel = request.getParameter("com_tel");
			String com_typ_id = request.getParameter("com_typ_id");
			String com_fat_id = request.getParameter("com_fat_id");
			String com_lep = request.getParameter("com_lep");
			String com_lep_cod = request.getParameter("com_lep_cod");
			String com_lon = request.getParameter("com_lon");
			String com_lat = request.getParameter("com_lat");
			String com_sor = request.getParameter("com_sor");
			String com_cen_lon = request.getParameter("com_cen_lon");
			String com_cen_lat = request.getParameter("com_cen_lat");
			String com_zoo_lev = request.getParameter("com_zoo_lev");
			String com_lev = request.getParameter("com_lev");
			String com_rol = request.getParameter("com_rol");
			String pro_id = request.getParameter("pro_id");
			String cit_id = request.getParameter("cit_id");
			String are_id = request.getParameter("are_id");
			String remark = request.getParameter("remark");
			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("com_nam", com_nam);
			map.put("com_ide", com_ide);
			map.put("com_add", com_add);
			map.put("com_sta", com_sta);
			map.put("com_con", com_con);
			map.put("com_tel", com_tel);
			map.put("com_typ_id", com_typ_id);
			map.put("com_fat_id", com_fat_id);
			map.put("com_lep", com_lep);
			map.put("com_lep_cod", com_lep_cod);
			if (com_lon != null && !com_lon.isEmpty()
					&& !com_lon.equals("null") && !com_lon.equals("")) {

				map.put("com_lon", com_lon);

			} else {

				map.put("com_lon", 0);
			}
			if (com_lat != null && !com_lat.isEmpty()
					&& !com_lat.equals("null") && !com_lat.equals("")) {

				map.put("com_lat", com_lat);

			} else {

				map.put("com_lat", 0);
			}

			map.put("com_sor", com_sor);

			if (com_cen_lon != null && !com_cen_lon.isEmpty()
					&& !com_cen_lon.equals("null") && !com_cen_lon.equals("")) {

				map.put("com_cen_lon", com_cen_lon);

			} else {

				map.put("com_cen_lon", 0);
			}

			if (com_cen_lat != null && !com_cen_lat.isEmpty()
					&& !com_cen_lat.equals("null") && !com_cen_lat.equals("")) {

				map.put("com_cen_lat", com_cen_lat);

			} else {

				map.put("com_cen_lat", 0);
			}

			if (com_zoo_lev != null && !com_zoo_lev.isEmpty()
					&& !com_zoo_lev.equals("null") && !com_zoo_lev.equals("")) {

				map.put("com_zoo_lev", com_zoo_lev);

			} else {

				map.put("com_zoo_lev", 0);
			}

			if (com_lev != null && !com_lev.isEmpty()
					&& !com_lev.equals("null") && !com_lev.equals("")) {

				map.put("com_lev", com_lev);

			} else {

				map.put("com_lev", 0);
			}

			if (com_rol != null && !com_rol.isEmpty()
					&& !com_rol.equals("null") && !com_rol.equals("")) {

				map.put("com_rol", com_rol);

			} else {

				map.put("com_rol", 1);
			}
			map.put("pro_id", pro_id);
			map.put("cit_id", cit_id);
			map.put("are_id", are_id);
			map.put("remark", remark);
			map.put("use_id", use_id);
			map.put("", new Date());

			if (id != null) {

				// 判断添加的公司名称是否存在
				List<Map<String, Object>> retLst = utilsService
						.getComInfByComNam(map);

				if (retLst != null && !retLst.isEmpty()
						&& retLst.get(0) != null && !retLst.get(0).isEmpty()
						&& !retLst.get(0).get("id").toString().equals(id)) {

					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("code.global.error.datarepeat"));
					baseTransferEntity.setData("");
					baseTransferEntity.setDesc(MobileConfig
							.get("msg.global.error.datarepeat"));

				} else {
					map.put("id", id);

					systemService.updateComInfoRol(map);

					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("code.global.success"));
					baseTransferEntity.setData("");
					baseTransferEntity.setDesc(MobileConfig
							.get("msg.global.success"));
				}
			} else {
				// 判断添加的公司名称是否存在
				List<Map<String, Object>> retLst = utilsService
						.getComInfByComNam(map);

				if (retLst != null && !retLst.isEmpty()
						&& retLst.get(0) != null && !retLst.get(0).isEmpty()) {

					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("code.global.error.datarepeat"));
					baseTransferEntity.setData("");
					baseTransferEntity.setDesc(MobileConfig
							.get("msg.global.error.datarepeat"));

				} else {

					systemService.insertComInfoRol(map);

					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("code.global.success"));
					baseTransferEntity.setData("");
					baseTransferEntity.setDesc(MobileConfig
							.get("msg.global.success"));
				}
			}

		} catch (Exception e) {
			log.error(
					"SystemController insertOrUpdateComInfoRol--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 合作伙伴信息 添加/修改 判断id 是否为空 如果为空 就添加 不为空 则修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertOrUpdateComInfoRol2")
	@ResponseBody
	public BaseTransferEntity updateComInfoRol2(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			String id = request.getParameter("id");
			String com_nam = request.getParameter("com_nam");
			String com_ide = request.getParameter("com_ide");
			String com_add = request.getParameter("com_add");
			String com_sta = request.getParameter("com_sta");
			String com_con = request.getParameter("com_con");
			String com_tel = request.getParameter("com_tel");
			String com_typ_id = request.getParameter("com_typ");
			String com_fat_id = request.getParameter("com_fat_id");
			String com_lep = request.getParameter("com_lep");
			String com_lep_cod = request.getParameter("com_lep_cod");
			String com_lon = request.getParameter("com_lon");
			String com_lat = request.getParameter("com_lat");
			String com_sor = request.getParameter("com_sor");
			String com_cen_lon = request.getParameter("com_cen_lon");
			String com_cen_lat = request.getParameter("com_cen_lat");
			String com_zoo_lev = request.getParameter("com_zoo_lev");
			String com_lev = request.getParameter("com_lev");
			String com_rol = request.getParameter("com_rol");
			String pro_id = request.getParameter("pro_id");
			String cit_id = request.getParameter("cit_id");
			String are_id = request.getParameter("are_id");
			String remark = request.getParameter("remark");
			String use_id = request.getParameter("use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("com_nam", com_nam);
			map.put("com_ide", com_ide);
			map.put("com_add", com_add);
			map.put("com_sta", com_sta);
			map.put("com_con", com_con);
			map.put("com_tel", com_tel);
			map.put("com_typ_id", com_typ_id);
			map.put("com_fat_id", com_fat_id);
			map.put("com_lep", com_lep);
			map.put("com_lep_cod", com_lep_cod);
			if (com_lon != null && !com_lon.isEmpty()
					&& !com_lon.equals("null") && !com_lon.equals("")) {

				map.put("com_lon", com_lon);

			} else {

				map.put("com_lon", 0);
			}
			if (com_lat != null && !com_lat.isEmpty()
					&& !com_lat.equals("null") && !com_lat.equals("")) {

				map.put("com_lat", com_lat);

			} else {

				map.put("com_lat", 0);
			}

			map.put("com_sor", com_sor);

			if (com_cen_lon != null && !com_cen_lon.isEmpty()
					&& !com_cen_lon.equals("null") && !com_cen_lon.equals("")) {

				map.put("com_cen_lon", com_cen_lon);

			} else {

				map.put("com_cen_lon", 0);
			}

			if (com_cen_lat != null && !com_cen_lat.isEmpty()
					&& !com_cen_lat.equals("null") && !com_cen_lat.equals("")) {

				map.put("com_cen_lat", com_cen_lat);

			} else {

				map.put("com_cen_lat", 0);
			}

			if (com_zoo_lev != null && !com_zoo_lev.isEmpty()
					&& !com_zoo_lev.equals("null") && !com_zoo_lev.equals("")) {

				map.put("com_zoo_lev", com_zoo_lev);

			} else {

				map.put("com_zoo_lev", 0);
			}

			if (com_lev != null && !com_lev.isEmpty()
					&& !com_lev.equals("null") && !com_lev.equals("")) {

				map.put("com_lev", com_lev);

			} else {

				map.put("com_lev", 0);
			}

			if (com_rol != null && !com_rol.isEmpty()
					&& !com_rol.equals("null") && !com_rol.equals("")) {

				map.put("com_rol", com_rol);

			} else {

				map.put("com_rol", 2);
			}
			map.put("pro_id", pro_id);
			map.put("cit_id", cit_id);
			map.put("are_id", are_id);
			map.put("remark", remark);
			map.put("use_id", use_id);
			map.put("tim", new Date());

			if (id != null) {

				// 判断添加的公司名称是否存在
				List<Map<String, Object>> retLst = utilsService
						.getComInfByComNam(map);

				if (retLst != null && !retLst.isEmpty()
						&& retLst.get(0) != null && !retLst.get(0).isEmpty()
						&& !retLst.get(0).get("id").toString().equals(id)) {

					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("code.global.error.datarepeat"));
					baseTransferEntity.setData("");
					baseTransferEntity.setDesc(MobileConfig
							.get("msg.global.error.datarepeat"));

				} else {
					map.put("id", id);

					systemService.updateComInfoRol2(map);

					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("code.global.success"));
					baseTransferEntity.setData("");
					baseTransferEntity.setDesc(MobileConfig
							.get("msg.global.success"));
				}

			} else {
				// 判断添加的公司名称是否存在
				List<Map<String, Object>> retLst = utilsService
						.getComInfByComNam(map);

				if (retLst != null && !retLst.isEmpty()
						&& retLst.get(0) != null && !retLst.get(0).isEmpty()) {

					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("code.global.error.datarepeat"));
					baseTransferEntity.setData("");
					baseTransferEntity.setDesc(MobileConfig
							.get("msg.global.error.datarepeat"));

				} else {

					systemService.insertComInfoRol2(map);

					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("code.global.success"));
					baseTransferEntity.setData("");
					baseTransferEntity.setDesc(MobileConfig
							.get("msg.global.success"));
				}
			}
		} catch (Exception e) {
			log.error("SystemController insertOrUpdateComInfoRol2--------->"
					+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**************************** 字典数据管理 ************************************/
	/**
	 * 添加数据字典
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insDataDic")
	@ResponseBody
	public BaseTransferEntity insDataDic(HttpServletRequest request,
			HttpServletResponse response, DataDicDto dataDicDto) {
		baseTransferEntity = new BaseTransferEntity();

		try {
			dataDicDto.setCrt_use_id(getCurrentUserId(request));
			dataDicDto.setCrt_tim(new Date());
			systemService.insDataDic(dataDicDto);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("SystemController insDataDic--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * TODO 跳转到修改数据字典页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/toUpdDicPage")
	@ResponseBody
	public BaseTransferEntity toUpdDicPage(HttpServletRequest request,
			HttpServletResponse response, DataDicDto dataDicDto) {
		baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> map = new HashMap<String, Object>();

		try {
			map.put("id", dataDicDto.getId());
			map.put("del_flag", DataDicDto.DEL_NO);

			DataDicDto dataDic = systemService.getDataDicById(map);
			baseTransferEntity.setData(dataDic);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController toUpdDicPage--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 修改数据字典
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updDataDic")
	@ResponseBody
	public BaseTransferEntity updDataDic(HttpServletRequest request,
			HttpServletResponse response, DataDicDto dataDicDto) {
		baseTransferEntity = new BaseTransferEntity();

		try {
			dataDicDto.setCrt_use_id(getCurrentUserId(request));
			dataDicDto.setMod_tim(new Date());
			systemService.updDataDic(dataDicDto);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("SystemController updDataDic--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 逻辑删除数据字典
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delDataDic")
	@ResponseBody
	public BaseTransferEntity delDataDic(HttpServletRequest request,
			HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			if (id != null && id != "") {
				map.put("id", Integer.parseInt(id));
			}
			map.put("mod_use_id", getCurrentUserId(request));
			map.put("del_flag", DataDicDto.DEL_YES);
			map.put("mod_tim", new Date());

			systemService.delDataDic(map);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("SystemController delDataDic--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 获取数据字典列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDataDicList")
	@ResponseBody
	public BaseTransferEntity getDataDicList(HttpServletRequest request,
			HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		Map<String, Object> map = new HashMap<String, Object>();

		String dic_typ_id = request.getParameter("dic_typ_id");
		String par_nam = request.getParameter("par_nam");
		String currentPage = request.getParameter("currentPage");

		Pager page = new Pager();
		if (currentPage != null && !currentPage.isEmpty()) {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}

		try {
			if (dic_typ_id != null && dic_typ_id != "") {
				map.put("dic_typ_id", Integer.parseInt(dic_typ_id));
			}
			map.put("del_flag", DataDicDto.DEL_NO);
			map.put("par_nam", par_nam);

			int totalCount = systemService.getDicListCount(map);
			page.setTotalCount(totalCount);

			map.put("start", page.getStart());
			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> dataDicList = systemService
					.getDataDicListByTypAndNam(map);
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(dataDicList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController getDataDicList--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/************
	 * 添加数据字典类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insDataDicTyp")
	@ResponseBody
	public BaseTransferEntity insDataDicTyp(HttpServletRequest request,
			HttpServletResponse response, DataDicTypeDto dataDicTypeDto) {
		baseTransferEntity = new BaseTransferEntity();

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("dic_typ_nam", dataDicTypeDto.getDic_typ_nam());
			List<Map<String, Object>> lstName = systemService
					.getDataDicTypByName(map);
			if (lstName != null && !lstName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("类型名称重复，请重新填写！");
				return baseTransferEntity;
			}

			dataDicTypeDto.setCrt_use_id(getCurrentUserId(request));
			systemService.insDataDicTyp(dataDicTypeDto);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController insDataDicTyp--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 跳转到修改数据字典类型窗口
	 */
	@RequestMapping(value = "/service/toUpdDicTypPage")
	@ResponseBody
	public BaseTransferEntity toUpdDicTypPage(HttpServletRequest request,
			HttpServletResponse response, DataDicTypeDto dataDicTypeDto) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (id != null && id != "") {
				map.put("id", Integer.parseInt(id));
			}
			map.put("del_flag", DataDicTypeDto.DEL_NO);
			DataDicTypeDto dicTyp = systemService.getDataDicTypById(map);

			baseTransferEntity.setData(dicTyp);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController toUpdDicTypPage--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 修改数据字典类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updDataDicTyp")
	@ResponseBody
	public BaseTransferEntity updDataDicTyp(HttpServletRequest request,
			HttpServletResponse response, DataDicTypeDto dataDicTypeDto) {
		baseTransferEntity = new BaseTransferEntity();

		try {
/*
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("dic_typ_nam", dataDicTypeDto.getDic_typ_nam());
			List<Map<String, Object>> lstName = systemService
					.getDataDicTypByName(map1);
			if (lstName != null && !lstName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("类型名称重复，请重新填写！");
				return baseTransferEntity;
			}
*/
			dataDicTypeDto.setMod_use_id(getCurrentUserId(request));
			systemService.updDataDicTyp(dataDicTypeDto);

			// 查询修改后的 信息
			DataDicTypeDto dicTyp = null;
			Map<String, Object> map = new HashMap<String, Object>();
			Integer id = dataDicTypeDto.getId();
			if (id != null) {
				map.put("id", id);
				map.put("del_flag", DataDicTypeDto.DEL_NO);
				dicTyp = systemService.getDataDicTypById(map);
			}

			baseTransferEntity.setData(dicTyp);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController updDataDicTyp--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 逻辑删除 数据字典类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delDataDicTyp")
	@ResponseBody
	public BaseTransferEntity delDataDicTyp(HttpServletRequest request,HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			if (id != null && id != "") {
				map.put("id", Integer.parseInt(id));
			}
			map.put("mod_use_id", getCurrentUserId(request));
			
			map.put("mod_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			if (systemService.delDataDicTyp(map)) {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setDesc("删除成功");
				
			} else {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				
				baseTransferEntity.setDesc("删除失败,请确保该项目下的字典信息已被删除");
			}
			
		} catch (Exception e) {
			
			log.error("SystemController delDataDicTyp--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * 获取数据字典类型列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDataDicTypList")
	@ResponseBody
	public BaseTransferEntity getDataDicTypList(HttpServletRequest request,
			HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> map = new HashMap<String, Object>();
		String dic_typ_nam = request.getParameter("dic_typ_nam");

		map.put("del_flag", DataDicTypeDto.DEL_NO);
		map.put("dic_typ_nam", dic_typ_nam);

		try {
			List<Map<String, Object>> dataDicTypList = systemService
					.getDataDicTypList(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(dataDicTypList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"SystemController getDataDicTypList--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/* ****************告警类型管理和告警码管理部分Start ******************** */
	/*
	 * 新增一个告警码
	 */
	@RequestMapping(value = "/service/addAlaCode")
	@ResponseBody
	public BaseTransferEntity addAlaCode(String app_typ_id, String idx_pst,
			String ala_typ_id, String flt_lev, String ala_info, String remark,
			String crt_use_id) {
		baseTransferEntity = new BaseTransferEntity();
		try {
			systemService.InsertAlaCode(null, app_typ_id, idx_pst, ala_typ_id,
					flt_lev, ala_info, remark, crt_use_id, new Date());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("添加成功");
		} catch (Exception e) {
			log.error("增加告警码异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/*
	 * 删除一个告警码
	 */
	@RequestMapping(value = "/service/removeAlaCode")
	@ResponseBody
	public BaseTransferEntity removeAlaCode(int id) {
		baseTransferEntity = new BaseTransferEntity();
		try {
			if (systemService.removeAlaCode(id) == 1) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("删除成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("删除失败，原因可能为该告警码不存在");
			}
		} catch (Exception e) {
			log.error("增加告警码异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	// 修改一个告警码信息
	@RequestMapping(value = "/service/updateAlaCode")
	@ResponseBody
	public BaseTransferEntity updateAlaCode(int id, String app_typ_id,
			String idx_pst, String flt_lev, String ala_typ_id, String ala_info,
			String remark, String use_id) {
		baseTransferEntity = new BaseTransferEntity();
		try {
			int result = systemService.updateAlaCodeInfo(id, app_typ_id,
					idx_pst, flt_lev, ala_typ_id, ala_info, remark, use_id,
					new Date());
			if (result == 1) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("更新成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("更新失败，原因可能为该告警码不存在");
			}
		} catch (Exception e) {
			log.error("更新告警码异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	// 新增告警类型
	@RequestMapping(value = "/service/insertAlaType")
	@ResponseBody
	public BaseTransferEntity insertAlaType(String ala_nam, int app_typ_id,
			int crt_use_id, String remark) {
		baseTransferEntity = new BaseTransferEntity();
		try {

			if (systemService.insertAlaTyp(ala_nam, app_typ_id, crt_use_id,
					new Date(), remark)) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("增加成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("增加成功");
			}
		} catch (Exception e) {
			log.error("增加告警类型异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	// 删除一个告警码类型，删除规则为当前类型没有任何的告警码的情况下才可以删除
	@RequestMapping(value = "/service/reomveAlaType")
	@ResponseBody
	public BaseTransferEntity reomveAlaType(int id) {
		baseTransferEntity = new BaseTransferEntity();
		try {

			if (systemService.removeAlaType(id)) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("删除成功!");
			} else {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("删除失败，请确保该类型下面没有任何的告警码");
			}
		} catch (Exception e) {
			log.error("增加告警类型异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	// 获取所有的告警类型信息，当只给一个id的时候则只获得一个告警类型的信息
	@RequestMapping(value = "/service/getAlaType")
	@ResponseBody
	public BaseTransferEntity getAlaType(
			@RequestParam(value = "id", required = false) String id) {
		baseTransferEntity = new BaseTransferEntity();
		try {

			baseTransferEntity.setData(systemService.getAlaType(id));
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

		} catch (Exception e) {
			log.error("获取告警信息异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	// 获取根据类型或者根据id获取所有的告警码
	@RequestMapping(value = "/service/getAlaCode")
	@ResponseBody
	public BaseTransferEntity getAlaCode(
			@RequestParam(value = "id", required = false) String id,
			String typeId, String search, String currentPage) {

		baseTransferEntity = new BaseTransferEntity();

		try {

			Pager page = new Pager();

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			map.put("typeId", typeId);

			map.put("search", search);

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			Map<String, Object> couMap = systemService.getAlaCodeInfoCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> alaLst = systemService.getAla(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(alaLst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("获取告警码异常" + e.getMessage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	// 根据设备类型id获取设备信息
	@RequestMapping(value = "/service/getAppInfo")
	@ResponseBody
	public BaseTransferEntity getAppInfo(String id) {
		baseTransferEntity = new BaseTransferEntity();
		try {

			baseTransferEntity.setData(systemService.getAppInfoById(id));
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

		} catch (Exception e) {
			log.error("获取告警码异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	@RequestMapping(value = "/service/updateAlaType")
	@ResponseBody
	public BaseTransferEntity updateAlaType(String ala_nam, String app_typ_id,
			String mod_use_id, String remark, String id) {
		baseTransferEntity = new BaseTransferEntity();
		try {

			if (systemService.updateAlaType(ala_nam, app_typ_id, mod_use_id,
					new Date(), remark, id)) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("更新成功!");
			} else {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("更新告警类型是失败");
			}
		} catch (Exception e) {
			log.error("增加告警类型异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/* 告警类型管理和告警码管理部分End */

	/*
	 * --------------------------------------设备信息维护部分Start------------------------
	 * --------------
	 */
	/**
	 * 获取设备列表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getEquInfLst")
	@ResponseBody
	public BaseTransferEntity getEquInfLst(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 设备类型唯一标识码，如：CNNBQ(储能逆变器)，GFNBQ(光伏逆变器)等
			String app_typ_ide = request.getParameter("app_typ_ide");
			// 站ID
			String pws_id = request.getParameter("pws_id");
			// 设备型号ID
			String app_id = request.getParameter("app_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("app_typ_ide", app_typ_ide);

			map.put("pws_id", pws_id);

			map.put("app_id", app_id);

			Map<String, Object> couMap = systemService.getEquInfLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = systemService.getEquInfLst(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController getEquInfLst--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 获取控制器设备列表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getCtlEquInfLst")
	@ResponseBody
	public BaseTransferEntity getCtlEquInfLst(HttpServletRequest request,
			HttpServletResponse response) {

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
			String app_id = request.getParameter("app_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("pws_id", pws_id);

			map.put("app_id", app_id);

			Map<String, Object> couMap = systemService.getCtlEquInfLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = systemService.getCtlEquInfLst(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"UserController getCtlEquInfLst--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 使用设备ID获取设备信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getEquInfByEquId")
	@ResponseBody
	public BaseTransferEntity getEquInfByEquId(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			// 设备ID
			String equ_id = request.getParameter("equ_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("equ_id", equ_id);

			List<Map<String, Object>> lst = systemService.getEquInfByEquId(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController getEquInfByEquId--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 新增设备详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertEquInfo")
	@ResponseBody
	public BaseTransferEntity insertEquInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 站ID
			String equ_nam = request.getParameter("equ_nam");
			// 设备型号ID
			String equ_mod_id = request.getParameter("equ_mod_id");

			String pws_id = request.getParameter("pws_id");

			String ins_add = request.getParameter("ins_add");

			String equ_lon = request.getParameter("equ_lon");

			String equ_lat = request.getParameter("equ_lat");

			String pro_tim = request.getParameter("pro_tim");

			String ope_tim = request.getParameter("ope_tim");

			String pur_tim = request.getParameter("pur_tim");

			String equ_sta = request.getParameter("equ_sta");

			String equ_num = request.getParameter("equ_num");

			String equ_cod = request.getParameter("equ_cod");

			String cur_sta = request.getParameter("cur_sta");

			String crt_use_id = request.getParameter("use_id");

			String remark = request.getParameter("remark");

			String equ_sor = request.getParameter("equ_sor");

			String meter_typ = request.getParameter("meter_typ");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("equ_nam", equ_nam);

			if (equ_mod_id != null && !equ_mod_id.isEmpty()
					&& !equ_mod_id.equals("null") && !equ_mod_id.equals("")) {

				map.put("equ_mod_id", equ_mod_id);

			} else {

				map.put("equ_mod_id", 0);
			}

			if (pws_id != null && !pws_id.isEmpty() && !pws_id.equals("null")
					&& !pws_id.equals("")) {

				map.put("pws_id", pws_id);

			} else {

				map.put("pws_id", 0);
			}
			map.put("ins_add", ins_add);

			if (equ_lon != null && !equ_lon.isEmpty()
					&& !equ_lon.equals("null") && !equ_lon.equals("")) {

				map.put("equ_lon", equ_lon);

			} else {

				map.put("equ_lon", 0);
			}

			if (equ_lat != null && !equ_lat.isEmpty()
					&& !equ_lat.equals("null") && !equ_lat.equals("")) {

				map.put("equ_lat", equ_lat);

			} else {

				map.put("equ_lat", 0);
			}

			if (pro_tim != null && !pro_tim.isEmpty()
					&& !pro_tim.equals("null") && !pro_tim.equals("")) {

				map.put("pro_tim", pro_tim);

			} else {

				map.put("pro_tim", "1970-01-01 08:00:00");
			}

			if (ope_tim != null && !ope_tim.isEmpty()
					&& !ope_tim.equals("null") && !ope_tim.equals("")) {

				map.put("ope_tim", ope_tim);

			} else {

				map.put("ope_tim", "1970-01-01 08:00:00");
			}

			if (pur_tim != null && !pur_tim.isEmpty()
					&& !pur_tim.equals("null") && !pur_tim.equals("")) {

				map.put("pur_tim", pur_tim);

			} else {

				map.put("pur_tim", "1970-01-01 08:00:00");
			}

			if (equ_sta != null && !equ_sta.isEmpty()
					&& !equ_sta.equals("null") && !equ_sta.equals("")) {

				map.put("equ_sta", equ_sta);

			} else {

				map.put("equ_sta", 0);
			}

			map.put("equ_num", equ_num);

			map.put("equ_cod", equ_cod);

			if (cur_sta != null && !cur_sta.isEmpty()
					&& !cur_sta.equals("null") && !cur_sta.equals("")) {

				map.put("cur_sta", cur_sta);

			} else {

				map.put("cur_sta", 0);
			}
			if (crt_use_id != null && !crt_use_id.isEmpty()
					&& !crt_use_id.equals("null") && !crt_use_id.equals("")) {

				map.put("crt_use_id", crt_use_id);

			} else {

				map.put("crt_use_id", 0);
			}
			map.put("crt_tim", new Date());

			map.put("remark", remark);

			if (equ_sor != null && !equ_sor.isEmpty()
					&& !equ_sor.equals("null") && !equ_sor.equals("")) {

				map.put("equ_sor", equ_sor);

			} else {

				map.put("equ_sor", 0);
			}

			if (meter_typ != null && !meter_typ.isEmpty()
					&& !meter_typ.equals("null") && !meter_typ.equals("")) {

				map.put("meter_typ", meter_typ);

			} else {

				map.put("meter_typ", 0);
			}
			
			//设备添加 放置 设备编号重复 
			Map<String,Object> equMap = new HashMap<String, Object>();
			equMap.put("equ_num", equ_num);
			List<Map<String,Object>> equLst = systemService.getEquNameByEquNum(equMap);
			if (equLst != null && !equLst.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
				baseTransferEntity.setDesc("设备编号已存在，请重新填写设备编号！");
				return baseTransferEntity;
			}
			
			systemService.insertEquInfo(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController insertEquInfo--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 修改设备详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updateEquInfo")
	@ResponseBody
	public BaseTransferEntity updateEquInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备ID
			String equ_id = request.getParameter("equ_id");
			// 设备名称
			String equ_nam = request.getParameter("equ_nam");
			// 设备型号ID
			String equ_mod_id = request.getParameter("equ_mod_id");

			String pws_id = request.getParameter("pws_id");

			String ins_add = request.getParameter("ins_add");

			String equ_lon = request.getParameter("equ_lon");

			String equ_lat = request.getParameter("equ_lat");

			String pro_tim = request.getParameter("pro_tim");

			String ope_tim = request.getParameter("ope_tim");

			String pur_tim = request.getParameter("pur_tim");

			String equ_sta = request.getParameter("equ_sta");
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// 设备编号（业主）
			String equ_cod = request.getParameter("equ_cod");
			// 设备状态
			String cur_sta = request.getParameter("cur_sta");
			// 修改人
			String mod_use_id = request.getParameter("use_id");

			String remark = request.getParameter("remark");

			String equ_sor = request.getParameter("equ_sor");
			// 电表类型
			String meter_typ = request.getParameter("meter_typ");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("equ_id", equ_id);

			map.put("equ_nam", equ_nam);

			if (equ_mod_id != null && !equ_mod_id.isEmpty()
					&& !equ_mod_id.equals("null") && !equ_mod_id.equals("")) {

				map.put("equ_mod_id", equ_mod_id);

			} else {

				map.put("equ_mod_id", 0);
			}

			if (pws_id != null && !pws_id.isEmpty() && !pws_id.equals("null")
					&& !pws_id.equals("")) {

				map.put("pws_id", pws_id);

			} else {

				map.put("pws_id", 0);
			}

			map.put("ins_add", ins_add);

			if (equ_lon != null && !equ_lon.isEmpty()
					&& !equ_lon.equals("null") && !equ_lon.equals("")) {

				map.put("equ_lon", equ_lon);

			} else {

				map.put("equ_lon", 0);
			}

			if (equ_lat != null && !equ_lat.isEmpty()
					&& !equ_lat.equals("null") && !equ_lat.equals("")) {

				map.put("equ_lat", equ_lat);

			} else {

				map.put("equ_lat", 0);
			}

			if (pro_tim != null && !pro_tim.isEmpty()
					&& !pro_tim.equals("null") && !pro_tim.equals("")) {

				map.put("pro_tim", pro_tim);

			} else {

				map.put("pro_tim", "1970-01-01 08:00:00");
			}

			if (ope_tim != null && !ope_tim.isEmpty()
					&& !ope_tim.equals("null") && !ope_tim.equals("")) {

				map.put("ope_tim", ope_tim);

			} else {

				map.put("ope_tim", "1970-01-01 08:00:00");
			}

			if (pur_tim != null && !pur_tim.isEmpty()
					&& !pur_tim.equals("null") && !pur_tim.equals("")) {

				map.put("pur_tim", pur_tim);

			} else {

				map.put("pur_tim", "1970-01-01 08:00:00");
			}

			if (equ_sta != null && !equ_sta.isEmpty()
					&& !equ_sta.equals("null") && !equ_sta.equals("")) {

				map.put("equ_sta", equ_sta);

			} else {

				map.put("equ_sta", 0);
			}

			map.put("equ_num", equ_num);

			map.put("equ_cod", equ_cod);

			if (cur_sta != null && !cur_sta.isEmpty()
					&& !cur_sta.equals("null") && !cur_sta.equals("")) {

				map.put("cur_sta", cur_sta);

			} else {

				map.put("cur_sta", 0);
			}

			map.put("mod_use_id", mod_use_id);

			if (mod_use_id != null && !mod_use_id.isEmpty()
					&& !mod_use_id.equals("null") && !mod_use_id.equals("")) {

				map.put("mod_use_id", mod_use_id);

			} else {

				map.put("mod_use_id", 0);
			}

			map.put("mod_tim", new Date());

			map.put("remark", remark);

			map.put("equ_sor", equ_sor);

			if (equ_sor != null && !equ_sor.isEmpty()
					&& !equ_sor.equals("null") && !equ_sor.equals("")) {

				map.put("equ_sor", equ_sor);

			} else {

				map.put("equ_sor", 0);
			}

			if (meter_typ != null && !meter_typ.isEmpty()
					&& !meter_typ.equals("null") && !meter_typ.equals("")) {

				map.put("meter_typ", meter_typ);

			} else {

				map.put("meter_typ", 0);
			}

			//设备添加 放置 设备编号重复 
			Map<String,Object> equMap = new HashMap<String, Object>();
			
			equMap.put("equ_num", equ_num);
			// 使用设备编号获取设备详情信息
			List<Map<String,Object>> equLst = systemService.getEquNameByEquNum(equMap);
			// 使用设备ID获取设备详情信息
			List<Map<String,Object>> equInfLst = systemService.getEquInfByEquId(map);
			
			if(equInfLst != null && !equInfLst.isEmpty()){
				
				if (equLst != null && !equLst.isEmpty() && !equInfLst.get(0).get("equ_num").equals(equ_num)) {
					
					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
					
					baseTransferEntity.setDesc("设备编号已存在，请重新填写设备编号！");
					
					return baseTransferEntity;
				}
			}
			
			systemService.updateEquInfo(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController updateEquInfo--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 逻辑删除某设备详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delectEquInfo")
	@ResponseBody
	public BaseTransferEntity delectEquInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备ID
			String equ_id = request.getParameter("equ_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("equ_id", equ_id);

			systemService.delectEquInfo(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController delectEquInfo--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 获取电站列表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsInfLst")
	@ResponseBody
	public BaseTransferEntity getPwsInfLst(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 站ID
			String pws_id = request.getParameter("pws_id");
			// 公司ID
			String com_id = request.getParameter("com_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("pws_id", pws_id);

			map.put("com_id", com_id);

			Map<String, Object> couMap = systemService.getPwsInfLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = systemService.getPwsInfLst(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("UserController getPwsInfLst--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取电站列表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsInfLstByComId")
	@ResponseBody
	public BaseTransferEntity getPwsInfLstByComId(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 站ID
			String pws_id = request.getParameter("pws_id");
			// 公司ID
			String com_id = request.getParameter("com_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			map.put("com_id", com_id);
			
			List<Map<String, Object>> lst = systemService.getPwsInfLstByComId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UserController getPwsInfLstByComId--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 使用电站ID获取电站信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsInfLstByPwsId")
	@ResponseBody
	public BaseTransferEntity getPwsInfLstByPwsId(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			// 电站ID
			String pws_id = request.getParameter("pws_id");
			// 公司ID
			String com_id = request.getParameter("com_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("pws_id", pws_id);

			map.put("com_id", com_id);

			List<Map<String, Object>> lst = systemService
					.getPwsInfLstByPwsId(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController getPwsInfLstByPwsId--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 新增电站详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertPwsInfo")
	@ResponseBody
	public BaseTransferEntity insertPwsInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			Map<String, Object> map = new HashMap<String, Object>();

			// 电站名称
			String pws_nam = request.getParameter("pws_nam");

			map.put("pws_nam", pws_nam);
			// 站类型
			String pws_typ = request.getParameter("pws_typ");

			if (pws_typ != null && !pws_typ.isEmpty()
					&& !pws_typ.equals("null") && !pws_typ.equals("")) {

				map.put("pws_typ", pws_typ);

			} else {

				map.put("pws_typ", 0);
			}
			// 运营类型（1为独立运维，2为统一运维）
			String ope_typ = request.getParameter("ope_typ");

			if (ope_typ != null && !ope_typ.isEmpty()
					&& !ope_typ.equals("null") && !ope_typ.equals("")) {

				map.put("ope_typ", ope_typ);

			} else {

				map.put("ope_typ", 0);
			}
			// 当前状态（1为计划，2为在建，3为投运）
			String cur_sta = request.getParameter("cur_sta");

			if (cur_sta != null && !cur_sta.isEmpty()
					&& !cur_sta.equals("null") && !cur_sta.equals("")) {

				map.put("cur_sta", cur_sta);

			} else {

				map.put("cur_sta", 0);
			}
			// 运维负责人
			String dev_add_num = request.getParameter("dev_add_num");

			map.put("dev_add_num", dev_add_num);
			// 省级ID
			String pro_id = request.getParameter("pro_id");

			if (pro_id != null && !pro_id.isEmpty() && !pro_id.equals("null")
					&& !pro_id.equals("")) {

				map.put("pro_id", pro_id);

			} else {

				map.put("pro_id", 0);
			}
			// 市级ID
			String cit_id = request.getParameter("cit_id");

			if (cit_id != null && !cit_id.isEmpty() && !cit_id.equals("null")
					&& !cit_id.equals("")) {

				map.put("cit_id", cit_id);

			} else {

				map.put("cit_id", 0);
			}
			// 区级ID
			String are_id = request.getParameter("are_id");

			if (are_id != null && !are_id.isEmpty() && !are_id.equals("null")
					&& !are_id.equals("")) {

				map.put("are_id", are_id);

			} else {

				map.put("are_id", 0);
			}
			// 联系人
			String con_nam = request.getParameter("con_nam");

			map.put("con_nam", con_nam);
			// 联系电话
			String con_mob = request.getParameter("con_mob");

			map.put("con_mob", con_mob);
			// 组织名称
			String org_nam = request.getParameter("org_nam");

			map.put("org_nam", org_nam);
			// 投运时间
			String ope_tim = request.getParameter("ope_tim");

			if (ope_tim != null && !ope_tim.isEmpty()
					&& !ope_tim.equals("null") && !ope_tim.equals("")) {

				map.put("ope_tim", ope_tim);

			} else {

				map.put("ope_tim", "1970-01-01 08:00:00");
			}
			// 占地面积
			String are_cov = request.getParameter("are_cov");

			if (are_cov != null && !are_cov.isEmpty()
					&& !are_cov.equals("null") && !are_cov.equals("")) {

				map.put("are_cov", are_cov);

			} else {

				map.put("are_cov", 0);
			}
			// 电站地址
			String pws_add = request.getParameter("pws_add");

			map.put("pws_add", pws_add);
			// 经度
			String pws_lon = request.getParameter("pws_lon");

			if (pws_lon != null && !pws_lon.isEmpty()
					&& !pws_lon.equals("null") && !pws_lon.equals("")) {

				map.put("pws_lon", pws_lon);

			} else {

				map.put("pws_lon", 0);
			}
			// 纬度
			String pws_lat = request.getParameter("pws_lat");

			if (pws_lat != null && !pws_lat.isEmpty()
					&& !pws_lat.equals("null") && !pws_lat.equals("")) {

				map.put("pws_lat", pws_lat);

			} else {

				map.put("pws_lat", 0);
			}
			// 业主名称
			String own_nam = request.getParameter("own_nam");

			map.put("own_nam", own_nam);
			// 备注/描述
			String rem = request.getParameter("rem");

			map.put("rem", rem);
			// 公司ID(组织ID)
			String com_id = request.getParameter("com_id");

			if (com_id != null && !com_id.isEmpty() && !com_id.equals("null")
					&& !com_id.equals("")) {

				map.put("com_id", com_id);

			} else {

				map.put("com_id", 0);
			}
			map.put("com_id", com_id);
			// 排序号
			String pws_sor = request.getParameter("pws_sor");

			if (pws_sor != null && !pws_sor.isEmpty()
					&& !pws_sor.equals("null") && !pws_sor.equals("")) {

				map.put("pws_sor", pws_sor);

			} else {

				map.put("pws_sor", 0);
			}

			// 电站编号
			String pws_num = request.getParameter("pws_num");

			map.put("pws_num", pws_num);
			// 额定电压
			String rat_vol = request.getParameter("rat_vol");

			if (rat_vol != null && !rat_vol.isEmpty()
					&& !rat_vol.equals("null") && !rat_vol.equals("")) {

				map.put("rat_vol", rat_vol);

			} else {

				map.put("rat_vol", 0);
			}

			// 额定电流
			String rat_cur = request.getParameter("rat_cur");

			if (rat_cur != null && !rat_cur.isEmpty()
					&& !rat_cur.equals("null") && !rat_cur.equals("")) {

				map.put("rat_cur", rat_cur);

			} else {

				map.put("rat_cur", 0);
			}
			// 额定功率
			String rat_pow = request.getParameter("rat_pow");

			if (rat_pow != null && !rat_pow.isEmpty()
					&& !rat_pow.equals("null") && !rat_pow.equals("")) {

				map.put("rat_pow", rat_pow);

			} else {

				map.put("rat_pow", 0);
			}

			map.put("crt_tim", new Date());
			// 创建人ID
			String crt_use_id = request.getParameter("use_id");

			if (crt_use_id != null && !crt_use_id.isEmpty()
					&& !crt_use_id.equals("null") && !crt_use_id.equals("")) {

				map.put("crt_use_id", crt_use_id);

			} else {

				map.put("crt_use_id", 0);
			}

			// 光伏容量(KW)
			String pv_rtd_pow = request.getParameter("pv_rtd_pow");

			if (pv_rtd_pow != null && !pv_rtd_pow.isEmpty()
					&& !pv_rtd_pow.equals("null") && !pv_rtd_pow.equals("")) {

				map.put("pv_rtd_pow", pv_rtd_pow);

			} else {

				map.put("pv_rtd_pow", 0);
			}
			// 储能额定功率(KW)
			String pc_rtd_pow = request.getParameter("pc_rtd_pow");

			if (pc_rtd_pow != null && !pc_rtd_pow.isEmpty()
					&& !pc_rtd_pow.equals("null") && !pc_rtd_pow.equals("")) {

				map.put("pc_rtd_pow", pc_rtd_pow);

			} else {

				map.put("pc_rtd_pow", 0);
			}
			// 储能容量(KWh)
			String pc_cap = request.getParameter("pc_cap");

			if (pc_cap != null && !pc_cap.isEmpty() && !pc_cap.equals("null")
					&& !pc_cap.equals("")) {

				map.put("pc_cap", pc_cap);

			} else {

				map.put("pc_cap", 0);
			}
			// 充电容量(KW)
			String chp_rtd_pow = request.getParameter("chp_rtd_pow");

			if (chp_rtd_pow != null && !chp_rtd_pow.isEmpty()
					&& !chp_rtd_pow.equals("null") && !chp_rtd_pow.equals("")) {

				map.put("chp_rtd_pow", chp_rtd_pow);

			} else {

				map.put("chp_rtd_pow", 0);
			}

			systemService.insertPwsInfo(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController insertEquInfo--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 修改电站详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updatePwsInfo")
	@ResponseBody
	public BaseTransferEntity updatePwsInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			Map<String, Object> map = new HashMap<String, Object>();

			// 站ID
			String pws_id = request.getParameter("pws_id");

			map.put("pws_id", pws_id);
			// 电站名称
			String pws_nam = request.getParameter("pws_nam");

			map.put("pws_nam", pws_nam);
			// 站类型
			String pws_typ = request.getParameter("pws_typ");

			if (pws_typ != null && !pws_typ.isEmpty()
					&& !pws_typ.equals("null") && !pws_typ.equals("")) {

				map.put("pws_typ", pws_typ);

			} else {

				map.put("pws_typ", 0);
			}
			// 运营类型（1为独立运维，2为统一运维）
			String ope_typ = request.getParameter("ope_typ");

			if (ope_typ != null && !ope_typ.isEmpty()
					&& !ope_typ.equals("null") && !ope_typ.equals("")) {

				map.put("ope_typ", ope_typ);

			} else {

				map.put("ope_typ", 0);
			}
			// 当前状态（1为计划，2为在建，3为投运）
			String cur_sta = request.getParameter("cur_sta");

			if (cur_sta != null && !cur_sta.isEmpty()
					&& !cur_sta.equals("null") && !cur_sta.equals("")) {

				map.put("cur_sta", cur_sta);

			} else {

				map.put("cur_sta", 0);
			}

			// 运维负责人
			String dev_add_num = request.getParameter("dev_add_num");

			map.put("dev_add_num", dev_add_num);
			// 省级ID
			String pro_id = request.getParameter("pro_id");

			if (pro_id != null && !pro_id.isEmpty() && !pro_id.equals("null")
					&& !pro_id.equals("")) {

				map.put("pro_id", pro_id);

			} else {

				map.put("pro_id", 0);
			}
			// 市级ID
			String cit_id = request.getParameter("cit_id");

			if (cit_id != null && !cit_id.isEmpty() && !cit_id.equals("null")
					&& !cit_id.equals("")) {

				map.put("cit_id", cit_id);

			} else {

				map.put("cit_id", 0);
			}
			// 区级ID
			String are_id = request.getParameter("are_id");

			if (are_id != null && !are_id.isEmpty() && !are_id.equals("null")
					&& !are_id.equals("")) {

				map.put("are_id", are_id);

			} else {

				map.put("are_id", 0);
			}
			// 联系人
			String con_nam = request.getParameter("con_nam");

			map.put("con_nam", con_nam);
			// 联系电话
			String con_mob = request.getParameter("con_mob");

			map.put("con_mob", con_mob);
			// 组织名称
			String org_nam = request.getParameter("org_nam");

			map.put("org_nam", org_nam);
			// 投运时间
			String ope_tim = request.getParameter("ope_tim");

			if (ope_tim != null && !ope_tim.isEmpty()
					&& !ope_tim.equals("null") && !ope_tim.equals("")) {

				map.put("ope_tim", ope_tim);

			} else {

				map.put("ope_tim", "1970-01-01 08:00:00");
			}
			// 占地面积
			String are_cov = request.getParameter("are_cov");

			if (are_cov != null && !are_cov.isEmpty()
					&& !are_cov.equals("null") && !are_cov.equals("")) {

				map.put("are_cov", are_cov);

			} else {

				map.put("are_cov", 0);
			}
			// 电站地址
			String pws_add = request.getParameter("pws_add");

			map.put("pws_add", pws_add);
			// 经度
			String pws_lon = request.getParameter("pws_lon");

			if (pws_lon != null && !pws_lon.isEmpty()
					&& !pws_lon.equals("null") && !pws_lon.equals("")) {

				map.put("pws_lon", pws_lon);

			} else {

				map.put("pws_lon", 0);
			}
			// 纬度
			String pws_lat = request.getParameter("pws_lat");

			if (pws_lat != null && !pws_lat.isEmpty()
					&& !pws_lat.equals("null") && !pws_lat.equals("")) {

				map.put("pws_lat", pws_lat);

			} else {

				map.put("pws_lat", 0);
			}
			// 业主名称
			String own_nam = request.getParameter("own_nam");

			map.put("own_nam", own_nam);
			// 备注/描述
			String rem = request.getParameter("rem");

			map.put("rem", rem);
			// 公司ID(组织ID)
			String com_id = request.getParameter("com_id");

			if (com_id != null && !com_id.isEmpty() && !com_id.equals("null")
					&& !com_id.equals("")) {

				map.put("com_id", com_id);

			} else {

				map.put("com_id", 0);
			}
			map.put("com_id", com_id);
			// 排序号
			String pws_sor = request.getParameter("pws_sor");

			if (pws_sor != null && !pws_sor.isEmpty()
					&& !pws_sor.equals("null") && !pws_sor.equals("")) {

				map.put("pws_sor", pws_sor);

			} else {

				map.put("pws_sor", 0);
			}

			// 电站编号
			String pws_num = request.getParameter("pws_num");

			map.put("pws_num", pws_num);
			// 额定电压
			String rat_vol = request.getParameter("rat_vol");

			if (rat_vol != null && !rat_vol.isEmpty()
					&& !rat_vol.equals("null") && !rat_vol.equals("")) {

				map.put("rat_vol", rat_vol);

			} else {

				map.put("rat_vol", 0);
			}

			// 额定电流
			String rat_cur = request.getParameter("rat_cur");

			if (rat_cur != null && !rat_cur.isEmpty()
					&& !rat_cur.equals("null") && !rat_cur.equals("")) {

				map.put("rat_cur", rat_cur);

			} else {

				map.put("rat_cur", 0);
			}
			// 额定功率
			String rat_pow = request.getParameter("rat_pow");

			if (rat_pow != null && !rat_pow.isEmpty()
					&& !rat_pow.equals("null") && !rat_pow.equals("")) {

				map.put("rat_pow", rat_pow);

			} else {

				map.put("rat_pow", 0);
			}

			map.put("mod_tim", new Date());
			// 创建人ID
			String mod_use_id = request.getParameter("use_id");

			if (mod_use_id != null && !mod_use_id.isEmpty()
					&& !mod_use_id.equals("null") && !mod_use_id.equals("")) {

				map.put("mod_use_id", mod_use_id);

			} else {

				map.put("mod_use_id", 0);
			}

			// 光伏容量(KW)
			String pv_rtd_pow = request.getParameter("pv_rtd_pow");

			if (pv_rtd_pow != null && !pv_rtd_pow.isEmpty()
					&& !pv_rtd_pow.equals("null") && !pv_rtd_pow.equals("")) {

				map.put("pv_rtd_pow", pv_rtd_pow);

			} else {

				map.put("pv_rtd_pow", 0);
			}
			// 储能额定功率(KW)
			String pc_rtd_pow = request.getParameter("pc_rtd_pow");

			if (pc_rtd_pow != null && !pc_rtd_pow.isEmpty()
					&& !pc_rtd_pow.equals("null") && !pc_rtd_pow.equals("")) {

				map.put("pc_rtd_pow", pc_rtd_pow);

			} else {

				map.put("pc_rtd_pow", 0);
			}
			// 储能容量(KWh)
			String pc_cap = request.getParameter("pc_cap");

			if (pc_cap != null && !pc_cap.isEmpty() && !pc_cap.equals("null")
					&& !pc_cap.equals("")) {

				map.put("pc_cap", pc_cap);

			} else {

				map.put("pc_cap", 0);
			}
			// 充电容量(KW)
			String chp_rtd_pow = request.getParameter("chp_rtd_pow");

			if (chp_rtd_pow != null && !chp_rtd_pow.isEmpty()
					&& !chp_rtd_pow.equals("null") && !chp_rtd_pow.equals("")) {

				map.put("chp_rtd_pow", chp_rtd_pow);

			} else {

				map.put("chp_rtd_pow", 0);
			}

			systemService.updatePwsInfo(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController updatePwsInfo--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 逻辑删除某电站详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delectPwsInfo")
	@ResponseBody
	public BaseTransferEntity delectPwsInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备ID
			String pws_id = request.getParameter("pws_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("pws_id", pws_id);

			systemService.delectPwsInfo(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"UserController delectPwsInfo--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/**
	 * 获取业主、合作伙伴信息列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getComRolOneAndTwo")
	@ResponseBody
	public BaseTransferEntity getComRolOneAndTwo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 获取公司角色 0代表自己公司 1代表业主公司 2代表合作伙伴
			String comRol = request.getParameter("comRol");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("comRol", comRol);

			List<Map<String, Object>> lst = systemService
					.getComRolOneAndTwo(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getComRolOneAndTwo--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/*
	 * --------------------------------------设备信息维护部分End--------------------------
	 * ------------
	 */

	/**
	 * 人员任务 转移 根据用户id 把该用户所有有关的任务转移给另一个人
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/moveTaskByUserId")
	@ResponseBody
	public BaseTransferEntity moveTaskByUserId(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 任务转移之前的用户id
			String before_user_id = request.getParameter("before_user_id");
			// 任务转移之后的用户id
			String after_user_id = request.getParameter("after_user_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("before_user_id", before_user_id);
			map.put("after_user_id", after_user_id);

			List<Map<String, Object>> lst = systemService.moveTaskByUserId(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getComRolOneAndTwo--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}

	/*
	 * --------------------------------------以下为建立用户与站点间的关系所属的接口------------------
	 * --------------------
	 */
	/**
	 * 获取系统内的一级公司/二级公司/三级公司下所属的站点与传入的用户ID所关联的站点的对比树
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUseAndPwsInfLst")
	@ResponseBody
	public BaseTransferEntity getUseAndPwsInfLst(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 用户ID
			String use_id = request.getParameter("use_id");
			// 用户ID
			String alt_use_id = request.getParameter("alt_use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("use_id", alt_use_id);

			List<Map<String, Object>> lst = systemService
					.getUseAndPwsInfLst(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getUseAndPwsInfLst--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 建立用户与电站之间的关系
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertUseAndPwsInf")
	@ResponseBody
	public BaseTransferEntity insertUserRoleByModule(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 操作此功能用户ID
			String use_id = request.getParameter("use_id");

			// 被执行该功能用户(变更与站之间关系的用户ID)
			String alt_use_id = request.getParameter("alt_use_id");
			// 站ID串（两个站ID间以“-”连接）
			String pws_ids = request.getParameter("pws_ids");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("use_id", alt_use_id);
			// 为了避免用户重复提交添加 通过用户id 删除此用户相关的电站信息 再执行添加操作
			systemService.deleteUseAndPwsInfByUseId(map);

			if (pws_ids != null && !pws_ids.isEmpty()) {

				String[] pwsIds = pws_ids.split("-");

				for (int i = 0; i < pwsIds.length; i++) {

					map.put("pws_id", pwsIds[i]);

					systemService.insertUseAndPwsInf(map);
				}
			}

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData("");

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

			log.info("成功的为用户ID为:" + alt_use_id + "的用户进行站点关联配置,站点ID串为:"
					+ pws_ids + ",操作者ID为：" + use_id);

		} catch (Exception e) {

			log.error(
					"SystemController insertUseAndPwsInf--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/********************** 接口补充 *********************/
	/**
	 * 使用ID获取获取厂家类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAllManTypById")
	@ResponseBody
	public BaseTransferEntity getAllManTypById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 用户ID
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			List<Map<String, Object>> lst = systemService.getAllManTypById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getUseAndPwsInfLst--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	@Value("${file.upload.path}")
	String filePath;

	/**
	 * 公司信息 添加图片 logo
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertComLogoImg", method = RequestMethod.POST)
	@ResponseBody
	public BaseTransferEntity insertComLogoImg(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("file") MultipartFile[] file) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 公司id
			String id = request.getParameter("id");
			// 公司项目名称
			String comPjtNam = request.getParameter("comPjtNam");

			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			map.put("comPjtNam", comPjtNam);
			
			int use_id = this.getCurrentUserId(request);
			
			map.put("use_id", use_id);
			
			map.put("mod_tim", new Date());

			// //通过公司di查询公司信息
			// List<Map<String,Object>> lstComLogo =
			// systemService.getComLogoImgById(map);
			// //判断缩略图地址是否为空
			// if(lstComLogo.get(0).get("com_pic_thum") != null &&
			// !lstComLogo.isEmpty()){
			//
			// baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
			// baseTransferEntity.setDesc("该公司已有Logo，");
			// baseTransferEntity.setData(lstComLogo);
			//
			// }else{
			//
			// }
			boolean hasFile = false;
			for (MultipartFile files : file) {
				if (files != null && !files.isEmpty()) {
					hasFile = true;
					break;
				}
			}
			if (!hasFile) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("没有选择上传的文件");
			}

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("文件上传项目成功");
			baseTransferEntity.setData(null);

			return systemService.uploadComImg(map, file, filePath);

		} catch (Exception e) {

			log.error(
					"SystemController insertComLogoImg--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 公司信息 添加图片 logo
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getComLogoImgById")
	@ResponseBody
	public BaseTransferEntity getComLogoImgById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 公司id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);

			// 通过公司di查询公司信息
			List<Map<String, Object>> lstComLogo = systemService
					.getComLogoImgById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lstComLogo);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController insertComLogoImg--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 电站 添加图片
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertPwsPic", method = RequestMethod.POST)
	@ResponseBody
	public BaseTransferEntity insertPwsPic(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("file") MultipartFile[] file) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 电站id
			String pws_id = request.getParameter("pws_id");
			// 用户id
			String user_id = request.getParameter("user_id");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("pws_id", pws_id);
			map.put("user_id", user_id);
			map.put("remark", remark);

			boolean hasFile = false;
			for (MultipartFile files : file) {
				if (files != null && !files.isEmpty()) {
					hasFile = true;
					break;
				}
			}
			if (!hasFile) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("没有选择上传的文件");
			}

			baseTransferEntity =systemService.uploadPwsPic(map, file, filePath);
			
			 if(StringUtil.equalsIgnoreCase(baseTransferEntity.getResultcode(),MobileConfig.getStringCode("msg.global.failed"))){
            	 
				 return baseTransferEntity;
				 
             }

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("文件上传项目成功");
			baseTransferEntity.setData(null);

		} catch (Exception e) {

			log.error(
					"SystemController insertComLogoImg--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 使用 设备编号 查询 设备名称
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getEquNameByEquNum")
	@ResponseBody
	public BaseTransferEntity getEquNameByEquNum(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备编号
			String equ_num = request.getParameter("equ_num");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("equ_num", equ_num);

			// 使用 设备编号 查询 设备名称
			List<Map<String, Object>> equNamLst = systemService
					.getEquNameByEquNum(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(equNamLst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController insertComLogoImg--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 使用 设备编号 查询 设备名称
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertMqtt")
	@ResponseBody
	public BaseTransferEntity insertMqtt(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// Mqtt登录名
			String mqtt_login_name = request.getParameter("mqtt_login_name");
			// Mqtt登录密码
			String mqtt_login_password = request
					.getParameter("mqtt_login_password");
			// Mqtt端口号
			String mqtt_port = request.getParameter("mqtt_port");
			// 客户端类型
			String client_type = request.getParameter("client_type");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("equ_num", equ_num);

			map.put("mqtt_login_name", mqtt_login_name);

			map.put("mqtt_login_password", mqtt_login_password);

			if (mqtt_port != null && !mqtt_port.isEmpty()
					&& !mqtt_port.equals("null") && !mqtt_port.equals("")) {

				map.put("mqtt_port", mqtt_port);

			} else {

				map.put("mqtt_port", 0);
			}

			map.put("client_type", client_type);

			systemService.insertMqtt(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("SystemController insertMqtt--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 修改Mqtt详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updateMqtt")
	@ResponseBody
	public BaseTransferEntity updateMqtt(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// Mqtt登录名
			String mqtt_login_name = request.getParameter("mqtt_login_name");
			// Mqtt登录密码
			String mqtt_login_password = request
					.getParameter("mqtt_login_password");
			// Mqtt端口号
			String mqtt_port = request.getParameter("mqtt_port");
			// 客户端类型
			String client_type = request.getParameter("client_type");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("equ_num", equ_num);

			map.put("mqtt_login_name", mqtt_login_name);

			map.put("mqtt_login_password", mqtt_login_password);

			map.put("mqtt_port", mqtt_port);

			map.put("client_type", client_type);

			systemService.updateMqtt(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("SystemController updateMqtt--------->" + e.getMessage(),
					e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 使用设备编号获取某Mqtt详细信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMqttInfByEquNum")
	@ResponseBody
	public BaseTransferEntity getMqttInfByEquNum(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 设备编号
			String equ_num = request.getParameter("equ_num");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("equ_num", equ_num);

			List<Map<String, Object>> lst = systemService
					.getMqttInfByEquNum(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("SystemController lst--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 获取所有电表类型列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterTypLstAll")
	@ResponseBody
	public BaseTransferEntity getMeterTypLstAll(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			List<Map<String, Object>> retLst = systemService
					.getMeterTypLstAll();

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(retLst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController getMeterTypLstAll--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 意见反馈 列表展示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selFeedBackAll")
	@ResponseBody
	public BaseTransferEntity selFeedBackAll(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			String sta_tim = request.getParameter("sta_tim");// 反馈 开始时间
			String end_tim = request.getParameter("end_tim");// 反馈 结束时间
			String words = request.getParameter("words");// 反馈人、反馈描述、回复人、回复描述
															// 模糊查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sta_tim", sta_tim);
			
			if(end_tim != null && !end_tim.isEmpty()){
				
				SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
				
				map.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));
			}
			map.put("words", words);
			map.put("currentPage", page.getCurrentPage());
			map.put("start", page.getStart());

			Map<String, Object> couMap = systemService.selFeedBackAllCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> retLst = systemService
					.selFeedBackAll(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(retLst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController selFeedBackAll--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	/**
	 * 意见反馈 列表展示(使用用户ID)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selFeedBackByUseId")
	@ResponseBody
	public BaseTransferEntity selFeedBackByUseId(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String sta_tim = request.getParameter("sta_tim");// 反馈 开始时间
			String end_tim = request.getParameter("end_tim");// 反馈 结束时间
			String words = request.getParameter("words");// 反馈人、反馈描述、回复人、回复描述
			String use_id = request.getParameter("use_id");// 反馈人、反馈描述、回复人、回复描述
			// 模糊查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sta_tim", sta_tim);
			
			if(end_tim != null && !end_tim.isEmpty()){
				
				SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
				
				map.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));
			}
			map.put("words", words);
			map.put("use_id", use_id);
			
			List<Map<String, Object>> retLst = systemService
					.selFeedBackByUseId(map);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(retLst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error(
					"SystemController selFeedBackByUseId--------->"
							+ e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * 意见反馈 新增
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertFeedBack")
	@ResponseBody
	public BaseTransferEntity insertFeedBack(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String feedback_use_id = request.getParameter("userId");// 反馈人id
			String feedback_desc = request.getParameter("feedBack");// 意见反馈描述
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("feedback_use_id", feedback_use_id);
			map.put("feedback_desc", feedback_desc);
			map.put("feedback_tim", new Date());

			systemService.insertFeedBack(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController selFeedBackAll--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 意见反馈 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delFeedBackById")
	@ResponseBody
	public BaseTransferEntity delFeedBackById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String id = request.getParameter("id");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);

			systemService.delFeedBackById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController delFeedBackById--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 意见反馈 回复
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updReplyById")
	@ResponseBody
	public BaseTransferEntity updReplyById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {

			String id = request.getParameter("id"); // 反馈id
			String reply_use_id = request.getParameter("replyUse"); // 回复人
			String reply_desc = request.getParameter("replyDesc"); // 回复描述
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("reply_use_id", reply_use_id);
			map.put("reply_desc", reply_desc);
			map.put("reply_tim", new Date());
			map.put("id", id);

			systemService.updReplyById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));

			baseTransferEntity.setData(null);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error(
					"SystemController delFeedBackById--------->"
							+ e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	
	/**
	 * 用户头像添加
	 */
	@RequestMapping(value = "/service/uploadUserImg", method = RequestMethod.POST)
	@ResponseBody
	public BaseTransferEntity uploadUserImg(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("files") MultipartFile[] files) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 
			String id = request.getParameter("id");
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			
			boolean hasFile = false;
			for (MultipartFile file : files) {
				if (file != null && !file.isEmpty()) {
					hasFile = true;
					break;
				}
			}
			if (!hasFile) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("没有选择上传的文件");
			}

			return systemService.uploadUserImg(map, files, filePath);

		} catch (Exception e) {
			log.error(
					"TourController delOverhaulPlan--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}
	
}