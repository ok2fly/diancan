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
	<input type="hidden"  id="com_id" name="id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>当前人</th>
			<td><input type="text" placeholder="请输入姓名"  id="use_nam"   class="popinput quinputcol" readonly="readonly"></td>
			<th>转派人</th>
			<td><select type="text" placeholder="请输入账号"  id="one_check_use_id"   class="popinput quinputcol"></select></td>
		</tr>
		<tr>
			
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
var comCheckId = "";
var depCheckId = "";
var posCheckId = "";
var eduCheckId = "";
var rolCheckId = "";
var id = "";
$(function(){
	id = $("#id").val()
	getById(id);
	getPerson();
	
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
    			 $("#use_nam").val(d.use_nam);
    			 $("#com_id").val(d.com_id);
    			 
			} else {
               layer.alert(data.desc);
			}
    	}
})
}

function getPerson(){
	var com_id=$("#com_id").val();
	$.ajax({
    	url:url+"getUserNameByComId.htm",
    	dataType:"json",
    	data:"com_id="+com_id,
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
   				 if(data.data.length > 0 ){
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				htmls += "<option value='"+d.id+"'>"+d.use_nam+"</option>";
   	    			 }
       			 }else{
       					htmls +=  "<option value='qxz'>请选择转派人</option>";
       			 }
    			
   	    		$("#one_check_use_id").html(htmls); 
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
function update(){
	var com_id=$("#com_id").val();
	 var param = "";
	 var before_user_id=$("#id").val();
	var after_user_id=$("#one_check_use_id").val();
	param +="&before_user_id="+before_user_id+"&after_user_id="+after_user_id;
	
	layer.confirm("是否确认本次转派操作？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色的背景 
		});
		
		$.ajax({
	    	url:url+"moveTaskByUserId.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);  //关闭 loading 窗口 
	    		if (data.resultcode=="USR000") {
	            	window.parent.getData(com_id);
	            	layer.alert("转派成功！",function(){
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
