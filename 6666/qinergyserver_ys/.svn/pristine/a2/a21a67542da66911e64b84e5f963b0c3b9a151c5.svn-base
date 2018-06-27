package com.qinergy.controller.integratmonitor.lneptt;


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
import com.qinergy.service.integratmonitor.lneptt.LnepttService;
import com.qinergy.util.MobileConfig;


/**
 * 线路保护
 * @author yz
 *
 */

@Controller
@RequestMapping(value = "")
public class LnepttController {
	
	
	// 声明
    private static Logger log = Logger
                .getLogger(LnepttController.class);
	
	@Autowired
	private LnepttService  lnepttService;

	 /**
     * 获取综合监控 线路保护 所有数据信息 
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getLnepttInfo")
    @ResponseBody
    public BaseTransferEntity getCtlInfo(HttpServletRequest request, HttpServletResponse response) {

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
        	
            List<Map<String, Object>> lst = lnepttService.getLnepttInfByEquNum(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("LnepttController getLnepttInfo--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
	
   
    
    /**
     * 获取综合监控 线路保护  查看详情
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getLnepttById")
    @ResponseBody
    public BaseTransferEntity getLnepttById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
           
        	// 设备编号
            String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
        	
            List<Map<String, Object>> lst = lnepttService.getLnepttById(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("LnepttController getLnepttById--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
	
    /**
     * 获取综合监控 线路保护  id查看设备，保修概况
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getLnepttInfoById")
    @ResponseBody
    public BaseTransferEntity getLnepttInfoById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
           
        	// 设备ID
            String id = request.getParameter("id");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("id", id);
        	
            List<Map<String, Object>> lst = lnepttService.getLnepttInfoById(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("LnepttController getLnepttInfoById--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
	
    /**
     * 获取综合监控 线路保护  显示当天图表信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getLnepttNow")
    @ResponseBody
    public BaseTransferEntity getLnepttNow(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
           
        	// 设备编号
            String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
        	
            List<Map<String, Object>> lst = lnepttService.getLnepttNow(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("LnepttController getLnepttNow--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    
    
    /**
     * 获取综合监控 线路保护 按年、月、日 查询图表信息（列表分页）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getLnepttInfoByYearList")
    @ResponseBody
    public BaseTransferEntity getLnepttInfoByYearList(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			PagerTwo page = new PagerTwo();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 年
			String year = request.getParameter("year");
			// 设备编号
			String equ_num = request.getParameter("equ_num");
			

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());
			
			map.put("year", year);
			
			map.put("equ_num", equ_num);
			
			Map<String, Object> couMap = lnepttService.getLnepttInfoByDayListCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = lnepttService.getLnepttInfoByDayList(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {
			
			log.error("LnepttController getLnepttInfoByYearList--------->"+ e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
    
    /**
     * 获取综合监控 线路保护 按年、月、日 查询图表信息（图表）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getLnepttInfoByDayGraph")
    @ResponseBody
    public BaseTransferEntity getLnepttInfoByDayGraph(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		// 年
    		String year = request.getParameter("year");
    		
    		// 设备编号
    		String equ_num = request.getParameter("equ_num");
    		
    			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("year", year);
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lst = lnepttService.getLnepttInfoByDayGraph(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("LnepttController getLnepttInfoByDayGraph--------->"+ e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	
    	return baseTransferEntity;
    }
    
}
