package com.qinergy.dao.integratmonitor.pqsms;

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
@Repository("pqsmsDao")
public class PqsmsDaoImpl extends BaseDao implements PqsmsDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsInfByEquNumTopOne(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pqsms.getIscsPqsmsInfByEquNumTopOne", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurves(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pqsms.getIscsPqsmsUIPQsumCurves",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsThdUIABCHistogram(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pqsms.getIscsPqsmsThdUIABCHistogram", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistory(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pqsms.getIscsPqsmsUIPQsumCurvesHistory", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistoryLst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pqsms.getIscsPqsmsUIPQsumCurvesHistoryLst", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsPqsmsUIPQsumCurvesHistoryLstCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pqsms.getIscsPqsmsUIPQsumCurvesHistoryLstCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pqsms.getEquLstByPwsEquTyp", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getPqsmsInfByEquNum(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("pqsms.getPqsmsInfByEquNum", map);
	}
}
