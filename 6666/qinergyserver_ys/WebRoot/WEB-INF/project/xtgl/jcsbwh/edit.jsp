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
	<input type="hidden"  id="id" value="${id}" >
	<input type="hidden"  id="pws_id" value=" " >
	<table  cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>设备类型</th>
			<td>
				<select class="popinput requiredInp"  id="sbatTypeIde"  placeholder="请选择设备类型" onchange="getAppType(this.value)" >
	   			 	<option value="">-设备类型-</option>
					<!-- <option value="CNNBQ">储能逆变器</option>
					<option value="DCDC">DC/DC</option>
					<option value="BYQ">变压器</option>
					<option value="DB">电表</option>
					<option value="DNZLJCZZ">电能质量检测</option>
					<option value="HLX">汇流箱</option>
					<option value="GFNBQ">光伏逆变器</option>
					<option value="JLPDG">交流配电柜</option>
					<option value="ZLPDG">直流配电柜</option>
					<option value="HJJCY">环境检测仪</option>
					<option value="CNDC">储能电池</option>
					<option value="JLZZ">解列</option>
					<option value="XLBH">线路保护</option>
					<option value="ZLCDZ">直流充电桩</option>
					<option value="JLCDZ">交流充电桩</option>
					<option value="KZQ">控制器</option> -->
     	   			 </select>
			</td>
			<th>设备型号</th>
			<td><select class="popinput requiredInp" id="app_id" placeholder="请选择设备型号"  ></select></td>
		</tr>
		<tr>
			<th>设备名称</th>
			<td><input type="text" placeholder="请输入设备名称" id="equ_nam" class="popinput quinputcol requiredInp"></td>
			<th>当前状态</th>
			<td><select class="popinput requiredInp" id="cur_sta" >
				<option value="1">投运</option>
				<option value="2">停运</option>
			</select></td>
		</tr>
		<tr>
			<th>设备编号</th>
			<td><input type="text" placeholder="请输入设备编号" id="equ_num" class="popinput quinputcol requiredInp"></td>
			<th>设备编号(业主)</th>
			<td><input type="text" placeholder="请输入设备编号(业主)" id="equ_cod" class="popinput quinputcol requiredInp"></td>
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
			<th id="meter_typ_th" >电表类型</th>
			<td id="meter_typ_td" >
				<select class="popinput "  id="meter_typ"   placeholder="请选择电表类型" onchange="" >
   	   			</select>
			</td>
		</tr>
		<tr>
			<th>安装地址</th>
			<td><input type="text" placeholder="请输入安装地址" id="ins_add" class="popinput quinputcol requiredInp"></td>
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
			<th>备注</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea quinputcol"></textarea>
			</td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="return update();">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script>

var metTyp = "";
$(function(){
	getById();
	
	
	$.ajax({
    	url:url+"getMeterTypLstAll.htm",
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
    			 if(data.data){
    				 if(data.data.length > 0 ){
        				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				
   		    				if(metTyp == d.id){
   		    					
	   		    				htmls += "<option value='"+d.id+"' selected >"+d.par_nam+"</option>";
   							}else{
   								
	   		    				htmls += "<option value='"+d.id+"'>"+d.par_nam+"</option>";
   							}
   		    				
    	    			 }
        				 $("#meter_typ").html(htmls); 
        			 } 
    			 } 
			} else {
               layer.alert(data.desc);
			}
    	}
    })
})

function getById(){
	var id = $("#id").val();
	$.ajax({
    	url:url+"getEquInfByEquId.htm",
    	data : "equ_id="+id,
    	dataType:"json",
    	async:false,
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			var d = data.data[0];
    			$("#equ_nam").val(d.equ_nam);
    		   	//$("#app_id").html("<option value='"+d.equ_mod_id+"'>"+d.app_mod+"</option>");
    		    $("#ins_add").val(d.ins_add);
    		   	$("#equ_lon").val(d.equ_lon);
    		   	$("#equ_lat").val(d.equ_lat);
    		   	$("#pro_tim").val(d.pro_tim);
    		   	$("#ope_tim").val(getLocalDateAndTime(d.ope_tim,2));
    		   	$("#pur_tim").val(getLocalDateAndTime(d.pur_tim,2));
    		   	$("#equ_num").val(d.equ_num);
    		   	$("#equ_cod").val(d.equ_cod);
    		   	$("#cur_sta").val(d.cur_sta);
    		   	$("#remark").val(d.remark);
    		   	$("#equ_sor").val(d.equ_sor);
    		   	$("#pws_id").val(d.pws_id);
    		   	metTyp = d.meter_typ;
    		   	$("#meter_typ").val(d.meter_typ);
    		   	//$("#sbatTypeIde").val(d.sbatTypeIde);
    		   	getApp(d.sbatTypeIde);
    		   	getAppType(d.sbatTypeIde,d.equ_mod_id);
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}

function getApp(id){
	 $.ajax({
	    	url:url+"getBasAppTypAll.htm",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				if(id == d.typ_ide){
			    					 htmls +=  "<option value='"+d.typ_ide+"' selected >"+d.typ_nam+"</option>";
			    				}else{
			    					 htmls +=  "<option value='"+d.typ_ide+"'>"+d.typ_nam+"</option>";
			    				}
		    			 }
	    			 } 
	   	    		 
	   	    	     $("#sbatTypeIde").html(htmls);
				} else {
	               layer.alert(data.desc);
				}
	    	}
	})
}


function getAppType(val,equ_mod_id){
	 if(val != "" && val != undefined){
		 var param = "app_typ_ide="+val;
			$.ajax({
		    	url:url+"getBasAppByAppTypIde.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
	    			 var htmls = "<option value=''>-设备型号-</option>";
		    		if (data.resultcode=="USR000") {
		    			 if(data.data){
		    				 if(data.data.length > 0 ){
		        				 for(var i = 0; i< data.data.length ; i++){
		    		    				var d =  data.data[i];
		    		    				if(equ_mod_id && equ_mod_id == d.id){
			    		    				htmls +=  "<option value='"+d.id+"' selected>"+d.app_mod+"</option>";
		    		    				}else{
			    		    				htmls +=  "<option value='"+d.id+"'>"+d.app_mod+"</option>";
		    		    				}
		    	    			 }
		        			 } 
		    			 } 
        				 $("#app_id").html(htmls); 
					} else {
						$("#app_id").html(htmls); 
		               layer.alert(data.desc);
					}
		    	}
		    })
		    if(val == "DB"){
		    	$("#meter_typ_th").show();
		    	$("#meter_typ_td").show();
		    }else{
		    	$("#meter_typ_th").hide();
		    	$("#meter_typ_td").hide();
		    }
	 }else{
		 $("#meter_typ_th").hide();
		 $("#meter_typ_td").hide();
		 $("#app_id").html("<option value=''>-设备型号-</option>");
	 }
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
   	 var pws_id = $("#pws_id").val();
   	 var equ_nam = $("#equ_nam").val();
   	 var equ_mod_id = $("#app_id").val();
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
   	 var meter_typ = $("#meter_typ").val();
   	 var param = "pws_id="+pws_id+"&equ_id="+id+"&equ_nam="+equ_nam+"&equ_mod_id="+equ_mod_id+"&ins_add="+ins_add+"&equ_lon="+equ_lon+"&equ_lat="+equ_lat+"&pro_tim="+pro_tim+
   	 			 "&ope_tim="+ope_tim+"&pur_tim="+pur_tim+"&equ_num="+equ_num+"&equ_cod="+equ_cod+"&cur_sta="+cur_sta+"&remark="+remark+"&equ_sor="+equ_sor;
   	 if(meter_typ != null){
   		 
   		param = param + "&meter_typ="+meter_typ;
   		 
   	 }
 	layer.confirm("是否修改？",function(){
	   	var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
	   	 $.ajax({
	    	url:url+"updateEquInfo.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    				window.parent.currentPage = 1 ; 
		    			window.parent.getData(); 
						$(".cancle").click();
						window.parent.layer.msg("保存成功！");	
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	})
}
</script>
</body>
</html>
