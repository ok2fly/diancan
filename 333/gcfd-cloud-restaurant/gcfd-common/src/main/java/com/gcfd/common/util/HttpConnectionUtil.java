package com.gcfd.common.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @类名：HttpConnectionUtil.java
 * @作者：ONE
 * @时间 2016年07月15日14:14:01
 * @版权：ONE
 * @version  1.0
 * @描述：
*/
public class HttpConnectionUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpConnectionUtil.class);
	
	@SuppressWarnings("serial")
	public void test(){
		Map<String, String> head = new HashMap<String, String>(){{
			put("Content-Type", "application/json;charset=utf-8");//JSON 方式
			put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11");// Chrome
		}};
		Map<String, Object> params = new HashMap<String, Object>(){{
			put("loginName", "彭凯");
			put("password", "1234567");
		}};
		String netData = HttpConnectionUtil.getString(PropertiesUtil.get("system.loginUrl"), params, head);
		logger.debug("-------------------------登录反馈:",netData);
	}	
	/**
	 * 默认为 GET 请求
	 * @param url
	 * @return
	 */
	public static String getString(String url){
		return httpString(url, null, null, "GET");
	}
	/**
	 * 默认为 POST 请求
	 * @param url
	 * @return
	 */
	public static String postString(String url){
		return httpString(url, null, null, "POST");
	}
	/**
	 * 默认为 POST 请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static String postString(String url,Map<String,Object> params){
		return httpString(url, params, null, "POST");
	}
	/**
	 * 默认为 GET 请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static String getString(String url,Map<String,Object> params){
		return httpString(url, params, null, "GET");
	}
	/**
	 * 默认为 POST 请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static String postString(String url,Map<String,Object> params,Map<String,String> head){
		return httpString(url, params, head, "POST");
	}
	/**
	 * 默认为 GET 请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static String getString(String url,Map<String,Object> params,Map<String,String> head){
		return httpString(url, params, head, "GET");
	}
	
	
	/**
	 * 默认为 GET 请求
	 * @param url
	 * @return
	 */
	public static InputStream getInputStream(String url){
		return httpInputStream(url, null, null, "GET");
	}
	/**
	 * 默认为 POST 请求
	 * @param url
	 * @return
	 */
	public static InputStream postInputStream(String url){
		return httpInputStream(url, null, null, "POST");
	}
	/**
	 * 默认为 POST 请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static InputStream postInputStream(String url,Map<String,Object> params){
		return httpInputStream(url, params, null, "POST");
	}
	/**
	 * 默认为 GET 请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static InputStream getInputStream(String url,Map<String,Object> params){
		return httpInputStream(url, params, null, "GET");
	}
	/**
	 * 默认为 POST 请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static InputStream postInputStream(String url,Map<String,Object> params,Map<String,String> head){
		return httpInputStream(url, params, head, "POST");
	}
	/**
	 * 默认为 GET 请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static InputStream getInputStream(String url,Map<String,Object> params,Map<String,String> head){
		return httpInputStream(url, params, head, "GET");
	}

	
	
	
	/**
	 * 标准网络请求得到String
	 * @param url
	 * @param params
	 * @param head
	 * @param type
	 * @return
	 */
	private static String httpString(String url,Map<String,Object> params,Map<String,String> head,String type){
		OutputStreamWriter writer = null;
		InputStream inStream  = null;
		try{
			URL myURL = new URL(url);
			if("https".equals(myURL.getProtocol())){
				HttpsURLConnection conn = httpsURLConnection(type, myURL, head);
				if(params!=null && !params.isEmpty()){
					writer = new OutputStreamWriter(conn.getOutputStream());
					//发送参数
			        writer.write(JSON.toJSONString(params));
			        writer.flush();
				}
				inStream = conn.getInputStream();
				logger.debug("-----------------------------接口请求成功！ HttpsConnectionUtil - httpString---------------------------------------------");
				return new String(readInputStream(inStream),"UTF-8");
			}else if("http".equals(myURL.getProtocol())){
				HttpURLConnection conn = httpURLConnection(type, myURL, head);
				if(params!=null && !params.isEmpty()){
					writer = new OutputStreamWriter(conn.getOutputStream());
			        //发送参数
			        writer.write(JSON.toJSONString(params));
			        writer.flush();
				}
				inStream = conn.getInputStream();
				logger.debug("-----------------------------接口请求成功！ HttpConnectionUtil - httpString---------------------------------------------");
				return new String(readInputStream(inStream),"UTF-8");
			}
		}catch(Exception e){
			logger.error("-----------------------------接口请求失败！ HttpConnectionUtil - httpString---------------------------------------------");
			e.printStackTrace();
		}finally {
			try{
				if(writer!=null)writer.close();
			}catch(Exception e){}
			try{
				if(inStream!=null)inStream.close();
			}catch(Exception e){}
		}
		return null;
	}
	/**
	 * 标准网络请求得到输入流
	 * @param url
	 * @param params
	 * @param head
	 * @param type
	 * @return
	 */
	private static InputStream httpInputStream(String url,Map<String,Object> params,Map<String,String> head,String type){
		OutputStreamWriter writer = null;
		try{
			URL myURL = new URL(url);
			if("https".equals(myURL.getProtocol())){
				HttpsURLConnection conn = httpsURLConnection(type, myURL, head);
				if(params!=null && !params.isEmpty()){
					writer = new OutputStreamWriter(conn.getOutputStream());
			        //发送参数
			        writer.write(JSON.toJSONString(params));
			        writer.flush();
				}
				logger.debug("-----------------------------接口请求成功！ HttpsConnectionUtil - httpInputStream---------------------------------------------");
				return conn.getInputStream();
			}else if("http".equals(myURL.getProtocol())){
				HttpURLConnection conn = httpURLConnection(type,myURL,head);
				if(params!=null && !params.isEmpty()){
					writer = new OutputStreamWriter(conn.getOutputStream());
			        //发送参数
			        writer.write(JSON.toJSONString(params));
			        writer.flush();
				}
				logger.debug("-----------------------------接口请求成功！ HttpConnectionUtil - httpInputStream---------------------------------------------");
				return conn.getInputStream();
			}	
		}catch(Exception e){
			logger.error("-----------------------------接口请求失败！ HttpConnectionUtil - httpInputStream---------------------------------------------");
			e.printStackTrace();
		}finally {
			try{
				if(writer!=null)writer.close();
			}catch(Exception e){}
		}
		return null;
	}
	
	
	
	/**
	 * 构建一个标准网络连接
	 * @param requestMethod
	 * @param head
	 * @param url
	 * @return
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	private static HttpURLConnection httpURLConnection(String requestMethod,URL url,Map<String, String> head) throws Exception {
		HttpURLConnection httpc = (HttpURLConnection) url.openConnection();
		httpc.setRequestMethod(requestMethod);// 提交模式
		httpc.setDoOutput(true);// 是否输入参数
		httpc.setRequestProperty("charset", "utf-8");
		httpc.setReadTimeout(60000);//过期时间1分钟，如果网络无反应
		httpc.setUseCaches(false);
		if(head!=null){
			for (Entry<String, String> entry: head.entrySet()) {
				httpc.setRequestProperty(entry.getKey(), entry.getValue());
			} 
		}
		return httpc;
	}
	
	
	
	/**
	 * @description 构建需SSL证书的https网络连接
	 * @author  王童博
	 * @date 2016年9月1日下午4:08:29
	 * @version 1.0
	 * @param requestMethod
	 * @param url
	 * @param head
	 * @return
	 * @throws Exception
	 */
	private static HttpsURLConnection httpsURLConnection(String requestMethod,URL url,Map<String, String> head) throws Exception {
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {return null;}
			@Override
			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}}};
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		// 创建URL对象
		// "https://login.qiuruisi.com/server/SMS/sendSMS"
		// 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
		HttpsURLConnection httpsConn = (HttpsURLConnection)url.openConnection();
		httpsConn.setSSLSocketFactory(ssf);
		httpsConn.setRequestMethod(requestMethod);
		httpsConn.setDoOutput(true);// 是否输入参数
		httpsConn.setDoInput(true);
		httpsConn.setRequestProperty("charset", "utf-8");
		httpsConn.setReadTimeout(60000);//过期时间1分钟，如果网络无反应
		httpsConn.setUseCaches(false);
		if(head!=null){
			for (Entry<String, String> entry: head.entrySet()) {
				httpsConn.setRequestProperty(entry.getKey(), entry.getValue());
			} 
		}
		return httpsConn;
	}
	
	/**
	 * 从输入流中读取数据
	 * @param inStream
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	private static byte[] readInputStream(InputStream inStream) throws Exception {
		try(ByteArrayOutputStream outStream = new ByteArrayOutputStream();){
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			byte[] data = outStream.toByteArray();
			return data;
		}finally {
			if(inStream!=null)inStream.close();
		}
	}
}