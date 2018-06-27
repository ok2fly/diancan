<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
		
	</head>
	<body >
	<input type="hidden" id="id" value="${id }">
		<div class="pt18 fl " style="width: 100%">
		<div class=" tabxq ">
			<table cellpadding="0" cellspacing="0" border="0" width="100%"  >
				<tr>
					<th>设备类型</th>
					<td id="app_typ_id" ></td>
					<th>设备型号</th>
					<td id="app_mod" ></td>
				</tr>
				<tr>
					<th>生产厂商</th> 
					<td id="man_id" ></td>
					<th>创建单位</th>
					<td id="com_id" ></td>
				</tr>
				<tr>
					<th>额定电流(A)</th>
					<td id="rtd_elc"></td>
					<th>额定电压(V)</th>
					<td id="rtd_vol"></td>
				</tr>
				<tr>
					<th>额定容量(kW)</th>
					<td id="rtd_pow"></td>
					<th>长*宽*深(mm)</th>
					<td id="size" ></td>
				</tr>
				<tr>
					<th>重量(kg)</th>
					<td id="weight" ></td>
					<th>海拔(km)</th>
					<td id="altitude"></td>
				</tr>
				<tr>
					<th>工作温度(°c)</th>
					<td id="work_temp" ></td>
					<th>防护等级</th>
					<td id="prtc_grade" ></td>
				</tr>
				<tr>
					<th>通讯类型</th>
					<td id="com_typ"  ></td>
					<th>通讯协议</th>
					<td id="com_pro" ></td>
				</tr>
				</table>
			</div>
		</div>
		
		
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>
<script type="text/javascript">
$(function(){
	var id = $("#id").val();
	getById(id);  
})

function getById(id){
	 $.ajax({
	    	url:url+"getBasAppById.htm",
	    	data : "app_id="+id,
	    	dataType:"json",
	    	async:false,
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			var d = data.data[0];
	    			 $("#app_typ_id").html(d.app_typ_id); 
	    			 $("#app_mod").html(d.app_mod);
	    			 $("#man_id").html(d.man_id);
	    			 $("#com_id").html(d.com_id);
	    			 $("#rtd_elc").html(d.rtd_elc);
	    			 $("#rtd_vol").html(d.rtd_vol);
	    			 $("#rtd_pow").html(d.rtd_pow);
	    			 $("#size").html(d.size);
	    			 $("#weight").html(d.weight);
	    			 $("#altitude").html(d.altitude);
	    			 $("#work_temp").html(d.work_temp);
	    			 $("#prtc_grade").html(d.prtc_grade);
					 var com_typ=d.com_typ==1?"RS485":d.com_typ==2?"以太网":d.com_typ==3?"CAN":d.com_typ==4?"WIFI":d.com_typ==5?"3G/4G":"";
	    			 $("#com_typ").html(com_typ);
	    			 $("#com_pro").html(d.com_pro);
	    			 var typeId = d.app_typ_id;
	    			 var manId = d.man_id;
	    			 var comId = d.com_id;
	   	    		 getType(typeId);
	   	    		 getMan(manId);
	   	    		 getCom(comId);
				} else {
	               layer.alert(data.desc);
				}
	    	}
  })
}

function getCom(comId){
	var userId = $("#useId").val();
 	$.ajax({
	    	url:url+"getAllComNam.htm",
	    	data : "id="+parseInt(userId),
	    	dataType:"json",
	    	type:"post",
	    	async:false,
	    	success:function(data1){
	    		if (data1.resultcode=="USR000") {
	    			 if(data1.data.length > 0 ){
	    				 var html = "";
	    				 for(var i = 0; i< data1.data.length ; i++){
	    					 var d = data1.data[i]
    					     if(comId == d.id){
    	   						 $("#com_id").html(d.com_nam); 
    					     }
	    			     } 
	    			 }
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}


function getMan(manId){
 	$.ajax({
	    	url:url+"getManInfAll.htm",
	    	dataType:"json",
	    	type:"post",
	    	async:false,
	    	success:function(data2){
	    		if (data2.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data2.data.length > 0 ){
	    				 for(var i = 0; i< data2.data.length ; i++){
			    				var d =  data2.data[i];
			    				if(d.id == manId){
				    				 $("#man_id").html(d.man_nam); 
			    				}
		    			 }
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}

function getType(typeId){
 	$.ajax({
	    	url:url+"getBasAppTypAll.htm",
	    	dataType:"json",
	    	type:"post",
	    	async:false,
	    	success:function(data3){
	    		if (data3.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data3.data.length > 0 ){
	    				 for(var i = 0; i< data3.data.length ; i++){
			    				var d =  data3.data[i];
			    				if(d.id == typeId){
				    				 $("#app_typ_id").html(d.typ_nam); 
			    				}
		    			 }
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}
</script>		

</body>
</html>