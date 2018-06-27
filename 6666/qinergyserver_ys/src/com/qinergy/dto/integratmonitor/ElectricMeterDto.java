package com.qinergy.dto.integratmonitor;

import java.util.Date;

public class ElectricMeterDto {

	/** id */
	private String id;
	/** 设备编号 */
	private String equ_num;
	/** 通讯状态（0：通讯中断、1：正常运行） */
	private Integer stat;
	/** 电压变比 */
	private Double pt;
	/** 电流变比 */
	private Double ct;

	private Double uab; // Uab线电压
	private Double ubc; // Ubc线电压
	private Double uca; // Uca线电压
	private Double ua; // A 相电压
	private Double ub; // B 相电压
	private Double uc; // C 相电压
	private Double ia; // A 相电流
	private Double ib; // B 相电流
	private Double ic; // C 相电流
	private Double pa; // A相有功
	private Double pb; // B相有功
	private Double pc; // C相有功
	private Double psum; // 有功功率
	private Double qsum; // 无功功率
	private Double ssum; // 视在功率

	private Double phiValue; // 正向有功电度表值
	private Double pheValue; // 反向有功电度表值
	private Double qhiValue; // 正向无功电度表值
	private Double qheValue; // 反向无功电度表值
	private Double phi; // 正向有功电度
	private Double phe; // 反向有功电度
	private Double qhi; // 正向无功电度
	private Double qhe; // 反向无功电度
	private Double phiTop; // 峰正向有功电度
	private Double pheTop; // 峰反向有功电度
	private Double qhiTop; // 峰正向无功电度
	private Double qheTop; // 峰反向无功电度
	private Double phiVal; // 谷正向有功电度
	private Double pheVal; // 谷反向有功电度
	private Double qhiVal; // 谷正向无功电度
	private Double qheVal; // 谷反向无功电度
	private Double phiFlat; // 平正向有功电度
	private Double pheFlat; // 平反向有功电度
	private Double qhiFlat; // 平正向无功电度
	private Double qheFlat; // 平反向无功电度
	private Double phiPeak; // 尖正向有功电度
	private Double phePeak; // 尖反向有功电度
	private Double qhiPeak; // 尖正向无功电度
	private Double qhePeak; // 尖反向无功电度
	private Double freq; // 频率
	private Double pf; // 功率因数
	
	
	/** 健康状态 */
	private Integer healthStat;
	/** 添加时间 */
	private Date crtTim;
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEqu_num() {
		return equ_num;
	}
	public void setEqu_num(String equ_num) {
		this.equ_num = equ_num;
	}
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	public Double getPt() {
		return pt;
	}
	public void setPt(Double pt) {
		this.pt = pt;
	}
	public Double getCt() {
		return ct;
	}
	public void setCt(Double ct) {
		this.ct = ct;
	}
	public Double getUab() {
		return uab;
	}
	public void setUab(Double uab) {
		this.uab = uab;
	}
	public Double getUbc() {
		return ubc;
	}
	public void setUbc(Double ubc) {
		this.ubc = ubc;
	}
	public Double getUca() {
		return uca;
	}
	public void setUca(Double uca) {
		this.uca = uca;
	}
	public Double getUa() {
		return ua;
	}
	public void setUa(Double ua) {
		this.ua = ua;
	}
	public Double getUb() {
		return ub;
	}
	public void setUb(Double ub) {
		this.ub = ub;
	}
	public Double getUc() {
		return uc;
	}
	public void setUc(Double uc) {
		this.uc = uc;
	}
	public Double getIa() {
		return ia;
	}
	public void setIa(Double ia) {
		this.ia = ia;
	}
	public Double getIb() {
		return ib;
	}
	public void setIb(Double ib) {
		this.ib = ib;
	}
	public Double getIc() {
		return ic;
	}
	public void setIc(Double ic) {
		this.ic = ic;
	}
	public Double getPa() {
		return pa;
	}
	public void setPa(Double pa) {
		this.pa = pa;
	}
	public Double getPb() {
		return pb;
	}
	public void setPb(Double pb) {
		this.pb = pb;
	}
	public Double getPc() {
		return pc;
	}
	public void setPc(Double pc) {
		this.pc = pc;
	}
	public Double getPsum() {
		return psum;
	}
	public void setPsum(Double psum) {
		this.psum = psum;
	}
	public Double getQsum() {
		return qsum;
	}
	public void setQsum(Double qsum) {
		this.qsum = qsum;
	}
	public Double getSsum() {
		return ssum;
	}
	public void setSsum(Double ssum) {
		this.ssum = ssum;
	}
	public Double getPhiValue() {
		return phiValue;
	}
	public void setPhiValue(Double phiValue) {
		this.phiValue = phiValue;
	}
	public Double getPheValue() {
		return pheValue;
	}
	public void setPheValue(Double pheValue) {
		this.pheValue = pheValue;
	}
	public Double getQhiValue() {
		return qhiValue;
	}
	public void setQhiValue(Double qhiValue) {
		this.qhiValue = qhiValue;
	}
	public Double getQheValue() {
		return qheValue;
	}
	public void setQheValue(Double qheValue) {
		this.qheValue = qheValue;
	}
	public Double getPhi() {
		return phi;
	}
	public void setPhi(Double phi) {
		this.phi = phi;
	}
	public Double getPhe() {
		return phe;
	}
	public void setPhe(Double phe) {
		this.phe = phe;
	}
	public Double getQhi() {
		return qhi;
	}
	public void setQhi(Double qhi) {
		this.qhi = qhi;
	}
	public Double getQhe() {
		return qhe;
	}
	public void setQhe(Double qhe) {
		this.qhe = qhe;
	}
	public Double getPhiTop() {
		return phiTop;
	}
	public void setPhiTop(Double phiTop) {
		this.phiTop = phiTop;
	}
	public Double getPheTop() {
		return pheTop;
	}
	public void setPheTop(Double pheTop) {
		this.pheTop = pheTop;
	}
	public Double getQhiTop() {
		return qhiTop;
	}
	public void setQhiTop(Double qhiTop) {
		this.qhiTop = qhiTop;
	}
	public Double getQheTop() {
		return qheTop;
	}
	public void setQheTop(Double qheTop) {
		this.qheTop = qheTop;
	}
	public Double getPhiVal() {
		return phiVal;
	}
	public void setPhiVal(Double phiVal) {
		this.phiVal = phiVal;
	}
	public Double getPheVal() {
		return pheVal;
	}
	public void setPheVal(Double pheVal) {
		this.pheVal = pheVal;
	}
	public Double getQhiVal() {
		return qhiVal;
	}
	public void setQhiVal(Double qhiVal) {
		this.qhiVal = qhiVal;
	}
	public Double getQheVal() {
		return qheVal;
	}
	public void setQheVal(Double qheVal) {
		this.qheVal = qheVal;
	}
	public Double getPhiFlat() {
		return phiFlat;
	}
	public void setPhiFlat(Double phiFlat) {
		this.phiFlat = phiFlat;
	}
	public Double getPheFlat() {
		return pheFlat;
	}
	public void setPheFlat(Double pheFlat) {
		this.pheFlat = pheFlat;
	}
	public Double getQhiFlat() {
		return qhiFlat;
	}
	public void setQhiFlat(Double qhiFlat) {
		this.qhiFlat = qhiFlat;
	}
	public Double getQheFlat() {
		return qheFlat;
	}
	public void setQheFlat(Double qheFlat) {
		this.qheFlat = qheFlat;
	}
	public Double getPhiPeak() {
		return phiPeak;
	}
	public void setPhiPeak(Double phiPeak) {
		this.phiPeak = phiPeak;
	}
	public Double getPhePeak() {
		return phePeak;
	}
	public void setPhePeak(Double phePeak) {
		this.phePeak = phePeak;
	}
	public Double getQhiPeak() {
		return qhiPeak;
	}
	public void setQhiPeak(Double qhiPeak) {
		this.qhiPeak = qhiPeak;
	}
	public Double getQhePeak() {
		return qhePeak;
	}
	public void setQhePeak(Double qhePeak) {
		this.qhePeak = qhePeak;
	}
	public Double getFreq() {
		return freq;
	}
	public void setFreq(Double freq) {
		this.freq = freq;
	}
	public Double getPf() {
		return pf;
	}
	public void setPf(Double pf) {
		this.pf = pf;
	}
	public Integer getHealthStat() {
		return healthStat;
	}
	public void setHealthStat(Integer healthStat) {
		this.healthStat = healthStat;
	}
	public Date getCrtTim() {
		return crtTim;
	}
	public void setCrtTim(Date crtTim) {
		this.crtTim = crtTim;
	}

	
	
}
