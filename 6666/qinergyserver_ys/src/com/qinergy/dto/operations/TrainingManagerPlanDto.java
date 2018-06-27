package com.qinergy.dto.operations;

import java.io.Serializable;

/**
 * @desc: 培训计划实体类
 * @author: Qist
 * @date: 2017年11月28日
 */
public class TrainingManagerPlanDto implements Serializable{
	private static final long serialVersionUID = -7999474912872902227L;
	
	public static final int DEL_FLAG_NO = 0; //未删除：显示
	public static final int DEL_FLAG_YES = 1; //
	
	public static final int TRA_PLAN_NOT_EXEC = 0; //待执行
	public static final int TRA_PLAN_EXEC = 1; //已执行
	
	
	private Integer id;
	private Integer tra_typ_id; //培训类型ID                                         
	private String tra_num; // 培训编号                                           
	private String plan_num; // 计划编号                                           
	private Integer is_exec; // 是否执行（0:待执行 1:已执行）
	private String tra_cont; // 内容                                                 
	private String tra_speaker; // 主讲人                                              
	private String tra_target; // 被培训对象                                        
	private String begin_tim; // 开始时间                                           
	private String finish_tim; // 结束时间                                           
	private String tra_place; // 培训地点                                           
	private Integer sub_com_id; //所属公司id(sys_bas_com)                            
	private Integer crt_use_id; //创建人ID                                            
	private String crt_tim; //创建时间                                           
	private Integer mod_use_id; //修改人ID                                            
	private String mod_tim; //修改时间                                           
	private String remark; //备注                                                 
	private Integer del_flag; //逻辑删除标记（ 0显示 1隐藏）
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTra_typ_id() {
		return tra_typ_id;
	}
	public void setTra_typ_id(Integer tra_typ_id) {
		this.tra_typ_id = tra_typ_id;
	}
	public String getTra_num() {
		return tra_num;
	}
	public void setTra_num(String tra_num) {
		this.tra_num = tra_num;
	}
	public String getPlan_num() {
		return plan_num;
	}
	public void setPlan_num(String plan_num) {
		this.plan_num = plan_num;
	}
	public Integer getIs_exec() {
		return is_exec;
	}
	public void setIs_exec(Integer is_exec) {
		this.is_exec = is_exec;
	}
	public String getTra_cont() {
		return tra_cont;
	}
	public void setTra_cont(String tra_cont) {
		this.tra_cont = tra_cont;
	}
	public String getTra_speaker() {
		return tra_speaker;
	}
	public void setTra_speaker(String tra_speaker) {
		this.tra_speaker = tra_speaker;
	}
	public String getTra_target() {
		return tra_target;
	}
	public void setTra_target(String tra_target) {
		this.tra_target = tra_target;
	}
	public String getFinish_tim() {
		return finish_tim;
	}
	public void setFinish_tim(String finish_tim) {
		this.finish_tim = finish_tim;
	}
	public String getBegin_tim() {
		return begin_tim;
	}
	public void setBegin_tim(String begin_tim) {
		this.begin_tim = begin_tim;
	}
	public String getTra_place() {
		return tra_place;
	}
	public void setTra_place(String tra_place) {
		this.tra_place = tra_place;
	}
	public Integer getSub_com_id() {
		return sub_com_id;
	}
	public void setSub_com_id(Integer sub_com_id) {
		this.sub_com_id = sub_com_id;
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
