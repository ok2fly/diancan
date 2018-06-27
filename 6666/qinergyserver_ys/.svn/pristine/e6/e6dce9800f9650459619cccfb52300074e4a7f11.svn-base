package com.qinergy.dto.assetmanagement;

import java.io.Serializable;
import java.util.List;

/**@desc: 
 * @author: Qist
 * @date: 2017年12月7日
 */
public class AssetsDto implements Serializable{

	private static final long serialVersionUID = -5438505451999434736L;
	
	public static final int DEL_FLAG_NO = 0; //未删除：显示
	public static final int DEL_FLAG_YES = 1; //
	public static final int BROUND_IN = 1; //入库
	public static final int BROUND_OUT = 2; //出库
	public static final int ASSETS_SCRAP_NO = 0; //未报废
	public static final int ASSETS_SCRAP_YES = 1; //报废
	
	
	private Integer id;                                                                                      
	/** 资产名称*/
	private String ass_nam; 
	/** 资产类型ID（见表;sys_bas_assets_typ*/
	private Integer ass_typ_id; 
                                                          
	/** 资产编号 */
	private String ass_num; 
	/** 资产状态状态（1为入库，2为出库） */
	private Integer cur_sta; 
	                                                                       
	/** 逻辑删除标记 0显示 1隐藏 */ 
	private Integer del_flag; 
	/** 排序号     */
	private Integer equ_sor; 
	/** 设备型号ID */
	private Integer app_mod_id; 
	/** 生产厂家ID(sys_bas_man) */
	private Integer man_id; 
	/** 所属公司ID(sys_bas_com)   */                                                       
	private Integer sub_com_id; 
	/** 是否报废（0否，1是） */                                                       
	private Integer is_scrap; 
	/** 所在仓库ID   */
	private Integer war_id; 
	/** 数量   */
	private Integer cou; 
	
	private List<Integer> ids; 
	/** 出入库单号 */                                                                        
	private String ord_num; 
	/** 出厂日期 */                                                                        
	private String pro_tim; 
	/** 购买日期 */  
	private String pur_tim; 
	/** 计量单位 */                                                                        
	private String unit; 
	/** 价格 */                                                                              
	private Double price; 
	/** 尺寸  */                                                                             
	private String siz; 
	/** 重量        */                                                                       
	private Double weight; 
	/** 输入电流   */                                                                      
	private Double inp_elc;
	/** 输入电压    */                                                                     
	private Double inp_vol;  
	/** 额定容量 */                                                                        
	private Double rtd_pow; 
	/** 输出电流   */                                                                      
	private Double out_elc; 
	/** 输出电压       */                                                                  
	private Double out_vol; 
	/** 工作温度   */                                                                      
	private Double work_temp; 
	/** 海拔 */                                                                             
	private Double altitude; 
	/**防护等级     */                                                                   
	private String prtc_grade; 
	/** 残值率 */                                                                           
	private Double res_val; 
	/** 折旧年限 */                                                                        
	private Double dep_fix_num_year; 
	/** 月折旧额  */                                                                       
	private Double mon_dep; 
	/** 累计折旧额    */                                                                  
	private Double acc_dep; 
	/** 备注  */      
	private String remark; 
	/** 创建人ID */                                                                         
	private Integer crt_use_id;
	/** 创建时间 */                                                                        
	private String crt_tim; 
	/** 修改人ID */                                                                         
	private Integer mod_use_id; 
	/** 修改时间 */
	private String mod_tim; 
	
	
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAss_nam() {
		return ass_nam;
	}
	public void setAss_nam(String ass_nam) {
		this.ass_nam = ass_nam;
	}
	public Integer getAss_typ_id() {
		return ass_typ_id;
	}
	public void setAss_typ_id(Integer ass_typ_id) {
		this.ass_typ_id = ass_typ_id;
	}
	public String getAss_num() {
		return ass_num;
	}
	public void setAss_num(String ass_num) {
		this.ass_num = ass_num;
	}
	public Integer getCur_sta() {
		return cur_sta;
	}
	public void setCur_sta(Integer cur_sta) {
		this.cur_sta = cur_sta;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	public Integer getEqu_sor() {
		return equ_sor;
	}
	public void setEqu_sor(Integer equ_sor) {
		this.equ_sor = equ_sor;
	}
	public Integer getApp_mod_id() {
		return app_mod_id;
	}
	public void setApp_mod_id(Integer app_mod_id) {
		this.app_mod_id = app_mod_id;
	}
	public Integer getMan_id() {
		return man_id;
	}
	public void setMan_id(Integer man_id) {
		this.man_id = man_id;
	}
	public Integer getSub_com_id() {
		return sub_com_id;
	}
	public void setSub_com_id(Integer sub_com_id) {
		this.sub_com_id = sub_com_id;
	}
	public Integer getIs_scrap() {
		return is_scrap;
	}
	public void setIs_scrap(Integer is_scrap) {
		this.is_scrap = is_scrap;
	}
	public Integer getWar_id() {
		return war_id;
	}
	public void setWar_id(Integer war_id) {
		this.war_id = war_id;
	}

	public String getUnit() {
		return unit;
	}
	public String getPro_tim() {
		return pro_tim;
	}
	public void setPro_tim(String pro_tim) {
		this.pro_tim = pro_tim;
	}
	public String getPur_tim() {
		return pur_tim;
	}
	public void setPur_tim(String pur_tim) {
		this.pur_tim = pur_tim;
	}
	public String getCrt_tim() {
		return crt_tim;
	}
	public void setCrt_tim(String crt_tim) {
		this.crt_tim = crt_tim;
	}
	public String getMod_tim() {
		return mod_tim;
	}
	public void setMod_tim(String mod_tim) {
		this.mod_tim = mod_tim;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getInp_elc() {
		return inp_elc;
	}
	public void setInp_elc(Double inp_elc) {
		this.inp_elc = inp_elc;
	}
	public String getSiz() {
		return siz;
	}
	public void setSiz(String siz) {
		this.siz = siz;
	}
	public Double getInp_vol() {
		return inp_vol;
	}
	public void setInp_vol(Double inp_vol) {
		this.inp_vol = inp_vol;
	}
	public Double getRtd_pow() {
		return rtd_pow;
	}
	public void setRtd_pow(Double rtd_pow) {
		this.rtd_pow = rtd_pow;
	}
	public Double getOut_elc() {
		return out_elc;
	}
	public void setOut_elc(Double out_elc) {
		this.out_elc = out_elc;
	}
	public Double getOut_vol() {
		return out_vol;
	}
	public void setOut_vol(Double out_vol) {
		this.out_vol = out_vol;
	}
	public Double getWork_temp() {
		return work_temp;
	}
	public void setWork_temp(Double work_temp) {
		this.work_temp = work_temp;
	}
	public Double getAltitude() {
		return altitude;
	}
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}
	public String getPrtc_grade() {
		return prtc_grade;
	}
	public void setPrtc_grade(String prtc_grade) {
		this.prtc_grade = prtc_grade;
	}
	public Double getRes_val() {
		return res_val;
	}
	public void setRes_val(Double res_val) {
		this.res_val = res_val;
	}
	public Double getDep_fix_num_year() {
		return dep_fix_num_year;
	}
	public void setDep_fix_num_year(Double dep_fix_num_year) {
		this.dep_fix_num_year = dep_fix_num_year;
	}
	public Double getMon_dep() {
		return mon_dep;
	}
	public void setMon_dep(Double mon_dep) {
		this.mon_dep = mon_dep;
	}
	public Double getAcc_dep() {
		return acc_dep;
	}
	public void setAcc_dep(Double acc_dep) {
		this.acc_dep = acc_dep;
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
	public Integer getMod_use_id() {
		return mod_use_id;
	}
	public void setMod_use_id(Integer mod_use_id) {
		this.mod_use_id = mod_use_id;
	}
	public String getOrd_num() {
		return ord_num;
	}
	public void setOrd_num(String ord_num) {
		this.ord_num = ord_num;
	}
	public Integer getCou() {
		return cou;
	}
	public void setCou(Integer cou) {
		this.cou = cou;
	}
}
