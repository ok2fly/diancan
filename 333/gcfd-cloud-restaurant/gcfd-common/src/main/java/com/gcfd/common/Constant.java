package com.gcfd.common;

import com.gcfd.common.util.PropertiesUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @类名：Config.java
 * @作者：one
 * @时间：2016年3月30日 下午10:56:29
 * @版权：pengkaione@icloud.com
 * @描述： 
 */
public class Constant {
	
	/**
	 * 监控 job 执行类型 
	 */
	public static final String JOB_TYPE_JAVACLASS = "javaClass";
	/**
	 * 监控 job 执行类型 
	 */
	public static final String JOB_TYPE_CCC = "javaClass";

	public static final int DF_CACHE_DB = PropertiesUtil.getInt("mybatis.syscachedb");
	/**
	 * 缓存session 的库
	 */
	public static final int SESSION_DB = PropertiesUtil.getInt("system.sessiondb");
	/**
	 * 缓存ticket的库
	 */
	public static final int TICKET_DB = PropertiesUtil.getInt("system.ticketdb");

	/**
	 * 缓存接口访问统计的库
	 */
	public static final int INTERFACE_DB = PropertiesUtil.getInt("system.interfacedb");

	/**
	 * session 有效时间
	 */
	public static final int SESSION_TIME = PropertiesUtil.getInt("system.session");
	/**
	 * 全局统计接口前缀
	 */
	public static final String INFERFACE_NAME = PropertiesUtil.get("system.inferfaceName");

	/**
	 * 取得本系统APPID
	 */
	public static final String APPID = PropertiesUtil.get("system.appid");

	/**
	 * ticket 有效时间（秒）
	 */
	public static final int TICKET_MINUTES = 5*60; 
	
	/**
	 * 换行符号
	 */
	public static final String NEW_LINE = System.getProperty("line.separator");  
	/**
	 * 系统登录用户名
	 */
	public static final String SYS_LOGIN_USERNAME = System.getProperty("user.name");
	/**
	 * 单点登录URL
	 */
	//public static final String SYS_LOGIN_URL = PropertiesUtil.get("system.loginUrl");
	/**
	 * 数据源名称
	 */
	public static final String DEFAULT_DATA_SOURCE =  "dataSource";
	
	/**
	 * 随机秘钥生成源
	 */
	public static final String PASS_KEY="0123456789qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM!@#$%^&*()_+";
	/**
	 * 有时效性
	 */
	public static final String DATE_T = "189qwfdsKGNM"; 
	/**
	 * 无时效性
	 */
	public static final String DATE_F = "346tyunmQWOP";
	/**
	 * 图片格式大全
	 */
	public static final String NETFILE_JGP = ".bmp|.jpg|.tiff|.gif|.pcx|.tga|.exif|.fpx|.svg|.psd|.cdr|.pcd|.dxf|.ufo|.eps|.ai|.raw|.png";
	/**
	 * 文档格式目录
	 */
	public static final String NETFILE_WORD_EXCLE = ".doc|.dotx|.dot|.rtf|.txt|.xlsx|.xls|.xltx|.xlt|.csv";
	
	/**
	 * 用户代理
	 */
	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11";
	/**
	 * Content-Type:json格式
	 */
	public static final String CONTENT_TYPE_JSON = "application/json;charset=utf-8";
	
	/**
	 * 网络代码定义
	 */
	public static final Map<String,String> NET_CODE = new HashMap<>();


	/**
	 * PUP机构URL
	 */
	public static final String PUP_GROUP_URL = "https://oauth.pre.hubpd.com/pup/api/orgs";
	/**
	 * PUP人员URL
	 */
	public static final String PUP_USER_URL = "https://oauth.pre.hubpd.com/pup/api/users";
	/**
	 *  PUP组织URL
	 */
	public static final String PUP_ORG_URL = "https://oauth.pre.hubpd.com/pup/api/depts";
	/**
	 * 获取token
	 */
	public static final String APP_TOKEN = "http://oauth.pre.hubpd.com/pup-asserver/appToken";
	/**
	 * client ID
	 * 应用标识
	 */
	public static final String CLIENT_ID = "dbec23cc86b14dab9d039cdd5d2506b4";
	/**
	 * secret ID
	 * 应用
	 */
	public static final String CLIENT_SECRET = "75f6324593a349cc96165bc46c4dfc1f";
	/**
	 * 获取授权码
	 */
	public static final String AUTHORIZE = "https://oauth.pre.hubpd.com/pup-asserver/authorize";
	/**
	 * 获取令牌
	 */
	public static final String ACCESS_TOKEN = "https://oauth.pre.hubpd.com/pup-asserver/accessToken";
	/**
	 * 获取用户基本信息
	 */
	public static final String USER_INFO = "https://oauth.pre.hubpd.com/pup-asserver/userInfo";


	/**
	 * 初始化 系统异常代码
	 */
	 static{
		 NET_CODE.put("EEEEE", "网络异常");
		 NET_CODE.put("C2002", "请求接口无效");
		 NET_CODE.put("C2003", "请求接口异常");
		 NET_CODE.put("C2004", "接口不存在，请勿非法访问");
		 NET_CODE.put("C3001", "接口授权过期");
		 NET_CODE.put("C3002", "非法访问");
		 NET_CODE.put("C9001", "请求参数类型错误,请按要求输入参数");
		 NET_CODE.put("U1000", "用户不存在");
		 NET_CODE.put("U1001", "密码错误");
		 NET_CODE.put("U1002", "用户过期");
		 NET_CODE.put("U1003", "用户已锁定，请联系客服");
		 NET_CODE.put("U1004", "用户已注销");
		 NET_CODE.put("F1000", "文件上传成功");
		 NET_CODE.put("F1001", "文件上传失败");
		 NET_CODE.put("I1000", "插入成功");
		 NET_CODE.put("I1002", "插入失败");
		 NET_CODE.put("UP1001", "更新成功");
		 NET_CODE.put("UP1002", "更新失败");
		 NET_CODE.put("D1001", "删除成功");
		 NET_CODE.put("D1002", "删除失败");
		 NET_CODE.put("Z1001", "注销成功");
		 NET_CODE.put("Z1002", "注销失败");
		 NET_CODE.put("Q1001", "查询成功");
		 NET_CODE.put("Q1002", "查询失败");
		 
	 }
}
