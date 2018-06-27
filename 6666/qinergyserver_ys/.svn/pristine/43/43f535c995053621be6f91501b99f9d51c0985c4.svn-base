package com.qinergy.dao.dailyoffice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dto.UserInfDto;

@Repository("dailyOfficeDao")
public class DailyOfficeDaoImpl extends BaseDao implements DailyOfficeDao {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int insertFile(LinkedHashMap<String, Object> map) {
		return this.sqlSessionTemplate.insert("dailyOffice.createFile", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LinkedHashMap<String, Object>> getFileById(int id) {
		return this.sqlSessionTemplate.selectList("dailyOffice.selectFileById", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int removeFile(int id) {
		return this.sqlSessionTemplate.update("dailyOffice.removeFile", id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LinkedHashMap<String, Object>> getListByComsId(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("dailyOffice.getFileList", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getComsAll() {

		return this.sqlSessionTemplate.selectList("dailyOffice.getAllComs");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFileType(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("dailyOffice.getFileType",map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int insertFilrType(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("dailyOffice.insertFileType", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selFileTypByName(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("dailyOffice.selFileTypByName", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updateFileType(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("dailyOffice.updateFileTypeById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getFileCountInType(int id) {
		return this.sqlSessionTemplate.selectOne("dailyOffice.getFileCountInType",id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int removeFileType(int id) {
		return this.sqlSessionTemplate.update("dailyOffice.removeFileType", id);
	}
	
	/**
	 * 员工客户 管理dao
	 */
	@Override
	public void insertUserInfo(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.insert("dailyOffice.insertUserInfo", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUserInfo(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("dailyOffice.updateUserInfo", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUserScore(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("dailyOffice.updateUserScore", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUserDep(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("dailyOffice.updateUserDep", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resetPwd(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("dailyOffice.resetPwd", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delUserInfo(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.delete("dailyOffice.delUserInfo", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAccStat(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.delete("dailyOffice.setAccStat", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserInfById(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dailyOffice.getUserInfById", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserInfListByType(
			Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dailyOffice.getUserInfListByType", map);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserListCount(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dailyOffice.getUserListCount", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserByNumAndNam(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dailyOffice.getUserByNumAndNam", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> AppSelectFileById(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("dailyOffice.AppSelectFileById", map);
	}

}
