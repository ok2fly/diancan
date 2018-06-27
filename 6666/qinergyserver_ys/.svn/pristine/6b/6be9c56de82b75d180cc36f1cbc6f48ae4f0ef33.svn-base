package com.qinergy.dao.system;

import java.util.List;
import java.util.Map;

import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.DataDicDto;
import com.qinergy.dto.system.DataDicTypeDto;
import com.qinergy.dto.system.UserDto;
import com.qinergy.dto.system.UserRoleDto;

/**
 * @desc: UserDao 实现类，无接口
 * @author iceX
 * @date 2016年7月8日15:53:45
 */
public interface SystemDao {

//	String selectChaPilSta(Map<String, Object> map);

	/**
	 * 查询单位层级信息（上属单位，下属单位等）
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasComLev(UserDto userDto) throws Exception;

	/**
	 * id查询组织机构详情信息  
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasComInfo(Map<String, Object> map) throws Exception;

	/**
	 *  查询指定单位类别信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasComTypInfo(Map<String, Object> map) throws Exception;

	 /**
	  * 查询指定单位的下属单位信息
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getBasComSubComInfo(Map<String, Object> map) throws Exception;

	 /**
	  * 查询指定单位的部门信息 
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getBasComDepInfo(Map<String, Object> map) throws Exception;

	 /**
	  * 角色信息添加 
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
	  * 查询三级地区列表,一级（省级）
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getBasRegLst1Lev(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> getBasRegLst2Or3Lev(Map<String, Object> map) throws Exception;

	/**
	 *  查询地区信息使用ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRegInfById(Map<String, Object> map) throws Exception;

	 /**
	  * 查询地区列表,以区域标识为条件
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getBasRegInfByIde(Map<String, Object> map) throws Exception;

	 /**
	  * 查询上级单位名称，传的id为点击单位的com_fat_id
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getBasHigComNam(Map<String, Object> map) throws Exception;

	/**
	 *  查询指定单位类别信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasComTypAllInfo() throws Exception;

	 /**
	  * 查询所有单位信息
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getBasComAllLst() throws Exception;

	/**
	 *  获取所有设施类型 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasAppTypAll(Map<String, Object> map) throws Exception;

	 /**
	  * 获取所有厂家类型 
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
	 * 用户信息查询，以Id为条件(PC)
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getUserById(UserDto userDto) throws Exception;

	public void updDep(Map<String, Object> map) throws Exception;

	public void insDep(Map<String, Object> map) throws Exception;

	/**
	 * 查询地区信息使用父地址ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRegInfByFatId(Map<String, Object> map) throws Exception;

	/**
	 * 用户信息查询，以登录名为条件(PC)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserByLoginNamePC(Map<String, Object> map) throws Exception;

	/**
	 * 用户信息添加
	 * @param map
	 * @throws Exception
	 */
	public void insertUser(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> getOpeConInf(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> getChpInfByChpNum(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有公司类型信息 -
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllComTyp() throws Exception;

	/**
	 * 获取所有公司信息中的公司名称
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllComNam() throws Exception;

	public void insDic(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> getDicById(Map<String, Object> map) throws Exception;

	public void updDic(Map<String, Object> map) throws Exception;

	/**
	 * 获取厂家信息/列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getManInf(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有厂家类型列表 
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllManTyp() throws Exception;

	/**
	 * 新建厂家信息
	 * @param map
	 * @throws Exception
	 */
	public void insMan(Map<String, Object> map) throws Exception;

	/**
	 * 修改厂家信息
	 * @param map
	 * @throws Exception
	 */
	public void updMan(Map<String, Object> map) throws Exception;

	/**
	 * 删除厂家信息 
	 * @param map
	 * @throws Exception
	 */
	public void delMan(Map<String, Object> map) throws Exception;

	public void insFauTyp(Map<String, Object> map) throws Exception;

	public void updFauTyp(Map<String, Object> map) throws Exception;

	public void delFauTyp(Map<String, Object> map) throws Exception;

	public void delDic(Map<String, Object> map) throws Exception;

	/**
	 * 用户信息修改，以手机号、公司ID为条件
	 * @param map
	 * @throws Exception
	 */
	public void updateUser(Map<String, Object> map) throws Exception;

	/**
	 * 用户信息删除，以用户ID为条件 
	 * @param map
	 * @throws Exception
	 */
	public void deleteUser(Map<String, Object> map) throws Exception;

	/**
	 *  获取角色信息 -
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getAllRolInf(Map<String, Object> map) throws Exception;

	/**
	 *  获取职位信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPosInfLst(Map<String, Object> map) throws Exception;

	/**
	 *  获取部门信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDepInfLst(Map<String, Object> map) throws Exception;

	/**
	 *  获取学历信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEduInfLst(Map<String, Object> map) throws Exception;

	 /**
	  * 新建地区信息
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
	public int delReg(Map<String, Object> map) throws Exception;

	 /**
	  * 用户信息查询，以Id为条件(PC)
	  * @param map
	  * @return
	  * @throws Exception
	  */
	public List<Map<String, Object>> getUserById(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> getFauTypId(Map<String, Object> map) throws Exception;

	/**
	 * 获取所有设施
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasApp(Map<String, Object> map)
			throws Exception;

	/**
	 * 修改设备型号信息
	 * @param map
	 * @throws Exception
	 */
	public void updAppInf(Map<String, Object> map) throws Exception;

	 /**
	  * 删除设备信息 
	  * @param map
	  * @throws Exception
	  */
	public void delAppInf(Map<String, Object> map) throws Exception;

	public void insAppInf(Map<String, Object> map) throws Exception;

	/**
	 *  用户信息查询，以登录名为条件(PC)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserByLoginNamePCT(Map<String, Object> map)
			throws Exception;

	/**
	 *  用户信息查询，以登录名为条件(PC)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserByLoginNamePCTCou(Map<String, Object> map)
			throws Exception;

	/**
	 *  获取所有设施 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasAppCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取厂家信息/列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getManInfCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 查询三级地区列表,一级（省级）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRegLst1LevCou(Map<String, Object> map)
			throws Exception;

	/**
	 * 查询地区信息使用父地址ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBasRegInfByFatIdCou(Map<String, Object> map)
			throws Exception;

	public List<Map<String, Object>> getChpInfByChpNumNew(Map<String, Object> map)
			throws Exception;

   /**
    *  查询地区信息使用父地址ID(不分页)
    * @param map
    * @return
    * @throws Exception
    */
    List<Map<String, Object>> getBasRegInfByFatIdNotPage(Map<String, Object> map) throws Exception;

   /**
    *  删除公司信息
    * @param map
    * @return
    * @throws Exception
    */
	int deComLev(Map<String, Object> map) throws Exception;
	
	
   /**
    *  根据用户id查询所属公司id
    * @param map
    * @return
    * @throws Exception
    */
	List<Map<String, Object>> getComFat(Map<String, Object> map) throws Exception;

    /**
     * 本接口为使用公司ID获取其下所有子公司信息接口  业主公司
     * @param companyDto
     * @return
     * @throws Exception
     */
	List<Map<String, Object>> getFatComInfByComIdRol(CompanyDto companyDto) throws Exception;
	
    /**
     * 为使用公司ID获取业主公司信息接口  业主公司
     * @param companyDto
     * @return
     * @throws Exception
     */
	public List<Map<String, Object>> getComInfByComIdRol(CompanyDto companyDto) throws Exception;
	
   /**
    *  本接口为使用公司ID获取其下所有子公司信息接口  合作伙伴-
    * @param companyDto
    * @return
    * @throws Exception
    */
	List<Map<String, Object>> getFatComInfByComIdRol2(CompanyDto companyDto) throws Exception;
	
    /**
     * 为使用公司ID获取合作公司信息接口 合作伙伴
     * @param companyDto
     * @return
     * @throws Exception
     */
	public List<Map<String, Object>> getComInfByComIdRol2(CompanyDto companyDto) throws Exception;

   /**
    *  id查询业主详情信息 
    * @param map
    * @return
    * @throws Exception
    */
	public List<Map<String, Object>> getBasComInfoRol(Map<String, Object> map) throws Exception;
	
    /**
     * 修改业主公司信息 
     * @param map
     * @throws Exception
     */
	public void updateComInfoRol (Map<String, Object> map) throws Exception;
    
    /**
     * 添加业主 公司信息
     * @param map
     * @throws Exception
     */
    public void insertComInfoRol(Map<String, Object> map) throws Exception;
  
	/**
	 * 修改合作伙伴信息
	 * @param map
	 * @throws Exception
	 */
	void updateComInfoRol2(Map<String, Object> map) throws Exception;

   /**
    * 添加合作伙伴信息 
    * @param map
    * @throws Exception
    */
	void insertComInfoRol2(Map<String, Object> map) throws Exception;
	

	/** 数据字典管理 start*/
    
    /**
     * 数据字典添加
     * @param map
     * @throws Exception
     */
	public void insDataDic(Map<String, Object> map) throws Exception;
	
    /**
     * 更新
     * @param map
     * @throws Exception
     */
	public void updDataDic(Map<String, Object> map) throws Exception;
	
	/**
	 * 删除
	 * @param map
	 * @throws Exception
	 */
	public void delDataDic(Map<String, Object> map) throws Exception;
	
	/**
	 * id查看数据字典删除标识
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getDataDicFlag(Map<String, Object> map) throws Exception;
	
	/**
	 * id查看该信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public DataDicDto getDataDicById(Map<String, Object> map) throws Exception;
	
	/**
	 * 分页 总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getDicListCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 列表显示 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDataDicListByTypAndNam(Map<String, Object> map) throws Exception;
	
	/**
	 * 添加数据字典类型
	 * @param map
	 * @throws Exception
	 */
	public void insDataDicTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改数据字典类型
	 * @param map
	 * @throws Exception
	 */
	public void updDataDicTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 删除数据字典类型
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int delDataDicTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * id查看数据字典类型删除标识
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getDataDicTypFlag(Map<String, Object> map) throws Exception;
	
	/**
	 * id查看该数据字典类型信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public DataDicTypeDto getDataDicTypById(Map<String, Object> map) throws Exception;
	
	/**
	 * 数据字典类型 总数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int getDataDicTypCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 数据字典类型列表查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getDataDicTypList(Map<String, Object> map) throws Exception;
	/** 数据字典管理  end*/
	
	
	/*告警码和类型维护start*/

	/**
	 * 告警码 添加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	int InsertAlaCode(Map<String, Object> map) throws Exception;

	/**
	 * 告警码 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int removeAlaCode(int id) throws Exception;
	
	/**
	 * 告警码 更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	int updateAlaCodeInfo(Map<String,Object> map)throws Exception;
	
	/**
	 * 告警类型 添加
	 * @param map
	 * @return
	 */
	int InsertAlaType(Map<String,Object> map);
	
	/**
	 * 告警类型 删除
	 * @param id
	 * @return
	 */
	int removeAlaType(int id);
	
	/**
	 * 根据类型 查询告警码
	 * @param id
	 * @return
	 */
	int getAlaCodeCountByType(int id);
	
	/**
	 * 告警类型 查询
	 * @param id
	 * @return
	 */
	List<Map<String,Object>> getAlaType(String id);
	
	/**
	 * 告警码查询
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getAlaCode(Map<String,Object> map);
	
	/**
	 * id 查看设备类型
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getAppInfoById(String id);
	
	/**
	 * 修改一个告警类型 
	 * @param map
	 * @return
	 */
	int updateAlaType(Map<String,Object> map);
	/*告警码和类型维护start*/
	
	/**
	 * 新建厂家类型信息
	 * @param map
	 * @throws Exception
	 */
	void insManTyp(Map<String, Object> map) throws Exception;

	/**
	 * 修改厂家类型信息
	 * @param map
	 * @throws Exception
	 */
	void updManTyp(Map<String, Object> map) throws Exception;

	/**
	 * 删除厂家类型信息
	 * @param map
	 * @throws Exception
	 */
	void delManTyp(Map<String, Object> map) throws Exception;

	/**
	 * 添加设备类型信息
	 * @param map
	 * @throws Exception
	 */
	void insAppTyp(Map<String, Object> map) throws Exception;

	/**
	 * 修改设备类型信息
	 * @param map
	 * @throws Exception
	 */
	void delAppTyp(Map<String, Object> map) throws Exception;

	/**
	 * 删除设备类型信息
	 * @param map
	 * @throws Exception
	 */
	void updAppTyp(Map<String, Object> map) throws Exception;
	
	/**
	 * 使用设备型号ID获取设备型号信息
	 * @param map
	 * @throws Exception
	 */
	List<Map<String, Object>> getBasAppById(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取某个站内所有制定设备类型的设备的信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getEquInfLstByPwsIdAppTyp(Map<String, Object> map);

	/**
	 * 获取站点名称使用ID
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPwsNamByPwsId(Map<String, Object> map);

	/**
	 * 获取某个站内充电桩的设备的信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getChpInfLstByPwsIdAppTyp(Map<String, Object> map);
	
	/**
	 * 使用用户ID获取公司信息以及用户信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	public List<Map<String, Object>> getComInfAndUseInfByUseId(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取站点信息，使用ID
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getPwsInfLstByPwsId(Map<String, Object> map);
	
	
	/**
	 * 获取设备列表信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getEquInfLst(Map<String, Object> map);
	
	/**
	 * 统计设备列表信息中数据的数量，做分页时用
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getEquInfLstCou(Map<String, Object> map);
	
	
	/**
	 * 获取设备列表信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getCtlEquInfLst(Map<String, Object> map);
	
	/**
	 * 使用设备ID获取设备信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getEquInfByEquId(Map<String, Object> map);
	
	/**
	 * 统计设备列表信息中数据的数量，做分页时用
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getCtlEquInfLstCou(Map<String, Object> map);
	
	/**
	 * 新增设备详细信息
	 * @param map
	 * @throws Exception
	 */
	void insertEquInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改某设备详细信息
	 * @param map
	 * @throws Exception
	 */
	void updateEquInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 逻辑删除某设备详细信息
	 * @param map
	 * @throws Exception
	 */
	void delectEquInfo(Map<String, Object> map) throws Exception;

	/**
	 * 获取业主、合作伙伴信息列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getComRolOneAndTwo(Map<String, Object> map);

	
	/**
	 * 修改地区信息
	 * @param map
	 * @return
	 */
	void updReg(Map<String, Object> map);

	/**
	 * 获取电站信息列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPwsInfLst(Map<String, Object> map);

	/**
	 * 获取电站信息列表（分页）
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPwsInfLstCou(Map<String, Object> map);

	/**
	 * 修改电站信息
	 * @param map
	 * @return
	 */
	void updatePwsInfo(Map<String, Object> map);

	/**
	 * 删除电站信息
	 * @param map
	 * @return
	 */
	void delectPwsInfo(Map<String, Object> map);

	/**
	 * 添加电站信息
	 * @param map
	 * @return
	 */
	void insertPwsInfo(Map<String, Object> map);

	
	
	
	
	/**
	 * 巡视任务  关于我创建的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selAppointTourTaskByUserId(Map<String, Object> map);

	/**
	 * 巡视任务  发布人 修改 
	 * @param map
	 */
	void updTourTaskByUserId(Map<String, Object> map);

	/**
	 * 巡视任务  执行人  修改
	 * @param map
	 */
	void updTourTaskExecuteByUserId(Map<String, Object> map);

	/**
	 *  巡视任务  执行人  修改
	 * @param map
	 */
	void updTourTaskCheckByUserId(Map<String, Object> map);

	/**
	 *  巡视任务  关于我执行的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selExecuteTourTaskByUserId(Map<String, Object> map);

	/**
	 *  巡视任务  关于我审核的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selCheckTourTaskByUserId(Map<String, Object> map);

	/**
	 *  检修任务  关于我创建的用户-
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selAppointOverhaulTaskByUserId(
			Map<String, Object> map);

	/**
	 *  检修任务  关于我执行的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selExecuteOverhaulTaskByUserId(
			Map<String, Object> map);

	/**
	 *  检修任务  关于我审核的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selCheckOverhaulTaskByUserId(
			Map<String, Object> map);

	/**
	 *  检修任务  发布人 修改
	 * @param map
	 */
	void updOverhaulTaskByUserId(Map<String, Object> map);

	 /**
	  * 检修任务  执行人  修改 
	  * @param map
	  */
	void updOverhaulTaskExecuteByUserId(Map<String, Object> map);

	 /**
	  * 检修任务  执行人  修改
	  * @param map
	  */
	void updOverhaulTaskCheckByUserId(Map<String, Object> map);

	/**
	 *  报修任务  关于我创建的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selCrtUseRepairTaskByUserId(
			Map<String, Object> map);

	/**
	 *  报修任务  关于我维修的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selRepairUserRepairTaskByUserId(
			Map<String, Object> map);

	/**
	 *  报修任务  关于我审核的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selCheckRepairTaskByUserId(Map<String, Object> map);

	/**
	 *  报修任务  创建人 修改
	 * @param map
	 */
	void updRepairTaskCrtUseByUserId(Map<String, Object> map);

	/**
	 *  报修任务  维修人  修改
	 * @param map
	 */
	void updRepairTaskRepairUserByUserId(Map<String, Object> map);

	/**
	 *  报修任务  审核人  修改
	 * @param map
	 */
	void updRepairTaskCheckByUserId(Map<String, Object> map);

	 /**
	  * 报废任务  关于我创建的用户
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> selCrtUseScrapTaskByUserId(Map<String, Object> map);

	/**
	 *  报废任务  关于我第一次审核的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selOneCheckScrapTaskByUserId(
			Map<String, Object> map);

	/**
	 *  报废任务  关于我第二次审核的用户
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selTwoCheckScrapTaskByUserId(
			Map<String, Object> map);

	/**
	 *  报废任务  创建人 修改
	 * @param map
	 */
	void updScrapTaskCrtUseByUserId(Map<String, Object> map);

	/**
	 *  报修任务  第一次审核  修改
	 * @param map
	 */
	void updScrapTaskOneCheckByUserId(Map<String, Object> map);

	/**
	 *  报修任务  第二次审核  修改
	 * @param map
	 */
	void updScrapTaskTwoCheckByUserId(Map<String, Object> map);
	
	/**
	 * 添加用户与站点间的关联关系
	 * @param map
	 * @return
	 */
	void insertUseAndPwsInf(Map<String, Object> map);

	/**
	 * 删除用户与站点间的关联关系
	 * @param map
	 * @return
	 */
	void deleteUseAndPwsInfByUseId(Map<String, Object> map);

	
	/**
	 * 使用用户ID获取用户与站关联表中的站点信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getUseAndPwsInfLst(Map<String, Object> map);

	/**
	 * 使用ID获取获取厂家类型
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAllManTypById(Map<String, Object> map);

	/**
	 *  id查看  角色信息 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getUserRoleById(Map<String, Object> map);

	/**
	 *  角色信息  修改
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> updateUserRole(Map<String, Object> map);

	 /**
	  * 角色名称 查看  角色信息 
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> getUserRoleByRolNam(Map<String, Object> map);

	/**
	 *  公司信息 添加图片 logo
	 * @param map
	 * @throws Exception
	 */
	void insertComLogoImg(Map<String, Object> map) throws Exception;

	/**
	 *  故障 分页
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAlaCodeInfoCou(Map<String, Object> map);

	 /**
	  * 使用公司id 获取公司所有信息 包括公司logo及缩略图地址
	  * @param map
	  * @return
	  * @throws Exception
	  */
	List<Map<String, Object>> getComLogoImgById(Map<String, Object> map)throws Exception;

	/**
	 *  查询三级地区列表,一级（省级）(所有) 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getBasRegLst1LevAll(Map<String, Object> map);

	/**
	 *  上传电站图片
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> insertPwsPic(Map<String, Object> map);

	 /**
	  * 使用电站id 查询该电站图片总数量   不可以超过2张图片
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> getPwsPicByPwsId(Map<String, Object> map);

	/**
	 *  使用电站id 查询该电站最先添加的图片的信息 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPwsOldPicByPwsId(Map<String, Object> map);

	/**
	 *  删除 电站图片   
	 * @param map
	 */
	void deletePwsPic(Map<String, Object> map);

	/**
	 *  使用 设备编号  查询 设备名称 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getEquNameByEquNum(Map<String, Object> map);
	/**
	 * 获取所有电表类型列表
	 * @return
	 */
	List<Map<String, Object>> getMeterTypLstAll();

	/**
	 * 新增Mqtt详细信息
	 */
	void insertMqtt(Map<String, Object> map);

	/**
	 * 使用设备编号获取某Mqtt详细信息
	 */
	List<Map<String, Object>> getMqttInfByEquNum(Map<String, Object> map);

	/**
	 * 修改Mqtt详细信息
	 */
	void updateMqtt(Map<String, Object> map);

	/**
	 * 获取所有运维公司信息中的公司名称
	 */
	List<Map<String, Object>> getAllOptComNam();

	/**
	 * 获取所有业主公司信息中的公司名称
	 */
	List<Map<String, Object>> getAllOwnComNam();

	/**
	 * 意见反馈  列表展示
	 */
	List<Map<String, Object>> selFeedBackAll(Map<String, Object> map);
	/**
	 * 意见反馈 分页
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selFeedBackAllCou(Map<String, Object> map);

	/**
	 * 意见反馈  新增 
	 * @param map
	 */
	void insertFeedBack(Map<String, Object> map);
	/**
	 * 意见反馈  删除 
	 * @param map
	 */
	void delFeedBackById(Map<String, Object> map);

	/**
	 * 意见反馈   回复 
	 * @param map
	 */
	void updReplyById(Map<String, Object> map);

	/**
	 * 数据字典类型 通过 类型 名称 查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDataDicTypByName(Map<String, Object> map)
			throws Exception;
	/**
	 * 获取站点列表信息(二级公司查询)
	 * @param map
	 */
	List<Map<String, Object>> getPwsInfLstBy2LevCom(Map<String, Object> map);

	/**
	 * 获取站点列表信息(一级公司查询)(分页)
	 * @param map
	 */
	List<Map<String, Object>> getPwsInfLstBy1LevComCou(Map<String, Object> map);

	/**
	 * 获取站点列表信息(二级公司查询)(分页)
	 * @param map
	 */
	List<Map<String, Object>> getPwsInfLstBy2LevComCou(Map<String, Object> map);

	/**
	 * 获取站点列表信息(一级公司查询)
	 * @param map
	 */
	List<Map<String, Object>> getPwsInfLstBy1LevCom(Map<String, Object> map);

	/**
	 * 数据字典 id 查看详情
	 * @param map
	 * @return
	 * @throws Exception
	 */
	int getDataDicTypId(Map<String, Object> map) throws Exception;

	/**
	 * 获取厂家信息/下拉框/全部
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getManInfAll() throws Exception;

	/**
	 * 使用当前地区ID,获取其下级地区信息 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	int getFatRegByRegId(Map<String, Object> map) throws Exception;

	/**
	 * id 查看公司 详情
	 * @param map
	 * @return
	 * @throws Exception
	 */
	int getComByFatId(Map<String, Object> map) throws Exception;

	/**
	 *  用户头像 添加 
	 * @param map
	 */
	void insertUserImg(Map<String, Object> map);

	/**
	 *  意见反馈  列表展示使用用户ID 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selFeedBackByUseId(Map<String, Object> map);

	

}
