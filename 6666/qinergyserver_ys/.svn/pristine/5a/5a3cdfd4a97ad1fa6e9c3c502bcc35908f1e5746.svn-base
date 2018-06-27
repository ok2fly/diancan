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
	<input type = "hidden" value="${user.id}"   id="useId">
	<input type = "hidden" value="${id}"  id="id">
 	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>路线名称</th>
			<td><input type="text" placeholder="请输入路线名称"  id="route_name" class="popinput quinputcol requiredInp"></td>
			<th>电站</th>
			<td><select class="popinput requiredInp" id="pws_id" ></select></td>
		</tr>
		<tr>
			<th>路线顺序</th>
			<td><input type="text" placeholder="请输入路线顺序" id="route_sort"  class="popinput quinputcol"></td>
			 
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


function getPws(){
	var userId = $("#user_id").val();
 	/* $.ajax({
	    	url:url+"getAllComNam.htm",
	    	async : false,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data.length > 0 ){
	    				 var html = "";
	    				 for(var i = 0; i< data.data.length ; i++){
	    					 var org = data.data[i];
   								html += "<option value="+org.id+" selected >"+org.com_nam+"</option>"
		    			 } 
    						 
   						 $("#com_id").html(html); 
	    			 }
				} else {
	               layer.alert(data.desc);
				}
	    	}
    }) */
}

function getById(id){
	 $.ajax({
	    	url:url+"getRouteById.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	async:false,
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			var d = data.data[0];
	    			 $("#pws_id").val(d.pws_id);
	    			 $("#route_name").val(d.route_name);
	    			 $("#route_sort").val(d.route_sort);
	    			 getPws(d.pws_id);
				} else {
	               layer.alert(data.desc);
				}
	    	}
	 })
}
 
function update(){
	
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	} 
	  		if(reFlag){
	  			return false;
	  		}
	}); 
	if(reFlag){
	   return false;
	}
	
	
	
	 var  id = $("#id").val();
	 var  user_id = parseInt($("#user_id").val());
	 var  route_name = $("#route_name").val();
	 var  pws_id = $("#pws_id").val();
	 var  route_sort = $("#route_sort").val();
	 
	 layer.confirm("确定保存？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		 });
		 
		 $.ajax({
	    	url:url+"updRoute.htm",
	    	data:"id="+id+"&use_id="+user_id+"&route_name="+route_name+"&pws_id="+pws_id+"&route_sort="+route_sort,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			layer.alert("保存成功");
	            	$(".cancle").click();
	            	window.parent.getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
		});
	 })
	
	 
}
</Script>
</body>
</html>
