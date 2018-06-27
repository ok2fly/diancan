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
	<input type="hidden" name="pws_id" id="pws_id" value="${id}" >
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
 
	<table  cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>设备名称</th>
			<td><input type="text" placeholder="请输入设备名称" id="equ_nam" class="popinput quinputcol requiredInp"></td>
			<th>设备型号</th>
			<td><select class="popinput requiredInp" id="app_id" placeholder="请选择设备型号" ></select></td>
		</tr>
		<tr>
			<th>设备编号</th>
			<td><input type="text" placeholder="请输入设备编号" id="equ_num" class="popinput quinputcol requiredInp"></td>
			<th>设备编号(业主)</th>
			<td><input type="text" placeholder="请输入设备编号(业主)" id="equ_cod" class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>当前状态</th>
			<td><select class="popinput requiredInp" id="cur_sta" >
				<option value="1">投运</option>
				<option value="2">停运</option>
			</select></td>
			<th>安装地址</th>
			<td><input type="text" placeholder="请输入安装地址" id="ins_add" class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>出厂日期</th>
			<td><input type="text" placeholder="请输入出厂日期" id="pro_tim" class="popinput Wdate quinputcol requiredInp"  onFocus="WdatePicker()"></td>
			<th>投运日期</th> 
			<td><input type="text" placeholder="请输入投运日期" id="ope_tim" class="popinput Wdate quinputcol requiredInp"  onFocus="WdatePicker()"></td>
		</tr>
		<tr>
			<th>购买日期</th>
			<td><input type="text" placeholder="请输入购买日期" id="pur_tim" class="popinput Wdate quinputcol requiredInp"  onFocus="WdatePicker()"></td>
			<th>排序号</th> 
			<td><input type="number" placeholder="请输入排序号" id="equ_sor" class="popinput quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>经度(°)</th>
			<td><input type="number" placeholder="请输入经度" id="equ_lon" class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>纬度(°)</th> 
			<td><input type="number" placeholder="请输入纬度" id="equ_lat"  class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>mqtt账号</th>
			<td><input type="text"  placeholder="请输入mqtt账号" id="mqtt_login_name" class="popinput quinputcol requiredInp"></td>
			<th>mqtt密码</th>
			<td><input type="text"  placeholder="请输入mqtt密码"  id="mqtt_login_password" class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>端口号</th>
			<td><input type="number"   placeholder="请输入端口号"  id="mqtt_port" class="popinput quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>客户端类型</th>
			<td><select class="popinput requiredInp"  placeholder="请选择客户端类型" id="client_type" >
				<option value="1">终端</option>
				<option value="2">主机</option>
			</select></td>
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
		<button class="popbut" onclick="insert()"  >确定</button>
		<input class="popbut" type="reset" value="重置" class="cz" onclick="reset()" > 
	</div>
	 
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script>
$(function(){
	getAppType("KZQ");
})
function getAppType(val){
	 if(val != "0" && val != undefined){
		 var param = "app_typ_ide="+val;
			$.ajax({
		    	url:url+"getBasAppByAppTypIde.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			 var htmls = "<option value=''>-设备型号-</option>";
		    			 if(data.data){
		    				 if(data.data.length > 0 ){
		        				 for(var i = 0; i< data.data.length ; i++){
		    		    				var d =  data.data[i];
		    		    				htmls +=  "<option value='"+d.id+"'>"+d.app_mod+"</option>";
		    	    			 }
		        				 $("#app_id").html(htmls); 
		        			 } 
		    			 } 
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
	 }
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
		   		if($(this).attr("id") == "pro_id" || $(this).attr("id") == "cit_id" || $(this).attr("id") == "are_id" ){
	  		 		if($(this).val() == "0"){
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
  	 var useId = $("#user_id").val();
   	 var equ_nam = $("#equ_nam").val();
   	 var equ_mod_id = $("#app_id").val();
   	 var pws_id = $("#pws_id").val();
   	 var ins_add = $("#ins_add").val();
   	 var equ_lon = $("#equ_lon").val();
   	 var equ_lat = $("#equ_lat").val();
   	 var pro_tim = $("#pro_tim").val();
   	 var ope_tim = $("#ope_tim").val();
   	 var pur_tim = $("#pur_tim").val();
   	 var equ_num = $("#equ_num").val();
   	 var equ_cod = $("#equ_cod").val();
   	 var cur_sta = $("#cur_sta").val();
   	 var remark = $("#remark").val();
   	 var equ_sor = $("#equ_sor").val();
   	 var mqtt_login_name=$("#mqtt_login_name").val();
   	 var mqtt_login_password=$("#mqtt_login_password").val();
   	 var mqtt_port=$("#mqtt_port").val();
   	 var client_type=$("#client_type").val(); 
   	 var param = "equ_nam="+equ_nam+"&equ_mod_id="+equ_mod_id+"&pws_id="+pws_id+"&ins_add="+ins_add+"&equ_lon="+equ_lon+"&equ_lat="+equ_lat+"&pro_tim="+pro_tim+
   	 			 "&ope_tim="+ope_tim+"&pur_tim="+pur_tim+"&equ_num="+equ_num+"&equ_cod="+equ_cod+"&cur_sta="+cur_sta+"&remark="+remark+"&equ_sor="+equ_sor+"&use_id="+useId;
   	layer.confirm("是否添加",function(){
	   	var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
	   	 $.ajax({
	    	url:url+"insertEquInfo.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1 ; 
	    			window.parent.getData();	
	    			layer.alert("添加成功");

				} else {
	               layer.alert(data.desc);
				}
	    	}
	    });
	    var param2 = "equ_num="+equ_num+"&mqtt_login_name="+mqtt_login_name+"&mqtt_login_password="+mqtt_login_password+"&mqtt_port="+mqtt_port+"&client_type="+client_type;
	   	$.ajax({
	    	url:url+"insertMqtt.htm",
	    	data : param2,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1 ; 
	    			window.parent.getData();	
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
   	})
}

function reset(){
	window.location.reload();
}
</script>
</body>
</html>
