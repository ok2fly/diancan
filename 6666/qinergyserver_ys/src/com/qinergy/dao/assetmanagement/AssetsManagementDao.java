package com.qinergy.dao.assetmanagement;

import java.util.List;
import java.util.Map;

/**
 * @desc: AssetManagementDao  
 * @author iceX
 * @date 2016年7月8日15:53:32
 */
public interface AssetsManagementDao {

	/**
	 * 添加一个资产类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean insAssetsTyp(Map<String, Object> map) throws Exception;

	/**
	 * 修改一个资产类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean updAssetsTyp(Map<String, Object> map) throws Exception;

	/**
	 * 删除一个资产类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean delAssetsTyp(Map<String, Object> map) throws Exception;
	
	
	/**
	 *  根据id获取该资产类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	Map<String, Object> getAssetsTypById(Map<String, Object> map) throws Exception;

	
	/**
	 *  获取资产类型列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getAssetsTypList() throws Exception;
	
	
	/**
	 *  获取该公司下的资产台账 统计数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getAssetsListByTyp(Map<String, Object> map) throws Exception;
	
	
	/**
	 *  列表个数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getAssetsListCount(Map<String, Object> map) throws Exception;
	
	
	/**
	 *  添加资产信息 ：出入库
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean insAssets(Map<String, Object> map) throws Exception;

	/**
	 *  修改资产信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean updAssets(Map<String, Object> map) throws Exception;

	/**
	 *  根据资产编号 GROUP BY 获取该资产统计信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getAssetsByAssNum(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 获取某ass_num 下所有 的id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getAssetsIdsByAssNum(Map<String, Object> map) throws Exception;
		
	
	/**
	 *  删除资产
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean delAssets(Map<String, Object> map) throws Exception;
	
	
	/**
	 *  删除多条资产
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean delBatchAssets(Map<String, Object> map) throws Exception;
	
	/**
	 *  物资出入库列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getInOutBroundList(Map<String, Object> map) throws Exception;
	
	/**
	 * 物资出入库信息个数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	Map<String, Object> getInOutBroundCount(Map<String, Object> map) throws Exception;
	
	
	/**
	 *  根据单号 查询 所有资产列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getAssetsListByOrdNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 	根据 ass_num 获取 资产告警数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	Map<String, Object> getAssetsAlaCou(Map<String, Object> map) throws Exception;
	
	/**
	 * 	  设置 资产告警数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean setAssetsAlaCou(Map<String, Object> map) throws Exception;
	
	/**
	 * 添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean insAssetsAlaInfo(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 根据公司id获取 仓库列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getStoreHouseByComId(Map<String, Object> map) throws Exception;
	
	
	
	
	
	
	//////////////////////////缺陷管理///////////////////////////////
	
	
	/**
	 * 上传文件 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean uploadFile(Map<String, Object> map) throws Exception;
	
	/**
	 * 逻辑删除文件 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean delFile(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据id查询缺陷信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	Map<String, Object> getFileById(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据缺陷id 获取文件列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getFileListByDefId(Map<String, Object> map) throws Exception;
		
		
	/**
	 * 添加缺陷类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean insDefectTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改缺陷类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean updDefectTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据id 删除缺陷类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean delDefectTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据id缺陷类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	Map<String, Object> getDefectTypById(Map<String, Object> map) throws Exception;
	
	/**
	 *  查询缺陷类型列表 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getDefectTypList(Map<String, Object> map) throws Exception;
	
	/**
	 * 缺陷缺陷类型条数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	 
	Map<String, Object> getDefectTypCount(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 添加缺陷信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean insDefectInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改缺陷信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean updDefectInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据def_num 删除缺陷信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean delDefectInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据def_num 批量删除缺陷信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean delBatchDefectInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据def_num缺陷信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	//根据def_num缺陷信息
	Map<String, Object> getDefectInfoByDefnum(Map<String, Object> map) throws Exception;
	
	/**
	 * 分页查询缺陷列表 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getDefectList(Map<String, Object> map) throws Exception;
	
	/**
	 * 缺陷列表条数 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	Map<String, Object> getDefectListCount(Map<String, Object> map) throws Exception;
	

	
	
	
	///////////////////////////物资采购计划////////////////////////////////
	
	/**
	 * 	添加 采购计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean insAssetsPurPlan(Map<String, Object> map) throws Exception;
	
	/**
	 * 	修改采购计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean updAssetsPurPlan(Map<String, Object> map) throws Exception;
	
	/**
	 * 	根据id获取计划信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	Map<String, Object> getAssetsPurPlanById(Map<String, Object> map) throws Exception;
	
	/**
	 * 	根据id删除计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean delAssetsPurPlan(Map<String, Object> map) throws Exception;
	
	/**
	 * 	批量删除采购计划
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean delBatchAssetsPurPlan(Map<String, Object> map) throws Exception;
		
	/**
	 * 	查询采购计划列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getAssetsPurPlanList(Map<String, Object> map) throws Exception;	
		
	/**
	 * 	查询采购计划条数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	Map<String, Object> getAssetsPurPlanCount(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 * 上传采购计划附件文件 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean uploadPurPlanFile(Map<String, Object> map) throws Exception;
	
	/**
	 * 逻辑删除文件
	 * @param map
	 * @return
	 * @throws Exception
	 */
	 
	boolean delPurPlanFile(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据id查询采购计划附件
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	Map<String, Object> getPurPlanFileById(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据计划编号  获取采购计划文件列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	List<Map<String, Object>> getPurPlanFileListByPlanNum(Map<String, Object> map) throws Exception;

	/**
	 * 根据名字查询列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAssetsTypByName(Map<String, Object> map)
			throws Exception;

	/**
	 * 根据名字得到类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDefectTypByName(Map<String, Object> map)
			throws Exception;

	
	/**
	 * 查询所有仓库
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAllWareHouseName()
			throws Exception;

	/**
	 * 通过资产编号查询物资
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getAssetsByAssNumNew(Map<String, Object> map) throws Exception;

		
		
}
