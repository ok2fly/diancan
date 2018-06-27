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
					<th>设备名称</th>
					<td id="equ_nam" name="equ_nam"  ></td>
					<th>设备型号</th>
					<td id="app_id" ></td>
				</tr>
				<tr>
					<th>设备编号</th>
					<td id="equ_num" ></td>
					<th>设备编号(业主)</th>
					<td id="equ_cod" ></td>
				</tr>
				<tr>
					<th>当前状态</th>
					<td id="cur_sta" ></td>
					<th>安装地址</th>
					<td id="ins_add"  ></td>
				</tr>
				
				<tr>
					<th>出厂日期</th>
					<td id="pro_tim" ></td>
					<th>投运日期</th> 
					<td id="ope_tim" ></td>
				</tr>
				<tr>
					<th>购买日期</th>
					<td id="pur_tim" ></td>
					<th>排序号</th> 
					<td id="equ_sor" ></td>
				</tr>
				<tr>
					<th>经度(°)</th>
					<td id="equ_lon" ></td>
					<th>纬度(°)</th> 
					<td id="equ_lat" ></td>
				</tr>
				<tr>
					<th>mqtt账号</th>
					<td id="mqtt_login_name" ></td>
					<th>mqtt密码</th>
					<td id="mqtt_login_password"  ></td>
				</tr>
				<tr>
					<th>端口号</th>
					<td id="mqtt_port"  ></td>
					<th>客户端类型</th>
					<td id="client_type" ></td>
				</tr>
				<tr>
					<th>备注</th>
					<td id="remark"></td>
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
	getById();
})
var equNum = "";
function getById(){
	var id = $("#id").val();
	$.ajax({
    	url:url+"getEquInfByEquId.htm",
    	data : "equ_id="+id,
    	dataType:"json",
    	type:"post",
    	async : false,
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			var d = data.data[0];
    			$("#equ_nam").html(d.equ_nam);
    		   	//$("#app_id").html("<option value='"+d.equ_mod_id+"'>"+d.app_mod+"</option>");
    		   	getAppType("KZQ",d.equ_mod_id);
    		    $("#ins_add").html(d.ins_add);
    		   	$("#equ_lon").html(d.equ_lon);
    		   	$("#equ_lat").html(d.equ_lat);
    		   	$("#pro_tim").html(d.pro_tim);
    		   	$("#ope_tim").html(getLocalDateAndTime(d.ope_tim,2));
    		   	$("#pur_tim").html(getLocalDateAndTime(d.pur_tim,2));
    		   	equNum = d.equ_num;
    		   	$("#equ_num").html(d.equ_num);
    		   	$("#equ_cod").html(d.equ_cod);
    		   	var cur_sta=d.cur_sta==1?"投运":d.cur_sta==2?"停运":"";
    		   	$("#cur_sta").html(cur_sta);
    		   	$("#remark").html(d.remark);
    		   	$("#equ_sor").html(d.equ_sor);
    		   	$("#pws_id").html(d.pws_id);
			} else {
               layer.alert(data.desc);
			}
    	}
    })
    
    $.ajax({
    	url:url+"getMqttInfByEquNum.htm",
    	data : "equ_num="+equNum,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			var d = data.data[0];
    			//$("#equ_nam").val(d.equ_nam);
    		    $("#mqtt_login_name").html(d.mqtt_login_name);
    		   	$("#mqtt_login_password").html(d.mqtt_login_password);
    		   	$("#mqtt_port").html(d.mqtt_port);
				var client_type=d.client_type==1?"终端":d.client_type==2?"主机":"";
    		   	$("#client_type").html(client_type);
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
function getAppType(val,id){
	 if(val != "0" && val != undefined){
		 var param = "app_typ_ide="+val;
			$.ajax({
		    	url:url+"getBasAppByAppTypIde.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			if(data.data){
		    				if(data.data.length > 0 ){
		        				 for(var i = 0; i< data.data.length ; i++){
		    		    				var d =  data.data[i];
		    		    				if(id == d.id){
		   		        				 $("#app_id").html(d.app_mod); 
		    		    				}
		    	    			 }
		        			 } 
		    			}
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
	 }
}
</script>		

</body>
</html>