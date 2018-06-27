/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qinergy.dao.operations.tour.TourDao;
import com.qinergy.dao.utils.UtilsDao;
import com.qinergy.dto.common.InterfaceConstants;
import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.UserDto;
import com.qinergy.util.StringUtil;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UtilsServiceImpl implements UtilsService {
	
    @Autowired
    private UtilsDao utilsDao;
    

	@Autowired
	TourDao tourDao;


    /**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 * @throws Exception
	 */
    @Override
	public List<Map<String, Object>> getEquInfByEquNum(Map<String, Object> map) throws Exception {
    	
		return utilsDao.getEquInfByEquNum(map);
	}
    
    /**
     * {@inheritDoc}
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public List<Map<String, Object>> getDicInfLstByDicTyp(Map<String, Object> map) throws Exception {
    	
    	return utilsDao.getDicInfLstByDicTyp(map);
    }
    
    
    /**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getStaffAddressBook(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
				
		// 获取运维人员公司的以及所关联的1、2、3级公司
		UserDto userDto = new UserDto();
		
		userDto.setId(Integer.valueOf(map.get("use_id").toString()));
		// 通过登录用户ID获取该用户所在的公司信息
		List<Map<String, Object>> optComInfLst = utilsDao.getComInfByUseId(userDto);
		
		String com_rol = "";
		
		String com_lev = "";
		
		String com_id = "";
		
		if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
			
			for(Map<String, Object> optComInfMap:optComInfLst){
				
				com_rol = optComInfMap.get("com_rol").toString();
				
				com_lev = optComInfMap.get("com_lev").toString();
				
				com_id = optComInfMap.get("id").toString();
			}
		}
		// 运维人员登录
		if(com_rol.equals("0") || com_rol.equals("2")){
			
			// 如果是运维人员登录进来，那么该人员可能是1级公司或2级公司或3级公司的员工
			// 如果该人员所在的公司是在一级公司的话，那么就需要将该人员的公司，与其公司有关的二级公司，以及与其它二给公司有关的三级公司的运维人员信息
			if(com_lev.equals("1")){
				
				if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
					
					for(Map<String, Object> optComInfMap:optComInfLst){
						
						// 再查询下级公司的人员信息、站信息
						// 查询二级公司信息
						CompanyDto companyDto = new CompanyDto();
						
						companyDto.setId(Integer.valueOf(com_id));
						// 取平台中所有指定公司下的运维公司的信息
						List<Map<String, Object>> twoLevComLstOpt = utilsDao.getOptFatComInfByComId(companyDto);
						
						if(twoLevComLstOpt != null && !twoLevComLstOpt.isEmpty()){
							
							for(Map<String, Object> twoLevComMapOpt : twoLevComLstOpt){
								
								// 再查询所有三级公司的人员信息、站信息
								companyDto.setId(Integer.valueOf(twoLevComMapOpt.get("id").toString()));
								
								// 再查询下级公司的人员信息、站信息
								// 查询三级公司信息
								List<Map<String, Object>> thrLevComLstOptIn = utilsDao.getOptFatComInfByComId(companyDto);
								
								twoLevComMapOpt.put("thrComLst", thrLevComLstOptIn);
							}
							
						}
						optComInfMap.put("towComLst", twoLevComLstOpt);
					}
				}
			}else if(com_lev.equals("2")){// 如果该人员所在的公司是在二级公司的话，那么就需要将该人员的公司，与其公司有关的三级公司的运维人员信息查询出来
				
				if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
					
					for(Map<String, Object> optComInfMap:optComInfLst){
						
						// 再查询下级公司的人员信息、站信息
						// 查询二级公司信息
						CompanyDto companyDto = new CompanyDto();
						
						companyDto.setId(Integer.valueOf(com_id));
						// 获取平台中所有指定公司下的运维公司的信息
						List<Map<String, Object>> thrLevComLstOpt = utilsDao.getOptFatComInfByComId(companyDto);
						
						optComInfMap.put("towComLst", thrLevComLstOpt);
					}
				}
			}
			
			retLst.addAll(optComInfLst);
			
		}else if(com_rol.equals("1")){
			
			// 查询出与查询人有关的三级客户公司
			List<Map<String, Object>> thrLevComLst = utilsDao.getThrLevComLstByOptComUseId(map);
			
			// 5.通过上述查询出的三级公司，查询出所有有关联的二级公司，将一级公司放到一个集合中
			List<Map<String, Object>> twoLevComLst = utilsDao.getTwoLevComLstByOptComUseId(map);
			map.put("com_rol", 0);
			// 6.通过上述查询出的二级公司，查询出所有有关联的一级公司，将一级公司放到一个集合中
			List<Map<String, Object>> fstLevComLst = utilsDao.getFstLevComLstByOptUseId(map);
			
			// 建立三级公司与二级公司间的关系,以及二级公司与人员之间的关系
			if(twoLevComLst != null && !twoLevComLst.isEmpty()){
				
				for(Map<String, Object> twoLevComMap:twoLevComLst){
					
					List<Map<String, Object>> retThrComLst = new ArrayList<Map<String,Object>>();
					
					if(thrLevComLst != null && !thrLevComLst.isEmpty()){
						
						for(Map<String, Object> thrLevComMap:thrLevComLst){
							// 判断三级公司是否与二级公司有从属关系
							if(thrLevComMap.get("com_fat_id").toString().equals(twoLevComMap.get("id").toString())){
								
								retThrComLst.add(thrLevComMap);
							}
						}
						
					}
					twoLevComMap.put("thrComLst", retThrComLst);
				}
			}
			
			// 建立二级公司与一级公司间的关系,以及一级公司与人员之间的关系
			if(fstLevComLst != null && !fstLevComLst.isEmpty()){
				
				for(Map<String, Object> fstLevComMap:fstLevComLst){
					
					List<Map<String, Object>> retThwComLst = new ArrayList<Map<String,Object>>();
					
					if(twoLevComLst != null && !twoLevComLst.isEmpty()){
						
						for(Map<String, Object> twoLevComMap:twoLevComLst){
							// 判断一级公司是否与二级公司有从属关系
							if(twoLevComMap.get("com_fat_id").toString().equals(fstLevComMap.get("id").toString())){
								
								retThwComLst.add(twoLevComMap);
							}
						}
						
					}
					fstLevComMap.put("towComLst", retThwComLst);
				}
			}
			retLst.addAll(fstLevComLst);
		}
		
		return retLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getCustomerAddressBook(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		// 获取运维人员公司的以及所关联的1、2、3级公司
		UserDto userDto = new UserDto();
		
		userDto.setId(Integer.valueOf(map.get("use_id").toString()));
		// 通过登录用户ID获取该用户所在的公司信息
		List<Map<String, Object>> optComInfLst = utilsDao.getComInfByUseId(userDto);
		
		String com_rol = "";
		
		String com_lev = "";
		
		String com_id = "";
		
		if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
			
			for(Map<String, Object> optComInfMap:optComInfLst){
				
				com_rol = optComInfMap.get("com_rol").toString();
				
				com_lev = optComInfMap.get("com_lev").toString();
				
				com_id = optComInfMap.get("id").toString();
			}
		}
		// 运维人员登录
		if(com_rol.equals("1")){
			
			// 如果是运维人员登录进来，那么该人员可能是1级公司或2级公司或3级公司的员工
			
			// 如果该人员所在的公司是在一级公司的话，那么就需要将该人员的公司，与其公司有关的二级公司，以及与其它二给公司有关的三级公司的运维人员信息
			if(com_lev.equals("1")){
				
				if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
					
					for(Map<String, Object> optComInfMap:optComInfLst){
						
						// 再查询下级公司的人员信息、站信息
						// 查询二级公司信息
						CompanyDto companyDto = new CompanyDto();
						
						companyDto.setId(Integer.valueOf(com_id));
						
						companyDto.setCom_rol(1);
						// 使用子公司ID获取其下所有子公司
						List<Map<String, Object>> twoLevComLstOpt = utilsDao.getFatComInfByComId(companyDto);
						
						if(twoLevComLstOpt != null && !twoLevComLstOpt.isEmpty()){
							
							for(Map<String, Object> twoLevComMapOpt : twoLevComLstOpt){
								
								// 再查询所有三级公司的人员信息、站信息
								
								companyDto.setId(Integer.valueOf(twoLevComMapOpt.get("id").toString()));
								
								// 再查询下级公司的人员信息、站信息
								// 查询三级公司信息
								List<Map<String, Object>> thrLevComLstOptIn = utilsDao.getFatComInfByComId(companyDto);
								
								twoLevComMapOpt.put("thrComLst", thrLevComLstOptIn);
							}
							
						}
						optComInfMap.put("towComLst", twoLevComLstOpt);
					}
				}
			}else if(com_lev.equals("2")){// 如果该人员所在的公司是在二级公司的话，那么就需要将该人员的公司，与其公司有关的三级公司的运维人员信息查询出来
				
				if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
					
					for(Map<String, Object> optComInfMap:optComInfLst){
						
						// 再查询下级公司的人员信息、站信息
						// 查询二级公司信息
						CompanyDto companyDto = new CompanyDto();
						
						companyDto.setId(Integer.valueOf(com_id));
						
						companyDto.setCom_rol(1);
						// 使用子公司ID获取其下所有子公司
						List<Map<String, Object>> thrLevComLstOpt = utilsDao.getFatComInfByComId(companyDto);
						
						optComInfMap.put("towComLst", thrLevComLstOpt);
					}
				}
			}
			
			retLst.addAll(optComInfLst);
			
		}else if(com_rol.equals("0") || com_rol.equals("2")){
			
			// 查询出与查询人有关的三级客户公司
			List<Map<String, Object>> thrLevComLst = utilsDao.getThrLevComLstByOwnerComUseId(map);
			
			// 5.通过上述查询出的三级公司，查询出所有有关联的二级公司，将一级公司放到一个集合中
			List<Map<String, Object>> twoLevComLst = utilsDao.getTwoLevComLstByOwnerComUseId(map);
			
			// 6.通过上述查询出的二级公司，查询出所有有关联的一级公司，将一级公司放到一个集合中
			List<Map<String, Object>> fstLevComLst = utilsDao.getFstLevComLstByOwnerUseId(map);
			
			// 建立三级公司与二级公司间的关系,以及二级公司与人员之间的关系
			if(twoLevComLst != null && !twoLevComLst.isEmpty()){
				
				for(Map<String, Object> twoLevComMap:twoLevComLst){
					
					List<Map<String, Object>> retThrComLst = new ArrayList<Map<String,Object>>();
					
					if(thrLevComLst != null && !thrLevComLst.isEmpty()){
						
						for(Map<String, Object> thrLevComMap:thrLevComLst){
							// 判断三级公司与2级公司的从属关系
							if(thrLevComMap.get("com_fat_id").toString().equals(twoLevComMap.get("id").toString())){
								
								retThrComLst.add(thrLevComMap);
							}
						}
						
					}
					twoLevComMap.put("towComLst", retThrComLst);
				}
			}
			
			// 建立二级公司与一级公司间的关系,以及一级公司与人员之间的关系
			if(fstLevComLst != null && !fstLevComLst.isEmpty()){
				
				for(Map<String, Object> fstLevComMap:fstLevComLst){
					
					if(twoLevComLst != null && !twoLevComLst.isEmpty()){
						
						for(Map<String, Object> twoLevComMap:twoLevComLst){
							// 判断二级公司与1级公司的从属关系
							if(twoLevComMap.get("com_fat_id").toString().equals(fstLevComMap.get("id").toString())){
								
								retLst.add(twoLevComMap);
							}
						}
					}
				}
			}
		}
		
		return retLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUseByStaffAddressBook(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		// 获取运维人员公司的以及所关联的1、2、3级公司
		UserDto userDto = new UserDto();
		
		userDto.setId(Integer.valueOf(map.get("use_id").toString()));
		// 通过登录用户ID获取该用户所在的公司信息
		List<Map<String, Object>> optComInfLst = utilsDao.getComInfByUseId(userDto);
		
		String com_rol = "";
		
		if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
			
			for(Map<String, Object> optComInfMap:optComInfLst){
				
				com_rol = optComInfMap.get("com_rol").toString();
				
			}
		}
		// 运维人员登录
		if(com_rol.equals("0") || com_rol.equals("2")){
			
			map.put("id", map.get("com_id"));
			
			retLst = utilsDao.getUseInfLstByComId(map);
			
		}else if(com_rol.equals("1")){// 客户登录
			// 与登录人员(客户)有关的运维人员信息
			retLst = utilsDao.getUseLstBySelectUseId(map);
		}
		
		return retLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getUseByStaffAddressBookCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		// 获取运维人员公司的以及所关联的1、2、3级公司
		UserDto userDto = new UserDto();
		
		userDto.setId(Integer.valueOf(map.get("use_id").toString()));
		// 通过登录用户ID获取该用户所在的公司信息
		List<Map<String, Object>> optComInfLst = utilsDao.getComInfByUseId(userDto);
		
		String com_rol = "";
		
		if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
			
			for(Map<String, Object> optComInfMap:optComInfLst){
				
				com_rol = optComInfMap.get("com_rol").toString();
				
			}
		}
		// 运维人员登录
		if(com_rol.equals("0") || com_rol.equals("2")){
			
			map.put("id", map.get("com_id"));
			
			 retLst = utilsDao.getUseInfLstByComIdCou(map);
			
			if (retLst != null && retLst.size() > 0) {
				
				for (Map<String, Object> retMap : retLst) {
					
					return retMap;
				}
			}
			
			
		}else if(com_rol.equals("1")){// 客户登录
			// 与登录人员(客户)有关的运维人员信息
			retLst = utilsDao.getUseLstBySelectUseIdCou(map);
			
			if (retLst != null && retLst.size() > 0) {
				
				for (Map<String, Object> retMap : retLst) {
					
					return retMap;
				}
			}
		}
		return null;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUseByCustomerAddressBook(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		// 获取运维人员公司的以及所关联的1、2、3级公司
		UserDto userDto = new UserDto();
		
		userDto.setId(Integer.valueOf(map.get("use_id").toString()));
		// 通过登录用户ID获取该用户所在的公司信息
		List<Map<String, Object>> optComInfLst = utilsDao.getComInfByUseId(userDto);
		
		String com_rol = "";
		
		if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
			
			for(Map<String, Object> optComInfMap:optComInfLst){
				
				com_rol = optComInfMap.get("com_rol").toString();
				
			}
		}
		// 运维人员登录
		if(com_rol.equals("1")){
			map.put("id", map.get("com_id"));
			retLst = utilsDao.getUseInfLstByComId(map);
			
		}else if(com_rol.equals("0") || com_rol.equals("2")){
			// 与登录人员(客户)有关的运维人员信息
			retLst = utilsDao.getUseLstBySelectUseIdOpt(map);
			
		}
		
		return retLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getUseByCustomerAddressBookCou(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		// 获取运维人员公司的以及所关联的1、2、3级公司
		UserDto userDto = new UserDto();
		
		userDto.setId(Integer.valueOf(map.get("use_id").toString()));
		// 通过登录用户ID获取该用户所在的公司信息
		List<Map<String, Object>> optComInfLst = utilsDao.getComInfByUseId(userDto);
		
		String com_rol = "";
		
		if(optComInfLst != null && !optComInfLst.isEmpty() && optComInfLst.get(0) != null){
			
			for(Map<String, Object> optComInfMap:optComInfLst){
				
				com_rol = optComInfMap.get("com_rol").toString();
				
			}
		}
		// 运维人员登录
		if(com_rol.equals("1")){
			
			map.put("id", map.get("com_id"));
			
			 retLst = utilsDao.getUseInfLstByComIdCou(map);
			
			if (retLst != null && retLst.size() > 0) {
				
				for (Map<String, Object> retMap : retLst) {
					
					return retMap;
				}
			}
			
			
			
		}else if(com_rol.equals("0") || com_rol.equals("2")){
			
			// 与登录人员(客户)有关的运维人员信息
			retLst = utilsDao.getUseLstBySelectUseIdOptCou(map);

			if (retLst != null && retLst.size() > 0) {

				for (Map<String, Object> retMap : retLst) {

					return retMap;
				}
			}
			
		}
		
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOrganizationHierarchyByUse(Map<String, Object> map) throws Exception {
		
		// 1.从前台获取use_id，以及用户类型信息（用户类型，分为：1.运维人员，2.客户公司人员）
		String use_typ = map.get("use_typ").toString();
		// 运维人员/站查看状态（1：可查看（如果为运维公司时，可查看子公司人员和站信息，如果为业主公司，可查看与该公司站关联的所有运维人员），
		// 2：不可查看（如果为运维公司，只能查看自己公司的人与站以及与自己有关的站的信息，如果为业主公司时，只能查看与自己有关的所有站的信息，
		// 不能查看运维人员信息）），用户新建时，默认可见
		String slt_opt_sta = map.get("slt_opt_sta").toString();
		
		// 2.所有系统内的用户都与站进行关联，所有的一、二、三级公司筛选，都使用站进行反推
		// 3.通过表sys_dat_use_pws中的关联关系，查询出所有与此用户有关的站，放入站集合中
		List<Map<String, Object>> pwsInfLst = utilsDao.getPwsInfLstByPwsIdOpt(map);// 与此用户有关的所有站信息
		
		// 4.通过上述查询出的站信息，查询出所有有关联的三级公司，将三级公司放到一个集合中
		List<Map<String, Object>> thrLevComLst = utilsDao.getThrLevComLstByOptUseId(map);
		
		List<Map<String, Object>> thrLevComLstReturn = new ArrayList<Map<String,Object>>();
		// 本集合是为了处理查询出来的三级公司有重复的情况而出现的，即三级公司信息集合去重
		Set<Map<String,Object>> thrLevComSet = new HashSet<Map<String,Object>>();
		
		// 5.通过上述查询出的三级公司，查询出所有有关联的二级公司，将一级公司放到一个集合中
		List<Map<String, Object>> twoLevComLstReturn = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> twoLevComLst = utilsDao.getTwoLevComLstByOptUseId(map);
		// 本集合是为了处理查询出来的二级公司有重复的情况而出现的，即二级公司信息集合去重
		Set<Map<String,Object>> twoLevComSet = new HashSet<Map<String,Object>>();
		
		List<Map<String, Object>> fstLevComLstReturn = new ArrayList<Map<String,Object>>();
		// 6.通过上述查询出的二级公司，查询出所有有关联的一级公司，将一级公司放到一个集合中
		List<Map<String, Object>> fstLevComLst = utilsDao.getFstLevComLstByUseId(map);
		// 本集合是为了处理查询出来的一级公司有重复的情况而出现的，即一级公司信息集合去重
		Set<Map<String,Object>> fstLevComSet = new HashSet<Map<String,Object>>();
		
		List<Map<String, Object>> optLst = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> optLstOther = new ArrayList<Map<String,Object>>();
		
		//判断use_typ状态是1还是2
		if(use_typ.equals("1")){
			
			// 获取运维人员公司的以及所关联的1、2、3级公司
			UserDto userDto = new UserDto();
			
			userDto.setId(Integer.valueOf(map.get("use_id").toString()));
			// 通过登录用户ID获取该用户所在的公司信息
			List<Map<String, Object>> optComInfLst = utilsDao.getComInfByUseId(userDto);
			
			if(optComInfLst != null && !optComInfLst.isEmpty()){
				
				for(Map<String, Object> optComInfMap : optComInfLst){
					
					String com_lev = optComInfMap.get("com_lev").toString();
					// 判断该人员所在公司是1级公司，还是2级公司，还是3级公司
					if(com_lev.equals("1")){
						
						List<Map<String, Object>> fstLevComLstOpt = optComInfLst;
						
						CompanyDto companyDto = new CompanyDto();
						
						companyDto.setId(Integer.valueOf(optComInfMap.get("id").toString()));
						
						// 再查询下级公司的人员信息、站信息
						// 如果是1级公司就查询本公司的人员信息、站信息
						List<Map<String, Object>> twoLevComLstOpt = utilsDao.getFatComInfByComId(companyDto);
						
						List<Map<String, Object>> thrLevComLstOpt = new ArrayList<Map<String,Object>>();
						
						if(twoLevComLstOpt != null && !twoLevComLstOpt.isEmpty()){
							
							for(Map<String, Object> twoLevComMapOpt : twoLevComLstOpt){
								
								// 再查询所有三级公司的人员信息、站信息
								
								companyDto.setId(Integer.valueOf(twoLevComMapOpt.get("id").toString()));
								
								// 再查询下级公司的人员信息、站信息
								// 如果是1级公司就查询本公司的人员信息、站信息
								List<Map<String, Object>> thrLevComLstOptIn = utilsDao.getFatComInfByComId(companyDto);
								
								thrLevComLstOpt.addAll(thrLevComLstOptIn);
								// 判断slt_opt_sta是否可见
								if(slt_opt_sta.equals("1")){
									
									// 如果为其它人员可见的话，就会看到所有与此人有关的站以及与这些站有关的运维人员
									if(thrLevComLstOptIn!= null && !thrLevComLstOptIn.isEmpty()){
										
										for(Map<String, Object> thrLevComMapOptIn:thrLevComLstOptIn){
											
											List<Map<String, Object>> optThrLst = utilsDao.getOptUseInfLstByComId(thrLevComMapOptIn);
											
											optLst.addAll(optThrLst);
										}
									}
									
									List<Map<String, Object>> optTowLst = utilsDao.getOptUseInfLstByComId(twoLevComMapOpt);
									
									optLst.addAll(optTowLst);
								}
							}
						}
						// 判断slt_opt_sta是否可见
						if(slt_opt_sta.equals("1")){
							
							List<Map<String, Object>> optFstLst = utilsDao.getOptUseInfInComLstByOptId(map);
							
							optLst.addAll(optFstLst);
						}
						
						thrLevComLst.addAll(thrLevComLstOpt);
						
						twoLevComLst.addAll(twoLevComLstOpt);
						
						fstLevComLst.addAll(fstLevComLstOpt);
						
					}else if(com_lev.equals("2")){
						// 如果是2级公司就查询本公司的人员信息、站信息
						List<Map<String, Object>> twoLevComLstOpt = optComInfLst;
						
						CompanyDto companyDto = new CompanyDto();
						
						companyDto.setId(Integer.valueOf(optComInfMap.get("id").toString()));
						
						// 再查询所有三级公司的人员信息、站信息
						List<Map<String, Object>> thrLevComLstOpt = utilsDao.getFatComInfByComId(companyDto);
						
						// 再查询上级公司的信息(1级公司)
						// 如果是1级公司就查询本公司的人员信息、站信息
						List<Map<String, Object>> fstLevComLstOpt = utilsDao.getSuperiorComInfLstByTwoOrThrComUse(map);
						
						// 判断slt_opt_sta是否可见
						if(slt_opt_sta.equals("1")){
							
							// 如果为其它人员可见的话，就会看到所有与此人有关的站以及与这些站有关的运维人员
							if(thrLevComLstOpt!= null && !thrLevComLstOpt.isEmpty()){
								
								for(Map<String, Object> thrLevComMapOptIn:thrLevComLstOpt){
									
									List<Map<String, Object>> optThrLst = utilsDao.getOptUseInfLstByComId(thrLevComMapOptIn);
									
									optLst.addAll(optThrLst);
								}
							}
							List<Map<String, Object>> optTwoLst = utilsDao.getOptUseInfInComLstByOptId(map);
							
							optLst.addAll(optTwoLst);
						}
						
						thrLevComLst.addAll(thrLevComLstOpt);
						
						twoLevComLst.addAll(twoLevComLstOpt);
						
						fstLevComLst.addAll(fstLevComLstOpt);
						
					}else if(com_lev.equals("3")){
						// 如果是三级公司就查询本公司的人员信息、站信息
						// 如果是2级公司就查询本公司的人员信息、站信息
						List<Map<String, Object>> thrLevComLstOpt = optComInfLst;
						
						CompanyDto companyDto = new CompanyDto();
						
						companyDto.setId(Integer.valueOf(optComInfMap.get("id").toString()));
						// 再查询上级公司的信息
						// 再查询所有三级公司的人员信息、站信息
						List<Map<String, Object>> twoLevComLstOpt = utilsDao.getSuperiorComInfLstByTwoOrThrComUse(map);
						// 再查询上上级公司的信息
						// 再查询上级公司的信息(1级公司)
						// 如果是1级公司就查询本公司的人员信息、站信息
						List<Map<String, Object>> fstLevComLstOpt = utilsDao.getSuperiorSuperiorComInfLstByThrComUse(map);
						
						// 判断slt_opt_sta是否可见
						if(slt_opt_sta.equals("1")){
							
							// 如果为其它人员可见的话，就会看到所有与此人有关的站以及与这些站有关的运维人员
							
							List<Map<String, Object>> optThrLst = utilsDao.getOptUseInfInComLstByOptId(map);
							
							optLst.addAll(optThrLst);
						}
						
						thrLevComLst.addAll(thrLevComLstOpt);
						
						twoLevComLst.addAll(twoLevComLstOpt);
						
						fstLevComLst.addAll(fstLevComLstOpt);
					}
				}
			}
		}else if(use_typ.equals("2")){
			
			// 判断slt_opt_sta是否可见
			if(slt_opt_sta.equals("1")){
				
				// 如果为其它人员可见的话，就会看到所有与此人有关的站以及与这些站有关的运维人员
				// 其它人员侧获取到运维人员信息
				optLstOther = utilsDao.getOptUseByPwsInfLstByPwsIdOpt(map);
			}
		}
		// 判断运维人员是否为空
		if(optLst != null && !optLst.isEmpty()){
			
			for(Map<String, Object> optMap : optLst){
				// 获取用户在地图中最新的定位信息
				List<Map<String, Object>> useLonLatLst = utilsDao.getUseLonLatNewByUseId(optMap);
				
				optMap.put("useLonLat", useLonLatLst);
				
			}
		}
		// 判断其它人员集合是否为空
		if(optLstOther != null && !optLstOther.isEmpty()){
			
			for(Map<String, Object> optMapOther : optLstOther){
				// 获取用户在地图中最新的定位信息
				List<Map<String, Object>> useLonLatLst = utilsDao.getUseLonLatNewByUseId(optMapOther);
				
				optMapOther.put("useLonLat", useLonLatLst);
				
			}
		}
		// 一级公司信息去重
		fstLevComSet.addAll(fstLevComLst);
		
		fstLevComLstReturn.addAll(fstLevComSet);
		// 二级公司信息去重
		twoLevComSet.addAll(twoLevComLst);
		
		twoLevComLstReturn.addAll(twoLevComSet);
		// 三级公司信息去重
		thrLevComSet.addAll(thrLevComLst);
		
		thrLevComLstReturn.addAll(thrLevComSet);
		// 三级公司信息非空判断
		if(thrLevComLstReturn != null && !thrLevComLstReturn.isEmpty()){
			// 三级公司信息遍历
			for(Map<String, Object> thrLevComMapReturn:thrLevComLstReturn){
				
				List<Map<String,Object>> returnPwsInfLst = new ArrayList<Map<String,Object>>();
				
				List<Map<String,Object>> returnOptUseLst = new ArrayList<Map<String,Object>>();
				
				if(pwsInfLst != null && !pwsInfLst.isEmpty()){
					
					for(Map<String, Object> pwsInfMap:pwsInfLst){
						// 建立电站与三级公司之间的从属关系
						if(pwsInfMap.get("com_id").toString().equals(thrLevComMapReturn.get("id").toString())){
							
							
							returnPwsInfLst.add(pwsInfMap);
						}
						// 获取平台中地图页面左侧电站图片信息
						List<Map<String, Object>> pwsPicLst = utilsDao.getIntMonLeftSidePwsPic(pwsInfMap);
						
						pwsInfMap.put("pwsPicLst", pwsPicLst);
					}
				}
				
				thrLevComMapReturn.put("pwsInfLst", returnPwsInfLst);
				// 如果为运维人员时
				if(use_typ.equals("1")){
					
					for(Map<String, Object> optMap:optLst){
						// 建立人员与三级公司的关系
						if(optMap.get("con_com_id").toString().equals(thrLevComMapReturn.get("id").toString())){
							
							returnOptUseLst.add(optMap);
						}
					}
				}else if(use_typ.equals("2")){// 如果为其它人员时
					
					for(Map<String, Object> optMapOther:optLstOther){
						// 建立人员与三级公司的关系
						if(optMapOther.get("con_com_id").toString().equals(thrLevComMapReturn.get("id").toString())){
							
							returnOptUseLst.add(optMapOther);
						}
					}
				}
				thrLevComMapReturn.put("optLst", returnOptUseLst);
			}
		}
		
		// 二级公司集合非空判断
		if(twoLevComLstReturn != null && !twoLevComLstReturn.isEmpty()){
			
			for(Map<String, Object> twoLevComMapReturn:twoLevComLstReturn){
				
				List<Map<String,Object>> returnComInfLst = new ArrayList<Map<String,Object>>();
				
				List<Map<String,Object>> returnOptUseLst = new ArrayList<Map<String,Object>>();
				
				if(thrLevComLstReturn != null && !thrLevComLstReturn.isEmpty()){
					
					for(Map<String, Object> thrLevComMapReturn:thrLevComLstReturn){
						// 建立二级公司与三级公司的从属关系
						if(thrLevComMapReturn.get("com_fat_id").toString().equals(twoLevComMapReturn.get("id").toString())){
							
							returnComInfLst.add(thrLevComMapReturn);
						}
					}
				}
				
				twoLevComMapReturn.put("thrComLst", returnComInfLst);
				// 如果为运维人员时
				if(use_typ.equals("1")){
					
					for(Map<String, Object> optMap:optLst){
						// 建立人员与二级公司的关系
						if(optMap.get("con_com_id").toString().equals(twoLevComMapReturn.get("id").toString())){
							
							returnOptUseLst.add(optMap);
						}
					}
				}else if(use_typ.equals("2")){// 如果为其它人员时
					
					for(Map<String, Object> optMapOther:optLstOther){
						// 建立人员与二级公司的关系
						if(optMapOther.get("con_com_id").toString().equals(twoLevComMapReturn.get("id").toString())){
							
							returnOptUseLst.add(optMapOther);
						}
					}
				}
				twoLevComMapReturn.put("optLst", returnOptUseLst);
			}
		}
		// 一级公司返回集合非空判断
		if(fstLevComLstReturn != null && !fstLevComLstReturn.isEmpty()){
			
			for(Map<String, Object> fstLevComMapReturn:fstLevComLstReturn){
				
				List<Map<String,Object>> returnComInfLst = new ArrayList<Map<String,Object>>();
				
				List<Map<String,Object>> returnOptUseLst = new ArrayList<Map<String,Object>>();
				
				if(twoLevComLstReturn != null && !twoLevComLstReturn.isEmpty()){
					
					for(Map<String, Object> twoLevComMapReturn:twoLevComLstReturn){
						
						// 建立一级公司与二级公司间的从属关系
						if(twoLevComMapReturn.get("com_fat_id").toString().equals(fstLevComMapReturn.get("id").toString())){
							
							returnComInfLst.add(twoLevComMapReturn);
						}
					}
				}
				
				fstLevComMapReturn.put("twoComLst", returnComInfLst);
				// 如果为运维人员时
				if(use_typ.equals("1")){
					
					for(Map<String, Object> optMap:optLst){
						// 建立人员与一级公司的关系
						if(optMap.get("con_com_id").toString().equals(fstLevComMapReturn.get("id").toString())){
							
							returnOptUseLst.add(optMap);
						}
					}
				}else if(use_typ.equals("2")){// 如果为其它人员时
					
					for(Map<String, Object> optMapOther:optLstOther){
						// 建立人员与一级公司的关系
						if(optMapOther.get("con_com_id").toString().equals(fstLevComMapReturn.get("id").toString())){
							
							returnOptUseLst.add(optMapOther);
						}
					}
				}
				fstLevComMapReturn.put("optLst", returnOptUseLst);
			}
		}
		
		// 7.从一级公司开始嵌套遍历公司以及站，并找出其中的从属关系
		// 8.判断是运维人员还是其它人员，如果是运维人员，再查询出其所属公司以及有关联的1、2、3级公司信息，判断slt_opt_sta状态，如果为1，
		// 则可查看本公司以及其下级所有公司的运维人员信息，如果为2，则只能查看本公司运维人员信息
		
		// 9.判断是运维人员还是其它人员，如果是其它人员，判断slt_opt_sta状态，如果为1，则可查看与其所关联的所有站的运维人员，如果为2，则
		// 只能查看站点信息，不能查看运维人员信息(不查询)
		
		return fstLevComLstReturn;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getIntMonLeftSide(Map<String, Object> map) throws Exception {
		
		// 3.通过表sys_dat_use_pws中的关联关系，查询出所有与此用户有关的站，放入站集合中
		List<Map<String, Object>> pwsInfLst = utilsDao.getPwsInfLstByPwsIdOpt(map);// 与此用户有关的所有站信息
		
		List<Map<String,Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> returnMap = new HashMap<String, Object>();
		// 电站数量
		Integer pwsCou = 0;
		// 投运电站数量
		Integer pwsOptCou = 0;
		// 在建电站数量
		Integer pwsConCou = 0;
		// 计划电站数量
		Integer pwsPlaCou = 0;
		
		
		// 电站容量
		Double pwsCap = 0.0;
		// 投运电站容量
		Double pwsOptCap = 0.0;
		// 在建电站容量
		Double pwsConCap = 0.0;
		// 计划电站容量
		Double pwsPlaCap = 0.0;
		
		// 获取安全运行天数接口
		List<Map<String, Object>> safeRunDaysLst = utilsDao.getSafeRunDays();
		// 安全运行天数
		Double safeRunDays = 0.0;
		
		// 累计收益
		Double tolRvn = 0.0;
		
		// 光伏功率
		Double pvPower = 0.0;
		// 储能功率
		Double pcPower = 0.0;
		// 充电功率
		Double chpPower = 0.0;
		
		// 等效植树
		Double equPlaTre = 0.0;
		// 二氧化碳减排
		Double carDioEmiRed = 0.0;
		// 节约标煤
		Double staCoal = 0.0;
		 
		if(safeRunDaysLst != null && !safeRunDaysLst.isEmpty()){
				
			for(Map<String, Object> safeRunDaysMap:safeRunDaysLst){
				
				safeRunDays = Double.valueOf(safeRunDaysMap.get("safe_run_days").toString());
			}
		}
		
		if(pwsInfLst != null && !pwsInfLst.isEmpty()){
			
			for(Map<String, Object> pwsInfMap:pwsInfLst){
				
				// 计算站状态数据
				if(pwsInfMap.get("cur_sta").toString().equals("1")){// 如果站为计划状态   
					
					pwsPlaCou = pwsPlaCou+1;
					
					if(pwsInfMap.get("rat_pow") != null && !pwsInfMap.get("rat_pow").toString().isEmpty()){
						
						pwsPlaCap = pwsPlaCap + Double.valueOf(pwsInfMap.get("rat_pow").toString());
						
					}
				}else if(pwsInfMap.get("cur_sta").toString().equals("2")){// 如果站为在建状态
					
					pwsConCou = pwsConCou+1;
					
					if(pwsInfMap.get("rat_pow") != null && !pwsInfMap.get("rat_pow").toString().isEmpty()){
						
						pwsConCap = pwsConCap + Double.valueOf(pwsInfMap.get("rat_pow").toString());
						
					}
				}else if(pwsInfMap.get("cur_sta").toString().equals("3")){// 如果站为投运状态
					
					pwsOptCou = pwsOptCou+1;
					
					if(pwsInfMap.get("rat_pow") != null && !pwsInfMap.get("rat_pow").toString().isEmpty()){
						
						pwsOptCap = pwsOptCap + Double.valueOf(pwsInfMap.get("rat_pow").toString());
						
					}
				}
				
				// 计算所有从站信息中获取到的消息数据
				List<Map<String, Object>> intMonLeftSideLst = utilsDao.getIntMonLeftSide(pwsInfMap);
				
				if(intMonLeftSideLst != null && !intMonLeftSideLst.isEmpty()){
					
					for(Map<String, Object> intMonLeftSideMap:intMonLeftSideLst){
						
						
						// 获取光伏总功率
						if(intMonLeftSideMap.get("pv_power") != null && !intMonLeftSideMap.get("pv_power").toString().isEmpty()){
							
							pvPower = pvPower + Double.valueOf(intMonLeftSideMap.get("pv_power").toString());
							
						}
						// 获取储能总功率
						if(intMonLeftSideMap.get("pc_power") != null && !intMonLeftSideMap.get("pc_power").toString().isEmpty()){
							
							pcPower = pcPower + Double.valueOf(intMonLeftSideMap.get("pc_power").toString());
							
						}
						// 获取充电总功率
						if(intMonLeftSideMap.get("chp_power") != null && !intMonLeftSideMap.get("chp_power").toString().isEmpty()){
							
							chpPower = chpPower + Double.valueOf(intMonLeftSideMap.get("chp_power").toString());
							
						}
						// 获取站总收益
						if(intMonLeftSideMap.get("tol__rvn") != null && !intMonLeftSideMap.get("tol__rvn").toString().isEmpty()){
							
							 tolRvn = tolRvn + Double.valueOf(intMonLeftSideMap.get("tol__rvn").toString());
							
						}
						// 获取等效植树数
						if(intMonLeftSideMap.get("equ_pla_tre") != null && !intMonLeftSideMap.get("equ_pla_tre").toString().isEmpty()){
							
							equPlaTre = equPlaTre + Double.valueOf(intMonLeftSideMap.get("equ_pla_tre").toString());
							
						}
						// 获取二氧化碳量
						if(intMonLeftSideMap.get("car_dio_emi_red") != null && !intMonLeftSideMap.get("car_dio_emi_red").toString().isEmpty()){
							
							carDioEmiRed = carDioEmiRed + Double.valueOf(intMonLeftSideMap.get("car_dio_emi_red").toString());
							
						}
						// 获取节约标煤量
						if(intMonLeftSideMap.get("sta_coal") != null && !intMonLeftSideMap.get("sta_coal").toString().isEmpty()){
							
							staCoal = staCoal + Double.valueOf(intMonLeftSideMap.get("sta_coal").toString());
							
						}
					}
				}
			}
		}
		
		// 总电站数量
		pwsCou = pwsPlaCou + pwsConCou + pwsOptCou;
		// 总电站容量
		pwsCap = pwsPlaCap + pwsConCap + pwsOptCap;
		
		// 电站数量
		returnMap.put("pwsCou", pwsCou);
		// 投运电站数量
		returnMap.put("pwsOptCou", pwsOptCou);
		// 在建电站数量
		returnMap.put("pwsConCou", pwsConCou);
		// 计划电站数量
		returnMap.put("pwsPlaCou", pwsPlaCou);
		
		
		
		// 电站容量
		returnMap.put("pwsCap", pwsCap);
		// 投运电站容量
		returnMap.put("pwsOptCap", pwsOptCap);
		// 在建电站容量
		returnMap.put("pwsConCap", pwsConCap);
		// 计划电站容量
		returnMap.put("pwsPlaCap", pwsPlaCap);
		
		// 安全运行天数
		returnMap.put("safeRunDays", safeRunDays);
		
		// 累计收益
		returnMap.put("tolRvn", tolRvn);
		
		// 光伏功率
		returnMap.put("pvPower", pvPower);
		// 储能功率
		returnMap.put("pcPower", pcPower);
		// 充电功率
		returnMap.put("chpPower", chpPower);
		
		// 等效植树
		returnMap.put("equPlaTre", equPlaTre);
		// 二氧化碳减排
		returnMap.put("carDioEmiRed", carDioEmiRed);
		// 节约标煤
		returnMap.put("staCoal", staCoal);
		
		returnLst.add(returnMap);
				
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getPwsStaInfo(Map<String, Object> map) throws Exception {
		
		// 1.通过表sys_dat_use_pws中的关联关系，查询出所有与此用户有关的站，放入站集合中
		List<Map<String, Object>> pwsInfLst = utilsDao.getPwsInfLstByPwsIdOpt(map);// 与此用户有关的所有站信息
		
		// 2.省份最终返回列表
		List<Map<String, Object>> proLstReturn = new ArrayList<Map<String,Object>>();
		// 本集合是为了处理查询出来的省份信息有重复的情况而出现的，即省份信息集合去重
		Set<Map<String,Object>> proSet = new HashSet<Map<String,Object>>();
		
		// 3.城市最终返回列表
		List<Map<String, Object>> citLstReturn = new ArrayList<Map<String,Object>>();
		// 本集合是为了处理查询出来的城市信息有重复的情况而出现的，即城市信息集合去重
		Set<Map<String,Object>> citSet = new HashSet<Map<String,Object>>();
		
		// 4.地区最终返回列表
		List<Map<String, Object>> areLstReturn = new ArrayList<Map<String,Object>>();
		// 本集合是为了处理查询出来的地区信息有重复的情况而出现的，即地区信息集合去重
		Set<Map<String,Object>> areSet = new HashSet<Map<String,Object>>();
		
		if(pwsInfLst != null && !pwsInfLst.isEmpty()){
			
			for(Map<String, Object> pwsInfMap : pwsInfLst){
				
				Map<String, Object> proMap = new HashMap<String, Object>();
				
				proMap.put("pro_id", pwsInfMap.get("pro_id"));
				
				proMap.put("pro_nam", pwsInfMap.get("pro_nam"));
				
				Map<String, Object> citMap = new HashMap<String, Object>();
				
				citMap.put("pro_id", pwsInfMap.get("pro_id"));
				
				citMap.put("cit_id", pwsInfMap.get("cit_id"));
				
				citMap.put("cit_nam", pwsInfMap.get("cit_nam"));
				
				Map<String, Object> areMap = new HashMap<String, Object>();
				
				areMap.put("pro_id", pwsInfMap.get("pro_id"));
				
				areMap.put("cit_id", pwsInfMap.get("cit_id"));
				
				areMap.put("are_id", pwsInfMap.get("are_id"));
				
				areMap.put("are_nam", pwsInfMap.get("are_nam"));
				
				// 去重
				proSet.add(proMap);
				
				citSet.add(citMap);
				
				areSet.add(areMap);
			}
			
			proLstReturn.addAll(proSet);
			
			citLstReturn.addAll(citSet);
			
			areLstReturn.addAll(areSet);
			// 建立电站与地区之间的从属关系
			if(areLstReturn != null && !areLstReturn.isEmpty()){
				
				for(Map<String, Object> areMapReturn : areLstReturn){
					// 建立一个临时的list集合
					List<Map<String,Object>> temLst = new ArrayList<Map<String,Object>>();
					
					for(Map<String, Object> pwsInfMap : pwsInfLst){
						// 判断地区与电站之间是否有从属关系
						if(areMapReturn.get("are_id").equals(pwsInfMap.get("are_id"))){
							
							temLst.add(pwsInfMap);
						}
					}
					areMapReturn.put("pwsInfLst", temLst);
				}
			}
			// 建立地区与城市之间的从属关系
			if(citLstReturn != null && !citLstReturn.isEmpty()){
				
				for(Map<String, Object> citMapReturn : citLstReturn){
					// 建立一个临时的list集合
					List<Map<String,Object>> temLst = new ArrayList<Map<String,Object>>();
					
					if(areLstReturn != null && !areLstReturn.isEmpty()){
						
						for(Map<String, Object> areMapReturn : areLstReturn){
							// 判断城市与地区之间是否有从属关系
							if(citMapReturn.get("cit_id").equals(areMapReturn.get("cit_id"))){
								
								temLst.add(areMapReturn);
							}
						}
					}
					
					citMapReturn.put("areLst", temLst);
				}
			}
			// 建立城市与省份之间的从属关系
			if(proLstReturn != null && !proLstReturn.isEmpty()){
				
				for(Map<String, Object> proMapReturn : proLstReturn){
					// 建立一个临时的list集合
					List<Map<String,Object>> temLst = new ArrayList<Map<String,Object>>();
					
					if(citLstReturn != null && !citLstReturn.isEmpty()){
						
						for(Map<String, Object> citMapReturn : citLstReturn){
							// 判断省份与城市之间是否有从属关系
							if(proMapReturn.get("pro_id").equals(citMapReturn.get("pro_id"))){
								
								temLst.add(citMapReturn);
							}
						}
					}
					
					proMapReturn.put("citLst", temLst);
				}
			}
		}
		
		return proLstReturn;
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getHomPagPwsCou(Map<String, Object> map) throws Exception {
		
		// 3.通过表sys_dat_use_pws中的关联关系，查询出所有与此用户有关的站，放入站集合中
		List<Map<String, Object>> pwsInfLst = utilsDao.getPwsInfLstByPwsIdOpt(map);// 与此用户有关的所有站信息
		
		List<Map<String,Object>> returnLst = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> returnMap = new HashMap<String, Object>();
		// 电站数量
		Integer pwsCou = 0;
		// 投运电站数量
		Integer pwsOptCou = 0;
		// 在建电站数量
		Integer pwsConCou = 0;
		// 计划电站数量
		Integer pwsPlaCou = 0;
		
		if(pwsInfLst != null && !pwsInfLst.isEmpty()){
			
			for(Map<String, Object> pwsInfMap:pwsInfLst){
				
				// 计算站状态数据
				if(pwsInfMap.get("cur_sta").toString().equals("1")){// 如果站为计划状态   
					
					pwsPlaCou = pwsPlaCou+1;
					
				}else if(pwsInfMap.get("cur_sta").toString().equals("2")){// 如果站为在建状态
					
					pwsConCou = pwsConCou+1;
					
				}else if(pwsInfMap.get("cur_sta").toString().equals("3")){// 如果站为投运状态
					
					pwsOptCou = pwsOptCou+1;
					
				}
			}
		}
		
		// 总电站数量
		pwsCou = pwsPlaCou + pwsConCou + pwsOptCou;
		
		// 电站数量
		returnMap.put("pwsCou", pwsCou);
		// 投运电站数量
		returnMap.put("pwsOptCou", pwsOptCou);
		// 在建电站数量
		returnMap.put("pwsConCou", pwsConCou);
		// 计划电站数量
		returnMap.put("pwsPlaCou", pwsPlaCou);
		
		returnLst.add(returnMap);
				
		return returnLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasAppByAppTypIde(Map<String, Object> map) throws Exception {
		
		return utilsDao.getBasAppByAppTypIde(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasPwsTypLst() throws Exception {
		
		return utilsDao.getBasPwsTypLst();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserName() throws Exception {
		
		return utilsDao.getUserName();
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSysBasAppTypeByPwsId(Map<String, Object> map) throws Exception {
		
		return utilsDao.getSysBasAppTypeByPwsId(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getEquNumBySysBasAppTypeId(Map<String, Object> map) throws Exception {
		
		return utilsDao.getEquNumBySysBasAppTypeId(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getOptLogLst(Map<String, Object> map) throws Exception {
		
		return utilsDao.getOptLogLst(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getOptLogLstCou(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> retLst = utilsDao.getOptLogLstCou(map);

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
	public List<Map<String, Object>> getComInfByComNam(Map<String, Object> map) throws Exception {
		
		return utilsDao.getComInfByComNam(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserNameByComId(Map<String, Object> map) throws Exception {
		
		return utilsDao.getUserNameByComId(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getSelectedButtonLstByModuleId(Map<String, Object> map) throws Exception {
		// 使用菜单ID获取按钮列表
		List<Map<String, Object>> bttLst = utilsDao.getButtonLstByModuleId(map);
		// 使用菜单ID与用户ID获取按钮列表
		List<Map<String, Object>> sedBttLst = utilsDao.getSelectedButtonLstByModuleId(map);
		// 判断按钮集合是否为空
		if(bttLst != null && !bttLst.isEmpty()){
			// 遍历按钮集合信息
			for(Map<String, Object> bttMap : bttLst){
				// 判断与登录人有关的按钮集合是否为空
				if(sedBttLst != null && !sedBttLst.isEmpty()){
					
					for(Map<String, Object> sedBttMap : sedBttLst){
						// 如果菜单与的按钮与与人员有关的按钮相同，则显示该按钮
						if(bttMap.get("id").toString().equals(sedBttMap.get("btt_id").toString())){
							
							bttMap.put("is_dpl", 1);
						}
					}
				}
			}
		}
		// 上面逻辑没有标记出来的显示状态，在下面补0
		if(bttLst != null && !bttLst.isEmpty()){
			
			for(Map<String, Object> bttMap : bttLst){
				
				if(bttMap.get("is_dpl") == null){
					
					bttMap.put("is_dpl", 0);
					
				}
			}
		}
		
		return bttLst;
	}

	/**
	 * 使用运维人员信息获取在各运维公司中的运维人员信息
	 */
	@Override
	public List<Map<String, Object>> getOptUseInfInComLstByOptId(Map<String, Object> map) throws Exception {
		
		return utilsDao.getOptUseInfInComLstByOptId(map);
	}
	
	/**
	 * 添加人员定位信息
	 */
	@Override
	public void insertUseLatLon(Map<String, Object> map) throws Exception {
		
		utilsDao.insertUseLatLon(map);
	}
	
	/**
	 * 使用IP获取地区信息
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getCityByIp(String ip) throws Exception {
		// 拼接获取地址信息的UI
		String str_url = InterfaceConstants.CITY_IP_TAOBAO_URL+ip;
       
		URL url = new URL(str_url);
        // 打开URL链接
		URLConnection conn = url.openConnection();
        // 获取返回信息
        BufferedReader retun = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        // 获取返回的json串
        JSONObject json = JSONObject.fromObject(retun.readLine());
        // 关闭连接
        retun.close();
        // 返回城市信息
//        return StringUtil.GBK2UTF8(JSONObject.fromObject(json.get("data")).get("city").toString());
        return JSONObject.fromObject(json.get("data")).get("city").toString();
    }
	
}
