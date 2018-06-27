package com.acl.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* @ClassName: SystemInterceptor
* @Description: 拦截器
* @author malx
*
 */									
public class SystemInterceptor extends HandlerInterceptorAdapter {

/*	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {  
        //得到访问地址  
        HttpSession session = request.getSession(false);
        
		if(session!=null){
			
			return true;
			
		}else{
			
//			response.sendRedirect(request.getContextPath());
			
//			return false;
			return true;
		}
    }  
*/
}
