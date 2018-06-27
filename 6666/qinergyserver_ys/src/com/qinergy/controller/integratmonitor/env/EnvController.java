package com.qinergy.controller.integratmonitor.env;


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
import com.qinergy.service.integratmonitor.env.EnvService;
import com.qinergy.util.MobileConfig;


/**
 * 环境监测仪
 * @author yz
 *
 */

@Controller
@RequestMapping(value = "")
public class EnvController {
	
	
	// 声明
    private static Logger log = Logger
                .getLogger(EnvController.class);
	
	@Autowired
	private EnvService envService;
	
	 /**
     * 获取综合监控  环境检测仪 所有数据信息 
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getEnvInfo")
    @ResponseBody
    public BaseTransferEntity getPcsNum0(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {

            List<Map<String, Object>> lst = envService.getEnvInfo();

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("EnvController getPcsNum0--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
	
    
    
    /**
     * 获取综合监控  环境检测仪 最新一条数据信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getEnvInfoNew")
    @ResponseBody
    public BaseTransferEntity getEnvInfoNew(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 站ID
        	String pws_id = request.getParameter("pws_id");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("pws_id", pws_id);
        	
            List<Map<String, Object>> lst = envService.getEnvInfoNew(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("EnvController getEnvInfoNew--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    
    /**
     * 获取综合监控  环境检测仪 最新一条数据信息 正常使用的
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getEnvInfoNew24Hours")
    @ResponseBody
    public BaseTransferEntity getEnvInfoNew24Hours(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		// 设备编号
    		String equ_num = request.getParameter("equ_num");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("equ_num", equ_num);
    		
    		List<Map<String, Object>> lst = envService.getEnvInfoNew24Hours(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("EnvController getEnvInfoNew--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    
    /**
     * 获取综合监控  环境检测仪 最新一条数据信息 设备信息 保修概况
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getEnvInfoNewById")
    @ResponseBody
    public BaseTransferEntity getEnvInfoNewById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	String id = request.getParameter("id");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("id", id);


            List<Map<String, Object>> lst = envService.getEnvInfoNewById(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("EnvController getEnvInfoNewById--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    
    
    
    /**
     * 获取综合监控  环境检测仪 日查询 列表
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getEnvInfoByYearList")
    @ResponseBody
    public BaseTransferEntity getEnvInfoByYearList(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	PagerTwo page = new PagerTwo();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}

			String year = request.getParameter("year");
        	
        	String equ_num = request.getParameter("equ_num");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("year", year);
            
            map.put("equ_num", equ_num);
            
			Map<String, Object> couMap = envService.getEnvInfoByDayListCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = envService.getEnvInfoByDayList(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

            baseTransferEntity.setData(lst);
        	
        	baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
        	
        	baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        } catch (Exception e) {
        	
            log.error("EnvController getEnvInfoByYearList--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
            
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    /**
     * 获取综合监控  环境检测仪日查询 图表信息 
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getEnvInfoByYearGraph")
    @ResponseBody
    public BaseTransferEntity getEnvInfoByYearGraph(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	
        	String year = request.getParameter("year");
        	
        	String equ_num = request.getParameter("equ_num");
        	
    		Map<String, Object> map = new HashMap<String, Object>();

            map.put("year", year);
            
            map.put("equ_num", equ_num);
            
            List<Map<String, Object>> lst = envService.getEnvInfoByYearGraph(map);

            baseTransferEntity.setData(lst);
        	
        	baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
        	
        	baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        } catch (Exception e) {
        	
            log.error("EnvController getEnvInfoByYearGraph--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
            
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }   
    
    /**
     * 获取综合监控  环境检测仪日查询 图表信息 
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getEnvInfoByYear24HoursGraph")
    @ResponseBody
    public BaseTransferEntity getEnvInfoByYear24HoursGraph(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String year = request.getParameter("year");
    		
    		String equ_num = request.getParameter("equ_num");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("year", year);
    		
    		map.put("equ_num", equ_num);
    		
    		List<Map<String, Object>> lst = envService.getEnvInfoByYear24HoursGraph(map);
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("EnvController getEnvInfoByYear24HoursGraph--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	
    	return baseTransferEntity;
    }   
    
    
    
    /**
     * 获取环境检测仪 最新 设备页的信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getEnvInfLst")
    @ResponseBody
    public BaseTransferEntity getEnvInfLst(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 设备类型ID
            String app_typ_id = request.getParameter("app_typ_id");
            // 场站ID(电站ID)
            String pws_id = request.getParameter("pws_id");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("app_typ_id", app_typ_id);
            
            map.put("pws_id", pws_id);
            
			List<Map<String, Object>> lstlist = envService.getEnvInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("EnvController getEnvInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    /**
     * 获取环境检测仪 最新 设备页的信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getEnvLstByPwsEquTyp")
    @ResponseBody
    public BaseTransferEntity getEnvLstByPwsEquTyp(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		// 设备类型ID
    		String app_typ_id = request.getParameter("app_typ_id");
    		// 场站ID(电站ID)
    		String pws_id = request.getParameter("pws_id");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("app_typ_id", app_typ_id);
    		
    		map.put("pws_id", pws_id);
    		
    		List<Map<String, Object>> lst = envService.getEnvLstByPwsEquTyp(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	}
    	catch (Exception e) {
    		
    		log.error("EnvController getEnvLstByPwsEquTyp--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	
    	return baseTransferEntity;
    }
}
