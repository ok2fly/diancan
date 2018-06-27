package com.qinergy.dao.integratmonitor.acdb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("acdbDao")
public class AcdbDaoImpl extends BaseDao implements AcdbDao {

	 /**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAcdbInfByEquNum(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("acdb.getAcdbInfByEquNum",map);
	}

	 /**
		 * {@inheritDoc}
		 * @param map
		 * @return
		 * @throws Exception
		 */
	@Override
	public List<Map<String, Object>> getAcdbInfoNewById(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("acdb.getAcdbInfoNewById",map);
	}

	 /**
		 * {@inheritDoc}
		 * @param map
		 * @return
		 * @throws Exception
		 */
	@Override
	public List<Map<String, Object>> getAcdbById(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("acdb.getAcdbById",map);
	}

	

	
}
