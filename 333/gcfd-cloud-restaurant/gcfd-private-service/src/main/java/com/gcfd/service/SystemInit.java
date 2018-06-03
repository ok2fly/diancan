package com.gcfd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
* @类名：SystemInit.java
* @作者：one
* @时间：2016年07月13日13:58:30
* @版权：pengkaione@icloud.com
* @描述： 
*/
public class SystemInit implements ServletContextListener{

	private static final Logger logger = LoggerFactory.getLogger(SystemInit.class);

	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.debug("-----------------系统关闭！---------------------");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("----------------- 系统启动成功！---------------------");
		logger.info("----------------- 重新装载 redis 缓存！---------------------");
//		SystemInitCache systemInitCache = SystemInitCache.getInstance();
//		systemInitCache.cacheInit();

	}
}