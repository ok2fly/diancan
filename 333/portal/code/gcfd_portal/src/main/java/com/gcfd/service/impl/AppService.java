package com.gcfd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcfd.mapper.IAppMapper;
import com.gcfd.model.App;
import com.gcfd.model.Group;
import com.gcfd.model.User;
import com.gcfd.service.IAppService;
import com.gcfd.util.PageBean;
@Service
public class AppService implements IAppService{

	@Autowired
	private IAppMapper appMapper;
	

	@Override
	public List<App> getApps(PageBean page, String app_id) {
		return appMapper.getApps(page,app_id);
	}


	@Override
	public int getCounts() {
		return appMapper.getCounts();
	}


	@Override
	public void addApp(App model) throws Exception {
		appMapper.addApp( model );
	}


	@Override
	public void updateApp(App model) throws Exception {
		appMapper.updateApp( model );		
	}


	@Override
	public void deleteAppById(Long id) throws Exception {
		appMapper.deleteAppById( id );	
	}
	public void deleteAppCascadAll(Map param)throws Exception {
		appMapper.deleteAppCascadAll( param );	
	}


	@Override
	public List<App> getAppIcons(User user) {
		return appMapper.getAppIcons(user);
	}
	public List<App> getAppAuth(User user)
	{
		return appMapper.getAppAuth(user);
	}
	public List<App> getAppGroupAuth(User user)
	{
		return appMapper.getAppGroupAuth(user);
	}
	
	public List<App> getAppByGroupAuth(String group_id)
	{
		return appMapper.getAppByGroupAuth(group_id);
	}

	@Override
	public List<App> getApps(PageBean page, Group group) {
		
	//	List<App> apps = new ArrayList<App>();
		
		List<App> allApps = appMapper.getApps(page, null);
		
		/*Set<App> ckApps = appMapper.getCheckApps(page, group.getGroup_id());
		
		for (App app : allApps) {
			if( ckApps.contains(app) ){
				app.setLAY_CHECKED(true);
			}
			apps.add(app);
		}*/
		
		return allApps;
	}

}
