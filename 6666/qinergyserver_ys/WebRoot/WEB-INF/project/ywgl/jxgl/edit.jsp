<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>故障类型管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<input type="hidden" value="${id}" id="id" name="id">
	
	<input type="hidden"   id="appoint_id" name="appoint_id">
	
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>检修路线</th>
			<td><select class="popinput requiredInp"  placeholder="请选择检修路线" id="tour_route_id"></select></td>
			<th>执行人</th>
			<td>
				<select class="popinput requiredInp"  placeholder="请选择执行人" id="task_execute_id">
		 			
				</select>
			</td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3"><input type="text" style="width:96%;" placeholder="请输入备注" id="remark"  class="popinput quinputcol"></td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	var id = $("#id").val();
	getById(id);
})

function getById(id){
	$.ajax({
    	url:url+"selOverhaulTaskById.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
   				 if(data.data.length > 0 ){
       				 var d =  data.data[0];
       				 $("#remark").val(d.remark);
       				 $("#appoint_id").val(d.appoint_id);
       				 var task_execute_id = d.task_execute_id;
       				 var tour_route_id = d.tour_route_id;
       				 getLx(tour_route_id);
       				 getPerson(task_execute_id);
       			 } 
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}

 

function getLx(id){
	var userId  = $("#user_id").val();
	var param = "id="+userId+"&type=1";
	$.ajax({
    	url:url+"getTourOrOverHaul.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
   				 if(data.data.length > 0 ){
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				if(d.id == id){
    		    				htmls += "<option value='"+d.id+"' selected>"+d.route_name+"</option>";
		    				}else{
    		    				htmls += "<option value='"+d.id+"'>"+d.route_name+"</option>";
		    				}
	    			 }
       			 }else{
       					htmls +=  "<option value='qxz'>选择路线</option>";
       			 }
    			
   	    		$("#tour_route_id").html(htmls); 
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}

function getPerson(id){
	$.ajax({
    	url:url+"selUserNameTour.htm",
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
   				 if(data.data.length > 0 ){
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				if(d.id == id){
	   		    				htmls += "<option value='"+d.id+"' selected>"+d.use_nam+"</option>";
   		    				}else{
   		    					htmls += "<option value='"+d.id+"'>"+d.use_nam+"</option>";
   		    				}
   	    			 }
       			 }else{
       					htmls +=  "<option value='qxz'>选择执行人</option>";
       			 }
    			
   	    		$("#task_execute_id").html(htmls); 
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
function update(){
	var id = $("#id").val();
	var appoint_id  = $("#appoint_id").val();
	var tour_route_id  = $("#tour_route_id").val();
	var remark  = $("#remark").val();
	var task_execute_id  = $("#task_execute_id").val();
	var param = "id="+id+"&appoint_id="+appoint_id;
	if(tour_route_id != '' && tour_route_id != undefined && task_execute_id != 'qxz'){
		param += "&tour_route_id="+tour_route_id;
	}else{
		layer.alert("请选择线路");
		return ;
	}
	
	if(task_execute_id != '' && task_execute_id != undefined && task_execute_id != 'qxz'){
		param += "&task_execute_id="+task_execute_id;
	}else{
		layer.alert("请选择执行人");
		return ;
	}
	
	if(remark != '' && remark != undefined){
		param += "&remark="+remark;
	} 
	
	layer.confirm("确定修改？",function(){
	
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"updOverhaulTaskById.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.document.getElementById("type").value=2;
	            	window.parent.getData();
	   	    		$(".cancle").click();
	   	    		window.parent.layer.alert("保存成功");
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
    })
}
</Script>
</body>
</html>
