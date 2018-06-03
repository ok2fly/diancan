package com.gcfd.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gcfd.model.App;
import com.gcfd.model.Group;
import com.gcfd.service.IAppService;
import com.gcfd.util.PageBean;
import com.gcfd.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 */
@Controller
@RequestMapping("/console")
public class AppController {
    @Resource
    private IAppService appService;
    
    @RequestMapping(value = "/getApps")
    public void getApp( HttpServletResponse response, Integer page, Integer limit, String app_id,String group_id ) {
    	
    	int count = appService.getCounts();
    	PageBean pageUtil = null;
    	if( page != null && limit !=null){
    		pageUtil = new PageBean(page,limit,count);
    	}
    	
    	List<App> appsauth = appService.getAppByGroupAuth(group_id );
    	
        List<App> apps = appService.getApps(pageUtil != null ? pageUtil : null, app_id != null ? app_id : null );
        JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(apps);
		
		if( app_id== null || app_id == "" ){
			result.put("count", count );
		}else{
			result.put("count", apps.size() );
		}
		result.put("auth", appsauth );
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);
        
    }
    @RequestMapping(value = "/getBackApps")
    public void getBackApps( HttpServletResponse response, Integer page, Integer limit, Group group ) {
    	
    	int count = appService.getCounts();
    	
    	PageBean pageUtil = new PageBean(page,limit,count);
    	
    	List<App> apps = appService.getApps(pageUtil, group );
    	JSONObject result = new JSONObject();
    	JSONArray jsonArray = JSONArray.fromObject(apps);
    	
    	result.put("count", count );
    	result.put("code", 0 );
    	result.put("msg", null );
    	result.put("data", jsonArray);
    	ResponseUtil.write(response, result);
    	
    }
    
    @RequestMapping(value = "/addApp")
    public void addApp( HttpServletResponse response, App model) {
    	if( model != null ){
    		JSONObject result = new JSONObject();
    		try {
				appService.addApp( model );
				result.put("msg", "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				result.put("msg", "添加失败");
			}
    		ResponseUtil.write(response, result);
    	}
        
    }
    @RequestMapping(value = "/updateApp")
    public void updateApp( HttpServletResponse response, App model) {
    	if( model != null ){
    		JSONObject result = new JSONObject();
    		try {
    			
    			appService.updateApp( model );
    			result.put("msg", "添加成功");
    		} catch (Exception e) {
    			e.printStackTrace();
    			result.put("msg", "添加失败");
    		}
    		ResponseUtil.write(response, result);
    	}
    	
    }
    @RequestMapping(value = "/deleteApp")
    public void deleteApp( HttpServletResponse response, Long id ) {
    	if( id != null && id != 0){
    		JSONObject result = new JSONObject();
    		try {
    			
//    			appService.deleteAppById( id );
    			Map<String,Long> param = new HashMap<String,Long>();
    			param.put("id",id);
    			appService.deleteAppCascadAll( param );
    			result.put("code", 0);
    			result.put("msg", "添加成功");
    		} catch (Exception e) {
    			e.printStackTrace();
    			result.put("msg", "添加失败");
    		}
    		ResponseUtil.write(response, result);
    	}
    	
    }
    
    
    
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public void upload( MultipartFile file,  HttpServletResponse response,HttpServletRequest request ){
    	JSONObject result = new JSONObject();
    	String msg = null;
    	 // 先判断文件是否为空 
        if (!file.isEmpty()) {
            // 获得原始文件名
            String fileName = file.getOriginalFilename();
            // 重命名文件
//            String newfileName = new Date().getTime() + String.valueOf(fileName);
            String[] tmpstr = fileName.split("\\.");
            String wide = "";
            if(null != tmpstr)
            	wide = tmpstr[tmpstr.length-1];
            String newfileName = new Date().getTime() + "_"+UUID.randomUUID().toString()+"."+wide;
            //获得物理路径webapp所在路径
            /**
             */
            String pathRoot = request.getSession().getServletContext().getRealPath("upload");
            // 项目下相对路径
            String path = "upload/" + newfileName;
            // 创建文件实例
            File tempFile = new File(pathRoot,newfileName);
            // 判断父级目录是否存在，不存在则创建
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdir();
            }
            // 判断文件是否存在，否则创建文件（夹）
            if (!tempFile.exists()) {
                tempFile.mkdir();
            }

            try {
                // 将接收的文件保存到指定文件中
                file.transferTo(tempFile);
                msg="yes";
    			result.put("imgUrl", path);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                msg="no";
            } catch (IOException e) {
                e.printStackTrace();
                msg="no";
            }

        }
    	result.put("msg", msg );
    	ResponseUtil.write(response, result);
    }
    
    
    
}
