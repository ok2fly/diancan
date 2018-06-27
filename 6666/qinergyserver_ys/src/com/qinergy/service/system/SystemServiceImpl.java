/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.system;

import com.qinergy.dao.integratmonitor.IntegratMonitorDao;
import com.qinergy.dao.system.SystemDao;
import com.qinergy.dao.utils.UtilsDao;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.DataDicDto;
import com.qinergy.dto.system.DataDicTypeDto;
import com.qinergy.dto.system.UserDto;
import com.qinergy.dto.system.UserRoleDto;
import com.qinergy.util.EhcacheUtil;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.PropertiesUtil;
import com.qinergy.util.StringUtil;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;

/**
 * TODO
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Unisys
 * @version 1.0
 * @since 1.0
 */

@Service
public class SystemServiceImpl implements SystemService {

	@Autowired
	private SystemDao systemDao;

	@Autowired
	private IntegratMonitorDao integratMonitorDao;

	@Autowired
	private UtilsDao utilsDao;

	@Autowired
	private EhcacheUtil ehcacheUtil;

	/**
	 * 使用公司ID获取一、二、三级公司下的电站信息
	 */
	@Override
	public List<Map<String, Object>> getPwsIdByComId(Map<String, Object> map) throws Exception {
		
		CompanyDto companyDto = new CompanyDto();
		
		companyDto.setId(Integer.valueOf(map.get("com_id").toString()));
		// 本接口为使用公司ID获取公司信息接口
		List<Map<String, Object>> comLst = utilsDao.getComInfByComId(companyDto);
		
		List<Map<String, Object>> pwsLst = new ArrayList<Map<String,Object>>();
		// 非空判断
		if(comLst != null && !comLst.isEmpty()){
			
			for(Map<String, Object> comMap:comLst){
				
				if(comMap != null && !comMap.isEmpty() && comMap.get("com_lev") != null){
					// 判断公司等级，不同等级，调用不同的接口
					if(comMap.get("com_lev").toString().equals("1")){
						// 使用一级公司ID获取电站列表信息
						pwsLst = utilsDao.getPwsIdByFistComId(map);
						
					}else if(comMap.get("com_lev").toString().equals("2")){
						// 使用二级公司ID获取电站列表信息
						pwsLst = utilsDao.getPwsIdBySecdComId(map);
						
					}else if(comMap.get("com_lev").toString().equals("3")){
						// 使用三级公司ID获取电站列表信息
						pwsLst = utilsDao.getPwsIdByThrdComId(map);
					}
				}
			}
		}
		return pwsLst;
	}
	
	/**
	 * 本接口为获取平台中所有客户公司的信息接口
	 */
	@Override
	public List<Map<String, Object>> getOwnerComLst() throws Exception {
		
		//1.获取平台中所有客户公司的信息
		List<Map<String, Object>> comLev2Lst = utilsDao.getOwnerComLstByComLevComRol();
		
		//2.for循环上面的集合
		for (Map<String, Object> comLev2Map : comLev2Lst) {
			
			CompanyDto comLev2Dto = new CompanyDto();
			
			//4.使用这个ID做getFatComInfByComId方法的com_fat_id
			
			comLev2Dto.setId(Integer.valueOf(comLev2Map.get("id").toString()));
			// 设置查询为业主公司
			comLev2Dto.setCom_rol(1);
			
			List<Map<String, Object>> comLev3Lst = utilsDao.getFatComInfByComId(comLev2Dto);
			
			comLev2Map.put("comLev3Lst", comLev3Lst);
		}
		
		return comLev2Lst;
	}
	
	/**
	 * 本接口为获取平台中所有运维公司的信息接口
	 */
	@Override
	public List<Map<String, Object>> getOptComLst() throws Exception {
		
		//1.获取平台中所有客户公司的信息
		List<Map<String, Object>> comLev1Lst = utilsDao.getOptComLstByComLevComRol();
		
		//2.for循环上面的集合
		for (Map<String, Object> comLev1Map : comLev1Lst) {
			
			//3.获取com_id(id)
			CompanyDto comLev1Dto = new CompanyDto();
			
			//4.使用这个ID做getFatComInfByComId方法的com_fat_id
			comLev1Dto.setId(Integer.valueOf(comLev1Map.get("id").toString()));
			
			// 获取平台中所有指定公司下的运维公司的信息
			List<Map<String, Object>> comLev2Lst = utilsDao.getOptFatComInfByComId(comLev1Dto);
			
			for (Map<String, Object> comLev2Map : comLev2Lst) {
				
				//3.获取com_id(id)
				CompanyDto comLev2Dto = new CompanyDto();
				
				//4.使用这个ID做getFatComInfByComId方法的com_fat_id
				comLev2Dto.setId(Integer.valueOf(comLev2Map.get("id").toString()));
				// 获取平台中所有指定公司下的运维公司的信息
				List<Map<String, Object>> comLev3Lst = utilsDao.getOptFatComInfByComId(comLev2Dto);
				
				comLev2Map.put("comLev3Lst", comLev3Lst);
				
			}
			comLev1Map.put("comLev2Lst", comLev2Lst);
		}
		
		return comLev1Lst;
	}
	
	/**
	 * 本接口为获取平台中所有自己公司的信息接口（组织机构处使用）
	 */
	@Override
	public List<Map<String, Object>> getOneselfComLst(Map<String,Object> map) throws Exception {
		
		//1.获取平台中所有客户公司的信息
		List<Map<String, Object>> comLev1Lst = utilsDao.getOptComLstByComLevComRol();
		
		//2.for循环上面的集合
		for (Map<String, Object> comLev1Map : comLev1Lst) {
			
			//3.获取com_id(id)
			CompanyDto comLev1Dto = new CompanyDto(); 
			
			//4.使用这个ID做getFatComInfByComId方法的com_fat_id
			comLev1Dto.setId(Integer.valueOf(comLev1Map.get("id").toString()));
			
			comLev1Dto.setCom_rol(Integer.valueOf(map.get("com_rol").toString()));
			// 获取启能自己公司的子公司信息
			List<Map<String, Object>> comLev2Lst = utilsDao.getOneselfFatComInfByComId(comLev1Dto);
			
			for (Map<String, Object> comLev2Map : comLev2Lst) {
				
				//3.获取com_id(id)
				CompanyDto comLev2Dto = new CompanyDto();
				
				//4.使用这个ID做getFatComInfByComId方法的com_fat_id
				comLev2Dto.setId(Integer.valueOf(comLev2Map.get("id").toString()));
				
				comLev2Dto.setCom_rol(Integer.valueOf(map.get("com_rol").toString()));
				// 获取启能自己公司的子公司信息
				List<Map<String, Object>> comLev3Lst = utilsDao.getOneselfFatComInfByComId(comLev2Dto);
				
				comLev2Map.put("comLev3Lst", comLev3Lst);
				
			}
			comLev1Map.put("comLev2Lst", comLev2Lst);
		}
		
		return comLev1Lst;
	}
	
	/**
	 * 本接口为获取平台中所有公司的信息接口
	 */
	@Override
	public List<Map<String, Object>> getComLst() throws Exception {
		
		//1.获取平台中所有运维公司的信息
		List<Map<String, Object>> comLev1Lst = utilsDao.getComLstByComLevComRol();
		
		//2.for循环上面的集合
		for (Map<String, Object> comLev1Map : comLev1Lst) {
			
			//3.获取com_id(id)
			CompanyDto comLev1Dto = new CompanyDto();
			
			//4.使用这个ID做getFatComInfByComId方法的com_fat_id
			comLev1Dto.setId(Integer.valueOf(comLev1Map.get("id").toString()));
			
			List<Map<String, Object>> comLev2Lst = utilsDao.getAllFatComInfByComId(comLev1Dto);
			
			for (Map<String, Object> comLev2Map : comLev2Lst) {
				
				//3.获取com_id(id)
				CompanyDto comLev2Dto = new CompanyDto();
				
				//4.使用这个ID做getFatComInfByComId方法的com_fat_id
				comLev2Dto.setId(Integer.valueOf(comLev2Map.get("id").toString()));
				
				//使用公司ID获取其下所有子公司信息
				List<Map<String, Object>> comLev3Lst = utilsDao.getAllFatComInfByComId(comLev2Dto);
				
				comLev2Map.put("comLev3Lst", comLev3Lst);
				
			}
			comLev1Map.put("comLev2Lst", comLev2Lst);
		}
		
		return comLev1Lst;
	}
	
	
	/**
	 * 获取所有一级组织机构的层级关系列表
	 */
	public List<Map<String, Object>> getBasComLev(int id) throws Exception {

		UserDto userDto = new UserDto();
		
		userDto.setFat_id(id);
		// 查询单位层级信息（上属单位，下属单位等）
		List<Map<String, Object>> com1LevLst = systemDao.getBasComLev(userDto);
		// 对查询回来的数据进行非空判断
		if (com1LevLst != null && com1LevLst.size() > 0) {
			//遍历1级公司信息
			for (Map<String, Object> com1LevMap : com1LevLst) {

				UserDto userDtoNew = new UserDto();

				userDtoNew.setFat_id(Integer.parseInt(com1LevMap.get("id").toString()));
				// 获取一级公司下的二级公司
				List<Map<String, Object>> com2LevLst = systemDao.getBasComLev(userDtoNew);

				com1LevMap.put("com2LevLst", com2LevLst);
			}
		}

		return com1LevLst;
	}

	/**
	 * 获取公司相信信息
	 */
	@Override
	public Map<String, Object> getBasComInfo(Map<String, Object> map) throws Exception {

		Map<String, Object> retMap = new HashMap<String, Object>();
		// 使用公司id查询组织机构详情信息 
		List<Map<String, Object>> basCILst = systemDao.getBasComInfo(map);

		if (basCILst != null && basCILst.size() > 0) {

			for (Map<String, Object> basCIMap : basCILst) {
				// 查询指定公司类别信息 
				List<Map<String, Object>> basCITLst = systemDao.getBasComTypInfo(map);

				if (basCITLst != null && basCITLst.size() > 0) {

					for (Map<String, Object> basCITMap : basCITLst) {

						basCIMap.put("com_typ", basCITMap.get("com_typ").toString());
					}
				}
			}
		}

		//查询指定公司的下属单位信息
		List<Map<String, Object>> basSCILst = systemDao.getBasComSubComInfo(map);

		//查询指定单位的部门信息 
		List<Map<String, Object>> basCDILst = systemDao.getBasComDepInfo(map);

		retMap.put("basCILst", basCILst);

		retMap.put("basSCILst", basSCILst);

		retMap.put("basCDILst", basCDILst);

		return retMap;
	}

	/**
	 * 获取公司相信信息
	 */
	@Override
	public void updateComInfo(Map<String, Object> map) throws Exception {

		systemDao.updateComInfo(map);
	}

	/**
	 * 获取公司相信信息
	 */
	@Override
	public void insertUserRole(UserRoleDto userRoleDto) throws Exception {

		systemDao.insertUserRole(userRoleDto);
	}

	/**
	 * 获取省市区之间关联信息
	 */
	public Map<String, Object> getProCitAreRelInf(Map<String, Object> inpMap, int flag) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		if (flag == 1) {

			map.put("id", inpMap.get("com_fat_id"));
			// 查询上级单位名称，传的id为点击单位的com_fat_id
			List<Map<String, Object>> bhcnLst = systemDao.getBasHigComNam(map);
			// 非空判断
			if (bhcnLst != null && bhcnLst.size() > 0) {
				// 循环遍历
				for (Map<String, Object> bhcnMap : bhcnLst) {
					// 非空判断
					if (!bhcnMap.isEmpty()) {
						// 获取所有公司信息
						List<Map<String, Object>> bhcanLst = systemDao.getBasComAllLst();

						if (bhcanLst != null && bhcanLst.size() > 0) {

							for (Map<String, Object> bhcanMap : bhcanLst) {
								// 判断上级公司是否在所有公司中
								if (bhcanMap.get("com_nam").toString().equals(bhcnMap.get("com_nam").toString())) {

									bhcanMap.put("sta", 1);

								} else {

									bhcanMap.put("sta", 0);
								}
							}
						}
						inpMap.put("higCom", bhcanLst);
					} else {
						// 查询所有单位信息
						List<Map<String, Object>> bhcanLst = systemDao.getBasComAllLst();

						inpMap.put("higCom", bhcanLst);
					}
				}
			} else {
				// 查询所有单位信息
				List<Map<String, Object>> bhcanLst = systemDao.getBasComAllLst();

				inpMap.put("higCom", bhcanLst);
			}
			// 查询指定单位类别信息
			List<Map<String, Object>> bctaiLst = systemDao.getBasComTypAllInfo();

			for (Map<String, Object> bctaiMap : bctaiLst) {

				map.put("id", inpMap.get("id"));
				// 查询指定单位类别信息 
				List<Map<String, Object>> bctiLst = systemDao.getBasComTypInfo(map);

				for (Map<String, Object> bctiMap : bctiLst) {
					
					if (bctaiMap.get("com_typ").toString().equals(bctiMap.get("com_typ").toString())) {

						bctaiMap.put("sta", 1);

					} else {

						bctaiMap.put("sta", 0);
					}

				}
			}
			inpMap.put("bctaiLst", bctaiLst);
		}

		return inpMap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasRegLst1Lev(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> basReg1LevLst = systemDao.getBasRegLst1Lev(map);

		return basReg1LevLst;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasRegLst2Or3Lev(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> basReg2Or3LevLst = systemDao.getBasRegLst2Or3Lev(map);

		return basReg2Or3LevLst;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updAppInf(Map<String, Object> map) throws Exception {

		systemDao.updAppInf(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delAppInf(Map<String, Object> map) throws Exception {

		systemDao.delAppInf(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insAppInf(Map<String, Object> map) throws Exception {

		utilsDao.insertBasAppInf(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasApp(Map<String, Object> map) throws Exception {

		return systemDao.getBasApp(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasAppTypAll(Map<String,Object> map) throws Exception {

		return systemDao.getBasAppTypAll(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasManTypAll() throws Exception {

		return systemDao.getBasManTypAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertComInfo(Map<String, Object> map) throws Exception {

		systemDao.insertComInfo(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updDep(Map<String, Object> map) throws Exception {

		systemDao.updDep(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insDep(Map<String, Object> map) throws Exception {

		systemDao.insDep(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasRegInfById(Map<String, Object> map) throws Exception {

		return systemDao.getBasRegInfById(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasRegInfByFatId(Map<String, Object> map) throws Exception {

		return systemDao.getBasRegInfByFatId(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasRegInfByFatIdNotPage(Map<String, Object> map) throws Exception {

		return systemDao.getBasRegInfByFatIdNotPage(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserByLoginNamePC(Map<String, Object> map) throws Exception {

		return systemDao.getUserByLoginNamePC(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserByLoginNamePCT(Map<String, Object> map) throws Exception {

		return systemDao.getUserByLoginNamePCT(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getUserByLoginNamePCTCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> chaLst = systemDao.getUserByLoginNamePCTCou(map);

		if (chaLst != null && chaLst.size() > 0) {

			for (Map<String, Object> chaMap : chaLst) {

				return chaMap;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getBasAppCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> chaLst = systemDao.getBasAppCou(map);

		if (chaLst != null && chaLst.size() > 0) {

			for (Map<String, Object> chaMap : chaLst) {

				return chaMap;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getManInfCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> chaLst = systemDao.getManInfCou(map);

		if (chaLst != null && chaLst.size() > 0) {

			for (Map<String, Object> chaMap : chaLst) {

				return chaMap;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getBasRegLst1LevCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> chaLst = systemDao.getBasRegLst1LevCou(map);

		if (chaLst != null && chaLst.size() > 0) {

			for (Map<String, Object> chaMap : chaLst) {

				return chaMap;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getBasRegInfByFatIdCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> chaLst = systemDao.getBasRegInfByFatIdCou(map);

		if (chaLst != null && chaLst.size() > 0) {

			for (Map<String, Object> chaMap : chaLst) {

				return chaMap;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAllComTyp() throws Exception {

		return systemDao.getAllComTyp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAllComNam() throws Exception {

		return systemDao.getAllComNam();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insDic(Map<String, Object> map) throws Exception {

		systemDao.insDic(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getDicById(Map<String, Object> map) throws Exception {

		return systemDao.getDicById(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updDic(Map<String, Object> map) throws Exception {

		systemDao.updDic(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getManInf(Map<String, Object> map) throws Exception {

		return systemDao.getManInf(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getManInfAll() throws Exception {
		
		return systemDao.getManInfAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasAppById(Map<String, Object> map) throws Exception {
		
		return systemDao.getBasAppById(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAllManTyp() throws Exception {

		return systemDao.getAllManTyp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insAppTyp(Map<String, Object> map) throws Exception {

		systemDao.insAppTyp(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delAppTyp(Map<String, Object> map) throws Exception {

		systemDao.delAppTyp(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updAppTyp(Map<String, Object> map) throws Exception {

		systemDao.updAppTyp(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insManTyp(Map<String, Object> map) throws Exception {
		
		systemDao.insManTyp(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delManTyp(Map<String, Object> map) throws Exception {
		
		systemDao.delManTyp(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updManTyp(Map<String, Object> map) throws Exception {
		
		systemDao.updManTyp(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insMan(Map<String, Object> map) throws Exception {
		
		systemDao.insMan(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delMan(Map<String, Object> map) throws Exception {
		
		systemDao.delMan(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updMan(Map<String, Object> map) throws Exception {
		
		systemDao.updMan(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insFauTyp(Map<String, Object> map) throws Exception {

		systemDao.insFauTyp(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delFauTyp(Map<String, Object> map) throws Exception {

		systemDao.delFauTyp(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delDic(Map<String, Object> map) throws Exception {

		systemDao.delDic(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updFauTyp(Map<String, Object> map) throws Exception {

		systemDao.updFauTyp(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUser(Map<String, Object> map) throws Exception {

		systemDao.insertUser(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUser(Map<String, Object> map) throws Exception {

		systemDao.updateUser(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUser(Map<String, Object> map) throws Exception {

		systemDao.deleteUser(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAllRolInf(Map<String, Object> map) throws Exception {

		return systemDao.getAllRolInf(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPosInfLst(Map<String, Object> map) throws Exception {

		return systemDao.getPosInfLst(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getDepInfLst(Map<String, Object> map) throws Exception {

		return systemDao.getDepInfLst(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getEduInfLst(Map<String, Object> map) throws Exception {

		return systemDao.getEduInfLst(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insReg(Map<String, Object> map) throws Exception {

		systemDao.insReg(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delReg(Map<String, Object> map) throws Exception {
		
			int count = this.systemDao.getFatRegByRegId(map);
			if (count > 0)
				return false;
			return systemDao.delReg(map) == 1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserById(Map<String, Object> map) throws Exception {

		return systemDao.getUserById(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getFauTypId(Map<String, Object> map) throws Exception {

		return systemDao.getFauTypId(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delComLev(Map<String, Object> map) throws Exception {
		
		int count = this.systemDao.getComByFatId(map);
		
		if (count > 0)
			
			return false;
		
		return systemDao.deComLev(map) == 1;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getComFat(Map<String, Object> map) throws Exception {

		return systemDao.getComFat(map);
	}

	/**
	 * 业主公司 根据公司id查询业主公司详情
	 */
	@Override
	public List<Map<String, Object>> getBasComInfoRol(Map<String, Object> map) throws Exception {
		return systemDao.getBasComInfoRol(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateComInfoRol(Map<String, Object> map) throws Exception {
		systemDao.updateComInfoRol(map);

	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertComInfoRol(Map<String, Object> map) throws Exception {

		systemDao.insertComInfoRol(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateComInfoRol2(Map<String, Object> map) throws Exception {
		systemDao.updateComInfoRol2(map);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertComInfoRol2(Map<String, Object> map) throws Exception {

		systemDao.insertComInfoRol2(map);
	}

	/** 数据字典管理 start */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insDataDic(DataDicDto dataDicDto) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("par_ide", dataDicDto.getPar_ide());
		map.put("par_nam", dataDicDto.getPar_nam());
		map.put("par_val", dataDicDto.getPar_val());
		map.put("sor_num", dataDicDto.getSor_num());
		map.put("dic_typ_id", dataDicDto.getDic_typ_id());
		map.put("del_flag", DataDicDto.DEL_NO);
		map.put("crt_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		map.put("crt_use_id",dataDicDto.getCrt_use_id());

		systemDao.insDataDic(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updDataDic(DataDicDto dataDicDto) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", dataDicDto.getId());
		map.put("par_ide", dataDicDto.getPar_ide());
		map.put("par_nam", dataDicDto.getPar_nam());
		map.put("par_val", dataDicDto.getPar_val());
		map.put("sor_num", dataDicDto.getSor_num());
		map.put("dic_typ_id", dataDicDto.getDic_typ_id());
		map.put("del_flag", DataDicDto.DEL_NO);
		map.put("mod_tim", new Date());
		map.put("mod_use_id",dataDicDto.getCrt_use_id());
		systemDao.updDataDic(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delDataDic(Map<String, Object> map) throws Exception {

		int dataDicFlag = systemDao.getDataDicFlag(map);
		if (dataDicFlag == DataDicDto.DEL_NO) {
			systemDao.delDataDic(map);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataDicDto getDataDicById(Map<String, Object> map) throws Exception {
		return systemDao.getDataDicById(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDicListCount(Map<String, Object> map) throws Exception {
		return systemDao.getDicListCount(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getDataDicListByTypAndNam(Map<String, Object> map) throws Exception {
		return systemDao.getDataDicListByTypAndNam(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getDataDicTypByName(Map<String, Object> map) throws Exception {
		return systemDao.getDataDicTypByName(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insDataDicTyp(DataDicTypeDto dataDicTypeDto) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dic_typ_ide", dataDicTypeDto.getDic_typ_ide());
		map.put("dic_typ_nam", dataDicTypeDto.getDic_typ_nam());
		map.put("sor_num", dataDicTypeDto.getSor_num());
		map.put("remark", dataDicTypeDto.getRemark());
		map.put("del_flag", DataDicTypeDto.DEL_NO);
		map.put("crt_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		map.put("crt_use_id",dataDicTypeDto.getCrt_use_id());
		systemDao.insDataDicTyp(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updDataDicTyp(DataDicTypeDto dataDicTypeDto) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", dataDicTypeDto.getId());
		map.put("dic_typ_ide", dataDicTypeDto.getDic_typ_ide());
		map.put("dic_typ_nam", dataDicTypeDto.getDic_typ_nam());
		map.put("sor_num", dataDicTypeDto.getSor_num());
		map.put("remark", dataDicTypeDto.getRemark());
		map.put("del_flag", DataDicTypeDto.DEL_NO);
		map.put("mod_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		map.put("mod_use_id",dataDicTypeDto.getMod_use_id());
		systemDao.updDataDicTyp(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delDataDicTyp(Map<String, Object> map) throws Exception {
		int dataDicTypFlag = systemDao.getDataDicTypFlag(map);
		if (dataDicTypFlag == DataDicTypeDto.DEL_NO) {
			
			int count = this.systemDao.getDataDicTypId(map);
			if (count > 0)
				return false;
			return systemDao.delDataDicTyp(map) == 1;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataDicTypeDto getDataDicTypById(Map<String, Object> map) throws Exception {
		return systemDao.getDataDicTypById(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDataDicTypCount(Map<String, Object> map) throws Exception {
		return systemDao.getDataDicTypCount(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getDataDicTypList(Map<String, Object> map) throws Exception {
		return systemDao.getDataDicTypList(map);
	}

	// 增加新的告警码

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int InsertAlaCode(String ala_ide, String app_typ_id, String idx_pst, String ala_typ_id, String flt_lev,
			String ala_info, String remark, String crt_use_id, Date crt_tim) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("app_typ_id", app_typ_id);
		map.put("idx_pst", idx_pst);
		map.put("ala_typ_id", ala_typ_id);
		map.put("flt_lev", flt_lev);
		map.put("ala_info", ala_info);
		map.put("remark", remark);
		map.put("crt_use_id", crt_use_id);
		map.put("crt_tim", crt_tim);
		return systemDao.InsertAlaCode(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int removeAlaCode(int id) throws Exception {
		return systemDao.removeAlaCode(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updateAlaCodeInfo(int id,String app_typ_id, String idx_pst, String flt_lev, String ala_typ_id, String ala_info,
			String remark, String mod_use_id, Date mod_tim) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("app_typ_id", app_typ_id);
		map.put("idx_pst", idx_pst);
		map.put("flt_lev", flt_lev);
		map.put("ala_typ_id", ala_typ_id);
		map.put("ala_info", ala_info);
		map.put("remark", remark);
		map.put("mod_use_id", mod_use_id);
		map.put("mod_tim", mod_tim);
		return systemDao.updateAlaCodeInfo(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insertAlaTyp(String ala_nam, int app_typ_id, int crt_use_id, Date crt_tim, String remark)
			throws Exception {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("ala_nam", ala_nam);
		map.put("app_typ_id", app_typ_id);
		map.put("crt_use_id", crt_use_id);
		map.put("crt_tim", crt_tim);
		map.put("remark", remark);
		return systemDao.InsertAlaType(map)==1;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAlaType(int id) {
		int count=systemDao.getAlaCodeCountByType(id);
		if(count>0) return false;
		return systemDao.removeAlaType(id)==1;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAlaType(String id) {
		return systemDao.getAlaType(id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAla(Map<String,Object> map) {
		
		return systemDao.getAlaCode(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getAlaCodeInfoCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> retLst = systemDao.getAlaCodeInfoCou(map);

		if (retLst != null && retLst.size() > 0) {

			for (Map<String, Object> retMap : retLst) {

				return retMap;
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public  List<Map<String, Object>> getAppInfoById(String id) {
		return systemDao.getAppInfoById(id);
	}
	
	@Override
	public boolean updateAlaType(String ala_nam, String app_typ_id, String mod_use_id, Date mod_tim, String remark,
			String id) {
	Map<String,Object> map=new HashMap<String, Object>();
	map.put("ala_nam", ala_nam);
	map.put("app_typ_id", app_typ_id);
	map.put("mod_use_id", mod_use_id);
	map.put("mod_tim", mod_tim);
	map.put("remark", remark);
	map.put("id", id);
	
		return systemDao.updateAlaType(map)==1;
	}
	/* 告警码和类型维护End */


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDataDicTypFlag(Map<String, Object> map) throws Exception {
		return systemDao.getDataDicTypFlag(map);
	}
	/** 数据字典管理 end */
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEquInfLst(Map<String, Object> map) throws Exception {
		
		return systemDao.getEquInfLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getEquInfLstCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> couLst = systemDao.getEquInfLstCou(map);

		if (couLst != null && couLst.size() > 0) {

			for (Map<String, Object> couMap : couLst) {

				return couMap;
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getCtlEquInfLst(Map<String, Object> map) throws Exception {
		
		return systemDao.getCtlEquInfLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEquInfByEquId(Map<String, Object> map) throws Exception {
		
		return systemDao.getEquInfByEquId(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getCtlEquInfLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> couLst = systemDao.getCtlEquInfLstCou(map);
		
		if (couLst != null && couLst.size() > 0) {
			
			for (Map<String, Object> couMap : couLst) {
				
				return couMap;
			}
		}
		return null;
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void insertEquInfo(Map<String, Object> map) throws Exception {
		
		systemDao.insertEquInfo(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void updateEquInfo(Map<String, Object> map) throws Exception {
		
		systemDao.updateEquInfo(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void updateMqtt(Map<String, Object> map) throws Exception {
		
		systemDao.updateMqtt(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getMqttInfByEquNum(Map<String, Object> map) throws Exception {
		
		return systemDao.getMqttInfByEquNum(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void insertMqtt(Map<String, Object> map) throws Exception {
		
		systemDao.insertMqtt(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void delectEquInfo(Map<String, Object> map) throws Exception {
		
		systemDao.delectEquInfo(map);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLst(Map<String, Object> map) throws Exception {
		
		List<Map<String,Object>> retLst = new ArrayList<Map<String,Object>>();
		
		CompanyDto companyDto = new CompanyDto();
		
		companyDto.setId(Integer.valueOf(map.get("com_id").toString()));
		// 获取到传入的公司信息
		List<Map<String, Object>> optComInfLst = utilsDao.getComInfByComId(companyDto);
		
		String com_lev = "";
		
		if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
			
			for(Map<String, Object> optComInfMap:optComInfLst){
				
				com_lev = optComInfMap.get("com_lev").toString();
			}
		}
		// 判断公司级别
		if(com_lev.equals("1")){
			// 获取站点列表信息(1级公司查询)
			retLst = systemDao.getPwsInfLstBy1LevCom(map);
			
		}else if(com_lev.equals("2")){
			// 获取站点列表信息(2级公司查询)
			retLst = systemDao.getPwsInfLstBy2LevCom(map);
			
		}else if(com_lev.equals("3")){
			// 获取站点列表信息(3级公司查询)
			retLst = systemDao.getPwsInfLst(map);
		}
		
		return retLst;
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstByComId(Map<String, Object> map) throws Exception {
		
		List<Map<String,Object>> retLst = new ArrayList<Map<String,Object>>();
		
		CompanyDto companyDto = new CompanyDto();
		
		companyDto.setId(Integer.valueOf(map.get("com_id").toString()));
		// 获取到传入的公司信息
		List<Map<String, Object>> optComInfLst = utilsDao.getComInfByComId(companyDto);
		
		String com_lev = "";
		
		if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
			
			for(Map<String, Object> optComInfMap:optComInfLst){
				
				com_lev = optComInfMap.get("com_lev").toString();
			}
		}
		
		map.put("start", 0);
		
		map.put("everyPage", 10000000);
		
		// 判断公司级别
		if(com_lev.equals("1")){
			// 获取站点列表信息(1级公司查询)
			retLst = systemDao.getPwsInfLstBy1LevCom(map);
			
		}else if(com_lev.equals("2")){
			// 获取站点列表信息(2级公司查询)
			retLst = systemDao.getPwsInfLstBy2LevCom(map);
			
		}else if(com_lev.equals("3")){
			// 获取站点列表信息(3级公司查询)
			retLst = systemDao.getPwsInfLst(map);
		}
		
		return retLst;
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPwsInfLstByPwsId(Map<String, Object> map) throws Exception {
		
		return systemDao.getPwsInfLstByPwsId(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getPwsInfLstCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> couLst = new ArrayList<Map<String,Object>>();
		
		CompanyDto companyDto = new CompanyDto();
		
		companyDto.setId(Integer.valueOf(map.get("com_id").toString()));
		// 获取到传入的公司信息
		List<Map<String, Object>> optComInfLst = utilsDao.getComInfByComId(companyDto);
		
		String com_lev = "";
		
		if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
			
			for(Map<String, Object> optComInfMap:optComInfLst){
				
				com_lev = optComInfMap.get("com_lev").toString();
			}
		}
		// 判断公司级别
		if(com_lev.equals("1")){
			// 获取站点列表信息(1级公司查询)(分页)
			couLst = systemDao.getPwsInfLstBy1LevComCou(map);
			
		}else if(com_lev.equals("2")){
			// 获取站点列表信息(2级公司查询)(分页)
			couLst = systemDao.getPwsInfLstBy2LevComCou(map);
			
		}else if(com_lev.equals("3")){
			// 获取站点列表信息(3级公司查询)(分页)
			couLst = systemDao.getPwsInfLstCou(map);
		}
		
		if (couLst != null && couLst.size() > 0) {
			
			for (Map<String, Object> couMap : couLst) {
				
				return couMap;
			}
		}
		return null;
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void insertPwsInfo(Map<String, Object> map) throws Exception {
		
		systemDao.insertPwsInfo(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void updatePwsInfo(Map<String, Object> map) throws Exception {
		
		systemDao.updatePwsInfo(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void delectPwsInfo(Map<String, Object> map) throws Exception {
		
		systemDao.delectPwsInfo(map);
	}
	
	/**
	 * 获取业主、合作伙伴信息列表
	 */
	@Override
	public List<Map<String, Object>> getComRolOneAndTwo(Map<String, Object> map) throws Exception {
		
		return systemDao.getComRolOneAndTwo(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void updReg(Map<String, Object> map) throws Exception {
		
		systemDao.updReg(map);
	}
	
	/**
	 * 人员任务  转移
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<Map<String, Object>> moveTaskByUserId(Map<String, Object> map) throws Exception {

		// 关于巡视
		Map<String, Object> tourAppointMap = new HashMap<String, Object>();

		tourAppointMap.put("appoint_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 巡视任务 我创建的
		List<Map<String, Object>> lstTourAppoint = systemDao.selAppointTourTaskByUserId(tourAppointMap);

		Map<String, Object> tourExecuteMap = new HashMap<String, Object>();

		tourExecuteMap.put("task_execute_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 巡视任务 我执行的
		List<Map<String, Object>> lstTourExecute = systemDao.selExecuteTourTaskByUserId(tourExecuteMap);

		Map<String, Object> tourCheckMap = new HashMap<String, Object>();

		tourCheckMap.put("task_check_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 巡视任务 我审核的
		List<Map<String, Object>> lstTourCheck = systemDao.selCheckTourTaskByUserId(tourCheckMap);

		if (lstTourAppoint != null && !lstTourAppoint.isEmpty()) {

			for (Map<String, Object> lstTourAppointMap:lstTourAppoint) {

				Map<String, Object> appointMap = new HashMap<String, Object>();

				appointMap.put("id", lstTourAppointMap.get("id"));

				appointMap.put("appoint_id", map.get("after_user_id"));
				// 修改 我创建的
				systemDao.updTourTaskByUserId(appointMap);
			}
		}

		if (lstTourExecute != null && !lstTourExecute.isEmpty()) {

			for (Map<String, Object> lstTourAppointMap : lstTourAppoint) {

				Map<String, Object> executeMap = new HashMap<String, Object>();

				executeMap.put("id", lstTourAppointMap.get("id"));

				executeMap.put("task_execute_id", map.get("after_user_id"));
				// 修改 我执行的
				systemDao.updTourTaskExecuteByUserId(executeMap);
			}
		}

		if (lstTourCheck != null && !lstTourCheck.isEmpty()) {

			for (Map<String, Object> lstTourCheckMap:lstTourCheck) {

				Map<String, Object> checkMap = new HashMap<String, Object>();

				checkMap.put("id", lstTourCheckMap.get("id"));

				checkMap.put("task_check_id", map.get("after_user_id"));
				// 修改 我审核的
				systemDao.updTourTaskCheckByUserId(checkMap);
			}
		}

		//关于检修
		Map<String, Object> overhaulAppointMap = new HashMap<String, Object>();

		overhaulAppointMap.put("appoint_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 检修任务 我创建的
		List<Map<String, Object>> lstOverhaulAppoint = systemDao.selAppointOverhaulTaskByUserId(overhaulAppointMap);

		Map<String, Object> overhaulExecuteMap = new HashMap<String, Object>();

		overhaulExecuteMap.put("task_execute_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 检修任务 我执行的
		List<Map<String, Object>> lstOverhaulExecute = systemDao.selExecuteOverhaulTaskByUserId(overhaulExecuteMap);

		Map<String, Object> overhaulCheckMap = new HashMap<String, Object>();

		overhaulCheckMap.put("task_check_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 检修任务 我审核的
		List<Map<String, Object>> lstOverhaulCheck = systemDao.selCheckOverhaulTaskByUserId(overhaulCheckMap);

		if (lstOverhaulAppoint != null && !lstOverhaulAppoint.isEmpty()) {

			for (Map<String, Object> lstOverhaulAppointMap:lstOverhaulAppoint) {

				Map<String, Object> appointMap = new HashMap<String, Object>();

				appointMap.put("id", lstOverhaulAppointMap.get("id"));

				appointMap.put("appoint_id", map.get("after_user_id"));
				// 修改 我创建的
				systemDao.updOverhaulTaskByUserId(appointMap);
			}
		}

		if (lstOverhaulExecute != null && !lstOverhaulExecute.isEmpty()) {

			for (Map<String, Object> lstOverhaulExecuteMap:lstOverhaulExecute) {

				Map<String, Object> executeMap = new HashMap<String, Object>();

				executeMap.put("id", lstOverhaulExecuteMap.get("id"));

				executeMap.put("task_execute_id", map.get("after_user_id"));
				// 修改 我执行的
				systemDao.updOverhaulTaskExecuteByUserId(executeMap);
			}
		}

		if (lstOverhaulCheck != null && !lstOverhaulCheck.isEmpty()) {

			for (Map<String, Object> lstOverhaulCheckMap:lstOverhaulCheck) {

				Map<String, Object> checkMap = new HashMap<String, Object>();

				checkMap.put("id", lstOverhaulCheckMap.get("id"));

				checkMap.put("task_check_id", map.get("after_user_id"));
				// 修改 我审核的
				systemDao.updOverhaulTaskCheckByUserId(checkMap);
			}
		}
		
		// 关于报修
		Map<String, Object> repairCrtUserMap = new HashMap<String, Object>();

		repairCrtUserMap.put("crt_use_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 报修任务 我创建的
		List<Map<String, Object>> lstRepairCrtUser = systemDao.selCrtUseRepairTaskByUserId(repairCrtUserMap);

		Map<String, Object> repairRepairUserMap = new HashMap<String, Object>();

		repairRepairUserMap.put("repair_use_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 报修任务 我维修的
		List<Map<String, Object>> lstRepairRepairUserMap = systemDao.selRepairUserRepairTaskByUserId(repairRepairUserMap);

		Map<String, Object> repairCheckMap = new HashMap<String, Object>();

		repairCheckMap.put("check_use_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 报修任务 我审核的
		List<Map<String, Object>> lstRepairCheck = systemDao.selCheckRepairTaskByUserId(repairCheckMap);

		if (lstRepairCrtUser != null && !lstRepairCrtUser.isEmpty()) {

			for (Map<String, Object> lstRepairCrtUserMap:lstRepairCrtUser) {

				Map<String, Object> crtUserMap = new HashMap<String, Object>();

				crtUserMap.put("id", lstRepairCrtUserMap.get("id"));

				crtUserMap.put("crt_use_id", map.get("after_user_id"));
				// 修改 我创建的
				systemDao.updRepairTaskCrtUseByUserId(crtUserMap);
			}
		}

		if (lstRepairRepairUserMap != null && !lstRepairRepairUserMap.isEmpty()) {

			for (Map<String, Object> lstRepairRepairUserMapMap:lstRepairRepairUserMap) {

				Map<String, Object> repairUserMap = new HashMap<String, Object>();

				repairUserMap.put("id", lstRepairRepairUserMapMap.get("id"));

				repairUserMap.put("repair_use_id", map.get("after_user_id"));
				// 修改 我维修的
				systemDao.updRepairTaskRepairUserByUserId(repairUserMap);
			}
		}

		if (lstRepairCheck != null && !lstRepairCheck.isEmpty()) {

			for (Map<String, Object> lstRepairCheckMap:lstRepairCheck) {

				Map<String, Object> repairRepairCheckMap = new HashMap<String, Object>();

				repairRepairCheckMap.put("id", lstRepairCheckMap.get("id"));

				repairRepairCheckMap.put("check_use_id",map.get("after_user_id"));
				// 修改 我审核的
				systemDao.updRepairTaskCheckByUserId(repairRepairCheckMap);
			}
		}

		// 关于报废
		Map<String, Object> scrapCrtUserMap = new HashMap<String, Object>();

		scrapCrtUserMap.put("crt_use_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 报废任务 我创建的
		List<Map<String, Object>> lstScrapCrtUser = systemDao.selCrtUseScrapTaskByUserId(scrapCrtUserMap);

		Map<String, Object> scrapOneCheckMap = new HashMap<String, Object>();

		scrapOneCheckMap.put("one_check_use_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 报废任务 我第一次审核的
		List<Map<String, Object>> lstScrapOneCheckMap = systemDao.selOneCheckScrapTaskByUserId(scrapOneCheckMap);

		Map<String, Object> scrapTwoCheckMap = new HashMap<String, Object>();

		scrapTwoCheckMap.put("two_chcek_use_id", map.get("before_user_id"));

		// 根据用户id 查询关于用户的 报废任务 我第二次审核的
		List<Map<String, Object>> lstScrapTwoCheck = systemDao.selTwoCheckScrapTaskByUserId(scrapTwoCheckMap);

		if (lstScrapCrtUser != null && !lstScrapCrtUser.isEmpty()) {

			for (Map<String, Object> lstScrapCrtUserMap:lstScrapCrtUser) {

				Map<String, Object> crtUserMap = new HashMap<String, Object>();

				crtUserMap.put("id", lstScrapCrtUserMap.get("id"));

				crtUserMap.put("crt_use_id", map.get("after_user_id"));
				// 修改 我创建的
				systemDao.updScrapTaskCrtUseByUserId(crtUserMap);
			}
		}

		if (lstScrapOneCheckMap != null && !lstScrapOneCheckMap.isEmpty()) {

			for (Map<String, Object> lstScrapOneCheckMapMap:lstScrapOneCheckMap) {

				Map<String, Object> oneCheckMap = new HashMap<String, Object>();

				oneCheckMap.put("id", lstScrapOneCheckMapMap.get("id"));

				oneCheckMap.put("one_check_use_id", map.get("after_user_id"));
				// 修改 我第一次审核的
				systemDao.updScrapTaskOneCheckByUserId(oneCheckMap);
			}
		}

		if (lstScrapTwoCheck != null && !lstScrapTwoCheck.isEmpty()) {

			for (Map<String, Object> lstScrapTwoCheckMap:lstScrapTwoCheck) {

				Map<String, Object> TwoCheckMap = new HashMap<String, Object>();

				TwoCheckMap.put("id", lstScrapTwoCheckMap.get("id"));

				TwoCheckMap.put("two_chcek_use_id", map.get("after_user_id"));
				// 修改 我第二次审核的
				systemDao.updScrapTaskTwoCheckByUserId(TwoCheckMap);
			}
		}

		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void insertUseAndPwsInf(Map<String, Object> map) throws Exception {
		
		systemDao.insertUseAndPwsInf(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public void deleteUseAndPwsInfByUseId(Map<String, Object> map) throws Exception {
		
		systemDao.deleteUseAndPwsInfByUseId(map);
	}
	
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<Map<String, Object>> getUseAndPwsInfLst(Map<String, Object> map) throws Exception {
		// 获取传入用户的所有的关联站信息
		List<Map<String,Object>> useAndPwsLst = systemDao.getUseAndPwsInfLst(map);
		// 获取平台内的所有的一级公司、二级公司、三级公司、站信息
		//1.调用getFstLevComLstByOptUseId
		List<Map<String, Object>> comLev1Lst = utilsDao.getOptComLstByComLevComRol();
		
		//2.for循环上面的集合
		for (Map<String, Object> comLev1Map : comLev1Lst) {
			
			//3.获取com_id(id)
			CompanyDto comLev1Dto = new CompanyDto();
			
			//4.使用这个ID做getFatComInfByComId方法的com_fat_id
			comLev1Dto.setId(Integer.valueOf(comLev1Map.get("id").toString()));
			// 使用公司ID获取其下所有子公司信息
			List<Map<String, Object>> comLev2Lst = utilsDao.getFatComInfByComIdAll(comLev1Dto);
			
			for (Map<String, Object> comLev2Map : comLev2Lst) {
				
				//3.获取com_id(id)
				CompanyDto comLev2Dto = new CompanyDto();
				
				//4.使用这个ID做getFatComInfByComId方法的com_fat_id
				comLev2Dto.setId(Integer.valueOf(comLev2Map.get("id").toString()));
				// 使用公司ID获取其下所有子公司信息
				List<Map<String, Object>> comLev3Lst = utilsDao.getFatComInfByComIdAll(comLev2Dto);
				
				if(comLev3Lst != null && !comLev3Lst.isEmpty()){
					
					for(Map<String, Object> comLev3Map:comLev3Lst){
						
						Map<String,Object> inpPwsMap = new HashMap<String, Object>();
						
						inpPwsMap.put("com_id", comLev3Map.get("id"));
						// 获取三级公司下的所有电站
						List<Map<String, Object>> pwsInfLst = utilsDao.getPwsInfLstByPwsId(inpPwsMap);
						
						if(pwsInfLst != null && !pwsInfLst.isEmpty()){
							
							for(Map<String, Object> pwsInfMap : pwsInfLst){
								// 判断传入用户是否有关联的站
								if(useAndPwsLst != null && !useAndPwsLst.isEmpty()){// 如果有
									
									for(Map<String, Object> useAndPwsMap:useAndPwsLst){
										
										if(useAndPwsMap.get("pws_id").toString().equals(pwsInfMap.get("id").toString())){
											
											// is_dpl(回传的电站是否勾选复选框,0为不勾选,1为勾选)
											pwsInfMap.put("is_dpl", 1);
											
										}
									}
								}
							}
							
							for(Map<String, Object> pwsInfMap : pwsInfLst){
								
								if(pwsInfMap.get("is_dpl") == null){
									
									// is_dpl(回传的电站是否勾选复选框,0为不勾选,1为勾选)
									pwsInfMap.put("is_dpl", 0);
								}
							}
						}
						
						comLev3Map.put("pwsInfLst", pwsInfLst);
					}
				}
				
				comLev2Map.put("comLev3Lst", comLev3Lst);
				
			}
			comLev1Map.put("comLev2Lst", comLev2Lst);
		}
				
		return comLev1Lst;
	}
	
	
	/**
	 * 使用ID获取获取厂家类型
	 */
	@Override
	public List<Map<String, Object>> getAllManTypById(Map<String, Object> map) throws Exception {
		
		return systemDao.getAllManTypById(map);
	}
	
	/**
	 * 使用ID获取角色信息
	 */
	@Override
	public List<Map<String, Object>> getUserRoleById(Map<String, Object> map) throws Exception {
		
		return systemDao.getUserRoleById(map);
	}
	/**
	 * 修改角色信息
	 */
	@Override
	public List<Map<String, Object>> updateUserRole(Map<String, Object> map) throws Exception {
		
		return systemDao.updateUserRole(map);
	}
	
	/**
	 * 角色名称 查看 角色信息  
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByRolNam(Map<String, Object> map) throws Exception {
		
		return systemDao.getUserRoleByRolNam(map);
	}
	
	
	
	/**
	 * 公司信息 添加图片 logo
	 */
	@Value("${file.upload.path}")
	String filePath;

	@Override
	public BaseTransferEntity uploadComImg(Map<String, Object> map,MultipartFile[] files, String filePath) {
	
		BaseTransferEntity  upload = new BaseTransferEntity();
		// 遍历文件集合
		for (MultipartFile file : files) {

        	 if (file == null || file.isEmpty() ) {
                 continue;
             }
        	 // 上传公司logo
        	 upload = uploadComImgLogo(file);

             if (upload == null) {
            	 
                 return upload;
             }
             
             Map<String, String> mapImg = (Map<String, String>) upload.getData();
             
             if (mapImg != null) {
            	
            	 //图片访问路径  
                 String url = PropertiesUtil.getProperty("file.prefix") + mapImg.get("newName");
                 
                 //缩略图访问路径  
                 String trumUrl = PropertiesUtil.getProperty("file.prefix") + mapImg.get("thumFileName");
                 
                 Map<String,Object> picMap = new HashMap<String, Object>();
                 picMap.put("comPicUrl",url);
                 picMap.put("comPjtNam", map.get("comPjtNam"));
                 picMap.put("id", map.get("id"));
                 picMap.put("comPicThum",trumUrl);
                 picMap.put("use_id",map.get("use_id"));
                 picMap.put("mod_tim",map.get("mod_tim"));
                 
                 try {
                	 
                	 // 公司信息 添加图片 logo
					systemDao.insertComLogoImg(picMap);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
             }
        }

		return upload;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseTransferEntity uploadComImgLogo(MultipartFile file) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			//获取文件名称
			String fileName = file.getOriginalFilename();

			// abc.jpg
			String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			//判断文件 后缀   如果不是图片
			if (!fileExtensionName.equalsIgnoreCase("jpg") && !fileExtensionName.equalsIgnoreCase("png") ) {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				
				baseTransferEntity.setDesc("请上传正确格式的图片进行上传。");
				
			}else{
			
			//图片   
			String uploadFileName = UUID.randomUUID().toString() + "."+ fileExtensionName;

			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				fileDir.setWritable(true);
				fileDir.mkdirs();
			}

			File targetFile = new File(filePath, uploadFileName);
			file.transferTo(targetFile);

			//缩略图
            BufferedImage image = ImageIO.read(targetFile);
            String thumFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
            File thumFile = new File(filePath, thumFileName);
            if (thumFile != null) {
                thumFile.setWritable(true, false);
                Thumbnails.of(file.getInputStream()).size(image.getWidth() / 2, image.getHeight() / 2).toFile(thumFile);
            }

			Map<String, String> mapImg = new HashMap<String, String>();
			
			mapImg.put("tour_image_name", fileName);
			mapImg.put("newName", uploadFileName);
			mapImg.put("thumFileName", thumFileName);
			
			baseTransferEntity.setData(mapImg);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}

		} catch (IOException e) {
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
			baseTransferEntity.setDesc("上传文件异常");

		}
		return baseTransferEntity;

	}
	
	
	/**
	 * 使用公司id 获取公司所有信息 包括公司logo及缩略图地址
	 */
	@Override
	public List<Map<String, Object>> getComLogoImgById(Map<String, Object> map) throws Exception {
		
		return systemDao.getComLogoImgById(map);
	}
	
	
	/**
	 * 查询三级地区列表,一级（省级）(所有)
	 */
	@Override
	public List<Map<String, Object>> getBasRegLst1LevAll(Map<String, Object> map) throws Exception {
		
		return systemDao.getBasRegLst1LevAll(map);
	}
	
	
	
	/**
	 * 电站图片 上传
	 */
	@Transactional
	@Override
	public BaseTransferEntity uploadPwsPic(Map<String, Object> map,MultipartFile[] files, String filePath) {
		
		BaseTransferEntity  upload = new BaseTransferEntity();
		
		//查询电站图片的数量   不能超过2张
		List<Map<String, Object>> lstPwsPicSize = systemDao.getPwsPicByPwsId(map);
		
		if(lstPwsPicSize != null && !lstPwsPicSize.isEmpty()){
			
			if(Integer.parseInt(lstPwsPicSize.get(0).get("cou").toString()) >= 2){
				//使用电站id 查询该电站最先添加的图片的信息
				List<Map<String, Object>> lstPwsPicOld = systemDao.getPwsOldPicByPwsId(map);
				
				Map<String,Object> pwsMap = new HashMap<String, Object>();
				pwsMap.put("id",lstPwsPicOld.get(0).get("id"));
				// 删除 电站图片 
				systemDao.deletePwsPic(pwsMap);
			}
		}
		
        for (MultipartFile file : files) {

        	 if (file == null || file.isEmpty() ) {
        		 
                 continue;
             }

        	 upload = uploadPws(file);

             if(StringUtil.equalsIgnoreCase(upload.getResultcode(),MobileConfig.getStringCode("msg.global.failed"))){
            	 
            	 return upload;
             }
             
             Map<String, String> mapImg = (Map<String, String>) upload.getData();
             
             if (mapImg != null) {
            	
            	 //图片访问路径  
                 String url = PropertiesUtil.getProperty("file.prefix") + mapImg.get("newName");
                 
                 Map<String,Object> picMap = new HashMap<String, Object>();
                 picMap.put("pic_nam",mapImg.get("newName"));
                 picMap.put("pic_url",url);
                 picMap.put("pws_id",map.get("pws_id"));
                 picMap.put("crt_use_id",map.get("user_id"));
                 picMap.put("crt_tim",new Date());
                 picMap.put("remark",map.get("remark"));
                 
                 try {
					systemDao.insertPwsPic(picMap);;
				} catch (Exception e) {
					
					e.printStackTrace();
				}
             }
        }

		return upload;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseTransferEntity uploadPws(MultipartFile file) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
	
		try {
			//获取文件名称
			String fileName = file.getOriginalFilename();

			// abc.jpg
			String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			//判断文件 后缀   如果不是图片
			if (!fileExtensionName.equalsIgnoreCase("jpg") && !fileExtensionName.equalsIgnoreCase("png") ) {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				
				baseTransferEntity.setDesc("请上传正确格式的图片进行上传,仅支持.jpg/.png格式。");
				
				return baseTransferEntity;
				
			}else{
			
			//图片   
			String uploadFileName = UUID.randomUUID().toString() + "."+ fileExtensionName;

			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				fileDir.setWritable(true);
				fileDir.mkdirs();
			}

			File targetFile = new File(filePath, uploadFileName);
			file.transferTo(targetFile);

			Map<String, String> mapImg = new HashMap<String, String>();
			
			mapImg.put("fileName",fileName);
			mapImg.put("newName",uploadFileName);
			
			baseTransferEntity.setData(mapImg);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}

		} catch (IOException e) {
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
			baseTransferEntity.setDesc("上传文件异常");

		}
		return baseTransferEntity;

	}
	
	

	/**
	 * 电站id 查询该电站图片总数量   不可以超过2张图片
	 */
	@Override
	public List<Map<String, Object>> getPwsPicByPwsId(Map<String, Object> map) throws Exception {
		
		return systemDao.getPwsPicByPwsId(map);
	}
	
	/**
	 * 使用电站id 查询该电站最先添加的图片的信息
	 */
	@Override
	public List<Map<String, Object>> getPwsOldPicByPwsId(Map<String, Object> map) throws Exception {
		
		return systemDao.getPwsPicByPwsId(map);
	}
	
	/**
	 * 删除 电站图片 
	 */
	@Override
	public void deletePwsPic(Map<String, Object> map) throws Exception {
		
		systemDao.deletePwsPic(map);
	}
	
	/**
	 * 使用 设备编号  查询 设备名称
	 */
	@Override
	public List<Map<String, Object>> getEquNameByEquNum(Map<String, Object> map) throws Exception {
		
		return systemDao.getEquNameByEquNum(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getMeterTypLstAll() throws Exception {
		
		return systemDao.getMeterTypLstAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAllOptComNam() throws Exception {
		
		return systemDao.getAllOptComNam();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAllOwnComNam() throws Exception {
		
		return systemDao.getAllOwnComNam();
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selFeedBackAll(Map<String,Object> map) throws Exception {
		
		return systemDao.selFeedBackAll(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> selFeedBackByUseId(Map<String,Object> map) throws Exception {
		
		return systemDao.selFeedBackByUseId(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> selFeedBackAllCou(Map<String,Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = systemDao.selFeedBackAllCou(map);
		
		if (retLst != null && retLst.size() > 0) {

			for (Map<String, Object> retMap : retLst) {

				return retMap;
			}
		}
		return null;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertFeedBack(Map<String,Object> map) throws Exception {
		
		systemDao.insertFeedBack(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delFeedBackById(Map<String,Object> map) throws Exception {
		
		systemDao.delFeedBackById(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updReplyById(Map<String,Object> map) throws Exception {
		
		systemDao.updReplyById(map);
	}
	
	/**
	 * 本接口为获取平台中所有自己公司的信息接口（组织机构处使用）
	 */
	@Override
	public List<Map<String, Object>> getOrgFatComInfByComId(Map<String,Object> map) throws Exception {
		
		return utilsDao.getOrgFatComInfByComId(map);
		
	}
	
	/**
	 * 用户头像上传 
	 */
	@Override
	public BaseTransferEntity uploadUserImg(Map<String, Object> map,
			MultipartFile[] files, String filePath) {
		
		BaseTransferEntity upload = new BaseTransferEntity();
		// 遍历文件集合
		for (MultipartFile file : files) {
			// 判断传过来的文件集合是否为空
			if (file == null || file.isEmpty()) {
				continue;
			}
			// 上传图表
			upload = insertUserImg(file);

			if (upload == null) {
				return upload;
			}
			Map<String, String> mapImg = (Map<String, String>) upload.getData();

			if (mapImg != null) {
				
				// 图片的添加
				String url = PropertiesUtil.getProperty("file.prefix")+ mapImg.get("newName");

				Map<String, Object> picMap = new HashMap<String, Object>();
				picMap.put("pic_url", url);
				picMap.put("pic_nam", mapImg.get("oldName"));
				picMap.put("pic_new_nam", mapImg.get("newName"));
				picMap.put("id", map.get("id"));
				// 用户头像 添加 
				systemDao.insertUserImg(picMap);
					
			}
		}

		return upload;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseTransferEntity insertUserImg(MultipartFile file) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			// 获取文件名称
			String fileName = file.getOriginalFilename();

			// abc.jpg
			String fileExtensionName = fileName.substring(fileName
					.lastIndexOf(".") + 1);
			// 图片
			String uploadFileName = UUID.randomUUID().toString() + "."+ fileExtensionName;
				// 通过文件路径获取文件资源
				File fileDir = new File(filePath);
				// 判断文件是否存在
				if (!fileDir.exists()) {
					fileDir.setWritable(true);
					fileDir.mkdirs();
				}
				// 上传文件
				File targetFile = new File(filePath, uploadFileName);
				file.transferTo(targetFile);

				Map<String, String> mapImg = new HashMap<String, String>();

				mapImg.put("oldName", fileName);
				mapImg.put("newName", uploadFileName);

				baseTransferEntity.setData(mapImg);
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (IOException e) {
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
			baseTransferEntity.setDesc("上传文件异常");

		}
		return baseTransferEntity;
	}
	
}
