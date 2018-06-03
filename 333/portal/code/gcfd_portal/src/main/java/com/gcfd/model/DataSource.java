package com.gcfd.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据源基础表
 * @author WGX
 *
 */
public class DataSource {
	/**
	 * 数据源ID
	 */
	private Long data_source_id;
	/**
	 * 数据源url
	 */
	private String data_source_url;
	/**
	 * 数据源用户名
	 */
	private String data_source_user_name;
	/**
	 * 数据源密码
	 */
	private String data_source_user_pwd;
	/**
	 * 数据源描述
	 */
	private String data_source_desc;
	/**
	 * 数据源状态
	 * USE,FREE
	 * @author WGX
	 *
	 */
	private String data_source_status;
	
	/**
	 * 与用户多对多
	 */
	private List<User> users;

	/**
	 * 与app多对多
	 */
	private List<App> apps;
	
	private Branch branch;
	
	public DataSource() {
		super();
		this.users = new ArrayList<User>();
		this.apps = new ArrayList<App>();
		this.branch = new Branch();
	}

	public DataSource(Long data_source_id, String data_source_url, String data_source_user_name,
			String data_source_user_pwd, String data_source_desc) {
		this();
		this.data_source_id = data_source_id;
		this.data_source_url = data_source_url;
		this.data_source_user_name = data_source_user_name;
		this.data_source_user_pwd = data_source_user_pwd;
		this.data_source_desc = data_source_desc;
	}

	public Long getData_source_id() {
		return data_source_id;
	}

	public void setData_source_id(Long data_source_id) {
		this.data_source_id = data_source_id;
	}

	public String getData_source_url() {
		return data_source_url;
	}

	public void setData_source_url(String data_source_url) {
		this.data_source_url = data_source_url;
	}

	public String getData_source_user_name() {
		return data_source_user_name;
	}

	public void setData_source_user_name(String data_source_user_name) {
		this.data_source_user_name = data_source_user_name;
	}

	public String getData_source_user_pwd() {
		return data_source_user_pwd;
	}

	public void setData_source_user_pwd(String data_source_user_pwd) {
		this.data_source_user_pwd = data_source_user_pwd;
	}

	public String getData_source_desc() {
		return data_source_desc;
	}

	public void setData_source_desc(String data_source_desc) {
		this.data_source_desc = data_source_desc;
	}

	public String getData_source_status() {
		return data_source_status;
	}

	public void setData_source_status(String data_source_status) {
		this.data_source_status = data_source_status;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<App> getApps() {
		return apps;
	}

	public void setApps(List<App> apps) {
		this.apps = apps;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
