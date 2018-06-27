/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.sendsms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;










import org.springframework.stereotype.Service;

import com.qinergy.dto.common.InterfaceConstants;
import com.qinergy.dto.common.UserConstants;

import net.sf.json.JSONObject;

/**
 * 发送短信基础类实现类
 * <p>
 * This contains the following methods:<br/>
 * <li><code>sendSms</code></li>
 * <p>
 * 
 * @see com.qianye.dto.common.InterfaceConstants
 * @see com.qianye.dto.common.UserConstants
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

@Service
public class SendSMSServiceImpl implements SendSMSService {
	
//	@Autowired
//	private EhcacheUtil ehcacheUtil;
	
//	@Autowired
//	private GetMobelNum getMobelNum;
	/**
	 * 发送短信验证码
	 * 
	 * <p>
	 * <b>Release Notes:</b> <br/>
	 * <table border="1" cellspacing="0" cellpadding="5" width="80%">
	 * <tr>
	 * <th align="left">Release</th>
	 * <th align="left">Notes</th>
	 * </tr>
	 * <tr>
	 * <td>@since 1.0</td>
	 * <td>&nbsp;</td>
	 * </tr>
	 * </table>
	 * <p>
	 * 
	 * @param sessionid
	 *            <code>String</code> session ID
	 * @param requestType
	 *            <code>Integer</code> 发送验证码的类型
	 * @param tel
	 *            <code>String</code> 电话
	 * @return <code>Integer</code> 验证码
	 * @throws UnsupportedEncodingException
	 */

	public Integer sendSms(String mobile, Integer requestType, String tel) throws UnsupportedEncodingException {

		// 生成验证码
		Random random = new Random();
		
		// 组成验证码信息
		int x_param = random.nextInt(900000) + 100000;
		
		HttpURLConnection httpconn = null;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(InterfaceConstants.AVATARDATA_SMS);
		
		sb.append(InterfaceConstants.SMS_KEY);

		if (requestType.equals(1)) {
			
			sb.append("&mobile=").append(mobile);
			
			sb.append("&templateId=").append(InterfaceConstants.REGIST_SMS_TEMPLATE_ID);
			
		} else if (requestType.equals(2)) {
			
			sb.append("&mobile=").append(mobile);
			
			sb.append("&templateId=").append(InterfaceConstants.FINDPASSWORD_SMS_TEMPLATE_ID);
			
		} else if (requestType.equals(3)) {
			
			if (tel != null && !"".equals(tel)) {
				
				sb.append("&mobile=").append(tel);
				
			} else {
				
				sb.append("&mobile=").append(mobile);
			}
			
			sb.append("&templateId=").append(InterfaceConstants.BANKCARD_SMS_TEMPLATE_ID);
			
		} else if (requestType.equals(4)) {
			
			sb.append("&mobile=").append(mobile);
			
			sb.append("&templateId=").append(InterfaceConstants.BANKCARD_SMS_TEMPLATE_ID);
		}
		
		sb.append("&param=").append(x_param);
		
		String redLine = "";

		// 发送验证码
		try {
			URL url = new URL(sb.toString());

			httpconn = (HttpURLConnection) url.openConnection();
			
			httpconn.setRequestProperty("Accept-Charset", "UTF-8");
			
			httpconn.setRequestProperty("contentType", "utf-8");

			BufferedReader rd = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));

			redLine = rd.readLine();
			
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
		
		JSONObject json = JSONObject.fromObject(redLine);
		
		String error_code = json.get("reason").toString();
		
		String str = json.get("reason").toString();
		
		if (!str.equals("Succes")) {
			
			return UserConstants.ERROR;
		}
		
		return x_param;
	}
}