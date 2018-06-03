<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>智慧云餐厅操作系统</title>

<script type="text/javascript"
	src="${basePath}/common/layui-2.2.6/layui.js"></script>
<style>
#win10-login {
	background: url('${basePath}/img/wallpapers/login.jpg') no-repeat fixed;
	width: 100%;
	height: 100%;
	background-size: 100% 100%;
	position: fixed;
	z-index: -1;
	top: 0;
	left: 0;
}

#win10-login-box {
	width: 300px;
	overflow: hidden;
	margin: 0 auto;
}

.win10-login-box-square {
	width: 105px;
	margin: 0 auto;
	border-radius: 50%;
	background-color: darkgray;
	position: relative;
	overflow: hidden;
}

.win10-login-box-square::after {
	content: "";
	display: block;
	padding-bottom: 100%;
}

.win10-login-box-square .content {
	position: absolute;
	width: 100%;
	height: 100%;
}

input {
	width: 90%;
	display: block;
	border: 0;
	margin: 0 auto;
	line-height: 36px;
	font-size: 20px;
	padding: 0 1em;
	border-radius: 5px;
	margin-bottom: 11px;
}

.login-username, .login-password {
	width: 91%;
	font-size: 13px;
	color: #999;
}

.login-password {
	width: calc(91% - 54px);
	-webkit-border-radius: 2px 0 0 2px;
	-moz-border-radius: 2px 0 0 2px;
	border-radius: 5px 0 0 5px;
	margin: 0px;
	float: left;
}

.login-submit {
	margin: 0px;
	float: left;
	-webkit-border-radius: 0 5px 5px 0;
	-moz-border-radius: 0 5px 5px 0;
	border-radius: 0 5px 5px 0;
	background-color: #009688;
	width: 54px;
	display: inline-block;
	height: 36px;
	line-height: 36px;
	padding: 0 auto;
	color: #fff;
	white-space: nowrap;
	text-align: center;
	font-size: 14px;
	border: none;
	cursor: pointer;
	opacity: .9;
	filter: alpha(opacity = 90);
}

.error {
	color: red
}
</style>
<script type="text/javascript" src="${basePath}/common/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div id="win10-login">
		<div style="height: 10%; min-height: 120px"></div>
		<div id="win10-login-box">
			<div class="win10-login-box-square">
				<img src="${basePath}/img/avatar.jpg" class="content" />
			</div>
			<p style="font-size: 24px; color: white; text-align: center">智慧云餐厅操作系统</p>
			<p class="error">${error}</p>
			<form id="loginForm" target="_self" method="post"
				action="${basePath}/console/frontLogin.action">
				<!--用户名-->
				<input type="text" name="user_name" id='user_name' placeholder="请输入登录名"
					class="login-username" onblur="return vUserName()">
				<!--密码-->
				<input type="password" name="user_pwd" id="user_pwd" placeholder="请输入密码"
					class="login-password" onblur="return vUserPwd()">
				<!--登陆按钮-->
				<input type="button" value="登录" id="btn-login" class="login-submit" onclick="if(check())loginForm.submit();"/>
			</form>


		</div>
	</div>
<script type="text/javascript">
	var layer;
	layui.use([ 'layer'], function() {
		layer = layui.layer;
	});
	function check(){
		if( vUserName() && vUserPwd()){
			return true;
		}
		return false;
	}
	
	function vUserName(){
		var userName = $('#user_name').val();
		if( userName.length === 0 ){
			layer.msg('用户名不能为空');
			return false;
		}
		return true;
	}
	
	function vUserPwd(){
		var pwd = $('#user_pwd').val();
		if( pwd.length === 0 ){
			layer.msg('密码不能为空')
			return false;
		}
		return true;
	}

</script>
</body>
</html>