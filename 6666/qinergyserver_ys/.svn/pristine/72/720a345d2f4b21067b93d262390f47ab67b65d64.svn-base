package com.qinergy.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.system.SystemDepDao;
import com.qinergy.dto.system.DepartmentDto;
import com.qinergy.dto.system.PositionDto;

@Service
public class SystemDepServiceImpl implements SystemDepService {

	
	@Autowired
    private SystemDepDao systemDepDao;
    
	/**
	 * 添加一个部门
	 */
	@Override
	public void insertDep(Map<String, Object> map) throws Exception {
		systemDepDao.insertDep(map);
	}

	/**
	 * 删除部门
	 */
	@Override
	public void deleteDep(Map<String, Object> map) throws Exception {
		systemDepDao.deleteDep(map);
	}

	/**
	 * 修改部门
	 */
	@Override
	public void updDep(Map<String, Object> map) throws Exception {
		
		systemDepDao.updDep(map);
	}

	/**
	 * 获取部门列表
	 */
	@Override
	public List<DepartmentDto> getDepInfo(Map<String, Object> map)
			throws Exception {
		return systemDepDao.getDepInfo(map);
	}

	/**
	 * 获取指定部门id
	 */
	@Override
	public DepartmentDto getDepInfoById(Map<String, Object> map)
			throws Exception {
		return systemDepDao.getDepInfoById(map);
	}
	
	/*--------------------------以下为职位信息获取接口-------------------------*/
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String,Object>> getPosInfAll() throws Exception {
		
		return systemDepDao.getPosInfAll();
	}

}
