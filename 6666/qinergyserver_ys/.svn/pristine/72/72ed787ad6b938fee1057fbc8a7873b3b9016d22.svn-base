<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>故障类型管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>驳回原因</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3"   placeholder="请输入驳回原因" id="task_reject_reason"  class="poptextarea requiredInp"></textarea>
			</td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="return update()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<Script>
 
function update(){
	var id  = $("#id").val();
	var user_id = $("#user_id").val();
	var task_reject_reason = $("#task_reject_reason").val();
	var param =  "id="+id+"&user_id="+user_id ;
	if(task_reject_reason != '' && task_reject_reason != undefined){
		param += "&task_reject_reason="+task_reject_reason ;
	}else{
		layer.alert("请输入驳回原因");
		return ;
	}
	
	layer.confirm("确定审核？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"updTourTaskStaReject.htm",
	    	data : param ,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	   	    		layer.alert("审核成功");
	   	    		$(".cancle").click();
	            	window.parent.getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	});
}
</Script>
</body>
</html>
