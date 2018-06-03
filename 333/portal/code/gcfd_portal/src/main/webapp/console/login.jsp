<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet"
	href="${basePath}/common/layui-2.2.6/css/layui.css" media="all">
<script type="text/javascript"
	src="${basePath}/common/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${basePath}/common/layui-2.2.6/layui.js"></script>
<script type="text/javascript" src="${basePath}/common/js/verify.js"></script>
<style type="text/css" media="screen">
.center {
	position: absolute;
	padding: 30px;
	width: 350px;
	height: 310px;
	left: 40%;
	top: 30%;
	margin: -60px 0px 0px -60px;
	border: 3px solid #009688;
}
.error{
	color:red
}
</style>
</head>
<body>
	<div class="center">
		<div class="layui-form-item" style="text-align: center;">
			<h1>用户登录</h1>
			<hr>
			<p class="error">${error}</p>
		</div>
		<form id="addForm" class="layui-form layui-form-pane" method="post" action="${basePath}/console/login.action">
			<div class="layui-form-item">
				<label class="layui-form-label">用户名 </label>
				<div class="layui-input-inline">
					<input id='user_name' name="user_name" placeholder="请输入用户名"
						autocomplete="off" class="layui-input" type="text"
						onblur="return vUserName()">
				</div>
				<!-- 对号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="ri"
						style="color: green; font-weight: bolder;" hidden></i>
				</div>
				<!-- 错号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="wr"
						style="color: red; font-weight: bolder;" hidden>ဆ</i>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">输入密码 </label>
				<div class="layui-input-inline">
					<input name="user_pwd" placeholder="请输入密码" autocomplete="off"
						class="layui-input" type="password" id="user_pwd"
						onblur="return vUserPwd()">
				</div>
				<!-- 对号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="rip"
						style="color: green; font-weight: bolder;" hidden></i>
				</div>
				<!-- 错号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="wrp"
						style="color: red; font-weight: bolder;" hidden>ဆ</i>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">输入验证码(<span class="verify">*</span>)
				</label>
				<div class="layui-input-inline">
					<input name="user_yzm" placeholder="请输入验证码" autocomplete="off"
						class="layui-input" type="text" id="user_yzm"
						onblur="return vUserYzm()"> <img id="img" alt=""
						src="${basePath}/console/login/code.action" onclick="refresh()"
						style="width: 100px; height: 30px">
				</div>
				<!-- 对号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="riyzm"
						style="color: green; font-weight: bolder;" hidden></i>
				</div>
				<!-- 错号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="wryzm"
						style="color: red; font-weight: bolder;" hidden>ဆ</i>
				</div>
			</div>
			<div style="text-align: center" class="layui-form-item">
				<button type="button" id="save" class="layui-btn"  onclick="if(check())addForm.submit();">保存</button>
			</div>
		</form>
	</div>
</body>
<script>
	var layer,form,$;
	layui.use([ 'table', 'layer', 'form' ], function() {
		layer = layui.layer;
		$ = layui.jquery;
	});
	
	function refresh() {
		var url = "${basePath}/console/login/code.action?number="
				+ Math.random();
		var img = document.getElementById("img");
		img.setAttribute("src", url);
	}

	var fName = false, fPwd = false, fYzm = false;

	function vUserName() {
		var name = $("#user_name").val();
		if (name.length === 0) {
			domHidden('#wr', '#ri');
			layer.msg("请输入用户名");
			fName = false;
			return ;
		}
		domHidden('#ri', '#wr');
		fName = true;
		return ;;
	}

	function vUserPwd() {
		var pwd = $("#user_pwd").val();
		if (pwd.length === 0) {
			domHidden('#wrp', '#rip');
			layer.msg("请输入密码");
			fPwd = false;
			return ;
		}
		domHidden('#rip', '#wrp');
		fPwd = true;
		return ;
	}

	function vUserYzm() {
		var yzm = $('#user_yzm').val();
		if (yzm.length === 0) {
			domHidden('#wryzm', '#riyzm');
			layer.msg("请输入验证码");
			fYzm = false;
			return ;
		}

		//判断验证码是否正确

		$.ajax({
			type : "post",
			url : '${basePath}/console/login/compareYZM.action',
			data : {
				yzm : yzm
			},//表单数据
			dataType : 'JSON',
			success : function(data) {
				//当你在iframe页面关闭自身时
				if (data.msg === 'no') {
					domHidden('#wryzm', '#riyzm');
					refresh();
					layer.msg("验证输入错误，请重新输入");
					 fYzm = false;
					
					return ;
				} else {
					domHidden('#riyzm', '#wryzm');
					fYzm = true;
					return ;
				}
			},
			error : function(data) {
				fYzm = false;
				return ;
			}
		});
	}
	function check(){
		vUserName();
		vUserPwd();
		vUserYzm();
		if (fName && fPwd && fYzm ) {
			return true;
		}else{
			return false;
		}
	}
</script>
</body>
</html>