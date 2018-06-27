<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>储能逆变器</title>
			<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
			 
	</head>
	<body class="bg-e9"  >
	
	<input type="hidden" id="app_typ_id" value="${app_typ_id}">
	<input type="hidden" id="pws_id" value="${pws_id}">
	<input type="hidden" id="typ_ide" value="${typ_ide}">
	<input type="hidden" id="goJumpType" value="${goJumpType}">
	<input type="hidden" id="id" value="${id}">
	<input type="hidden" id="equNum" value="${equNum}">
 
		 
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>


<script type="text/javascript">
	var app_typ_id= "";
	var pws_id= "";
	var typ_ide= "";
	var stat = "";
	var goJumpType = "";
	var id = "";
	var equNum = "";
 	$(function (){
 		app_typ_id=$("#app_typ_id").val();
 		pws_id=$("#pws_id").val(); 
 		typ_ide=$("#typ_ide").val();  
 		goJumpType=$("#goJumpType").val();  
 		id=$("#id").val();  
 		equNum=$("#equNum").val();  

 		//跳转页面
 		var gourl = jumpPageUrl;
 		
 		if(typ_ide == "GFNBQ"){
			 gourl += "commens/zhjk/sb/sb-gf.htm";
		 }else if(typ_ide == "CNNBQ"){
			 gourl += "commens/zhjk/sb/sb-storage.htm";
		 }else if(typ_ide == "CNDC"){
			 gourl += "commens/zhjk/sb/sb-energy.htm";
		 }else if(typ_ide == "HJJCY"){
			 gourl += "commens/zhjk/sb/environment.htm";
		 }else if(typ_ide == "DCDC"){
			 gourl += "commens/zhjk/sb/sb-dc.htm";
		 }else if(typ_ide == "BYQ"){
			 gourl += "commens/zhjk/sb/sb-transformer.htm";
		 }else if(typ_ide == "DB"){
			 gourl += "commens/zhjk/sb/sb-enwatch.htm";
		 }else if(typ_ide == "DNZLJCZZ"){
			 gourl += "commens/zhjk/sb/sb-powercheck.htm";
		 }else if(typ_ide == "HLX"){
			 gourl += "commens/zhjk/sb/sb-headerbox.htm";
		 }else if(typ_ide == "JLPDG"){
			 gourl += "commens/zhjk/sb/sb-peidiangui.htm";
		 }else if(typ_ide == "ZLPDG"){
			 gourl += "commens/zhjk/sb/sb-zlpeidiangui.htm";
		 }else if(typ_ide == "JLZZ"){
			 gourl += "commens/zhjk/sb/sb-jielie.htm";
		 }else if(typ_ide == "XLBH"){
			 gourl += "commens/zhjk/sb/sb-protect.htm";
		 }else if(typ_ide == "JLCDZ"){
			 gourl += "commens/zhjk/sb/sb-dcz.htm";
		 }else if(typ_ide == "ZLCDZ"){
			 gourl += "commens/zhjk/sb/sb-acz.htm";
		 }else if(typ_ide == "KZQ"){
			 gourl += "commens/zhjk/sb/sb-kzq.htm";
		 }else if(typ_ide == "WWXT"){
			 gourl += "commens/zhjk/sb/sb-microgrid.htm";
		 } 
 		 console.log("goJumpType=="+goJumpType);
 		 if(goJumpType !="" && goJumpType != undefined){
	 		 location.href = gourl+"?app_typ_id="+app_typ_id+"&pws_id="+pws_id+"&typ_ide="+typ_ide+"&goJumpType="+goJumpType+"&id="+id+"&equNum="+equNum;
 		 }else{
	 		 location.href = gourl+"?app_typ_id="+app_typ_id+"&pws_id="+pws_id+"&typ_ide="+typ_ide;
 		 }
 	})
 	
 	
 	 
</script>	
	
</body>
</html>