package com.qinergy.dto.assetmanagement;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefectDto implements Serializable{

	private static final long serialVersionUID = -335542057074752514L;
	
	
	public static final int DEL_FLAG_NO = 0; //未删除
	public static final int DEL_FLAG_YES = 1; 
	
	public static final int DEF_STAT_NOT_DISPIL = 0; //未消除
	public static final int DEF_STAT_DISPIL = 1; //已消除
	public static final int DEF_STAT_NOT_DEAL = 2; //不处理
	
	
	private Integer id;                                                                     
	private Integer def_typ_id; //消缺类型ID                                                      
	private String def_num; //缺陷编号                                                        
	private Integer def_sta; //缺陷状态（0:未消除，1：已消除 2:不处理）           
	private Integer def_grade; //缺陷等级                                                        
	private Integer sub_com_id; //所属公司id                                                        
	private String def_desc; //缺陷描述                                                        
	private Integer crt_use_id; //创建人ID                                                         
	private String crt_tim; //创建时间                                                        
	private Integer mod_use_id; //修改人ID                                                         
	private String mod_tim; //修改时间                                                        
	private String remark; //备注                                                              
	private Integer del_flag; //逻辑删除标记
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDef_typ_id() {
		return def_typ_id;
	}
	public void setDef_typ_id(Integer def_typ_id) {
		this.def_typ_id = def_typ_id;
	}
	public String getDef_num() {
		return def_num;
	}
	public void setDef_num(String def_num) {
		this.def_num = def_num;
	}
	public Integer getDef_sta() {
		return def_sta;
	}
	public void setDef_sta(Integer def_sta) {
		this.def_sta = def_sta;
	}
	public Integer getDef_grade() {
		return def_grade;
	}
	public void setDef_grade(Integer def_grade) {
		this.def_grade = def_grade;
	}
	public String getDef_desc() {
		return def_desc;
	}
	public void setDef_desc(String def_desc) {
		this.def_desc = def_desc;
	}
	public Integer getCrt_use_id() {
		return crt_use_id;
	}
	public void setCrt_use_id(Integer crt_use_id) {
		this.crt_use_id = crt_use_id;
	}
	public String getCrt_tim() {
		return crt_tim;
	}
	public void setCrt_tim(String crt_tim) {
		this.crt_tim = crt_tim;
	}
	public Integer getMod_use_id() {
		return mod_use_id;
	}
	public void setMod_use_id(Integer mod_use_id) {
		this.mod_use_id = mod_use_id;
	}
	public String getMod_tim() {
		return mod_tim;
	}
	public void setMod_tim(String mod_tim) {
		this.mod_tim = mod_tim;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	public Integer getSub_com_id() {
		return sub_com_id;
	}
	public void setSub_com_id(Integer sub_com_id) {
		this.sub_com_id = sub_com_id;
	}
	
	
	
}
