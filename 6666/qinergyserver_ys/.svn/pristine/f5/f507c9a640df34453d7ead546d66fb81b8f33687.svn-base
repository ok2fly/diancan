package com.qinergy.controller.integratmonitor.micsys;

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
import com.qinergy.service.integratmonitor.micsys.MicNetworkSysService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;

/**
 * 
 * @desc: 微网系统 控制器
 * @author: Qist
 * @date: 2017年10月27日
 */
@Controller
@RequestMapping(value = "")
public class MicNetworkSysController {

	private static Logger log = Logger.getLogger(MicNetworkSysController.class);

	@Autowired
	MicNetworkSysService micNetworkSysService;
	@Autowired
	private IntegratMonitorService integratMonitorService;

	BaseTransferEntity baseTransferEntity;

	/**
	 * @Title: getMicSysInfPage
	 * @Desc: 微网系统列表页面 展示：名称、状态
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping(value = "/service/getMicSysInfPage")
	@ResponseBody
	public BaseTransferEntity getMicSysInfPage(HttpServletRequest request, HttpServletResponse response) {
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
		Integer norRunStatCount = 0; // 正常运行状态计数器
		Integer norStopStatCount = 0; // 正常停机状态计数器
		Integer alaRunStatCount = 0; // 告警运行状态计数器
		Integer fauStopStatCount = 0; // 故障停机状态计数器

		try {
			resultLst = new ArrayList<Map<String, Object>>();

			// 获取微网系统 设备所有编号
			List<Map<String, Object>> equNumLst = integratMonitorService.getEquNumLstByPwsEquTyp(map);
			if (equNumLst != null && !equNumLst.isEmpty()) {
				for (Map<String, Object> equNumMap : equNumLst) {

					// 从实时数据中获取 某一个设备数据
					Map<String, Object> micSysRealByNum = micNetworkSysService.getMicSysRealByEquNum(equNumMap);
					if (micSysRealByNum != null && !micSysRealByNum.isEmpty()) {
						micSysRealByNum.put("equ_nam", equNumMap.get("equ_nam").toString());

						// 设备状态:0：通讯中断、1：正常运行、2：正常停机、3：告警运行、4：故障停机
						Integer equStat = (Integer)micSysRealByNum.get("stat");
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
						resultLst.add(micSysRealByNum);
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
			log.error("MicNetworkSysController: getMicSysInfPage--->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 2. 微网系统 实时数据页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMicSysRealInf")
	@ResponseBody
	public BaseTransferEntity getMicSysRealInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equ_num", equ_num);

		try {
			// 1.获取最新的一条记录 （包含 告警牌信息）
			Map<String, Object> micSysReal = micNetworkSysService.getMicSysRealByEquNum(map);
			// 2.获取当天数据 图表分析
			List<Map<String, Object>> micSysRealList = micNetworkSysService.getMicSysRealList(map);
			// 3.设备静态信息 + 保修信息
			Map<String, Object> micSysEqu = integratMonitorService.getEquStaticInfByNum(map);
			Map<String, Object> equData = new HashMap<String, Object>();

			equData.put("micSysReal", micSysReal);
			equData.put("micSysRealList", micSysRealList);
			equData.put("micSysEqu", micSysEqu);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(equData);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("MicNetworkSysController getMicSysRealInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 微网系统 其他详情数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMicSysOtherInf")
	@ResponseBody
	public BaseTransferEntity getMicSysOtherInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String equ_num = request.getParameter("equ_num"); // 设备编号
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equ_num", equ_num);

		try {
			Map<String, Object> micSysReals = micNetworkSysService.getMicSysRealsByEquNum(map);

			baseTransferEntity.setData(micSysReals);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("MicNetworkSysController getMicSysOtherInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}

	/**
	 * 3.微网系统 历史数据 功率页面
	 * @param request
	 * @param response
	 * @return      
	 */
	@RequestMapping(value = "/service/getMicSysPowerHistoryInf")
	@ResponseBody
	public BaseTransferEntity getMicSysPowerHistoryInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		Map<String, Object> resultMap;
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
			List<Map<String, Object>> dayTim;
			if (day != null && !day.isEmpty()) {
				dayTim = DateUtil.getDayMonYearTimLst(day, "1");
			} else {
				dayTim = DateUtil.getDayMonYearTimLst(DateUtil.getcurrentTime(), "1");
			}
			map.put("startTim", dayTim.get(0).get("sta_tim"));
			map.put("endTim", dayTim.get(0).get("end_tim"));
			
			page.setTotalCount(micNetworkSysService.getMicSysHistoryCount(map));

			map.put("start", page.getStart());
			map.put("everyPage", page.getEveryPage());
			// 历史数据
			List<Map<String, Object>> micSysHistoryList = micNetworkSysService.getMicSysHistoryList(map);
			
			resultMap = new HashMap<String, Object>();
			resultMap.put("micSysHistoryList", micSysHistoryList);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(resultMap);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("MicNetworkSysController: getMicSysPowerHistoryInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	
	/**
	 * 3.微网系统 历史数据 累计电量图表 按月 和年
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getMicSysElecHistoryInf")
	@ResponseBody
	public BaseTransferEntity getMicSysHistoryInf(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		String equ_num = request.getParameter("equ_num"); // 设备编号
		String day = request.getParameter("day"); // 日历 上某一天: '2017-11-01'
		String tim_typ = request.getParameter("tim_typ"); //查询类型 2:按月 3:按年
		
		try {
			// 微网系统 电量统计
			List<Map<String, Object>> micsysTolPower = micNetworkSysService.getMicsysTolPower(equ_num, day, tim_typ);
			baseTransferEntity.setData(micsysTolPower);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("MicNetworkSysController: getMicSysElecHistoryInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * TODO 微网系统健康页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/equHealthPage")
	@ResponseBody
	public BaseTransferEntity equHealthPage(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		return baseTransferEntity;
	}
	
	
	 /**
     * 获取微网设备列表页的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getMicsysInfLst")
    @ResponseBody
    public BaseTransferEntity getMicsysInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = micNetworkSysService.getMicsysInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PvsController getMicsysInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }

}
