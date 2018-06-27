package com.qinergy.controller.integratmonitor.pqsms;

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
import com.qinergy.service.integratmonitor.pqsms.PqsmsService;
import com.qinergy.util.MobileConfig;


/**
 * 电能质量监测装置
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
public class PqsmsController {
	// 声明
    private static Logger log = Logger.getLogger(PqsmsController.class);
	
	@Autowired
	private PqsmsService pqsmsService;
    
    /**
     * 电能质量检测装置-详情 （获取最新那条数据）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPqsmsInfByEquNumTopOne")
    @ResponseBody
    public BaseTransferEntity getIscsPqsmsInfByEquNumTopOne(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	//设备编号
            String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = pqsmsService.getIscsPqsmsInfByEquNumTopOne(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("PqsmsController getIscsPqsmsInfByEquNumTopOne--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }

    /**
     * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（当天的））
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPqsmsUIPQsumCurves")
    @ResponseBody
    public BaseTransferEntity getIscsPqsmsUIPQsumCurves(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = pqsmsService.getIscsPqsmsUIPQsumCurves(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("PqsmsController getIscsPqsmsUIPQsumCurves--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    

    /**
     * 电能质量检测装置-详情 （获取电能质量检测装置的电压、电流2-50次谐波柱状图（当天的最新的那条数据））
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPqsmsThdUIABCHistogram")
    @ResponseBody
    public BaseTransferEntity getIscsPqsmsThdUIABCHistogram(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	
        	String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
        	

            List<Map<String, Object>> lst = pqsmsService.getIscsPqsmsThdUIABCHistogram(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("PqsmsController getIscsPqsmsThdUIABCHistogram--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    /**
     * 电能质量检测装置-详情 （获取电能质量检测装置的电压、电流2-50次谐波柱状图（当天的最新的那条数据））(App)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPqsmsThdUIABCHistogramLst")
    @ResponseBody
    public BaseTransferEntity getIscsPqsmsThdUIABCHistogramLst(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String equ_num = request.getParameter("equ_num");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("equ_num", equ_num);
    		
    		
    		List<Map<String, Object>> lst = pqsmsService.getIscsPqsmsThdUIABCHistogramLst(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("PqsmsController getIscsPqsmsThdUIABCHistogramLst--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    /**
     * 电能质量检测装置-详情 （获取电能质量检测装置的电压、电流2-50次谐波柱状图（当天的最新的那条数据））(iOS)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPqsmsThdUIABCHistogramLstIos")
    @ResponseBody
    public BaseTransferEntity getIscsPqsmsThdUIABCHistogramLstIos(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String equ_num = request.getParameter("equ_num");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("equ_num", equ_num);
    		
    		
    		List<Map<String, Object>> lst = pqsmsService.getIscsPqsmsThdUIABCHistogramLstIos(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("PqsmsController getIscsPqsmsThdUIABCHistogramLstIos--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    /**
     * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPqsmsUIPQsumCurvesHistory")
    @ResponseBody
    public BaseTransferEntity getIscsPqsmsUIPQsumCurvesHistory(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String equ_num = request.getParameter("equ_num");
    		
    		String date = request.getParameter("date");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("equ_num", equ_num);
    		
    		map.put("date", date);
    		
    		List<Map<String, Object>> lst = pqsmsService.getIscsPqsmsUIPQsumCurvesHistory(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("PqsmsController getIscsPqsmsUIPQsumCurvesHistory--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    
    /**
     * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））(App)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPqsmsThdUIABCHistogramHistoryLst")
    @ResponseBody
    public BaseTransferEntity getIscsPqsmsThdUIABCHistogramHistoryLst(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String equ_num = request.getParameter("equ_num");
    		
    		String date = request.getParameter("date");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("equ_num", equ_num);
    		
    		map.put("date", date);
    		
    		List<Map<String, Object>> lst = pqsmsService.getIscsPqsmsThdUIABCHistogramHistoryLst(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("PqsmsController getIscsPqsmsThdUIABCHistogramHistoryLst--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    
    
    /**
     * 获取PQSMS设备列表页的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPqsmsInfLst")
    @ResponseBody
    public BaseTransferEntity getPqsmsInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = pqsmsService.getPqsmsInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PqsmsController getPqsmsInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    /**
     * 获取PQSMS设备状态的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPqsmsInfStat")
    @ResponseBody
    public BaseTransferEntity getPqsmsInfStat(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = pqsmsService.getPqsmsInfStat(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PqsmsController getPqsmsInfStat--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    /**
     * 电能质量检测装置-详情 （获取电能质量检测装置的电流电压曲线图数据以及有功无功曲线图数据（历史的））(列表,带分页)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsPqsmsUIPQsumCurvesHistoryLst")
    @ResponseBody
    public BaseTransferEntity getIscsPqsmsUIPQsumCurvesHistoryLst(HttpServletRequest request, HttpServletResponse response) {
    	
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
    		
    		Map<String, Object> couMap = pqsmsService.getIscsPqsmsUIPQsumCurvesHistoryLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = pqsmsService.getIscsPqsmsUIPQsumCurvesHistoryLst(map);

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
    		log.error("PqsmsController getIscsPqsmsUIPQsumCurvesHistoryLst--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
}