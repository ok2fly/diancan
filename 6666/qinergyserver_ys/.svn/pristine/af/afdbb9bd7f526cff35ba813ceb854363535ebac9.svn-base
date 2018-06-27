package com.qinergy.controller.operations.tour;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.qinergy.util.DateUtil;

/**
 * 巡视与检修计划定时类
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
public class TourPlanTime {
	
	public static String TourPlanTime(String first_tim,String end_tim,Integer freq) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		/* HOUR_OF_DAY 指示一天中的小时 */
		// curTim = "2018-03-10 01:23:13";// 从系统获取的
		
		Calendar calendar2 = Calendar.getInstance();
		
		/* HOUR_OF_DAY 指示一天中的小时 */
		 //first_tim = "2018-01-01 01:23:13";// 从数据库获取的
		 //end_tim = "2018-05-01 00:00:00";// 从数据库获取的
		
		String frt_hour = first_tim.split(" ")[1];
		
		// 2018-03-01没有超过当前时间
		// 2018-05-01超过了当前时间
		calendar2.setTime(sdf.parse(first_tim));
		
		int year2 = calendar2.get(Calendar.YEAR);
		
		int month2 = calendar2.get(Calendar.MONTH)+1;
		
		int day2 = calendar2.get(Calendar.DATE);
		
		//freq = 2;// 从数据库获取的
		
		// 下一次，是上一次已经执行完了，下一次还没执行
		// 当前还没执行，下一次的时间一定超过当前时间

		String next_tim = "";
		
		long netL = 0;
		
		for(int i=1;i<1000000000;i++){
			
			if(month2+freq>12){
				
				year2=year2+(month2+freq)/12;
				
				month2 = (month2+freq)%12;
			}else{
				month2 = month2+freq;
			}
			next_tim = year2+"-"+month2+"-"+day2+" "+frt_hour;
			// 以为下次时间
			netL = sdf.parse(next_tim).getTime();
			
			if(netL>(new Date()).getTime()){
				
				break;
				
			}
		}
		
		if(sdf.parse(end_tim).getTime()<netL){
			
			next_tim = "计划已过期";
		}
		
		System.out.println(next_tim);
		
		return next_tim;
		
	}

}
