package com.qinergy.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.qinergy.util.EhcacheUtil;

public class BaseController {

	@Autowired
	private EhcacheUtil ehcacheUtil;
	
	
	//获取 缓存中登录用户信息
	protected Map<String, Object> getSessionUser(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		HashMap<String, Object> userMap = (HashMap<String, Object>) (session.getAttribute("user"));
		
		if(userMap != null && !userMap.isEmpty()){
			return userMap;
		}else{
			//TODO sessionUser失效，拦截处理
			
			return null;
		}
	}
	
	/**获取 session 用户id*/
	protected int getCurrentUserId(HttpServletRequest request){
		Integer userId = 0;
		Map<String, Object> sessionUser = getSessionUser(request);
		if(sessionUser != null){
			userId = (Integer)sessionUser.get("id");
		} 
		return userId;
	}
	
	protected Map<String,Object> getEhcacheInfo(HttpServletRequest request) throws Exception{
		
		//获取请求中的sessionId
		String sessionId = request.getParameter("sessionid");
		
		Map<String,Object> map = (Map<String,Object>)ehcacheUtil.getCacheElement(sessionId);
		
		return map;
	}
	
		
		
	
	
	
}
