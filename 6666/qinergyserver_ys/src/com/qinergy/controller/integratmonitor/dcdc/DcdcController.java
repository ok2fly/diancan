package com.qinergy.controller.integratmonitor.dcdc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.PagerTwo;
import com.qinergy.service.integratmonitor.IntegratMonitorService;
import com.qinergy.service.integratmonitor.dcdc.DcdcService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;

/**
 * DCDC设备 页面控制器
 * 
 * @desc:
 * @author: Qist
 * @date: 2017年10月25日
 */
@Controller
@RequestMapping(value = "")
public class DcdcController {

	private static Logger log = Logger.getLogger(DcdcController.class);

	@Autowired
	private DcdcService dcdcService;
	@Autowired
	private IntegratMonitorService integratMonitorService;

	BaseTransferEntity baseTransferEntity;

	 /**
     * 获取DC/DC设备列表页的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDcdcInfLst")
    @ResponseBody
    public BaseTransferEntity getDcdcInfLst(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 设备类型ID
            String app_typ_id = request.getParameter("app_typ_id");
            // 场站ID(电站ID)
            String pws_id = request.getParameter("pws_id");
            //状态
            String stat = request.getParameter("stat");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("app_typ_id", app_typ_id);
            
            map.put("pws_id", pws_id);
            
            map.put("stat", stat);
            
			List<Map<String, Object>> lstlist = dcdcService.getDcdcInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PvsController getDcdcInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
	
	
	
	/**
	 * 1.DCDC设备统计页面展示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDCDCInfPage")
	@ResponseBody
	public BaseTransferEntity getDCDCInfPage(HttpServletRequest request, HttpServletResponse response) {

		baseTransferEntity = new BaseTransferEntity();
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst;
		Map<String, Object> resultMap;

		String typ_id = request.getParameter("typ_id"); // 设备类型id
		String pws_id = request.getParameter("pws_id"); // 电站id
		Map<String, Object> map = new HashMap<String, Object>();
		if (typ_id != null && typ_id != "") {
			map.put("typ_id", Integer.parseInt(typ_id));
		}
		if (pws_id != null && pws_id != "") {
			map.put("pws_id", Integer.parseInt(pws_id));
		}

		// 设备状态:0：通讯中断、1：正常运行、2：正常停机、3：告警运行、4：故障停机
		Integer breakStatCount = 0; // 通讯中断状态计数器
		Integer norRunStatCount = 0; // 正常运行状态计数器
		Integer norStopStatCount = 0; // 正常停机状态计数器
		Integer alaRunStatCount = 0; // 告警运行状态计数器
		Integer fauStopStatCount = 0; // 故障停机状态计数器

		try {

			resultLst = new ArrayList<Map<String, Object>>();

			// 根据 typ_id、pws_id获取某电站DCDC 设备所有编号
			List<Map<String, Object>> equNumLst = integratMonitorService.getEquNumLstByPwsEquTyp(map);

			if (equNumLst != null && !equNumLst.isEmpty()) {
				for (Map<String, Object> equNumMap : equNumLst) {

					// 从实时数据中获取 某一个设备数据
					Map<String, Object> dcdcRealByNum = dcdcService.getDCDCRealByNum(equNumMap);
					if (dcdcRealByNum != null && !dcdcRealByNum.isEmpty()) {
						dcdcRealByNum.put("equ_nam", equNumMap.get("equ_nam"));
						Integer equStat = (Integer)dcdcRealByNum.get("stat");
						if (equStat == 0) {
							breakStatCount = breakStatCount + 1;
						} else if (equStat == 1) {
							norRunStatCount = norRunStatCount + 1;
						} else if (equStat ==2 ) {
							norStopStatCount = norStopStatCount + 1;
						} else if (equStat == 3) {
							alaRunStatCount = alaRunStatCount + 1;
						} else if (equStat == 4) {
							fauStopStatCount = fauStopStatCount + 1;
						} else {
							breakStatCount = breakStatCount + 1;
						}

						// 将 设备存入集合
						resultLst.add(dcdcRealByNum);
					}
				}
			}

			resultMap = new HashMap<String, Object>();
			resultMap.put("breakStatCount", breakStatCount);
			resultMap.put("norRunStatCount", norRunStatCount);
			resultMap.put("norStopStatCount", norStopStatCount);
			resultMap.put("alaRunStatCount", alaRunStatCount);
			resultMap.put("fauStopStatCount", fauStopStatCount);
			resultMap.put("resultLst", resultLst);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(resultMap);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DcdcController getDCDCMassPage--->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 2. DCDC设备实时数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDCDCRealInf")
	@ResponseBody
	public BaseTransferEntity getDCDCRealInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equ_num", equ_num);

		try {
			// 1.获取该dcdc的最新的一条记录 （包含 告警牌信息）
			Map<String, Object> dcdcReal = dcdcService.getDCDCRealByNum(map);
			// 2.获取当天数据 图表分析
			List<Map<String, Object>> dcdcRealList = dcdcService.getDCDCRealList(map);
			// 3.设备静态信息 + 保修信息
			Map<String, Object> dcdcEqu = dcdcService.getDCDCEquByNum(map);
			Map<String, Object> equData = new HashMap<String, Object>();

			equData.put("dcdcReal", dcdcReal);
			equData.put("dcdcRealList", dcdcRealList);
			equData.put("dcdcEqu", dcdcEqu);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(equData);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DcdcController getDCDCRealInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * DCDC设备其他详情数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDCDCOtherInf")
	@ResponseBody
	public BaseTransferEntity getDCDCOtherInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equ_num", equ_num);

		try {
			// 1.获取该dcdc的最新的一条记录 （包含 告警牌信息）
			Map<String, Object> dcdcReals = dcdcService.getDCDCRealsByNum(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(dcdcReals);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {
			log.error("DcdcController getDCDCOtherInf--->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 3.DCDC设备历史数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDCDCHistoryInf")
	@ResponseBody
	public BaseTransferEntity getDCDCHistoryInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		String day = request.getParameter("day"); // 日历 上某一天
		String currentPage = request.getParameter("currentPage"); // 查询的页数

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equ_num", equ_num);

		PagerTwo page = new PagerTwo();
		if (currentPage != null && !currentPage.isEmpty()) {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}

		try {
			/**
			 * DateUtil.getDayMonYearTimLst(String date, String type) date :
			 * 某天的日期 type : 1:按日 2：按月 3：按年
			 * 
			 * @return 每天的 startTim和endTim（月或者年时为【startTim和endTim】集合） startTim:
			 *         根据day字段获取某一天 00:00时间 endTim: 根据day字段获取某一天 23:59时间
			 */
			List<Map<String, Object>> dayTim;
			if (day != null && !day.isEmpty()) {
				dayTim = DateUtil.getDayMonYearTimLst(day, "5");
			} else {
				dayTim = DateUtil.getDayMonYearTimLst(DateUtil.getcurrentTime(), "5");
			}
			map.put("startTim", dayTim.get(0).get("sta_tim"));
			map.put("endTim", dayTim.get(0).get("end_tim"));

			int totalCount = dcdcService.getDCDCHistoryCount(map);
			page.setTotalCount(totalCount);

			map.put("start", page.getStart());
			map.put("everyPage", page.getEveryPage());
			List<Map<String, Object>> dcdcHistoryList = dcdcService.getDCDCHistoryList(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(dcdcHistoryList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DcdcController getDCDCHistoryInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	/**
	 * 3.DCDC设备历史数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDCDCHistoryGraph")
	@ResponseBody
	public BaseTransferEntity getDCDCHistoryGraph(HttpServletRequest request, HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();
		
		String equ_num = request.getParameter("equ_num"); // 设备编号
		
		String day = request.getParameter("day"); // 日历 上某一天
		
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			map.put("date", day);
		/**
			DateUtil.getDayMonYearTimLst(String date, String type) date :
			某天的日期 type : 1:按日 2：按月 3：按年
			 
			return 每天的 startTim和endTim（月或者年时为【startTim和endTim】集合） startTim:
			根据day字段获取某一天 00:00时间 endTim: 根据day字段获取某一天 23:59时间
		*/ 
			
			List<Map<String, Object>> dcdcHistoryList = dcdcService.getDCDCHistoryGraph(map);
			
			baseTransferEntity.setData(dcdcHistoryList);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		
		} catch (Exception e) {
			
			log.error("DcdcController getDCDCHistoryInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * TODO 待定 DCDC设备健康状况页面 --告警记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDCDCFaultList")
	@ResponseBody
	public BaseTransferEntity getDCDCFaultList(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		if (equ_num != null && equ_num != "") {
			map.put("equ_num", Integer.parseInt(equ_num));
		}
		try {
			// 告警记录
			List<Map<String, Object>> dcdcFaultList = dcdcService.getDCDCFaultList(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(dcdcFaultList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DcdcController getDCDCFaultList--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * TODO 待定 DCDC设备健康状况页面 --维修记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDCDCRepairList")
	@ResponseBody
	public BaseTransferEntity getDCDCRepairList(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		if (equ_num != null && equ_num != "") {
			map.put("equ_num", Integer.parseInt(equ_num));
		}
		try {
			// 告警记录
			List<Map<String, Object>> dcdcRepairList = dcdcService.getDCDCRepairList(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(dcdcRepairList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DcdcController getDCDCRepairList--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * TODO 待定 DCDC设备健康状况页面 --保养记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDCDCMainList")
	@ResponseBody
	public BaseTransferEntity getDCDCMainList(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		if (equ_num != null && equ_num != "") {
			map.put("equ_num", Integer.parseInt(equ_num));
		}
		try {
			// 保养记录
			List<Map<String, Object>> dcdcMainList = dcdcService.getDCDCMainList(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(dcdcMainList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DcdcController getDCDCMainList--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

}
