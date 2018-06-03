package com.gcfd.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限组表
 * @author WGX
 *
 */
public class Group {
	/**
	 * 组ID
	 */
	private Long group_id;
	/**
	 * 组名称
	 */
	private String group_name;
	
	/**
	 * 与用户 多对多
	 */
	private List<User> users;
	
	private List<App> apps;
	//false表示未选中，true表示选中
	private Boolean LAY_CHECKED = false;
	
	//复选框是否可用
	private Boolean DISABLED = false; 

	public Group() {
		super();
		this.users = new ArrayList<User>();
		this.apps = new ArrayList<App>();
		
	}

	public Group(String group_name) {
		this();
		this.group_name = group_name;
	}


	public Long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
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

	public Boolean getLAY_CHECKED() {
		return LAY_CHECKED;
	}

	public void setLAY_CHECKED(Boolean lAY_CHECKED) {
		LAY_CHECKED = lAY_CHECKED;
	}

	public Boolean getDISABLED() {
		return DISABLED;
	}

	public void setDISABLED(Boolean dISABLED) {
		DISABLED = dISABLED;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DISABLED == null) ? 0 : DISABLED.hashCode());
		result = prime * result + ((LAY_CHECKED == null) ? 0 : LAY_CHECKED.hashCode());
		result = prime * result + ((apps == null) ? 0 : apps.hashCode());
		result = prime * result + ((group_id == null) ? 0 : group_id.hashCode());
		result = prime * result + ((group_name == null) ? 0 : group_name.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Group other = (Group) obj;
		if (DISABLED == null) {
			if (other.DISABLED != null)
				return false;
		} else if (!DISABLED.equals(other.DISABLED))
			return false;
		if (LAY_CHECKED == null) {
			if (other.LAY_CHECKED != null)
				return false;
		} else if (!LAY_CHECKED.equals(other.LAY_CHECKED))
			return false;
		if (apps == null) {
			if (other.apps != null)
				return false;
		} else if (!apps.equals(other.apps))
			return false;
		if (group_id == null) {
			if (other.group_id != null)
				return false;
		} else if (!group_id.equals(other.group_id))
			return false;
		if (group_name == null) {
			if (other.group_name != null)
				return false;
		} else if (!group_name.equals(other.group_name))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

}
