package com.qinergy.dao.statisticanalysis.analysis.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.statisticanalysis.analysis.SolarResourAnalysisDao;

/**
 * @desc: 电站分析（电站和设备分析）dao实现类
 * @author: Qist
 * @date: 2017年11月1日
 */
@Repository("solarResourAnalysisDao")
public class SolarResourAnalysisDaoImpl extends BaseDao implements SolarResourAnalysisDao{

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Map<String, Object> getRealSolarResources(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("solarResourAnalysisMapper.getRealSolarResources", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getFeaSolarResources(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("solarResourAnalysisMapper.getFeaSolarResources", map);
	}

	/*@Override
	public Map<String, Object> getSolarData(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("solarResourAnalysisMapper.getSolarData", map);
	}*/
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public List<Map<String, Object>> getSolarDataEnvInfo(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("solarResourAnalysisMapper.getSolarDataEnvInfo", map);
	}
	

}
