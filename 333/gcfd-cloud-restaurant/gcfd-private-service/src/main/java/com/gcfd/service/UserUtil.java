package com.gcfd.service;

import com.alibaba.fastjson.JSON;
import com.gcfd.common.Constant;
import com.gcfd.common.util.JedisUtil;
import com.gcfd.storage.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @类名：webUtil.java
 * @作者：one
 * @时间：2016年3月31日 上午10:19:01
 * @版权：pengkaione@icloud.com
 * @描述： 
 */
public class UserUtil {

//	private static final Logger logger = LoggerFactory.getLogger(UserUtil.class);
//
//	private static final String[] TASKPOWER = {"3a85cb27d6c24f929b4f1a6a0d49e40b","2c50f12d2df0469f8d87068627a092f8","e3e90aec83e04106989e9b5b3d97ef78","2a95bf887e754f1984efdefeda2277d7","eb974cac940d47ecbbbc4af5711ede75","73dbd63a196f4b7da0e03215261cf5ab"};
//
//	private static final String[] REPORTPOWER = {"4904c66e86d4475fbe7a70dcac1bed3a","ba9eda12bca54157a7c236a92862353d","deb88b36fb0b4935bb91cd6425ce74e6","3c3af7dad7f642f2b352a54944bef4a7","f2db2f6e42534b3bbd3d037c78a86de4"};
//
//	private static final String[] CLUESPOWER = {"7dd79d31a844484e93bf969d5efe7a06","2d5a85deca52404fada256250a427796","ce8d0ef332e243169c2179cb1f3525bc","db00b50f51594164b0e9b1057f873c20","3e44acd5c0b4413ca4f4d4aaf0371087"};
//
//	private static final String[] MAJORPOWER = {"02d7f3b281154cbeaaedf3b724dd3561","07173021528d4739b1fa2ba3b5c0a165","8540ea2d8cac4778b4f73b6e5bb3ea60","d7e5c4189a544e3a824267a7e91854b0","9e5dc5d9206d4e1ebe1c4157987d983b"};
//
//	private static final String TASKCHECK = "";
//	private static final String REPORCHECK = "";
//	private static final String CLUESCHECK = "";
//	private static final String MAJORCHECK = "";
//    /**
//	 * @description 获取当前登录用户
//	 * @author  YGX
//	 * @date 2017-06-19 17:58:31
//	 * @param request
//	 * @return
//	 */
//	public static SysUserEntity getCurrentUser(HttpServletRequest request){
//		try{
//			String jsonu = (String) request.getAttribute("_sysUser");
//			if(null==jsonu || "".equals(jsonu)){
//				return null;
//			}
//			return JSON.parseObject(jsonu, SysUserEntity.class);
//		}catch(Exception e){
//			logger.error("------------------ UserUtil -- getCurrentUser(HttpServletRequest request)   异常");
//			throw new RuntimeException();
//		}
//	}
	/**
	 * 根据Token 获取用户
	 * @param request
	 * @return
	 */
	public static SysUser getCurrentUser(HttpServletRequest request){
        SysUser sysUser=new SysUser();
        sysUser.setBranchId("B001");
        sysUser.setUserId("1001");
		return sysUser;
	}
//
//	public static List<Boolean> getCurentUserPower(HttpServletRequest request,String perType){
//		try{
//			List<Boolean> resultList = new ArrayList<Boolean>();
//			String jsonu = (String) request.getAttribute("_sysUser");
//			if(null==jsonu || "".equals(jsonu)){
//				return null;
//			}
//			SysUserEntity user =  JSON.parseObject(jsonu, SysUserEntity.class);
//			if(user == null){
//				return null;
//			}else{
//				List<String> list = user.getPerList();
//				if("1001".equals(perType)){
//					resultList = getPowerFlag(TASKPOWER,list);
//				}else if("2001".equals(perType)){
//					resultList = getPowerFlag(REPORTPOWER,list);
//				}else if("3001".equals(perType)){
//					resultList = getPowerFlag(CLUESPOWER,list);
//				}else if("4001".equals(perType)){
//					resultList = getPowerFlag(MAJORPOWER,list);
//				}
//
//			}
//			return resultList;
//		}catch(Exception e){
//			logger.error("------------------ UserUtil -- getCurrentUser(HttpServletRequest request)   异常");
//			throw new RuntimeException();
//		}
//	}
//
//	public static  List<Boolean> getPowerFlag(String[] strs,List<String> list){
//		List<Boolean> resultList = new ArrayList<Boolean>();
//		for(int i = 0;i<strs.length;i++){
//			boolean flag = false;
//			for(String ceil : list){
//				if(TASKPOWER[i].equals(ceil)){
//					flag = true;
//					break;
//				}
//			}
//			resultList.add(flag);
//		}
//		return resultList;
//	}
//
//	public static Boolean getCurentUserCheckPower(HttpServletRequest request,String perType){
//		try{
//			String jsonu = (String) request.getAttribute("_sysUser");
//			boolean result = false;
//			if(null==jsonu || "".equals(jsonu)){
//				return null;
//			}
//			SysUserEntity user =  JSON.parseObject(jsonu, SysUserEntity.class);
//			if(user == null){
//				return null;
//			}else{
//				List<String> list = user.getPerList();
//				if("1001".equals(perType)){
//					for(String ceil : list){
//						if(TASKCHECK.equals(ceil)){
//							result = true;
//							break;
//						}
//					}
//				}else if("2001".equals(perType)){
//					for(String ceil : list){
//						if(REPORCHECK.equals(ceil)){
//							result = true;
//							break;
//						}
//					}
//				}else if("3001".equals(perType)){
//					for(String ceil : list){
//						if(CLUESCHECK.equals(ceil)){
//							result = true;
//							break;
//						}
//					}
//				}else if("4001".equals(perType)){
//					for(String ceil : list){
//						if(MAJORCHECK.equals(ceil)){
//							result = true;
//							break;
//						}
//					}
//				}
//
//			}
//			return result;
//		}catch(Exception e){
//			logger.error("------------------ UserUtil -- getCurrentUser(HttpServletRequest request)   异常");
//			throw new RuntimeException();
//		}
//	}
//
//	/**
//	 * @description 获取管理员的机构类型
//	 * @author YGX
//	 * @param request
//	 * @return
//     */
//	public static String getManagerUserBrancher(HttpServletRequest request){
//		SysUserEntity sysUser = UserUtil.getCurrentUser(request);
//		if (null == sysUser || "".equals(sysUser)) {
//			return null;
//		}
//		String branchType = sysUser.getBranchType();
//		if("1".equals(branchType)) branchType = "('1','4')";
//		else if("2".equals(branchType))  branchType = "('2','3')";
//		List<SysRoleEntity> list =  sysUser.getRoleList();
//		if(list != null && list.size() > 0){
//			for(SysRoleEntity sysRoleEntity: list){
//				if("T".equals(sysRoleEntity.getIsAdmin())){
//					branchType = "";
//					break;
//				}
//			}
//		}
//		return branchType;
//	}
}
