package com.qinergy.dao.integratmonitor.acchp;

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
@Repository("acchpDao")
public class AcchpDaoImpl extends BaseDao implements AcchpDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsAcchpStdInfByEquNumTopOne(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("acchp.getIscsAcchpStdInfByEquNumTopOne", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsAcchpRelInfByEquNumTopOne(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("acchp.getIscsAcchpRelInfByEquNumTopOne",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsAcchpRelUICurves(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("acchp.getIscsAcchpRelUICurves", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsAcchpRelUICurvesHistory(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("acchp.getIscsAcchpRelUICurvesHistory", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsAcchpOrdInfLst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("acchp.getIscsAcchpOrdInfLst", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsAcchpOrdInfLstCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("acchp.getIscsAcchpOrdInfLstCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("acchp.getEquLstByPwsEquTyp", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAcchpInfByEquNum(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("acchp.getAcchpInfByEquNum", map);
	}
}
