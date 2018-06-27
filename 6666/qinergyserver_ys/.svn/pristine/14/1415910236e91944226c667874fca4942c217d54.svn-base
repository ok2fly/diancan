/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.operations.training;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dao.operations.training.TrainingManageDao;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.assetmanagement.AssetsDto;
import com.qinergy.dto.assetmanagement.DefectDto;
import com.qinergy.dto.operations.TrainingManagerDto;
import com.qinergy.dto.operations.TrainingManagerPlanDto;
import com.qinergy.dto.operations.TrainingTypeDto;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.PropertiesUtil;
import com.qinergy.util.StringUtil;

/**
 * @desc: 培训管理 / 培训计划 实现类
 * @author: Qist
 * @date: 2017年11月28日
 */
@Service
public class TrainingManageServiceImpl implements TrainingManageService {

	@Autowired
	TrainingManageDao trainingManageDao;

	@Override
	public boolean insTrainingTyp(TrainingTypeDto trainingTypeDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("typ_nam", trainingTypeDto.getTyp_nam());
		paramMap.put("typ_ide", trainingTypeDto.getTyp_ide());
		paramMap.put("remark", trainingTypeDto.getRemark());
		paramMap.put("crt_use_id", trainingTypeDto.getCrt_use_id());
		paramMap.put("del_flag", TrainingTypeDto.DEL_FLAG_NO);
		paramMap.put("crt_tim", DateUtil.getcurrentTime());

		return trainingManageDao.insTrainingTyp(paramMap);
	}
	
	
	@Override
	public List<Map<String, Object>> getTrainingTypByName(Map<String, Object> map) throws Exception {

		return trainingManageDao.getTrainingTypByName(map);
	}

	
	

	@Override
	public boolean updTrainingTyp(TrainingTypeDto trainingTypeDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("id", trainingTypeDto.getId());
		paramMap.put("typ_nam", trainingTypeDto.getTyp_nam());
		paramMap.put("typ_ide", trainingTypeDto.getTyp_ide());
		paramMap.put("remark", trainingTypeDto.getRemark());
		paramMap.put("mod_use_id", trainingTypeDto.getMod_use_id());
		paramMap.put("del_flag", TrainingTypeDto.DEL_FLAG_NO);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return trainingManageDao.updTrainingTyp(paramMap);
	}

	@Override
	public boolean delTrainingTyp(String id, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("id", id);
		paramMap.put("mod_use_id", use_id);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		paramMap.put("del_flag", TrainingTypeDto.DEL_FLAG_YES);

		return trainingManageDao.delTrainingTyp(paramMap);
	}

	@Override
	public Map<String, Object> getTrainingTypById(String id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("del_flag", TrainingTypeDto.DEL_FLAG_NO);

		return trainingManageDao.getTrainingTypById(paramMap);
	}

	@Override
	public List<Map<String, Object>> getTrainingTypList() throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("del_flag", TrainingTypeDto.DEL_FLAG_NO);

		return trainingManageDao.getTrainingTypList(paramMap);
	}

	// 上传文件
	@Override
	public boolean uploadTrainFile(MultipartFile file, Map<String, Object> map) throws Exception {
		InputStream is = null;
		try {
			is = file.getInputStream();
			String fileName = file.getName();
			long size = file.getSize();
			String type = file.getContentType();
			//File goal = new File(MobileConfig.get("file.global.location"),StringUtil.getFileNameByUUID(file.getOriginalFilename()));
		
			File goal = new File(PropertiesUtil.getProperty("file.upload.path"),StringUtil.getFileNameByUUID(file.getOriginalFilename()));
			

			
			FileUtils.copyInputStreamToFile(is, goal);

			map.put("file_url", goal.getPath());
			map.put("del_flag", DefectDto.DEL_FLAG_NO);
			
			//判断文件类型
			String[] suffix = {"JPEG","GIF","JPG","PNG","BMP","PIC"};
	        String picSuffix = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
	        
	        boolean contains = Arrays.asList(suffix).contains(picSuffix);
	        if(contains){//1:文件 2:图片
	        	map.put("file_typ", 2);
	        }else{
	        	map.put("file_typ", 1);
	        }
			
			trainingManageDao.uploadTrainFile(map);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 下载
	@Override
	public boolean downloadTrainFile(HttpServletResponse response, int id, BaseTransferEntity baseTransferEntity)
			throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);

		Map<String, Object> fileMap = trainingManageDao.getFileById(paramMap);

		if (fileMap.isEmpty() || "1".equals(fileMap.get("del_flag"))) {
			baseTransferEntity.setResultcode(MobileConfig.get("code.global.failed"));
			baseTransferEntity.setDesc("请求的文件不存在");
			return false;
		}

		if (fileMap != null && !fileMap.isEmpty() && "0".equals(fileMap.get("del_flag").toString())) {

			String file_nam = (String) fileMap.get("fil_nam");
			String file_url = (String) fileMap.get("fil_url");
			File file = new File(file_url);
			if (!file.exists()) {
				baseTransferEntity.setResultcode(MobileConfig.get("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在，可能被非法删除");
				return false;
			}

			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/force-download");// 设置强制下载不打开
			try {
				response.addHeader("Content-Disposition",
						"attachment;fileName=" + java.net.URLEncoder.encode(file_nam, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
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
		return false;
	}

	@Override
	public boolean delTrainFile(String id, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("id", id);
		paramMap.put("mod_use_id", use_id);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_YES);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return trainingManageDao.delTrainFile(paramMap);
	}

	@Override
	public Map<String, Object> getFileById(String id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);

		return trainingManageDao.getFileById(paramMap);
	}

	@Override
	public List<Map<String, Object>> getFileListByTrainNum(String train_num) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("train_num", train_num);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);

		return trainingManageDao.getFileListByTrainNum(paramMap);
	}

	
	
	
	
	
	
	@Override
	public boolean insTraining(TrainingManagerDto managerDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("tra_typ_id", managerDto.getTra_typ_id());
		paramMap.put("tra_cont", managerDto.getTra_cont());
		paramMap.put("tra_speaker", managerDto.getTra_speaker());
		paramMap.put("tra_target", managerDto.getTra_target());
		paramMap.put("begin_tim", managerDto.getBegin_tim());
		paramMap.put("finish_tim", managerDto.getFinish_tim());
		paramMap.put("tra_place", managerDto.getTra_place());
		paramMap.put("remark", managerDto.getRemark());
		paramMap.put("sub_com_id", managerDto.getSub_com_id());
		paramMap.put("crt_use_id", managerDto.getCrt_use_id());
		// 后台处理的字段
		paramMap.put("tra_num", StringUtil.genTrainNum()); // PXJH_ + yyyyMMdd + 4位随机数
		paramMap.put("tra_sta", TrainingManagerDto.TRA_STA_NOT_BEGIN); // 0:未开始 1:进行中 2:已结束
		paramMap.put("del_flag", TrainingManagerDto.DEL_FLAG_NO);
		paramMap.put("crt_tim", DateUtil.getcurrentTime());

		return trainingManageDao.insTraining (paramMap);
	}

	@Override
	public boolean updTraining (TrainingManagerDto managerDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("id", managerDto.getId());
		paramMap.put("tra_typ_id", managerDto.getTra_typ_id());
		paramMap.put("tra_cont", managerDto.getTra_cont());
		paramMap.put("tra_speaker", managerDto.getTra_speaker());
		paramMap.put("tra_target", managerDto.getTra_target());
		paramMap.put("begin_tim", managerDto.getBegin_tim());
		paramMap.put("finish_tim", managerDto.getFinish_tim());
		paramMap.put("tra_place", managerDto.getTra_place());
		paramMap.put("remark", managerDto.getRemark());
		paramMap.put("mod_use_id", managerDto.getMod_use_id());
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		paramMap.put("sub_com_id", managerDto.getSub_com_id());

//		paramMap.put("sub_com_id", managerDto.getSub_com_id());
		// paramMap.put("tra_num", managerDto.getTra_num());
		// paramMap.put("sub_com_id", managerDto.getSub_com_id());
		// paramMap.put("is_exec", TrainingManagerPlanDto.TRA_PLAN_NOT_EXEC);  
		// 是否执行（0:待执行 1:已执行）
		// paramMap.put("del_flag", TrainingManagerDto.DEL_FLAG_NO);

		return trainingManageDao.updTraining (paramMap);

	}

	@Override
	public boolean executeTraining (String id, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("mod_use_id", use_id);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		paramMap.put("tra_sta", TrainingManagerDto.TRA_STA_STARTING);//TODO  0:未开始 1:进行中 2:已结束
		
		return trainingManageDao.executeTraining(paramMap);
	}

	@Override
	public boolean delTrainingById(String id, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("mod_use_id", use_id);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		paramMap.put("del_flag", TrainingManagerDto.DEL_FLAG_YES);

		return trainingManageDao.delTrainingById(paramMap);
	}

	@Override
	public boolean delBatchTrainingById(String ids, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ids", ids.split(","));
		paramMap.put("mod_use_id", use_id);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		paramMap.put("del_flag", TrainingManagerDto.DEL_FLAG_YES);

		return trainingManageDao.delBatchTrainingById(paramMap);
	}

	@Override
	public Map<String, Object> getTrainingById(String id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("del_flag", TrainingManagerDto.DEL_FLAG_NO);
		
		return trainingManageDao.getTrainingById(paramMap);
	}

	@Override
	public List<Map<String, Object>> getTrainingList(Map<String, Object> map) throws Exception {

		return trainingManageDao.getTrainingList(map);
	}

	@Override
	public int getTrainingListCount(Map<String, Object> map) throws Exception {

		Long count = 0l;
		Map<String, Object> dataCount = trainingManageDao.getTrainingListCount(map);
		if (dataCount != null && !dataCount.isEmpty()) {
			count = (Long) dataCount.get("cou");
		}
		return count.intValue();
	}

	
	
	
	
	
	
	/////////////////计划//////////////////
	@Override
	public boolean insTrainingPlan(TrainingManagerPlanDto managerPlanDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("tra_typ_id", managerPlanDto.getTra_typ_id());
		paramMap.put("tra_cont", managerPlanDto.getTra_cont());
		paramMap.put("tra_speaker", managerPlanDto.getTra_speaker());
		paramMap.put("tra_target", managerPlanDto.getTra_target());
		paramMap.put("begin_tim", managerPlanDto.getBegin_tim());
		paramMap.put("finish_tim", managerPlanDto.getFinish_tim());
		paramMap.put("tra_place", managerPlanDto.getTra_place());
		paramMap.put("remark", managerPlanDto.getRemark());
		paramMap.put("sub_com_id", managerPlanDto.getSub_com_id());
		paramMap.put("crt_use_id", managerPlanDto.getCrt_use_id());
		paramMap.put("crt_tim", DateUtil.getcurrentTime());
		// 后台处理的字段
		paramMap.put("tra_num", StringUtil.genTrainNum()); // PX_ + yyyyMMdd + 4位随机数
		paramMap.put("plan_num", StringUtil.genTrainPlanNum()); // PXJH_ + yyyyMMdd + 4位随机数
		paramMap.put("is_exec", TrainingManagerPlanDto.TRA_PLAN_NOT_EXEC); // （0:待执行 1:已执行）
		paramMap.put("del_flag", TrainingManagerPlanDto.DEL_FLAG_NO);
		paramMap.put("crt_tim", DateUtil.getcurrentTime());
		
		return trainingManageDao.insTrainingPlan(paramMap);
	}
	
	
	
	@Override
	public boolean updTrainingPlan(TrainingManagerPlanDto managerPlanDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", managerPlanDto.getId());
		paramMap.put("tra_typ_id", managerPlanDto.getTra_typ_id());
		paramMap.put("tra_cont", managerPlanDto.getTra_cont());
		paramMap.put("tra_speaker", managerPlanDto.getTra_speaker());
		paramMap.put("tra_target", managerPlanDto.getTra_target());
		paramMap.put("begin_tim", managerPlanDto.getBegin_tim());
		paramMap.put("finish_tim", managerPlanDto.getFinish_tim());
		paramMap.put("tra_place", managerPlanDto.getTra_place());
		paramMap.put("remark", managerPlanDto.getRemark());
		paramMap.put("sub_com_id", managerPlanDto.getSub_com_id());
		paramMap.put("mod_use_id", managerPlanDto.getMod_use_id());
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

//		paramMap.put("tra_num", StringUtil.genTrainNum()); // PX_ + yyyyMMdd + 4位随机数
//		paramMap.put("plan_num", StringUtil.genTrainPlanNum()); // PXJH_ + yyyyMMdd + 4位随机数
//		paramMap.put("is_exec", TrainingManagerPlanDto.TRA_PLAN_NOT_EXEC); // （0:待执行 1:已执行）
//		paramMap.put("del_flag", TrainingManagerPlanDto.DEL_FLAG_NO);
//		paramMap.put("crt_tim", DateUtil.getcurrentTime());
		
		return trainingManageDao.updTrainingPlan(paramMap);

	}
	
	
	@Override
	public boolean delTrainingPlanById(String id, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("mod_use_id", use_id);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		paramMap.put("del_flag", TrainingManagerPlanDto.DEL_FLAG_YES);

		return trainingManageDao.delTrainingPlanById(paramMap);
	}

	@Override
	public boolean delBatchTrainingPlanById(String ids, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ids", ids.split(","));
		paramMap.put("mod_use_id", use_id);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		paramMap.put("del_flag", TrainingManagerPlanDto.DEL_FLAG_YES);

		return trainingManageDao.delBatchTrainingPlanById(paramMap);
	}

	@Override
	public Map<String, Object> getTrainingPlanById(String id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("del_flag", TrainingManagerPlanDto.DEL_FLAG_NO);
		
		return trainingManageDao.getTrainingPlanById(paramMap);
	}
	
	
	@Override
	public List<Map<String, Object>> getTrainingPlanList(Map<String, Object> map) throws Exception {

		return trainingManageDao.getTrainingPlanList(map);
	}

	@Override
	public int getTrainingPlanListCount(Map<String, Object> map) throws Exception {

		Long count = 0l;
		Map<String, Object> dataCount = trainingManageDao.getTrainingPlanListCount(map);
		if (dataCount != null && !dataCount.isEmpty()) {
			count = (Long) dataCount.get("cou");
		}
		return count.intValue();
	}


}
