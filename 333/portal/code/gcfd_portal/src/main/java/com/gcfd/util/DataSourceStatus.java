package com.gcfd.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WGX
 *
 */
public class DataSourceStatus {
	private List<DropDownListBean> listBean = null;
	private static DataSourceStatus instance = null;  
	private DataSourceStatus(){
		listBean = new ArrayList<DropDownListBean>();
		listBean.add(new DropDownListBean("use","use"));
    	listBean.add(new DropDownListBean("free","free"));
	}  
	public static DataSourceStatus getInstance() {  
		if (instance == null) {  
			synchronized (DataSourceStatus.class) {  
				if (instance == null) {
					instance = new DataSourceStatus();  
				}  
			}  
		}  
		return instance;  
	}
	public List<DropDownListBean> getListBean() {
		return listBean;
	}
	
}
