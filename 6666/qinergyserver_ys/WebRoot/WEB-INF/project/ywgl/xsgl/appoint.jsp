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
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>执行人</th>
			<td>
				<select class="popinput requiredInp" placeholder="请选择执行人"  id="task_execute_id">
		 			
				</select>
			</td>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="return update()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<Script>
$(function(){
	getPerson();
})

 
function getPerson(){
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
   		    				htmls += "<option value='"+d.id+"'>"+d.use_nam+"</option>";
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
	var id  = $("#id").val();
	var task_execute_id = $("#task_execute_id").val();
	if(task_execute_id != '' && task_execute_id != undefined && task_execute_id != 'qxz'){
		param += "&task_execute_id="+task_execute_id;
	}else{
		layer.alert("请选择执行人");
		return ;
	}

	var param =  "id="+id+"&task_execute_id="+task_execute_id ;
	
	layer.confirm("确定保存？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"tourTaskAppoint.htm",
	    	data : param ,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	   	    		layer.alert("指派成功");
	   	    		$(".cancle").click();
	            	window.parent.getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	});
}
</Script>
</body>
</html>
