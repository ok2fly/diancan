package com.qinergy.dao.statisticanalysis.analysis.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.statisticanalysis.analysis.PowerRationAnalysisDao;

/**
 * @desc: 功率预测与限电分析dao实现类
 * @author: Qist
 * @date: 2017年11月4日
 */
@Repository("rationAnalysisDao")
public class PowerRationAnalysisDaoImpl extends BaseDao implements PowerRationAnalysisDao{

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public  List<Map<String, Object>> getPowerRation(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("rationAnalysisMapper.getPowerRation", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getEnergyStorage(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("rationAnalysisMapper.getEnergyStorage", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getEnergyStoragePlan(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("rationAnalysisMapper.getEnergyStoragePlan", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getStorNetCharge(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("rationAnalysisMapper.getStorNetCharge", map);
	}



}
