package com.qinergy.controller.system;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.qinergy.base.BaseController;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.system.DepartmentDto;
import com.qinergy.service.system.SystemDepService;
import com.qinergy.util.MobileConfig;

/**
 * 与部门有关对前端页面接口类
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping
public class SystemDepController extends BaseController{

	private static Logger log = Logger.getLogger(SystemController.class);

	@Autowired
	private SystemDepService systemDepService;

	// 数据传输对象
	BaseTransferEntity baseTransferEntity;

	/**
	 * 添加部门信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insDepInf")
	@ResponseBody
	public BaseTransferEntity insDepInf(HttpServletRequest request,
			HttpServletResponse response,DepartmentDto departmentDto) {

		baseTransferEntity = new BaseTransferEntity();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("dep_nam", departmentDto.getDep_nam());
		map.put("dep_ide", departmentDto.getDep_ide());
		map.put("com_id", departmentDto.getCom_id());
		map.put("remark", departmentDto.getRemark());
		map.put("dep_sta", departmentDto.getDep_sta());
		map.put("dep_sor", departmentDto.getDep_sor());
		map.put("del_flag", DepartmentDto.DEP_STAT_YES);
		map.put("crt_use_id", getCurrentUserId(request));
		map.put("crt_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		try {
			systemDepService.insertDep(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(null);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {
			log.error("SystemDepController insDepInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("添加部门信息接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}

		return baseTransferEntity;
	}
	
	/**
	 * 修改部门信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updDepInf")
	@ResponseBody
	public BaseTransferEntity updDepInfo(HttpServletRequest request,
			HttpServletResponse response,DepartmentDto departmentDto) {

		baseTransferEntity = new BaseTransferEntity();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", departmentDto.getId());
		map.put("dep_nam", departmentDto.getDep_nam());
		map.put("dep_ide", departmentDto.getDep_ide());
		map.put("com_id", departmentDto.getCom_id());
		map.put("remark", departmentDto.getRemark());
		map.put("dep_sta", departmentDto.getDep_sta());
		map.put("dep_sor", departmentDto.getDep_sor());
		map.put("mod_use_id", getCurrentUserId(request));
		map.put("mod_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		try {

			systemDepService.updDep(map);
			
			
			DepartmentDto depInfo = systemDepService.getDepInfoById(map);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(depInfo);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {
			log.error("SystemDepController updDepInfo--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改部门信息接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * 删除部门信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/delDepInf")
	@ResponseBody
	public BaseTransferEntity delDepInf(HttpServletRequest request,
			HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();
		
		try {
			String id = request.getParameter("id");
			Map<String, Object> map = new HashMap<String, Object>();
			if(id != null && id != ""){
				map.put("id", Integer.parseInt(id));
			}
			map.put("del_flag", DepartmentDto.DEP_STAT_NO);
			
			systemDepService.deleteDep(map);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setData(null);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			log.error("SystemDepController delDepInf--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("删除部门信息接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * 查询部门信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDepInfList")
	@ResponseBody
	public BaseTransferEntity getDepInfLst(HttpServletRequest request,
			HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();
		
		try {
			String com_id = request.getParameter("com_id");
			Map<String, Object> map = new HashMap<String, Object>();
			if(com_id != null && com_id != ""){
				map.put("com_id", Integer.parseInt(com_id));
			}
			List<DepartmentDto> depInfo = systemDepService.getDepInfo(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(depInfo);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("SystemDepController getDepInfLst--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("查询部门接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 查询指定部门信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getDepInfById")
	@ResponseBody
	public BaseTransferEntity getDepInfById(HttpServletRequest request,
			HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();
		
		try {
			String id = request.getParameter("id");
			String com_id = request.getParameter("com_id");
			Map<String, Object> map = new HashMap<String, Object>();
			if(id != null && id != ""){
				map.put("id", Integer.parseInt(id));
			}
			if(com_id != null && com_id != ""){
				map.put("com_id", Integer.parseInt(com_id));
			}
			
			DepartmentDto depInfoById = systemDepService.getDepInfoById(map);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(depInfoById);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("SystemDepController getDepInfById--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("查询指定部门接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 获取所有职位的职位名称信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getPosInfAll")
	@ResponseBody
	public BaseTransferEntity getPosInfAll(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try{
			
			List<Map<String, Object>> posLst = systemDepService.getPosInfAll();
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(posLst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		
		} catch (Exception e) {
			
			log.error("SystemDepController getPosInfAll--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("获取所有职位的职位名称信息的接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	
}
