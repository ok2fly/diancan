package com.qinergy.controller.dailyoffice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

import com.qinergy.base.BaseController;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.Pager;
import com.qinergy.dto.UserInfDto;
import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.UserDto;
import com.qinergy.service.dailyoffice.DailyOfficeService;
import com.qinergy.service.system.SystemService;
import com.qinergy.service.utils.UtilsService;
import com.qinergy.util.EhcacheUtil;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.StringUtil;

@Controller
@RequestMapping(value = "")
public class DailyOfficeController extends BaseController{
	// 声明
	private static Logger log = Logger.getLogger(DailyOfficeController.class);

	@Autowired
	private DailyOfficeService dailyOfficeService;

	@Autowired
	private EhcacheUtil ehcacheUtil;
	@Autowired
	private SystemService systemService;
	@Autowired
	private UtilsService utilsService;
	
	/**
	 * 文件上传
	 * @param file
	 * @param file_type
	 * @param created_id
	 * @param remark
	 * @return
	 */
	@RequestMapping(value = { "service/upload" }, method = { RequestMethod.POST })
	@ResponseBody
	public BaseTransferEntity uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("file_type") int file_type,int created_id,String remark) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

		try {
			map.put("file_name", file.getOriginalFilename());//文件名
			map.put("file_type", file_type);//文件类型
			map.put("created_id", created_id);//创建人
			map.put("comment", remark);//备注
			map.put("created_date", new Date());//创建时间
			long cou = 0;
			cou += file.getSize();
			
			if(cou > 100 * 1024 * 1024){ 
				log.error("uploadDef ：上传失败：文件大小不能超过100M");
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
				baseTransferEntity.setDesc("上传失败：文件大小不能超过100M");
				return baseTransferEntity;
			}
			boolean flag = dailyOfficeService.uploadFile(file, map, created_id);
			if (flag) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("文件上传成功");

			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("文件上传失败");
			}
		} catch (Exception e) {
			log.error("文件上传失败" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	//下载文件
	@RequestMapping("/service/download")
	@ResponseBody
	public BaseTransferEntity fileDownload(@RequestParam("id") int id, HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			dailyOfficeService.downloadFile(response, id, baseTransferEntity);
			return baseTransferEntity;

		} catch (Exception e) {
			e.printStackTrace();
			log.error("文件下载失败，请联系管理员"+e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			return baseTransferEntity;
		}

	}
	
	/**
	 * app端 下载 需要的返回参数
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/AppSelectFileById")
	@ResponseBody
	public BaseTransferEntity AppSelectFileById(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			//文件id
			String id = request.getParameter("id");
			
			//用户id
			String created_id = request.getParameter("user_id");
			
			//文件类型
			String file_type = request.getParameter("file_type");
			
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("created_id", created_id);
			map.put("file_type", file_type);
			
			List<Map<String, Object>> lstHashMaps = dailyOfficeService.AppSelectFileById(map);
			
			 baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
	         baseTransferEntity.setData(lstHashMaps);
	         baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));

		} catch (Exception e) {
			e.printStackTrace();
			log.error("app端文档管理，下载文档异常，请联系管理员"+e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
		}
		return baseTransferEntity;

	}
	
	
	
	
	
	/**
	 * 文件删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/removeFile")
	@ResponseBody
	public BaseTransferEntity removeFile(@RequestParam("id") int id){
		BaseTransferEntity baseTransferEntity=new BaseTransferEntity();
		try{
			int result=dailyOfficeService.removeFile(id);
			if(result==1){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("删除成功");
			}else{
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("文件删除失败");
			}
		}catch(Exception e){
			log.error("文件删除异常"+e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}
	
	/**
	 * 列表查询
	 * @param user_id
	 * @param request
	 * @return
	 */
	@RequestMapping("/service/getFileList")
	@ResponseBody
	public BaseTransferEntity getFileList(Integer user_id,HttpServletRequest request){
		
		BaseTransferEntity baseTransferEntity=new BaseTransferEntity();
		
		try{
			String name = request.getParameter("info");//查询内容 根据名字模糊查询
			
			String type = request.getParameter("id");
			
			if(name!=null) 
				name="%"+name+"%";
			
			UserDto userDto=new UserDto();
			
			userDto.setId(user_id);
			
			// 使用用户ID获取公司信息
			List<Map<String, Object>> com_info=dailyOfficeService.getComsInfoByUserId(userDto);
			// 获取公司级别
			int com_lev=(Integer) com_info.get(0).get("com_lev");
			
			List<Map<String, Object>> fileList=new ArrayList<Map<String,Object>>();
			
			List<Integer> allComsId=new ArrayList<Integer>();
			
			if(com_lev==1){
				// 获取所有公司信息
				List<Map<String, Object>> coms_id=dailyOfficeService.getAllComs();
				// 遍历公司信息
				for (Map<String, Object> map : coms_id) {
					
					allComsId.add((Integer) map.get("id"));
				}
				
			}else if (com_lev==2){// 如果 是2级公司
				
				allComsId.add((Integer) com_info.get(0).get("id"));
				
				CompanyDto companyDto=new CompanyDto();
				
				companyDto.setId((Integer) com_info.get(0).get("id"));
				// 获取3级公司信息
				List<Map<String,Object>> level_3=dailyOfficeService.getComs_Level_3_Of_com(companyDto);
				
				for (Map<String, Object> map : level_3) {
					
					allComsId.add((Integer) map.get("id"));
				}
				
			}else{
				
				allComsId.add((Integer) com_info.get(0).get("id"));
			}
			for (Integer integer : allComsId) {
				// 获取公司所属的文件信息列表
				fileList.addAll(dailyOfficeService.getComFileList(integer, type,name));
			}
			
			baseTransferEntity.setData(fileList);
			
			baseTransferEntity.setResultcode(MobileConfig.get("code.global.success"));
			
		}catch(Exception e){
			
			log.error("获取文件列表异常"+e.getMessage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}
	
	/**
	 * 查看文件类型
	 * @param request
	 * @return
	 */
	@RequestMapping("/service/filetype")
	@ResponseBody
	public BaseTransferEntity getFileType(HttpServletRequest request){
		
		BaseTransferEntity baseTransferEntity=new BaseTransferEntity();
		
		try{
			
			String id=request.getParameter("id");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			
			baseTransferEntity.setData(dailyOfficeService.getFileType(map));
			
			baseTransferEntity.setResultcode(MobileConfig.get("code.global.success"));
			
		}catch(Exception e){
			
			log.error("获取文件类型获取异常"+e.getMessage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
		
	}
	
	/**
	 * 添加文件类型
	 * @param typeName
	 * @param userId
	 * @param remark
	 * @return
	 */
	@RequestMapping("/service/addFileType")
	@ResponseBody
	public BaseTransferEntity addFileType(String typeName,int  userId, String remark){
		BaseTransferEntity baseTransferEntity=new BaseTransferEntity();
		try{
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("fil_typ_nam", typeName); //类型名称
			
			List<Map<String,Object>> lstName = dailyOfficeService.selFileTypByName(map);
			
			if (lstName != null && !lstName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
				baseTransferEntity.setDesc("文档类型名称重复，请重新填写！");
				return baseTransferEntity;
			}
			
			dailyOfficeService.insertFileType(typeName, userId,new Date(), remark);
			baseTransferEntity.setResultcode(MobileConfig.get("code.global.success"));
			baseTransferEntity.setDesc("类型增加成功");
		}catch(Exception e){
			log.error("获取文件类型获取异常"+e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
		
	}
	
	/**
	 * 文档类型修改
	 * @param id
	 * @param typeName
	 * @param userId
	 * @param remark
	 * @return
	 */
	@RequestMapping("/service/updateFileType")
	@ResponseBody
	public BaseTransferEntity updateFileType(int id,String typeName,int  userId, String remark){
		BaseTransferEntity baseTransferEntity=new BaseTransferEntity();
		try{
			dailyOfficeService.updateFileTypeById(id, typeName, userId, remark);
			baseTransferEntity.setResultcode(MobileConfig.get("code.global.success"));
			baseTransferEntity.setDesc("类型修改成功");
		}catch(Exception e){
			log.error("异常"+e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
		
	}
	
	/**
	 * 文件删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/removeFileType")
	@ResponseBody
	public BaseTransferEntity removeFileType(@RequestParam("id") int id){
		BaseTransferEntity baseTransferEntity=new BaseTransferEntity();
		try{
			
			if(dailyOfficeService.removeFileType(id)){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("删除成功");
			}else{
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("删除失败,请确保该类型下所有文件被删除");
			}
		}catch(Exception e){
			log.error("文件删除异常"+e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/************************** 员工、客户 管理    通讯录管理 ******************************************/

	/**
	 * 添加用户信息
	 * 
	 * @return
	 */
	@RequestMapping("/service/insUserInfo")
	@ResponseBody
	public BaseTransferEntity insertUserInfo(HttpServletRequest request,
			HttpServletResponse response, UserInfDto userInfDto) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			
			userInfDto.setCrt_use_id(getCurrentUserId(request) + "");
			 
			Map<String,Object> mapNum = new HashMap<String, Object>();
			//账号
			mapNum.put("acc_num",userInfDto.getAcc_num());
			
			//根据  账号 查询   防止用户账号重复 
			List<Map<String, Object>> lstUserNum =	dailyOfficeService.getUserByNumAndNam(mapNum);
			
			if(lstUserNum != null && !lstUserNum.isEmpty()){
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
				baseTransferEntity.setDesc("账号已被注册，请重新填写账号！");
				
				return baseTransferEntity;
				
			}
			
			dailyOfficeService.insertUserInfo(userInfDto);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			log.error("DailyOfficeController insertUserInfo:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 */
	@RequestMapping("/service/upUserInfo")
	@ResponseBody
	public BaseTransferEntity upUserInfo(HttpServletRequest request,
			HttpServletResponse response, UserInfDto userInfDto) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			userInfDto.setMod_use_id(getCurrentUserId(request) + "");
			// 修改员工信息
			dailyOfficeService.updateUserInfo(userInfDto);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DailyOfficeController updateUserInfo:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}
	
	/**
	 * 修改运维人员分数
	 * 
	 * @return
	 */
	@RequestMapping("/service/updateUserScore")
	@ResponseBody
	public BaseTransferEntity updateUserScore(HttpServletRequest request,
			HttpServletResponse response, UserInfDto userInfDto) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 被修改人ID
			String id = request.getParameter("id");
			// 运维人员分数
			String use_score = request.getParameter("use_score");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("use_score", use_score);
			
			dailyOfficeService.updateUserScore(map);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DailyOfficeController updateUserInfo:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}

	/**
	 * 修改用户部门
	 * 
	 * @return
	 */
	@RequestMapping("/service/updateUserDep")
	@ResponseBody
	public BaseTransferEntity updateUserDep(HttpServletRequest request,
			HttpServletResponse response, UserInfDto userInfDto) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			userInfDto.setMod_use_id(getCurrentUserId(request) + "");
			dailyOfficeService.updateUserInfo(userInfDto);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DailyOfficeController updateUserDep:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * 修改用户密码
	 * 
	 * @return
	 */
	@RequestMapping("/service/resetPwd")
	@ResponseBody
	public BaseTransferEntity resetPwd(HttpServletRequest request,
			HttpServletResponse response, UserInfDto userInfDto) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			userInfDto.setMod_use_id(getCurrentUserId(request) + "");
			
			userInfDto.setUse_pas(StringUtil.md5Encrypt(userInfDto.getUse_pas(), "UTF-8"));
			
			dailyOfficeService.resetPwd(userInfDto);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DailyOfficeController resetPwd:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	@RequestMapping("/service/delUserInfo")
	@ResponseBody
	public BaseTransferEntity delUserInfo(HttpServletRequest request,
			HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		String id = request.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", Integer.valueOf(id));
		map.put("mod_use_id", getCurrentUserId(request));
		map.put("mod_tim", new Date());
		try {
			dailyOfficeService.delUserInfo(map);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DailyOfficeController delUserInfo:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * 启停账号
	 *  
	 * @return
	 */
	@RequestMapping("/service/setAccStat")
	@ResponseBody
	public BaseTransferEntity setAccStat(HttpServletRequest request,
			HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		String id = request.getParameter("id");
		String use_sta = request.getParameter("use_sta");
		String use_id = getCurrentUserId(request) + "";
		try {
			dailyOfficeService.setAccStat(Integer.valueOf(id),
					Integer.valueOf(use_sta), use_id);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DailyOfficeController setAccStat :--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * 根据员工id查询员工信息
	 * 
	 * @return
	 */
	@RequestMapping("/service/getUserInfById")
	@ResponseBody
	public BaseTransferEntity getUserInfById(HttpServletRequest request,
			HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> map = new HashMap<String, Object>();
		String id = request.getParameter("id");
		map.put("id", Integer.parseInt(id));
		map.put("use_sta", UserInfDto.USER_STAT_YES);

		try {
			List<Map<String, Object>> lst = dailyOfficeService.getUserInfById(map);
			baseTransferEntity.setData(lst);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("DailyOfficeController getUserInfById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setData(null);
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * 根据 条件查询员工信息 模糊查询 分页
	 * 
	 * 	1.根据use_typ 区分 员工/客户（运维、运营）  用户类型（1.运维人员，2.其它人员）
	 * 	2.员工和通讯录 使用同一表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/getUserInfListByType")
	@ResponseBody 
	public BaseTransferEntity getUserInfListByType(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		// 公司ID
		String com_id = request.getParameter("com_id");
		// 部门ID
		String dep_id = request.getParameter("dep_id");
		// 混合模糊 查询
		String words = request.getParameter("words");
		
		String currentPage = request.getParameter("currentPage");

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("words", words);
		
		map.put("com_id", com_id);
		
		map.put("dep_id", dep_id);
		
		Pager page = new Pager();
		
		if (currentPage != null && !currentPage.isEmpty()) {
			
			page.setCurrentPage(Integer.parseInt(currentPage));
			
		}
		try {
			// 获取用户信息数量
			int totalCount = dailyOfficeService.getUserListCount(map);
			
			page.setTotalCount(totalCount);
			
			map.put("start", page.getStart());
			
			map.put("everyPage", page.getEveryPage());
			
			// 使用用户类型获取用户信息
			List<Map<String, Object>> userInfListByType = dailyOfficeService.getUserInfListByType(map);
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
            baseTransferEntity.setEveryPage(page.getEveryPage());
            
            baseTransferEntity.setTotalCount(page.getTotalCount());
            
            baseTransferEntity.setTotalPage(page.getTotalPage());
            
            baseTransferEntity.setData(userInfListByType);
            
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
            
            baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
            
		} catch (Exception e) {
			
			log.error("DailyOfficeController getUserInfListByType--------->" + e.getMessage(), e);
			
            baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
            
            baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
            
            baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	
}
