package com.qinergy.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.DoubleArraySerializer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * java调用中央气象局天气预报接口
 * <p>
 * Created by cj on 2017/10/1 0001.
 */
public class WeatherUtils {

    public static final String BEIJING_CITY_ID = "beijing";
    // 和风天气
    public static final String WEATHER_KEY = "63a497fc556948ecba4c884dec6fc9a3";

    public static void main(String[] args) {
        System.out.println( getBeijingTemp() );
    }


    public static String getBeijingTemp() {
        try {
            JSONObject data = getNowWether(BEIJING_CITY_ID);

            // {"HeWeather5":[{"status":"no more requests"}]}
            if (null != data) {
                JSONObject weather = data.getJSONArray("HeWeather5").getJSONObject(0);
                if ( weather !=null && weather.get("status").equals("ok") )
                return weather.getJSONObject("now").get("tmp").toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取实时天气<br>
     * 方 法 名： getTodayWeather <br>
     *
     * @param Cityid 城市编码
     */
    public static JSONObject getNowWether(String Cityid)
            throws IOException, NullPointerException {
        // https://free-api.heweather.com/v5/now?city=yourcity&key=yourkey
        // city=北京，city=beijing，city=CN101010100，city= 60.194.130.1
        URL url = new URL("https://free-api.heweather.com/v5/now?city=" + Cityid + "&key=" + WEATHER_KEY);
        URLConnection connectionData = url.openConnection();
        connectionData.setConnectTimeout(1000);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connectionData.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null)
                sb.append(line);
            String datas = sb.toString();
//            System.out.println(datas);
            JSONObject jsonData = JSONObject.parseObject(datas);

            return jsonData;
        } catch (SocketTimeoutException e) {
            System.out.println("连接超时");
        } catch (FileNotFoundException e) {
            System.out.println("加载文件出错");
        }

        return null;

    }





}
