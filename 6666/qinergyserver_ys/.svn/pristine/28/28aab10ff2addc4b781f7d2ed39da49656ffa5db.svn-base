package com.qinergy.dao.system;

import java.util.List;
import java.util.Map;

import com.qinergy.dto.system.DepartmentDto;


/**
 * 
 * @desc UserDao 
 * @author Qist
 * 2017年10月17日
 */
public interface SystemDepDao {

	void insertDep(Map<String, Object> map) throws Exception;

	void deleteDep(Map<String, Object> map) throws Exception;
	
	void updDep(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取部门信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<DepartmentDto> getDepInfo(Map<String, Object> map) throws Exception;
	
	DepartmentDto getDepInfoById(Map<String, Object> map) throws Exception;
	
	/*--------------------------以下为职位信息获取接口-------------------------*/
	 /**
	  * 获取所有职位的职位名称信息
	  * @return
	  * @throws Exception
	  */
	List<Map<String,Object>> getPosInfAll() throws Exception;
}
