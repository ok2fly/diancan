<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>场景管理</title>
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
 .layui-table-cell{
      height: 40px;
      line-height: 40px;
    } 
</style>
</head>
<body>
	<div class="demoTable">
		<button class="layui-btn" id="addScence">添加场景</button>
		<span style="margin-left: 20"> 搜索名称：</span>
		<div class="layui-inline">
			<input class="layui-input" name="scence_name" id="search" autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload">搜索</button>
	</div>

	<table class="layui-hide" lay-even id="Scence_table"
		lay-filter="Scence_table">
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
				elem : '#Scence_table',
				url : '${basePath}/console/getScences.action',
				cols : [ [ {
					type : 'numbers',
					title : '序号',
					width : '80',
					fixed : 'left'
				}, {
					field : 'scence_id',
					title : '场景ID',
					align : 'center',
					width : '10%',
					fixed : true
				}, {
					field : 'scence_name',
					title : '场景名称',
					align : 'center',
					width : '10%'
				}, {
					field : 'scence_bref_desc',
					title : '场景简述',
					align : 'center',
					width : '10%'
				},{
					field : 'scence_desc',
					title : '场景描述',
					align : 'center',
					width : '10%'
				},{
					field : 'status',
					title : '场景状态',
					align : 'center',
					width : '10%'
				}, {
					
					field : 'version',
					title : '版本号',
					align : 'center',
					width : '10%'
				}, {
					field : 'icon',
					title : '图标',
					align : 'center',
					width : '10%',
					templet: '#imgTpl'
				}, {
					field : 'scence_url',
					title : '入口地址',
					align : 'center',
					width : '10%'
				}, {
					field : 'right',
					title : '操作',
					align : 'center',
					toolbar : '#barDemo',
					fixed : 'right'
				} ] ],
				page : true,
				height : 'full-60',
				done: function( res, page, count ){
					 $("[data-field='status']").children().each(function(){  
						 var value = $(this).text();						 
		                     if( value === '0' ){
		                    	 $(this).text("正常");
		                     }else if( value === '1' ){
		                    	 $(this).text("发布");
		                     }else if(value === '2' ){
		                    	 $(this).text("规划");
		                     }else if(value === '3' ){
		                    	 $(this).text("开发中");
		                     }else if(value === '4' ){
		                    	 $(this).text("废弃");
		                     }
		            });
					 
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
				      table.reload('Scence_table', {
				        page: {
				          curr: 1 //重新从第 1 页开始
				        }
				        ,where: {
				          //key: {
				        	  scence_name: $('#search').val()
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
			table.on('tool(Scence_table)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') {
					layer.confirm('确认是否要删除本条记录', function(index) {
						//obj.del();
						$.post('${basePath}/console/deleteScence.action', {
							id : data.id
						}, function(data) {
							layer.msg(JSON.parse(data).msg);
							active['reload'].call(this);
						});
						layer.close(index);
					});
				} else if(obj.event === 'edit'){
					editRow=obj.data;
					layer.open({
						type : 2,
						title : '编辑场景',
						area : [ '600px', '500px' ],
						scrollbar: false,//禁止浏览器滚动
						maxmin : true,
						id : 'edit',
						content : '${basePath}/console/scence/add.jsp', 
						zIndex : layer.zIndex //重点1
						,
						success : function(layero) {
							layer.setTop(layero); //重点2
						}
						, cancel: function(){ 
						    //右上角关闭回调
							editRow = null;
						  }
					});
				}
			});

			 $("#addScence").click(function() {
				layer.open({
					type : 2,
					title : '添加场景',
					area : [ '600px', '500px' ],
					maxmin : true,
					scrollbar: false,//禁止浏览器滚动
					id : 'add',
					content : '${basePath}/console/scence/add.jsp',
					zIndex : layer.zIndex, // 重点1
					success : function(layero) {
						layer.setTop(layero); // 重点2
					}, cancel: function(){ 
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