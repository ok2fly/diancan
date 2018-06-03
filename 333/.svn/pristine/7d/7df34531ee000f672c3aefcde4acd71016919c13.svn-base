<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>API管理</title>
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
					<input id="id" name="id" class="layui-input" type="hidden">
				</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">编号(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<input id="api_id" name="api_id" placeholder="请输入api编号"
					autocomplete="off" class="layui-input" onblur="return vApiId()">
			</div>
			<!-- 对号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="riid"
					style="color: green; font-weight: bolder;" hidden></i>
			</div>
			<!-- 错号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="wrid"
					style="color: red; font-weight: bolder;" hidden>ဆ</i>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">名称(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<input id="api_name" name="api_name" placeholder="请输入名称"
					autocomplete="off" class="layui-input" onblur="return vApiName()">
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
			<label class="layui-form-label">应用状态(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
    		  	<select id="status" name="status" >
		          <option value="0">请选择</option>
		          <option value="normal">normal</option>
		          <option value="release">release</option>
		          <option value="planning">planning</option>
		          <option value="development">development</option>
		          <option value="abandoned">abandoned</option>
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
			<label class="layui-form-label">版本号(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
					<input id="version" name="version" placeholder="请输入版本号"
					autocomplete="off" class="layui-input" onblur="return vVersion()">
			</div>
			<!-- 对号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="riversion"
					style="color: green; font-weight: bolder;" hidden></i>
			</div>
			<!-- 错号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="wrversion"
					style="color: red; font-weight: bolder;" hidden>ဆ</i>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">访问令牌</label>
			<div class="layui-input-inline">
					<input id="access_token" name="access_token" placeholder="请输入访问令牌"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">访问方式</label>
			<div class="layui-input-inline">
    		  	<select id="api_access_type" name="api_access_type" >
		          <option value="0">请选择</option>
		          <option value="get">get</option>
		          <option value="post">post</option>
		        </select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">接口地址</label>
			<div class="layui-input-inline">
					<input id="api_url" name="api_url" placeholder="请输入接口地址"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">请求参数
			</label>
			<div class="layui-input-inline">
				<textarea id="api_request_parameters"  name="api_request_parameters" placeholder="请输入请求参数" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">参数说明
			</label>
			<div class="layui-input-inline">
				<textarea id="api_request_parameters_memo"  name="api_request_parameters_memo" placeholder="请输入请求参数" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">返回结果
			</label>
			<div class="layui-input-inline">
				<textarea id="api_reponse_data"  name="api_reponse_data" placeholder="请输入返回结果" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">返回结果说明
			</label>
			<div class="layui-input-inline">
				<textarea id="api_reponse_data_memo"  name="api_reponse_data_memo" placeholder="请输入返回结果说明" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">简介(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<textarea id="api_bref_desc"  name="api_bref_desc" placeholder="请输入简介" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">描述</label>
			<div class="layui-input-inline">
				<textarea id="api_desc"  name="api_desc" placeholder="请输入应用描述" class="layui-textarea"></textarea>
			</div>
		</div>
		<div style="text-align: center" class="layui-form-item">
			<button type="button" id="save" class="layui-btn" >保存</button>
		</div>
	</form>

</div>
	
	<script type="text/javascript">
	var layer, form , $;
	//JavaScript代码区域
	layui.use([ 'layer', 'form' ], function() {
		layer = layui.layer;
		form = layui.form;
		$ = layui.jquery;
		/// status
		/// method
		
		var flag='add';
		var api = parent.editRow;
		if( api !== undefined && api !== null ){
			$("#id").val( api.id );
			$("#api_id").val( api.api_id );
			$("#api_name").val( api.api_name );
			$("#status").val( api.status );
			$("#version").val( api.version );
			$("#access_token").val( api.access_token );
			$("#api_access_type").val( api.api_access_type );
			$("#api_url").val( api.api_url );
			$("#api_request_parameters").val( api.api_request_parameters );
			$("#api_request_parameters_memo").val( api.api_request_parameters_memo );
			$("#api_reponse_data").val( api.api_reponse_data );
			$("#api_reponse_data_memo").val( api.api_reponse_data_memo );
			$("#api_bref_desc").val( api.api_bref_desc );
			$("#api_desc").val( api.api_desc );
			flag='edit';
		}
		form.render('select');
		
		$('#save').click(function(){
				vApiId();
				vApiName();
				vVersion();
				var url;
				if( flag === 'edit' ){
					url='${basePath}/console/updateApi.action';
				}else if( flag === 'add' ){
					url='${basePath}/console/addApi.action';
					if(fId&&fName&&fVersion){
						if($('#status').val() === '0' ){
							parent.layer.msg('请选择应用状态！');
							domHidden('#wrstatus','#ristatus');
							return;
						}
						if($('#api_access_type').val() === '0'){
							parent.layer.msg('请选择访问方式！');
							domHidden('#wrstatus','#ristatus');
							return;
						}
					}else{
						parent.layer.msg('请检查必填项，必填项有错误！');
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
	var fId = false, fName=false,fVersion = false;
	
	function vApiId(){
		var id = $('#api_id').val();
		if( id.length === 0){
			domHidden('#wrid','#riid');
			fId = false;
			parent.layer.msg('编号不允许为空！');
			return;
		}
		/* var reg = /^[0-9]{4}$/;
		if ( !(id.match(reg)) ) {
			domHidden('#wrid','#riid');
			fId = false;
			parent.layer.msg('编号必须为4位正整数！');
			return;
		} */
		domHidden('#riid','#wrid');
		fId = true;
	}
	
	function vApiName(){
		var name=$("#api_name").val();
		if( name.length === 0){
			domHidden('#wrname','#riname');
			fName = false;
			parent.layer.msg('api名称不允许为空！');
			return;
		}
		
		var reg = /^[a-zA-Z0-9_\u4e00-\u9fa5]{2,10}$/;
		if ( !(name.match(reg)) ) {
			domHidden('#wrname','#riname');
			fName = false;
			parent.layer.msg('应用名称必须为2-10位字母、数字、下划线和汉字！');
			return;
		}
		
		fName = true;
		domHidden('#riname','#wrname');
	}
	
	function vVersion(){
		var v = $('#version').val();
		if( v.length === 0){
			fVersion= false;
			domHidden('#wrversion','#riversion');
			parent.layer.msg('版本号不允许为空！');
			return;
		}
		
		var reg=/^\d+(\.\d+){0,2}$/;
		if(!(v.match(reg))){
			fVersion= false;
			domHidden('#wrversion','#riversion');
			parent.layer.msg('版本号格式不对，例1.0.0 or 1.0！');
			return;
		}
		
		domHidden('#riversion','#wrversion');
		fVersion= true;
	}
	
	
	</script>
</body>
</html>