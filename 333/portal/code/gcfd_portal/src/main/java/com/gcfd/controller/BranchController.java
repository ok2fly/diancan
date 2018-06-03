package com.gcfd.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcfd.model.Branch;
import com.gcfd.model.Scence;
import com.gcfd.service.BranchService;
import com.gcfd.util.PageBean;
import com.gcfd.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/console")
public class BranchController {
	
	@Autowired
	private BranchService branchService;

	
	@RequestMapping(value="getBranchs")
	public void getBranchs(HttpServletResponse response,Integer page, Integer limit, String branch_name  ){
		List<Branch> branchs =null;
		Integer count = null;
		if( page == null && limit == null && branch_name == null){
			branchs = branchService.getBranchs(null , null );
		}else{
			PageBean pageUtil = null;
			count = branchService.getCounts();
	    	if( page != null && limit !=null){
	    		pageUtil = new PageBean(page,limit,count);
	    	}
	    	branchs = branchService.getBranchs(pageUtil , branch_name );
		}
		
		
        JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(branchs);
		if( count != null ){
			result.put("count", count );
		}else{
			result.put("count", branchs.size() );
		}
		
		result.put("code", 0 );
		result.put("msg", null );
		result.put("data", jsonArray);
		ResponseUtil.write(response, result);
		
	}
	
	@RequestMapping( value="deleteBranch" )
	public void deleteBranch( HttpServletResponse response, Long id ){
		if( id != null && id != 0){
    		JSONObject result = new JSONObject();
    		try {
    			branchService.deleteBranchById(id);;
    			result.put("msg", "成功");
    		} catch (Exception e) {
    			e.printStackTrace();
    			result.put("msg", "失败");
    		}
    		ResponseUtil.write(response, result);
    	}
	}
	
	@RequestMapping(value = "/updateBranch")
    public void updateBranch( HttpServletResponse response, Branch model) {
    	if( model != null ){
    		JSONObject result = new JSONObject();
    		try {
    			model.setIs_del("F");
    			branchService.updateBranch(model);
    			result.put("msg", "成功");
    		} catch (Exception e) {
    			e.printStackTrace();
    			result.put("msg", "失败");
    		}
    		ResponseUtil.write(response, result);
    	}
    	
    }
	
	@RequestMapping(value = "/addBranch")
    public void addBranch( HttpServletResponse response, Branch model) {
    	if( model != null ){
    		JSONObject result = new JSONObject();
    		try {
    			model.setIs_del("F");
    			branchService.addBranch(model);;
				result.put("msg", "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				result.put("msg", "添加失败");
			}
    		ResponseUtil.write(response, result);
    	}
        
    }
	
	
}
