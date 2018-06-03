package com.gcfd.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcfd.mongo.model.VisitLog;
import com.gcfd.mongo.repositories.VisitLogRepositories;
@Service("visitLogService")
public class VisitLogServiceImpl {

	@Autowired
	private VisitLogRepositories visitLogRepositories;
	
	public void saveVisitLog(VisitLog vl)
	{
		visitLogRepositories.save(vl);
	}
}
