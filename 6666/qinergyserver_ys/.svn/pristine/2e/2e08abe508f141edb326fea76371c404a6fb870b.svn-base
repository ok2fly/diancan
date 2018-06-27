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
<title>物资出入库</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${ass_num}" id="ass_num" name="ass_num">
	<input type="hidden" value="${user.id}" id="mod_use_id" name="mod_use_id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
			<tr>
				<th>资产名称</th>
				<td><input type="text" id="ass_nam" placeholder="请输入资产名称"  class="popinput quinputcol" readonly="readonly"></td>
				<th>入库数量</th>
				<td><input type="text" id="cou" placeholder="请输入入库数量" class="popinput quinputcol requiredInp" ></td>
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
<script src="<%=basePath%>js/ajaxfileupload.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	var ass_num = $("#ass_num").val();
	getDataById(ass_num);
})
function update(){
	 var  cou = $("#cou").val();
	 var  use_id = $("#mod_use_id").val();
	 var  ass_num = $("#ass_num").val();

	 var  param="bround_typ=1";
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
	 param += "&cou="+cou+"&use_id="+use_id+"&ass_num="+ass_num;
	 layer.confirm("确定保存？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"assetsInOutBround.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);  //关闭 loading
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1 ;
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

function getDataById(ass_num){
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({
		url:url+"getAssetsByAssNum.htm",
		type:"post",
		data:"ass_num="+ass_num,
		dataType:"json",
		success:function(data){
			layer.close(indexlayer);  //关闭 loading
			if(data.resultcode=="USR000"){
				var d=data.data[0];
					$("#ass_nam").val(d.ass_nam);
				
			}else{
				layer.alert(data.desc);
			}
		}
	})
}
</Script>
</body>
</html>
