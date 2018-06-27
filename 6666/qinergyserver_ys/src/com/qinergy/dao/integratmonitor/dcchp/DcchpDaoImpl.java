package com.qinergy.dao.integratmonitor.dcchp;

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
@Repository("dcchpDao")
public class DcchpDaoImpl extends BaseDao implements DcchpDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpStdInfByEquNumTopOne(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("dcchp.getIscsDcchpStdInfByEquNumTopOne", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpRelInfByEquNumTopOne(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("dcchp.getIscsDcchpRelInfByEquNumTopOne",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpRelUICurves(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("dcchp.getIscsDcchpRelUICurves", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpRelUICurvesHistory(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("dcchp.getIscsDcchpRelUICurvesHistory", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsCarStaInfLst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("dcchp.getIscsCarStaInfLst", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpOrdInfLst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("dcchp.getIscsDcchpOrdInfLst", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsDcchpOrdInfLstCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("dcchp.getIscsDcchpOrdInfLstCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("dcchp.getEquLstByPwsEquTyp", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getDcchpInfByEquNum(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("dcchp.getDcchpInfByEquNum", map);
	}
}
