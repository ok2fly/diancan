package com.qinergy.dao.integratmonitor.meter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.integratmonitor.meter.MeterDao;

/**
 * @desc: 
 * @author: Qist
 * @date: 2017年10月27日
 */
@Repository("meterDao")
public class MeterDaoImpl extends BaseDao implements MeterDao{

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getMeterRealByEquNum(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("meterMapper.getMeterRealByEquNum", map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getMeterRealsByEquNum(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("meterMapper.getMeterRealsByEquNum", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMeterRealList(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("meterMapper.getMeterRealList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMeterHistoryList(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("meterMapper.getMeterHistoryList", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMeterHistoryGraph(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("meterMapper.getMeterHistoryGraph", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getMeterHistoryCount(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("meterMapper.getMeterHistoryCount", map);
	}


	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMeterInfByEquNum(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("meterMapper.getMeterInfByEquNum", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("meterMapper.getEquLstByPwsEquTyp", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMeterRealListMonth(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("meterMapper.getMeterRealListMonth", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMeterHistoryListMonth(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("meterMapper.getMeterHistoryListMonth", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMeterHistoryListMonthCou(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("meterMapper.getMeterHistoryListMonthCou", map);
	}

}
