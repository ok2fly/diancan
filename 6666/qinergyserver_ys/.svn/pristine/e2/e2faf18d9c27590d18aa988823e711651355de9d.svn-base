package com.qinergy.dao.integratmonitor.dcdc;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.integratmonitor.dcdc.DcdcDao;

@Repository("dcdcDao")
public class DcdcDaoImpl extends BaseDao implements DcdcDao {

	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getDCDCRealByNum(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("dcdcMapper.getDCDCRealByNum", map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getDCDCRealsByNum(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("dcdcMapper.getDCDCRealsByNum", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDCDCRealList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dcdcMapper.getDCDCRealList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getDCDCEquByNum(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> lst = sqlSessionTemplate.selectList("dcdcMapper.getDCDCEquByNum", map);
		
		if(lst != null && !lst.isEmpty() && lst.get(0) != null){
			
			return lst.get(0);
			
		}else{
			
			return null;
		}
		
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getDCDCHistoryCount(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("dcdcMapper.getDCDCHistoryCount", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDCDCHistoryList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dcdcMapper.getDCDCHistoryList", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDCDCHistoryGraph(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dcdcMapper.getDCDCHistoryGraph", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDCDCFaultList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dcdcMapper.getDCDCFaultList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDCDCRepairList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dcdcMapper.getDCDCRepairList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDCDCMainList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dcdcMapper.getDCDCMainList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDCDCHealthList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dcdcMapper.getDCDCHealthList", map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDCDCStatCount(Map<String, Object> map) throws Exception {
		 return sqlSessionTemplate.selectList("dcdcMapper.getDCDCStatCount", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDCDCEquList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dcdcMapper.getDCDCEquList", map);
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
		return this.sqlSessionTemplate.selectList("dcdcMapper.getEquLstByPwsEquTyp", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDcdcInfByEquNum(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("dcdcMapper.getDcdcInfByEquNum", map);
	}
	
}
