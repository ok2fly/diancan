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
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<input type="hidden" value="${id}" id="id" name="id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>告警是否可见</th>
			<td>
				<select  id="is_def_sta"  placeholder="请选择告警是否可见"  class="popinput requiredInp">
					<option value="1">可见</option>
					<option value="2">不可见</option>
				</select>
			</td>
			<th></th>
			<td></td>
			
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="resetGJ()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>


$(function(){
	id = $("#id").val()
	getById(id);
})

function getById(id){
	$.ajax({
    	url:url+"getUserInfById.htm",
    	data  : "id="+id,
    	dataType:"json",
    	async:false,
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			var d= data.data[0];
    			 $("#is_def_sta").val(d.is_def_sta);
    			
			} else {
               layer.alert(data.desc);
			}
    	}
})
}

function resetGJ(){
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	}
	  		if(reFlag){
	  			return false;
	  		}
	}); 
	if(reFlag){
	   return false;
	}
	
	var id=$("#id").val();
	var isDefSta=$("#is_def_sta").val();
	
	layer.confirm("确定修改？",function(){
	 	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"updUserIsDefStaByUserId.htm",
			type:"post",
			data:"id="+id+"&isDefSta="+isDefSta,
			dataType:"json",
			success:function(data){
				 layer.close(indexlayer);
				if (data.resultcode=="USR000") {
					layer.alert("保存成功");
	            	$(".cancle").click();
	            	window.parent.getData();
				}else{
					layer.alert(data.desc);
				}
			}
		})
	})
}
</Script>
</body>
</html>
