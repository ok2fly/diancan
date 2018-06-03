package com.gcfd.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @类名：AppIdUtil.java
* @作者：one
* @时间：2016年7月1日 下午12:40:35
* @版权：pengkaione@icloud.com
* @描述： 
*/
public class AppIdUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(AppIdUtil.class);
	
	/**
	 * 新的appid
	 * @return
	 */
	public static String createAppId(){
		String appid = TokenUtil.getToken(1000);
    	logger.debug("-------------------------产生了一个新的Appid : {}    长度: {} ",appid,appid.length());
    	return appid;
	}
	/**
	 * 检查Appid 的有效性
	 * @return true 有效的appid  false 无效的appid
	 */
	public static Boolean checkAppId(String appid){
			if(appid==null|| appid.length() != 64) return false;
			String cValue = new String(appid);
			if(!"-1".equals(TokenUtil.decryptToken(cValue))){
				return true;
			}
			return false;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if(checkAppId(AppIdUtil.createAppId())){
				logger.debug("-------------------------通过检验！ ");
			}else{
				logger.debug("-------------------------检验失败！ ");
			}
		}
		
	}

}
