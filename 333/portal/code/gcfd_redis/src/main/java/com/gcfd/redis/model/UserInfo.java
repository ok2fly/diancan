package com.gcfd.redis.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 21L;

	private Long lastusetime;
	private String token;
	private String userName;
	private String userId;
	private List userRight;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List getUserRight() {
		return userRight;
	}
	public void setUserRight(List userRight) {
		this.userRight = userRight;
	}
	public Long getLastusetime() {
		return lastusetime;
	}
	public void setLastusetime(Long lastusetime) {
		this.lastusetime = lastusetime;
	}
	
	
}
