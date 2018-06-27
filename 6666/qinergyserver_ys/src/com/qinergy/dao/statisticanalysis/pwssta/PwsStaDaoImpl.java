package com.qinergy.dao.statisticanalysis.pwssta;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("pwsStaDao")
public class PwsStaDaoImpl extends BaseDao implements PwsStaDao {
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPwsByComId(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPwsByComId",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getStaByPws(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getStaByPws",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getSatInfoByStaId(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getSatInfoByStaId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getSatInfoByStaIdPVS(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pwsSta.getSatInfoByStaIdPVS",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getSatInfoByStaIdChp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pwsSta.getSatInfoByStaIdChp",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getSatInfoByStaIdLoss(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pwsSta.getSatInfoByStaIdLoss",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getSatInfoByStaIdFau(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pwsSta.getSatInfoByStaIdFau",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getSatInfoByStaIdPCS(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pwsSta.getSatInfoByStaIdPCS",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getSatInfoByStaIdMonth(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getSatInfoByStaIdMonth",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPlanPower(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPlanPower",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getMonthPower(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getMonthPower",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowerNew(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowerNew",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowerByPlan(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowerByPlan",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowerByReal(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowerByReal",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPhiPheByPlan(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPhiPheByPlan",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPhiPheByReal(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPhiPheByReal",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFalEquNumTop(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getFalEquNumTop",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFalEquNumBoottom(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getFalEquNumBoottom",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowerRankByComTop5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowerRankByComTop5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowerRankByComBottom5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowerRankByComBottom5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFaultRankByComTop5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getFaultRankByComTop5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFaultRankByComBottom5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getFaultRankByComBottom5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowGenEffHourRankByComTop5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowGenEffHourRankByComTop5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowGenEffHourRankByComBottom5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowGenEffHourRankByComBottom5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChaVolRankByComTop5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getChaVolRankByComTop5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChaVolRankByComBottom5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getChaVolRankByComBottom5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChaGenEffHourRankByComTop5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getChaGenEffHourRankByComTop5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChaGenEffHourRankByComBottom5Owner(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getChaGenEffHourRankByComBottom5Owner",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowerRankByComTop5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowerRankByComTop5Opm",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowerRankByComBottom5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowerRankByComBottom5Opm",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFaultRankByComTop5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getFaultRankByComTop5Opm",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getFaultRankByComBottom5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getFaultRankByComBottom5Opm",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowGenEffHourRankByComTop5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowGenEffHourRankByComTop5Opm",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPowGenEffHourRankByComBottom5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getPowGenEffHourRankByComBottom5Opm",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChaVolRankByComTop5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getChaVolRankByComTop5Opm",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChaVolRankByComBottom5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getChaVolRankByComBottom5Opm",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChaGenEffHourRankByComTop5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getChaGenEffHourRankByComTop5Opm",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getChaGenEffHourRankByComBottom5Opm(
			Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("pwsSta.getChaGenEffHourRankByComBottom5Opm",map);
	}
}
