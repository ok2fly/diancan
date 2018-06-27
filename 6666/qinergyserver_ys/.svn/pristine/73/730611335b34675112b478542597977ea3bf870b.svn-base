/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.login.UserDao;
import com.qinergy.dto.common.UserConstants;
import com.qinergy.dto.system.UserDto;
import com.qinergy.dto.system.UserRoleDto;
import com.qinergy.dto.system.UserRoleModuleButtonDto;
import com.qinergy.dto.system.UserRoleModuleDto;

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
public class UserServiceImpl implements UserService {

	/**
	 * Attribute to hold the <code>userDao</code> property.
	 */
	@Autowired
	private UserDao userDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> userLogin(UserDto userDto) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 给返回给前端的请求原因字段,赋初始值
		map.put("reason", UserConstants.SUCCESS);
		// 判断登录名是否为空
		if (StringUtils.isNotBlank(userDto.getLogin_name())) {
			
			userDto.setLogin_name(userDto.getLogin_name().trim());
			
		} else {
			// 参数异常

			map.put("reason", UserConstants.PARAM_ERROR);
			
			return map;
		}
		// 调用获取登录信息接口
		Map<String, Object> userMap = userDao.userLoginPC(userDto);
		// 判断获取回来的登录信息是否为空
		if (userMap != null) {

			if (!userDto.getPassword().equals(userMap.get("use_pas").toString())) {
			// 密码不正确

				map.put("reason", UserConstants.PASSWD_INVALID);

				return map;

			}

			map.put("reason", UserConstants.SUCCESS);
		}else{
			// 如果为空,则返回给前端不存在
			map.put("reason", UserConstants.USER_NOT_EXIST);
		}
		
		map.put("userMap", userMap);
		
		return map;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserAuthorityPC(UserDto userDto) throws Exception {
		// 获取系统内所有的一级模块的信息
		List<Map<String, Object>> lev1AllLst = userDao.getUserRoleByModule1LevlAll();
		// 获取与登录人有关的一级模块信息
		List<Map<String, Object>> auth1Levllst = userDao.getUserRoleByModule1Levl(userDto);
		// 比对系统内已存在的一级模块信息以及与登录人有关的一级模块信息,并将存在的打上标记
		if(lev1AllLst != null && !lev1AllLst.isEmpty() && lev1AllLst.get(0) != null){
			
			for(Map<String, Object> lev1AllMap:lev1AllLst){
				
				if(auth1Levllst != null && !auth1Levllst.isEmpty() && auth1Levllst.get(0) != null){
					
					for(Map<String, Object> auth1LevlMap:auth1Levllst){
						// 比对判断,打标记
						if(auth1LevlMap.get("id").toString().equals(lev1AllMap.get("id").toString())){
							
							lev1AllMap.put("is_dsp", 1);
						}
					}
				}
			}
		}
		// 将没有打标记的数据,统一打上标记(0,is_dsp如果为0,则首页中的部分为0的一级菜单入口,显示灰色)
		if(lev1AllLst != null && !lev1AllLst.isEmpty() && lev1AllLst.get(0) != null){
			
			for(Map<String, Object> lev1AllMap:lev1AllLst){
				
				if(lev1AllMap.get("is_dsp") == null){
					
					lev1AllMap.put("is_dsp", 0);
				}
			}
		}
		// 判断系统内是否存在一级菜单
		if(lev1AllLst != null && lev1AllLst.size() > 0){
			
			for(Map<String, Object> lev1AllMap : lev1AllLst){
				// 找出用户权限内所能够查看/有权点击的一级菜单
				if(lev1AllMap != null && lev1AllMap.get("is_dsp").toString().equals("1")){
					
					userDto.setPos_id(Integer.parseInt(lev1AllMap.get("id").toString()));
					// 通过一级菜单,找出该菜单下的所有有权限查看的二级菜单
					List<Map<String, Object>> auth2Levllst = userDao.getUserRoleByModule2Levl(userDto);
					
					if(auth2Levllst != null && auth2Levllst.size() > 0){
						
						for(Map<String, Object> auth2LevlMap : auth2Levllst){
							
							if(auth2LevlMap != null){
								
								userDto.setPos_id(Integer.parseInt(auth2LevlMap.get("id").toString()));
								// 通过二级菜单,筛选出二级菜单下所有有权限查看的三级菜单
								List<Map<String, Object>> auth3Levllst = userDao.getUserRoleByModule2Levl(userDto);
								
								auth2LevlMap.put("menu", auth3Levllst);
							}
						}
					}
					
					lev1AllMap.put("menu", auth2Levllst);
				}
			}
		}
		
		return lev1AllLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserAuthorityAppNew(UserDto userDto) throws Exception {
		// 获取系统内所有的一级模块的信息
		List<Map<String, Object>> allMenLst = userDao.getAppUserRole();
		// 获取与登录人有关的一级模块信息
		List<Map<String, Object>> rolMenLst = userDao.getAppUserRoleByRolId(userDto);
		// 比对系统内已存在的一级模块信息以及与登录人有关的一级模块信息,并将存在的打上标记
		if(allMenLst != null && !allMenLst.isEmpty() && allMenLst.get(0) != null){
			
			for(Map<String, Object> allMenMap:allMenLst){
				
				if(rolMenLst != null && !rolMenLst.isEmpty() && rolMenLst.get(0) != null){
					
					for(Map<String, Object> rolMenMap:rolMenLst){
						// 比对判断,打标记
						if(allMenMap.get("id").toString().equals(rolMenMap.get("id").toString())){
							
							allMenMap.put(allMenMap.get("module_code").toString(), 1);
							
							break;
						}
					}
				}
			}
		}
		
		// 将没有打标记的数据,统一打上标记(0,is_dsp如果为0,则首页中的部分为0的一级菜单入口,显示灰色)
		if(allMenLst != null && !allMenLst.isEmpty() && allMenLst.get(0) != null){
			
			for(Map<String, Object> allMenMap:allMenLst){
				
				if(allMenMap.get(allMenMap.get("module_code").toString()) == null){
					
					allMenMap.put(allMenMap.get("module_code").toString(), 0);
				}
			}
		}
		
		return allMenLst;
	}
	
	/**
	 * {@inheritDoc}--i
	 */
	@Override
	public List<Map<String, Object>> getUserAuthorityApp(UserDto userDto) throws Exception {
		
		// 获取与登录人有关的一级模块信息
		List<Map<String, Object>> auth1Levllst = userDao.getUserRoleByModule1LevlApp(userDto);
		
		if(auth1Levllst != null && auth1Levllst.size() > 0){
			
			for(Map<String, Object> auth1LevlMap : auth1Levllst){
				
				if(auth1LevlMap != null){
					
					userDto.setPos_id(Integer.parseInt(auth1LevlMap.get("id").toString()));
					// 获取与登录人有关的一级模块下的可查看人二级模块信息
					List<Map<String, Object>> auth2Levllst = userDao.getUserRoleByModule2LevlApp(userDto);
					
					if(auth2Levllst != null && auth2Levllst.size() > 0){
						
						for(Map<String, Object> auth2LevlMap : auth2Levllst){
							
							if(auth2LevlMap != null){
								
								userDto.setPos_id(Integer.parseInt(auth2LevlMap.get("id").toString()));
								// 获取与登录人有关的二级模块下的可查看人三级模块信息
								List<Map<String, Object>> auth3Levllst = userDao.getUserRoleByModule2LevlApp(userDto);
								
								auth2LevlMap.put("menu", auth3Levllst);
							}
						}
					}
					
					auth1LevlMap.put("menu", auth2Levllst);
				}
			}
		}
		
		return auth1Levllst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updateUserPassWd(String loginName,String md5NewPasswd,String md5OldPasswd) throws Exception {

		UserDto userDto = new UserDto();
		
		userDto.setLogin_name(loginName);
		
		userDto.setPassword(md5OldPasswd);
		// 在修改密码时,需要判断用户输入的原始密码是否正确
		Map<String, Object> userMap = userDao.userLogin(userDto);

		Map<String, Object> map = new HashMap<String, Object>();
		// 如果密码不正确,则给用户返回密码不正确的提示
		if (userMap != null) {

			if (!userDto.getPassword().equals(userMap.get("use_pas").toString())) {
			// 密码不正确
				return UserConstants.PASSWD_INVALID;
			}
		}
		
		map.put("md5NewPasswd", md5NewPasswd);
		
		map.put("loginName", loginName);
		
		userDao.updateUserPassWd(map);
		
		return UserConstants.SUCCESS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserRole(UserRoleDto userRoleDto) throws Exception {
		
		userDao.deleteUserRole(userRoleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByModuleLevl(UserDto userDto)throws Exception{
		
		return userDao.getUserRoleByModuleLevl(userDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByModuleLevlApp(UserDto userDto)throws Exception{
		
		return userDao.getUserRoleByModuleLevlApp(userDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getBasRolInfo(Map<String, Object> map)throws Exception{
		
		return userDao.getBasRolInfo(map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String,Object> getBasRolInfoCou(Map<String,Object> map) throws Exception{
		
		List<Map<String, Object>> chaLst = userDao.getBasRolInfoCou(map);
		
		if(chaLst != null && chaLst.size() > 0){
			
			for(Map<String, Object> chaMap : chaLst){
				
				return chaMap;
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUserRoleByModule(UserRoleModuleDto userRoleModuleDto)throws Exception{
		
		userDao.insertUserRoleByModule(userRoleModuleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUserRoleByModuleApp(UserRoleModuleDto userRoleModuleDto)throws Exception{
		
		userDao.insertUserRoleByModuleApp(userRoleModuleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserRoleByModule(UserRoleModuleDto userRoleModuleDto)throws Exception{
		
		userDao.deleteUserRoleByModule(userRoleModuleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserRoleByModuleApp(UserRoleModuleDto userRoleModuleDto)throws Exception{
		
		userDao.deleteUserRoleByModuleApp(userRoleModuleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUserInfo(Map<String,Object> map) throws Exception {
		userDao.updateUserInfo(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUserInfoApp(Map<String,Object> map) throws Exception {
		userDao.updateUserInfoApp(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserRoleModuleButtonByCrtIde(UserRoleModuleButtonDto userRoleModuleButtonDto) throws Exception {
		
		userDao.deleteUserRoleModuleButtonByCrtIde(userRoleModuleButtonDto);;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUserRoleModuleButton(UserRoleModuleButtonDto userRoleModuleButtonDto) throws Exception {
		
		userDao.insertUserRoleModuleButton(userRoleModuleButtonDto);;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleModuleByButtonLevl(UserRoleModuleDto userRoleModuleDto) throws Exception {
		
		return userDao.getUserRoleModuleByButtonLevl(userRoleModuleDto);
	}
}
