package com.qinergy.dao.knowledgebase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("knowledgeBaseDao")
public class KnowledgeBaseDaoImpl extends BaseDao implements KnowledgeBaseDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int insetKnowLedge(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("knowledgeBase.insertKnw", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updateKnw(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("knowledgeBase.updateKnw", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int insertFile(Map<String, Object> map) {

		return this.sqlSessionTemplate.update("knowledgeBase.createFile", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getIdByInfo(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("knowledgeBase.selectCreatedKnw", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFileInfoById(int id) {

		return this.sqlSessionTemplate.selectList("knowledgeBase.getFileInfoById", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int removeFileById(int id) {
		return this.sqlSessionTemplate.update("knowledgeBase.removeFilebyId", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int removeKnw(int id) {
		return this.sqlSessionTemplate.update("knowledgeBase.removeKnw", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int removeFileByKnwID(int id) {
		return this.sqlSessionTemplate.update("knowledgeBase.removeFileByKnwID", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int insertKnwType(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("knowledgeBase.createKnwType", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getKnwTypeByName(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("knowledgeBase.getKnwTypeByName", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getKnwType(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return this.sqlSessionTemplate.selectList("knowledgeBase.getKnwType", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getKnwByType(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("knowledgeBase.getKnwByType", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getKnwByTypeCou(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("knowledgeBase.getKnwByTypeCou", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFileInfoByKnw(int id) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("knowledgeBase.getFileInfoByKnw", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getKnwInfoById(int id) {
		return this.sqlSessionTemplate.selectOne("knowledgeBase.getKnwById", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getKnwCountByTypeId(int id) {
		return this.sqlSessionTemplate.selectOne("knowledgeBase.getKnwCountByTypeId", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int removeKnwType(int id) {
		return this.sqlSessionTemplate.update("knowledgeBase.removeKnwType", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updateKnwTypeInfo(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("knowledgeBase.updateTypeInfo", map);
	}

	// 以下为安全管理部分
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int insertSct(Map<String, Object> map) {

		return this.sqlSessionTemplate.insert("knowledgeBase.addSct", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int insertSctFile(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("knowledgeBase.addSctFile", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getSctIdByInfo(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("knowledgeBase.getSctIdByInfo", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSctFileInfoById(int id) {
		return this.sqlSessionTemplate.selectList("knowledgeBase.getSctFileInfoById", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int removeFileInSctById(int id) {
		return this.sqlSessionTemplate.update("knowledgeBase.removeFileInSct", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updateSctInfo(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("knowledgeBase.updateSctInfo", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int reomveSctInfoById(int id) {
		return this.sqlSessionTemplate.update("knowledgeBase.ReomveSctInfoById", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int removeFilesBySctId(int id) {
		return this.sqlSessionTemplate.update("knowledgeBase.removeFileBySctId", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSctCountBySctId(int id) {
		return this.sqlSessionTemplate.selectOne("knowledgeBase.getSctCountBySctId", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int insertSctType(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("knowledgeBase.insertSctType", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSctTypeByName(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("knowledgeBase.getSctTypeByName", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSctType(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return this.sqlSessionTemplate.selectList("knowledgeBase.getSctType", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSctByTypeOrName(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("knowledgeBase.getSctByTypeOrName", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSctByTypeOrNameCou(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("knowledgeBase.getSctByTypeOrNameCou", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFileInfoBySctId(String sct_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sct_id", sct_id);
		return this.sqlSessionTemplate.selectList("knowledgeBase.getFileInfoBySctId", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSctCountByType(int id) {
		return this.sqlSessionTemplate.selectOne("knowledgeBase.getSctCount", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int RemoveSctType(int id) {
		return this.sqlSessionTemplate.update("knowledgeBase.removeSctType", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updateSctTypeInfo(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("knowledgeBase.updateSctTypeInfo", map);
	}

}
