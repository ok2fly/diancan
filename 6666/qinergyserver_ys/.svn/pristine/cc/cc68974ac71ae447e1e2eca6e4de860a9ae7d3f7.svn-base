package com.qinergy.controller.others;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.qinergy.base.BaseController;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.Pager;
import com.qinergy.service.dailyoffice.DailyOfficeService;
import com.qinergy.service.others.OthersService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.EhcacheUtil;
import com.qinergy.util.MobileConfig;

/**
 * 其它共用或未分类对前端页面接口类
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
public class OthersController extends BaseController {
	// 声明
    private static Logger log = Logger.getLogger(OthersController.class);

    @Autowired
    private OthersService othersService;
    @Autowired
    private DailyOfficeService dailyOfficeService;

    @Autowired
    private EhcacheUtil ehcacheUtil;

	/**
	 * 获取考核管理页面中所有的数据信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsAssMagInfByPwsId")
	@ResponseBody
	public BaseTransferEntity getPwsAssMagInfByPwsId(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 指定时间段
			String date = request.getParameter("date");
			// 电站ID
			String pws_id = request.getParameter("pws_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("date", date);
			
			map.put("pws_id", pws_id);
			
			List<Map<String, Object>> lst = othersService.getPwsAssMagInfByPwsId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getPwsAssMagInfByPwsId--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	/**
	 * 获取综合监控中设备运维信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getIntEquOpeInf")
	@ResponseBody
	public BaseTransferEntity getIntEquOpeInf(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getIntEquOpeInf(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	
	/**
	 * 获取历史告警记录(分页)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAlaHistoryLst")
	@ResponseBody
	public BaseTransferEntity getAlaHistoryLst(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// 告警信息
			String fau_inf = request.getParameter("fau_inf");
			// 查询中开始时间条件
			String sta_tim = request.getParameter("sta_tim");
			// 查询中结束时间条件
			String end_tim = request.getParameter("end_tim");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("equ_num", equ_num);
			
			map.put("fau_inf", fau_inf);

			map.put("sta_tim", sta_tim);

			map.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));

			Map<String, Object> couMap = othersService.getAlaHistoryLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = othersService.getAlaHistoryLst(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));

			baseTransferEntity.setData(lst);

			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {

			log.error("OthersController getAlaHistoryLst--------->" + e.getMessage(), e);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));

			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");

			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取设备维修记录(分页)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMaintenanceLst")
	@ResponseBody
	public BaseTransferEntity getMaintenanceLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// 报修原因
			String repair_reason = request.getParameter("repair_reason");
			// 查询中开始时间条件
			String sta_tim = request.getParameter("sta_tim");
			// 查询中结束时间条件
			String end_tim = request.getParameter("end_tim");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("equ_num", equ_num);
			
			map.put("repair_reason", repair_reason);
			
			map.put("sta_tim", sta_tim);
			
			map.put("end_tim", end_tim);
			
			Map<String, Object> couMap = othersService.getMaintenanceLstCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = othersService.getMaintenanceLst(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getMaintenanceLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取设备检修（保养）记录(分页)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getOverhaulLst")
	@ResponseBody
	public BaseTransferEntity getOverhaulLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// 检修内容
			String ove_inf = request.getParameter("ove_inf");
			// 查询中开始时间条件
			String sta_tim = request.getParameter("sta_tim");
			// 查询中结束时间条件
			String end_tim = request.getParameter("end_tim");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("equ_num", equ_num);
			
			map.put("ove_inf", ove_inf);
			
			map.put("sta_tim", sta_tim);
			
			map.put("end_tim", end_tim);
			
			Map<String, Object> couMap = othersService.getOverhaulLstCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = othersService.getOverhaulLst(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getOverhaulLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 使用用户ID获取通知信息列表 
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getNoticeInfByUseId")
	@ResponseBody
	public BaseTransferEntity getNoticeInfByUseId(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 用户ID
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			map.put("id", use_id);
			
			List<Map<String, Object>> useLst = dailyOfficeService.getUserInfById(map);
			
			String is_def_sta = useLst.get(0).get("is_def_sta").toString();
			
			List<Map<String, Object>> lst = new ArrayList<Map<String,Object>>();
			
			if(is_def_sta != null && !is_def_sta.isEmpty() && !is_def_sta.equals("2")){
				
				lst = othersService.getNoticeInfByUseId(map);
			}
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getNoticeInfByUseId--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 使用用户ID获取系统通知信息列表 
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getSysNoticeInfByUseId")
	@ResponseBody
	public BaseTransferEntity getSysNoticeInfByUseId(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 用户ID
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			List<Map<String, Object>> lst = othersService.getSysNoticeInfByUseId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getSysNoticeInfByUseId--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 更新阅读状态（是否已阅读）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updNoticeState")
	@ResponseBody
	public BaseTransferEntity updNoticeState(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 消息ID
			String fau_id = request.getParameter("fau_id");
			
			int use_id = this.getCurrentUserId(request);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("fau_id", fau_id);
			map.put("use_id", use_id);
			
			othersService.updNoticeState(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController updNoticeState--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	/**
	 * 更新阅读状态（是否已阅读）(App)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updNoticeStateApp")
	@ResponseBody
	public BaseTransferEntity updNoticeStateApp(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 消息ID
			String fau_id = request.getParameter("fau_id");
			
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("fau_id", fau_id);
			map.put("use_id", use_id);
			
			othersService.updNoticeState(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController updNoticeState--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	/**
	 * 更新阅读状态（是否已阅读）（系统通知）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updSysNoticeState")
	@ResponseBody
	public BaseTransferEntity updSysNoticeState(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 消息ID
			String not_id = request.getParameter("not_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("not_id", not_id);
			// 阅读时间
			map.put("reve_tim", new Date());
			
			int sta = othersService.updSysNoticeState(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController updSysNoticeState--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/*-------------------------------------以下为与公告有关的所有接口-------------------------------------*/
	
	/**
	 * 添加公告信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insAnnInf")
	@ResponseBody
	public BaseTransferEntity insAnnInf(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 公告内容
			String ann_cont = request.getParameter("ann_cont");
			// 公告状态
			String ann_typ = request.getParameter("ann_typ");
			// 公告排序号
			String ann_sort = request.getParameter("ann_sort");
			// 公告备注
			String remark = request.getParameter("remark");
			// 用户ID
			String crt_use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("ann_cont", ann_cont);
			
			map.put("ann_typ", ann_typ);
			
			map.put("ann_sort", ann_sort);
			
			map.put("remark", remark);
			
			map.put("crt_use_id", crt_use_id);
			// 创建时间
			map.put("crt_tim", new Date());
			
			othersService.insAnnInf(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController insAnnInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 修改公告信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updAnnInf")
	@ResponseBody
	public BaseTransferEntity updAnnInf(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 公告ID
			String ann_id = request.getParameter("ann_id");
			// 公告内容
			String ann_cont = request.getParameter("ann_cont");
			// 公告状态
			String ann_typ = request.getParameter("ann_typ");
			// 公告排序号
			String ann_sort = request.getParameter("ann_sort");
			// 公告备注
			String remark = request.getParameter("remark");
			// 用户ID
			String mod_use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("ann_id", ann_id);
			
			map.put("ann_cont", ann_cont);
			
			map.put("ann_typ", ann_typ);
			
			map.put("ann_sort", ann_sort);
			
			map.put("remark", remark);
			
			map.put("mod_use_id", mod_use_id);
			// 创建时间
			map.put("mod_tim", new Date());
			
			othersService.updAnnInf(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController updAnnInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 删除公告信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delAnnInf")
	@ResponseBody
	public BaseTransferEntity delAnnInf(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 公告ID
			String ann_id = request.getParameter("ann_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("ann_id", ann_id);
			
			othersService.delAnnInf(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController delAnnInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 使用公告ID获取公告信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAnnInfById")
	@ResponseBody
	public BaseTransferEntity getAnnInfById(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 公告ID
			String ann_id = request.getParameter("ann_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("ann_id", ann_id);
			
			List<Map<String, Object>> lst = othersService.getAnnInfById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getAnnInfById--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取公告信息列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAnnInfLst")
	@ResponseBody
	public BaseTransferEntity getAnnInfLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 公告内容（模糊 ）
			String ann_cont = request.getParameter("ann_cont");
			// 公告状态（1为播出，2为不播出）
			String ann_typ = request.getParameter("ann_typ");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("ann_cont", ann_cont);
			
			map.put("ann_typ", ann_typ);
			
			Map<String, Object> couMap = othersService.getAnnInfLstCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = othersService.getAnnInfLst(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getAnnInfLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取首页中运维信息数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getFstPagOptInf")
	@ResponseBody
	public BaseTransferEntity getFstPagOptInf(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 用户ID
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			Map<String, Object> couMap = othersService.getFstPagOptInf(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(couMap);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getFstPagOptInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	

	/*-------------------------------------以下为与计划充放电量有关的所有接口-------------------------------------*/
	
	/**
	 * 添加计划充放电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insPlanPhiPhe")
	@ResponseBody
	public BaseTransferEntity insPlanPhiPhe(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 电站ID(通过一、二、三级公司查出来的电站ID)
			String pws_id = request.getParameter("pws_id");
			// 计划充电量
			String plan_phi = request.getParameter("plan_phi");
			// 计划放电量
			String plan_phe = request.getParameter("plan_phe");
			// 计划时间
			String plan_tim = request.getParameter("plan_tim");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			map.put("plan_phi", plan_phi);
			
			map.put("plan_phe", plan_phe);
			
			map.put("plan_tim", plan_tim);
			
			// 创建时间
			map.put("crt_tim", new Date());
			
			othersService.insPlanPhiPhe(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController insPlanPhiPhe--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 修改计划充放电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updPlanPhiPhe")
	@ResponseBody
	public BaseTransferEntity updPlanPhiPhe(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 计划充放电量ID
			String ppp_id = request.getParameter("ppp_id");
			// 电站ID(通过一、二、三级公司查出来的电站ID)
			String pws_id = request.getParameter("pws_id");
			// 计划充电量
			String plan_phi = request.getParameter("plan_phi");
			// 计划放电量
			String plan_phe = request.getParameter("plan_phe");
			// 计划时间
			String plan_tim = request.getParameter("plan_tim");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("ppp_id", ppp_id);
			
			map.put("pws_id", pws_id);
			
			map.put("plan_phi", plan_phi);
			
			map.put("plan_phe", plan_phe);
			
			map.put("plan_tim", plan_tim);
			
			othersService.updPlanPhiPhe(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController updPlanPhiPhe--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 删除计划充放电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delPlanPhiPheInf")
	@ResponseBody
	public BaseTransferEntity delPlanPhiPheInf(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 计划充放电量ID
			String ppp_id = request.getParameter("ppp_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("ppp_id", ppp_id);
			
			othersService.delPlanPhiPheInf(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController delPlanPhiPheInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 使用计划充放电量ID获取计划充放电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPlanPhiPheInfById")
	@ResponseBody
	public BaseTransferEntity getPlanPhiPheInfById(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 计划充放电量ID
			String ppp_id = request.getParameter("ppp_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("ppp_id", ppp_id);
			
			List<Map<String, Object>> lst = othersService.getPlanPhiPheInfById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getPlanPhiPheInfById--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取充放电量计划列表信息(分页)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPlanPhiPheLst")
	@ResponseBody
	public BaseTransferEntity getPlanPhiPheLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 电站ID(通过一、二、三级公司查出来的电站ID)
			String pws_id = request.getParameter("pws_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("pws_id", pws_id);
			
			Map<String, Object> couMap = othersService.getPlanPhiPheLstCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = othersService.getPlanPhiPheLst(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getPlanPhiPheLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/*-------------------------------------以下为与理论发电量有关的所有接口-------------------------------------*/
	/**
	 * 添加理论发电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insFsbPower")
	@ResponseBody
	public BaseTransferEntity insFsbPower(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 电站ID(通过一、二、三级公司查出来的电站ID)
			String pws_id = request.getParameter("pws_id");
			// 理论发电量
			String fsb_power = request.getParameter("fsb_power");
			// 理论发电量收益
			String fsb_amo = request.getParameter("fsb_amo");
			// 理论时间
			String fsb_tim = request.getParameter("fsb_tim");
			// 创建人ID
			String crt_use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			map.put("fsb_power", fsb_power);
			
			map.put("fsb_amo", fsb_amo);
			
			map.put("fsb_tim", fsb_tim);
			
			// 创建时间
			map.put("crt_tim", new Date());
			
			map.put("crt_use_id", crt_use_id);
			
			othersService.insFsbPower(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController insFsbPower--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 修改理论发电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updFsbPower")
	@ResponseBody
	public BaseTransferEntity updFsbPower(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 理论发电量ID
			String pfp_id = request.getParameter("pfp_id");
			// 电站ID(通过一、二、三级公司查出来的电站ID)
			String pws_id = request.getParameter("pws_id");
			// 理论发电量
			String fsb_power = request.getParameter("fsb_power");
			// 理论发电量收益
			String fsb_amo = request.getParameter("fsb_amo");
			// 理论时间
			String fsb_tim = request.getParameter("fsb_tim");
			// 修改人ID
			String mod_use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pfp_id", pfp_id);
			
			map.put("pws_id", pws_id);
			
			map.put("fsb_power", fsb_power);
			
			map.put("fsb_amo", fsb_amo);
			
			map.put("fsb_tim", fsb_tim);
			
			// 创建时间
			map.put("mod_tim", new Date());
			
			map.put("mod_use_id", mod_use_id);
			
			othersService.updFsbPower(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController updFsbPower--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 删除理论发电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delFsbPowerInf")
	@ResponseBody
	public BaseTransferEntity delFsbPowerInf(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 理论发电量ID
			String pfp_id = request.getParameter("pfp_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pfp_id", pfp_id);
			
			othersService.delFsbPowerInf(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController delFsbPowerInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 使用理论发电量ID获取理论发电量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getFsbPowerInfById")
	@ResponseBody
	public BaseTransferEntity getFsbPowerInfById(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 理论发电量ID
			String pfp_id = request.getParameter("pfp_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pfp_id", pfp_id);
			
			List<Map<String, Object>> lst = othersService.getFsbPowerInfById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getFsbPowerInfById--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取理论发电量列表信息(分页)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getFsbPowerLst")
	@ResponseBody
	public BaseTransferEntity getFsbPowerLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 电站ID(通过一、二、三级公司查出来的电站ID)
			String pws_id = request.getParameter("pws_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("pws_id", pws_id);
			
			Map<String, Object> couMap = othersService.getFsbPowerLstCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = othersService.getFsbPowerLst(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getFsbPowerLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/*-------------------------------------以下为与理论辐射量有关的所有接口-------------------------------------*/
	/**
	 * 添加理论辐射量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insFsbHv")
	@ResponseBody
	public BaseTransferEntity insFsbHv(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 电站ID(通过一、二、三级公司查出来的电站ID)
			String pws_id = request.getParameter("pws_id");
			// 理论辐射量
			String fsb_hv = request.getParameter("fsb_hv");
			// 月份
			String month = request.getParameter("month");
			// 创建人ID
			String crt_use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			map.put("fsb_hv", fsb_hv);
			
			map.put("month", month);
			
			// 创建时间
			map.put("crt_tim", new Date());
			
			map.put("crt_use_id", crt_use_id);
			
			othersService.insFsbHv(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController insFsbHv--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 修改理论辐射量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updFsbHv")
	@ResponseBody
	public BaseTransferEntity updFsbHv(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 理论辐射量ID
			String pfh_id = request.getParameter("pfh_id");
			// 电站ID(通过一、二、三级公司查出来的电站ID)
			String pws_id = request.getParameter("pws_id");
			// 理论辐射量
			String fsb_hv = request.getParameter("fsb_hv");
			// 月份
			String month = request.getParameter("month");
			// 修改人ID
			String mod_use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pfh_id", pfh_id);
			
			map.put("pws_id", pws_id);
			
			map.put("fsb_hv", fsb_hv);
			
			map.put("month", month);
			
			// 创建时间
			map.put("mod_tim", new Date());
			
			map.put("mod_use_id", mod_use_id);
			
			othersService.updFsbHv(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController updFsbHv--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 删除理论辐射量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delFsbHvInf")
	@ResponseBody
	public BaseTransferEntity delFsbHvInf(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 理论辐射量ID
			String pfh_id = request.getParameter("pfh_id");
			   
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pfh_id", pfh_id);
			
			othersService.delFsbHvInf(map);
			 
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController delFsbHvInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 使用理论辐射量ID获取理论辐射量信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getFsbHvInfById")
	@ResponseBody
	public BaseTransferEntity getFsbHvInfById(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 理论辐射量ID
			String pfh_id = request.getParameter("pfh_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pfh_id", pfh_id);
			
			List<Map<String, Object>> lst = othersService.getFsbHvInfById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getFsbHvInfById--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取理论辐射量列表信息(分页)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getFsbHvLst")
	@ResponseBody
	public BaseTransferEntity getFsbHvLst(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			Pager page = new Pager();
			
			String currentPage = request.getParameter("currentPage");
			
			if (currentPage != null && !currentPage.isEmpty()) {
				
				page.setCurrentPage(Integer.parseInt(currentPage));
				
			}
			// 电站ID(通过一、二、三级公司查出来的电站ID)
			String pws_id = request.getParameter("pws_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("currentPage", page.getCurrentPage());
			
			map.put("start", page.getStart());
			
			map.put("pws_id", pws_id);
			
			Map<String, Object> couMap = othersService.getFsbHvLstCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = othersService.getFsbHvLst(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getFsbHvLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	

	
	

	/**
	 * 电量计划    光伏计划发电量表    列表显示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selPvPlanPower")
	@ResponseBody
	public BaseTransferEntity selPvPlanPower(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		
		try {
			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			
			String sbpId = request.getParameter("sbpId");
			
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("sbpId", sbpId);

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());
			
			Map<String, Object> couMap = othersService.selPvPlanPowerCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());
			
			lst = othersService.selPvPlanPower(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
	
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController delTourPlan--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}
	
	
	
	/**
	 * 电量计划    光伏计划发电量表    列表显示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insOrUpdPvPlanPower")
	@ResponseBody
	public BaseTransferEntity insOrUpdPvPlanPower(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		
		try {
			
			
			String id = request.getParameter("id");
			//电站ID
			String pws_id = request.getParameter("pws_id");
			//plan_power
			String plan_power = request.getParameter("plan_power");
			//计划时间（每月一条数据）
			String plan_tim = request.getParameter("plan_tim");
			//String crt_tim = request.getParameter("crt_tim");
			//创建人员ID
			String crt_use_id = request.getParameter("crt_use_id");
			//String mod_tim = request.getParameter("mod_tim");
			//修改人员ID
			String mod_use_id = request.getParameter("mod_use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			map.put("pws_id", pws_id);
			map.put("plan_power", plan_power);
			map.put("plan_tim", plan_tim);
			//map.put("crt_tim", crt_tim);
			map.put("crt_use_id", crt_use_id);
			//map.put("mod_tim", mod_tim);
			map.put("mod_use_id", mod_use_id);
			
			othersService.insOrUpdPvPlanPower(map);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(null);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController delTourPlan--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}
	
	
	
	

	/**
	 * 电量计划    光伏计划发电量表    数据回显
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selPvPlanPowerById")
	@ResponseBody
	public BaseTransferEntity selPvPlanPowerById(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		
		try {
			
			
			String id = request.getParameter("id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			
			lst = othersService.selPvPlanPowerById(map);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController delTourPlan--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}
	

	/**
	 * 电量计划 光伏计划发电量表 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delPvPlanPowerById")
	@ResponseBody
	public BaseTransferEntity delPvPlanPowerById(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		
		try {
			
			
			String id = request.getParameter("id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			
			othersService.delPvPlanPowerById(map);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(null);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController delTourPlan--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}
	
	
	/**
	 * 获取告警信息列表与实时告警信息的对照关系列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getRelFauLst")
	@ResponseBody
	public BaseTransferEntity getRelFauLst(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getRelFauLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OtherController getRelFauLst--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * 获取告警信息列表与实时告警信息的对照关系列表(App)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getRelFauLstApp")
	@ResponseBody
	public BaseTransferEntity getRelFauLstApp(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getRelFauLstApp(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OtherController getRelFauLstApp--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 获取设备健康评分曲线
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getEquHealthCurve")
	@ResponseBody
	public BaseTransferEntity getEquHealthCurve(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getEquHealthCurve(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OtherController getEquHealthCurve--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 获取首页设备健康状态以及设备健康率
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getEquHealthScor")
	@ResponseBody
	public BaseTransferEntity getEquHealthScor(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 用户ID(登录的用户ID)
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			List<Map<String, Object>> lst = othersService.getEquHealthScor(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OtherController getEquHealthScor--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 获取大屏右侧电站效率以及消缺率图表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPwsEffRidRateLst")
	@ResponseBody
	public BaseTransferEntity getPwsEffRidRateLst(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 用户ID(登录的用户ID)
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			List<Map<String, Object>> lst = othersService.getRidNumFauNumAscRateInf(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OtherController getPwsEffRidRateLst--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 获取合作伙伴数量与运维人员数量
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getOptComCouAndOptUseCouLst")
	@ResponseBody
	public BaseTransferEntity getOptComCouAndOptUseCouLst(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			List<Map<String, Object>> lst = othersService.getOptComCouAndOptUseCouLst();
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OtherController getOptComCouAndOptUseCouLst--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	
	
	/*-------------------------------------以下为综合监控 显示所有设备详情  接口  -------------------------------------*/
		
	
	/**
	 * 交流充电桩-详情,待机数据 （获取最新那条数据)
	 * 交流充电桩-详情,充电中实时数据 （获取最新那条数据）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getIscsAcchpStdAndRelByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getIscsAcchpStdAndRelByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			Map<String, Object> lst = othersService.getIscsAcchpStdAndRelByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取 交流配电柜  设备的最新实时数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getAcdbInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getAcdbInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			 List<Map<String, Object>> lst = othersService.getAcdbInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 查询储能电池  最新实时数据  根据编号
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBmsInfoByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getBmsInfoByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getBmsInfoByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	/**
	 * 汇流箱-详情 （获取最新那条数据，包含支路电流数据）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getIscsBoxInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getIscsBoxInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getIscsBoxInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	/**
	 * 控制器-详情 （获取最新那条数据，包含支路电流数据）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getCtlInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getCtlInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getCtlInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 直流充电桩-详情,待机数据 （获取最新那条数据）
	 * 直流充电桩-详情,实时数据 （获取最新那条数据）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getIscsDcchpStdAndRelByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getIscsDcchpStdAndRelByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			Map<String, Object> lst = othersService.getIscsDcchpStdAndRelByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	/**
	 * 获取 直流配电柜  设备的最新实时数据）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDcdbInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getDcdbInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getDcdbInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取  获取 解列装置   设备的最新实时数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDctdevInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getDctdevInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getDctdevInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取  第二类大屏第一屏数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBigScreenOne")
	@ResponseBody
	public BaseTransferEntity getBigScreenOne(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 用户ID
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			// 获取 第二类大屏第一屏数据
			List<Map<String, Object>> lst = othersService.getBigScreenOne(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getBigScreenOne--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取  第二类大屏第一屏数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBigSceensInf2")
	@ResponseBody
	public BaseTransferEntity getBigSceensInf2(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 用户ID
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("use_id", use_id);
			
			List<Map<String, Object>> lst = othersService.getBigSceensInf2(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("OthersController getBigSceensInf2--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取 环境检测仪   设备的最新实时数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getEnvInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getEnvInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getEnvInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取 线路保护   设备的最新实时数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getLnepttInfByEquNum")
	@ResponseBody
	public BaseTransferEntity getLnepttInfByEquNum(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getLnepttInfByEquNum(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	
	
	/**
	 * 获取  储能逆变器   设备的最新实时数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPcsInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getPcsInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getPcsInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取 变压器   设备的最新实时数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getIscsTranfRelInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getIscsTranfRelInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getIscsTranfRelInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getIscsTranfRelInfByEquNumNew--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	
	/**
	 * 获取   电能质量监测    设备的最新实时数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPqsmsInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getPqsmsInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getPqsmsInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	
	/**
	 * 获取   光伏逆变器   设备的最新实时数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPvsInfByEquNumNew")
	@ResponseBody
	public BaseTransferEntity getPvsInfByEquNumNew(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = othersService.getPvsInfByEquNumNew(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	/**
	 * 更新用户  站查看状态
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updUserSltOptStaByUserId")
	@ResponseBody
	public BaseTransferEntity updUserSltOptStaByUserId(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			//用户id
			String id = request.getParameter("id");
			//1：可查看（如果为运维公司时，可查看子公司人员和站信息，如果为业主公司，可查看与该公司站关联的所有运维人员），
			//2：不可查看（如果为运维公司，只能查看自己公司的人与站以及与自己有关的站的信息，如果为业主公司时，只能查看与自己有关的所有站的信息，不能查看运维人员信息）），用户新建时，默认可见',
			String sltOptSta = request.getParameter("sltOptSta");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			map.put("sltOptSta", sltOptSta);
			
			othersService.updUserSltOptStaByUserId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
	
	/**
	 * 更新用户  站查看状态
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updUserIsDefStaByUserId")
	@ResponseBody
	public BaseTransferEntity updUserIsDefStaByUserId(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			//用户id
			String id = request.getParameter("id");
			//用户对告警信息是否可见，默认为1（可见）
			//为2时，所有告警信息均不获取',
			String isDefSta = request.getParameter("isDefSta");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			map.put("isDefSta", isDefSta);
			
			othersService.updUserIsDefStaByUserId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(null);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getIntEquOpeInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	/**
	 * 获取安卓最新版本
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getNewAppVarsion")
	@ResponseBody
	public BaseTransferEntity getNewAppVarsion(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
						
			List<Map<String, Object>> lst = othersService.getNewAppVarsion();
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("StatisticAnalysisController getNewAppVarsion--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	}
	
	
}
