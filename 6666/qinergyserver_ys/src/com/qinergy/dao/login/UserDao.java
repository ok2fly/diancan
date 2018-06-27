package com.qinergy.dao.login;

import java.util.List;
import java.util.Map;

import com.qinergy.dto.system.UserDto;
import com.qinergy.dto.system.UserRoleDto;
import com.qinergy.dto.system.UserRoleModuleButtonDto;
import com.qinergy.dto.system.UserRoleModuleDto;

/**
 * @desc: UserDao 实现类，无接口
 * @author iceX
 * @date 2016年7月8日15:53:45
 */
public interface UserDao {
	
	/**
	 * 登录入口（登录主方法）
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> userLogin(UserDto userDto) throws Exception ;
	
	/**
	 * 获取与登录人有关的一级模块信息
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserRoleByModule1Levl(UserDto userDto) throws Exception;
	
	/**
	 * 获取与登录人有关的二级模块信息
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserRoleByModule2Levl(UserDto userDto) throws Exception;
	
	/**
	 * 修改密码(PC)
	 * @param map
	 * @throws Exception
	 */
	public void updateUserPassWd(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取已选的和未选的所有模块信息
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserRoleByModuleLevl(UserDto userDto)
			throws Exception;
	/**
	 * 删除用户角色信息
	 * @param userRoleDto
	 * @throws Exception
	 */
	void deleteUserRole(UserRoleDto userRoleDto) throws Exception;

	/**
	 * 建立角色与菜单（模块）之间的关联关系
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	void insertUserRoleByModule(UserRoleModuleDto userRoleModuleDto)
			throws Exception;

	/**
	 * 删除角色与菜单（模块）之间的关联关系
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	void deleteUserRoleByModule(UserRoleModuleDto userRoleModuleDto)
			throws Exception;
	
	/**
	 * 更新个人信息（更新用户信息）
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	public void updateUserInfo(Map<String, Object> map);

	/**
	 * 建立角色与菜单（模块）之间的关联关系
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	public Map<String, Object> userLoginPC(UserDto userDto) throws Exception;
	
	/**
	 * 按条件查询角色信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRolInfo(Map<String, Object> map) throws Exception;

	/**
	 * 按条件查询角色信息列表(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBasRolInfoCou(Map<String, Object> map)
			throws Exception;

	
	/**
	 * 获取指定角色的角色与菜单中间表的所有数据唯一性标记
	 * @param userRoleModuleDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserRoleModuleCrtIde(UserRoleModuleDto userRoleModuleDto) throws Exception;
	
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
	 * 用户信息查询，展示1级菜单(App)
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserRoleByModule1LevlApp(UserDto userDto)
			throws Exception;
	/**
	 * 获取与登录人有关的一级模块下的可查看人二级模块信息
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserRoleByModule2LevlApp(UserDto userDto)
			throws Exception;

	/**
	 * 获取系统内所有的一级模块的信息
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserRoleByModule1LevlAll() throws Exception;

	/**
	 * 用户更新基本信息(App)
	 * @param map
	 */
	void updateUserInfoApp(Map<String, Object> map);

	/**
	 * 获取与登录人有关的一级模块信息(App)
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAppUserRoleByRolId(UserDto userDto)
			throws Exception;

	/**
	 * 获取系统内所有的一级模块的信息(App)
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAppUserRole() throws Exception;
	
	/**
	 * 删除用户角色与权限之间的关联(App)
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	void deleteUserRoleByModuleApp(UserRoleModuleDto userRoleModuleDto)
			throws Exception;

	/**
	 * 建立用户角色与权限之间的关联关系(App)
	 * @param userRoleModuleDto
	 * @throws Exception
	 */
	void insertUserRoleByModuleApp(UserRoleModuleDto userRoleModuleDto)
			throws Exception;

	/**
	 * 获取权限信息
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserRoleByModuleLevlApp(UserDto userDto)
			throws Exception;

}
