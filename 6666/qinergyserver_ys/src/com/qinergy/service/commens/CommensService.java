package com.qinergy.service.commens;

import java.util.List;
import java.util.Map;

public interface CommensService {
	/**
	 * 获取所有用户的信息列表
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserInfoList() throws Exception;
	/**
	 * 获取所有角色的信息列表
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getRoleInfoList() throws Exception;

}
