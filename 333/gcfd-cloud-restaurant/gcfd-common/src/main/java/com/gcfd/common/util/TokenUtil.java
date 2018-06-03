package com.gcfd.common.util;

import com.gcfd.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * @类名：TokenUtil.java
 * @作者：one
 * @时间：2016年4月2日 下午3:12:39
 * @版权：pengkaione@icloud.com
 * @描述： 
 */
public class TokenUtil {
	
	private static final String invalid = "-1", expired = "0";
	private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);
	/**
     * 获得指定有效时间的token
     * @param seconds
     * @return
     */
	public static String getToken(int seconds){
		String uuid = UUIDUtil.getUUID32();
		return  getToken(uuid,seconds);
	  }
	/**
     * 获得指定有效时间的token
     * @param seconds
     * @return
     */
	public static String getToken(String uuid,int seconds){
		String pass = AESUtil.encrypt(createToken(uuid,seconds));
		pass = pass.substring(9, 12).concat(pass.substring(6,9)).concat(pass.substring(12,15))
				  .concat(pass.substring(3,6)).concat(pass.substring(18,21)).concat(pass.substring(0,3))
				  .concat(pass.substring(15,18)).concat(pass.substring(21,pass.length()));
		return pass;
	  }
	/**
	 * 生产token
	 * @param seconds 
	 */
	private static String createToken(String token,int seconds){
		try{
			String str = Int64Util.CompressNumber(System.currentTimeMillis()+(seconds*1000));
			if(seconds>0){
				token = addXByNum(Constant.DATE_T,addXForNum(" ", str, 10,false).concat(token),1);// 生产带时效的token
			}else{
				token = addXByNum(Constant.DATE_F,addXForNum(" ", str, 10,false).concat(token),1);//生产不带时效的token
			}
		}catch(Exception e){
			logger.debug("----------------------Token 生产异常！");
			return null;
		}
		return token;
	}
	/**
	 * token 解密
	 * @param content
	 * @return -1 无意义的串 0 已过期token  其它 则为解密后的token 
	 */
	public static String decryptToken(String content){
		if(content==null|| content.length()<=36) return invalid;
		try{
			content = content.substring(15, 18).concat(content.substring(9,12)).concat(content.substring(3,6))
					  .concat(content.substring(0,3)).concat(content.substring(6,9)).concat(content.substring(18,21))
					  .concat(content.substring(12,15)).concat(content.substring(21,content.length()));
			content = AESUtil.decrypt(content);//先 aes 解出来，确定为有效的aes 字符token
			Long longDate = Int64Util.UnCompressNumber(content.substring(1, 11).trim());
			new Date(longDate);// long 转化为时间检查
			if(content.matches("^["+Constant.DATE_T+"]{1}.*")){
				if (System.currentTimeMillis() >= longDate){
					return expired;
				}
				logger.debug("----------------------Token有效秒  : {}",(longDate - System.currentTimeMillis())/1000);
			} else if(content.matches("^["+Constant.DATE_F+"]{1}.*")){
				logger.debug("----------------------Token 永久有效，请确保业务真的需要 ");
			}
			else{
				return invalid;
			}
			content = content.substring(11,content.length());
		}catch(Exception e){
			logger.debug("----------------------错误(非法) Token！",content);
			return invalid;
		}
		return content;
	}
	
	 
	
	/**
	 * 补足随机位
	 * @param str  需要补充的字符串
	 * @param strLength  需要补足到的位数
	 * @param b  默认为true 补充再前面，false 补充在后面
	 * @return
	 */
	public static String addXForNum( String str,int strLength,boolean...b) {
		if(b.length<=0) b = new boolean[]{true};
		 while (str.length()<strLength) {
			 if(b[0]){
				 str = (Constant.PASS_KEY.charAt((int)(Math.random() * Constant.PASS_KEY.length()))+"").concat(str);
			 }else{
				 str = str.concat(Constant.PASS_KEY.charAt((int)(Math.random() * Constant.PASS_KEY.length()))+"");
			 }
		}
		  return str;
	}
	/**
	 * 补足随机位
	 * @param x 用来补充的串
	 * @param str  需要补充的字符串
	 * @param strLength  需要补足到的位数
	 * @param b  默认为true 补充再前面，false 补充在后面
	 * @return
	 */
	public static String addXForNum(String x,String str,int strLength,boolean...b) {
		if(x==null || str==null || x.length()<=0 || str.length()<0) return null;
		if(b.length<=0) b = new boolean[]{true};
		 while (str.length()<strLength) {
			 if(b[0]){
				 str = (x.charAt((int)(Math.random() * x.length()))+"").concat(str);
			 }else{
				 str = str.concat(x.charAt((int)(Math.random() * x.length()))+"");
			 }
		}
		  return str;
	}
	
	/**
	 * 补固定位数 随机位
	 * @param x 用来补充的串
	 * @param str  需要补充的字符串
	 * @param strLength  需要的位数
	 * @param b  默认为true 补充再前面，false 补充在后面
	 * @return
	 */
	public static String addXByNum(String x,String str,int strLength,boolean...b) {
		if(x==null || str==null || x.length()<=0 || str.length()<0) return null;
		if(b.length<=0) b = new boolean[]{true};
		 while (strLength>0) {
			 strLength = strLength -1;
			 if(b[0]){
				 str = (x.charAt((int)(Math.random() * x.length()))+"").concat(str);
			 }else{
				 str = str.concat(x.charAt((int)(Math.random() * x.length()))+"");
			 }
		}
		  return str;
	}
	//public static boolean appId
	public static void main(String[] args) throws InterruptedException, ParseException {
		String sourceT = null;
		String uid = "omvyVw4nMHIt8QMSqjpMa6vS0usA";
		//uid = UUIDUtil.getUUID32();
		sourceT = getToken(uid,1000);
		logger.debug("----------------------Token原始串  : {}",uid);
		logger.debug("----------------------Token加密串  : {}    长度：{}",sourceT,sourceT.length());
		logger.debug("----------------------Token解密串  : {}\n",decryptToken(sourceT));

	}
}
