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
	<input type="hidden" id="time" value="${time}" >
	<input type="hidden" id="reg_fat_id" value="${reg_ide}" >
	<input type="hidden" id="use_id" value="${user.id}">
	<table cellpadding="0"  border="0" width="100%" class="poptable">
		<tr>
			<th>上级区域名称</th>
			<td><input type="text" id="reg_are"  placeholder="请选择上级区域名称" class="popinput requiredInp" readonly="readonly" ></td>
			<th>区域名称</th>
			<td><input type="text" id="reg_nam"  placeholder="请输入区域名称" class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>区域标识</th>
			<td><input type="text" id="fir_let" placeholder="请输入区域标识" class="popinput quinputcol requiredInp"></td>
			<!-- <th>区域级别</th>
			<td><input type="text" id="reg_lev" placeholder="请输入区域级别" class="popinput"></td> -->
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert()" >确定</button>
		<input class="popbut"  type="reset" value="重置" class="cz" onclick="reset()">
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript">
var parentLev=0;
$(function(){
	var reg_fat_id = $("#reg_fat_id").val();
	if(reg_fat_id == 0){
		$("#reg_are").val("中国");
	}else{
		$.ajax({
			  url:url+"getBasRegInfById.htm",
			  data: "id="+reg_fat_id,
			  dataType:"json",
			  type:"post",
			  success:function(data){
				  if(data.resultcode=="USR000"){
					   $("#reg_are").val(data.data[0].reg_nam);
					   parentLev = data.data[0].reg_lev ;
				  }else{
					  layer.alert(data.desc);
				  }
			  }
		});
	}
	
})
function insert(){
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
	var reg_fat_id = $("#reg_fat_id").val();
	var reg_nam = $("#reg_nam").val();
	var remark = $("#remark").val();
	var reg_lev =  "";
	var use_id=$("#use_id").val();
	if(reg_fat_id == 0){
		reg_lev = 1 ;
	}else{
		reg_lev =(parentLev+1);
	}
	var fir_let = $("#fir_let").val();
	var time = $("#time").val();
	layer.confirm("是否添加?",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
			  url:url+"insReg.htm",
			  data: "reg_fat_id="+reg_fat_id 
			  		+"&&reg_nam="+reg_nam
			  		+"&&fir_let="+fir_let
			  		+"&&reg_lev="+reg_lev
			  		+"&&use_id="+use_id  ,
			  dataType:"json",
			  async: false,
			  type:"post",
			  success:function(data){
				  layer.close(indexlayer); //关闭 loading 
				  if(data.resultcode=="USR000"){
					  if(time == 1){
						  window.parent.getSheng();
					  }else if(time == 2 ){
						  window.parent.getShi(window.parent.sheng);
					  }else if(time  == 3){
						  window.parent.getQu(window.parent.shi);
					  }
					  layer.alert("保存成功");
				  }else{
					  layer.alert(data.desc);
				  }
			  }
		 })
	})
		

}
function reset(){
	window.location.reload();
}
</script>
</body>
</html>
