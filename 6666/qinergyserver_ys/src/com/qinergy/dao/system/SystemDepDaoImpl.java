package com.qinergy.dao.system;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;
import com.qinergy.dto.system.DepartmentDto;

@Repository("systemDepDao")
public class SystemDepDaoImpl extends BaseDao implements SystemDepDao {
	
	
	@Override
	public void insertDep(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.insert("systemDep.insDep",map);
	}

	@Override
	public void deleteDep(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.delete("systemDep.delDep", map);
	}

	@Override
	public void updDep(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.delete("systemDep.updDep", map);
	}

	@Override
	public List<DepartmentDto> getDepInfo(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList("systemDep.getDepInfLst", map);
	}

	@Override
	public DepartmentDto getDepInfoById(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne("systemDep.getDepInfById", map);
	}

	/*--------------------------以下为职位信息获取接口-------------------------*/
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String,Object>> getPosInfAll() throws Exception {
		
		return sqlSessionTemplate.selectList("systemDep.getPosInfAll");
	}
}
