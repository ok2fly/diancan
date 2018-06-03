package com.gcfd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcfd.util.ResponseUtil;
import com.gcfd.util.SCaptcha;

import net.sf.json.JSONObject;

@Controller
@RequestMapping( value="console/login")
public class VerifyCodeController {
	
	@RequestMapping(value = "/code", method = RequestMethod.GET) 
    public void createCode(HttpServletRequest reqeust,  
            HttpServletResponse response) throws IOException {  
		 // 设置响应的类型格式为图片格式  
        response.setContentType("image/jpeg");  
        // 禁止图像缓存。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0); 
        SCaptcha instance = new SCaptcha();
        // 将验证码输入到session中，用来验证  
        reqeust.getSession().setAttribute("code", instance.getCode());  
        // 输出打web页面  
        instance.write(response.getOutputStream());  
    }
	
	@RequestMapping( value="compareYZM", method= RequestMethod.POST)
	public void compareYZM( HttpServletResponse response, HttpSession session, String yzm ){
		
		String code = (String) session.getAttribute("code");
		JSONObject result = new JSONObject();
		String msg = null;
		if( yzm.trim(). equalsIgnoreCase(code)){
			msg = "yes";
		}else{
			msg = "no";
		}
		
		result.put("msg", msg);
		
		ResponseUtil.write(response, result);
		
	}
}
