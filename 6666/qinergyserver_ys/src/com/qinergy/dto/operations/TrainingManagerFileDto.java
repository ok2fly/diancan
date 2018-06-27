package com.qinergy.dto.operations;

import java.io.Serializable;

public class TrainingManagerFileDto implements Serializable {
	
	private static final long serialVersionUID = -8229074588443448812L;
	public static final int DEL_FLAG_NO = 0; //未删除
	public static final int DEL_FLAG_YES = 1; 
	public static final int FILE_TYP_FILES = 1; //文件
	public static final int FILE_TYP_PIC = 2; //图片
	
	
	private Integer id;                                                                      
	private Integer train_num; // 培训编号                                                             
	private Integer file_typ; // 文件类型(1:文件 2:图片)                                                          
	private String file_nam; // 文件名称                                                        
	private String file_url; // 文件路径                                                        
	private Integer crt_use_id; // 上传人  id                                                         
	private String crt_tim; // 上传时间        
	private Integer mod_use_id; //修改人ID                                                         
	private String mod_tim; //修改时间      
	private String remark; // 备注                                                              
	private Integer del_flag; // 逻辑删除标记
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTrain_num() {
		return train_num;
	}
	public void setTrain_num(Integer train_num) {
		this.train_num = train_num;
	}
	public Integer getFile_typ() {
		return file_typ;
	}
	public void setFile_typ(Integer file_typ) {
		this.file_typ = file_typ;
	}
	public String getFile_nam() {
		return file_nam;
	}
	public void setFile_nam(String file_nam) {
		this.file_nam = file_nam;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
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
	
	
}
