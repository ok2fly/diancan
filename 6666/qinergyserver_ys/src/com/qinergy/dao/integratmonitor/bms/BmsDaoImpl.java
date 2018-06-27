package com.qinergy.dao.integratmonitor.bms;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("bmsDao")
public class BmsDaoImpl extends BaseDao implements BmsDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfo() throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfo");
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoNew(Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoNew",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoList(Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoList",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoListById(Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoListById",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoByYear(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoByYear",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoByYearList(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoByYearList",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoByMonth(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoByMonth",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoByMonthList(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoByMonthList",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoByDayList(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoByDayList",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoByDayListCou(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoByDayListCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfoByDayGraph(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfoByDayGraph",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsStatOne() throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsStatOne");
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsStatTwo() throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsStatTwo");
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsStatThree() throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsStatThree");
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsStatFour() throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsStatFour");
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsStatFive() throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsStatFive");
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsLstByPwsEquTyp(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsLstByPwsEquTyp",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBmsInfByEquNum(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("bms.getBmsInfByEquNum",map);
	}

	
	

	
}
