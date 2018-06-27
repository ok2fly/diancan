package com.qinergy.controller.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.Pager;
import com.qinergy.dto.common.UserConstants;
import com.qinergy.dto.system.UserDto;
import com.qinergy.dto.system.UserRoleDto;
import com.qinergy.dto.system.UserRoleModuleButtonDto;
import com.qinergy.dto.system.UserRoleModuleDto;
import com.qinergy.service.dailyoffice.DailyOfficeService;
import com.qinergy.service.login.UserService;
import com.qinergy.service.sendsms.SendSMSService;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.StringUtil;

/**
 * 登录及与用户有关对前端页面接口类
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "")
public class UserController {

	private static Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private SendSMSService sendService;
	
	
	@Autowired
	private DailyOfficeService dailyOfficeService;


	/**
	 * 登录入口（登录主方法）(PC)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/userLogin")
	@ResponseBody
	public BaseTransferEntity userLogin(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		int flag = UserConstants.PARAM_ERROR;

		try {
			// 登录名
			String loginName = request.getParameter("loginName");
			// 密码
			String password = request.getParameter("password");
			// 验证码
			String code = request.getParameter("code");
			// 记录log日志，日志中把登录名、验证码、session中存的验证码（就是通过获取验证码接口获取得的验证码）给打印出来
			
			//判断验证码是否与生成的验证码一样
			if (code != null && request!= null && request.getSession() != null && request.getSession().getAttribute("verifyCode") != null && !code.equalsIgnoreCase(request.getSession().getAttribute("verifyCode").toString())) {  //忽略验证码大小写
				// 返回代码：USR104
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.identity"));
				// 无数据返回
				baseTransferEntity.setData("");
				// 返回信息：验证码错误
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.identity"));
				// 记录log日志
				log.info("验证码不正确，登录名为：" + loginName);
			
			}else{
				//新建变量，该变量名为：存放新MD5密码
				String md5NewPasswd = "";
				// 新建实体类用户信息类
				UserDto userDto = new UserDto();
				// 将获取到的登录名，放入用户信息类实体类中
				userDto.setLogin_name(loginName);
				// 新建一个map集合
				Map<String, Object> map = new HashMap<String, Object>();
				// 新建一个用于存放用户信息的map集合
				Map<String, Object> userMap = new HashMap<String, Object>();
				// 新建一个list集合
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				// 判断由登录页输入的密码是否为空
				if (!StringUtil.isEmpty(password)) {
					// 将输入进来的密码转成MD5加密的方式
					md5NewPasswd = StringUtil.md5Encrypt(password, "UTF-8");
					// 将转换成MD5的密码，放入用户信息实体类中
					userDto.setPassword(md5NewPasswd);
					// 使用输入进来的登录名、转换完成的MD5密码，进入数据库中查询用户信息
					map = userService.userLogin(userDto);
					// 如返回的用户信息中，reason字段不为空
					if (map != null && map.get("reason") != null) {
						// 取出reason字段为何值
						flag = Integer.parseInt(map.get("reason").toString());
						// 如果获取的用户详情不为空
						if (map.get("userMap") != null) {
							
							userMap = (Map<String, Object>) map.get("userMap");
							
							md5NewPasswd = StringUtil.md5Encrypt(password, "UTF-8");
							
							userDto.setPassword(md5NewPasswd);
							// 判断用户详情中，rol_id即该用户是否有权限
							if (userMap != null && userMap.get("rol_id") != null) {
								
								userDto.setRol_id(Integer.parseInt(userMap.get("rol_id").toString()));
								// 如果有权限，则获取该用户权限信息
								list = userService.getUserAuthorityPC(userDto);
								
								// 如果flag==1(如果用户信息获取正常、有权限登录该系统)
								if (flag == 1) {
									// 设定该登录后的页面session过期时间为2小时
									request.getSession().setMaxInactiveInterval(
											12 * 60 * 60);// 以秒为单位
									// 将获取到的用户信息传给前端页面，并放入session缓存中
									request.getSession().setAttribute("user", userMap);
									// 将获取到的用户权限即菜单信息，传给前端页面，并放入session缓存中
									request.getSession().setAttribute("menu", list);
								}
							}
						}
					}
					
				} else {
					// 判断由登录页输入的密码为空,返回参数错误信息提示
					flag = UserConstants.PARAM_ERROR;
				}
				
				if (flag == UserConstants.SUCCESS) {// 登陆成功
					
					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
					
					baseTransferEntity.setData(userMap);
					
					baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
					
					log.info("登录成功，登录名为：" + loginName);
				
				} else if (flag == UserConstants.PARAM_ERROR) {// 参数异常
					
					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.param"));
					
					baseTransferEntity.setData("");
					
					baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.param"));
					
					log.info("参数异常，登录名为：" + loginName);
				
				} else if (flag == UserConstants.PASSWD_INVALID) {// 密码不正确
					
					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.login"));
					
					baseTransferEntity.setData("");
					
					baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.login"));
					
					log.info("密码不正确，登录名为：" + loginName);
				
				} else if (flag == UserConstants.USER_NOT_EXIST) {// 用户不存在
					
					baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exsit"));
					
					baseTransferEntity.setData("");
					
					baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.exsit"));
					
					log.info("用户未注册，登录名为：" + loginName);
				}
			}
		} catch (Exception e) {
			
			log.error("UserController userLogin--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 登录入口（登录主方法(App-iOS)）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/userLoginApp")
	@ResponseBody
	public BaseTransferEntity userLoginApp(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		int flag = UserConstants.PARAM_ERROR;
		
		try {
			// 登录名
			String loginName = request.getParameter("loginName");
			// 密码
			String password = request.getParameter("password");
			//新建变量，该变量名为：存放新MD5密码
			String md5NewPasswd = "";
			// 新建实体类用户信息类
			UserDto userDto = new UserDto();
			// 将获取到的登录名，放入用户信息类实体类中
			userDto.setLogin_name(loginName);
			// 新建一个map集合
			Map<String, Object> map = new HashMap<String, Object>();
			// 新建一个用于存放用户信息的map集合
			Map<String, Object> userMap = new HashMap<String, Object>();
			// 新建一个list集合
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			// 判断由登录页输入的密码是否为空
			if (!StringUtil.isEmpty(password)) {
				// 将输入进来的密码转成MD5加密的方式
				md5NewPasswd = StringUtil.md5Encrypt(password, "UTF-8");
				// 将转换成MD5的密码，放入用户信息实体类中
				userDto.setPassword(md5NewPasswd);
				// 使用输入进来的登录名、转换完成的MD5密码，进入数据库中查询用户信息
				map = userService.userLogin(userDto);
				// 如返回的用户信息中，reason字段不为空
				if (map != null && map.get("reason") != null) {
					// 取出reason字段为何值
					flag = Integer.parseInt(map.get("reason").toString());
					// 如果获取的用户详情不为空
					if (map.get("userMap") != null) {
						
						userMap = (Map<String, Object>) map.get("userMap");
						
						md5NewPasswd = StringUtil.md5Encrypt(password, "UTF-8");
						
						userDto.setPassword(md5NewPasswd);
						// 判断用户详情中，rol_id即该用户是否有权限
						if (userMap != null && userMap.get("rol_id") != null) {
							
							userDto.setRol_id(Integer.parseInt(userMap.get("rol_id").toString()));
							// 如果有权限，则获取该用户权限信息
							list = userService.getUserAuthorityPC(userDto);
							
							// 如果flag==1(如果用户信息获取正常、有权限登录该系统)
							if (flag == 1) {
								// 设定该登录后的页面session过期时间为2小时
								request.getSession().setMaxInactiveInterval(
										2 * 60 * 60);// 以秒为单位
								// 将获取到的用户信息传给前端页面，并放入session缓存中
								request.getSession().setAttribute("user", userMap);
								// 将获取到的用户权限即菜单信息，传给前端页面，并放入session缓存中
								request.getSession().setAttribute("menu", list);
							}
						}
					}
				}
				
			} else {
				// 判断由登录页输入的密码为空,返回参数错误信息提示
				flag = UserConstants.PARAM_ERROR;
			}
			
			if (flag == UserConstants.SUCCESS) {// 登陆成功
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setData(userMap);
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
				
				log.info("登录成功，登录名为：" + loginName);
				
			} else if (flag == UserConstants.PARAM_ERROR) {// 参数异常
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.param"));
				
				baseTransferEntity.setData("");
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.param"));
				
				log.info("参数异常，登录名为：" + loginName);
				
			} else if (flag == UserConstants.PASSWD_INVALID) {// 密码不正确
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.login"));
				
				baseTransferEntity.setData("");
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.login"));
				
				log.info("密码不正确，登录名为：" + loginName);
				
			} else if (flag == UserConstants.USER_NOT_EXIST) {// 用户不存在
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exsit"));
				
				baseTransferEntity.setData("");
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.exsit"));
				
				log.info("用户未注册，登录名为：" + loginName);
			}
		} catch (Exception e) {
			
			log.error("UserController userLoginApp--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}


	/**
	 * 登录入口（登录主方法） app 新增修改的方法(安卓)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/userLoginAppNew")
	@ResponseBody
	public BaseTransferEntity userLoginAppNew(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		List a = new ArrayList();
		int flag = UserConstants.PARAM_ERROR;
		
		try {
			// 登录名
			String loginName = request.getParameter("loginName");
			// 密码
			String password = request.getParameter("password");
			//新建变量，该变量名为：存放新MD5密码
			String md5NewPasswd = "";
			// 新建实体类用户信息类
			UserDto userDto = new UserDto();
			// 将获取到的登录名，放入用户信息类实体类中
			userDto.setLogin_name(loginName);
			// 新建一个map集合
			Map<String, Object> map = new HashMap<String, Object>();
			// 新建一个list集合
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			// 判断由登录页输入的密码是否为空
			if (!StringUtil.isEmpty(password)) {
				// 将输入进来的密码转成MD5加密的方式
				md5NewPasswd = StringUtil.md5Encrypt(password, "UTF-8");
				// 将转换成MD5的密码，放入用户信息实体类中
				userDto.setPassword(md5NewPasswd);
				// 使用输入进来的登录名、转换完成的MD5密码，进入数据库中查询用户信息
				map = userService.userLogin(userDto);
				// 如返回的用户信息中，reason字段不为空
				if (map != null && map.get("reason") != null) {
					// 取出reason字段为何值
					flag = Integer.parseInt(map.get("reason").toString());
					
					// 如果获取的用户详情不为空
					if (map.get("userMap") != null) {
						
						Map<String, Object> userMap = (Map<String, Object>) map.get("userMap");
						
						md5NewPasswd = StringUtil.md5Encrypt(password, "UTF-8");
						
						userDto.setPassword(md5NewPasswd);
						// 判断用户详情中，rol_id即该用户是否有权限
						if (userMap != null && userMap.get("rol_id") != null) {
							
							userDto.setRol_id(Integer.parseInt(userMap.get("rol_id").toString()));
							
							List<Map<String, Object>> autLst = new ArrayList<Map<String, Object>>();
							// 如果有权限，则获取该用户权限信息
							autLst = userService.getUserAuthorityAppNew(userDto);
							
							map.put("shouye1", autLst.get(0).get("shouye1"));
							map.put("shouye2", autLst.get(1).get("shouye2"));
							map.put("shouye3", autLst.get(2).get("shouye3"));
							map.put("shouye4", autLst.get(3).get("shouye4"));
							map.put("shouye5", autLst.get(4).get("shouye5"));
							map.put("shouye6", autLst.get(5).get("shouye6"));
							map.put("shouye7", autLst.get(6).get("shouye7"));
							map.put("shouye8", autLst.get(7).get("shouye8"));
							map.put("shouye9", autLst.get(8).get("shouye9"));
							map.put("shouye21", autLst.get(9).get("shouye21"));
							map.put("shouye22", autLst.get(10).get("shouye22"));
							map.put("shouye23", autLst.get(11).get("shouye23"));
							map.put("shouye24", autLst.get(12).get("shouye24"));
							map.put("shouye25", autLst.get(13).get("shouye25"));
							map.put("shouye26", autLst.get(14).get("shouye26"));
							map.put("shouye31", autLst.get(15).get("shouye31"));
							map.put("shouye32", autLst.get(16).get("shouye32"));
							map.put("shouye33", autLst.get(17).get("shouye33"));
							map.put("shouye34", autLst.get(18).get("shouye34"));
							map.put("shouye41", autLst.get(19).get("shouye41"));
							map.put("shouye42", autLst.get(20).get("shouye42"));
							map.put("shouye43", autLst.get(21).get("shouye43"));
							map.put("shouye91", autLst.get(22).get("shouye91"));
							map.put("shouye92", autLst.get(23).get("shouye92"));
							map.put("shouye93", autLst.get(24).get("shouye93"));
							map.put("shouye94", autLst.get(25).get("shouye94"));
							map.put("shouye95", autLst.get(26).get("shouye95"));
							
						}
					}
				}
				// 如返回的用户信息中，reason字段不为空
				list.add(map);
			} else {
				// 判断由登录页输入的密码为空,返回参数错误信息提示
				flag = UserConstants.PARAM_ERROR;
			}
			
			if (flag == UserConstants.SUCCESS) {// 登陆成功
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setData(list);
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
				
				log.info("登录成功，登录名为：" + loginName);
				
			} else if (flag == UserConstants.PARAM_ERROR) {// 参数异常
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.param"));
				
				baseTransferEntity.setData("");
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.param"));
				
				log.info("参数异常，登录名为：" + loginName);
				
			} else if (flag == UserConstants.PASSWD_INVALID) {// 密码不正确
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.login"));
				
				baseTransferEntity.setData("");
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.login"));
				
				log.info("密码不正确，登录名为：" + loginName);
				
			} else if (flag == UserConstants.USER_NOT_EXIST) {// 用户不存在
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exsit"));
				
				baseTransferEntity.setData("");
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.exsit"));
				
				log.info("用户未注册，登录名为：" + loginName);
			}
		} catch (Exception e) {
			
			log.error("UserController userLoginApp--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(a);
		}
		
		return baseTransferEntity;
	}

	
	/**
	 * @Title: createCode
	 * @Description: 生成验证码(PC)
	 * @author iceX
	 * @throws Exception
	 */
	@RequestMapping(value = "/getVerificationCode")
	public String createCode(HttpServletRequest request,HttpServletResponse response) throws Exception {

		// 构建返回头（response）
		response.setContentType("image/jpeg");

		response.setHeader("Pragma", "No-cache");

		response.setHeader("Cache-Control", "no-cache");

		response.setDateHeader("Expires", 0);

		HttpSession session = request.getSession();

		char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
				'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
		// 在内存中创建图象
		int width = 85, height = 35;

		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));

		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		// 画边框
		g.setColor(getRandColor(160, 200));

		g.drawRect(7, 7, width - 8, height - 8);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));

		for (int i = 0; i < 155; i++) {

			int x = random.nextInt(width);

			int y = random.nextInt(height);

			int xl = random.nextInt(12);

			int yl = random.nextInt(12);

			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		String sRand = "";

		for (int i = 0; i < 4; i++) {

			String rand = String.valueOf(codeSequence[random.nextInt(32)]);

			sRand += rand;

			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 19 * i + 6, 28);
		}

		// 将认证码存入SESSION
		session.setAttribute("verifyCode", sRand);

		// 图象生效
		g.dispose();

		// 输出图象到页面
		ImageIO.write(image, "JPEG", response.getOutputStream());

		return null;
	}
	
	/**
	 * 给定范围获得随机颜色
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色

		Random random = new Random();

		if (fc > 255) {

			fc = 255;
		}

		if (bc > 255) {

			bc = 255;
		}

		int r = fc + random.nextInt(bc - fc);

		int g = fc + random.nextInt(bc - fc);

		int b = fc + random.nextInt(bc - fc);

		return new Color(r, g, b);
	}

	/**
	 * 修改密码(PC+app)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updateUserPassWd")
	@ResponseBody
	public BaseTransferEntity updateUserPassWd(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 登录名
			String loginName = request.getParameter("loginName");
			// 新密码
			String passwordNew = request.getParameter("passwordNew");
			// 新密码确认
			String passwordNewCon = request.getParameter("passwordNewCon");
			
			if(!passwordNew.equals(passwordNewCon)){
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				
				baseTransferEntity.setDesc("两次输入的密码不一致，请重新输入！");
				
				log.info("修改用户名称：" + loginName + "两次输入密码不一致！");
				
				return baseTransferEntity;
				
			}
			
			// 旧密码
			String passwordOld = request.getParameter("passwordOld");
			
			if (passwordNew.equalsIgnoreCase(passwordOld)) {//新密码与旧密码不能一致
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				
				baseTransferEntity.setDesc("新密码与旧密码不能相同，请重新输入！");
				
				log.info("修改用户名称：" + loginName + "新密码与旧密码一致，请重新输入！");
				
				return baseTransferEntity;
			}
			

			String md5OldPasswd = "";

			String md5NewPasswd = "";
			// 旧密码转成MD5
			md5OldPasswd = StringUtil.md5Encrypt(passwordOld, "UTF-8");
			// 新密码转成MD5
			md5NewPasswd = StringUtil.md5Encrypt(passwordNew, "UTF-8");
			// 将数据库内的旧密码替换成新密码
			int flag = userService.updateUserPassWd(loginName, md5NewPasswd,md5OldPasswd);

			if (flag == UserConstants.SUCCESS) {// 修改密码成功

				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setData("");
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
				
				baseTransferEntity.setDesc("密码修改成功，请重新登录！");
				
				log.info("修改用户名称：" + loginName + "的账户密码，成功！");
				
				return baseTransferEntity;
				
			} else if (flag == UserConstants.PASSWD_INVALID) {// 原密码不正确
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.login"));
				
				baseTransferEntity.setData("");
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.error.login"));
				
				baseTransferEntity.setDesc("原始密码不正确，请确认后再修改！");
				
				log.info("修改用户名称：" + loginName + "的账户密码时，原始密码不正确！");
				
				return baseTransferEntity;
			}
		} catch (Exception e) {
			
			log.error("UserController updateUserPassWd--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * 获取用户的权限信息(PC)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUserAuthorityPC")
	@ResponseBody
	public BaseTransferEntity getUserAuthorityPC(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 用户的角色ID
			String role_id = request.getParameter("role_id");

			UserDto userDto = new UserDto();
			
			if(role_id != null && !role_id.isEmpty()){
				
				userDto.setRol_id(Integer.parseInt(role_id));
				
			}
			
			// 使用用户的角色ID,获取用户的角色权限信息
			List<Map<String, Object>> list = userService.getUserAuthorityPC(userDto);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(list);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UserController getUserAuthorityPC--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 获取用户的权限信息(App)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUserAuthorityApp")
	@ResponseBody
	public BaseTransferEntity getUserAuthorityApp(HttpServletRequest request,
			HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 用户的角色ID
			String role_id = request.getParameter("role_id");
			// 声明用户信息实体类
			UserDto userDto = new UserDto();
			
			userDto.setRol_id(Integer.parseInt(role_id));
			// 使用用户的角色ID,获取用户的角色权限信息
			List<Map<String, Object>> list = userService.getUserAuthorityApp(userDto);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(list);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("UserController getUserAuthorityApp--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * 建立角色与模块之间的关系(PC)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertUserRoleByModule")
	@ResponseBody
	public BaseTransferEntity insertUserRoleByModule(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			//角色id
			String role_id = request.getParameter("role_id");
			//模块id 多个  用 - 连接
			String module_ids = request.getParameter("module_ids");
			//当前执行操作的用户
			String use_id = request.getParameter("use_id");

			UserRoleModuleDto userRoleModuleDto = new UserRoleModuleDto();
			
			userRoleModuleDto.setRole_id(Integer.parseInt(role_id));
			
			//避免重复提交 添加  通过角色id 删除相关内容
			userService.deleteUserRoleByModule(userRoleModuleDto);
			
			//创建人id
			userRoleModuleDto.setCrt_use_id(Integer.parseInt(use_id));
			//创建时间
			userRoleModuleDto.setCrt_tim(new Date());
			
			
			if(module_ids != null && !module_ids.isEmpty()){
				
				String[] modIds = module_ids.split("-");
				
				for(int i = 0 ; i < modIds.length ; i++){
					//模块id
					userRoleModuleDto.setModule_id(Integer.parseInt(modIds[i]));
					// 调用建立角色与模块之间的关系的接口
					userService.insertUserRoleByModule(userRoleModuleDto);
				}
			}
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData("");
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
			log.info("成功的对角色进行了权限配置！角色ID为："+role_id+",操作者ID为："+use_id);
		} catch (Exception e) {
			
			log.error("UserController insertUserRoleByModule--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 建立角色与模块之间的关系(App)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertUserRoleByModuleApp")
	@ResponseBody
	public BaseTransferEntity insertUserRoleByModuleApp(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			//角色id
			String role_id = request.getParameter("role_id");
			//模块id 多个  用 - 连接
			String module_ids = request.getParameter("module_ids");
			//当前执行操作的用户
			String use_id = request.getParameter("use_id");
			
			UserRoleModuleDto userRoleModuleDto = new UserRoleModuleDto();
			
			userRoleModuleDto.setRole_id(Integer.parseInt(role_id));
			
			//避免重复提交 添加  通过角色id 删除相关内容
			userService.deleteUserRoleByModuleApp(userRoleModuleDto);
			
			//创建人id
			userRoleModuleDto.setCrt_use_id(Integer.parseInt(use_id));
			//创建时间
			userRoleModuleDto.setCrt_tim(new Date());
			
			
			if(module_ids != null && !module_ids.isEmpty()){
				
				String[] modIds = module_ids.split("-");
				
				for(int i = 0 ; i < modIds.length ; i++){
					// 模块id
					userRoleModuleDto.setModule_id(Integer.parseInt(modIds[i]));
					// 调用建立角色与模块之间的关系的接口
					userService.insertUserRoleByModuleApp(userRoleModuleDto);
				}
			}
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData("");
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
			log.info("成功的对角色App端进行了权限配置！角色ID为："+role_id+",操作者ID为："+use_id);
		} catch (Exception e) {
			
			log.error("UserController insertUserRoleByModuleApp--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 建立菜单与按钮之间的关系(PC)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/insertUserRoleModuleByButton")
	@ResponseBody
	public BaseTransferEntity insertUserRoleModuleByButton(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 角色ID
			String role_id = request.getParameter("role_id");
			// 按钮ID拼接串
			String button_ids = request.getParameter("button_ids");
			// 菜单ID
			String module_id = request.getParameter("module_id");
			//用户ID
			String use_id = request.getParameter("use_id"); 
			
			UserRoleModuleButtonDto userRoleModuleButtonDto = new UserRoleModuleButtonDto();
			
			userRoleModuleButtonDto.setRole_id(Integer.parseInt(role_id));
			
			userRoleModuleButtonDto.setModule_id(Integer.parseInt(module_id));
		
			// 使用指定角色获取角色与菜单中间表的所有数据唯一性标记删除已分配权限的菜单与按钮的中间关系表中的数据
			userService.deleteUserRoleModuleButtonByCrtIde(userRoleModuleButtonDto);
			
			userRoleModuleButtonDto.setCrt_use_id(Integer.parseInt(use_id));
			
			userRoleModuleButtonDto.setCrt_tim(new Date());
			// 遍历按钮ID集合
			if(button_ids != null && !button_ids.isEmpty()){
				
				String[] bttIds = button_ids.split("-");
				
				for(int i = 0 ; i < bttIds.length ; i++){
					
					userRoleModuleButtonDto.setBtt_id(Integer.parseInt(bttIds[i]));
					// 向已分配权限的菜单与按钮的中间关系表中添加信息
					userService.insertUserRoleModuleButton(userRoleModuleButtonDto);
				}
			}
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData("");
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
			log.info("成功的对角色进行了权限配置！角色ID为："+role_id+",操作者ID为："+use_id);
			
		} catch (Exception e) {
			
			log.error("UserController insertUserRoleByModule--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 获取系统中某菜单中的按钮与某角色被分配的按钮的关系（PC）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUserRoleModuleByButtonLevl")
	@ResponseBody
	public BaseTransferEntity getUserRoleModuleByButtonLevl(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 
			String role_id = request.getParameter("role_id");
			
			String module_id = request.getParameter("module_id");
			
//			String use_id = request.getParameter("use_id");
			
			UserRoleModuleDto userRoleModuleDto = new UserRoleModuleDto();
			
			userRoleModuleDto.setRole_id(Integer.parseInt(role_id));
			
			userRoleModuleDto.setModule_id(Integer.parseInt(module_id));
			
			List<Map<String, Object>> buttonLevlLst = userService.getUserRoleModuleByButtonLevl(userRoleModuleDto);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(buttonLevlLst);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
//			log.info("成功的对角色进行了权限配置！角色ID为："+role_id+",操作者ID为："+use_id);
			
		} catch (Exception e) {
			
			log.error("UserController insertUserRoleByModule--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("'获取系统中某菜单中的按钮与某角色被分配的按钮的关系'-->系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	

	/**
	 * 解除角色与模块之间的关系(弃用--删除)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
//	@RequestMapping(value = "/service/deleteUserRoleByModule")
//	@ResponseBody
//	public BaseTransferEntity deleteUserRoleByModule(HttpServletRequest request, HttpServletResponse response) {
//
//		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
//
//		try {
//			// 菜单（模块）ID
//			String module_id = request.getParameter("module_id");
//			// 角色ID
//			String role_id = request.getParameter("role_id");
//			// 用户ID
//			String use_id = request.getParameter("use_id");
//			
//			UserRoleModuleDto userRoleModuleDto = new UserRoleModuleDto();
//
//			userRoleModuleDto.setModule_id(Integer.parseInt(module_id));
//
//			userRoleModuleDto.setRole_id(Integer.parseInt(role_id));
//
//			// 查询出所有该角色下的所有菜单（中间表信息）
//			List<Map<String, Object>> crtIdeLst = userService.getUserRoleModuleCrtIde(userRoleModuleDto);
//			
//			if(crtIdeLst != null && !crtIdeLst.isEmpty()){
//				
//				for(Map<String, Object> crtIdeMap : crtIdeLst){
//					
//					// 使用中间表crt_ide删除所有关联的按钮
//					UserRoleModuleButtonDto userRoleModuleButtonDto = new UserRoleModuleButtonDto();
//					// 使用指定角色获取角色与菜单中间表的所有数据唯一性标记删除已分配权限的菜单与按钮的中间关系表中的数据
//					userService.deleteUserRoleModuleButtonByCrtIde(userRoleModuleButtonDto);
//				}
//			}
//			
//			// 删除与有与该角色有关的菜单
//			userService.deleteUserRoleByModule(userRoleModuleDto);
//			
//			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
//			
//			baseTransferEntity.setData("");
//			
//			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
//
//			log.info("成功的对角色权限进行了取消操作！角色ID为：" + role_id + ",操作者ID为：" + use_id);
//			
//		} catch (Exception e) {
//			
//			log.error("UserController deleteUserRoleByModule--------->" + e.getMessage(), e);
//			
//			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
//			
//			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
//			
//			baseTransferEntity.setData(null);
//		}
//		
//		return baseTransferEntity;
//	}

	/**
	 * 删除角色(PC)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/deleteUserRole")
	@ResponseBody
	public BaseTransferEntity deleteUserRole(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 角色ID
			String id = request.getParameter("id");
			// 用户ID
			String use_id = request.getParameter("use_id");
			// 角色信息实体
			UserRoleDto userRoleDto = new UserRoleDto();

			userRoleDto.setId(Integer.parseInt(id));
			
			userRoleDto.setMod_use_id(Integer.parseInt(use_id));
			
			userRoleDto.setMod_tim(new Date());
			
			// 删除角色信息（使用角色ID）
			userService.deleteUserRole(userRoleDto);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData("");
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
			log.info("成功的对角色进行了删除操作！角色ID为：" + id + ",操作者ID为：" + use_id);
			
		} catch (Exception e) {
			
			log.error("UserController deleteUserRole--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 获取指定的菜单下的按钮(弃用)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
//	@RequestMapping(value = "/service/getUserRoleModuleButtonByRolMod")
//	@ResponseBody
//	public BaseTransferEntity getUserRoleModuleButtonByRolMod(HttpServletRequest request,
//			HttpServletResponse response) {
//		
//		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
//		
//		try {
//			// 角色ID
//			String role_id = request.getParameter("role_id");
//			// 菜单ID
//			String module_id = request.getParameter("module_id");
//			// 用户ID
//			String use_id = request.getParameter("use_id");
//			// 角色与菜单中间表信息实体
//			UserRoleModuleDto userRoleModuleDto = new UserRoleModuleDto();
//			
//			userRoleModuleDto.setModule_id(Integer.valueOf(module_id));
//			
//			userRoleModuleDto.setRole_id(Integer.valueOf(role_id));
//			// 获取指定的菜单下的按钮
//			List<Map<String, Object>> buttonLst = userService.getUserRoleModuleButtonByRolMod(userRoleModuleDto);
//			
//			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
//			
//			baseTransferEntity.setData(buttonLst);
//			
//			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
//			
//			log.info("用户ID为"+use_id+"的用户，成功的获取了角色ID为"+role_id+"菜单ID为" + module_id + "的按钮信息。");
//			
//		} catch (Exception e) {
//			
//			log.error("UserController getUserRoleModuleButtonByRolMod--------->" + e.getMessage(),e);
//			
//			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
//			
//			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
//			
//			baseTransferEntity.setData(null);
//		}
//		
//		return baseTransferEntity;
//	}


	/**
	 * 登录跳转（PC）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/webUserLogin", method = RequestMethod.GET)
	public String webUserLogin(HttpServletRequest request) {
		// 获取session中的user(用户信息)
		Object user = request.getSession().getAttribute("user");
		// 如果用户信息存在
		if (user != null) {
			// 跳转至主页面
			return "main";

		} else {
			// 跳转至登录页面
			return "login";
		}
	}

	/**
	 * 退出登录（PC）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/exitLogin")
	public String exitLogin(HttpServletRequest request,HttpServletResponse response) {
		// 清除session中的用户信息
		request.getSession().removeAttribute("user");
		// 跳转至登录页面
		return "login";
	}

	/**
	 * 用户更新基本信息(PC)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updateUserInfo")
	@ResponseBody
	public BaseTransferEntity updateUserInfo(HttpServletRequest request,HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			//账号
			String acc_num = request.getParameter("acc_num");
			//邮箱
			String use_mal = request.getParameter("use_mal");
			//用户姓名
			String use_nam  = request.getParameter("use_nam");
			//性别   
			int use_sex = Integer.parseInt(request.getParameter("use_sex"));
			//手机号
			String use_mob  = request.getParameter("use_mob");
			//身份证
			String use_idc  = request.getParameter("use_idc");
			//地址
			String use_add  = request.getParameter("use_add");
			//用户状态
			int use_sta  = Integer.parseInt(request.getParameter("use_sta"));
			//职位id
			int pos_id  = Integer.parseInt(request.getParameter("pos_id"));
			//用户专业
			String use_maj  = request.getParameter("use_maj");
			//学历id
			int edu_id  = Integer.parseInt(request.getParameter("edu_id"));
			//参加工作时间
			String tak_tim  = request.getParameter("tak_tim");
			//籍贯
			String pla_ori  = request.getParameter("pla_ori");
			//备注
			String remark  = request.getParameter("remark");
			//角色id
			int rol_id  = Integer.parseInt(request.getParameter("rol_id"));
			//公司id
			int com_id  = Integer.parseInt(request.getParameter("com_id"));
			//部门id
			String dep_id  =request.getParameter("dep_id");
			//修改人id
			String mod_use_id  =request.getParameter("mod_use_id");
			
			String pic_url = request.getParameter("pic_url");
			
			String use_typ = request.getParameter("use_typ");
			
			//运维人员/站查看状态（1：可查看  2：不可查看
			String slt_opt_sta = request.getParameter("slt_opt_sta");
			//用户对告警信息是否可见，1（可见），如为2时，所有告警信息均不获取',
			String is_def_sta = request.getParameter("is_def_sta");
			
			map.put("id", id);
			
			map.put("acc_num", acc_num);
			
			map.put("use_mal", use_mal);
			
			map.put("use_nam", use_nam);
			
			map.put("use_sex", use_sex);
			
			map.put("use_mob", use_mob);
			
			map.put("use_idc", use_idc);
			
			map.put("use_add", use_add);
			
			map.put("use_sta", use_sta);
			
			map.put("pos_id", pos_id);
			
			map.put("use_maj", use_maj);
			
			map.put("edu_id", edu_id);
			
			map.put("use_typ", use_typ);
			
			if(!tak_tim.equals("") && tak_tim != null && !tak_tim.equals("null") && !tak_tim.isEmpty()){
				
				map.put("tak_tim", tak_tim);
			}else{
				
				map.put("tak_tim", "1970-01-01 08:00:00");
			}
			map.put("pla_ori", pla_ori);
			map.put("remark", remark);
			map.put("rol_id", rol_id);
			map.put("com_id", com_id);

			if(!dep_id.equals("") && dep_id != null && !dep_id.equals("null") && !dep_id.isEmpty()){
				
				map.put("dep_id", dep_id);
			}else{
				
				map.put("dep_id", 0);
			}
			map.put("mod_use_id", mod_use_id);

			map.put("mod_tim", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

			map.put("pic_url", pic_url);
			
			map.put("slt_opt_sta",slt_opt_sta);
			
			map.put("is_def_sta",is_def_sta);

			userService.updateUserInfo(map);

			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			log.info("成功的对用户ID为：" + id + "的用户进行了基本信息更新操作！");
		} catch (Exception e) {
			log.error(
					"UserInfoController updateUserInfo--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;

	}
	
	/**
	 * 用户更新基本信息（App）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/updateUserInfoApp")
	@ResponseBody
	public BaseTransferEntity updateUserInfoApp(HttpServletRequest request,
			HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			//邮箱
			String use_mal = request.getParameter("use_mal");
			//用户姓名
			String use_nam  = request.getParameter("use_nam");
			//性别   
			int use_sex = Integer.parseInt(request.getParameter("use_sex"));
			//手机号
			String use_mob  = request.getParameter("use_mob");
			//地址
			String use_add  = request.getParameter("use_add");
			//修改人id
			String mod_use_id  =request.getParameter("use_id");
			
			map.put("id", id);
			
			map.put("use_mal", use_mal);
			
			map.put("use_nam", use_nam);
			
			map.put("use_sex", use_sex);
			
			map.put("use_mob", use_mob);
			
			map.put("use_add", use_add);
			
			map.put("mod_use_id", mod_use_id);
			
			map.put("mod_tim", new Date());
			
			userService.updateUserInfoApp(map);
			
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			log.info("成功的对用户ID为：" + id + "的用户进行了基本信息更新操作！");
		} catch (Exception e) {
			log.error(
					"UserInfoController updateUserInfo--------->"
							+ e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig
					.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			baseTransferEntity.setData(null);
		}
		return baseTransferEntity;
		
	}

	/**
	 * 获取已选的和未选的所有模块信息(PC)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUserRoleByModuleLevl")
	@ResponseBody
	public BaseTransferEntity getUserRoleByModuleLevl(HttpServletRequest request, HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 角色ID
			String role_id = request.getParameter("role_id");

			UserDto userDto = new UserDto();

			userDto.setRol_id(Integer.parseInt(role_id));
			// 调用service层获取已选的和未选的所有模块信息方法
			List<Map<String, Object>> list = userService.getUserRoleByModuleLevl(userDto);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(list);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			log.error("UserController getUserRoleByModuleLevl--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	/**
	 * 获取已选的和未选的所有模块信息(App)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getUserRoleByModuleLevlApp")
	@ResponseBody
	public BaseTransferEntity getUserRoleByModuleLevlApp(HttpServletRequest request, HttpServletResponse response) {
		
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
		
		try {
			// 角色ID
			String role_id = request.getParameter("role_id");
			
			UserDto userDto = new UserDto();
			
			userDto.setRol_id(Integer.parseInt(role_id));
			// 调用service层获取已选的和未选的所有模块信息方法
			List<Map<String, Object>> list = userService.getUserRoleByModuleLevlApp(userDto);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(list);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			log.error("UserController getUserRoleByModuleLevlApp--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}

	/**
	 * 查询所有本公司的角色信息(PC)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/service/getBasRolInfo")
	@ResponseBody
	public BaseTransferEntity getBasRolInfo(HttpServletRequest request,
			HttpServletResponse response) {

		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 分页
			Pager page = new Pager();
			// 当前页
			String currentPage = request.getParameter("currentPage");

			if (currentPage != null && !currentPage.isEmpty()) {

				page.setCurrentPage(Integer.parseInt(currentPage));

			}
			// 角色名称
			String role_name = request.getParameter("role_name");
			// 公司ID
			String com_id = request.getParameter("com_id");

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("currentPage", page.getCurrentPage());

			map.put("start", page.getStart());

			map.put("role_name", role_name);

			map.put("com_id", com_id);
			// 获取角色数据数据量
			Map<String, Object> couMap = userService.getBasRolInfoCou(map);

			page.setTotalCount(Integer.parseInt(couMap.get("count").toString()));

			map.put("evertPage", page.getEveryPage());
			// 获取角色数据集合
			List<Map<String, Object>> list = userService.getBasRolInfo(map);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());

			baseTransferEntity.setEveryPage(page.getEveryPage());

			baseTransferEntity.setTotalCount(page.getTotalCount());

			baseTransferEntity.setTotalPage(page.getTotalPage());
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setData(list);
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		
		} catch (Exception e) {
		
			log.error("UserController getBasRolInfo--------->" + e.getMessage(),e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
			baseTransferEntity.setData(null);
		}
		
		return baseTransferEntity;
	}
	
	
}
