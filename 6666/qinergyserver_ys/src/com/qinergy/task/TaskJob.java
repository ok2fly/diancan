package com.qinergy.task;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qinergy.dao.others.OthersDao;
import com.qinergy.util.DateUtil;
import com.qinergy.util.EhcacheUtil;

@Component("taskJob")
public class TaskJob {

	@Autowired
	private OthersDao othersDao;
	@Autowired
	private EhcacheUtil ehcacheUtil;

	/**
	 * 每日凌晨0点2分时，定时清理设备实时数据表中的信息
	 * 
	 * @throws ParseException
	 * @throws UnsupportedEncodingException
	 */
//	@Scheduled(cron = "0 5 0 * * ?")
	public void cleanUpEquRelInf() throws ParseException,
			UnsupportedEncodingException {

		try {

			// 每日凌晨0点2分时，定时清理设备实时数据表中的信息
			// 删除交流充电桩充电流程信息数据表
			othersDao.delIscsEquAcChpOrd();
			// 删除交流充电桩充电中实时数据表
			othersDao.delIscsEquAcChpRel();
			// 删除交流充电桩待机数据表
			othersDao.delIscsEquAcChpStd();
			// 删除交流配电柜数据表
			othersDao.delIscsEquAcDb();
			// 删除储能电池实时数据信息表
			othersDao.delIscsEquBms();
			// 删除汇流箱实时数据信息表
			othersDao.delIscsEquBox();
			// 删除电动汽车充电过程信息数据表
			othersDao.delIscsEquChpCarOrd();
			// 删除电动汽车充电信息实时数据表
			othersDao.delIscsEquChpCarSta();
			// 删除控制器信息实时数据表
			othersDao.delIscsEquCtl();
			// 删除直流充电桩充电流程信息数据表
			othersDao.delIscsEquDcChpOrd();
			// 删除直流充电桩充电中实时数据表
			othersDao.delIscsEquDcChpRel();
			// 删除直流充电桩待机状态信息数据表
			othersDao.delIscsEquDcChpStd();
			// 删除直流配电柜信息数据表
			othersDao.delIscsEquDcDb();
			// 删除DC/DC(直流转直流电源)信息数据表
			othersDao.delIscsEquDcdc();
			// 删除解列装置实时数据表
			othersDao.delIscsEquDctDev();
			// 删除环境监测仪实时数据表
			othersDao.delIscsEquEnv();
			// 删除线路保护实时数据表
			othersDao.delIscsEquLnePtt();
			// 删除电表实时数据表
			othersDao.delIscsEquMeter();
			// 删除微网系统实时数据表
			othersDao.delIscsEquMicSys();
			// 删除储能逆变器实时数据表
			othersDao.delIscsEquPcs();
			// 删除电能质量监测装置实时数据表
			othersDao.delIscsEquPqsms();
			// 删除光伏逆变器实时数据表
			othersDao.delIscsEquPvs();
			// 删除变压器实时数据表
			othersDao.delIscsEquTransf();

		} catch (Exception e) {

			System.err.println(e);
		}
	}

	/**
	 * 每一分钟进行一次通知消息信息检测与创建
	 * 
	 * @throws ParseException
	 * @throws UnsupportedEncodingException
	 */
	@Scheduled(cron = "0 * * * * ?")
	private void genNoticeInf() throws ParseException,
			UnsupportedEncodingException {

		try {
			
			// 时间处理方法
			SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
			
			Date crtTim = new Date();
			// 以下为处理当前时间,并将当前时间减一
			Calendar cal=Calendar.getInstance();
			
			cal.setTime(crtTim);
			
			cal.add(Calendar.MINUTE, -1);//1分钟前
			
			String sta_tim = sdf.format(cal.getTime());
			
			String end_tim = sdf.format(crtTim);
			
			// 构建传入参数集合
			Map<String, Object> inpMap = new HashMap<String, Object>();
			// 开始时间
			inpMap.put("sta_tim", sta_tim);
			// 结束时间
			inpMap.put("end_tim", end_tim);
			// 获取系统中与当前人有关的设备,以当前时间为准1分钟以内的所有发生的告警
			List<Map<String, Object>> fauLst = othersDao.getEquNumByFau(inpMap);
			
			if(fauLst != null && !fauLst.isEmpty() && fauLst.get(0) != null){
				// 遍历该集合
				for(Map<String, Object> fauMap:fauLst){
					// 判断如果有告警,且状态为1,则该告警正在发生,将此状态告警记录到通知表中
					if(fauMap.get("flag").toString().equals("1")){
						
						Map<String, Object> instMap = new HashMap<String, Object>();

						instMap.put("fau_id", fauMap.get("id"));

						instMap.put("fau_level", fauMap.get("level"));

						instMap.put("fau_num", fauMap.get("num"));

						instMap.put("fau_info", fauMap.get("info"));

						instMap.put("fau_time", fauMap.get("time"));

						instMap.put("equ_id", fauMap.get("equ_id"));

						instMap.put("equ_num", fauMap.get("equ_num"));

						instMap.put("app_typ_ide", fauMap.get("typ_ide"));

						instMap.put("app_typ_id", fauMap.get("app_typ_id"));

						instMap.put("pws_id", fauMap.get("pws_id"));
						// 添加通知信息 
						othersDao.insNoticeInf(instMap);
						// 判断如果有告警,且状态为0,则该告警已经小时,需要将通知表中的告警信息状态,设置为通知关闭状态
					}else if(fauMap.get("flag").toString().equals("0")){
						
						Map<String, Object> instMap = new HashMap<String, Object>();
						// 设备编号
						instMap.put("equ_num", fauMap.get("PID"));
						// 告警信息
						instMap.put("info", fauMap.get("info"));
						// 通过设备编号更新通知状态
						othersDao.updNoticeStateByEquNumFauTim(instMap);
					}
				}
			}
		} catch (Exception e) {

			System.err.println(e);
		}
	}

}