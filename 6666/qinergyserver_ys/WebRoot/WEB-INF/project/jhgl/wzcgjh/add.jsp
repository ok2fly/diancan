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
<title>采购计划</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="crt_use_id" name="crt_use_id">
	<input type="hidden" value="${type}" id="type">
	<input type="hidden" value="${user.com_id}" id="com_id">

	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>计划日期</th>
			<td><input type="text" value="" id="pur_tim" placeholder="请输入计划日期" class="popinput Wdate requiredInp" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"></td>
			<th>采购负责人</th>
			<td><select type="text" value="" id="plan_use_id" placeholder="请输入计划采购人" class="popinput requiredInp"></select></td>
			
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
				<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea"></textarea>
			</td>
			
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
<Script>
$(function(){
	getPerson();
})
function getPerson(){
	var com_id=$("#com_id").val();
	$.ajax({
    	url:url+"getUserNameByComId.htm",
    	dataType:"json",
    	data:"com_id="+com_id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
   				 if(data.data.length > 0 ){
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				if(type==d.id){
   	   		    				htmls += "<option value='"+d.id+"' selected>"+d.use_nam+"</option>";   		    					
   		    				}else{
   		    					
   		    				htmls += "<option value='"+d.id+"'>"+d.use_nam+"</option>";
   		    				}
   	    			 }
       			 }else{
       					htmls +=  "<option value='qxz'>计划采购人</option>";
       			 }
    			
   	    		$("#plan_use_id").html(htmls); 
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}

function insert(){
	
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
	
	var plan_use_id=$("#plan_use_id").val();
	var crt_use_id=$("#crt_use_id").val();
	 var param = "crt_use_id="+crt_use_id;
	 var  pur_tim = $("#pur_tim").val();
	 
	 var  remark = $("#remark").val();
	 
	 param += "&pur_tim="+pur_tim+"&remark="+remark+"&plan_use_id="+plan_use_id,
	 layer.confirm("确定保存？",function(){
		$.ajax({
	    	url:url+"insAssetsPurPlan.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
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
	 });
	 
}
</Script>
</body>
</html>
