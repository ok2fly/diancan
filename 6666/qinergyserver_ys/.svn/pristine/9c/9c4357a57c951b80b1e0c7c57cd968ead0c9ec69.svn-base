package com.qinergy.service.system;

import java.util.List;
import java.util.Map;

import com.qinergy.dto.system.DepartmentDto;

/**
 * 
 * @desc: 部门管理接口 无实现
 * @author: Qist
 * @date: 2017年10月17日
 */
public interface SystemDepService {

	/**
	 * 添加部门信息
	 * @param map
	 * @throws Exception
	 */
	void insertDep(Map<String, Object> map) throws Exception;
	/**
	 * 删除部门信息
	 * @param map
	 * @throws Exception
	 */
	void deleteDep(Map<String, Object> map) throws Exception;
	/**
	 * 修改部门信息
	 * @param map
	 * @throws Exception
	 */
	void updDep(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取部门信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<DepartmentDto> getDepInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取某一条部门信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	DepartmentDto getDepInfoById(Map<String, Object> map) throws Exception;

	/*--------------------------以下为职位信息获取接口-------------------------*/
	
	/**
	 * 获取所有职位的职位名称信息
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPosInfAll() throws Exception;
}
