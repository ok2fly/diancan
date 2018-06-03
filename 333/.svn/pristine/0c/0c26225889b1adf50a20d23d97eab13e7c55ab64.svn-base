<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机构管理</title>
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
		<button class="layui-btn" id="addBranch">添加机构</button>
		<span style="margin-left: 20"> 搜索名称：</span>
		<div class="layui-inline">
			<input class="layui-input" name="branch_name" id="search" autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload">搜索</button>
	</div>

	<table class="layui-hide" lay-even id="Branch_table"
		lay-filter="Branch_table">
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
				elem : '#Branch_table',
				url : '${basePath}/console/getBranchs.action',
				cols : [ [ {
					type : 'numbers',
					title : '序号',
					width : '80',
					fixed : 'left'
				}, {
					field : 'branch_id',
					title : '机构编号',
					align : 'center',
					width : '8%',
					fixed : true
				}, {
					field : 'branch_name',
					title : '机构名称',
					align : 'center',
					width : '8%'
				}, {
					field : 'branch_short_name',
					title : '机构缩写',
					align : 'center',
					width : '8%'
				},{
					field : 'branch_addr',
					title : '机构地址',
					align : 'center',
					width : '8%'
				},{
					field : 'branch_no',
					title : '组织统一社会信用代码',
					align : 'center',
					width : '8%'
				}, {
					
					field : 'branch_contacts',
					title : '联系人',
					align : 'center',
					width : '8%'
				}, {
					field : 'branch_contacts_phone',
					title : '联系电话',
					align : 'center',
					width : '8%'
				}, {
					field : 'memo',
					title : 'memo',
					align : 'center',
					width : '8%'
				}, {
					field : 'branch_pic',
					title : 'branch_pic',
					align : 'center',
					width : '8%'
				}, {
					field : 'branch_desc',
					title : '备注',
					align : 'center',
					width : '8%'
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
				}
			});
			var active = {
				    reload: function(){
				      
				      //执行重载
				      table.reload('Branch_table', {
				        page: {
				          curr: 1 //重新从第 1 页开始
				        }
				        ,where: {
				          //key: {
				        	  branch_name: $('#search').val()
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
			table.on('tool(Branch_table)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') {
					layer.confirm('确认是否要删除本条记录', function(index) {
						//obj.del();
						$.post('${basePath}/console/deleteBranch.action', {
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
						title : '编辑机构',
						area : [ '600px', '500px' ],
						scrollbar: false,//禁止浏览器滚动
						maxmin : true,
						id : 'edit',
						content : '${basePath}/console/branch/add.jsp', 
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

			 $("#addBranch").click(function() {
				layer.open({
					type : 2,
					title : '添加机构',
					area : [ '600px', '500px' ],
					maxmin : true,
					scrollbar: false,//禁止浏览器滚动
					id : 'add',
					content : '${basePath}/console/branch/add.jsp',
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
</body>
</html>