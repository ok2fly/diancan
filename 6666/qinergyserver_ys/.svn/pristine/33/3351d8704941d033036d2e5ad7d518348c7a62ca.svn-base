/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.login;

import java.util.List;
import java.util.Map;

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
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public interface UserService {
	
	/**
	 * 登录入口（登录主方法）
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> userLogin(UserDto userDto) throws Exception ;
	
	/**
	 * 获取用户的权限信息
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserAuthorityPC(UserDto userDto) throws Exception;
	
	/**
	 * 修改密码
	 * @param loginName
	 * @param md5NewPasswd
	 * @param md5OldPasswd
	 * @return
	 * @throws Exception
	 */
	public int updateUserPassWd(String loginName,String md5NewPasswd,String md5OldPasswd) throws Exception;
	
	/**
	 * 获取已选的和未选的所有模块信息
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserRoleByModuleLevl(UserDto userDto) throws Exception;
	
	/**
	 * 删除角色信息(逻辑删除)
	 * @param userRoleDto
	 * @throws Exception
	 */
	void deleteUserRole(UserRoleDto userRoleDto) throws Exception;

	/**
	 * 建立角色与模块之间的关系
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	void insertUserRoleByModule(UserRoleModuleDto userRoleModuleDto) throws Exception;
	
	/**
	 * 删除角色与模块之间的关系
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	void deleteUserRoleByModule(UserRoleModuleDto userRoleModuleDto) throws Exception;
	
	
	/**
	 * 用户更新基本信息
	 * @param map
	 * @throws Exception
	 */
	public void updateUserInfo(Map<String, Object> map) throws Exception;

	/**
	 * 查询所有本公司的角色信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRolInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 查询所有本公司的角色信息(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getBasRolInfoCou(Map<String, Object> map) throws Exception;

	/**
	 * 使用指定角色获取角色与菜单中间表的所有数据唯一性标记删除已分配权限的菜单与按钮的中间关系表中的数据
	 * @param userRoleModuleButtonDto
	 * @throws Exception
	 */
	void deleteUserRoleModuleButtonByCrtIde(UserRoleModuleButtonDto userRoleModuleButtonDto) throws Exception;
	
	/**
	 * 向已分配权限的菜单与按钮的中间关系表中添加信息
	 * @param userRoleModuleButtonDto
	 * @throws Exception
	 */
	void insertUserRoleModuleButton(UserRoleModuleButtonDto userRoleModuleButtonDto) throws Exception;
	
	/**
	 * 获取系统中某菜单中的按钮与某角色被分配的按钮的关系
	 * @param userRoleModuleDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserRoleModuleByButtonLevl(UserRoleModuleDto userRoleModuleDto) throws Exception;
	
	/**
	 * 获取用户的权限信息(App)
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserAuthorityApp(UserDto userDto) throws Exception;
	
	/**
	 * 用户更新基本信息（App）
	 * @param map
	 * @throws Exception
	 */
	void updateUserInfoApp(Map<String, Object> map) throws Exception;

	/**
	 * 安卓端的用户权限获取
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserAuthorityAppNew(UserDto userDto) throws Exception;

	/**
	 * 避免重复提交/添加,通过角色id,删除相关内容(删除用户角色与模块之间的关系(App))
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	void deleteUserRoleByModuleApp(UserRoleModuleDto userRoleModuleDto) throws Exception;

	/**
	 * 建立角色与模块之间的关系(App)
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	void insertUserRoleByModuleApp(UserRoleModuleDto userRoleModuleDto) throws Exception;

	/**
	 * 获取已选的和未选的所有模块信息(App)
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserRoleByModuleLevlApp(UserDto userDto) throws Exception;
}
