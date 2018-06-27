package com.qinergy.controller.integratmonitor.tranf;

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
import com.qinergy.service.integratmonitor.transf.TransformerService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;

/**
 * @desc: 变压器 设备页面控制器
 * @author: Qist
 * @date: 2017年10月25日
 */
@Controller
@RequestMapping(value = "")
public class TransformerController {

	@Autowired
	private TransformerService transformerService;
	@Autowired
	private IntegratMonitorService integratMonitorService;

	private static Logger log = Logger.getLogger(TransformerController.class);

	BaseTransferEntity baseTransferEntity;
	
	/**
     * 获取变压器设备列表页的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getTransfInfLst")
    @ResponseBody
    public BaseTransferEntity getTransfInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
            List<Map<String,Object>> lstlist = transformerService.getTransfInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PvsController getTransfInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
	/**
	 * @Desc: 变压器 设备列表页面 展示字段：名称、状态、
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping(value = "/service/getTransfInfPage")
	@ResponseBody
	public BaseTransferEntity getTransfInfPage(HttpServletRequest request, HttpServletResponse response) {
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
		Integer breakStatCount = 0; // 通讯中断状态计数器
		Integer norStatCount = 0; // 正常运行状态计数器
		Integer alaStatCount = 0; // 告警运行状态计数器

		try {

			resultLst = new ArrayList<Map<String, Object>>();

			// 获取某电站DCDC 设备所有编号
			List<Map<String, Object>> equNumLst = integratMonitorService.getEquNumLstByPwsEquTyp(map);

			if (equNumLst != null && !equNumLst.isEmpty()) {
				for (Map<String, Object> equNumMap : equNumLst) {

					// 从实时数据中获取 某一个设备数据
					Map<String, Object> transfRealByNum = transformerService.getTransfRealByEquNum(equNumMap);
					if (transfRealByNum != null && !transfRealByNum.isEmpty()) {

						transfRealByNum.put("equ_nam", equNumMap.get("equ_nam"));

						// 设备状态:0：通讯中断、1：正常运行、2、设备告警
						Integer equStat = (Integer)transfRealByNum.get("stat");
						if (equStat == 0) {
							breakStatCount = breakStatCount + 1;
						} else if (equStat == 1) {
							norStatCount = norStatCount + 1;
						} else if (equStat ==2 ) {
							alaStatCount = alaStatCount + 1;
						}  else {
							breakStatCount = breakStatCount + 1;
						}
						// 将 设备存入集合
						resultLst.add(transfRealByNum);
					}
				}
			}

			resultMap = new HashMap<String, Object>();
			resultMap.put("breakStatCount", breakStatCount);
			resultMap.put("norRunStatCount", norStatCount);
			resultMap.put("norStopStatCount", alaStatCount);
			resultMap.put("resultLst", resultLst);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(resultMap);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TransformerController: getTransfInfPage--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 2. 变压器 设备实时数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getTransfRealInf")
	@ResponseBody
	public BaseTransferEntity getTransfRealInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equ_num", equ_num);

		try {
			// 1.获取该transf的最新的一条记录
			Map<String, Object> transfReal = transformerService.getTransfRealByEquNum(map);
			// 2.获取当天数据 图表分析
			
			if(transfReal != null && !transfReal.isEmpty()){
				
				map.put("branchNum", transfReal.get("branchNum"));
				
			}
			
			List<Map<String, Object>> transfRealList = transformerService.getTransfRealList(map);
			// 3.设备静态信息 + 保修信息
			Map<String, Object> transfEqu = integratMonitorService.getEquStaticInfByNum(map);
			Map<String, Object> equData = new HashMap<String, Object>();

			equData.put("transfReal", transfReal);
			equData.put("transfRealList", transfRealList);
			equData.put("transfEqu", transfEqu);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(equData);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TransformerController: getTransfRealInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 变压器设备其他详情数据(全部字段)
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getTransfOtherInf")
	@ResponseBody
	public BaseTransferEntity getTransfOtherInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equ_num", equ_num);

		try {
			// 1.获取该transf的最新的一条记录(全部字段)
			Map<String, Object> transfReals = transformerService.getTransfRealsByEquNum(map);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(transfReals);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TransformerController: getTransfOtherInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 3.变压器设备历史数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getTransfHistoryInf")
	@ResponseBody
	public BaseTransferEntity getTransfHistoryInf(HttpServletRequest request, HttpServletResponse response) {
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

			int totalCount = transformerService.getTransfHistoryCount(map);
			page.setTotalCount(totalCount);

			map.put("start", page.getStart());
			map.put("everyPage", page.getEveryPage());
			List<Map<String, Object>> transfHistoryList = transformerService.getTransfHistoryList(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(transfHistoryList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TransformerController: getTransfHistoryInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	/**
	 * 3.变压器设备历史数据页面（图表）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getTransfHistoryGraph")
	@ResponseBody
	public BaseTransferEntity getTransfHistoryGraph(HttpServletRequest request, HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();
		
		String equ_num = request.getParameter("equ_num"); // 设备编号
		
		String day = request.getParameter("day"); // 日历 上某一天
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("equ_num", equ_num);
		
		try {
			map.put("date", day);
			
			List<Map<String, Object>> transfHistoryList = transformerService.getTransfHistoryGraph(map);
			
			baseTransferEntity.setData(transfHistoryList);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("TransformerController: getTransfHistoryGraph--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * TODO 变压器设备健康状况页面 --告警记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getTransfFaultList")
	@ResponseBody
	public BaseTransferEntity getTransfFaultList(HttpServletRequest request, HttpServletResponse response) {
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
			List<Map<String, Object>> transfFaultList = null;
			/** 告警记录 TODO */

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(transfFaultList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TransformerController: getDCDCFaultList--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * TODO 变压器设备健康状况页面 --维修记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getTransfRepairList")
	@ResponseBody
	public BaseTransferEntity getTransfRepairList(HttpServletRequest request, HttpServletResponse response) {
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
			List<Map<String, Object>> transfRepairList = null;
			/** 维修记录 TODO */

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(transfRepairList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TransformerController: getTransfRepairList--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * TODO 变压器设备健康状况页面 --保养记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getTransfMainList")
	@ResponseBody
	public BaseTransferEntity getTransfMainList(HttpServletRequest request, HttpServletResponse response) {
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
			List<Map<String, Object>> transfMainList = null;
			/** 保养记录 TODO */

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(transfMainList);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TransformerController: getTransfMainList--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

}
