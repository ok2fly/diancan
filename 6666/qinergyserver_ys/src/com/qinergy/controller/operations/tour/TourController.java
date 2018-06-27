package com.qinergy.controller.operations.tour;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






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
import com.qinergy.service.operations.tour.TourService;
import com.qinergy.service.operations.tour.OverhaulTask;
import com.qinergy.service.operations.tour.TourTask;
import com.qinergy.service.statisticanalysis.pwssta.PwsStaService;
import com.qinergy.service.system.SystemService;
import com.qinergy.service.utils.UtilsService;
import com.qinergy.util.MobileConfig;

/**
 * 运维 巡视及管理功能
 * 
 * @author zy
 * 
 * 
 */

@Controller
@RequestMapping(value = "")
public class TourController extends BaseController {

	// 声明
	private static Logger log = Logger.getLogger(TourController.class);

	@Autowired
	private TourService tourService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private PwsStaService pwsStaService;
	
	@Autowired
	private UtilsService utilsService;
	
	// 巡视集合
	public static Map<String,Object> tourTimerMap = new HashMap<String, Object>();
	// 检修集合
	public static Map<String,Object> overhaulTimerMap = new HashMap<String, Object>();

	// ****************************************巡视、检修路线**************************************************************************************

	/**
	 * 查看巡视路线 (查询所有检修路线)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getTourOrOverHaul")
	@ResponseBody
	public BaseTransferEntity getTourRouteNam(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			
			Map<String, Object> map = new HashMap<String, Object>();

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));
				
				map.put("currentPage", page.getCurrentPage());
				map.put("start", page.getStart());
				map.put("everyPage", page.getEveryPage());

			}

			// 类型
			String type = request.getParameter("type");
			// 路线名字
			String name = request.getParameter("route_name");

			String sta_tim = request.getParameter("sta_tim");

			String end_tim = request.getParameter("end_tim");
			
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 
			if (end_tim != null && !end_tim.isEmpty()) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(sdf.parse(end_tim));
				calendar.add(calendar.DATE, 1);
				end_tim = sdf.format(calendar.getTime());

			}
			
			
			map.put("type", type);
			map.put("name", name);
			map.put("sta_tim", sta_tim);
			map.put("end_tim", end_tim);

			
			// 检修
			if ("1".equals(type)) {

				Map<String, Object> couMap = tourService.selOverhaulRouteNameCou(map);

				page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
				// 巡视
			} else {

				Map<String, Object> couMap = tourService.selTourRouteNameCou(map);

				page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			}


			lst = tourService.selTourOrOverhaulByName(map);

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
					"TourController getTourOrOverHaul--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 添加巡视路线 (添加所有巡视路线) 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertRouteOrOverhaul")
	@ResponseBody
	public BaseTransferEntity insertRouteOrOverhaul(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 类型 type为1的时候是检修路线 2的时候是巡视路线
			String type = request.getParameter("type");

			String use_id = request.getParameter("use_id");

			String route_name = request.getParameter("route_name");

			String pws_id = request.getParameter("pws_id");
			
			String sort = request.getParameter("sort");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", type);
			map.put("use_id", use_id);
			map.put("route_name", route_name);
			map.put("pws_id", pws_id);
			map.put("crate_time", new Date());
			map.put("sort", sort);

			if ("1".equals(type)) {
				
				Map<String,Object> nameMap = new HashMap<String, Object>();
				
				nameMap.put("route_name", route_name);
				//根据路线名称查询路线是否重复
				List<Map<String, Object>> lstName = tourService.selOverhaulRoteByName(nameMap);
				
				if (lstName != null && !lstName.isEmpty()) {
					
					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
					
					baseTransferEntity.setDesc("检修路线名称重复，请重新填写！");
					
					return baseTransferEntity;
				}
				// 检修
				tourService.InsertOverhaulRouteName(map);
				
			} else if ("2".equals(type)) {
				
				Map<String,Object> nameMap = new HashMap<String, Object>();
				
				nameMap.put("route_name", route_name);
				//根据路线名称查询路线是否重复
				List<Map<String, Object>> lstName = tourService.selTourRoteByName(nameMap);
				
				if (lstName != null && !lstName.isEmpty()) {
					
					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
					
					baseTransferEntity.setDesc("巡视路线名称重复，请重新填写！");
					
					return baseTransferEntity;
				}
				
				// 巡视
				tourService.InsertRouteName(map);

			}
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController insertRouteOrOverhaul--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 删除路线 ( 删除路线)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delRouteOrOverhaul")
	@ResponseBody
	public BaseTransferEntity delRouteOrOverhaul(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 类型 type为1的时候是检修路线 2的时候是巡视路线
			String type = request.getParameter("type");
			// id
			String id = request.getParameter("id");
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("type", type);
			map.put("id", id);

			lst = tourService.delRouteOrOverhaul(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController delRouteOrOverhaul--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 根据路线id查询 检修 路线的电站经纬度 根据路线id查询 巡视 路线的电站经纬度
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selRouteOrOverhaulNamePwsByRouteNameId")
	@ResponseBody
	public BaseTransferEntity selRouteOrOverhaulNamePwsByRouteNameId(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 类型
			String type = request.getParameter("type");
			// route_name_id
			String route_name_id = request.getParameter("route_name_id");
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("type", type);
			map.put("route_name_id", route_name_id);

			lst = tourService.selRouteOrOverhaulNamePwsByRouteNameId(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selRouteOrOverhaulNamePwsByRouteNameId--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	// *******************巡视管理*****************************************************

	/**
	 * 
	 * 查看巡视任务
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selRouteTask")
	@ResponseBody
	public BaseTransferEntity selRouteTask(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 类型 0全部 1我执行的 2 我发布的 3我审核的
			String type = request.getParameter("type");

			// user_id 用户id
			String user_id = request.getParameter("user_id");

			// task_sta 任务状态（2未开始 3进行中 4完成待审核 5审核通过 6审核驳回）
			String task_sta = request.getParameter("task_sta");

			// task_typ 创建状态（1：自动创建，2：手动创建）
			String task_typ = request.getParameter("task_typ");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("user_id", user_id);
			map.put("type", type);
			map.put("task_sta", task_sta);
			map.put("task_typ", task_typ);

			map.put("currentPage", page.getCurrentPage());
			map.put("start", page.getStart());

			Map<String, Object> couMap = tourService.selRouteTaskCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			lst = tourService.selRouteTask(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController selRouteTask--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 新增 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/insTourTask")
	@ResponseBody
	public BaseTransferEntity insTourTask(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 巡视路线ID
			String tour_route_id = request.getParameter("tour_route_id");
			// 发布人id
			String appoint_id = request.getParameter("appoint_id");
			// 执行人id
			String task_execute_id = request.getParameter("task_execute_id");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("tour_route_id", tour_route_id);
			map.put("appoint_id", appoint_id);
			// 任务状态（1未指派 2未开始 3进行中 4完成待审核 5审核通过 6审核驳回）',
			map.put("task_sta", 2);
			map.put("task_execute_id", task_execute_id);
			// 创建状态（1：自动创建，2：手动创建）
			map.put("task_typ", 2);
			map.put("remark", remark);
			// 添加巡视任务
			tourService.insTourTask(map);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {
			log.error("TourController insTourTask--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}


	/**
	 * 
	 * 巡视任务 审核通过 系统消息已经添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updTourTaskStaCheck")
	@ResponseBody
	public BaseTransferEntity updTourTaskStaCheck(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");

			// 用户id
			String user_id = request.getParameter("user_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_check_id", user_id);
			map.put("task_check_time", new Date());
			map.put("userId",this.getCurrentUserId(request));

			lst = tourService.updTourTaskStaCheck(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updTourTaskStaCheck--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 驳回 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updTourTaskStaReject")
	@ResponseBody
	public BaseTransferEntity updTourTaskStaReject(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");

			// 用户id
			String user_id = request.getParameter("user_id");
			// 驳回原因
			String task_reject_reason = request.getParameter("task_reject_reason");
			
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_check_id", user_id);
			map.put("task_check_time", new Date());
			map.put("task_reject_reason", task_reject_reason);
			map.put("userId",this.getCurrentUserId(request));

			lst = tourService.updTourTaskStaReject(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updTourTaskStaReject--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 开始任务 
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updTourTaskStaExecute")
	@ResponseBody
	public BaseTransferEntity updTourTaskStaExecute(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			// 用户id
			String task_execute_id = request.getParameter("task_execute_id");
			//路线id
			String tour_route_id = request.getParameter("tour_route_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_execute_id", task_execute_id);
			map.put("tour_route_id", tour_route_id);

			lst = tourService.updTourTaskStaExecute(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updTourTaskStaExecute--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delTourTaskSta")
	@ResponseBody
	public BaseTransferEntity delTourTaskSta(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.delTourTaskSta(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController delTourTaskSta--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 查看任务记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selTaskRecord")
	@ResponseBody
	public BaseTransferEntity selTaskRecord(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 路线id
			String tour_route_id = request.getParameter("tour_route_id");
			// 任务id
			String tour_task_id = request.getParameter("tour_task_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("tour_route_id", tour_route_id);
			map.put("tour_task_id", tour_task_id);

			lst = tourService.selTaskRecord(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selTaskRecord--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 查看任务记录 列表信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selTaskRecordAll")
	@ResponseBody
	public BaseTransferEntity selTaskRecordAll(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 路线id
			String tour_route_id = request.getParameter("tour_route_id");
			// 任务id
			String tour_task_id = request.getParameter("tour_task_id");
			
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("tour_route_id", tour_route_id);
			map.put("tour_task_id", tour_task_id);

			lst = tourService.selTaskRecordAll(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selTaskRecordAll--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 记录添加/修改 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/updOrInsTourRecord", method = RequestMethod.POST)
	@ResponseBody
	public BaseTransferEntity updOrInsTourRecord(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("files") MultipartFile[] files) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 路线节点id
			String tour_route_id = request.getParameter("tour_route_id");

			// 开始时间
			String sta_time = request.getParameter("sta_time");
			// 结束时间
			String end_time = request.getParameter("end_time");
			// 任务id
			String tour_task_id = request.getParameter("tour_task_id");
			// 巡视人
			String tour_people_id = request.getParameter("tour_people_id");
			// 是否完成 0 是 1 否
			String tour_complete = request.getParameter("tour_complete");
			// 备注
			String remark = request.getParameter("remark");
			// 记录id
			String treId = request.getParameter("treId");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("tour_route_id", tour_route_id);
			map.put("sta_time", sta_time);
			map.put("end_time", end_time);
			map.put("tour_task_id", tour_task_id);
			map.put("tour_people_id", tour_people_id);
			map.put("tour_complete", tour_complete);
			map.put("remark", remark);
			map.put("treId", treId);
			// 添加/修改任务
			lst = tourService.updOrInsTourRecord(map);

			Map<String, Object> userMap = new HashMap<String, Object>();
			userMap.put("user_id", tour_people_id);
			// 查询 最新添加的记录信息 id
			List<Map<String, Object>> recordId = tourService.selRouteTaskById(userMap);

			if (recordId.get(0).get("id") != null && !"".equals(recordId.get(0).get("id"))) {
				// 图片类型
				// 1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）
				// 文件类型
				// 1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
				// String type = request.getParameter("type");
				// 用户id
				// String userId = request.getParameter("userId");
				String userId = request.getParameter("tour_people_id");

				Map<String, Object> mapNew = new HashMap<String, Object>();
				mapNew.put("userId", userId);
				mapNew.put("tour_record_id", recordId.get(0).get("id"));
				mapNew.put("type", 2);
				boolean hasFile = false;
				for (MultipartFile file : files) {
					if (file != null && !file.isEmpty()) {
						hasFile = true;
						break;
					}
				}
				if (!hasFile) {
					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("msg.global.failed"));
					baseTransferEntity.setDesc("没有选择上传的文件");
				}

				return tourService.uploadImg(mapNew, files, filePath);
			}

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updOrInsTourRecord--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 巡视任务 通过记录id查看记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selTourRecordByRouteId")
	@ResponseBody
	public BaseTransferEntity selTourRecordByRouteId(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 记录id
			String treId = request.getParameter("treId");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("treId", treId);

			lst = tourService.selTourRecordByRouteId(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selTourRecordByRouteId--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 巡视任务 指派 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/tourTaskAppoint")
	@ResponseBody
	public BaseTransferEntity tourTaskAppoint(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			// 指派人id
			String task_execute_id = request.getParameter("task_execute_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_execute_id", task_execute_id);

			map.put("userId",this.getCurrentUserId(request));
			
			lst = tourService.tourTaskAppoint(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController tourTaskAppoint--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 巡视任务 提交 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/tourTaskSubmit")
	@ResponseBody
	public BaseTransferEntity tourTaskSubmit(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			
			String task_check_id = request.getParameter("task_check_id");
			
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_check_id", task_check_id);
			map.put("userId",this.getCurrentUserId(request));

			lst = tourService.tourTaskSubmit(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController tourTaskSubmit--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 巡视任务 更新 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updTourTaskById")
	@ResponseBody
	public BaseTransferEntity updTourTaskById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			// 路线id
			String tour_route_id = request.getParameter("tour_route_id");
			// 创建人id
			String appoint_id = request.getParameter("appoint_id");
			// 执行人id
			String task_execute_id = request.getParameter("task_execute_id");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("tour_route_id", tour_route_id);
			map.put("appoint_id", appoint_id);
			map.put("task_execute_id", task_execute_id);
			map.put("remark", remark);

			lst = tourService.updTourTaskById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updTourTaskById--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 巡视任务 显示 回显
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selTourTaskById")
	@ResponseBody
	public BaseTransferEntity selTourTaskById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.selTourTaskById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selTourTaskById--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	// *******************检修管理*****************************************************

	/**
	 * 
	 * 查看检修任务
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selOverhaulTask")
	@ResponseBody
	public BaseTransferEntity selOverhaulTask(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			// 类型 0全部 1我执行的 2 我发布的 3我审核的
			String type = request.getParameter("type");

			// user_id 用户id
			String user_id = request.getParameter("user_id");

			// task_sta 任务状态（2未开始 3进行中 4完成待审核 5审核通过 6审核驳回）
			String task_sta = request.getParameter("task_sta");

			// task_typ 创建状态（1：自动创建，2：手动创建）
			String task_typ = request.getParameter("task_typ");

			Map<String, Object> map = new HashMap<String, Object>();
		
			map.put("type", type);
			map.put("user_id", user_id);
			map.put("task_sta", task_sta);
			map.put("task_typ", task_typ);

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			Map<String, Object> couMap = tourService.selOverhaulTaskCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			lst = tourService.selOverhaulTask(map);

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
					"TourController selOverhaulTask--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 新增 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/instOverhaulTask")
	@ResponseBody
	public BaseTransferEntity instOverhaulTask(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 巡视路线ID
			String tour_route_id = request.getParameter("tour_route_id");
			// 发布人id
			String appoint_id = request.getParameter("appoint_id");
			// 执行人id
			String task_execute_id = request.getParameter("task_execute_id");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("tour_route_id", tour_route_id);
			map.put("appoint_id", appoint_id);
			// 任务状态（1未指派 2未开始 3进行中 4完成待审核 5审核通过 6审核驳回）',
			map.put("task_sta", 2);
			map.put("task_execute_id", task_execute_id);
			// 创建状态（1：自动创建，2：手动创建）
			map.put("task_typ", 2);
			map.put("remark", remark);
			// 添加
			lst = tourService.instOverhaulTask(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController instOverhaulTask--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 审核
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updOverhaulTaskStaCheck")
	@ResponseBody
	public BaseTransferEntity updOverhaulTaskStaCheck(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			// 用户id
			String user_id = request.getParameter("user_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_check_id", user_id);
			map.put("task_check_time", new Date());
			map.put("userId",this.getCurrentUserId(request));

			lst = tourService.updOverhaulTaskStaCheck(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updOverhaulTaskStaCheck--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 驳回 
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updOverhaulTaskStaReject")
	@ResponseBody
	public BaseTransferEntity updOverhaulTaskStaReject(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			// 用户id
			String user_id = request.getParameter("user_id");
			// 驳回原因
			String task_reject_reason = request.getParameter("task_reject_reason");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_check_id", user_id);
			map.put("task_check_time", new Date());
			map.put("task_reject_reason", task_reject_reason);
			map.put("userId",this.getCurrentUserId(request));

			lst = tourService.updOverhaulTaskStaReject(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updOverhaulTaskStaReject--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 开始任务
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updOverhaulTaskStaExecute")
	@ResponseBody
	public BaseTransferEntity updOverhaulTaskStaExecute(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			// 用户id
			String task_execute_id = request.getParameter("task_execute_id");
			// 路线id
			String tour_route_id = request.getParameter("tour_route_id");
			
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_execute_id", task_execute_id);
			map.put("tour_route_id", tour_route_id);

			lst = tourService.updOverhaulTaskStaExecute(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updOverhaulTaskStaExecute--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delOverhaulTaskSta")
	@ResponseBody
	public BaseTransferEntity delOverhaulTaskSta(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.delOverhaulTaskSta(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController delOverhaulTaskSta--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 查看任务记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selOverhaulTaskRecord")
	@ResponseBody
	public BaseTransferEntity selOverhaulTaskRecord(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 路线id
			String tour_route_id = request.getParameter("tour_route_id");
			// 任务id
			String tour_task_id = request.getParameter("tour_task_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("tour_route_id", tour_route_id);
			map.put("tour_task_id", tour_task_id);

			lst = tourService.selOverhaulTaskRecord(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selOverhaulTaskRecord--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 查看任务记录 列表 信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selOverhaulTaskRecordAll")
	@ResponseBody
	public BaseTransferEntity selOverhaulTaskRecordAll(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 路线id
			String tour_route_id = request.getParameter("tour_route_id");
			// 任务id
			String tour_task_id = request.getParameter("tour_task_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("tour_route_id", tour_route_id);
			map.put("tour_task_id", tour_task_id);

			lst = tourService.selOverhaulTaskRecordAll(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selOverhaulTaskRecordAll--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 记录添加/修改 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/updOrInsOverhaulRecord", method = RequestMethod.POST)
	@ResponseBody
	public BaseTransferEntity updOrInsOverhaulRecord(
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam("files") MultipartFile[] files) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 路线节点id
			String tour_route_id = request.getParameter("tour_route_id");

			// 开始时间
			String sta_time = request.getParameter("sta_time");
			// 结束时间
			String end_time = request.getParameter("end_time");
			// 任务id
			String tour_task_id = request.getParameter("tour_task_id");
			// 巡视人
			String tour_people_id = request.getParameter("tour_people_id");
			// 是否完成 0 是 1 否
			String tour_complete = request.getParameter("tour_complete");
			// 备注
			String remark = request.getParameter("remark");
			// 记录id
			String oreId = request.getParameter("oreId");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("tour_route_id", tour_route_id);
			map.put("sta_time", sta_time);
			map.put("end_time", end_time);
			map.put("tour_task_id", tour_task_id);
			map.put("tour_people_id", tour_people_id);
			map.put("tour_complete", tour_complete);
			map.put("remark", remark);
			map.put("oreId", oreId);

			lst = tourService.updOrInsOverhaulRecord(map);

			Map<String, Object> userMap = new HashMap<String, Object>();
			userMap.put("user_id", tour_people_id);
			// 查询 最新添加的记录信息 id
			List<Map<String, Object>> recordId = tourService.selOverhaulNewTaskById(userMap);

			if (recordId.get(0).get("id") != null
					&& !"".equals(recordId.get(0).get("id"))) {
				// 图片类型
				// 1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）
				// 文件类型
				// 1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
				// String type = request.getParameter("type");
				// 用户id
				// String userId = request.getParameter("userId");
				String userId = request.getParameter("tour_people_id");

				Map<String, Object> mapNew = new HashMap<String, Object>();
				mapNew.put("userId", userId);
				mapNew.put("tour_record_id", recordId.get(0).get("id"));
				mapNew.put("type", 4);
				boolean hasFile = false;
				for (MultipartFile file : files) {
					if (file != null && !file.isEmpty()) {
						hasFile = true;
						break;
					}
				}
				if (!hasFile) {
					baseTransferEntity.setResultcode(MobileConfig
							.getStringCode("msg.global.failed"));
					baseTransferEntity.setDesc("没有选择上传的文件");
				}

				return tourService.uploadImg(mapNew, files, filePath);
			}

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updOrInsOverhaulRecord--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 通过路线节点id查看记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selOverhaulRecordByRouteId")
	@ResponseBody
	public BaseTransferEntity selOverhaulRecordByRouteId(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 记录id
			String oreId = request.getParameter("oreId");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("oreId", oreId);

			lst = tourService.selOverhaulRecordByRouteId(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selOverhaulRecordByRouteId--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 巡视任务 指派 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/overhaulTaskAppoint")
	@ResponseBody
	public BaseTransferEntity overhaulTaskAppoint(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			// 指派人id
			String task_execute_id = request.getParameter("task_execute_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_execute_id", task_execute_id);
			map.put("userId",this.getCurrentUserId(request));

			lst = tourService.overhaulTaskAppoint(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController overhaulTaskAppoint--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 巡视任务 提交 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/overhaulTaskSubmit")
	@ResponseBody
	public BaseTransferEntity overhaulTaskSubmit(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			String task_check_id = request.getParameter("task_check_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("task_check_id", task_check_id);
			map.put("userId",this.getCurrentUserId(request));

			lst = tourService.overhaulTaskSubmit(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController overhaulTaskSubmit--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 更新 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updOverhaulTaskById")
	@ResponseBody
	public BaseTransferEntity updOverhaulTaskById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");
			// 路线id
			String tour_route_id = request.getParameter("tour_route_id");
			// 创建人id
			String appoint_id = request.getParameter("appoint_id");
			// 执行人id
			String task_execute_id = request.getParameter("task_execute_id");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("tour_route_id", tour_route_id);
			map.put("appoint_id", appoint_id);
			map.put("task_execute_id", task_execute_id);
			map.put("remark", remark);

			lst = tourService.updOverhaulTaskById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController updOverhaulTaskById--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 检修任务 显示 回显
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selOverhaulTaskById")
	@ResponseBody
	public BaseTransferEntity selOverhaulTaskById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 任务id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.selOverhaulTaskById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selOverhaulTaskById--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	// *********************************************报废管理************************
	/**
	 * 
	 * 报修 列表显示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selRepair")
	@ResponseBody
	public BaseTransferEntity selRepair(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			// 类型 0全部 1我创建的 2我维修的 3我审核的
			String type = request.getParameter("type");
			// 用户id
			String userId = request.getParameter("userId");
			// 审核状态 1未指派 2未开始 3进行中 4完成待审核 5审核通过 6审核驳回
			String check_sta = request.getParameter("check_sta");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("type", type);
			map.put("userId", userId);

			map.put("check_sta", check_sta);

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			Map<String, Object> couMap = tourService.selRepairCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			lst = tourService.selRepair(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController selRepair--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 新建报修任务 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertRepair")
	@ResponseBody
	public BaseTransferEntity insertRepair(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// 创建时间
			// String crt_tim = request.getParameter("crt_tim");
			// 报修原因
			String repair_reason = request.getParameter("repair_reason");
			// 创建人id
			String crt_use_id = request.getParameter("crt_use_id");
			// 维修人员id
			String repair_use_id = request.getParameter("repair_use_id");
			// 是否更换 0 否 1是
			String if_change = request.getParameter("if_change");
			// 备注
			String remark = request.getParameter("remark");

			// 备注
			String tour_nam = request.getParameter("tour_nam");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("equ_num", equ_num);
			map.put("crt_tim", new Date());
			map.put("repair_reason", repair_reason);
			map.put("crt_use_id", crt_use_id);
			map.put("repair_use_id", repair_use_id);
			map.put("if_change", if_change);
			// 审核状态 （1未指派 2未开始 3进行中 4完成待审核 5审核通过 6审核驳回）'
			map.put("check_sta", 2);
			map.put("remark", remark);
			map.put("tour_nam", tour_nam);

			lst = tourService.insertRepair(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController insertRepair--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 修改报修任务 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updateRepair")
	@ResponseBody
	public BaseTransferEntity updateRepair(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			//
			String id = request.getParameter("id");
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// 报修原因
			String repair_reason = request.getParameter("repair_reason");
			// 创建人id
			String crt_use_id = request.getParameter("crt_use_id");
			// 维修人员id
			String repair_use_id = request.getParameter("repair_use_id");
			// 是否更换 0 否 1是
			String if_change = request.getParameter("if_change");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("equ_num", equ_num);
			map.put("upd_tim", new Date());
			map.put("repair_reason", repair_reason);
			map.put("crt_use_id", crt_use_id);
			map.put("repair_use_id", repair_use_id);
			map.put("if_change", if_change);
			map.put("remark", remark);

			lst = tourService.updateRepair(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController updateRepair--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 修改任务 信息回显
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selRepairById")
	@ResponseBody
	public BaseTransferEntity selRepairById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			lst = tourService.selRepairById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selRepairById--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 删除报修任务
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delRepair")
	@ResponseBody
	public BaseTransferEntity delRepair(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);

			lst = tourService.delRepair(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController delRepair--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 节点添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertRepariNode")
	@ResponseBody
	public BaseTransferEntity insertRepariNode(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 报修id
			String repair_id = request.getParameter("repair_id");
			// 维修人员id
			String crt_id = request.getParameter("crt_id");
			// 开始时间
			String sta_time = request.getParameter("sta_time");
			// 结束时间
			String end_time = request.getParameter("end_time");
			// 状态 1开始 2开始中 3结束
			String sta = request.getParameter("sta");
			// 维修结果及总结
			String repair_result = request.getParameter("repair_result");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("repair_id", repair_id);
			map.put("crt_id", crt_id);
			map.put("sta_time", sta_time);
			map.put("end_time", end_time);
			map.put("sta", sta);
			map.put("repair_result", repair_result);
			map.put("remark", remark);

			lst = tourService.insertRepariNode(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController insertRepariNode--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 开始报修任务
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updRepairSta")
	@ResponseBody
	public BaseTransferEntity updRepairSta(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 报修id
			String id = request.getParameter("id");
			// 用户id
			String crt_id = request.getParameter("crt_id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("crt_id", crt_id);

			lst = tourService.updRepairSta(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController updRepairSta--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 根据报修id查看该3条记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selRepairNodeAndRepair")
	@ResponseBody
	public BaseTransferEntity selRepairNodeAndRepair(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 报修id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);

			lst = tourService.selRepairNodeAndRepair(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController selRepairNodeAndRepair--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 根据报修id 查询报修记录信息 及状态
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selRepairNodeAndRepairAll")
	@ResponseBody
	public BaseTransferEntity selRepairNodeAndRepairAll(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 报修id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);

			lst = tourService.selRepairNodeAndRepairAll(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selRepairNodeAndRepairAll--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 根据报修id 查询报修记录所有信息 及附件
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selRepairNodeAll")
	@ResponseBody
	public BaseTransferEntity selRepairNodeAll(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			// 报修id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);

			lst = tourService.selRepairNodeAll(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selRepairNodeAll--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 报修节点修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/updRepairNode", method = RequestMethod.POST)
	@ResponseBody
	public BaseTransferEntity updRepairNode(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("files") MultipartFile[] files) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 报修节点id
			String id = request.getParameter("id");
			// 开始时间
			String sta_time = request.getParameter("sta_time");
			// 结束时间
			String end_time = request.getParameter("end_time");
			// 是否完成 0否 1是
			String if_success = request.getParameter("if_success");
			// 维修结果及总结
			String repair_result = request.getParameter("repair_result");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("sta_time", sta_time);
			map.put("end_time", end_time);
			map.put("if_success", if_success);
			map.put("repair_result", repair_result);
			map.put("remark", remark);

			lst = tourService.updRepairNode(map);

			// 图片类型
			// 1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）
			// 文件类型
			// 1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
			// String type = request.getParameter("type");

			// 用户id
			String userId = request.getParameter("userId");

			Map<String, Object> mapNew = new HashMap<String, Object>();
			mapNew.put("userId", userId);
			mapNew.put("tour_record_id", id);
			mapNew.put("type", 6);

			boolean hasFile = false;
			for (MultipartFile file : files) {
				if (file != null && !file.isEmpty()) {
					hasFile = true;
					break;
				}
			}
			if (!hasFile) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("没有选择上传的文件");
			}

			return tourService.uploadImg(mapNew, files, filePath);

		} catch (Exception e) {
			log.error("TourController updRepairNode--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 报修节点 添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/insertRepairNode", method = RequestMethod.POST)
	@ResponseBody
	public BaseTransferEntity insertRepairNode(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("files") MultipartFile[] files) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 报修id
			String id = request.getParameter("id");
			// 创建人id
			String crt_id = request.getParameter("crt_id");
			// 开始时间
			String sta_time = request.getParameter("sta_time");
			// 结束时间
			String end_time = request.getParameter("end_time");
			// 状态 1开始 2开始中 3 结束'
			String sta = request.getParameter("sta");
			// 是否完成 0否 1是
			String if_success = request.getParameter("if_success");
			// 维修结果及总结
			String repair_result = request.getParameter("repair_result");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("repair_id", id);
			map.put("crt_id", crt_id);
			map.put("sta_time", sta_time);
			map.put("end_time", end_time);
			map.put("sta", sta);
			map.put("if_success", if_success);
			map.put("repair_result", repair_result);
			map.put("remark", remark);
			map.put("crt_tim", new Date());

			lst = tourService.insertRepariNode(map);

			Map<String, Object> newMap = new HashMap<String, Object>();
			newMap.put("crt_id", crt_id);
			newMap.put("sta", sta);

			// 查询刚添加的 报修 节点信息
			List<Map<String, Object>> lstMap = tourService.selRepairNodeNew(newMap);

			// 图片类型
			// 1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）
			// 文件类型
			// 1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
			// String type = request.getParameter("type");

			// 用户id
			// String userId = request.getParameter("userId");

			Map<String, Object> mapNew = new HashMap<String, Object>();
			mapNew.put("userId", crt_id);
			mapNew.put("tour_record_id", lstMap.get(0).get("id"));
			mapNew.put("type", 6);

			boolean hasFile = false;
			for (MultipartFile file : files) {
				if (file != null && !file.isEmpty()) {
					hasFile = true;
					break;
				}
			}
			if (!hasFile) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("没有选择上传的文件");
			}

			return tourService.uploadImg(mapNew, files, filePath);

		} catch (Exception e) {
			log.error(
					"TourController insertRepairNode--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 根据报修节点id查看 信息回显
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selRepairNodeById")
	@ResponseBody
	public BaseTransferEntity selRepairNodeById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {

			// 报修节点id
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);

			lst = tourService.selRepairNodeById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController selRepairNodeById--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 任务提交 完成待审核 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updRepairStaFour")
	@ResponseBody
	public BaseTransferEntity updRepairStaFour(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 报修id
			String id = request.getParameter("id");
			// 审核人id
			String check_use_id = request.getParameter("check_use_id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("check_use_id", check_use_id);

			lst = tourService.updRepairStaFour(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController updRepairStaFour--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报修 审核或驳回 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updRepairStaIfSuccess")
	@ResponseBody
	public BaseTransferEntity updRepairStaIfSuccess(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 报修id
			String id = request.getParameter("id");
			// 审核人id
			String check_use_id = request.getParameter("check_use_id");
			// 审核时间
			// String check_time = request.getParameter("check_time");
			// 审核详情
			String check_remark = request.getParameter("check_remark");
			// 状态 1未指派 2未开始 3进行中 4完成待审核 5审核通过 6审核驳回、
			// 因为这个方法是 审核通过 或 驳回 所以 状态只需要 5或者6
			String check_sta = request.getParameter("check_sta");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("check_use_id", check_use_id);
			map.put("check_time", new Date());
			map.put("check_remark", check_remark);
			map.put("check_sta", check_sta);
			map.put("crt_id", this.getCurrentUserId(request));

			lst = tourService.updRepairStaIfSuccess(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController updRepairStaIfSuccess--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	// *********************************************报废管理************************
	/**
	 * 
	 * 报废 列表显示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selScrap")
	@ResponseBody
	public BaseTransferEntity selScrap(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			// 类型 1我创建的 2我第一审核 3我第二次审核
			String type = request.getParameter("type");
			// 用户id
			String userId = request.getParameter("userId");
			// 审核状态0 未开始 1开始未审核 2第一审核通过 3第一审核驳回 4第二次审核通过 5第二次审核驳回
			String check_sta = request.getParameter("check_sta");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("userId", userId);

			// 我创建的
			if ("1".equals(type)) {
				map.put("crt_use_id", userId);
			}
			// 我第一次审核
			if ("2".equals(type)) {
				map.put("one_check_use_id", userId);
			}
			// 我第二次审核
			if ("3".equals(type)) {
				map.put("two_chcek_use_id", userId);
			}

			map.put("check_sta", check_sta);

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			Map<String, Object> couMap = tourService.selScrapCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			lst = tourService.selScrap(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController selRepair--------->" + e.getMessage(), e);
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
	 * 
	 * 报废 新增报废任务 TODO---
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/insertScrap", method = RequestMethod.POST)
	@ResponseBody
	public BaseTransferEntity insertScrap(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("files") MultipartFile[] files) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 创建人id
			String crt_use_id = request.getParameter("crt_use_id");
			//
			// String crt_tim = request.getParameter("crt_tim");
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// 报废原因
			String scrap_resaon = request.getParameter("scrap_resaon");
			// 处理意见
			String scrap_opinion = request.getParameter("scrap_opinion");
			// 第一次审核人id
			String one_check_use_id = request.getParameter("one_check_use_id");
			// 备注
			String remark = request.getParameter("remark");

			// 备注
			String tour_nam = request.getParameter("tour_nam");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("crt_use_id", crt_use_id);
			map.put("crt_tim", new Date());
			map.put("equ_num", equ_num);
			map.put("scrap_resaon", scrap_resaon);
			map.put("scrap_opinion", scrap_opinion);
			map.put("one_check_use_id", one_check_use_id);
			// 审核状态（0 未开始 1开始未审核 2第一审核通过 3第一审核驳回 4第二次审核通过 5第二次审核驳回
			map.put("check_sta", 1);
			map.put("remark", remark);
			map.put("tour_nam", tour_nam);

			// 任务添加
			tourService.insertScrap(map);

			Map<String, Object> newMap = new HashMap<String, Object>();
			newMap.put("crt_use_id", crt_use_id);
			// 查询刚添加的任务
			List<Map<String, Object>> lstNew = tourService.selScrapNew(newMap);

			// 图片类型
			// 1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）
			// 文件类型
			// 1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
			// String type = request.getParameter("type");

			Map<String, Object> mapNew = new HashMap<String, Object>();
			mapNew.put("userId", crt_use_id);
			mapNew.put("tour_record_id", lstNew.get(0).get("id"));
			mapNew.put("type", 7);

			boolean hasFile = false;
			for (MultipartFile file : files) {
				if (file != null && !file.isEmpty()) {
					hasFile = true;
					break;
				}
			}
			if (!hasFile) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("没有选择上传的文件");
			}

			return tourService.uploadImg(mapNew, files, filePath);

		} catch (Exception e) {
			log.error("TourController selRepair--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报废 修改报废任务
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updateScrap")
	@ResponseBody
	public BaseTransferEntity updateScrap(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			String id = request.getParameter("id");
			// 创建人id
			String crt_use_id = request.getParameter("crt_use_id");
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			// 报废原因
			String scrap_resaon = request.getParameter("scrap_resaon");
			// 处理意见
			String scrap_opinion = request.getParameter("scrap_opinion");
			// 第一次审核人id
			String one_check_use_id = request.getParameter("one_check_use_id");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("crt_use_id", crt_use_id);
			map.put("equ_num", equ_num);
			map.put("scrap_resaon", scrap_resaon);
			map.put("scrap_opinion", scrap_opinion);
			map.put("one_check_use_id", one_check_use_id);
			map.put("remark", remark);
			// 1开始未审核
			map.put("check_sta", 1);

			lst = tourService.updateScrap(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController updateScrap--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报废 信息回显
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selScrapById")
	@ResponseBody
	public BaseTransferEntity selScrapById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {

			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.selScrapById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController selScrapById--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}
	/**
	 * 
	 * 报废 信息回显 App接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selScrapByIdApp")
	@ResponseBody
	public BaseTransferEntity selScrapByIdApp(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		Map<String, Object> lst = new HashMap<String, Object>();
		
		try {
			
			String id = request.getParameter("id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			
			lst = tourService.selScrapByIdApp(map);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController selRepair--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}

	/**
	 * 
	 * 报废 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delScrap")
	@ResponseBody
	public BaseTransferEntity delScrap(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.delScrap(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController delScrap--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报废 第一次审核或驳回 系统消息已添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updScrapStaOne")
	@ResponseBody
	public BaseTransferEntity updScrapStaOne(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 报废id
			String id = request.getParameter("id");
			// 第一审核详情
			String one_check_detail = request.getParameter("one_check_detail");
			// 第一次审核时间
			// String one_check_tim = request.getParameter("one_check_tim");
			// 审核状态（0 未开始 1开始未审核 2第一审核通过 3第一审核驳回 4第二次审核通过 5第二次审核驳回
			// 这个方法是第一次审核 只需要状态 2或者3
			String check_sta = request.getParameter("check_sta");
			// 第二次审核人
			String two_chcek_use_id = request.getParameter("two_chcek_use_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("one_check_detail", one_check_detail);
			map.put("one_check_tim", new Date());
			map.put("check_sta", check_sta);
			map.put("two_chcek_use_id", two_chcek_use_id);

			lst = tourService.updScrapStaOne(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController updScrapStaOne--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 
	 * 报废 第二次审核或驳回 
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updScrapStaTwo")
	@ResponseBody
	public BaseTransferEntity updScrapStaTwo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			// 报废id
			String id = request.getParameter("id");
			// 第二审核详情
			String two_check_detail = request.getParameter("two_check_detail");
			// 第二次审核时间
			// String two_check_tim = request.getParameter("two_check_tim");
			// 审核状态（0 未开始 1开始未审核 2第一审核通过 3第一审核驳回 4第二次审核通过 5第二次审核驳回
			// 这个方法是第二次审核 只需要状态 4或者5
			String check_sta = request.getParameter("check_sta");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("two_check_detail", two_check_detail);
			map.put("two_check_tim", new Date());
			map.put("check_sta", check_sta);

			lst = tourService.updScrapStaTwo(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController updScrapStaTwo--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	// *********************************************巡视计划************************
	/**
	 * 
	 * 巡视计划 列表显示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/selTourPlan")
	@ResponseBody
	public BaseTransferEntity selTourPlan(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			// 用户id
			String userId = request.getParameter("userId");
			// 计划运行状态（1：执行2：停止）
			String run_flat = request.getParameter("run_flat");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("crt_use_id", userId);
			map.put("run_flat", run_flat);

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			Map<String, Object> couMap = tourService.selTourPlanCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			lst = tourService.selTourPlan(map);

			//清楚 timer 任务
			for (Map<String, Object> result : lst) {
				
				if (result.get("next_time").equals("计划已过期")) {
					
					String id = result.get("id").toString();
					// 修改计划状态为 执行 状态（1：执行2：停止）
					Map<String, Object> timeMap = new HashMap<String, Object>();
					timeMap.put("id", id);
					timeMap.put("run_flat", 2);
					tourService.updTourPlanFlat(map);
					//清空timer任务
					Timer timer = (Timer) tourTimerMap.get(id);
					
					if (timer != null && timer.equals("")) {
						timer.cancel();
					}
					
					
					
				}
			}
			
			
			
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController selTourPlan--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 巡视计划 添加 或 更新 
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertOrUpdTourPlan")
	@ResponseBody
	public BaseTransferEntity insertTourPlan(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 计划id
			String id = request.getParameter("id");
			// 巡视路线id
			String tour_route_id = request.getParameter("tour_route_id");
			// 首次工作日期
			String first_time = request.getParameter("first_time");
			// 下次工作日期
			String next_time = request.getParameter("next_time");
			// 周期类型 1月 2日
			String day_type = request.getParameter("day_type");
			// 频率
			String frequency = request.getParameter("frequency");
			// 计划巡视工期
			String plan_tour_time = request.getParameter("plan_tour_time");
			// 创建人id
			String crt_use_id = request.getParameter("crt_use_id");
			// 计划名称
			String tour_plan_name = request.getParameter("tour_plan_name");
			// 备注
			String remark = request.getParameter("remark");
			// 计划自动结束时间
			String end_time = request.getParameter("end_time");
			// 计划运行状态（1：执行2：停止）
			 String run_flat = request.getParameter("run_flat");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("tour_route_id", tour_route_id);
			map.put("first_time", first_time);
			map.put("next_time", next_time);
			map.put("day_type", day_type);
			map.put("frequency", frequency);
			map.put("plan_tour_time", plan_tour_time);
			map.put("crt_use_id", crt_use_id);
			map.put("tour_plan_name", tour_plan_name);
			map.put("crt_tim", new Date());
			map.put("remark", remark);
			map.put("end_time", end_time);

			// 如果id 不为空 则 修改
			if (id != null && !"".equals(id)) {
				map.put("run_flat", run_flat);
				lst = tourService.updTourPlan(map);
				
			} else {
				// 添加 计划 默认为 停止
				map.put("run_flat", 2);

				lst = tourService.insertTourPlan(map);

			}

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController insertOrUpdTourPlan--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 巡视计划 根据id查看
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getTourPlanById")
	@ResponseBody
	public BaseTransferEntity getTourPlanById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.getTourPlanById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController getTourPlanById--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 巡视计划 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delTourPlan")
	@ResponseBody
	public BaseTransferEntity delTourPlan(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.delTourPlan(map);

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
	 * 巡视计划 开始执行
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/updTourPlanRunFlat")
	@ResponseBody
	public BaseTransferEntity updTourPlanRunFlat(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		// 准备执行任务
		Timer timer = new Timer();

		try {
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			// 根据计划id查询 计划信息
			List<Map<String, Object>> lstTrouPlan = tourService.getTourPlanById(map);

			//月
			if (lstTrouPlan.get(0).get("day_type").equals("1")) {
				
				if (lstTrouPlan.get(0).get("next_time").equals("计划已过期")) {
					// 修改计划状态为 执行 状态（1：执行2：停止）
					Map<String, Object> runFlat = new HashMap<String, Object>();
					runFlat.put("id", id);
					runFlat.put("run_flat", 2);
					tourService.updTourPlanFlat(runFlat);

					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
					baseTransferEntity.setData(null);
					baseTransferEntity.setDesc("计划已过期。");
					return baseTransferEntity;
					
				}else {
					
					// 首次工作日期
					Date first_time = format.parse(lstTrouPlan.get(0).get("first_time").toString());
					// 下次工作日期
					Date next_time = format.parse(lstTrouPlan.get(0).get("next_time").toString());
					// 周期
					int frequency = (Integer) lstTrouPlan.get(0).get("frequency");
					
					long cha = next_time.getTime() - first_time.getTime();
					
					// 结束时间
					String end_time = lstTrouPlan.get(0).get("end_time").toString();

					map.put("endTime", end_time);

					//long delay = frequency * 24L * 3600L * 1000L;
					
					tourTimerMap.put(id, timer);

					//巡视计划 修改该计划的状态 为开始执行
					tourService.updTourPlanBegin(map);
					
					timer.schedule(new TourTask(map),first_time, cha);//安排指定的任务task在指定的时间firstTime开始进行重复的固定速率delay执行
				}
			}
				
				//日
				if (lstTrouPlan.get(0).get("day_type").equals("2")) {
					
					if (lstTrouPlan.get(0).get("next_time").equals("计划已过期")) {
						// 修改计划状态为 执行 状态（1：执行2：停止）
						Map<String, Object> runFlat = new HashMap<String, Object>();
						runFlat.put("id", id);
						runFlat.put("run_flat", 2);
						tourService.updTourPlanFlat(runFlat);

						baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
						baseTransferEntity.setData(null);
						baseTransferEntity.setDesc("计划已过期。");
						return baseTransferEntity;
						
					}else {
						
						// 首次工作日期
						Date first_time = format.parse(lstTrouPlan.get(0).get("first_time").toString());
						// 下次工作日期
						Date next_time = format.parse(lstTrouPlan.get(0).get("next_time").toString());
						// 周期
						int frequency = (Integer) lstTrouPlan.get(0).get("frequency");
						
						//long cha = next_time.getTime() - first_time.getTime();
						
						// 结束时间
						String end_time = lstTrouPlan.get(0).get("end_time").toString();
						
						map.put("endTime", end_time);

						long delay = frequency * 24L * 3600L * 1000L;
						
						tourTimerMap.put(id, timer);
						
						//巡视计划 修改该计划的状态 为开始执行
						tourService.updTourPlanBegin(map);
						
						
						timer.schedule(new TourTask(map),first_time,delay);//安排指定的任务task在指定的时间firstTime开始进行重复的固定速率delay执行
					}
				}
			
			//timer.schedule(new TourTask(map), format.parse(first_time), 10000);//安排指定的任务task在指定的时间firstTime开始进行重复的固定速率delay执行

			/* //修改计划状态为 执行 状态（1：执行2：停止）
			 Map<String,Object> runFlat = new HashMap<String,Object>();
			 runFlat.put("id",id);
			 runFlat.put("run_flat",1);
			 tourService.updTourPlanFlat(runFlat);
			 */
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(null);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController updTourPlanRunFlat--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}
	
	/**
	 * 
	 * 巡视计划  停止
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/stopTourPlan")
	@ResponseBody
	public BaseTransferEntity stopTourPlan(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			String id = request.getParameter("id");
			// 修改计划状态为 执行 状态（1：执行2：停止）
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("run_flat", 2);
			tourService.updTourPlanFlat(map);
			//清空timer任务
			Timer timer = (Timer) tourTimerMap.get(id);
			timer.cancel();
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController stopTourPlan--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	
	
	

	// *********************************************检修计划************************
	/**
	 * 
	 * 检修计划 列表显示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/selOverhaulPlan")
	@ResponseBody
	public BaseTransferEntity selOverhaulPlan(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			// 用户id
			String userId = request.getParameter("userId");
			// 计划运行状态（1：执行2：停止）
			String run_flat = request.getParameter("run_flat");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("crt_use_id", userId);
			map.put("run_flat", run_flat);

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			Map<String, Object> couMap = tourService.selOverhaulPlanCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			lst = tourService.selOverhaulPlan(map);
			
			//清楚 timer 任务
			for (Map<String, Object> result : lst) {
				
				if (result.get("next_time").equals("计划已过期")) {
					
					String id = result.get("id").toString();
					// 修改计划状态为 执行 状态（1：执行2：停止）
					Map<String, Object> timeMap = new HashMap<String, Object>();
					timeMap.put("id", id);
					timeMap.put("run_flat", 2);
					tourService.updOverhaulPlanFlat(map);
					//清空timer任务
					Timer timer = (Timer) overhaulTimerMap.get(id);
					
					if (timer != null && timer.equals("")) {
						timer.cancel();
					}
					
				}
			}
			

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController selOverhaulPlan--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 检修计划 添加 或 更新 
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertOrUpdOverhaulPlan")
	@ResponseBody
	public BaseTransferEntity insertOrUpdOverhaulPlan(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 计划id
			String id = request.getParameter("id");
			// 巡视路线id
			String tour_route_id = request.getParameter("tour_route_id");
			// 首次工作日期
			String first_time = request.getParameter("first_time");
			// 下次工作日期
			String next_time = request.getParameter("next_time");
			// 周期类型
			String day_type = request.getParameter("day_type");
			// 频率
			String frequency = request.getParameter("frequency");
			// 计划巡视工期
			String plan_tour_time = request.getParameter("plan_tour_time");
			// 创建人id
			String crt_use_id = request.getParameter("crt_use_id");
			// 计划名称
			String tour_plan_name = request.getParameter("tour_plan_name");
			// 备注
			String remark = request.getParameter("remark");
			// 计划自动结束时间
			String end_time = request.getParameter("end_time");
			// 计划运行状态（1：执行2：停止）
			String run_flat = request.getParameter("run_flat");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("tour_route_id", tour_route_id);
			map.put("first_time", first_time);
			map.put("next_time", next_time);
			map.put("day_type", day_type);
			map.put("frequency", frequency);
			map.put("plan_tour_time", plan_tour_time);
			map.put("crt_use_id", crt_use_id);
			map.put("tour_plan_name", tour_plan_name);
			map.put("crt_tim", new Date());
			map.put("remark", remark);
			map.put("end_time", end_time);

			if (id != null && !"".equals(id)) {
				map.put("run_flat", run_flat);
				lst = tourService.updOverhaulPlan(map);

			} else {
				map.put("run_flat", 2);

				lst = tourService.insertOverhaulPlan(map);

			}

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController insertOrUpdOverhaulPlan--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 检修计划 id查看计划
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getOverhaulPlanById")
	@ResponseBody
	public BaseTransferEntity getOverhaulPlanById(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.getOverhaulPlanById(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController getOverhaulPlanById--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * 检修计划 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delOverhaulPlan")
	@ResponseBody
	public BaseTransferEntity delOverhaulPlan(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			lst = tourService.delOverhaulPlan(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
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

	/**
	 * 检修计划 开始执行
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/service/updOverhaulPlanRunFlat")
	@ResponseBody
	public BaseTransferEntity updOverhaulPlanRunFlat(
			HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");					

		
		// 准备执行任务
		Timer timer = new Timer();

		try {

			String id = request.getParameter("id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);

			// 根据计划id查询 计划信息
			List<Map<String, Object>> lstTrouPlan = tourService.getOverhaulPlanById(map);
			
			
			//月				
			if (lstTrouPlan.get(0).get("day_type").equals("1")) {	
				
				if (lstTrouPlan.get(0).get("next_time").equals("计划已过期")) {
					// 修改计划状态为 执行 状态（1：执行2：停止）
					Map<String, Object> runFlat = new HashMap<String, Object>();
					runFlat.put("id", id);
					runFlat.put("run_flat", 2);
					tourService.updOverhaulPlanFlat(runFlat);

					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
					baseTransferEntity.setData(null);
					baseTransferEntity.setDesc("计划已过期。");
					return baseTransferEntity;
					
				}else{
					
					// 首次工作日期
					Date first_time = format.parse(lstTrouPlan.get(0).get("first_time").toString());

					// 下次工作日期								
					Date next_time = format.parse(lstTrouPlan.get(0).get("next_time").toString());	
					
					// 周期							
					int frequency = (Integer) lstTrouPlan.get(0).get("frequency");							
												
					long cha = next_time.getTime() - first_time.getTime();			
					
					// 结束时间							
					String end_time = lstTrouPlan.get(0).get("end_time").toString();							
												
					map.put("endTime", end_time);			

					overhaulTimerMap.put(id, timer);	
					
					//修改该计划的状态 为开始执行
					tourService.updOverhaulPlanBegin(map);
					
					timer.schedule(new OverhaulTask(map),first_time, cha);//安排指定的任务task在指定的时间firstTime开始进行重复的固定速率delay执行

				}
			}	
				
				if (lstTrouPlan.get(0).get("day_type").equals("2")) {	
					
					if (lstTrouPlan.get(0).get("next_time").equals("计划已过期")) {
						// 修改计划状态为 执行 状态（1：执行2：停止）
						Map<String, Object> runFlat = new HashMap<String, Object>();
						runFlat.put("id", id);
						runFlat.put("run_flat", 2);
						tourService.updOverhaulPlanFlat(runFlat);

						baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
						baseTransferEntity.setData(null);
						baseTransferEntity.setDesc("计划已过期。");
						return baseTransferEntity;
						
					}else{
						
						// 首次工作日期
						Date first_time =format.parse(lstTrouPlan.get(0).get("first_time").toString());

						// 下次工作日期								
						Date next_time = format.parse(lstTrouPlan.get(0).get("next_time").toString());	
						
						// 周期							
						int frequency = (Integer) lstTrouPlan.get(0).get("frequency");							
													
						//long cha = next_time.getTime() - first_time.getTime();			
						
						// 结束时间							
						String end_time = lstTrouPlan.get(0).get("end_time").toString();	
						
						long delay = frequency * 24L * 3600L * 1000L;				

						map.put("endTime", end_time);			

						overhaulTimerMap.put(id, timer);
						
						//修改该计划的状态 为开始执行
						tourService.updOverhaulPlanBegin(map);
						

						timer.schedule(new OverhaulTask(map),first_time, delay);//安排指定的任务task在指定的时间firstTime开始进行重复的固定速率delay执行

					}
				}
						

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(null);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {
			log.error("TourController updOverhaulPlanRunFlat--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}
	
	/**				
	 * 				
	 * 巡视计划  停止				
	 * @param request				
	 * @param response				
	 * @return				
	 */				
	@RequestMapping(value = "/service/stopOverhaulPlan")				
	@ResponseBody				
	public BaseTransferEntity stopOverhaulPlan(HttpServletRequest request,				
			HttpServletResponse response) {		
					
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();			
					
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();			
					
		try {			
			String id = request.getParameter("id");		
			// 修改计划状态为 执行 状态（1：执行2：停止）
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("run_flat", 2);
			
			tourService.updOverhaulPlanFlat(map);	
			// 清空 检修计划 timer任务
			Timer timer = (Timer) overhaulTimerMap.get(id);		
			timer.cancel();		
					
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));		
			baseTransferEntity.setData(lst);		
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));		
		} catch (Exception e) {			
			log.error("TourController stopOverhaulPlan--------->" + e.getMessage(),		
					e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");		
			baseTransferEntity.setData(null);		
		}			
		return baseTransferEntity;		

	}
	
	
	
	
	

	/*
	 * @Value("${img.upload.path}") String imgPath;
	 */

	// **********************************

	/**
	 * 运维 图片上传
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/uploadImg", method = RequestMethod.POST)
	@ResponseBody
	public BaseTransferEntity uploadImg(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("files") MultipartFile[] files) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 上传人
			String userId = request.getParameter("userId");
			// 记录或任务或过程id
			String tour_record_id = request.getParameter("recordId");
			// 图片类型
			// 1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）
			// 文件类型
			// 1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
			String type = request.getParameter("type");
			// 备注
			String remark = request.getParameter("remark");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("userId", userId);
			map.put("tour_record_id", tour_record_id);
			map.put("type", type);
			map.put("remark", remark);

			boolean hasFile = false;
			for (MultipartFile file : files) {
				if (file != null && !file.isEmpty()) {
					hasFile = true;
					break;
				}
			}
			if (!hasFile) {
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("没有选择上传的文件");
			}

			return tourService.uploadImg(map, files, filePath);

		} catch (Exception e) {
			log.error(
					"TourController uploadImg--------->" + e.getMessage(),
					e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	/**
	 * App 任务接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selTaskAllByUserId")
	@ResponseBody
	public BaseTransferEntity selTaskAllByUserId(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> lst = new HashMap<String, Object>();

		try {
			String userId = request.getParameter("userId");
			// 1 巡视 2检修 3 报修
			String stat = request.getParameter("stat");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("userId", userId);
			
			if (stat != null && !stat.isEmpty()) {
				map.put("stat", stat);
			}else {
				map.put("stat", 0);
			}

			lst = tourService.selTaskAllByUserId(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selTaskAllByUserId--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}
	
	
	/**
	 * 运维模块 查询 本公司及下级公司 所有运维人员   选择执行人时用此接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selUserNameTour")
	@ResponseBody
	public BaseTransferEntity selUserNameTour(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		
		List<Map<String, Object>> lst = new ArrayList<Map<String,Object>>();
		
		try {
			//通过前台 获取用户id
			String user_id = request.getParameter("user_id");
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			if (user_id != null && !user_id.isEmpty()) {
				
				map.put("use_id",user_id);
			
			}else{
				//后台 session 中 获取用户id
				map.put("use_id",this.getCurrentUserId(request));
			}
			
			lst = tourService.selUserNameTour(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selUserNameTour--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}
	
	/**
	 * 运维模块 查询 本公司及上级公司 所有运维人员   选择审核人时用此接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/selUserNameTourCheck")
	@ResponseBody
	public BaseTransferEntity selUserNameTourCheck(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		
		List<Map<String, Object>> lst = new ArrayList<Map<String,Object>>();
		
		try {
			
			//通过前台 获取用户id
			String user_id = request.getParameter("user_id");
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			if (user_id != null && !user_id.isEmpty()) {
				
				map.put("use_id",user_id);
			
			}else{
				//后台 session 中 获取用户id
				map.put("use_id",this.getCurrentUserId(request));
			}
			
			lst = tourService.selUserNameTourCheck(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController selUserNameTourCheck--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}
	
	/**
	 * 运维模块 查询本公司所有运维人员   
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getOptUseInfInComLstByOptId")
	@ResponseBody
	public BaseTransferEntity getOptUseInfInComLstByOptId(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		List<Map<String, Object>> lst = new ArrayList<Map<String,Object>>();
		
		try {
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("use_id",this.getCurrentUserId(request));
			
			lst = utilsService.getOptUseInfInComLstByOptId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController getOptUseInfInComLstByOptId--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}
	/**
	 * 运维模块 查询本公司所有人员 (后增加的的接口)   
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getComPanyUserName")
	@ResponseBody
	public BaseTransferEntity getComPanyUserName(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		List<Map<String, Object>> lst = new ArrayList<Map<String,Object>>();
		
		try {
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("use_id",this.getCurrentUserId(request));
			//map.put("use_id", 1);
			
			lst = tourService.getComPanyUserName(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController getComPanyUserName--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}
	
	/**
	 * 运维模块 查询本公司所有人员 App (后增加的的接口)   
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getComPanyUserNameApp")
	@ResponseBody
	public BaseTransferEntity getComPanyUserNameApp(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		List<Map<String, Object>> lst = new ArrayList<Map<String,Object>>();
		//通过前台 获取用户id
		String use_id = request.getParameter("use_id");
		try {
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("use_id",use_id);
			//map.put("use_id", 1);
			
			lst = tourService.getComPanyUserName(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error(
					"TourController getComPanyUserNameApp--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}

}
