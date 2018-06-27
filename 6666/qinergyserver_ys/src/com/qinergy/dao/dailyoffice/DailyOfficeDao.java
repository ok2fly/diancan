package com.qinergy.dao.dailyoffice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.qinergy.dto.UserInfDto;

/**
 * @desc: DailyOfficeDao 实现类，无接口
 * @author iceX
 * @date 2016年7月8日15:53:32
 */
public interface DailyOfficeDao {
	
	/**
	 * 文件添加
	 * @param map
	 * @return
	 */
	int insertFile(LinkedHashMap<String, Object> map);

	/**
	 * 通过id 查询所有文件
	 * @param map
	 * @return
	 */
	List<LinkedHashMap<String, Object>> getFileById(int id);

	/**
	 * 文件移除
	 * @param map
	 * @return
	 */
	int removeFile(int id);

	/**
	 * 根据公司查询所有的文件信息
	 * @param map
	 * @return
	 */
	List<LinkedHashMap<String, Object>> getListByComsId(Map<String, Object> map);

	/**
	 * 查询所有公司
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getComsAll();

	/**
	 * 获取文件类型
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getFileType(Map<String, Object> map);

	/**
	 * 添加文件类型
	 * @param map
	 * @return
	 */
	int insertFilrType(Map<String, Object> map);

	/**
	 * 修改文件类型
	 * @param map
	 * @return
	 */
	int updateFileType(Map<String, Object> map);

	/**
	 * 根据类型 得到改类型文件总数
	 * @param map
	 * @return
	 */
	int getFileCountInType(int id);

	/**
	 * 删除文件类型
	 * @param map
	 * @return
	 */
	int removeFileType(int id);

	
	/** 员工管理*/
	/**
	 * 添加用户信息
	 * @param map
	 * @return
	 */
	public void insertUserInfo(Map<String, Object> map) throws Exception;

	/**
	 * 修改用户信息
	 * @param map
	 * @return
	 */
	public void updateUserInfo(Map<String, Object> map) throws Exception;

	/**
	 * 修改用户所在部门
	 * @param map
	 * @return
	 */
	public void updateUserDep(Map<String, Object> map) throws Exception;

	/**
	 * 修改密码
	 * @param map
	 * @return
	 */
	public void resetPwd(Map<String, Object> map) throws Exception;

	/**
	 * 删除用户信息
	 * @param map
	 * @return
	 */
	public void delUserInfo(Map<String, Object> map) throws Exception;

	/**
	 * 更改用户 是否离职
	 * @param map
	 * @return
	 */
	public void setAccStat(Map<String, Object> map) throws Exception;

	/**
	 * 根据id 产看用户详细信息
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getUserInfById(Map<String, Object> map) throws Exception;

	/**
	 * 用户信息列表展示及查询
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getUserInfListByType(Map<String, Object> map) throws Exception;

	/**
	 * 用户信息列表展示及查询   分页
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getUserListCount(Map<String, Object> map) throws Exception;

	/**
	 * 根据  账号，用户姓名 查询   防止用户账号重复或姓名重复
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getUserByNumAndNam(Map<String, Object> map)
			throws Exception;

	/**
	 * 通过名称查询文件类型
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selFileTypByName(Map<String, Object> map)throws Exception;

	/**
	 * app端 文件下载 需要返回的参数
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> AppSelectFileById(Map<String, Object> map)
			throws Exception;

	/**
	 * 修改用户分数
	 * @param map
	 * @return
	 */
	void updateUserScore(Map<String, Object> map) throws Exception;

	/** 员工管理*/
}
