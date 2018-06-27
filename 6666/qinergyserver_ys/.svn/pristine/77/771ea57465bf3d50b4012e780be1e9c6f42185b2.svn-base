package com.qinergy.dao.assetmanagement;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("assetManagementDao")
public class AssetsManagementDaoImpl extends BaseDao implements AssetsManagementDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insAssetsTyp(Map<String, Object> map) throws Exception {
		boolean result = false;
		int insert = sqlSessionTemplate.insert("assetsManagement.insAssetsTyp", map);
		if(insert > 0){
			result = true;
		}
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAssetsTypByName(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getAssetsTypByName", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updAssetsTyp(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.updAssetsTyp", map) > 0){
			result = true;
		}
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delAssetsTyp(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delAssetsTyp", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getAssetsTypById(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("assetsManagement.getAssetsTypById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAssetsTypList() throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getAssetsTypList");
	}

	
	
	/////////////////////////////////////////////////////////////
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAssetsListByTyp(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getAssetsListByTyp", map);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insAssets(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.insert("assetsManagement.insAssets", map) > 0){
			result = true;
		}
		return result; 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updAssets(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.updAssets", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Map<String, Object>> getAssetsIdsByAssNum(Map<String, Object> map) throws Exception{
		
		return sqlSessionTemplate.selectList("assetsManagement.getAssetsIdsByAssNum", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delAssets(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delAssets", map) > 0){
			result = true;
		}
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delBatchAssets(Map<String, Object> map) throws Exception{
		
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delBatchAssets", map) > 0){
			result = true;
		}
		return result;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAssetsByAssNum(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getAssetsByAssNum", map);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAssetsListCount(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getAssetsListCount", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getStoreHouseByComId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getStoreHouseByComId", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getInOutBroundList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getInOutBroundList", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getInOutBroundCount(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("assetsManagement.getInOutBroundCount", map);
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAssetsListByOrdNum(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getAssetsListByOrdNum", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getAssetsAlaCou(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("assetsManagement.getAssetsAlaCou", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setAssetsAlaCou(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.setAssetsAlaCou", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insAssetsAlaInfo(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.insAssetsAlaInfo", map) > 0){
			result = true;
		}
		return result;
	}

	
	
	//////////////////////////缺陷管理///////////////////////////////
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean uploadFile(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.insert("assetsManagement.uploadFile", map) > 0){
			result = true;
		}
		return result; 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delFile(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delFile", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getFileById(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("assetsManagement.getFileById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFileListByDefId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getFileListByDefId", map);
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getDefectTypByName(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getDefectTypByName", map);
	}
	
	
	
	//////////////缺陷 类型///////////
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insDefectTyp(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.insert("assetsManagement.insDefectTyp", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updDefectTyp(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.updDefectTyp", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delDefectTyp(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delDefectTyp", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getDefectTypList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getDefectTypList", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getDefectTypCount(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("assetsManagement.getDefectTypCount", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getDefectTypById(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("assetsManagement.getDefectTypById", map);
	}

	
	//////////////缺陷///////////
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insDefectInfo(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.insert("assetsManagement.insDefectInfo", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updDefectInfo(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.updDefectInfo", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delDefectInfo(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delDefectInfo", map) > 0){
			result = true;
		}
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delBatchDefectInfo(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delBatchDefectInfo", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getDefectInfoByDefnum(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("assetsManagement.getDefectInfoByDefnum", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getDefectList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("assetsManagement.getDefectList", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getDefectListCount(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("assetsManagement.getDefectListCount", map);
	}

	
	
	
	
	////////////////////////////////采购计划/////////////////////////////////////////
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insAssetsPurPlan(Map<String, Object> map) throws Exception {
		
		boolean result = false;
		if(sqlSessionTemplate.insert("assetsManagement.insAssetsPurPlan", map) > 0){
			result = true;
		}
		return result;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updAssetsPurPlan(Map<String, Object> map) throws Exception {
		
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.updAssetsPurPlan", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getAssetsPurPlanById(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectOne("assetsManagement.getAssetsPurPlanById", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delAssetsPurPlan(Map<String, Object> map) throws Exception {
		
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delAssetsPurPlan", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override 
	public boolean delBatchAssetsPurPlan(Map<String, Object> map) throws Exception {

		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delBatchAssetsPurPlan", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAssetsPurPlanList(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("assetsManagement.getAssetsPurPlanList", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getAssetsPurPlanCount(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectOne("assetsManagement.getAssetsPurPlanCount", map);
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean uploadPurPlanFile(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.insert("assetsManagement.uploadPurPlanFile", map) > 0){
			result = true;
		}
		return result; 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delPurPlanFile(Map<String, Object> map) throws Exception {
		boolean result = false;
		if(sqlSessionTemplate.update("assetsManagement.delPurPlanFile", map) > 0){
			result = true;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getPurPlanFileById(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectOne("assetsManagement.getPurPlanFileById", map);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPurPlanFileListByPlanNum(Map<String, Object> map) throws Exception {

		return sqlSessionTemplate.selectList("assetsManagement.getPurPlanFileListByPlanNum", map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAllWareHouseName() throws Exception {
		
		return sqlSessionTemplate.selectList("assetsManagement.getAllWareHouseName");
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAssetsByAssNumNew(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectList("assetsManagement.getAssetsByAssNumNew",map);
	}
	
	

	


}
