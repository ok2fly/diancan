package com.qinergy.controller.integratmonitor.box;

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
import com.qinergy.service.integratmonitor.box.BoxService;
import com.qinergy.util.MobileConfig;


/**
 * 汇流箱
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "")
public class BoxController {
	// 声明
    private static Logger log = Logger.getLogger(BoxController.class);
	
	@Autowired
	private BoxService boxService;
    
    /**
     * 汇流箱-详情 （获取最新那条数据，包含支路电流数据）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsBoxInfByEquNumTopOne")
    @ResponseBody
    public BaseTransferEntity getIscsBoxInfByEquNumTopOne(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	//设备编号
            String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = boxService.getIscsBoxInfByEquNumTopOne(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("BoxController getIscsBoxInfByEquNumTopOne--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }

    /**
     * 汇流箱-详情 （获取汇流箱的温度曲线图数据以及离散率曲线图数据（当天的））
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsBoxTempDisRateCurves")
    @ResponseBody
    public BaseTransferEntity getIscsBoxTempDisRateCurves(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = boxService.getIscsBoxTempDisRateCurves(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("BoxController getIscsBoxTempDisRateCurves--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    

    /**
     * 汇流箱-详情 （获取汇流箱的温度曲线图数据以及离散率曲线图数据（历史的））
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsBoxTempDisRateCurvesHistory")
    @ResponseBody
    public BaseTransferEntity getIscsBoxTempDisRateCurvesHistory(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	
        	String equ_num = request.getParameter("equ_num");
        	
        	String date = request.getParameter("date");
        	
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
            
            map.put("date", date);

            List<Map<String, Object>> lst = boxService.getIscsBoxTempDisRateCurvesHistory(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("BoxController getIscsBoxTempDisRateCurvesHistory--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    /**
     * 获取汇流箱设备列表页的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBoxInfLst")
    @ResponseBody
    public BaseTransferEntity getBoxInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = boxService.getBoxInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("BoxController getBoxInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    /**
     * 获取汇流箱设备状态的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getBoxInfStat")
    @ResponseBody
    public BaseTransferEntity getBoxInfStat(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = boxService.getBoxInfStat(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("BoxController getBoxInfStat--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    /**
     * 汇流箱-详情 （获取汇流箱的温度曲线图数据以及离散率曲线图数据（历史的））(列表,分页)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsBoxTempDisRateCurvesHistoryLst")
    @ResponseBody
    public BaseTransferEntity getIscsBoxTempDisRateCurvesHistoryLst(HttpServletRequest request, HttpServletResponse response) {
    	
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
    		
    		Map<String, Object> couMap = boxService.getIscsBoxTempDisRateCurvesHistoryLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = boxService.getIscsBoxTempDisRateCurvesHistoryLst(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("BoxController getIscsBoxTempDisRateCurvesHistoryLst--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
}