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
			<label class="layui-form-label">场景ID(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<input id="scence_id" name="scence_id" placeholder="请输入场景ID"
					autocomplete="off" class="layui-input" onblur="return vScenceId()">
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
			<label class="layui-form-label">场景名称(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<input id="scence_name" name="scence_name" placeholder="请输入场景名称"
					autocomplete="off" class="layui-input" onblur="return vScenceName()">
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
				<select id="status" name="status">
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
			<label class="layui-form-label">场景图标</label>
			<div class="layui-input-inline">
				<div class="layui-upload">
					<button type="button" class="layui-btn" id="uploadIcon">上传图片</button>
					<img style="width: 40px; height: 40px;" class="layui-upload-img"
						id="ImgIcon" name='icon'>
					<p id="iconText"></p>
					<input id='icon' name="icon" type="hidden">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">场景地址</label>
			<div class="layui-input-inline">
				<input id="scence_url" name="scence_url" placeholder="请场景地址"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">场景简介(<span class="verify">*</span>)
			</label>
			<div class="layui-input-inline">
				<textarea id="scence_bref_desc" name="scence_bref_desc"
					placeholder="请输入场景简介" class="layui-textarea" onblur="return vBDesc()"></textarea>
			</div>
			<!-- 对号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="ribdesc"
					style="color: green; font-weight: bolder;" hidden></i>
			</div>
			<!-- 错号 -->
			<div class="layui-inline">
				<i class="layui-icon" id="wrbdes"
					style="color: red; font-weight: bolder;" hidden>ဆ</i>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">场景描述</label>
			<div class="layui-input-inline">
				<textarea id="scence_desc" name="scence_desc" placeholder="请输入场景描述"
					class="layui-textarea"></textarea>
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
							var scence = parent.editRow;
							if (scence !== undefined && scence !== null) {
								$("#id").val(scence.id);
								$("#scence_id").val(scence.scence_id);
								$("#scence_name").val(scence.scence_name);
								$("#status").val(scence.status);
								$("#version").val(scence.version);
								$("#icon").val(scence.icon);
								$('#ImgIcon').attr('src',
										"${basePath}/" + scence.icon);
								$("#scence_url").val(scence.scence_url);
								$("#scence_bref_desc").val(scence.scence_bref_desc);
								$("#scence_desc").val(scence.scence_desc);
								flag = 'edit';
							}

							form.render('select');
							//普通图片上传
							var uploadInst = upload
									.render({
										elem : '#uploadIcon',
										url : '${basePath}/console/upload.action',
										method : 'POST',
										accept : 'images',
										acceptMime : 'image/*',
										exts : 'jpg|png|gif|bmp|jpeg',
										before : function(obj) {
											//预读本地文件示例，不支持ie8
											obj.preview(function(index, file,
													result) {
												$('#ImgIcon').attr('src',
														result); //图片链接（base64）
											});
										},
										done : function(obj) {

											if (obj.msg === 'no') {
												return layer.msg('上传失败');
											} else {
												layer.msg('上传成功');
												$('#icon').val(obj.imgUrl);
												return;
											}
											//上传成功
										},
										error : function() {
											//演示失败状态，并实现重传
											var iconText = $('#iconText');
											iconText
													.html('<a class="layui-btn layui-btn-mini demo-reload">重试</a><span style="color: #FF5722;">上传失败</span>');
											iconText.find('.demo-reload').on(
													'click', function() {
														uploadInst.upload();
													});
										}
									});

							$('#save')
									.click(
											function() {
												if (flag === 'edit') {
													url = '${basePath}/console/updateScence.action';
												} else if (flag === 'add') {
													url = '${basePath}/console/addScence.action';
													if (fId && fName && fBdesc
															&& fVersion) {
														if ($('#status').val() === '0') {
															layer
																	.msg('请选择应用状态！');
															domHidden(
																	'#wrstatus',
																	'#ristatus');
															return;
														}
													} else {
														layer.msg('请检查应用必填项，必填项有错误！');
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
		var fId = false, fName = false, fBdesc = false, fVersion = false;

		function vScenceId() {
			var id = $('#scence_id').val();
			if (id.length === 0) {
				domHidden('#wrid', '#riid');
				fId = false;
				layer.msg('编号不允许为空！');
				return;
			}
			var reg = /^[0-9]{4}$/;
			if (!(id.match(reg))) {
				domHidden('#wrid', '#riid');
				fId = false;
				layer.msg('编号必须为4位正整数！');
				return;
			} 
			domHidden('#riid', '#wrid');
			fId = true;
			return;
		}

		function vScenceName() {
			var name = $("#scence_name").val();
			if (name.length === 0) {
				domHidden('#wrname', '#riname');
				fName = false;
				layer.msg('scence名称不允许为空！');
				return;
			}
			var reg = /^[a-zA-Z0-9_\u4e00-\u9fa5]{2,10}$/;
			if (!(name.match(reg))) {
				domHidden('#wrname', '#riname');
				fName = false;
				layer.msg('应用名称必须为2-10位字母、数字、下划线和汉字！');
				return;
			} 
			fName = true;
			domHidden('#riname', '#wrname');
			return;
		}

		function vVersion() {
			var v = $('#version').val();
			if (v.length === 0) {
				fVersion = false;
				domHidden('#wrversion', '#riversion');
				layer.msg('版本号不允许为空！');
				return;
			}
			var reg = /^\d+(\.\d+){0,2}$/;
			if (!(v.match(reg))) {
				fVersion = false;
				domHidden('#wrversion', '#riversion');
				layer.msg('版本号格式不对，例1.0.0 or 1.0！');
				return;
			}
			domHidden('#riversion', '#wrversion');
			fVersion = true;
			return;
		}

		function vBDesc() {
			var bdesc = $('#scence_bref_desc').val();
			if (bdesc.length === 0) {
				fBdesc = false;
				domHidden('#wrbdesc', '#ribdesc');
				layer.msg('应用简介不允许为空！');
				return;
			} 
			domHidden('#ribdesc', '#wrbdesc');
			fBdesc = true;
			return;
		}
	</script>
</body>
</html>