package com.qinergy.controller.integratmonitor.dcbd;


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
import com.qinergy.service.integratmonitor.dcdb.DcdbService;
import com.qinergy.util.MobileConfig;


/**
 * 直流配电柜
 * @author yz
 *
 */

@Controller
@RequestMapping(value = "")
public class DcdbController {
	
	// 声明
    private static Logger log = Logger.getLogger(DcdbController.class);
	
	@Autowired
	private DcdbService dcdbService;
    
    /**
     * 获取 交流配电柜 列表页的信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getDcdbInfByEquNum")
    @ResponseBody
    public BaseTransferEntity getDcdbInfByEquNum(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = dcdbService.getDcdbInfByEquNum(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("DcdbController getDcdbInfByEquNum--------->" + e.getMessage(), e);
            
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
    @RequestMapping("/service/getDcdbById")
    @ResponseBody
    public BaseTransferEntity getAcdbById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
            
            String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
            
			List<Map<String, Object>> lstlist = dcdbService.getDcdbById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("DcdbController getDcdbById--------->" + e.getMessage(), e);
            
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
    @RequestMapping("/service/getDcdbInfoNewById")
    @ResponseBody
    public BaseTransferEntity getAcdbInfoNewById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
            
            String id = request.getParameter("id");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("id", id);
            
			List<Map<String, Object>> lstlist = dcdbService.getDcdbInfoNewById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("DcdbController getDcdbInfoNewById--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    
}
