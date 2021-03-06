<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>APP管理</title>
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
 .layui-table-cell{
      height: 40px;
      line-height: 40px;
    } 
</style>
</head>
<body>
	<div class="demoTable">
		<button class="layui-btn" id="add">添加APP</button>
	 		<span style="margin-left:20"> 搜索应用ID：</span>
	  		<div class="layui-inline">
	   			 <input class="layui-input" name="app_name" id="search" autocomplete="off">
	 		</div>
	  		<button class="layui-btn" data-type="reload">搜索</button>
	</div>
		
	<table class="layui-hide" lay-even id="__table"
		lay-filter="__table">
	</table>
	<script>
		
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
				url : '${basePath}/console/getApps.action',
				cols : [ [ {
					type : 'numbers',
					title : '序号',
					width : '40',
					fixed : 'left'
				}, {
					field : 'app_id',
					title : '应用ID',
					align : 'center',
					width : '10%',
					fixed : true
				}, {
					field : 'app_name',
					title : '应用名称',
					align : 'center',
					width : '10%',
					fixed : true
				}, {
					field : 'app_bref_desc',
					title : '应用简述',
					align : 'center',
					width : '10%'
				}, {
					field : 'app_desc',
					title : '应用描述',
					align : 'center',
					width : '20%',
				}, {
					field : 'status',
					title : '应用状态',
					align : 'center',
					width : '8%'
				}, {
					field : 'version',
					title : '版本号',
					align : 'center',
					width : '8%'
				}, {
					field : 'icon',
					title : '应用图标',
					align : 'center',
					width : '8%',
					templet: '#imgTpl'
				}, {
					field : 'app_url',
					title : 'app入口地址',
					align : 'center',
					width : '10%'
				}, {
					field : 'right',
					title : '操作',
					align : 'center',
					toolbar : '#barDemo',
					width : '15%',
					fixed : 'right'
				} ] ],
				page : true,
				height : 'full-60',
				done: function( res, page, count ){
					 $("[data-field='icon']").children().each(function(){  
		                     if($(this).text()!=='应用图标'){
		                    	 $(this).text();
		                     }
		                    
		            })  
				}
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
				        	  app_id: $('#search').val()
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
						
						$.post('${basePath}/console/deleteApp.action', {
							id : data.id
						}, function(data) {
							if(0 == JSON.parse(data).code)
							{
								obj.del();
								layer.msg(JSON.parse(data).msg);
							}
							else
							{
								layer.msg(JSON.parse(data).msg);
							}
						});
						layer.close(index);
					});
				} else if (obj.event === 'group') {
					
				} else if(obj.event === 'edit'){
					editRow =data;
					layer.open({
						type : 2,
						title : '编辑APP',
						area : [ '600px', '500px' ],
						id:'editApp',
						maxmin : true,
						content : '${basePath}/console/app/add.jsp',
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
					title : '添加APP',
					area : [ '600px', '500px' ],
					id:'addApp',
					maxmin : true,
					content : '${basePath}/console/app/add.jsp',
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
	
	<script type="text/html" id="imgTpl">
   		 <img style="width : 40px; height : 40px" src="${basePath}\{{ d.icon }}">
	</script>
</body>
</html>