package com.qinergy.dao.integratmonitor.box;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

/**
 * 汇流箱 接口
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
@Repository("boxDao")
public class BoxDaoImpl extends BaseDao implements BoxDao {

	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsBoxInfByEquNumTopOne(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("box.getIscsBoxInfByEquNumTopOne", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsBoxTempDisRateCurves(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("box.getIscsBoxTempDisRateCurves",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsBoxTempDisRateCurvesHistory(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("box.getIscsBoxTempDisRateCurvesHistory", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsBoxTempDisRateCurvesHistoryLst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("box.getIscsBoxTempDisRateCurvesHistoryLst", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getIscsBoxTempDisRateCurvesHistoryLstCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("box.getIscsBoxTempDisRateCurvesHistoryLstCou", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getEquLstByPwsEquTyp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("box.getEquLstByPwsEquTyp", map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getBoxInfByEquNum(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("box.getBoxInfByEquNum", map);
	}
}
