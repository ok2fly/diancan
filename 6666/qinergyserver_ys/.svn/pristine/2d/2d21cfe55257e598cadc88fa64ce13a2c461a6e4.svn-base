package com.qinergy.util;

import java.io.UnsupportedEncodingException;

/**
 * 3DES加密提供者
 * @author 韩彦伟
 * @since: 2012-09-14
 * @version: 1.0.0
 */
public class ThreeDESEncryptProvider {

    public static String encrypt(String data,String key) {
        try {
            return  new String(BASE64.encode(DESUtils.Union3DesEncrypt(key.getBytes("utf-8"), data.getBytes("utf-8"))));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String decrypt(String key,String data){
        try {
            return new String(DESUtils.Union3DesDecrypt(key.getBytes("utf-8"), BASE64.decode(data)));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
