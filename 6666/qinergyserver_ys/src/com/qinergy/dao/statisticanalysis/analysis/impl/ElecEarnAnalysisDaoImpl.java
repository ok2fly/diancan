package com.qinergy.dao.statisticanalysis.analysis.impl;

import java.text.ParseException;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.statisticanalysis.analysis.ElecEarnAnalysisDao;

/**
 * @desc:  电量与收益分析 dao实现类
 * @author: Qist
 * @date: 2017年11月4日
 */
@Repository("elecEarnAnalysisDao")
public class ElecEarnAnalysisDaoImpl extends BaseDao implements ElecEarnAnalysisDao{


	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Map<String, Object> getFeaElecAnalysis(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("elecEarnMapper.getFeaElecAnalysis", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Map<String, Object> getPracElecAndEarnAnalysis(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("elecEarnMapper.getPracElecAndEarnAnalysis", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Map<String, Object> getForeElecAndEarnAnalysis(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("elecEarnMapper.getForeElecAndEarnAnalysis", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Map<String, Object> getForeElecAnalysis(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("elecEarnMapper.getForeElecAnalysis", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Map<String, Object> getPlanElecAnalysis(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("elecEarnMapper.getPlanElecAnalysis", map);
	}

}
