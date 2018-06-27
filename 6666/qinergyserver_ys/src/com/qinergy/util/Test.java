package com.qinergy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {
	public static void main(String[] args) {
//		Format f = new SimleDateFormat("yyyy-MM-dd HH:mm:ss");
//		 
//        Date today = new Date();
//        System.out.println("今天是:" + f.format(today));
// 
//        Calendar c = Calendar.getInstance();
//        c.setTime(today);
//        c.add(Calendar.DAY_OF_MONTH, 7);// 今天+1天
// 
//        Date tomorrow = c.getTime();
//        System.out.println("明天是:" + f.format(tomorrow));
		String result = "";
		// 组成验证码信息
		HttpURLConnection httpconn = null;
		StringBuilder sb = new StringBuilder();
//		sb.append(InterfaceConstants.HAOSERVICE_REAL_TIME_GOLD);
//		sb.append(InterfaceConstants.REAL_TIME_GOLD_KEY);
		
		// 发送验证码
		try {
			URL url = new URL(sb.toString());
			httpconn = (HttpURLConnection) url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
			result = rd.readLine();
			rd.close();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			if (httpconn != null) {
				httpconn.disconnect();
				httpconn = null;
			}

		}
		System.out.println(result);
		
//		{"error_code":0,"reason":"成功","result":[
//		{"variety":"Ag99.99","latestpri":"3235","openpri":"3235","maxpri":"3235","minpri":"3235","limit":"-1.04%","yespri":"3269","totalvol":"23700.00","time":"2016/1/26 15:15:17"},
//		{"variety":"Au99.95","latestpri":"236.54","openpri":"234.7","maxpri":"236.54","minpri":"234.7","limit":"1.28%","yespri":"233.56","totalvol":"1612.00","time":"2016/1/26 15:15:17"},
//		{"variety":"Au(T+D)","latestpri":"236.5","openpri":"234.48","maxpri":"236.6","minpri":"233.82","limit":"1.23%","yespri":"233.62","totalvol":"75708.00","time":"2016/1/26 15:15:17"},
//		{"variety":"iAu99.99","latestpri":"236.5","openpri":"236.5","maxpri":"236.5","minpri":"236.5","limit":"1.5%","yespri":"233","totalvol":"1202.36","time":"2016/1/26 15:15:17"},
//		{"variety":"Ag99.9","latestpri":"0.00","openpri":"0.00","maxpri":"0.00","minpri":"0.00","limit":"0.00%","yespri":"4092.00","totalvol":"0.00","time":"2016/1/26 15:15:17"},
//		{"variety":"iAu99.5","latestpri":"0.00","openpri":"0.00","maxpri":"0.00","minpri":"0.00","limit":"0.00%","yespri":"237.80","totalvol":"0.00","time":"2016/1/26 15:15:17"},
//		{"variety":"Pt99.95","latestpri":"195.75","openpri":"195.5","maxpri":"195.75","minpri":"195.5","limit":"2.39%","yespri":"191.18","totalvol":"148.00","time":"2016/1/26 15:15:17"},
//		{"variety":"iAu100g","latestpri":"233","openpri":"233","maxpri":"233","minpri":"233","limit":"1.31%","yespri":"229.98","totalvol":"0.00","time":"2016/1/26 15:15:17"},
//		{"variety":"Au(T+N1)","latestpri":"238.5","openpri":"234.05","maxpri":"238.5","minpri":"233.5","limit":"1.75%","yespri":"234.4","totalvol":"265.40","time":"2016/1/26 15:15:17"},
//		{"variety":"Au(T+N2)","latestpri":"240.8","openpri":"239","maxpri":"240.8","minpri":"237.2","limit":"1.43%","yespri":"237.4","totalvol":"41.40","time":"2016/1/26 15:15:17"},
//		{"variety":"Au100g","latestpri":"236.38","openpri":"233.75","maxpri":"236.5","minpri":"233.65","limit":"1.2%","yespri":"233.58","totalvol":"47.20","time":"2016/1/26 15:15:17"},
//		{"variety":"mAu(T+D)","latestpri":"236.64","openpri":"234.35","maxpri":"236.66","minpri":"233.9","limit":"1.31%","yespri":"233.59","totalvol":"3567.60","time":"2016/1/26 15:15:17"},
//		{"variety":"Ag(T+D)","latestpri":"3269","openpri":"3245","maxpri":"3271","minpri":"3242","limit":"0.9%","yespri":"3240","totalvol":"1244110.00","time":"2016/1/26 15:15:17"},
//		{"variety":"Au99.99","latestpri":"236.65","openpri":"234","maxpri":"236.8","minpri":"233.81","limit":"1.27%","yespri":"233.69","totalvol":"19355.90","time":"2016/1/26 15:15:17"}]}


	}

}
