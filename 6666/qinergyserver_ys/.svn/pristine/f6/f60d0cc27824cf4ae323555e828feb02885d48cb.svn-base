package com.qinergy.service.assetmanagement;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dao.assetmanagement.AssetsManagementDao;
import com.qinergy.dao.utils.UtilsDao;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.assetmanagement.AssetsDto;
import com.qinergy.dto.assetmanagement.AssetsPurPlanDto;
import com.qinergy.dto.assetmanagement.AssetsTypeDto;
import com.qinergy.dto.assetmanagement.DefectDto;
import com.qinergy.dto.assetmanagement.DefectTypeDto;
import com.qinergy.dto.operations.TrainingManagerFileDto;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.StringUtil;

/**
 * @desc: 资产管理 service 实现
 * @author: Qist
 * @date: 2017年11月8日
 */
@Service
public class AssetsManagementServiceImpl implements AssetsManagementService {

	@Autowired
	AssetsManagementDao assetManagementDao;
	
	@Autowired
	UtilsDao utilsDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public boolean insAssetsTyp(AssetsTypeDto assetsTypeDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		if (assetsTypeDto != null) {
			paramMap.put("typ_nam", assetsTypeDto.getTyp_nam());
			paramMap.put("typ_ide", assetsTypeDto.getTyp_ide());
			paramMap.put("remark", assetsTypeDto.getRemark());
			paramMap.put("del_flag", AssetsTypeDto.DEL_FLAG_NO);
			paramMap.put("ass_typ_sort", assetsTypeDto.getAss_typ_sort());
			paramMap.put("crt_use_id", assetsTypeDto.getCrt_use_id());
			paramMap.put("crt_tim", DateUtil.getcurrentTime());
		}
		
		boolean retSta = assetManagementDao.insAssetsTyp(paramMap);
		
		Map<String, Object> logMap = new HashMap<String, Object>();
		// 操作人ID
		logMap.put("use_id", assetsTypeDto.getCrt_use_id());
		// 操作类型
		logMap.put("opt_typ", "数据添加");
		// 操作时间
		logMap.put("opt_tim", DateUtil.getcurrentTime());
		// 操作功能
		logMap.put("opt_fut", "添加资产类型");
		
		// 操作内容
		logMap.put("opt_ctn", paramMap.toString());
		// 是否操作成功（0为不成功，1为成功）
		logMap.put("is_suc", 1);
		
		utilsDao.insertOptLogInf(logMap);
		
		return retSta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Map<String, Object>> getAssetsTypByName(Map<String, Object> map) throws Exception {

		return assetManagementDao.getAssetsTypByName(map);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public boolean updAssetsTyp(AssetsTypeDto assetsTypeDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		if (assetsTypeDto != null) {
			paramMap.put("id", assetsTypeDto.getId());
			paramMap.put("typ_nam", assetsTypeDto.getTyp_nam());
			paramMap.put("typ_ide", assetsTypeDto.getTyp_ide());
			paramMap.put("remark", assetsTypeDto.getRemark());
			paramMap.put("ass_typ_sort", assetsTypeDto.getAss_typ_sort());
//			paramMap.put("ass_typ_sort", 1);
			paramMap.put("mod_use_id", assetsTypeDto.getMod_use_id());
			paramMap.put("mod_tim", DateUtil.getcurrentTime());
		}
		
		boolean retSta = assetManagementDao.updAssetsTyp(paramMap);
		
		Map<String, Object> logMap = new HashMap<String, Object>();
		// 操作人ID
		logMap.put("use_id", assetsTypeDto.getMod_use_id());
		// 操作类型
		logMap.put("opt_typ", "数据修改");
		// 操作时间
		logMap.put("opt_tim", DateUtil.getcurrentTime());
		// 操作功能
		logMap.put("opt_fut", "修改资产类型");
		// 操作内容
		logMap.put("opt_ctn", paramMap.toString());
		// 是否操作成功（0为不成功，1为成功）
		logMap.put("is_suc", 1);
		
		utilsDao.insertOptLogInf(logMap);
		
		return retSta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public boolean delAssetsTyp(String id, String mod_use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("id", id);
		paramMap.put("mod_use_id", mod_use_id);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		
		boolean retSta = assetManagementDao.delAssetsTyp(paramMap);
		
		Map<String, Object> logMap = new HashMap<String, Object>();
		// 操作人ID
		logMap.put("use_id", mod_use_id);
		// 操作类型
		logMap.put("opt_typ", "数据删除");
		// 操作时间
		logMap.put("opt_tim", DateUtil.getcurrentTime());
		// 操作功能
		logMap.put("opt_fut", "删除资产类型");
		// 操作内容
		logMap.put("opt_ctn", paramMap.toString());
		// 是否操作成功（0为不成功，1为成功）
		logMap.put("is_suc", 1);
		
		utilsDao.insertOptLogInf(logMap);

		return retSta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getAssetsTypById(String id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);

		return assetManagementDao.getAssetsTypById(paramMap);
	}

	@Override
	public List<Map<String, Object>> getAssetsTypList() throws Exception {

		return assetManagementDao.getAssetsTypList();
	}

	// ////////////////////////////////////资产/////////////////////////////////////////////

	@Override
	public List<Map<String, Object>> getAssetsListByTyp(Map<String, Object> map) throws Exception {

		List<Map<String, Object>> assetsList = assetManagementDao.getAssetsListByTyp(map);
		if (assetsList != null && assetsList.size() > 0) {
			for (Map<String, Object> assetsMap : assetsList) {
				if (assetsMap != null && !assetsMap.isEmpty()) {

					Integer ala_num = Integer.valueOf(assetsMap.get("ala_num").toString()); // 库存告警数量
					BigDecimal stock_num = (BigDecimal) assetsMap.get("stock_num"); // 库存数量
					// BigDecimal 比较大小返回int： -1表示小于，0是等于，1是大于
					boolean flag = stock_num.compareTo(new BigDecimal(ala_num)) == -1
							|| stock_num.compareTo(new BigDecimal(ala_num)) == 0;
					assetsMap.put("is_alam", flag);
				}
			}
		}

		return assetsList;
	}

	@Override
	public Integer getAssetsListCount(Map<String, Object> map) throws Exception {
//		int count = 0l;
		int count = 0;
		List<Map<String, Object>> assetsCount = assetManagementDao.getAssetsListCount(map);
		if (assetsCount != null && !assetsCount.isEmpty()) {
//			count = (Long) assetsCount.get(0).get("he");
			count = assetsCount.size();
		}
		return count;
	}

	@Override
	@Transactional
	public boolean insAssets(Map<String, Object> map) throws Exception {

		return assetManagementDao.insAssets(map);
	}

	@Override
	@Transactional
	public boolean insAssets(AssetsDto assetsDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("ass_nam", assetsDto.getAss_nam());
		paramMap.put("ass_num", assetsDto.getAss_num());
		paramMap.put("ass_typ_id", assetsDto.getAss_typ_id());
		paramMap.put("pro_tim", assetsDto.getPro_tim());
		paramMap.put("pur_tim", assetsDto.getPur_tim());
		paramMap.put("remark", assetsDto.getRemark());
		paramMap.put("equ_sor", assetsDto.getEqu_sor());
		paramMap.put("app_mod_id", assetsDto.getApp_mod_id());
		paramMap.put("man_id", assetsDto.getMan_id());
		paramMap.put("unit", assetsDto.getUnit());
		paramMap.put("price", assetsDto.getPrice());
		paramMap.put("sub_com_id", assetsDto.getSub_com_id());
		paramMap.put("siz", assetsDto.getSiz());
//		paramMap.put("siz",map.get("size_lon")+"*"+map.get("size_wid")+"*"+map.get("size_hig"));
		paramMap.put("weight", assetsDto.getWeight());
		paramMap.put("inp_elc", assetsDto.getInp_elc());
		paramMap.put("inp_vol", assetsDto.getInp_vol());
		paramMap.put("rtd_pow", assetsDto.getRtd_pow());
		paramMap.put("out_elc", assetsDto.getOut_elc());
		paramMap.put("out_vol", assetsDto.getOut_vol());
		paramMap.put("work_temp", assetsDto.getWork_temp());
		paramMap.put("altitude", assetsDto.getAltitude());
		paramMap.put("prtc_grade", assetsDto.getPrtc_grade());
		paramMap.put("res_val", assetsDto.getRes_val());
		paramMap.put("dep_fix_num_year", assetsDto.getDep_fix_num_year());
		paramMap.put("mon_dep", assetsDto.getMon_dep());
		paramMap.put("acc_dep", assetsDto.getAcc_dep());
		paramMap.put("war_id", assetsDto.getWar_id());
		paramMap.put("crt_use_id", assetsDto.getCrt_use_id());
		paramMap.put("crt_tim", DateUtil.getcurrentTime());

		paramMap.put("cou", assetsDto.getCou());
		paramMap.put("ord_num", assetsDto.getOrd_num());
		paramMap.put("cur_sta", AssetsDto.BROUND_IN);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);
		paramMap.put("is_scrap", AssetsDto.ASSETS_SCRAP_NO);

		boolean retSta = assetManagementDao.insAssets(paramMap);
		
		Map<String, Object> logMap = new HashMap<String, Object>();
		// 操作人ID
		logMap.put("use_id", assetsDto.getCrt_use_id());
		// 操作类型
		logMap.put("opt_typ", "数据添加");
		// 操作时间
		logMap.put("opt_tim", DateUtil.getcurrentTime());
		// 操作功能
		logMap.put("opt_fut", "添加资产信息");
		// 操作内容
		logMap.put("opt_ctn", paramMap.toString());
		// 是否操作成功（0为不成功，1为成功）
		logMap.put("is_suc", 1);
		
		utilsDao.insertOptLogInf(logMap);
		
		return retSta;
	}

	public List<Map<String, Object>> getAssetsIdsByAssNum(String ass_num) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("ass_num", ass_num);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);

		return assetManagementDao.getAssetsIdsByAssNum(paramMap);
	}

	@Override
	@Transactional
	public boolean updAssets(AssetsDto assetsDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		if (assetsDto != null) {
			paramMap.put("sub_com_id", assetsDto.getSub_com_id());
			paramMap.put("ass_nam", assetsDto.getAss_nam());
			paramMap.put("ass_num", assetsDto.getAss_num());
			paramMap.put("ass_typ_id", assetsDto.getAss_typ_id());
			paramMap.put("pro_tim", assetsDto.getPro_tim());
			paramMap.put("pur_tim", assetsDto.getPur_tim());
			paramMap.put("remark", assetsDto.getRemark());
			paramMap.put("equ_sor", assetsDto.getEqu_sor());
			paramMap.put("app_mod_id", assetsDto.getApp_mod_id());
			paramMap.put("man_id", assetsDto.getMan_id());
			paramMap.put("unit", assetsDto.getUnit());
			paramMap.put("price", assetsDto.getPrice());
			paramMap.put("siz",assetsDto.getSiz());
			paramMap.put("weight", assetsDto.getWeight());
			paramMap.put("inp_elc", assetsDto.getInp_elc());
			paramMap.put("inp_vol", assetsDto.getInp_vol());
			paramMap.put("rtd_pow", assetsDto.getRtd_pow());
			paramMap.put("out_elc", assetsDto.getOut_elc());
			paramMap.put("out_vol", assetsDto.getOut_vol());
			paramMap.put("work_temp", assetsDto.getWork_temp());
			paramMap.put("altitude", assetsDto.getAltitude());
			paramMap.put("prtc_grade", assetsDto.getPrtc_grade());
			paramMap.put("res_val", assetsDto.getRes_val());
			paramMap.put("dep_fix_num_year", assetsDto.getDep_fix_num_year());
			paramMap.put("mon_dep", assetsDto.getMon_dep());
			paramMap.put("acc_dep", assetsDto.getAcc_dep());
			paramMap.put("war_id", assetsDto.getWar_id());
			// paramMap.put("cou", assetsDto.getCou());
			// paramMap.put("cur_sta", AssetsDto.BROUND_OUT);
			// paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);
			// paramMap.put("is_scrap", AssetsDto.ASSETS_SCRAP_NO);
			paramMap.put("ord_num", StringUtil.genOrderNumInbound());
			paramMap.put("mod_use_id", assetsDto.getMod_use_id());
			paramMap.put("mod_tim", DateUtil.getcurrentTime());
		}

		boolean retSta = assetManagementDao.updAssets(paramMap);
		
		Map<String, Object> logMap = new HashMap<String, Object>();
		// 操作人ID
		logMap.put("use_id", assetsDto.getMod_use_id());
		// 操作类型
		logMap.put("opt_typ", "数据修改");
		// 操作时间
		logMap.put("opt_tim", DateUtil.getcurrentTime());
		// 操作功能
		logMap.put("opt_fut", "修改资产信息");
		// 操作内容
		logMap.put("opt_ctn", paramMap.toString());
		// 是否操作成功（0为不成功，1为成功）
		logMap.put("is_suc", 1);
		
		utilsDao.insertOptLogInf(logMap);
		
		return retSta;
	}

	@Override
	public List<Map<String, Object>> getAssetsByAssNum(String ass_num) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 有ass_num参数 ：获取指定ass_num的信息 无ass_num参数 ：获取所有ass_num的信息
		if (ass_num != null && ass_num != "") {
			paramMap.put("ass_num", ass_num);
		}
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);

		return assetManagementDao.getAssetsByAssNum(paramMap);
	}

	@Override
	@Transactional
	public boolean delAssets(String ass_num, String mod_use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("ass_num", ass_num);
		paramMap.put("mod_use_id", mod_use_id);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_YES);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		
		boolean retSta = assetManagementDao.delAssets(paramMap);
		
		Map<String, Object> logMap = new HashMap<String, Object>();
		// 操作人ID
		logMap.put("use_id", mod_use_id);
		// 操作类型
		logMap.put("opt_typ", "数据删除");
		// 操作时间
		logMap.put("opt_tim", DateUtil.getcurrentTime());
		// 操作功能
		logMap.put("opt_fut", "删除资产信息");
		// 操作内容
		logMap.put("opt_ctn", paramMap.toString());
		// 是否操作成功（0为不成功，1为成功）
		logMap.put("is_suc", 1);
		
		utilsDao.insertOptLogInf(logMap);
		
		return retSta;
	}

	@Override
	public boolean delBatchAssets(String ass_nums, String mod_use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("ass_nums", ass_nums.split(","));
		paramMap.put("mod_use_id", mod_use_id);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_YES);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());
		
		boolean retSta = assetManagementDao.delBatchAssets(paramMap);
		
		Map<String, Object> logMap = new HashMap<String, Object>();
		// 操作人ID
		logMap.put("use_id", mod_use_id);
		// 操作类型
		logMap.put("opt_typ", "数据删除");
		// 操作时间
		logMap.put("opt_tim", DateUtil.getcurrentTime());
		// 操作功能
		logMap.put("opt_fut", "批量删除资产信息");
		// 操作内容
		logMap.put("opt_ctn", paramMap.toString());
		// 是否操作成功（0为不成功，1为成功）
		logMap.put("is_suc", 1);
		
		utilsDao.insertOptLogInf(logMap);

		return retSta;
	}

	@Override
	public List<Map<String, Object>> getInOutBroundList(Map<String, Object> map) throws Exception {
		return assetManagementDao.getInOutBroundList(map);
	}

	@Override
	public Integer getInOutBroundCount(Map<String, Object> map) throws Exception {
		Long count = 0l;
		Map<String, Object> dataCount = assetManagementDao.getInOutBroundCount(map);
		if (dataCount != null && !dataCount.isEmpty()) {
			count = (Long) dataCount.get("cou");
		}
		return count.intValue();
	}

	@Override
	public List<Map<String, Object>> getAssetsListByOrdNum(String ord_num) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ord_num", ord_num);

		return assetManagementDao.getAssetsListByOrdNum(paramMap);
	}

	@Override
	public Map<String, Object> getAssetsAlaCou(String ass_num) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ass_num", ass_num);

		return assetManagementDao.getAssetsAlaCou(paramMap);
	}

	@Override
	@Transactional
	public boolean setAssetsAlaCou(String ass_num, String ala_num, String mod_use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ass_num", ass_num);
		paramMap.put("ala_num", ala_num);
		paramMap.put("mod_use_id", mod_use_id);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return assetManagementDao.setAssetsAlaCou(paramMap);
	}

	@Override
	public boolean insAssetsAlaInfo(String ass_num, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ass_num", ass_num);
		paramMap.put("crt_use_id", use_id);
		paramMap.put("ala_num", 0);
		paramMap.put("crt_tim", DateUtil.getcurrentTime());
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);


		boolean retSta = assetManagementDao.insAssetsAlaInfo(paramMap);
		
		Map<String, Object> logMap = new HashMap<String, Object>();
		// 操作人ID
		logMap.put("use_id", use_id);
		// 操作类型
		logMap.put("opt_typ", "数据添加");
		// 操作时间
		logMap.put("opt_tim", DateUtil.getcurrentTime());
		// 操作功能
		logMap.put("opt_fut", "添加资产预警信息");
		// 操作内容
		logMap.put("opt_ctn", paramMap.toString());
		// 是否操作成功（0为不成功，1为成功）
		logMap.put("is_suc", 1);
		
		utilsDao.insertOptLogInf(logMap);
		
		return retSta;
	}

	@Override
	public List<Map<String, Object>> getStoreHouseByComId(String com_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sub_com_id", com_id);

		return assetManagementDao.getStoreHouseByComId(paramMap);
	}

	// ///////////////////////////缺陷管理 ////////////////////////////////////

	// 上传文件
	@Override
	public boolean uploadFile(MultipartFile file, Map<String, Object> map) throws Exception {
		InputStream is = null;
		try {
			is = file.getInputStream();
			String fileName = file.getName();
			long size = file.getSize();
			String type = file.getContentType();
			File goal = new File(MobileConfig.get("file.global.location"), StringUtil.getFileNameByUUID(file
					.getOriginalFilename()));
			FileUtils.copyInputStreamToFile(is, goal);

			map.put("file_url", goal.getPath());
			map.put("del_flag", DefectDto.DEL_FLAG_NO);

			// 判断文件类型
			String[] suffix = { "JPEG", "GIF", "JPG", "PNG", "BMP", "PIC" };
			String picSuffix = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();

			boolean contains = Arrays.asList(suffix).contains(picSuffix);
			if (contains) {// 1:文件 2:图片
				map.put("file_typ", 2);
			} else {
				map.put("file_typ", 1);
			}

			assetManagementDao.uploadFile(map);
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

	@Override
	public boolean delFile(String id, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("id", id);
		paramMap.put("mod_use_id", use_id);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_YES);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return assetManagementDao.delFile(paramMap);
	}
	

	// 下载
	@Override
	public boolean downloadFile(HttpServletResponse response, int id, BaseTransferEntity baseTransferEntity)
			throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);

		Map<String, Object> fileMap = assetManagementDao.getFileById(paramMap);

		if (fileMap.isEmpty() || "1".equals(fileMap.get("del_flag").toString())) {
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
	public Map<String, Object> getFileById(String id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);

		return assetManagementDao.getFileById(paramMap);
	}
	@Override
	public Map<String, Object> getFileByIdNew(int id) throws Exception{
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		
		return assetManagementDao.getFileById(paramMap);
	}

	@Override
	public List<Map<String, Object>> getFileListByDefId(String def_num) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("def_num", def_num);

		return assetManagementDao.getFileListByDefId(paramMap);
	}
	
	@Override
	public List<Map<String, Object>> getDefectTypByName(Map<String, Object> map) throws Exception {
		
		return assetManagementDao.getDefectTypByName(map);
	}

	// /////////////////////////////////////////////////
	@Override
	public boolean insDefectTyp(DefectTypeDto defectTypeDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (defectTypeDto != null) {
			paramMap.put("typ_nam", defectTypeDto.getTyp_nam());
			paramMap.put("typ_ide", defectTypeDto.getTyp_ide());
			paramMap.put("remark", defectTypeDto.getRemark());
			paramMap.put("del_flag", DefectTypeDto.DEL_FLAG_NO);
			paramMap.put("typ_sor", defectTypeDto.getTyp_sor());
			paramMap.put("crt_use_id", defectTypeDto.getCrt_use_id());
			paramMap.put("crt_tim", DateUtil.getcurrentTime());
		}

		return assetManagementDao.insDefectTyp(paramMap);
	}

	@Override
	public boolean updDefectTyp(DefectTypeDto defectTypeDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (defectTypeDto != null) {
			paramMap.put("id", defectTypeDto.getId());
			paramMap.put("typ_nam", defectTypeDto.getTyp_nam());
			paramMap.put("typ_ide", defectTypeDto.getTyp_ide());
			paramMap.put("remark", defectTypeDto.getRemark());
			paramMap.put("del_flag", DefectTypeDto.DEL_FLAG_NO);
			paramMap.put("typ_sor", defectTypeDto.getTyp_sor());
			paramMap.put("crt_use_id", defectTypeDto.getCrt_use_id());
			paramMap.put("crt_tim", DateUtil.getcurrentTime());
		}

		return assetManagementDao.updDefectTyp(paramMap);
	}

	@Override
	public boolean delDefectTyp(String id, String mod_use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("id", id);
		paramMap.put("mod_use_id", mod_use_id);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_YES);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return assetManagementDao.delDefectTyp(paramMap);
	}

	@Override
	public Map<String, Object> getDefectTypById(String id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);

		return assetManagementDao.getDefectTypById(paramMap);
	}

	@Override
	public List<Map<String, Object>> getDefectTypList() throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);

		return assetManagementDao.getDefectTypList(paramMap);
	}

	@Override
	public Integer getDefectTypCount() throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);
		Long count = 0l;
		Map<String, Object> countMap = assetManagementDao.getDefectTypCount(paramMap);
		if (countMap != null && !countMap.isEmpty()) {
			count = (Long) countMap.get("cou");
		}
		return count.intValue();
	}

	// ////////////////////////////////////////////////////
	@Override
	public boolean insDefectInfo(DefectDto defectDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (defectDto != null) {
			paramMap.put("def_typ_id", defectDto.getDef_typ_id());
			paramMap.put("def_num", StringUtil.genDefNum()); // yyyyMMdd + 4位随机数
			paramMap.put("def_sta", defectDto.getDef_sta());
			paramMap.put("def_grade", defectDto.getDef_grade());
			paramMap.put("del_flag", DefectDto.DEL_FLAG_NO);
			paramMap.put("def_desc", defectDto.getDef_desc());
			paramMap.put("remark", defectDto.getRemark());
			paramMap.put("sub_com_id", defectDto.getSub_com_id());
			paramMap.put("crt_use_id", defectDto.getCrt_use_id());
			paramMap.put("crt_tim", DateUtil.getcurrentTime());
		}

		return assetManagementDao.insDefectInfo(paramMap);
	}

	@Override
	public boolean updDefectInfo(DefectDto defectDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (defectDto != null) {
			paramMap.put("def_num", defectDto.getDef_num());
			paramMap.put("def_typ_id", defectDto.getDef_typ_id());
			paramMap.put("def_sta", defectDto.getDef_sta());
			paramMap.put("def_grade", defectDto.getDef_grade());
			paramMap.put("del_flag", DefectDto.DEL_FLAG_NO);
			paramMap.put("def_desc", defectDto.getDef_desc());
			paramMap.put("remark", defectDto.getRemark());
			paramMap.put("sub_com_id", defectDto.getSub_com_id());
			paramMap.put("crt_use_id", defectDto.getCrt_use_id());
			paramMap.put("crt_tim", DateUtil.getcurrentTime());
		}

		return assetManagementDao.updDefectInfo(paramMap);
	}

	@Override
	public Map<String, Object> getDefectInfoByDefnum(String def_num) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("def_num", def_num);
		paramMap.put("del_flag", DefectDto.DEL_FLAG_NO);

		return assetManagementDao.getDefectInfoByDefnum(paramMap);
	}

	@Override
	public boolean delDefectInfo(String def_num,String id, String mod_use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("def_num", def_num);
		paramMap.put("id", id);
		paramMap.put("mod_use_id", mod_use_id);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_YES);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return assetManagementDao.delDefectInfo(paramMap);
	}

	@Override
	public boolean delBatchDefectInfo(String def_nums, String mod_use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("def_nums", def_nums);
		paramMap.put("mod_use_id", mod_use_id);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_YES);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return assetManagementDao.delBatchDefectInfo(paramMap);
	}

	@Override
	public List<Map<String, Object>> getDefectList(Map<String, Object> map) throws Exception {

		return assetManagementDao.getDefectList(map);
	}

	@Override
	public Integer getDefectListCount(Map<String, Object> map) throws Exception {
		Long count = 0l;
		Map<String, Object> dataCount = assetManagementDao.getDefectListCount(map);
		if (dataCount != null && !dataCount.isEmpty()) {
			count = (Long) dataCount.get("cou");
		}
		return count.intValue();
	}

	// ////////////////////////////////////////////////////////////////////////
	@Override
	public boolean insAssetsPurPlan(AssetsPurPlanDto purPlanDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("plan_num", StringUtil.genPurPlanNum());
		paramMap.put("pur_tim", purPlanDto.getPur_tim());
		paramMap.put("remark", purPlanDto.getRemark());

		paramMap.put("plan_use_id", purPlanDto.getPlan_use_id());
		paramMap.put("crt_use_id", purPlanDto.getCrt_use_id());
		paramMap.put("is_finish", AssetsPurPlanDto.PLAN_FINISH_NO);
		paramMap.put("del_flag", AssetsPurPlanDto.DEL_FLAG_NO);
		paramMap.put("crt_tim", DateUtil.getcurrentTime());

		return assetManagementDao.insAssetsPurPlan(paramMap);
	}

	@Override
	public boolean updAssetsPurPlan(AssetsPurPlanDto purPlanDto) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("id", purPlanDto.getId());
		paramMap.put("plan_num", purPlanDto.getPlan_num());
		paramMap.put("is_finish", purPlanDto.getIs_finish());
		paramMap.put("pur_tim", purPlanDto.getPur_tim());
		paramMap.put("remark", purPlanDto.getRemark());
		paramMap.put("plan_use_id", purPlanDto.getPlan_use_id());
		paramMap.put("mod_use_id", purPlanDto.getCrt_use_id());
		paramMap.put("del_flag", AssetsPurPlanDto.DEL_FLAG_NO);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return assetManagementDao.updAssetsPurPlan(paramMap);
	}

	@Override
	public Map<String, Object> getAssetsPurPlanById(Map<String, Object> map) throws Exception {

		return assetManagementDao.getAssetsPurPlanById(map);
	}

	@Override
	public boolean delAssetsPurPlan(String id, String mod_use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("mod_use_id", mod_use_id);
		paramMap.put("del_flag", AssetsPurPlanDto.DEL_FLAG_YES);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return assetManagementDao.delAssetsPurPlan(paramMap);
	}

	@Override
	public boolean delBatchAssetsPurPlan(String ids, String mod_use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ids", ids.split(","));
		paramMap.put("mod_use_id", mod_use_id);
		paramMap.put("del_flag", AssetsPurPlanDto.DEL_FLAG_YES);
		paramMap.put("mod_tim", DateUtil.getcurrentTime());

		return assetManagementDao.delBatchAssetsPurPlan(paramMap);
	}

	@Override
	public List<Map<String, Object>> getAssetsPurPlanList(Map<String, Object> map) throws Exception {

		return assetManagementDao.getAssetsPurPlanList(map);
	}

	@Override
	public int getAssetsPurPlanCount(Map<String, Object> map) throws Exception {

		Long count = 0l;
		Map<String, Object> dataCount = assetManagementDao.getAssetsPurPlanCount(map);
		if (dataCount != null && !dataCount.isEmpty()) {
			count = (Long) dataCount.get("cou");
		}
		return count.intValue();
	}

	// 上传 培训文件
	@Override
	public boolean uploadPurPlanFile(MultipartFile file, Map<String, Object> map) throws Exception {

		InputStream is = null;
		try {
			is = file.getInputStream();
			String fileName = file.getName();
			long size = file.getSize();
			String type = file.getContentType();
			File goal = new File(MobileConfig.get("file.global.location"), StringUtil.getFileNameByUUID(file
					.getOriginalFilename()));
			FileUtils.copyInputStreamToFile(is, goal);

			map.put("file_url", goal.getPath());
			map.put("del_flag", TrainingManagerFileDto.DEL_FLAG_NO);

			// 判断文件类型
			String picSuffix = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();

			boolean contains = "JPEG".equals(picSuffix) || "GIF".equals(picSuffix) || "JPG".equals(picSuffix)
					|| "PNG".equals(picSuffix) || "BMP".equals(picSuffix) || "PIC".equals(picSuffix);
			if (contains) {// 1:文件 2:图片
				map.put("file_typ", 2);
			} else {
				map.put("file_typ", 1);
			}

			assetManagementDao.uploadPurPlanFile(map);
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
	public boolean downloadPurPlanFile(HttpServletResponse response, int id, BaseTransferEntity baseTransferEntity)
			throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);

		Map<String, Object> fileMap = assetManagementDao.getFileById(paramMap);

		if (fileMap.isEmpty() || "1".equals(fileMap.get("del_flag"))) {
			baseTransferEntity.setResultcode(MobileConfig.get("code.global.failed"));
			baseTransferEntity.setDesc("请求的文件不存在");
			return false;
		}

		//if (fileMap != null && !fileMap.isEmpty() && "0".equals(fileMap.get("del_flag").toString())) {

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
		//}
	}

	@Override
	public boolean delPurPlanFile(String id, String use_id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("mod_use_id", use_id);
		paramMap.put("del_flag", TrainingManagerFileDto.DEL_FLAG_YES);
		paramMap.put("mod_tim",new Date());
		return assetManagementDao.delPurPlanFile(paramMap);
	}

	@Override
	public Map<String, Object> getPurPlanFileById(String id) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("del_flag", TrainingManagerFileDto.DEL_FLAG_NO);

		return assetManagementDao.getPurPlanFileById(paramMap);
	}
	
	

	@Override
	public List<Map<String, Object>> getPurPlanFileListByPlanNum(String plan_num) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("plan_num", plan_num);
		paramMap.put("del_flag", TrainingManagerFileDto.DEL_FLAG_NO);

		return assetManagementDao.getPurPlanFileListByPlanNum(paramMap);
	}
	
	/**
	 * 查询所有仓库
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAllWareHouseName() throws Exception {
		
		return assetManagementDao.getAllWareHouseName();
	}
	
	
	/**
	 * 通过资产编号查询物资
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAssetsByAssNumNew(Map<String, Object> map) throws Exception {
		
		return assetManagementDao.getAssetsByAssNumNew(map);
	}

}
