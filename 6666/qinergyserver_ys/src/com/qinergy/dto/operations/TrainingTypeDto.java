package com.qinergy.dto.operations;

import java.io.Serializable;

public class TrainingTypeDto implements Serializable{
	
	private static final long serialVersionUID = -7618649143471440536L;
	public static final int DEL_FLAG_NO = 0; //未删除
	public static final int DEL_FLAG_YES = 1; 
	
	
	private Integer id;                                                                      
	private String typ_nam; 	//培训类型名称                                                  
	private String typ_ide; 	//培训类型标识                                                  
	private String remark; 		//备注                                                              
	private Integer crt_use_id; //创建人ID                                                         
	private String crt_tim; 	//创建时间                                                        
	private Integer mod_use_id; //修改人ID                                                         
	private String mod_tim; 	//修改时间                                                        
	private Integer del_flag; 	//逻辑删除标记
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTyp_nam() {
		return typ_nam;
	}
	public void setTyp_nam(String typ_nam) {
		this.typ_nam = typ_nam;
	}
	public String getTyp_ide() {
		return typ_ide;
	}
	public void setTyp_ide(String typ_ide) {
		this.typ_ide = typ_ide;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	
	
	
	
}
