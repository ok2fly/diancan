package com.qinergy.dao.statisticanalysis.analysis.impl;

import java.text.ParseException;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.statisticanalysis.analysis.EnergyConsumAnalysisDao;

/**
 * @desc:  能耗分析 dao实现类
 * @author: Qist
 * @date: 2017年11月4日
 */
@Repository("consumAnalysisDao")
public class EnergyConsumAnalysisDaoImpl extends BaseDao implements EnergyConsumAnalysisDao{

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Map<String, Object> getElecStatistics(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("energyConsumMapper.getElecStatistics", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Map<String, Object> getTotalElecStatistics(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("energyConsumMapper.getTotalElecStatistics", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Map<String, Object> getElecAnalysis(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("energyConsumMapper.getElecAnalysis", map);
	}

	


}
