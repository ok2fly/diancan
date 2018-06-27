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
	<input type="hidden"   id="rol_id" value="${rol_id}" >
	<input type="hidden"   id="id" value="${id}" >
	<input type="hidden"   id="use_id" value="${user.id}" >
	<div class="editBut">
		<ul id="butUl">
		</ul>
	</div>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()" >确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script>
var rolId = "";
var id = "";
var use_id = "";
$(function(){
	 rolId = $("#rol_id").val();
	 id = $("#id").val();
	 use_id = $("#use_id").val();
	 refreshData();
})
 
//采用ul，li来实现样式
 function  refreshData(){
	$.ajax({
		url:url+"getUserRoleModuleByButtonLevl.htm",
		data :"role_id="+parseInt(rolId)+"&module_id="+id,
	    dataType:"json", 
	    type:"post",
	    success:function(data){	   
	    	if(data.resultcode == "USR000"){
	    		 var ulli=data.data;	 
	    		 var htmls="";
	    		 $(ulli).each(function(i,datas){
	    			 var checkHtmlOne = "";
	    			 if(datas.levl == 1){
	    				 checkHtmlOne="checked";
	    			 } 
	    			 htmls += ('<li><input type="checkbox" '+checkHtmlOne+' value="'+datas.id+'"  class="inputCheck">'+datas.btt_nam+'</li>');
	    		 })	  
	    		 $("#butUl").html(htmls);
	    	}else{
	    		alert(data.desc);
	    	}
	    }
	  })	
} 



//修改
function update(){
	
	var butId = "";
	$("input[type='checkbox']:checked").each(function(i){  
	    var idOne = $(this).val();
	    butId += idOne+"-";
	});
	if(butId != ""){
		butId = butId.substring(0, butId.length-1);
	}
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({
		url:url+"insertUserRoleModuleByButton.htm",
		data :"role_id="+parseInt(rolId)+"&button_ids="+butId+"&module_id="+id+"&use_id="+use_id,
	    dataType:"json", 
	    type:"post",
	    success:function(data){	   
	    	layer.close(indexlayer); //关闭 loading 
	    	if(data.resultcode == "USR000"){
	    		layer.alert("按钮权限配置成功");
	    		setTimeout(function(){
	    			$(".cancle").click();
	    		},1000)
	    		
	    	}else{
	    		alert(data.desc);
	    	}
	    }
	})
	 
}


</script>
</body>
</html>
