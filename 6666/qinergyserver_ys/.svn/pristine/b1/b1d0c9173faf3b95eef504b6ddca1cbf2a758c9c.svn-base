package com.qinergy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.qinergy.service.operations.tour.TourTask;

public class JavaTest {
	private static Timer timer = new Timer() ;
	public static void main(String[] args) throws ParseException {
		
		// 首次工作日期
		String first_time = "2018-01-28";
		// 结束时间
		String end_time = "2018-01-30";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date endTime = format.parse(end_time);

		long delay = 2 * 1000L;
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", "1");
		map.put("endTime", endTime);
		
		timer.scheduleAtFixedRate(new TourTask(map), 0,  delay);

		// //修改计划状态为 执行 状态（1：执行2：停止）
//		 Map<String,Object> runFlat = new HashMap<String,Object>();
//		 runFlat.put("id",id);
//		 runFlat.put("run_flat",1);
//		 tourService.updTourPlanFlat(runFlat);
		
		
	}
}
