package com.qinergy.dao.login;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dto.system.UserDto;
import com.qinergy.dto.system.UserRoleDto;
import com.qinergy.dto.system.UserRoleModuleButtonDto;
import com.qinergy.dto.system.UserRoleModuleDto;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> userLogin(UserDto userDto) throws Exception {
		
		List<Map<String, Object>> userlist = this.sqlSessionTemplate.selectList("system.getUserByLoginNamePC", userDto);
		
		if(userlist != null && userlist.size()>0){
			
			Map<String, Object> map = userlist.get(0);
			
			return map;
			
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> userLoginPC(UserDto userDto) throws Exception {
		
		List<Map<String, Object>> userlist = this.sqlSessionTemplate.selectList("system.getUserByLoginNamePC", userDto);
		
		if(userlist != null && userlist.size()>0){
			
			Map<String, Object> map = userlist.get(0);
			
			return map;
			
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByModule1Levl(UserDto userDto) throws Exception {
		
		List<Map<String, Object>> userRoleModulelist = this.sqlSessionTemplate.selectList("system.getUserRoleByModule1Levl", userDto);
		
		return userRoleModulelist;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAppUserRoleByRolId(UserDto userDto) throws Exception {
		
		List<Map<String, Object>> userRoleModulelist = this.sqlSessionTemplate.selectList("system.getAppUserRoleByRolId", userDto);
		
		return userRoleModulelist;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAppUserRole() throws Exception {
		
		List<Map<String, Object>> userRoleModulelist = this.sqlSessionTemplate.selectList("system.getAppUserRole");
		
		return userRoleModulelist;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByModule1LevlAll() throws Exception {
		
		List<Map<String, Object>> userRoleModulelist = this.sqlSessionTemplate.selectList("system.getUserRoleByModule1LevlAll");
		
		return userRoleModulelist;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByModule1LevlApp(UserDto userDto) throws Exception {
		
		List<Map<String, Object>> userRoleModulelist = this.sqlSessionTemplate.selectList("system.getUserRoleByModule1LevlApp", userDto);
		
		return userRoleModulelist;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByModule2Levl(UserDto userDto) throws Exception {
		
		List<Map<String, Object>> userRoleModulelist = this.sqlSessionTemplate.selectList("system.getUserRoleByModule2Levl", userDto);
		
		return userRoleModulelist;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByModule2LevlApp(UserDto userDto) throws Exception {
		
		List<Map<String, Object>> userRoleModulelist = this.sqlSessionTemplate.selectList("system.getUserRoleByModule2LevlApp", userDto);
		
		return userRoleModulelist;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByModuleLevl(UserDto userDto) throws Exception {
		// 获取当前角色权限可见的1级菜单
		List<Map<String, Object>> module1LevlLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule1Levl", userDto);
		// 获取系统内的所有1级菜单
		List<Map<String, Object>> module1LevlAllLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule1LevlAll", userDto);
		// 对获取的所有1级菜单集合进行非空判断
		if(module1LevlAllLst != null && module1LevlAllLst.size() > 0){
			// 对获取的所有1级菜单集合进行遍历
			for(Map<String, Object> module1LevlAllMap:module1LevlAllLst){
				// 取出遍历出的1级菜单在数据库中的唯一标识（id）
				String allId = module1LevlAllMap.get("id").toString();
				// 建立计数器（以标识当前权限在系统内的1级菜单中，是否被赋予给该角色）
				int levl1 = 0;
				// 对当前角色权限可见的1级菜单集合进行非空判断
				if(module1LevlLst != null && module1LevlLst.size() > 0){
					// 遍历当前角色权限可见的1级菜单集合
					for(Map<String, Object> module1LevlMap:module1LevlLst){
						// 取出遍历出的1级菜单在数据库中的唯一标识（id）
						String id = module1LevlMap.get("id").toString();
						// 判断是否有匹配的1级菜单
						if(allId.equals(id)){
							
							levl1 = levl1 + 1;
						}
					}
				}
				// 对已分配的菜单进行标记
				if(levl1 > 0){
					
					module1LevlAllMap.put("levl", 1);
					
				}else{
					
					module1LevlAllMap.put("levl", 0);
				}
				// 二级菜单与一级菜单处理相同
				userDto.setPos_id(Integer.parseInt(allId));
				// 获取当前角色权限可见的2级菜单
				List<Map<String, Object>> module2LevlLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule2Levl", userDto);
				// 获取系统内的所有2级菜单
				List<Map<String, Object>> module2LevlAllLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule2LevlAll", userDto);
				// 对获取的所有2级菜单集合进行非空判断
				if(module1LevlAllLst != null && module1LevlAllLst.size() > 0){
					// 对获取的所有2级菜单集合进行遍历
					for(Map<String, Object> module2LevlAllMap:module2LevlAllLst){
						// 取出遍历出的2级菜单在数据库中的唯一标识（id）
						String allL2Id = module2LevlAllMap.get("id").toString();
						// 建立计数器（以标识当前权限在系统内的2级菜单中，是否被赋予给该角色）
						int levl2 = 0;
						// 对当前角色权限可见的2级菜单集合进行非空判断
						if(module2LevlLst != null && module2LevlLst.size() > 0){
							// 遍历当前角色权限可见的2级菜单集合
							for(Map<String, Object> module2LevlMap:module2LevlLst){
								// 取出遍历出的2级菜单在数据库中的唯一标识（id）
								String l2Id = module2LevlMap.get("id").toString();
								// 判断是否有匹配的2级菜单
								if(allL2Id.equals(l2Id)){
									
									levl2 = levl2 + 1;
								}
							}
						}
						// 对已分配的菜单进行标记
						if(levl2 > 0){
							
							module2LevlAllMap.put("levl", 1);
							
						}else{
							
							module2LevlAllMap.put("levl", 0);
						}
						// 三级菜单与二级处理相同
						userDto.setPos_id(Integer.parseInt(allL2Id));
						// 获取当前角色权限可见的3级菜单
						List<Map<String, Object>> module3LevlLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule2Levl", userDto);
						// 获取系统内的所有3级菜单
						List<Map<String, Object>> module3LevlAllLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule2LevlAll", userDto);
						// 对获取的所有3级菜单集合进行非空判断
						if(module3LevlAllLst != null && module3LevlAllLst.size() > 0){
							// 对获取的所有3级菜单集合进行遍历
							for(Map<String, Object> module3LevlAllMap:module3LevlAllLst){
								// 取出遍历出的3级菜单在数据库中的唯一标识（id）
								String allL3Id = module3LevlAllMap.get("id").toString();
								// 建立计数器（以标识当前权限在系统内的3级菜单中，是否被赋予给该角色）
								int levl3 = 0;
								// 对当前角色权限可见的3级菜单集合进行非空判断
								if(module3LevlLst != null && module3LevlLst.size() > 0){
									// 遍历当前角色权限可见的3级菜单集合
									for(Map<String, Object> module3LevlMap:module3LevlLst){
										// 取出遍历出的3级菜单在数据库中的唯一标识（id）
										String l3Id = module3LevlMap.get("id").toString();
										// 判断是否有匹配的3级菜单
										if(allL3Id.equals(l3Id)){
											
											levl3 = levl3 + 1;
										}
									}
								}
								// 对已分配的菜单进行标记
								if(levl3 > 0){
									
									module3LevlAllMap.put("levl", 1);
									
								}else{
									
									module3LevlAllMap.put("levl", 0);
								}
							}
						}
						
						module2LevlAllMap.put("module3LevlAllLst", module3LevlAllLst);
					}
				}
				
				module1LevlAllMap.put("module2LevlAllLst", module2LevlAllLst);
			}
		}
		
		return module1LevlAllLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserRoleByModuleLevlApp(UserDto userDto) throws Exception {
		// 获取当前角色权限可见的1级菜单
		List<Map<String, Object>> module1LevlLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule1LevlApp", userDto);
		// 获取系统内的所有1级菜单
		List<Map<String, Object>> module1LevlAllLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule1LevlAllApp", userDto);
		// 对获取的所有1级菜单集合进行非空判断
		if(module1LevlAllLst != null && module1LevlAllLst.size() > 0){
			// 对获取的所有1级菜单集合进行遍历
			for(Map<String, Object> module1LevlAllMap:module1LevlAllLst){
				// 取出遍历出的1级菜单在数据库中的唯一标识（id）
				String allId = module1LevlAllMap.get("id").toString();
				// 建立计数器（以标识当前权限在系统内的1级菜单中，是否被赋予给该角色）
				int levl1 = 0;
				// 对当前角色权限可见的1级菜单集合进行非空判断
				if(module1LevlLst != null && module1LevlLst.size() > 0){
					// 遍历当前角色权限可见的1级菜单集合
					for(Map<String, Object> module1LevlMap:module1LevlLst){
						// 取出遍历出的1级菜单在数据库中的唯一标识（id）
						String id = module1LevlMap.get("id").toString();
						// 判断是否有匹配的1级菜单
						if(allId.equals(id)){
							
							levl1 = levl1 + 1;
						}
					}
				}
				// 对已分配的菜单进行标记
				if(levl1 > 0){
					
					module1LevlAllMap.put("levl", 1);
					
				}else{
					
					module1LevlAllMap.put("levl", 0);
				}
				// 二级菜单与一级菜单处理相同
				userDto.setPos_id(Integer.parseInt(allId));
				// 获取当前角色权限可见的2级菜单
				List<Map<String, Object>> module2LevlLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule2LevlApp", userDto);
				// 获取系统内的所有2级菜单
				List<Map<String, Object>> module2LevlAllLst = this.sqlSessionTemplate.selectList("system.getUserRoleByModule2LevlAllApp", userDto);
				// 对获取的所有2级菜单集合进行非空判断
				if(module1LevlAllLst != null && module1LevlAllLst.size() > 0){
					// 对获取的所有2级菜单集合进行遍历
					for(Map<String, Object> module2LevlAllMap:module2LevlAllLst){
						// 取出遍历出的2级菜单在数据库中的唯一标识（id）
						String allL2Id = module2LevlAllMap.get("id").toString();
						// 建立计数器（以标识当前权限在系统内的2级菜单中，是否被赋予给该角色）
						int levl2 = 0;
						// 对当前角色权限可见的2级菜单集合进行非空判断
						if(module2LevlLst != null && module2LevlLst.size() > 0){
							// 遍历当前角色权限可见的2级菜单集合
							for(Map<String, Object> module2LevlMap:module2LevlLst){
								// 取出遍历出的2级菜单在数据库中的唯一标识（id）
								String l2Id = module2LevlMap.get("id").toString();
								// 判断是否有匹配的2级菜单
								if(allL2Id.equals(l2Id)){
									
									levl2 = levl2 + 1;
								}
							}
						}
						// 对已分配的菜单进行标记
						if(levl2 > 0){
							
							module2LevlAllMap.put("levl", 1);
							
						}else{
							
							module2LevlAllMap.put("levl", 0);
						}
					}
				}
				
				module1LevlAllMap.put("module2LevlAllLst", module2LevlAllLst);
			}
		}
		
		return module1LevlAllLst;
	}
	
	
	/**
	 * {@inheritDoc}
	 * @param userRoleModuleDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getUserRoleModuleByButtonLevl(UserRoleModuleDto userRoleModuleDto) throws Exception {
		// 获取当前角色权限可见的指定菜单中的按钮
		List<Map<String, Object>> buttonLevlLst = this.sqlSessionTemplate.selectList("system.getUserRoleModuleButtonByRolMod", userRoleModuleDto);
		// 获取系统内的与该菜单有关的所有按钮信息
		List<Map<String, Object>> buttonLevlAllLst = this.sqlSessionTemplate.selectList("system.getUserRoleModuleButtonByMod", userRoleModuleDto);
		// 对系统内的与该菜单有关的所有按钮信息进行非空判断
		if(buttonLevlAllLst != null && buttonLevlAllLst.size() > 0){
			// 对获取的系统内的与该菜单有关的所有按钮信息
			for(Map<String, Object> buttonLevlAllMap:buttonLevlAllLst){
				// 取出遍历出的系统内的与该菜单有关的所有按钮信息中的在数据库中的唯一标识（id）
				String allId = buttonLevlAllMap.get("id").toString();
				// 建立计数器
				int levl1 = 0;
				// 对当前角色权限可见的指定菜单中的按钮集合进行非空判断
				if(buttonLevlLst != null && buttonLevlLst.size() > 0){
					// 遍历当前角色权限可见的指定菜单中的按钮集合
					for(Map<String, Object> buttonLevlMap:buttonLevlLst){
						// 取出遍历出的当前角色权限可见的指定菜单中的按钮在数据库中的唯一标识（id）
						String id = buttonLevlMap.get("id").toString();
						// 判断是否有匹配的当前角色权限可见的指定菜单中的按钮
						if(allId.equals(id)){
							
							levl1 = levl1 + 1;
						}
					}
				}
				// 对已分配的按钮进行标记
				if(levl1 > 0){
					
					buttonLevlAllMap.put("levl", 1);
					
				}else{
					
					buttonLevlAllMap.put("levl", 0);
				}
			}
		}
		
		return buttonLevlAllLst;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUserPassWd(Map<String, Object> map) throws Exception {
		
		this.sqlSessionTemplate.update("system.updateUserPassWd", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserRole(UserRoleDto userRoleDto) throws Exception {
		
		this.sqlSessionTemplate.delete("system.deleteUserRole", userRoleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserRoleByModule(UserRoleModuleDto userRoleModuleDto) throws Exception {
		
		this.sqlSessionTemplate.delete("system.deleteUserRoleByModule", userRoleModuleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserRoleByModuleApp(UserRoleModuleDto userRoleModuleDto) throws Exception {
		
		this.sqlSessionTemplate.delete("system.deleteUserRoleByModuleApp", userRoleModuleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUserRoleByModule(UserRoleModuleDto userRoleModuleDto) throws Exception {
		this.sqlSessionTemplate.insert("system.insertUserRoleByModule",userRoleModuleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUserRoleByModuleApp(UserRoleModuleDto userRoleModuleDto) throws Exception {
		this.sqlSessionTemplate.insert("system.insertUserRoleByModuleApp",userRoleModuleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUserInfo(Map<String,Object> map) {
		this.sqlSessionTemplate.update("system.updateUser", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUserInfoApp(Map<String,Object> map) {
		this.sqlSessionTemplate.update("system.updateUserApp", map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String,Object>> getBasRolInfo(Map<String,Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("system.getBasRolInfo",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String,Object>> getBasRolInfoCou(Map<String,Object> map) throws Exception {
		return this.sqlSessionTemplate.selectList("system.getBasRolInfoCou",map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String,Object>> getUserRoleModuleCrtIde(UserRoleModuleDto userRoleModuleDto) throws Exception {
		
		return this.sqlSessionTemplate.selectList("system.getUserRoleModuleCrtIde",userRoleModuleDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserRoleModuleButtonByCrtIde(UserRoleModuleButtonDto userRoleModuleButtonDto) throws Exception {
		
		this.sqlSessionTemplate.delete("system.deleteUserRoleModuleButtonByCrtIde",userRoleModuleButtonDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUserRoleModuleButton(UserRoleModuleButtonDto userRoleModuleButtonDto) throws Exception {
		
		this.sqlSessionTemplate.insert("system.insertUserRoleModuleButton",userRoleModuleButtonDto);
	}
	
}
