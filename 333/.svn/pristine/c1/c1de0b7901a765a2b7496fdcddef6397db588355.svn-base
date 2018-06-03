package com.gcfd.mongo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcfd.mongo.model.VisitLog;
import com.gcfd.mongo.service.VisitLogServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/mongo")
public class VisitLogController {
	@Autowired
	@Qualifier("visitLogService")
	private VisitLogServiceImpl visitLogService;
	
	@RequestMapping(value = "/loginlog")
	@ResponseBody
	public String loginLog( Integer page, Integer limit, String user_name ,String begintime,String endtime) {
		
		VisitLog tmpvl = new VisitLog();
		tmpvl.setUserName(user_name);
		if(null == page || page < 1)
			page =1;
		if(null == limit || limit < 1)
			limit =10;
		//查询总条数
		long count = visitLogService.visitlogCount(tmpvl , begintime, endtime);
		List<VisitLog> vls  = visitLogService.visitlog(tmpvl , begintime, endtime,page,limit);

		Map<String,Object > map = new HashMap<String,Object>();
		map.put("count", count );
		map.put("code", 0 );
		map.put("msg", null );
		map.put("data", vls);
//		return jsonArray.toString();
		return JSONObject.fromObject(map).toString();
	}

}
