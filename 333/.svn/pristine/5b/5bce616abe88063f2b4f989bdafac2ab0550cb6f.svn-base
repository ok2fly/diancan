<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DataSource管理</title>
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
	<div style="padding:15px;">
	<form id="addForm" class="layui-form layui-form-pane">
		<div class="layui-form-item">
				<div class="layui-input-inline">
					<input id="data_source_id" name="data_source_id" class="layui-input" type="hidden">
				</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">url(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<input id="data_source_url" name="data_source_url" placeholder="请输入数据源地址"
					autocomplete="off" class="layui-input" onblur="return vDataSourceUrl()">
			</div>
			<!-- 对号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="riurl"
					style="color: green; font-weight: bolder;" hidden></i>
			</div>
			<!-- 错号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="wrurl"
					style="color: red; font-weight: bolder;" hidden>ဆ</i>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户名(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<input id="data_source_user_name" name="data_source_user_name" placeholder="请输入用户名称"
					autocomplete="off" class="layui-input" onblur="return vUserName()">
			</div>
			<!-- 对号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="riname"
					style="color: green; font-weight: bolder;" hidden></i>
			</div>
			<!-- 错号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="wrname"
					style="color: red; font-weight: bolder;" hidden>ဆ</i>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<input id="data_source_user_pwd" name="data_source_user_pwd" placeholder="请输入用户密码"
					autocomplete="off" class="layui-input" type="password" onblur="return vPass()">
			</div>
			<!-- 对号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="ripwd"
					style="color: green; font-weight: bolder;" hidden></i>
			</div>
			<!-- 错号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="wrpwd"
					style="color: red; font-weight: bolder;" hidden>ဆ</i>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">数据源状态(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
    		  	<select id="data_source_status" name="data_source_status" >
		          <option value="0">请选择</option>
					<option value="use">use</option>
					<option value="free">free</option>
		        </select>
			</div>
			<!-- 对号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="ristatus"
					style="color: green; font-weight: bolder;" hidden></i>
			</div>
			<!-- 错号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="wrstatus"
					style="color: red; font-weight: bolder;" hidden>ဆ</i>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">描述(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<textarea id="data_source_desc"  name="data_source_desc" placeholder="请输入数据源描述" class="layui-textarea"></textarea>
			</div>
		</div>
		<div style="text-align: center" class="layui-form-item">
			<button type="button" id="save" class="layui-btn" >保存</button>
		</div>
	</form>
	</div>
	<script type="text/javascript">
	
	//JavaScript代码区域
	layui.use([ 'layer', 'form' ], function() {
		var layer = layui.layer;
		var form = layui.form;
		var $ = layui.jquery;
		var flag='add';
		var dataSource = parent.editRow;
		if( dataSource !== undefined && dataSource !== null ){
			$("#data_source_id").val( dataSource.data_source_id );
			$("#data_source_url").val( dataSource.data_source_url );
			$("#data_source_user_name").val( dataSource.data_source_user_name );
			$("#data_source_user_pwd").val( dataSource.data_source_user_pwd );
			$("#data_source_desc").val( dataSource.data_source_desc );
			$("#data_source_status").val( dataSource.data_source_status );
			flag='edit';
		}
		 form.render('select');
		
				
		$('#save').click(function(){
			var url;
				if( flag === 'edit' ){
					url='${basePath}/console/updateDataSource.action';
				}else if( flag === 'add' ){
					url='${basePath}/console/addDatasource.action';
					vDataSourceUrl();
					vUserName();
					vPass();
					if(fUrl && fName && fPass ){
						if ($('#status').val() === '0') {
							layer.msg('请选择应用状态！');
							domHidden('#wrstatus','#ristatus');
							return;
						}else{
							domHidden('#ristatus','#wrstatus');
						}
					}else{
						layer.msg('请检查应用必填项，必填项有错误！');
						return;
					}
				}
				$.ajax({
					type : "post",
					url : url,
					data : $('#addForm').serialize(),//表单数据
					dataType: 'JSON',
					success : function(data) {
						//当你在iframe页面关闭自身时
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭
						parent.location.reload();
						parent.layer.msg(data.msg);
					}
				});
		});
		
	});
	
	/**
	表单验证
	*/
	var fUrl = false, fName=false,fPass = false;
	function vDataSourceUrl(){
		var url = $('#data_source_url').val();
		if( url.length === 0){
			domHidden($('#wrurl'),$('#riurl'));
			fUrl = false;
			layer.msg('数据源地址不允许为空！');
			return;
		}		
		domHidden($('#riurl'),$('#wrurl'));
		fUrl = true;
		return;
	}
	function vUserName(){
		var url = $('#data_source_user_name').val();
		if( url.length === 0){
			domHidden($('#wrname'),$('#riname'));
			fName = false;
			layer.msg('用户名不允许为空！');
			return;
		}		
		domHidden($('#riname'),$('#wrname'));
		fName = true;
		return;
	}
	function vPass(){
		var url = $('#data_source_user_pwd').val();
		if( url.length === 0){
			domHidden($('#wrpwd'),$('#ripwd'));
			fPass = false;
			layer.msg('密码不允许为空！');
			return;
		}		
		domHidden($('#ripwd'),$('#wrpwd'));
		fPass = true;
		return;
	}
	</script>
</body>
</html>