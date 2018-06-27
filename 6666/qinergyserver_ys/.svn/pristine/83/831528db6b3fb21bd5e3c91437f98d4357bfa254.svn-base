package com.qinergy.dao.operations.training;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("trainingManageDao")
public class TrainingManageDaoImpl extends BaseDao implements TrainingManageDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insTrainingTyp(Map<String, Object> map) throws Exception {

		boolean result = false;
		int insert = sqlSessionTemplate.insert("trainingMapper.insTrainingTyp", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTrainingTypByName(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("trainingMapper.getTrainingTypByName", map);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updTrainingTyp(Map<String, Object> map) throws Exception {
		boolean result = false;
		int insert = sqlSessionTemplate.update("trainingMapper.updTrainingTyp", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delTrainingTyp(Map<String, Object> map) throws Exception {
		boolean result = false;
		int insert = sqlSessionTemplate.update("trainingMapper.delTrainingTyp", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getTrainingTypById(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectOne("trainingMapper.getTrainingTypById", map);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTrainingTypList(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectList("trainingMapper.getTrainingTypList", map);
	}

	// /////////////////////////////培训文件 /////////////////////////////////
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean uploadTrainFile(Map<String, Object> map) throws Exception {
		boolean result = false;
		if (sqlSessionTemplate.insert("trainingMapper.uploadTrainFile", map) > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delTrainFile(Map<String, Object> map) throws Exception {
		boolean result = false;
		if (sqlSessionTemplate.update("trainingMapper.delTrainFile", map) > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getFileById(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectOne("trainingMapper.getFileById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFileListByTrainNum(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectList("trainingMapper.getFileListByTrainNum", map);
	}

	// /////////////////////////////培训管理 /////////////////////////////////
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insTraining(Map<String, Object> map) throws Exception {

		boolean result = false;
		int insert = sqlSessionTemplate.insert("trainingMapper.insTraining", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updTraining(Map<String, Object> map) throws Exception {
		boolean result = false;
		int insert = sqlSessionTemplate.update("trainingMapper.updTraining", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean executeTraining(Map<String, Object> map) throws Exception {
		boolean result = false;
		int insert = sqlSessionTemplate.update("trainingMapper.executeTraining", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delTrainingById(Map<String, Object> map) throws Exception {

		boolean result = false;
		int insert = sqlSessionTemplate.update("trainingMapper.delTrainingById", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delBatchTrainingById(Map<String, Object> map) throws Exception {
		boolean result = false;
		int insert = sqlSessionTemplate.update("trainingMapper.delBatchTrainingById", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getTrainingById(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectOne("trainingMapper.getTrainingById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTrainingList(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectList("trainingMapper.getTrainingList", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getTrainingListCount(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectOne("trainingMapper.getTrainingListCount", map);
	}

	
	
	
	
	
	//////////培训  计划////////
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insTrainingPlan(Map<String, Object> map) throws Exception {

		boolean result = false;
		int insert = sqlSessionTemplate.insert("trainingMapper.insTrainingPlan", map);
		if (insert > 0) {
			result = true;
		}
		return result;

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updTrainingPlan(Map<String, Object> map) throws Exception {
		boolean result = false;
		int insert = sqlSessionTemplate.update("trainingMapper.updTrainingPlan", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delTrainingPlanById(Map<String, Object> map) throws Exception {

		boolean result = false;
		int insert = sqlSessionTemplate.update("trainingMapper.delTrainingPlanById", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delBatchTrainingPlanById(Map<String, Object> map) throws Exception {
		boolean result = false;
		int insert = sqlSessionTemplate.update("trainingMapper.delBatchTrainingPlanById", map);
		if (insert > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getTrainingPlanById(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectOne("trainingMapper.getTrainingPlanById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTrainingPlanList(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectList("trainingMapper.getTrainingPlanList", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getTrainingPlanListCount(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectOne("trainingMapper.getTrainingPlanListCount", map);
	}

}
