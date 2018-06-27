package com.qinergy.dao.integratmonitor.pvs;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

/**
 * 光伏逆变器 接口
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
@Repository("pvsDao")
public class PvsDaoImpl extends BaseDao implements PvsDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsInfByEquNumTopOne(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getIscsPvsInfByEquNumTopOne", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurves(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getIscsPvsAcDcPIVDisRateCurves",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsDayPowerHistogram(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getIscsPvsDayPowerHistogram", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsDayPowerHistogramFirst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getIscsPvsDayPowerHistogramFirst", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistory(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getIscsPvsAcDcPIVDisRateCurvesHistory", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsDayPowerHistogramHistory(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getIscsPvsDayPowerHistogramHistory", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getEquLstByPwsEquTyp", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPvsInfByEquNum(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getPvsInfByEquNum", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistoryLst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getIscsPvsAcDcPIVDisRateCurvesHistoryLst", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPvsAcDcPIVDisRateCurvesHistoryLstCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pvs.getIscsPvsAcDcPIVDisRateCurvesHistoryLstCou", map);
	}
}
