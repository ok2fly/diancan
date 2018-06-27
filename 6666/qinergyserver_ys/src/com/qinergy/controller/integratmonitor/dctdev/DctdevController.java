package com.qinergy.controller.integratmonitor.dctdev;


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
import com.qinergy.service.integratmonitor.dctdev.DctdevService;
import com.qinergy.util.MobileConfig;


/**
 * 解列装置
 * @author yz
 *
 */

@Controller
@RequestMapping(value = "")
public class DctdevController {
	
	// 声明
    private static Logger log = Logger.getLogger(DctdevController.class);
	
	@Autowired
	private DctdevService dctdevService;
	
    /**
     * 获取解列装置 设备列表页的信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDctdevInfLst")
    @ResponseBody
    public BaseTransferEntity getDctdevInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = dctdevService.getDctdevInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("DctdevController getDctdevInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    /**
     * 获取解列装置 设备、保修概况信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDctdevInfoNewById")
    @ResponseBody
    public BaseTransferEntity getDctdevInfoNewById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 设备编号
            String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
            
			List<Map<String, Object>> lstlist = dctdevService.getDctdevInfoNewById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("DctdevController getDctdevInfoNewById--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    /**
     * 获取解列装置设备 当天图标信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDctdevNow")
    @ResponseBody
    public BaseTransferEntity getDctdevNow(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 设备编号
            String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
            
			List<Map<String, Object>> lstlist = dctdevService.getDctdevNow(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("DctdevController getDctdevInfoNewById--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    /**
     * 获取解列装置 历史信息 按年、月、日 查询(图表)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDctdevInfoByDayGraph")
    @ResponseBody
    public BaseTransferEntity getDctdevInfoByDayGraph(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 时间
            String year = request.getParameter("year");
            //设备编号
            String equ_num = request.getParameter("equ_num");
            
        	Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("year", year);
            
            map.put("equ_num", equ_num);
            
			List<Map<String, Object>> lstlist = dctdevService.getDctdevInfoByDayGraph(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
            	
        } catch (Exception e) {
        	
            log.error("DctdevController getDctdevInfoByDayGraph--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }

    /**
     * 解列装置 按 日 查询列表信息(列表,分页)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDctdevInfoByDayList")
    @ResponseBody
    public BaseTransferEntity getDctdevInfoByDayList(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		PagerTwo page = new PagerTwo();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
    		String equ_num = request.getParameter("equ_num");
    		// 时间
            String year = request.getParameter("year");
    		
    		Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());
			
    		map.put("equ_num", equ_num);
    		
    		 map.put("year", year);
    		
    		Map<String, Object> couMap = dctdevService.getDctdevInfoByDayListCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = dctdevService.getDctdevInfoByDayList(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		
    		log.error("DctdevController getDctdevInfoByDayList--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    		
    	}
    	
    	return baseTransferEntity;
    }
    
    /**
     * 获取解列装置设备 当天详情信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDctdevId")
    @ResponseBody
    public BaseTransferEntity getDctdevId(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 设备编号
            String equ_num = request.getParameter("equ_num");
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
            
			List<Map<String, Object>> lstlist = dctdevService.getDctdevId(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("DctdevController getDctdevId--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    
    
}
