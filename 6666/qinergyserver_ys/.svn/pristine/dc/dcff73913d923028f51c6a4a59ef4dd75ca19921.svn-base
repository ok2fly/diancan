package com.qinergy.controller.knowledgebase;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.Pager;
import com.qinergy.service.knowledgebase.KnowledgeBaseService;
import com.qinergy.util.EhcacheUtil;
import com.qinergy.util.MobileConfig;

/**
 * 知识库与安全管理对前端页面接口类
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
public class KnowledgeBaseController {
	// 声明
	private static Logger log = Logger.getLogger(KnowledgeBaseController.class);

	@Autowired
	private KnowledgeBaseService knowledgeBaseService;

	@Autowired
	private EhcacheUtil ehcacheUtil;

	/**
	 * 创建知识库信息
	 * @param typeId
	 * @param knwName
	 * @param knwDec
	 * @param useId
	 * @param remarke
	 * @param file
	 * @return
	 */
	@RequestMapping("/service/createKnw")
	@ResponseBody
	public BaseTransferEntity insertKnw(int typeId, String knwName, String knwDec, int useId) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			int result = knowledgeBaseService.insertKnw(typeId, knwName, knwDec, useId, new Date());
			if (result == 1) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("创建知识成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("创建知识失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("创建知识异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;

	}
	/**
	 * 添加知识相关的文件信息
	 * @param knwId
	 * @param userId
	 * @param remark
	 * @param file
	 * @return
	 */
	@RequestMapping("/service/addFilesToKnw")
	@ResponseBody
	public BaseTransferEntity addFilesToKnw(int knwId, int userId, String remark,
			@RequestParam("file") MultipartFile[] file) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
		if(file == null){
			log.error("uploadDef ：上传文件 为空");
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传文件 为空");
			return baseTransferEntity;
		}
		
		long cou = 0;
		for (int i = 0; i < file.length; i++) {
			
			cou += file[i].getSize();
			
			if(cou > 100 * 1024 * 1024){ 
				log.error("uploadDef ：上传失败：文件大小不能超过100M");
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
				baseTransferEntity.setDesc("上传失败：文件大小不能超过100M");
	            return baseTransferEntity;
	        }
		}
		
		
		
			knowledgeBaseService.addFileToKnw(knwId, userId, remark, file);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("创建知识异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 更新知识库信息
	 * @param knwId
	 * @param typeId
	 * @param knwName
	 * @param knwDec
	 * @param useId
	 * @param remarke
	 * @return
	 */
	@RequestMapping("/service/updateKnw")
	@ResponseBody
	public BaseTransferEntity updateKnwInfo(int knwId, int typeId, String knwName, String knwDec, int useId) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			int result = knowledgeBaseService.update(knwId, typeId, knwName, knwDec, useId, new Date());
			if (result == 1) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("修改知识成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("修改知识失败");
			}
		} catch (Exception e) {
			log.error("数据更新失败" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 下载与某条知识相关的文件
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/knwDownload")
	@ResponseBody
	public BaseTransferEntity fileDownload(@RequestParam("id") Integer id, HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			//knowledgeBaseService.downloadKnwFile(baseTransferEntity, id, response);

			List<Map<String, Object>> list = knowledgeBaseService.getFileInfoById(id);
			
			if (list.size() == 0 || !((Integer) list.get(0).get("del_flag") == 0)) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在");
				return baseTransferEntity;
			}

			String path = (String) list.get(0).get("fil_url"); //文件路径
			String file_name = (String) list.get(0).get("fil_nam");//文件名称
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("path", path);
			map.put("file_name", file_name);
			
			File file = new File(path);
			if (!file.exists()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在，可能被非法删除");
				return baseTransferEntity;
				
			}
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(map);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("文件下载失败，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
		}
		return baseTransferEntity;
	}

	/**
	 * 文件下载
	 * @param response
	 * @param path
	 * @param file_name
	 */
	@RequestMapping("/service/KnowXiaZai")
	@ResponseBody
	public void xiaZai(HttpServletResponse response,String path,String file_name){
		
		File file = new File(path);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/force-download");// 设置强制下载不打开
		try {
			response.addHeader("Content-Disposition","attachment;fileName=" + new String(file_name.getBytes(),"ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			log.error("转码失败" + e.getMessage());
			e.printStackTrace();
		} // 设置文件名
		byte[] buffer = new byte[1024];//创建buffer空间
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			OutputStream os = response.getOutputStream(); //输出流
			int i = bis.read(buffer);
			while (i != -1) {
				os.write(buffer, 0, i);
				i = bis.read(buffer);
			}
		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 删除知识库中的文件信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/removeKnwFile")
	@ResponseBody
	public BaseTransferEntity removeKnwFile(int id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			if (knowledgeBaseService.removeFileById(id)) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("文件删除成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("文件删除失败");
			}
		} catch (Exception e) {
			log.error("文件删除异常，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 删除知识信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/removeKnw")
	@ResponseBody
	public BaseTransferEntity removeKnwById(int id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			if (knowledgeBaseService.removeKnw(id)) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("知识删除成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("知识删除失败，请确保该知识下没有任何文件");
			}
		} catch (Exception e) {
			log.error("知识库删除异常，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 获取某一条知识信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/getKnwInfoById")
	@ResponseBody
	public BaseTransferEntity getKnwType(int id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			baseTransferEntity.setData(knowledgeBaseService.getKnwInfoById(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("获取成功");
		} catch (Exception e) {
			log.error("获取知识库类型异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 创建知识类型信息
	 * @param userId
	 * @param name
	 * @param remark
	 * @return
	 */
	@RequestMapping("/service/createKnwType")
	@ResponseBody
	public BaseTransferEntity addKnwType(int userId, String name, String remark) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("knw_typ_nam", name);
			List<Map<String,Object>> lstName = knowledgeBaseService.getKnwTypeByName(map);
			if (lstName != null && !lstName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("类型名称重复，请重新填写！");
				return baseTransferEntity;
			}
			
				boolean result = knowledgeBaseService.createKnwType(name, remark, userId);
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("创建成功");
		} catch (Exception e) {
			log.error("知识库创建异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;

	}

	/**
	 * 获取知识类型
	 */
	@RequestMapping("/service/KnwType")
	@ResponseBody
	public BaseTransferEntity getKnwType(String id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			baseTransferEntity.setData(knowledgeBaseService.getKnwTypeList(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("获取成功");
		} catch (Exception e) {
			log.error("获取知识库类型异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 使用知识类型ID获取知识信息列表
	 * @param info
	 * @param request
	 * @return
	 */
	@RequestMapping("/service/knwByTypeId")
	@ResponseBody
	public BaseTransferEntity getKnwByType(String info, HttpServletRequest request) {
		int id = 0;
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			
			if (info != null)//模糊查询的内容
				info = "%" + info + "%";
			String temp = request.getParameter("id");
			if (temp != null)
				id = Integer.parseInt(temp);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("currentPage", page.getCurrentPage());
			map.put("start", page.getStart());
			map.put("info",info);
			map.put("id",id);
			
			Map<String, Object> couMap = knowledgeBaseService.getKnwByTypeCou(map);
			
			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));
			
			map.put("everyPage", page.getEveryPage());
			
			baseTransferEntity.setData(knowledgeBaseService.getKnwByType(map));
			
			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			
			baseTransferEntity.setEveryPage(page.getEveryPage());
			
			baseTransferEntity.setTotalCount(page.getTotalCount());
			
			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("获取成功");
		} catch (Exception e) {
			log.error("获取知识库异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 使用知识ID获取与此知识有关的文件信息
	 */
	@RequestMapping("/service/fileInfoByKnw")
	@ResponseBody
	public BaseTransferEntity getFileInfoByKnw(int id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			baseTransferEntity.setData(knowledgeBaseService.getFileInfoByKnw(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("获取成功");
		} catch (Exception e) {
			log.error("获取知识库异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 移除知识类型信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/removeKnwType")
	@ResponseBody
	public BaseTransferEntity removeKnwType(int id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			if (knowledgeBaseService.removeKnwType(id)) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("删除成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("删除失败,请确保该项目下的知识已经被删除");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("知识类型删除异常，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 更新知识类型信息
	 * @param id
	 * @param knw_typ_nam
	 * @param use_id
	 * @param remark
	 * @return
	 */
	@RequestMapping("/service/updateKnwTypeInfo")
	@ResponseBody
	public BaseTransferEntity updateKnwTypeInfo(int id, String knw_typ_nam, int use_id, String remark) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			
			knowledgeBaseService.updateKnwTypeInfo(id, knw_typ_nam, use_id, new Date(), remark);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("信息更新成功");
		} catch (Exception e) {
			log.error("信息更新失败删除失败，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			return baseTransferEntity;
		}
		return baseTransferEntity;

	}

/************************* 下面的为安全管理的接口************************************************/
	/**
	 * 新建安全信息
	 * @param typeId
	 * @param sctName
	 * @param sctDec
	 * @param useId
	 * @param remarke
	 * @param file
	 * @return
	 */
	@RequestMapping("/service/createSct")
	@ResponseBody
	public BaseTransferEntity createSct(int typeId, String sctName, String sctDec, int useId, HttpServletRequest request) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			int result = knowledgeBaseService.insertSct(typeId, sctName, sctDec, useId, new Date());
			if (result == 1) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("创建安全项目成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("创建安全项目失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("创建安全项目异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;

	}

	/**
	 * 给安全信息添加文件信息
	 * @param sctId
	 * @param userId
	 * @param remark
	 * @param file
	 * @return
	 */
	@RequestMapping("/service/addFileToSct")
	@ResponseBody
	public BaseTransferEntity createSct(Integer sctId, Integer userId, String remark,
			@RequestParam("file") MultipartFile[] file) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
		if(file == null){
			log.error("uploadDef ：上传文件 为空");
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传文件 为空");
			return baseTransferEntity;
		}
		
		long cou = 0;
		for (int i = 0; i < file.length; i++) {
			
			cou += file[i].getSize();
			
			if(cou > 100 * 1024 * 1024){ 
				log.error("uploadDef ：上传失败：文件大小不能超过100M");
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
				baseTransferEntity.setDesc("上传失败：文件大小不能超过100M");
	            return baseTransferEntity;
	        }
		}
		
			knowledgeBaseService.addFileToSct(sctId, userId, remark, file);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("文件上传项目成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("创建安全项目异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;

	}

	/**
	 * 安全信息文件下载
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping("/service/sctDownload")
	@ResponseBody
	public BaseTransferEntity SctfileDownload(@RequestParam("id") int id, HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			List<Map<String, Object>> list = knowledgeBaseService.getSctFileInfoById(id);
			
			if (list.size() == 0 || !((Integer) list.get(0).get("del_flag") == 0)) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在");
				return baseTransferEntity;
			}

			String path = (String) list.get(0).get("fil_url");
			String file_name = (String) list.get(0).get("fil_nam");
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("path", path);
			map.put("file_name", file_name);
			
			File file = new File(path);
			if (!file.exists()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在，可能被非法删除");
				return baseTransferEntity;
			}

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(map);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("文件下载失败，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
		}
		return baseTransferEntity;
	}

	/**
	 * 使用安全文件ID删除某文件信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/removeSctFileById")
	@ResponseBody
	public BaseTransferEntity removeFileInSct(int id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			if (knowledgeBaseService.removeFileInSctById(id)) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("删除成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("文件删除失败，可能的原因为文件不存在");
			}
		} catch (Exception e) {
			log.error("文件删除失败，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			return baseTransferEntity;
		}
		return baseTransferEntity;

	}

	/**
	 * 更新安全信息
	 * @param id
	 * @param sct_typ_id
	 * @param sct_nam
	 * @param sct_dec
	 * @param use_id
	 * @param remark
	 * @return
	 */
	@RequestMapping("/service/updateSctInfo")
	@ResponseBody
	public BaseTransferEntity updateSct(int id, int sct_typ_id, String sct_nam, String sct_dec, int use_id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			boolean result = knowledgeBaseService.updateSctInfo(id, sct_typ_id, sct_nam, sct_dec, use_id, new Date());
			if (result) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("信息更新成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("信息更新失败");
			}
		} catch (Exception e) {
			log.error("信息更新失败删除失败，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			return baseTransferEntity;
		}
		return baseTransferEntity;

	}

	/**
	 * 移除安全信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/removeSct")
	@ResponseBody
	public BaseTransferEntity removeSctById(int id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			if (knowledgeBaseService.removeSctAndFileInSct(id)) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("安全项目删除成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("安全项目删除失败,请确保安全项目下的文件已经被删除");
			}
		} catch (Exception e) {
			log.error("安全项目删除异常，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 添加安全类型信息
	 * @param userId
	 * @param sctTypeName
	 * @param remark
	 * @return
	 */
	@RequestMapping("/service/addSctType")
	@ResponseBody
	public BaseTransferEntity addSctType(int userId, String sctTypeName, String remark) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			Map<String,Object> map = new HashMap<String, Object>();
			//类型名称
			map.put("sct_typ_nam", sctTypeName);
			List<Map<String,Object>> lstName = knowledgeBaseService.getSctTypeByName(map);
			if (lstName != null && !lstName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("类型名称重复，请重新填写！");
				return baseTransferEntity;
			}
			
			knowledgeBaseService.addSctType(userId, sctTypeName, new Date(), remark);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("增加类型成功");
			
		} catch (Exception e) {
			log.error("增加类型异常，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 获取安全类型信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/sctType")
	@ResponseBody
	public BaseTransferEntity getSctType(String id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			baseTransferEntity.setData(knowledgeBaseService.getSctType(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("获取成功");
		} catch (Exception e) {
			log.error("获取安全管理类型异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 使用安全类型获取安全列表
	 * @param info
	 * @param typeId
	 * @param sctId
	 * @return
	 */
	@RequestMapping("/service/getSct")
	@ResponseBody
	public BaseTransferEntity getSctByType(String info, String typeId ,String sctId,HttpServletRequest request, HttpServletResponse response) {
		int id = 0;
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {

			Pager page = new Pager();

			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			//模糊查询的内容  可以在controller 里 加% 放到mybatis处理  也可以直接在sql中处理
			if (info != null)
				info = "%" + info + "%";

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("info", info);
			map.put("typeId", typeId);
			map.put("sctId", sctId);
			
			
			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			Map<String, Object> couMap = knowledgeBaseService.getSctCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("cou").toString()));

			map.put("everyPage", page.getEveryPage());
			
			List<Map<String, Object>> lst = knowledgeBaseService.getSct(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());

			baseTransferEntity.setData(lst);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("获取成功");
		} catch (Exception e) {
			log.error("获取知识库异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 使用安全信息ID获取文件列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/service/fileInfoBySctId")
	@ResponseBody
	public BaseTransferEntity getFileInfoBySctId(HttpServletRequest request) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		try {
			String temp = request.getParameter("id");

			baseTransferEntity.setData(knowledgeBaseService.getFileInfoBySctId(temp));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc("获取成功");
		} catch (Exception e) {
			log.error("获取文件信息异常" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 移除安全类型信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/service/removeSctType")
	@ResponseBody
	public BaseTransferEntity removeSctType(int id) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			if (knowledgeBaseService.removeSctType(id)) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("安全项目类型删除成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("安全项目类型删除失败,请确保安全项目下的文件已经被删除");
			}
		} catch (Exception e) {
			log.error("安全项目删除异常，请联系管理员" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * 更新安全类型信息
	 * @param id
	 * @param sct_typ_nam
	 * @param use_id
	 * @param remark
	 * @return
	 */
	@RequestMapping("/service/updateSctTypeInfo")
	@ResponseBody
	public BaseTransferEntity updateSctTypeInfo(int id, String sct_typ_nam, int use_id, String remark) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			
			knowledgeBaseService.updateSctTypeInfo(id, sct_typ_nam, use_id, new Date(), remark);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setDesc("信息更新成功");
		
		} catch (Exception e) {
			
			log.error("信息更新失败删除失败，请联系管理员" + e.getMessage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			return baseTransferEntity;
		}
		return baseTransferEntity;
	}
	
}
