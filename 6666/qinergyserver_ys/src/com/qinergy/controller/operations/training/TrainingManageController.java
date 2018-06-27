package com.qinergy.controller.operations.training;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.Pager;
import com.qinergy.dto.operations.TrainingManagerDto;
import com.qinergy.dto.operations.TrainingManagerPlanDto;
import com.qinergy.dto.operations.TrainingTypeDto;
import com.qinergy.service.operations.training.TrainingManageService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.EhcacheUtil;
import com.qinergy.util.MobileConfig;

/**
 * 培训有关对前端页面接口类
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
public class TrainingManageController {
	
    private static Logger log = Logger.getLogger(TrainingManageController.class);

    @Autowired
    private EhcacheUtil ehcacheUtil;
    
    @Autowired
    private TrainingManageService trainingManageService;

    BaseTransferEntity baseTransferEntity;
    
    
    /**
     * @Title: insTrainingTyp  
     * @Desc: 添加 培训计划类型 
     * @return BaseTransferEntity
     * @throws
     */
	@RequestMapping("/service/insTrainingTyp")
	@ResponseBody
	public BaseTransferEntity insTrainingTyp(HttpServletRequest request, HttpServletResponse response,
			TrainingTypeDto trainingTypeDto) {
		baseTransferEntity = new BaseTransferEntity();
    
		try {
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("typ_nam", trainingTypeDto.getTyp_nam());
			List<Map<String,Object>> lstName = trainingManageService.getTrainingTypByName(map);
			if (lstName != null && !lstName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("类型名称重复，请重新填写！");
				return baseTransferEntity;
			}
			
			boolean insTrainingTyp = trainingManageService.insTrainingTyp(trainingTypeDto);
			baseTransferEntity.setData(insTrainingTyp);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			log.error("TrainingManageController: insTrainingTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("添加 培训计划 接口异常，请联系管理员！");
		}
    
		return baseTransferEntity;
	}
    
    /**
     * @Title: updTrainingTyp  
     * @Desc: 修改 培训计划类型 
     * @return BaseTransferEntity
     * @throws
     */
	@RequestMapping("/service/updTrainingTyp")
	@ResponseBody
	public BaseTransferEntity updTrainingTyp(HttpServletRequest request, HttpServletResponse response,
			TrainingTypeDto trainingTypeDto) {
		baseTransferEntity = new BaseTransferEntity();
    
		try {
			boolean updTrainingTyp = trainingManageService.updTrainingTyp(trainingTypeDto);
			baseTransferEntity.setData(updTrainingTyp);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: updTrainingTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改 培训计划 接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	} 
    
	
	/**
	 * @Title: getTrainingTypById  
	 * @Desc: 根据id 获取培训类型 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getTrainingTypById")
	@ResponseBody
	public BaseTransferEntity getTrainingTypById(HttpServletRequest request, HttpServletResponse response,
			TrainingTypeDto trainingTypeDto) {
		baseTransferEntity = new BaseTransferEntity();
	
		String id = request.getParameter("id");// 培训类型id
		try {
			Map<String, Object> trainingTyp = trainingManageService.getTrainingTypById(id);
			baseTransferEntity.setData(trainingTyp);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: getTrainingTypById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("根据id 获取培训类型 接口异常，请联系管理员！");
		}
		
		
		return baseTransferEntity;
	} 	
	
	/**
	 * @Title: delTrainingTyp  
	 * @Desc: 删除 培训类型 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/delTrainingTyp")
	@ResponseBody
	public BaseTransferEntity delTrainingTyp(HttpServletRequest request, HttpServletResponse response,
			TrainingTypeDto trainingTypeDto) {
		baseTransferEntity = new BaseTransferEntity();
	
		String typ_id = request.getParameter("id");// 培训类型id
		String use_id = request.getParameter("use_id");// 操作人id
	
		try {
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("typ_id", typ_id);
			paramMap.put("del_flag", TrainingManagerDto.DEL_FLAG_NO);
			paramMap.put("start", 0);
			paramMap.put("everyPage", 10);
			
			List<Map<String, Object>> planList = trainingManageService.getTrainingPlanList(paramMap);
			if(planList != null && planList.size() > 0){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.type.not.null"));
				baseTransferEntity.setDesc("请先删除该类型的计划信息，再删除该类型！");
				return baseTransferEntity;
			}
			
			boolean delTrainingTyp = trainingManageService.delTrainingTyp(typ_id, use_id);
			baseTransferEntity.setData(delTrainingTyp);
			if(delTrainingTyp){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else{
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("TrainingManageController: delTrainingTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("逻辑删除 培训类型  接口异常，请联系管理员！");
		}
	
		return baseTransferEntity;
	} 	
	
	/**
	 * @Title: getTrainingTypList  
	 * @Desc:  获取所有培训类型 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getTrainingTypList")
	@ResponseBody
	public BaseTransferEntity getTrainingTypList(HttpServletRequest request, HttpServletResponse response,
			TrainingTypeDto trainingTypeDto) {
		baseTransferEntity = new BaseTransferEntity();
	
		try {
			List<Map<String, Object>> trainingTypList = trainingManageService.getTrainingTypList();
			baseTransferEntity.setData(trainingTypList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: getTrainingTypList:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取所有培训类型 接口异常，请联系管理员！");
		}
		
		
		return baseTransferEntity;
	} 		
	
	
	
	/*******************************************
	 * @Title: uploadTraining  
	 * @Desc: 上传培训文件 
	 * 			file_type文件类型(1:文件 2:图片)
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping(value = { "service/uploadTraining" }, method = { RequestMethod.POST })
	@ResponseBody
	public BaseTransferEntity uploadTraining(@RequestParam("file") MultipartFile file, int use_id, String train_num) {
		baseTransferEntity = new BaseTransferEntity();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		if(file == null){
			
			log.error("uploadDef ：上传文件 为空");
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传文件 为空");
			return baseTransferEntity;
		}if(file.getSize() > 100 * 1024 * 1024){ 
			log.error("uploadDef ：上传失败：文件大小不能超过100M");
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传失败：文件大小不能超过100M");
            return baseTransferEntity;
        }
		
		try {
			paramMap.put("file_nam", file.getOriginalFilename());
			paramMap.put("train_num", train_num);
			paramMap.put("crt_use_id", use_id);
			paramMap.put("crt_tim", DateUtil.getcurrentTime());
			
			boolean flag = trainingManageService.uploadTrainFile(file, paramMap);
			baseTransferEntity.setData(flag);
			
			if (flag) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("文件上传成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("文件上传失败");
			}
		} catch (Exception e) {
			log.error("TrainingManageController: uploadTraining:--------->"+e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传培训文件 接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}
	
	
	/**
	 * @Title: downloadTraining  
	 * @Desc: 下载培训 文件  
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/downloadTraining")
	@ResponseBody
	public BaseTransferEntity downloadTraining(@RequestParam("id") int id, HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			trainingManageService.downloadTrainFile(response, id, baseTransferEntity);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("成功");
			return baseTransferEntity;
			
		} catch (Exception e) {
			log.error("TrainingManageController: downloadTraining:--------->"+e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("下载培训文件 接口异常，请联系管理员！");
			return baseTransferEntity;
		}
	}
	
	/**
	 * @Title: delTrainFile  
	 * @Desc: 删除 培训文件 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delTrainFile")
	@ResponseBody
	public BaseTransferEntity delTrainFile(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		try {
			String id = request.getParameter("id");// id
			String use_id = request.getParameter("use_id");// 操作人id
			
			boolean delTrainFile = trainingManageService.delTrainFile(id, use_id);
			baseTransferEntity.setData(delTrainFile);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			log.error("TrainingManageController: delTrainFile:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("删除文件接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}	
	
	
	/**
	 * @Title: getTrainFileById  
	 * @Desc: 获取 文件信息 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getTrainFileById")
	@ResponseBody
	public BaseTransferEntity getTrainFileById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String id = request.getParameter("id");
		
		try {
			baseTransferEntity.setData(trainingManageService.getFileById(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: getFileById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取文件信息 接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}	
		
		
	/**
	 * @Title: getFileListByTrainNum  
	 * @Desc: 获取文件列表  
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getFileListByTrainNum")
	@ResponseBody
	public BaseTransferEntity getFileListByTrainNum(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String train_num = request.getParameter("train_num");// 培训编号	
		
		try {
			baseTransferEntity.setData(trainingManageService.getFileListByTrainNum(train_num));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: getFileListByDefId:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取文件列表 接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}			
		
		
	/************************************************************************8
	 * @Title: insTraining  
	 * @Desc:  添加培训 信息 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/insTraining")
	@ResponseBody
	public BaseTransferEntity insTraining(HttpServletRequest request, TrainingManagerDto managerDto) {
		baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 添加培训 信息
			boolean insTraining = trainingManageService.insTraining(managerDto);
			baseTransferEntity.setData(insTraining);
			if(insTraining){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("TrainingManageController: insTraining:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("添加培训  接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}
	
	
	
	/**
	 * @Title: getTrainingById  
	 * @Desc:  根据id 获取培训 信息 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getTrainingById")
	@ResponseBody
	public BaseTransferEntity getTrainingById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String id = request.getParameter("id"); 
		
		try {
			baseTransferEntity.setData(trainingManageService.getTrainingById(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: getTrainingById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取培训 信息  接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}	
	

	/**
	 * @Title: updTraining  
	 * @Desc:  修改培训 信息   
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/updTraining")
	@ResponseBody
	public BaseTransferEntity updTraining(HttpServletRequest request, TrainingManagerDto managerDto) {
		baseTransferEntity = new BaseTransferEntity();
		try {
			 boolean updTraining = trainingManageService.updTraining(managerDto);
			baseTransferEntity.setData(updTraining);
			if(updTraining){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("TrainingManageController: updTraining:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改培训 信息  接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * @Title: executeTraining  
	 * @Desc:  执行培训 将未开始的培训 设置为进行中
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/executeTraining")
	@ResponseBody
	public BaseTransferEntity executeTraining(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String id = request.getParameter("id"); 
		String use_id = request.getParameter("use_id"); //操作人id
		
		try {
			 boolean updTraining = trainingManageService.executeTraining(id, use_id);
			baseTransferEntity.setData(updTraining);
			if(updTraining){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("TrainingManageController: executeTraining:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改培训 信息  接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}	
		
		
		
	/**
	 * @Title: delTrainingById  
	 * @Desc:  根据id 删除培训 信息  
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delTrainingById")
	@ResponseBody
	public BaseTransferEntity delTrainingById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String id = request.getParameter("id"); 
		String mod_use_id = request.getParameter("use_id"); //操作人id
		
		try {
			
			boolean delTraining = trainingManageService.delTrainingById(id, mod_use_id);
			baseTransferEntity.setData(delTraining);
			if(delTraining){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("TrainingManageController: delTrainingById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("根据id删除培训 信息 异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * @Title: delBatchTrainingById  
	 * @Desc:  批量删除培训信息 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delBatchTrainingById")
	@ResponseBody
	public BaseTransferEntity delBatchTrainingById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String ids = request.getParameter("ids"); 
		String mod_use_id = request.getParameter("use_id"); //操作人id
		
		try {
			boolean delBatchTraining = trainingManageService.delBatchTrainingById(ids, mod_use_id);
			baseTransferEntity.setData(delBatchTraining);
			if(delBatchTraining){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: delBatchTrainingPlanById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("批量删除培训 信息   异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * @Title: getTrainingList  
	 * @Desc:  获取培训 信息  列表 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getTrainingList")
	@ResponseBody
	public BaseTransferEntity getTrainingList(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String com_id = request.getParameter("com_id");// 公司id
		String typ_id = request.getParameter("typ_id");// 
		String start_tim = request.getParameter("start_tim"); 
		String end_tim = request.getParameter("end_tim"); 
		String words = request.getParameter("words");// 	
		
		String currentPage = request.getParameter("currentPage");// 查询 页码
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("com_id", com_id);
		paramMap.put("typ_id", typ_id);
		paramMap.put("start_tim", start_tim);
		paramMap.put("end_tim", end_tim);
		paramMap.put("del_flag", TrainingManagerDto.DEL_FLAG_NO);
		paramMap.put("words", words);	
	
		Pager page = new Pager();
		if (currentPage != null && !currentPage.isEmpty()) {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		try {
			page.setTotalCount(trainingManageService.getTrainingListCount(paramMap));
			paramMap.put("start", page.getStart());
			paramMap.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> trainingList = trainingManageService.getTrainingList(paramMap);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(trainingList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: getTrainingPlanList:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("分页查询该公司下的培训 信息  列表接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}	
	
	/****************************培训 计划***********************************
	 * @Title: insTrainingPlan  
	 * @Desc: 添加培训 计划信息  
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/insTrainingPlan")
	@ResponseBody
	public BaseTransferEntity insTrainingPlan(HttpServletRequest request, TrainingManagerPlanDto managerDto) {
		baseTransferEntity = new BaseTransferEntity();
		
		try {
			boolean insTrainingPlan = trainingManageService.insTrainingPlan(managerDto);
			baseTransferEntity.setData(insTrainingPlan);
			if(insTrainingPlan){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("TrainingManageController: insTrainingPlan:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("添加培训 计划 接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * @Title: getTrainingPlanById  
	 * @Desc:  根据id 获取培训计划 信息  
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getTrainingPlanById")
	@ResponseBody
	public BaseTransferEntity getTrainingPlanById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String id = request.getParameter("id"); 
		
		try {
			baseTransferEntity.setData(trainingManageService.getTrainingPlanById(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: getTrainingPlanById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取培训 计划信息  接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}
	
	/**
	 * @Title: updTrainingPlan  
	 * @Desc:  修改培训计划 信息    
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/updTrainingPlan")
	@ResponseBody
	public BaseTransferEntity updTrainingPlan(HttpServletRequest request, TrainingManagerPlanDto managerDto) {
		baseTransferEntity = new BaseTransferEntity();
		try {
			boolean updTrainingPlan = trainingManageService.updTrainingPlan(managerDto);
			baseTransferEntity.setData(updTrainingPlan);
			if(updTrainingPlan){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("TrainingManageController: updTrainingPlan:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改培训 计划信息  接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * @Title: delTrainingPlanById  
	 * @Desc:  根据id 删除培训计划 信息   
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delTrainingPlanById")
	@ResponseBody
	public BaseTransferEntity delTrainingPlanById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String id = request.getParameter("id"); 
		String mod_use_id = request.getParameter("use_id"); //操作人id
		String tra_num = request.getParameter("tra_num"); 
		
		try {
			
			List<Map<String, Object>> fileList = trainingManageService.getFileListByTrainNum(tra_num);
			if(fileList != null && fileList.size() > 0){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.file.not.null"));
				baseTransferEntity.setDesc("请先删除该计划的文件，再删除该计划！");
				return baseTransferEntity;
			}
			
			boolean delTrainingPlan = trainingManageService.delTrainingPlanById(id, mod_use_id);
			baseTransferEntity.setData(delTrainingPlan);
			if(delTrainingPlan){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("TrainingManageController: delTrainingPlanById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("根据id删除培训计划 信息 异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * @Title: delBatchTrainingPlanById  
	 * @Desc:  批量删除培训计划信息  
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delBatchTrainingPlanById")
	@ResponseBody
	public BaseTransferEntity delBatchTrainingPlanById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		String ids = request.getParameter("ids"); 
		String mod_use_id = request.getParameter("use_id"); //操作人id
		
		try {
			boolean delBatch = trainingManageService.delBatchTrainingPlanById(ids, mod_use_id);
			baseTransferEntity.setData(delBatch);
			if(delBatch){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: delBatchTrainingPlanById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("批量删除培训 计划信息   异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * @Title: getTrainingPlanList  
	 * @Desc:  获取培训计划记录信息 列表 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getTrainingPlanList")
	@ResponseBody
	public BaseTransferEntity getTrainingPlanList(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		
		String com_id = request.getParameter("com_id");// 公司id
		String typ_id = request.getParameter("typ_id");// 
		String start_tim = request.getParameter("start_tim"); 
		String end_tim = request.getParameter("end_tim"); 
		String words = request.getParameter("words");// 	
		
		String currentPage = request.getParameter("currentPage");// 查询 页码  
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("com_id", com_id);
		paramMap.put("typ_id", typ_id);
		paramMap.put("start_tim", start_tim);
		
		paramMap.put("del_flag", TrainingManagerDto.DEL_FLAG_NO);
		
		paramMap.put("words", words);	
		
		Pager page = new Pager();
		if (currentPage != null && !currentPage.isEmpty()) {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		try {

			if(end_tim != null && !end_tim.isEmpty()){
				
				SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
				
				paramMap.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));
			}
			
			page.setTotalCount(trainingManageService.getTrainingPlanListCount(paramMap));
			paramMap.put("start", page.getStart());
			paramMap.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> trainingPlanList = trainingManageService.getTrainingPlanList(paramMap);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(trainingPlanList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("TrainingManageController: getTrainingPlanList:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("分页查询该公司下的培训记录信息 列表   列表接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}		
		

}
