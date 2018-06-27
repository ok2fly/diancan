package com.qinergy.controller.integratmonitor.pvs;

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
import com.qinergy.service.integratmonitor.pvs.PvsService;
import com.qinergy.util.MobileConfig;


/**
 * 光伏逆变器
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
public class PvsController {
	// 声明
    private static Logger log = Logger.getLogger(PvsController.class);
	
	@Autowired
	private PvsService pvsService;
    
    /**
     * 光伏逆变器-详情 （获取最新那条数据）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPvsInfByEquNumTopOne")
    @ResponseBody
    public BaseTransferEntity getIscsPvsInfByEquNumTopOne(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	//编号
            String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = pvsService.getIscsPvsInfByEquNumTopOne(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("PvsController getIscsPvsInfByEquNumTopOne--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }

    /**
     * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPvsAcDcPIVDisRateCurves")
    @ResponseBody
    public BaseTransferEntity getIscsPvsAcDcPIVDisRateCurves(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = pvsService.getIscsPvsAcDcPIVDisRateCurves(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("PvsController getIscsPvsAcDcPIVDisRateCurves--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    

    /**
     * 光伏逆变器-详情 （获取光伏设备的发电量柱状图）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPvsDayPowerHistogram")
    @ResponseBody
    public BaseTransferEntity getIscsPvsDayPowerHistogram(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	
        	String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
        	

            List<Map<String, Object>> lst = pvsService.getIscsPvsDayPowerHistogram(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("PvsController getIscsPvsDayPowerHistogram--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    /**
     * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（历史的））
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPvsAcDcPIVDisRateCurvesHistory")
    @ResponseBody
    public BaseTransferEntity getIscsPvsAcDcPIVDisRateCurvesHistory(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String equ_num = request.getParameter("equ_num");
    		
    		String date = request.getParameter("date");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("equ_num", equ_num);
    		
    		map.put("date", date);
    		
    		List<Map<String, Object>> lst = pvsService.getIscsPvsAcDcPIVDisRateCurvesHistory(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("PvsController getIscsPvsAcDcPIVDisRateCurvesHistory--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    /**
     * 光伏逆变器-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（历史的））(分页)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPvsAcDcPIVDisRateCurvesHistoryLst")
    @ResponseBody
    public BaseTransferEntity getIscsPvsAcDcPIVDisRateCurvesHistoryLst(HttpServletRequest request, HttpServletResponse response) {
    	
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
    		
    		Map<String, Object> couMap = pvsService.getIscsPvsAcDcPIVDisRateCurvesHistoryLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = pvsService.getIscsPvsAcDcPIVDisRateCurvesHistoryLst(map);

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
    		log.error("PvsController getIscsPvsAcDcPIVDisRateCurvesHistoryLst--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    /**
     * 光伏逆变器-详情 （获取光伏设备的发电量柱状图）（历史的）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPvsDayPowerHistogramHistory")
    @ResponseBody
    public BaseTransferEntity getIscsPvsDayPowerHistogramHistory(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String equ_num = request.getParameter("equ_num");
    		
    		String date = request.getParameter("date");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("equ_num", equ_num);
    		
    		map.put("date", date);
    		
    		List<Map<String, Object>> lst = pvsService.getIscsPvsDayPowerHistogramHistory(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("PvsController getIscsPvsDayPowerHistogramHistory--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    
    
    
    
    
    /**
     * 获取PVS设备列表页的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPvsInfLst")
    @ResponseBody
    public BaseTransferEntity getPvsInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = pvsService.getPvsInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PvsController getPvsInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    /**
     * 获取PVS设备状态的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPvsInfStat")
    @ResponseBody
    public BaseTransferEntity getPvsInfStat(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = pvsService.getPvsInfStat(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PvsController getPvsInfStat--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
}