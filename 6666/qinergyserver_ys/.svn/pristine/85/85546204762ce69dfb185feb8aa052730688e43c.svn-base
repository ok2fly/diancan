/**  
* @Title: CheckLoginInterceptor.java
* @Package com.xjtraffic.interceptor
* @Description: TODO(用一句话描述该文件做什么)
* @author dingkunjie  
* @date 2016年1月27日 上午10:21:16
* @version V1.0  
*/ 
package com.qinergy.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.qinergy.util.EhcacheUtil;

/**  
 * @Title: CheckLoginInterceptor.java
 * @Package com.xjtraffic.interceptor
 * @Description: 检查是否登录拦截器
 * @author dingkunjie  
 * @date 2016年1月27日 上午10:21:16
 * @version V1.0  
 */
public class CheckLoginInterceptor implements HandlerInterceptor {

	
	//日志
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private EhcacheUtil ehcacheUtil;
	
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object obj, ModelAndView mav) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		//获取请求中的sessionId
		String sessionId = request.getParameter("sessionid");
		
		String deviceId = request.getParameter("deviceId");
		
		String deviceType = request.getParameter("deviceType");
		
		//创建json对象
		JSONObject json = new JSONObject();
		
		String desc = "用户未登录";
		
		//sessionId为null或空时 没有登录
		if (sessionId != null && !"".equals(sessionId)) {
			
			if(sessionId.equals("1111")){
				
				desc = "用户已经修改过密码,重新登录！";
				json.put("resultcode", "USR123");
				
			}else{
				
				Map<String,Object> map = (Map<String,Object>)ehcacheUtil.getCacheElement(sessionId);
				
				if (deviceType.equals("Android") || deviceType.equals("iOS")) {
					
					Object Object = map.get("mdId");
					
					if(Object != null ){
						
						if(!deviceId.equals(Object.toString())){
							
							desc = "用户已在其它设备上登录";
							json.put("resultcode", "USR124");
						} else { //缓存中的设备id和用户传过的设备id一致  验证通过
							return true;
						}
					}
				} else { //pc端登录 暂不做判断 
					return true;
				}
			}
		}else{
			
			json.put("resultcode", "USR125");
		}
		json.put("desc", desc);
		
		//设置字符编码
		response.setContentType("text/html;charset=UTF-8");
		
		//向前端返回数据
		PrintWriter writer = null; 
			
		try {
			writer = response.getWriter();
			writer.print(json);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("检查登录拦截器向前端返回数据时抛出异常：" + e.getMessage());
		}
		
		return false;
	}

}
