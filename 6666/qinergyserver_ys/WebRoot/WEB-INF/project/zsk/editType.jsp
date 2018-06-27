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
<title>知识库类型修改</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="userId" name="useId">
	<input type="hidden" value="${id}" id="id" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th >知识库类型</th>
			<td ><input type="text"   id="name" placeholder="请选择知识库类型"  class="popinput quinputcol requiredInp"></td>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
		<th>备注</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入描述" id="remark"   name="remark"  class="poptextarea"></textarea>
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
    	url:url+"KnwType.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			  $("#name").val(data.data[0].knw_typ_nam);
    			  $("#remark").val(data.data[0].remark);
			} else {
               layer.alert(data.desc);
			}
    	}
	}) 
}


function edit(){
	var id = $("#id").val();
	var userId = $("#userId").val();
	var name = $("#name").val();
	var remark=$("#remark").val();
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
	layer.confirm("确定修改？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		 });
		 $.ajax({
		    	url:url+"updateKnwTypeInfo.htm",
		    	data : "id="+id+"&knw_typ_nam="+name+"&use_id="+userId+"&remark="+remark,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 window.parent.currentPage  = 1;
		    			 window.parent.getTypeData();
		    			 layer.alert("修改知识库类型成功",function(){
		    				 $(".cancle").click();
		    			 });
		    			
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
