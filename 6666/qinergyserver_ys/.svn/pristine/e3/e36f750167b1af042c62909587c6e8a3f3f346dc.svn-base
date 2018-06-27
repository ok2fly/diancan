package com.qinergy.dao.utils;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.UserDto;

@Repository("utilsDao")
public class UtilsDaoImpl extends BaseDao implements UtilsDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getComInfByUseId(UserDto userDto)
			throws Exception {
		return this.sqlSessionTemplate.selectList("utils.getComInfByUseId",userDto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getComInfByComId(CompanyDto companyDto)
			throws Exception {
		return this.sqlSessionTemplate.selectList("utils.getComInfByComId",companyDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFatComInfByComId(CompanyDto companyDto)
			throws Exception {
		return this.sqlSessionTemplate.selectList("utils.getFatComInfByComId",companyDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFatComInfByComIdAll(CompanyDto companyDto)
			throws Exception {
		return this.sqlSessionTemplate.selectList("utils.getFatComInfByComIdAll",companyDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPwsLstByComId(CompanyDto companyDto)
			throws Exception {
		return this.sqlSessionTemplate.selectList("utils.getPwsLstByComId",companyDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFstLevComLstByOptUseId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getFstLevComLstByOptUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFstLevComLstByOwnerUseId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getFstLevComLstByOwnerUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFstLevComLstByUseId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getFstLevComLstByUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getTwoLevComLstByOptUseId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getTwoLevComLstByOptUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getThrLevComLstByOptUseId(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getThrLevComLstByOptUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getEquInfByEquNum(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getEquInfByEquNum",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSuperiorComInfLstByTwoOrThrComUse(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getSuperiorComInfLstByTwoOrThrComUse",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSuperiorSuperiorComInfLstByThrComUse(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getSuperiorSuperiorComInfLstByThrComUse",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getThrComInfLstByFstComUse(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getThrComInfLstByFstComUse",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getInferiorsComInfLstByFstOrTwoComUse(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getInferiorsComInfLstByFstOrTwoComUse",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOptUseByPwsInfLstByPwsIdOpt(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("utils.getOptUseByPwsInfLstByPwsIdOpt",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstByPwsIdOpt(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getPwsInfLstByPwsIdOpt",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOptUseInfInComLstByOptId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getOptUseInfInComLstByOptId",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOptUseInfLstByComId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getOptUseInfLstByComId",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getSafeRunDays() {
		
		return this.sqlSessionTemplate.selectList("utils.getSafeRunDays");
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getIntMonLeftSide(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getIntMonLeftSide",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getIntMonLeftSidePwsPic(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getIntMonLeftSidePwsPic",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseLonLatNewByUseId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getUseLonLatNewByUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getDicInfLstByDicTyp(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getDicInfLstByDicTyp",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getBasAppByAppTypIde(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getBasAppByAppTypIde",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertBasAppInf(Map<String, Object> map) {
		
		this.sqlSessionTemplate.insert("utils.insertBasAppInf",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getBasPwsTypLst() {
		
		return this.sqlSessionTemplate.selectList("utils.getBasPwsTypLst");
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUserName() {
		
		return this.sqlSessionTemplate.selectList("utils.getUserName");
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOwnerComLstByComLevComRol() {
		
		return this.sqlSessionTemplate.selectList("utils.getOwnerComLstByComLevComRol");
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOptComLstByComLevComRol() {
		
		return this.sqlSessionTemplate.selectList("utils.getOptComLstByComLevComRol");
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOptFatComInfByComId(CompanyDto companyDto) {
		
		return this.sqlSessionTemplate.selectList("utils.getOptFatComInfByComId",companyDto);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getSysBasAppTypeByPwsId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getSysBasAppTypeByPwsId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEquNumBySysBasAppTypeId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getEquNumBySysBasAppTypeId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstByPwsId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getPwsInfLstByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> insertOptLogInf(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.insertOptLogInf",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getComLstByComLevComRol() {
		
		return this.sqlSessionTemplate.selectList("utils.getComLstByComLevComRol");
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOptLogLst(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getOptLogLst",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOptLogLstCou(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getOptLogLstCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getComInfByComNam(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getComInfByComNam",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getAllFatComInfByComId(CompanyDto comLevDto) {
		
		return this.sqlSessionTemplate.selectList("utils.getAllFatComInfByComId",comLevDto);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOneselfFatComInfByComId(CompanyDto comLevDto) {
		
		return this.sqlSessionTemplate.selectList("utils.getOneselfFatComInfByComId",comLevDto);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUserNameByComId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getUserNameByComId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseInfInComLstById(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getUseInfInComLstById",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseInfLstByComId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getUseInfLstByComId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseInfLstByComIdCou(Map<String,Object> map) {
		
		return  this.sqlSessionTemplate.selectList("utils.getUseInfLstByComIdCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseLstBySelectUseId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getUseLstBySelectUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseLstBySelectUseIdCou(Map<String,Object> map) {
		
		return  this.sqlSessionTemplate.selectList("utils.getUseLstBySelectUseIdCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseComIdLstBySelectUseId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getUseComIdLstBySelectUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getTwoLevComLstByOptComUseId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getTwoLevComLstByOptComUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getThrLevComLstByOptComUseId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getThrLevComLstByOptComUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getTwoLevComLstByOwnerComUseId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getTwoLevComLstByOwnerComUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getThrLevComLstByOwnerComUseId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getThrLevComLstByOwnerComUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseLstBySelectUseIdOpt(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getUseLstBySelectUseIdOpt",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseLstBySelectUseIdOptCou(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getUseLstBySelectUseIdOptCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getButtonLstByModuleId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getButtonLstByModuleId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getSelectedButtonLstByModuleId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getSelectedButtonLstByModuleId",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOrgFatComInfByComId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getOrgFatComInfByComId",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsIdByFistComId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getPwsIdByFistComId",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsIdBySecdComId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getPwsIdBySecdComId",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsIdByThrdComId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("utils.getPwsIdByThrdComId",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertUseLatLon(Map<String,Object> map) {
		
		this.sqlSessionTemplate.insert("utils.insertUseLatLon",map);
	}
}