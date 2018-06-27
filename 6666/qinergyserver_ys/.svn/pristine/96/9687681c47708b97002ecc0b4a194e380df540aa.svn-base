package com.qinergy.controller.integratmonitor.dcchp;

import java.text.SimpleDateFormat;
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
import com.qinergy.service.integratmonitor.dcchp.DcchpService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;


/**
 * 直流充电桩
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
public class DcchpController {
	// 声明
    private static Logger log = Logger.getLogger(DcchpController.class);
	
	@Autowired
	private DcchpService dcchpService;
    
    /**
     * 直流充电桩-详情,待机数据 （获取最新那条数据）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsDcchpStdInfByEquNumTopOne")
    @ResponseBody
    public BaseTransferEntity getIscsDcchpStdInfByEquNumTopOne(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	//编号
            String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = dcchpService.getIscsDcchpStdInfByEquNumTopOne(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("DcchpController getIscsDcchpStdInfByEquNumTopOne--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }

    /**
     * 直流充电桩-详情,实时数据 （获取最新那条数据）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsDcchpRelInfByEquNumTopOne")
    @ResponseBody
    public BaseTransferEntity getIscsDcchpRelInfByEquNumTopOne(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = dcchpService.getIscsDcchpRelInfByEquNumTopOne(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("DcchpController getIscsDcchpRelInfByEquNumTopOne--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    

    /**
     * 直流充电桩-详情 （获取直流充电桩设备的电流、电压曲线（当天的））
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsDcchpRelUICurves")
    @ResponseBody
    public BaseTransferEntity getIscsDcchpRelUICurves(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	
        	String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
        	
            List<Map<String, Object>> lst = dcchpService.getIscsDcchpRelUICurves(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("DcchpController getIscsDcchpRelUICurves--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    /**
     * 获取直流充电桩设备列表页的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDcchpInfLst")
    @ResponseBody
    public BaseTransferEntity getDcchpInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = dcchpService.getDcchpInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("DcchpController getDcchpInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    /**
     * 获取直流充电桩设备状态的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDcchpInfStat")
    @ResponseBody
    public BaseTransferEntity getDcchpInfStat(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = dcchpService.getDcchpInfStat(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("DcchpController getDcchpInfStat--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    /**
     * 直流充电桩-详情 （获取订单信息）（分页）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsDcchpOrdInfLst")
    @ResponseBody
    public BaseTransferEntity getIscsDcchpOrdInfLst(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

    	SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
    	
    	try {
    		PagerTwo page = new PagerTwo();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
    		String equ_num = request.getParameter("equ_num");
    		
    		String sta_tim = request.getParameter("sta_tim");
    		
    		String end_tim = request.getParameter("end_tim");
    		
    		Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());
			
    		map.put("equ_num", equ_num);
    		
    		map.put("sta_tim", sta_tim);

    		if(end_tim != null){
    			
    			map.put("end_tim", DateUtil.addDay(sdf.parse(end_tim),1));
    			
    		}
    		
    		Map<String, Object> couMap = dcchpService.getIscsDcchpOrdInfLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = dcchpService.getIscsDcchpOrdInfLst(map);

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
    		log.error("DcchpController getIscsDcchpOrdInfLst--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    /**
     * 直流充电桩-详情 （获取直流充电桩设备的电流、电压（历史的））(使用订单编号)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsDcchpRelUICurvesHistory")
    @ResponseBody
    public BaseTransferEntity getIscsDcchpRelUICurvesHistory(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String orderNo = request.getParameter("orderNo");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("orderNo", orderNo);
    		
    		List<Map<String, Object>> lst = dcchpService.getIscsDcchpRelUICurvesHistory(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("DcchpController getIscsDcchpRelUICurvesHistory--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    /**
     * 直流充电桩-详情 （获取直流充电桩充电的汽车信息）(使用订单编号)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsCarStaInfLst")
    @ResponseBody
    public BaseTransferEntity getIscsCarStaInfLst(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String orderNo = request.getParameter("orderNo");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("orderNo", orderNo);
    		
    		List<Map<String, Object>> lst = dcchpService.getIscsCarStaInfLst(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("DcchpController getIscsDcchpRelUICurvesHistory--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
}