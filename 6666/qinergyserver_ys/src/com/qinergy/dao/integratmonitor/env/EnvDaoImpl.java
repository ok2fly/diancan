package com.qinergy.dao.integratmonitor.env;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("envDao")
public class EnvDaoImpl extends BaseDao implements EnvDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfo() throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfo");
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoNew(Map<String,Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoNew",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoNewFirst(Map<String,Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoNewFirst",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoNewById(Map<String,Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoNewById",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoByYear(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoByYear",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoByYearList(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoByYearList",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoByMonth(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoByMonth",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoByMonthList(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoByMonthList",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoByDayList(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoByDayList",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoByDayListCou(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoByDayListCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoByYearGraph(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoByYearGraph",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoByYearGraphHistory(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfoByYearGraphHistory",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvLstByPwsEquTyp(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvLstByPwsEquTyp",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvInfByEquNum(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvInfByEquNum",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquInfByPwsIdByForEnv(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEquInfByPwsIdByForEnv",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEnvDayHg() throws Exception {
		return this.sqlSessionTemplate.selectList("env.getEnvDayHg");
	}

	

	
}
