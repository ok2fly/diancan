<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet"
	href="${basePath}/common/layui-2.2.6/css/layui.css" media="all">
<script type="text/javascript"
	src="${basePath}/common/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${basePath}/common/layui-2.2.6/layui.js"></script>
<script type="text/javascript" src="${basePath}/common/js/verify.js"></script>
<style type="text/css">
.verify {
	color: red
}
</style>
</head>
<body>
	<div style="padding:15px;"   id="userAdd">
		<form id="addForm" class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<input id='user_id' name="user_id" type="hidden">
					<!-- <input id='user_status' name="user_status" type="hidden" value="0"> -->
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">用户名(<span class="verify">*</span>)
				</label>
				<div class="layui-input-inline">
					<input id='user_name' name="user_name" placeholder="请输入用户名"
						autocomplete="off" class="layui-input" type="text" onblur="return vUserName();" tabindex="1" >
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
				<label class="layui-form-label">输入密码(<span class="verify">*</span>)
				</label>
				<div class="layui-input-inline">
					<input name="user_pwd" placeholder="请输入密码" autocomplete="off"
						class="layui-input" type="password" id="user_pwd" onblur="return vUserPwd();"tabindex="2" >
				</div>
				<!-- 对号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="pri"
						style="color: green; font-weight: bolder;" hidden></i>
				</div>
				<!-- 错号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="pwr"
						style="color: red; font-weight: bolder;" hidden>ဆ</i>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">确认密码(<span class="verify">*</span>)
				</label>
				<div class="layui-input-inline">
					<input id='r_pwd' placeholder="请输入密码" autocomplete="off"
						class="layui-input" type="password" onblur="return vUserPwd2();"tabindex="3" >
				</div>
				<!-- 对号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="rpri"
						style="color: green; font-weight: bolder;" hidden></i>
				</div>
				<!-- 错号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="rpwr"
						style="color: red; font-weight: bolder;" hidden>ဆ</i>
				</div>
			</div>
			<div style="text-align: center" class="layui-form-item">
				<button type="button" id="submit" class="layui-btn" lay-submit=""
					lay-filter="submit" >保存</button>
			</div>
		</form>

	</div>
	<script>
		var layer,$;
		//用于标记访问action
		layui.use([ 'layer','jquery','form' ], function() {
			layer = layui.layer;
			$ = layui.jquery;
			var form = layui.form;
			
			/**
			*用于编辑文本框进行回显
			*/
			if( parent.editRow !== undefined && parent.editRow !== null ){
				var user =  parent.editRow;
				flag = 'edit';
				$('#user_id').val( user.user_id );
				$('#user_name').val( user.user_name );
				$("#user_name").attr("disabled",true); 
				editRow = null;
			}
			
			
			/**
			自定义验证规则，验证密码
			 */
			$("#submit").click(function() {
				var url;
					url ='${basePath}/console/updateUserPwd.action';
					fPwd=fRpwd=true;
					 vUserPwd();
					vUserPwd2();
				if ( fPwd && fRpwd) {
					$.ajax({
						type : "post",
						url : url,
						data : $('#addForm').serialize(),//表单数据
						dataType: 'JSON',
						success : function(data) {
							//当你在iframe页面关闭自身时
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭
							layer.msg(data.msg);
							parent.editRow = null;
							parent.location.reload();
						},
						error : function( data ){
							parent.editRow = null;
						}
					}); 
				} 
			});
		});
		///验证用户名
		var fName = false, fPwd = false, fRpwd = false,fTel=false,fMail=false;
		
		
		function vUserPwd(){
			var pwd = $('#user_pwd').val();
			if( pwd.length <= 0 ){
				domHidden('#pwr','#pri');
				fPwd = false;
				layer.msg('密码不能为空！');
				return;
			}
			
			// 能匹配的组合为：数字+字母，数字+特殊字符，字母+特殊字符，
			//数字+字母+特殊字符组合，而且不能是纯数字，纯字母，纯特殊字符
			var reg = /^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{6,20}$/;
			if ( !(pwd.match(reg)) ) {
				//layer.msg('请输入合法密码');
				domHidden('#pwr','#pri');
				fPwd = false;
				layer.msg('密码必须为6-20位非纯数字、纯字母和纯特殊字符！');
				return;
			} else {
				fPwd = true;
				domHidden('#pri','#pwr');
			}
		}
		
		function vUserPwd2(){
			var rpwd = $('#r_pwd').val();
			if ($('#user_pwd').val() !== rpwd ) {
				domHidden('#rpwr','#rpri');
				fRpwd = false;
				layer.msg('两次输入密码不一致!');
				return;
			}
			fRpwd = true;
			domHidden('#rpri','#rpwr');
			
		}
	
					
	</script>
</body>
</html>