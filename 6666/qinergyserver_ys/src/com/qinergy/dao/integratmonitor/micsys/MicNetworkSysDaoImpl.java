package com.qinergy.dao.integratmonitor.micsys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.integratmonitor.micsys.MicNetworkSysDao;
@Repository("micNetworkSysDao")
public class MicNetworkSysDaoImpl extends BaseDao implements MicNetworkSysDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getMicSysRealByEquNum(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("micsysMapper.getMicSysRealByEquNum", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getMicSysRealsByEquNum(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("micsysMapper.getMicSysRealsByEquNum", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMicSysRealList(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("micsysMapper.getMicSysRealList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMicSysHistoryList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("micsysMapper.getMicSysHistoryList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getMicSysHistoryCount(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectOne("micsysMapper.getMicSysHistoryCount", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getMicSysTolPower(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("micsysMapper.getMicSysTolPower", map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("micsysMapper.getEquLstByPwsEquTyp", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMicsysInfByEquNum(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("micsysMapper.getMicsysInfByEquNum", map);
	}
}
