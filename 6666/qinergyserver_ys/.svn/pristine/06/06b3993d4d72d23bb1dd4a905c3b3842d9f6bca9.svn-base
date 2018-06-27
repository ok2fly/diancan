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
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="mod_use_id" name="mod_use_id">
	<input type="hidden" value="${id}" id="id" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th > 厂家类型名称</th>
			<td ><input type="text"   id="typ_nam" placeholder="请输入厂家类型名称" class="popinput quinputcol requiredInp"></td>
			<th > 厂家类型标识</th>
			<td ><input type="text"   id="typ_ide" placeholder="请输入厂家类型标识" class="popinput quinputcol"></td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea"></textarea>
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
    	url:url+"getAllManTypById.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			  var d = data.data[0];
    			  $("#typ_nam").val(d.typ_nam);
    			  $("#typ_ide").val(d.typ_ide);
    			  $("#remark").val(d.remark);
			} else {
               layer.alert(data.desc);
			}
    	}
	}) 
} 


function edit(){
	layer.confirm("确定修改？",function(){

		//必填项的校验 
		var reFlag = false ; 
		 $(".requiredInp").each(function(){
		  		if($(this).val().trim() == "" || $(this).val() == undefined ){
				   reFlag = true;
				   layer.alert($(this).attr("placeholder"))
				   return false;
			   	}else{
			   		if($(this).attr("id") == "pro_id" || $(this).attr("id") == "cit_id" || $(this).attr("id") == "are_id" ){
		 		 		if($(this).val() == "0"){
		 		 		   reFlag = true;
						   layer.alert($(this).attr("placeholder"))
						   return false;
		 		 		}
		 		 	} 
			   	}
		  		if(reFlag){
		  			return false;
		  		}
		 }); 
		 if(reFlag){
			   return false;
		 }
		 
		var id = $("#id").val();
		var mod_use_id = $("#mod_use_id").val();
		var typ_ide=$("#typ_ide").val();
		var typ_nam = $("#typ_nam").val();
		var remark = $("#remark").val();
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
		    	url:url+"updManTyp.htm",
		    	data : "man_typ_id="+id+"&&typ_nam="+typ_nam+"&&mod_use_id="+mod_use_id+"&&remark="+remark+"&&typ_ide="+typ_ide,
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
	})
}
</Script>
</body>
</html>
