//@formatter:off
/* ========================================== */
/*     Copyright(c) 2016 BYRT Corporation.    */
/*            All rights reserved.            */
/*               BYRT CONFIDENTIAL            */
/* ========================================== */
//@formatter:on
package com.qinergy.dto.system;

import java.io.Serializable;

/**
 * 用户数据-模块信息
 * <p>
 * This contains the following attributes:<br/>
 * <p>
 * 
 * 
 * @author iceX
 * @version 1.0
 * @since 1.0
 */

public class UserModuleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8532747096683514978L;
	/**
	 * 序号
	 */
	private int id;
	/**
	 * 模块名称
	 */
	private String module_name;
	/**
	 * 模块代码
	 */
	private String module_code;
	/**
	 * 父菜单
	 */
	private int module_father;
	/**
	 * 模块级别
	 */
	private int module_level;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * Gets the value of the <code>id</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>id</code> property.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Sets the value of the <code>id</code> property.
	 * <p>
	 *
	 * @param <code>id</code>
	 *        Holds the new value of the <code>id</code> property.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Gets the value of the <code>module_name</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>module_name</code> property.
	 */
	public String getModule_name() {
		return module_name;
	}
	/**
	 * Sets the value of the <code>module_name</code> property.
	 * <p>
	 *
	 * @param <code>module_name</code>
	 *        Holds the new value of the <code>module_name</code> property.
	 */
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	/**
	 * Gets the value of the <code>module_code</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>module_code</code> property.
	 */
	public String getModule_code() {
		return module_code;
	}
	/**
	 * Sets the value of the <code>module_code</code> property.
	 * <p>
	 *
	 * @param <code>module_code</code>
	 *        Holds the new value of the <code>module_code</code> property.
	 */
	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}
	/**
	 * Gets the value of the <code>module_father</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>module_father</code> property.
	 */
	public int getModule_father() {
		return module_father;
	}
	/**
	 * Sets the value of the <code>module_father</code> property.
	 * <p>
	 *
	 * @param <code>module_father</code>
	 *        Holds the new value of the <code>module_father</code> property.
	 */
	public void setModule_father(int module_father) {
		this.module_father = module_father;
	}
	/**
	 * Gets the value of the <code>module_level</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>module_level</code> property.
	 */
	public int getModule_level() {
		return module_level;
	}
	/**
	 * Sets the value of the <code>module_level</code> property.
	 * <p>
	 *
	 * @param <code>module_level</code>
	 *        Holds the new value of the <code>module_level</code> property.
	 */
	public void setModule_level(int module_level) {
		this.module_level = module_level;
	}
	/**
	 * Gets the value of the <code>description</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>description</code> property.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the value of the <code>description</code> property.
	 * <p>
	 * 
	 * @param <code>description</code> Holds the new value of the
	 *        <code>description</code> property.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
