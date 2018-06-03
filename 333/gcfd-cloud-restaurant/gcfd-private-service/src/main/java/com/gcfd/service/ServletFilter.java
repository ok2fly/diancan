package com.gcfd.service;

import com.alibaba.fastjson.JSON;
import com.gcfd.common.Constant;
import com.gcfd.common.DataCenter;
import com.gcfd.common.EnumNetCode;
import com.gcfd.common.util.JedisUtil;
import com.gcfd.common.util.TokenUtil;
import com.gcfd.common.util.webUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
* @类名：jerseyFilter.java
* @作者：one
* @时间：2016年6月19日 上午10:48:05
* @版权：pengkaione@icloud.com
* @描述： 
*/
public class ServletFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(ServletFilter.class);
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		// TODO Auto-generated method stub
		logger.info(" -------------welcome-----jerseyFilter------------");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setCharacterEncoding("UTF-8");
		//开发模式--无限跨域
		httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.addHeader("Access-Control-Allow-Methods", "post,get,options");
		httpServletResponse.addHeader("Access-Control-Allow-Headers","Token, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

		long b = System.currentTimeMillis();
		//SSL  过滤   ssl 的请求访问，由nginx 服务来保证绝对的ssl ,此处ssl 检查代码去除
    	//接口访问过滤 //URL
        String path = httpServletRequest.getRequestURI();

        try{

	        //统一过滤方法
			if(!Interface(httpServletRequest,httpServletResponse,path)){
				printERROR(httpServletResponse);
				return;
			}
			chain.doFilter(httpServletRequest, httpServletResponse);
		    long e = System.currentTimeMillis();
		    logger.info("网络请求:【{}】 接口耗时:【{}】  ------------------------------",path,e - b);
		}catch(Exception e){
			 logger.error("网络请求:【{}】 异常  ------------------------------",path);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * 接口在案判断
	 * @param response
	 * @param path
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private boolean Interface(HttpServletRequest request,HttpServletResponse response,String path) throws ServletException, IOException{
		String token = request.getHeader("accessToken");
		if("noAuth".equals(token)){
			System.out.println("no Auth");
			return true;
		}
		return isAccessTokenAccept(request,response,token);
	}

	/**
	 * 服务权限校验
	 * @param request
	 * @param response
	 * @param token
	 * @return
	 */
	private boolean isAccessTokenAccept(HttpServletRequest request,HttpServletResponse response,String token){
		//通过微信的验证机制accessToken验证是否可被调用
		System.out.println("Auth");
		return true;
	}

	/**
	 * 网络异常反馈
	 * @param response
	 * @throws IOException
	 */
	public static void printERROR(HttpServletResponse response) throws IOException{
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pr = response.getWriter();
		response.setContentType("");
		DataCenter<Object> rt = new DataCenter<Object>();
		rt.setNetCode(EnumNetCode.C2003);
		pr.write(JSON.toJSONString(rt));
	}
}
