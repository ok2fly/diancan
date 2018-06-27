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
<title>理论发电量</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden" value="${user.id}" id="use_id" name="use_id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>理论时间</th>
			<td><input type="text" value="" id="fsb_tim" placeholder="请输入理论时间" class="popinput Wdate requiredInp" onFocus="WdatePicker({dateFmt:'yyyy'})"></td>
		 	<th>电站</th>
			<td><input  class="popinput quinputcol" id="pws_nam"  placeholder="电站不能为空"  readonly="readonly"></td>
		</tr>
		<tr>	
			<th>理论发电量(kWh)</th>
			<td><input type="number" id="fsb_power" placeholder="请输入理论发电量"  class="popinput quinputcol requiredInp"   oninput="if(value.length>11)value=value.slice(0,11)" ></td>
			<th>理论发电量收益(元)</th>
			<td><input type="number" id="fsb_amo"  placeholder="请输入理论发电量收益" class="popinput quinputcol requiredInp"   oninput="if(value.length>11)value=value.slice(0,11)" ></td>
		</tr>
		<tr>	
			<th></th>
			<td><input type="hidden" class="popinput quinputcol " id="pws_id" placeholder="电站不能为空"  readonly="readonly"></td>
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
		url:url+"getFsbPowerInfById.htm",
		type:"post",
		data:"pfp_id="+id,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var htmls="";
				var d=data.data[0];
				$("#pws_id").val(d.pws_id);
		        $("#pws_nam").val(getIsNull(d.pws_nam));
		        $("#fsb_tim").val(getIsZero(d.fsb_tim));
		        $("#fsb_power").val(getIsZero(d.fsb_power));
		        $("#fsb_amo").val(getIsZero(d.fsb_amo));
		        
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
	var pfp_id = $("#id").val();
	 var param = "pfp_id="+pfp_id;
	 var pws_id=$("#pws_id").val();
	 var  fsb_tim = $("#fsb_tim").val();
	 var  fsb_power = $("#fsb_power").val();
	 var  fsb_amo = $("#fsb_amo").val();
	 if(fsb_tim!=null){
		 fsb_tim=fsb_tim+"-01-01";
	 }
	 param += "&fsb_tim="+fsb_tim+"&fsb_power="+fsb_power+"&fsb_amo="+fsb_amo+"&use_id="+use_id+"&pws_id="+pws_id;
	 layer.confirm("确定修改？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
	    	url:url+"updFsbPower.htm",
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
	               layer.alert(data.desc);
				}
	    	}
		});
	 })
	 
}
</Script>
</body>
</html>
