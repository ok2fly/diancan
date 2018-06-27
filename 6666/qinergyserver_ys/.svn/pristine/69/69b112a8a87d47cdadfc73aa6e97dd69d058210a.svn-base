/**  
 * @Title: MySessionContext.java
 * @Package com.xjtraffic.session
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dingkunjie  
 * @date 2016年1月16日 下午2:49:21
 * @version V1.0  
 */
package com.qinergy.session;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

/**
 * @Title: MySessionContext.java
 * @Package com.qinergy.session
 * @Description: TODO(用一句话描述该文件做什么)
 * @author iceX
 * @date 2016年1月16日 下午2:49:21
 * @version V1.0
 */
public class MySessionContext {
	
	private static MySessionContext instance;
	
	private HashMap<String,Object> mymap;

	private MySessionContext() {
		mymap = new HashMap<String,Object>();
	}

	public static MySessionContext getInstance() {
		if (instance == null) {
			instance = new MySessionContext();
		}
		return instance;
	}

	public synchronized void AddSession(HttpSession session) {
		if (session != null) {
			mymap.put(session.getId(), session);
		}
	}

	public synchronized void DelSession(HttpSession session) {
		if (session != null) {
			mymap.remove(session.getId());
		}
	}

	public synchronized HttpSession getSession(String session_id) {
		if (session_id == null)
			return null;
		return (HttpSession) mymap.get(session_id);
	}

}
