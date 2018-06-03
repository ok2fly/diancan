<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组管理</title>
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
	<div class="demoTable"  >
		<button class="layui-btn" id="add">添加组</button>
	 		<span style="margin-left:20"> 搜索组名：</span>
	  		<div class="layui-inline">
	   			 <input class="layui-input" name="group_name" id="search" autocomplete="off">
	 		</div>
	  		<button class="layui-btn" data-type="reload">搜索</button>
	</div>
		
	<table class="layui-hide" lay-even id="__table"
		lay-filter="__table">
	</table>
	<script>
		var editRow;
		//JavaScript代码区域
		layui.use([ 'table', 'layer', 'form' ], function() {
			var table = layui.table;
			var layer = layui.layer;
			var form = layui.form;
			var $ = layui.$;
			//方法级渲染
			table.render({
				elem : '#__table',
				url : '${basePath}/console/getGroups.action',
				cols : [ [ {
					type : 'numbers',
					title : '序号',
					width : '80'
				}, {
					field : 'group_name',
					title : '组名',
					align : 'center',
					width : '30%'
				}, {
					field : 'right',
					title : '操作',
					align : 'center',
					toolbar : '#barDemo',
					width : '60%'
				} ] ],
				page : true,
				height : 'full-60',
				width: 900
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
				        	  group_name: $('#search').val()
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
						$.post('${basePath}/console/deleteGroup.action', {
							group_id : data.group_id
						}, function(data) {
							layer.msg(JSON.parse(data).msg);
						});
						layer.close(index);
					});
				} else if (obj.event === 'group') {
					editRow = data;
					layer.open({
						type : 2,
						title : '组授权',
						area : [ '600px', '500px' ],
						id: 'edit',
						maxmin : true,
						content : '${basePath}/console/user/group.jsp',
						zIndex : layer.zIndex //重点1
						,
						success : function(layero) {
							layer.setTop(layero); //重点2
						}
					});
					
					
				}else if(obj.event === 'edit'){
					editRow = data;
					layer.open({
						type : 2,
						title : '编辑组',
						area : [ '600px', '500px' ],
						id: 'edit',
						maxmin : true,
						content : '${basePath}/console/group/add.jsp',
						zIndex : layer.zIndex //重点1
						,
						success : function(layero) {
							layer.setTop(layero); //重点2
						},cancel: function(){ 
						    //右上角关闭回调
							editRow = null;
						  }
					});
				}else if(obj.event === 'auth' ){
					
					editRow = data;
					layer.open({
						type : 2,
						title : '权限',
						area : [ '600px', '500px' ],
						id: 'auth',
						maxmin : true,
						content : '${basePath}/console/group/auth.jsp',
						zIndex : layer.zIndex ,
						success : function(layero) {
							layer.setTop(layero); 
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
					title : '添加组',
					area : [ '500px', '200px' ],
					id : 'addadd',
					maxmin : true,
					content : '${basePath}/console/group/add.jsp',
					zIndex : layer.zIndex //重点1
					,
					success : function(layero) {
						layer.setTop(layero); //重点2
					}, cancel: function(){ 
					    //右上角关闭回调
						editRow = null;
					  }
				});
			}); 
		}); 
	</script>

	<script type="text/html" id="barDemo">
    	<a class="layui-btn layui-btn-mini layui-btn-xs" lay-event="auth">权限管理</a>
    	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="group">组授权</a>
    	<a class="layui-btn layui-btn-mini layui-btn-xs" lay-event="edit">编辑</a>
    	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
</body>
<table class="layui-table" lay-even lay-filter="group_table"
	id='group_table'>
</table>
</html>