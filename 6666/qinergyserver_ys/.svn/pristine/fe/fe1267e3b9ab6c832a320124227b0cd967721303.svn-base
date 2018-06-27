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
<title>告警类型管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="mod_use_id" name="mod_use_id">
	<input type="hidden" value="${id}" id="id" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<tr>
				<th>类型名称</th>
				<td><input type="text"  placeholder="请输入类型名称"  id="ala_nam" name="ala_nam" class="popinput quinputcol requiredInp"></td>
				<th>告警类型</th>
				<td><select    id="app_typ_id" name="app_typ_id" placeholder="请选择告警类型"   class="popinput requiredInp"></select></td>
			</tr>
			<tr>
				<th>备注</th>
				<td colspan="3">
					<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea quinputcol"></textarea>
				</td>
			</tr>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="edit();">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<Script>

$(function(){
	var id = $("#id").val();
	getDescData(id);
})

 function getDescData(id){
	$.ajax({
    	url:url+"getAlaType.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    				getApp(data.data[0].app_typ_id);
    			  $("#ala_nam").val(data.data[0].ala_nam);
    			  $("#remark").val(data.data[0].remark);

			} else {
               layer.alert(data.desc);
			}
    	}
	}) 
}

function getApp(app_typ_id){
	 $.ajax({
	    	url:url+"getAppInfo.htm",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				if(app_typ_id == d.id ){
			    					 htmls +=  "<option value='"+d.id+"' selected >"+d.typ_nam+"</option>";
			    				}else{
			    					 htmls +=  "<option value='"+d.id+"'>"+d.typ_nam+"</option>";
			    				}
		    			 }
	    			 } 
	   	    		 
	   	    	     $("#app_typ_id").html(htmls);
	    			
				} else {
	               layer.alert(data.desc);
				}
	    	}
})
}

function edit(){
	
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
	 
	var id = $("#id").val();
	var app_typ_id=$("#app_typ_id").val();
	var mod_use_id = $("#mod_use_id").val();
	var ala_nam = $("#ala_nam").val();
	var remark = $("#remark").val();
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	 $.ajax({
	    	url:url+"updateAlaType.htm",
	    	data : "id="+id+"&&app_typ_id="+app_typ_id+"&&ala_nam="+ala_nam+"&&remark="+remark,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			 layer.alert("修改知识库类型成功");
	    			 $(".cancle").click();
	    			 window.parent.getTypeData();
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
 	})
}
</Script>
</body>
</html>
