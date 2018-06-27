package com.qinergy.controller.integratmonitor.ctl;


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
import com.qinergy.service.integratmonitor.ctl.CtlService;
import com.qinergy.util.MobileConfig;


/**
 * 控制器
 * @author yz
 *
 */

@Controller
@RequestMapping(value = "")
public class CtlController {
	
	// 声明
    private static Logger log = Logger
                .getLogger(CtlController.class);
	
	@Autowired
	private CtlService  ctlService;

	 /**
     * 获取综合监控 控制器 所有数据信息 
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getCtlInfo")
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
        	
            List<Map<String, Object>> lst = ctlService.getCtlInfByEquNum(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("CtlController getCtlInfo--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
	
}
