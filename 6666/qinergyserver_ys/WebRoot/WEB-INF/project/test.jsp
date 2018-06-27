<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath%>css/style.css?pubVersion=201802070001" />
		<style>
		html{
			overflow: hidden;  
		}
		.nav_wrap{  
		    height: 400px;  
		    width: 200px;  
		    overflow: hidden;  
		    border: 1px solid #ccc;  
		    margin: 20px auto;  
		}  
		.nav_ul{  
		    height: 100%;  
		    width: 220px;  
		    overflow-y: auto;  
		    overflow-x: hidden;  
		}  
		.nav_li{  
		    border: 1px solid #ccc;  
		    margin: -1px;  
		    height: 40px;  
		    line-height: 40px;  
		    text-align: center;  
		    font-size: 12px;  
		    width: 200px;  
		}  
		.btn_wrap{  
		    text-align: center;  
		}  
		
		 
	</style>
	</head>
	<body>
		<div class= "nav_wrap">  
		    <ul class= "nav_ul">        
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		        <li class="nav_li">我是菜单1</li>  
		        <li class="nav_li">我是菜单2</li>  
		    </ul>  
		</div>  
	 </body>
