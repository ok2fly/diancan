<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
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
<div style="padding:15px;">
	<table width="100%" align="center">
	  <tr>
	    <th>
	    APP
	    </th>
	    <th>
	    API
	    </th>
	  </tr>
	  <tr>
	    <td width="40%" align="left" valign="top">
	    <!-- <table class="layui-hide" lay-even id="table1"    lay-filter="table1">
		</table> -->
		<select style="width:120px; margin-top:13px" id="getApps" onchange="appchange(this);" name="getApps" >
			<option value="-1">请选择</option>
		</select>	
		 </td>   
		<td width="50%">
	    <table class="layui-hide"  id="table2"   lay-filter="table2">
		</table>
	    </td>
	  </tr>
	</table>
	
	
	<div style="text-align: center" class="layui-form-item">
		<button type="button" id="save" class="layui-btn">保存</button>
	</div>
</div>
	
	
	<script type="text/javascript">
	var group ;
	var table;
	//JavaScript代码区域
	layui.use([ 'table', 'layer' ], function() {
		table = layui.table;
		var $ = layui.$;
		
		 group = parent.editRow;
		$.ajax({
		    type : "post",
		    url : "${basePath}/console/getApps.action?group_id="+group.group_id, //此次url改为真正需要的url
		    dataType: 'JSON',
		    success : function(data) {
		    	var auth = data.auth;
		        $.each(data.data, function(index, item) {
		        		var name = item.app_name;
		        		for(var c=0;c< auth.length;c++)
		        			{
		        			
		        			if(auth[c].id == item.id)
		        				{
		        					name = "(已选)  " + name ;
		        				}
		        			}
		        		 $("#getApps").append(  //此处向select中循环绑定数据
					   			 "<option  value="+item.id+" >" +name+ "</option>");
		        });
		        
		       // form.render('select');
		    }
		});
		//方法级渲染
		  table.render({
			elem : '#table2',
			url : '${basePath}/console/getBackApis.action',
			where : group,
			cols : [ [ {
				checkbox: true
			}, {
				field : 'api_name',
				title : 'API名称',
				align : 'center',
				width : '100'
			} ]  ],
			//page : true,
			height: 'full-100',
			width: '50px',
		});  
		
		
				  
		
		$("#save").click(function(){
			//var checked1 = table.checkStatus('table1').data;
			/* if( checked1.length === 0){
				layer.msg("请选择APP");
				return;
			} */
			
			if($("#getApps").val() === "-1" ){
				layer.msg("请选择APP");
				return;
			}
			
			var checked2 = table.checkStatus('table2').data;
			if( checked2.length === 0){
				//layer.msg("请选择API");
				//return;
			}
			var param = { group_id: group.group_id };
			
			param.appId = $("#getApps").val();
			/* param.appIds = [];
			checked1.forEach(function( app ){
				param.appIds.push( app.id )
			}); */
			
			param.apiIds = [];
			checked2.forEach(function( api ){
				param.apiIds.push( api.id )
			});
			
			
			$.post('${basePath}/console/groupAuth.action',
					{param:JSON.stringify([param])},
					function( msg ){
						//当你在iframe页面关闭自身时
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭
						parent.layer.msg(JSON.parse(msg).msg );
					});
			
		});
	}); 
	function appchange(th)
	{
		var appid = $(th).val();
		if(appid != -1)
		{
			 table.render({
					elem : '#table2',
					url : "${basePath}/console/getApisByGroupAndAPP.action?group_id="+group.group_id+"&app_id="+appid, //此次url改为真正需要的url'
					where : group,
					cols : [ [ {
						checkbox: true
					}, {
						field : 'api_name',
						title : 'API名称',
						align : 'center',
						width : '100'
					} ]  ],
					//page : true,
					height: 'full-100',
					width: '50px',
				}); 
			
			
		}
	}
	
	
	</script>
</body>
</html>