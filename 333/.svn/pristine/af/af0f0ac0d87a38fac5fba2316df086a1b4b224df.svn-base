package com.gcfd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcfd.mapper.IApiMapper;
import com.gcfd.model.Api;
import com.gcfd.model.Group;
import com.gcfd.service.IApiService;
import com.gcfd.util.PageBean;

@Service
public class ApiService implements IApiService {

	@Autowired
	private IApiMapper apiMapper;
	
	@Override
	public int getCounts() {
		return apiMapper.getCounts() ;
	}

	@Override
	public List<Api> getApis(PageBean page, String api_id) {
		return apiMapper.getApis(page,api_id) ;
	}
	public List<Api> getApisByGroupAndAPP(Map param) {
		//return apiMapper.getApisByGroupAndAPP(param) ;
		
		
		List<Api> apis = new ArrayList<Api>();
		
		List<Api> allApis = apiMapper.getApis(null,null);
		
		List<Api> ckApis = apiMapper.getApisByGroupAndAPP(param);
		
		for (Api api : allApis) {
			
			for( Api cApi: ckApis){
				if( cApi.getId() == api.getId() ){
					api.setLAY_CHECKED(true);
				}
			}
			apis.add(api);
		}
		
		return apis;
		
	}

	@Override
	public void addApi(Api api) throws Exception {
		apiMapper.addApi(api) ;
	}

	@Override
	public void deleteApiById(Long id) throws Exception {
		apiMapper.deleteApiById(id) ;		
	}

	@Override
	public void updateApi(Api api) throws Exception {
		apiMapper.updateApi(api) ;		
	}

	
	public List<Api> getApisAuth(Map<String,Object> param)
	{
		return apiMapper.getApisAuth(param) ;
	}
	public List<Api> getApisGroupAuth(Map<String,Object> param)
	{
		return apiMapper.getApisGroupAuth(param) ;
	}
	
	@Override
	public List<Api> getApis(PageBean page, Group group) {
		//List<Api> apis = new ArrayList<Api>();
		
		List<Api> allApis = apiMapper.getApis(null, null);
		
	/*	Set<Api> ckApis = apiMapper.getCheckApis(page, group.getGroup_id());
		
		for (Api api : allApis) {
			if( ckApis.contains(api) ){
				api.setLAY_CHECKED(true);
			}
			apis.add(api);
		}*/
		
		return allApis;
	}

}
