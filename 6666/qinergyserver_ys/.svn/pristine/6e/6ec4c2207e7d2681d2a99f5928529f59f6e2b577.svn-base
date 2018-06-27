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
	<input type="hidden" value="${mod_use_id}" id="mod_use_id" name="mod_use_id">
	<input type="hidden" value="${id}" id="id" >
	<input type="hidden" value="${user.id}" id="crt_use_id" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>类型名称</th>
			<td><input type="text" placeholder="请输入类型名称"  id="typ_nam" name="typ_nam" class="popinput quinputcol requiredInp"></td>
			<th>类型标识</th>
			<td><input type="text" placeholder="请输入类型标识"  id="typ_ide" name="typ_ide"  class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>排序号</th>
			<td><input type="text" placeholder="请输入排序号"  id="typ_sor" name="typ_sor"  class="popinput quinputcol requiredInp"></td>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<th>备注/描述</th> 
			<td colspan="3">
				<textarea    cols="3"  rows="3"  placeholder="请输入备注"  id="remark" name="remark"   class="poptextarea"></textarea>
			</td>
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
    	url:url+"getDefectTyp.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			  $("#typ_nam").val(data.data.typ_nam);
    			  $("#typ_ide").val(data.data.typ_ide);
    			  $("#typ_sor").val(data.data.typ_sor);
    			  $("#remark").val(data.data.remark);
			} else {
               layer.alert(data.desc);
			}
    	}
	}) 
}


function edit(){
	var crt_use_id = $("#crt_use_id").val();
	var id = $("#id").val();
	var typ_nam = $("#typ_nam").val();
	var typ_ide = $("#typ_ide").val();
	var typ_sor=$("#typ_sor").val();
	var remark = $("#remark").val();
	
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
  	 layer.confirm("确定修改？",function(){
	  	var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
		    	url:url+"updDefectTyp.htm",
		    	data : "id="+id+"&typ_nam="+typ_nam+"&&remark="+remark+"&typ_ide="+typ_ide+"&typ_sor="+typ_sor+"&crt_use_id="+crt_use_id,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 window.parent.getTypeData();
		    			 layer.alert("修改类型成功",function(){
			    			 $(".cancle").click();
		    			 });
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
