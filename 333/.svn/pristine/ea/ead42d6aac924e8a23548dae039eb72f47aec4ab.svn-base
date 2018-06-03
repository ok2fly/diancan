package com.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gcfd.mapper.IGroupMapper;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath*:*.xml"}) 
public class TestFun {

	@Autowired
	private IGroupMapper groupMapper;
	@Test
	public void testDelAuth() throws Exception {
		
		Map<String,Long> param = new HashMap<String,Long>();
		param.put("group_id", 1l);
		param.put("app_id", 7l);
		groupMapper.deleteAuthByGroupAPP(param);
	}
	
}
