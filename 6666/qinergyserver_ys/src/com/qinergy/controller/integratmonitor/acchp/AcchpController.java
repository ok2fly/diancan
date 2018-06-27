package com.qinergy.controller.integratmonitor.acchp;

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
import com.qinergy.service.integratmonitor.acchp.AcchpService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;


/**
 * 交流充电桩
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
public class AcchpController {
	// 声明
    private static Logger log = Logger.getLogger(AcchpController.class);
	
	@Autowired
	private AcchpService acchpService;
    
    /**
     * 交流充电桩-详情,待机数据 （获取最新那条数据）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsAcchpStdInfByEquNumTopOne")
    @ResponseBody
    public BaseTransferEntity getIscsAcchpStdInfByEquNumTopOne(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {

            String equ_num = request.getParameter("equ_num");//设备编号

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = acchpService.getIscsAcchpStdInfByEquNumTopOne(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("AcchpController getIscsAcchpStdInfByEquNumTopOne--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }

    /**
     * 交流充电桩-详情,实时数据 （获取最新那条数据）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsAcchpRelInfByEquNumTopOne")
    @ResponseBody
    public BaseTransferEntity getIscsAcchpRelInfByEquNumTopOne(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = acchpService.getIscsAcchpRelInfByEquNumTopOne(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("AcchpController getIscsAcchpRelInfByEquNumTopOne--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    

    /**
     * 交流充电桩-详情 （获取交流充电桩设备的电流、电压曲线（当天的））
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsAcchpRelUICurves")
    @ResponseBody
    public BaseTransferEntity getIscsAcchpRelUICurves(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	
        	String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
        	
            List<Map<String, Object>> lst = acchpService.getIscsAcchpRelUICurves(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("AcchpController getIscsAcchpRelUICurves--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    /**
     * 交流充电桩-详情 （获取光伏设备的直/交流的电流、电压、功率曲线（当天的））(使用订单信息获取)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsAcchpRelUICurvesHistory")
    @ResponseBody
    public BaseTransferEntity getIscsAcchpRelUICurvesHistory(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String orderNo = request.getParameter("orderNo");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("orderNo", orderNo);
    		
    		List<Map<String, Object>> lst = acchpService.getIscsAcchpRelUICurvesHistory(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("AcchpController getIscsAcchpRelUICurvesHistory--------->" + e.getMessage(), e);
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
    @RequestMapping("/service/getAcchpInfLst")
    @ResponseBody
    public BaseTransferEntity getAcchpInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = acchpService.getAcchpInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("AcchpController getAcchpInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    /**
     * 获取交流充电桩设备状态的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getAcchpInfStat")
    @ResponseBody
    public BaseTransferEntity getAcchpInfStat(HttpServletRequest request, HttpServletResponse response) {

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
//            map.put("app_typ_id", app_typ_id);
            
            map.put("pws_id", pws_id);
            
            map.put("stat", stat);
            
			List<Map<String, Object>> lstlist = acchpService.getAcchpInfStat(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("AcchpController getAcchpInfStat--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    /**
     * 交流充电桩-详情 （获取订单信息）（分页）
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getIscsAcchpOrdInfLst")
    @ResponseBody
    public BaseTransferEntity getIscsAcchpOrdInfLst(HttpServletRequest request, HttpServletResponse response) {
    	
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
    		
    		Map<String, Object> couMap = acchpService.getIscsAcchpOrdInfLstCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> lst = acchpService.getIscsAcchpOrdInfLst(map);

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
    		log.error("AcchpController getIscsAcchpOrdInfLst--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
}