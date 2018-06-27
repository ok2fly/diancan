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
<title>发电量计划</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden" value="${user.id}" id="mod_use_id" name="mod_use_id">
	<input type="hidden" id="pws_id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>计划日期</th>
			<td><input type="text" value="" id="plan_tim" class="popinput Wdate requiredInp" onFocus="WdatePicker({dateFmt:'yyyy-MM'})"></td>
			<th>计划电量(kWh)</th>
			<td><input type="number" id="plan_power"   class="popinput quinputcol requiredInp" oninput="if(value.length>11)value=value.slice(0,11)" ></td>
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
<script type="text/javascript" src="<%=basePath%>js/checkCom.js?pubVersion=201802070001"></script>

<Script>


$(function(){
	var mod_use_id=$("#mod_use_id").val();
	var id = $("#id").val();
	getDataById(id);
	getCompanyOne();

})
function getDataById(id){
	$.ajax({
		url:url+"selPvPlanPowerById.htm",
		type:"post",
		data:"id="+id,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var htmls="";
				var d=data.data[0];
				$("#pws_id").val(d.pws_id);
		        $("#plan_tim").val(d.plan_tim);
		        $("#plan_power").val(d.plan_power);
		        
			}else{
				layer.alert(data.desc);
			}
		}
	})
}


function update(){
	
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
	
	
	var id = $("#id").val();
	 var param = "id="+id;
	 var pws_id=$("#pws_id").val();
	 var  plan_tim = $("#plan_tim").val();
	 var  plan_power = $("#plan_power").val();
	 var  mod_use_id = $("#mod_use_id").val();
	 if(plan_tim!=null){
		 plan_tim=plan_tim+"-01";
	 }
	 param += "&plan_tim="+plan_tim+"&plan_power="+plan_power+"&mod_use_id="+mod_use_id+"&pws_id="+pws_id;
	 layer.confirm("确定保存？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
	    	url:url+"insOrUpdPvPlanPower.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);  //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage  = 1;
	            	window.parent.getData();
	    			layer.alert("保存成功",function(){
	    				$(".cancle").click();
	    			});
	            	
				} else {
					layer.close(indexlayer);
	               layer.alert(data.desc);
				}
	    	}
		});
	 });
	 
}
</Script>
</body>
</html>
