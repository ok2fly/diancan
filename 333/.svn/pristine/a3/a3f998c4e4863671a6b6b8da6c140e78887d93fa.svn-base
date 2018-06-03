<%@ page isELIgnored="false"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>古成方德控制台</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="${basePath}/common/layui-2.2.6/css/layui.css" media="all">
<script type="text/javascript"
	src="${basePath}/common/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${basePath}/common/layui-2.2.6/layui.js"></script>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo" style="font-size:18pt;color:white;font-weight:bold;">古成方德控制台</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="${basePath}/img/avatar.jpg" class="layui-nav-img">
						${user.user_id}
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="${basePath}/console/loginOut.action">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item"><a href="${basePath}/console/api/api.jsp"
						target="option">API管理</a></li>
					<li class="layui-nav-item"><a href="${basePath}/console/app/app.jsp"
						target="option">APP管理</a></li>
					<li class="layui-nav-item"><a href="${basePath}/console/scence/scence.jsp"
						target="option">场景管理</a></li>
					<li class="layui-nav-item"><a href="${basePath}/console/branch/branch.jsp"
						target="option">机构管理</a></li>
					<li class="layui-nav-item"><a href="${basePath}/console/datasource/data.jsp"
						target="option">数据源管理</a></li>
					<li class="layui-nav-item"><a href="${basePath}/console/group/group.jsp"
						target="option">组管理</a></li>
					<li class="layui-nav-item"><a href="${basePath}/console/user/user.jsp"
						target="option">用户管理</a></li>
					<li class="layui-nav-item"><a href="${basePath}/console/log/loginlog.jsp"
						target="option">登录日志</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 10px; height: 97%">
				<iframe id="option" name="option" style="overflow: visible;"
					scrolling="no" frameborder="no" width="100%" height="100%">
				</iframe>
			</div>
		</div>

		<div class="layui-footer footer footer-demo">
			<div class="layui-main">
				<!-- 
				<p>
					<a href="" target="_blank">古城方德</a>
				</p>
				 -->
			</div>
		</div>
	</div>
</body>
</html>