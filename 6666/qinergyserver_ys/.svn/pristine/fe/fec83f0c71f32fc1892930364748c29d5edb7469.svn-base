package com.qinergy.dao.commens;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinergy.dao.base.BaseDao;

@Repository("commensDao")
public class CommensDaoImpl extends BaseDao implements CommensDao {

	@Override
	public List<Map<String, Object>> getUserInfoList() throws Exception {

		List<Map<String, Object>> userList = this.sqlSessionTemplate.selectList("commens.getUserInfoList");

		return userList;
	}

	@Override
	public List<Map<String, Object>> getRoleInfoList() throws Exception {
		List<Map<String, Object>> roleList = this.sqlSessionTemplate.selectList("commens.getRoleInfoList");
		return roleList;
	}

}
