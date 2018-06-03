package com.gcfd.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcfd.model.DataSource;
import com.gcfd.service.IDataSourceService;
import com.gcfd.util.PageBean;
import com.gcfd.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 */
@Controller
@RequestMapping("/console")
public class DataSourceController {
    @Resource
    private IDataSourceService dataSourceService;
    
    @RequestMapping(value = "/getDatasources")
    public void getApis( HttpServletResponse response, HttpSession session, Integer page, Integer limit, String data_source_url ) {
    	
    	int count = dataSourceService.getCounts();
    	
    	PageBean pageUtil = new PageBean(page,limit,count);
    	
        List<DataSource> dataSources = dataSourceService.getDataSource(pageUtil, data_source_url );
        JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(dataSources);
		
		if( data_source_url== null || data_source_url == "" ){
			result.put("count", count );
		}else{
			result.put("count", dataSources.size() );
		}
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);
        
    }
    
    @RequestMapping(value = "/addDatasource")
    public void addApp( HttpServletResponse response, DataSource model) {
    	if( model != null ){
    		JSONObject result = new JSONObject();
    		try {
				dataSourceService.addDataSource( model );
				result.put("msg", "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				result.put("msg", "添加失败");
			}
    		ResponseUtil.write(response, result);
    	}
        
    }
    @RequestMapping(value = "/updateDataSource")
    public void updateApi( HttpServletResponse response, DataSource model) {
    	if( model != null ){
    		JSONObject result = new JSONObject();
    		try {
    			
    			dataSourceService.updateDataSource( model );
    			result.put("msg", "添加成功");
    		} catch (Exception e) {
    			e.printStackTrace();
    			result.put("msg", "添加失败");
    		}
    		ResponseUtil.write(response, result);
    	}
    	
    }
    @RequestMapping(value = "/deleteDataSource")
    public void deleteApi( HttpServletResponse response, Long data_source_id ) {
    	if( data_source_id != null && data_source_id != 0){
    		JSONObject result = new JSONObject();
    		try {
    			
    			dataSourceService.deleteDataSourceById( data_source_id );
    			result.put("msg", "删除成功");
    		} catch (Exception e) {
    			e.printStackTrace();
    			result.put("msg", "删除失败");
    		}
    		ResponseUtil.write(response, result);
    	}
    	
    }
        
    
}
