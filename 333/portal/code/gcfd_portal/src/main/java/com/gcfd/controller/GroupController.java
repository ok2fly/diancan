package com.gcfd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcfd.model.Group;
import com.gcfd.model.User;
import com.gcfd.service.IGroupService;
import com.gcfd.util.PageBean;
import com.gcfd.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 */
@Controller
@RequestMapping("/console")
public class GroupController {
	@Resource
	private IGroupService groupService;


	@RequestMapping(value = "/getGroups")
	public void getGroups( HttpServletResponse response,Integer page, Integer limit, String group_name ) {

		//查询总条数
		int count = groupService.getCounts( null );

		PageBean pageUtil = new PageBean(page,limit,count);

		List<Group> groups = groupService.getGroups(pageUtil, group_name);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(groups);
		if( group_name== null || group_name == "" ){
			result.put("count", count );
		}else{
			result.put("count", groups.size() );
		}
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);

	}
	
	/**
	 * 用于组授权，根据userid查询出当前id已经授权的组
	 * @param response
	 * @param page
	 * @param limit
	 * @param user_id
	 */
	@RequestMapping(value = "/getGroupUser")
	public void getGroupUser( HttpServletResponse response, User user ) {
		List<Group> groups = groupService.getGroups(user);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(groups);
		result.put("count", groups.size() );
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);

	}
	
	
	

	@RequestMapping( value = "/getGroupRel")
	public void GetGroupRel( HttpServletResponse response,Integer page, Integer limit, Group group ){
		//查询总条数
		int count = groupService.getCounts( null );

		PageBean pageUtil = new PageBean(page,limit,count);

		List<Group> groups = groupService.getGroups(pageUtil, group );
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(groups);
		result.put("count", count );
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);
	}
	@RequestMapping( value = "/groupRel")
	public void GetGroupRel( HttpServletResponse response,String param ){
		//查询总条数
		
		JSONArray json=JSONArray.fromObject(param);

		Map<String,Object> map = null;
		for(int i=0;i<json.size();i++){
			map = new HashMap<String,Object>();
			JSONObject jsonOne = json.getJSONObject(i); 
			map.put("group_id", jsonOne.get("group_id"));
			map.put("groupids", jsonOne.get("groupids"));
		}

		JSONObject result = new JSONObject();
		String msg = null;
		try {
			groupService.addGroupRel(map);
			msg="成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg="失败";
		}
		result.put("msg", msg );
		ResponseUtil.write(response, result);
	}


	@RequestMapping(value = "/addGroup", method = RequestMethod.POST)
	public void add( HttpServletResponse response, Group model) {

		JSONObject result = new JSONObject();
		String msg = null;
		try {
			groupService.addGroup(model);
			msg="添加成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg="添加失败";
		}
		result.put("msg", msg );
		ResponseUtil.write(response, result);

	}

	@RequestMapping(value = "/updateGroup", method = RequestMethod.POST)
	public void update( HttpServletResponse response, Group model) {

		JSONObject result = new JSONObject();
		String msg = null;
		try {
			groupService.updateGroup(model);
			msg="更新成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg="更新失败";
		}
		result.put("msg", msg );
		ResponseUtil.write(response, result);

	}
	@RequestMapping(value = "/deleteGroup", method = RequestMethod.POST)
	public void delete( HttpServletResponse response, String group_id ) {

		JSONObject result = new JSONObject();
		String msg = null;
		try {
			Long id = Long.parseLong(group_id);
//			groupService.deleteGroupById( id );
			Map<String,Long> param = new HashMap<String,Long>();
			param.put("group_id", id);
			groupService.deleteGroupAndRelateById( param );
			msg="删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg="删除失败";
		}
		result.put("msg", msg );
		ResponseUtil.write(response, result);

	}
	@RequestMapping(value = "/onlyByGroupName", method = RequestMethod.POST)
	public void onlyByGroupName( HttpServletResponse response, String group_name ) {

		JSONObject result = new JSONObject();
		String msg = null;
		Group group = groupService.onlyByGroupName(group_name);
		if( group== null ){

			msg="yes";
		}else{

			msg="no";
		}
		result.put("msg", msg );
		ResponseUtil.write(response, result);

	}
	@RequestMapping(value = "/groupAuth", method = RequestMethod.POST)
	public void groupAuth( HttpServletResponse response, String param ) {
		
		JSONArray json=JSONArray.fromObject(param);

		Map<String,Object> map = null;
		for(int i=0;i<json.size();i++){
			map = new HashMap<String,Object>();
			JSONObject jsonOne = json.getJSONObject(i); 
			map.put("group_id",jsonOne.get("group_id"));
			map.put("appId", String.valueOf( jsonOne.get("appId")));
			map.put("apiIds", jsonOne.get("apiIds"));
		}

		JSONObject result = new JSONObject();
		String msg = null;
		try {
			groupService.groupAuth(map);
			msg="成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg="失败";
		}
		result.put("msg", msg );
		ResponseUtil.write(response, result);
		
	}
	
	
	
	
}
