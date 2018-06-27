/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.assetmanagement;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.assetmanagement.AssetsDto;
import com.qinergy.dto.assetmanagement.AssetsPurPlanDto;
import com.qinergy.dto.assetmanagement.AssetsTypeDto;
import com.qinergy.dto.assetmanagement.DefectDto;
import com.qinergy.dto.assetmanagement.DefectTypeDto;

/**
 * @desc: 资产管理 service
 * @author: Qist
 * @date: 2017年11月7日
 */
public interface AssetsManagementService {

	/**
	 * @Title: insAssetsTyp
	 * 添加 资产类型
	 * @return boolean
	 * @throws
	 */
	boolean insAssetsTyp(AssetsTypeDto assetsTypeDto) throws Exception;

	/**
	 * @Title: delAssetsTyp
	 * @Desc: 逻辑删除 资产类型
	 * @return boolean
	 * @throws
	 */
	boolean delAssetsTyp(String id, String mod_use_id) throws Exception;
	
	
	/**
	 * @Title: updAssetsTyp
	 * @Desc: 修改 资产类型
	 * @return boolean
	 * @throws
	 */
	boolean updAssetsTyp(AssetsTypeDto assetsTypeDto) throws Exception;

	/**
	 * @Title: getAssetsTypById
	 * @Desc: 根据id获取该资产类型
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getAssetsTypById(String id) throws Exception;

	/**
	 * @Title: getAssetsTypList
	 * @Desc: 获取资产类型列表
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getAssetsTypList() throws Exception;

	
	
	/*****************************************
	 * @Title: getAssetsListByTyp
	 * @Desc: 获取该公司下的资产台账 统计数据
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getAssetsListByTyp(Map<String, Object> map) throws Exception;

	/**
	 * @Title: getAssetsListCount
	 * @Desc: 资产数量列表  
	 * @return Integer
	 * @throws
	 */
	Integer getAssetsListCount(Map<String, Object> map) throws Exception;

	
	
	/**************************************************
	 * @Title: insAssets
	 * @Desc: 添加资产记录信息(出入库 操作)
	 * @return boolean
	 * @throws
	 */
	boolean insAssets(Map<String, Object> map) throws Exception;
	
	
	/**
	 * @param map 
	 * @Title: insAssets  
	 * @Desc:  添加资产静态信息 
	 * @return boolean
	 * @throws
	 */
	boolean insAssets(AssetsDto assetsDto) throws Exception;

	/**
	 * @Title: getAssetsByAssNum
	 * @Desc: 根据资产编号 GROUP BY 获取该资产统计信息
	 * 				有ass_num参数 ：获取指定ass_num的信息
	 * 				无ass_num参数 ：获取所有ass_num的信息
	 * @return Map<String,Object>
	 * @throws
	 */
	List<Map<String, Object>> getAssetsByAssNum(String ass_num) throws Exception;

	
	/**
	 * @Title: updAssets
	 * @Desc: 修改资产信息 (修改资产静态信息使用)
	 * @return boolean
	 * @throws
	 */
	boolean updAssets(AssetsDto assetsDto) throws Exception;

	/**
	 * @Title: getAssetsIdsByAssNum  
	 * @Desc: 获取某ass_num 下所有 的id 和 ass_num 集合
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getAssetsIdsByAssNum(String ass_num) throws Exception;
		
	/**
	 * @Title: delAssets
	 * @Desc: 删除资产
	 * @return boolean
	 * @throws
	 */
	boolean delAssets(String ass_num, String mod_use_id) throws Exception;

	/**
	 * @Title: delAssets
	 * @Desc: 批量删除资产
	 * @return boolean
	 * @throws
	 */
	boolean delBatchAssets(String ids, String mod_use_id) throws Exception;

	
	/**
	 * @Title: getAssetsParamList
	 * @Desc: 物资出入库列表
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getInOutBroundList(Map<String, Object> map) throws Exception;

	/**
	 * @Title: getAssetsListCount
	 * @Desc: 物资出入库信息count
	 * @return Integer
	 * @throws
	 */
	Integer getInOutBroundCount(Map<String, Object> map) throws Exception;

	/**
	 * @Title: getAssetsListByOrdNum  
	 * @Desc:  根据单号 查询 所有出入库信息 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getAssetsListByOrdNum(String ord_num) throws Exception;

	
	/**
	 * @Title: getAssetsAlaCou  
	 * @Desc: 根据 ass_num 获取 资产告警数量 
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getAssetsAlaCou(String ass_num) throws Exception;
	
	/**
	 * 	  @Title: setAssetsAlaCou  
	 * @Desc: 设置 资产告警数量 
	 * @return boolean
	 * @throws
	 */
	boolean setAssetsAlaCou(String ass_num, String ala_num, String mod_use_id) throws Exception;
	
	
	boolean insAssetsAlaInfo(String ass_num, String use_id) throws Exception;
	
	
	/**
	 * @Title: getStoreHouseByComId
	 * @Desc: 根据公司id获取 仓库列表
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getStoreHouseByComId(String sub_com_id) throws Exception;
	
	
	
	
	/////////////////////////////缺陷管理 ////////////////////////////////////
	
	/**
	 * @Title: uploadFile  
	 * @Desc:   上传文件 
	 * @return boolean
	 * @throws
	 */
	boolean uploadFile(MultipartFile file,Map<String, Object> map) throws Exception;
	
	/**
	 * @throws Exception 
	 * @Title: downloadFile  
	 * @Desc:   下载文件 
	 * @return boolean
	 * @throws
	 */
	boolean downloadFile(HttpServletResponse response, int id, BaseTransferEntity baseTransferEntity) throws Exception;
	
	/**
	 * @Title: removeFileById  
	 * @Desc:   逻辑删除文件 
	 * @return int
	 * @throws
	 */
	boolean delFile(String id, String use_id) throws Exception;

	/**
	 * @Title: getFileById  
	 * @Desc: 根据id查询缺陷文件 
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getFileById(String id) throws Exception;
	
	/**
	 * @Title: getFileListByDefId  
	 * @Desc: 根据缺陷id 获取文件列表 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getFileListByDefId(String def_num) throws Exception;
	
	
	
	/*****************************************************************
	 * @Title: insDefectTyp  
	 * @Desc: 添加缺陷类型 
	 * @return boolean
	 * @throws
	 */
	boolean insDefectTyp(DefectTypeDto defectTypeDto) throws Exception;
	
	/**
	 * @Title: updDefectTyp  
	 * @Desc: 修改缺陷类型 
	 * @return boolean
	 * @throws
	 */
	boolean updDefectTyp(DefectTypeDto defectTypeDto) throws Exception;
	
	/**
	 * @Title: delDefectTyp  
	 * @Desc: 根据id 删除缺陷类型 
	 * @return boolean
	 * @throws
	 */
	boolean delDefectTyp(String id, String mod_use_id) throws Exception;
	
	/**
	 * @Title: getDefectTypById  
	 * @Desc: 根据id缺陷类型 
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getDefectTypById(String id) throws Exception;
	
	/**
	 * @Title: getDefectTypList  
	 * @Desc:  查询缺陷类型列表  
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getDefectTypList() throws Exception;
	
	/**
	 * @Title: getDefectTypCount  
	 * @Desc: 缺陷缺陷类型条数  
	 * @return Map<String,Object>
	 * @throws
	 */
	Integer getDefectTypCount() throws Exception;
	
	
	
	
	/*******************************************************8
	 * @Title: insDefectInfo  
	 * @Desc: 添加缺陷信息 
	 * @return boolean
	 * @throws
	 */
	boolean insDefectInfo(DefectDto defectDto) throws Exception;
	
	/**
	 * @Title: updDefectInfo  
	 * @Desc: 修改缺陷信息 
	 * @return boolean
	 * @throws
	 */
	boolean updDefectInfo(DefectDto defectDto) throws Exception;
	
	/**
	 * @Title: delDefectInfo  
	 * @Desc: 根据def_num 删除缺陷信息 
	 * @return boolean
	 * @throws
	 */
	boolean delDefectInfo(String def_num,String id, String mod_use_id) throws Exception;
	
	/**
	 * @Title: delBatchDefectInfo  
	 * @Desc: 批量删除缺陷信息 
	 * @return boolean
	 * @throws
	 */
	boolean delBatchDefectInfo(String def_nums, String mod_use_id) throws Exception;
	
	/**
	 * @Title: getDefectInfoByDefnum  
	 * @Desc: 根据def_num缺陷信息 
	 * @return Integer
	 * @throws
	 */
	Map<String, Object> getDefectInfoByDefnum(String def_num) throws Exception;
		
	/**
	 * @Title: getDefectInfoByComId  
	 * @Desc: 分页查询缺陷列表 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getDefectList(Map<String, Object> map) throws Exception;
	
	/**
	 * @Title: getDefectInfoCount  
	 * @Desc: 缺陷列表条数 
	 * @return Map<String,Object>
	 * @throws
	 */ 
	Integer getDefectListCount(Map<String, Object> map) throws Exception;
	
	
	
	
	/*********************************物资采购计划********************************
	 * @Title: insAssetsPurPlan  
	 * @Desc:   添加 采购计划
	 * @return boolean
	 * @throws
	 */
	boolean insAssetsPurPlan(AssetsPurPlanDto assetsPurPlanDto) throws Exception;
	
	/**
	 * @Title: updAssetsPurPlan  
	 * @Desc:   修改采购计划
	 * @return boolean
	 * @throws
	 */
	boolean updAssetsPurPlan(AssetsPurPlanDto assetsPurPlanDto) throws Exception;
	
	/**
	 * @Title: getAssetsPurPlanById  
	 * @Desc:   根据id获取计划信息
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getAssetsPurPlanById(Map<String, Object> map) throws Exception;
	
	/**
	 * @Title: delAssetsPurPlan  
	 * @Desc:   根据id删除计划
	 * @return boolean
	 * @throws
	 */
	boolean delAssetsPurPlan(String id, String use_id) throws Exception;
	
	/**
	 * @Title: delBatchAssetsPurPlan  
	 * @Desc:    批量删除采购计划
	 * @return boolean
	 * @throws
	 */
	boolean delBatchAssetsPurPlan(String ids, String mod_use_id) throws Exception;
		
	/**
	 * @Title: getAssetsPurPlanList  
	 * @Desc:    查询采购计划列表
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getAssetsPurPlanList(Map<String, Object> map) throws Exception;	
		
	/**
	 * @Title: getAssetsPurPlanCount  
	 * @Desc:   查询采购计划条数
	 * @return Map<String,Object>
	 * @throws
	 */
	int getAssetsPurPlanCount(Map<String, Object> map) throws Exception;
	
	
	

	
	
	/**
	 * @Title: uploadPurPlanFile  
	 * @Desc:  上传采购计划附件文件  
	 * @return boolean
	 * @throws
	 */
	boolean uploadPurPlanFile(MultipartFile file, Map<String, Object> map) throws Exception;
	
	/**
	 * @Title: downloadTrainFile  
	 * @Desc:  下载文件  
	 * @return boolean
	 * @throws
	 */
	boolean downloadPurPlanFile(HttpServletResponse response, int id, BaseTransferEntity baseTransferEntity) throws Exception;
	
	/**
	 * @Title: delPurPlanFile  
	 * @Desc:  逻辑删除文件  
	 * @return boolean
	 * @throws
	 */
	boolean delPurPlanFile(String id, String use_id) throws Exception;
	
	/**
	 * @Title: getPurPlanFileById  
	 * @Desc:  根据id查询采购计划附件 
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> getPurPlanFileById(String id) throws Exception;
	
	
	
	/**
	 * @Title: getPurPlanFileListByPlanNum  
	 * @Desc:  根据计划编号  获取采购计划文件列表 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getPurPlanFileListByPlanNum(String plan_num) throws Exception;

	/**
	 * @Title: getAssetsTypByName  
	 * @Desc:  根据名字查询列表
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	List<Map<String, Object>> getAssetsTypByName(Map<String, Object> map)
			throws Exception;

	/**
	 * 使用缺陷名称获取缺陷信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDefectTypByName(Map<String, Object> map)
			throws Exception;

	/**
	 * 使用文件ID获取文件信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getFileByIdNew(int id) throws Exception;

	/**
	 * 获取所有仓库名称
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAllWareHouseName()
			throws Exception;

	/**
	 * 根据资产编号 GROUP BY 获取该资产统计信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAssetsByAssNumNew(Map<String, Object> map) throws Exception;
}
