package com.gcfd.common.util;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @类名：SpringContextUtil.java
 * @作者：one
 * @时间：2016年4月2日 下午3:00:52
 * @版权：pengkaione@icloud.com
 * @描述： 
 */
public class SpringContextUtil{ 

	private static WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
	  /**
		  * 获取注入bean 
		  * @param id
		  * @return
		  */
		public static Object getBean(String id) {
			try {
				return applicationContext.getBean(id);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return null;
		}
	}