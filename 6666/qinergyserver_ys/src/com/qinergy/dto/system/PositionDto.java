package com.qinergy.dto.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础信息表--职位信息表（与部门无关联）
 * @author Daniel
 * @describe
 */
public class PositionDto implements Serializable {

	private static final long serialVersionUID = 259623181945439383L;

	private Integer id;
	/**
	 * 职位名称
	 */
	private String pos_nam;
	/**
	 * 职位标识
	 */
	private String pos_ide;
	/**
	 * 备注
	 */
	private int remark;
	/**
	 * 创建人ID
	 */
	private String crt_use_id;
	/**
	 * 创建时间
	 */
	private Integer crt_tim;
	/**
	 * 创修改人ID
	 */
	private Integer mod_use_id;
	/**
	 * 修改时间
	 */
	private String mod_tim;
	/**
	 * 该字段为标记该数据是否被删除（逻辑删除标记）
	 */
	private Date del_flag;

	/**
	 * Gets the value of the <code>id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>id</code> property.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the value of the <code>id</code> property.
	 * <p>
	 * 
	 * @param <code>id</code> Holds the new value of the <code>id</code>
	 *        property.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the value of the <code>pos_nam</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>pos_nam</code> property.
	 */
	public String getPos_nam() {
		return pos_nam;
	}

	/**
	 * Sets the value of the <code>pos_nam</code> property.
	 * <p>
	 * 
	 * @param <code>pos_nam</code> Holds the new value of the
	 *        <code>pos_nam</code> property.
	 */
	public void setPos_nam(String pos_nam) {
		this.pos_nam = pos_nam;
	}

	/**
	 * Gets the value of the <code>pos_ide</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>pos_ide</code> property.
	 */
	public String getPos_ide() {
		return pos_ide;
	}

	/**
	 * Sets the value of the <code>pos_ide</code> property.
	 * <p>
	 * 
	 * @param <code>pos_ide</code> Holds the new value of the
	 *        <code>pos_ide</code> property.
	 */
	public void setPos_ide(String pos_ide) {
		this.pos_ide = pos_ide;
	}

	/**
	 * Gets the value of the <code>remark</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>remark</code> property.
	 */
	public int getRemark() {
		return remark;
	}

	/**
	 * Sets the value of the <code>remark</code> property.
	 * <p>
	 * 
	 * @param <code>remark</code> Holds the new value of the <code>remark</code>
	 *        property.
	 */
	public void setRemark(int remark) {
		this.remark = remark;
	}

	/**
	 * Gets the value of the <code>crt_use_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>crt_use_id</code> property.
	 */
	public String getCrt_use_id() {
		return crt_use_id;
	}

	/**
	 * Sets the value of the <code>crt_use_id</code> property.
	 * <p>
	 * 
	 * @param <code>crt_use_id</code> Holds the new value of the
	 *        <code>crt_use_id</code> property.
	 */
	public void setCrt_use_id(String crt_use_id) {
		this.crt_use_id = crt_use_id;
	}

	/**
	 * Gets the value of the <code>crt_tim</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>crt_tim</code> property.
	 */
	public Integer getCrt_tim() {
		return crt_tim;
	}

	/**
	 * Sets the value of the <code>crt_tim</code> property.
	 * <p>
	 * 
	 * @param <code>crt_tim</code> Holds the new value of the
	 *        <code>crt_tim</code> property.
	 */
	public void setCrt_tim(Integer crt_tim) {
		this.crt_tim = crt_tim;
	}

	/**
	 * Gets the value of the <code>mod_use_id</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>mod_use_id</code> property.
	 */
	public Integer getMod_use_id() {
		return mod_use_id;
	}

	/**
	 * Sets the value of the <code>mod_use_id</code> property.
	 * <p>
	 * 
	 * @param <code>mod_use_id</code> Holds the new value of the
	 *        <code>mod_use_id</code> property.
	 */
	public void setMod_use_id(Integer mod_use_id) {
		this.mod_use_id = mod_use_id;
	}

	/**
	 * Gets the value of the <code>mod_tim</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>mod_tim</code> property.
	 */
	public String getMod_tim() {
		return mod_tim;
	}

	/**
	 * Sets the value of the <code>mod_tim</code> property.
	 * <p>
	 * 
	 * @param <code>mod_tim</code> Holds the new value of the
	 *        <code>mod_tim</code> property.
	 */
	public void setMod_tim(String mod_tim) {
		this.mod_tim = mod_tim;
	}

	/**
	 * Gets the value of the <code>del_flag</code> property.
	 * <p>
	 * 
	 * @return Returns the current value of <code>del_flag</code> property.
	 */
	public Date getDel_flag() {
		return del_flag;
	}

	/**
	 * Sets the value of the <code>del_flag</code> property.
	 * <p>
	 * 
	 * @param <code>del_flag</code> Holds the new value of the
	 *        <code>del_flag</code> property.
	 */
	public void setDel_flag(Date del_flag) {
		this.del_flag = del_flag;
	}
}
