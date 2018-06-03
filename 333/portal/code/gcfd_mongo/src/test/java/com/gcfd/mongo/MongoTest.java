package com.gcfd.mongo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gcfd.mongo.model.VisitLog;
import com.gcfd.mongo.service.VisitLogServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:spring-mongo.xml"}) 
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
	@Test
	public void testCount() {
		
		int count = visitLogService.getCount(null);
		System.out.println("count:"+count);
	}
	@Test
	public void testGetList() {
		
		Page<VisitLog> page = visitLogService.visitlog(null,0,15);
		 System.out.println("总记录数:" + page.getTotalElements());  
	        System.out.println("总页数:" + page.getTotalPages());  
	        System.out.println("当前页（request):" + page.getNumber());  
	        System.out.println("当前页总记录数（request):" + page.getSize());  
	        System.out.println("当前页记录总数：" + page.getNumberOfElements());  
	        List<VisitLog> vls = page.getContent();  
	        for (VisitLog vl : vls) {  
	            System.out.println(vl.getOperTime());  
	            System.out.println(vl.getUserName());  
	            System.out.println(vl.getOperCode());  
	            System.out.println(vl.getReturnPath());  
	            System.out.println(vl.getVisitPath());
	            System.out.println(".....................");
	        }  
	        
	        
	}
	@Test
	public void testVisitlog() {
		
		  VisitLog vvl = new VisitLog();
		  vvl.setUserName("wen");
		  long ct = visitLogService.visitlogCount(vvl, null, null);
		  System.out.println("count:"+ct);
		  List<VisitLog> vls = visitLogService.visitlog(vvl, null, null, 1, 10);
		  for (VisitLog vl : vls) {  
	            System.out.println(vl.getOperTime());  
	            System.out.println(vl.getUserName());  
	            System.out.println(vl.getOperCode());  
	            System.out.println(vl.getReturnPath());  
	            System.out.println(vl.getVisitPath());
	            System.out.println(".....................");
	        }  
		
	}
}
