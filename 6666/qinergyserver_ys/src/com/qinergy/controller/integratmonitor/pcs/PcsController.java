package com.qinergy.controller.integratmonitor.pcs;

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
import com.qinergy.service.integratmonitor.pcs.PcsService;
import com.qinergy.util.MobileConfig;


/**
 * 储能逆变器
 * @author yz
 *
 */

@Controller
@RequestMapping(value = "")
public class PcsController {
	
	// 声明
    private static Logger log = Logger.getLogger(PcsController.class);
	
	@Autowired
	private PcsService pcsService;
    
    /**
     * 综合监控  储能逆变器 根据id查看详情 (正确方法)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsInfoById")
    @ResponseBody
    public BaseTransferEntity getPcsInfoById(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	//设备编号
            String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = pcsService.getPcsInfByEquNum(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("PcsController getPcsInfoById--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }

    /**
     * 综合监控  储能逆变器 实时信息 获取当天数据 图表显示 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsNow")
    @ResponseBody
    public BaseTransferEntity getPcsNow(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	String equ_num = request.getParameter("equ_num");

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("equ_num", equ_num);

            List<Map<String, Object>> lst = pcsService.getPcsNow(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("PcsController getPcsNow--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    
    
    /**
     * 综合监控  储能逆变器 实时信息 获取当天数据 图表显示 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsNowMonth")
    @ResponseBody
    public BaseTransferEntity getPcsNowMonth(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		String equ_num = request.getParameter("equ_num");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("equ_num", equ_num);
    		
    		List<Map<String, Object>> lst = pcsService.getPcsNowMonth(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    	}
    	catch (Exception e) {
    		log.error("PcsController getPcsNowMonth--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig
    				.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    
    /**
     * 综合监控  储能逆变器 实时信息 获取某月数据 图表显示 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsHistoryMonth")
    @ResponseBody
    public BaseTransferEntity getPcsHistoryMonth(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		String equ_num = request.getParameter("equ_num");
    		
    		String date = request.getParameter("date");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("equ_num", equ_num);
    		
    		map.put("date", date);
    		
    		List<Map<String, Object>> lst = pcsService.getPcsHistoryMonth(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lst);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("PcsController getPcsHistoryMonth--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    }
    
    
    
    

    /**
     * 综合监控  储能逆变器 历史信息 获取当天数据 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsHistory")
    @ResponseBody
    public BaseTransferEntity getPcsHistory(HttpServletRequest request, HttpServletResponse response) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

        try {
        	
        	String equ_num = request.getParameter("equ_num");
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            map.put("equ_num", equ_num);
        	

            List<Map<String, Object>> lst = pcsService.getPcsHistory(map);

            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.success"));
            baseTransferEntity.setData(lst);
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
        }
        catch (Exception e) {
            log.error("PcsController getPcsHistory--------->" + e.getMessage(), e);
            baseTransferEntity.setResultcode(MobileConfig
                        .getStringCode("code.global.error.exception"));
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            baseTransferEntity.setData(null);
        }
        return baseTransferEntity;
    }
    
    
    
    /**
     * 综合监控  储能逆变器 历史信息 按年、月、日 查询 (正常使用)(列表)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsInfoByYearList")
    @ResponseBody
    public BaseTransferEntity getPcsInfoByYearList(HttpServletRequest request, HttpServletResponse response) {

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
            
        	Map<String, Object> couMap = pcsService.getPcsInfoByDayListCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());
			
            List<Map<String, Object>> lstlist = pcsService.getPcsInfoByDayList(map);
            
            baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
            
            baseTransferEntity.setData(lstlist);
            
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
            
        } catch (Exception e) {
        	
            log.error("PcsController getPcsInfoByDayList--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
            
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    /**
     * 获取所有实时数据  显示当月信息 图表显示(分页)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsHistoryMonthLst")
    @ResponseBody
    public BaseTransferEntity getPcsHistoryMonthLst(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		PagerTwo page = new PagerTwo();
    		
    		String currentPage = request.getParameter("currentPage");
    		
    		if (currentPage != null && !currentPage.isEmpty()) {
    			
    			page.setCurrentPage(Integer.parseInt(currentPage));
    			
    		}
    		String date = request.getParameter("date");
    		
    		String equ_num = request.getParameter("equ_num");
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		
    		map.put("currentPage", page.getCurrentPage());
    		
    		map.put("start", page.getStart());
    		
    		map.put("date", date);
    		
    		map.put("equ_num", equ_num);
    		
    		Map<String, Object> couMap = pcsService.getPcsHistoryMonthLstCou(map);
    		
    		page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
    		
    		map.put("everyPage", page.getEveryPage());
    		
    		List<Map<String, Object>> lstlist = pcsService.getPcsHistoryMonthLst(map);
    		
    		baseTransferEntity.setCurrentPage(page.getCurrentPage());
    		
    		baseTransferEntity.setEveryPage(page.getEveryPage());
    		
    		baseTransferEntity.setTotalCount(page.getTotalCount());
    		
    		baseTransferEntity.setTotalPage(page.getTotalPage());
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(lstlist);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("PcsController getPcsHistoryMonthLst--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	
    	return baseTransferEntity;
    }
    
    
    /**
     * 综合监控  储能逆变器 历史信息 按年、月、日 查询 (正常使用)(图表)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsInfoByDayGraph")
    @ResponseBody
    public BaseTransferEntity getPcsInfoByDayGraph(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	try {
    		
    		String year = request.getParameter("year");
    		
    		String equ_num = request.getParameter("equ_num");
    		
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("year", year);
			
			map.put("equ_num", equ_num);
			
			List<Map<String, Object>> lstlist = pcsService.getPcsInfoByDayGraph(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
    	} catch (Exception e) {
    		
    		log.error("PcsController getPcsInfoByDayGraph--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	
    	return baseTransferEntity;
    }
    
    
    

    /**
     * 获取PCS设备列表页的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsInfLst")
    @ResponseBody
    public BaseTransferEntity getPcsInfLst(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = pcsService.getPcsInfLst(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PcsController getPcsInfLst--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    /**
     * 获取PCS设备状态的信息 (正常使用)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPcsInfStat")
    @ResponseBody
    public BaseTransferEntity getPcsInfStat(HttpServletRequest request, HttpServletResponse response) {

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
            
			List<Map<String, Object>> lstlist = pcsService.getPcsInfStat(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(lstlist);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

        }
        catch (Exception e) {
        	
            log.error("PcsController getPcsInfStat--------->" + e.getMessage(), e);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
           
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
           
            baseTransferEntity.setData(null);
        }
        
        return baseTransferEntity;
    }
    
    
    
    
}

