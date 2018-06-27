package com.qinergy.dto.system;

import java.io.Serializable;
import java.util.Date;

public class DataDicTypeDto implements Serializable {
	private static final long serialVersionUID = 6929634089687035359L;
	// 0:未删除 1：删除
	public static final Integer DEL_NO = 0;
	public static final Integer DEL_YES = 1;
	
	/** id */
	private Integer id;
	/** 字典类型唯一标识 */
	private String dic_typ_ide;
	/** 字典类型名称 */
	private String dic_typ_nam;
	/** 排序号 */
	private Integer sor_num;
	/** 备注 */
	private String remark;

	/** 创建人id */
	private Integer crt_use_id;
	/** 创建时间 */
	private Date crt_tim;
	/** 修改人id */
	private Integer mod_use_id;
	/** 修改时间 */
	private Date mod_tim;
	/** 逻辑删除标记 */
	private Integer del_flag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDic_typ_ide() {
		return dic_typ_ide;
	}

	public void setDic_typ_ide(String dic_typ_ide) {
		this.dic_typ_ide = dic_typ_ide;
	}

	public String getDic_typ_nam() {
		return dic_typ_nam;
	}

	public void setDic_typ_nam(String dic_typ_nam) {
		this.dic_typ_nam = dic_typ_nam;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSor_num() {
		return sor_num;
	}

	public void setSor_num(Integer sor_num) {
		this.sor_num = sor_num;
	}

	public Integer getCrt_use_id() {
		return crt_use_id;
	}

	public void setCrt_use_id(Integer crt_use_id) {
		this.crt_use_id = crt_use_id;
	}

	public Date getCrt_tim() {
		return crt_tim;
	}

	public void setCrt_tim(Date crt_tim) {
		this.crt_tim = crt_tim;
	}

	public Integer getMod_use_id() {
		return mod_use_id;
	}

	public void setMod_use_id(Integer mod_use_id) {
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
