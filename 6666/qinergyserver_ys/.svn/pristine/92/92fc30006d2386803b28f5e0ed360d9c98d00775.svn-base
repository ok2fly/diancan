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
<title>理论辐射量</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden" value="${user.id}" id="use_id" name="use_id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>月份</th>
			<td><select  id="month" class="popinput quinputcol requiredInp" placeholder="请选择月份" >
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				
			</select></td>
		 	<th>电站</th>
			<td><input  class="popinput quinputcol" id="pws_nam"  placeholder="电站不能为空" readonly="readonly"></td>
		</tr>
		<tr>	
			<th>理论辐射量(kWh/㎡)</th>
			<td><input type="number" id="fsb_hv"   class="popinput quinputcol requiredInp"  placeholder="请输入理论辐射量"    oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th></th>
			<td><input type="hidden" class="popinput quinputcol"  placeholder="电站不能为空" id="pws_id" readonly="readonly"></td>
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
		url:url+"getFsbHvInfById.htm",
		type:"post",
		data:"pfh_id="+id,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var htmls="";
				var d=data.data[0];
				$("#pws_id").val(d.pws_id);
		        $("#pws_nam").val(getIsNull(d.pws_nam));
		        $("#month").val(d.month);
		        $("#fsb_hv").val(getIsZero(d.fsb_hv));
		        
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
	
	
	

	var use_id=$("#use_id").val();
	var pfh_id = $("#id").val();
	
	 var param = "pfh_id="+pfh_id;
	 
	 var pws_id=$("#pws_id").val();
	 var  month = $("#month").val();
	 var  fsb_hv = $("#fsb_hv").val();
	 
	
	param += "&month="+month+"&fsb_hv="+fsb_hv+"&use_id="+use_id+"&pws_id="+pws_id;
	
	layer.confirm("确定修改？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		
		
		 
		 $.ajax({
	    	url:url+"updFsbHv.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);  //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage  = 1;
	            	window.parent.getData();
	    			layer.alert("修改成功",function(){
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
