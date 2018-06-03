package com.gcfd.mongo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gcfd.mongo.model.VisitLog;
import com.gcfd.mongo.service.VisitLogServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:mongo/spring-mongo.xml"}) 
public class MongoTest {

	@Autowired
	@Qualifier("visitLogService")
	private VisitLogServiceImpl visitLogService;
	
	@Test
	public void testSaveVisitLog() {
		VisitLog vl = new VisitLog();
		vl.setUserId("asdfasdf");
		vl.setUserName("wangwu");
		vl.setOperCode("02030");
		vl.setOperTime(null);
		vl.setVisitPath("/asdf/asdf.jsp");
		
		List<String> lt = new LinkedList<String>();
		lt.add("aaa");
		lt.add("bbb");
		lt.add("ccc");
		vl.setList(lt);
		visitLogService.saveVisitLog(vl);
	}
}
