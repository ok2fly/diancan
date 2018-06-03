package com.gcfd.model;

import java.util.ArrayList;
import java.util.List;

public class App {
	/**
	 * uuid 
	 */
	private Long id;
	/**
	 * 应用ID
	 */
	private String app_id;
	/**
	 * 应用名称
	 */
	private String app_name;
	/**
	 * 应用简述
	 */
	private String app_bref_desc;
	/**
	 * 应用描述
	 */
	private String app_desc;
	/**
	 * '应用状态（正常，发布，规划，开发中，废弃）'
	 * 'normal','release',' planning','development','abandoned'
	 * 1,2,3,4,5
	 * @author WGX
	 *
	 */
	private String status;
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * 应用图标
	 */
	private String icon;
	/**
	 * app入口地址
	 */
	private String app_url;

	//false表示未选中，true表示选中
	private Boolean LAY_CHECKED = false;


	/**
	 * 与用户多对多
	 */
	private List<User> users;

	/**
	 * 与数据源 多对多
	 */
	private List<DataSource> dataSources;

	private List<Group> groups;


	public App() {
		super();
		this.users = new ArrayList<User>();
		this.dataSources = new ArrayList<DataSource>();
		this.groups = new ArrayList<Group>();
	}



	public App(Long id, String app_id, String app_name, String app_bref_desc, String app_desc, String status,
			String version, String icon, String app_url, List<User> users, List<DataSource> dataSources,
			List<Group> groups) {
		this();
		this.id = id;
		this.app_id = app_id;
		this.app_name = app_name;
		this.app_bref_desc = app_bref_desc;
		this.app_desc = app_desc;
		this.status = status;
		this.version = version;
		this.icon = icon;
		this.app_url = app_url;
		this.users = users;
		this.dataSources = dataSources;
		this.groups = groups;
	}



	public Boolean getLAY_CHECKED() {
		return LAY_CHECKED;
	}



	public void setLAY_CHECKED(Boolean lAY_CHECKED) {
		LAY_CHECKED = lAY_CHECKED;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	public String getApp_bref_desc() {
		return app_bref_desc;
	}

	public void setApp_bref_desc(String app_bref_desc) {
		this.app_bref_desc = app_bref_desc;
	}

	public String getApp_desc() {
		return app_desc;
	}

	public void setApp_desc(String app_desc) {
		this.app_desc = app_desc;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getApp_url() {
		return app_url;
	}

	public void setApp_url(String app_url) {
		this.app_url = app_url;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<DataSource> getDataSources() {
		return dataSources;
	}

	public void setDataSources(List<DataSource> dataSources) {
		this.dataSources = dataSources;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LAY_CHECKED == null) ? 0 : LAY_CHECKED.hashCode());
		result = prime * result + ((app_bref_desc == null) ? 0 : app_bref_desc.hashCode());
		result = prime * result + ((app_desc == null) ? 0 : app_desc.hashCode());
		result = prime * result + ((app_id == null) ? 0 : app_id.hashCode());
		result = prime * result + ((app_name == null) ? 0 : app_name.hashCode());
		result = prime * result + ((app_url == null) ? 0 : app_url.hashCode());
		result = prime * result + ((dataSources == null) ? 0 : dataSources.hashCode());
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		App other = (App) obj;
		if (LAY_CHECKED == null) {
			if (other.LAY_CHECKED != null)
				return false;
		} else if (!LAY_CHECKED.equals(other.LAY_CHECKED))
			return false;
		if (app_bref_desc == null) {
			if (other.app_bref_desc != null)
				return false;
		} else if (!app_bref_desc.equals(other.app_bref_desc))
			return false;
		if (app_desc == null) {
			if (other.app_desc != null)
				return false;
		} else if (!app_desc.equals(other.app_desc))
			return false;
		if (app_id == null) {
			if (other.app_id != null)
				return false;
		} else if (!app_id.equals(other.app_id))
			return false;
		if (app_name == null) {
			if (other.app_name != null)
				return false;
		} else if (!app_name.equals(other.app_name))
			return false;
		if (app_url == null) {
			if (other.app_url != null)
				return false;
		} else if (!app_url.equals(other.app_url))
			return false;
		if (dataSources == null) {
			if (other.dataSources != null)
				return false;
		} else if (!dataSources.equals(other.dataSources))
			return false;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	
}
