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
	<input type="hidden" value="${ass_num}" id="ass_num" name="ass_num">
	<input type="hidden" value="${user.id}" id="use_id" name="use_id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
			<tr>
				<th>资产名称信息</th>
				<td><input type="text" id="ass_nam" class="popinput quinputcol "  readonly="readonly"></td>
				<th>告警库存</th>
				<td><input type="text" id="ala_num1" placeholder="请输入告警库存" class="popinput quinputcol requiredInp" ></td>
			</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	 var  ass_num = $("#ass_num").val();

	$.ajax({
		url:url+"getAssetsAlaCou.htm",
		type:"post",
		data:"ass_num="+ass_num,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var d=data.data;
				$("#ass_nam").val(d.ass_nam);
				$("#ala_num1").val(d.ala_num);
			}else{
				layer.alert(data.desc);
			}
		}
	})
})
function update(){
	 var  ass_num = $("#ass_num").val();
	 var  ala_num = $("#ala_num1").val();
	 if(isNull(ala_num)){
		 layer.alert("请输入告警库存")
	 }
	 var  use_id = $("#use_id").val();
	 var  param="";
	 param += "&ass_num="+ass_num+"&use_id="+use_id+"&ala_num="+ala_num,
	layer.confirm("确定修改？",function(){
		$.ajax({
	    	url:url+"setAssetsStockAlaNum.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1;
	            	window.parent.getData();
	    			layer.alert("保存成功",function(){
	    				$(".cancle").click();
	    			});
				} else {
	               layer.alert(data.desc);
				}
	    	}
		});
	 })
	
	 
}
</Script>
</body>
</html>
