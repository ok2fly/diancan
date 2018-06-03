package com.gcfd.util;
/**
 * 下拉列表
 * @author WGX
 *
 */
public class DropDownListBean {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DropDownListBean(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public DropDownListBean() {
		super();
	}
	
}
