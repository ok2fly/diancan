<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script>
	$(function(){
		$(".tab").on("click","a",function(){
			$(".tab").find("a").removeClass("active");
			$(this).addClass("active");
		})
	}) 
</script>
</head>
<body>
	<input type="hidden" id="rol_id" value="${user.rol_id}">
	
	<div class="headtop">
		<div class="w17 fl nam" id="title">
			 
		</div>
		<div class="w80  fl tab" id="tab">
			
		</div>
	</div>
</body>
</html>