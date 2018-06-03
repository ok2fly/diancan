<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加组</title>
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
	<div id="userAdd" style="padding: 15px;">
		<form id="addForm" class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<input id="group_id" name="group_id" placeholder="请输入组名"
						autocomplete="off" class="layui-input" type="hidden">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">组名(<span class="verify">*</span>)
				</label>
				<div class="layui-input-inline">
					<input id="group_name" name="group_name" placeholder="请输入组名"
						autocomplete="off" class="layui-input">
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
			<div style="text-align: center" class="layui-form-item">
				<button type="button" id="submit" class="layui-btn" lay-submit=""
					lay-filter="submit">提交</button>
			</div>
		</form>

	</div>
	<script>
		//JavaScript代码区域
		layui.use([ 'table', 'layer', 'form' ], function() {
			var table = layui.table;
			var layer = layui.layer;
			var form = layui.form;
			var $ = layui.jquery;
			//表单验证
			var vId;
			var flag = 'add';
			var group = parent.editRow;
			if (group !== undefined && group !== null) {
				$("#group_id").val(group.group_id);
				$("#group_name").val(group.group_name);
				flag = 'edit';
			}
			/**
			自定义验证规则，验证密码
			 */
			$('#group_name').blur(function() {
				var name = $(this).val();
				if (name.length <= 0) {
					vId = false;
					$('#wr').removeAttr('hidden');
					$('#ri').attr('hidden', 'hidden');
					layer.msg('组名不允许为空！');
					return;
				} else {
					var reg = /^[a-zA-Z0-9_\u4e00-\u9fa5]{2,10}$/;
					if (!(name.match(reg))) {
						$('#wr').removeAttr('hidden');
						$('#ri').attr('hidden', 'hidden');
						vId = false;
						layer.msg('必须2-10位，且只含有汉字、数字、字母、下划线，下划线位置不限');
						return;
					} else {
						$('#ri').removeAttr('hidden');
						$('#wr').attr('hidden', 'hidden');
						vId = true;
						
						/*
						$.ajax({
							url : '${basePath}/console/onlyByGroupName.action',
							type : 'post',
							dataType : 'JSON',
							data : $('#addForm').serialize(),
							//验证用户名是否可用
							success : function(data) {
								if (data.msg === 'yes') {
									$('#ri').removeAttr('hidden');
									$('#wr').attr('hidden', 'hidden');
									vId = true;
								} else {
									$('#wr').removeAttr('hidden');
									$('#ri').attr('hidden', 'hidden');
									layer.msg('当前用户名已被占用! ')
									vId = false;
								}

							}
						});
						*/
					}
				}
			});

			$("#submit").click(function() {
				if (flag === 'edit') {
					url = '${basePath}/console/updateGroup.action';
				} else if (flag === 'add') {
					url = '${basePath}/console/addGroup.action';
					if (!vId) {
						layer.msg('输入错误，请检查表单!');
						return;
					}
				}
				$.ajax({
					type : "post",
					url : url,
					data : $('#addForm').serialize(),//表单数据
					dataType : 'JSON',
					success : function(data) {
						//当你在iframe页面关闭自身时
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭
						layer.msg(data.msg);
						parent.location.reload();
					}
				});
			});
		});
	</script>
</body>
</html>