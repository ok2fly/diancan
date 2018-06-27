package com.qinergy.dao.utils;

import java.util.List;
import java.util.Map;

import com.qinergy.dto.system.CompanyDto;
import com.qinergy.dto.system.UserDto;

/**
 * @desc: UtilsDao 工具类实现类
 * @author iceX
 * @date 2016年7月8日15:53:45
 */
public interface UtilsDao {
	
	/**
	 * 本接口为使用userId获取公司信息接口
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getComInfByUseId(UserDto userDto) throws Exception;
	
	/**
	 * 本接口为使用公司ID获取公司信息接口
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getComInfByComId(CompanyDto companyDto) throws Exception;
	
	/**
	 * 本接口为使用子公司ID获取其下所有电站接口
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getPwsLstByComId(CompanyDto companyDto) throws Exception;
	/**
	 * 本接口为使用子公司ID获取其下所有子公司接口
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getFatComInfByComId(CompanyDto companyDto) throws Exception;
	
	/**
	 * 本接口为使用运维人员用户ID,获取所有与此运维人员有关的1级公司ID接口
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getFstLevComLstByOptUseId(Map<String,Object> map) throws Exception;
	
	/**
	 * 本接口为使用运维人员用户ID,获取所有与此运维人员有关的2级公司ID接口
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getTwoLevComLstByOptUseId(Map<String,Object> map) throws Exception;
	
	/**
	 * 本接口为使用运维人员用户ID,获取所有与此运维人员有关的3级公司ID接口
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getThrLevComLstByOptUseId(Map<String,Object> map) throws Exception;
	
	/**
	 * 本接口为使用设备编号，获取该编号设备信息（设备详情页面中，右侧设备基础数据信息展示）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEquInfByEquNum(Map<String,Object> map) throws Exception;
	
	/**
	 * 三级(或二级)公司人员查询上级(二级)公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getSuperiorComInfLstByTwoOrThrComUse(Map<String,Object> map) throws Exception;
	
	/**
	 * 三级公司人员查询上上级(一级)公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getSuperiorSuperiorComInfLstByThrComUse(Map<String,Object> map) throws Exception;
	
	/**
	 * 一级公司人员查询三级公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getThrComInfLstByFstComUse(Map<String,Object> map) throws Exception;
	
	/**
	 * （一级或）二级公司人员查询下级公司信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getInferiorsComInfLstByFstOrTwoComUse(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取与该人员有关的站点中的所有运维人员信息，使用人员ID
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getOptUseByPwsInfLstByPwsIdOpt(Map<String,Object> map) throws Exception;

	/**
	 * 获取站点信息，使用ID(运维人员)
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getPwsInfLstByPwsIdOpt(Map<String, Object> map);
	
	/**
	 * 获取本公司内的所有运维人员
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getOptUseInfInComLstByOptId(Map<String, Object> map);
	

	/**
	 * 获取某公司内的所有运维人员
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getOptUseInfLstByComId(Map<String, Object> map);

	
	/**
	 * 获取平台中的安全运维天数 
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getSafeRunDays();
	
	/**
	 * 获取平台中地图页面右侧统计数据
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getIntMonLeftSide(Map<String, Object> map);
	
	/**
	 * 获取平台中地图页面左侧电站图片信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getIntMonLeftSidePwsPic(Map<String, Object> map);
	
	/**
	 * 获取用户在地图中最新的定位信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getUseLonLatNewByUseId(Map<String, Object> map);
	
	/**
	 * 使用字典类型，获取字典表中字典信息下拉列表
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getDicInfLstByDicTyp(Map<String, Object> map);

	
	/**
	 * 使用设备类型唯一标识获取设备型号
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getBasAppByAppTypIde(Map<String, Object> map);
	
	/**
	 * 添加设备型号信息
	 * @param map
	 * @return List
	 */
	void insertBasAppInf(Map<String, Object> map);
	
	/**
	 * 获取设备类型列表
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getBasPwsTypLst();

	List<Map<String, Object>> getUserName();

	/**
	 * 本接口为获取平台中所有客户公司的信息接口
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getOwnerComLstByComLevComRol();

	/**
	 * 本接口为获取平台中所有客户公司的信息接口
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getOptComLstByComLevComRol();

	/**
	 * 本接口为获取平台中所有指定公司下的运维公司的信息接口
	 * @param companyDto
	 * @return
	 */
	List<Map<String, Object>> getOptFatComInfByComId(CompanyDto companyDto);

	/**
	 * 本接口为 根据电站id获取所有设备类型
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getSysBasAppTypeByPwsId(Map<String, Object> map);
	
	/**
	 * 本接口为 根据设备类型id获取设备编号
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getEquNumBySysBasAppTypeId(Map<String, Object> map);

	List<Map<String, Object>> getPwsInfLstByPwsId(Map<String, Object> map);
	
	/**
	 * 新增操作日志信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> insertOptLogInf(Map<String, Object> map);

	/**
	 * 本接口为获取平台中所有运维公司的信息接口
	 * @return
	 */
	List<Map<String, Object>> getComLstByComLevComRol();

	/**
	 * 查询操作日志信息列表
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getOptLogLst(Map<String, Object> map);
	
	/**
	 * 查询操作日志信息列表(分页)
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getOptLogLstCou(Map<String, Object> map);

	/**
	 * 使用公司名称获取公司信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getComInfByComNam(Map<String, Object> map);

	/**
	 * 本接口为使用公司ID获取其下所有子公司信息接口 
	 * @param comLevDto
	 * @return
	 */
	List<Map<String, Object>> getAllFatComInfByComId(CompanyDto comLevDto);

	/**
	 * 本接口为使用公司ID获取其下所有子公司信息接口
	 * @param companyDto
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFatComInfByComIdAll(CompanyDto companyDto)
			throws Exception;

	
	/**
	 * 获取启能自己公司的子公司信息
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getOneselfFatComInfByComId(CompanyDto comLevDto);

	/**
	 * 根据公司id 获取公司人员
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getUserNameByComId(Map<String, Object> map);

	List<Map<String, Object>> getUseInfInComLstById(Map<String,Object> map);

	List<Map<String, Object>> getUseInfLstByComId(Map<String, Object> map);

	
	/**
	 * 获取与查询人有关联的站的有关联的人
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getUseLstBySelectUseId(Map<String, Object> map);
	
	/**
	 * 获取与查询人有关联的站的有关联的人的公司ID
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getUseComIdLstBySelectUseId(Map<String, Object> map);

	/**
	 * 本接口为使用运维人员用户ID,获取所有与此运维人员有关的2级公司ID接口
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getTwoLevComLstByOptComUseId(Map<String, Object> map);

	/**
	 * 本接口为使用运维人员用户ID,获取所有与此运维人员有关的3级公司ID接口
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getThrLevComLstByOptComUseId(Map<String, Object> map);

	/**
	 * 本接口为使用运维人员用户ID,获取所有与此客户人员有关的2级公司ID接口
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getTwoLevComLstByOwnerComUseId(Map<String, Object> map);
	
	/**
	 * 本接口为使用运维人员用户ID,获取所有与此客户人员有关的3级公司ID接口
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getThrLevComLstByOwnerComUseId(Map<String, Object> map);

	
	/**
	 * 获取与查询人有关联的站的有关联的人
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getUseLstBySelectUseIdOpt(Map<String, Object> map);

	/**
	 * 使用菜单ID获取按钮列表
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getButtonLstByModuleId(Map<String, Object> map);

	/**
	 * 使用菜单ID与用户ID获取按钮列表
	 * @param map
	 * @return List
	 */
	List<Map<String, Object>> getSelectedButtonLstByModuleId(Map<String, Object> map);

	/**
	 * 本接口为获取平台中所有指定公司下的自己公司的信息接口
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getOrgFatComInfByComId(Map<String, Object> map);

	/**
	 * 使用一级公司ID获取电站列表信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPwsIdByFistComId(Map<String, Object> map);

	/**
	 *  使用二级公司ID获取电站列表信息 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPwsIdBySecdComId(Map<String, Object> map);

	/**
	 *  使用三级公司ID获取电站列表信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getPwsIdByThrdComId(Map<String, Object> map);

	/**
	 *  获取某公司内的所有人员  分页
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getUseInfLstByComIdCou(Map<String, Object> map);

	/**
	 *  获取与查询人有关联的站的有关联的人 分页
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getUseLstBySelectUseIdCou(Map<String, Object> map);

	/**
	 *  本接口为使用运维人员用户ID,获取所有与此运维人员有关的1级公司ID接口
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFstLevComLstByOwnerUseId(
			Map<String, Object> map) throws Exception;
	/**
	 *  本接口为使用运维人员用户ID,获取所有与此运维人员有关的1级公司ID接口 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getFstLevComLstByUseId(Map<String, Object> map)
			throws Exception;

	/**
	 *  新增用户定位信息
	 * @param map
	 */
	void insertUseLatLon(Map<String, Object> map);

	 /*
	  * 获取与查询人有关联的站的有关联的人
	  */
	List<Map<String, Object>> getUseLstBySelectUseIdOptCou(
			Map<String, Object> map);

}
