package com.gcfd.consumer;

import com.alibaba.fastjson.JSON;
import com.gcfd.common.DataCenter;
import com.gcfd.common.EnumNetCode;
import com.gcfd.common.util.JedisUtil;
import com.gcfd.common.util.TokenUtil;
import com.gcfd.common.util.webUtil;
import com.gcfd.storage.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
* @类名：ServletFilter.java
* @作者：one
* @时间：2018年05月12日18:06:10
* @版权：pengkaione@icloud.com
* @描述： 
*/
public class ServletFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(ServletFilter.class);

	@Value("${app.index.html.url}")
	private String appIndexHtmlUrl;

	@Value("${app.token.name}")
	private String appTokenName;

	@Value("${app.session.time}")
	private int sessionTime;

	@Value("${service.api.noauth.keyname}")
	private String noAhthApikeyName;

	//以5分钟为单位更新无需验证API 列表，减少对redis 的频繁查询，如果业务中需要及时性，可去除
	private static long noAuthApiCacheTime = 0L;
	private static List<String> noAuthApiCache = new ArrayList<String>();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setCharacterEncoding("UTF-8");
		long b = System.currentTimeMillis();
		boolean check = false;
		/**
		 * 作者 ONE
		 * 由于 nginx 做 ssl 不再使用代码做SSL
		 * 标注时间  2018年05月12日17:16:14
		 */

		/**
		 * 安全域名、IP 验证设定（跨域）
		 */
		corsOrigin(httpServletRequest, httpServletResponse);

		String path = httpServletRequest.getRequestURI();
        try{

			if( interfaceNoAuth(httpServletRequest,httpServletResponse)) {
				check = true;
			}

			if(! check) {
				String token = httpServletRequest.getHeader(appTokenName);
				SysUser user = userLogin(httpServletRequest, httpServletResponse, token);

				if (user != null) {
					if (!interfaceAuth(httpServletRequest, httpServletResponse, user)) {
						printERROR(httpServletResponse);
						return;
					}
				}
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
	 * 暂时只做简单的资源跨域实现
	 * <br><br>
	 * 目前业务暂时没有 角色、用户、get、post等 各种其他维度的跨域实现需求
	 * @param request
	 * @param response
	 */
	private void corsOrigin(HttpServletRequest request, HttpServletResponse response){

		/**
		 * 作者 ONE
		 * 开发模式先设置为无限跨域
		 *
		 * 由于当前设计缺失并无安全域名、IP相关配置 -- 暂时设定为无限跨域
		 *
		 * 缺省为全跨域
		 *
		 *  标注时间  2018年05月12日18:15:48
		 */
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "post,get,options");
		response.addHeader("Access-Control-Allow-Headers","Token, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

	}

	/**
	 * noAuth接口 验证
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	private boolean interfaceNoAuth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		/**
		 * 作者 ONE
		 *
		 * 此处需要系统初始化时对API表，根据登录以及URL规则，定义出标准的API 数据格式（redis 无需权限验证的API 缓存）
		 *
		 * 同时此处需要根据设置加载 安全域名、安全IP 做跨域允许 （redis 缓存）
		 *
		 * 目前设计缺失
		 *
		 *
		 * 当前缺失实现为： noAuthAPI 数据结构为redis List
		 *
		 * 标注时间 2018年05月12日17:05:59
		 */
		String path = request.getRequestURI();

		if (noAuthApiCacheTime > 0  && System.currentTimeMillis() - noAuthApiCacheTime > 5 * 1000 * 60) {
			try(Jedis jedis = JedisUtil.getJedisConnection(0)) {
				//int noAuthSize = Math.toIntExact(jedis.llen(noAhthApikeyName));
				/**
				 * 缺省取100万个元素，实际应用中理应不会出现100万个无需验证的API
				 */
				noAuthApiCache = jedis.lrange(noAhthApikeyName, 0, 1000000);
			}
		}
		/**
		 * 此处基于当前有URL传参，无法做强制校验，只能做模糊校验
		 *
		 * 具体实现过程要注意一个接口地址的设定导致全部接口都有权限
		 */
		for (String api : noAuthApiCache) {
			if(api.indexOf(path) > 0)
				return true;
		}

		return false;
	}


	/**
	 * 接口权限验证<br>
	 *<br>
	 * 缺省实现为及时性验证，无缓存机制，每次都查询redis <br>
	 * 如果业务上对接口的权限变动性不大，则可根据noAuth 改造优化
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private boolean interfaceAuth(HttpServletRequest request, HttpServletResponse response, SysUser user) throws ServletException, IOException{

		/**
		 * 作者 ONE
		 *
		 * 此处需要系统初始化时对API表，根据登录以及URL规则，定义出标准的API 数据格式，用来做 角色 到 API 的权限判断 （redis 缓存）
		 *
		 * 同时此处需要根据设置加载 安全域名、安全IP 做跨域允许 （redis 缓存）
		 *
		 * 目前设计缺失
		 *
		 *
		 * 缺省实现为  角色ID+用户ID+接口地址(大写) ---- 此实现需要确定URL传参时如何避开无法校验问题
		 *
		 * 标注时间 2018年05月12日17:05:59
		 */
		String userId = user.getUserId();
		String roleId = "";  // user.getroleId();  此处设计缺失 登录部分
		String path = request.getRequestURI().toUpperCase();

		try(Jedis jedis = JedisUtil.getJedisConnection(sessionTime)) {
			String value = jedis.get(userId + roleId + path);

			if(value!= null && !"".equals(value))
				return true;
		}

 		return false;
	}
	
	/**
	 * 非自动过滤类接口
	 * @param request
	 * @param response
	 * @param token
	 * @return SysUser
	 * @throws IOException
	 * @throws ServletException
	 * @throws Exception
	 */
	private SysUser userLogin(HttpServletRequest request,HttpServletResponse response,String token) throws ServletException, IOException{
   		if(token==null||"".equals(token)||"null".equals(token)) {
			//token 为空直接回首页
			response.setHeader("REDIRECTURL", appIndexHtmlUrl);
			return null;

    	} else {
    		logger.debug(" 来自IP: 【{}】  请求 token: 【{}】 ------------------------------", webUtil.getIpAddr(request),token);

			/**
			 * 作者 ONE
			 * 此处需要修改为登录Token算法解密
			 * 用来对应计算是否为合法Token 作为一级过滤
			 *
			 * 默认实现为原在东软写的算法
			 *
			 * 标注时间 2018年05月12日17:05:11
			 */
			String tokenT = TokenUtil.decryptToken(token);
    		if(!"-1".equals(tokenT) && !"0".equals(tokenT)){
    			SysUser user = null;

				try(Jedis jedis = JedisUtil.getJedisConnection(sessionTime)){
    				String userStr = jedis.get(tokenT);
					user = JSON.parseObject(userStr,SysUser.class);

    				if(user!=null){
    					jedis.expire(tokenT, sessionTime);
    					request.setAttribute("_sysUser", user);
    					//定义新的token
    					response.setHeader(appTokenName, TokenUtil.getToken(tokenT, sessionTime));
    				}else {
    					//token为有效但是，无登录信息
    					response.setHeader("REDIRECTURL", appIndexHtmlUrl);
    					logger.debug(" 来自IP: 【{}】    异常提示：【{}】 ------------------------------", webUtil.getIpAddr(request),"无登录信息在 redis");
    					return null;
    				}
    			}catch (Exception e) {
    				printERROR(response);
    			}
    			return user;
    		}else{
    			//token无效
    			response.setHeader("REDIRECTURL", appIndexHtmlUrl);
				logger.debug(" 来自IP: 【{}】    异常提示：【{}】 ------------------------------", webUtil.getIpAddr(request),"Token  无效");
				return null;
    		}
    	}
	}

	/**
	 * 网络异常反馈
	 * @param response
	 * @throws IOException
	 */
	private void printERROR(HttpServletResponse response) throws IOException{
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pr = response.getWriter();
		response.setContentType("");
		DataCenter<Object> rt = new DataCenter<Object>();
		rt.setNetCode(EnumNetCode.C2003);
		pr.write(JSON.toJSONString(rt));
	}
}
