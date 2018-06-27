package com.qinergy.dao.integratmonitor;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dao.base.CharInfo_dao;

@Repository("integratMonitorDao")
public class IntegratMonitorDaoImpl extends BaseDao implements IntegratMonitorDao {
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getComInfById(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getComInfById", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getComInfByFatId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getComInfByFatId", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void delComInf(Map<String,Object> map) throws Exception {
		
		this.sqlSessionTemplate.delete("integratMonitor.delComInf", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void delDepInf(Map<String,Object> map) throws Exception {
		
		this.sqlSessionTemplate.delete("integratMonitor.delDepInf", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getRegInf(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getRegInf", map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getAllManInf() throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getAllManInf");
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getAllAppModInf(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getAllAppModInf",map);
	}
	
	
	

	/**
	 *  获取某电站中  某种设备 所有设备编号 ：
	 */
	@Override
	public List<Map<String, Object>> getEquNumLstByPwsEquTyp(
			Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("integratMonitor.getEquNumLstByPwsEquTyp",map);
	}

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getEquStaticInfByNum(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("integratMonitor.getEquNumLstByPwsEquTyp",map);
	}

	
	/*
	 * ##########################################
	 *              综合监控中与站有关的所有接口Start
	 * ##########################################
	 */
    
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsAllAppTypByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsAllAppTypByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsInfByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsInfByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsPicLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsPicLstByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPvPcChaLoadLineInfLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPvPcChaLoadLineInfLstByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPvPcChaLoadLineInfByPwsIdTop1(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPvPcChaLoadLineInfByPwsIdTop1",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPvPcChaLodMonPowerLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPvPcChaLodMonPowerLstByPwsId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getMonPowerLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getMonPowerLstByPwsId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getMonNetPowerLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getMonNetPowerLstByPwsId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getMonPcsLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getMonPcsLstByPwsId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getMonChaLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getMonChaLstByPwsId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getMonEleConLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getMonEleConLstByPwsId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPvFctPowerCurvesLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPvFctPowerCurvesLstByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getSchPowerCurvesLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getSchPowerCurvesLstByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getHvRealPowerCurvesLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getHvRealPowerCurvesLstByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsInfTolTop1LstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsInfTolTop1LstByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsInfTolTop1LstByPwsIdNewWork(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsInfTolTop1LstByPwsIdNewWork",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsInfTolTop1LstByPwsIdPVS(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsInfTolTop1LstByPwsIdPVS",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsInfTolTop1LstByPwsIdPCS(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsInfTolTop1LstByPwsIdPCS",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsInfTolTop1LstByPwsIdChp(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsInfTolTop1LstByPwsIdChp",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsInfTolTop1LstByPwsIdLoad(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsInfTolTop1LstByPwsIdLoad",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getPwsPlanMonYearPowerLstByPwsId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getPwsPlanMonYearPowerLstByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getDeflInfByEquNum(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getDeflInfByEquNum",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,Object>> getDeflInfByEquNumCou(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("integratMonitor.getDeflInfByEquNumCou",map);
	}
	
	
	/*
	 * ##########################################
	 *              综合监控中与站有关的所有接口End
	 * ##########################################
	 */
    
}
