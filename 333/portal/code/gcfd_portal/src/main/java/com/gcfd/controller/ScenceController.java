package com.gcfd.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcfd.model.App;
import com.gcfd.model.Scence;
import com.gcfd.service.ScenceService;
import com.gcfd.util.PageBean;
import com.gcfd.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping( value="/console")
public class ScenceController {
	
	@Autowired
	private ScenceService scenceService;

	@RequestMapping(value = "/getScences")
	public void getScences(HttpServletResponse response,Integer page, Integer limit, String scence_name){
		//查询总条数
		int count = scenceService.getCounts();

		PageBean pageUtil = new PageBean(page,limit,count);

		List<Scence> scences = scenceService.getScences(pageUtil, scence_name == null? null : scence_name );
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(scences);
		if( scence_name== null || scence_name == "" ){
			result.put("count", count );
		}else{
			result.put("count", scences.size() );
		}
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);
	}
	
	@RequestMapping( value="deleteScence" )
	public void deleteScence( HttpServletResponse response, Long id ){
		if( id != null && id != 0){
    		JSONObject result = new JSONObject();
    		try {
    			scenceService.delete( id );
    			result.put("msg", "成功");
    		} catch (Exception e) {
    			e.printStackTrace();
    			result.put("msg", "失败");
    		}
    		ResponseUtil.write(response, result);
    	}
	}
	
	@RequestMapping(value = "/updateScence")
    public void updateApp( HttpServletResponse response, Scence model) {
    	if( model != null ){
    		JSONObject result = new JSONObject();
    		try {
    			
    			scenceService.update( model );
    			result.put("msg", "成功");
    		} catch (Exception e) {
    			e.printStackTrace();
    			result.put("msg", "失败");
    		}
    		ResponseUtil.write(response, result);
    	}
    	
    }
	
	@RequestMapping(value = "/addScence")
    public void addApp( HttpServletResponse response, Scence model) {
    	if( model != null ){
    		JSONObject result = new JSONObject();
    		try {
    			scenceService.add( model );
				result.put("msg", "成功");
			} catch (Exception e) {
				e.printStackTrace();
				result.put("msg", "失败");
			}
    		ResponseUtil.write(response, result);
    	}
        
    }
}
