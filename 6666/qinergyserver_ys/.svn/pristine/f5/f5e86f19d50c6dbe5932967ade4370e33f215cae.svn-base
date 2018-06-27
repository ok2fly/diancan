package com.qinergy.dao.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.DataDicDto;
import com.qinergy.dto.system.DataDicTypeDto;
import com.qinergy.dto.system.UserDto;
import com.qinergy.dto.system.UserRoleDto;

@Repository("systemDao")
public class SystemDaoImpl extends BaseDao implements SystemDao {


//	@Override
//	public String selectChaPilSta(Map<String, Object> map) {
//		return this.sqlSessionTemplate.selectOne("system.selectChaPilSta",map);
//	}

	@Override
	public List<Map<String,Object>> getBasComLev(UserDto userDto) throws Exception {
		return this.sqlSessionTemplate.selectList("system.getBasComLev",userDto);
	}
	
	@Override
	public List<Map<String,Object>> getBasComInfo(Map<String,Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("system.getBasComInfo",map);
	}
	
	@Override
	public List<Map<String,Object>> getBasComTypInfo(Map<String,Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("system.getBasComTypInfo",map);
	}
	
	@Override
	public List<Map<String,Object>> getBasComSubComInfo(Map<String,Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("system.getBasComSubComInfo",map);
	}
	
	@Override
	public List<Map<String,Object>> getBasComDepInfo(Map<String,Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("system.getBasComDepInfo",map);
	}
	
	@Override
	public void insertUserRole(UserRoleDto userRoleDto) throws Exception {
		this.sqlSessionTemplate.insert("system.insertUserRole",userRoleDto);
	}
	
	@Override
	public void updateComInfo(Map<String,Object> map) throws Exception {
		this.sqlSessionTemplate.update("system.updateComInfo",map);
	}
	
	@Override
	public List<Map<String,Object>> getBasRegInfById(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasRegInfById",map);
	}
	@Override
	public List<Map<String,Object>> getBasRegInfByIde(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasRegInfByIde",map);
	}
	
	/*@Override
	public List<Map<String,Object>> getBasRegLst(Map<String,Object> map) throws Exception {
	
		List<Map<String,Object>> reg1LevLst = this.sqlSessionTemplate.selectList("system.getBasRegLst1Lev",map);
		
		if(reg1LevLst != null && reg1LevLst.size() > 0){
			
			for(Map<String, Object> reg1LevMap : reg1LevLst){
				
				List<Map<String,Object>> reg2LevLst = this.sqlSessionTemplate.selectList("system.getBasRegLst2Or3Lev",reg1LevMap);
				
				if(reg2LevLst != null && reg2LevLst.size() > 0){
					
					for(Map<String, Object> reg2LevMap : reg2LevLst){
						
						List<Map<String,Object>> reg3LevLst = this.sqlSessionTemplate.selectList("system.getBasRegLst2Or3Lev",reg2LevMap);
						
						reg2LevMap.put("reg3LevLst", reg3LevLst);
					}
				}
				
				reg1LevMap.put("reg2LevLst", reg2LevLst);
			}
		}
		
		return reg1LevLst;
	}*/
	@Override
	public List<Map<String,Object>> getBasRegLst1Lev(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasRegLst1Lev",map);
		
	}
	@Override
	public List<Map<String,Object>> getBasRegLst2Or3Lev(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasRegLst2Or3Lev",map);
		
	}
	@Override
	public List<Map<String,Object>> getBasHigComNam(Map<String,Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasHigComNam",map);
		
	}
	@Override
	public List<Map<String,Object>> getBasComTypAllInfo() throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasComTypAllInfo");
	}
	@Override
	public List<Map<String,Object>> getBasComAllLst() throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasComAllLst");
	}
	@Override
	public List<Map<String,Object>> getBasAppTypAll(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasAppTypAll",map);
	}
	@Override
	public List<Map<String,Object>> getBasManTypAll() throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasManTypAll");
	}
	@Override
	public void insertComInfo(Map<String,Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insertComInfo",map);
	}
	
	/*App端使用-start*/
	
	@Override
	public Map<String, Object> getUserById(UserDto userDto) throws Exception {
		
		List<Map<String, Object>> userlist = this.sqlSessionTemplate.selectList("system.getUserById", userDto);
		
		if(userlist != null && userlist.size()>0){
			
			Map<String, Object> map = userlist.get(0);
			
			return map;
			
		}
		return null;
	}
	
	/*App端使用-end*/
	
	@Override
	public void updDep(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.updDep",map);
	}
	
	@Override
	public void insDep(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insDep",map);
	}
	
	@Override
	public void insertUser(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insertUser",map);
	}
	
	@Override
	public List<Map<String, Object>> getBasRegInfByFatId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasRegInfByFatId",map);
	}
	
	@Override
	public List<Map<String, Object>> getBasRegInfByFatIdNotPage(Map<String, Object> map) throws Exception {
	    
	    return this.sqlSessionTemplate.selectList("system.getBasRegInfByFatIdNotPage",map);
	}
	
	@Override
	public List<Map<String, Object>> getUserByLoginNamePC(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getUserByLoginNamePC",map);
	}
	
	@Override
	public List<Map<String, Object>> getUserByLoginNamePCT(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getUserByLoginNamePCT",map);
	}
	
	@Override
	public List<Map<String, Object>> getUserByLoginNamePCTCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getUserByLoginNamePCTCou",map);
	}
	
	@Override
	public List<Map<String, Object>> getBasAppCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasAppCou",map);
	}
	
	@Override
	public List<Map<String, Object>> getManInfCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getManInfCou",map);
	}
	
	@Override
	public List<Map<String, Object>> getBasRegLst1LevCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasRegLst1LevCou",map);
	}
	
	@Override
	public List<Map<String, Object>> getBasRegInfByFatIdCou(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasRegInfByFatIdCou",map);
	}
	
	@Override
	public List<Map<String, Object>> getOpeConInf(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getOpeConInf",map);
	}
	
	@Override
	public List<Map<String, Object>> getChpInfByChpNum(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getChpInfByChpNum",map);
	}
	
	@Override
	public List<Map<String, Object>> getAllComTyp() throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getAllComTyp");
	}
	
	@Override
	public List<Map<String, Object>> getAllComNam() throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getAllComNam");
	}
	
	@Override
	public void insDic(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insDic",map);
	}
	
	@Override
	public List<Map<String, Object>> getDicById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getDicById",map);
	}
	
	@Override
	public void updDic(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.updDic",map);
	}
	
	@Override
	public List<Map<String, Object>> getManInf(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getManInf",map);
	}
	
	@Override
	public List<Map<String, Object>> getManInfAll() throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getManInfAll");
	}
	
	@Override
	public List<Map<String, Object>> getAllManTyp() throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getAllManTyp");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insManTyp(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insManTyp",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updManTyp(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.updManTyp",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delManTyp(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.delete("system.delManTyp",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insMan(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insMan",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updMan(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.updMan",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delMan(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.delMan",map);
	}
	
	@Override
	public void updFauTyp(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.updFauTyp",map);
	}
	
	
	@Override
	public void insFauTyp(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insFauTyp",map);
	}
	
	@Override
	public void delFauTyp(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.delete("system.delFauTyp",map);
	}
	
	@Override
	public void delDic(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.delete("system.delDic",map);
	}
	
	@Override
	public void updateUser(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.updateUser",map);
	}
	
	@Override
	public void deleteUser(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.delete("system.deleteUser",map);
	}
	
	@Override
	public List<Map<String, Object>> getAllRolInf(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getAllRolInf",map);
	}
	
	@Override
	public List<Map<String, Object>> getPosInfLst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getPosInfLst",map);
	}
	
	@Override
	public List<Map<String, Object>> getDepInfLst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getDepInfLst",map);
	}
	
	@Override
	public List<Map<String, Object>> getEduInfLst(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getEduInfLst",map);
	}
	
	@Override
	public void insReg(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insReg",map);
	}
	
	@Override
	public int delReg(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.delete("system.delReg",map);
	}
	
	@Override
	public int getFatRegByRegId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectOne("system.getFatRegByRegId",map);
	}
	
	@Override
	public List<Map<String, Object>> getUserById(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getUserById",map);
	}
	
	@Override
	public List<Map<String, Object>> getFauTypId(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getFauTypId",map);
	}
	
	@Override
	public List<Map<String, Object>> getBasApp(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getBasApp",map);
	}
	
	@Override
	public void updAppInf(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.updAppInf",map);
	}
	@Override
	public void delAppInf(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.delAppInf",map);
	}
	@Override
	public void insAppInf(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insAppInf",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void updAppTyp(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.updAppTyp",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void delAppTyp(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.delAppTyp",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void insAppTyp(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insAppTyp",map);
	}
	
	/*微信*/
	@Override
	public List<Map<String, Object>> getChpInfByChpNumNew(Map<String, Object> map) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getChpInfByChpNumSys",map);
	}

	@Override
	public int deComLev(Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.insert("system.deComLev",map);
	}

	@Override
	public List<Map<String, Object>> getComFat(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("system.getComFat",map);
	}
	@Override
	public int getComByFatId(Map<String, Object> map) throws Exception {
		
		return sqlSessionTemplate.selectOne("system.getComByFatId",map);
	}

	@Override
	public List<Map<String, Object>> getFatComInfByComIdRol(
			CompanyDto companyDto) throws Exception {
		return sqlSessionTemplate.selectList("system.getFatComInfByComIdRol",companyDto);
	}

	@Override
	public List<Map<String, Object>> getComInfByComIdRol(CompanyDto companyDto)
			throws Exception {
		return sqlSessionTemplate.selectList("system.getComInfByComIdRol",companyDto);
	}

	@Override
	public List<Map<String, Object>> getFatComInfByComIdRol2(
			CompanyDto companyDto) throws Exception {
		return sqlSessionTemplate.selectList("system.getFatComInfByComIdRol2",companyDto);
	}

	@Override
	public List<Map<String, Object>> getComInfByComIdRol2(CompanyDto companyDto)
			throws Exception {
		return sqlSessionTemplate.selectList("system.getComInfByComIdRol2",companyDto);
	}

	@Override
	public List<Map<String, Object>> getBasComInfoRol(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("system.getBasComInfoRol",map);
	}
	
	@Override
	public List<Map<String, Object>> getBasAppById(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("system.getBasAppById",map);
	}

	@Override
	public void updateComInfoRol(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("system.updateComInfoRol",map);
		
	}
	@Override
	public void insertComLogoImg(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("system.insertComLogoImg",map);
		
	}
	
	@Override
	public List<Map<String, Object>> getComLogoImgById(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("system.getComLogoImgById",map);
		
	}

	@Override
	public void insertComInfoRol(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("system.insertComInfoRol",map);
		
	}

	@Override
	public void updateComInfoRol2(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("system.updateComInfoRol2",map);
		
	}

	@Override
	public void insertComInfoRol2(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("system.insertComInfoRol2",map);
		
	}
	
	
	
	
	
	/** 数据字典管理 start*/
	@Override
	public void insDataDic(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.insert("system.insDataDic", map);
	}

	@Override
	public void updDataDic(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("system.updDataDic", map);
	}

	@Override
	public void delDataDic(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("system.delDataDic", map);
	}

	@Override
	public int getDataDicFlag(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("system.getDataDicFlag", map);
	}
	
	@Override
	public DataDicDto getDataDicById(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("system.getDataDicById", map);
	}
	
	@Override
	public List<Map<String, Object>> getDataDicListByTypAndNam(
			Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("system.getDataDicListByTypAndNam", map);
	}

	@Override
	public int getDicListCount(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("system.getDicListCount", map);
	}
	
	@Override
	public void insDataDicTyp(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.insert("system.insDataDicTyp", map);
	}

	@Override
	public List<Map<String, Object>> getDataDicTypByName(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("system.getDataDicTypByName", map);
	}
	
	@Override
	public void updDataDicTyp(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("system.updDataDicTyp", map);
	}

	@Override
	public int delDataDicTyp(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.update("system.delDataDicTyp", map);
	}
	
	@Override
	public int getDataDicTypId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("system.getDataDicTypId", map);
	}

	@Override
	public int getDataDicTypFlag(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("system.getDataDicTypFlag", map);
	}
	
	@Override
	public DataDicTypeDto getDataDicTypById(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("system.getDataDicTypById", map);
	}
	
	@Override
	public List<Map<String, Object>> getDataDicTypList(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("system.getDataDicTypList", map);
	}
	
	@Override
	public int getDataDicTypCount(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("system.getDataDicTypCount", map);
	}
	/** 数据字典管理 end */

	
	/*告警码和类型维护Start*/

	@Override
	public int InsertAlaCode(Map<String, Object> map) throws Exception {
		return this.sqlSessionTemplate.insert("system.addAlaCode",map);
	}

	@Override
	public int removeAlaCode(int id) throws Exception {
		return this.sqlSessionTemplate.update("system.removeAlaCode",id);
	}
	
	@Override
	public int updateAlaCodeInfo(Map<String,Object> map) throws Exception {
		return this.sqlSessionTemplate.update("system.updateAlaCode", map);
	}

	@Override
	public int  InsertAlaType(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("system.insertAlaType",map);
	}

	@Override
	public int removeAlaType(int id) {
		return this.sqlSessionTemplate.update("system.removeAlaType", id);
	}
	volatile int i;
	@Override
	public int getAlaCodeCountByType(int id) {
		return this.sqlSessionTemplate.selectOne("system.getAlaCodeCountByType", id);
	}

	@Override
	public List<Map<String, Object>> getAlaType(String id) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("id", id);
		return this.sqlSessionTemplate.selectList("system.getAlaType",map);
	}

	@Override
	public List<Map<String, Object>> getAlaCode(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("system.getAlaCodeInfo",map);
	}
	
	@Override
	public List<Map<String, Object>> getAlaCodeInfoCou(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("system.getAlaCodeInfoCou",map);
	}

	@Override
	public List<Map<String, Object>> getAppInfoById(String id) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("id", id);
		return this.sqlSessionTemplate.selectList("system.getAppTypeInfoById", map);
	}

	@Override
	public int updateAlaType(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("system.updateAlaType", map);
	}
	
	
	/*告警码和类型维护End*/
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEquInfLstByPwsIdAppTyp(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getEquInfLstByPwsIdAppTyp",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getChpInfLstByPwsIdAppTyp(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getChpInfLstByPwsIdAppTyp",map);
	}

	@Override
	public List<Map<String, Object>> getPwsNamByPwsId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsNamByPwsId",map);
	}

	@Override
	public List<Map<String, Object>> getComInfAndUseInfByUseId(Map<String, Object> map)
			throws Exception {
		return this.sqlSessionTemplate.selectList("system.getComInfAndUseInfByUseId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstByPwsId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsInfLstByPwsId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEquInfLst(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getEquInfLst",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEquInfLstCou(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getEquInfLstCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getCtlEquInfLst(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getCtlEquInfLst",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getCtlEquInfLstCou(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getCtlEquInfLstCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEquInfByEquId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getEquInfByEquId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getMqttInfByEquNum(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getMqttInfByEquNum",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertEquInfo(Map<String, Object> map) {
		
		this.sqlSessionTemplate.insert("system.insertEquInfo",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updateEquInfo(Map<String, Object> map) {
		
		this.sqlSessionTemplate.update("system.updateEquInfo",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updateMqtt(Map<String, Object> map) {
		
		this.sqlSessionTemplate.update("system.updateMqtt",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertMqtt(Map<String, Object> map) {
		
		this.sqlSessionTemplate.insert("system.insertMqtt",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void delectEquInfo(Map<String, Object> map) {
		
		this.sqlSessionTemplate.update("system.delectEquInfo",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLst(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsInfLst",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstBy2LevCom(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsInfLstBy2LevCom",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstBy1LevCom(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsInfLstBy1LevCom",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstCou(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsInfLstCou",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstBy2LevComCou(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsInfLstBy2LevComCou",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstBy1LevComCou(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsInfLstBy1LevComCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertPwsInfo(Map<String, Object> map) {
		
		this.sqlSessionTemplate.insert("system.insertPwsInfo",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updatePwsInfo(Map<String, Object> map) {
		
		this.sqlSessionTemplate.update("system.updatePwsInfo",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void delectPwsInfo(Map<String, Object> map) {
		
		this.sqlSessionTemplate.update("system.delectPwsInfo",map);
	}
	
	/**
	 * 获取业主、合作伙伴信息列表
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getComRolOneAndTwo(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getComRolOneAndTwo",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updReg(Map<String, Object> map) {
		
		this.sqlSessionTemplate.update("system.updReg",map);
	}
	
	
	
	//-------------------人员 任务转移   包括 巡视  检修  报修  报废-stat------------------------
	
	/**
	 * 巡视
	 * 人员任务  转移
	 * 巡视任务  关于用户 我创建的
	 * 
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selAppointTourTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selAppointTourTaskByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 巡视任务  关于用户  我执行的
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selExecuteTourTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selExecuteTourTaskByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 巡视任务  关于用户  我审核的
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selCheckTourTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selCheckTourTaskByUserId",map);
	}
	
	
	/**
	 * 人员任务  转移
	 * 巡视任务  关于用户   我创建的   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updTourTaskByUserId(Map<String, Object> map) {
		
		 this.sqlSessionTemplate.selectList("system.updTourTaskByUserId",map);
	}
	
	/**
	 * 人员任务  转移
	 * 巡视任务  关于用户   执行人   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updTourTaskExecuteByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updTourTaskExecuteByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 巡视任务  关于用户   审核人   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updTourTaskCheckByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updTourTaskCheckByUserId",map);
	}
	
	
	/**
	 * 检修
	 * 人员任务  转移
	 * 检修任务  关于用户 我创建的
	 * 
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selAppointOverhaulTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selAppointOverhaulTaskByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 检修任务  关于用户  我执行的
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selExecuteOverhaulTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selExecuteOverhaulTaskByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 检修任务  关于用户  我审核的
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selCheckOverhaulTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selCheckOverhaulTaskByUserId",map);
	}
	
	
	/**
	 * 人员任务  转移
	 * 检修任务  关于用户   我创建的   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updOverhaulTaskByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updOverhaulTaskByUserId",map);
	}
	
	/**
	 * 人员任务  转移
	 * 检修任务  关于用户   执行人   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updOverhaulTaskExecuteByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updOverhaulTaskExecuteByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 检修任务  关于用户   审核人   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updOverhaulTaskCheckByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updOverhaulTaskCheckByUserId",map);
	}
	
	/**
	 * 报修
	 * 人员任务  转移
	 * 报修任务  关于用户 我创建的
	 * 
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selCrtUseRepairTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selCrtUseRepairTaskByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 报修任务  关于用户  我维修的
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selRepairUserRepairTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selRepairUserRepairTaskByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 报修任务  关于用户  我审核的
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selCheckRepairTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selCheckRepairTaskByUserId",map);
	}
	
	
	/**
	 * 人员任务  转移
	 * 报修任务  关于用户   我创建的   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updRepairTaskCrtUseByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updRepairTaskCrtUseByUserId",map);
	}
	
	/**
	 * 人员任务  转移
	 * 报修任务  关于用户   维修人   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updRepairTaskRepairUserByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updRepairTaskRepairUserByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 报修任务  关于用户   审核人   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updRepairTaskCheckByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updRepairTaskCheckByUserId",map);
	}
	
	
	/**
	 * 报废
	 * 人员任务  转移
	 * 报废任务  关于用户 我创建的
	 * 
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selCrtUseScrapTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selCrtUseScrapTaskByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 报废任务  关于用户  我第一次审核的
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selOneCheckScrapTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selOneCheckScrapTaskByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 报废任务  关于用户  我第二次审核的
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selTwoCheckScrapTaskByUserId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selTwoCheckScrapTaskByUserId",map);
	}
	
	
	/**
	 * 人员任务  转移
	 * 报废任务  关于用户   我创建的   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updScrapTaskCrtUseByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updScrapTaskCrtUseByUserId",map);
	}
	
	/**
	 * 人员任务  转移
	 * 报废任务  关于用户   第一次审核   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updScrapTaskOneCheckByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updScrapTaskOneCheckByUserId",map);
	}
	/**
	 * 人员任务  转移
	 * 报废任务  关于用户   第二次审核   修改
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updScrapTaskTwoCheckByUserId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.selectList("system.updScrapTaskTwoCheckByUserId",map);
	}
	

	//-------------------人员 任务转移   包括 巡视  检修  报修  报废-end------------------------
	
	
	
	
	/*--------------------------建立用户与站点间的关系---------------------------*/
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertUseAndPwsInf(Map<String, Object> map) {
		
		this.sqlSessionTemplate.insert("system.insertUseAndPwsInf",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void deleteUseAndPwsInfByUseId(Map<String, Object> map) {
		
		this.sqlSessionTemplate.delete("system.deleteUseAndPwsInfByUseId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUseAndPwsInfLst(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getUseAndPwsInfLst",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getAllManTypById(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getAllManTypById",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUserRoleById(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getUserRoleById",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> updateUserRole(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.updateUserRole",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByRolNam(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getUserRoleByRolNam",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getBasRegLst1LevAll(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getBasRegLst1LevAll",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> insertPwsPic(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.insertPwsPic",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsPicByPwsId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsPicByPwsId",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsOldPicByPwsId(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getPwsOldPicByPwsId",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void deletePwsPic(Map<String, Object> map) {
		
		this.sqlSessionTemplate.delete("system.deletePwsPic",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEquNameByEquNum(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.getEquNameByEquNum",map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getMeterTypLstAll() {
		
		return this.sqlSessionTemplate.selectList("system.getMeterTypLstAll");
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getAllOptComNam() {
		
		return this.sqlSessionTemplate.selectList("system.getAllOptComNam");
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getAllOwnComNam() {
		
		return this.sqlSessionTemplate.selectList("system.getAllOwnComNam");
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selFeedBackAll(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selFeedBackAll",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selFeedBackByUseId(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selFeedBackByUseId",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selFeedBackAllCou(Map<String,Object> map) {
		
		return this.sqlSessionTemplate.selectList("system.selFeedBackAllCou",map);
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertFeedBack(Map<String,Object> map) {
		
		this.sqlSessionTemplate.insert("system.insertFeedBack",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void delFeedBackById(Map<String,Object> map) {
		
		this.sqlSessionTemplate.insert("system.delFeedBackById",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void updReplyById(Map<String,Object> map) {
		
		this.sqlSessionTemplate.insert("system.updReplyById",map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public void insertUserImg(Map<String,Object> map) {
		
		this.sqlSessionTemplate.insert("system.insertUserImg",map);
	}
	
}