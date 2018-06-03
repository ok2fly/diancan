package com.gcfd.common.util;

import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

/**
* @类名：PropertiesUtil.java
* @作者：one
* @时间：2016年6月19日 上午10:48:05
* @版权：pengkaione@icloud.com
* @描述： 
*/
public class PropertiesUtil {
	
	private static HashMap<String,String> properties = new HashMap<String,String>();

	/**
	 * 初始化参数,类加载器执行
	 */
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("info");
		Set<String> keySets = bundle.keySet();
		for (String key : keySets) {
			try {
				properties.put(key, new String(bundle.getString(key).getBytes("ISO-8859-1"),"UTF-8"));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	/**
	 * 获取 Properties 参数
	 * @param key
	 * @return
	 */
	public static String get(String key){
		return properties.get(key);
	}
	/**
	 * 获取 Properties 参数
	 * @param key
	 * @return
	 */
	public static int getInt(String key){
		return Integer.parseInt(properties.get(key));
	}
}
