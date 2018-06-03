package com.gcfd.redis;

import java.util.HashMap;
import java.util.Map;

import org.gcfd.redis.service.UserInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gcfd.redis.model.RedisObject;
import com.gcfd.redis.model.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:spring-redis.xml"}) 
public class TestRedis {

	@Autowired
	@Qualifier("userInfoService")
	private UserInfoServiceImpl userInfoService;
	
	@Test
	public void testSave() {
		
		
		UserInfo ui = new UserInfo();
		ui.setToken("1111111111111122222222222222");
		ui.setUserId("userid");
		ui.setUserName("zhangsan");
		
		userInfoService.saveUserInfo(ui);
		
		
		
		RedisObject robj = new RedisObject();
		robj.setKey("aaaaaaaaaaaaaaaaa");
		robj.setValue("dddddddddddddddd");
		
		Map<String,String> mp = new HashMap<String,String>();
		mp.put("sdff","aaaa");
		robj.setValue(mp);
		userInfoService.saveObject(robj);
	}
	
	@Test
	public void testGet() {
		
		UserInfo ui = userInfoService.getUserInfo( "1111111111111122222222222222");
		if(null != ui)
			System.out.println(ui.getUserName());
		else
			System.out.println("UserInfo Not Exists!");
		Object obj = userInfoService.getObject("aaaaaaaaaaaaaaaaa");
		if(null != obj)
		{
			RedisObject robj = (RedisObject)obj;
			System.out.println(robj.getValue().toString());
		}
	}
	
	@Test
	public void testDel() {
		userInfoService.delObject("1111111111111122222222222222");
	}
	
}
