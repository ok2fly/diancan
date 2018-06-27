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
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<input type="hidden" value="${app_typ}" id="app_typ" name="app_typ">
 	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>设备类型</th>
			<td><select  id="app_typ_id"  class="popinput requiredInp" placeholder="请选择设备类型" ></select></td>
			<th>设备型号</th>
			<td><input type="text" placeholder="请输入设备型号名称"  id="app_mod"   class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>生产厂商</th> 
			<td><select  id="man_id"  class="popinput requiredInp" placeholder="请选择厂家" ></select></td>
			<th>创建单位</th>
			<td><select  id="com_id"  class="popinput requiredInp" placeholder="请选择公司" ></select></td>
		</tr>
		<tr>
			<th>额定电流(A)</th>
			<td><input type="number" placeholder="请输入额定电流"  id="rtd_elc"   class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>额定电压(V)</th>
			<td><input type="number" placeholder="请输入额定电压"  id="rtd_vol"   class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>额定容量(kW)</th>
			<td><input type="number" placeholder="请输入额定容量"  id="rtd_pow"   class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>长*宽*深(mm)</th>
			<td><input type="number" placeholder="长" id="size_lon" class="inp"   oninput="if(value.length>11)value=value.slice(0,11)">*
			<input type="number"  placeholder="宽" id="size_wid" class="inp"   oninput="if(value.length>11)value=value.slice(0,11)">*
			<input type="number" placeholder="深" id="size_hig"  class="inp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>重量(kg)</th>
			<td><input type="number" placeholder="请输入重量"  id="weight"   class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>海拔(km)</th>
			<td><input type="text" placeholder="请输入海拔"  id="altitude"   class="popinput quinputcol"></td>
		</tr>
		<tr>
			<th>工作温度(°c)</th>
			<td><input type="text" placeholder="请输入工作温度"  id="work_temp"   class="popinput quinputcol"></td>
			<th>防护等级</th>
			<td><input type="text" placeholder="请输入工作温度"  id="prtc_grade"   class="popinput quinputcol"></td>
		</tr>
		<tr>
			<th>通讯类型</th>
			<td><select type="text" placeholder="请选择通讯类型"  id="com_typ"   class="popinput quinputcol">
				<option  value="1">RS485</option>
				<option  value="2">以太网</option>
				<option  value="3">CAN</option>
				<option  value="4">WIFI</option>
				<option  value="5">3G/4G</option>
			</select></td>
			<th>通讯协议</th>
			<td><input type="text" placeholder="请输入通讯协议"  id="com_pro"   class="popinput quinputcol"></td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert()" >确定</button>
		<input class="popbut" type="reset" value="重置" class="cz" onclick="reset()">
	</div>
	
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	getType();
	getMan();
	getCom();
})


function getCom(){
	var userId = $("#user_id").val();
 	$.ajax({
	    	url:url+"getAllComNam.htm",
	    	async : false,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data.length > 0 ){
	    				 var html = "";
	    				 for(var i = 0; i< data.data.length ; i++){
	    					 var org = data.data[i];
   								html += "<option value="+org.id+"  >"+org.com_nam+"</option>"
		    			 } 
    						 
   						 $("#com_id").html(html); 
	    			 }
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}


function getMan(){
 	$.ajax({
	    	url:url+"getManInfAll.htm",
	    	dataType:"json",
	    	async : false,
	    	type:"post",
	    	success:function(data1){
	    		if (data1.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data1.data.length > 0 ){
	    				 for(var i = 0; i< data1.data.length ; i++){
			    				var d =  data1.data[i];
			    				 htmls +=  "<option value='"+d.id+"'>"+d.man_nam+"</option>";
		    			 }
	    				 $("#man_id").html(htmls); 
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}

function getType(){
	
	var app_typ=$("#app_typ").val();
 	$.ajax({
	    	url:url+"getBasAppTypAll.htm",
	    	dataType:"json",
	    	async : false,
	    	type:"post",
	    	success:function(data2){
	    		if (data2.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data2.data.length > 0 ){
	    				 for(var i = 0; i< data2.data.length ; i++){
			    				var d =  data2.data[i];
			    				if(d.id == app_typ){
			    					 htmls +=  "<option value='"+d.id+"' selected >"+d.typ_nam+"</option>";
			    				}else{
			    					 htmls +=  "<option value='"+d.id+"'>"+d.typ_nam+"</option>";
			    				}
		    			 }
	    				 $("#app_typ_id").html(htmls); 
	    			 } 
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
	  			/* if($(this).attr("id") == "size_hig" ){
	 		 		if($(this).val() == ""){
	 		 		   reFlag = true;
					   layer.alert("请输入尺寸长宽高")
					   return false;
	 		 		}
	 		 	}else{
	 		 	} */
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
	 }else{
		/*  if($("#size_lon").val() == "" || $("#size_wid").val() == "" || $("#size_hig").val() == ""){
			 layer.alert("请输入长宽深");
			 return false;
		 } */
	 }
	 
	 var  useId = parseInt($("#user_id").val());
	 var  app_typ_id = parseInt($("#app_typ_id").val());
	 var  app_mod = $("#app_mod").val();
	 var  man_id = parseInt($("#man_id").val());
	 var  com_id = parseInt($("#com_id").val());
	 var  rtd_elc = $("#rtd_elc").val();
	 var  rtd_vol = $("#rtd_vol").val();
	 var  rtd_pow = $("#rtd_pow").val();
	 var  size_lon=$("#size_lon").val();
	 var  size_wid=$("#size_wid").val();
	 var  size_hig=$("#size_hig").val();
	 var  weight = $("#weight").val();
	 var  altitude = $("#altitude").val();
	 var  work_temp = $("#work_temp").val();
	 var  prtc_grade = $("#prtc_grade").val();
	 var  com_typ = $("#com_typ").val();
	 var  com_pro = $("#com_pro").val();
	 
	 layer.confirm("是否添加？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"insAppInf.htm",
	    	data:"crt_use_id="+useId+"&app_typ_id="+app_typ_id+"&app_mod="+app_mod+"&man_id="+man_id+"&com_id="+com_id+
	    		 "&rtd_elc="+rtd_elc+"&rtd_vol="+rtd_vol+"&rtd_pow="+rtd_pow+
	    		 "&size_lon="+size_lon+"&size_wid="+size_wid+"&size_hig="+size_hig+
	    		 "&weight="+weight+"&altitude="+altitude+"&work_temp="+work_temp+"&prtc_grade="+prtc_grade+"&com_typ="+com_typ+"&com_pro="+com_pro,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1 ; 
	    			window.parent.getData();	
	    			layer.alert("设备型号添加成功！");

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
</Script>
</body>
</html>
