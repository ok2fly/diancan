/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.knowledgebase;

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

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dao.knowledgebase.KnowledgeBaseDao;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.StringUtil;

/**
 * TODO
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

@Service
public class KnowledgeBaseServiceImpl implements KnowledgeBaseService {

	private static Logger log = Logger.getLogger(KnowledgeBaseService.class);
	@Autowired
	KnowledgeBaseDao knowledgeBaseDao;

	@Override
	@Transactional
	public int insertKnw(int knw_typ_id, String knw_nam, String knw_dec, int use_id, Date crt_tim) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("knw_typ_id", knw_typ_id);
		map.put("knw_nam", knw_nam);
		map.put("knw_dec", knw_dec);
		map.put("use_id", use_id);
		map.put("crt_tim", crt_tim);
		knowledgeBaseDao.insetKnowLedge(map);
		/*if (file != null) {
			int knw_id = (Integer) knowledgeBaseDao.getIdByInfo(map).get("id");
			for (MultipartFile multipartFile : file) {
				if(multipartFile.isEmpty()) continue;
				Map<String, Object> fileInfo = new HashMap<String, Object>();

				File goal = new File(MobileConfig.get("file.global.location"),
						StringUtil.getFileNameByUUID(multipartFile.getOriginalFilename()));

				FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), goal);

				fileInfo.put("knw_bas_id", knw_id);
				fileInfo.put("fil_nam", multipartFile.getOriginalFilename());
				fileInfo.put("fil_url", goal.getPath());
				fileInfo.put("use_id", use_id);
				fileInfo.put("crt_tim", crt_tim);
				fileInfo.put("remark", remark);
				fileInfo.put("flag", 0);
				knowledgeBaseDao.insertFile(fileInfo);

			}
		}*/
		return 1;
	}

	@Override
	public void addFileToKnw(int knwId, int userId, String remark, MultipartFile[] file) throws IOException {
		for (MultipartFile multipartFile : file) {
			Map<String, Object> fileInfo = new HashMap<String, Object>();

			File goal = new File(MobileConfig.get("file.global.location"),
					StringUtil.getFileNameByUUID(multipartFile.getOriginalFilename()));

			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), goal);

			fileInfo.put("knw_bas_id", knwId);
			fileInfo.put("fil_nam", multipartFile.getOriginalFilename());
			fileInfo.put("fil_url", goal.getPath());
			fileInfo.put("use_id", userId);
			fileInfo.put("crt_tim", new Date());
			fileInfo.put("remark", remark);
			fileInfo.put("flag", 0);
			knowledgeBaseDao.insertFile(fileInfo);

		}
	}

	@Override
	public int update(int knw_id, int knw_typ_id, String knw_nam, String knw_dec, int use_id, Date mod_tim) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("knw_id", knw_id);
		map.put("knw_typ_id", knw_typ_id);
		map.put("knw_nam", knw_nam);
		map.put("knw_dec", knw_dec);
		map.put("use_id", use_id);
		map.put("mod_tim", mod_tim);
		map.put("flag", 1);

		return this.knowledgeBaseDao.updateKnw(map);
	}
	

	@Override
	public boolean downloadKnwFile(BaseTransferEntity baseTransferEntity, int id, HttpServletResponse response) {
		List<Map<String, Object>> list = knowledgeBaseDao.getFileInfoById(id);
		
		
		if (list.size() == 0 || !((Integer) list.get(0).get("del_flag") == 0)) {
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
			baseTransferEntity.setDesc("请求的文件不存在");
			return false;
		}

		String path = (String) list.get(0).get("fil_url");
		String file_name = (String) list.get(0).get("fil_nam");
		File file = new File(path);
		if (!file.exists()) {
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
			baseTransferEntity.setDesc("请求的文件不存在，可能被非法删除");
			
			return false;
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/force-download");// 设置强制下载不打开
		try {
			response.addHeader("Content-Disposition","attachment;fileName=" + java.net.URLEncoder.encode(file_name, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			log.error("转码失败" + e.getMessage());
			e.printStackTrace();
		} // 设置文件名
		byte[] buffer = new byte[1024];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			OutputStream os = response.getOutputStream();
			int i = bis.read(buffer);
			while (i != -1) {
				os.write(buffer, 0, i);
				i = bis.read(buffer);
			}
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
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

	@Override
	public boolean removeFileById(int id) {
		return knowledgeBaseDao.removeFileById(id) == 1;
	}

	@Transactional
	@Override
	public boolean removeKnw(int id) {
		int size = knowledgeBaseDao.getFileInfoByKnw(id).size();
		if (size != 0)
			return false;
		int is = knowledgeBaseDao.removeKnw(id);
		return is == 1;
	}

	@Override
	public boolean removeKnwType(int id) {
		int count = this.knowledgeBaseDao.getKnwCountByTypeId(id);
		if (count > 0)
			return false;
		return this.knowledgeBaseDao.removeKnwType(id) == 1;
	}

	@Override
	public boolean createKnwType(String knw_typ_nam, String remark, int use_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("knw_typ_nam", knw_typ_nam);
		map.put("crt_tim", new Date());
		map.put("remark", remark);
		map.put("crt_use_id", use_id);
		return knowledgeBaseDao.insertKnwType(map) == 1;
	}

	@Override
	public List<Map<String, Object>> getKnwTypeByName(Map<String, Object> map) {
		return knowledgeBaseDao.getKnwTypeByName(map);
	}
	@Override
	public List<Map<String, Object>> getKnwTypeList(String id) {
		return knowledgeBaseDao.getKnwType(id);
	}

	@Override
	public List<Map<String, Object>> getKnwByType(Map<String,Object> map) {
		Map<String, Object> mapNew = new HashMap<String, Object>();
		/*mapNew.put("id", id);
		mapNew.put("info", info);*/
		return knowledgeBaseDao.getKnwByType(map);
	}
	
	@Override
	public Map<String, Object> getKnwByTypeCou(Map<String,Object> map) {
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("info", info);*/
		List<Map<String, Object>> retLst = knowledgeBaseDao.getKnwByTypeCou(map);

		if (retLst != null && retLst.size() > 0) {

			for (Map<String, Object> retMap : retLst) {

				return retMap;
			}
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getFileInfoByKnw(int id) {
		return knowledgeBaseDao.getFileInfoByKnw(id);
	}

	@Override
	public boolean updateKnwTypeInfo(int id, String knw_typ_nam, int mod_use_id, Date mod_tim, String remark) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("knw_typ_nam", knw_typ_nam);
		map.put("mod_use_id", mod_use_id);
		map.put("mod_tim", mod_tim);
		map.put("remark", remark);
		return knowledgeBaseDao.updateKnwTypeInfo(map) == 1;
	}

	@Override
	public Map<String, Object> getKnwInfoById(int id) {
		return knowledgeBaseDao.getKnwInfoById(id);
	}

	// 以下为安全管理部分
	@Transactional
	@Override
	public int insertSct(int sct_typ_id, String sct_nam, String sct_dec, int use_id, Date crt_tim) throws IOException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sct_typ_id", sct_typ_id);
		map.put("sct_nam", sct_nam);
		map.put("sct_dec", sct_dec);
		map.put("use_id", use_id);
		map.put("crt_tim", crt_tim);

		return knowledgeBaseDao.insertSct(map);

	}

	@Override
	public void addFileToSct(int sctId, int userId, String remark, MultipartFile[] file) throws IOException {
		for (MultipartFile multipartFile : file) {
			Map<String, Object> fileInfo = new HashMap<String, Object>();

			File goal = new File(MobileConfig.get("file.global.location"),
					StringUtil.getFileNameByUUID(multipartFile.getOriginalFilename()));

			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), goal);

			fileInfo.put("sct_id", sctId);
			fileInfo.put("fil_nam", multipartFile.getOriginalFilename());
			fileInfo.put("fil_url", goal.getPath());
			fileInfo.put("use_id", userId);
			fileInfo.put("crt_tim", new Date());
			fileInfo.put("remark", remark);
			fileInfo.put("flag", 0);
			knowledgeBaseDao.insertSctFile(fileInfo);

		}
	}
	@Override
	public List<Map<String, Object>> getFileInfoById(int id){
			return knowledgeBaseDao.getFileInfoById(id);
			
	}
	@Override
	public List<Map<String, Object>> getSctFileInfoById(int id){
		return knowledgeBaseDao.getSctFileInfoById(id);
		
	}

	@Override
	public boolean downloadSctFile(BaseTransferEntity baseTransferEntity, int id, HttpServletResponse response) {

		List<Map<String, Object>> list = knowledgeBaseDao.getSctFileInfoById(id);
		
		if (list.size() == 0 || !((Integer) list.get(0).get("del_flag") == 0)) {
			baseTransferEntity.setResultcode(MobileConfig.get("code.global.failed"));
			baseTransferEntity.setDesc("请求的文件不存在");
			return false;
		}

		String path = (String) list.get(0).get("fil_url");
		String file_name = (String) list.get(0).get("fil_nam");
		File file = new File(path);
		if (!file.exists()) {
			baseTransferEntity.setResultcode(MobileConfig.get("code.global.failed"));
			baseTransferEntity.setDesc("请求的文件不存在，可能被非法删除");
			return false;
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/force-download");// 设置强制下载不打开
		try {
			response.addHeader("Content-Disposition",
					"attachment;fileName=" + java.net.URLEncoder.encode(file_name, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			log.error("转码失败" + e.getMessage());
			e.printStackTrace();
		} // 设置文件名
		byte[] buffer = new byte[1024];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			OutputStream os = response.getOutputStream();
			int i = bis.read(buffer);
			while (i != -1) {
				os.write(buffer, 0, i);
				i = bis.read(buffer);
			}
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
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

	@Override
	public boolean removeFileInSctById(int id) {
		return knowledgeBaseDao.removeFileInSctById(id) == 1;
	}

	@Override
	public boolean updateSctInfo(int id, int sct_typ_id, String sct_nam, String sct_dec, int use_id, Date mod_tim) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("sct_typ_id", sct_typ_id);
		map.put("sct_nam", sct_nam);
		map.put("sct_dec", sct_dec);
		map.put("use_id", use_id);
		map.put("mod_tim", mod_tim);
		return knowledgeBaseDao.updateSctInfo(map) == 1;
	}

	@Override
	public boolean removeSctAndFileInSct(int id) {
		int count = knowledgeBaseDao.getSctCountBySctId(id);
		if ((Integer) count > 0){
			return false;
		}
		int is = knowledgeBaseDao.reomveSctInfoById(id);
		return is == 1;
	}

	@Override
	public boolean addSctType(int useId, String sct_typ_nam, Date crt_tim, String remark) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("crt_use_id", useId);
		map.put("sct_typ_nam", sct_typ_nam);
		map.put("crt_tim", crt_tim);
		map.put("remark", remark);
		return this.knowledgeBaseDao.insertSctType(map) == 1;
	}
	
	@Override
	public List<Map<String, Object>> getSctTypeByName(Map<String,Object> map) {
		return knowledgeBaseDao.getSctTypeByName(map);
	}

	@Override
	public List<Map<String, Object>> getSctType(String id) {
		return knowledgeBaseDao.getSctType(id);
	}

	@Override
	public List<Map<String, Object>> getSct(Map<String,Object> map) {
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", info);
		map.put("id", typeId);
		map.put("sct_id", sctId);*/
		return knowledgeBaseDao.getSctByTypeOrName(map);
	}

	@Override
	public Map<String, Object> getSctCou(Map<String,Object> map) {
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", info);
		map.put("id", typeId);
		map.put("sct_id", sctId);*/
		List<Map<String, Object>> retLst = knowledgeBaseDao.getSctByTypeOrNameCou(map);

		if (retLst != null && retLst.size() > 0) {

			for (Map<String, Object> retMap : retLst) {

				return retMap;
			}
		}
		return null;

	}

	@Override
	public List<Map<String, Object>> getFileInfoBySctId(String sct_id) {
		return knowledgeBaseDao.getFileInfoBySctId(sct_id);
	}

	@Override
	public boolean removeSctType(int id) {
		int count = knowledgeBaseDao.getSctCountByType(id);
		if (count > 0)
			return false;
		return knowledgeBaseDao.RemoveSctType(id) == 1;
	}

	@Override
	public boolean updateSctTypeInfo(int id, String sct_typ_nam, int mod_use_id, Date mod_tim, String remark) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("sct_typ_nam", sct_typ_nam);
		map.put("mod_use_id", mod_use_id);
		map.put("mod_tim", mod_tim);
		map.put("remark", remark);
		return knowledgeBaseDao.updateSctTypeInfo(map) == 1;
	}

}
