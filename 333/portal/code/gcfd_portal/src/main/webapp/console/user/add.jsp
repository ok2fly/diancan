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
			<div class="layui-form-item" id="div_pwd">
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
			<div class="layui-form-item" id="div_rpwd">
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
			<div class="layui-form-item">
				<label class="layui-form-label">电话号码
				</label>
				<div class="layui-input-inline">
					<input id='user_tel' name='user_tel' placeholder="请输入电话号码" autocomplete="off" 
						class="layui-input" type="text" onblur="return vTel();"tabindex="4" >
				</div>
				<!-- 对号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="tri"
						style="color: green; font-weight: bolder;" hidden></i>
				</div>
				<!-- 错号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="twr"
						style="color: red; font-weight: bolder;" hidden>ဆ</i>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">电子邮箱
				</label>
				<div class="layui-input-inline">
					<input id='user_email' name='user_email' placeholder="请输入电子邮箱" autocomplete="off" 
						class="layui-input" type="text" onblur="return vMail();"tabindex="5" >
				</div>
				<!-- 对号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="eri"
						style="color: green; font-weight: bolder;" hidden></i>
				</div>
				<!-- 错号 -->
				<div class="layui-inline">
					<i class="layui-icon" id="ewr"
						style="color: red; font-weight: bolder;" hidden>ဆ</i>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">所属机构</label>
				<div class="layui-input-inline">
					<select id="branch_id" name="branch.branch_id" tabindex="6" >
					<option value="-1">请选择</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">用户状态</label>
				<div class="layui-input-inline">
					<select id="user_status" name="user_status" tabindex="7" >
						<option value="-1">请选择</option>
						<option value="0">正常</option>
						<option value="1">冻结</option>
					</select>
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
		var flag = 'add';
		//JavaScript代码区域
		layui.use([ 'layer','jquery','form' ], function() {
			layer = layui.layer;
			$ = layui.jquery;
			var form = layui.form;
			
			/**
			*用于编辑文本框进行回显
			*/
			
			var branchid;
			$.ajax({
			    type : "post",
			    url : "${basePath}/console/getBranchs.action", //此次url改为真正需要的url
			    dataType: 'JSON',
			    success : function(data) {
			        $.each(data.data, function(index, item) {
			        	if( branchid === item.branch_id ){
			        		 $("#branch_id").append(  //此处向select中循环绑定数据
						   			 "<option value="+item.branch_id+" selected >" + item.branch_short_name+ "</option>");
			        		// $("#branch_id").attr("disabled",true);
			        		// $("#branch_id").attr("readOnly","readOnly");
			        	}else{
			        		 $("#branch_id").append(  //此处向select中循环绑定数据
						   			 "<option value="+item.branch_id+">" + item.branch_short_name+ "</option>");
			        	}
			        });
			        form.render('select');
			    }
			});
			if( parent.editRow !== undefined && parent.editRow !== null ){
				var user =  parent.editRow;
				flag = 'edit';
				$('#user_id').val( user.user_id );
				$('#user_name').val( user.user_name );
				//$("#user_name").attr("unselectable",'on'); 
				//$('#user_pwd').val( user.user_pwd );
				//$('#r_pwd').val( user.user_pwd );
				$("#div_rpwd").hide();
				$("#div_pwd").hide();
				
				
				$('#user_status').val( user.user_status );
				$('#user_tel').val( user.user_tel );
				$('#user_email').val( user.user_email );
				$("#user_name").attr("disabled",true); 
				///$("#user_email").attr("disabled",true); 
				///$("#user_tel").attr("disabled",true); 
				branchid=user.branch.branch_id;				
				editRow = null;
			}
			
			
			/**
			自定义验证规则，验证密码
			 */
			$("#submit").click(function() {
				var url;
				if( flag === 'add'){
					url ='${basePath}/console/addUser.action';
					vUserName();
					vUserPwd();
					vUserPwd2();
					vTel();
					vMail();
				}else if( flag === 'edit' ){
					url ='${basePath}/console/updateUser.action';
					///fName=fPwd=fRpwd=fTel=fMail=true;
					fName=fTel=fMail=true;
				}
				if (fName && fPwd && fRpwd && fTel && fMail) {
					$("#user_name").attr("disabled",false); 
					$("#user_email").attr("disabled",false); 
					$("#user_tel").attr("disabled",false); 
					$("#branch_id").attr("disabled",false);
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
		function vUserName(){
				var name = $('#user_name').val();
				if( name.length<=0 ){
					fName = false;
					domHidden('#wr','#ri');
					layer.msg('用户名不允许为空！');
					return;
				}
				
				//只含有数字、字母、下划线不能以下划线开头和结尾
				var reg = /^(?!_)(?!.*?_$)[a-zA-Z0-9_]{2,10}$/;
				if ( !(name.match(reg)) ) {
					domHidden('#wr','#ri');
					fName = false;
					layer.msg('用户名只能是数字、字母、下划线并且不能以下划线结尾！');
					return;
				}
				
				//如果是添加，需要验证用户名唯一性
				 if( flag === 'add' ){
					 
					 $.ajax({
						 type:'POST',
						 url:'${basePath}/console/onlyByUserName.action',
						 data:{ user_name: name },
						 dataType:'JSON',
						//验证用户名是否可用
							success : function(data) {
								if (data.msg === 'yes') {
									domHidden('#ri','#wr');
									fName = true;
								} else {
									domHidden('#wr','#ri');
									layer.msg('当前用户名已被占用! ')
									fName = false;
									return;
								}

							}
					 });
					
				}else if( flag === 'edit' ){
					domHidden('#ri','#wr');
					fName = true;
				} 
		}
		
		
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
	
		function vTel(){
			var tel = $('#user_tel').val();
			var reg = /^[1][3,4,5,7,8,9][0-9]{9}$/; 
			if ( !(tel.match(reg)) ) {
				domHidden('#twr','#tri');
				fTel = false;
				layer.msg('手机格式不正确！');
				return;
			} 
			fTel = true;
			domHidden('#tri','#twr');
		}
		function vMail(){
			var mail = $('#user_email').val();
			var reg = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
			if ( !(mail.match(reg)) ) {
				domHidden('#ewr','#eri');
				fMail = false;
				layer.msg('邮箱格式不正确！');
				return;
			}
			fMail = true;
			domHidden('#eri','#ewr');
			
		}
					
	</script>
</body>
</html>