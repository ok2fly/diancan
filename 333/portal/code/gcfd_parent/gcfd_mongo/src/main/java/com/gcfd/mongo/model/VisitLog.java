package com.gcfd.mongo.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="visitlog")
public class VisitLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;
	
	@Id
	private String id;
	@Indexed
	private String userId;
	@Field
	private String userName;
	@Field
	private String operCode;
	
	@Field
	private String operTime;
	@Field
	private String visitPath;
	@Field
	private String returnPath;

	@Field
	private List<?> list;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

	public String getOperTime() {
		return operTime;
	}

	public void setOperTime(String operTime) {
		if(null == operTime || operTime.trim().length() == 0)
		{
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
			this.operTime = sdf.format(now);
		}
		else
		{
			this.operTime = operTime;
		}
	}

	public String getVisitPath() {
		return visitPath;
	}

	public void setVisitPath(String visitPath) {
		this.visitPath = visitPath;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getReturnPath() {
		return returnPath;
	}

	public void setReturnPath(String returnPath) {
		this.returnPath = returnPath;
	}
	
	
}
