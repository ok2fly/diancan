package com.gcfd.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;


import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Hex;  
public class Tools {
	/**
	 * MD5加密
	 * @author wgx
	 */
	public static String EncoderByMd5(String str) {
		// 确定计算方法
		MessageDigest md5;
		String newstr = "";
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			if(StringUtils.isNotBlank(str)){
				newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 加密后的字符串
		return newstr;
	}
	
	
	/** 
     * 生成含有随机盐的密码 
     */  
    public static String generate(String password) {  
        Random r = new Random();  
        StringBuilder sb = new StringBuilder(16);  
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));  
        int len = sb.length();  
        if (len < 16) {  
            for (int i = 0; i < 16 - len; i++) {  
                sb.append("0");  
            }  
        }  
        String salt = sb.toString();  
        password = md5Hex(password + salt);  
        char[] cs = new char[48];  
        for (int i = 0; i < 48; i += 3) {  
            cs[i] = password.charAt(i / 3 * 2);  
            char c = salt.charAt(i / 3);  
            cs[i + 1] = c;  
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);  
        }  
        return new String(cs);  
    }  
  
    /** 
     * 校验密码是否正确 
     */  
    public static boolean verify(String password, String md5) {  
        char[] cs1 = new char[32];  
        char[] cs2 = new char[16];  
        for (int i = 0; i < 48; i += 3) {  
            cs1[i / 3 * 2] = md5.charAt(i);  
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);  
            cs2[i / 3] = md5.charAt(i + 1);  
        }  
        String salt = new String(cs2);  
        return md5Hex(password + salt).equals(new String(cs1));  
    }  
  
    /** 
     * 获取十六进制字符串形式的MD5摘要 
     */  
    public static String md5Hex(String src) {  
        try {  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            byte[] bs = md5.digest(src.getBytes());  
            return new String(new Hex().encode(bs));  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
    
    
    /**
     * 生成UUID
     * @author 
     */
    public static String generateId(){
    	return UUID.randomUUID().toString().toUpperCase();
    }
    public static void main(String[] args) {  
        String password = generate("admin");  
        System.out.println(verify("admin", password));  
    }  
}
