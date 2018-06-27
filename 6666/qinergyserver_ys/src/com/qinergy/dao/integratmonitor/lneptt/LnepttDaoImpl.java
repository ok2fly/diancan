package com.qinergy.dao.integratmonitor.lneptt;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("lnepttDao")
public class LnepttDaoImpl extends BaseDao implements LnepttDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttLstByPwsEquTyp(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttLstByPwsEquTyp",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfByEquNum(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttInfByEquNum",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttById(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttById",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfoById(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttInfoById",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttNow(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttNow",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfoByYear(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttInfoByYear",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfoByYearList(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttInfoByYearList",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfoByMonth(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttInfoByMonth",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfoByMonthList(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttInfoByMonthList",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfoByDayList(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttInfoByDayList",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfoByDayListCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttInfoByDayListCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getLnepttInfoByDayGraph(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("lneptt.getLnepttInfoByDayGraph",map);
	}

	

	

	
}
