package com.qinergy.service.operations.tour;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import com.qinergy.util.SpringContextUtil;

public class TourTask extends TimerTask {

	private TourService tourService;

	private Map<String, Object> map;
	
	private Date endTime;

	
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public TourTask(Map<String, Object> map) {
		super();
		tourService = SpringContextUtil.getBean("tourServiceImpl");
		this.map = map;
		//endTime = (Date) map.get("endTime");
		
		 try {
			endTime = format.parse(map.get("endTime").toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TourTask() {
		super();
	}

	@Override
	public void run() {
		try {
			if (tourService == null) {
				System.out.println("---> null");
			}
			
			System.out.println(new Date() + "------???"+new Date().getTime()+"***************************");
			System.out.println(map.get("endTime").toString()+"+++++++???"+endTime.getTime()+"***************************************");
			
			if (new Date().getTime() > endTime.getTime()) {
				
				this.cancel();
				System.out.println("---> 结束 ");
				//修改计划状态为 执行 状态（1：执行2：停止）
				Map<String, Object> runFlat = new HashMap<String, Object>();
				runFlat.put("id", map.get("id"));
				runFlat.put("run_flat", 2);
				tourService.updTourPlanFlat(runFlat);
				
			} else {
				
				this.tourService.updTourPlanRunFlat(this.map);
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
