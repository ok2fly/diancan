package com.qinergy.dto.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Qist
 * @describe
 */
public class DepartmentDto implements Serializable {

	private static final long serialVersionUID = 259623181945439383L;
	/**  部门状态 	0：可用  1：不可用 */
	public static final int DEP_STAT_YES = 0;
	public static final int DEP_STAT_NO = 1;
	
	private Integer id;
	/** 部门名称 */
	private String dep_nam;
	/** 部门id */
	private String dep_ide;
	/** 公司id  */
	private int com_id;
	/** 公司名称称 */
	private int com_name;
	/** 备注 */
	private String remark;
	/**  部门状态 	1：可用  2：不可用 */
	private Integer dep_sta;
	/** 排序 */
	private Integer dep_sor;
	/** 添加操作人id */
	private String crt_use_id;
	/** 添加时间 */
	private Date crt_tim;
	/** 添加操作人id */
	private String mod_use_id;
	/**修改时间 */
	private Date mod_tim;
	/** 删除标记 */
	private Integer del_flag;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDep_nam() {
		return dep_nam;
	}
	public void setDep_nam(String dep_nam) {
		this.dep_nam = dep_nam;
	}
	public String getDep_ide() {
		return dep_ide;
	}
	public void setDep_ide(String dep_ide) {
		this.dep_ide = dep_ide;
	}
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public int getCom_name() {
		return com_name;
	}
	public void setCom_name(int com_name) {
		this.com_name = com_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDep_sta() {
		return dep_sta;
	}
	public void setDep_sta(Integer dep_sta) {
		this.dep_sta = dep_sta;
	}
	public Integer getDep_sor() {
		return dep_sor;
	}
	public void setDep_sor(Integer dep_sor) {
		this.dep_sor = dep_sor;
	}
	public String getCrt_use_id() {
		return crt_use_id;
	}
	public void setCrt_use_id(String crt_use_id) {
		this.crt_use_id = crt_use_id;
	}
	public Date getCrt_tim() {
		return crt_tim;
	}
	public void setCrt_tim(Date crt_tim) {
		this.crt_tim = crt_tim;
	}
	public String getMod_use_id() {
		return mod_use_id;
	}
	public void setMod_use_id(String mod_use_id) {
		this.mod_use_id = mod_use_id;
	}
	public Date getMod_tim() {
		return mod_tim;
	}
	public void setMod_tim(Date mod_tim) {
		this.mod_tim = mod_tim;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	
	
}
