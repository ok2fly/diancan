<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
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
		<button class="layui-btn" id="addUser">添加用户</button>
		<span style="margin-left: 20"> 搜索账号：</span>
		<div class="layui-inline">
			<input class="layui-input" name="id" id="search" autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload">搜索</button>
	</div>

	<table class="layui-hide" lay-even id="User_table"
		lay-filter="User_table">
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
				elem : '#User_table',
				url : '${basePath}/console/getUsers.action',
				cols : [ [ {
					type : 'numbers',
					title : '序号',
					width : '80',
					fixed : 'left'
				}, {
					field : 'user_name',
					title : '用户名',
					align : 'center',
					width : '10%',
					fixed : true
				}, {
					field : 'user_tel',
					title : '电话号码',
					align : 'center',
					width : '15%'
				}, {
					field : 'user_email',
					title : '电子邮件',
					align : 'center',
					width : '15%'
				},{
					field : 'branch',
					title : '所属机构',
					align : 'center',
					templet: '<div>{{d.branch.branch_short_name}}</div>',
					width : '15%'
				},{
					field : 'user_status',
					title : '用户状态',
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
					 $("[data-field='user_status']").children().each(function(){  
						 var value = $(this).text();						 
		                     if( value === '0' ){
		                    	 $(this).text("正常");
		                     }else if( value === '1' ){
		                    	 $(this).text("冻结");
		                     }else if(value === '2' ){
		                    	 $(this).text("删除");
		                     }
		                    
		            });
				}
			});
			var active = {
				    reload: function(){
				      
				      //执行重载
				      table.reload('User_table', {
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
			table.on('tool(User_table)', function(obj) {
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
						area : [ '600px', '500px' ],
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
						area : [ '600px', '500px' ],
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
				}else if(obj.event === 'editpwd'){
					editRow=obj.data;
					layer.open({
						type : 2,
						title : '重置密码',
						area : [ '600px', '500px' ],
						scrollbar: false,//禁止浏览器滚动
						maxmin : true,
						id : 'edit',
						content : '${basePath}/console/user/modpwd.jsp', /* $('#addForm') */
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
					area : [ '600px', '500px' ],
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
    	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="group">组授权</a>
 		<a class="layui-btn layui-btn-mini layui-btn-xs" lay-event="edit">编辑</a>
 		<a class="layui-btn layui-btn-mini layui-btn-xs" lay-event="editpwd">重置密码</a>
    	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
</body>
</html>