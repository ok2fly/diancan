package com.qinergy.dao.integratmonitor.transf;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.integratmonitor.transf.TransformerDao;

/**
 * @desc:  
 * @author: Qist
 * @date: 2017年10月26日
 */
@Repository("transformerDao")
public class TransformerDaoImpl extends BaseDao implements TransformerDao{


	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getTransfRealByEquNum(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("transfMapper.getTransfRealByEquNum", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getTransfRealsByEquNum(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("transfMapper.getTransfRealsByEquNum", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getTransfRealList(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("transfMapper.getTransfRealList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getTransfHistoryList(
			Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("transfMapper.getTransfHistoryList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer getTransfHistoryCount(Map<String, Object> map)
			throws Exception {
		Map<String, Object> returnMap = sqlSessionTemplate.selectOne("transfMapper.getTransfHistoryCount", map);
		
		return Integer.parseInt(returnMap.get("cou").toString());
		
//		return sqlSessionTemplate.selectOne("transfMapper.getTransfHistoryCount", map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("transfMapper.getEquLstByPwsEquTyp", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getTransfInfByEquNum(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("transfMapper.getTransfInfByEquNum", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getTransfHistoryGraph(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("transfMapper.getTransfHistoryGraph", map);
	}
}
