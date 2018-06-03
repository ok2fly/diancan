package com.gcfd.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gcfd.model.User;
import com.gcfd.mongo.model.VisitLog;
import com.gcfd.mongo.service.VisitLogServiceImpl;
/**
 * 
 * @author LIUFEI
 * @category 记录登录登出日志
 *
 */
@Component
@Aspect
public class MongoAop {

	@Autowired
	@Qualifier("visitLogService")
	private VisitLogServiceImpl visitLogService; 
	 
//	@Before("execution(* com.gcfd.controller.UserController.**(..))")
	public void beforeVisit(JoinPoint joinpoint) {
		Signature sign = joinpoint.getSignature(); 
		 System.out.println(" 返回通知 afterReturingAdvice ... "+joinpoint.getSignature().getName());
	}
	@Around(value="execution(* com.gcfd.controller.UserController.*ogin*(..))")
	public Object  loginVisit(ProceedingJoinPoint pjd) {
		Signature sign = pjd.getSignature(); 
		 Object[] args = pjd.getArgs(); 
//		System.out.println(" 返回通知 afterReturingAdvice ... "+sign.getName()+":"+ pjd.getTarget().getClass().getName());
		VisitLog vl = new VisitLog();
		vl.setVisitPath(pjd.getTarget().getClass().getName()+"."+sign.getName());
		vl.setOperTime(null);
		 Object result = null; 
	        try { 
//	            System.out.println(" 前置通知 beforeAdvice ... "+sign.getName()); 
	             if(null != args)
	             {
	            	 for(Object obj : args)
	            	 {
	            		 if(obj instanceof User)
	            		 {
	            			 User us = (User)obj;
	            			 vl.setUserName(us.getUser_name());
	            			 vl.setOperCode("0001");
	            		 }
	            	 }
	             }
	             if(null == vl.getUserName())
	             {
	            	 HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 

	                 HttpSession session =request.getSession();  
	                 if(session.getAttribute("user") != null)
	                 {
	                	 User user = (User)session.getAttribute("user");
	                	 vl.setUserName(user.getUser_name());
            			 vl.setOperCode("0001");
	                 }
	             }
	             
	             //调用方法。。。 
	            result = pjd.proceed();
	            vl.setOperCode("0000");
	            if(null != result)
	            {
	            	if(result instanceof ModelAndView)
	            	{
	            		ModelAndView mav = (ModelAndView)result;
	            		vl.setReturnPath(mav.getViewName() );
	            	}
	            	if(result instanceof String)
	            	{
	            		vl.setReturnPath(result.toString() );
	            	}
	            }
//	            System.out.println(" 返回通知 afterReturingAdvice ... "+sign.getName()+" the result is "+result); 
	        } catch (Throwable e) { 
	            // TODO: handle exception 
	        	vl.setOperCode("0002");
//	            System.out.println(" 异常通知 afterThrowingAdvice ... "+sign.getName()+" exception is ... "+e); 
	            throw new RuntimeException(e); 
	        } finally{ 
	        	visitLogService.saveVisitLog(vl);
//	            System.out.println(" 后置通知 afterAdvice ... "+sign.getName()); 
	        } 
	         
	        return result; 
	        
	}
}
