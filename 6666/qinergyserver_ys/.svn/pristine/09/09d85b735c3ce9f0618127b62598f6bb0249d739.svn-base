package com.qinergy.controller.integratmonitor.mater;

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
import com.qinergy.service.integratmonitor.meter.MeterService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;

/**
 * @desc: 设备详情：电表页面 控制器
 * @author: Qist
 * @date: 2017年10月27日
 */
@Controller
@RequestMapping(value = "")
public class MeterController {

	@Autowired
	private MeterService meterService;

	@Autowired
	private IntegratMonitorService integratMonitorService;

	private static Logger log = Logger.getLogger(MeterController.class);

	BaseTransferEntity baseTransferEntity;
	
	/**
     * 获取Meter设备列表页的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getMeterInfLst")
    @ResponseBody
    public BaseTransferEntity getMeterInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = meterService.getMeterInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PvsController getMeterInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
	
	/**
	 * @Title: getTransfRealInf
	 * @Desc: 电表 设备列表页面 展示字段：名称、状态、
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping(value = "/service/getMeterInfPage")
	@ResponseBody
	public BaseTransferEntity getMeterInfPage(HttpServletRequest request, HttpServletResponse response) {
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
		String stat = request.getParameter("stat"); // 设备状态
		Integer breakStatCount = 0; // 通讯中断状态计数器
		Integer norStatCount = 0; // 正常运行状态计数器

		try {

			resultLst = new ArrayList<Map<String, Object>>();

			// 获取某电站DCDC 设备所有编号
			List<Map<String, Object>> equNumLst = integratMonitorService.getEquNumLstByPwsEquTyp(map);

			if (equNumLst != null && !equNumLst.isEmpty()) {
				for (Map<String, Object> equNumMap : equNumLst) {

					// 从实时数据中获取 某一个设备数据
					Map<String, Object> newMap = new HashMap<String, Object>();
					newMap.put("equ_num", equNumMap.get("equ_num"));
					
					Map<String, Object> meterRealByNum = meterService.getMeterRealByEquNum(newMap);
					
					if (meterRealByNum != null && !meterRealByNum.isEmpty()) {
						meterRealByNum.put("equ_nam", equNumMap.get("equ_nam").toString());
						Integer equStat = (Integer)meterRealByNum.get("stat");

						// 设备状态:0：通讯中断、1：正常运行
						if (equStat == 0) {
							breakStatCount = breakStatCount + 1;
						} else if (equStat == 1) {
							norStatCount = norStatCount + 1;
						} else  {
							breakStatCount = breakStatCount + 1;
						}
						// 将 设备存入集合
						resultLst.add(meterRealByNum);
					}
				}
			}

			resultMap = new HashMap<String, Object>();
			resultMap.put("breakStatCount", breakStatCount);
			resultMap.put("norRunStatCount", norStatCount);
			resultMap.put("resultLst", resultLst);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(resultMap);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("MeterController getMeterInfPage--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 2. 电表 设备实时数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterRealInf")
	@ResponseBody
	public BaseTransferEntity getMeterRealInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equ_num", equ_num);

		try {
			// 1.获取该电表的最新的一条记录
			Map<String, Object> meterReal = meterService.getMeterRealByEquNum(map);
			// 2.获取当天数据 图表分析
			List<Map<String, Object>> meterRealList = meterService.getMeterRealList(map);
			// 3.设备静态信息 + 保修信息
			Map<String, Object> meterEqu = integratMonitorService.getEquStaticInfByNum(map);
			Map<String, Object> equData = new HashMap<String, Object>();

			equData.put("meterReal", meterReal);
			equData.put("meterRealList", meterRealList);
			equData.put("meterEqu", meterEqu);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(equData);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("MeterController: getMeterRealInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	/**
	 * 2. 电表 设备实时数据页面(正反向有无功电度柱状图)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterRealListMonth")
	@ResponseBody
	public BaseTransferEntity getMeterRealListMonth(HttpServletRequest request, HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();
		
		String equ_num = request.getParameter("equ_num"); // 设备编号
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("equ_num", equ_num);
		
		try {
			// 2.获取当天数据 图表分析
			List<Map<String, Object>> meterRealList = meterService.getMeterRealListMonth(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(meterRealList);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("MeterController: getMeterRealListMonth--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * 2. 电表 设备实时数据页面(正反向有无功电度柱状图)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterHistoryMonthGraph")
	@ResponseBody
	public BaseTransferEntity getMeterHistoryMonthGraph(HttpServletRequest request, HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();
		
		String equ_num = request.getParameter("equ_num"); // 设备编号
		
		String date = request.getParameter("date"); // 时间
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("equ_num", equ_num);
		
		map.put("date", date);
		
		try {
			// 2.获取当天数据 图表分析
			List<Map<String, Object>> meterRealList = meterService.getMeterHistoryMonthGraph(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(meterRealList);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("MeterController: getMeterHistoryMonthGraph--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
     * 根据设备编号 获取当月正反向电度数据 (分页)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getMeterHistoryListMonth")
    @ResponseBody
    public BaseTransferEntity getMeterHistoryListMonth(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		PagerTwo page = new PagerTwo();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
    		String equ_num = request.getParameter("equ_num");
    		
    		String date = request.getParameter("date");
    		
    		Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());
			
    		map.put("equ_num", equ_num);
    		
    		map.put("date", date);
    		
    		Map<String, Object> couMap = meterService.getMeterHistoryListMonthCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = meterService.getMeterHistoryListMonth(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	} catch (Exception e) {
    		
    		log.error("MeterController getMeterHistoryListMonth--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
	/**
	 * 电表设备其他详情数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterOtherInf")
	@ResponseBody
	public BaseTransferEntity getMeterOtherInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equ_num", equ_num);
		
		try {
			// 1.获取该电表的最新的一条记录（所有字段）
			Map<String, Object> meterReals = meterService.getMeterRealsByEquNum(map);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(meterReals);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			baseTransferEntity.setData(null);
			log.error("MeterController: getMeterOtherInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * 3.电表设备历史数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterHistoryInf")
	@ResponseBody
	public BaseTransferEntity getMeterHistoryInf(HttpServletRequest request, HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		
		String day = request.getParameter("day"); // 日历 上某一天
		
		String currentPage = request.getParameter("currentPage");// 当前页数

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

			int totalCount = meterService.getMeterHistoryCount(map);
			
			page.setTotalCount(totalCount);

			map.put("start", page.getStart());
			
			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> meterHistoryList = meterService.getMeterHistoryList(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setData(meterHistoryList);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("MeterController: getMeterHistoryInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	/**
	 * 3.电表设备历史数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterHistoryGraph")
	@ResponseBody
	public BaseTransferEntity getMeterHistoryGraph(HttpServletRequest request, HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();
		
		String equ_num = request.getParameter("equ_num"); // 设备编号
		
		String day = request.getParameter("day"); // 日历 上某一天
		
		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("equ_num", equ_num);
			
			map.put("date", day);
			
			List<Map<String, Object>> meterHistoryList = meterService.getMeterHistoryGraph(map);
			
			baseTransferEntity.setData(meterHistoryList);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			log.error("MeterController: getMeterHistoryInf--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * TODO 电表设备健康状况页面 --告警记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterFaultList")
	@ResponseBody
	public BaseTransferEntity getMeterFaultList(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");
		String pws_id = request.getParameter("pws_id"); // 站点id
		Map<String, Object> map = new HashMap<String, Object>();
		if (id != null && id != "") {
			map.put("id", Integer.parseInt(id));
		}
		if (pws_id != null && pws_id != "") {
			map.put("pws_id", Integer.parseInt(pws_id));
		}
		try {
			/** 告警记录 TODO */
			List<Map<String, Object>> meterFaultList = null;
			/** 告警记录 TODO */

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(meterFaultList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("MeterController: getMeterFaultList--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * TODO 电表设备健康状况页面 --维修记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterRepairList")
	@ResponseBody
	public BaseTransferEntity getMeterRepairList(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");
		String pws_id = request.getParameter("pws_id"); // 站点id
		Map<String, Object> map = new HashMap<String, Object>();
		if (id != null && id != "") {
			map.put("id", Integer.parseInt(id));
		}
		if (pws_id != null && pws_id != "") {
			map.put("pws_id", Integer.parseInt(pws_id));
		}
		try {
			/** 维修记录 TODO */
			List<Map<String, Object>> meterRepairList = null;
			/** 维修记录 TODO */

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(meterRepairList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("MeterController: getMeterRepairList--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * TODO 电表设备健康状况页面 --保养记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMeterMainList")
	@ResponseBody
	public BaseTransferEntity getMeterMainList(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");
		String pws_id = request.getParameter("pws_id"); // 站点id
		Map<String, Object> map = new HashMap<String, Object>();
		if (id != null && id != "") {
			map.put("id", Integer.parseInt(id));
		}
		if (pws_id != null && pws_id != "") {
			map.put("pws_id", Integer.parseInt(pws_id));
		}
		try {
			/** 保养记录 TODO */
			List<Map<String, Object>> meterMainList = null;
			/** 保养记录 TODO */

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(meterMainList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("MeterController: getMeterMainList--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
}
