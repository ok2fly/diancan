package com.qinergy.dao.integratmonitor.ctl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("ctlDao")
public class CtlDaoImpl extends BaseDao implements CtlDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsLstByPwsEquTyp(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("ctl.getBmsLstByPwsEquTyp",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getCtlInfByEquNum(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("ctl.getCtlInfByEquNum",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getCtlStatByEquNum(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("ctl.getCtlStatByEquNum",map);
	}

	

	

	
}
