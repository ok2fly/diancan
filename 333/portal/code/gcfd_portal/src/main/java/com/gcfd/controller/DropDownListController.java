package com.gcfd.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcfd.util.DataSourceStatus;
import com.gcfd.util.DropDownListBean;
import com.gcfd.util.Method;
import com.gcfd.util.ResponseUtil;
import com.gcfd.util.Status;

import net.sf.json.JSONObject;

/**
 */
@Controller
@RequestMapping("/console")
public class DropDownListController {
    /**
     * status
     * @param response
     * @param session
     */
    @RequestMapping(value = "/DropDownList")
    public void app( HttpServletResponse response, HttpSession session ) {
    	List<DropDownListBean> listBean=Status.getInstance().getListBean();
    	JSONObject result = new JSONObject();
    	result.put("dropDown", listBean);
    	ResponseUtil.write(response, result);
    }
    /**
     * method
     * @param response
     * @param session
     */
    @RequestMapping(value = "/DropDownListMethod")
    public void apiMethod( HttpServletResponse response, HttpSession session ) {
    	List<DropDownListBean> listBean=Method.getInstance().getListBean();
    	JSONObject result = new JSONObject();
    	result.put("dropDown", listBean);
    	ResponseUtil.write(response, result);
    }
    /**
     * free use
     * @param response
     * @param session
     */
    @RequestMapping(value = "/DropDownListStatus")
    public void dataSourceStatus( HttpServletResponse response, HttpSession session ) {
    	List<DropDownListBean> listBean=DataSourceStatus.getInstance().getListBean();
    	JSONObject result = new JSONObject();
    	result.put("dropDown", listBean);
    	ResponseUtil.write(response, result);
    }
}
