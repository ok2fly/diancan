package com.gcfd.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @类名：AESUtil.java
 * @作者：one
 * @时间：2016年4月5日 下午4:56:19
 * @版权：pengkaione@icloud.com
 * @描述： 
 */
public class AESUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);
	private static final String default_charset = "UTF-8";
	private static final String default_key = "mW63*I@h!e^vF2s1";
	private static final String default_iv  = "LBNmAg(psx6D*e7F";
	
	/**
	 * 加密<自定义，该加密必须是自定义解密>
	 * @param content 加密内容
	 * @return
	 */
	public static String encrypt(String content) {
		 try {
			 String pass = encrypt(content.getBytes(default_charset),default_key.getBytes(default_charset) ,default_iv.getBytes(default_charset));
			 return pass.substring(4, 8)+pass.substring(16, 20)+pass.substring(0, 4)+pass.substring(12, 16)+pass.substring(8, 12)+pass.substring(20, pass.length());
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return null;
	}
	/**
	 * 加密
	 * @param content 加密内容
	 * @param key 密钥
	 * @param iv 加密向量
	 * @return
	 */
	public static String encrypt(String content, String key,String iv) {
		key=(key==null||"".equals(key))?default_key:key;
		iv=(iv==null||"".equals(iv))?default_key:iv;
		 try {
			 return encrypt(content.getBytes(default_charset),key.getBytes(default_charset) ,iv.getBytes(default_charset));
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return null;
	}
	
    /**
     * 加密
     * @param content 需要加密的内容
     * @param key 加密密码
     * @param iv 加密向量
     * @return 加密后的字节数据
     */
    public static String encrypt(byte[] content, byte[] key, byte[] iv) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); //"算法/模式/补码方式" 
            IvParameterSpec ivps = new IvParameterSpec(iv);//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivps);//
           return new BASE64Encoder().encode(cipher.doFinal(content));
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 解密
     * @param content 密串
     * @param key 密钥
     * @param iv 向量
     * @return
     */
    public static String decrypt(String content, String key, String iv) {
    	key=(key==null||"".equals(key))?default_key:key;
		iv=(iv==null||"".equals(iv))?default_key:iv;
    	try{
    		return decrypt(new BASE64Decoder().decodeBuffer(content),key.getBytes(default_charset) ,iv.getBytes(default_charset));
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    /**
     * 解密<自定义，该解密必须是自定义加密>
     * @param content 密串
     * @return
     */
    public static String decrypt(String content) {
    	try{
    		String pass = content.substring(8, 12)+content.substring(0, 4)+content.substring(16, 20)+content.substring(12, 16)+content.substring(4, 8)+content.substring(20, content.length());
    		return decrypt(new BASE64Decoder().decodeBuffer(pass),default_key.getBytes(default_charset) ,default_iv.getBytes(default_charset));
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    /**
     * 解密
     * @param content 密串
     * @param key 密钥
     * @param iv 向量
     * @return
     */
    public static String decrypt(byte[] content, byte[] key, byte[] iv) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); //"算法/模式/补码方式"
            IvParameterSpec ivps = new IvParameterSpec(iv);//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivps);//
            return new String(cipher.doFinal(content),default_charset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	/**将16进制转换为二进制 
	 * @param hexStr 
	 * @return 
	 */  
	public static byte[] parseHexStr2Byte(String hexStr) {  
	        if (hexStr.length() < 1)  
	                return null;  
	        byte[] result = new byte[hexStr.length()/2];  
	        for (int i = 0;i< hexStr.length()/2; i++) {  
	                int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
	                int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
	                result[i] = (byte) (high * 16 + low);  
	        }  
	        return result;  
	}  
 
    public static void main(String[] args) throws Exception {
    	
//    	Long f = System.currentTimeMillis();
//        for (int i = 0; i <= 1; i++) {
//        	String soure =  UUIDUtil.getUUID36();
//        	String pass = AESUtil.encrypt(soure);
//        	String p = AESUtil.decrypt(pass);
//		}
//    	Long t = System.currentTimeMillis();
//    	System.out.println( t - f);
    	//logger.debug("-------------------------token: {}",TokenUtil.getToken(1000));
    	
    	//77c0b45fac744d08885a9c4caa24b244
    	//N1a77c0b45fac744d088mi85a9c4caa24b244icilfs
    	
    	String tk = TokenUtil.getToken(1000);
    	logger.debug("-------------------------tk: {}",tk);
    	
//    	String v = encrypt(tk);
//    	
//    	logger.debug("-------------------------en tk: {}",v);
    	String tt = TokenUtil.decryptToken(tk);
    	logger.debug("-------------------------dee tk: {}",tt);
    	String de = decrypt(tk);
//    	
    	logger.debug("-------------------------de tk: {}",de);
	}
}