/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.sendsms;

import java.io.UnsupportedEncodingException;

/**
 * 发送短信基础类
 * <p>
 * This contains the following methods:<br/>
 * <li><code>sendSms</code></li>
 * <p>
 * 
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public interface SendSMSService {

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 *            <code>String</code> session ID
	 * @param requestType
	 *            <code>Integer</code> 发送验证码的类型
	 * @param tel
	 *            <code>String</code> 电话
	 * @return <code>Integer</code> 验证码
	 * @throws UnsupportedEncodingException
	 */
	public Integer sendSms(String sessionid, Integer requestType, String tel)
			throws UnsupportedEncodingException;

}
