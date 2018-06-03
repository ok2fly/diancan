<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组授权管理</title>
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
<div style="padding:15px;" >
	<table class="layui-hide" lay-even id="__table"
		lay-filter="__table">
	</table>
</div>
	
	<div style="text-align: center" class="layui-form-item">
		<button type="button" id="save" class="layui-btn" >保存</button>
	</div>
	<script>
	
		
		
		//JavaScript代码区域
		layui.use([ 'table', 'layer', 'form' ], function() {
			var table = layui.table;
			var $ = layui.$;
			var form = layui.form;
			
			var pData = null,url;
			if( parent.editRow.group_id !== undefined && parent.editRow.group_id !==null ){
				
				param = { group_id : parent.editRow.group_id};
				pData = parent.editRow;
				url = '${basePath}/console/getGroupRel.action'
				sUrl ='${basePath}/console/groupRel.action'; 
			}else{
				param = pData = { user_id:parent.editRow.user_id };
				url = '${basePath}/console/getGroupUser.action';
				sUrl ='${basePath}/console/userGroup.action'; 
			}
			
			//方法级渲染
			table.render({
				elem : '#__table',
				url : url,
				where: pData,
				cols : [ [ {
					checkbox: true
					, fixed: true
				},{
					type : 'numbers',
					title : '序号',
					width : '80'
				}, {
					field : 'group_name',
					title : '组名',
					align : 'center',
					width : '60%'
				} ] ],
				page : true,
				height: 'full-100',
				done: function (res, curr, count) {
					currChecked = new Array (table.checkStatus('__table').data);
					if( parent.editRow.group_id !== undefined && parent.editRow.group_id !==null  ){
						var data = res.data;
						var groupid = parent.editRow.group_id;
	                    var allck = false;
	                    if (!allck) {
	                        $(".layui-table-header").find("input[name = 'layTableCheckbox'][lay-filter='layTableAllChoose']").each(function () {
	                            $(this).attr("disabled", 'disabled').next().removeClass("layui-form-checked");
	                            form.render('checkbox');
	                        });
	                    }
	                    var i = 0;
	                    $(".layui-table-body.layui-table-main").find("input[name='layTableCheckbox']").each(function () {
	                        if (data[i].DISABLED) {//关键点如果当前行数据中score包含57那么就不可选
	                            $(this).attr("disabled", 'disabled').removeAttr("checked");
	                            form.render('checkbox');
	                        }
	                        if(groupid == data[i].group_id)
	                        {
	                            $(this).attr("disabled", 'disabled').removeAttr("checked");
	                            form.render('checkbox');
	                        }
	                        i++;
	                    });
	                    i = 0;
	                    $(".layui-table-fixed.layui-table-fixed-l").find(".layui-table-body").find("input[name='layTableCheckbox']").each(function () {
	                    	if (data[i].DISABLED) {//关键点如果当前行数据中score包含57那么就不可选
	                            $(this).attr("disabled", 'disabled').removeAttr("checked");
	                            form.render('checkbox');
	                        }
	                    	 if(groupid == data[i].group_id)
		                        {
		                            $(this).attr("disabled", 'disabled').removeAttr("checked");
		                            form.render('checkbox');
		                        }
	                        i++;
	                    });
					}
                    
                }
			});
			
			
			$("#save").click(function(){
				var checkStatus = table.checkStatus('__table').data;
				param.groupids =[];
				checkStatus.forEach(function( group ){
					param.groupids.push( group.group_id )
				});
				
				
				$.post(sUrl,
						{param:JSON.stringify([param])},
						function( msg ){
							//当你在iframe页面关闭自身时
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭
							parent.layer.msg(JSON.parse(msg).msg );
						});
				
				editRow = null;
			});
		}); 
	</script>

</body>
</html>