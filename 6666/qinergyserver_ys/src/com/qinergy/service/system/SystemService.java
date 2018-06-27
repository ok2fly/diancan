/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.DataDicDto;
import com.qinergy.dto.system.DataDicTypeDto;
import com.qinergy.dto.system.UserDto;
import com.qinergy.dto.system.UserRoleDto;

import net.sf.json.JSONObject;

/**
 * 系统管理中涉及到的接口
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public interface SystemService {

	/**
	 * 根据查询条件获取公司信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getBasComInfo(Map<String, Object> map) throws Exception;

	/**
	 * 添加用户角色信息
	 * @param userRoleDto
	 * @throws Exception
	 */
	public void insertUserRole(UserRoleDto userRoleDto) throws Exception;

	/**
	 * 修改公司信息
	 * @param map
	 * @throws Exception
	 */
	public void updateComInfo(Map<String, Object> map) throws Exception;

	/**
	 * 获取省级地区列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRegLst1Lev(Map<String, Object> map) throws Exception;

	/**
	 * 获取市级或区级地区信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRegLst2Or3Lev(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有设备类型列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasAppTypAll(Map<String,Object> map) throws Exception;

	/**
	 * 获取所有厂家类型信息列表
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasManTypAll() throws Exception;

	/**
	 * 添加公司信息
	 * @param map
	 * @throws Exception
	 */
	public void insertComInfo(Map<String, Object> map) throws Exception;

	/**
	 * 修改部门信息
	 * @param map
	 * @throws Exception
	 */
	public void updDep(Map<String, Object> map) throws Exception;

	/**
	 * 添加部门信息
	 * @param map
	 * @throws Exception
	 */
	public void insDep(Map<String, Object> map) throws Exception;

	/**
	 * 查询地区信息使用ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRegInfById(Map<String, Object> map) throws Exception;

	/**
	 * 查询地区信息使用父地址ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRegInfByFatId(Map<String, Object> map) throws Exception;

	/**
	 * 使用登录名，获取用户信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserByLoginNamePC(Map<String, Object> map) throws Exception;

	/**
	 * 添加用户信息
	 * @param map
	 * @throws Exception
	 */
	public void insertUser(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有公司类型
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllComTyp() throws Exception;

	/**
	 * 获取所有公司名称
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllComNam() throws Exception;

	/**
	 * 添加字典信息
	 * @param map
	 * @throws Exception
	 */
	public void insDic(Map<String, Object> map) throws Exception;

	/**
	 * 通过字典ID获取数据字典信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDicById(Map<String, Object> map) throws Exception;

	/**
	 * 修改字典信息
	 * @param map
	 * @throws Exception
	 */
	public void updDic(Map<String, Object> map) throws Exception;

	/**
	 * 根据条件获取厂家信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getManInf(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有厂家类型信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllManTyp() throws Exception;

	/**
	 * 添加厂家信息
	 * @param map
	 * @throws Exception
	 */
	public void insMan(Map<String, Object> map) throws Exception;

	/**
	 * 删除厂家信息
	 * @param map
	 * @throws Exception
	 */
	public void delMan(Map<String, Object> map) throws Exception;

	/**
	 * 修改厂家信息
	 * @param map
	 * @throws Exception
	 */
	public void updMan(Map<String, Object> map) throws Exception;
	
	/**
	 * 添加告警类型信息
	 * @param map
	 * @throws Exception
	 */
	public void insFauTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 删除告警类型信息
	 * @param map
	 * @throws Exception
	 */
	public void delFauTyp(Map<String, Object> map) throws Exception;
	/**
	 * 添加告警类型信息
	 * @param map
	 * @throws Exception
	 */
	public void updFauTyp(Map<String, Object> map) throws Exception;

	/**
	 * 删除字典信息
	 * @param map
	 * @throws Exception
	 */
	public void delDic(Map<String, Object> map) throws Exception;

	/**
	 * 修改用户信息
	 * @param map
	 * @throws Exception
	 */
	public void updateUser(Map<String, Object> map) throws Exception;

	/**
	 * 删除用户信息
	 * @param map
	 * @throws Exception
	 */
	public void deleteUser(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有角色信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllRolInf(Map<String, Object> map) throws Exception;

	/**
	 * 获取职位信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPosInfLst(Map<String, Object> map) throws Exception;

	/**
	 * 获取部门信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDepInfLst(Map<String, Object> map) throws Exception;

	/**
	 * 获取学历信息列表 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEduInfLst(Map<String, Object> map) throws Exception;

	/**
	 * 添加地区信息
	 * @param map
	 * @throws Exception
	 */
	public void insReg(Map<String, Object> map) throws Exception;

	/**
	 * 删除地区信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public boolean delReg(Map<String, Object> map) throws Exception;

	/**
	 * 使用用户ID获取用户信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserById(Map<String, Object> map) throws Exception;

	/**
	 * 获取某一条告警故障信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getFauTypId(Map<String, Object> map) throws Exception;

	/**
	 * 获取设备型号信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBasApp(Map<String, Object> map) throws Exception;

	/**
	 * 修改设备型号信息
	 * @param map
	 * @throws Exception
	 */
	void updAppInf(Map<String, Object> map) throws Exception;

	/**
	 * 删除设备型号信息
	 * @param map
	 * @throws Exception
	 */
	void delAppInf(Map<String, Object> map) throws Exception;

	/**
	 * 添加设备型号信息
	 * @param map
	 * @throws Exception
	 */
	void insAppInf(Map<String, Object> map) throws Exception;

	/**
	 * 使用登录名获取用户信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getUserByLoginNamePCT(Map<String, Object> map) throws Exception;

	/**
	 * 使用登录名获取用户信息总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getUserByLoginNamePCTCou(Map<String, Object> map) throws Exception;

	/**
	 * 获取设备型号总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getBasAppCou(Map<String, Object> map) throws Exception;

	/**
	 * 获取厂家信息总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getManInfCou(Map<String, Object> map) throws Exception;

	/**
	 * 获取升级地区总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getBasRegLst1LevCou(Map<String, Object> map) throws Exception;

	/**
	 * 查询地区信息使用父地址ID(获取查询回来的数据总数量)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getBasRegInfByFatIdCou(Map<String, Object> map) throws Exception;

	/**
	 * 询地区信息使用父地址ID(不分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBasRegInfByFatIdNotPage(Map<String, Object> map) throws Exception;

	/**
	 * 删除某一条公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	boolean delComLev(Map<String, Object> map) throws Exception;

	/**
	 * 根据ID获取所属公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getComFat(Map<String, Object> map) throws Exception;

	/**
	 * 根据公司ID获取业主/合作伙伴公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasComInfoRol(Map<String, Object> map) throws Exception;

	/**
	 * 业主信息修改
	 * @param map
	 * @throws Exception
	 */
	public void updateComInfoRol(Map<String, Object> map) throws Exception;

	/**
	 * 业主信息添加
	 * @param map
	 * @throws Exception
	 */
	public void insertComInfoRol(Map<String, Object> map) throws Exception;

	/**
	 * 合作伙伴修改
	 * @param map
	 * @throws Exception
	 */
	void updateComInfoRol2(Map<String, Object> map) throws Exception;

	/**
	 * 合作伙伴添加
	 * @param map
	 * @throws Exception
	 */
	void insertComInfoRol2(Map<String, Object> map) throws Exception;

	/** 数据字典管理 start */
	/**
	 * 添加数据字典信息
	 * @param dataDicDto
	 * @throws Exception
	 */
	public void insDataDic(DataDicDto dataDicDto) throws Exception;

	/**
	 * 修改数据字典信息
	 * @param dataDicDto
	 * @throws Exception
	 */
	public void updDataDic(DataDicDto dataDicDto) throws Exception;

	/**
	 * 删除某一条数据字典信息
	 * @param map
	 * @throws Exception
	 */
	public void delDataDic(Map<String, Object> map) throws Exception;

	/**
	 * 获取某一条数据字典
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public DataDicDto getDataDicById(Map<String, Object> map) throws Exception;

	/**
	 * 获取数据字典总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getDicListCount(Map<String, Object> map) throws Exception;

	/**
	 * 使用数据字典类型名称获取数据字典信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDataDicListByTypAndNam(Map<String, Object> map) throws Exception;

	/**
	 * 添加数据字典类型
	 * @param dataDicTypeDto
	 * @throws Exception
	 */
	public void insDataDicTyp(DataDicTypeDto dataDicTypeDto) throws Exception;

	/**
	 * 修改数据字典类型信息
	 * @param dataDicTypeDto
	 * @throws Exception
	 */
	public void updDataDicTyp(DataDicTypeDto dataDicTypeDto) throws Exception;

	/**
	 * 删除某一条数据字典类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public boolean delDataDicTyp(Map<String, Object> map) throws Exception;

	/**
	 * 获取某一条数据字典类型删除标记
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getDataDicTypFlag(Map<String, Object> map) throws Exception;

	/**
	 * 获取某一条数据字典类型信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public DataDicTypeDto getDataDicTypById(Map<String, Object> map) throws Exception;

	/**
	 * 获取数据字典类型总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getDataDicTypCount(Map<String, Object> map) throws Exception;

	/**
	 * 获取数据字典类型信息列表 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDataDicTypList(Map<String, Object> map) throws Exception;

	/** 数据字典管理 end */

	/* 告警码和类型维护Start */
	/**
	 * 添加告警码信息
	 * @param ala_ide
	 * @param app_typ_id
	 * @param idx_pst
	 * @param ala_typ_id
	 * @param flt_lev
	 * @param ala_info
	 * @param remark
	 * @param crt_use_id
	 * @param crt_tim
	 * @return
	 * @throws Exception
	 */
	int InsertAlaCode(String ala_ide, String app_typ_id, String idx_pst, String ala_typ_id, String flt_lev,
			String ala_info, String remark, String crt_use_id, Date crt_tim) throws Exception;

	/**
	 * 删除告警码信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int removeAlaCode(int id) throws Exception;

	/**
	 * 修改告警码信息
	 * @param id
	 * @param app_typ_id
	 * @param idx_pst
	 * @param flt_lev
	 * @param ala_typ_id
	 * @param ala_info
	 * @param remark
	 * @param mod_use_id
	 * @param mod_tim
	 * @return
	 * @throws Exception
	 */
	int updateAlaCodeInfo(int id,String app_typ_id, String idx_pst, String flt_lev, String ala_typ_id, String ala_info,
			String remark, String mod_use_id, Date mod_tim) throws Exception;
	
	/**
	 * 添加告警类型信息
	 * @param ala_nam
	 * @param app_typ_id
	 * @param crt_use_id
	 * @param crt_tim
	 * @param remark
	 * @return
	 * @throws Exception
	 */
	boolean insertAlaTyp(String ala_nam,int app_typ_id ,int crt_use_id,Date crt_tim,String remark)throws Exception;
	
	/**
	 * 删除告警类型信息
	 * @param id
	 * @return
	 */
	boolean removeAlaType(int id);
	
	/**
	 * 获取告警类型信息
	 * @param id
	 * @return
	 */
	List<Map<String,Object>> getAlaType(String id);
	
	/**
	 * 获取告警码信息
	 * @param map
	 * @return
	 */
	List<Map<String,Object>>  getAla(Map<String,Object> map);
	
	/**
	 * 获取某一条设备型号信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>>getAppInfoById(String id);
	
	/**
	 * 修改告警类型
	 * @param ala_nam
	 * @param app_typ_id
	 * @param mod_use_id
	 * @param mod_tim
	 * @param remark
	 * @param id
	 * @return
	 */
	boolean updateAlaType(String ala_nam,String app_typ_id,String mod_use_id,Date mod_tim,String remark,String id);
	/* 告警码和类型维护End */

	/**
	 * 新建厂家类型信息
	 */
	void insManTyp(Map<String, Object> map) throws Exception;

	/**
	 * 删除厂家类型信息
	 */
	void delManTyp(Map<String, Object> map) throws Exception;

	/**
	 * 修改厂家类型信息
	 */
	void updManTyp(Map<String, Object> map) throws Exception;

	/**
	 * 添加设备类型信息
	 */
	void insAppTyp(Map<String, Object> map) throws Exception;

	/**
	 * 修改厂家类型信息
	 */
	void updAppTyp(Map<String, Object> map) throws Exception;

	/**
	 * 删除设备类型信息
	 */
	void delAppTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 使用设备型号ID获取某一条设备型号信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getBasAppById(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取设备列表信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getEquInfLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 统计设备列表信息中数据的数量，做分页时用
	 * @param map
	 * @return map
	 */
	Map<String, Object> getEquInfLstCou(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取设备列表信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getCtlEquInfLst(Map<String, Object> map) throws Exception;
	
	/**
	 * 使用设备ID获取设备信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getEquInfByEquId(Map<String, Object> map) throws Exception;
	
	/**
	 * 统计设备列表信息中数据的数量，做分页时用
	 * @param map
	 * @return map
	 */
	Map<String, Object> getCtlEquInfLstCou(Map<String, Object> map) throws Exception;
	
	/**
	 * 新增设备详细信息
	 * @param map
	 * @return map
	 */
	void insertEquInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改设备详细信息
	 * @param map
	 * @return map
	 */
	void updateEquInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 逻辑删除某设备详细信息
	 * @param map
	 * @return map
	 */
	void delectEquInfo(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 业主、合作伙伴列表显示
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getComRolOneAndTwo(Map<String, Object> map)
			throws Exception;

	
	/**
	 * 修改地区信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void updReg(Map<String, Object> map) throws Exception;

	/**
	 * 查询电站列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfLst(Map<String, Object> map) throws Exception;

	/**
	 * 使用电站ID获取电站详情信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfLstByPwsId(Map<String, Object> map) throws Exception;
	
	/**
	 * 查询电站列表信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getPwsInfLstCou(Map<String, Object> map) throws Exception;
	

	/**
	 * 添加电站信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void insertPwsInfo(Map<String, Object> map) throws Exception;

	/**
	 * 修改电站信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void updatePwsInfo(Map<String, Object> map) throws Exception;

	/**
	 * 删除电站信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void delectPwsInfo(Map<String, Object> map) throws Exception;

	/**
	 * 本接口为获取平台中所有客户公司的信息接口
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOwnerComLst() throws Exception;
	
	/**
	 * 本接口为获取平台中所有运维公司的信息接口
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOptComLst() throws Exception;

	
	
	
	
	/**
	 *  使用用户id 把所属任务转移给另一个人
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> moveTaskByUserId(Map<String, Object> map)
			throws Exception;

	/**
	 * 添加用户与站点间的关联关系
	 * @param map
	 * @return
	 */
	void insertUseAndPwsInf(Map<String, Object> map) throws Exception;

	/**
	 * 删除用户与站点间的关联关系
	 * @param map
	 * @return
	 */
	void deleteUseAndPwsInfByUseId(Map<String, Object> map) throws Exception;

	/**
	 * 获取系统内的一级公司/二级公司/三级公司下所属的站点与传入的用户ID所关联的站点的对比树
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getUseAndPwsInfLst(Map<String, Object> map)
			throws Exception;

	
	/**
	 * 使用ID获取获取厂家类型
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAllManTypById(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取公司列表信息
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getComLst() throws Exception;

	
	
	/**
	 * id查看  角色信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getUserRoleById(Map<String, Object> map)
			throws Exception;
	/**
	 *  角色信息  修改 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> updateUserRole(Map<String, Object> map)
			throws Exception;
	/**
	 *   角色名称 查看 角色信息  
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getUserRoleByRolNam(Map<String, Object> map)
			throws Exception;

	/**
	 *   公司信息 添加图片 logo  
	 * @param map
	 * @return
	 */
	BaseTransferEntity uploadComImg(Map<String, Object> map,
			MultipartFile[] file, String filePath);

	/**
	 * 上传公司logo
	 * @param file
	 * @return
	 */
	BaseTransferEntity uploadComImgLogo(MultipartFile file);

	/**
	 * 获取告警码信息数量(分页)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getAlaCodeInfoCou(Map<String, Object> map)
			throws Exception;

	/**
	 *   使用公司id 获取公司所有信息 包括公司logo及缩略图地址 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getComLogoImgById(Map<String, Object> map)throws Exception;

	/**
	 * 本接口为获取平台中所有自己公司的信息接口（组织机构处使用）
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getOneselfComLst(Map<String,Object> map) throws Exception;

	/**
	 * 查询三级地区列表,一级（省级）(所有)
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getBasRegLst1LevAll(Map<String, Object> map) throws Exception;

	
	/**
	 *   电站 上传图片
	 * @param map
	 * @return
	 */
	BaseTransferEntity uploadPws(MultipartFile file);
	
	/**
	 * 上传电站照片
	 * @param map
	 * @param files
	 * @param filePath
	 * @return
	 */
	BaseTransferEntity uploadPwsPic(Map<String, Object> map,
			MultipartFile[] files, String filePath);

	/**
	 * 使用电站ID获取电站图片
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsPicByPwsId(Map<String, Object> map)
			throws Exception;

	
	/**
	 * 使用电站id 查询该电站最先添加的图片的信息
	 */
	List<Map<String, Object>> getPwsOldPicByPwsId(Map<String, Object> map)
			throws Exception;

	/**
	 * 删除 电站图片 
	 */
	void deletePwsPic(Map<String, Object> map) throws Exception;

	
	/**
	 * 使用 设备编号  查询 设备名称
	 */
	List<Map<String, Object>> getEquNameByEquNum(Map<String, Object> map)throws Exception;

	/**
	 * 获取所有电表类型列表
	 */
	List<Map<String, Object>> getMeterTypLstAll() throws Exception;

	
	/**
	 * 新增Mqtt详细信息
	 */
	void insertMqtt(Map<String, Object> map) throws Exception;

	
	/**
	 * 修改Mqtt详细信息
	 */
	void updateMqtt(Map<String, Object> map) throws Exception;

	/**
	 * 使用设备编号获取某Mqtt详细信息
	 */
	List<Map<String, Object>> getMqttInfByEquNum(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有运维公司信息中的公司名称
	 */
	List<Map<String, Object>> getAllOptComNam() throws Exception;

	/**
	 * 获取所有业主公司信息中的公司名称
	 */
	List<Map<String, Object>> getAllOwnComNam() throws Exception;

	/**
	 *  意见反馈  列表展示 
	 */
	List<Map<String, Object>> selFeedBackAll(Map<String, Object> map)
			throws Exception;
	
	/**
	 * 查询所有意见反馈数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selFeedBackAllCou(Map<String, Object> map)
			throws Exception;

	/**
	 *  意见反馈  新增
	 */
	void insertFeedBack(Map<String, Object> map) throws Exception;
	/**
	 *  意见反馈   删除
	 */
	void delFeedBackById(Map<String, Object> map) throws Exception;
	/**
	 *  意见反馈   回复
	 */
	void updReplyById(Map<String, Object> map) throws Exception;

	/**
	 * 使用名称查询数据字典类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDataDicTypByName(Map<String, Object> map) throws Exception;

	/**
	 * 使用公司ID获取电站信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsInfLstByComId(Map<String, Object> map) throws Exception;

	/**
	 * 本接口为获取平台中所有自己公司的信息接口（组织机构处使用）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getOrgFatComInfByComId(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有厂商信息
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getManInfAll() throws Exception;

	/**
	 * 使用公司ID获取电站ID列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPwsIdByComId(Map<String, Object> map) throws Exception;

	/**
	 * 添加用户头像
	 * @param file
	 * @return
	 */
	BaseTransferEntity insertUserImg(MultipartFile file);

	/**
	 * 上传用户头像
	 * @param map
	 * @param files
	 * @param filePath
	 * @return
	 */
	BaseTransferEntity uploadUserImg(Map<String, Object> map,
			MultipartFile[] files, String filePath);

	/**
	 * 使用用户ID获取意见反馈信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selFeedBackByUseId(Map<String, Object> map)
			throws Exception;

	
}
