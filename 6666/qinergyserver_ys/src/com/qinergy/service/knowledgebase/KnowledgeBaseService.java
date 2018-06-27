/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.knowledgebase;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dto.BaseTransferEntity;

/**
 * 知识与安全信息接口类
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public interface KnowledgeBaseService {
	
	/**
	 * 添加知识库信息
	 * @param knw_typ_id
	 * @param knw_nam
	 * @param knw_dec
	 * @param use_id
	 * @param crt_tim
	 * @return
	 * @throws IOException
	 */
	int insertKnw(int knw_typ_id, String knw_nam, String knw_dec, int use_id, Date crt_tim) throws IOException;

	/**
	 * 修改知识库信息
	 * @param knw_id
	 * @param knw_type_id
	 * @param knw_nam
	 * @param knw_dec
	 * @param use_id
	 * @param mod_tim
	 * @return
	 */
	int update(int knw_id, int knw_type_id, String knw_nam, String knw_dec, int use_id, Date mod_tim);

	/**
	 * 下载知识库文件
	 * @param baseTransferEntity
	 * @param id
	 * @param response
	 * @return
	 */
	boolean downloadKnwFile(BaseTransferEntity baseTransferEntity, int id, HttpServletResponse response);

	/**
	 * 移除知识库文件
	 * @param id
	 * @return
	 */
	boolean removeFileById(int id);

	/**
	 * 创建知识类型
	 * @param knw_typ_nam
	 * @param remark
	 * @param use_id
	 * @return
	 */
	boolean createKnwType(String knw_typ_nam, String remark, int use_id);

	/**
	 * 获取知识类型列表
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getKnwTypeList(String id);

	/**
	 * 使用知识类型获取知识
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getKnwByType(Map<String,Object> map);
	/**
	 * 使用知识获取文件信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getFileInfoByKnw(int id);
	
	/**
	 * 删除知识信息
	 * @param id
	 * @return
	 */
	boolean removeKnw(int id);
	
	/**
	 * 删除知识库类型信息
	 * @param id
	 * @return
	 */
	boolean removeKnwType(int id);

	/**
	 * 更新知识库类型数据
	 * @param id
	 * @param knw_typ_nam
	 * @param mod_use_id
	 * @param mod_tim
	 * @param remark
	 * @return
	 */
	boolean updateKnwTypeInfo(int id, String knw_typ_nam, int mod_use_id, Date mod_tim, String remark);

	/**
	 * 使用知识ID获取知识信息
	 * @param id
	 * @return
	 */
	Map<String, Object> getKnwInfoById(int id);
	
	/**
	 * 添加知识库中的文件信息
	 * @param knwId
	 * @param userId
	 * @param remark
	 * @param file
	 * @throws IOException
	 */
	public void addFileToKnw(int knwId,int userId,String remark,MultipartFile[] file) throws IOException;

	// 以下为安全管理部分
	/**
	 * 添加安全信息
	 * @param sct_typ_id
	 * @param sct_nam
	 * @param sct_dec
	 * @param use_id
	 * @param crt_tim
	 * @return
	 * @throws IOException
	 */
	int insertSct(int sct_typ_id, String sct_nam, String sct_dec, int use_id, Date crt_tim) throws IOException;
	
	/**
	 * 下载安全文件
	 * @param baseTransferEntity
	 * @param id
	 * @param response
	 * @return
	 */
	boolean downloadSctFile(BaseTransferEntity baseTransferEntity, int id, HttpServletResponse response);
	
	/**
	 * 使用文件ID删除安全文件
	 * @param id
	 * @return
	 */
	boolean removeFileInSctById(int id);

	/**
	 * 修改安全信息
	 * @param id
	 * @param sct_typ_id
	 * @param sct_nam
	 * @param sct_dec
	 * @param use_id
	 * @param mod_tim
	 * @return
	 * @throws IOException
	 */
	boolean updateSctInfo(int id, int sct_typ_id, String sct_nam, String sct_dec, int use_id, Date mod_tim) throws IOException;
	
	/**
	 * 移除安全信息以及文件
	 * @param id
	 * @return
	 */
	boolean removeSctAndFileInSct(int id);

	/**
	 * 添加安全类型
	 * @param useId
	 * @param sct_typ_nam
	 * @param crt_tim
	 * @param remark
	 * @return
	 */
	boolean addSctType(int useId, String sct_typ_nam, Date crt_tim, String remark);

	/**
	 * 获取安全类型
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getSctType(String id);

	/**
	 * 获取安全信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSct(Map<String,Object> map);

	/**
	 * 使用安全ID获取文件信息
	 * @param sct_id
	 * @return
	 */
	List<Map<String, Object>> getFileInfoBySctId(String sct_id);

	/**
	 * 删除安全类型
	 * @param id
	 * @return
	 */
	public boolean removeSctType(int id);

	/**
	 * 修改安全类型信息
	 * @param id
	 * @param sct_typ_nam
	 * @param mod_use_id
	 * @param mod_tim
	 * @param remark
	 * @return
	 */
	public boolean updateSctTypeInfo(int id, String sct_typ_nam, int mod_use_id, Date mod_tim, String remark);
	
	/**
	 * 向安全信息中添加文件
	 * @param sctId
	 * @param userId
	 * @param remark
	 * @param file
	 * @throws IOException
	 */
	public void addFileToSct(int sctId, int userId,String remark ,MultipartFile[] file) throws IOException;

	/**
	 * 安全信息分页计数
	 * @param map
	 * @return
	 */
	Map<String, Object> getSctCou(Map<String,Object> map);

	/**
	 * 获取安全类型分页计数
	 * @param map
	 * @return
	 */
	Map<String, Object> getKnwByTypeCou(Map<String,Object> map);

	/**
	 * 使用安全类型名称获取安全类型信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getSctTypeByName(Map<String, Object> map);

	/**
	 * 使用知识类型名称获取知识类型信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getKnwTypeByName(Map<String, Object> map);

	/**
	 * 使用文件ID获取知识文件信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getFileInfoById(int id);

	/**
	 * 使用安全文件ID获取安全文件信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getSctFileInfoById(int id);

}
