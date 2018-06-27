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

</head>
<body >
<input type="hidden" id="ro_id" value="${user.rol_id}" >
<input type="hidden" id="userId" value="${user.id}" >
<input type="hidden" id="comId" value="${user.com_id}" >
<input type="hidden" id="use_typ" value="${user.use_typ}" >
<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
<input type="hidden" id="ipAdd" value="${ipAdd}" >
<div id="map"></div>
<div class="set_up">
  <div class="top-tit" style="position: relative;">
	<div class=" fl w25p" ><img style="padding-left: 75px; max-width: 175px;max-height: 55px; margin-top: 8px;" id="compLogo"></div>
	  <div class="fl w50p" style=" text-align: center;"><h1 style="font-size: 35px;"  class="system-name">智慧光伏平台</h1></div>
	  <div class="w25p" style="font-size:18px; width:30%; position: absolute; right: 0; ">
		<div id="weather" style="font-size:18px; width:350px; position: absolute; right: 30px; text-align: right;"></div>
		<div id="sj" style="font-size:18px; width:200px; position: absolute; right: 320px; "></div>
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
	<div class="w94p h70 fl mar10 rigbox" style="margin: 20px 3%;">
    <ul>
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
	</div>
</div>
</body>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
<script>

// 页面全局变量声明  开始
//---创建综合监控 图表实例 echart5 ---//
  var myChart5=echarts.init(document.getElementById('dzsl'),'shine');
//---创建综合监控 图表实例 echart5 ---//

//---创建电量趋势 电量效益提升实例 echart5 ---//
  var myChart55 = echarts.init(document.getElementById('dlxyts'),'shine');
//---创建电量趋势 电量效益提升实例 echart5 ---//

//---创建电量趋势 消缺率实例 echart5 ---//
  var myChart555 = echarts.init(document.getElementById('xqlChart'),'shine');

//---创建健康指数 消缺率曲实例 echart5 ---//
	var myChart66=echarts.init(document.getElementById('xql'),'shine');
//---创建健康指数 消缺率曲实例 echart5 ---//
//---创建电量趋势 消缺率实例 echart5 ---//

var map;
var interValOne ;
var timeInterval ;
var weatherInterval ;
var ipAdd = $("#ipAdd").val();
// console.log(ipAdd)

var last_dlqs = null; // 电量趋势上次数据
var last_zhsj = null; // 综合数据上次数据

var userComData = null;
var last_userComData = null;

var markerArr = [];
var last_markerArr = [];



//全局变量
// var longitude=116.3;
// var latitude=39.9;
var longitude = 108.292786;
var latitude = 36.81042;

//存放提示信息窗口对象的数组
var info = new Array();
//设置地图标注点
var marker = new Array();

//存放标注点经纬信息的数组
var point = new Array();
//存放提示信息窗口对象的数组
var info = new Array();
//设置地图标注点
var marker = new Array();

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
};
// 页面全局变量声明  结束

$(function(){

	$(window).resize(function() {
		window.location.reload();
	});

	getCompLog();

	showLocale();

	findWeather();

	map = create_map();

	loadTime();

	// map_init();
})


// 获取logo 图片 和 设置系统名字
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


// 显示日期和时间 年月日时分秒
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
  //清理内存
  str = null;
  colorhead = null;
  colorfoot = null;
  objD = null;
  yy = null;
  MM = null;
  dd = null;
  hh = null;
  mm = null;
  ss = null;
  ww = null;
  timeInterval = setTimeout(function(){showLocale()}, 1000);
}


// 显示天气
function findWeather() {

  if(weatherInterval != undefined){
    window.clearInterval(weatherInterval);
  }
  weatherInterval = null;

  var cityUrl = url + 'getCityByIp.htm?ip=' + ipAdd;

  $.get(cityUrl, function(data){
	  var cityNam = data.data;
	  // console.log(cityNam);
    $.ajax({
      url: jumpPageUrl +"commens/weather.htm",
      data: {
        city : cityNam
      },
      type:"post",
      success: function (data) {
        if(data.error == 0){
          var tq = data.results[0].weather_data[0].weather;
          var wd = data.results[0].weather_data[0].temperature;
          var f = data.results[0].weather_data[0].wind;
          var tq =   tq + "   " + wd + "   " + f  ;
          $('#weather').empty().html(tq);

          //清理内存
          tq = null;
          wd = null;
          f = null;
          data = null;
          cityNam = null;
        }
      }
    });
  });

  //清理内存
  cityUrl = null;
  weatherInterval = setTimeout(function(){findWeather()}, 60000*120);
}


// 综合数据和社会贡献  数据显示
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
          if (last_zhsj === null || d != last_zhsj) {
            var d  = data.data[0];
            var serData = [];
            serData.push({
              value:d.pwsOptCou,
              name:'已投运',
              itemStyle: {
                normal: {
                  color: '#FF5352'
                }
              }
            });
            serData.push({
              value: d.pwsConCou,
              name: '在建',
              itemStyle: {
                normal: {
                  color: '#EDB213'
                }
              }
            });
            serData.push({
              value: d.pwsPlaCou,
              name: '计划',
              itemStyle: {
                normal: {
                  color: '#00ABF7'
                }
              }
            });

          // 综合数据 饼图
            var zrl = getFixedNum5(((d.pwsOptCap)+(d.pwsConCap)+(d.pwsPlaCap))/1000);
            var zsl = (d.pwsOptCou)+(d.pwsConCou)+(d.pwsPlaCou);
            chart(serData,zrl,zsl);   // 综合数据面板里面饼图显示

            $("#tyrl").empty().html(getFixedNum5(d.pwsOptCap/1000)+"MW");
            $("#tysl").empty().html(d.pwsOptCou+"座电站");
            $("#zjrl").empty().html(getFixedNum5(d.pwsConCap/1000)+"MW");
            $("#zjsl").empty().html(d.pwsConCou+"座电站");
            $("#jhrl").empty().html(getFixedNum5(d.pwsPlaCap/1000)+"MW");
            $("#jhsl").empty().html(d.pwsPlaCou+"座电站");

          // 社会贡献
            $("#dxzs").empty().html(getFixedNum4(d.equPlaTre)+"<span>棵</span>");
            $("#eyht").empty().html(getFixedNum5(d.carDioEmiRed/1000)+"<span>吨</span>");
            $("#jybm").empty().html(getFixedNum5(d.staCoal/1000)+"<span>吨</span>");

          }

          // 清理内存
          serData = null;
          zrl = null;
          zsl = null;
          last_zhsj = d;
          d = null;
        }
      } else {
        layer.alert(data.desc);
      }
    }
  })
}


// 综合数据面板里面饼图显示
function chart(serData,zrl,zsl){

  // var myChart5=echarts.init(document.getElementById('dzsl'),'shine');
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
      left: '30',
      top: '0',
      right: '10',
      bottom: '0'
    },
    tooltip: {
      trigger: 'item',
      formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    calculable: true,
    series : [
      {
        name: '电站数量',
        type: 'pie',
        radius: ['61%', '71%'],
        itemStyle: {
          normal: {
            label: {
              show : true,
              textStyle : {
                fontSize : '18',
                fontWeight : 'bold'
              }
            },
            labelLine: {
              show: true
            }
          },
          emphasis: {
            label: {
              show: true,
              position: 'left',
              textStyle: {
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
  myChart5.setOption(option5);

  // 清理内存
  option5 = null;
}


// 创建地图
function create_map () {
  //设置地图宽高
  var Screenheight  = (document.documentElement.clientHeight);

  //设置地图高
  $("#map").css("height",Screenheight);

  // 百度地图API功能
  var map = new BMap.Map("map", {mapType:BMAP_HYBRID_MAP});    // 创建Map实例
  map.centerAndZoom(new BMap.Point(108.292786,36.81042), 5);  // 初始化地图,设置中心点坐标和地图级别
  map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
  map.enableScrollWheelZoom();     //开启鼠标滚轮缩放

  return map;
}


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


// 获取用户公司数据   为地图标注点 准备数据
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

        if (last_userComData === null || last_userComData != userComData) {
          map.clearOverlays();  //清楚老的标注点
          setCompanytwo();
          last_userComData = userComData;  // userComData 将会在setCompanyTwo 内用完后销毁
        }
      }
    },
    error : function(){

    }
  });

  // 清理内存
  userId = null;
  use_typ = null;
  slt_opt_sta = null;
}


// 组装标注点数组 markerArr
function setCompanytwo(){
  var val = userComData[0].id;
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
              // 清理内存
              oneMarker = null;
            }
            // 清理内存
            pwsThree = null;
          }
          // 清理内存
          l = null;
        }
        // 清理内存
        k = null;
        comThree = null;
      }
      // 清理内存
      j = null;
      comTwo = null;
    }
  }
  // 清理内存
  i = null;
  comOne = null;
  userComData = null;
  val = null;
  map_init();
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
			// console.log('haha');
			// console.log(data);

	  	if (data.resultcode=="USR000") {
	  		if(data.data  ){
	  		 	var d = data.data[0];
	  		 	if(d.equHealthRate){
	  		 		$("#sbjkzt").empty().html(d.equHealthSta);
	  		 	}

					if(d.equHealthSta){
   			 		$("#sbjkl").empty().html(getFixedNum(d.equHealthRate*100)+"%");
   			 	}
          d = null;
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
			// console.log('hehe');
			// console.log(data);
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
				if (data.data) {
					setChartYwzk(data.data);
				} else {
					layer.alert(data.desc);
				}
			}
		}
	})

	/*健康指数 缺陷数 消缺数 消缺率*/
	$.ajax({
		url:url+"getFstPagOptInf.htm",
		data : param,
		dataType:"json",
		type:"post",
		success:function(data){
			// console.log('hihi');
			// console.log(data);
			if (data.resultcode=="USR000") {
				if(data.data){
					var d  = data.data;
					$("#qxs").empty().html(d.defCou);
					$("#xqs").empty().html(d.elmDefCou);

					setChartXql(toDecimal(d.elmDefRate*100));  /*健康指数 消缺率*/
					d = null;
				}
			} else {
				layer.alert(data.desc);
			}
		}
	})
}

/*健康指数 消缺率*/
function setChartXql(d){
	var otherD = 100 - d ;
	// var myChart66=echarts.init(document.getElementById('xql'),'shine');
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
		var xD = '';
		if(d.tol_tim != '' && d.tol_tim != undefined && d.tol_tim != null  ){
			xD = d.tol_tim.indexOf("-") > -1 ? d.tol_tim.split("-")[1]+"月" : d.tol_tim ;
			xTime.push(xD);
			y1.push(d.pws_eff_asc_rate);
			y2.push(d.rid_rate);
		}
		d = null;
		xD = null;
	}
	// var myChart55 = echarts.init(document.getElementById('dlxyts'),'shine');
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
		series: {
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
	option55 = null;


	// var myChart555 = echarts.init(document.getElementById('xqlChart'),'shine');
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
		series: {
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
	option555 = null;

	xTime = null;
	y1 = null;
	y2 = null;
}

// 更新地图标注点
function map_init(){

  for (var i = 0; i < markerArr.length; i++) {
    var p0 = markerArr[i].point.split(",")[0]; //
    var p1 = markerArr[i].point.split(",")[1]; //按照原数组的point格式将地图点坐标的经纬度分别提出来
    point[i] = new window.BMap.Point(p0, p1); //循环生成新的地图点

    var type="";
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

      // 清理内存
      p0 = null;
      p1 = null;

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
      infoStr = null;
      imgH = null;
      // marker[i].openInfoWindow(info[i]);
    }
  }

  marker[0].openInfoWindow(info[0]);
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
  var markerT = null;
  mapInterval = setInterval(function(){
    if(cccount2 < marker.length ){
      markerT = null;
      markerT = marker[cccount2] ;
      markerT.openInfoWindow(info[cccount2]);
      cccount2++
    }else{
      cccount2 = 0;
    }
  },6000*5)
}

</script>
</html>
