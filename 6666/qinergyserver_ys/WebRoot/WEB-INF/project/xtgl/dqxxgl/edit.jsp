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
<title>地区信息管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" id="id" value="${id}" >
	<input type="hidden" id="reg_fat_id">
	<input type="hidden" id="reg_lev">
	<input type="hidden" id="use_id" value="${user.id}">
 	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>区域名称</th>
			<td><input type="text" value="" id="reg_nam" placeholder="请输区域名称" class="popinput quinputcol requiredInp"></td>
			<th>区域标识</th>
			<td><input type="text" value="" id="fir_let" placeholder="请输入区域标识" class="popinput quinputcol requiredInp"></td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()" >确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript">
var parentLev=0;
$(function(){
		var id=$("#id").val();
		$.ajax({
			  url:url+"getBasRegInfById.htm",
			  data: "id="+id,
			  dataType:"json",
			  type:"post",
			  success:function(data){
				  if(data.resultcode=="USR000"){
					   $("#reg_nam").val(data.data[0].reg_nam);
					   $("#fir_let").val(data.data[0].fir_let);
					   $("#reg_fat_id").val(data.data[0].reg_fat_id);
					   $("#reg_lev").val(data.data[0].reg_lev);
				  }else{
					  layer.alert(data.desc);
				  }
			  }
		})
})

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
	
	layer.confirm("是否修改",function(){
		var id = $("#id").val();
		var reg_nam = $("#reg_nam").val();
		var fir_let = $("#fir_let").val();
		var reg_fat_id = $("#reg_fat_id").val();
		var reg_lev = $("#reg_lev").val();
		var use_id = $("#use_id").val();
		var time = $("#reg_lev").val();
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
			  url:url+"updReg.htm",
			  data: "reg_nam="+reg_nam 
			  		+"&&id="+id
			  		+"&&fir_let="+fir_let
			  		+"&&reg_fat_id="+reg_fat_id
			  		+"&&reg_lev="+reg_lev
			  		+"&&use_id="+use_id,
			  dataType:"json",
			  async: false,
			  type:"post",
			  success:function(data){
				  layer.close(indexlayer); //关闭 loading 
				  if(data.resultcode=="USR000"){
					  $(".cancle").click();
					  if(time == 1){
						  window.parent.getSheng();
					  }else if(time == 2 ){
						  window.parent.getShi(window.parent.sheng);
					  }else if(time  == 3){
						  window.parent.getQu(window.parent.shi);
					  }
					  window.parent.layer.msg("修改成功");
				  }else{
					  layer.alert(data.desc);
				  }
			  }
		 })
	});
	
} 


</script>
</body>
</html>
