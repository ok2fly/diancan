<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智慧能源运维管家</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/text.css?pubVersion=201802070001"/>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4&ak=spS1jTrhDurkl3nOFkx5YcgMMfXbWalP"></script>
<!-- <script type="text/javascript" src="http://api.map.baidu.com/library/TrafficControl/1.4/src/TrafficControl_min.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/TextIconOverlay/1.2/src/TextIconOverlay_min.js?pubVersion=201802070001"></script> -->

</head>
<body >
<input type="hidden" id="ro_id" value="${user.rol_id}" >
<input type="hidden" id="userId" value="${user.id}" >
<input type="hidden" id="comId" value="${user.com_id}" >
<input type="hidden" id="use_typ" value="${user.use_typ}" >
<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
<div id="map"></div>
<div class="set_up">
	<div class="top-tit">
		<div class=" fl w25p" ><img style="padding-left: 75px;  max-width: 175px;max-height: 55px;    MARGIN-TOP: 8px;"  id="compLogo"    ></div>
		<div class="fl w50p" style=" text-align: center;"><h1 style="font-size: 35px;"  class="system-name">智慧光伏平台</h1></div>
		<div class="fl w25p" style="font-size:18px;">
			<div  class="fl" style="width:55%;"  id="weather"></div>
			<div  class="fl" style="width:38%;"  id="sj"></div>
		</div>
	</div>
</div>
<div class="set_left1">
	<div class="botlt"></div>
	<div class="botlb"></div>
	<div class="botrt"></div>
	<div class="botrb"></div>
	<div class="top" style="margin-bottom:0;"><p>综合数据</p></div>
	<div class="w94 fl mar10 h190">
		<div class=" w100" style="height:220px;" id="dzsl">
		</div>
		<div  class="h160 w100  mainright-smail"  >
			<ul>
				<li class="" style="border:1px solid #FF5352;">
					<div class="ti" style="background:#FF5352;">
						 已投运
					</div>
					<div class="val" id="tyrl">260mw</div>
					<div class="val fr25" id="tysl">16个电站</div>
				</li>
				<li class="" style="border:1px solid #EDB213;" >
					<div class="ti" style="background:#EDB213;  ">
						 在建
					</div>
					<div class="val" id="zjrl">260mw</div>
					<div class="val fr25" id="zjsl">16个电站</div>
					</li>
				<li class="" style="border:1px solid #00ABF7;"  >
					<div class="ti" style="background:#00ABF7; ">
						 计划
					</div>
					<div class="val" id="jhrl">260mw</div>
					<div class="val fr25" id="jhsl">16个电站</div>
				</li>
			</ul>
		</div>
	</div>
</div>

<div class="set_right1">
	<div class="botlt"></div>
	<div class="botlb"></div>
	<div class="botrt"></div>
	<div class="botrb"></div>
	<div class="top"><p>运维状况</p></div>
	<!-- <div class="fl w22p h70p">图标</div>
	<div class="fl w75p h70p">
		<div class="top2 fl" style="text-align: center;">
			<p>合作伙伴数量</p>
		</div>
		<h3 style="text-align: center;">123</h3>
	</div> 
	<div class="fl w22p h70p">图标</div>
	<div class="fl w75p h70p">
		<div class="top2 fl">
			<p>运维人数</p>
		</div>
		<h3 style="text-align: center;">123</h3>
	</div>  -->
	<div class="w94p h70 fl mar10 rigbox" style="margin: 20px 3%;">
      	<ul >
  			<li>
  				<i class="i1"></i>
  				<a>合作伙伴数量</a>
				<b  id="hzhbsl">0</b><!-- <b>KWh</b> -->
  			</li>
  			<li>
  				<i class="i2"></i>
  				<a>运维人数</a>
  				<b id="ywrs">0</b>
  			</li>
   		</ul>
	</div>
	<div class="w94p h190 fl mar10" style="margin-bottom:0;margin-top: 0;">
		<div class="cha-top"><p>电量效益提升</p></div>
		<div class="w100 h140 fl" id="dlxyts"></div>
	</div>
	<div class="w94p h190 fl mar10" style="margin-bottom:0;margin-top:0;">
		<div class="cha-top"><p>消缺率</p></div>
		<div class="w100 h140 fl" id="xqlChart"></div>
	</div>
</div>
<div class="set_left2">
	<div class="botlt"></div>
	<div class="botlb"></div>
	<div class="botrt"></div>
	<div class="botrb"></div>
	<div class="top"><p>社会贡献</p></div>
	<div class="w94p h110 fl mar10 mt15 bg11">
		<div class="ky">二氧化碳减排</div>
		<div class="va" id="eyht">0<span>吨</span></div>
	</div>
	<div class="w94p h110 fl mar10 bg12">
		<div class="ky">等效植树</div>
		<div class="va" id="dxzs">0<span>吨</span></div>
	</div>
	<div class="w94p h110 fl mar10 bg13">
		<div class="ky">节约标准煤</div>
		<div class="va" id="jybm">0<span>吨</span></div>
	</div>
	<!-- <div class="w94p h110 fl mar10 bg14">
		<div class="ky">汽车节能减排</div>
		<div class="va">0<span>吨</span></div>
	</div> -->
</div>

<div class="set_right2">
	<div class="botlt"></div>
	<div class="botlb"></div>
	<div class="botrt"></div>
	<div class="botrb"></div>
	<div class="top"><p>健康指数</p></div>
	<div class="w94  h160 fl mar10">
		<div class="radius_box">
			<div class="fl w40 h120" id="xql">
			
			</div>
			<div class="fl w60 h110 rigbox3">
				<ul >
		  			<li style="margin-top:10px;border-bottom:1px solid #fff;">
		  				<i class="i1"></i>
		  				<a>缺陷数</a>
						<b  id="qxs" >0</b><!-- <b>KWh</b> -->
		  			</li>
		  			<li style="margin-top:15px;">
		  				<i class="i2"></i>
		  				<a>消缺数</a>
		  				<b id="xqs">0</b>
		  			</li>
		   		</ul>
			</div>
		</div>	
	</div>
	<div class="w100p fl mar10 h70 rigbox2 " >
		<ul >
  			<li>
  				<i class="i1"></i>
  				<a>设备健康状态</a>
				<b  id="sbjkzt" >良好</b><!-- <b>KWh</b> -->
  			</li>
  			<li>
  				<i class="i2"></i>
  				<a>设备健康率</a>
  				<b id="sbjkl">80%</b>
  			</li>
   		</ul>
		<!-- <div class="w50p h130 fl">
			<div class="top2"><p>设备健康状态</p></div>
			<h1 style="text-align: center;">良好</h1>
		</div>
		<div class="w50p h130 fl">
			<div class="top2"><p>设备健康率</p></div>
			<h1 style="text-align: center;">80%</h1>
		</div> -->
	</div>
</div>
</body>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
<script>

var interValOne ;
var timeInterval ;
var weatherInterval ;

$(function(){
	
	$(window).resize(function() {
		window.location.reload();
	});
	
	getCompLog();
	
	showLocale();
	
	findWeather();
	
	loadTime();
	
	
})


function loadTime(){
	
	if(interValOne != undefined){
		window.clearInterval(interValOne);
	}
	interValOne = null;
	
	getUseData();
	
	getDzData();
	
	getYwData();
	
	interValOne = setTimeout(function(){loadTime()},60000*15);
	
}


function showLocale() {
	
	if(timeInterval != undefined){
		window.clearInterval(timeInterval);
	}
	timeInterval = null;
	
    var str, colorhead, colorfoot;
    var objD = new Date();
    var yy = objD.getYear();
    if (yy < 1900) yy = yy + 1900;
    var MM = objD.getMonth() + 1;
    if (MM < 10) MM = '0' + MM;
    var dd = objD.getDate();
    if (dd < 10) dd = '0' + dd;
    var hh = objD.getHours();
    if (hh < 10) hh = '0' + hh;
    var mm = objD.getMinutes();
    if (mm < 10) mm = '0' + mm;
    var ss = objD.getSeconds();
    if (ss < 10) ss = '0' + ss;
    var ww = objD.getDay();
    if (ww == 0) colorhead = "";
    if (ww > 0 && ww < 6) colorhead = "";
    if (ww == 6) colorhead = "";
    if (ww == 0) ww = "星期日";
    if (ww == 1) ww = "星期一";
    if (ww == 2) ww = "星期二";
    if (ww == 3) ww = "星期三";
    if (ww == 4) ww = "星期四";
    if (ww == 5) ww = "星期五";
    if (ww == 6) ww = "星期六";
    colorfoot = ""
    str = colorhead + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss + " "  + colorfoot;
    $("#sj").html(str);
    
    timeInterval = setTimeout(function(){showLocale()}, 1000);	
} 
  
  

function findWeather() {
	
	if(weatherInterval != undefined){
		window.clearInterval(weatherInterval);
	}
	weatherInterval = null;
	
  	var cityUrl = 'http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js';
    $.getScript(cityUrl, function (script, textStatus, jqXHR) {
     	var citytq = remote_ip_info.city; // 获取城市
	
	    //var urlaa =  "http://www.sojson.com/open/api/weather/json.shtml?city="+citytq ;
	    $.ajax({
	        url: jumpPageUrl +"commens/weather.htm",
	       data : {
	      	 city : citytq
	       },
	        type:"post",
	        success: function (data) {
	      	  if(data.error == 0){
	      		  /* var tq = data.data.forecast[0].type ; 
	      		  var low  = data.data.forecast[0].low.substring(3,data.data.forecast[0].low.length);
	      		  var high  = data.data.forecast[0].high.substring(3,data.data.forecast[0].high.length);
	      		  var wd = low+"～"+high ; 
	      		  var f = data.data.forecast[0].fx+data.data.forecast[0].fl ;
	      		  var tq =   tq + "   " + wd + "   " + f  ; */
	      		  
	      		  var tq = data.results[0].weather_data[0].weather;
	      		  var wd = data.results[0].weather_data[0].temperature;
	      		  var f = data.results[0].weather_data[0].wind;
	      		  var tq =   tq + "   " + wd + "   " + f  ; 
	              $('#weather').empty().html(tq);
	      	  }
	        }
	     });  
   });
  
    weatherInterval = setTimeout(function(){findWeather()}, 60000*120);	
}


function getCompLog(){
	var  comId = $("#comId").val();
	$.ajax({
		url:url+"getComLogoImgById.htm",
		data : "id="+comId,
		success: function(datas){
			if (datas.data.length > 0 ) {
				var d = datas.data[0];
				var imgSrc = d.com_pic_thum;
				$("#compLogo").attr("src",imgSrc);
				$(".system-name").empty().html(d.com_pjt_nam);
			}
		},
		error : function(){
			
		}
	}); 
}


var userComData = null ; 
 
var markerArr = [];
function getUseData(){
	var userId = $("#userId").val(); 
	var use_typ = $("#use_typ").val(); 
	var slt_opt_sta = $("#slt_opt_sta").val(); 
	$.ajax({
		url:url+"getOrganizationHierarchyByUse.htm",
		data : "use_id="+userId+"&use_typ="+use_typ+"&slt_opt_sta="+slt_opt_sta,
		success: function(datas){
			if (datas.data.length > 0 ) {
				markerArr=[];
				userComData = null;
				userComData = datas.data ;
				setCompanytwo();
			}
		},
		error : function(){
			
		}
	}); 
}

function setCompanytwo(){
	var  val = userComData[0].id;
	for (var i = 0; i < userComData.length; i++) {
		 var comOne  = userComData[i];
		 if(comOne.id == val){
			 for (var j = 0; j < comOne.twoComLst.length; j++) {
				 var comTwo  = comOne.twoComLst[j];
				 for (var k = 0; k < comTwo.thrComLst.length; k++) {
					 var comThree  = comTwo.thrComLst[k];
					 //添加二级公司下三级公司的电站
					 for (var l = 0; l < comThree.pwsInfLst.length; l++) {
						 var oneMarker = {};
						 var pwsThree  = comThree.pwsInfLst[l];
						 if(pwsThree.pws_lon && pwsThree.pws_lat){
							 oneMarker = {
										id : pwsThree.id,
										point : pwsThree.pws_lon+','+pwsThree.pws_lat ,
										type : 1 ,
										pos: pwsThree.pro_nam+pwsThree.cit_nam+pwsThree.are_nam+pwsThree.pws_add,
										comName : comThree.com_nam,
										state : pwsThree.cur_sta,
										remark : pwsThree.rem,
										name : pwsThree.pws_nam,
										picS : pwsThree.pwsPicLst,
										typName : pwsThree.pws_typ_nam,
										rat_pow : getFixedNum(pwsThree.rat_pow)
								};
							 markerArr.push(oneMarker);
						 }
						 pwsThree = null;
						 oneMarker = null;
					 }
				 }
			 }
		 }
	}
	map_init();
}

function getDzData(){
	var userId = $("#userId").val();
	var param  = "use_id="+userId;
	$.ajax({
    	url:url+"getIntMonLeftSide.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data.length > 0 ){
    				 
    				 var d  = data.data[0];
    				 var serData = [];
    				 serData.push({
    					 value:d.pwsOptCou, 
    					 name:'已投运',
    					 itemStyle : {
   							normal : {
   						        color: '#FF5352' 
   						    }
   						} 
    				 });
    				 serData.push({
    					 value:d.pwsConCou, 
    					 name:'在建',
    					 itemStyle : {
   							normal : {
   						        color: '#EDB213' 
   						    }
   						}
    				 });
    				 serData.push({
    					 value:d.pwsPlaCou, 
    					 name:'计划',
    					 itemStyle : {
   							normal : {
   						        color: '#00ABF7' 
   						    }
   						} 
    				 });
    				 
    				 
    				 
    				 $("#tyrl").empty().html(getFixedNum5(d.pwsOptCap/1000)+"MW");
    				 $("#tysl").empty().html(d.pwsOptCou+"座电站");
    				 $("#zjrl").empty().html(getFixedNum5(d.pwsConCap/1000)+"MW");
    				 $("#zjsl").empty().html(d.pwsConCou+"座电站");
    				 $("#jhrl").empty().html(getFixedNum5(d.pwsPlaCap/1000)+"MW");
    				 $("#jhsl").empty().html(d.pwsPlaCou+"座电站");
    				 
    				 var zrl = getFixedNum5(((d.pwsOptCap)+(d.pwsConCap)+(d.pwsPlaCap))/1000);
    				 var zsl = (d.pwsOptCou)+(d.pwsConCou)+(d.pwsPlaCou);
    				 
    				 chart(serData,zrl,zsl);
    				 
    				 
    				 $("#dxzs").empty().html(getFixInt(d.equPlaTre)+"<span>棵</span>");
    				 $("#eyht").empty().html(getFixedNum(d.carDioEmiRed/1000)+"<span>吨</span>");
    				 $("#jybm").empty().html(getFixedNum(d.staCoal/1000)+"<span>吨</span>");
    			 } 
    			 
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}


 
function chart(serData,zrl,zsl){
	 
	var myChart5=echarts.init(document.getElementById('dzsl'),'shine');
	 var option5 = {
		 title: {
	        text: zsl+'座',
	        subtext: zrl+'MW',
	        x: 'center',
	        y: 'center',
	        itemGap: 20,
	        textStyle : {
	            color : 'rgba(255,255,255,0.8)',
	            fontFamily : '微软雅黑',
	            fontSize : 24,
	            fontWeight : 'bolder'
	        },
	        subtextStyle : {
	        	 fontSize : 20 
	        }
	    },
	    grid: {
	    	left : '30',
			top : '0',
			right : '10',
			bottom : '0'
        },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    calculable : true,
	    series : [
	        {
	            name:'电站数量',
	            type:'pie',
	            radius : ['61%', '71%'],
	            itemStyle : {
	                normal : {
	                    label : {
	                        show : true,
	                        textStyle : {
	                            fontSize : '18',
	                            fontWeight : 'bold'
	                        }
	                    },
	                    labelLine : {
	                        show : true
	                    }
	                },
	                emphasis : {
	                    label : {
	                        show : true,
	                        position : 'left',
	                        textStyle : {
	                            fontSize : '20',
	                            fontWeight : 'bold'
	                        }
	                    }
	                }
	            },
	            data:serData
	        }
	    ]
	};
	myChart5.clear();
	myChart5.setOption(option5);
	////////////////////////////////////////////////////////////
}

function getYwData(){
	
	var userId = $("#userId").val();
	var param  = "use_id="+userId;
	 $.ajax({
	    	url:url+"getEquHealthScor.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data  ){
	    			 	var d = data.data[0];
	    			 	if(d.equHealthRate){
	    			 		$("#sbjkzt").empty().html(d.equHealthSta);
	    			 	}
	    			 	
						if(d.equHealthSta){
	    			 		$("#sbjkl").empty().html(getFixedNum(d.equHealthRate*100)+"%");
	    			 	}
	    			 	 
					 } else {
		               layer.alert(data.desc);
					 }
	    		}
	    	}
	    })
	    
	 $.ajax({
    	url:url+"getOptComCouAndOptUseCouLst.htm",
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data  ){
    			 	var d = data.data[0];
    			 	if(d.optUseCou){
    			 		$("#ywrs").empty().html(getIsZero(d.optUseCou));
    			 	}
    			 	
					if(d.optComCou){
    			 		$("#hzhbsl").empty().html(getIsZero(d.optComCou));
    			 	}
    			 	 
				 } else {
	               layer.alert(data.desc);
				 }
    		}
    	}
    })
	    
    $.ajax({
    	url:url+"getPwsEffRidRateLst.htm", 
    	data : param ,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data  ){
					setChartYwzk(data.data);
				 } else {
	               layer.alert(data.desc);
				 }
    		}
    	}
    })
    
    
    $.ajax({
    	url:url+"getFstPagOptInf.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data  ){
    				 var d  = data.data;
    			 	$("#qxs").empty().html(d.defCou);
    			 	$("#xqs").empty().html(d.elmDefCou);
    			 	
    			 	setChartXql(toDecimal(d.elmDefRate*100));
    			 } 
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}

/*消缺率*/
function setChartXql(d){
	var otherD = 100 - d ;
	var myChart66=echarts.init(document.getElementById('xql'),'shine');
	var labelFromatter = {
	    normal : {
	        label : {
	            formatter : function (params){
	                return toDecimal(100 - toDecimal(params.value)) + '%'
	            },
	            textStyle: {
	                baseline : 'top'
	            }
	        }
	    },
	}
	var labelTop = {
	    normal : {
	    	color: '#00ECF4',
	        label : {
	            show : true,
	            position : 'center',
	            formatter : '{b}',
	            textStyle: {
	            	color: '#00ECF4',
	            	fontSize : '22',
	                baseline : 'bottom'
	            }
	        },
	        labelLine : {
	            show : false
	        }
	    }
	};
	var labelBottom = {
	    normal : {
	        color: '#0363A0',
	        label : {
	            show : true,
	            position : 'center',
	            textStyle: {
	            	color: '#fff',
	            	fontSize : '18',
	                baseline : 'bottom'
	            }
	        },
	        labelLine : {
	            show : false
	        }
	    },
	    emphasis: {
	        color: 'rgba(1,122,169,0.5)'
	    }
	};
	var radius = [50, 60];
	var option66 = { 
	    series : [
	        {
	            type : 'pie',
	            center : ['70px', '60px'],
	            radius : radius,
	            x: '0%', // for funnel
	            itemStyle : labelFromatter,
	            data : [
					{name:'消缺率', value:d,itemStyle : labelTop},
	                {name:'other', value:otherD, itemStyle : labelBottom}
	            ]
	        } 
	    ]
	};
	myChart66.clear();
	myChart66.setOption(option66);                 
}

/*运维状况*/
function setChartYwzk(data){
	var xTime=[];
	var y1=[];
	var y2=[];
	for(var i=0;i<data.length;i++){
		var d=data[i];
		var xD = d.tol_tim.indexOf("-") > -1 ? d.tol_tim.split("-")[1]+"月" : d.tol_tim ;
		xTime.push(xD);
		y1.push(d.pws_eff_asc_rate);
		y2.push(d.rid_rate);
	}
	var myChart55 = echarts.init(document.getElementById('dlxyts'),'shine');
	var option55 = {
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    }, 
	    grid: {
	    	left : '40',
			top : '30',
			right : '10',
			bottom : '20'
	        },
	    xAxis:  {
	        type: 'category',
	        data: xTime ,
	        axisLine :{
	        	show : true , 
				lineStyle : {
					color:'#fff'
				}
	        },
	        splitLine:{show: false}, 
	        splitArea : {show : false},//保留网格区域 */
	        axisTick :{
	        	show : true , 
				lineStyle : {
					color:'#fff'
				}
	        },
			axisLabel : {
				textStyle : {
					color : '#fff'
				}
			}
	    },
	    yAxis: {
	    	type : 'value',
			name : '提升率(%)',
			/* splitLine:{show: false},//去除网格线
	        splitArea : {show : true},//保留网格区域 */
			axisLabel : {
				formatter : '{value}',
				textStyle : {
					color : '#fff'
				}
			},
			axisLine :{
	        	show : true , 
				lineStyle : {
					color:'#fff'
				}
	        },
	        axisTick :{
	        	show : true , 
				lineStyle : {
					color:'#fff'
				}
	        },
			min : 0 ,
			max : 100
	    },
	    series: 
	    {
            name: '',
            type: 'line',
			smooth : true,
            data: y1,
            symbol : 'none',
			itemStyle : {
				normal : {
					color : '#EDB213'
				}
			} //后台传的数据
          } 
	    
	};
	myChart55.clear();   
	myChart55.setOption(option55);     
	
	
	var myChart555 = echarts.init(document.getElementById('xqlChart'),'shine');
	var option555 = {
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    }, 
	    grid: {
	    	left : '40',
			top : '30',
			right : '10',
			bottom : '20'
        },
	    xAxis:  {
	        type: 'category',
	        data: xTime ,
	        axisLine :{
	        	show : true , 
				lineStyle : {
					color:'#fff'
				}
	        },
	        axisTick :{
	        	show : true , 
				lineStyle : {
					color:'#fff'
				}
	        },
	        splitLine:{show: false}, 
	        splitArea : {show : false},//保留网格区域 */
			axisLabel : {
				textStyle : {
					color : '#fff'
				}
			}
	    },
	    yAxis: {
	    	type : 'value',
			name : '消缺率(%)',
			/* splitLine:{show: false},//去除网格线
			splitArea : {show : true},//保留网格区域 */
			axisLabel : {
				formatter : '{value}',
				textStyle : {
					color : '#fff'
				}
			},
			axisLine :{
	        	show : true , 
				lineStyle : {
					color:'#fff'
				}
	        },
	        axisTick :{
	        	show : true , 
				lineStyle : {
					color:'#fff'
				}
	        },
			min : 0 ,
			max : 100
	    },
	    series: 
	    {
            name: '',
            type: 'line',
			smooth : true,
            data: y2,
            symbol : 'none',
			itemStyle : {
				normal : {
					color : '#07CB47',
					
				}
			} //后台传的数据
          } 
	    
	};
	myChart555.clear();          
	myChart555.setOption(option555);  
}

	
//存放提示信息窗口对象的数组
var info = [];
//设置地图标注点 
var marker = []; 

function map_init(){
		 
	
	//设置地图宽高
	var Screenheight  = (document.documentElement.clientHeight);  
 
	//设置地图高
	$("#map").css("height",Screenheight);
	
	// 百度地图API功能
	var map = new BMap.Map("map", {mapType:BMAP_HYBRID_MAP});    // 创建Map实例
	map.centerAndZoom(new BMap.Point(108.292786,36.81042), 5);  // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
	map.enableScrollWheelZoom(false);     //开启鼠标滚轮缩放
		
	
	//存放标注点经纬信息的数组
	var point = new Array(); 
	//存放提示信息窗口对象的数组
	info = [];
	//设置地图标注点 
	marker =[]; 
	
 	//图标
	var myIcon1 = new BMap.Icon("<%=basePath %>images/1.png", new BMap.Size(36, 52)); //蓝
	var myIcon2 = new BMap.Icon("<%=basePath %>images/2.png", new BMap.Size(36, 52)); //红
	var myIcon3 = new BMap.Icon("<%=basePath %>images/13.png", new BMap.Size(36, 52));//黄
	//var myIcon1 = new BMap.Icon("<%=basePath %>images/gz1.png", new BMap.Size(36, 52));
	
	var opts = {
		width:300,
		height : 170,
		enableMessage : false,
		enableCloseOnClick : false
	}
	for (var i = 0; i < markerArr.length; i++) {
			var p0 = markerArr[i].point.split(",")[0]; //
			var p1 = markerArr[i].point.split(",")[1]; //按照原数组的point格式将地图点坐标的经纬度分别提出来
			point[i] = new window.BMap.Point(p0, p1); //循环生成新的地图点
			var type=""
			if(markerArr[i].type == 1){
				if(markerArr[i].state == 1){ //计划
					type = "计划";
					marker[i] = new window.BMap.Marker(point[i], {
					
							  icon : myIcon1
					});
				}else if(markerArr[i].state == 2){ //在建
					type = "在建";
					marker[i] = new window.BMap.Marker(point[i], {
							  icon : myIcon3
					});
				}else if(markerArr[i].state == 3){ //投运
					type = "投运";
					marker[i] = new window.BMap.Marker(point[i], {
							  icon : myIcon2
					});
				}
				
				//按照地图点坐标生成标记
				map.addOverlay(marker[i]);
				
				var imgH = '';
				if(markerArr[i].picS.length > 0 ){
					imgH = markerArr[i].picS[0].pic_url;
				}else{
					imgH = jumpPageUrl+"img/gf1.png";
				}
				var infoStr = '<div style="position:absolute;top:-8px;left:0;z-index:2;height: 180px;width:300px;">'+
					'<div class="mapbox-title">'+
						'<span>'+markerArr[i].name+'</span>'+
					'</div>'+
					'<div class="mapbox-subtitle">'+
						'<span><a  class="ad">地址：</a><a>'+markerArr[i].pos+'</a></span>'+
					'</div>'+
					'<div class="mapbox-info">'+
						'<div class="mapbox-st">'+
							'<span>类型：</span><span class="font-w">'+markerArr[i].typName+'</span>'+
						'</div>'+
					'</div>'+ 
					'<div class="cler">'+
					'</div>'+ 
					'<div class="mapbox-info">'+
						'<div class="mapbox-st" style="width:60%;">'+
							'<span>容量：</span><span  class="font-w">'+markerArr[i].rat_pow+'</span><span class="font-w">kW</span>'+
						'</div>'+
						'<div class="mapbox-st" style="width:40%;">'+
							'<span>状态：</span><span class="font-w">'+type+'</span>'+
						'</div>'+
					'</div>'+ 
					'<div class="cler">'+
					'</div>'+ 
					'<div class="mapbox-info" style="margin-top:2px">'+
						'<img style="width:100%;height:68px;" src="'+imgH+'">'+
					'</div>'+ 
				'</div>'
			
			info[i] = new window.BMap.InfoWindow(infoStr,opts);
			marker[i].openInfoWindow(info[i]);
			
			infoStr = null;
			
			/* info[i] =   new BMapLib.InfoBox(
			    map,
			    infoStr,
			    {
			        boxStyle:{background:"#fff",width: "300px",height:"170px"},
			        offset:new BMap.Size(0, 100),//此处貌似只能调整y的偏移
			        closeIconMargin: "10px 2px 0 0",
			        closeIconUrl:"",
			        enableAutoPan: true
			    }
			); */
		} 
 	}
	
	//让所有点在视野范围内
	//map.setViewport(point);
	
	//bindMapClick();
	bindMapClick2();
}

 
var mapInterval ;
var cccount2 = 0 ;
function bindMapClick2(){
	//var markerT = marker[cccount] ;
	//markerT.openInfoWindow(info[cccount]);
	
	if(mapInterval != undefined ){
		 window.clearInterval(mapInterval);
	}
	mapInterval = setInterval(function(){
		if(cccount2 < marker.length ){
			var markerT = marker[cccount2] ;
			markerT.openInfoWindow(info[cccount2]);
			cccount2++
		}else{
			cccount2 = 0;
		}
	},6000*5) 
}


function openWid(coun){
	if(coun < marker.length ){
		var markerT = marker[coun] ;
		markerT.openInfoWindow(info[coun]);
		coun++
	}else{
		coun = 0;
	}
	cccount2 = coun;
}
  


  
  
  
</script>
</html>