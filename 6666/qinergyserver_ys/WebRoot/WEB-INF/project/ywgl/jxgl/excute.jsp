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
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/common.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18" style="height:100%;">
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden" value="${routeId}" id="routeId" name="routeId">
	<div  class="pl8 pr8 pb18 bg-ff">
		<div class="clr wauto" >
		 	 <a  class='layer fr' id="add_btn" style="padding:5px;border:1px solid #ccc;border-radius:3px;background-color: #00b8b7;color:#fff;display:none;" data-url='<%=basePath%>commens/ywgl/jxgl/editRoute.htm?task_id=${id}&routeId=${routeId}' data-title='新增记录' data-width='650px' data-height='300px'   href='javascript:void(0);' >新增记录 </a> 
	     </div>
     </div>
  	<div  class="pl8 pr8 pb18 bg-ff pt10">
		<div class="clr wauto" >
		 	<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
	            <tr>
	              <th>路线名称</th>
	              <td id="routeName"></td> 
	              <th>任务状态</th>
	              <td id="state"></td> 
	            </tr>
	         </table>
	     </div>
     </div>
     <div  class="pl8 pr8 pb18 bg-ff pt10">
		<div class="clr wauto" >
		 	<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
	            <tr>
	              <th>电站名称</th>
	              <th>是否完成</th>
	            </tr>
	            <tbody id="datalist">
	            	<tr>
	            		<td colspan='2'>暂无数据</td>
	            	</tr>
	            </tbody>
	         </table>
	      </div>
     </div>
     <div  class="pl8 pr8 pb18 bg-ff pt10">
		<div class="clr wauto" >
		 	<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
	            <tr>
	              <th>开始时间</th>
	              <th>结束时间</th>
	              <th>状态</th>
	              <th>是否完成</th>
	              <th>电站</th>
	              <th>备注</th>
	              <th>附件</th>
	              <th>操作</th>
	            </tr>
	            <tbody id="datalist2">
	            	<tr>
	            		<td colspan='8'>暂无数据</td>
	            	</tr>
	            </tbody>
	         </table>
	      </div>
     </div>
     <div id="checkPerson" style="display:none;">
	     <table cellpadding="0"   border="0" width="100%" class="poptable">
			<tr>
				<th>审核人</th>
				<td>
					<select class="popinput" id="task_check_id">
			 			
					</select>
				</td>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<td>
					<div class="tc popbutbox2">
						<button class="cancle" style="display:none;" > </button>
						<button class="popbut" onclick="return update()">提交审核</button>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	getLx();
	getJl();
	
	getPerson();
})


function getJl(){
	var id  = $("#id").val();
	var routeId  = $("#routeId").val();
	var param = "tour_task_id="+id+"&tour_route_id="+routeId;
	$.ajax({
    	url:url+"selOverhaulTaskRecordAll.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data){
    				 if(data.data.routeMap.length > 0 ){
    					 var htmls = "";
    					 for(var o=0;o<data.data.routeMap.length;o++){
    						 var a = data.data.routeMap[o];
    						 var ooo = "" 
    						 var aa = "";
    						 if(a.tour_complete == 0){
    							 ooo = "是"
    						 }else{
    							 ooo = "否";
    						 }  
    						 var sta = a.task_stat == 1 ? "开始" :  a.task_stat == 2 ? "进行中" :  a.task_stat == 3 ? "完成待审核" :  a.task_stat == 4 ? "驳回" : a.task_stat == 5 ? "审核通过" : "";
    						 var imgNama = '无';
    						 var imgId = '';
    						 var typ = '';
    						 if(a.imgLst && a.imgLst.length > 0){
    							 typ = a.imgLst[0].type ;
    							 if(typ == 1 ){
    								 imgNama = a.imgLst[0].tour_image_name;
    							 }else if(typ == 2){
    								 imgNama = a.imgLst[0].file_name;
    							 }
    							 
    							 imgId = a.imgLst[0].id;
    							 
    							 aa = "<a  onclick='down("+imgId+","+typ+")'  href='javascript:void(0);' >下载</a>";
    						 }
    						 htmls += "<tr> "+
	    				             "<td>"+getLocalDateAndTime(a.sta_time,1)+"</td> "+
	    				             "<td>"+getLocalDateAndTime(a.end_time,1)+"</td> "+
	    			              	 "<td>"+sta+"</td>"+
	    			              	 "<td>"+ooo+"</td>"+
	    				             "<td>"+a.pws_nam+"</td> "+
	    				             "<td>"+getIsNull(a.remark)+"</td> "+
	    			              	 "<td class='hid' title='"+imgNama+"'>"+imgNama+"</td>"+
	    			              	 "<td>"+aa+"</td>"+
    		              	 		 "</tr>";
    					 }
    					 $("#datalist2").html(htmls);
    					  
        			 }else{
        				 $("#datalist2").html('<tr><td colspan="8">暂无数据</td></tr>');
        			 }
    				 
    			 }else{
    				 $("#datalist2").html('<tr><td colspan="8">暂无数据</td></tr>');
    			 }
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}

function getLx(){
	var id  = $("#id").val();
	var routeId  = $("#routeId").val();
	var param = "tour_task_id="+id+"&tour_route_id="+routeId;
	$.ajax({
    	url:url+"selOverhaulTaskRecord.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data){
    				 if(data.data.routeMap.length > 0 ){
    					 var d =  data.data.routeMap[0];
		    			 $("#routeName").html(d.route_name);
		    			 var  ss = d.task_sta == 1 ? "未指派" : d.task_sta == 2 ? "未开始" :  d.task_sta == 3 ? "进行中" : d.task_sta == 4 ? "完成待审核" : d.task_sta == 5 ? "审核通过" : d.task_sta == 6 ? "审核驳回" : "" ;
		    			 $("#state").html(ss);
        				  
		    			 //根据状态判断是否可新增记录
		    			 if(d.task_sta == 3 || d.task_sta == 6 ){
		    				 $("#add_btn").show();
		    			 }
        			 }else{
        				 $("#routeName").html("无");
        				 $("#state").html("无");
        			 }
       	    	 
    				 var isComCount = 0 ; 
    				 if(data.data.recordMap.length > 0 ){
    					 var htmls = "";
    					 for(var o=0;o<data.data.recordMap.length;o++){
    						 var a = data.data.recordMap[o];
    						 var ooo = "" 
    						 var aa = "";
    						 if(a.tour_complete == 0){
    							 ooo = "是"
   								 isComCount++;
    						 }else{
    							 ooo = "否";
    						 }  
    						 htmls += "<tr> "+
	    				             "<td>"+a.pws_nam+"</td> "+
	    			              	 "<td>"+ooo+"</td>"+
    		              	 		 "</tr>";
    					 }
    					 $("#datalist").html(htmls);
    					 
    					 if(data.data.recordMap.length == isComCount || data.data.recordMap.length < isComCount){
    						 if(data.data.routeMap.length>0){
    							 if(data.data.routeMap[0].task_sta == 4 ){ //提交审核人之后不可以修改审核人、审核驳回时除外
    								 $("#checkPerson").hide();
    							 }else{
    								 $("#checkPerson").show();
    							 }
    						 }
    					 }else{
    						 $("#checkPerson").hide();
    					 }
    					 
        			 }else{
        				 $("#datalist").html('<tr><td colspan="2">暂无数据</td></tr>');
        			 }
    				 
    			 }else{
    				 $("#routeName").html("无");
    				 $("#state").html("无");
    			 }
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
 

function getPerson(){
	$.ajax({
    	url:url+"selUserNameTourCheck.htm",
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
       					htmls +=  "<option value='qxz'>选择审核人</option>";
       			 }
    			
   	    		$("#task_check_id").html(htmls); 
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}


function down(id,type){
	var layerC = layer.confirm("确定下载？",function(){
		$.ajax({
			url : url+"downloadImgOrFile.htm?id="+id+"&type="+type,
			dataType : "json",
			type : "post",
			success : function(data) {
				if (data.resultcode && data.resultcode != "USR000") {
					layer.alert(data.desc);
					return ;
				} else {
					location.href = url+"downloadImgOrFile.htm?id="+id+"&type="+type ;
					layer.close(layerC);
				}
				
			},
			error : function(){
				location.href = url+"downloadImgOrFile.htm?id="+id+"&type="+type ;
				layer.close(layerC);
			}
		})  
		
	})
}

function update(){
	var id  = $("#id").val();
	var task_check_id = $("#task_check_id").val();
	if(task_check_id != '' && task_check_id != undefined && task_check_id != 'qxz'){
		param += "&task_check_id="+task_check_id;
	}else{
		layer.alert("请选择审核人");
		return ;
	}
	
	var param =  "id="+id+"&task_check_id="+task_check_id ;
	layer.confirm("确定保存？",function(){
		$.ajax({
	    	url:url+"overhaulTaskSubmit.htm",
	    	data : param ,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage  = 1;
	            	window.parent.getData();
	   	    		
	   	    		layer.alert("提交审核成功",function(){
	   	    			$(".cancle").click();
	   	    			window.parent.layer.closeAll();
	   	    		});
	   	    		
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
