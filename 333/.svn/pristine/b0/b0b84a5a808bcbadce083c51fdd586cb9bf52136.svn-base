<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>场景添加</title>
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
			<label class="layui-form-label">机构编号(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<input id="branch_id" name="branch_id" placeholder="请输入机构编号"
					autocomplete="off" class="layui-input" onblur="return vbranchId()">
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
			<label class="layui-form-label">机构名称(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<input id="branch_name" name="branch_name" placeholder="请输入机构名称"
					autocomplete="off" class="layui-input" onblur="return vbranchName()">
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
			<label class="layui-form-label">机构缩写
			</label>
			<div class="layui-input-inline">
				<input id="branch_short_name" name="branch_short_name" placeholder="请输入机构缩写"
					autocomplete="off" class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">机构地址</label>
			<div class="layui-input-inline">
				<input id="branch_addr" name="branch_addr" placeholder="请场景地址"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">信用代码
			</label>
			<div class="layui-input-inline">
				<input id="branch_no" name="branch_no" placeholder="请输入企业信用代码"
						autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">联系人</label>
			<div class="layui-input-inline">
				<input id="branch_contacts" name="branch_contacts" placeholder="请输入企业联系人"
							autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号</label>
			<div class="layui-input-inline">
				<input id="branch_contacts_phone" name="branch_contacts_phone" placeholder="请输入手机号"
							autocomplete="off" class="layui-input"  onblur="return vTel();">
			</div>
			<!-- 对号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="pid"
					style="color: green; font-weight: bolder;" hidden></i>
			</div>
			<!-- 错号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="wpid"
					style="color: red; font-weight: bolder;" hidden>ဆ</i>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">memo</label>
			<div class="layui-input-inline">
				<textarea id="memo" name="memo"
					placeholder="请输入" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">branch_pic</label>
			<div class="layui-input-inline">
				<textarea id="branch_pic" name="branch_pic"
					placeholder="请输入" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">branch_desc</label>
			<div class="layui-input-inline">
			<textarea id="branch_desc" name="branch_desc"
					placeholder="请输入" class="layui-textarea"></textarea>
			</div>
		</div>
		<div style="text-align: center" class="layui-form-item">
			<button type="button" id="save" class="layui-btn" lay-submit=""
				lay-filter="submit">保存</button>
		</div>
	</form>
</div>
	<script type="text/javascript">
		var layer, $;

		//JavaScript代码区域
		layui
				.use(
						[ 'upload', 'layer', 'form' ],
						function() {
							layer = layui.layer;
							$ = layui.jquery;
							var form = layui.form, upload = layui.upload;

							var flag = 'add';
							var branch = parent.editRow;
							if (branch !== undefined && branch !== null) {
								$("#id").val(branch.id);
								$("#branch_id").val(branch.branch_id);
								$("#branch_name").val(branch.branch_name);
								$("#branch_short_name").val(branch.branch_short_name);
								$("#branch_addr").val(branch.branch_addr);
								$("#branch_no").val(branch.branch_no);
								$("#branch_contacts").val(branch.branch_contacts);
								$("#branch_contacts_phone").val(branch.branch_contacts_phone);
								$("#memo").val(branch.memo);
								$("#branch_pic").val(branch.branch_pic);
								$("#branch_desc").val(branch.branch_desc);
								flag = 'edit';
							}

							form.render('select');
							//普通图片上传

							$('#save')
									.click(
											function() {
												if (flag === 'edit') {
													url = '${basePath}/console/updateBranch.action';
													if (!(fId && fName && fPhone)) {
														return;
													} 
												} else if (flag === 'add') {
													url = '${basePath}/console/addBranch.action';
													if (!(fId && fName && fPhone)) {
														return;
													} 
												}
												$
														.ajax({
															type : "post",
															url : url,
															data : $('#addForm')
																	.serialize(),//表单数据
															dataType : 'JSON',
															success : function(
																	data) {
																//当你在iframe页面关闭自身时
																var index = parent.layer
																		.getFrameIndex(window.name); //先得到当前iframe层的索引
																parent.layer
																		.close(index); //再执行关闭
																layer
																		.msg(data.msg);
																parent.location
																		.reload();
															}
														});
											});

						});

		/**
		表单验证
		 */
		var fId = false, fName = false, fPhone= true;

		function vbranchId() {
			var id = $('#branch_id').val();
			if (id.length === 0) {
				domHidden('#wrid', '#riid');
				fId = false;
				layer.msg('编号不允许为空！');
				return;
			}

			/*
			var reg = /^[0-9]{4}$/;
			if (!(id.match(reg))) {
				domHidden('#wrid', '#riid');
				fId = false;
				layer.msg('编号必须为4位正整数！');
				return;
			} 
			*/
			if (!(id.length >= 1 && id.length <= 30)) {
				domHidden('#wrid', '#riid');
				fId = false;
				layer.msg('编号必须大于一个字符小于30个字符！');
				return;
			} 
			
			domHidden('#riid', '#wrid');
			fId = true;
			return;
		}

		function vbranchName() {
			var name = $("#branch_name").val();
			if (name.length === 0) {
				domHidden('#wrname', '#riname');
				fName = false;
				layer.msg('机构名称不允许为空！');
				return;
			}
			var reg = /^[a-zA-Z0-9_\u4e00-\u9fa5]{2,40}$/;
			if (!(name.match(reg))) {
				domHidden('#wrname', '#riname');
				fName = false;
				layer.msg('应用名称必须为2-40位字母、数字、下划线和汉字！');
				return;
			} 
			fName = true;
			domHidden('#riname', '#wrname');
			return;
		}
		
		function vTel(){
			if( $('#branch_contacts_phone').length !== 0){
				var tel = $('#branch_contacts_phone').val();
				var reg = /^[1][3,4,5,7,8,9][0-9]{9}$/; 
				if ( !(tel.match(reg)) ) {
					domHidden('#wpid','#pid');
					fPhone = false;
					layer.msg('手机格式不正确！');
					return;
				} 
				fPhone = true;
				domHidden('#pid','#wpid');
			}else{
				fPhone = true;
			}
		}

	</script>
</body>
</html>