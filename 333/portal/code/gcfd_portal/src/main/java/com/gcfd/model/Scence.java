package com.gcfd.model;

/**
 * 场景基础表
 * @author WGX
 *
 */
public class Scence {
	/**
	 * uuid 主键
	 */
	private Long id;
	
	/**
	 * 场景ID
	 */
	private String scence_id;
	/**
	 * 场景名称
	 */
	private String scence_name;
	
	/**
	 * 场景简述
	 */
	private String scence_bref_desc;
	
	
	/**
	 * 场景描述
	 */
	private String scence_desc;
	
	/**
	 * 场景状态（正常，发布，规划，开发中，废弃）
	 * @author WGX
	 *	NORMAL,RELEASE,PLANNING,DEVELOPMENT,ABANDONED
	 */
	private String status;
	
	
	/**
	 * 版本号
	 */
	private String version;
	
	
	/**
	 * 场景图标
	 */
	private String icon;
	
	/**
	 * 场景入口地址
	 */
	private String scence_url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScence_id() {
		return scence_id;
	}

	public void setScence_id(String scence_id) {
		this.scence_id = scence_id;
	}

	public String getScence_name() {
		return scence_name;
	}

	public void setScence_name(String scence_name) {
		this.scence_name = scence_name;
	}

	public String getScence_bref_desc() {
		return scence_bref_desc;
	}

	public void setScence_bref_desc(String scence_bref_desc) {
		this.scence_bref_desc = scence_bref_desc;
	}

	public String getScence_desc() {
		return scence_desc;
	}

	public void setScence_desc(String scence_desc) {
		this.scence_desc = scence_desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getScence_url() {
		return scence_url;
	}

	public void setScence_url(String scence_url) {
		this.scence_url = scence_url;
	}

	public Scence() {
		super();
	}

	public Scence(Long id, String scence_id, String scence_name, String scence_bref_desc, String scence_desc,
			String status, String version, String icon, String scence_url) {
		super();
		this.id = id;
		this.scence_id = scence_id;
		this.scence_name = scence_name;
		this.scence_bref_desc = scence_bref_desc;
		this.scence_desc = scence_desc;
		this.status = status;
		this.version = version;
		this.icon = icon;
		this.scence_url = scence_url;
	}
	
}
