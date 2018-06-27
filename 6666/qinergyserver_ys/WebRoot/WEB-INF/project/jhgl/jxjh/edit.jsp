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
<title>检修计划</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type = "hidden" value="${user.id}"   id="user_id">
	<input type = "hidden" value="${id}"  id="id">
	<input type="hidden" id="run_flat"> 
 	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>计划名称</th>
			<td><input type="text" placeholder="请输入计划名称"  id="tour_plan_name" class="popinput quinputcol requiredInp"></td>
			<th>检修路线</th>
			<td><select class="popinput requiredInp" id="tour_route_id" placeholder="请选择检修路线" ></select></td>
		</tr>
		<tr>
			<th>计划开始时间</th>
			<td><input type="text" placeholder="请输入计划开始时间"  id="first_time" class="popinput quinputcol Wdate requiredInp" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'end_time\')}',minDate:'%y-%M-%d' })"></td>
			<th>计划结束时间</th>
			<td><input type="text" placeholder="请输入计划结束时间" id="end_time"  class="popinput quinputcol Wdate requiredInp" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'first_time\')}'})"></td>
		</tr>
		<tr>
			<th>巡视周期规则</th>
			<td>
				<select placeholder="请选择检修周期规则" id="day_type"  class="popinput requiredInp">
					<option value="2">按日</option>
					<option value="1">按月</option>
				</select>
			</td>
			<th>检修周期</th>
			<td><input type="number" placeholder="请输入检修周期" id="frequency"  class="popinput quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>检修工期</th>
			<td><input  type="number" placeholder="请输入检修工期" id="plan_tour_time"  class="popinput quinputcol requiredInp" oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
				<textarea cols="3" rows="3" placeholder="请输入备注" id="remark" name="remark" onfocus="" class="poptextarea"></textarea>
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
	getLx();
	getById(id);
})


function getById(id){
	$.ajax({
    	url:url+"getOverhaulPlanById.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
   				 if(data.data.length > 0 ){
       				 var d =  data.data[0];
       				 $("#tour_plan_name").val(d.tour_plan_name);
       				 $("#first_time").val(getLocalDateAndTime(d.first_time,2));
       				 $("#next_time").val(getLocalDateAndTime(d.next_time,2));
       				 $("#frequency").val(d.frequency);
       				 $("#remark").val(d.remark);
       				 $("#end_time").val(getLocalDateAndTime(d.end_time,2));
       				 $("#plan_tour_time").val(d.plan_tour_time);
       				 $("#run_flat").val(d.run_flat);
       				 $("#day_type").val(d.day_type);
       				 var tour_route_id = d.tour_route_id;
       				 getLx(tour_route_id);
       			 } 
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}

function getLx(id){
	var userId  = $("#user_id").val();
	var param = "id="+userId+"&type=1";
	$.ajax({
    	url:url+"getTourOrOverHaul.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
   				 if(data.data.length > 0 ){
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				if(d.id == id){
    		    				htmls += "<option value='"+d.id+"' selected>"+d.route_name+"</option>";
		    				}else{
    		    				htmls += "<option value='"+d.id+"'>"+d.route_name+"</option>";
		    				}
	    			 }
       			 }else{
       					htmls +=  "<option value='qxz'>选择路线</option>";
       			 }
    			
   	    		$("#tour_route_id").html(htmls); 
    			
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
		   	}else{
		   		if($(this).attr("id") == "tour_route_id"   ){
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
	
	var id = $("#id").val();
	var userId  = $("#user_id").val();
	var tour_route_id  = $("#tour_route_id").val();
	var first_time  = $("#first_time").val();
	var next_time  = $("#next_time").val();
	var frequency  = $("#frequency").val();
	var plan_tour_time  = $("#plan_tour_time").val();
	var tour_plan_name  = $("#tour_plan_name").val();
	var remark  = $("#remark").val();
	var end_time  = $("#end_time").val();
	var run_flat  = $("#run_flat").val();
	var day_type  = $("#day_type").val();
	
	var param = "id="+id+"&crt_use_id="+userId;
	if(tour_route_id != '' && tour_route_id != undefined){
		param += "&tour_route_id="+tour_route_id;
	}else{
		layer.alert("请选择线路");
		return ;
	}
	
	if(first_time != '' && first_time != undefined){
		param += "&first_time="+first_time;
	} 
	if(next_time != '' && next_time != undefined){
		param += "&next_time="+next_time;
	} 
	if(frequency != '' && frequency != undefined){
		param += "&frequency="+frequency;
	} 
	if(plan_tour_time != '' && plan_tour_time != undefined){
		param += "&plan_tour_time="+plan_tour_time;
	} 
	if(tour_plan_name != '' && tour_plan_name != undefined){
		param += "&tour_plan_name="+tour_plan_name;
	} 
	if(end_time != '' && end_time != undefined){
		param += "&end_time="+end_time;
	} 
	
	if(remark != '' && remark != undefined){
		param += "&remark="+remark;
	} 
	if(run_flat != '' && run_flat != undefined){
		param += "&run_flat="+run_flat;
	} 
	if(day_type != '' && day_type != undefined){
		param += "&day_type="+day_type;
	} 
	
	layer.confirm("确定修改？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"insertOrUpdOverhaulPlan.htm",
	    	data : param,
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
	    })
    })
}
</Script>
</body>
</html>
