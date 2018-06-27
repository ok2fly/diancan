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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18" style="height:100%;">
	<input type="hidden" id="userId" value="${user.id}" >
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<input type="hidden" id="id" value="${id}" >
	<input type="hidden" id="type" value="${type}" >
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>路线类型</th>
			<td><input  type="text" id="lxType" readonly="readonly" class="popinput quinputcol" ></td>
			<th>路线名称</th>
			<td><input type="text"  id="route_name"  readonly="readonly" class="popinput quinputcol"></td>
		</tr>
	</table>
	<div id="map" style="width:60%;min-height:400px; " class="fl">
	
	</div>
	<div class="w40 fl"  style="height:100%;">
		 <div  class="fl w90 ml15" id="check_area" style="min-height: 220px;border: 1px solid #ccc; position: relative;">
		 	<div class="pl8 pr8 pt10">
		 		<div id="pswcheck" class="check_yw_pws">
			 		 <table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
				            <tr>
				              <th>序号</th>
				              <th>站点名称</th>
				            </tr>
				            <tbody id="datalist"> 
				            
				            </tbody>
			         </table>
		         </div>
		 	</div>
		 </div>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4&ak=spS1jTrhDurkl3nOFkx5YcgMMfXbWalP"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>

var markerArr = [];
//全局变量
var longitude=116.3;
var latitude=39.9;

$(function(){
	
	//设置地图宽高
	var Screenheight  = (document.documentElement.clientHeight);  
	//设置地图高
	Screenheight = Screenheight - 90;
		
	$("#map").css("height",Screenheight);
	
	$("#check_area").css("height",Screenheight);
	$("#pswcheck").css("height",Screenheight-30);
	
	getOne();
	
	var typ = $("#type").val() == 1 ? "检修路线" : "巡视路线" ;
	$("#lxType").val(typ);
	 
})

function getOne(){
	var id = $("#id").val();
	var type = $("#type").val();
	var param = "route_name_id="+id+"&type="+type;
	$.ajax({
    	url:url+"selRouteOrOverhaulNamePwsByRouteNameId.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data){
    				 if(data.data.length > 0 ){
    					 markerArr = []; 
    					 var route_name = "" ;
    					 var tabHt = '';
        				 for(var i = 0; i< data.data.length ; i++){
   		    				 var d = data.data[i];
   		    				 var oneMarker = {
  									point : d.pws_lon+','+d.pws_lat 
  							 };
  							 markerArr.push(oneMarker);
  							 
  							 tabHt += '<tr>'+
  							 		  '<td>'+d.route_sort+'</td>'+
  							 		  '<td>'+d.pws_nam+'</td>'+
  							 		  '</tr>';
  							route_name = d.route_name;
    	    			 }
        				 
        				  
        				 $("#datalist").html(tabHt);
        				 $("#route_name").val(route_name);
        			 
        				 
        				 map_init();
        			 } 
    			 } 
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}


function map_init(){
	// 百度地图API功能
	var map = new BMap.Map("map");
	map.centerAndZoom(new BMap.Point(118.454, 32.955), 6);
	map.enableScrollWheelZoom();
	
	//存放标注点经纬信息的数组
	var point = new Array(); 
	 
	 
	for (var i = 0; i < markerArr.length; i++) {
			var p0 = markerArr[i].point.split(",")[0]; //
			var p1 = markerArr[i].point.split(",")[1]; //按照原数组的point格式将地图点坐标的经纬度分别提出来
			point[i] = new window.BMap.Point(p0, p1); //循环生成新的地图点
			 
 	}
	//让所有点在视野范围内
	map.setViewport(point);
	var curve = new BMapLib.CurveLine(point, {strokeColor:"blue", strokeWeight:3, strokeOpacity:0.5}); //创建弧线对象
	map.addOverlay(curve); //添加到地图中
}
	
</Script>
</body>
</html>
