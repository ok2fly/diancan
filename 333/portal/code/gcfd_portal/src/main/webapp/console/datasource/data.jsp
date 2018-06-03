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
</head>
<body>
<div class="demoTable">
		<button class="layui-btn" id="add">添加数据源</button>
	 		<span style="margin-left:20"> 搜索数据源url：</span>
	  		<div class="layui-inline">
	   			 <input class="layui-input" name="data_source_url" id="search" autocomplete="off">
	 		</div>
	  		<button class="layui-btn" data-type="reload">搜索</button>
	</div>
		
	<table class="layui-hide" lay-even id="__table"
		lay-filter="__table">
	</table>
<script type="text/javascript">
	var editRow = null;
	//JavaScript代码区域
	layui.use([ 'table', 'layer', 'form' ], function() {
		var table = layui.table;
		var layer = layui.layer;
		var form = layui.form;
		var $ = layui.$;
		//方法级渲染
		table.render({
			elem : '#__table',
			url : '${basePath}/console/getDatasources.action',
			cols : [ [ {
				type : 'numbers',
				title : '序号',
				width : '40'
			}, {
				field : 'data_source_url',
				title : 'url',
				align : 'center',
				width : '20%'
			}, {
				field : 'data_source_user_name',
				title : '用户名',
				align : 'center',
				width : '8%'
			}, {
				field : 'data_source_user_pwd',
				title : '用户密码',
				align : 'center',
				width : '8%'
			}, {
				field : 'data_source_desc',
				title : '描述',
				align : 'center',
				width : '20%',
			}, {
				field : 'data_source_status',
				title : '数据源状态',
				align : 'center',
				width : '8%'
			}, {
				field : 'right',
				title : '操作',
				align : 'center',
				toolbar : '#barDemo'
			} ] ],
			page : true,
			height : 'full-60'
		});
		var active = {
			    reload: function(){
			      
			      //执行重载
			      table.reload('__table', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			          //key: {
			        	  data_source_url: $('#search').val()
			         // }
			        }
			      });
			    }
			  };
			  
			  $('.demoTable .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });

		//监听工具条
		table.on('tool(__table)', function(obj) {
			var data = obj.data;
			if (obj.event === 'del') {
				layer.confirm('确认是否要删除本条记录', function(index) {
					obj.del();
					$.post('${basePath}/console/deleteDataSource.action', {
						data_source_id : data.data_source_id
					}, function(data) {
						layer.msg(JSON.parse(data).msg);
					});
					layer.close(index);
				});
			} else if(obj.event === 'edit'){
				editRow =data;
				layer.open({
					type : 2,
					title : '编辑数据源',
					area : [ '600px', '500px' ],
					id:'editApi',
					maxmin : true,
					content : '${basePath}/console/datasource/add.jsp',
					zIndex : layer.zIndex //重点1
					,
					success : function(layero) {
						layer.setTop(layero); //重点2
					},cancel: function(){ 
					    //右上角关闭回调
						editRow = null;
					  }
				});
			}
		});

		 $("#add").click(function() {
			layer.open({
				type : 2,
				title : '添加数据源',
				area : [ '600px', '500px' ],
				id:'addApi',
				maxmin : true,
				content : '${basePath}/console/datasource/add.jsp',
				zIndex : layer.zIndex //重点1
				,
				success : function(layero) {
					layer.setTop(layero); //重点2
				},cancel: function(){ 
				    //右上角关闭回调
					editRow = null;
				  }
			});
		}); 
	}); 
</script>

<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-mini layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>