package com.qinergy.dao.integratmonitor.dcdb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("dcdbDao")
public class DcdbDaoImpl extends BaseDao implements DcdbDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDcdbInfByEquNum(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("dcdb.getDcdbInfByEquNum",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDcdbInfoNewById(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("dcdb.getDcdbInfoNewById",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDcdbById(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("dcdb.getDcdbById",map);
	}

	

	
}
