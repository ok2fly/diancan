//@formatter:off
/* ========================================== */
/*  Copyright(c) 2016 Neusoft Corporation.    */
/*            All rights reserved.            */
/*           Neusoft CONFIDENTIAL             */
/* ========================================== */
//@formatter:on
package com.qinergy.dto.common;

/**
 * 用户常用参数
 * <p>
 * This contains the following attributes:<br/>
 * <li><code>SUCCESS</code></li>
 * <li><code>ERROR</code></li>
 * <li><code>PARAMETER_ERROR</code></li>
 * <li><code>USR_EXCEPTIONS</code></li>
 * <li><code>PARAM_ERROR</code></li>
 * <li><code>PARAM_SESSIONID</code></li>
 * <li><code>PAY_PASSWD</code></li>
 * <li><code>ERROR_CODE</code></li>
 * <li><code>ERROR_CARD</code></li>
 * <li><code>SUCCESS_CARD</code></li>
 * <li><code>ERROR_ID_CARD</code></li>
 * <li><code>CHECK_CODE_ERROR</code></li>
 * <li><code>ERROR_BALANCE</code></li>
 * <li><code>ERROR_OLDPASSWD</code></li>
 * <li><code>ERROR_SELLOUT</code></li>
 * <li><code>ISNOT_PHONE</code></li>
 * <li><code>BANK_CARD_ERROR</code></li>
 * <li><code>BANK_CARD_CHECK_NOAGGREE</code></li>
 * <li><code>BANK_CARD_CHECK_NOTSUPPORL</code></li>
 * <li><code>BANK_CARD_CHECK_NOTCASHCARD</code></li>
 * <li><code>aa</code></li>
 * <li><code>TRANSIENT_USER</code></li>
 * <li><code>USER_NOT_EXIST</code></li>
 * <li><code>PASSWD_INVALID</code></li>
 * <li><code>USER_EXIST</code></li>
 * <li><code>ANSWER_IS_INVALID</code></li>
 * <li><code>CODE_ERROR</code></li>
 * <li><code>ISNOTREGIT</code></li>
 * <li><code>EMAIL_EXIST</code></li>
 * <li><code>MOBILE_EXIST</code></li>
 * <li><code>BLACKUSER_EXIST</code></li>
 * <li><code>REGISTER_CAN</code></li>
 * <li><code>SEND_NEVER</code></li>
 * <li><code>SEND_OVER</code></li>
 * <li><code>SEND_OK</code></li>
 * <li><code>CHANNEL_NOT_EXIST</code></li>
 * <li><code>FORMAT_ERROR</code></li>
 * <li><code>USER_UPDATE</code></li>
 * <li><code>USER_SERVER_EXCEPTION</code></li>
 * <li><code>CODE_EXPIRE</code></li>
 * <li><code>USER_LOGIN_FREQUENCY</code></li>
 * <li><code>OLDPASSWORD_INVALIDE</code></li>
 * <p>
 * 
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
public class UserConstants {
	/***
	 * 操作成功
	 */
	public static final int SUCCESS = 1;
	/**
	 * 操作异常
	 */
	public static final int ERROR = 0;
	/**
	 * 入参异常
	 */
	public static final int PARAMETER_ERROR = 507;
	/**
	 * 接口异常
	 */
	public static final int USR_EXCEPTIONS = -1;
	/**
	 * 参数错误
	 */
	public static final int PARAM_ERROR = 11;
	/**
	 * userid 为空 未登录状态
	 */
	public static final int PARAM_SESSIONID = 22;
	/**
	 * 验证码错误
	 */
	public static final int CHECK_CODE_ERROR = 10014;
	/**
	 * 是否是手机号
	 */
	public static final int ISNOT_PHONE = 10018;
	/**
	 * 未登录状态
	 */
	public static final String TRANSIENT_USER = "transient";
	/**
	 * 用户不存在
	 */
	public static final int USER_NOT_EXIST = 51;
	/**
	 * 密码不正确
	 */
	public static final int PASSWD_INVALID = 2;
	/**
	 * 用户已经存在
	 */
	public static final int USER_EXIST = 3;
	/**
	 * 用户忘记密码的答案不对
	 */
	public static final int ANSWER_IS_INVALID = 4;
	/**
	 * 用户暂时无法注册
	 */
	public static final int ISNOTREGIT = 30;
	/**
	 * 邮箱已经存在
	 */
	public static final int EMAIL_EXIST = 8;
	/**
	 * 手机号已经存在
	 */
	public static final int MOBILE_EXIST = 9;
	/**
	 * 可以注册
	 */
	public static final int REGISTER_CAN = 12;
	/**
	 * 可以发送验证码
	 */
	public static final int SEND_OK = 15;
	/**
	 * 手机号或者邮箱格式不对
	 */
	public static final int FORMAT_ERROR = 17;
	/**
	 * 修改成功
	 */
	public static final int USER_UPDATE = 18;
	/**
	 * 服务异常
	 */
	public static final int USER_SERVER_EXCEPTION = 19;
	/**
	 * 用户登陆频率
	 */
	public static final int USER_LOGIN_FREQUENCY = 21;
	/**
	 * 原密码不正确
	 */
	public static final int OLDPASSWORD_INVALIDE = 5;
	/**
	 * 验证码错误
	 */
	public static final int CODE_ERROR = 7;
	/**
	 * 验证码已过期
	 */
	public static final int CODE_EXPIRE = 20;
}
