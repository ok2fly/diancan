package com.qinergy.dao.operations.tour;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.util.SpringContextUtil;

@Repository("tourDao")
public class TourDaoImpl extends BaseDao implements TourDao {


	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getrouteByPws(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getrouteByPws", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTourPwsByComId(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getTourPwsByComId", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTourRecordByRoute(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getTourRecordByRoute", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertRouteNam(Map<String, Object> map) throws Exception {

		this.sqlSessionTemplate.insert("tour.insertRouteNam", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourRoteByName(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourRoteByName", map);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public  List<Map<String, Object>> insertRoute(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.insertRoute", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getRouteNamNew(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getRouteNamNew", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delRouteNam(Map<String, Object> map) throws Exception {

		return 	this.sqlSessionTemplate.selectList("tour.delRouteNam", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delRoute(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.delRoute", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getRouteById(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getRouteById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updRoute(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.updRoute", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertRecord(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.insertRecord", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delRecord(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.delRecord", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getRecordById(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getRecordById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updRecord(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.updRecord", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulRouteByPws(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getOverhaulRouteByPws", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulTourRecordByRoute(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getOverhaulTourRecordByRoute", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertOverhaulRouteNam(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.insertOverhaulRouteNam", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulRoteByName(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulRoteByName", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertOverhaulRoute(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.insertOverhaulRoute", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulRouteNamNew(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getOverhaulRouteNamNew", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delOverhaulRouteNam(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.delOverhaulRouteNam", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delOverhaulRoute(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.delOverhaulRoute", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulRouteById(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getOverhaulRouteById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulRoute(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.updOverhaulRoute", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertOverhaulRecord(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.insertOverhaulRecord", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delOverhaulRecord(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.delOverhaulRecord", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulRecordById(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getOverhaulRecordById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulRecord(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.updOverhaulRecord", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTourPlanByroutId(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getTourPlanByroutId", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertTourPlan(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.insertTourPlan", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updTourPlan(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.updTourPlan", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertTourTask(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.insertTourTask", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updTourTask(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.updTourTask", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTourPlan() throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getTourPlan");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTourPlanById(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getTourPlanById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delTourPlan(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.delTourPlan", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTaskByPlanId(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getTaskByPlanId", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulPlanByroutId(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getOverhaulPlanByroutId", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulTaskByPlanId(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getOverhaulTaskByPlanId", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertOverhaulPlan(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.insertOverhaulPlan", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulPlan() throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getOverhaulPlan");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertOverhaulTask(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.insertOverhaulTask", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulPlan(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.updOverhaulPlan", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulTask(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.updOverhaulTask", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulPlanById(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.getOverhaulPlanById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulPlanFlat(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updOverhaulPlanFlat", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delOverhaulPlan(Map<String, Object> map) throws Exception {

		return this.sqlSessionTemplate.selectList("tour.delOverhaulPlan", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getRepairByUserId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.getRepairByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertRepairTask(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insertRepairTask", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertRepairTaskImg(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insertRepairTaskImg", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTourRouteNam(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.getTourRouteNam", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOverhaulRouteNam(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.getOverhaulRouteNam", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourRoute(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourRoute", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourRouteName(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourRouteName", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourRouteNameCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourRouteNameCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulRoute(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulRoute", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulRouteName(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulRouteName", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulRouteNameCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulRouteNameCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRouteNamePwsByRouteNameId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRouteNamePwsByRouteNameId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulNamePwsByRouteNameId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulNamePwsByRouteNameId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRouteTask(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRouteTask", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRouteTaskCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRouteTaskCou", map);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulTask(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulTask", map);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulTaskCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulTaskCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updTourTaskStaCheck(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updTourTaskStaCheck", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updTourTaskStaReject(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updTourTaskStaReject", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delTourTaskSta(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.delTourTaskSta", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updTourTaskStaExecute(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updTourTaskStaExecute", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertTourRecordProcess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insertTourRecordProcess", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourRecordProcess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourRecordProcess", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updTourRecordProcess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updTourRecordProcess", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulTaskStaOrDel(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updOverhaulTaskStaOrDel", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRouteTaskType(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRouteTaskType", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulTaskStaCheck(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updOverhaulTaskStaCheck", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulTaskStaReject(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updOverhaulTaskStaReject", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delOverhaulTaskSta(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.delOverhaulTaskSta", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulTaskStaExecute(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updOverhaulTaskStaExecute", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertOverhaulRecordProcess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insertOverhaulRecordProcess", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulRecordProcess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulRecordProcess", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulRecordProcess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updOverhaulRecordProcess", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertOverhaulTaskSta(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insertOverhaulTaskSta", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insTourTask(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insTourTask", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> instOverhaulTask(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.instOverhaulTask", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRouteNameById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRouteNameById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selUserNameById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selUserNameById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRouteById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRouteById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulRouteNameById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulRouteNameById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulRouteById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulRouteById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updTourRecord(Map<String, Object> map) throws Exception {
		
		 this.sqlSessionTemplate.selectList("tour.updTourRecord", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insTourRecord(Map<String, Object> map) throws Exception {
		
		 this.sqlSessionTemplate.selectList("tour.insTourRecord", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourRecordByRouteId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourRecordByRouteId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourImgByRouteId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourImgByRouteId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourFileByRouteId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourFileByRouteId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourImgByRouteIdApp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourImgByRouteIdApp", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourFileByRouteIdApp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourFileByRouteIdApp", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> tourTaskAppoint(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.tourTaskAppoint", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> tourTaskSubmit(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.tourTaskSubmit", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updTourTaskById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updTourTaskById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourTaskById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourTaskById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updateOverhaulRecord(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updateOverhaulRecord", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulRecordByRouteId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulRecordByRouteId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insOverhaulRecord(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insOverhaulRecord", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> overhaulTaskAppoint(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.overhaulTaskAppoint", map);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> overhaulTaskSubmit(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.overhaulTaskSubmit", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulTaskById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updOverhaulTaskById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulTaskById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulTaskById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepair(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRepair", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRepairCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertRepair(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insertRepair", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertRepariNode(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insertRepariNode", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updateRepair(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updateRepair", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delRepair(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.delRepair", map);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRepairById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairNodeByRepairSta(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRepairNodeByRepairSta", map);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selScrap(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selScrap", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selScrapCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selScrapCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertScrap(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insertScrap", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updateScrap(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updateScrap", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selScrapById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selScrapById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> delScrap(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.delScrap", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updRepairSta(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updRepairSta", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insertRepairRecordProcess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insertRepairRecordProcess", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairRecordProcess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRepairRecordProcess", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updRepairRecordProcess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updRepairRecordProcess", map);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairNodeByRepairId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRepairNodeByRepairId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updRepairNode(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updRepairNode", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairNodeNew(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRepairNodeNew", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairNodeById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selRepairNodeById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updRepairStaFour(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updRepairStaFour", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updRepairStaIfSuccess(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updRepairStaIfSuccess", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updScrapStaOne(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updScrapStaOne", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updScrapStaTwo(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updScrapStaTwo", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourPlan(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourPlan", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourPlanCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourPlanCou", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourPlanAll(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selTourPlanAll", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updTourPlanRunFlat(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updTourPlanRunFlat", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insTourTaskAutomatic(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insTourTaskAutomatic", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulPlan(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulPlan", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTourPlanMonth(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.getTourPlanMonth", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updTourPlanFlat(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.updTourPlanFlat", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulPlanAll(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulPlanAll", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulPlanCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.selOverhaulPlanCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> updOverhaulPlanRunFlat(Map<String, Object> map) throws Exception {
		
		sqlSessionTemplate = SpringContextUtil.getBean("SqlSessionTemplate");
		
		return this.sqlSessionTemplate.selectList("tour.updOverhaulPlanRunFlat", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insOverhaulTaskAutomatic(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insOverhaulTaskAutomatic", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insTourOrOverhaulImg(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("tour.insTourOrOverhaulImg", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> insTourOrOverhaulFile(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("tour.insTourOrOverhaulFile", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRouteTaskById(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("tour.selRouteTaskById",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulNewTaskById(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("tour.selOverhaulNewTaskById",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selScrapNew(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("tour.selScrapNew",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTourImageById(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.getTourImageById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTourFileById(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.getTourFileById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourRecordByTaskRoute(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selTourRecordByTaskRoute", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulRecordByTaskRoute(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selOverhaulRecordByTaskRoute", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourAllByTaskRoute(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selTourAllByTaskRoute", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourAllRecord(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selTourAllRecord", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourAllByTask(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selTourAllByTask", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulAllByTaskRoute(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selOverhaulAllByTaskRoute", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulAllRecord(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selOverhaulAllRecord", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulAllByTask(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selOverhaulAllByTask", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourTaskAppointByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selTourTaskAppointByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourTaskExecuteByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selTourTaskExecuteByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selTourTaskCheckByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selTourTaskCheckByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulTaskAppointByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selOverhaulTaskAppointByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulTaskExecuteByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selOverhaulTaskExecuteByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulTaskCheckByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selOverhaulTaskCheckByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairTaskCrtByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selRepairTaskCrtByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairTaskRepairByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selRepairTaskRepairByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selRepairTaskCheckByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selRepairTaskCheckByUserId", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selUserNameTour(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selUserNameTour",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selComByUserId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selComByUserId",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selComByComId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selComByComId",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selComByComFatId(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selComByComFatId",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selOverhaulPlanMonth(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selOverhaulPlanMonth",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> addOverhaulNextTime(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.addOverhaulNextTime",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> addTourPlanNextTime(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.addTourPlanNextTime",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selComPanyUserName(Map<String, Object> map) throws Exception{
		return this.sqlSessionTemplate.selectList("tour.selComPanyUserName",map);
	}
	
}
