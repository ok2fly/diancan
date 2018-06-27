package com.qinergy.service.commens;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.commens.CommensDao;

@Service
public class CommensServiceImpl implements CommensService {

	@Autowired
	private CommensDao commensDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getUserInfoList() throws Exception {
		List<Map<String, Object>> userList =commensDao.getUserInfoList();
		return userList;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getRoleInfoList() throws Exception {
		List<Map<String, Object>> roleList =commensDao.getRoleInfoList();
		return roleList;
	}

}
