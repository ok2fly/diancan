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
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>一级公司</th>
			<td>
				 <select class="popinput quinputcol requiredInp" placeholder="请选择一级公司"  id="companyOne"  onchange="setCompanytwo(this.value);">
   	   			 	<option value="qxz">请选择一级公司</option>
   	   			 </select>
			</td>
			<th>二级公司</th>
			<td>
				 <select class="popinput quinputcol requiredInp"  placeholder="请选择二级公司"  id="companyTwo" onchange="setCompanyThree(this.value);">
   	   			 	<option value="qxz">请选择二级公司</option>
   	   			 </select>
			</td>
		</tr>
		<tr>
			<th>三级公司</th>
			<td>
				 <select class="popinput quinputcol requiredInp"  placeholder="请选择三级公司"  id="companyThree"   onchange="setPws(this.value);">
   	   			 	<option value="qxz">请选择三级公司</option>
   	   			 </select>
			</td>
			<th>电站</th>
			<td>
				<select class="popinput quinputcol requiredInp"  id="companyPws" placeholder="请选择电站"     onchange="setTypeIde(this.value);" >
   	   			 	<option value="qxz">请选择电站</option>
   	   			 </select>
			</td>
		</tr>
		<tr>
			<th>设备类型</th>
			<td>
				<select class="popinput quinputcol requiredInp"  id="typeIde"  placeholder="请选择设备类型"    onchange="setTypeEquNum(this.value);" >
   	   			 	<option value="qxz">请选择设备类型</option>
   	   			 </select>
			</td>
			<th>设备编号</th>
			<td>
				<select class="popinput quinputcol requiredInp" id="equ_num"  placeholder="请选择设备编号" >
		 			<option value="qxz">请选择设备编号</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>维修人员</th>
			<td>
				<select class="popinput requiredInp" id="repair_use_id" placeholder="请选择维修人员">
		 			
				</select>
			</td>
			<th>是否更换</th>
			<td>
				<select class="popinput requiredInp" id="if_change"  placeholder="请选择是否更换">
					<option value="0"  >否</option>
					<option value="1"  >是</option>
				</select></td>
		</tr>
		<tr>
			<th>报修原因</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入报修原因" id="repair_reason"     class="poptextarea requiredInp"></textarea>
		</tr>
		<tr>
			<th>描述</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入描述" id="remark"     class="poptextarea"></textarea>
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
<script type="text/javascript" src="<%=basePath%>js/ywCheckCom.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	getCompanyOne();
	getPerson();
})


function getPerson(){
	$.ajax({
    	url:url+"selUserNameTour.htm",
    	dataType:"json",
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
       					htmls +=  "<option value='qxz'>选择维修人</option>";
       			 }
    			
   	    		$("#repair_use_id").html(htmls); 
    			
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
		   	}else{
		   		if($(this).attr("id") == "companyOne" || $(this).attr("id") == "companyTwo" || $(this).attr("id") == "companyThree" 
		   				|| $(this).attr("id") == "companyPws" || $(this).attr("id") == "typeIde" || $(this).attr("id") == "equ_num"){
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
	
	
	var userId  = $("#user_id").val();
	var equ_num  = $("#equ_num").val();
	var repair_reason  = $("#repair_reason").val();
	var remark  = $("#remark").val();
	var repair_use_id  = $("#repair_use_id").val();
	var if_change  = $("#if_change").val();
	
	var param = "crt_use_id="+userId;
	
	if(equ_num != '' && equ_num != undefined && equ_num != 'qxz'){
		param += "&equ_num="+equ_num;
	} 
	
	if(repair_use_id != '' && repair_use_id != undefined){
		param += "&repair_use_id="+repair_use_id;
	}else{
		layer.alert("请选择维修人员");
		return ;
	}
	
	if(remark != '' && remark != undefined){
		param += "&remark="+remark;
	} 
	
	if(repair_reason != '' && repair_reason != undefined){
		param += "&repair_reason="+repair_reason;
	}  
	
	if(if_change != '' && if_change != undefined && if_change != 'qxz'){
		param += "&if_change="+if_change;
	} 
	
	
	layer.confirm("确定保存？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		
		$.ajax({
	    	url:url+"insertRepair.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.document.getElementById("type").value=1;
	            	window.parent.getData();
	   	    		$(".cancle").click();
	   	    		window.parent.layer.alert("保存成功");
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
    })
	 
}
</Script>
</body>
</html>
