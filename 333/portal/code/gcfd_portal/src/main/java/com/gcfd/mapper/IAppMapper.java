package com.gcfd.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.gcfd.model.App;
import com.gcfd.model.User;
import com.gcfd.util.PageBean;

public interface IAppMapper {
	
	public List<App> getApps(@Param("page")PageBean page, @Param("app_id")String app_id);
	
	public int getCounts();

	public void addApp(App model) throws Exception;

	public void updateApp(App model)throws Exception;

	public void deleteAppById(Long id)throws Exception;
	public void deleteAppCascadAll(Map param)throws Exception;

	public List<App> getAppIcons(User user);
	
	public List<App> getAppAuth(User user);
	
	public List<App> getAppGroupAuth(User user);
	public List<App> getAppByGroupAuth(String group_id);

	public Set<App> getCheckApps(@Param("page")PageBean page, @Param("group_id")Long group_id);
	
}
