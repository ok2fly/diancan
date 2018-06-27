/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.dailyoffice;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.UserInfDto;
import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.UserDto;

/**
 * 日常办公接口类
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public interface DailyOfficeService {

	/**
	 * 文件上传主方法
	 * @param file
	 * @param map
	 * @param created_id
	 * @return
	 */
	boolean uploadFile(MultipartFile file, LinkedHashMap<String, Object> map,
			int created_id);

	/**
	 * 文件下载主方法
	 * @param response
	 * @param id
	 * @param baseTransferEntity
	 * @return
	 */
	boolean downloadFile(HttpServletResponse response, int id,
			BaseTransferEntity baseTransferEntity);

	/**
	 * 文件移除主方法
	 * @param id
	 * @return
	 */
	int removeFile(int id);

	/**
	 * 添加文件类型
	 * @param fil_typ_nam
	 * @param crt_use_id
	 * @param crt_tim
	 * @param remark
	 * @return
	 */
	int insertFileType(String fil_typ_nam, int crt_use_id, Date crt_tim,
			String remark);
	/**
	 * 使用文件类型ID修改文件类型信息
	 * @param id
	 * @param fil_typ_nam
	 * @param mod_use_id
	 * @param remark
	 * @return
	 */
	boolean updateFileTypeById(int id, String fil_typ_nam, int mod_use_id,
			String remark);

	/**
	 * 删除文件类型
	 * @param id
	 * @return
	 */
	boolean removeFileType(int id);

	/**
	 * 使用用户ID获取公司信息
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getComsInfoByUserId(UserDto userDto)
			throws Exception;

	/**
	 * 获取公司所属的文件信息列表
	 * @param com_id
	 * @param type
	 * @param name
	 * @return
	 */
	public List<LinkedHashMap<String, Object>> getComFileList(Integer com_id,
			String type, String name);

	/**
	 * 获取所有公司信息
	 * @return
	 */
	public List<Map<String, Object>> getAllComs();

	/**
	 * 获取3级公司信息
	 * @param companyDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getComs_Level_3_Of_com(
			CompanyDto companyDto) throws Exception;

	/**
	 * 获取文件类型
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getFileType(Map<String, Object> map);

	/**
	 * 用户类型 ： 员工管理（运维公司） + 客户管理（运营公司）
	 */
	/**
	 *  添加 员工信息
	 * @param userInfDto
	 * @throws Exception
	 */
	public void insertUserInfo(UserInfDto userInfDto) throws Exception;

	/**
	 *  修改员工信息
	 * @param userInfDto
	 * @throws Exception
	 */
	public void updateUserInfo(UserInfDto userInfDto) throws Exception;

	/**
	 *  修改 员工部门
	 * @param userInfDto
	 * @throws Exception
	 */
	public void updateUserDep(UserInfDto userInfDto) throws Exception;

	/**
	 *  修改 密码
	 * @param userInfDto
	 * @throws Exception
	 */
	public void resetPwd(UserInfDto userInfDto) throws Exception;

	/**
	 *  删除 员工信息
	 * @param map
	 * @throws Exception
	 */
	public void delUserInfo(Map<String, Object> map) throws Exception;

	/**
	 *  停用/启用帐号
	 * @param id
	 * @param use_sta
	 * @param use_id
	 * @throws Exception
	 */
	public void setAccStat(Integer id, Integer use_sta,String use_id) throws Exception;

	/**
	 * 根据公司类型（1：运维 公司2：运营公司 ） 用户类型（1：运维人员 2：客户运营公司人员 ）
	 */
	public List<Map<String, Object>> getUserInfById(Map<String, Object> map) throws Exception;

	/**
	 * 使用用户类型获取用户信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserInfListByType(Map<String, Object> map) throws Exception;

	/**
	 * 获取用户信息数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getUserListCount(Map<String, Object> map) throws Exception;

	/**
	 * 根据  账号，用户姓名 查询   防止用户账号重复或姓名重复
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserByNumAndNam(Map<String, Object> map)
			throws Exception;

	/**
	 * 使用文件名称获取文件类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selFileTypByName(Map<String, Object> map)throws Exception;

	/**
	 * 使用文件ID获取文件
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<LinkedHashMap<String, Object>> getFileById(int id) throws Exception;

	/**
	 * 使用文件ID获取文件（App）
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> AppSelectFileById(Map<String, Object> map)
			throws Exception;
	
	/**
	 * 设置运维人员分数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void updateUserScore(Map<String, Object> map) throws Exception;
	

}
