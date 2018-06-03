package com.gcfd.common.util;


import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * Created by ygx on 2017/11/8.
 */
public class Base64Util {

    public static String baseUnicode64(String userId){
        // 第二种解密
        StringBuffer stringBuffer = new StringBuffer();
        String[] userIds = userId.split("ncdp");
        for (int i = 1; i < userIds.length; i++) {
            int data = Integer.parseInt(userIds[i], 16);
            stringBuffer.append((char) data);
        }

        // 第一种解密
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return new String (decoder.decodeBuffer(stringBuffer.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
