package com.gcfd.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gcfd.mongo.model.VisitLog;
import com.gcfd.mongo.repositories.VisitLogRepositories;
@Service("visitLogService")
public class VisitLogServiceImpl {

	@Autowired
	private VisitLogRepositories visitLogRepositories;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void saveVisitLog(VisitLog vl)
	{
		visitLogRepositories.save(vl);
	}
	
	
	public int getCount(VisitLog vl)
	{
		return (int) visitLogRepositories.count();
	}
	
	public Page<VisitLog> visitlog(VisitLog vl ,int pageno,int pagesize)
	{
		Order idOrder = new Order(Direction.DESC, "operTime");  
//        Order nameOrder = new Order(Direction.ASC,"name");  
//        Sort sort = new Sort(idOrder,nameOrder); 
        Sort sort = new Sort(idOrder); 
        
		PageRequest pageRequest  = new PageRequest(pageno, pagesize, sort);  
        
        Page<VisitLog> pagelog = visitLogRepositories.findAll(pageRequest );
		return pagelog;
	}
	/**
	 * @author liuxf
	 * @category 根据用户名、起始时间、结束时间查询登录日志总条数
	 * @param vl
	 * @param begintime
	 * @param endtime
	 * @return
	 */
	public long visitlogCount(VisitLog vl,String begintime,String endtime)
	{
		
		Query qcount = new Query();
		if(null != vl)
		{
			if(null != vl.getUserName() && vl.getUserName().trim().length() > 0)
			{
				qcount.addCriteria(Criteria.where("userName").regex(vl.getUserName()+"*"));
			}
		}
		if(null != begintime && begintime.trim().length() > 0)
		{
			
			qcount.addCriteria(Criteria.where("operTime").gte(begintime));
		}
		if(null != endtime && endtime.trim().length() > 0)
		{
			
			qcount.addCriteria(Criteria.where("operTime").lte(endtime));
		}
		return mongoTemplate.count(qcount, VisitLog.class);
	}
	public List<VisitLog> visitlog(VisitLog vl,String begintime,String endtime ,int pageno,int pagesize)
	{
		
		Query qquery = new Query();
			if(null != vl && null != vl.getUserName() && vl.getUserName().trim().length() > 0)
			{
				
				qquery.addCriteria(Criteria.where("userName").regex(vl.getUserName().trim()+"*"));
			}
			if(null != begintime && begintime.trim().length() > 0)
			{
				
				qquery.addCriteria(Criteria.where("operTime").gte(begintime));
			}
			if(null != endtime && endtime.trim().length() > 0)
			{
				
				qquery.addCriteria(Criteria.where("operTime").lte(endtime));
			}
			
			Order order = new Order(Direction.DESC,"operTime");

			qquery.with( new Sort(order));
			
			qquery.skip(( pageno-1)* pagesize).limit(pagesize);
			
			List<VisitLog> lvl = mongoTemplate.find(qquery, VisitLog.class);
			return lvl;
	}
	
}
