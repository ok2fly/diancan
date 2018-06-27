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
  	<div  class="pl8 pr8 pb18 bg-ff pt10">
		<div class="clr wauto" >
		 	<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
	            <tr>
	              <th>设备编号</th>
	              <td id="equ_num"></td> 
	              <th>状态</th>
	              <td id="state"></td> 
	            </tr>
	            <tr>
	              <th>维修人</th>
	              <td id="crt_use_id"></td> 
	              <th>维修原因</th>
	              <td id="repair_reason"></td> 
	            </tr>
	         </table>
	     </div>
     </div>
     <div  class="pl8 pr8 pb18 bg-ff pt10">
		<div class="clr wauto" >
		 	<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
	            <tr>
	              <th>步骤</th>
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
	              <th>操作人</th>
	              <th>状态</th>
	              <th>是否完成</th>
	              <th>维修结果及总结</th>
	              <th>备注</th>
	              <th>附件</th>
	              <th>操作</th>
	            </tr>
	            <tbody id="datalist2">
	            	<tr>
	            		<td colspan='9'>暂无数据</td>
	            	</tr>
	            </tbody>
	         </table>
	      </div>
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
})

function getLx(){
	var id  = $("#id").val();
	var user_id  = $("#user_id").val();
	var param = "id="+id;
	$.ajax({
    	url:url+"selRepairNodeAndRepairAll.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data){
    				 if(data.data.lstRepair && data.data.lstRepair.length > 0 ){
    					 var d =  data.data.lstRepair[data.data.lstRepair.length-1];
		    			 $("#equ_num").html(d.equ_num);
		    			 var  ss = d.check_sta == 1 ? "未指派" : d.check_sta == 2 ? "未开始" :  d.check_sta == 3 ? "进行中" : d.check_sta == 4 ? "待审核" : d.check_sta == 5 ? "审核通过" : d.check_sta == 6 ? "审核驳回" : "" ;
		    			 $("#state").html(ss);
		    			 $("#crt_use_id").html(d.repair_nam);
		    			 $("#repair_reason").html(d.repair_reason);
        			 }else{
        				 $("#equ_num").html("无");
        				 $("#state").html("无");
        				 $("#crt_use_id").html("无");
        				 $("#repair_reason").html("无");
        			 }
       	    	 
 					var isComCount = 0 ; 
    				 
    				 var one = 0 ;
    				 var two = 0 ;
    				 var three = 0 ;
    				 
    				 var  htmls = "";
    				 var d = data.data.mapSta;
    				 for(var i =0 ; i < 3 ;i++){
       					 var lx = "";
       					 var comStat = d['sta'+(i+1)] == 0  ? "否" : d['sta'+(i+1)] == 1 ? "是" : "无" ;
       					 var aa = "";
       					 if( i == 0){
       						 lx = "开始";
       						 one = d['sta'+(i+1)] ;
       					 }else if(i  == 1){
       						 lx = "进行中"
      							 two = d['sta'+(i+1)] ;
       					 }else if(i  == 2){
       						 lx = "结束"
      							 three =d['sta'+(i+1)] ;
       					 } 
       					 htmls += "<tr> "+
						             "<td>"+lx+"</td> "+
					              	 "<td>"+comStat+"</td>"+
              	 		 		 "</tr>";
    				 }
    				 
    				 $("#datalist").html(htmls);
    				 
    				 
    			 }else{
    				 $("#equ_num").html("无");
    				 $("#state").html("无");
    				 $("#crt_use_id").html("无");
    				 $("#repair_reason").html("无");
    			 }
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
 
function getJl(){
	var id  = $("#id").val();
	var routeId  = $("#routeId").val();
	var param = "id="+id;
	$.ajax({
    	url:url+"selRepairNodeAll.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data){
    				 if(data.data.repairNodeMap.length > 0 ){
    					 var htmls = "";
    					 for(var o=0;o<data.data.repairNodeMap.length;o++){
    						 var a = data.data.repairNodeMap[o];
    						 var ooo = "" 
    						 var aa = "";
    						 if(a.if_success == 0){
    							 ooo = "否"
    						 }else if(a.if_success == 1){
    							 ooo = "是";
    						 }  
    						 /* var sta = ""
    						 if(a.sta == 1){
    							 sta = "开始"
    						 }else if(a.sta == 2){
    							 sta = "进行中"
    						 }else{
    							 sta = "结束";
    						 }   */
    						 var sta = a.sta == 1 ? "开始" :  a.sta == 2 ? "进行中" :  a.sta == 3 ? "完成待审核" :  a.sta == 4 ? "驳回" : a.sta == 5 ? "审核通过" : "";
    						 var imgNama = '无';
    						 var imgId = '';
    						 var typ = '';
    						 htmls += "<tr> "+
	    				             "<td>"+getLocalDateAndTime(a.sta_time,1)+"</td> "+
	    				             "<td>"+getLocalDateAndTime(a.end_time,1)+"</td> "+
	    				             "<td>"+getIsNull(a.crt_nam)+"</td> "+
	    			              	 "<td>"+sta+"</td>"+
	    			              	 "<td>"+ooo+"</td>"+
	    				             "<td>"+getIsNull(a.repair_result)+"</td> "+
	    				             "<td>"+getIsNull(a.remark)+"</td> "+
	    			              	 "<td class='hid' title='"+imgNama+"'>"+imgNama+"</td>"+
	    			              	 "<td>"+aa+"</td>"+
    		              	 		 "</tr>";
    					 }
    					 $("#datalist2").html(htmls);
    					  
        			 }else{
        				 $("#datalist2").html('<tr><td colspan="9">暂无数据</td></tr>');
        			 }
    				 
    			 }else{
    				 $("#datalist2").html('<tr><td colspan="9">暂无数据</td></tr>');
    			 }
    			
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
 
 
</Script>
</body>
</html>
