package com.qinergy.controller.integratmonitor.acdb;


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
import com.qinergy.service.integratmonitor.acdb.AcdbService;
import com.qinergy.util.MobileConfig;


/**
 * 交流配电柜
 * @author yz
 *
 */

@Controller
@RequestMapping(value = "")
public class AcdbController {
	
	// 声明
    private static Logger log = Logger
                .getLogger(AcdbController.class);
	
	@Autowired
	private AcdbService acdbService;
    
    /**
     * 获取 交流配电柜 列表页的信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getAcdbInfByEquNum")
    @ResponseBody
    public BaseTransferEntity getAcdbInfByEquNum(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	// 设备类型ID
            String app_typ_id = request.getParameter("app_typ_id");
            // 场站ID(电站ID)
            String pws_id = request.getParameter("pws_id");
            //状态
            String stat = request.getParameter("stat");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("app_typ_id",app_typ_id);
            
            map.put("pws_id", pws_id);
            
            map.put("stat", stat);
            
			List<Map<String, Object>> lstlist = acdbService.getAcdbInfByEquNum(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("AcdbController getAcdbInfByEquNum--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    /**
     * 获取 交流配电柜  详情 设备编号查看 最新
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getAcdbById")
    @ResponseBody
    public BaseTransferEntity getAcdbById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
            
            String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
            
			List<Map<String, Object>> lstlist = acdbService.getAcdbById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("AcdbController getAcdbInfoNewById--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    
    
    /**
     * 获取 交流配电柜  设备详情 设备概况
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getAcdbInfoNewById")
    @ResponseBody
    public BaseTransferEntity getAcdbInfoNewById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
            
            String id = request.getParameter("id");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("id", id);
            
			List<Map<String, Object>> lstlist = acdbService.getAcdbInfoNewById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("AcdbController getAcdbInfoNewById--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    
}
