package com.qinergy.controller.statisticanalysis.pwssta;

import java.util.ArrayList;
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
import com.qinergy.dto.system.CompanyDto;
import com.qinergy.service.statisticanalysis.pwssta.PwsStaService;
import com.qinergy.service.system.SystemService;
import com.qinergy.util.MobileConfig;

/**
 * 统计分析-电站分析-对前端页面接口类
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
public class PwsStaController {
	// 声明
    private static Logger log = Logger
                .getLogger(PwsStaController.class);

    @Autowired
    private PwsStaService pwsStaService;
    
    @Autowired
	private SystemService systemService;

    /**
     * 电站统计分析 获取所有地区
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPwsStaInfo")
    @ResponseBody
    public BaseTransferEntity getPwsStaInfo(HttpServletRequest request, HttpServletResponse response) {

    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 获取用户id
			String userid = request.getParameter("id");
			
			int id = Integer.parseInt(userid);

			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);

			// 根据用户id查询公司id
			List<Map<String, Object>> retMap = systemService.getComFat(map);
			
			int companyId = (Integer) retMap.get(0).get("id");
			
			CompanyDto companyDto = new CompanyDto();
			
			companyDto.setId(companyId);

			List<Map<String, Object>> ListPws =  new ArrayList<Map<String, Object>>();
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(ListPws);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("PwsStaController getPwsStaInfo--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
    }
    
    /**
     * 电站统计分析 通过地区 获取站点 信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getStaByPws")
    @ResponseBody
    public BaseTransferEntity getStaByPws(HttpServletRequest request, HttpServletResponse response) {

    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();

		try {
			// 获取地区 省 id
			String pro_id = request.getParameter("pro_id");
			// 获取地区 市 id
			String cit_id = request.getParameter("cit_id");
			
			String com_id = request.getParameter("com_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pro_id", pro_id);
			map.put("cit_id", cit_id);
			map.put("com_id", com_id);
			
			 lst = pwsStaService.getStaByPws(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(lst);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("PwsStaController getStaByPws--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

    }
    
    
    
    
    /**
     * 电站统计分析 通过站点信息  获取详细信息
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getSatInfoByStaId")
    @ResponseBody
    public BaseTransferEntity getSatInfoByStaId(HttpServletRequest request, HttpServletResponse response) {

    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> map = new HashMap<String, Object>();

		try {
			
			String type = request.getParameter("type");
			
			String year = request.getParameter("year");
			
			//年
			if ("1".equals(type)) {
				// 站点 id
				String strings = request.getParameter("id");
				
				map.put("strings", strings);
				
				map.put("year", year);
				
				List<Map<String, Object>> lst = pwsStaService.getSatInfoByStaId(map);
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setData(lst);
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}

			// 月
			if ("2".equals(type)) {
				// 站点 id
				String strings = request.getParameter("id");
				
				map.put("strings", strings);
				
				map.put("year", year);
				
				List<Map<String, Object>> lst = pwsStaService.getSatInfoByStaIdMonth(map);
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setData(lst);
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}
			
			
		} catch (Exception e) {
			
			log.error("PwsStaController getSatInfoByStaId--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
    }
    


    /**
     * 电站统计分析  实际、计划发电量 (这个没有用到)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPower")
    @ResponseBody
    public BaseTransferEntity getPower(HttpServletRequest request, HttpServletResponse response) {

    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			
			
			String year = request.getParameter("year");

				// 站点 id
				String strings = request.getParameter("id");
				String[] pws_id = strings.split("-");
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < pws_id.length; i++) {
					map.put("pws_id", pws_id[i].toString());
					map.put("year", year);
					lst = pwsStaService.getPower(map);
					list.addAll(lst);
				}
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setData(list);
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		

		
			
			
		} catch (Exception e) {
			log.error("PwsStaController getPower--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

    }
    
    
    
    
    
    /**
     * 电站统计分析  实际、计划发电量 (this is my new and better method)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPowerNew")
    @ResponseBody
    public BaseTransferEntity getPowerNew(HttpServletRequest request, HttpServletResponse response) {

    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			
			String year = request.getParameter("year");

				// 站点 id
				String strings = request.getParameter("id");
				String[] pws_id = strings.split("-");
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < pws_id.length; i++) {
					map.put("pws_id", pws_id[i].toString());
					map.put("year", year);
					lst = pwsStaService.getPowerNew(map);
					list.addAll(lst);
				}
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setData(list);
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			log.error("PwsStaController getPower--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

    }
    
    /**
     * 电站统计分析  实际、计划充放电量 (this is my new and better method)
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPhiPheNew")
    @ResponseBody
    public BaseTransferEntity getPhiPheNew(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	try {
    		
    		String year = request.getParameter("year");
    		
    		// 站点 id
    		String strings = request.getParameter("id");
    		
    		String[] pws_id = strings.split("-");
    		
    		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    		
    		for (int i = 0; i < pws_id.length; i++) {
    			
    			map.put("pws_id", pws_id[i].toString());
    			
    			map.put("year", year);
    			
    			lst = pwsStaService.getPhiPheNew(map);
    			
    			list.addAll(lst);
    		}
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		
    		baseTransferEntity.setData(list);
    		
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		
    		log.error("PwsStaController getPhiPheNew--------->" + e.getMessage(), e);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		
    		baseTransferEntity.setData(null);
    	}
    	
    	return baseTransferEntity;
    }
    
    
    
    /**
     * 电站统计分析   实际、计划放电量/充电量
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPhiPheSaMon")
    @ResponseBody
    public BaseTransferEntity getPhiPheSaMon(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	try {
    		
    		String year = request.getParameter("year");
    		
    		// 站点 id
    		String strings = request.getParameter("id");
    		String[] pws_id = strings.split("-");
    		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    		for (int i = 0; i < pws_id.length; i++) {
    			map.put("pws_id", pws_id[i].toString());
    			map.put("year", year);
    			lst = pwsStaService.getPhiPheSaMon(map);
    			list.addAll(lst);
    		}
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		baseTransferEntity.setData(list);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		log.error("PwsStaController getPower--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    	
    }
    
    
    

    /**
     * 电站统计分析  故障数排行
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getFalEquNum")
    @ResponseBody
    public BaseTransferEntity getFalEquNum(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
    	
    	try {
    		
			String year = request.getParameter("year");
			// 站点 id
			String pws_id = request.getParameter("pws_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("year", year);
			map.put("pws_id", pws_id);
			
			lst = pwsStaService.getFalEquNum(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		log.error("PwsStaController getPower--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    	
    }
    

    /**
     * 排行榜 发电量排行榜 TOP5bottom5
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/service/getPowerRankByComOwner")
    @ResponseBody
    public BaseTransferEntity getPowerRankByComOwner(HttpServletRequest request, HttpServletResponse response) {
    	
    	BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
    	
    	List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
    	
    	try {
    		// type为2则处理月排行，为1则处理年排行
			String type = request.getParameter("type");
			
			String date = request.getParameter("date");
			// 用户 id
			String use_id = request.getParameter("use_id");
			
			String pws_id = request.getParameter("pws_id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("type", type);
			
			map.put("date", date);
			
			map.put("use_id", use_id);
			
			map.put("pws_id", pws_id);
			
			lst = pwsStaService.getPowerRankByComOwner(map);
    		
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
    		baseTransferEntity.setData(lst);
    		baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
    		
    	} catch (Exception e) {
    		log.error("PwsStaController getPowerRankByComOwner--------->" + e.getMessage(), e);
    		baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
    		baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
    		baseTransferEntity.setData(null);
    	}
    	return baseTransferEntity;
    	
    }
    
}
