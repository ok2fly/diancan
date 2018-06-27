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
<div class="pt18" style="height:80%;">
	<input type="hidden" id="userId" value="${user.id}" >
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>路线类型</th>
			<td>
				<select class="popinput requiredInp" placeholder="请 选择路线类型"  id="lxType" >
					<option value="1">检修路线</option>
	          		<option value="2">巡视路线</option>
	       		</select>
       		</td>
			<th>路线名称</th>
			<td><input type="text" placeholder="请输入路线名称"  id="route_name" class="popinput quinputcol requiredInp"></td>
		</tr>
	</table>
	<div id="map" style="width:60%;min-height:400px;height:100%;" class="fl">
	
	</div>
	<div class="w40 fl"  style="height:100%;">
		 <select class="fl quinput  ml15"  style="width : 90%" id="companyOne"  onchange="setCompanytwo(this.value);">
		 	<option value="qxz">请选择一级公司</option>
		 </select>
		 <select class="fl quinput  ml15 mt15" style="width : 90%"  id="companyTwo"   onchange="setCompanyThree(this.value);">
		 	<option value="qxz">请选择二级公司</option>
		 </select>
		 <select class="fl quinput  ml15 mt15"   style="width : 90%"id="companyThree"   onchange="setPws(this.value);">
		 	<option value="qxz">请选择三级公司</option>
		 </select>
		  <select class="fl quinput  ml15 mt15"  style="width : 90%" id="companyPws"  onchange="checkPws(this.value)"   >
		 	<option value="qxz">请选择电站</option>
		 </select>
		 <div  class="fl w90 ml15" id="check_area" style="min-height: 220px;border: 1px solid #ccc;margin-top: 10px;position: relative;">
		 	<div class="pl8 pr8 pt10">
		 		<div id="pswcheck" class="check_yw_pws">
		 			<!-- <div class="pws_table">
		 				<em>场站A场站A场站A场站A场站A<i>X</i></em><input  >
		 			</div> -->
		 		</div>
		 		<div class="tc cler mt10 " >
					<button class="popbut" onclick="reload()">重置</button>
					<button class="popbut" onclick="return createLx();">生成路线</button>
				</div>
		 	</div>
		 </div>
	</div>
	<div class="tc popbutbox cler mt15">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="return insert()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4&ak=spS1jTrhDurkl3nOFkx5YcgMMfXbWalP"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<%-- <script type="text/javascript" src="<%=basePath%>js/checkCom.js?pubVersion=201802070001"></script> --%>
<script type="text/javascript" src="<%=basePath%>js/checkLxCom.js?pubVersion=201802070001"></script>
<Script>
$(function(){
	
	//设置地图宽高
	var Screenheight  = (document.documentElement.clientHeight);  
	//设置地图高
	Screenheight = Screenheight - 120;
		
	$("#map").css("height",Screenheight);
	
	$("#check_area").css("height",Screenheight-175);
	$("#pswcheck").css("height",Screenheight-230);
	 
	
	getCompanyOne();
	map_init();
	
	  
})

var isSave = 0 ;

var markerArr = [];
//全局变量
var longitude=116.3;
var latitude=39.9;

 
/**
 * isLuXian 标识  不传为默认加载地图   1代表加载标注点数据   2代表加载路线数据
 *  comId  公司id 只有isLuXian为1时才会传，是三级公司的id
 */
function map_init(isLuXian,comId){
	// 百度地图API功能
	var map = new BMap.Map("map");
	map.centerAndZoom(new BMap.Point(118.454, 32.955), 6);
	map.enableScrollWheelZoom();
	
	//存放标注点经纬信息的数组
	var point = new Array(); 
	//存放提示信息窗口对象的数组
	info = new Array();
	//设置地图标注点 
	var marker = new Array(); 
 	 
	markerArr = [];
	if(isLuXian && isLuXian == 1){
		//组装数据
		for (var i = 0; i < userComData.length; i++) {
			 var comOne  = userComData[i];
			 for (var j = 0; j < comOne.twoComLst.length; j++) {
				 var comTwo  = comOne.twoComLst[j];
				 for (var k = 0; k < comTwo.thrComLst.length; k++) {
					 var comThree  = comTwo.thrComLst[k];
					 if(comThree.id == comId){
						 for (var l = 0; l < comThree.pwsInfLst.length; l++) {
							 var pwsThree  = comThree.pwsInfLst[l];
							 var oneMarker = {
									id : pwsThree.id,
									point : pwsThree.pws_lon+','+pwsThree.pws_lat ,
									type : 1 ,
									pos: pwsThree.pro_nam+pwsThree.cit_nam+pwsThree.are_nam+pwsThree.pws_add,
									comName : comThree.com_nam,
									state : pwsThree.cur_sta,
									remark : pwsThree.rem,
									name : pwsThree.pws_nam
							};
							markerArr.push(oneMarker);
						 }
					 }
				 }
			 }
		}
		
		//图标
		var myIcon1 = new BMap.Icon("<%=basePath %>images/zc11.png", new BMap.Size(35, 45));
		var myIcon2 = new BMap.Icon("<%=basePath %>images/gz11.png", new BMap.Size(35, 45));
		var myIcon3 = new BMap.Icon("<%=basePath %>images/wfz11.png", new BMap.Size(35, 45));
		
		var opts = {
			width:200,
			height : 20,
			enableMessage : false,
			enableCloseOnClick : false
		}
		for (var i = 0; i < markerArr.length; i++) {
			var p0 = markerArr[i].point.split(",")[0]; //
			var p1 = markerArr[i].point.split(",")[1]; //按照原数组的point格式将地图点坐标的经纬度分别提出来
			point[i] = new window.BMap.Point(p0, p1); //循环生成新的地图点
			 
			if(markerArr[i].state == 1){
				marker[i] = new window.BMap.Marker(point[i], {
				
						  icon : myIcon1
				});
			}else if(markerArr[i].state == 2){
				marker[i] = new window.BMap.Marker(point[i], {
						  icon : myIcon3
				});
			}else if(markerArr[i].state == 3){
				marker[i] = new window.BMap.Marker(point[i], {
						  icon : myIcon2
				});
			}
			
			
			var infoStr = '<div style="height: 40px;width:200px;">'+
							'<div style="width:100%;">'+
								'<span>'+markerArr[i].name+'</span>'+
							'</div>'+
							'</div>'
	
			info[i] = new window.BMap.InfoWindow(infoStr,opts);
							
			bindMapClick2(marker[i],info[i]);				
			
			
			//按照地图点坐标生成标记
			map.addOverlay(marker[i]);
			
 		} 
		 
		//让所有点在视野范围内
		map.setViewport(point);
		
	} else 
	if(isLuXian && isLuXian == 2){
		for (var ii = 0; ii < checkPsw.length; ii++) {
			var checkPwsId = checkPsw[ii];
			for (var i = 0; i < userComData.length; i++) {
				 var comOne  = userComData[i];
				 for (var j = 0; j < comOne.twoComLst.length; j++) {
					 var comTwo  = comOne.twoComLst[j];
					 for (var k = 0; k < comTwo.thrComLst.length; k++) {
						 var comThree  = comTwo.thrComLst[k];
						 for (var l = 0; l < comThree.pwsInfLst.length; l++) {
							 var pwsThree  = comThree.pwsInfLst[l];
							 if(pwsThree.id == checkPwsId){
								 var oneMarker = {
										id : pwsThree.id,
										point : pwsThree.pws_lon+','+pwsThree.pws_lat ,
										type : 1 ,
										pos: pwsThree.pro_nam+pwsThree.cit_nam+pwsThree.are_nam+pwsThree.pws_add,
										comName : comThree.com_nam,
										state : pwsThree.cur_sta,
										remark : pwsThree.rem,
										name : pwsThree.pws_nam
								};
								markerArr.push(oneMarker);
							 }
						 }
					 }
				 }
			}
		}
		
		for (var i = 0; i < markerArr.length; i++) {
				var p0 = markerArr[i].point.split(",")[0]; //
				var p1 = markerArr[i].point.split(",")[1]; //按照原数组的point格式将地图点坐标的经纬度分别提出来
				point[i] = new window.BMap.Point(p0, p1); //循环生成新的地图点
	 	}
		
		//让所有点在视野范围内
		map.setViewport(point);
		if(point.length > 1){
			
		}
		var curve = new BMapLib.CurveLine(point, {strokeColor:"blue", strokeWeight:3, strokeOpacity:0.5}); //创建弧线对象
		
		map.addOverlay(curve); //添加到地图中
		
	}else {
		point = [];
		//让所有点在视野范围内
		map.setViewport(point);
	}
	
}


function bindMapClick2(markerT,info){
	markerT.addEventListener("click", function() {
		markerT.openInfoWindow(info);
	});
}


function checkPws(id){
	if(id != "qxz" && id != undefined){
		if($.inArray(id+"", checkPsw) < 0){
			 addToCheck(id);
		 } 
	}
}
	
var checkPsw = new Array();
var markerArr  = new Array();



/*添加到已选电站*/
function addToCheck(id){
	var numval = (checkPsw.length+1);
	var name  = $("#companyPws option:selected").text();
	if(name.length > 23){
		name = name.substring(0,23)+'...';
	}
	var h = '<div class="pws_table"><em>'+name+'<i id="checkPsw_'+id+'" name="'+name+'">X</i></em><input placeholder="排序号" type="" class="pxh" value="'+numval+'"></div>';
	$("#pswcheck").append(h);
	checkPsw.push(id);
	
	$("#pswcheck").find("em").find("i").unbind('click').click(function(){
		var idt = $(this).attr("id");
		var id = idt.split("checkPsw_")[1];
		delToCheck(id);
	});
	
	$("#pswcheck").find("input").on("blur",function(){
		 var a =  this ;
		 if($(a).val() !='' ){
			 var co = 0 ;
			 $.each($("#pswcheck").find("input"),function(index,va){
				 if($(a).val() == $(va).val()){
					 co++;
				 }
			 })
			 if(co > 1){
				 layer.alert("请不要添加重复的排序号");
			 }
		 }
		
	});
	 
	
	$("input[class=pxh]").keydown(function(){
		this.value=this.value.replace(/\D/g,'')
   })
	  
   $("input[class=pxh]").keyup(function(){
	   this.value=this.value.replace(/\D/g,'')
   })
   
   $("input[class=pxh]").afterpaste(function(){
	   this.value=this.value.replace(/\D/g,'')
   })
	 
}

/*删除已选电站*/
function delToCheck(id){
	$("#checkPsw_"+id).parent().parent().remove();
	checkPsw.splice($.inArray(id+"", checkPsw), 1);
}


//生成路线
function createLx(){
	if($("#pswcheck").find("input").length > 0){
		var v = 0 ;
		var typ = 0 ;
		var checkPswNum = new Array();
		 
		$.each($("#pswcheck").find("input"),function(index,va){
			if($(va).val() == ''){
				v++;
			}else {
				if($.inArray($(va).val(), checkPswNum) > -1 ){
					typ++;
					return;
				}else{
					checkPswNum.push($(va).val());
				}
			}
		})
		if(v > 0 ){
			layer.alert('请检查排序号是否填写完全');
			return;
		}
		 
		if(typ > 0 ){
			layer.alert('请不要添加重复的排序号');
			return;
		}
		
		layer.confirm("确定生成路线？",function(){
			//为了点击一个路线时，地图消失看不见的情况
			if($("#pswcheck").find("input").length < 2){
				map_init();
			}else{
				map_init(2);
			}
			isSave++;
			//需要组装待保存的数据
			pws_id_save = '';
			sort_save = '';
			$("#pswcheck .pws_table").each(function(index,one){
				var a  = this; 
				var idt = $(a).find("em").find("i").attr("id");
				var numt = $(a).find("input").val();
				var id = idt.split("checkPsw_")[1];
				pws_id_save += id + "-" ;
				sort_save += numt + "-" ;
			})
			console.log("电站id="+pws_id_save);
			console.log("电站排序="+sort_save);
			
			layer.alert("生成成功,需要点击下方的确定按钮保存");
		})
	}else{
		layer.alert("请先选择电站");
	}
	
	 
}
	
//电站id
var pws_id_save = "";
//排序号
var sort_save = "";


function insert(){
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
	
	 
	if(isSave > 0 ){

		 if(pws_id_save == ''){
			 layer.alert("请选择巡视电站");
			 return ;
		 } 
		 
		 var  user_id = parseInt($("#userId").val());
		 var  route_name = $("#route_name").val();
		 
		 var pws_id = pws_id_save.substring(0,pws_id_save.length-1);
		 console.log("pws_id="+pws_id);
		 //站名顺序
		 var route_sort =sort_save.substring(0,sort_save.length-1);
		 console.log("route_sort="+route_sort);
	 
		 var lxType = $("#lxType").val();
		 
		 layer.confirm("确定保存？",function(){
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			 $.ajax({
		    	url:url+"insertRouteOrOverhaul.htm",
		    	data:"use_id="+user_id+"&type="+lxType+"&route_name="+route_name+"&pws_id="+pws_id+"&sort="+route_sort,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer); //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			layer.alert("保存成功");
		            	$(".cancle").click();
		            	window.parent.getData();
					} else {
		               layer.alert(data.desc);
					}
		    	}
			});
		 })
	}else{
		layer.alert("请点击生成路线");
	}
	
}
function reload(){
	window.location.reload();
}
</Script>
</body>
</html>
