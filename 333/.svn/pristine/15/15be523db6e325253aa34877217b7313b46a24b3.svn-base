package com.gcfd.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.gcfd.model.Api;
import com.gcfd.util.PageBean;

public interface IApiMapper {
	public int getCounts();
	public List<Api> getApis(@Param("page") PageBean page, @Param("api_id") String api_id);
	public void addApi(Api api) throws Exception;
	public void deleteApiById( Long id ) throws Exception;
	public void updateApi(Api api) throws Exception;
	public Set<Api> getCheckApis(@Param("page")PageBean page, @Param("group_id")Long group_id);
	
	public List<Api> getApisAuth(Map<String,Object> param);
	public List<Api> getApisGroupAuth(Map<String,Object> param);
	public List<Api> getApisByGroupAndAPP(Map<String,Object> param);
	
}
