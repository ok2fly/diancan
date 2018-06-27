<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<title>智慧能源运维管家</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath%>css/login1.css?pubVersion=201802070001" />
<script language="JavaScript"> 
	if (window != top) 
	top.location.href = location.href; 
</script> 
</head>
<body onkeydown="keyLogin(event);">
	<div class="login-body">
		<div class="login-top">
			<div class="logo">
				<div class="logoimg"></div>
				<div class="logotex">
					<span>智慧能源运维管家</span>
				</div>
			</div>
		</div>
		<div class="login-main">
			<div class="login-main-right">
				<div class="right-body">
					<h4>登录</h4>
					<div class="text">
						<div class="box">
							<div class="icon"
								style="background:url(<%=basePath%>images/icon-user.png) no-repeat;  background-position: center;">
							</div>
							<input name="username" id="txtUserName" type="text"
								placeholder="请输入账号" />
						</div>
						<div class="line"></div>
						<div class="box">
							<div class="icon"
								style="background:url(<%=basePath%>images/icon-pwd.png) no-repeat;background-position: center;">
							</div>
							<input name="password" id="txtPassWord" type="password"
								placeholder="请输入密码" />
						</div>
						<div class="line"></div>
						<div class="box">
							<div class="icon"
								style="background:url(<%=basePath%>images/icon-pwd.png) no-repeat;background-position: center;">
							</div>
							<input name="txtCode" id="txtCode" type="text"
								placeholder="请输入验证码" /> <img
								src="<%=basePath%>getVerificationCode.htm" id="yanzm"
								style="width: 80px; position: absolute; margin: 12px -70px; height: 35px;"
								onclick="this.src='<%=basePath%>getVerificationCode.htm?d='+ Math.random();" />
						</div>
					</div>
					<input class="btn" type="button" id="btnSumit" onclick="login()"
						value="登录" />
				</div>
			</div>
		</div>
	</div>
</body>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001" type="text/javascript"></script>
<script>
	$(function() {
		$(".right-body").hover(function() {
			$(this).css("opacity", "1");
		}, function() {
			$(this).css("opacity", "0.7");
		})
	})
	

	
	//执行键盘按键命令
	function keyLogin(e) {
		var keycode = 0;
		//IE浏览器
		if (CheckBrowserIsIE()) {
			keycode = e.keyCode;
		} else {
			//火狐浏览器
			keycode = e.which;
		}
		if (keycode == 13) { //回车键是13
			login();
		}
	}
	//判断访问者的浏览器是否是IE
	function CheckBrowserIsIE() {
		var result = false;
		var browser = navigator.appName;
		if (browser == "Microsoft Internet Explorer") {
			result = true;
		}
		return result;
	}
	
	
	/* $("body").keydown(function() {
	    if (event.keyCode == "13") {//keyCode=13是回车键
	        $('#btnSumit').click();
	    }
	});    */
	
	function login() {
		var txtUserName = $("#txtUserName").val();
		var txtPassWord = $("#txtPassWord").val();
		var txtCode = $("#txtCode").val();
		if ("" == txtUserName) {
			$("#yanzm").click();
			layer.alert("请输入用户名！");
			return;
		}
		if ("" == txtPassWord) {
			$("#yanzm").click();
			layer.alert("请输入密码！");
			return;
		}

		if ("" == txtCode) {
			$("#yanzm").click();
			layer.alert("请输入验证码！");
			return;
		}
		var indexlayer = layer.load(1, {
			shade : [ 0.5, '#fff' ]
		//0.1透明度的白色背景
		});

		$.ajax({
			url : url + "userLogin.htm",
			data : "loginName=" + txtUserName + "&password=" + txtPassWord + "&code=" + txtCode,
			dataType : "json",
			type : "post",
			success : function(data) {
				layer.close(indexlayer); //关闭 loading 
				if (data.resultcode == "USR000") {
					window.location.href = url + "webUserLogin.htm";
				} else {
					layer.alert(data.desc);
					$("#yanzm").click();
				}
			}
		});
	}

	
</script>
</html>
