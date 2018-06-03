package com.gcfd.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 'normal','release',' planning','development','abandoned'
 * @author WGX
 *
 */
public class Status {
	/*private String normal;
	private String release;
	private String planning;
	private String development;
	private String abandoned;*/
	private List<DropDownListBean> listBean = null;
	private static Status instance = null;  
	private Status(){
		listBean = new ArrayList<DropDownListBean>();
		listBean.add(new DropDownListBean("normal","normal"));
		listBean.add(new DropDownListBean("release","release"));
		listBean.add(new DropDownListBean("planning","planning"));
		listBean.add(new DropDownListBean("development","development"));
		listBean.add(new DropDownListBean("abandoned","abandoned"));
	}  
	public static Status getInstance() {  
		if (instance == null) {  
			synchronized (Status.class) {  
				if (instance == null) {
					instance = new Status();  
				}  
			}  
		}  
		return instance;  
	}
	public List<DropDownListBean> getListBean() {
		return listBean;
	}
	
}
