package com.gcfd.common.util;

import com.alibaba.fastjson.JSON;
import com.gcfd.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
* @类名：sessionUitl.java
* @作者：one
* @时间：2016年7月16日 下午12:46:59
* @版权：pengkaione@icloud.com
* @描述： 
*/
public class SessionUitl {
	private static final Logger logger = LoggerFactory.getLogger(SessionUitl.class);
 	/**
 	 * 存入 session 信息
 	 * @param token
 	 * @param object
 	 * @return 0 失败  1 成功
 	 */
 	public static int setLoginUser(String token,Object object){
 		try(Jedis Jedis = JedisUtil.getJedisConnection(Constant.SESSION_DB)){
 			Jedis.set(token, JSON.toJSONString(object) ,"nx", "ex",Constant.SESSION_TIME);
 			Jedis.expire(token, Constant.SESSION_TIME);
 			return 1;
 		}catch(Exception e){
			logger.error("JedisUtil ------  getObject(String key,Class<T> clazz)------ 异常："+e.getMessage());
		}
		return 0;
 	}
 	
 	/**
 	 * @description 更新redis用户
 	 * @author  王童博
 	 * @date 2016年8月18日上午11:40:24
 	 * @version 1.0
 	 * @param token
 	 * @param object
 	 * @return
 	 */
 	public static int updateLoginUser(String token,Object object){
 		try(Jedis Jedis = JedisUtil.getJedisConnection(Constant.SESSION_DB)){
 			Jedis.set(token, JSON.toJSONString(object) ,"xx", "ex", Constant.SESSION_TIME);
 			Jedis.expire(token, Constant.SESSION_TIME);
 			return 1;
 		}catch(Exception e){
			logger.error("JedisUtil ------  getObject(String key,Class<T> clazz)------ 异常："+e.getMessage());
		}
		return 0;
 	}
 	/**
 	 * 登出 session 信息
 	 * @param token
 	 * @return 0 失败  1 成功
 	 */
 	public static int loginOut(String token){
 		try(Jedis Jedis = JedisUtil.getJedisConnection(Constant.SESSION_DB)){
 			Jedis.del(token);
 			return 1;
 		}catch(Exception e){
			logger.error("JedisUtil ------  loginOut(String token) ------ 异常："+e.getMessage());
		}
		return 0;
 	}

}
