<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录日志</title>
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
	<div class="demoTable">
		<span style="margin-left: 20"> 搜索：</span>
		<div class="layui-inline">
			<input class="layui-input" name="userName" id="search" autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload">搜索</button>
	</div>

	<table class="layui-hide" lay-even id="visitlog_table"
		lay-filter="visitlog_table">
	</table>
	<script>
	
		var editRow;
		layui.use([ 'table', 'layer', 'form' ], function() {
			var table = layui.table;
			var layer = layui.layer;
			var form = layui.form;
			var $ = layui.$;
			//方法级渲染
			table.render({
				elem : '#visitlog_table',
				url : '${basePath}/mongo/loginlog.action',
				cols : [ [ {
					field : 'userName',
					title : '用户名',
					align : 'center',
					width : '10%',
					fixed : true
				}, {
					field : 'visitPath',
					title : '实际访问路径',
					align : 'center',
					width : '25%'
				}, {
					field : 'returnPath',
					title : '返回路径',
					align : 'center',
					width : '25%'
				},{
					field : 'operTime',
					title : '访问时间',
					align : 'center',
					templet: '<div>{{d.operTime}}</div>',
					width : '20%'
				},{
					field : 'operCode',
					title : '访问结果',
					align : 'center',
					width : '20%'
				} ] ],
				page : true,
				height : 'full-60',
				done: function( res, page, count ){
					 $("[data-field='visitPath']").children().each(function(){  
						 var value = $(this).text();						 
		                     if( value === 'com.gcfd.controller.UserController.login' ){
		                    	 $(this).text("管理员登录");
		                     }else if( value === 'com.gcfd.controller.UserController.frontLogin' ){
		                    	 $(this).text("用户登录");
		                     }else if( value === 'com.gcfd.controller.UserController.loginOut' ){
		                    	 $(this).text("管理员退出");
		                     }
		                     else if( value === 'com.gcfd.controller.UserController.frontLoginout' ){
		                    	 $(this).text("用户退出");
		                     }
		                     
		                     else  {
		                    	// $(this).text("未定义");
		                     }
		                    
		            });
					 $("[data-field='operCode']").children().each(function(){  
						 var value = $(this).text();						 
		                     if( value === '0000' ){
		                    	 $(this).text("执行成功");
		                     }else if( value === '0002' ){
		                    	 $(this).text("异常");
		                     }else  {
		                    	// $(this).text("未定义");
		                     }
		                    
		            });
					  
					 $("[data-field='returnPath']").children().each(function(){  
						 var value = $(this).text();						 
		                     if( value === 'win10-ui/index' || value==='/win10-ui/index'){
		                    	 $(this).text("前台视图");
		                     }else if( value === 'console/index' ){
		                    	 $(this).text("管理员视图");
		                     }else if( value === '/console/login' ){
		                    	 $(this).text("管理员登录视图");
		                     }else if( value === '/win10-ui/login' ){
		                    	 $(this).text("用户登录视图");
		                     }else if( value === 'redirect:/console/login.jsp' ){
		                    	 $(this).text("管理员登陆视图");
		                     }else if( value === 'redirect:/win10-ui/login.jsp' ){
		                    	 $(this).text("用户登录视图");
		                     }
		                     
		                     else  {
		                    	// $(this).text("未定义");
		                     }
		                    
		            });
					 
				}
			});
			var active = {
				    reload: function(){
				      
				      //执行重载
				      table.reload('visitlog_table', {
				        page: {
				          curr: 1 //重新从第 1 页开始
				        }
				        ,where: {
				          //key: {
				        	  user_name: $('#search').val()
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
			table.on('tool(visitlog_table)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') {
					layer.confirm('确认是否要删除本条记录', function(index) {
						//obj.del();
						$.post('${basePath}/console/deleteUser.action', {
							user_id : data.user_id
						}, function(data) {
							layer.msg(JSON.parse(data).msg);
							
							active['reload'].call(this);
						});
						layer.close(index);
					});
				} else if (obj.event === 'group') {
					 editRow=obj.data;
					 layer.open({
						type : 2,
						title : '用户管理',
						area : [ '400px', '400px' ],
						maxmin : true,
						scrollbar: false,//禁止浏览器滚动
						id : 'groupid',
						content : '${basePath}/console/user/group.jsp' ,
						zIndex : layer.zIndex //重点1
						,
						success : function(layero) {
							layer.setTop(layero); //重点2
						}
					}); 
				}else if(obj.event === 'edit'){
					editRow=obj.data;
					layer.open({
						type : 2,
						title : '编辑用户',
						area : [ '400px', '400px' ],
						scrollbar: false,//禁止浏览器滚动
						maxmin : true,
						id : 'edit',
						content : '${basePath}/console/user/add.jsp', /* $('#addForm') */
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

			 $("#addUser").click(function() {
				layer.open({
					type : 2,
					title : '添加用户',
					area : [ '600px', '400px' ],
					maxmin : true,
					scrollbar: false,//禁止浏览器滚动
					id : 'add',
					content : '${basePath}/console/user/add.jsp', /* $('#addForm') */
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
    	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="group">组管理</a>
 		<a class="layui-btn layui-btn-mini layui-btn-xs" lay-event="edit">编辑</a>
    	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
</body>
</html>