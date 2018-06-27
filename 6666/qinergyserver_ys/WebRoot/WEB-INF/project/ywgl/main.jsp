<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>系统配置</title>
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/style.css?pubVersion=201802070001">
</head>

<frameset  rows="60px,*" frameborder="NO" border="0" framespacing="0">
	<frame name="tophead" src="<%=basePath%>commens/ywgl/top.htm" style="min-height: 60px;min-width: 1366px"></frame>
	<frameset cols="14%,*" frameborder="NO" border="0" framespacing="0">
		<frame name="left" src="<%=basePath%>commens/ywgl/menu.htm"></frame>
		<!-- 根据权限打开右侧页面 -->
		<frame name="right" src="<%=basePath%>commens/ywgl/xsgl/list.htm"></frame>
	</frameset>
	<noframes>
	<body>您的浏览器无法处理框架！</body>
	</noframes>
</frameset>

</html>