package com.qinergy.dao.operations.tour;

import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @desc: TourDao 实现类，无接口
 * @author zy
 */
public interface TourDao {

	/**
	 * 根据电站获取所有巡视路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getrouteByPws(Map<String, Object> map) throws Exception;

	/**
	 * 根据公司id获取所有站点id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourPwsByComId(Map<String, Object> map) throws Exception;

	/**
	 * 根据路线id获取记录信息
	 */
	List<Map<String, Object>> getTourRecordByRoute(Map<String, Object> map) throws Exception;

	/**
	 * 添加路线表
	 * @param map
	 * @throws Exception
	 */
	void insertRouteNam(Map<String, Object> map) throws Exception;

	/**
	 * 添加路线节点表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRoute(Map<String, Object> map) throws Exception;

	/**
	 * 查询路线最新一条信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRouteNamNew(Map<String, Object> map) throws Exception;

	 /**
	  * 路线删除
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> delRouteNam(Map<String, Object> map) throws Exception;

	/**
	 *  路线节点删除 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delRoute(Map<String, Object> map) throws Exception;

	/**
	 *  id查询路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRouteById(Map<String, Object> map) throws Exception;
	/**
	 * 巡视 路线更新 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRoute(Map<String, Object> map) throws Exception;

	/**
	 * 记录添加 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRecord(Map<String, Object> map) throws Exception;

	/**
	 * 记录 删除 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delRecord(Map<String, Object> map) throws Exception;
	
	/**
	 * id查询记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRecordById(Map<String, Object> map) throws Exception;

	/**
	 * 记录 更新 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRecord(Map<String, Object> map) throws Exception;

	/**
	 * 根据电站获取所有检修路线 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulRouteByPws(Map<String, Object> map) throws Exception;

	/**
	 * 根据路线id获取记录信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulTourRecordByRoute(Map<String, Object> map) throws Exception;

	/**
	 * 添加检修路线表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertOverhaulRouteNam(Map<String, Object> map) throws Exception;

	/**
	 * 添加检修路线节点表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertOverhaulRoute(Map<String, Object> map) throws Exception;

	/**
	 * 查询检修路线最新一条信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulRouteNamNew(Map<String, Object> map) throws Exception;

	/**
	 * 检修路线删除 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delOverhaulRouteNam(Map<String, Object> map) throws Exception;

	/**
	 * 检修路线节点删除 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delOverhaulRoute(Map<String, Object> map) throws Exception;

	/**
	 * id查询检修路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulRouteById(Map<String, Object> map) throws Exception;

	/**
	 * 路线更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulRoute(Map<String, Object> map) throws Exception;

	/**
	 * 记录添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertOverhaulRecord(Map<String, Object> map) throws Exception;

	/**
	 * 记录 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delOverhaulRecord(Map<String, Object> map) throws Exception;

	/**
	 * id查询记录 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulRecordById(Map<String, Object> map) throws Exception;

	/**
	 * 记录 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulRecord(Map<String, Object> map) throws Exception;

	/**
	 * 根据巡视路线id 获取巡视计划 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourPlanByroutId(Map<String, Object> map) throws Exception;

	/**
	 * 巡视计划添加 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertTourPlan(Map<String, Object> map) throws Exception;

	/**
	 * 巡视 计划  更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourPlan(Map<String, Object> map) throws Exception;

	/**
	 * 巡视任务添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertTourTask(Map<String, Object> map) throws Exception;

	/**
	 * 巡视 任务  更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourTask(Map<String, Object> map) throws Exception;

	/**
	 * 查询路线最新一条信息 
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourPlan() throws Exception;

	/**
	 * 根据id查看巡视 计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourPlanById(Map<String, Object> map) throws Exception;

	/**
	 * 巡视计划 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delTourPlan(Map<String, Object> map) throws Exception;

	/**
	 * 根据巡视计划  获取任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTaskByPlanId(Map<String, Object> map) throws Exception;

	/**
	 * 根据检修路线id 获取检修计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulPlanByroutId(Map<String, Object> map) throws Exception;

	/**
	 * 根据检修计划  获取任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulTaskByPlanId(Map<String, Object> map) throws Exception;

	/**
	 * 检修计划添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertOverhaulPlan(Map<String, Object> map) throws Exception;

	/**
	 * 查询检修计划最新一条信息 
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulPlan() throws Exception;

	/**
	 * 检修任务添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertOverhaulTask(Map<String, Object> map) throws Exception;

	/**
	 * 检修 计划  更新 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulPlan(Map<String, Object> map) throws Exception;

	/**
	 * 检修 任务  更新 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulTask(Map<String, Object> map) throws Exception;

	/**
	 * 根据id查看检修 计划  按日
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulPlanById(Map<String, Object> map) throws Exception;

	/**
	 * 检修计划 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delOverhaulPlan(Map<String, Object> map) throws Exception;

	/**
	 * 报修管理 查看跟自己有关的报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getRepairByUserId(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修任务添加 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRepairTask(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修任务添加 -
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
	 *  查看检修路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOverhaulRouteNam(Map<String, Object> map)
			throws Exception;

	 /**
	  * 查询所有巡视路线节点
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selTourRoute(Map<String, Object> map)
			throws Exception;

	/**
	 *  查询所有巡视路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourRouteName(Map<String, Object> map)
			throws Exception;

	/**
	 *  查询所有检修路线节点 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulRoute(Map<String, Object> map)
			throws Exception;

	 /**
	  * 查询所有检修路线
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selOverhaulRouteName(Map<String, Object> map)
			throws Exception;

	 /**
	  * 根据路线id查询巡视路线的电站经纬度
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selRouteNamePwsByRouteNameId(
			Map<String, Object> map) throws Exception;

	/**
	 *  根据路线id查询检修路线的电站经纬度
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulNamePwsByRouteNameId(
			Map<String, Object> map) throws Exception;

	 /**
	  * 巡视任务查看
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selRouteTask(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修任务查看
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulTask(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 审核通过
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourTaskStaCheck(Map<String, Object> map)
			throws Exception;

	List<Map<String, Object>> updOverhaulTaskStaOrDel(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务查看  type
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRouteTaskType(Map<String, Object> map)
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
	 * 巡视任务  开始任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourTaskStaExecute(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务  删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delTourTaskSta(Map<String, Object> map)
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
	 * 检修任务 审核通过
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulTaskStaReject(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务  删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delOverhaulTaskSta(Map<String, Object> map)
			throws Exception;

	/**
	 * 检修任务  开始任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulTaskStaExecute(Map<String, Object> map)
			throws Exception;

	List<Map<String, Object>> insertOverhaulTaskSta(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 新增
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
	 * 巡视任务 查询路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRouteNameById(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 查询路线节点
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRouteById(Map<String, Object> map)
			throws Exception;

	/**检修任务 查询路线
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulRouteNameById(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 查询路线节点
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulRouteById(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视记录修改
	 * @param map
	 * @throws Exception
	 */
	void updTourRecord(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视记录新增
	 * @param map
	 * @throws Exception
	 */
	void insTourRecord(Map<String, Object> map)
			throws Exception;

	/**
	 * 巡视任务 通过记录id查看是否有记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourRecordByRouteId(Map<String, Object> map)
			throws Exception;

	/**
	 * 指派 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> tourTaskAppoint(Map<String, Object> map)
			throws Exception;

	/**
	 * 任务提交
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> tourTaskSubmit(Map<String, Object> map)
			throws Exception;

	/**
	 *  修改任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourTaskById(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 回显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourTaskById(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修记录修改
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updateOverhaulRecord(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修任务 通过记录id查看是否有记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulRecordByRouteId(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修记录新增 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insOverhaulRecord(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修 指派 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> overhaulTaskAppoint(Map<String, Object> map)throws Exception;

	/**
	 *  检修  任务提交
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> overhaulTaskSubmit(Map<String, Object> map)throws Exception;

	/**
	 *  检修 修改任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulTaskById(Map<String, Object> map)throws Exception;

	/**
	 *  巡视任务 回显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulTaskById(Map<String, Object> map)throws Exception;

	/**
	 *  报修 列表显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepair(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修 节点添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRepariNode(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修 新建报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRepair(Map<String, Object> map)
			throws Exception;

	 /**
	  * 报修  修改报修任务
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> updateRepair(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修  删除报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delRepair(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修 修改任务 信息回显
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairById(Map<String, Object> map)
			throws Exception;

	 /**
	  * 报报废 列表显示
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selScrap(Map<String, Object> map)
			throws Exception;

	 /**
	  * 报废 新建报废任务
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> insertScrap(Map<String, Object> map)
			throws Exception;

	/**
	 *  报废  修改报废任务 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updateScrap(Map<String, Object> map)
			throws Exception;

	 /**
	  * 报废 修改任务 信息回显
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selScrapById(Map<String, Object> map)
			throws Exception;

	/**
	 *  报废  删除报废任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> delScrap(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修  开始报修任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRepairSta(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修  根据报修id查询报修节点记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairNodeByRepairId(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修  报修节点修改
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRepairNode(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修  根据报修节点id查看  信息回显
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairNodeById(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修  任务提交  报修任务待审核
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRepairStaFour(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修  审核或驳回
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRepairStaIfSuccess(Map<String, Object> map)
			throws Exception;

	/**
	 *  报废   第一次审核或驳回
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updScrapStaOne(Map<String, Object> map)
			throws Exception;

	/**
	 *  报废   第二次审核或驳回
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updScrapStaTwo(Map<String, Object> map)
			throws Exception;

	 /**
	  * 巡视计划 列表显示
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selTourPlan(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视计划    开始执行
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourPlanRunFlat(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视  计划   自动添加巡视任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insTourTaskAutomatic(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修计划 列表显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulPlan(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修计划    开始执行
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulPlanRunFlat(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修 计划   自动添加巡视任务
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insOverhaulTaskAutomatic(Map<String, Object> map)
			throws Exception;

	/**
	 *  运维 图片添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insTourOrOverhaulImg(Map<String, Object> map)
			throws Exception;

	/**
	 *  运维 文件添加
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> insTourOrOverhaulFile(Map<String, Object> map);

	/**
	 *  巡视记录 查询最新的
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selRouteTaskById(Map<String, Object> map);

	/**
	 *  检修记录 查询最新的
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selOverhaulNewTaskById(Map<String, Object> map);

	/**
	 *  报废 最新的信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selScrapNew(Map<String, Object> map);

	/**
	 *  运维 id查看图片
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourImageById(Map<String, Object> map)throws Exception;

	/**
	 *  运维 id查看文件
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourFileById(Map<String, Object> map)throws Exception;

	 /**
	  * -巡视  通过记录id  查看图片
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selTourImgByRouteId(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视  通过记录id  查看文件
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourFileByRouteId(Map<String, Object> map)
			throws Exception;

	/**
	 *  查询所有检修路线 分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulRouteNameCou(Map<String, Object> map)
			throws Exception;

	/**
	 *  查询所有巡视路线  分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourRouteNameCou(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务查看  分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRouteTaskCou(Map<String, Object> map)
			throws Exception;

	 /**
	  * 检修任务查看  分页
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selOverhaulTaskCou(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修 列表显示  分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairCou(Map<String, Object> map)
			throws Exception;

	 /**
	  * 报报废 列表显示   分页
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selScrapCou(Map<String, Object> map)
			throws Exception;

	 /**
	  * 巡视计划 列表显示  分页
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selTourPlanCou(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视计划 列表显示  分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulPlanCou(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视计划 列表显示  导出功能
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourPlanAll(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视计划 列表显示  导出
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulPlanAll(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修计划    停止
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulPlanFlat(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视计划    停止
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourPlanFlat(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务  查询节点状态
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourRecordByTaskRoute(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修任务  查询节点状态-
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulRecordByTaskRoute(
			Map<String, Object> map) throws Exception;

	/**
	 *  巡视  通过任务 和 路线  查询所有 记录信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourAllByTaskRoute(
			Map<String, Object> map) throws Exception;

	/**
	 *  检修 通过任务 和 路线  查询所有 记录信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulAllByTaskRoute(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修节点  最新的一条记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairNodeNew(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修 根据报修任务id 和状态 查询信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairNodeByRepairSta(Map<String, Object> map)
			throws Exception;

	 /**
	  * 巡视任务     我创建的
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selTourTaskAppointByUserId(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务     我执行的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourTaskExecuteByUserId(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务     我审核的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourTaskCheckByUserId(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修任务     我创建的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulTaskAppointByUserId(
			Map<String, Object> map) throws Exception;

	/**
	 *  检修任务    我执行的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulTaskExecuteByUserId(
			Map<String, Object> map) throws Exception;

	/**
	 *  检修任务     我审核的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulTaskCheckByUserId(
			Map<String, Object> map) throws Exception;

	/**
	 *  报修任务     我创建的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairTaskCrtByUserId(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修任务     我维修的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairTaskRepairByUserId(
			Map<String, Object> map) throws Exception;

	/**
	 *  报修任务     我审核的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairTaskCheckByUserId(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视  通过任务 查询所有 记录信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourAllByTask(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修  通过任务 查询所有 记录信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulAllByTask(Map<String, Object> map)
			throws Exception;
	/**
	 *  根据 名称 查询 检修路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulRoteByName(Map<String, Object> map)
			throws Exception;
	/**
	 *  根据 名称 查询 巡视路线
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourRoteByName(Map<String, Object> map) throws Exception;

	/**
	 *  运维模块 查询所有运维人员   选择执行人时用此接口  通过公司id  查询 所有运维人员
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selUserNameTour(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修计划 显示 id查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulPlanMonth(Map<String, Object> map)
			throws Exception;

	/**
	 *  根据id查看巡视 计划 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getTourPlanMonth(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修计划 添加 下次时间
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> addOverhaulNextTime(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视计划 添加 下次时间
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> addTourPlanNextTime(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 增加流程记录  开始
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertTourRecordProcess(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 增加流程记录  查询 防止重复
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourRecordProcess(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 增加流程记录  修改
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updTourRecordProcess(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修任务 增加流程记录  开始-
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertOverhaulRecordProcess(
			Map<String, Object> map) throws Exception;

	/**
	 *  巡视任务 增加流程记录  查询 防止重复
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulRecordProcess(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视任务 增加流程记录  修改
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updOverhaulRecordProcess(Map<String, Object> map)
			throws Exception;

	/**
	 *  巡视  通过任务 查询所有 记录信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourAllRecord(Map<String, Object> map)
			throws Exception;

	/**
	 *  检修  通过任务 查询所有 记录信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selOverhaulAllRecord(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修任务 增加流程记录  开始
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> insertRepairRecordProcess(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修任务 增加流程记录  查询 防止重复-
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selRepairRecordProcess(Map<String, Object> map)
			throws Exception;

	/**
	 *  报修任务 增加流程记录  修改
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> updRepairRecordProcess(Map<String, Object> map)
			throws Exception;

	 /**
	  * 运维模块  系统消息添加 查询用户姓名
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selUserNameById(Map<String, Object> map)
			throws Exception;

	 /**
	  * 运维模块    选择执行人时使用  根据登录用户id 查询用户所在公司
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selComByUserId(Map<String, Object> map)
			throws Exception;

	 /**
	  * 运维模块    选择执行人时使用  根据公司id 查询下级公司
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> selComByComId(Map<String, Object> map)
			throws Exception;

	/**
	 *  运维模块    选择审核人时使用  根据公司id 查询公司
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selComByComFatId(Map<String, Object> map)
			throws Exception;

	/**
	 *  运维模块 使用公司id 获取 本公司所有人员信息  筛选用
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selComPanyUserName(Map<String, Object> map)
			throws Exception;

	/**
	 *  App 巡视  通过记录id  查看文件
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourFileByRouteIdApp(Map<String, Object> map)
			throws Exception;

	/**
	 *  App 巡视  通过记录id  查看图片
	 * @param imageMap
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selTourImgByRouteIdApp(Map<String, Object> imageMap)throws Exception;
	

	
	
	
	
	
}
