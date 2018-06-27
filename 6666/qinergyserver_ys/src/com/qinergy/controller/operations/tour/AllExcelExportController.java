package com.qinergy.controller.operations.tour;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.service.operations.tour.TourService;
import com.qinergy.service.statisticanalysis.StatisticAnalysisService;
import com.qinergy.util.MobileConfig;

/**
 * excel导出功能
 * @author Administrator
 *
 */

@Controller
@RequestMapping
public class AllExcelExportController {

	// 声明
	private static Logger log = Logger.getLogger(TourController.class);
	
	@Autowired
	private TourService tourService;

	@Autowired
	private StatisticAnalysisService statisticAnalysisService;
	
	/**
	 *
	 * 巡视计划列表导出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/TourPlanExport")
	@ResponseBody
	public BaseTransferEntity TourPlanExport(HttpServletRequest request,HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			// 获取巡视计划的列表
			lst = tourService.selTourPlanAll(map);

			// 定义表的标题
			String title = "巡视计划列表一览";

			// 定义表的列名
			String[] rowsName = new String[] {"序号", "计划名称", "巡视路线id", "首次工作日期",
					"下次工作日期", "频率", "巡视工期", "自动结束时间", "运行状态", "任务派发人" };

			// 定义表的内容
			List<Object[]> dataList = new ArrayList<Object[]>();

			Object[] objs = null;

			for (int i = 0; i < lst.size(); i++) {
				
				objs = new Object[rowsName.length];
				
				
				objs[0] = lst.get(i).get("tour_plan_name");
				//开始放置数据
				
				if (lst.get(i) == null || lst.get(i).get("tour_plan_name") == null || lst.get(i).get("tour_plan_name").toString().isEmpty()) {
					objs[1] = "无";
				}else{
					
					objs[1] = lst.get(i).get("tour_plan_name");
				}
				
				if (lst.get(i) == null || lst.get(i).get("tour_route_id") == null) {
					objs[2] = "无";
				}else{
					
					objs[2] = lst.get(i).get("tour_route_id");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("first_time") == null || lst.get(i).get("first_time").toString().isEmpty()) {
					objs[3] = "无";
				}else{
					
					objs[3] = lst.get(i).get("first_time");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("next_time") == null || lst.get(i).get("next_time").toString().isEmpty()) {
					objs[4] = "无";
				}else{
					
					objs[4] = lst.get(i).get("next_time");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("frequency") == null || lst.get(i).get("frequency").toString().isEmpty()) {
					objs[5] = "无";
				}else{
					
					objs[5] = lst.get(i).get("frequency");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("plan_tour_time") == null || lst.get(i).get("plan_tour_time").toString().isEmpty()) {
					objs[6] = "无";
				}else{
					
					objs[6] = lst.get(i).get("plan_tour_time");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("end_time") == null || lst.get(i).get("end_time").toString().isEmpty()) {
					objs[7] = "无";
				}else{
					
					objs[7] = lst.get(i).get("end_time");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("run_flat") == null || lst.get(i).get("run_flat").toString().isEmpty()) {
					objs[8] = "无";
				}else{
					
					objs[8] = lst.get(i).get("run_flat");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("crt_nam") == null || lst.get(i).get("crt_nam").toString().isEmpty()) {
					objs[9] = "无";
				}else{
					
					objs[9] = lst.get(i).get("crt_nam");
					
				}

				dataList.add(objs);
			}

			// 创建ExportExcel对象
			ExportExcel ex = new ExportExcel(title, rowsName, dataList);

			// 输出Excel文件
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition","attachment; filename=TourPlan.xls");
			response.setContentType("application/msexcel");
			ex.export(output);
			output.close();

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController TourPlanExport--------->"+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}
	
	/**
	 *
	 * 检修计划列表导出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/OverhaulPlanExport")
	@ResponseBody
	public BaseTransferEntity OverhaulPlanExport(HttpServletRequest request,HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			// 获取检修计划的列表
			lst = tourService.selOverhaulPlanAll(map);

			// 定义表的标题
			String title = "检修计划列表一览";

			// 定义表的列名
			String[] rowsName = new String[] {"序号","计划名称","巡视路线id","首次工作日期",
					"下次工作日期","频率","巡视工期","自动结束时间","运行状态","任务派发人"};

			// 定义表的内容
			List<Object[]> dataList = new ArrayList<Object[]>();

			Object[] objs = null;

			for (int i = 0; i < lst.size(); i++) {
				objs = new Object[rowsName.length];

				objs[0] = lst.get(i).get("tour_plan_name");
				//开始放置数据
				
				if (lst.get(i) == null || lst.get(i).get("tour_plan_name") == null || lst.get(i).get("tour_plan_name").toString().isEmpty()) {
					objs[1] = "无";
				}else{
					objs[1] = lst.get(i).get("tour_plan_name");
				}
				
				
				if (lst.get(i) == null || lst.get(i).get("tour_route_id") == null || lst.get(i).get("tour_route_id").toString().isEmpty()) {
					objs[2] = "无";
				}else{
					objs[2] = lst.get(i).get("tour_route_id");
				}
				
				
				if (lst.get(i) == null || lst.get(i).get("first_time") == null || lst.get(i).get("first_time").toString().isEmpty()) {
					objs[3] = "无";
				}else{
					objs[3] = lst.get(i).get("first_time");
				}
				
				
				if (lst.get(i) == null || lst.get(i).get("next_time") == null || lst.get(i).get("next_time").toString().isEmpty()) {
					objs[4] = "无";
				}else{
					objs[4] = lst.get(i).get("next_time");
				}
				
				
				if (lst.get(i) == null || lst.get(i).get("frequency") == null || lst.get(i).get("frequency").toString().isEmpty()) {
					objs[5] = "无";
				}else{
					objs[5] = lst.get(i).get("frequency");
				}
				
				
				if (lst.get(i) == null || lst.get(i).get("plan_tour_time") == null || lst.get(i).get("plan_tour_time").toString().isEmpty()) {
					objs[6] = "无";
				}else{
					objs[6] = lst.get(i).get("plan_tour_time");
				}
				
				
				if (lst.get(i) == null || lst.get(i).get("end_time") == null || lst.get(i).get("end_time").toString().isEmpty()) {
					objs[7] = "无";
				}else{
					objs[7] = lst.get(i).get("end_time");
				}
				
				
				if (lst.get(i) == null || lst.get(i).get("run_flat") == null || lst.get(i).get("run_flat").toString().isEmpty()) {
					objs[8] = "无";
				}else{
					objs[8] = lst.get(i).get("run_flat");
				}
				
				
				if (lst.get(i) == null || lst.get(i).get("crt_nam") == null || lst.get(i).get("crt_nam").toString().isEmpty()) {
					objs[9] = "无";
				}else{
					objs[9] = lst.get(i).get("crt_nam");
				}
				

				dataList.add(objs);
			}

			// 创建ExportExcel对象
			ExportExcel ex = new ExportExcel(title, rowsName, dataList);

			// 输出Excel文件
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition","attachment; filename=OverhaulPlan.xls");
			response.setContentType("application/msexcel");
			ex.export(output);
			output.close();

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController OverhaulPlanExport--------->"+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}

	
	
	
	

	/**
	 *
	 * 采集数据列表导出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/CollectDataLstExport")
	@ResponseBody
	public BaseTransferEntity CollectDataLstExport(HttpServletRequest request,HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 站ID
			String pws_id = request.getParameter("pws_id");
			// 设备编码
			String equ_num = request.getParameter("equ_num");
			// 指定时间段开始时间
			String sta_tim = request.getParameter("sta_tim");
			// 指定时间段结束时间
			String end_tim = request.getParameter("end_tim");

			String typ_ide = request.getParameter("typ_ide");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("pws_id", pws_id);

			map.put("equ_num", equ_num);

			map.put("sta_tim", sta_tim);

			map.put("end_tim", end_tim);

			map.put("typ_ide", typ_ide);
			
			lst = statisticAnalysisService.getCollectDataLst(map);
			
			if (map.get("typ_ide").toString().equals("CNNBQ")) {

				CNNBQ(response, lst);
			}

			if (map.get("typ_ide").toString().equals("DCDC")) {
				
				DCDC(response, lst);
			}

			if (map.get("typ_ide").toString().equals("BYQ")) {
				
				BYQ(response, lst);
			}

			if (map.get("typ_ide").toString().equals("DB")) {
				
				DB(response, lst);
			}

			if (map.get("typ_ide").toString().equals("DNZLJCZZ")) {
				
				DNZLJCZZ(response, lst);
			}

			if (map.get("typ_ide").toString().equals("HLX")) {
				
				HLX(response, lst);
			}

			if (map.get("typ_ide").toString().equals("JLPDG")) {

				JLPDG(response, lst);

			}

			if (map.get("typ_ide").toString().equals("ZLPDG")) {

				ZLPDG(response, lst);

			}

			if (map.get("typ_ide").toString().equals("HJJCY")) {

				HJJCY(response,lst);

			}

			if (map.get("typ_ide").toString().equals("JLZZ")) {

				JLZZ(response, lst);

			}

			if (map.get("typ_ide").toString().equals("XLBH")) {

				XLBH(response, lst);

			}

			if (map.get("typ_ide").toString().equals("ZLCDZLC")) {

				ZLCDZLC(response, lst);

			}

			if (map.get("typ_ide").toString().equals("ZLCDZSS")) {

				ZLCDZSS(response, lst);

			}

			if (map.get("typ_ide").toString().equals("ZLCDZDJ")) {

				ZLCDZDJ(response, lst);

			}

			if (map.get("typ_ide").toString().equals("DDQCSS")) {

				DDQCSS(response, lst);

			}

			if (map.get("typ_ide").toString().equals("DDQCGC")) {

				DDQCGC(response, lst);

			}

			if (map.get("typ_ide").toString().equals("JLCDZLC")) {

				JLCDZLC(response, lst);

			}

			if (map.get("typ_ide").toString().equals("JLCDZSS")) {

				JLCDZSS(response, lst);

			}

			if (map.get("typ_ide").toString().equals("JLCDZDJ")) {

				JLCDZDJ(response, lst);

			}

			if (map.get("typ_ide").toString().equals("GFNBQ")) {

				GFNBQ(response, lst);

			}

			if (map.get("typ_ide").toString().equals("KZQ")) {

				KZQ(response, lst);
			}
			
			if (map.get("typ_ide").toString().equals("CNDC")) {
				
				CNDC(response, lst);
		
			}
			if (map.get("typ_ide").toString().equals("WWXT")) {
				
				WWXT(response, lst);
		
			}
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(null);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController CollectDataLstExport--------->"+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}



	private void CNDC(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----储能电池数据信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态",
				
				"电池状态","告警码",
				
				"温度模块数量","单体电池数量",
				
				"最高电压位置","最低电压位置",
				
				"最高温度位置","最低温度位置",
				
				"总电压","总电流","总功率",
				
				"SOC","额定容量",
				
				"累计充电电量","累计放电电量","可充电电量","可放电电量",
				
				"最高电压","最低电压","最高温度","最低温度",
				
				"最大允许充电电流","最大允许放电电流",
				
				"最高允许工作温度","最低允许工作温度",
				
				"最高允许充电单体电压","最低允许充电单体电压",
				
				"健康状态","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("equ_num");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("statBatts") == null || lst.get(i).get("statBatts").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				
				objs[3] = lst.get(i).get("statBatts");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				
				objs[4] = lst.get(i).get("faultCode");
			}
			
			if (lst.get(i) == null || lst.get(i).get("tempNum") == null || lst.get(i).get("tempNum").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				
				objs[5] = lst.get(i).get("tempNum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ucellNum") == null || lst.get(i).get("ucellNum").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				
				objs[6] = lst.get(i).get("ucellNum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("hvSN") == null || lst.get(i).get("hvSN").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				
				objs[7] = lst.get(i).get("hvSN");
			}
			
			if (lst.get(i) == null || lst.get(i).get("mvSN") == null || lst.get(i).get("mvSN").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				
				objs[8] = lst.get(i).get("mvSN");
			}
			
			if (lst.get(i) == null || lst.get(i).get("htSN") == null || lst.get(i).get("htSN").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				
				objs[9] = lst.get(i).get("htSN");
			}
			
			if (lst.get(i) == null || lst.get(i).get("mtSN") == null || lst.get(i).get("mtSN").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				
				objs[10] = lst.get(i).get("mtSN");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc") == null || lst.get(i).get("udc").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				
				objs[11] = lst.get(i).get("udc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc") == null || lst.get(i).get("idc").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				
				objs[12] = lst.get(i).get("idc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc") == null || lst.get(i).get("pdc").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				
				objs[13] = lst.get(i).get("pdc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("soc") == null || lst.get(i).get("soc").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				
				objs[14] = lst.get(i).get("soc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("capacity") == null || lst.get(i).get("capacity").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				
				objs[15] = lst.get(i).get("capacity");
			}
			
			if (lst.get(i) == null || lst.get(i).get("chg") == null || lst.get(i).get("chg").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				
				objs[16] = lst.get(i).get("chg");
			}
			
			if (lst.get(i) == null || lst.get(i).get("dischg") == null || lst.get(i).get("dischg").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				
				objs[17] = lst.get(i).get("dischg");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rechg") == null || lst.get(i).get("rechg").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				
				objs[18] = lst.get(i).get("rechg");
			}
			
			if (lst.get(i) == null || lst.get(i).get("redischg") == null || lst.get(i).get("redischg").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				
				objs[19] = lst.get(i).get("redischg");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uHigh") == null || lst.get(i).get("uHigh").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				
				objs[20] = lst.get(i).get("uHigh");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uLow") == null || lst.get(i).get("uLow").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				
				objs[21] = lst.get(i).get("uLow");
			}
			
			if (lst.get(i) == null || lst.get(i).get("tempHigh") == null || lst.get(i).get("tempHigh").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				
				objs[22] = lst.get(i).get("tempHigh");
			}
			
			if (lst.get(i) == null || lst.get(i).get("tempLow") == null || lst.get(i).get("tempLow").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				
				objs[23] = lst.get(i).get("tempLow");
			}
			
			if (lst.get(i) == null || lst.get(i).get("iChgMax") == null || lst.get(i).get("iChgMax").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				
				objs[24] = lst.get(i).get("iChgMax");
			}
			
			if (lst.get(i) == null || lst.get(i).get("iDischgMax") == null || lst.get(i).get("iDischgMax").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				
				objs[25] = lst.get(i).get("iDischgMax");
			}
			
			if (lst.get(i) == null || lst.get(i).get("tempHighLimit") == null || lst.get(i).get("tempHighLimit").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				
				objs[26] = lst.get(i).get("tempHighLimit");
			}
			
			if (lst.get(i) == null || lst.get(i).get("tempLowLimit") == null || lst.get(i).get("tempLowLimit").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				
				objs[27] = lst.get(i).get("tempLowLimit");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uHighCell") == null || lst.get(i).get("uHighCell").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				
				objs[28] = lst.get(i).get("uHighCell");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ulowCell") == null || lst.get(i).get("ulowCell").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				
				objs[29] = lst.get(i).get("ulowCell");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				
				objs[30] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[31] = "无";
			}else {
				
				objs[31] = lst.get(i).get("crtTim");
			}
			
		
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}

	
	
	private void KZQ(HttpServletResponse response, List<Map<String, Object>> lst)
			throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----控制器数据信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","信号强度",
				
				"上行流量","下行流量",
				
				"ICCID","卡号","健康状态","创建时间",
				
				"设备状态" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("equ_num");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("signal") == null || lst.get(i).get("signal").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("signal");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uplink") == null || lst.get(i).get("uplink").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("uplink");
			}
			
			if (lst.get(i) == null || lst.get(i).get("downlink") == null || lst.get(i).get("downlink").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("downlink");
			}
			
			if (lst.get(i) == null || lst.get(i).get("iccid") == null || lst.get(i).get("iccid").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("iccid");
			}
			
			if (lst.get(i) == null || lst.get(i).get("phone") == null || lst.get(i).get("phone").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("phone");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("crtTim");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("stat");
			}
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}
	
	
	
	private void WWXT(HttpServletResponse response, List<Map<String, Object>> lst)
			throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----微网系统数据信息";
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","运行状态","工作模式","并离网状态","告警码","信号强度",
				
				"上行流量","下行流量","ICCID","卡号","电网总有功","电网总无功","负荷总有功","负荷总无功","储能总有功","储能总无功",
				"光伏总有功","光伏总无功","充电桩总有功","充电桩总无功","电网输入电量","馈网电量","负荷用电电量","储能充电电量","储能放电电量",
				"光伏发电电量","充电桩用电电量","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("equ_num");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("mode") == null || lst.get(i).get("mode").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				
				objs[3] = lst.get(i).get("mode");
			}
			
			if (lst.get(i) == null || lst.get(i).get("gridStat") == null || lst.get(i).get("gridStat").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				
				objs[4] = lst.get(i).get("gridStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultNum") == null || lst.get(i).get("faultNum").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				
				objs[5] = lst.get(i).get("faultNum");
			}
			if (lst.get(i) == null || lst.get(i).get("signal") == null || lst.get(i).get("signal").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				
				objs[6] = lst.get(i).get("signal");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uplink") == null || lst.get(i).get("uplink").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("uplink");
			}
			
			if (lst.get(i) == null || lst.get(i).get("downlink") == null || lst.get(i).get("downlink").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("downlink");
			}
			
			if (lst.get(i) == null || lst.get(i).get("iccid") == null || lst.get(i).get("iccid").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("iccid");
			}
			
			if (lst.get(i) == null || lst.get(i).get("phone") == null || lst.get(i).get("phone").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("phone");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("pGrid") == null || lst.get(i).get("pGrid").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("pGrid");
			}
			if (lst.get(i) == null || lst.get(i).get("qGrid") == null || lst.get(i).get("qGrid").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("qGrid");
			}
			if (lst.get(i) == null || lst.get(i).get("pLoad") == null || lst.get(i).get("pLoad").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("pLoad");
			}
			if (lst.get(i) == null || lst.get(i).get("qLoad") == null || lst.get(i).get("qLoad").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("qLoad");
			}
			if (lst.get(i) == null || lst.get(i).get("pBatts") == null || lst.get(i).get("pBatts").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("pBatts");
			}
			if (lst.get(i) == null || lst.get(i).get("qBatts") == null || lst.get(i).get("qBatts").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("qBatts");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("pPV") == null || lst.get(i).get("pPV").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("pPV");
			}
			if (lst.get(i) == null || lst.get(i).get("qPV") == null || lst.get(i).get("qPV").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("qPV");
			}
			if (lst.get(i) == null || lst.get(i).get("pEV") == null || lst.get(i).get("pEV").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("pEV");
			}
			if (lst.get(i) == null || lst.get(i).get("qEV") == null || lst.get(i).get("qEV").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("qEV");
			}
			if (lst.get(i) == null || lst.get(i).get("power4Grid") == null || lst.get(i).get("power4Grid").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				objs[21] = lst.get(i).get("power4Grid");
			}
			if (lst.get(i) == null || lst.get(i).get("power2Grid") == null || lst.get(i).get("power2Grid").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				objs[22] = lst.get(i).get("power2Grid");
			}
			if (lst.get(i) == null || lst.get(i).get("powerLoad") == null || lst.get(i).get("powerLoad").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("powerLoad");
			}
		
			if (lst.get(i) == null || lst.get(i).get("powerCharge") == null || lst.get(i).get("powerCharge").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				objs[24] = lst.get(i).get("powerCharge");
			}
			if (lst.get(i) == null || lst.get(i).get("powerDisCharge") == null || lst.get(i).get("powerDisCharge").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				objs[25] = lst.get(i).get("powerDisCharge");
			}
			if (lst.get(i) == null || lst.get(i).get("powerPV") == null || lst.get(i).get("powerPV").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				objs[26] = lst.get(i).get("powerPV");
			}
			if (lst.get(i) == null || lst.get(i).get("powerEV") == null || lst.get(i).get("powerEV").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				objs[27] = lst.get(i).get("powerEV");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				objs[28] = lst.get(i).get("crtTim");
			}
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}

	
	
	private void GFNBQ(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----光伏逆变器数据信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态","告警码",
				
				"支路数量",
				
				"直流电压1","直流电压2","直流电压3","直流电压4","直流电压5",
				
				"直流电压6","直流电压7","直流电压8","直流电压9","直流电压10",
				
				"直流电流1","直流电流2","直流电流3","直流电流4","直流电流5",
				
				"直流电流6","直流电流7","直流电流8","直流电流9","直流电流10",
				
				"直流功率1","直流功率2","直流功率3","直流功率4","直流功率5",
				
				"直流功率6","直流功率7","直流功率8","直流功率9","直流功率10",
				
				"总直流功率",
				
				"Uab线电压","Ubc线电压","Uca线电压",
				
				"A相电压","B相电压","C相电压",
				
				"A相电流","B相电流","C相电流",
				
				"A相有功","B相有功","C相有功",
				
				"有功功率","无功功率","视在功率",
				
				"功率因数","效率","频率","离散率",
				
				"日发电量","总发电量",
				
				"累计正常运行时间","累计正常停机时间","累计告警运行时间",
				
				"累计故障时间","累计通讯中断时间","累计限电运行时间","累计运行时间",
				
				"机内温度",
				
				"模块1温度","模块2温度","模块3温度","模块4温度","模块5温度","模块6温度",
				
				"正极对地阻抗值","负极对地阻抗值",
				
				"限功率实际值","无功调节实际值",
				
				"健康状态","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("equ_num");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("faultCode");
			}
			
			if (lst.get(i) == null || lst.get(i).get("branchNum") == null || lst.get(i).get("branchNum").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("branchNum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc1") == null || lst.get(i).get("udc1").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("udc1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc2") == null || lst.get(i).get("udc2").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("udc2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc3") == null || lst.get(i).get("udc3").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("udc3");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc4") == null || lst.get(i).get("udc4").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("udc4");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc5") == null || lst.get(i).get("udc5").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("udc5");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc6") == null || lst.get(i).get("udc6").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("udc6");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc7") == null || lst.get(i).get("udc7").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("udc7");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc8") == null || lst.get(i).get("udc8").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("udc8");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc9") == null || lst.get(i).get("udc9").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("udc9");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc10") == null || lst.get(i).get("udc10").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("udc10");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc1") == null || lst.get(i).get("idc1").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("idc1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc2") == null || lst.get(i).get("idc2").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("idc2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc3") == null || lst.get(i).get("idc3").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("idc3");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc4") == null || lst.get(i).get("idc4").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("idc4");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc5") == null || lst.get(i).get("idc5").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("idc5");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc6") == null || lst.get(i).get("idc6").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("idc6");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc7") == null || lst.get(i).get("idc7").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				objs[21] = lst.get(i).get("idc7");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc8") == null || lst.get(i).get("idc8").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				objs[22] = lst.get(i).get("idc8");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc9") == null || lst.get(i).get("idc9").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("idc9");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc10") == null || lst.get(i).get("idc10").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				objs[24] = lst.get(i).get("idc10");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc1") == null || lst.get(i).get("pdc1").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				objs[25] = lst.get(i).get("pdc1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc2") == null || lst.get(i).get("pdc2").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				objs[26] = lst.get(i).get("pdc2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc3") == null || lst.get(i).get("pdc3").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				objs[27] = lst.get(i).get("pdc3");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc4") == null || lst.get(i).get("pdc4").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				objs[28] = lst.get(i).get("pdc4");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc5") == null || lst.get(i).get("pdc5").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				objs[29] = lst.get(i).get("pdc5");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc6") == null || lst.get(i).get("pdc6").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				objs[30] = lst.get(i).get("pdc6");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc7") == null || lst.get(i).get("pdc7").toString().isEmpty()) {
				objs[31] = "无";
			}else {
				objs[31] = lst.get(i).get("pdc7");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc8") == null || lst.get(i).get("pdc8").toString().isEmpty()) {
				objs[32] = "无";
			}else {
				objs[32] = lst.get(i).get("pdc8");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc9") == null || lst.get(i).get("pdc9").toString().isEmpty()) {
				objs[33] = "无";
			}else {
				objs[33] = lst.get(i).get("pdc9");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc10") == null || lst.get(i).get("pdc10").toString().isEmpty()) {
				objs[34] = "无";
			}else {
				objs[34] = lst.get(i).get("pdc10");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdcSum") == null || lst.get(i).get("pdcSum").toString().isEmpty()) {
				objs[35] = "无";
			}else {
				objs[35] = lst.get(i).get("pdcSum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uab") == null || lst.get(i).get("uab").toString().isEmpty()) {
				objs[36] = "无";
			}else {
				objs[36] = lst.get(i).get("uab");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ubc") == null || lst.get(i).get("ubc").toString().isEmpty()) {
				objs[37] = "无";
			}else {
				objs[37] = lst.get(i).get("ubc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uca") == null || lst.get(i).get("uca").toString().isEmpty()) {
				objs[38] = "无";
			}else {
				objs[38] = lst.get(i).get("uca");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ua") == null || lst.get(i).get("ua").toString().isEmpty()) {
				objs[39] = "无";
			}else {
				objs[39] = lst.get(i).get("ua");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ub") == null || lst.get(i).get("ub").toString().isEmpty()) {
				objs[40] = "无";
			}else {
				objs[40] = lst.get(i).get("ub");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uc") == null || lst.get(i).get("uc").toString().isEmpty()) {
				objs[41] = "无";
			}else {
				objs[41] = lst.get(i).get("uc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ia") == null || lst.get(i).get("ia").toString().isEmpty()) {
				objs[42] = "无";
			}else {
				objs[42] = lst.get(i).get("ia");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ib") == null || lst.get(i).get("ib").toString().isEmpty()) {
				objs[43] = "无";
			}else {
				objs[43] = lst.get(i).get("ib");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ic") == null || lst.get(i).get("ic").toString().isEmpty()) {
				objs[44] = "无";
			}else {
				objs[44] = lst.get(i).get("ic");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pa") == null || lst.get(i).get("pa").toString().isEmpty()) {
				objs[45] = "无";
			}else {
				objs[45] = lst.get(i).get("pa");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pb") == null || lst.get(i).get("pb").toString().isEmpty()) {
				objs[46] = "无";
			}else {
				objs[46] = lst.get(i).get("pb");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pc") == null || lst.get(i).get("pc").toString().isEmpty()) {
				objs[47] = "无";
			}else {
				objs[47] = lst.get(i).get("pc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("psum") == null || lst.get(i).get("psum").toString().isEmpty()) {
				objs[48] = "无";
			}else {
				objs[48] = lst.get(i).get("psum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("qsum") == null || lst.get(i).get("qsum").toString().isEmpty()) {
				objs[49] = "无";
			}else {
				objs[49] = lst.get(i).get("qsum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ssum") == null || lst.get(i).get("ssum").toString().isEmpty()) {
				objs[50] = "无";
			}else {
				objs[50] = lst.get(i).get("ssum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pf") == null || lst.get(i).get("pf").toString().isEmpty()) {
				objs[51] = "无";
			}else {
				objs[51] = lst.get(i).get("pf");
			}
			
			if (lst.get(i) == null || lst.get(i).get("eff") == null || lst.get(i).get("eff").toString().isEmpty()) {
				objs[52] = "无";
			}else {
				objs[52] = lst.get(i).get("eff");
			}
			
			if (lst.get(i) == null || lst.get(i).get("freq") == null || lst.get(i).get("freq").toString().isEmpty()) {
				objs[53] = "无";
			}else {
				objs[53] = lst.get(i).get("freq");
			}
			
			if (lst.get(i) == null || lst.get(i).get("disRate") == null || lst.get(i).get("disRate").toString().isEmpty()) {
				objs[54] = "无";
			}else {
				objs[54] = lst.get(i).get("disRate");
			}
			
			if (lst.get(i) == null || lst.get(i).get("powerDay") == null || lst.get(i).get("powerDay").toString().isEmpty()) {
				objs[55] = "无";
			}else {
				objs[55] = lst.get(i).get("powerDay");
			}
			
			if (lst.get(i) == null || lst.get(i).get("powerAll") == null || lst.get(i).get("powerAll").toString().isEmpty()) {
				objs[56] = "无";
			}else {
				objs[56] = lst.get(i).get("powerAll");
			}
			
			if (lst.get(i) == null || lst.get(i).get("goodRunTime") == null || lst.get(i).get("goodRunTime").toString().isEmpty()) {
				objs[57] = "无";
			}else {
				objs[57] = lst.get(i).get("goodRunTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("downTime") == null || lst.get(i).get("downTime").toString().isEmpty()) {
				objs[58] = "无";
			}else {
				objs[58] = lst.get(i).get("downTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultTime") == null || lst.get(i).get("faultTime").toString().isEmpty()) {
				objs[59] = "无";
			}else {
				objs[59] = lst.get(i).get("faultTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("failureTime") == null || lst.get(i).get("failureTime").toString().isEmpty()) {
				objs[60] = "无";
			}else {
				objs[60] = lst.get(i).get("failureTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("comIntTime") == null || lst.get(i).get("comIntTime").toString().isEmpty()) {
				objs[61] = "无";
			}else {
				objs[61] = lst.get(i).get("comIntTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("eleRunTime") == null || lst.get(i).get("eleRunTime").toString().isEmpty()) {
				objs[62] = "无";
			}else {
				objs[62] = lst.get(i).get("eleRunTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("timeAll") == null || lst.get(i).get("timeAll").toString().isEmpty()) {
				objs[63] = "无";
			}else {
				objs[63] = lst.get(i).get("timeAll");
			}
			
			if (lst.get(i) == null || lst.get(i).get("temp") == null || lst.get(i).get("temp").toString().isEmpty()) {
				objs[64] = "无";
			}else {
				objs[64] = lst.get(i).get("temp");
			}
			
			if (lst.get(i) == null || lst.get(i).get("temp1") == null || lst.get(i).get("temp1").toString().isEmpty()) {
				objs[65] = "无";
			}else {
				objs[65] = lst.get(i).get("temp1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("temp2") == null || lst.get(i).get("temp2").toString().isEmpty()) {
				objs[66] = "无";
			}else {
				objs[66] = lst.get(i).get("temp2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("temp3") == null || lst.get(i).get("temp3").toString().isEmpty()) {
				objs[67] = "无";
			}else {
				objs[67] = lst.get(i).get("temp3");
			}
			
			if (lst.get(i) == null || lst.get(i).get("temp4") == null || lst.get(i).get("temp4").toString().isEmpty()) {
				objs[68] = "无";
			}else {
				objs[68] = lst.get(i).get("temp4");
			}
			
			if (lst.get(i) == null || lst.get(i).get("temp5") == null || lst.get(i).get("temp5").toString().isEmpty()) {
				objs[69] = "无";
			}else {
				objs[69] = lst.get(i).get("temp5");
			}
			
			if (lst.get(i) == null || lst.get(i).get("temp6") == null || lst.get(i).get("temp6").toString().isEmpty()) {
				objs[70] = "无";
			}else {
				objs[70] = lst.get(i).get("temp6");
			}
			
			if (lst.get(i) == null || lst.get(i).get("imp1") == null || lst.get(i).get("imp1").toString().isEmpty()) {
				objs[71] = "无";
			}else {
				objs[71] = lst.get(i).get("imp1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("imp2") == null || lst.get(i).get("imp2").toString().isEmpty()) {
				objs[72] = "无";
			}else {
				objs[72] = lst.get(i).get("imp2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("plimit") == null || lst.get(i).get("plimit").toString().isEmpty()) {
				objs[73] = "无";
			}else {
				objs[73] = lst.get(i).get("plimit");
			}
			
			if (lst.get(i) == null || lst.get(i).get("qlimit") == null || lst.get(i).get("qlimit").toString().isEmpty()) {
				objs[74] = "无";
			}else {
				objs[74] = lst.get(i).get("qlimit");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[75] = "无";
			}else {
				objs[75] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[76] = "无";
			}else {
				objs[76] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}

	
	
	private void JLCDZDJ(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----交流充电桩待机状态数据信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","充电桩编号","设备状态",
				
				"枪链接状态","告警码",
				
				"累计充电时间(h)","累计充电电量(kWh)","累计充电金额","有效充电小时数(h)",
				
				"累计正常运行时间","累计正常停机时间","累计告警运行时间","累计故障停机时间","累计通讯中断时间","累计运行时间",
				
				"累计充电次数",
				
				"健康状态","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("pileNo") == null || lst.get(i).get("pileNo").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("pileNo");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("gunStat") == null || lst.get(i).get("gunStat").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("gunStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("faultCode");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cumTime") == null || lst.get(i).get("cumTime").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("cumTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cumPower") == null || lst.get(i).get("cumPower").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("cumPower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cumMoney") == null || lst.get(i).get("cumMoney").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("cumMoney");
			}
			
			if (lst.get(i) == null || lst.get(i).get("validTime") == null || lst.get(i).get("validTime").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("validTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("goodRunTime") == null || lst.get(i).get("goodRunTime").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("goodRunTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("downTime") == null || lst.get(i).get("downTime").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("downTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultTime") == null || lst.get(i).get("faultTime").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("faultTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("failureTime") == null || lst.get(i).get("failureTime").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("failureTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("comIntTime") == null || lst.get(i).get("comIntTime").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("comIntTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("runTime") == null || lst.get(i).get("runTime").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("runTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("chpCnt") == null || lst.get(i).get("chpCnt").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("chpCnt");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void JLCDZSS(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----交流充电桩充电中实时数据信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","充电单号","充电桩编号",
				
				"设备状态","告警码",
				
				"交流A相充电电压","交流B相充电电压","交流C相充电电压",
				
				"交流A相充电电流","交流B相充电电流","交流C相充电电流",
				
				"充电功率","当前电表读数","本次累计充电费","本次累计充电量",
				
				"充电时长",
				
				"健康状态","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("orderNo") == null || lst.get(i).get("orderNo").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("orderNo");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("pileNo") == null || lst.get(i).get("pileNo").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("pileNo");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("faultCode");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ua") == null || lst.get(i).get("ua").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("ua");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ub") == null || lst.get(i).get("ub").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("ub");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uc") == null || lst.get(i).get("uc").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("uc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ia") == null || lst.get(i).get("ia").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("ia");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ib") == null || lst.get(i).get("ib").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("ib");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ic") == null || lst.get(i).get("ic").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("ic");
			}
			
			if (lst.get(i) == null || lst.get(i).get("power") == null || lst.get(i).get("power").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("power");
			}
			
			if (lst.get(i) == null || lst.get(i).get("currPower") == null || lst.get(i).get("currPower").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("currPower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("money") == null || lst.get(i).get("money").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("money");
			}
			
			if (lst.get(i) == null || lst.get(i).get("tolPower") == null || lst.get(i).get("tolPower").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("tolPower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("time") == null || lst.get(i).get("time").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("time");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void JLCDZLC(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----交流充电桩充电流程信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","充电桩编号","充电单号",
				
				"设备状态","充电过程","枪连接状态",
				
				"付款方式","预付金额","卡号","卡余额","用户账号",
				
				"充电开始时间","初始电表读数","充电结束时间","充电时长","充电电量",
				
				"充电金额","充电结束原因","充电后电表读数","充电后卡余额",
				
				"创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("pileNo") == null || lst.get(i).get("pileNo").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("pileNo");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("orderNo") == null || lst.get(i).get("orderNo").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("orderNo");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("chgStat") == null || lst.get(i).get("chgStat").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("chgStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("gunStat") == null || lst.get(i).get("gunStat").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("gunStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("payWay") == null || lst.get(i).get("payWay").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("payWay");
			}
			
			if (lst.get(i) == null || lst.get(i).get("prePayMoney") == null || lst.get(i).get("prePayMoney").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("prePayMoney");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cardNo") == null || lst.get(i).get("cardNo").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("cardNo");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cardMoney") == null || lst.get(i).get("cardMoney").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("cardMoney");
			}
			
			if (lst.get(i) == null || lst.get(i).get("userAccount") == null || lst.get(i).get("userAccount").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("userAccount");
			}
			
			if (lst.get(i) == null || lst.get(i).get("beginTime") == null || lst.get(i).get("beginTime").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("beginTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("initPower") == null || lst.get(i).get("initPower").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("initPower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("endTime") == null || lst.get(i).get("endTime").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("endTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("time") == null || lst.get(i).get("time").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("time");
			}
			
			if (lst.get(i) == null || lst.get(i).get("power") == null || lst.get(i).get("power").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("power");
			}
			
			if (lst.get(i) == null || lst.get(i).get("money") == null || lst.get(i).get("money").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("money");
			}
			
			if (lst.get(i) == null || lst.get(i).get("endReason") == null || lst.get(i).get("endReason").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("endReason");
			}
			
			if (lst.get(i) == null || lst.get(i).get("endPower") == null || lst.get(i).get("endPower").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("endPower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cardRemMoney") == null || lst.get(i).get("cardRemMoney").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("cardRemMoney");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crt_tim") == null || lst.get(i).get("crt_tim").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("crt_tim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void DDQCGC(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----电动汽车充电过程数据信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","充电单号","充电桩编号",
				
				"当前SOC",
				
				"电池组最低温度","电池组最高温度",
				
				"单体电池最高电压","单体电池最低电压",
				
				"创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("orderNo") == null || lst.get(i).get("orderNo").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("orderNo");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("pileNo") == null || lst.get(i).get("pileNo").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("pileNo");
			}
			
			if (lst.get(i) == null || lst.get(i).get("currSOC") == null || lst.get(i).get("currSOC").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("currSOC");
			}
			
			if (lst.get(i) == null || lst.get(i).get("minTemp") == null || lst.get(i).get("minTemp").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("minTemp");
			}
			
			if (lst.get(i) == null || lst.get(i).get("maxTemp") == null || lst.get(i).get("maxTemp").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("maxTemp");
			}
			
			if (lst.get(i) == null || lst.get(i).get("battMaxU") == null || lst.get(i).get("battMaxU").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("battMaxU");
			}
			
			if (lst.get(i) == null || lst.get(i).get("battMinU") == null || lst.get(i).get("battMinU").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("battMinU");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void DDQCSS(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----电动汽车充电信息实时数据";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","充电单号","充电桩编号",
				
				"充电过程","车辆VIN",
				
				"车辆生产国家","车辆制造商","车辆种类","车辆型号","车辆发动机","车辆功率",
				
				"充电桩与BMS通信协议版本号","BMS与充电桩通信协议版本号","充电桩与BMS握手结果",
				
				"电池类型",
				
				"最高允许温度","BMS最高允许充电电压","单体最高允许充电电压","最高允许充电电流",
				
				"额定总电压","当前电压","额定容量","标称能量",
				
				"开始SOC","停止原因",
				
				"BMS中止充电原因","BMS充电故障原因","BMS中止错误原因","中止荷电状态SOC",
				
				"中止荷电单体最低电压","中止荷电单体最高电压",
				
				"中止荷电最高温度","中止荷电最低温度",
				
				"创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("orderNo") == null || lst.get(i).get("orderNo").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("orderNo");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("pileNo") == null || lst.get(i).get("pileNo").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("pileNo");
			}
			
			if (lst.get(i) == null || lst.get(i).get("chgStat") == null || lst.get(i).get("chgStat").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("chgStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("carVin") == null || lst.get(i).get("carVin").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("carVin");
			}
			
			if (lst.get(i) == null || lst.get(i).get("carMadeIn") == null || lst.get(i).get("carMadeIn").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("carMadeIn");
			}
			
			if (lst.get(i) == null || lst.get(i).get("carManu") == null || lst.get(i).get("carManu").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("carManu");
			}
			
			if (lst.get(i) == null || lst.get(i).get("carType") == null || lst.get(i).get("carType").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("carType");
			}
			
			if (lst.get(i) == null || lst.get(i).get("carModel") == null || lst.get(i).get("carModel").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("carModel");
			}
			
			if (lst.get(i) == null || lst.get(i).get("carEngine") == null || lst.get(i).get("carEngine").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("carEngine");
			}
			
			if (lst.get(i) == null || lst.get(i).get("carCapacity") == null || lst.get(i).get("carCapacity").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("carCapacity");
			}
			
			if (lst.get(i) == null || lst.get(i).get("versionPile") == null || lst.get(i).get("versionPile").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("versionPile");
			}
			
			if (lst.get(i) == null || lst.get(i).get("versionBMS") == null || lst.get(i).get("versionBMS").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("versionBMS");
			}
			
			if (lst.get(i) == null || lst.get(i).get("handshake") == null || lst.get(i).get("handshake").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("handshake");
			}
			
			if (lst.get(i) == null || lst.get(i).get("battType") == null || lst.get(i).get("battType").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("battType");
			}
			
			if (lst.get(i) == null || lst.get(i).get("allowMaxTemp") == null || lst.get(i).get("allowMaxTemp").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("allowMaxTemp");
			}
			
			if (lst.get(i) == null || lst.get(i).get("allowMaxU") == null || lst.get(i).get("allowMaxU").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("allowMaxU");
			}
			
			if (lst.get(i) == null || lst.get(i).get("allowSingleMaxU") == null || lst.get(i).get("allowSingleMaxU").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("allowSingleMaxU");
			}
			
			if (lst.get(i) == null || lst.get(i).get("allowMaxI") == null || lst.get(i).get("allowMaxI").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("allowMaxI");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rateU") == null || lst.get(i).get("rateU").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("rateU");
			}
			
			if (lst.get(i) == null || lst.get(i).get("currU") == null || lst.get(i).get("currU").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("currU");
			}
			
			if (lst.get(i) == null || lst.get(i).get("capacity") == null || lst.get(i).get("capacity").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				objs[21] = lst.get(i).get("capacity");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ratePower") == null || lst.get(i).get("ratePower").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				objs[22] = lst.get(i).get("ratePower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("startSOC") == null || lst.get(i).get("startSOC").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("startSOC");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stopReason") == null || lst.get(i).get("stopReason").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				objs[24] = lst.get(i).get("stopReason");
			}
			
			if (lst.get(i) == null || lst.get(i).get("bmsStopReason") == null || lst.get(i).get("bmsStopReason").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				objs[25] = lst.get(i).get("bmsStopReason");
			}
			
			if (lst.get(i) == null || lst.get(i).get("bmsFaultReason") == null || lst.get(i).get("bmsFaultReason").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				objs[26] = lst.get(i).get("bmsFaultReason");
			}
			
			if (lst.get(i) == null || lst.get(i).get("bmsFaultChaReason") == null || lst.get(i).get("bmsFaultChaReason").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				objs[27] = lst.get(i).get("bmsFaultChaReason");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stopSOC") == null || lst.get(i).get("stopSOC").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				objs[28] = lst.get(i).get("stopSOC");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stopSingleMinU") == null || lst.get(i).get("stopSingleMinU").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				objs[29] = lst.get(i).get("stopSingleMinU");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stopSingleMaxU") == null || lst.get(i).get("stopSingleMaxU").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				objs[30] = lst.get(i).get("stopSingleMaxU");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stopMaxTemper") == null || lst.get(i).get("stopMaxTemper").toString().isEmpty()) {
				objs[31] = "无";
			}else {
				objs[31] = lst.get(i).get("stopMaxTemper");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stopMinTemper") == null || lst.get(i).get("stopMinTemper").toString().isEmpty()) {
				objs[32] = "无";
			}else {
				objs[32] = lst.get(i).get("stopMinTemper");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[33] = "无";
			}else {
				objs[33] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void ZLCDZDJ(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----直流充电桩充电中待机数据信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","充电桩编号","设备状态","告警码",
				
				"枪链接状态",
				
				"累计充电时间","累计充电电量","累计充电金额",
				
				"有效充电小时数(h)",
				
				"累计正常运行时间","累计正常停机时间","累计告警运行时间","累计故障停机时间","累计通讯中断时间","累计运行时间",
				
				"累计充电次数",
				
				"将康状态","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("pileNo") == null || lst.get(i).get("pileNo").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("pileNo");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("faultCode");
			}
			
			if (lst.get(i) == null || lst.get(i).get("gunStat") == null || lst.get(i).get("gunStat").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("gunStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cumTime") == null || lst.get(i).get("cumTime").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("cumTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cumPower") == null || lst.get(i).get("cumPower").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("cumPower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cumMoney") == null || lst.get(i).get("cumMoney").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("cumMoney");
			}
			
			if (lst.get(i) == null || lst.get(i).get("validTime") == null || lst.get(i).get("validTime").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("validTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("goodRunTime") == null || lst.get(i).get("goodRunTime").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("goodRunTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("downTime") == null || lst.get(i).get("downTime").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("downTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultTime") == null || lst.get(i).get("faultTime").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("faultTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("failureTime") == null || lst.get(i).get("failureTime").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("failureTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("comIntTime") == null || lst.get(i).get("comIntTime").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("comIntTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("runTime") == null || lst.get(i).get("runTime").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("runTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("chpCnt") == null || lst.get(i).get("chpCnt").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("chpCnt");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void ZLCDZSS(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----直流充电桩充电中实时数据信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","充电单号","充电桩编号","设备状态","告警码",
				
				"当前SOC(%)","当前电表读数",
				
				"充电电压","充电电流","充电功率",
				
				"BMS需求电压","BMS需求电流","BMS充电模式",
				
				"充电时长","剩余充电时间",
				
				"本次累计充电费","本次累计充电量",
				
				"将康状态","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("orderNo") == null || lst.get(i).get("orderNo").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("orderNo");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("pileNo") == null || lst.get(i).get("pileNo").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("pileNo");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("faultCode");
			}
			
			if (lst.get(i) == null || lst.get(i).get("SOC") == null || lst.get(i).get("SOC").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("SOC");
			}
			
			if (lst.get(i) == null || lst.get(i).get("currPower") == null || lst.get(i).get("currPower").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("currPower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udc") == null || lst.get(i).get("udc").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("udc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idc") == null || lst.get(i).get("idc").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("idc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pdc") == null || lst.get(i).get("pdc").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("pdc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("udcBMS") == null || lst.get(i).get("udcBMS").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("udcBMS");
			}
			
			if (lst.get(i) == null || lst.get(i).get("idcBMS") == null || lst.get(i).get("idcBMS").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("idcBMS");
			}
			
			if (lst.get(i) == null || lst.get(i).get("modeBMS") == null || lst.get(i).get("modeBMS").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("modeBMS");
			}
			
			if (lst.get(i) == null || lst.get(i).get("time") == null || lst.get(i).get("time").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("time");
			}
			
			if (lst.get(i) == null || lst.get(i).get("remTime") == null || lst.get(i).get("remTime").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("remTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("money") == null || lst.get(i).get("money").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("money");
			}
			
			if (lst.get(i) == null || lst.get(i).get("power") == null || lst.get(i).get("power").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("power");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void ZLCDZLC(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----直流充电桩充电流程信息";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","充电单号","充电桩编号","设备状态","充电过程","告警码",
				
				"充电枪口号","枪连接状态","付款方式","预付金额",
				
				"卡号","卡余额","用户账号","充电方式","充电方式参数","充电开始时间",
				
				"最高输出电压","最低输出电压","最大电流","最小电流",
				
				"初始SOC(%)","初始电表读数","充电结束时间","充电时长","充电电量","充电金额",
				
				"结束soc(%)","充电结束原因","充电后电表读数","充电后卡余额",
				
				"创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("orderNo") == null || lst.get(i).get("orderNo").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				
				objs[1] = lst.get(i).get("orderNo");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("pileNo") == null || lst.get(i).get("pileNo").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				
				objs[2] = lst.get(i).get("pileNo");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("chgStat") == null || lst.get(i).get("chgStat").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("chgStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("faultCode");
			}
			
			if (lst.get(i) == null || lst.get(i).get("gunNo") == null || lst.get(i).get("gunNo").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("gunNo");
			}
			
			if (lst.get(i) == null || lst.get(i).get("gunStat") == null || lst.get(i).get("gunStat").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("gunStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("payWay") == null || lst.get(i).get("payWay").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("payWay");
			}
			
			if (lst.get(i) == null || lst.get(i).get("prePayMoney") == null || lst.get(i).get("prePayMoney").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("prePayMoney");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cardNo") == null || lst.get(i).get("cardNo").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("cardNo");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cardMoney") == null || lst.get(i).get("cardMoney").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("cardMoney");
			}
			
			if (lst.get(i) == null || lst.get(i).get("userAccount") == null || lst.get(i).get("userAccount").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("userAccount");
			}
			
			if (lst.get(i) == null || lst.get(i).get("chgType") == null || lst.get(i).get("chgType").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("chgType");
			}
			
			if (lst.get(i) == null || lst.get(i).get("chgTypeParam") == null || lst.get(i).get("chgTypeParam").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("chgTypeParam");
			}
			
			if (lst.get(i) == null || lst.get(i).get("beginTime") == null || lst.get(i).get("beginTime").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("beginTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uMax") == null || lst.get(i).get("uMax").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("uMax");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uMin") == null || lst.get(i).get("uMin").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("uMin");
			}
			
			if (lst.get(i) == null || lst.get(i).get("iMax") == null || lst.get(i).get("iMax").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("iMax");
			}
			
			if (lst.get(i) == null || lst.get(i).get("iMin") == null || lst.get(i).get("iMin").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("iMin");
			}
			
			if (lst.get(i) == null || lst.get(i).get("beginSOC") == null || lst.get(i).get("beginSOC").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("beginSOC");
			}
			
			if (lst.get(i) == null || lst.get(i).get("initPower") == null || lst.get(i).get("initPower").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				objs[21] = lst.get(i).get("initPower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("endTime") == null || lst.get(i).get("endTime").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				objs[22] = lst.get(i).get("endTime");
			}
			
			if (lst.get(i) == null || lst.get(i).get("time") == null || lst.get(i).get("time").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("time");
			}
			
			if (lst.get(i) == null || lst.get(i).get("power") == null || lst.get(i).get("power").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				objs[24] = lst.get(i).get("power");
			}
			
			if (lst.get(i) == null || lst.get(i).get("money") == null || lst.get(i).get("money").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				objs[25] = lst.get(i).get("money");
			}
			
			if (lst.get(i) == null || lst.get(i).get("endSOC") == null || lst.get(i).get("endSOC").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				objs[26] = lst.get(i).get("endSOC");
			}
			
			if (lst.get(i) == null || lst.get(i).get("endReason") == null || lst.get(i).get("endReason").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				objs[27] = lst.get(i).get("endReason");
			}
			
			if (lst.get(i) == null || lst.get(i).get("endPower") == null || lst.get(i).get("endPower").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				objs[28] = lst.get(i).get("endPower");
			}
			
			if (lst.get(i) == null || lst.get(i).get("cardRemMoney") == null || lst.get(i).get("cardRemMoney").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				objs[29] = lst.get(i).get("cardRemMoney");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				objs[30] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void XLBH(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----线路保护";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态","告警码",
				
				"Uab线电压","Ubc线电压","Uca线电压",
				
				"A相电压","B相电压","C相电压",
				
				"A相电流","B相电流","C相电流",
				
				"有功功率","无功功率","视在功率","频率",
				
				"健康状态","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("faultCode");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uab") == null || lst.get(i).get("uab").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("uab");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ubc") == null || lst.get(i).get("ubc").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("ubc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uca") == null || lst.get(i).get("uca").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("uca");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ua") == null || lst.get(i).get("ua").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("ua");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ub") == null || lst.get(i).get("ub").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("ub");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uc") == null || lst.get(i).get("uc").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("uc");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ia") == null || lst.get(i).get("ia").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("ia");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ib") == null || lst.get(i).get("ib").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("ib");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ic") == null || lst.get(i).get("ic").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("ic");
			}
			
			if (lst.get(i) == null || lst.get(i).get("psum") == null || lst.get(i).get("psum").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("psum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("qsum") == null || lst.get(i).get("qsum").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("qsum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ssum") == null || lst.get(i).get("ssum").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("ssum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("freq") == null || lst.get(i).get("freq").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("freq");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void JLZZ(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----解列装置";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态",
				
				"A相电压1","B相电压1","C相电压1",
				
				"A相电压2","B相电压2","C相电压2",
				
				"频率1","频率2",
				
				"健康状态","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ua1") == null || lst.get(i).get("ua1").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("ua1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ub1") == null || lst.get(i).get("ub1").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("ub1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uc1") == null || lst.get(i).get("uc1").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("uc1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ua2") == null || lst.get(i).get("ua2").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("ua2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ub2") == null || lst.get(i).get("ub2").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("ub2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("uc2") == null || lst.get(i).get("uc2").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("uc2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("freq1") == null || lst.get(i).get("freq1").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("freq1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("freq2") == null || lst.get(i).get("freq2").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("freq2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void HJJCY(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----环境检测仪";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态",
				
				"水平面瞬时辐射","水平面总辐射量","倾斜面瞬时辐射","倾斜面总辐射量",
				
				"环境温度","环境湿度","组件温度",
				
				"风速","风向","大气压力",
				
				"平均风速","平均气温","平均湿度",
				
				"累计日照时数","日照时数","峰值日照时数",
				
				"0-100W/m2辐射量",
				"100-200W/m2辐射量",
				"200-300W/m2辐射量",
				"300-400W/m2辐射量",
				"400-500W/m2辐射量",
				"500-600W/m2辐射量",
				"600-700W/m2辐射量",
				"700-800W/m2辐射量",
				"800-900W/m2辐射量",
				"900-1000W/m2辐射量",
				"大于1000W/m2辐射量",
				
				"健康状态","创建时间" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("hgv") == null || lst.get(i).get("hgv").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("hgv");
			}
			
			if (lst.get(i) == null || lst.get(i).get("hg") == null || lst.get(i).get("hg").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("hg");
			}
			
			if (lst.get(i) == null || lst.get(i).get("htv") == null || lst.get(i).get("htv").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("htv");
			}
			
			if (lst.get(i) == null || lst.get(i).get("ht") == null || lst.get(i).get("ht").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("ht");
			}
			
			if (lst.get(i) == null || lst.get(i).get("temp") == null || lst.get(i).get("temp").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("temp");
			}
			
			if (lst.get(i) == null || lst.get(i).get("humi") == null || lst.get(i).get("humi").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("humi");
			}
			
			if (lst.get(i) == null || lst.get(i).get("tempPV") == null || lst.get(i).get("tempPV").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("tempPV");
			}
			
			if (lst.get(i) == null || lst.get(i).get("windSpeed") == null || lst.get(i).get("windSpeed").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("windSpeed");
			}
			
			if (lst.get(i) == null || lst.get(i).get("windDir") == null || lst.get(i).get("windDir").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("windDir");
			}
			
			if (lst.get(i) == null || lst.get(i).get("air") == null || lst.get(i).get("air").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("air");
			}
			
			if (lst.get(i) == null || lst.get(i).get("vmean") == null || lst.get(i).get("vmean").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("vmean");
			}
			
			if (lst.get(i) == null || lst.get(i).get("tammean") == null || lst.get(i).get("tammean").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("tammean");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rh") == null || lst.get(i).get("rh").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("rh");
			}
			
			if (lst.get(i) == null || lst.get(i).get("accHs") == null || lst.get(i).get("accHs").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("accHs");
			}
			
			if (lst.get(i) == null || lst.get(i).get("hs") == null || lst.get(i).get("hs").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("hs");
			}
			
			if (lst.get(i) == null || lst.get(i).get("pekHs") == null || lst.get(i).get("pekHs").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("pekHs");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad0-100W-2m") == null || lst.get(i).get("rad0-100W-2m").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("rad0-100W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad100-200W-2m") == null || lst.get(i).get("rad100-200W-2m").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("rad100-200W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad200-300W-2m") == null || lst.get(i).get("rad200-300W-2m").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				objs[21] = lst.get(i).get("rad200-300W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad300-400W-2m") == null || lst.get(i).get("rad300-400W-2m").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				objs[22] = lst.get(i).get("rad300-400W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad400-500W-2m") == null || lst.get(i).get("rad400-500W-2m").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("rad400-500W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad500-600W-2m") == null || lst.get(i).get("rad500-600W-2m").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				objs[24] = lst.get(i).get("rad500-600W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad600-700W-2m") == null || lst.get(i).get("rad600-700W-2m").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				objs[25] = lst.get(i).get("rad600-700W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad700-800W-2m") == null || lst.get(i).get("rad700-800W-2m").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				objs[26] = lst.get(i).get("rad700-800W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad800-900W-2m") == null || lst.get(i).get("rad800-900W-2m").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				objs[27] = lst.get(i).get("rad800-900W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad900-1000W-2m") == null || lst.get(i).get("rad900-1000W-2m").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				objs[28] = lst.get(i).get("rad900-1000W-2m");
			}
			
			if (lst.get(i) == null || lst.get(i).get("rad1000W-2mThan") == null || lst.get(i).get("rad1000W-2mThan").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				objs[29] = lst.get(i).get("rad1000W-2mThan");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				objs[30] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[31] = "无";
			}else {
				objs[31] = lst.get(i).get("crtTim");
			}
			
		
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void ZLPDG(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----直流配电柜";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态",
				
				"支路数量","1#断路器","2#断路器","3#断路器","4#断路器","5#断路器",
				
				"6#断路器","7#断路器","8#断路器","9#断路器","10#断路器",
				
				"数据入库时间","健康状态" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("branchNum") == null || lst.get(i).get("branchNum").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("branchNum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat1") == null || lst.get(i).get("stat1").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("stat1");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat2") == null || lst.get(i).get("stat2").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("stat2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat3") == null || lst.get(i).get("stat3").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("stat3");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat4") == null || lst.get(i).get("stat4").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("stat4");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat5") == null || lst.get(i).get("stat5").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("stat5");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat6") == null || lst.get(i).get("stat6").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("stat6");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat7") == null || lst.get(i).get("stat7").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("stat7");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat8") == null || lst.get(i).get("stat8").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("stat8");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat9") == null || lst.get(i).get("stat9").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("stat9");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat10") == null || lst.get(i).get("stat10").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("stat10");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("healthStat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("crtTim");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void JLPDG(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----交流配电柜";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态",
				
				"支路数量","1#断路器","2#断路器","3#断路器","4#断路器","5#断路器",
				
				"6#断路器","7#断路器","8#断路器","9#断路器","10#断路器",
				
				"数据入库时间","健康状态" };
		
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			
			
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			
			if (lst.get(i) == null || lst.get(i).get("branchNum") == null || lst.get(i).get("branchNum").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("branchNum");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat1") == null || lst.get(i).get("stat1").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("stat1");
			}
		
			if (lst.get(i) == null || lst.get(i).get("stat2") == null || lst.get(i).get("stat2").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("stat2");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat3") == null || lst.get(i).get("stat3").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("stat3");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat4") == null || lst.get(i).get("stat4").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("stat4");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat5") == null || lst.get(i).get("stat5").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("stat5");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat6") == null || lst.get(i).get("stat6").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("stat6");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat7") == null || lst.get(i).get("stat7").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("stat7");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat8") == null || lst.get(i).get("stat8").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("stat8");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat9") == null || lst.get(i).get("stat9").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("stat9");
			}
			
			if (lst.get(i) == null || lst.get(i).get("stat10") == null || lst.get(i).get("stat10").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("stat10");
			}
			
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("crtTim");
			}
			
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("healthStat");
			}
			
			
			dataList.add(objs);
		}
		
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void HLX(HttpServletResponse response, List<Map<String, Object>> lst)
			throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----汇流箱";
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态",
				"告警码","支路数量","直流电压","直流电流","直流功率","机内温度","离散率",
				"第1路电流","第2路电流","第3路电流","第4路电流","第5路电流","第6路电流","第7路电流","第8路电流","第9路电流","第10路电流",
				"第11路电流","第12路电流","第13路电流","第14路电流","第15路电流","第16路电流","第17路电流","第18路电流","第19路电流","第20路电流",
				"第21路电流","第22路电流","第23路电流","第24路电流","第25路电流","第26路电流","第27路电流","第28路电流","第29路电流","第30路电流",
				"第31路电流","第32路电流",
				"创建时间","健康状态" };
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("faultCode");
			}
			if (lst.get(i) == null || lst.get(i).get("branchNum") == null || lst.get(i).get("branchNum").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("branchNum");
			}
			if (lst.get(i) == null || lst.get(i).get("udc") == null || lst.get(i).get("udc").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("udc");
			}
			if (lst.get(i) == null || lst.get(i).get("idc") == null || lst.get(i).get("idc").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("idc");
			}
			if (lst.get(i) == null || lst.get(i).get("pdc") == null || lst.get(i).get("pdc").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("pdc");
			}
			if (lst.get(i) == null || lst.get(i).get("temp") == null || lst.get(i).get("temp").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("temp");
			}
			if (lst.get(i) == null || lst.get(i).get("disRate") == null || lst.get(i).get("disRate").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("disRate");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc1") == null || lst.get(i).get("Idc1").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("Idc1");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc2") == null || lst.get(i).get("Idc2").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("Idc2");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc3") == null || lst.get(i).get("Idc3").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("Idc3");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc4") == null || lst.get(i).get("Idc4").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("Idc4");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc5") == null || lst.get(i).get("Idc5").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("Idc5");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc6") == null || lst.get(i).get("Idc6").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("Idc6");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc7") == null || lst.get(i).get("Idc7").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("Idc7");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc8") == null || lst.get(i).get("Idc8").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("Idc8");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc9") == null || lst.get(i).get("Idc9").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("Idc9");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc10") == null || lst.get(i).get("Idc10").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("Idc10");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc11") == null || lst.get(i).get("Idc11").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("Idc11");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc12") == null || lst.get(i).get("Idc12").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				objs[21] = lst.get(i).get("Idc12");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc13") == null || lst.get(i).get("Idc13").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				objs[22] = lst.get(i).get("Idc13");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc14") == null || lst.get(i).get("Idc14").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("Idc14");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc15") == null || lst.get(i).get("Idc15").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				objs[24] = lst.get(i).get("Idc15");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc16") == null || lst.get(i).get("Idc16").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				objs[25] = lst.get(i).get("Idc16");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc17") == null || lst.get(i).get("Idc17").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				objs[26] = lst.get(i).get("Idc17");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc18") == null || lst.get(i).get("Idc18").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				objs[27] = lst.get(i).get("Idc18");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc19") == null || lst.get(i).get("Idc19").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				objs[28] = lst.get(i).get("Idc19");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc20") == null || lst.get(i).get("Idc20").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				objs[29] = lst.get(i).get("Idc20");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc21") == null || lst.get(i).get("Idc21").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				objs[30] = lst.get(i).get("Idc21");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc22") == null || lst.get(i).get("Idc22").toString().isEmpty()) {
				objs[31] = "无";
			}else {
				objs[31] = lst.get(i).get("Idc22");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc23") == null || lst.get(i).get("Idc23").toString().isEmpty()) {
				objs[32] = "无";
			}else {
				objs[32] = lst.get(i).get("Idc23");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc24") == null || lst.get(i).get("Idc24").toString().isEmpty()) {
				objs[33] = "无";
			}else {
				objs[33] = lst.get(i).get("Idc24");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc25") == null || lst.get(i).get("Idc25").toString().isEmpty()) {
				objs[34] = "无";
			}else {
				objs[34] = lst.get(i).get("Idc25");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc26") == null || lst.get(i).get("Idc26").toString().isEmpty()) {
				objs[35] = "无";
			}else {
				objs[35] = lst.get(i).get("Idc26");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc27") == null || lst.get(i).get("Idc27").toString().isEmpty()) {
				objs[36] = "无";
			}else {
				objs[36] = lst.get(i).get("Idc27");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc28") == null || lst.get(i).get("Idc28").toString().isEmpty()) {
				objs[37] = "无";
			}else {
				objs[37] = lst.get(i).get("Idc28");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc29") == null || lst.get(i).get("Idc29").toString().isEmpty()) {
				objs[38] = "无";
			}else {
				objs[38] = lst.get(i).get("Idc29");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc30") == null || lst.get(i).get("Idc30").toString().isEmpty()) {
				objs[39] = "无";
			}else {
				objs[39] = lst.get(i).get("Idc30");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc31") == null || lst.get(i).get("Idc31").toString().isEmpty()) {
				objs[40] = "无";
			}else {
				objs[40] = lst.get(i).get("Idc31");
			}
			if (lst.get(i) == null || lst.get(i).get("Idc32") == null || lst.get(i).get("Idc32").toString().isEmpty()) {
				objs[41] = "无";
			}else {
				objs[41] = lst.get(i).get("Idc32");
			}
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[42] = "无";
			}else {
				objs[42] = lst.get(i).get("crtTim");
			}
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[43] = "无";
			}else {
				objs[43] = lst.get(i).get("healthStat");
			}
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void DNZLJCZZ(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----电能质量检测装置";
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备`号","设备状态",
				"Uab线电压","Ubc线电压","Uca线电压",
				"A相电压","B相电压","C相电压",
				"A相基波电压","B相基波电压","C相基波电压",
				"A相电流","B相电流","C相电流",
				"A相基波电流","B相基波电流","C相基波电流",
				"A相真有功","B相真有功","C相真有功",
				"A相基波有功","B相基波有功","C相基波有功",
				"有功功率",
				"A相真无功","B相真无功","C相真无功",
				"A相基波无功","B相基波无功","C相基波无功",
				"无功功率",
				"正向有功电能","反向有功电能","正向无功电能","反向无功电能",
				"A相功率因数","B相功率因数","C相功率因数",
				"功率因数","频率",
				"正序电压","负序电压","零序电压","正序电流","负序电流","零序电流",
				"电压不平衡度","电流不平衡度",
				"A相电压波动","B相电压波动","C相电压波动",
				"A相短时闪变","B相短时闪变","C相短时闪变","A相长时闪变","B相长时闪变","C相长时闪变",
				"A相电压总谐波畸变率","B相电压总谐波畸变率","C相电压总谐波畸变率","A相电流总谐波畸变率","B相电流总谐波畸变率","C相电流总谐波畸变率",
				"A相电压2次谐波","B相电压2次谐波","C相电压2次谐波","A相电流2次谐波","B相电流2次谐波","C相电流2次谐波",
				"健康状态","创建时间" };
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];
			
			objs[0] = lst.get(i).get("id");
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			if (lst.get(i) == null || lst.get(i).get("uab") == null || lst.get(i).get("uab").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("uab");
			}
			if (lst.get(i) == null || lst.get(i).get("ubc") == null || lst.get(i).get("ubc").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("ubc");
			}
			if (lst.get(i) == null || lst.get(i).get("uca") == null || lst.get(i).get("uca").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("uca");
			}
			if (lst.get(i) == null || lst.get(i).get("ua") == null || lst.get(i).get("ua").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("ua");
			}
			if (lst.get(i) == null || lst.get(i).get("ub") == null || lst.get(i).get("ub").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("ub");
			}
			if (lst.get(i) == null || lst.get(i).get("uc") == null || lst.get(i).get("uc").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("uc");
			}
			if (lst.get(i) == null || lst.get(i).get("fua") == null || lst.get(i).get("fua").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("fua");
			}
			if (lst.get(i) == null || lst.get(i).get("fub") == null || lst.get(i).get("fub").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("fub");
			}
			if (lst.get(i) == null || lst.get(i).get("fuc") == null || lst.get(i).get("fuc").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("fuc");
			}
			if (lst.get(i) == null || lst.get(i).get("ia") == null || lst.get(i).get("ia").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("ia");
			}
			if (lst.get(i) == null || lst.get(i).get("ib") == null || lst.get(i).get("ib").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("ib");
			}
			if (lst.get(i) == null || lst.get(i).get("ic") == null || lst.get(i).get("ic").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("ic");
			}
			if (lst.get(i) == null || lst.get(i).get("fia") == null || lst.get(i).get("fia").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("fia");
			}
			if (lst.get(i) == null || lst.get(i).get("fib") == null || lst.get(i).get("fib").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("fib");
			}
			if (lst.get(i) == null || lst.get(i).get("fic") == null || lst.get(i).get("fic").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("fic");
			}
			if (lst.get(i) == null || lst.get(i).get("pa") == null || lst.get(i).get("pa").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("pa");
			}
			if (lst.get(i) == null || lst.get(i).get("pb") == null || lst.get(i).get("pb").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("pb");
			}
			if (lst.get(i) == null || lst.get(i).get("pc") == null || lst.get(i).get("pc").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("pc");
			}
			if (lst.get(i) == null || lst.get(i).get("fpa") == null || lst.get(i).get("fpa").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				objs[21] = lst.get(i).get("fpa");
			}
			if (lst.get(i) == null || lst.get(i).get("fpb") == null || lst.get(i).get("fpb").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				objs[22] = lst.get(i).get("fpb");
			}
			if (lst.get(i) == null || lst.get(i).get("fpc") == null || lst.get(i).get("fpc").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("fpc");
			}
			if (lst.get(i) == null || lst.get(i).get("psum") == null || lst.get(i).get("psum").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				objs[24] = lst.get(i).get("psum");
			}
			if (lst.get(i) == null || lst.get(i).get("qa") == null || lst.get(i).get("qa").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				objs[25] = lst.get(i).get("qa");
			}
			if (lst.get(i) == null || lst.get(i).get("qb") == null || lst.get(i).get("qb").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				objs[26] = lst.get(i).get("qb");
			}
			if (lst.get(i) == null || lst.get(i).get("qc") == null || lst.get(i).get("qc").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				objs[27] = lst.get(i).get("qc");
			}
			if (lst.get(i) == null || lst.get(i).get("fqa") == null || lst.get(i).get("fqa").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				objs[28] = lst.get(i).get("fqa");
			}
			if (lst.get(i) == null || lst.get(i).get("fqb") == null || lst.get(i).get("fqb").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				objs[29] = lst.get(i).get("fqb");
			}
			if (lst.get(i) == null || lst.get(i).get("fqc") == null || lst.get(i).get("fqc").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				objs[30] = lst.get(i).get("fqc");
			}
			if (lst.get(i) == null || lst.get(i).get("qsum") == null || lst.get(i).get("qsum").toString().isEmpty()) {
				objs[31] = "无";
			}else {
				objs[31] = lst.get(i).get("qsum");
			}
			if (lst.get(i) == null || lst.get(i).get("phi") == null || lst.get(i).get("phi").toString().isEmpty()) {
				objs[32] = "无";
			}else {
				objs[32] = lst.get(i).get("phi");
			}
			if (lst.get(i) == null || lst.get(i).get("phe") == null || lst.get(i).get("phe").toString().isEmpty()) {
				objs[33] = "无";
			}else {
				objs[33] = lst.get(i).get("phe");
			}
			if (lst.get(i) == null || lst.get(i).get("qhi") == null || lst.get(i).get("qhi").toString().isEmpty()) {
				objs[34] = "无";
			}else {
				objs[34] = lst.get(i).get("qhi");
			}
			if (lst.get(i) == null || lst.get(i).get("qhe") == null || lst.get(i).get("qhe").toString().isEmpty()) {
				objs[35] = "无";
			}else {
				objs[35] = lst.get(i).get("qhe");
			}
			if (lst.get(i) == null || lst.get(i).get("pfa") == null || lst.get(i).get("pfa").toString().isEmpty()) {
				objs[36] = "无";
			}else {
				objs[36] = lst.get(i).get("pfa");
			}
			if (lst.get(i) == null || lst.get(i).get("pfb") == null || lst.get(i).get("pfb").toString().isEmpty()) {
				objs[37] = "无";
			}else {
				objs[37] = lst.get(i).get("pfb");
			}
			if (lst.get(i) == null || lst.get(i).get("pfc") == null || lst.get(i).get("pfc").toString().isEmpty()) {
				objs[38] = "无";
			}else {
				objs[38] = lst.get(i).get("pfc");
			}
			if (lst.get(i) == null || lst.get(i).get("pf") == null || lst.get(i).get("pf").toString().isEmpty()) {
				objs[39] = "无";
			}else {
				objs[39] = lst.get(i).get("pf");
			}
			if (lst.get(i) == null || lst.get(i).get("freq") == null || lst.get(i).get("freq").toString().isEmpty()) {
				objs[40] = "无";
			}else {
				objs[40] = lst.get(i).get("freq");
			}
			if (lst.get(i) == null || lst.get(i).get("psv") == null || lst.get(i).get("psv").toString().isEmpty()) {
				objs[41] = "无";
			}else {
				objs[41] = lst.get(i).get("psv");
			}
			if (lst.get(i) == null || lst.get(i).get("nsv") == null || lst.get(i).get("nsv").toString().isEmpty()) {
				objs[42] = "无";
			}else {
				objs[42] = lst.get(i).get("nsv");
			}
			if (lst.get(i) == null || lst.get(i).get("zsv") == null || lst.get(i).get("zsv").toString().isEmpty()) {
				objs[43] = "无";
			}else {
				objs[43] = lst.get(i).get("zsv");
			}
			if (lst.get(i) == null || lst.get(i).get("psc") == null || lst.get(i).get("psc").toString().isEmpty()) {
				objs[44] = "无";
			}else {
				objs[44] = lst.get(i).get("psc");
			}
			if (lst.get(i) == null || lst.get(i).get("nsc") == null || lst.get(i).get("nsc").toString().isEmpty()) {
				objs[45] = "无";
			}else {
				objs[45] = lst.get(i).get("nsc");
			}
			if (lst.get(i) == null || lst.get(i).get("zsc") == null || lst.get(i).get("zsc").toString().isEmpty()) {
				objs[46] = "无";
			}else {
				objs[46] = lst.get(i).get("zsc");
			}
			if (lst.get(i) == null || lst.get(i).get("ublk") == null || lst.get(i).get("ublk").toString().isEmpty()) {
				objs[47] = "无";
			}else {
				objs[47] = lst.get(i).get("ublk");
			}
			if (lst.get(i) == null || lst.get(i).get("iblk") == null || lst.get(i).get("iblk").toString().isEmpty()) {
				objs[48] = "无";
			}else {
				objs[48] = lst.get(i).get("iblk");
			}
			if (lst.get(i) == null || lst.get(i).get("vfa") == null || lst.get(i).get("vfa").toString().isEmpty()) {
				objs[49] = "无";
			}else {
				objs[49] = lst.get(i).get("vfa");
			}
			if (lst.get(i) == null || lst.get(i).get("vfb") == null || lst.get(i).get("vfb").toString().isEmpty()) {
				objs[50] = "无";
			}else {
				objs[50] = lst.get(i).get("vfb");
			}
			if (lst.get(i) == null || lst.get(i).get("vfc") == null || lst.get(i).get("vfc").toString().isEmpty()) {
				objs[51] = "无";
			}else {
				objs[51] = lst.get(i).get("vfc");
			}
			if (lst.get(i) == null || lst.get(i).get("psta") == null || lst.get(i).get("psta").toString().isEmpty()) {
				objs[52] = "无";
			}else {
				objs[52] = lst.get(i).get("psta");
			}
			if (lst.get(i) == null || lst.get(i).get("pstb") == null || lst.get(i).get("pstb").toString().isEmpty()) {
				objs[53] = "无";
			}else {
				objs[53] = lst.get(i).get("pstb");
			}
			if (lst.get(i) == null || lst.get(i).get("pstc") == null || lst.get(i).get("pstc").toString().isEmpty()) {
				objs[54] = "无";
			}else {
				objs[54] = lst.get(i).get("pstc");
			}
			if (lst.get(i) == null || lst.get(i).get("plta") == null || lst.get(i).get("plta").toString().isEmpty()) {
				objs[55] = "无";
			}else {
				objs[55] = lst.get(i).get("plta");
			}
			if (lst.get(i) == null || lst.get(i).get("pltb") == null || lst.get(i).get("pltb").toString().isEmpty()) {
				objs[56] = "无";
			}else {
				objs[56] = lst.get(i).get("pltb");
			}
			if (lst.get(i) == null || lst.get(i).get("pltc") == null || lst.get(i).get("pltc").toString().isEmpty()) {
				objs[57] = "无";
			}else {
				objs[57] = lst.get(i).get("pltc");
			}
			if (lst.get(i) == null || lst.get(i).get("thdua") == null || lst.get(i).get("thdua").toString().isEmpty()) {
				objs[58] = "无";
			}else {
				objs[58] = lst.get(i).get("thdua");
			}
			if (lst.get(i) == null || lst.get(i).get("thdub") == null || lst.get(i).get("thdub").toString().isEmpty()) {
				objs[59] = "无";
			}else {
				objs[59] = lst.get(i).get("thdub");
			}
			if (lst.get(i) == null || lst.get(i).get("thduc") == null || lst.get(i).get("thduc").toString().isEmpty()) {
				objs[60] = "无";
			}else {
				objs[60] = lst.get(i).get("thduc");
			}
			if (lst.get(i) == null || lst.get(i).get("thdia") == null || lst.get(i).get("thdia").toString().isEmpty()) {
				objs[61] = "无";
			}else {
				objs[61] = lst.get(i).get("thdia");
			}
			if (lst.get(i) == null || lst.get(i).get("thdib") == null || lst.get(i).get("thdib").toString().isEmpty()) {
				objs[62] = "无";
			}else {
				objs[62] = lst.get(i).get("thdib");
			}
			if (lst.get(i) == null || lst.get(i).get("thdic") == null || lst.get(i).get("thdic").toString().isEmpty()) {
				objs[63] = "无";
			}else {
				objs[63] = lst.get(i).get("thdic");
			}
			if (lst.get(i) == null || lst.get(i).get("thdua2") == null || lst.get(i).get("thdua2").toString().isEmpty()) {
				objs[64] = "无";
			}else {
				objs[64] = lst.get(i).get("thdua2");
			}
			if (lst.get(i) == null || lst.get(i).get("thdub2") == null || lst.get(i).get("thdub2").toString().isEmpty()) {
				objs[65] = "无";
			}else {
				objs[65] = lst.get(i).get("thdub2");
			}
			if (lst.get(i) == null || lst.get(i).get("thduc2") == null || lst.get(i).get("thduc2").toString().isEmpty()) {
				objs[66] = "无";
			}else {
				objs[66] = lst.get(i).get("thduc2");
			}
			if (lst.get(i) == null || lst.get(i).get("thdia2") == null || lst.get(i).get("thdia2").toString().isEmpty()) {
				objs[67] = "无";
			}else {
				objs[67] = lst.get(i).get("thdia2");
			}
			if (lst.get(i) == null || lst.get(i).get("thdib2") == null || lst.get(i).get("thdib2").toString().isEmpty()) {
				objs[68] = "无";
			}else {
				objs[68] = lst.get(i).get("thdib2");
			}
			if (lst.get(i) == null || lst.get(i).get("thdic2") == null || lst.get(i).get("thdic2").toString().isEmpty()) {
				objs[69] = "无";
			}else {
				objs[69] = lst.get(i).get("thdic2");
			}
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[70] = "无";
			}else {
				objs[70] = lst.get(i).get("healthStat");
			}
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[71] = "无";
			}else {
				objs[71] = lst.get(i).get("crtTim");
			}
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void DCDC(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----DC/DC";
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态","工作状态",
				"工作模式","告警码","高压侧电压","高压侧电流","高压侧功率","低压侧电压","低压侧电流",
				"低压侧功率","健康状态","创建时间" };

		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();

		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];

			objs[0] = lst.get(i).get("id");
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			if (lst.get(i) == null || lst.get(i).get("workStat") == null || lst.get(i).get("workStat").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				//设备状态
				objs[3] = lst.get(i).get("workStat");
			}
			if (lst.get(i) == null || lst.get(i).get("mode") == null || lst.get(i).get("mode").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				//设备状态
				objs[4] = lst.get(i).get("mode");
			}
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				//设备状态
				objs[5] = lst.get(i).get("faultCode");
			}
			if (lst.get(i) == null || lst.get(i).get("uHigh") == null || lst.get(i).get("uHigh").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				//设备状态
				objs[6] = lst.get(i).get("uHigh");
			}
			if (lst.get(i) == null || lst.get(i).get("iHigh") == null || lst.get(i).get("iHigh").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				//设备状态
				objs[7] = lst.get(i).get("iHigh");
			}
			if (lst.get(i) == null || lst.get(i).get("pHigh") == null || lst.get(i).get("pHigh").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				//设备状态
				objs[8] = lst.get(i).get("pHigh");
			}
			if (lst.get(i) == null || lst.get(i).get("uLow") == null || lst.get(i).get("uLow").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				//设备状态
				objs[9] = lst.get(i).get("uLow");
			}
			if (lst.get(i) == null || lst.get(i).get("iLow") == null || lst.get(i).get("iLow").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				//设备状态
				objs[10] = lst.get(i).get("iLow");
			}
			if (lst.get(i) == null || lst.get(i).get("pLow") == null || lst.get(i).get("pLow").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				//设备状态
				objs[11] = lst.get(i).get("pLow");
			}
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				//设备状态
				objs[12] = lst.get(i).get("healthStat");
			}
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				//设备状态
				objs[13] = lst.get(i).get("crtTim");
			}
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void CNNBQ(HttpServletResponse response,
			List<Map<String, Object>> lst) throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----储能逆变器";
		
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态","告警码",
				"工作模式","并离网状态","直流电压","直流电流","直流功率","Uab线电压","Ubc线电压",
				"Uca线电压","A相电压","B相电压","C相电压","A相电流","B相电流","C相电流",
				 "A相有功","B相有功","C相有功","无功功率","累计输入电量","累计输出电量","效率","功率因数",
				 "频率","机内温度","模块温度","累计正常运行时间","累计正常停机时间","累计告警运行时间","累计故障停机时间",
				 "累计通讯中断时间","累计运行时间","累计充电时间","累计放电时间","健康状态","创建时间" };

		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();

		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];

			objs[0] = lst.get(i).get("id");
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			if (lst.get(i) == null || lst.get(i).get("faultCode") == null || lst.get(i).get("faultCode").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				//设备告警码
				objs[3] = lst.get(i).get("faultCode");
			}
			if (lst.get(i) == null || lst.get(i).get("mode") == null || lst.get(i).get("mode").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				//工作模式
				objs[4] = lst.get(i).get("mode");
			}
			if (lst.get(i) == null || lst.get(i).get("gridStat") == null || lst.get(i).get("gridStat").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				//并离网状态
				objs[5] = lst.get(i).get("gridStat");
			}
			if (lst.get(i) == null || lst.get(i).get("udc") == null || lst.get(i).get("udc").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				//直流电压
				objs[6] = lst.get(i).get("udc");
			}
			if (lst.get(i) == null || lst.get(i).get("idc") == null || lst.get(i).get("idc").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				//直流电流
				objs[7] = lst.get(i).get("idc");
			}
			if (lst.get(i) == null || lst.get(i).get("pdc") == null || lst.get(i).get("pdc").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				//直流功率
				objs[8] = lst.get(i).get("pdc");
			}
			if (lst.get(i) == null || lst.get(i).get("uab") == null || lst.get(i).get("uab").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				//Uab线电压
				objs[9] = lst.get(i).get("uab");
			}
			if (lst.get(i) == null || lst.get(i).get("ubc") == null || lst.get(i).get("ubc").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				//Ubc线电压
				objs[10] = lst.get(i).get("ubc");
			}
			if (lst.get(i) == null || lst.get(i).get("uca") == null || lst.get(i).get("uca").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				//Uca线电压
				objs[11] = lst.get(i).get("uca");
			}
			if (lst.get(i) == null || lst.get(i).get("ua") == null || lst.get(i).get("ua").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				//abc相电压
				objs[12] = lst.get(i).get("ua");
			}
			if (lst.get(i) == null || lst.get(i).get("ub") == null || lst.get(i).get("ub").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("ub");
			}
			if (lst.get(i) == null || lst.get(i).get("uc") == null || lst.get(i).get("uc").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("uc");
			}
			if (lst.get(i) == null || lst.get(i).get("ia") == null || lst.get(i).get("ia").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				//abc相电流
				objs[15] = lst.get(i).get("ia");
			}
			if (lst.get(i) == null || lst.get(i).get("ib") == null || lst.get(i).get("ib").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("ib");
			}
			if (lst.get(i) == null || lst.get(i).get("ic") == null || lst.get(i).get("ic").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("ic");
			}
			if (lst.get(i) == null || lst.get(i).get("pa") == null || lst.get(i).get("pa").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				//abc相有功
				objs[18] = lst.get(i).get("pa");
			}
			if (lst.get(i) == null || lst.get(i).get("pb") == null || lst.get(i).get("pb").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("pb");
			}
			if (lst.get(i) == null || lst.get(i).get("pc") == null || lst.get(i).get("pc").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("pc");
			}
			if (lst.get(i) == null || lst.get(i).get("qsum") == null || lst.get(i).get("qsum").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				//无功功率
				objs[21] = lst.get(i).get("qsum");
			}
			if (lst.get(i) == null || lst.get(i).get("phi") == null || lst.get(i).get("phi").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				//累计输入输出电量
				objs[22] = lst.get(i).get("phi");
			}
			if (lst.get(i) == null || lst.get(i).get("phe") == null || lst.get(i).get("phe").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("phe");
			}
			if (lst.get(i) == null || lst.get(i).get("eff") == null || lst.get(i).get("eff").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				//效率
				objs[24] = lst.get(i).get("eff");
			}
			if (lst.get(i) == null || lst.get(i).get("pf") == null || lst.get(i).get("pf").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				//功率因数
				objs[25] = lst.get(i).get("pf");
			}
			if (lst.get(i) == null || lst.get(i).get("freq") == null || lst.get(i).get("freq").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				//频率
				objs[26] = lst.get(i).get("freq");
			}
			if (lst.get(i) == null || lst.get(i).get("temp") == null || lst.get(i).get("temp").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				//机内温度
				objs[27] = lst.get(i).get("temp");
			}
			if (lst.get(i) == null || lst.get(i).get("tempMod") == null || lst.get(i).get("tempMod").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				//模块温度
				objs[28] = lst.get(i).get("tempMod");
			}
			if (lst.get(i) == null || lst.get(i).get("goodRunTime") == null || lst.get(i).get("goodRunTime").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				//"累计正常运行时间","累计正常停机时间","累计告警运行时间","累计故障停机时间", "累计通讯中断时间"
				objs[29] = lst.get(i).get("goodRunTime");
			}
			if (lst.get(i) == null || lst.get(i).get("downTime") == null || lst.get(i).get("downTime").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				objs[30] = lst.get(i).get("downTime");
			}
			if (lst.get(i) == null || lst.get(i).get("faultTime") == null || lst.get(i).get("faultTime").toString().isEmpty()) {
				objs[31] = "无";
			}else {
				objs[31] = lst.get(i).get("faultTime");
			}
			if (lst.get(i) == null || lst.get(i).get("failureTime") == null || lst.get(i).get("failureTime").toString().isEmpty()) {
				objs[32] = "无";
			}else {
				objs[32] = lst.get(i).get("failureTime");
			}
			if (lst.get(i) == null || lst.get(i).get("comIntTime") == null || lst.get(i).get("comIntTime").toString().isEmpty()) {
				objs[33] = "无";
			}else {
				objs[33] = lst.get(i).get("comIntTime");
			}
			if (lst.get(i) == null || lst.get(i).get("runTime") == null || lst.get(i).get("runTime").toString().isEmpty()) {
				objs[34] = "无";
			}else {
				//"累计运行时间","累计充电时间","累计放电时间","健康状态","创建时间"
				objs[34] = lst.get(i).get("runTime");
			}
			if (lst.get(i) == null || lst.get(i).get("chargeTime") == null || lst.get(i).get("chargeTime").toString().isEmpty()) {
				objs[35] = "无";
			}else {
				objs[35] = lst.get(i).get("chargeTime");
			}
			if (lst.get(i) == null || lst.get(i).get("dischargeTime") == null || lst.get(i).get("dischargeTime").toString().isEmpty()) {
				objs[36] = "无";
			}else {
				objs[36] = lst.get(i).get("dischargeTime");
			}
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[37] = "无";
			}else {
				objs[37] = lst.get(i).get("healthStat");
			}
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[38] = "无";
			}else {
				objs[38] = lst.get(i).get("crtTim");
			}
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void BYQ(HttpServletResponse response, List<Map<String, Object>> lst)
			throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----变压器";
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态","绕组数量",
				"Uab线电压","Ubc线电压","Uca线电压",
				"A相电压","B相电压","C相电压","Ａ相电流","B相电流","C相电流",
				"有功功率","无功功率","频率","功率因数",
				"Ａ相温度","Ｂ相温度","Ｃ相温度","温度",
				"正向有功电度","正向无功电度","反向有功电度","反向无功电度",
				"Uab线电压","Ubc线电压","Uca线电压",
				"A相电压","B相电压","C相电压","Ａ相电流","B相电流","C相电流",
				"有功功率","无功功率","频率","功率因数",
				"Ａ相温度","Ｂ相温度","Ｃ相温度","温度",
				"正向有功电度","正向无功电度","反向有功电度","反向无功电度",
				"Uab线电压","Ubc线电压","Uca线电压",
				"A相电压","B相电压","C相电压","Ａ相电流","B相电流","C相电流",
				"有功功率","无功功率","频率","功率因数",
				"Ａ相温度","Ｂ相温度","Ｃ相温度","温度",
				"正向有功电度","正向无功电度","反向有功电度","反向无功电度",
				"健康状态","创建时间" };
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();

		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];

			objs[0] = lst.get(i).get("id");
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			if (lst.get(i) == null || lst.get(i).get("branchNum") == null || lst.get(i).get("branchNum").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				//绕组数量
				objs[3] = lst.get(i).get("branchNum");
			}
			if (lst.get(i) == null || lst.get(i).get("uab1") == null || lst.get(i).get("uab1").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				
				objs[4] = lst.get(i).get("uab1");
			}
			if (lst.get(i) == null || lst.get(i).get("ubc1") == null || lst.get(i).get("ubc1").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("ubc1");
			}
			if (lst.get(i) == null || lst.get(i).get("uca1") == null || lst.get(i).get("uca1").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("uca1");
			}
			if (lst.get(i) == null || lst.get(i).get("ua1") == null || lst.get(i).get("ua1").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("ua1");
			}
			if (lst.get(i) == null || lst.get(i).get("ub1") == null || lst.get(i).get("ub1").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("ub1");
			}
			if (lst.get(i) == null || lst.get(i).get("uc1") == null || lst.get(i).get("uc1").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("uc1");
			}
			if (lst.get(i) == null || lst.get(i).get("ia1") == null || lst.get(i).get("ia1").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("ia1");
			}
			if (lst.get(i) == null || lst.get(i).get("ib1") == null || lst.get(i).get("ib1").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("ib1");
			}
			if (lst.get(i) == null || lst.get(i).get("ic1") == null || lst.get(i).get("ic1").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("ic1");
			}
			if (lst.get(i) == null || lst.get(i).get("psum1") == null || lst.get(i).get("psum1").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("psum1");
			}
			if (lst.get(i) == null || lst.get(i).get("qsum1") == null || lst.get(i).get("qsum1").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("qsum1");
			}
			if (lst.get(i) == null || lst.get(i).get("freq1") == null || lst.get(i).get("freq1").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("freq1");
			}
			if (lst.get(i) == null || lst.get(i).get("pf1") == null || lst.get(i).get("pf1").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("pf1");
			}
			if (lst.get(i) == null || lst.get(i).get("tempa1") == null || lst.get(i).get("tempa1").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("tempa1");
			}
			if (lst.get(i) == null || lst.get(i).get("tempb1") == null || lst.get(i).get("tempb1").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("tempb1");
			}
			if (lst.get(i) == null || lst.get(i).get("tempc1") == null || lst.get(i).get("tempc1").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("tempc1");
			}
			if (lst.get(i) == null || lst.get(i).get("temp1") == null || lst.get(i).get("temp1").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("temp1");
			}
			if (lst.get(i) == null || lst.get(i).get("phi1") == null || lst.get(i).get("phi1").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				objs[21] = lst.get(i).get("phi1");
			}
			if (lst.get(i) == null || lst.get(i).get("qhi1") == null || lst.get(i).get("qhi1").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				objs[22] = lst.get(i).get("qhi1");
			}
			if (lst.get(i) == null || lst.get(i).get("phe1") == null || lst.get(i).get("phe1").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("phe1");
			}
			if (lst.get(i) == null || lst.get(i).get("qhe1") == null || lst.get(i).get("qhe1").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				objs[24] = lst.get(i).get("qhe1");
			}
			if (lst.get(i) == null || lst.get(i).get("uab2") == null || lst.get(i).get("uab2").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				objs[25] = lst.get(i).get("uab2");
			}
			if (lst.get(i) == null || lst.get(i).get("ubc2") == null || lst.get(i).get("ubc2").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				objs[26] = lst.get(i).get("ubc2");
			}
			if (lst.get(i) == null || lst.get(i).get("uca2") == null || lst.get(i).get("uca2").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				objs[27] = lst.get(i).get("uca2");
			}
			if (lst.get(i) == null || lst.get(i).get("ua2") == null || lst.get(i).get("ua2").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				objs[28] = lst.get(i).get("ua2");
			}
			if (lst.get(i) == null || lst.get(i).get("ub2") == null || lst.get(i).get("ub2").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				objs[29] = lst.get(i).get("ub2");
			}
			if (lst.get(i) == null || lst.get(i).get("uc2") == null || lst.get(i).get("uc2").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				objs[30] = lst.get(i).get("uc2");
			}
			if (lst.get(i) == null || lst.get(i).get("ia2") == null || lst.get(i).get("ia2").toString().isEmpty()) {
				objs[31] = "无";
			}else {
				objs[31] = lst.get(i).get("ia2");
			}
			if (lst.get(i) == null || lst.get(i).get("ib2") == null || lst.get(i).get("ib2").toString().isEmpty()) {
				objs[32] = "无";
			}else {
				objs[32] = lst.get(i).get("ib2");
			}
			if (lst.get(i) == null || lst.get(i).get("ic2") == null || lst.get(i).get("ic2").toString().isEmpty()) {
				objs[33] = "无";
			}else {
				objs[33] = lst.get(i).get("ic2");
			}
			if (lst.get(i) == null || lst.get(i).get("psum2") == null || lst.get(i).get("psum2").toString().isEmpty()) {
				objs[34] = "无";
			}else {
				objs[34] = lst.get(i).get("psum2");
			}
			if (lst.get(i) == null || lst.get(i).get("qsum2") == null || lst.get(i).get("qsum2").toString().isEmpty()) {
				objs[35] = "无";
			}else {
				objs[35] = lst.get(i).get("qsum2");
			}
			if (lst.get(i) == null || lst.get(i).get("freq2") == null || lst.get(i).get("freq2").toString().isEmpty()) {
				objs[36] = "无";
			}else {
				objs[36] = lst.get(i).get("freq2");
			}
			if (lst.get(i) == null || lst.get(i).get("pf2") == null || lst.get(i).get("pf2").toString().isEmpty()) {
				objs[37] = "无";
			}else {
				objs[37] = lst.get(i).get("pf2");
			}
			if (lst.get(i) == null || lst.get(i).get("tempa2") == null || lst.get(i).get("tempa2").toString().isEmpty()) {
				objs[38] = "无";
			}else {
				objs[38] = lst.get(i).get("tempa2");
			}
			if (lst.get(i) == null || lst.get(i).get("tempb2") == null || lst.get(i).get("tempb2").toString().isEmpty()) {
				objs[39] = "无";
			}else {
				objs[39] = lst.get(i).get("tempb2");
			}
			if (lst.get(i) == null || lst.get(i).get("tempc2") == null || lst.get(i).get("tempc2").toString().isEmpty()) {
				objs[40] = "无";
			}else {
				objs[40] = lst.get(i).get("tempc2");
			}
			if (lst.get(i) == null || lst.get(i).get("temp2") == null || lst.get(i).get("temp2").toString().isEmpty()) {
				objs[41] = "无";
			}else {
				objs[41] = lst.get(i).get("temp2");
			}
			if (lst.get(i) == null || lst.get(i).get("phi2") == null || lst.get(i).get("phi2").toString().isEmpty()) {
				objs[42] = "无";
			}else {
				objs[42] = lst.get(i).get("phi2");
			}
			if (lst.get(i) == null || lst.get(i).get("qhi2") == null || lst.get(i).get("qhi2").toString().isEmpty()) {
				objs[43] = "无";
			}else {
				objs[43] = lst.get(i).get("qhi2");
			}
			if (lst.get(i) == null || lst.get(i).get("phe2") == null || lst.get(i).get("phe2").toString().isEmpty()) {
				objs[44] = "无";
			}else {
				objs[44] = lst.get(i).get("phe2");
			}
			if (lst.get(i) == null || lst.get(i).get("qhe2") == null || lst.get(i).get("qhe2").toString().isEmpty()) {
				objs[45] = "无";
			}else {
				objs[45] = lst.get(i).get("qhe2");
			}
			if (lst.get(i) == null || lst.get(i).get("uab3") == null || lst.get(i).get("uab3").toString().isEmpty()) {
				objs[46] = "无";
			}else {
				objs[46] = lst.get(i).get("uab3");
			}
			if (lst.get(i) == null || lst.get(i).get("ubc3") == null || lst.get(i).get("ubc3").toString().isEmpty()) {
				objs[47] = "无";
			}else {
				objs[47] = lst.get(i).get("ubc3");
			}
			if (lst.get(i) == null || lst.get(i).get("uca3") == null || lst.get(i).get("uca3").toString().isEmpty()) {
				objs[48] = "无";
			}else {
				objs[48] = lst.get(i).get("uca3");
			}
			if (lst.get(i) == null || lst.get(i).get("ua3") == null || lst.get(i).get("ua3").toString().isEmpty()) {
				objs[49] = "无";
			}else {
				objs[49] = lst.get(i).get("ua3");
			}
			if (lst.get(i) == null || lst.get(i).get("ub3") == null || lst.get(i).get("ub3").toString().isEmpty()) {
				objs[50] = "无";
			}else {
				objs[50] = lst.get(i).get("ub3");
			}
			if (lst.get(i) == null || lst.get(i).get("uc3") == null || lst.get(i).get("uc3").toString().isEmpty()) {
				objs[51] = "无";
			}else {
				objs[51] = lst.get(i).get("uc3");
			}
			if (lst.get(i) == null || lst.get(i).get("ia3") == null || lst.get(i).get("ia3").toString().isEmpty()) {
				objs[52] = "无";
			}else {
				objs[52] = lst.get(i).get("ia3");
			}
			if (lst.get(i) == null || lst.get(i).get("ib3") == null || lst.get(i).get("ib3").toString().isEmpty()) {
				objs[53] = "无";
			}else {
				objs[53] = lst.get(i).get("ib3");
			}
			if (lst.get(i) == null || lst.get(i).get("ic3") == null || lst.get(i).get("ic3").toString().isEmpty()) {
				objs[54] = "无";
			}else {
				objs[54] = lst.get(i).get("ic3");
			}
			if (lst.get(i) == null || lst.get(i).get("psum3") == null || lst.get(i).get("psum3").toString().isEmpty()) {
				objs[55] = "无";
			}else {
				objs[55] = lst.get(i).get("psum3");
			}
			if (lst.get(i) == null || lst.get(i).get("qsum3") == null || lst.get(i).get("qsum3").toString().isEmpty()) {
				objs[56] = "无";
			}else {
				objs[56] = lst.get(i).get("qsum3");
			}
			if (lst.get(i) == null || lst.get(i).get("freq3") == null || lst.get(i).get("freq3").toString().isEmpty()) {
				objs[57] = "无";
			}else {
				objs[57] = lst.get(i).get("freq3");
			}
			if (lst.get(i) == null || lst.get(i).get("pf3") == null || lst.get(i).get("pf3").toString().isEmpty()) {
				objs[58] = "无";
			}else {
				objs[58] = lst.get(i).get("pf3");
			}
			if (lst.get(i) == null || lst.get(i).get("tempa3") == null || lst.get(i).get("tempa3").toString().isEmpty()) {
				objs[59] = "无";
			}else {
				objs[59] = lst.get(i).get("tempa3");
			}
			if (lst.get(i) == null || lst.get(i).get("tempb3") == null || lst.get(i).get("tempb3").toString().isEmpty()) {
				objs[60] = "无";
			}else {
				objs[60] = lst.get(i).get("tempb3");
			}
			if (lst.get(i) == null || lst.get(i).get("tempc3") == null || lst.get(i).get("tempc3").toString().isEmpty()) {
				objs[61] = "无";
			}else {
				objs[61] = lst.get(i).get("tempc3");
			}
			if (lst.get(i) == null || lst.get(i).get("temp3") == null || lst.get(i).get("temp3").toString().isEmpty()) {
				objs[62] = "无";
			}else {
				objs[62] = lst.get(i).get("temp3");
			}
			if (lst.get(i) == null || lst.get(i).get("phi3") == null || lst.get(i).get("phi3").toString().isEmpty()) {
				objs[63] = "无";
			}else {
				objs[63] = lst.get(i).get("phi3");
			}
			if (lst.get(i) == null || lst.get(i).get("qhi3") == null || lst.get(i).get("qhi3").toString().isEmpty()) {
				objs[46] = "无";
			}else {
				objs[46] = lst.get(i).get("qhi3");
			}
			if (lst.get(i) == null || lst.get(i).get("phe3") == null || lst.get(i).get("phe3").toString().isEmpty()) {
				objs[65] = "无";
			}else {
				objs[65] = lst.get(i).get("phe3");
			}
			if (lst.get(i) == null || lst.get(i).get("qhe3") == null || lst.get(i).get("qhe3").toString().isEmpty()) {
				objs[66] = "无";
			}else {
				objs[66] = lst.get(i).get("qhe3");
			}
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[67] = "无";
			}else {
				objs[67] = lst.get(i).get("healthStat");
			}
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[68] = "无";
			}else {
				objs[68] = lst.get(i).get("crtTim");
			}
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}



	private void DB(HttpServletResponse response, List<Map<String, Object>> lst)
			throws IOException, Exception {
		// 定义表的标题
		String title = "采集数据列表一览----电表";
		// 定义表的列名
		String[] rowsName = new String[] {"序号","设备编号","设备状态",
				"电压变比","电流变比","Uab线电压","Ubc线电压","Uca线电压",
				"A相电压","B相电压","C相电压","A相电流","B相电流","C相电流",
				 "A相有功","B相有功","C相有功","有功功率","无功功率","视在功率",
				 "正向有功电度表值","反向有功电度表值","正向无功电度表值","反向无功电度表值",
				 "正向有功电度","反向有功电度","正向无功电度","反向无功电度",
				 "峰正向有功电度","峰反向有功电度","峰正向无功电度","峰反向无功电度",
				 "谷正向有功电度","谷反向有功电度","谷正向无功电度","谷反向无功电度",
				 "平正向有功电度","平反向有功电度","平正向无功电度","平反向无功电度",
				 "尖正向有功电度","尖反向有功电度","尖正向无功电度","尖反向无功电度",
				 "效率","功率因数","健康状态","创建时间" };
		// 定义表的内容
		List<Object[]> dataList = new ArrayList<Object[]>();

		Object[] objs = null;
		
		for (int i = 0; i < lst.size(); i++) {
			objs = new Object[rowsName.length];

			objs[0] = lst.get(i).get("id");
			
			if (lst.get(i) == null || lst.get(i).get("equ_num") == null || lst.get(i).get("equ_num").toString().isEmpty()) {
				objs[1] = "无";
			}else {
				//设备编号
				objs[1] = lst.get(i).get("equ_num");
			}
			if (lst.get(i) == null || lst.get(i).get("stat") == null || lst.get(i).get("stat").toString().isEmpty()) {
				objs[2] = "无";
			}else {
				//设备状态
				objs[2] = lst.get(i).get("stat");
			}
			if (lst.get(i) == null || lst.get(i).get("pt") == null || lst.get(i).get("pt").toString().isEmpty()) {
				objs[3] = "无";
			}else {
				objs[3] = lst.get(i).get("pt");
			}
			if (lst.get(i) == null || lst.get(i).get("ct") == null || lst.get(i).get("ct").toString().isEmpty()) {
				objs[4] = "无";
			}else {
				objs[4] = lst.get(i).get("ct");
			}
			if (lst.get(i) == null || lst.get(i).get("uab") == null || lst.get(i).get("uab").toString().isEmpty()) {
				objs[5] = "无";
			}else {
				objs[5] = lst.get(i).get("uab");
			}
			if (lst.get(i) == null || lst.get(i).get("ubc") == null || lst.get(i).get("ubc").toString().isEmpty()) {
				objs[6] = "无";
			}else {
				objs[6] = lst.get(i).get("ubc");
			}
			if (lst.get(i) == null || lst.get(i).get("uca") == null || lst.get(i).get("uca").toString().isEmpty()) {
				objs[7] = "无";
			}else {
				objs[7] = lst.get(i).get("uca");
			}
			if (lst.get(i) == null || lst.get(i).get("ua") == null || lst.get(i).get("ua").toString().isEmpty()) {
				objs[8] = "无";
			}else {
				objs[8] = lst.get(i).get("ua");
			}
			if (lst.get(i) == null || lst.get(i).get("ub") == null || lst.get(i).get("ub").toString().isEmpty()) {
				objs[9] = "无";
			}else {
				objs[9] = lst.get(i).get("ub");
			}
			if (lst.get(i) == null || lst.get(i).get("uc") == null || lst.get(i).get("uc").toString().isEmpty()) {
				objs[10] = "无";
			}else {
				objs[10] = lst.get(i).get("uc");
			}
			if (lst.get(i) == null || lst.get(i).get("ia") == null || lst.get(i).get("ia").toString().isEmpty()) {
				objs[11] = "无";
			}else {
				objs[11] = lst.get(i).get("ia");
			}
			if (lst.get(i) == null || lst.get(i).get("ib") == null || lst.get(i).get("ib").toString().isEmpty()) {
				objs[12] = "无";
			}else {
				objs[12] = lst.get(i).get("ib");
			}
			if (lst.get(i) == null || lst.get(i).get("ic") == null || lst.get(i).get("ic").toString().isEmpty()) {
				objs[13] = "无";
			}else {
				objs[13] = lst.get(i).get("ic");
			}
			if (lst.get(i) == null || lst.get(i).get("pa") == null || lst.get(i).get("pa").toString().isEmpty()) {
				objs[14] = "无";
			}else {
				objs[14] = lst.get(i).get("pa");
			}
			if (lst.get(i) == null || lst.get(i).get("pb") == null || lst.get(i).get("pb").toString().isEmpty()) {
				objs[15] = "无";
			}else {
				objs[15] = lst.get(i).get("pb");
			}
			if (lst.get(i) == null || lst.get(i).get("pc") == null || lst.get(i).get("pc").toString().isEmpty()) {
				objs[16] = "无";
			}else {
				objs[16] = lst.get(i).get("pc");
			}
			if (lst.get(i) == null || lst.get(i).get("psum") == null || lst.get(i).get("psum").toString().isEmpty()) {
				objs[17] = "无";
			}else {
				objs[17] = lst.get(i).get("psum");
			}
			if (lst.get(i) == null || lst.get(i).get("qsum") == null || lst.get(i).get("qsum").toString().isEmpty()) {
				objs[18] = "无";
			}else {
				objs[18] = lst.get(i).get("qsum");
			}
			if (lst.get(i) == null || lst.get(i).get("ssum") == null || lst.get(i).get("ssum").toString().isEmpty()) {
				objs[19] = "无";
			}else {
				objs[19] = lst.get(i).get("ssum");
			}
			if (lst.get(i) == null || lst.get(i).get("phiValue") == null || lst.get(i).get("phiValue").toString().isEmpty()) {
				objs[20] = "无";
			}else {
				objs[20] = lst.get(i).get("phiValue");
			}
			if (lst.get(i) == null || lst.get(i).get("pheValue") == null || lst.get(i).get("pheValue").toString().isEmpty()) {
				objs[21] = "无";
			}else {
				objs[21] = lst.get(i).get("pheValue");
			}
			if (lst.get(i) == null || lst.get(i).get("qhiValue") == null || lst.get(i).get("qhiValue").toString().isEmpty()) {
				objs[22] = "无";
			}else {
				objs[22] = lst.get(i).get("qhiValue");
			}
			if (lst.get(i) == null || lst.get(i).get("qheValue") == null || lst.get(i).get("qheValue").toString().isEmpty()) {
				objs[23] = "无";
			}else {
				objs[23] = lst.get(i).get("qheValue");
			}
			if (lst.get(i) == null || lst.get(i).get("phi") == null || lst.get(i).get("phi").toString().isEmpty()) {
				objs[24] = "无";
			}else {
				objs[24] = lst.get(i).get("phi");
			}
			if (lst.get(i) == null || lst.get(i).get("phe") == null || lst.get(i).get("phe").toString().isEmpty()) {
				objs[25] = "无";
			}else {
				objs[25] = lst.get(i).get("phe");
			}
			if (lst.get(i) == null || lst.get(i).get("qhi") == null || lst.get(i).get("qhi").toString().isEmpty()) {
				objs[26] = "无";
			}else {
				objs[26] = lst.get(i).get("qhi");
			}
			if (lst.get(i) == null || lst.get(i).get("qhe") == null || lst.get(i).get("qhe").toString().isEmpty()) {
				objs[27] = "无";
			}else {
				objs[27] = lst.get(i).get("qhe");
			}
			if (lst.get(i) == null || lst.get(i).get("phiTop") == null || lst.get(i).get("phiTop").toString().isEmpty()) {
				objs[28] = "无";
			}else {
				objs[28] = lst.get(i).get("phiTop");
			}
			if (lst.get(i) == null || lst.get(i).get("pheTop") == null || lst.get(i).get("pheTop").toString().isEmpty()) {
				objs[29] = "无";
			}else {
				objs[29] = lst.get(i).get("pheTop");
			}
			if (lst.get(i) == null || lst.get(i).get("qhiTop") == null || lst.get(i).get("qhiTop").toString().isEmpty()) {
				objs[30] = "无";
			}else {
				objs[30] = lst.get(i).get("qhiTop");
			}
			if (lst.get(i) == null || lst.get(i).get("qheTop") == null || lst.get(i).get("qheTop").toString().isEmpty()) {
				objs[31] = "无";
			}else {
				objs[31] = lst.get(i).get("qheTop");
			}
			if (lst.get(i) == null || lst.get(i).get("phiVal") == null || lst.get(i).get("phiVal").toString().isEmpty()) {
				objs[32] = "无";
			}else {
				objs[32] = lst.get(i).get("phiVal");
			}
			if (lst.get(i) == null || lst.get(i).get("pheVal") == null || lst.get(i).get("pheVal").toString().isEmpty()) {
				objs[33] = "无";
			}else {
				objs[33] = lst.get(i).get("pheVal");
			}
			if (lst.get(i) == null || lst.get(i).get("qhiVal") == null || lst.get(i).get("qhiVal").toString().isEmpty()) {
				objs[34] = "无";
			}else {
				objs[34] = lst.get(i).get("qhiVal");
			}
			if (lst.get(i) == null || lst.get(i).get("qheVal") == null || lst.get(i).get("qheVal").toString().isEmpty()) {
				objs[35] = "无";
			}else {
				objs[35] = lst.get(i).get("qheVal");
			}
			if (lst.get(i) == null || lst.get(i).get("phiFlat") == null || lst.get(i).get("phiFlat").toString().isEmpty()) {
				objs[36] = "无";
			}else {
				objs[36] = lst.get(i).get("phiFlat");
			}
			if (lst.get(i) == null || lst.get(i).get("pheFlat") == null || lst.get(i).get("pheFlat").toString().isEmpty()) {
				objs[37] = "无";
			}else {
				objs[37] = lst.get(i).get("pheFlat");
			}
			if (lst.get(i) == null || lst.get(i).get("qhiFlat") == null || lst.get(i).get("qhiFlat").toString().isEmpty()) {
				objs[38] = "无";
			}else {
				objs[38] = lst.get(i).get("qhiFlat");
			}
			if (lst.get(i) == null || lst.get(i).get("qheFlat") == null || lst.get(i).get("qheFlat").toString().isEmpty()) {
				objs[39] = "无";
			}else {
				objs[39] = lst.get(i).get("qheFlat");
			}
			if (lst.get(i) == null || lst.get(i).get("phiPeak") == null || lst.get(i).get("phiPeak").toString().isEmpty()) {
				objs[40] = "无";
			}else {
				objs[40] = lst.get(i).get("phiPeak");
			}
			if (lst.get(i) == null || lst.get(i).get("phePeak") == null || lst.get(i).get("phePeak").toString().isEmpty()) {
				objs[41] = "无";
			}else {
				objs[41] = lst.get(i).get("phePeak");
			}
			if (lst.get(i) == null || lst.get(i).get("qhiPeak") == null || lst.get(i).get("qhiPeak").toString().isEmpty()) {
				objs[42] = "无";
			}else {
				objs[42] = lst.get(i).get("qhiPeak");
			}
			if (lst.get(i) == null || lst.get(i).get("qhePeak") == null || lst.get(i).get("qhePeak").toString().isEmpty()) {
				objs[43] = "无";
			}else {
				objs[43] = lst.get(i).get("qhePeak");
			}
			if (lst.get(i) == null || lst.get(i).get("freq") == null || lst.get(i).get("freq").toString().isEmpty()) {
				objs[44] = "无";
			}else {
				objs[44] = lst.get(i).get("freq");
			}
			if (lst.get(i) == null || lst.get(i).get("pf") == null || lst.get(i).get("pf").toString().isEmpty()) {
				objs[45] = "无";
			}else {
				objs[45] = lst.get(i).get("pf");
			}
			if (lst.get(i) == null || lst.get(i).get("healthStat") == null || lst.get(i).get("healthStat").toString().isEmpty()) {
				objs[46] = "无";
			}else {
				objs[46] = lst.get(i).get("healthStat");
			}
			if (lst.get(i) == null || lst.get(i).get("crtTim") == null || lst.get(i).get("crtTim").toString().isEmpty()) {
				objs[47] = "无";
			}else {
				objs[47] = lst.get(i).get("crtTim");
			}
			dataList.add(objs);
		}
		// 创建ExportExcel对象
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment; filename=CollectDataLst.xls");
		response.setContentType("application/msexcel");
		ex.export(output);
		output.close();
	}
	
	
	@Value("${file.upload.path}")
	String filePath;
	
	/**
	 * 
	 * 图片  或  文件 下载
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/service/downloadImgOrFile")
	@ResponseBody
	public BaseTransferEntity download(HttpServletRequest request,HttpServletResponse response) throws Exception {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		try{
			String path = null;
			String name = null;
			String NewName = null;
			String type = request.getParameter("type");
			//图片或文件 id
			String id = request.getParameter("id");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
	
			// type为1 是 图片
			if ("1".equals(type)) {
			
					//根据id 查询图片信息
					lst = tourService.getTourImageById(map);
					//判断 图片 或 文件 是否为空
					if (lst == null || lst.isEmpty()) {
						baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
						baseTransferEntity.setDesc("图片不存在，或已被删除，请重新选择！");
						return baseTransferEntity;
						//return false;
					}
						//得到 图片的 访问路径
						path = (String) lst.get(0).get("image_path");
						//得到 图片的 名字
						name = (String) lst.get(0).get("tour_image_name");
						//访问路径去除空格
						File tempFile =new File(path.trim());  
						//得到  图片 名字
				        NewName = tempFile.getName();  
			        
				
				// type为2 是 文件
			} else if ("2".equals(type)) {
					//根据id 查询文件信息
					lst = tourService.getTourFileById(map);
					//判断 图片 或 文件 是否为空
					if (lst == null || lst.isEmpty()) {
						baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
						baseTransferEntity.setDesc("文件不存在，或已被删除，请重新选择！");
						return baseTransferEntity;
						//return false;
						
					}
						//得到 文件的 访问路径
						path = (String) lst.get(0).get("file_path");
						//得到 文件的 名字
						name = (String) lst.get(0).get("file_name");
						//访问路径去除空格
						File tempFile =new File(path.trim());  
						//得到 文件 名字
						NewName = tempFile.getName();  
			}else{
					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
					baseTransferEntity.setDesc("非法参数！(参数有问题，前台传值有误。)");
					return baseTransferEntity;
			}
			
			
			/*//判断 图片 或 文件 是否为空
			if (lst == null || lst.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig
						.get("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在");
				//return false;
			}*/
			// filePath 在conf.properties 中配置
			// 如果在controller中使用
			// @Value("${file.upload.path}")
			// String filePath;
			// 需要在mvc-dispatcher-servlet.xml配置扫描  <context:property-placeholder location="classpath:config/conf.properties"/> 在service中 则不需要 
			//下载路径 = filePath + 图片 或 文件 名字
			//filePath += NewName;
			File file = new File((filePath+NewName)); //filePath  路径  指的是 具体到文件的路径  比如 E://file/aaaa.peg   如果是E:file 的话  会报异常  拒绝访问
			if (!file.exists()) {
				baseTransferEntity.setResultcode(MobileConfig.get("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在，可能被非法删除");
				return baseTransferEntity;
				//return false;
			}
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName="+ java.net.URLEncoder.encode(name, "UTF-8"));
				// 设置文件名
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
				
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
				}
				//return true;
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setData(null);
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
				return baseTransferEntity;
			
			} catch (Exception e) {
				e.printStackTrace();
				//return false;
				return baseTransferEntity;
			} finally {
				if (bis != null) {
					
						bis.close();
				}
				if (fis != null) {
					
						fis.close();
				}
				
			}
		
		}catch (Exception e) {
			log.error("TourController OverhaulPlanExport--------->"+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
	
}	
	
	
	
	/**
	 *
	 * 告警数据列表导出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/FatDataLstExport")
	@ResponseBody
	public BaseTransferEntity FatDataLstExport(HttpServletRequest request,HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			
			// 站ID
			String pws_id = request.getParameter("pws_id");
			// 设备编码
			String equ_num = request.getParameter("equ_num");
			// 指定时间段开始时间
			String sta_tim = request.getParameter("sta_tim");
			// 指定时间段结束时间
			String end_tim = request.getParameter("end_tim");
			// 设备类型唯一标识
			String typ_ide = request.getParameter("typ_ide");
			
			String use_id = request.getParameter("use_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pws_id", pws_id);
			
			map.put("equ_num", equ_num);
			
			map.put("sta_tim", sta_tim);
			
			map.put("end_tim", end_tim);
			
			map.put("typ_ide", typ_ide);
			
			map.put("use_id", use_id);
			// 获取巡视计划的列表
			lst = statisticAnalysisService.getFatDataLst(map);

			// 定义表的标题
			String title = "告警数据列表一览";

			// 定义表的列名
			String[] rowsName = new String[] {"序号", "设备编号", "设备名称", "设备类型",
					"故障或告警级别", "故障码", "故障索引", "故障信息", "故障标志", "故障变化时间" };

			// 定义表的内容
			List<Object[]> dataList = new ArrayList<Object[]>();

			Object[] objs = null;

			for (int i = 0; i < lst.size(); i++) {
				
				objs = new Object[rowsName.length];
				
				
				objs[0] = lst.get(i).get("id");
				//开始放置数据
				
				if (lst.get(i) == null || lst.get(i).get("PID") == null || lst.get(i).get("PID").toString().isEmpty()) {
					objs[1] = "无";
				}else{
					
					objs[1] = lst.get(i).get("PID");
				}
				
				if (lst.get(i) == null || lst.get(i).get("name") == null || lst.get(i).get("name").toString().isEmpty()) {
					objs[2] = "无";
				}else{
					
					objs[2] = lst.get(i).get("name");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("type") == null || lst.get(i).get("type").toString().isEmpty()) {
					objs[3] = "无";
				}else{
					
					objs[3] = lst.get(i).get("type");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("level") == null || lst.get(i).get("level").toString().isEmpty()) {
					objs[4] = "无";
				}else{
					
					objs[4] = lst.get(i).get("level").equals(1) ? "告警" : "故障";
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("num") == null || lst.get(i).get("num").toString().isEmpty()) {
					objs[5] = "无";
				}else{
					
					objs[5] = lst.get(i).get("num");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("index") == null || lst.get(i).get("index").toString().isEmpty()) {
					objs[6] = "无";
				}else{
					
					objs[6] = lst.get(i).get("index");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("info") == null || lst.get(i).get("info").toString().isEmpty()) {
					objs[7] = "无";
				}else{
					
					objs[7] = lst.get(i).get("info");
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("flag") == null || lst.get(i).get("flag").toString().isEmpty()) {
					objs[8] = "无";
				}else{
					
					objs[8] = lst.get(i).get("flag").equals(1) ? "发生" : "消失";
					
				}
				
				if (lst.get(i) == null || lst.get(i).get("time") == null || lst.get(i).get("time").toString().isEmpty()) {
					objs[9] = "无";
				}else{
					
					objs[9] = lst.get(i).get("time");
					
				}

				dataList.add(objs);
			}

			// 创建ExportExcel对象
			ExportExcel ex = new ExportExcel(title, rowsName, dataList);

			// 输出Excel文件
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition","attachment; filename=FatDataLst.xls");
			response.setContentType("application/msexcel");
			ex.export(output);
			output.close();

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TourController TourPlanExport--------->"+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}
	
	
	
	
	
	
	
	
	
	
}
