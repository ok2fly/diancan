/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.dto.system;

import java.io.Serializable;

/**
 * 基础信息-公司信息表
 * <p>
 * This contains the following attributes:<br/>
 * <p>
 * 
 * 
 * @author iceX
 * @version 1.0
 * @since 1.0
 */

public class CompanyDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8532747096683514977L;
	
	/**
	 * 序号
	 */
	private int id;
	
	/**
	 * 公司名称
	 */
	private String com_nam;
	
	/**
	 * 公司标识
	 */
	private String com_ide;
	
	/**
	 * 公司地址
	 */
	private String com_add;
	
	/**
	 * 单位状态（1为可用，2为不可用）
	 */
	private Integer com_sta;
	
	/**
	 * 公司联系人
	 */
	private String com_con;
	
	/**
	 * 公司级别
	 */
	private Integer com_lev;
	
	/**
	 * 公司联系电话
	 */
	private String com_tel;
	
	/**
	 * 单位类型表ID(sys_bas_com_typ表，为该表主键)
	 */
	private Integer com_typ_id;
	
	/**
	 * 上级单位ID(表sys_bas_com，为该表主键)
	 */
	private Integer com_fat_id;
	
	/**
	 * 公司法人名称
	 */
	private String com_lep;
	
	/**
	 * 公司法人代码
	 */
	private String com_lep_cod;
	
	/**
	 * 公司经度
	 */
	private Double com_lon;
	
	/**
	 * 公司纬度
	 */
	private Double com_lat;
	
	/**
	 * 排序号
	 */
	private Integer com_sor;
	
	/**
	 * 中心点坐标经度
	 */
	private Double com_cen_lon;
	
	/**
	 * 中心点坐标（纬度）
	 */
	private Double com_cen_lat;
	
	/**
	 * 地图缩放级别
	 */
	private Integer com_zoo_lev;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 省级地区ID
	 */
	private Integer pro_id;
	
	/**
	 * 市级地区ID
	 */
	private Integer cit_id;
	
	/**
	 * 区级ID
	 */
	private Integer are_id;
	
	/**
	 * 公司角色（0代表自己公司，1代表业主公司，2代表合作伙伴）
	 */
	private Integer com_rol;

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
	 * Gets the value of the <code>com_nam</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_nam</code> property.
	 */
	public String getCom_nam() {
		return com_nam;
	}

	/**
	 * Sets the value of the <code>com_nam</code> property.
	 * <p>
	 * 
	 * @param <code>com_nam</code> Holds the new value of the
	 *        <code>com_nam</code> property.
	 */
	public void setCom_nam(String com_nam) {
		this.com_nam = com_nam;
	}

	/**
	 * Gets the value of the <code>com_ide</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_ide</code> property.
	 */
	public String getCom_ide() {
		return com_ide;
	}

	/**
	 * Sets the value of the <code>com_ide</code> property.
	 * <p>
	 * 
	 * @param <code>com_ide</code> Holds the new value of the
	 *        <code>com_ide</code> property.
	 */
	public void setCom_ide(String com_ide) {
		this.com_ide = com_ide;
	}

	/**
	 * Gets the value of the <code>com_add</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_add</code> property.
	 */
	public String getCom_add() {
		return com_add;
	}

	/**
	 * Sets the value of the <code>com_add</code> property.
	 * <p>
	 * 
	 * @param <code>com_add</code> Holds the new value of the
	 *        <code>com_add</code> property.
	 */
	public void setCom_add(String com_add) {
		this.com_add = com_add;
	}

	/**
	 * Gets the value of the <code>com_sta</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_sta</code> property.
	 */
	public Integer getCom_sta() {
		return com_sta;
	}

	/**
	 * Sets the value of the <code>com_sta</code> property.
	 * <p>
	 * 
	 * @param <code>com_sta</code> Holds the new value of the
	 *        <code>com_sta</code> property.
	 */
	public void setCom_sta(Integer com_sta) {
		this.com_sta = com_sta;
	}

	/**
	 * Gets the value of the <code>com_con</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_con</code> property.
	 */
	public String getCom_con() {
		return com_con;
	}

	/**
	 * Sets the value of the <code>com_con</code> property.
	 * <p>
	 * 
	 * @param <code>com_con</code> Holds the new value of the
	 *        <code>com_con</code> property.
	 */
	public void setCom_con(String com_con) {
		this.com_con = com_con;
	}

	/**
	 * Gets the value of the <code>com_tel</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_tel</code> property.
	 */
	public String getCom_tel() {
		return com_tel;
	}

	/**
	 * Sets the value of the <code>com_tel</code> property.
	 * <p>
	 * 
	 * @param <code>com_tel</code> Holds the new value of the
	 *        <code>com_tel</code> property.
	 */
	public void setCom_tel(String com_tel) {
		this.com_tel = com_tel;
	}

	/**
	 * Gets the value of the <code>com_typ_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_typ_id</code> property.
	 */
	public Integer getCom_typ_id() {
		return com_typ_id;
	}

	/**
	 * Sets the value of the <code>com_typ_id</code> property.
	 * <p>
	 * 
	 * @param <code>com_typ_id</code> Holds the new value of the
	 *        <code>com_typ_id</code> property.
	 */
	public void setCom_typ_id(Integer com_typ_id) {
		this.com_typ_id = com_typ_id;
	}

	/**
	 * Gets the value of the <code>com_fat_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_fat_id</code> property.
	 */
	public Integer getCom_fat_id() {
		return com_fat_id;
	}

	/**
	 * Sets the value of the <code>com_fat_id</code> property.
	 * <p>
	 * 
	 * @param <code>com_fat_id</code> Holds the new value of the
	 *        <code>com_fat_id</code> property.
	 */
	public void setCom_fat_id(Integer com_fat_id) {
		this.com_fat_id = com_fat_id;
	}

	/**
	 * Gets the value of the <code>com_lep</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_lep</code> property.
	 */
	public String getCom_lep() {
		return com_lep;
	}

	/**
	 * Sets the value of the <code>com_lep</code> property.
	 * <p>
	 * 
	 * @param <code>com_lep</code> Holds the new value of the
	 *        <code>com_lep</code> property.
	 */
	public void setCom_lep(String com_lep) {
		this.com_lep = com_lep;
	}

	/**
	 * Gets the value of the <code>com_lep_cod</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_lep_cod</code> property.
	 */
	public String getCom_lep_cod() {
		return com_lep_cod;
	}

	/**
	 * Sets the value of the <code>com_lep_cod</code> property.
	 * <p>
	 * 
	 * @param <code>com_lep_cod</code> Holds the new value of the
	 *        <code>com_lep_cod</code> property.
	 */
	public void setCom_lep_cod(String com_lep_cod) {
		this.com_lep_cod = com_lep_cod;
	}

	/**
	 * Gets the value of the <code>com_lon</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_lon</code> property.
	 */
	public Double getCom_lon() {
		return com_lon;
	}

	/**
	 * Sets the value of the <code>com_lon</code> property.
	 * <p>
	 * 
	 * @param <code>com_lon</code> Holds the new value of the
	 *        <code>com_lon</code> property.
	 */
	public void setCom_lon(Double com_lon) {
		this.com_lon = com_lon;
	}

	/**
	 * Gets the value of the <code>com_lat</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_lat</code> property.
	 */
	public Double getCom_lat() {
		return com_lat;
	}

	/**
	 * Sets the value of the <code>com_lat</code> property.
	 * <p>
	 * 
	 * @param <code>com_lat</code> Holds the new value of the
	 *        <code>com_lat</code> property.
	 */
	public void setCom_lat(Double com_lat) {
		this.com_lat = com_lat;
	}

	/**
	 * Gets the value of the <code>com_sor</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_sor</code> property.
	 */
	public Integer getCom_sor() {
		return com_sor;
	}

	/**
	 * Sets the value of the <code>com_sor</code> property.
	 * <p>
	 * 
	 * @param <code>com_sor</code> Holds the new value of the
	 *        <code>com_sor</code> property.
	 */
	public void setCom_sor(Integer com_sor) {
		this.com_sor = com_sor;
	}

	/**
	 * Gets the value of the <code>com_cen_lon</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_cen_lon</code> property.
	 */
	public Double getCom_cen_lon() {
		return com_cen_lon;
	}

	/**
	 * Sets the value of the <code>com_cen_lon</code> property.
	 * <p>
	 * 
	 * @param <code>com_cen_lon</code> Holds the new value of the
	 *        <code>com_cen_lon</code> property.
	 */
	public void setCom_cen_lon(Double com_cen_lon) {
		this.com_cen_lon = com_cen_lon;
	}

	/**
	 * Gets the value of the <code>com_cen_lat</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_cen_lat</code> property.
	 */
	public Double getCom_cen_lat() {
		return com_cen_lat;
	}

	/**
	 * Sets the value of the <code>com_cen_lat</code> property.
	 * <p>
	 * 
	 * @param <code>com_cen_lat</code> Holds the new value of the
	 *        <code>com_cen_lat</code> property.
	 */
	public void setCom_cen_lat(Double com_cen_lat) {
		this.com_cen_lat = com_cen_lat;
	}

	/**
	 * Gets the value of the <code>com_zoo_lev</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>com_zoo_lev</code> property.
	 */
	public Integer getCom_zoo_lev() {
		return com_zoo_lev;
	}

	/**
	 * Sets the value of the <code>com_zoo_lev</code> property.
	 * <p>
	 * 
	 * @param <code>com_zoo_lev</code> Holds the new value of the
	 *        <code>com_zoo_lev</code> property.
	 */
	public void setCom_zoo_lev(Integer com_zoo_lev) {
		this.com_zoo_lev = com_zoo_lev;
	}

	/**
	 * Gets the value of the <code>remark</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>remark</code> property.
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the value of the <code>remark</code> property.
	 * <p>
	 * 
	 * @param <code>remark</code> Holds the new value of the <code>remark</code>
	 *        property.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the value of the <code>pro_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>pro_id</code> property.
	 */
	public Integer getPro_id() {
		return pro_id;
	}

	/**
	 * Sets the value of the <code>pro_id</code> property.
	 * <p>
	 * 
	 * @param <code>pro_id</code> Holds the new value of the <code>pro_id</code>
	 *        property.
	 */
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}

	/**
	 * Gets the value of the <code>cit_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>cit_id</code> property.
	 */
	public Integer getCit_id() {
		return cit_id;
	}

	/**
	 * Sets the value of the <code>cit_id</code> property.
	 * <p>
	 * 
	 * @param <code>cit_id</code> Holds the new value of the <code>cit_id</code>
	 *        property.
	 */
	public void setCit_id(Integer cit_id) {
		this.cit_id = cit_id;
	}

	/**
	 * Gets the value of the <code>are_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>are_id</code> property.
	 */
	public Integer getAre_id() {
		return are_id;
	}

	/**
	 * Sets the value of the <code>are_id</code> property.
	 * <p>
	 * 
	 * @param <code>are_id</code> Holds the new value of the <code>are_id</code>
	 *        property.
	 */
	public void setAre_id(Integer are_id) {
		this.are_id = are_id;
	}

	/**
	 * Gets the value of the <code>com_lev</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>com_lev</code> property.
	 */
	public Integer getCom_lev() {
		return com_lev;
	}

	/**
	 * Sets the value of the <code>com_lev</code> property.
	 * <p>
	 *
	 * @param <code>com_lev</code>
	 *        Holds the new value of the <code>com_lev</code> property.
	 */
	public void setCom_lev(Integer com_lev) {
		this.com_lev = com_lev;
	}

	/**
	 * Gets the value of the <code>com_rol</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>com_rol</code> property.
	 */
	public Integer getCom_rol() {
		return com_rol;
	}

	/**
	 * Sets the value of the <code>com_rol</code> property.
	 * <p>
	 *
	 * @param <code>com_rol</code>
	 *        Holds the new value of the <code>com_rol</code> property.
	 */
	public void setCom_rol(Integer com_rol) {
		this.com_rol = com_rol;
	}

}
