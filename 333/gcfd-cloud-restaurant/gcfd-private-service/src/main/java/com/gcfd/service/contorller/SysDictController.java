package com.gcfd.service.contorller;

import com.gcfd.common.DataCenter;
import com.gcfd.common.EnumNetCode;
import com.gcfd.common.util.ConnectionFactory;
import com.gcfd.service.UserUtil;
import com.gcfd.storage.dao.SysDictMapper;
import com.gcfd.storage.entity.SysDict;
import com.gcfd.storage.entity.SysDictKey;
import com.gcfd.storage.entity.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @className：SysDictEntity.java
 * @author：ygx
 * @data 2017-10-19 10:01:27
 * @version  1.0
 * @description：
 */

@RestController
@RequestMapping(value = "/service/scr/app/dict")
public class SysDictController {
    private static final Logger logger = LoggerFactory.getLogger(ScrAppSysController.class);
    /**
     * 根据code获取数据字典列表
     * @param code
     * @param request
     * @return
     */
    @RequestMapping(value = "/getSysDictList",method = {RequestMethod.POST,RequestMethod.GET})
    public DataCenter<Object> getSysDictList(String code, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            List<SysDict> sysDictList= sysDictMapper.getAllSysDictByCode(code);
            netData.setData(sysDictList);
            netData.setNetCode(EnumNetCode.Q1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.Q1002);
            logger.error("发生异常，异常信息如下：" + e.getLocalizedMessage());
            e.printStackTrace();
        }finally {
            if(sqlsession != null){
                sqlsession.close();
            }
        }
        return netData;
    }
    /**
     * 根据id和code获取数据字典
     * @param code
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/getSysDictByCode",method = {RequestMethod.POST,RequestMethod.GET})
    public DataCenter<Object> getSysDictByCode(String code,String id, HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            SysDict sysDict=sysDictMapper.selectByPrimaryKey(code,id);
            netData.setData(sysDict);
            netData.setNetCode(EnumNetCode.Q1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.Q1002);
            logger.error("发生异常，异常信息如下：" + e.getLocalizedMessage());
            e.printStackTrace();
        }finally {
            if(sqlsession != null){
                sqlsession.close();
            }
        }
        return netData;
    }
    /**
     * 修改数据字典
     * @param sysDict
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateSysDict",method = {RequestMethod.POST,RequestMethod.GET})
    public DataCenter<Object> updateSysDict(SysDict sysDict,HttpServletRequest request){
        SysUser sysUser= UserUtil.getCurrentUser(request);
        //实例化返回参数
        DataCenter<Object> netData = new DataCenter<Object>();
        SqlSession sqlsession = null;
        try{
            sqlsession = ConnectionFactory.getSessionFactory(sysUser.getBranchId()).openSession();
            SysDictMapper sysDictMapper = sqlsession.getMapper(SysDictMapper.class);
            sysDict.setLstModifyUserId(sysUser.getUserId());
            sysDictMapper.updateByPrimaryKey(sysDict);
            netData.setNetCode(EnumNetCode.Q1001);
        }catch (Exception e) {
            netData.setNetCode(EnumNetCode.Q1002);
            logger.error("发生异常，异常信息如下：" + e.getLocalizedMessage());
            e.printStackTrace();
        }finally {
            if(sqlsession != null){
                sqlsession.close();
            }
        }
        return netData;
    }


//	@Autowired
//	private SysDictImpl sysDictImpl;
//	@Autowired
//	private SysRoleImpl sysRoleImpl;
//	@Autowired
//	private SqlSessionFactory sqlSessionFactory;
//
//	private static final Logger logger = LoggerFactory.getLogger(SysDictController.class);
//
//
//	/**
//	 * @description 查詢字典，放入緩存
//	 * @author  YGX
//	 * @date 2017-10-23 10:01:27
//	 * @version 1.0
//	 * @param sysDictEntity
//	 * @return
//	 */
//	@RequestMapping(value = "/querySysDict",method = RequestMethod.POST)
//	public DataCenter<Object> querySysDict(@RequestBody SysDictEntity sysDictEntity) {
//		DataCenter<Object> netData = new DataCenter<Object>();// 实例化统一网络包
//		String code = null;
//		// SysDictEntity sysDictEntity = null;
//		if (sysDictEntity == null || sysDictEntity.getCode() == null || "".equals(sysDictEntity.getCode())) {
//			netData.setNetCode(EnumNetCode.C3002);
//		} else {
//			code = sysDictEntity.getCode();
//			if ("SYSROLE".equals(code)) {
//				netData.setOData(sysRoleImpl.querySysDict());
//			} else {
//				netData.setOData(sysDictImpl.querySysDictInit(code)); // 查询例子，默认取缓存
//			}
//		}
//		logger.debug("------------- SysDictServer 【{}】 server 请求成功！--------------", "querySysDict");
//		return netData;
//	}
//
//	/**
//	 * @description 修改字典
//	 * @author YGX
//	 * @date 2017-10-23 10:01:27
//	 * @param sysDictEntity
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/updateSysDict",method = RequestMethod.POST)
//	public DataCenter<Object> updateSysDict(@RequestBody SysDictEntity sysDictEntity, HttpServletRequest request) {
//		DataCenter<Object> netData = new DataCenter<Object>();// 实例化统一网络包
//
//		SysUserEntity sysb = UserUtil.getCurrentUser(request);//取出用户实体
//
//		if (sysb==null || sysDictEntity==null) {
//			netData.setNetCode(EnumNetCode.C3002);
//			logger.debug("-----------未获取到系统用户----------");
//		}else {
//			SysDictEntity dictEntity = new SysDictEntity();
//			dictEntity.setCode(sysDictEntity.getCode());
//			dictEntity.setId(sysDictEntity.getId());
//			dictEntity.setName(sysDictEntity.getName());
//			dictEntity.setDescription(sysDictEntity.getDescription());
//			dictEntity.setIsDel(sysDictEntity.getIsDel());
//			dictEntity.setLastModifyUser(sysb.getUsername());
//			try {
//				sysDictImpl.updateSysDict(dictEntity);//更新
//				netData.setNetCode(EnumNetCode.UP1001);
//				logger.debug("------------- SysDictServer 【{}】 server 请求成功！--------------", "updateSysDict");
//			} catch (Exception e) {
//				netData.setNetCode(EnumNetCode.UP1002);
//				logger.debug("------------- SysDictServer 【{}】 server 请求失败！--------------", "updateSysDict");
//			}
//		}
//		return netData;
//	}
//
//	/**
//	 * @description 新增字典
//	 * @author YGX
//	 * @date 2017-10-23 10:01:27
//	 * @param request
//	 * @param list
//	 * @return
//	 */
//	@RequestMapping(value = "/insertSysDict",method = RequestMethod.POST)
//	public DataCenter<Object> insertSysDict(HttpServletRequest request,@RequestBody List<SysDictEntity> list) {
//		DataCenter<Object> netData = new DataCenter<Object>();// 统一网络实例包
//
//		SysUserEntity sysb = UserUtil.getCurrentUser(request);//取出用户实体
//
//		if (sysb==null || list==null) {
//			netData.setNetCode(EnumNetCode.C3002);
//			logger.debug("-----------未获取到系统用户----------");
//		}else {
//			List<SysDictEntity> errorList = new ArrayList<SysDictEntity>(); //存储插入异常的数据
//			for (SysDictEntity sysDictEntity : list) {
//				SysDictEntity dictEntity = new SysDictEntity();
//				dictEntity.setCode(sysDictEntity.getCode());
//				dictEntity.setId(sysDictEntity.getId());
//				dictEntity.setName(sysDictEntity.getName());
//				dictEntity.setDescription(sysDictEntity.getDescription());
//				dictEntity.setCreateUser(sysb.getUsername());
//				try {
//					sysDictImpl.insertSysDict(dictEntity); // 执行插入操作
//				} catch (Exception e) {
//					errorList.add(dictEntity);
//				}
//			}
//			if (errorList.size()<=0) {
//				netData.setNetCode(EnumNetCode.I1000);
//				logger.debug("------------- SysDictServer 【{}】 server 请求成功！--------------", "insertSysDict");
//			}else {
//				netData.setNetCode(EnumNetCode.I1002);
//				netData.setData(errorList);
//			}
//		}
//		return netData;
//	}
//
//	/**
//	 * @description 分页查询所有字典
//	 * @author YGX
//	 * @date 2017-10-23 10:01:27
//	 * @param dataCenter
//	 * @return
//	 */
//	@RequestMapping(value = "/getPageDict",method = RequestMethod.POST)
//	public DataCenter<Object> getPageDict(@RequestBody DataCenter<SysDictEntity> dataCenter) {
//		DataCenter<Object> queryResult = new DataCenter<>();
//		if (dataCenter==null) {
//			queryResult.setNetCode(EnumNetCode.C3002);
//		}else {
//			queryResult.setPageNum(dataCenter.getPageNum());
//			queryResult.setPageSize(dataCenter.getPageSize());
//
//			DataCenter<SysDictEntity> netData = new DataCenter<>();
//			netData.setData(dataCenter.getData());
//			netData.setPageNum(dataCenter.getPageNum());
//			netData.setPageSize(dataCenter.getPageSize());
//
//			try{
//				queryResult.setData(sysDictImpl.querySysDict(netData));
//				queryResult.setRowCount(sysDictImpl.queryCount(netData));
//				queryResult.setNetCode(EnumNetCode.Q1001);
//				logger.debug("--------------------获取字典列表成功------------------");
//	 		}catch (Exception e) {
//	 			queryResult.setNetCode(EnumNetCode.Q1002);
//				logger.debug("--------------------获取字典列表失败------------------");
//			}
//		}
//
//		return queryResult;
//	}
//
//
//	/**
//	 * @description 获取字典项
//	 * @author YGX
//	 * @date 2017-10-23 10:01:27
//	 * @return
//	 */
//	@RequestMapping(value = "/getDictCode",method = RequestMethod.POST)
//	public DataCenter<Object> getDictCode() {
//		DataCenter<Object> netData = new DataCenter<Object>();
//		List<String> list = sysDictImpl.queryDictCode("");
//		netData.setData(list);
//		return netData;
//	}
//
//	/**
//	 * @description 注销字典
//	 * @author YGX
//	 * @date 2017-10-23 10:01:27
//	 * @param list
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/delSysDict",method = RequestMethod.POST)
//	public DataCenter<Object> delSysDict(@RequestBody List<SysDictEntity> list, HttpServletRequest request) {
//		DataCenter<Object> resultDateCenter = null;// 实例化统一网络包
//		SysUserEntity sysb = UserUtil.getCurrentUser(request);//取出用户实体
//		if (sysb==null || list==null || list.size() <= 0) {
//			resultDateCenter = DataCenterUtil.error(EnumNetCode.C3002);
//			logger.debug("-----------未获取到系统用户----------");
//		}else {
//			String userName = sysb.getUsername();
//			try(SqlSession sqlsession = sqlSessionFactory.openSession(false)){
//				SysDictDao sysDictDao = sqlsession.getMapper(SysDictDao.class);
//				for(SysDictEntity dictEntity : list){
//					dictEntity.setLastModifyUser(userName);
//					sysDictDao.deleteSysDict(dictEntity);
//
//				}
//				resultDateCenter = DataCenterUtil.success(EnumNetCode.D1001);
//				logger.debug("------------- SysDictServer 【{}】 server 请求成功！--------------", "delSysDict");
//				sqlsession.commit();
//			}catch(Exception e){
//				resultDateCenter = DataCenterUtil.success(EnumNetCode.D1002);
//				logger.debug("------------- SysDictServer 【{}】 server 请求失败！--------------", "delSysDict");
//			}
//		}
//		return resultDateCenter;
//	}
//
//	/**
//	 * @description 激活字典
//	 * @author YGX
//	 * @Ddate 2017-10-23 10:01:27
//	 * @param list
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/actSysDict",method = RequestMethod.POST)
//	public DataCenter<Object> actSysDict(@RequestBody List<SysDictEntity> list,HttpServletRequest request) {
//		DataCenter<Object> resultDateCenter = null;// 实例化统一网络包
//		SysUserEntity sysb = UserUtil.getCurrentUser(request);//取出用户实体
//		if (sysb==null || list==null || list.size() <= 0) {
//			resultDateCenter = DataCenterUtil.error(EnumNetCode.C3002);
//			logger.debug("-----------未获取到系统用户----------");
//		}else {
//			String userName = sysb.getUsername();
//			try(SqlSession sqlsession = sqlSessionFactory.openSession(false)){
//				SysDictDao sysDictDao = sqlsession.getMapper(SysDictDao.class);
//				for(SysDictEntity dictEntity : list){
//					dictEntity.setLastModifyUser(userName);
//					sysDictDao.recoverSysDict(dictEntity);
//				}
//				resultDateCenter = DataCenterUtil.success(EnumNetCode.UP1001);
//				logger.debug("------------- SysDictServer 【{}】 server 请求成功！--------------", "delSysDict");
//				sqlsession.commit();
//			}catch(Exception e){
//				resultDateCenter = DataCenterUtil.success(EnumNetCode.UP1002);
//				logger.debug("------------- SysDictServer 【{}】 server 请求失败！--------------", "delSysDict");
//			}
//		}
//		return resultDateCenter;
//	}
//
//
//	/**
//	 * @description 查询缓存Code
//	 * @author  YGX
//	 * @date 2017-10-23 10:01:27
//	 * @version 1.0
//	 * @return
//	 */
//	@RequestMapping(value = "/queryCacheDict/{type}",method = RequestMethod.POST)
//	public DataCenter<List<String>> queryCacheDict(@PathVariable("type") String type){
//		DataCenter<List<String>> netData = new DataCenter<List<String>>();
//		try{
//			List<String> cacheList = sysDictImpl.queryDictCode(type);
//			logger.debug("--------SysDict---------------queryCacheDict----------执行成功-----【{}】----",cacheList.get(0));
//			netData.setData(cacheList);
//			netData.setNetCode(EnumNetCode.Q1001);
//		}catch(Exception e){
//			logger.debug("--------SysDict---------------queryCacheDict----------查询过程失败---------");
//			netData.setNetCode(EnumNetCode.Q1002);
//		}
//		return netData;
//	}

}
