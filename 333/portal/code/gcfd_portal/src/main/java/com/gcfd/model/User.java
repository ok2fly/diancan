package com.gcfd.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	/**
	 * 用户名（只使用手机号登录）
	 */
	private String user_id ;
	
	/**
	 * 用户名
	 */
	private String user_name;
	/**
	 * MD5加密密码串
	 */
	private String user_pwd;
	/**
	 * 用户电话号码
	 */
	private String user_tel;
	/**
	 * 用户电子邮件地址
	 */
	private String user_email;
	
	/**
	 * 用户标示串
	 * 0正常
	 * 1冻结
	 * 2删除
	 */
	private String user_status;
//	private String user_sign;
	
	
	private Branch branch;
	
	
	private List<Group> groups;


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_pwd() {
		return user_pwd;
	}


	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}


//	public String getUser_sign() {
//		return user_sign;
//	}
//
//
//	public void setUser_sign(String user_sign) {
//		this.user_sign = user_sign;
//	}


	public List<Group> getGroups() {
		return groups;
	}


	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}



	public String getUser_tel() {
		return user_tel;
	}


	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_status() {
		return user_status;
	}


	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}


	public Branch getBranch() {
		return branch;
	}


	public void setBranch(Branch branch) {
		this.branch = branch;
	}


	public User(String user_id, String user_name, String user_pwd, String user_tel, String user_email,
			String user_status, List<Group> groups) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_tel = user_tel;
		this.user_email = user_email;
		this.user_status = user_status;
		this.groups = groups;
	}


	public User() {
		super();
		groups = new ArrayList<Group>();
		branch = new Branch();
	}
	
	
	
	
}
