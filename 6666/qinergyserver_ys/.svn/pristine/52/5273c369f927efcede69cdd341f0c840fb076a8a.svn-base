/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.operations.tour;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dto.BaseTransferEntity;

/**
 * <p>
 * This contains the following methods:<br/> 
 * <p>
 * 
 * @author zy
 * @version 1.0
 * @since 1.0
 */

public interface TourService {
	
	/**
	 * 电站查询路线 （暂时没有用到）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getrouteByPws(Map<String, Object> map)
			throws Exception;

	/**
	 * 公司查询 电站下的路线（）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getTourPwsByComId(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getTourRecordByRoute(
			Map<String, Object> map) throws Exception;

	/**
	 * 路线添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void InsertRouteName(Map<String, Object> map) throws Exception;

	/**
	 * 路线删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void delRouteNam(Map<String, Object> map) throws Exception;

	/**
	 * id查询路线 回显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getRouteById(Map<String, Object> map)
			throws Exception;

	/**
	 * 路线 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> updRoute(Map<String, Object> map)
			throws Exception;

	/**
	 *  记录 添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> insertRecord(Map<String, Object> map)
			throws Exception;

	/**
	 * 记录 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> delRecord(Map<String, Object> map)
			throws Exception;

	/**
	 * 记录 id查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getRecordById(Map<String, Object> map)
			throws Exception;

	/**
	 *  记录 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> updRecord(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修 根据电站获取所有检修路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getOverhaulRouteByPws(
			Map<String, Object> map) throws Exception;

	/**
	 * 检修 根据电站获取所有检修路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getOverhaulTourRecordByRoute(
			Map<String, Object> map) throws Exception;

	/**
	 * 检修 路线添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void InsertOverhaulRouteName(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修路线删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> delOverhaulRouteNam(Map<String, Object> map)
			throws Exception;

	/**
	 * id查询检修路线 回显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getOverhaulRouteById(
			Map<String, Object> map) throws Exception;

	/**
	 * 检修路线 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> updOverhaulRoute(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修记录添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> insertOverhaulRecord(
			Map<String, Object> map) throws Exception;

	/**
	 * 检修记录 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> delOverhaulRecord(Map<String, Object> map)
			throws Exception;

	/**
	 *  id查看检修记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getOverhaulRecordById(
			Map<String, Object> map) throws Exception;

	/**
	 * 检修记录 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> updOverhaulRecord(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据巡视路线id 获取计划列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourPlanByroutId(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视计划 添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertTourPlan(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视计划 任务 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourPlan(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据id查看巡视计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourPlanById(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视计划 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delTourPlan(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据巡视计划id 获取任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTaskByPlanId(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据检修路线id 获取计划列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulPlanByroutId(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据检修计划 获取任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulTaskByPlanId(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修计划 添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertOverhaulPlan(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修计划 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulPlan(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据id查看检修计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulPlanById(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据id删除检修计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delOverhaulPlan(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据用户id查看与自己有关的报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRepairByUserId(Map<String, Object> map)
			throws Exception;

	/**
	 * 报修任务添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRepairTask(Map<String, Object> map)
			throws Exception;

	/**
	 * 报修任务添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRepairTaskImg(Map<String, Object> map)
			throws Exception;

	/**
	 *  查看巡视路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourRouteNam(Map<String, Object> map)
			throws Exception;

	/**
	 * 查看检修路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulRouteNam(Map<String, Object> map)
			throws Exception;

	/**
	 *  添加巡视路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRouteOrOverhaul(Map<String, Object> map)
			throws Exception;

	/**
	 * 删除路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delRouteOrOverhaul(Map<String, Object> map)
			throws Exception;

	/**
	 * 查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourOrOverhaulByName(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据路线id查询巡视路线的电站经纬度
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRouteOrOverhaulNamePwsByRouteNameId(
			Map<String, Object> map) throws Exception;

	/**
	 * 查看巡视任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRouteTask(Map<String, Object> map)
			throws Exception;

	/**
	 * 查看检修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulTask(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 审核通过
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourTaskStaCheck(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 驳回
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourTaskStaReject(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 开始任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourTaskStaExecute(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delTourTaskSta(Map<String, Object> map)
			throws Exception;

	/**
	 * 查看巡视任务 type
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRouteTaskType(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 审核通过
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulTaskStaCheck(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 驳回
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulTaskStaReject(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 开始任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulTaskStaExecute(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delOverhaulTaskSta(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 新增
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insTourTask(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 新增
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> instOverhaulTask(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 查看任务记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selTaskRecord(Map<String, Object> map) throws Exception;

	/**
	 * 检修任务 查看任务记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selOverhaulTaskRecord(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 记录添加/修改
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> updOrInsTourRecord(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 通过记录id查看记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selTourRecordByRouteId(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 指派
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> tourTaskAppoint(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 提交
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> tourTaskSubmit(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourTaskById(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 回显
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourTaskById(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 记录添加/修改
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> updOrInsOverhaulRecord(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 记录id查看记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selOverhaulRecordByRouteId(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 指派
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> overhaulTaskAppoint(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 提交
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> overhaulTaskSubmit(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修任务 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulTaskById(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务 回显
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulTaskById(Map<String, Object> map)
			throws Exception;

	/**
	 * 报修 列表显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepair(Map<String, Object> map)
			throws Exception;

	/**
	 * 报修 新建报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRepair(Map<String, Object> map)
			throws Exception;

	/**
	 * 报修 节点添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRepariNode(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修 修改报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updateRepair(Map<String, Object> map)
			throws Exception;

	/**
	 * 报修 删除报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delRepair(Map<String, Object> map)
			throws Exception;

	/**
	 * 报修 修改任务 信息回显
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairById(Map<String, Object> map)
			throws Exception;

	/**
	 * 报废 列表显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selScrap(Map<String, Object> map)throws Exception;

	/**
	 * 报废 新增
	 * @param map
	 * @return
	 * @throws Exception
	 */
	 List<Map<String, Object>> insertScrap(Map<String, Object> map)throws Exception;

		/**
		 * 报废 修改
		 * @param map
		 * @return
		 * @throws Exception
		 */
	 List<Map<String, Object>> updateScrap(Map<String, Object> map)throws Exception;

		/**
		 * 报废 信息回显
		 * @param map
		 * @return
		 * @throws Exception
		 */
	 Map<String, Object> selScrapById(Map<String, Object> map)throws Exception;

		/**
		 * 报废 删除
		 * @param map
		 * @return
		 * @throws Exception
		 */
	List<Map<String, Object>> delScrap(Map<String, Object> map)throws Exception;

	/**
	 * 报修 开始报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRepairSta(Map<String, Object> map)throws Exception;

	/**
	 * 报修 报修节点修改
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRepairNode(Map<String, Object> map)throws Exception;

	/**
	 * 报修 根据报修节点id查看 信息回显
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selRepairNodeById(Map<String, Object> map)throws Exception;

	/**
	 * 报修 任务提交 报修任务待审核
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRepairStaFour(Map<String, Object> map)throws Exception;

	/**
	 * 报修 任务提交 审核或驳回
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRepairStaIfSuccess(Map<String, Object> map)throws Exception;

	/**
	 * 报废 第一次审核或驳回
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updScrapStaOne(Map<String, Object> map)throws Exception;

	/**
	 * 报废 第二次审核或驳回
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updScrapStaTwo(Map<String, Object> map)throws Exception;

	/**
	 * 报修 根据报修id查看该3条记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairNodeAndRepair(Map<String, Object> map)throws Exception;

	/**
	 * 巡视计划 列表显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourPlan(Map<String, Object> map)throws Exception;

	/**
	 * 巡视计划 修改该计划的状态 为开始执行
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourPlanRunFlat(Map<String, Object> map)throws Exception;

	/**
	 * 检修计划 列表显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulPlan(Map<String, Object> map)throws Exception;

	/**
	 *  检修计划 修改该计划的状态 为开始执行
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulPlanRunFlat(Map<String, Object> map)throws Exception;

	/**
	 * 运维 图片上传 和 文件上传
	 * @param map
	 * @return
	 * @throws Exception
	 */
	BaseTransferEntity uploadImg(Map<String, Object> map,MultipartFile[] files, String imgPath);

	/**
	 * 运维 图片上传 和 文件上传
	 * @param map
	 * @return
	 * @throws Exception
	 */
	BaseTransferEntity upload(MultipartFile file);

	/**
	 * 报废 最新的信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selScrapNew(Map<String, Object> map)throws Exception;

	/**
	 * 巡视记录 查看最新的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selRouteTaskById(Map<String, Object> map)throws Exception;

	/**
	 * 检修记录 查询最新的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selOverhaulNewTaskById(Map<String, Object> map)throws Exception;

	/**
	 * 运维 id查看图片
	 * @param map
	 * @return
	 * @throws Exception
	 */
	 List<Map<String, Object>> getTourImageById(Map<String, Object> map)throws Exception;

		/**
		 * 运维 id查看文件
		 * @param map
		 * @return
		 * @throws Exception
		 */
	 List<Map<String, Object>> getTourFileById(Map<String, Object> map)throws Exception;

		/**
		 * 查看巡视任务 分页
		 * @param map
		 * @return
		 * @throws Exception
		 */
	public Map<String, Object> selRouteTaskCou(Map<String, Object> map)throws Exception;

	/**
	 *  查看检修任务 分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selOverhaulTaskCou(Map<String, Object> map)throws Exception;

	/**
	 * 报修 列表显示 分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selRepairCou(Map<String, Object> map)throws Exception;

	/**
	 * 报废 列表显示 分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selScrapCou(Map<String, Object> map)throws Exception;

	/**
	 *  巡视计划 列表显示 分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selTourPlanCou(Map<String, Object> map)throws Exception;

	/**
	 * 检修计划 列表显示 分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selOverhaulPlanCou(Map<String, Object> map)throws Exception;

	/**
	 * 巡视计划 列表显示 导出
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selTourPlanAll(Map<String, Object> map)throws Exception;

	/**
	 * 检修计划 列表显示 导出
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selOverhaulPlanAll(Map<String, Object> map)throws Exception;

	/**
	 * 检修路线 分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selOverhaulRouteNameCou(Map<String, Object> map)throws Exception;

	/**
	 * 查看巡视路线 分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selTourRouteNameCou(Map<String, Object> map)throws Exception;

	/**
	 * 检修计划 停止
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void updOverhaulPlanFlat(Map<String, Object> map)throws Exception;

	/**
	 * 检修计划 修改该计划的状态 为开始执行
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void updOverhaulPlanBegin(Map<String, Object> map)throws Exception;

	/**
	 * -巡视计划 停止
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void updTourPlanFlat(Map<String, Object> runFlat)throws Exception;

	/**
	 * 巡视计划 修改该计划的状态 为开始执行
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void updTourPlanBegin(Map<String, Object> runFlat)throws Exception;

	/**
	 * 巡视任务 查看任务记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selTaskRecordAll(Map<String, Object> map)throws Exception;

	/**
	 * 检修任务 查看任务记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selOverhaulTaskRecordAll(Map<String, Object> map)throws Exception;

	/**
	 * 报修 节点添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selRepairNodeNew(Map<String, Object> newMap)throws Exception;

	/**
	 * 根据报修id 查询报修记录信息 及状态
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selRepairNodeAndRepairAll(Map<String, Object> map)throws Exception;

	/**
	 * 根据报修id 查询报修记录所有信息 及附件
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selRepairNodeAll(Map<String, Object> map)throws Exception;

	/**
	 * 查询 关于 登录用户  的 所有 巡视，检修，报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selTaskAllByUserId(Map<String, Object> map)throws Exception;

	/**
	 * 根据路线名称 查询 检修路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selOverhaulRoteByName(
			Map<String, Object> nameMap)throws Exception;

	/**
	 * 根据 路线名称 查询 巡视路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selTourRoteByName(
			Map<String, Object> nameMap)throws Exception;

	/**
	 * 运维模块 查询所有运维人员   选择执行人时用此接口  查询本公司和下级公司所有运维人员
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selUserNameTour(Map<String, Object> map)throws Exception;

	/**
	 * 运维模块 查询所有运维人员   选择审核人时用此接口  查询 本公司和上级公司所有运维人员
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selUserNameTourCheck(Map<String, Object> map)throws Exception;

	/**
	 * 根据登录用户所在公司 查询 该公司下 所有员工
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getComPanyUserName(Map<String, Object> map)throws Exception;

	/**
	 * 报废信息 回显  App接口 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selScrapByIdApp(Map<String, Object> map)throws Exception;

	
}
