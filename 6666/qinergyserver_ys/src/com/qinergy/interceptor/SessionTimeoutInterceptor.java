package com.qinergy.interceptor;

import java.io.PrintWriter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qinergy.dto.common.SystemConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * spring拦截器
 * 
 * @author iceX
 * 
 */
public class SessionTimeoutInterceptor implements HandlerInterceptor {

	public String[] allowUrls;// 还没发现可以直接配置不拦截的资源，所以在代码里面来排除

	public void setAllowUrls(String[] allowUrls) {
		
		this.allowUrls = allowUrls;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2, ModelAndView arg3) throws Exception {
		
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object arg2) throws Exception {
		
		String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
		
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(true);
		
		// System.out.println(requestUrl);
		
		if (null != allowUrls && allowUrls.length >= 1){
			
			for (String url : allowUrls) {
				
				if (requestUrl.contains(url)) {
					
					return true;
				}
			}
		}
		
		Object obj = session.getAttribute(SystemConstants.SEESION_IUSER);
		
		if (obj == null || "".equals(obj.toString())) {
			
			// throw new SessionTimeoutException();// 返回到配置文件中定义的路径
			// response.sendRedirect(SystemConstants.LOGIN_URL);
			
			PrintWriter out = response.getWriter();
			
			StringBuilder builder = new StringBuilder();
			
			builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
			
			builder.append("alert(\"页面过期，请重新登录\");");
			
			builder.append("window.top.location.href=\""+ SystemConstants.LOGIN_URL + "\"");
			
			builder.append("</script>");
			
			out.print(builder.toString());
			
			out.close();

		}
		return true; // 返回true，则这个方面调用后会接着调用postHandle(), afterCompletion()
	}
}
