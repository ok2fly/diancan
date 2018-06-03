package com.gcfd.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WGX
 *
 */
public class UserStatus {
	private List<DropDownListBean> listBean = null;
	private static UserStatus instance = null;  
	private UserStatus(){
		listBean = new ArrayList<DropDownListBean>();
		listBean.add(new DropDownListBean("0","正常"));
    	listBean.add(new DropDownListBean("1","冻结"));
    	listBean.add(new DropDownListBean("2","删除"));
	}  
	public static UserStatus getInstance() {  
		if (instance == null) {  
			synchronized (UserStatus.class) {  
				if (instance == null) {
					instance = new UserStatus();  
				}  
			}  
		}  
		return instance;  
	}
	public List<DropDownListBean> getListBean() {
		return listBean;
	}
	
}
