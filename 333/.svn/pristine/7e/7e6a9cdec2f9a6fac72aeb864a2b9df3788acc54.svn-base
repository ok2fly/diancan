package com.gcfd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcfd.model.Api;
import com.gcfd.model.Group;
import com.gcfd.service.IApiService;
import com.gcfd.util.PageBean;
import com.gcfd.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 */
@Controller
@RequestMapping("/console")
public class ApiController {
	@Resource
	private IApiService apiService;

	@RequestMapping(value = "/getApis")
	public void getApis( HttpServletResponse response, Integer page, Integer limit, String api_id ) {

		int count = apiService.getCounts();

		PageBean pageUtil = new PageBean(page,limit,count);

		List<Api> apis = apiService.getApis(pageUtil, api_id== null ? null : api_id );
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(apis);

		if( api_id== null || api_id == "" ){
			result.put("count", count );
		}else{
			result.put("count", apis.size() );
		}
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);

	}
	@RequestMapping(value = "/getApisByGroupAndAPP")
	public void getApisByGroupAndAPP( HttpServletResponse response, String group_id, String app_id ) {
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("group_id",group_id);
		param.put("app_id",app_id);
		List<Api> apis = apiService.getApisByGroupAndAPP(param);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(apis);
		
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);
		
	}
	@RequestMapping(value = "/getBackApis")
	public void getBackApis( HttpServletResponse response,Integer page, Integer limit, Group group ) {
		int count = apiService.getCounts();
		PageBean pageUtil = new PageBean(page,limit,count);
		List<Api> apis = apiService.getApis(pageUtil, group );
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(apis);
		result.put("count", apis.size() );
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);

	}

	@RequestMapping(value = "/addApi")
	public void addApp( HttpServletResponse response, Api model) {
		if( model != null ){
			JSONObject result = new JSONObject();
			try {
				apiService.addApi( model );
				result.put("msg", "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				result.put("msg", "添加失败");
			}
			ResponseUtil.write(response, result);
		}

	}
	@RequestMapping(value = "/updateApi")
	public void updateApi( HttpServletResponse response, Api model) {
		if( model != null ){
			JSONObject result = new JSONObject();
			try {

				apiService.updateApi( model );
				result.put("msg", "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				result.put("msg", "添加失败");
			}
			ResponseUtil.write(response, result);
		}

	}
	@RequestMapping(value = "/deleteApi")
	public void deleteApi( HttpServletResponse response, Long id ) {
		if( id != null && id != 0){
			JSONObject result = new JSONObject();
			try {

				apiService.deleteApiById( id );
				result.put("msg", "删除成功");
			} catch (Exception e) {
				e.printStackTrace();
				result.put("msg", "删除失败");
			}
			ResponseUtil.write(response, result);
		}

	}


}
