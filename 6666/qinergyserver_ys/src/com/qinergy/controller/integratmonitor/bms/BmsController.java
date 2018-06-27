package com.qinergy.controller.integratmonitor.bms;


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
import com.qinergy.service.integratmonitor.bms.BmsService;
import com.qinergy.util.MobileConfig;

/**
 * 储能电池
 * @author yz
 *
 */
@Controller
@RequestMapping(value = "")
public class BmsController {
	
	
	// 声明
    private static Logger log = Logger.getLogger(BmsController.class);
    
	@Autowired
	private BmsService bmsService;
	
	 /**
     * 获取综合监控 储能电池 所有数据信息 
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBmsInfo")
    @ResponseBody
    public BaseTransferEntity getBmsInfo(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
           
            List<Map<String, Object>> lst = bmsService.getBmsInfo();

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("BmsController getBmsInfo--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
	
    /**
     * 获取综合监控 储能电池  编号查看详情 
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBmsInfoNew")
    @ResponseBody
    public BaseTransferEntity getBmsInfoNew(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
           
        	String equ_num = request.getParameter("equ_num");
        	Map<String,Object> map = new HashMap<String,Object>();
        	map.put("equ_num", equ_num);
        	
            List<Map<String, Object>> lst = bmsService.getBmsInfoNew(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("BmsController getBmsInfoNew--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    
    /**
     * 获取综合监控 储能电池 当天数据  图表显示  
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBmsInfoList")
    @ResponseBody
    public BaseTransferEntity getBmsInfoList(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
           
        	String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);
        	
            List<Map<String, Object>> lst = bmsService.getBmsInfoList(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("BmsController getBmsInfoList--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    /**
     * 获取综合监控  查询储能电池 设备和保修概况  
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBmsInfoListById")
    @ResponseBody
    public BaseTransferEntity getBmsInfoListById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
           
        	String id = request.getParameter("id");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("id", id);

            List<Map<String, Object>> lst = bmsService.getBmsInfoListById(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("BmsController getBmsInfoListById--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    /**
     * 获取综合监控  查询储能电池 历史分析 年、月、日 图表信息数据显示 (图表)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBmsInfoByDayGraph")
    @ResponseBody
    public BaseTransferEntity getBmsInfoByDayGraph(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	
        	// 由前台传入的要查询数据的日期
			String year = request.getParameter("year");
			// 要查询信息的设备编号
			String equ_num = request.getParameter("equ_num");
			
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("year", year);
			
			map.put("equ_num", equ_num);
			// 返回的为一个数组
			List<Map<String, Object>> lst = bmsService.getBmsInfoByDayGraph(map);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
        	
            log.error("BmsController getBmsInfoByDayGraph--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
            
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    
    /**
     * 获取综合监控  查询储能电池 历史分析 年、月、日 图表信息数据显示 （图表下方的列表）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBmsInfoByYearList")
    @ResponseBody
    public BaseTransferEntity getBmsInfoByYearList(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 分页对象
        	PagerTwo page = new PagerTwo();
        	// 当前多少页
        	String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
        	// 由前台传入的要查询数据的日期
			String year = request.getParameter("year");
			// 要查询信息的设备编号
			String equ_num = request.getParameter("equ_num");
			// 构建掺入参数集合
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());
			
			map.put("year", year);
			
			map.put("equ_num", equ_num);
			
			Map<String, Object> couMap = bmsService.getBmsInfoByDayListCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			// 返回的为一个数组
			List<Map<String, Object>> retLst = bmsService.getBmsInfoByDayList(map);
			// 分页:当前多少页
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			// 分页:每页多少条数据
			baseTransferEntity.setEveryPage(page.getEveryPage());
			// 分页:一共多少条
			baseTransferEntity.setTotalCount(page.getTotalCount());
			// 分页:一共多少页
			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(retLst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
        } catch (Exception e) {
        	
            log.error("BmsController getBmsInfoByYearList--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
            
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    /**
     * 获取综合监控  查询储能电池 设备状态数量  
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBmsStatLev")
    @ResponseBody
    public BaseTransferEntity getBmsStatLev(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
           
            Map<String, Object> lst = bmsService.getBmsStatLev();

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("BmsController getBmsStatLev--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    /**
     * 获取电池设备列表页的信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBmsInfLst")
    @ResponseBody
    public BaseTransferEntity getBmsInfLst(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 设备类型ID
            String app_typ_id = request.getParameter("app_typ_id");
            // 场站ID(电站ID)
            String pws_id = request.getParameter("pws_id");
            
            String stat = request.getParameter("stat");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("app_typ_id", app_typ_id);
            
            map.put("pws_id", pws_id);
            
            map.put("stat", stat);
            
			List<Map<String, Object>> lstlist = bmsService.getBmsInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("BmsController getBmsInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }

    /**
     * 获取bms设备状态的信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBmsInfStat")
    @ResponseBody
    public BaseTransferEntity getBmsInfStat(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 设备类型ID
            String app_typ_id = request.getParameter("app_typ_id");
            // 场站ID(电站ID)
            String pws_id = request.getParameter("pws_id");
            
            String stat = request.getParameter("stat");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("app_typ_id", app_typ_id);
            
            map.put("pws_id", pws_id);
            
            map.put("stat", stat);
            
			List<Map<String, Object>> lstlist = bmsService.getBmsInfStat(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("BmsController getBmsInfStat--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
}
