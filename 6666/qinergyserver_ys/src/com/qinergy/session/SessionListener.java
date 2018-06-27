/**  
 * @Title: SessionListener.java
 * @Package com.xjtraffic.session
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dingkunjie  
 * @date 2016年1月16日 下午2:51:24
 * @version V1.0  
 */
package com.qinergy.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Title: SessionListener.java
 * @Package com.qinergy.session
 * @Description: TODO(用一句话描述该文件做什么)
 * @author iceX
 * @date 2016年1月16日 下午2:51:24
 * @version V1.0
 */
public class SessionListener implements HttpSessionListener {
	public static Map<String,Object> userMap = new HashMap<String,Object>();
	private MySessionContext myc = MySessionContext.getInstance();

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		myc.AddSession(httpSessionEvent.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		HttpSession session = httpSessionEvent.getSession();
		myc.DelSession(session);
	}
}
