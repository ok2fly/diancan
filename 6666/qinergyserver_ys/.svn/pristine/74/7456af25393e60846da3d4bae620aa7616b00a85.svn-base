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
		<input type="hidden" id="userId" value="${user.id}" >
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>	
			<th>一级公司</th>	
			<td><select   id="companyOne"  onchange="setCompanytwo(this.value);" placeholder="请选择一级公司"   class="popinput requiredInp">
				 <option value="qxz">-请选择-</option>
				 </select></td>
			<th>二级公司</th>
			<td><select  class="popinput quinputcol requiredInp" id="companyTwo"  placeholder="请选择二级公司"    onchange="setCompanyThree(this.value);">
			 	<option value="qxz">-请选择-</option>
			 	</select></td>
		</tr>
		<tr>	
			<th>三级公司</th>
			<td><select  class="popinput quinputcol requiredInp" id="companyThree"  placeholder="请选择三级公司"   onchange="setPws(this.value);">
			 	<option value="qxz">-请选择-</option>
			 	</select></td>
		 	<th>电站</th>
			<td><select  class="popinput quinputcol requiredInp" id="companyPws"  placeholder="请选择电站"   >
			 	<option value="qxz">-请选择-</option>
			 	</select></td>
		 </tr>
		<tr>
			<th>月份</th>
			<td><select   id="month" class="popinput requiredInp" placeholder="请选择月份" >
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
			<th>理论辐射量(kWh/㎡)</th>
			<td><input type="number" id="fsb_hv"  placeholder="请输入理论辐射量"   class="popinput quinputcol requiredInp"   oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/checkCom.js?pubVersion=201802070001"></script>
<Script>
$(function(){
	getCompanyOne();
})

function insert(){
	
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	}else{
		   		if($(this).attr("id") == "companyOne" || $(this).attr("id") == "companyTwo" || $(this).attr("id") == "companyThree" || $(this).attr("id") == "companyPws" ){
	 		 		if($(this).val() == "qxz"){
	 		 		   reFlag = true;
					   layer.alert($(this).attr("placeholder"))
					   return false;
	 		 		}
	 		 	} 
		   	}
	  		if(reFlag){
	  			return false;
	  		}
	}); 
	if(reFlag){
	   return false;
	}
	
	
	var use_id=$("#userId").val();
	 var param ="use_id="+use_id;
	
	 var pws_id = $("#companyPws").val();
	 if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "&pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
		}
	
	 var  plan_tim = $("#month").val();
	 if(!isNull(plan_tim)){
			param  += "&month="+plan_tim;
		}
	 var  fsb_hv = $("#fsb_hv").val();
	 if(!isNull(fsb_hv)){
			param  += "&fsb_hv="+fsb_hv;
		}
	 layer.confirm("确定保存？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"insFsbHv.htm",
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
