package com.qinergy.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户 信息bean
 * @desc: 
 * @author: Qist
 * @date: 2017年10月17日
 */
public class UserInfDto implements Serializable{

	private static final long serialVersionUID = 7989470888608063894L;
	
	/**  用户状态 1:正常  2：停用*/
	public static final int USER_STAT_YES = 1;
	public static final int USER_STAT_NO = 2;
	
	/** 用户类型 1：运维人员    2：客户公司人员（运营） */
	public static final int USER_TYPE_YW = 1;
	public static final int USER_TYPE_YY = 2;
	

	
	/** id */
	private Integer id;
	/** 用户类型 1：运维人员    2：客户公司人员（运营） */
	private Integer use_typ;
	
	/** 公司id */
	private Integer com_id;
	/** 部门id  */
	private String dep_id;
	/** 职位id */
	private Integer pos_id;
	/** 学历 id */
	private Integer edu_id;
	/** 角色id */
	private Integer rol_id;
	
	/** 公司名称 */
	private Integer com_nam;
	/** 部门名称  */
	private Integer dep_nam;
	/** 职位名称 */
	private Integer pos_nam;
	/** 学历名称 */
	private Integer edu_nam;
	/** 角色名称 */
	private Integer rol_nam;

	/**用户状态 1:正常  2：停用 */
	private Integer use_sta;
	
	/** 账号 */
	private String acc_num;
	/** 密码 */
	private String use_pas;
	/** 姓名 */
	private String use_nam;
	/** 手机号码 */
	private String use_mob;
	/** 性别 1：男 2：女 */
	private Integer use_sex;
	/** 身份证号 */
	private String use_idc;
	/** 邮箱 */
	private String use_mal;
	/** 通讯地址 */
	private String use_add;
	/** 照片url */
	private String pic_url;

	/** 学历专业 */
	private String use_maj;
	/** 参加工作时间 */
	private String tak_tim;
	/** 籍贯 */
	private String pla_ori;
	/** 备注 */
	private String remark;
	
	/** 添加操作人id */
	private String crt_use_id;
	/** 添加时间 */
	private Date crt_tim;
	/** 添加操作人id */
	private String mod_use_id;
	/**修改时间 */
	private Date mod_tim;

	
	
	/**运维人员/站查看状态
	 * 1：可查看（如果为运维公司时，可查看子公司人员和站信息，如果为业主公司，可查看与该公司站关联的所有运维人员），
	 * 2：不可查看（如果为运维公司，只能查看自己公司的人与站以及与自己有关的站的信息，如果为业主公司时，只能查看与自己有关的所有站的信息，不能查看运维人员信息）），
	 * 用户新建时，默认可见'
	 * */
	private Integer slt_opt_sta;
	/**用户对告警信息是否可见，
	 * 默认为1（可见），
	 * 如为2时，所有告警信息均不获取', */
	private Integer is_def_sta;
	
	
	
	
	//TODO 预留自助申请账号字段
	/**是否审批(0:驳回,1:批准,2:未审批 )*/
	private int apr;
	/**申请时间*/
	private Date ap_time;
	/** 审批时间*/
	private Date che_tim;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUse_typ() {
		return use_typ;
	}
	public void setUse_typ(Integer use_typ) {
		this.use_typ = use_typ;
	}
	public Integer getCom_id() {
		return com_id;
	}
	public void setCom_id(Integer com_id) {
		this.com_id = com_id;
	}
	public String getDep_id() {
		return dep_id;
	}
	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	public Integer getPos_id() {
		return pos_id;
	}
	public void setPos_id(Integer pos_id) {
		this.pos_id = pos_id;
	}
	public Integer getEdu_id() {
		return edu_id;
	}
	public void setEdu_id(Integer edu_id) {
		this.edu_id = edu_id;
	}
	public Integer getRol_id() {
		return rol_id;
	}
	public void setRol_id(Integer rol_id) {
		this.rol_id = rol_id;
	}
	public Integer getCom_nam() {
		return com_nam;
	}
	public void setCom_nam(Integer com_nam) {
		this.com_nam = com_nam;
	}
	public Integer getDep_nam() {
		return dep_nam;
	}
	public void setDep_nam(Integer dep_nam) {
		this.dep_nam = dep_nam;
	}
	public Integer getPos_nam() {
		return pos_nam;
	}
	public void setPos_nam(Integer pos_nam) {
		this.pos_nam = pos_nam;
	}
	public Integer getEdu_nam() {
		return edu_nam;
	}
	public void setEdu_nam(Integer edu_nam) {
		this.edu_nam = edu_nam;
	}
	public Integer getRol_nam() {
		return rol_nam;
	}
	public void setRol_nam(Integer rol_nam) {
		this.rol_nam = rol_nam;
	}
	public Integer getUse_sta() {
		return use_sta;
	}
	public void setUse_sta(Integer use_sta) {
		this.use_sta = use_sta;
	}
	public String getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}
	public String getUse_pas() {
		return use_pas;
	}
	public void setUse_pas(String use_pas) {
		this.use_pas = use_pas;
	}
	public String getUse_nam() {
		return use_nam;
	}
	public void setUse_nam(String use_nam) {
		this.use_nam = use_nam;
	}
	public String getUse_mob() {
		return use_mob;
	}
	public void setUse_mob(String use_mob) {
		this.use_mob = use_mob;
	}
	public Integer getUse_sex() {
		return use_sex;
	}
	public void setUse_sex(Integer use_sex) {
		this.use_sex = use_sex;
	}
	public String getUse_idc() {
		return use_idc;
	}
	public void setUse_idc(String use_idc) {
		this.use_idc = use_idc;
	}
	public String getUse_mal() {
		return use_mal;
	}
	public void setUse_mal(String use_mal) {
		this.use_mal = use_mal;
	}
	public String getUse_add() {
		return use_add;
	}
	public void setUse_add(String use_add) {
		this.use_add = use_add;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getUse_maj() {
		return use_maj;
	}
	public void setUse_maj(String use_maj) {
		this.use_maj = use_maj;
	}
	public String getTak_tim() {
		return tak_tim;
	}
	public void setTak_tim(String tak_tim) {
		this.tak_tim = tak_tim;
	}
	public String getPla_ori() {
		return pla_ori;
	}
	public void setPla_ori(String pla_ori) {
		this.pla_ori = pla_ori;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public int getApr() {
		return apr;
	}
	public void setApr(int apr) {
		this.apr = apr;
	}
	public Date getAp_time() {
		return ap_time;
	}
	public void setAp_time(Date ap_time) {
		this.ap_time = ap_time;
	}
	public Date getChe_tim() {
		return che_tim;
	}
	public void setChe_tim(Date che_tim) {
		this.che_tim = che_tim;
	}
	/**
	 * @return the slt_opt_sta
	 */
	public Integer getSlt_opt_sta() {
		return slt_opt_sta;
	}
	/**
	 * @param slt_opt_sta the slt_opt_sta to set
	 */
	public void setSlt_opt_sta(Integer slt_opt_sta) {
		this.slt_opt_sta = slt_opt_sta;
	}
	/**
	 * @return the is_def_sta
	 */
	public Integer getIs_def_sta() {
		return is_def_sta;
	}
	/**
	 * @param is_def_sta the is_def_sta to set
	 */
	public void setIs_def_sta(Integer is_def_sta) {
		this.is_def_sta = is_def_sta;
	}
	
	
	
	
	
}