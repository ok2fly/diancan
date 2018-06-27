/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.operations.tour;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.qinergy.controller.operations.tour.TourPlanTime;
import com.qinergy.dao.operations.tour.TourDao;
import com.qinergy.dao.others.OthersDao;
import com.qinergy.dao.system.SystemDao;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.PropertiesUtil;
import com.qinergy.util.SpringContextUtil;

/**
 * 
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author -.-- .- -. --. --.. .. .- -.
 * @version 1.0
 * @since 1.0
 */

@Service
public class TourServiceImpl implements TourService {



	@Autowired
	TourDao tourDao;

	@Autowired
	OthersDao othersDao;

	@Autowired
	SystemDao systemDao;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	

	public List<Map<String, Object>> getrouteByPws(Map<String, Object> map)
			throws Exception {
		return tourDao.getrouteByPws(map);
	}

	public List<Map<String, Object>> getTourPwsByComId(Map<String, Object> map)
			throws Exception {
		return tourDao.getTourPwsByComId(map);
	}

	public List<Map<String, Object>> getTourRecordByRoute(
			Map<String, Object> map) throws Exception {
		return tourDao.getTourRecordByRoute(map);
	}

	/**
	 *  根据 路线名称 查询 巡视路线
	 */
	public List<Map<String, Object>> selTourRoteByName(Map<String, Object> map)
			throws Exception {
		return tourDao.selTourRoteByName(map);
	}

	/**
	 *  路线添加
	 */
	@Transactional
	public void InsertRouteName(Map<String, Object> map) throws Exception {

		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"添加了一条新的巡视路线。");
		mapNot.put("use_id", map.get("use_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		Map<String, Object> mapRouteNam = new HashMap<String, Object>();

		mapRouteNam.put("crate_name_id", map.get("use_id"));

		mapRouteNam.put("crate_time", map.get("crate_time"));

		mapRouteNam.put("route_name", map.get("route_name"));

		// 添加路线
		tourDao.insertRouteNam(mapRouteNam);

		// 查询路线刚添加的一条数据
		List<Map<String, Object>> listRouteNamList = tourDao.getRouteNamNew(map);

		if (map.get("pws_id") != null && !map.get("pws_id").toString().isEmpty()) {

			String[] pwsIds = map.get("pws_id").toString().split("-");

			String[] sorts = map.get("sort").toString().split("-");

			if (pwsIds != null) {

				for (int i = 0; i < pwsIds.length; i++) {

					Map<String, Object> mapRoute = new HashMap<String, Object>();

						mapRoute.put("crt_use_id",listRouteNamList.get(0).get("crate_name_id"));

						mapRoute.put("crt_tim",listRouteNamList.get(0).get("crate_time"));

						mapRoute.put("route_name_id", listRouteNamList.get(0).get("id"));

						mapRoute.put("pws_id", pwsIds[i]);

						mapRoute.put("route_sort", sorts[i]);

						// 添加路线节点
						tourDao.insertRoute(mapRoute);

				}
			}
		}
	}

	/**
	 *  路线删除
	 */
	@Transactional
	public void delRouteNam(Map<String, Object> map) throws Exception {

		Map<String, Object> mapRouteNam = new HashMap<String, Object>();

		mapRouteNam.put("route_name_id", map.get("route_name_id"));

		// 删除路线表
		tourDao.delRouteNam(mapRouteNam);

		Map<String, Object> mapRoute = new HashMap<String, Object>();

		mapRoute.put("id", map.get("id"));

		// 删除路线节点表
		tourDao.delRoute(mapRoute);
	}

	/**
	 *  id查询路线 回显示
	 */
	@Transactional
	public List<Map<String, Object>> getRouteById(Map<String, Object> map)
			throws Exception {

		return tourDao.getRouteById(map);

	}

	/**
	 *  路线 更新
	 */
	@Transactional
	public List<Map<String, Object>> updRoute(Map<String, Object> map)
			throws Exception {

		return tourDao.updRoute(map);

	}

	/**
	 *  记录 添加
	 */
	@Transactional
	public List<Map<String, Object>> insertRecord(Map<String, Object> map)
			throws Exception {

		return tourDao.insertRecord(map);

	}

	/**
	 *  记录 删除
	 */
	@Transactional
	public List<Map<String, Object>> delRecord(Map<String, Object> map)
			throws Exception {

		return tourDao.delRecord(map);

	}

	/**
	 *  记录 id查询
	 */
	@Transactional
	public List<Map<String, Object>> getRecordById(Map<String, Object> map)
			throws Exception {

		return tourDao.getRecordById(map);

	}

	/**
	 *  记录 更新
	 */
	@Transactional
	public List<Map<String, Object>> updRecord(Map<String, Object> map)
			throws Exception {

		return tourDao.updRecord(map);

	}

	/**
	 *  检修 根据电站获取所有检修路线
	 */
	@Transactional
	public List<Map<String, Object>> getOverhaulRouteByPws(
			Map<String, Object> map) throws Exception {

		return tourDao.getOverhaulRouteByPws(map);

	}

	/**
	 *  检修 根据电站获取所有检修路线
	 */
	@Transactional
	public List<Map<String, Object>> getOverhaulTourRecordByRoute(
			Map<String, Object> map) throws Exception {

		return tourDao.getOverhaulTourRecordByRoute(map);

	}

	/**
	 * 根据路线名称 查询 检修路线
	 */
	@Transactional
	public List<Map<String, Object>> selOverhaulRoteByName(
			Map<String, Object> map) throws Exception {

		return tourDao.selOverhaulRoteByName(map);

	}

	/**
	 *  检修 路线添加
	 */
	@Transactional
	public void InsertOverhaulRouteName(Map<String, Object> map)
			throws Exception {

		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"添加了一条新的检修路线。");
		mapNot.put("use_id", map.get("use_id"));
		mapNot.put("crt_tim", new Date());
		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		Map<String, Object> mapRouteNam = new HashMap<String, Object>();

		mapRouteNam.put("crate_name_id", map.get("use_id"));

		mapRouteNam.put("crate_time", map.get("crate_time"));

		mapRouteNam.put("route_name", map.get("route_name"));

		// 添加路线
		tourDao.insertOverhaulRouteNam(mapRouteNam);

		// 查询路线刚添加的一条数据
		List<Map<String, Object>> listRouteNamList = tourDao.getOverhaulRouteNamNew(map);

		if (map.get("pws_id") != null && !map.get("pws_id").toString().isEmpty()) {

			String[] pwsIds = map.get("pws_id").toString().split("-");

			String[] sorts = map.get("sort").toString().split("-");

			if (pwsIds != null) {

				for (int i = 0; i < pwsIds.length; i++) {

					Map<String, Object> mapRoute = new HashMap<String, Object>();

					mapRoute.put("crt_use_id",listRouteNamList.get(0).get("crate_name_id"));
					
					mapRoute.put("crt_tim",listRouteNamList.get(0).get("crate_time"));
					
					mapRoute.put("route_name_id",listRouteNamList.get(0).get("id"));

					mapRoute.put("pws_id", pwsIds[i]);
					
					mapRoute.put("route_sort", sorts[i]);

					// 添加路线节点
					tourDao.insertOverhaulRoute(mapRoute);

				}

			}

		}

	}

	/**
	 *  检修路线删除
	 */
	@Transactional
	public List<Map<String, Object>> delOverhaulRouteNam(Map<String, Object> map)
			throws Exception {

		Map<String, Object> mapRouteNam = new HashMap<String, Object>();

		mapRouteNam.put("route_name_id", map.get("route_name_id"));

		// 删除路线表
		tourDao.delOverhaulRouteNam(mapRouteNam);

		Map<String, Object> mapRoute = new HashMap<String, Object>();

		mapRoute.put("id", map.get("id"));

		// 删除路线节点表
		return tourDao.delOverhaulRoute(mapRoute);

	}

	/**
	 *  id查询检修路线 回显示
	 */
	@Transactional
	public List<Map<String, Object>> getOverhaulRouteById(
			Map<String, Object> map) throws Exception {

		return tourDao.getOverhaulRouteById(map);

	}

	/**
	 *  检修路线 更新
	 */
	@Transactional
	public List<Map<String, Object>> updOverhaulRoute(Map<String, Object> map)
			throws Exception {

		return tourDao.updOverhaulRoute(map);

	}

	/**
	 *  检修记录添加
	 */
	@Transactional
	public List<Map<String, Object>> insertOverhaulRecord(
			Map<String, Object> map) throws Exception {

		return tourDao.insertOverhaulRecord(map);

	}

	/**
	 *  检修记录 删除
	 */
	@Transactional
	public List<Map<String, Object>> delOverhaulRecord(Map<String, Object> map)
			throws Exception {

		return tourDao.delOverhaulRecord(map);

	}

	/**
	 *  id查看检修记录
	 */
	@Override
	public List<Map<String, Object>> getOverhaulRecordById(
			Map<String, Object> map) throws Exception {
		return tourDao.getOverhaulRecordById(map);
	}

	/**
	 *  检修记录 更新
	 */
	@Override
	public List<Map<String, Object>> updOverhaulRecord(Map<String, Object> map)
			throws Exception {
		return tourDao.updOverhaulRecord(map);
	}

	/**
	 *  根据巡视路线id 获取计划列表
	 */
	@Override
	public List<Map<String, Object>> getTourPlanByroutId(Map<String, Object> map)
			throws Exception {
		return tourDao.getTourPlanByroutId(map);
	}

	/**
	 *  根据巡视计划id 获取任务
	 */
	@Override
	public List<Map<String, Object>> getTaskByPlanId(Map<String, Object> map)
			throws Exception {
		return tourDao.getTaskByPlanId(map);
	}

	/**
	 *  根据检修路线id 获取计划列表
	 */
	@Override
	public List<Map<String, Object>> getOverhaulPlanByroutId(
			Map<String, Object> map) throws Exception {
		return tourDao.getOverhaulPlanByroutId(map);
	}

	/**
	 *  根据检修计划 获取任务
	 */
	@Override
	public List<Map<String, Object>> getOverhaulTaskByPlanId(
			Map<String, Object> map) throws Exception {
		return tourDao.getOverhaulTaskByPlanId(map);
	}

	/**
	 *  根据用户id查看与自己有关的报修任务
	 */
	public List<Map<String, Object>> getRepairByUserId(Map<String, Object> map)
			throws Exception {
		return tourDao.getRepairByUserId(map);
	}

	/**
	 *  报修任务添加
	 */
	public List<Map<String, Object>> insertRepairTask(Map<String, Object> map)
			throws Exception {
		return tourDao.insertRepairTask(map);
	}

	/**
	 *  报修任务添加
	 */
	public List<Map<String, Object>> insertRepairTaskImg(Map<String, Object> map)
			throws Exception {
		return tourDao.insertRepairTaskImg(map);
	}

	// ***************************巡视**********************************************************
	/**
	 *  查看巡视路线
	 */
	public List<Map<String, Object>> getTourRouteNam(Map<String, Object> map)
			throws Exception {
		return tourDao.getTourRouteNam(map);
	}

	/**
	 *  查看巡视路线 分页
	 */
	public Map<String, Object> selTourRouteNameCou(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = tourDao.selTourRouteNameCou(map);

		if (lstMap != null && lstMap.size() > 0) {

			for (Map<String, Object> retMap : lstMap) {

				return retMap;
			}
		}
		return null;
	}

	/**
	 *  查看检修路线
	 */
	public List<Map<String, Object>> getOverhaulRouteNam(Map<String, Object> map)
			throws Exception {
		return tourDao.getOverhaulRouteNam(map);
	}

	/**
	 *  添加巡视路线
	 */
	public List<Map<String, Object>> insertRouteOrOverhaul(
			Map<String, Object> map) throws Exception {

		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		// 类型 检修
		if (map.get("type").equals("1")) {
			// 添加检修
			lstMap = tourDao.insertOverhaulRoute(map);

		} else if (map.get("type").equals("2")) {
			// 添加巡视路线
			lstMap = tourDao.insertRoute(map);
		}
		return lstMap;

	}

	/**
	 *  删除路线
	 */
	public List<Map<String, Object>> delRouteOrOverhaul(Map<String, Object> map)
			throws Exception {

		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		// 类型 检修
		if (map.get("type").equals("1")) {
			// 检修
			lstMap = tourDao.delOverhaulRouteNam(map);

		} else if (map.get("type").equals("2")) {
			// 巡视路线
			lstMap = tourDao.delRouteNam(map);

		}
		return lstMap;

	}

	/**
	 *  检修路线 分页
	 */
	public Map<String, Object> selOverhaulRouteNameCou(Map<String, Object> map)
			throws Exception {

		List<Map<String, Object>> retLst = tourDao.selOverhaulRouteNameCou(map);

		if (retLst != null && retLst.size() > 0) {

			for (Map<String, Object> retMap : retLst) {

				return retMap;
			}
		}
		return null;
	}

	/**
	 *  查询
	 */
	public List<Map<String, Object>> selTourOrOverhaulByName(
			Map<String, Object> map) throws Exception {

		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();

		// 类型 检修
		if (map.get("type").equals("1")) {

			// 查询所有检修路线
			List<Map<String, Object>> listOverhaulRouteNameLst = tourDao.selOverhaulRouteName(map);

			// 查询所有检修路线节点

			if (listOverhaulRouteNameLst != null
					&& !listOverhaulRouteNameLst.isEmpty()) {

				for (Map<String, Object> listTourRouteNameMap : listOverhaulRouteNameLst) {

					List<Map<String, Object>> overhaulRouteLst = tourDao.selOverhaulRoute(listTourRouteNameMap);

					listTourRouteNameMap.put("overhauRouteLst",overhaulRouteLst);
				}
			}

			lstMap.addAll(listOverhaulRouteNameLst);

			// 类型 巡视
		} else if (map.get("type").equals("2")) {

			// 查询所有巡视路线
			List<Map<String, Object>> listTourRouteNameLst = tourDao.selTourRouteName(map);

			// 查询所有巡视路线节点

			if (listTourRouteNameLst != null && !listTourRouteNameLst.isEmpty()) {

				for (Map<String, Object> listTourRouteNameMap : listTourRouteNameLst) {

					List<Map<String, Object>> tourRouteLst = tourDao.selTourRoute(listTourRouteNameMap);

					listTourRouteNameMap.put("tourRouteLst", tourRouteLst);
				}
			}

			lstMap.addAll(listTourRouteNameLst);

		}
		return lstMap;
	}

	/**
	 *  根据路线id查询巡视路线的电站经纬度
	 */
	public List<Map<String, Object>> selRouteOrOverhaulNamePwsByRouteNameId(
			Map<String, Object> map) throws Exception {

		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		// 类型 检修
		if (map.get("type").equals("1")) {
			// 检修
			lstMap = tourDao.selOverhaulNamePwsByRouteNameId(map);

		} else if (map.get("type").equals("2")) {
			// 巡视路线
			lstMap = tourDao.selRouteNamePwsByRouteNameId(map);
		}
		return lstMap;

	}

	/**
	 *  查看巡视任务
	 */
	public List<Map<String, Object>> selRouteTask(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();

		Map<String,Object> newMap = new HashMap<String, Object>();
		
		lstMap = tourDao.selRouteTask(map);
		
		for (int i = 0; i < lstMap.size(); i++) {
			// 如果 审核状态为 5 审核通过  那么 驳回原因 设置为 空
			if (lstMap.get(i).get("task_sta").equals(5)) {

				lstMap.get(i).put("task_reject_reason", null);

			}
		}

		System.out.println(lstMap);

		return lstMap;

	}

	/**
	 *  查看巡视任务 分页
	 */
	public Map<String, Object> selRouteTaskCou(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();

		lstMap = tourDao.selRouteTaskCou(map);

		System.out.println(lstMap);

		if (lstMap != null && lstMap.size() > 0) {

			for (Map<String, Object> retMap : lstMap) {

				return retMap;
			}
		}

		return null;

	}

	/**
	 *  查看巡视任务 type
	 */
	public List<Map<String, Object>> selRouteTaskType(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();

		Map<String, Object> mapNew = new HashMap<String, Object>();
		List<Map<String, Object>> lstNewMap = new ArrayList<Map<String, Object>>();

		lstMap = tourDao.selRouteTaskType(map);

		System.out.println(lstMap);

		for (Map<String, Object> routeMap : lstMap) {

			if (routeMap.get("task_execute_id").equals(
					map.get("task_execute_id"))) {

				mapNew.put("typeNew", 1);

				lstNewMap.add(mapNew);
			}
			if (routeMap.get("appoint_id").equals(map.get("appoint_id"))) {

				mapNew.put("typeNew", 2);

				lstNewMap.add(mapNew);
			}
			if (routeMap.get("task_check_id").equals(map.get("task_check_id"))) {

				mapNew.put("typeNew", 3);

				lstNewMap.add(mapNew);
			}
		}
		lstMap.addAll(lstNewMap);

		return lstMap;

	}

	/**
	 *  巡视任务 审核通过
	 */
	@Transactional
	public List<Map<String, Object>> updTourTaskStaCheck(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();

		lstMap = tourDao.updTourTaskStaCheck(map);

		//通过  创建人id 和任务id 查询改流程的记录   开始  是否存在
		
		Map<String,Object> newMap = new HashMap<String, Object>();
		
		newMap.put("tour_task_id",map.get("id").toString());
		newMap.put("tour_people_id",map.get("userId").toString());
		//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
		newMap.put("task_stat",5);
		
		 List<Map<String, Object>> lstRecord = tourDao.selTourRecordProcess(newMap);
		 
		//添加任务流程 开始 记录
		Map<String,Object> recordMap = new HashMap<String, Object>();
			
		if (lstRecord != null && !lstRecord.isEmpty()) {
			
			recordMap.put("sta_tim",new Date());
			recordMap.put("id",lstRecord.get(0).get("id").toString());
			tourDao.updTourRecordProcess(recordMap);
			
		}else {

			recordMap.put("sta_time",new Date());
			recordMap.put("tour_people_id",map.get("userId"));
			//是否完成（0是  1否）
			recordMap.put("tour_complete",0);
			recordMap.put("tour_task_id",map.get("id"));
			//recordMap.put("tour_route_id",map.get("tour_route_id"));
			recordMap.put("remark","该巡视任务审核已通过。");
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			recordMap.put("task_stat",5);
			
			tourDao.insertTourRecordProcess(recordMap);
		}
				
		
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您有一条巡视任务在"+format.format(new Date())+"已经通过审核。");
		mapNot.put("use_id", map.get("task_check_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  巡视任务 驳回
	 */
	@Transactional
	public List<Map<String, Object>> updTourTaskStaReject(
			Map<String, Object> map) throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updTourTaskStaReject(map);
		
		
		//添加任务流程  记录
		Map<String,Object> recordMap = new HashMap<String, Object>();

		recordMap.put("sta_time",new Date());
		recordMap.put("tour_people_id",map.get("userId"));
		//是否完成（0是  1否）
		recordMap.put("tour_complete",0);
		recordMap.put("tour_task_id",map.get("id"));
		//recordMap.put("tour_route_id",map.get("tour_route_id"));
		recordMap.put("remark","该巡视任务已被驳回，驳回原因是："+map.get("task_reject_reason")+",请重新提交待审核。");
		//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
		recordMap.put("task_stat",4);
		
		tourDao.insertTourRecordProcess(recordMap);
	
					
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con","您有一条巡视任务在"+format.format(new Date())+"被驳回，驳回原因是:" + map.get("task_reject_reason"));
		mapNot.put("use_id", map.get("use_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  巡视任务 开始任务
	 */
	@Transactional
	public List<Map<String, Object>> updTourTaskStaExecute(
			Map<String, Object> map) throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updTourTaskStaExecute(map);
		//通过  创建人id 和任务id 查询改流程的记录   开始  是否存在
		
		Map<String,Object> newMap = new HashMap<String, Object>();
		
		newMap.put("tour_task_id",map.get("id").toString());
		newMap.put("tour_people_id",map.get("task_execute_id").toString());
		newMap.put("task_stat",1);
		
		 List<Map<String, Object>> lstRecord = tourDao.selTourRecordProcess(newMap);
		 
		//添加任务流程 开始 记录
		Map<String,Object> recordMap = new HashMap<String, Object>();
			
		if (lstRecord != null && !lstRecord.isEmpty()) {
			
			recordMap.put("sta_tim",new Date());
			recordMap.put("id",lstRecord.get(0).get("id").toString());
			tourDao.updTourRecordProcess(recordMap);
			
		}else {

			recordMap.put("sta_time",new Date());
			recordMap.put("tour_people_id",map.get("task_execute_id"));
			//是否完成（0是  1否）
			recordMap.put("tour_complete",0);
			recordMap.put("tour_task_id",map.get("id"));
			//recordMap.put("tour_route_id",map.get("tour_route_id"));
			recordMap.put("remark","任务流程已开始，请记录信息。");
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			recordMap.put("task_stat",1);
			
			tourDao.insertTourRecordProcess(recordMap);
		}
		
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您有一条巡视任务，在"+format.format(new Date())+"已经开始，请注意查看。");
		mapNot.put("use_id", map.get("task_execute_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  巡视任务 删除
	 */
	public List<Map<String, Object>> delTourTaskSta(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.delTourTaskSta(map);
		return lstMap;

	}

	/**
	 *  巡视记录 查看最新的
	 */
	public List<Map<String, Object>> selRouteTaskById(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selRouteTaskById(map);
		return lstMap;

	}

	/**
	 *  巡视任务 新增
	 */
	@Transactional
	public List<Map<String, Object>> insTourTask(Map<String, Object> map)
			throws Exception {

		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();

		// 任务新增
		lstMap = tourDao.insTourTask(map);

		// 添加系统消息
		Map<String,Object> nameMap = new HashMap<String, Object>();
		nameMap.put("id",map.get("appoint_id"));
		List<Map<String,Object>> userNameMap = tourDao.selUserNameById(nameMap);
		
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con","用户："+userNameMap.get(0).get("use_nam")+",在"+format.format(new Date())
				+ "指派给您一条新的巡视任务，请注意及时查看。");
		mapNot.put("use_id", map.get("task_execute_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  巡视任务 查看任务记录
	 */
	public Map<String, Object> selTaskRecord(Map<String, Object> map)
			throws Exception {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		Map<String, Object> mapRoute = new HashMap<String, Object>();

		mapRoute.put("tour_task_id", map.get("tour_task_id"));

		// 根据任务id 查询 路线名称 和 任务状态
		List<Map<String, Object>> routeMap = tourDao.selRouteNameById(mapRoute);
		resultMap.put("routeMap", routeMap);

		Map<String, Object> mapRecord = new HashMap<String, Object>();

		mapRecord.put("tour_route_id", map.get("tour_route_id"));
		// 路线id 查询 节点站信息
		List<Map<String, Object>> recordMap = tourDao.selRouteById(mapRecord);

		if (recordMap != null & !recordMap.isEmpty()) {

			for (int i = 0; i < recordMap.size(); i++) {
				Map<String, Object> record = recordMap.get(i);
				String id = record.get("id").toString();

				Map<String, Object> routeNameMap = new HashMap<String, Object>();
				routeNameMap.put("tour_route_id", id);
				routeNameMap.put("tour_task_id", map.get("tour_task_id"));
				// 根据 任务id 路线节点id 查询节点 站信息状态
				List<Map<String, Object>> recordSta = tourDao.selTourRecordByTaskRoute(routeNameMap);
				
				if (recordSta != null & !recordSta.isEmpty()) {
					
					record.put("tour_complete",recordSta.get(0).get("tour_complete"));
				} else {

					record.put("tour_complete", 1);

				}

			}
		}

		resultMap.put("recordMap", recordMap);
		return resultMap;

	}

	/**
	 *  巡视任务 查看任务记录
	 */
	public Map<String, Object> selTaskRecordAll(Map<String, Object> map)
			throws Exception {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<Map<String, Object>> routeMap = tourDao.selTourAllRecord(map);
		
		for (int i = 0; i < routeMap.size(); i++) {
			
			if (routeMap.get(i).containsKey("pws_nam")){
				
				if (routeMap.get(i).get("pws_nam").toString() !=null && !routeMap.get(i).get("pws_nam").toString().isEmpty()) {
					routeMap.get(i).put("pws_nam",routeMap.get(i).get("pws_nam"));
				}else {
					routeMap.get(i).put("pws_nam","其他");
				}
				
			}else {
				routeMap.get(i).put("pws_nam","其他");
			}
		}

		for (int i = 0; i < routeMap.size(); i++) {
			
			Map<String, Object> img = routeMap.get(i);

			Map<String, Object> imgMap = new HashMap<String, Object>();
			imgMap.put("treId", img.get("id"));
			// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
			imgMap.put("imageType", 2);
			List<Map<String, Object>> imgLst = tourDao.selTourImgByRouteId(imgMap);

			if (imgLst != null && !imgLst.isEmpty()) {
			
				img.put("imgLst", imgLst);
			}

			Map<String, Object> fileMap = new HashMap<String, Object>();
			fileMap.put("treId", img.get("id"));
			// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
			fileMap.put("fileType", 2);
			List<Map<String, Object>> filLst = tourDao.selTourFileByRouteId(fileMap);
			
			if (filLst != null && !filLst.isEmpty()) {
			
				// img.put("filLst", filLst);
				img.put("imgLst", filLst);
			}

		}

		resultMap.put("routeMap", routeMap);
		return resultMap;

	}

	/**
	 *  巡视任务 记录添加/修改
	 */
	@Transactional
	public Map<String, Object> updOrInsTourRecord(Map<String, Object> map)
			throws Exception {
		Map<String, Object> lstMap = new HashMap<String, Object>();

		Map<String, Object> mapRecord = new HashMap<String, Object>();

		mapRecord.put("treId", map.get("treId"));

		// 通过记录id 查看是否有此记录
		List<Map<String, Object>> recordLst = tourDao.selTourRecordByRouteId(mapRecord);

		if (!recordLst.isEmpty() && recordLst != null) {

			Map<String, Object> mapUpdRecord = new HashMap<String, Object>();

			mapUpdRecord.put("sta_time", map.get("sta_time"));
			mapUpdRecord.put("end_time", map.get("end_time"));
			mapUpdRecord.put("tour_people_id", map.get("tour_people_id"));
			mapUpdRecord.put("tour_complete", map.get("tour_complete"));
			mapUpdRecord.put("remark", map.get("remark"));
			mapUpdRecord.put("treId", map.get("treId"));

			// 修改
			tourDao.updTourRecord(mapUpdRecord);

			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在"+format.format(new Date())+"修改了一条巡视记录");
			mapNot.put("use_id", map.get("tour_people_id"));
			mapNot.put("crt_tim", new Date());

			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);

		} else {

			Map<String, Object> mapInsRecord = new HashMap<String, Object>();

			mapInsRecord.put("sta_time", map.get("sta_time"));
			mapInsRecord.put("end_time", map.get("end_time"));
			mapInsRecord.put("tour_route_id", map.get("tour_route_id"));
			mapInsRecord.put("tour_people_id", map.get("tour_people_id"));
			mapInsRecord.put("tour_complete", map.get("tour_complete"));
			mapInsRecord.put("remark", map.get("remark"));
			mapInsRecord.put("tour_task_id", map.get("tour_task_id"));
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			mapInsRecord.put("task_stat",2);

			// 添加
			tourDao.insTourRecord(mapInsRecord);

			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在"+format.format(new Date())+"添加了一条新的巡视记录");
			mapNot.put("use_id", map.get("tour_people_id"));
			mapNot.put("crt_tim", new Date());

			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);

		}

		return lstMap;

	}

	/**
	 *  巡视任务 通过记录id查看记录
	 */
	public Map<String, Object> selTourRecordByRouteId(Map<String, Object> map)
			throws Exception {

		// 根据记录id查看巡视记录
		List<Map<String, Object>> lstMap = tourDao.selTourRecordByRouteId(map);

		Map<String, Object> fileMap = new HashMap<String, Object>();
		fileMap.put("treId", map.get("treId"));
		// 文件类型（1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
		fileMap.put("fileType", 2);
		// 查询 文件
		List<Map<String, Object>> lstFile = tourDao.selTourFileByRouteId(fileMap);

		Map<String, Object> imageMap = new HashMap<String, Object>();
		// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
		imageMap.put("treId", map.get("treId"));
		imageMap.put("imageType", 2);
		// 查询 图片
		List<Map<String, Object>> lstImg = tourDao.selTourImgByRouteId(imageMap);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lstMap", lstMap);
		resultMap.put("lstFile", lstFile);
		resultMap.put("lstImg", lstImg);

		return resultMap;

	}

	/**
	 *  巡视任务 指派
	 */
	@Transactional
	public List<Map<String, Object>> tourTaskAppoint(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.tourTaskAppoint(map);

		// 添加系统消息
		Map<String,Object> nameMap = new HashMap<String, Object>();
		nameMap.put("id",map.get("userId"));
		//获取用户名称
		List<Map<String,Object>> userNameMap = tourDao.selUserNameById(nameMap);
		
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con","用户："+userNameMap.get(0).get("use_nam")+",在"+format.format(new Date())
				+ "指派给您一条新的巡视任务，请注意及时查看。");

		mapNot.put("use_id", map.get("task_execute_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  巡视任务 提交
	 */
	@Transactional
	public List<Map<String, Object>> tourTaskSubmit(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.tourTaskSubmit(map);

		//通过  创建人id 和任务id 查询改流程的记录   开始  是否存在
		Map<String,Object> newMap = new HashMap<String, Object>();
		
		newMap.put("tour_task_id",map.get("id").toString());
		newMap.put("tour_people_id",map.get("userId").toString());
		//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
		newMap.put("task_stat",3);
		
		 List<Map<String, Object>> lstRecord = tourDao.selTourRecordProcess(newMap);
		 
		//添加任务流程 开始 记录
		Map<String,Object> recordMap = new HashMap<String, Object>();
			
		if (lstRecord != null && !lstRecord.isEmpty()) {
			recordMap.put("sta_tim",new Date());
			recordMap.put("id",lstRecord.get(0).get("id").toString());
			tourDao.updTourRecordProcess(recordMap);
		}else {
			recordMap.put("sta_time",new Date());
			recordMap.put("tour_people_id",map.get("userId"));
			//是否完成（0是  1否）
			recordMap.put("tour_complete",0);
			recordMap.put("tour_task_id",map.get("id"));
			recordMap.put("remark","该巡视任务记录已添加完成，已提交待审核。");
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			recordMap.put("task_stat",3);
			tourDao.insertTourRecordProcess(recordMap);
		}
		
		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"有一条新的巡视任务待审核，请注意查看。");
		mapNot.put("use_id", map.get("task_check_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  巡视任务 更新
	 */
	@Transactional
	public List<Map<String, Object>> updTourTaskById(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updTourTaskById(map);

		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"有一条新的巡视任务需要执行，请注意查看");
		mapNot.put("use_id", map.get("task_execute_id"));
		mapNot.put("crt_tim", new Date());
		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  巡视任务 回显
	 */
	public List<Map<String, Object>> selTourTaskById(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selTourTaskById(map);
		return lstMap;

	}

	/**
	 *  查看检修任务
	 */
	public List<Map<String, Object>> selOverhaulTask(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selOverhaulTask(map);
		
		for (int i = 0; i < lstMap.size(); i++) {
			// 如果 审核状态为 5 审核通过 驳回原因 置空
			if (lstMap.get(i).get("task_sta").equals(5)) {

				lstMap.get(i).put("task_reject_reason", null);

			}
		}
		
		return lstMap;

	}

	/**
	 *  查看检修任务 分页
	 */
	public Map<String, Object> selOverhaulTaskCou(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selOverhaulTaskCou(map);

		if (lstMap != null && lstMap.size() > 0) {

			for (Map<String, Object> retMap : lstMap) {

				return retMap;
			}
		}
		return null;

	}

	/**
	 *  检修任务 审核通过
	 */
	@Transactional
	public List<Map<String, Object>> updOverhaulTaskStaCheck(
			Map<String, Object> map) throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updOverhaulTaskStaCheck(map);

		//通过  创建人id 和任务id 查询改流程的记录   开始  是否存在
		Map<String,Object> newMap = new HashMap<String, Object>();
		
		newMap.put("tour_task_id",map.get("id").toString());
		newMap.put("tour_people_id",map.get("userId").toString());
		//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
		newMap.put("task_stat",5);
		
		 List<Map<String, Object>> lstRecord = tourDao.selOverhaulRecordProcess(newMap);
		 
		//添加任务流程 开始 记录
		Map<String,Object> recordMap = new HashMap<String, Object>();
			
			
		if (lstRecord != null && !lstRecord.isEmpty()) {
			
			recordMap.put("sta_tim",new Date());
			recordMap.put("id",lstRecord.get(0).get("id").toString());
			tourDao.updOverhaulRecordProcess(recordMap);
			
		}else {

			recordMap.put("sta_time",new Date());
			recordMap.put("tour_people_id",map.get("userId"));
			//是否完成（0是  1否）
			recordMap.put("tour_complete",0);
			recordMap.put("tour_task_id",map.get("id"));
			recordMap.put("remark","该检修任务审核已通过。");
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			recordMap.put("task_stat",5);
			
			tourDao.insertOverhaulRecordProcess(recordMap);
		}
		
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您有一条检修任务在"+format.format(new Date())+"已经通过审核。");
		mapNot.put("use_id", map.get("task_check_id"));
		mapNot.put("crt_tim", new Date());
		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  检修任务 驳回
	 */
	@Transactional
	public List<Map<String, Object>> updOverhaulTaskStaReject(
			Map<String, Object> map) throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updOverhaulTaskStaReject(map);
	
		//添加任务流程 开始 记录
		Map<String,Object> recordMap = new HashMap<String, Object>();

		recordMap.put("sta_time",new Date());
		recordMap.put("tour_people_id",map.get("userId"));
		//是否完成（0是  1否）
		recordMap.put("tour_complete",0);
		recordMap.put("tour_task_id",map.get("id"));
		recordMap.put("remark","您有一条检修任务已被驳回，驳回原因是："+map.get("task_reject_reason")+",请重新提交待审核。");
		//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
		recordMap.put("task_stat",4);
		tourDao.insertOverhaulRecordProcess(recordMap);
	
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con","您有一个检修任务在"+format.format(new Date())+"被驳回，驳回原因是" + map.get("task_reject_reason"));
		
		mapNot.put("use_id", map.get("task_check_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);
		

		return lstMap;

	}

	/**
	 *  检修任务 开始任务
	 */
	@Transactional
	public List<Map<String, Object>> updOverhaulTaskStaExecute(
			Map<String, Object> map) throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updOverhaulTaskStaExecute(map);
		Map<String,Object> newMap = new HashMap<String, Object>();		
		
		newMap.put("tour_task_id",map.get("id").toString());
		newMap.put("tour_people_id",map.get("task_execute_id").toString());
		//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
		newMap.put("task_stat",1);
		
		//通过  创建人id 和任务id 查询改流程的记录   开始  是否存在
		 List<Map<String, Object>> lstRecord = tourDao.selOverhaulRecordProcess(newMap);
		 
		//添加任务流程 开始 记录
		Map<String,Object> recordMap = new HashMap<String, Object>();
			
			
		if (lstRecord != null && !lstRecord.isEmpty()) {
			
			recordMap.put("sta_tim",new Date());
			recordMap.put("id",lstRecord.get(0).get("id").toString());
			tourDao.updOverhaulRecordProcess(recordMap);
			
		}else {

			recordMap.put("sta_time",new Date());
			recordMap.put("tour_people_id",map.get("task_execute_id"));
			//是否完成（0是  1否）
			recordMap.put("tour_complete",0);
			recordMap.put("tour_task_id",map.get("id"));
			recordMap.put("remark","任务流程已开始，请记录信息。");
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			recordMap.put("task_stat",1);
			
			tourDao.insertOverhaulRecordProcess(recordMap);
		}
		
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您有一条检修任务，在"+format.format(new Date())+"已经开始，请注意执行。");
		mapNot.put("use_id", map.get("task_execute_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  检修任务 删除
	 */
	public List<Map<String, Object>> delOverhaulTaskSta(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.delOverhaulTaskSta(map);
		return lstMap;

	}

	/**
	 *  检修记录 查询最新的
	 */
	public List<Map<String, Object>> selOverhaulNewTaskById(
			Map<String, Object> map) throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selOverhaulNewTaskById(map);
		return lstMap;

	}

	/**
	 *  检修任务 新增
	 */
	@Transactional
	public List<Map<String, Object>> instOverhaulTask(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();

		// 检修任务新增
		lstMap = tourDao.instOverhaulTask(map);
		
		// 添加系统消息
		Map<String,Object> nameMap = new HashMap<String, Object>();
		nameMap.put("id",map.get("appoint_id"));
		List<Map<String,Object>> userNameMap = tourDao.selUserNameById(nameMap);
		
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con","您在"+format.format(new Date())+"有一条新的检修任务，请注意及时查看。");
		
		mapNot.put("use_id", map.get("task_execute_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  检修任务 查看任务记录
	 */
	public Map<String, Object> selOverhaulTaskRecord(Map<String, Object> map)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		Map<String, Object> mapRoute = new HashMap<String, Object>();

		mapRoute.put("tour_task_id", map.get("tour_task_id"));

		// 根据任务id 查询 路线名称 和 任务状态
		List<Map<String, Object>> routeMap = tourDao.selOverhaulRouteNameById(mapRoute);

		resultMap.put("routeMap", routeMap);

		Map<String, Object> mapRecord = new HashMap<String, Object>();

		mapRecord.put("tour_route_id", map.get("tour_route_id"));

		// // 路线id 查询 节点站信息
		List<Map<String, Object>> recordMap = tourDao.selOverhaulRouteById(mapRecord);

		if (recordMap != null & !recordMap.isEmpty()) {

			for (int i = 0; i < recordMap.size(); i++) {
				Map<String, Object> record = recordMap.get(i);
				String id = record.get("id").toString();

				Map<String, Object> routeNameMap = new HashMap<String, Object>();
				routeNameMap.put("tour_route_id", id);
				routeNameMap.put("tour_task_id", map.get("tour_task_id"));
				// 根据 任务id 路线节点id 查询节点 站信息状态
				List<Map<String, Object>> recordSta = tourDao.selOverhaulRecordByTaskRoute(routeNameMap);

				if (recordSta != null & !recordSta.isEmpty()) {
					
					record.put("tour_complete",recordSta.get(0).get("tour_complete"));
					
				} else {

					record.put("tour_complete", 1);

				}

			}
		}

		resultMap.put("recordMap", recordMap);

		return resultMap;

	}

	/**
	 *  检修任务 查看任务记录
	 */
	public Map<String, Object> selOverhaulTaskRecordAll(Map<String, Object> map)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<Map<String, Object>> routeMap = tourDao.selOverhaulAllRecord(map);
		
		for (int i = 0; i < routeMap.size(); i++) {
			
			if (routeMap.get(i).containsKey("pws_nam")){
				
				if (routeMap.get(i).get("pws_nam").toString() !=null && !routeMap.get(i).get("pws_nam").toString().isEmpty()) {
					routeMap.get(i).put("pws_nam",routeMap.get(i).get("pws_nam"));
				}else {
					routeMap.get(i).put("pws_nam","其他");
				}
				
			}else {
				routeMap.get(i).put("pws_nam","其他");
			}
		}

		for (int i = 0; i < routeMap.size(); i++) {
			Map<String, Object> img = routeMap.get(i);

			Map<String, Object> imgMap = new HashMap<String, Object>();
			imgMap.put("treId", img.get("id"));
			// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
			imgMap.put("imageType", 4);
			List<Map<String, Object>> imgLst = tourDao.selTourImgByRouteId(imgMap);

			if (imgLst != null && !imgLst.isEmpty()) {
				img.put("imgLst", imgLst);
			}

			Map<String, Object> fileMap = new HashMap<String, Object>();
			fileMap.put("treId", img.get("id"));
			// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
			fileMap.put("fileType", 4);
			List<Map<String, Object>> filLst = tourDao.selTourFileByRouteId(fileMap);

			if (filLst != null && !filLst.isEmpty()) {

				img.put("imgLst", filLst);
			}

		}

		resultMap.put("routeMap", routeMap);

		return resultMap;

	}

	/**
	 *  检修任务 记录添加/修改
	 */
	@Transactional
	public Map<String, Object> updOrInsOverhaulRecord(Map<String, Object> map)
			throws Exception {
		Map<String, Object> lstMap = new HashMap<String, Object>();

		Map<String, Object> mapRecord = new HashMap<String, Object>();

		mapRecord.put("oreId", map.get("oreId"));

		// 通过记录id 查看是否有此记录
		List<Map<String, Object>> recordLst = tourDao
				.selOverhaulRecordByRouteId(mapRecord);

		if (!recordLst.isEmpty() && recordLst != null) {

			Map<String, Object> mapUpdRecord = new HashMap<String, Object>();

			mapUpdRecord.put("sta_time", map.get("sta_time"));
			mapUpdRecord.put("end_time", map.get("end_time"));
			mapUpdRecord.put("tour_people_id", map.get("tour_people_id"));
			mapUpdRecord.put("tour_complete", map.get("tour_complete"));
			mapUpdRecord.put("remark", map.get("remark"));
			mapUpdRecord.put("oreId", map.get("oreId"));

			// 修改
			tourDao.updateOverhaulRecord(mapUpdRecord);

			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在"+format.format(new Date())+"修改了一条检修记录");
			mapNot.put("use_id", map.get("tour_people_id"));
			mapNot.put("crt_tim", new Date());

			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);

		} else {

			Map<String, Object> mapInsRecord = new HashMap<String, Object>();

			mapInsRecord.put("sta_time", map.get("sta_time"));
			mapInsRecord.put("end_time", map.get("end_time"));
			mapInsRecord.put("tour_route_id", map.get("tour_route_id"));
			mapInsRecord.put("tour_people_id", map.get("tour_people_id"));
			mapInsRecord.put("tour_complete", map.get("tour_complete"));
			mapInsRecord.put("remark", map.get("remark"));
			mapInsRecord.put("tour_task_id", map.get("tour_task_id"));
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			mapInsRecord.put("task_stat",2);

			// 添加
			tourDao.insOverhaulRecord(mapInsRecord);

			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在"+format.format(new Date())+"添加了一条新的检修记录");
			mapNot.put("use_id", map.get("tour_people_id"));
			mapNot.put("crt_tim", new Date());

			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);

		}

		return lstMap;

	}

	/**
	 *  检修任务 记录id查看记录
	 */
	public Map<String, Object> selOverhaulRecordByRouteId(
			Map<String, Object> map) throws Exception {

		// 记录id 查看检修记录
		List<Map<String, Object>> lstMap = tourDao.selOverhaulRecordByRouteId(map);

		Map<String, Object> fileMap = new HashMap<String, Object>();
		fileMap.put("treId", map.get("oreId"));
		// 文件类型（1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
		fileMap.put("fileType", 4);
		// 查询 文件
		List<Map<String, Object>> lstFile = tourDao.selTourFileByRouteId(fileMap);

		Map<String, Object> imageMap = new HashMap<String, Object>();
		// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
		imageMap.put("treId", map.get("oreId"));
		imageMap.put("imageType", 4);
		// 查询 图片
		List<Map<String, Object>> lstImg = tourDao.selTourImgByRouteId(imageMap);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lstMap", lstMap);
		resultMap.put("lstFile", lstFile);
		resultMap.put("lstImg", lstImg);

		return resultMap;

	}

	/**
	 *  检修任务 指派
	 */
	@Transactional
	public List<Map<String, Object>> overhaulTaskAppoint(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.overhaulTaskAppoint(map);

		// 添加系统消息
		Map<String,Object> nameMap = new HashMap<String, Object>();
		nameMap.put("id",map.get("userId"));
		List<Map<String,Object>> userNameMap = tourDao.selUserNameById(nameMap);
		
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con","用户："+userNameMap.get(0).get("use_nam")+",在"+format.format(new Date())
				+ "指派给您一条新的检修任务，请注意及时查看。");
		
		mapNot.put("use_id", map.get("task_execute_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  检修任务 提交
	 */
	@Transactional
	public List<Map<String, Object>> overhaulTaskSubmit(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.overhaulTaskSubmit(map);

		//通过  创建人id 和任务id 查询改流程的记录   开始  是否存在
		
		Map<String,Object> newMap = new HashMap<String, Object>();
		
		newMap.put("tour_task_id",map.get("id").toString());
		newMap.put("tour_people_id",map.get("userId").toString());
		//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
		newMap.put("task_stat",3);
		
		 List<Map<String, Object>> lstRecord = tourDao.selOverhaulRecordProcess(newMap);
		 
		//添加任务流程 开始 记录
		Map<String,Object> recordMap = new HashMap<String, Object>();
			
			
		if (lstRecord != null && !lstRecord.isEmpty()) {
			
			recordMap.put("sta_tim",new Date());
			recordMap.put("id",lstRecord.get(0).get("id").toString());
			tourDao.updOverhaulRecordProcess(recordMap);
			
		}else {

			recordMap.put("sta_time",new Date());
			recordMap.put("tour_people_id",map.get("userId"));
			//是否完成（0是  1否）
			recordMap.put("tour_complete",0);
			recordMap.put("tour_task_id",map.get("id"));
			recordMap.put("remark","该检修任务记录已添加完成，已提交待审核。");
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			recordMap.put("task_stat",3);
			
			tourDao.insertOverhaulRecordProcess(recordMap);
		}
		
		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"有一条新的检修任务待审核，请注意查看。");
		mapNot.put("use_id", map.get("task_check_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  检修任务 更新
	 */
	@Transactional
	public List<Map<String, Object>> updOverhaulTaskById(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updOverhaulTaskById(map);

		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"有一条新的检修任务需要执行，请注意查看");
		mapNot.put("use_id", map.get("task_execute_id"));
		mapNot.put("crt_tim", new Date());
		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  检修任务 回显
	 */
	public List<Map<String, Object>> selOverhaulTaskById(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selOverhaulTaskById(map);
		return lstMap;

	}

	// *****************************************************报修管理*****************************************

	/**
	 *  报修 列表显示
	 */
	public List<Map<String, Object>> selRepair(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selRepair(map);
		return lstMap;

	}

	/**
	 *  报修 列表显示 分页
	 */
	public Map<String, Object> selRepairCou(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selRepairCou(map);

		if (lstMap != null && lstMap.size() > 0) {

			for (Map<String, Object> retMap : lstMap) {

				return retMap;
			}
		}
		return null;

	}

	/**
	 *  报修 修改报修任务
	 */
	@Transactional
	public List<Map<String, Object>> updateRepair(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updateRepair(map);

		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"有一条新的报修任务，请注意查看。");
		mapNot.put("use_id", map.get("repair_use_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  报修 修改任务 信息回显
	 */
	public List<Map<String, Object>> selRepairById(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selRepairById(map);
		return lstMap;

	}

	/**
	 *  报修 删除报修任务
	 */
	public List<Map<String, Object>> delRepair(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.delRepair(map);
		return lstMap;

	}

	/**
	 *  报修 新建报修任务
	 */
	@Transactional
	public List<Map<String, Object>> insertRepair(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.insertRepair(map);

		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"有一条新的报修任务，请注意查看。");
		mapNot.put("use_id", map.get("repair_use_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  报修 节点添加
	 */
	@Transactional
	public List<Map<String, Object>> insertRepariNode(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.insertRepariNode(map);
		
		// 根据报修任务id 和状态 查询   2进行中   的信息
		Map<String, Object> staMap = new HashMap<String, Object>();
		staMap.put("sta", 2);
		staMap.put("repair_id", map.get("repair_id"));
		List<Map<String, Object>> lstNode = tourDao.selRepairNodeByRepairSta(staMap);

		//通过  创建人id 和任务id 查询流程的记录   结束   是否存在
		Map<String,Object> newMap = new HashMap<String, Object>();
		newMap.put("repair_id",map.get("repair_id").toString());
		newMap.put("crt_id",map.get("crt_id").toString());
		//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
		newMap.put("sta",3);
		 List<Map<String, Object>> lstRecord = tourDao.selRepairRecordProcess(newMap);
		
		//是否完成  0否 1是'
		if (lstNode.get(0).get("if_success").equals(1)) {

			//添加任务流程 开始 记录
			Map<String,Object> recordMap = new HashMap<String, Object>();
					
			if (lstRecord != null && !lstRecord.isEmpty()) {
				recordMap.put("crt_tim",new Date());
				recordMap.put("sta_time",new Date());
				recordMap.put("id",lstRecord.get(0).get("id").toString());
				tourDao.updRepairRecordProcess(recordMap);
			}else {
				recordMap.put("crt_tim",new Date());
				recordMap.put("sta_time",new Date());
				recordMap.put("crt_id",map.get("crt_id"));
				//是否完成  0否 1是
				recordMap.put("if_success",1);
				recordMap.put("repair_id",map.get("repair_id"));
				recordMap.put("repair_result","该维修任务已经结束。");
				recordMap.put("remark","维修结束。");
				//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
				recordMap.put("sta",3);
				tourDao.insertRepairRecordProcess(recordMap);
			}
		}
		
		return lstMap;

	}

	/**
	 *  报修 节点添加
	 */
	public List<Map<String, Object>> selRepairNodeNew(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selRepairNodeNew(map);
		return lstMap;

	}

	/**
	 *  报修 开始报修任务
	 */
	@Transactional
	public List<Map<String, Object>> updRepairSta(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();

		Map<String, Object> mapRepair = new HashMap<String, Object>();

		mapRepair.put("id", map.get("id"));
		// 更新报修状态
		tourDao.updRepairSta(mapRepair);
		
		//通过  创建人id 和任务id 查询流程的记录   开始  是否存在
		
		Map<String,Object> newMap = new HashMap<String, Object>();
		
		newMap.put("repair_id",map.get("id").toString());
		newMap.put("crt_id",map.get("crt_id").toString());
		//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
		newMap.put("sta",1);
		
		 List<Map<String, Object>> lstRecord = tourDao.selRepairRecordProcess(newMap);
		 
		//添加任务流程 开始 记录
		Map<String,Object> recordMap = new HashMap<String, Object>();
			
		if (lstRecord != null && !lstRecord.isEmpty()) {
			
			recordMap.put("sta_time",new Date());
			recordMap.put("crt_tim",new Date());
			recordMap.put("id",lstRecord.get(0).get("id").toString());
			tourDao.updRepairRecordProcess(recordMap);
			
		}else {

			recordMap.put("sta_time",new Date());
			recordMap.put("crt_tim",new Date());
			recordMap.put("crt_id",map.get("crt_id"));
			//是否完成  0否 1是
			recordMap.put("if_success",1);
			recordMap.put("repair_id",map.get("id"));
			recordMap.put("repair_result","请填写维修结果及总结。");
			recordMap.put("remark","该报修任务已开始。");
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			recordMap.put("sta",1);
			
			tourDao.insertRepairRecordProcess(recordMap);
		}
				
		

		return lstMap;

	}

	/**
	 *  报修 根据报修id查看该3条记录
	 */
	public List<Map<String, Object>> selRepairNodeAndRepair(
			Map<String, Object> map) throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();

		// 根据报修id查询报修节点记录
		lstMap = tourDao.selRepairNodeByRepairId(map);

		// 查询报修信息
		List<Map<String, Object>> lstMapRepair = tourDao.selRepairById(map);

		lstMap.addAll(lstMapRepair);

		return lstMap;

	}

	/**
	 * 根据报修id 查询报修记录信息 及状态
	 */
	public Map<String, Object> selRepairNodeAndRepairAll(Map<String, Object> map)
			throws Exception {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		// 查询报修信息
		List<Map<String, Object>> lstRepair = tourDao.selRepairById(map);

		// 根据报修id查询报修节点记录
		// List<Map<String, Object>> lstRepairNode =tourDao.selRepairNodeByRepairId(map);

		Map<String,Object> mapSta = new HashMap<String, Object>();
		//根据  流程记录状态 查询最新的信息  流程记录 1开始 2进行中 3完成待审核 4驳回 5审核通过'
		for (int j = 1; j < 4; j++) {

			Map<String, Object> staMap = new HashMap<String, Object>();
			staMap.put("sta", j);
			staMap.put("repair_id", map.get("id"));
			// // 根据报修任务id 和状态 查询   2进行中   的信息
			List<Map<String, Object>> lstNode = tourDao.selRepairNodeByRepairSta(staMap);

			if (lstNode != null && !lstNode.isEmpty() ) {
				
				if (j == 1) {
					
					mapSta.put("sta"+ j,lstNode.get(0).get("if_success"));
					
				} 
				
				if (j == 2) {
					
					mapSta.put("sta"+ j,lstNode.get(0).get("if_success"));
					mapSta.put("sta"+(j+1),lstNode.get(0).get("if_success"));
					
				} 
				
				if (j == 3) {
					
					break;
					
				} 
			}else {
				mapSta.put("sta" + j, 0);
			}
			
		}

		resultMap.put("lstRepair", lstRepair);
		// resultMap.put("lstRepairNode", lstRepairNode);
		resultMap.put("mapSta", mapSta);
		return resultMap;

	}

	/**
	 * 根据报修id 查询报修记录所有信息 及附件
	 */
	public Map<String, Object> selRepairNodeAll(Map<String, Object> map)
			throws Exception {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<Map<String, Object>> repairNodeMap = tourDao.selRepairNodeByRepairId(map);

		for (int i = 0; i < repairNodeMap.size(); i++) {
			Map<String, Object> img = repairNodeMap.get(i);

			Map<String, Object> imgMap = new HashMap<String, Object>();
			imgMap.put("treId", img.get("id"));
			// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
			imgMap.put("imageType", 6);
			List<Map<String, Object>> imgLst = tourDao.selTourImgByRouteId(imgMap);

			if (imgLst != null && !imgLst.isEmpty()) {
				img.put("imgLst", imgLst);
			}

			Map<String, Object> fileMap = new HashMap<String, Object>();
			fileMap.put("treId", img.get("id"));
			// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
			fileMap.put("fileType", 6);
			List<Map<String, Object>> filLst = tourDao.selTourFileByRouteId(fileMap);

			if (filLst != null && !filLst.isEmpty()) {

				img.put("imgLst", filLst);
			}

		}

		resultMap.put("repairNodeMap", repairNodeMap);
		return resultMap;

	}

	/**
	 *  报修 报修节点修改
	 */
	public List<Map<String, Object>> updRepairNode(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updRepairNode(map);
		return lstMap;

	}

	/**
	 *  报修 根据报修节点id查看 信息回显
	 */
	public Map<String, Object> selRepairNodeById(Map<String, Object> map)
			throws Exception {
		// 修节点id查看
		List<Map<String, Object>> lstMap = tourDao.selRepairNodeById(map);

		Map<String, Object> fileMap = new HashMap<String, Object>();
		fileMap.put("treId", map.get("id"));
		// 文件类型（1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
		fileMap.put("fileType", 6);
		// 查询 文件
		List<Map<String, Object>> lstFile = tourDao.selTourFileByRouteId(fileMap);

		Map<String, Object> imageMap = new HashMap<String, Object>();
		// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
		imageMap.put("treId", map.get("id"));
		imageMap.put("imageType", 6);
		// 查询 图片
		List<Map<String, Object>> lstImg = tourDao.selTourImgByRouteId(imageMap);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lstMap", lstMap);
		resultMap.put("lstFile", lstFile);
		resultMap.put("lstImg", lstImg);

		return resultMap;

	}

	/**
	 *  报修 任务提交 报修任务待审核
	 */
	@Transactional
	public List<Map<String, Object>> updRepairStaFour(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updRepairStaFour(map);

		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"有一条新的报修任务待审核，请注意查看。");
		mapNot.put("use_id", map.get("check_use_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  报修 任务提交 审核或驳回
	 */
	@Transactional
	public List<Map<String, Object>> updRepairStaIfSuccess(
			Map<String, Object> map) throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updRepairStaIfSuccess(map);
		
		Map<String,Object> newMap = new HashMap<String, Object>();
		if (map.get("check_sta").toString().equals("5")) {
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			newMap.put("sta",5);
		}
		
		if (map.get("check_sta").toString().equals("6")) {
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			newMap.put("sta",4);
		}
		
		newMap.put("sta_time",new Date());
		newMap.put("crt_tim",new Date());
		newMap.put("crt_id",map.get("crt_id"));
		//是否完成  0否 1是
		newMap.put("if_success",1);
		newMap.put("repair_id",map.get("id"));
		
		
		if (map.get("check_sta").toString().equals("5")) {
			newMap.put("repair_result","审核已通过。");
			newMap.put("remark","审核已通过。该报修任务已结束。");
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			//newMap.put("sta",5);
		}
		
		if (map.get("check_sta").toString().equals("6")) {
			newMap.put("repair_result",map.get("check_remark").toString());
			newMap.put("remark","审核已被驳回，请重新添加并修改报修记录。");
			//任务流程状态 1开始 2进行中 3完成待审核 4驳回 5审核通过
			//newMap.put("sta",4);
		}
		
		tourDao.insertRepairRecordProcess(newMap);
		
		// 通过报修任务id 查看报修详情
		Map<String, Object> repairMap = new HashMap<String, Object>();
		repairMap.put("id", map.get("id"));

		List<Map<String, Object>> lstRepairMap = tourDao.selRepairById(repairMap);
		// 获取任务创建人
		// lstRepairMap.get(0).get("crt_use_id");
		// 任务创建时间
		// lstRepairMap.get(0).get("crt_tim")
		// 审核状态 （1未指派 2未开始 3进行中 4完成待审核 5审核通过 6审核驳回）'
		// 因为这个方法是 审核通过 或 驳回 所以 状态只需要 5或者6

		// 通过
		if ("5".equals(map.get("check_sta"))) {

			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在" + format.format(new Date())
					+ "创建的报修任务，审核已通过。");
			mapNot.put("use_id", lstRepairMap.get(0).get("crt_use_id"));
			mapNot.put("crt_tim", new Date());
			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);
			// 驳回
		} else if ("6".equals(map.get("check_sta"))) {
			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在" + format.format(new Date())
					+ "创建的报修任务，审核已被驳回，原因是：" + map.get("check_remark") + "。");
			mapNot.put("use_id", lstRepairMap.get(0).get("crt_use_id"));
			mapNot.put("crt_tim", new Date());
			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);
		}

		return lstMap;

	}

	// *****************************************************报废管理*****************************************

	/**
	 *  报废 列表显示
	 */
	public List<Map<String, Object>> selScrap(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selScrap(map);
		return lstMap;

	}

	/**
	 *  报废 列表显示 分页
	 */
	public Map<String, Object> selScrapCou(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selScrapCou(map);

		if (lstMap != null && lstMap.size() > 0) {

			for (Map<String, Object> retMap : lstMap) {

				return retMap;
			}
		}
		return null;

	}

	/**
	 *  报废 新增
	 */
	@Transactional
	public List<Map<String, Object>> insertScrap(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.insertScrap(map);

		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "您在"+format.format(new Date())+"有一条新的报废任务待审核，请注意查看");
		mapNot.put("use_id", map.get("one_check_use_id"));
		mapNot.put("crt_tim", new Date());

		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return lstMap;

	}

	/**
	 *  报废 修改
	 */
	public List<Map<String, Object>> updateScrap(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.updateScrap(map);
		return lstMap;

	}

	/**
	 *  报废 信息回显
	 */
	public Map<String, Object> selScrapById(Map<String, Object> map)
			throws Exception {

		// id 查看信息
		List<Map<String, Object>> lstMap = tourDao.selScrapById(map);

		Map<String, Object> fileMap = new HashMap<String, Object>();
		fileMap.put("treId", map.get("id"));
		// 文件类型（1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
		fileMap.put("fileType", 7);
		// 查询 文件
		List<Map<String, Object>> lstFile = tourDao.selTourFileByRouteId(fileMap);

		Map<String, Object> imageMap = new HashMap<String, Object>();
		// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
		imageMap.put("treId", map.get("id"));
		imageMap.put("imageType", 7);
		// 查询 图片
		List<Map<String, Object>> lstImg = tourDao.selTourImgByRouteId(imageMap);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lstMap", lstMap);
		resultMap.put("lstFile", lstFile);
		resultMap.put("lstImg", lstImg);

		return resultMap;

	}
	
	/**
	 * 报废信息 回显  App接口 
	 * 
	 * If I let me do this again, I will resign.
	 */
	/**
	 *                                         ,s555SB@@&                          
	 *                                      :9H####@@@@@Xi                        
	 *                                     1@@@@@@@@@@@@@@8                       
	 *                                   ,8@@@@@@@@@B@@@@@@8                      
	 *                                  :B@@@@X3hi8Bs;B@@@@@Ah,                   
	 *             ,8i                  r@@@B:     1S ,M@@@@@@#8;                 
	 *            1AB35.i:               X@@8 .   SGhr ,A@@@@@@@@S                
	 *            1@h31MX8                18Hhh3i .i3r ,A@@@@@@@@@5               
	 *            ;@&i,58r5                 rGSS:     :B@@@@@@@@@@A               
	 *             1#i  . 9i                 hX.  .: .5@@@@@@@@@@@1               
	 *              sG1,  ,G53s.              9#Xi;hS5 3B@@@@@@@B1                
	 *               .h8h.,A@@@MXSs,           #@H1:    3ssSSX@1                  
	 *               s ,@@@@@@@@@@@@Xhi,       r#@@X1s9M8    .GA981               
	 *               ,. rS8H#@@@@@@@@@@#HG51;.  .h31i;9@r    .8@@@@BS;i;          
	 *                .19AXXXAB@@@@@@@@@@@@@@#MHXG893hrX#XGGXM@@@@@@@@@@MS        
	 *                s@@MM@@@hsX#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&,      
	 *              :GB@#3G@@Brs ,1GM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B,     
	 *            .hM@@@#@@#MX 51  r;iSGAM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@8     
	 *          :3B@@@@@@@@@@@&9@h :Gs   .;sSXH@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:    
	 *      s&HA#@@@@@@@@@@@@@@M89A;.8S.       ,r3@@@@@@@@@@@@@@@@@@@@@@@@@@@r    
	 *   ,13B@@@@@@@@@@@@@@@@@@@5 5B3 ;.         ;@@@@@@@@@@@@@@@@@@@@@@@@@@@i    
	 *  5#@@#&@@@@@@@@@@@@@@@@@@9  .39:          ;@@@@@@@@@@@@@@@@@@@@@@@@@@@;    
	 *  9@@@X:MM@@@@@@@@@@@@@@@#;    ;31.         H@@@@@@@@@@@@@@@@@@@@@@@@@@:    
	 *   SH#@B9.rM@@@@@@@@@@@@@B       :.         3@@@@@@@@@@@@@@@@@@@@@@@@@@5    
	 *     ,:.   9@@@@@@@@@@@#HB5                 .M@@@@@@@@@@@@@@@@@@@@@@@@@B    
	 *           ,ssirhSM@&1;i19911i,.             s@@@@@@@@@@@@@@@@@@@@@@@@@@S   
	 *              ,,,rHAri1h1rh&@#353Sh:          8@@@@@@@@@@@@@@@@@@@@@@@@@#:  
	 *            .A3hH@#5S553&@@#h   i:i9S          #@@@@@@@@@@@@@@@@@@@@@@@@@A.
	 *
	 *
	 *    
	 */

	
	public Map<String, Object> selScrapByIdApp(Map<String, Object> map)
			throws Exception {
		
		// id 查看信息
		List<Map<String, Object>> lstMap = tourDao.selScrapById(map);
		
		Map<String, Object> fileMap = new HashMap<String, Object>();
		fileMap.put("treId", map.get("id"));
		// 文件类型（1：为巡视任务文件，2：为巡视记录文件,3：为检修任务文件，4：为检修记录文件，5：为报修任务文件，6：为报修过程文件，7：为报废任务文件
		fileMap.put("fileType", 7);
		// 查询 文件
		List<Map<String, Object>> lstFile = tourDao.selTourFileByRouteIdApp(fileMap);
		
		Map<String, Object> imageMap = new HashMap<String, Object>();
		// 图片类型（1：为巡视任务图片，2：为巡视记录图片,3：为检修任务图片，4：为检修记录图片，5：为报修任务图片，6：为报修过程图片，7：为报废任务图片）',
		imageMap.put("treId", map.get("id"));
		imageMap.put("imageType", 7);
		// 查询 图片
		List<Map<String, Object>> lstImg = tourDao.selTourImgByRouteIdApp(imageMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lstMap", lstMap);
		resultMap.put("lstFile", lstFile);
		resultMap.put("lstImg", lstImg);
		
		return resultMap;
		
	}

	/**
	 *  报废 最新的信息
	 */
	public List<Map<String, Object>> selScrapNew(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selScrapNew(map);
		return lstMap;

	}

	/**
	 *  报废 删除
	 */
	public List<Map<String, Object>> delScrap(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.delScrap(map);
		return lstMap;

	}

	/**
	 * 报废 第一次审核或驳回
	 */
	@Transactional
	public List<Map<String, Object>> updScrapStaOne(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		// 修改审核情况
		lstMap = tourDao.updScrapStaOne(map);
		// id查看报废信息
		Map<String, Object> mapScrap = new HashMap<String, Object>();
		mapScrap.put("id", map.get("id"));
		List<Map<String, Object>> lstScrap = tourDao.selScrapById(mapScrap);
		// 报废任务创建人
		// lstScrap.get(0).get("crt_use_id");
		// 报废任务创建时间
		// lstScrap.get(0).get("crt_tim");

		// 审核状态（0 未开始 1开始未审核 2第一审核通过 3第一审核驳回 4第二次审核通过 5第二次审核驳回
		// 这个方法是第一次审核 只需要状态 2或者3
		// 第一次审核通过
		if ("2".equals(map.get("check_sta"))) {
			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在" + 
			format.format(new Date())
					+ "创建的报废任务，第一次审核通过");
			mapNot.put("use_id", lstScrap.get(0).get("crt_use_id"));
			mapNot.put("crt_tim", new Date());
			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);

			// 第一次审核驳回
		} else if ("3".equals(map.get("check_sta"))) {
			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在" + format.format(new Date())
					+ "创建的报废任务，第一次审核驳回");
			mapNot.put("use_id", lstScrap.get(0).get("crt_use_id"));
			mapNot.put("crt_tim", new Date());
			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);

		}

		return lstMap;

	}

	/**
	 * 报废 第二次审核或驳回
	 */
	@Transactional
	public List<Map<String, Object>> updScrapStaTwo(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		// 修改第二次审核概况
		lstMap = tourDao.updScrapStaTwo(map);

		// id查看报废信息
		Map<String, Object> mapScrap = new HashMap<String, Object>();
		mapScrap.put("id", map.get("id"));
		List<Map<String, Object>> lstScrap = tourDao.selScrapById(mapScrap);
		// 报废任务创建人
		// lstScrap.get(0).get("crt_use_id");
		// 报废任务创建时间
		// lstScrap.get(0).get("crt_tim");

		// 审核状态（0 未开始 1开始未审核 2第一审核通过 3第一审核驳回 4第二次审核通过 5第二次审核驳回
		// 这个方法是第二次审核 只需要状态 4或者5
		// 第二次审核通过
		if ("4".equals(map.get("check_sta"))) {
			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在" + format.format(new Date())
					+ "创建的报废任务，第二次审核通过");
			mapNot.put("use_id", lstScrap.get(0).get("crt_use_id"));
			mapNot.put("crt_tim", new Date());
			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);

			// 第二次审核驳回
		} else if ("5".equals(map.get("check_sta"))) {
			// 添加系统消息
			Map<String, Object> mapNot = new HashMap<String, Object>();
			mapNot.put("notice_con", "您在" + format.format(new Date())
					+ "创建的报废任务，第二次审核驳回");
			mapNot.put("use_id", lstScrap.get(0).get("crt_use_id"));
			mapNot.put("crt_tim", new Date());
			// 添加系统消息
			othersDao.insSysNoticeInf(mapNot);

		}

		return lstMap;

	}

	// *****************************************************巡视计划*****************************************

	/**
	 *  巡视计划 列表显示
	 */
	@Transactional
	public List<Map<String, Object>> selTourPlan(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		
		List<Map<String, Object>> monthLst = new ArrayList<Map<String, Object>>();						
		// 查询
		lstMap = tourDao.selTourPlan(map);
		
		for (int i = 0; i < lstMap.size(); i++) {											
			//月										
			if (lstMap.get(i).get("day_type").toString().equals("1")){										
													
				Map<String,Object> monthMap = new HashMap<String, Object>();									
													
				monthMap.put("id", lstMap.get(i).get("id").toString());									
													
				monthLst = tourDao.getTourPlanMonth(monthMap);									
													
				String next_tim = TourPlanTime.TourPlanTime(									
						monthLst.get(0).get("first_time").toString(),							
						monthLst.get(0).get("end_time").toString(),							
						Integer.parseInt(monthLst.get(0).get("frequency").toString()));							
				
				next_tim = next_tim.split(" ")[0];
				
				lstMap.get(i).put("next_time", next_tim);
				
				
				//id  next_tiem 存到数据库中
				Map<String,Object> nextTimeMap = new HashMap<String, Object>();		
				nextTimeMap.put("id", monthMap.get("id"));
				nextTimeMap.put("next_time",next_tim);
				
				if (nextTimeMap.get("next_time").equals("计划已过期")) {
					// 计划运行状态（1：执行2：停止）
					nextTimeMap.put("run_flat",2);
				}else {
					nextTimeMap.put("run_flat",1);
				}
				
				tourDao.addTourPlanNextTime(nextTimeMap);
				
			}
			
			//日										
			if (lstMap.get(i).get("day_type").toString().equals("2")){		
				
				if (lstMap.get(i).get("next_time").toString().equals("计划已过期")) {
					
					lstMap.get(i).put("next_time","计划已过期");
					
				}else {
					
					String next_tim = lstMap.get(i).get("next_time").toString().split(" ")[0];
					
					lstMap.get(i).put("next_time", next_tim);
				}
				
				//id  next_tiem 存到数据库中
				Map<String,Object> nextTimeMap = new HashMap<String, Object>();		
				nextTimeMap.put("id", lstMap.get(i).get("id").toString());
				nextTimeMap.put("next_time",lstMap.get(i).get("next_time").toString());
				
				if (nextTimeMap.get("next_time").equals("计划已过期")) {
					// 计划运行状态（1：执行2：停止）
					nextTimeMap.put("run_flat",2);
				}else {
					nextTimeMap.put("run_flat",1);
				}
				
				tourDao.addTourPlanNextTime(nextTimeMap);
				
			}
		}											

		//再重新   查询
		lstMap = tourDao.selTourPlan(map);
		return lstMap;

	}

	/**
	 *  巡视计划 列表显示 导出
	 */
	public List<Map<String, Object>> selTourPlanAll(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selTourPlanAll(map);
		return lstMap;

	}

	/**
	 *  巡视计划 列表显示 分页
	 */
	public Map<String, Object> selTourPlanCou(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selTourPlanCou(map);
		if (lstMap != null && lstMap.size() > 0) {

			for (Map<String, Object> retMap : lstMap) {

				return retMap;
			}
		}
		return null;

	}

	/**
	 *  巡视计划 添加
	 */
	@Override
	public List<Map<String, Object>> insertTourPlan(Map<String, Object> map)
			throws Exception {

		// 添加计划
		return tourDao.insertTourPlan(map);

	}

	/**
	 *  巡视计划 任务 更新
	 */
	@Override
	public List<Map<String, Object>> updTourPlan(Map<String, Object> map)
			throws Exception {
		// 更新计划
		return tourDao.updTourPlan(map);
	}

	/**
	 *  根据id查看巡视计划
	 */
	public List<Map<String, Object>> getTourPlanById(Map<String, Object> map)
			throws Exception {
		return tourDao.getTourPlanById(map);
	}

	/**
	 *  巡视计划 删除
	 */
	public List<Map<String, Object>> delTourPlan(Map<String, Object> map)
			throws Exception {
		return tourDao.delTourPlan(map);
	}

	/**
	 *  -巡视计划 停止
	 */
	public void updTourPlanFlat(Map<String, Object> map) throws Exception {
		tourDao.updTourPlanFlat(map);
	}
	
	/**
	 *  巡视计划 修改该计划的状态 为开始执行
	 */
	public void updTourPlanBegin(Map<String, Object> map) throws Exception {
		tourDao.updTourPlanRunFlat(map);
	}
	
	
	/**
	 *  巡视计划 开始执行
	 */
	@Transactional
	public List<Map<String, Object>> updTourPlanRunFlat(Map<String, Object> map)
			throws Exception {

		// TODO 这个方法需要获取 计划开始时间 和结束时间 以及 频率 定时生成巡视任务
		tourDao = SpringContextUtil.getBean("tourDao");
		// 修改该计划的状态 为开始执行
		tourDao.updTourPlanRunFlat(map);

		// 根据计划id查询 计划信息
		List<Map<String, Object>> lstTrouPlan = tourDao.getTourPlanById(map);

		Map<String, Object> taskMap = new HashMap<String, Object>();
		// 获取计划中的id 添加到任务中
		taskMap.put("tour_plan_id", lstTrouPlan.get(0).get("id"));
		// 获取计划中的路线id 添加到任务中
		taskMap.put("tour_route_id", lstTrouPlan.get(0).get("tour_route_id"));
		// 获取计划中的创建人 添加到任务中
		taskMap.put("appoint_id", lstTrouPlan.get(0).get("crt_use_id"));
		// 任务中的任务状态 变为 1未指派
		taskMap.put("task_sta", 1);
		// 任务中的创建状态 变为 1自动创建
		taskMap.put("task_typ", 1);

		// 自动添加任务
		tourDao.insTourTaskAutomatic(taskMap);

		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "系统在"+format.format(new Date())+"自动为您生成一条巡视任务，请注意查看。");
		mapNot.put("use_id", lstTrouPlan.get(0).get("crt_use_id"));
		mapNot.put("crt_tim", new Date());
		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return null;

	}

	// *****************************************************检修计划*****************************************

	/**
	 *  检修计划 列表显示
	 */
	@Transactional
	public List<Map<String, Object>> selOverhaulPlan(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> monthLst = new ArrayList<Map<String, Object>>();
	
		// 查询
		lstMap = tourDao.selOverhaulPlan(map);
		
		for (int i = 0; i < lstMap.size(); i++) {
			//月
			if (lstMap.get(i).get("day_type").toString().equals("1")){
				
				Map<String,Object> monthMap = new HashMap<String, Object>();
				
				monthMap.put("id", lstMap.get(i).get("id").toString());
				
				monthLst = tourDao.selOverhaulPlanMonth(monthMap);
				
				String next_tim = TourPlanTime.TourPlanTime(
						monthLst.get(0).get("first_time").toString(),
						monthLst.get(0).get("end_time").toString(),
						Integer.parseInt(monthLst.get(0).get("frequency").toString()));
				
				next_tim = next_tim.split(" ")[0];
				
				lstMap.get(i).put("next_time", next_tim);
				
				//id  next_tiem 存到数据库中
				Map<String,Object> nextTimeMap = new HashMap<String, Object>();		
				nextTimeMap.put("id", monthMap.get("id"));
				nextTimeMap.put("next_time",next_tim);
				
				if (nextTimeMap.get("next_time").equals("计划已过期")) {
					// 计划运行状态（1：执行2：停止）
					nextTimeMap.put("run_flat",2);
				}else {
					nextTimeMap.put("run_flat",1);
				}
				
				tourDao.addOverhaulNextTime(nextTimeMap);
				
			}
			
			//日										
			if (lstMap.get(i).get("day_type").toString().equals("2")){		
				
				if (lstMap.get(i).get("next_time").toString().equals("计划已过期")) {
					
					lstMap.get(i).put("next_time","计划已过期");
					
				}else {
					
					String next_tim = lstMap.get(i).get("next_time").toString().split(" ")[0];
					
					lstMap.get(i).put("next_time", next_tim);
				}
				
				//id  next_tiem 存到数据库中
				Map<String,Object> nextTimeMap = new HashMap<String, Object>();		
				nextTimeMap.put("id", lstMap.get(i).get("id").toString());
				nextTimeMap.put("next_time",lstMap.get(i).get("next_time").toString());
				
				if (nextTimeMap.get("next_time").equals("计划已过期")) {
					// 计划运行状态（1：执行2：停止）
					nextTimeMap.put("run_flat",2);
				}else {
					nextTimeMap.put("run_flat",1);
				}
				
				tourDao.addOverhaulNextTime(nextTimeMap);
			}
			
		}
		
		
		//再重新   查询
		lstMap = tourDao.selOverhaulPlan(map);
		return lstMap;

	}

	/**
	 *  检修计划 列表显示 导出
	 */
	public List<Map<String, Object>> selOverhaulPlanAll(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selOverhaulPlanAll(map);
		return lstMap;

	}

	/**
	 *  检修计划 列表显示 分页
	 */
	public Map<String, Object> selOverhaulPlanCou(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> lstMap = new ArrayList<Map<String, Object>>();
		lstMap = tourDao.selOverhaulPlanCou(map);

		if (lstMap != null && lstMap.size() > 0) {

			for (Map<String, Object> retMap : lstMap) {

				return retMap;
			}
		}
		return null;

	}

	/**
	 *  检修计划 添加
	 */
	@Override
	public List<Map<String, Object>> insertOverhaulPlan(Map<String, Object> map)
			throws Exception {
		// 添加计划
		return tourDao.insertOverhaulPlan(map);
	}

	/**
	 *  检修计划 更新
	 */
	@Override
	public List<Map<String, Object>> updOverhaulPlan(Map<String, Object> map)
			throws Exception {
		// 更新计划
		return tourDao.updOverhaulPlan(map);
	}

	/**
	 *  根据id查看检修计划
	 */
	public List<Map<String, Object>> getOverhaulPlanById(Map<String, Object> map)
			throws Exception {
		return tourDao.getOverhaulPlanById(map);
	}

	/**
	 *  根据id删除检修计划
	 */
	public List<Map<String, Object>> delOverhaulPlan(Map<String, Object> map)
			throws Exception {
		return tourDao.delOverhaulPlan(map);
	}

	/**
	 *  检修计划 停止
	 */
	public void updOverhaulPlanFlat(Map<String, Object> map) throws Exception {
		tourDao.updOverhaulPlanFlat(map);
	}

	
	
	/**
	 *  检修计划 修改该计划的状态 为开始执行
	 */
	public void updOverhaulPlanBegin(Map<String, Object> map) throws Exception {
		tourDao.updOverhaulPlanRunFlat(map);
	}
	
	
	/**
	 *  检修计划 开始执行
	 */
	@Transactional
	public List<Map<String, Object>> updOverhaulPlanRunFlat(
			Map<String, Object> map) throws Exception {

		// TODO 这个方法需要获取 计划开始时间 和结束时间 以及 频率 定时生成巡视任务

		tourDao = SpringContextUtil.getBean("tourDao");

		// 修改该计划的状态 为开始执行
		tourDao.updOverhaulPlanRunFlat(map);

		// 根据计划id查询 计划信息
		List<Map<String, Object>> lstTrouPlan = tourDao.getOverhaulPlanById(map);

		Map<String, Object> taskMap = new HashMap<String, Object>();
		// 获取计划中的id 添加到任务中
		taskMap.put("tour_plan_id", lstTrouPlan.get(0).get("id"));
		// 获取计划中的路线id 添加到任务中
		taskMap.put("tour_route_id", lstTrouPlan.get(0).get("tour_route_id"));
		// 获取计划中的创建人 添加到任务中
		taskMap.put("appoint_id", lstTrouPlan.get(0).get("crt_use_id"));
		// 任务中的任务状态 变为 1未指派
		taskMap.put("task_sta", 1);
		// 任务中的创建状态 变为 1自动创建
		taskMap.put("task_typ", 1);

		// 自动添加任务
		tourDao.insOverhaulTaskAutomatic(taskMap);

		// 添加系统消息
		Map<String, Object> mapNot = new HashMap<String, Object>();
		mapNot.put("notice_con", "系统在"+format.format(new Date())+"自动为您生成一条检修任务，请注意查看。");
		mapNot.put("use_id", lstTrouPlan.get(0).get("crt_use_id"));
		mapNot.put("crt_tim", new Date());
		// 添加系统消息
		othersDao.insSysNoticeInf(mapNot);

		return null;

	}

	// --------------------------电量计划----------------------------------------------------------------

	/**
	 * 运维 图片上传 和 文件上传
	 */
	// @Value("${img.upload.path}")
	// String imgPath;

	@Value("${file.upload.path}")
	String filePath;

	@Override
	public BaseTransferEntity uploadImg(Map<String, Object> map,
			MultipartFile[] files, String filePath) {
		BaseTransferEntity upload = new BaseTransferEntity();
		for (MultipartFile file : files) {

			if (file == null || file.isEmpty()) {
				continue;
			}

			upload = upload(file);

			if (upload == null) {
				return upload;
			}
			Map<String, String> mapImg = (Map<String, String>) upload.getData();
			System.out.println(mapImg + "-----------------------------");

			if (mapImg != null) {
				// 如果不是图片 执行文件的添加
				if (!mapImg.get("newName").contains("jpg")
						&& !mapImg.get("newName").contains("png")) {
					String url = PropertiesUtil.getProperty("file.prefix")
							+ mapImg.get("newName");
					Map<String, Object> fileMap = new HashMap<String, Object>();
					fileMap.put("file_name", mapImg.get("file_name"));
					fileMap.put("file_path", url);
					fileMap.put("tour_file_id", map.get("userId"));
					fileMap.put("tour_record_id", map.get("tour_record_id"));
					fileMap.put("file_typ", map.get("type"));
					fileMap.put("remark", map.get("remark"));

					List<Map<String, Object>> lstMapFileList = tourDao
							.insTourOrOverhaulFile(fileMap);

				} else {
					// 图片的添加
					String url = PropertiesUtil.getProperty("file.prefix")
							+ mapImg.get("newName");

					Map<String, Object> picMap = new HashMap<String, Object>();
					picMap.put("tour_image_name", mapImg.get("tour_image_name"));
					picMap.put("image_path", url);
					picMap.put("tour_image_id", map.get("userId"));
					picMap.put("tour_record_id", map.get("tour_record_id"));
					picMap.put("image_typ", map.get("type"));
					picMap.put("remark", map.get("remark"));

					try {
						List<Map<String, Object>> lstMapImgList = tourDao
								.insTourOrOverhaulImg(picMap);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

		return upload;
	}

	@Override
	public BaseTransferEntity upload(MultipartFile file) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 获取文件名称
			String fileName = file.getOriginalFilename();

			// abc.jpg
			String fileExtensionName = fileName.substring(fileName
					.lastIndexOf(".") + 1);

			// 判断文件 后缀 如果不是图片
			if (!fileExtensionName.equalsIgnoreCase("jpg")
					&& !fileExtensionName.equalsIgnoreCase("png")) {
				// 新的文件名称
				String uploadFileName = UUID.randomUUID().toString() + "."
						+ fileExtensionName;
				File fileDir = new File(filePath);
				if (!fileDir.exists()) {
					fileDir.setWritable(true);
					fileDir.mkdirs();
				}
				// 执行文件上传
				File targetFile = new File(filePath, uploadFileName);
				file.transferTo(targetFile);

				Map<String, String> mapImg = new HashMap<String, String>();
				// 保存一下文件名称 和新的文件名称
				mapImg.put("file_name", fileName);
				mapImg.put("newName", uploadFileName);

				baseTransferEntity.setData(mapImg);

				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig
						.get("msg.global.success"));

			} else {

				// 图片
				String uploadFileName = UUID.randomUUID().toString() + "."
						+ fileExtensionName;

				File fileDir = new File(filePath);
				if (!fileDir.exists()) {
					fileDir.setWritable(true);
					fileDir.mkdirs();
				}

				File targetFile = new File(filePath, uploadFileName);
				file.transferTo(targetFile);

				Map<String, String> mapImg = new HashMap<String, String>();

				mapImg.put("tour_image_name", fileName);
				mapImg.put("newName", uploadFileName);

				baseTransferEntity.setData(mapImg);
				baseTransferEntity.setResultcode(MobileConfig
						.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig
						.get("msg.global.success"));
			}

		} catch (IOException e) {
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("msg.global.failed"));
			baseTransferEntity.setDesc("上传文件异常");

		}
		return baseTransferEntity;

	}

	/**
	 *  运维 id查看图片
	 */
	public List<Map<String, Object>> getTourImageById(Map<String, Object> map)
			throws Exception {
		return tourDao.getTourImageById(map);
	}

	/**
	 *  运维 id查看文件
	 */
	public List<Map<String, Object>> getTourFileById(Map<String, Object> map)
			throws Exception {
		return tourDao.getTourFileById(map);
	}
	
	
	/**
	 *  运维模块 查询所有运维人员   选择执行人时用此接口  查询本公司和下级公司所有运维人员
	 */
	public List<Map<String, Object>> selUserNameTour(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> resultLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> comLst = new ArrayList<Map<String,Object>>();
		
		// 根据登录用户id 查询用户所在公司
		List<Map<String, Object>> nowComList = tourDao.selComByUserId(map);

		if (nowComList.get(0).get("com_lev").equals(1)) {
			
			comLst.addAll(nowComList);
			
			Map<String, Object> twoMap = new HashMap<String, Object>();
			
			twoMap.put("id", nowComList.get(0).get("com_id").toString());
			// 根据公司id 查询下级公司
			List<Map<String, Object>> twoCompany = tourDao.selComByComId(twoMap);
			
			comLst.addAll(twoCompany);
			
			if (twoCompany != null && !twoCompany.isEmpty()) {
				
				for (int i = 0; i < twoCompany.size(); i++) {
					
					Map<String, Object> comIdMap = new HashMap<String, Object>();
					
					comIdMap.put("id", twoCompany.get(i).get("com_id").toString());
					
					// 根据公司id 查询下级公司
					List<Map<String, Object>> threeCompany = tourDao.selComByComId(comIdMap);
					
					comLst.addAll(threeCompany);
					
				}
					
			}
			
		}
		
		if (nowComList.get(0).get("com_lev").equals(2)) {
			
			comLst.addAll(nowComList);
			
			Map<String, Object> twoMap = new HashMap<String, Object>();
			
			twoMap.put("id", nowComList.get(0).get("com_id").toString());
			// 根据公司id 查询下级公司
			List<Map<String, Object>> threeCompany = tourDao.selComByComId(twoMap);
			
			comLst.addAll(threeCompany);
			
		}
		
		if (nowComList.get(0).get("com_lev").equals(3)) {
			
			comLst.addAll(nowComList);
		}
		
		for (Map<String, Object> comUserMap : comLst) {

			Map<String, Object> comIdMap = new HashMap<String, Object>();
			
			comIdMap.put("com_id", comUserMap.get("com_id"));

			// 通过公司id 查询 所有运维人员
			List<Map<String, Object>> userLst = tourDao.selUserNameTour(comIdMap);
			
			resultLst.addAll(userLst);
		}

		return resultLst;
	}

	
	
	/**
	 *  运维模块 查询所有运维人员   选择审核人时用此接口  查询 本公司和上级公司所有运维人员
	 */
	public List<Map<String, Object>> selUserNameTourCheck(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> resultLst = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> comLst = new ArrayList<Map<String,Object>>();
		
		// 根据登录用户id 查询用户所在公司
		List<Map<String, Object>> nowComList = tourDao.selComByUserId(map);
		
		if (nowComList.get(0).get("com_lev").equals(1)) {
			
			comLst.addAll(nowComList);
			
		}
		
		if (nowComList.get(0).get("com_lev").equals(2)) {
			
			comLst.addAll(nowComList);
			
			Map<String, Object> twoMap = new HashMap<String, Object>();
			
			twoMap.put("id", nowComList.get(0).get("com_id").toString());
			// 查询本公司  上级公司id
			List<Map<String, Object>> twoCompany = tourDao.selComByComFatId(twoMap);
			
			if (twoCompany != null && !twoCompany.isEmpty()) {
				
					Map<String, Object> comIdMap = new HashMap<String, Object>();
					
					comIdMap.put("id", twoCompany.get(0).get("com_fat_id").toString());
					
					// 根据公司id 查询上级公司
					List<Map<String, Object>> threeCompany = tourDao.selComByComFatId(comIdMap);
					
					comLst.addAll(threeCompany);
			}
			
		}
		
		if (nowComList.get(0).get("com_lev").equals(3)) {
			
			comLst.addAll(nowComList);
			
			Map<String, Object> twoMap = new HashMap<String, Object>();
			
			twoMap.put("id", nowComList.get(0).get("com_id").toString());
			// 得到本公司 父id
			List<Map<String, Object>> oneCompany = tourDao.selComByComFatId(twoMap);
			
			if (oneCompany != null && !oneCompany.isEmpty()) {
				
				Map<String, Object> comIdMapOne = new HashMap<String, Object>();
				
				comIdMapOne.put("id", oneCompany.get(0).get("com_fat_id").toString());
				
				// 根据公司id 查询2级公司
				List<Map<String, Object>> twoCompany = tourDao.selComByComFatId(comIdMapOne);
				
				comLst.addAll(twoCompany);
				
			if (twoCompany != null && !twoCompany.isEmpty()) {
				
				Map<String, Object> comIdMapTwo = new HashMap<String, Object>();
				
				comIdMapTwo.put("id", twoCompany.get(0).get("com_fat_id").toString());
				
				// 根据2级公司父id 查询1级公司
				List<Map<String, Object>> threeCompany = tourDao.selComByComFatId(comIdMapTwo);
				
				comLst.addAll(threeCompany);
				
			}
		}
			
	}
		
		for (Map<String, Object> comUserMap : comLst) {
			
			Map<String, Object> comIdMap = new HashMap<String, Object>();
			
			comIdMap.put("com_id", comUserMap.get("com_id"));
			
			// 通过公司id 查询 所有运维人员
			//List<Map<String, Object>> userLst = tourDao.selUserNameTour(comIdMap);
			//通过公司id 查询所有人员 （不包括离职人员）
			List<Map<String, Object>> userLst = tourDao.selComPanyUserName(comIdMap);
			
			resultLst.addAll(userLst);
		}
		
		return resultLst;
	}
	
	
	/**
	 * 根据登录用户所在公司 查询 该公司下 所有员工
	 */
	@Transactional
	@Override
	public List<Map<String, Object>> getComPanyUserName(Map<String, Object> map) throws Exception {
		//用户id获取公司信息
		List<Map<String,Object>> lstList = tourDao.selComByUserId(map);
		Map<String,Object> nameMap = new HashMap<String, Object>();
		nameMap.put("com_id", lstList.get(0).get("com_id").toString());
		//公司id 获取用户姓名
		return tourDao.selComPanyUserName(nameMap);
		
	}
	
	
	
	

	/*********************** App 任务接口 ********************************************************************/
	
	/**   if i work with android client 的 peoples again,i will fuck the hashiqi!
	 *                                         ,s555SB@@&                          
	 *                                      :9H####@@@@@Xi                        
	 *                                     1@@@@@@@@@@@@@@8                       
	 *                                   ,8@@@@@@@@@B@@@@@@8                      
	 *                                  :B@@@@X3hi8Bs;B@@@@@Ah,                   
	 *             ,8i                  r@@@B:     1S ,M@@@@@@#8;                 
	 *            1AB35.i:               X@@8 .   SGhr ,A@@@@@@@@S                
	 *            1@h31MX8                18Hhh3i .i3r ,A@@@@@@@@@5               
	 *            ;@&i,58r5                 rGSS:     :B@@@@@@@@@@A               
	 *             1#i  . 9i                 hX.  .: .5@@@@@@@@@@@1               
	 *              sG1,  ,G53s.              9#Xi;hS5 3B@@@@@@@B1                
	 *               .h8h.,A@@@MXSs,           #@H1:    3ssSSX@1                  
	 *               s ,@@@@@@@@@@@@Xhi,       r#@@X1s9M8    .GA981               
	 *               ,. rS8H#@@@@@@@@@@#HG51;.  .h31i;9@r    .8@@@@BS;i;          
	 *                .19AXXXAB@@@@@@@@@@@@@@#MHXG893hrX#XGGXM@@@@@@@@@@MS        
	 *                s@@MM@@@hsX#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&,      
	 *              :GB@#3G@@Brs ,1GM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B,     
	 *            .hM@@@#@@#MX 51  r;iSGAM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@8     
	 *          :3B@@@@@@@@@@@&9@h :Gs   .;sSXH@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:    
	 *      s&HA#@@@@@@@@@@@@@@M89A;.8S.       ,r3@@@@@@@@@@@@@@@@@@@@@@@@@@@r    
	 *   ,13B@@@@@@@@@@@@@@@@@@@5 5B3 ;.         ;@@@@@@@@@@@@@@@@@@@@@@@@@@@i    
	 *  5#@@#&@@@@@@@@@@@@@@@@@@9  .39:          ;@@@@@@@@@@@@@@@@@@@@@@@@@@@;    
	 *  9@@@X:MM@@@@@@@@@@@@@@@#;    ;31.         H@@@@@@@@@@@@@@@@@@@@@@@@@@:    
	 *   SH#@B9.rM@@@@@@@@@@@@@B       :.         3@@@@@@@@@@@@@@@@@@@@@@@@@@5    
	 *     ,:.   9@@@@@@@@@@@#HB5                 .M@@@@@@@@@@@@@@@@@@@@@@@@@B    
	 *           ,ssirhSM@&1;i19911i,.             s@@@@@@@@@@@@@@@@@@@@@@@@@@S   
	 *              ,,,rHAri1h1rh&@#353Sh:          8@@@@@@@@@@@@@@@@@@@@@@@@@#:  
	 *            .A3hH@#5S553&@@#h   i:i9S          #@@@@@@@@@@@@@@@@@@@@@@@@@A.
	 *
	 *
	 *    
	 */
	
	
	
	/**
	 * 查询 关于 登录用户  的 所有 巡视，检修，报修任务
	 */
	@Transactional
	public Map<String, Object> selTaskAllByUserId(Map<String, Object> map)
			throws Exception {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 巡视任务
		Map<String, Object> lstTourTask = new HashMap<String, Object>();
		// 检修任务
		Map<String, Object> lstOverhaulTask = new HashMap<String, Object>();
		// 报修任务
		Map<String, Object> lstRepairTask = new HashMap<String, Object>();
		
		//巡视
		if (map.get("stat").toString().equals("1")) {
			
			// 我创建的
			Map<String, Object> tourAppointMap = new HashMap<String, Object>();
			tourAppointMap.put("appoint_id", map.get("userId"));
			List<Map<String, Object>> lstTourAppoint = tourDao.selTourTaskAppointByUserId(tourAppointMap);

			// 我执行的
			Map<String, Object> tourExecuteMap = new HashMap<String, Object>();
			tourExecuteMap.put("task_execute_id", map.get("userId"));
			List<Map<String, Object>> lstTourExecute = tourDao.selTourTaskExecuteByUserId(tourExecuteMap);

			// 我审核的
			Map<String, Object> tourCheckMap = new HashMap<String, Object>();
			tourCheckMap.put("task_check_id", map.get("userId"));
			List<Map<String, Object>> lstTourCheck = tourDao.selTourTaskCheckByUserId(tourCheckMap);

			lstTourTask.put("lstTourAppoint", lstTourAppoint);
			lstTourTask.put("lstTourExecute", lstTourExecute);
			lstTourTask.put("lstTourCheck", lstTourCheck);
			
			resultMap.put("lstTourTask", lstTourTask);

		}else if (map.get("stat").toString().equals("2")) {
			//检修
			
			// 我创建的
			Map<String, Object> overhaulAppointMap = new HashMap<String, Object>();
			overhaulAppointMap.put("appoint_id", map.get("userId"));
			List<Map<String, Object>> lstOverhaulAppoint = tourDao.selOverhaulTaskAppointByUserId(overhaulAppointMap);

			// 我执行的
			Map<String, Object> overhaulExecuteMap = new HashMap<String, Object>();
			overhaulExecuteMap.put("task_execute_id", map.get("userId"));
			List<Map<String, Object>> lstOverhaulExecute = tourDao.selOverhaulTaskExecuteByUserId(overhaulExecuteMap);

			// 我审核的
			Map<String, Object> overhaulCheckMap = new HashMap<String, Object>();
			overhaulCheckMap.put("task_check_id", map.get("userId"));
			List<Map<String, Object>> lstoverhaulCheck = tourDao.selOverhaulTaskCheckByUserId(overhaulCheckMap);

			lstOverhaulTask.put("lstOverhaulAppoint", lstOverhaulAppoint);
			lstOverhaulTask.put("lstOverhaulExecute", lstOverhaulExecute);
			lstOverhaulTask.put("lstoverhaulCheck", lstoverhaulCheck);
			
			resultMap.put("lstOverhaulTask", lstOverhaulTask);
			
		}else if (map.get("stat").toString().equals("3")) {
			// 报修
			
			// 我创建的
			Map<String, Object> repairCrtUseMap = new HashMap<String, Object>();
			repairCrtUseMap.put("crt_use_id", map.get("userId"));
			List<Map<String, Object>> lstRepairCrtUse = tourDao.selRepairTaskCrtByUserId(repairCrtUseMap);

			// 我维修的
			Map<String, Object> repairRepairUseMap = new HashMap<String, Object>();
			repairRepairUseMap.put("repair_use_id", map.get("userId"));
			List<Map<String, Object>> lstRepairRepairUse = tourDao.selRepairTaskRepairByUserId(repairRepairUseMap);

			// 我审核的
			Map<String, Object> repairCheckMap = new HashMap<String, Object>();
			repairCheckMap.put("check_use_id", map.get("userId"));
			List<Map<String, Object>> lstRepairCheckUse = tourDao.selRepairTaskCheckByUserId(repairCheckMap);

			lstRepairTask.put("lstRepairCrtUse", lstRepairCrtUse);
			lstRepairTask.put("lstRepairRepairUse", lstRepairRepairUse);
			lstRepairTask.put("lstRepairCheckUse", lstRepairCheckUse);
			
			resultMap.put("lstRepairTask", lstRepairTask);

		}else{
			
			// 我创建的
			Map<String, Object> tourAppointMap = new HashMap<String, Object>();
			tourAppointMap.put("appoint_id", map.get("userId"));
			List<Map<String, Object>> lstTourAppoint = tourDao.selTourTaskAppointByUserId(tourAppointMap);

			// 我执行的
			Map<String, Object> tourExecuteMap = new HashMap<String, Object>();
			tourExecuteMap.put("task_execute_id", map.get("userId"));
			List<Map<String, Object>> lstTourExecute = tourDao.selTourTaskExecuteByUserId(tourExecuteMap);

			// 我审核的
			Map<String, Object> tourCheckMap = new HashMap<String, Object>();
			tourCheckMap.put("task_check_id", map.get("userId"));
			List<Map<String, Object>> lstTourCheck = tourDao.selTourTaskCheckByUserId(tourCheckMap);

			lstTourTask.put("lstTourAppoint", lstTourAppoint);
			lstTourTask.put("lstTourExecute", lstTourExecute);
			lstTourTask.put("lstTourCheck", lstTourCheck);
			
			resultMap.put("lstTourTask", lstTourTask);

			//检修
			// 我创建的
			Map<String, Object> overhaulAppointMap = new HashMap<String, Object>();
			overhaulAppointMap.put("appoint_id", map.get("userId"));
			List<Map<String, Object>> lstOverhaulAppoint = tourDao.selOverhaulTaskAppointByUserId(overhaulAppointMap);

			// 我执行的
			Map<String, Object> overhaulExecuteMap = new HashMap<String, Object>();
			overhaulExecuteMap.put("task_execute_id", map.get("userId"));
			List<Map<String, Object>> lstOverhaulExecute = tourDao.selOverhaulTaskExecuteByUserId(overhaulExecuteMap);

			// 我审核的
			Map<String, Object> overhaulCheckMap = new HashMap<String, Object>();
			overhaulCheckMap.put("task_check_id", map.get("userId"));
			List<Map<String, Object>> lstoverhaulCheck = tourDao.selOverhaulTaskCheckByUserId(overhaulCheckMap);

			lstOverhaulTask.put("lstOverhaulAppoint", lstOverhaulAppoint);
			lstOverhaulTask.put("lstOverhaulExecute", lstOverhaulExecute);
			lstOverhaulTask.put("lstoverhaulCheck", lstoverhaulCheck);
			
			resultMap.put("lstOverhaulTask", lstOverhaulTask);
			
			
			// 报修
			// 我创建的
			Map<String, Object> repairCrtUseMap = new HashMap<String, Object>();
			repairCrtUseMap.put("crt_use_id", map.get("userId"));
			List<Map<String, Object>> lstRepairCrtUse = tourDao.selRepairTaskCrtByUserId(repairCrtUseMap);

			// 我维修的
			Map<String, Object> repairRepairUseMap = new HashMap<String, Object>();
			repairRepairUseMap.put("repair_use_id", map.get("userId"));
			List<Map<String, Object>> lstRepairRepairUse = tourDao.selRepairTaskRepairByUserId(repairRepairUseMap);

			// 我审核的
			Map<String, Object> repairCheckMap = new HashMap<String, Object>();
			repairCheckMap.put("check_use_id", map.get("userId"));
			List<Map<String, Object>> lstRepairCheckUse = tourDao.selRepairTaskCheckByUserId(repairCheckMap);

			lstRepairTask.put("lstRepairCrtUse", lstRepairCrtUse);
			lstRepairTask.put("lstRepairRepairUse", lstRepairRepairUse);
			lstRepairTask.put("lstRepairCheckUse", lstRepairCheckUse);
			
			resultMap.put("lstRepairTask", lstRepairTask);
		}
	
		return resultMap;
	}

	
	
	
	
	
}
