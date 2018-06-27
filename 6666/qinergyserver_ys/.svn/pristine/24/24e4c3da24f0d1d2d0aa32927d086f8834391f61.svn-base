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
	<input type="hidden" value="${user.id}" id="userId" name="useId">
	<input type="hidden" value="${id}" id="id" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>类型名称</th>
			<td><input type="text" placeholder="请输入类型名称"  id="typ_nam" name="typ_nam" class="popinput quinputcol"></td>
			<th>类型标识</th>
			<td><input type="text" placeholder="请输入类型标识"  id="typ_ide" name="typ_ide"  class="popinput quinputcol"></td>
		</tr>
		<tr>
			<th>备注</th>
			<td><input type="text" placeholder="请输入备注"  id="remark" name="remark"  class="popinput quinputcol"></td>
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
    	url:url+"getAssetsTypById.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			  $("#typ_nam").val(data.data.typ_nam);
    			  $("#typ_ide").val(data.data.typ_ide);
    			  $("#remark").val(data.data.remark);
			} else {
               layer.alert(data.desc);
			}
    	}
	}) 
}


function edit(){
	var id = $("#id").val();
	var typ_nam = $("#typ_nam").val();
	var typ_ide = $("#typ_ide").val();
	var remark = $("#remark").val();
	 $.ajax({
	    	url:url+"updAssetsTyp.htm",
	    	data : "id="+id+"&typ_nam="+typ_nam+"&&remark="+remark+"&typ_ide="+typ_ide,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 layer.alert("修改类型成功");
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
