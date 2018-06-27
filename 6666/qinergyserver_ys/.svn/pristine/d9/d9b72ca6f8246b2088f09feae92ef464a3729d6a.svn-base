package com.qinergy.dao.statisticanalysis.analysis.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.statisticanalysis.analysis.EfficAnalysisDao;

/**
 * @desc: 电站分析（电站和设备分析）dao实现类
 * @author: Qist
 * @date: 2017年11月1日
 */
@Repository("analysisDao")
public class EfficAnalysisDaoImpl extends BaseDao implements EfficAnalysisDao{

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getStationListByComId(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getStationListByComId", map);
		
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getOverallEffic(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getOverallEffic", map);
		
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getOverallEfficPVS(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getOverallEfficPVS", map);
		
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getOverallEfficEff(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getOverallEfficEff", map);
		
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getOverallEfficHv(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getOverallEfficHv", map);
		
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getPlanPvsPower(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getPlanPvsPower", map);
		
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getMonthDataStation(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getMonthDataStation", map);
		
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getDiscardRate(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getDiscardRate", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getLossAnalysis(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getLossAnalysis", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getSolarEnergyResources(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getSolarEnergyResources", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getInverterProp(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("efficAnalysisMapper.getInverterProp", map);
	}

}
