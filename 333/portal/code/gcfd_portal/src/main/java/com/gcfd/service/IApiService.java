package com.gcfd.service;

import java.util.List;
import java.util.Map;

import com.gcfd.model.Api;
import com.gcfd.model.Group;
import com.gcfd.util.PageBean;

public interface IApiService {
	public int getCounts();
	public List<Api> getApis(PageBean page, String api_id);
	public void addApi(Api api) throws Exception;
	public void deleteApiById( Long id ) throws Exception;
	public void updateApi(Api api) throws Exception;
	public List<Api> getApis(PageBean page, Group group);
	
	public List<Api> getApisAuth(Map<String,Object> param);
	public List<Api> getApisGroupAuth(Map<String,Object> param);
	public List<Api> getApisByGroupAndAPP(Map param);
}
