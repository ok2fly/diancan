package com.gcfd.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 'normal','release',' planning','development','abandoned'
 * @author WGX
 *
 */
public class Method {
	private List<DropDownListBean> listBean = null;
	private static Method instance = null;  
	private Method(){
		listBean = new ArrayList<DropDownListBean>();
		listBean.add(new DropDownListBean("get","get"));
    	listBean.add(new DropDownListBean("post","post"));
	}  
	public static Method getInstance() {  
		if (instance == null) {  
			synchronized (Method.class) {  
				if (instance == null) {
					instance = new Method();  
				}  
			}  
		}  
		return instance;  
	}
	public List<DropDownListBean> getListBean() {
		return listBean;
	}
	
}
