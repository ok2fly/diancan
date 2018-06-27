/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.dailyoffice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dao.dailyoffice.DailyOfficeDao;
import com.qinergy.dao.knowledgebase.KnowledgeBaseDao;
import com.qinergy.dao.utils.UtilsDao;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.UserInfDto;
import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.UserDto;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MD5;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.PropertiesUtil;
import com.qinergy.util.StringUtil;
import com.sun.xml.internal.bind.v2.runtime.Name;

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
public class DailyOfficeServiceImpl implements DailyOfficeService {
	private static Logger log = Logger.getLogger(DailyOfficeServiceImpl.class);
	@Autowired
	DailyOfficeDao dailyOfficeDao;
	@Autowired
	UtilsDao utilsDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean uploadFile(MultipartFile file, LinkedHashMap<String, Object> map, int created_id) {
		InputStream is = null;
		try {
			is = file.getInputStream();
			String name = file.getName();
			long size = file.getSize();
			String type = file.getContentType();
			//File goal = new File(MobileConfig.get("file.upload.path"), StringUtil.getFileNameByUUID(file.getOriginalFilename()));
			
			File goal = new File(PropertiesUtil.getProperty("file.upload.path"),StringUtil.getFileNameByUUID(file.getOriginalFilename()));
			
			
			
			FileUtils.copyInputStreamToFile(is, goal);
			UserDto user = new UserDto();
			user.setId(created_id);
			List<Map<String, Object>> list = utilsDao.getComInfByUseId(user);
			if (list.get(0) != null) {
				map.put("com_id", list.get(0).get("id"));
			} else {
				map.put("com_id", null);
			}
			map.put("file_path", goal.getPath());
			dailyOfficeDao.insertFile(map);
			return true;

		} catch (Exception e) {
			log.error("文件上传失败" + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {

			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public boolean downloadFile(HttpServletResponse response, int id, BaseTransferEntity baseTransferEntity) {

		List<LinkedHashMap<String, Object>> list = dailyOfficeDao.getFileById(id);
		if (list == null || list.isEmpty()) {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}


	@Override
	public List<LinkedHashMap<String, Object>> getFileById(int id) throws Exception {

		return dailyOfficeDao.getFileById(id);

	}

	
	
	@Override
	public int removeFile(int id) {
		return dailyOfficeDao.removeFile(id);
	}

	@Override
	public List<Map<String, Object>> getComsInfoByUserId(UserDto userDto) throws Exception {

		return utilsDao.getComInfByUseId(userDto);

	}

	@Override
	public List<LinkedHashMap<String, Object>> getComFileList(Integer com_id, String type, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("com_id", com_id);
		map.put("type", type);
		map.put("name", name);
		return dailyOfficeDao.getListByComsId(map);
	}

	@Override
	public List<Map<String, Object>> getAllComs() {
		// TODO Auto-generated method stub
		return dailyOfficeDao.getComsAll();
	}

	@Override
	public List<Map<String, Object>> getComs_Level_3_Of_com(CompanyDto companyDto) throws Exception {
		// TODO Auto-generated method stub
		return utilsDao.getFatComInfByComId(companyDto);
	}

	@Override
	public List<Map<String, Object>> getFileType(Map<String, Object> map) {

		return this.dailyOfficeDao.getFileType(map);
	}
	@Override
	public List<Map<String, Object>> selFileTypByName(Map<String, Object> map)throws Exception {
		
		return this.dailyOfficeDao.selFileTypByName(map);
	}

	@Override
	public int insertFileType(String fil_typ_nam, int crt_use_id, Date crt_tim, String remark) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fil_typ_nam", fil_typ_nam);
		map.put("crt_use_id", crt_use_id);
		map.put("crt_tim", crt_tim);
		map.put("remark", remark);

		return dailyOfficeDao.insertFilrType(map);
	}

	@Override
	public boolean updateFileTypeById(int id, String fil_typ_nam, int mod_use_id, String remark) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("fil_typ_nam", fil_typ_nam);
		map.put("mod_use_id", mod_use_id);
		map.put("remark", remark);
		map.put("mod_tim", new Date());
		return dailyOfficeDao.updateFileType(map) == 1;
	}

	@Override
	public boolean removeFileType(int id) {
		int count = dailyOfficeDao.getFileCountInType(id);
		if (count > 0)
			return false;
		return dailyOfficeDao.removeFileType(id) == 1;
	}

	/****** 员工、客户管理 **********/
	// TODO 修改信息 判断 role_id 是否为管理员
	@Override
	public void insertUserInfo(UserInfDto userInfDto) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("use_typ", userInfDto.getUse_typ());
		map.put("com_id", userInfDto.getCom_id());
		
		System.out.println(userInfDto.getDep_id().toString() );
		
		if(userInfDto.getDep_id() != null && !userInfDto.getDep_id().equals(" ")){
			
			map.put("dep_id", userInfDto.getDep_id());
		}else{
			map.put("dep_id",0);
		}
		
		map.put("pos_id", userInfDto.getPos_id());
		map.put("edu_id", userInfDto.getEdu_id());
		map.put("rol_id", userInfDto.getRol_id());
		map.put("use_sta", UserInfDto.USER_STAT_YES);
		map.put("acc_num", userInfDto.getAcc_num());
		
		if(userInfDto.getUse_pas() != null && !userInfDto.getUse_pas().isEmpty()){
			
			map.put("use_pas", StringUtil.md5Encrypt(userInfDto.getUse_pas(), "UTF-8"));
			
		}
		map.put("use_nam", userInfDto.getUse_nam());
		map.put("use_mob", userInfDto.getUse_mob());
		map.put("use_sex", userInfDto.getUse_sex());
		map.put("use_idc", userInfDto.getUse_idc());
		map.put("use_mal", userInfDto.getUse_mal());
		map.put("use_add", userInfDto.getUse_add());
		map.put("pic_url", userInfDto.getPic_url());
		map.put("use_maj", userInfDto.getUse_maj());
		map.put("pla_ori", userInfDto.getPla_ori());
		map.put("remark", userInfDto.getRemark());
		
		if (userInfDto.getTak_tim() != null && userInfDto.getTak_tim() != "") {
			map.put("tak_tim", new SimpleDateFormat("yyyy-MM-dd").parse(userInfDto.getTak_tim()));
		}
		map.put("crt_use_id", userInfDto.getCrt_use_id());
		map.put("crt_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		map.put("slt_opt_sta",userInfDto.getSlt_opt_sta());
		map.put("is_def_sta",userInfDto.getIs_def_sta());
		
		dailyOfficeDao.insertUserInfo(map);
	}

	@Override
	public void updateUserInfo(UserInfDto userInfDto) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", userInfDto.getId());
		map.put("use_typ", userInfDto.getUse_typ());
		map.put("com_id", userInfDto.getCom_id());
		map.put("dep_id", userInfDto.getDep_id() != null ? userInfDto.getDep_id() : 0);
		map.put("pos_id", userInfDto.getPos_id());
		map.put("edu_id", userInfDto.getEdu_id());
		map.put("rol_id", userInfDto.getRol_id());
		map.put("use_sta", userInfDto.getUse_sta());
		map.put("acc_num", userInfDto.getAcc_num());
		map.put("use_pas", userInfDto.getUse_pas());
		map.put("use_nam", userInfDto.getUse_nam());
		map.put("use_mob", userInfDto.getUse_mob());
		map.put("use_sex", userInfDto.getUse_sex());
		map.put("use_idc", userInfDto.getUse_idc());
		map.put("use_mal", userInfDto.getUse_mal());
		map.put("use_add", userInfDto.getUse_add());
		map.put("pic_url", userInfDto.getPic_url());
		map.put("use_maj", userInfDto.getUse_maj());
		map.put("pla_ori", userInfDto.getPla_ori());
		map.put("remark", userInfDto.getRemark());
		if (userInfDto.getTak_tim() != null && userInfDto.getTak_tim() != "") {
			map.put("tak_tim", new SimpleDateFormat("yyyy-MM-dd").parse(userInfDto.getTak_tim()));
		}
		map.put("mod_use_id", userInfDto.getMod_use_id());
		map.put("mod_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		map.put("slt_opt_sta",userInfDto.getSlt_opt_sta());
		map.put("is_def_sta",userInfDto.getIs_def_sta());

		dailyOfficeDao.updateUserInfo(map);
	}
	
	@Override
	public void updateUserScore(Map<String,Object> map) throws Exception {
		
		dailyOfficeDao.updateUserScore(map);
	}

	@Override
	public void updateUserDep(UserInfDto userInfDto) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", userInfDto.getId());
		map.put("dep_id", userInfDto.getDep_id());
		map.put("mod_use_id", userInfDto.getMod_use_id());
		map.put("mod_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		dailyOfficeDao.updateUserDep(map);
	}

	@Override
	public void resetPwd(UserInfDto userInfDto) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", userInfDto.getId());
		map.put("use_pas", userInfDto.getUse_pas());
		map.put("mod_use_id", userInfDto.getMod_use_id());
		map.put("mod_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		dailyOfficeDao.resetPwd(map);
	}

	@Override
	public void delUserInfo(Map<String, Object> map) throws Exception {
		dailyOfficeDao.delUserInfo(map);
	}

	@Override
	public void setAccStat(Integer id, Integer use_sta, String use_id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", id);
		map.put("mod_use_id", use_id);
		map.put("mod_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		// TODO 1:正常 2： 停用？
		if (use_sta == UserInfDto.USER_STAT_YES) {
			map.put("use_sta", UserInfDto.USER_STAT_NO);
		} else {
			map.put("use_sta", UserInfDto.USER_STAT_YES);
		}
		dailyOfficeDao.setAccStat(map);
	}

	@Override
	public List<Map<String, Object>> getUserInfById(Map<String, Object> map) throws Exception {
		return dailyOfficeDao.getUserInfById(map);
	}

	@Override
	public List<Map<String, Object>> getUserInfListByType(Map<String, Object> map) throws Exception {
		return dailyOfficeDao.getUserInfListByType(map);
	}

	@Override
	public int getUserListCount(Map<String, Object> map) throws Exception {
		int count = 0;
		List<Map<String, Object>> countList = dailyOfficeDao.getUserListCount(map);
		if (countList != null && countList.size() > 0) {
			for (Map<String, Object> countMap : countList) {
				count = Integer.parseInt(countMap.get("cou").toString());
			}
		}
		return count;
	}
	
	
	/**
	 * 根据  账号，用户姓名 查询   防止用户账号重复或姓名重复
	 */
	@Override
	public List<Map<String, Object>> getUserByNumAndNam(Map<String, Object> map) throws Exception {
		return dailyOfficeDao.getUserByNumAndNam(map);
	}

	/**
	 * app端 文件下载 需要返回的参数 
	 */
	@Override
	public List<Map<String, Object>> AppSelectFileById(Map<String, Object> map) throws Exception {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		UserDto user = new UserDto();
		user.setId(Integer.parseInt(map.get("created_id").toString()));
		List<Map<String, Object>> list = utilsDao.getComInfByUseId(user);
		if (list.get(0) != null) {
			map.put("com_id", list.get(0).get("id"));
		} else {
			map.put("com_id", null);
		}
		
		List<Map<String,Object>> lstMaps =  dailyOfficeDao.AppSelectFileById(map);
		
		resultMap.put("id", lstMaps.get(0).get("id").toString());
		resultMap.put("file_type", lstMaps.get(0).get("fil_typ").toString());
		resultMap.put("fil_nam", lstMaps.get(0).get("fil_nam").toString());
		resultMap.put("fil_url", lstMaps.get(0).get("fil_url").toString());
		
		String filePath = lstMaps.get(0).get("fil_url").toString();
		
		int index = filePath.lastIndexOf("\\");
		
		String name = filePath.substring(index+1);
		
		resultMap.put("newName",name);
		
		String path = PropertiesUtil.getProperty("file.prefix") + name;
		
		resultMap.put("path",path);
		List<Map<String, Object>> resuList = new ArrayList<Map<String,Object>>();
		resuList.add(resultMap);
		return resuList;
		
	}
	

}
