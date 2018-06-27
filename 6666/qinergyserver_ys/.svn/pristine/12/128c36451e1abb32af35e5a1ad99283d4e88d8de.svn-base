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
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden" value="${user.id}" id="mod_use_id">
	<input type="hidden" value="${user.com_id}" id="com_id">
	
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>编号</th>
			<td><input  id="plan_num" placeholder="编号不能为空" class="popinput" readonly="readonly"></td>
			<th>计划日期</th>
			<td><input type="text" value="" id="pur_tim"  placeholder="请输入计划日期" class="popinput Wdate requiredInp" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"></td>
		</tr>
		<tr>
			<th>是否完成</th> 
			<td><select value="" id="is_finish"  placeholder="请选择是否完成"  class="popinput requiredInp">
							<option value="0">完成</option>
							<option value="1">未完成</option></select></td>
			<th>采购负责人</th>
			<td><select  value="" id="plan_use_id" placeholder="请输入计划采购人" class="popinput  requiredInp"></select></td>
			
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
		<button class="popbut" onclick="update()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>


$(function(){
	
	var id = $("#id").val();
	getDataById(id);
})
function getDataById(id){
	$.ajax({
		url:url+"getAssetsPurPlanById.htm",
		type:"post",
		data:"id="+id,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var htmls="";
				var d=data.data;
		        $("#plan_num").val(d.plan_num);
		        $("#pur_tim").val(getLocalDateAndTime(d.pur_tim,2));
		        $("#is_finish").val(d.is_finish);
		        getPerson(d.plan_use_id);
		        $("#remark").val(d.remark);
		        
			}else{
				layer.alert(data.desc);
			}
		}
	})
}

function getPerson(plan_use_id){
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
   		    				if(plan_use_id==d.id){
   		    				htmls += "<option value='"+d.id+"' selected>"+d.use_nam+"</option>";
   		    				}else{
   	   		    				htmls += "<option value='"+d.id+"'>"+d.use_nam+"</option>";

   		    				}
	       			 }
       			 }
    			
   	    		$("#plan_use_id").html(htmls); 
    			
			} else {
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
	 var  plan_num = $("#plan_num").val();
	 var  pur_tim = $("#pur_tim").val();
	 var  plan_use_id = $("#plan_use_id").val();
	 var  is_finish = $("#is_finish").val();
	 var  mod_use_id = $("#mod_use_id").val();
	 var  remark = $("#remark").val();
	 
	 if(pur_tim!=" "&&pur_tim!=undefined){
		 param +="&pur_tim="+pur_tim;
	 }else{
		 layer.alert("时间不能为空！");
		 return;
	 }
	 param += "&plan_num="+plan_num+"&plan_use_id="+plan_use_id+"&is_finish="+is_finish+
	 "&mod_use_id="+mod_use_id+"&remark="+remark,
	 
	 layer.confirm("确定修改？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		 });
		 $.ajax({
	    	url:url+"updAssetsPurPlan.htm",
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
	 });
	
	 
}
</Script>
</body>
</html>
