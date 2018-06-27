/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.dto.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户数据-用戶信息
 * <p>
 * This contains the following attributes:<br/>
 * <p>
 * 
 * 
 * @author iceX
 * @version 1.0
 * @since 1.0
 */

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8532747096683514977L;
	/**
	 * 序号
	 */
	private int id;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 登录名
	 */
	private String login_name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 姓名
	 */
	private String rea_nam;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 是否审批(0:驳回,1:批准,2:未审批 )
	 */
	private int apr;
	/**
	 * 申请时间
	 */
	private Date ap_time;
	/**
	 * 审批时间
	 */
	private Date che_tim;
	/**
	 * 角色ID
	 */
	private int rol_id;
	/**
	 * 公司id
	 */
	private String com_id;
	/**
	 * 部门id
	 */
	private int dep_id;
	/**
	 * 职位id TODO 后续将职位ID换为角色ID
	 */
	private int pos_id;
	/**
	 * 父id
	 */
	private int fat_id;

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
	 * @param <code>id</code> Holds the new value of the <code>id</code>
	 *        property.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the value of the <code>mobile</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>mobile</code> property.
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the value of the <code>mobile</code> property.
	 * <p>
	 * 
	 * @param <code>mobile</code> Holds the new value of the <code>mobile</code>
	 *        property.
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Gets the value of the <code>login_name</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>login_name</code> property.
	 */
	public String getLogin_name() {
		return login_name;
	}

	/**
	 * Sets the value of the <code>login_name</code> property.
	 * <p>
	 * 
	 * @param <code>login_name</code> Holds the new value of the
	 *        <code>login_name</code> property.
	 */
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	/**
	 * Gets the value of the <code>password</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>password</code> property.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the <code>password</code> property.
	 * <p>
	 * 
	 * @param <code>password</code> Holds the new value of the
	 *        <code>password</code> property.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the value of the <code>age</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>age</code> property.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the value of the <code>age</code> property.
	 * <p>
	 * 
	 * @param <code>age</code> Holds the new value of the <code>age</code>
	 *        property.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the value of the <code>sex</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>sex</code> property.
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * Sets the value of the <code>sex</code> property.
	 * <p>
	 * 
	 * @param <code>sex</code> Holds the new value of the <code>sex</code>
	 *        property.
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * Gets the value of the <code>ap_time</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>ap_time</code> property.
	 */
	public Date getAp_time() {
		return ap_time;
	}

	/**
	 * Sets the value of the <code>ap_time</code> property.
	 * <p>
	 * 
	 * @param <code>ap_time</code> Holds the new value of the
	 *        <code>ap_time</code> property.
	 */
	public void setAp_time(Date ap_time) {
		this.ap_time = ap_time;
	}

	/**
	 * Gets the value of the <code>rea_nam</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>rea_nam</code> property.
	 */
	public String getRea_nam() {
		return rea_nam;
	}

	/**
	 * Sets the value of the <code>rea_nam</code> property.
	 * <p>
	 * 
	 * @param <code>rea_nam</code> Holds the new value of the
	 *        <code>rea_nam</code> property.
	 */
	public void setRea_nam(String rea_nam) {
		this.rea_nam = rea_nam;
	}

	/**
	 * Gets the value of the <code>apr</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>apr</code> property.
	 */
	public int getApr() {
		return apr;
	}

	/**
	 * Sets the value of the <code>apr</code> property.
	 * <p>
	 * 
	 * @param <code>apr</code> Holds the new value of the <code>apr</code>
	 *        property.
	 */
	public void setApr(int apr) {
		this.apr = apr;
	}

	/**
	 * Gets the value of the <code>che_tim</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>che_tim</code> property.
	 */
	public Date getChe_tim() {
		return che_tim;
	}

	/**
	 * Sets the value of the <code>che_tim</code> property.
	 * <p>
	 * 
	 * @param <code>che_tim</code> Holds the new value of the
	 *        <code>che_tim</code> property.
	 */
	public void setChe_tim(Date che_tim) {
		this.che_tim = che_tim;
	}

	/**
	 * Gets the value of the <code>rol_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>rol_id</code> property.
	 */
	public int getRol_id() {
		return rol_id;
	}

	/**
	 * Sets the value of the <code>rol_id</code> property.
	 * <p>
	 * 
	 * @param <code>rol_id</code> Holds the new value of the <code>rol_id</code>
	 *        property.
	 */
	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

	/**
	 * Gets the value of the <code>com_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_id</code> property.
	 */
	public String getCom_id() {
		return com_id;
	}

	/**
	 * Sets the value of the <code>com_id</code> property.
	 * <p>
	 * 
	 * @param <code>com_id</code> Holds the new value of the <code>com_id</code>
	 *        property.
	 */
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}

	/**
	 * Gets the value of the <code>dep_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>dep_id</code> property.
	 */
	public int getDep_id() {
		return dep_id;
	}

	/**
	 * Sets the value of the <code>dep_id</code> property.
	 * <p>
	 * 
	 * @param <code>dep_id</code> Holds the new value of the <code>dep_id</code>
	 *        property.
	 */
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}

	/**
	 * Gets the value of the <code>pos_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>pos_id</code> property.
	 */
	public int getPos_id() {
		return pos_id;
	}

	/**
	 * Sets the value of the <code>pos_id</code> property.
	 * <p>
	 * 
	 * @param <code>pos_id</code> Holds the new value of the <code>pos_id</code>
	 *        property.
	 */
	public void setPos_id(int pos_id) {
		this.pos_id = pos_id;
	}

	/**
	 * Gets the value of the <code>fat_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>fat_id</code> property.
	 */
	public int getFat_id() {
		return fat_id;
	}

	/**
	 * Sets the value of the <code>fat_id</code> property.
	 * <p>
	 * 
	 * @param <code>fat_id</code> Holds the new value of the <code>fat_id</code>
	 *        property.
	 */
	public void setFat_id(int fat_id) {
		this.fat_id = fat_id;
	}

}
