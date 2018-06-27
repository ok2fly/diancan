package com.qinergy.dao.knowledgebase;

import java.util.List;
import java.util.Map;

/**
 * @desc: KnowledgeBaseDao 实现类，无接口
 * @author iceX
 * @date 2016年7月8日15:53:32
 */
public interface KnowledgeBaseDao {
	
	/**
	 * 添加知识库
	 * @param map
	 * @return
	 */
	int insetKnowLedge(Map<String, Object> map);

	/**
	 * 知识库修改
	 * @param map
	 * @return
	 */
	int updateKnw(Map<String, Object> map);

	/**
	 * 创建知识库文件
	 * @param map
	 * @return
	 */
	int insertFile(Map<String, Object> map);

	/**
	 * 查询知识库
	 * @param map
	 * @return
	 */
	Map<String, Object> getIdByInfo(Map<String, Object> map);

	/**
	 * 根据id 查看文件信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getFileInfoById(int id);

	/**
	 * 知识库文件删除
	 * @param id
	 * @return
	 */
	int removeFileById(int id);
	/**
	 * 知识库信息删除
	 * @param id
	 * @return
	 */
	int removeKnw(int id);
	/**
	 * 删除文件
	 * @param id
	 * @return
	 */
	int removeFileByKnwID(int id);

	/**
	 * 创建只是库 类型
	 * @param map
	 * @return
	 */
	int insertKnwType(Map<String, Object> map);

	/**
	 * 类型查询
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getKnwType(String id);
	
	/**
	 * 知识库表查询
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getKnwByType(Map<String, Object> map);

	/**
	 * 通过类型查询文件信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getFileInfoByKnw(int id);

	/**
	 * 通过类型查询知识库的 数量
	 * @param id
	 * @return
	 */
	int getKnwCountByTypeId(int id);

	/**
	 * 删除知识库类型
	 * @param id
	 * @return
	 */
	int removeKnwType(int id);

	/**
	 * 修改知识库类型信息
	 * @param map
	 * @return
	 */
	 int updateKnwTypeInfo(Map<String,Object> map);
	/**
	 * 根据id 查看知识库类型信息
	 * @param id
	 * @return
	 */
	 Map<String,Object> getKnwInfoById(int id);


	// 一下为安全管理部分

	/**
	 * 添加安全类型
	 * @param map
	 * @return
	 */
	int insertSct(Map<String, Object> map);

	/**
	 * 添加文件
	 * @param map
	 * @return
	 */
	int insertSctFile(Map<String, Object> map);

	/**
	 * 查看文件
	 * @param map
	 * @return
	 */
	Map<String, Object> getSctIdByInfo(Map<String, Object> map);

	/**
	 * 查看文件详细信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getSctFileInfoById(int id);

	/**
	 * 文件删除
	 * @param id
	 * @return
	 */
	int removeFileInSctById(int id);

	/**
	 * 安全类型修改
	 * @param map
	 * @return
	 */
	int updateSctInfo(Map<String, Object> map);

	/**
	 * 类型删除
	 * @param id
	 * @return
	 */
	int reomveSctInfoById(int id);

	/**
	 * 数量
	 * @param id
	 * @return
	 */
	int getSctCountBySctId(int id);

	/**
	 * 文件删除
	 * @param id
	 * @return
	 */
	int removeFilesBySctId(int id);

	/**
	 * 添加类型
	 * @param map
	 * @return
	 */
	int insertSctType(Map<String, Object> map);

	/**
	 * 查询文件类型
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getSctType(String id);

	/**
	 * 类型或名称查询
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSctByTypeOrName(Map<String, Object> map);

	/**
	 * 查询该安全列表下显示的所属的该所有文件列表
	 * @param sct_id
	 * @return
	 */
	List<Map<String, Object>> getFileInfoBySctId(String sct_id);

	/**
	 * 根据安全类型 查询安全信息的 数量
	 * @param id
	 * @return
	 */
	int getSctCountByType(int id);

	/**
	 * 安全类型删除
	 * @param id
	 * @return
	 */
	int RemoveSctType(int id);

	/**
	 * 安全类型 更新
	 * @param map
	 * @return
	 */
	int updateSctTypeInfo(Map<String, Object> map);

	/**
	 * 类型或名称查询 的 数量
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSctByTypeOrNameCou(Map<String, Object> map);

	/**
	 * 知识库  分页
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getKnwByTypeCou(Map<String, Object> map);

	/**
	 * 根据名称 查询 安全类型
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSctTypeByName(Map<String, Object> map);

	/**
	 * 根据类型名称 查看 知识库类型
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getKnwTypeByName(Map<String, Object> map);
	
	


}
