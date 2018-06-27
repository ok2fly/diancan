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
	<body class="pl8t0 bgfc">
		<input type="hidden" id="pws_id" value="${pws_id}">
		<input type="hidden" id="app_typ_id" value="${app_typ_id}"> 
		<input type="hidden" id="equNum" value="${equNum}"> 

		<div class="dc-center">
			<div class="ene-equ bor-radius">
				<div class="a44"><p>工作状态</p></div>
				<div class="b1 borRight">
						<img src="<%=basePath %>img/jkicon.png" />
					<div class="b3">
						<p>健康状态</p>
						<h1 id="healthStat" style="margin-top: 35px;">--</h1>
					</div>
				</div>
				<div class="b1">
					<img src="<%=basePath %>img/sbyxicon.png" />
					<div class="b3">
						<p>设备状态</p>
						<h1 id="stat" style="margin-top: 35px;">--</h1>
					</div>
				</div>
			</div>
			<div class="ene-table2 bor-radius fr" style="margin-top:16px;">
				<div class="a44"><p>环境信息</p></div>
				<div class="box1 fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/wd.png"  width="50px"/>
						<div class="box-test">
							<p>环境温度(°c)</p>						
							<h1 id="temp">0</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/sd.png"  width="50px"/>
						<div class="box-test">
						<p>环境湿度(%)</p>						
						<h1 id="humi">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box1 fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/byqwd.png"  width="50px"/>
						<div class="box-test">
						<p>组件温度(°c)</p>						
						<h1 id="tempPV">0</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/fs.png"  width="50px"/>
						<div class="box-test">
							<p>风速(m/s)</p>						
							<h1 id="windSpeed">0级</h1>
						</div>
					</div>
				</div>
				<div class="box1 fl">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/fx.png"  width="50px"/>
						<div class="box-test">
							<p>风向</p>						
							<h1 id="windDir">无</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/dqyl.png"  width="50px"/>
						<div class="box-test">
						<p>大气压力(hPa)</p>						
						<h1 id="air">0.00</h1>
						</div>
					</div>
				</div>
			</div>
			<div class="ene-table2 bor-radius fl" style="margin-top:16px;">
				<div class="a44"><p>光照信息</p></div>
				<div class="box fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/ssfs.png"   width="50px"/>
						<div class="box-test">
							<p>瞬时辐射(W/㎡)</p>						
							<h1 id="hgv">0.00</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/ssfs.png"   width="50px"/>
						<div class="box-test">
						<p>日辐射量(kWh/㎡)</p>						
						<h1 id="dayHg">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box fl" >
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/ssfs.png"   width="50px"/>
						<div class="box-test">
						<p>总辐射量(kWh/㎡)</p>						
						<h1 id="hg">0.00</h1>
						</div>
					</div>
					 
				</div>
			</div>
			<%-- <div class="ene-equ1 bor-radius">
				
				<div class="a44"><p>工作环境</p></div>
				<div class="b22">
					<div class="borRight" style="height:100%">
						<img src="<%=basePath %>img/wd.png" />
						<div class="b3">
							<p>环境温度(°c)</p>
							<h2 id="temp" style="margin-top: 35px;">0</h2>
						</div>	
					</div>
				</div>
				<div class="b22">
					<div class="borRight" style="height:100%">
						<img src="<%=basePath %>img/sd.png" />
						<div class="b3">
							<p>环境湿度(%)</p>
							<h2 id="humi" style="margin-top: 35px;">0</h2>
						</div>	
					</div>
				</div>
				<div class="b22">
						<img src="<%=basePath %>img/byqwd.png" />
						<div class="b3">
							<p>机内温度(°c)</p>
							<h2 id="tempPV" style="margin-top: 35px;">0</h2>
						</div>	
				</div>
			</div>
			<div class="ene-equ bor-radius">
				<div class="a44"><p>风力数据</p></div>
				<div class="b22">
					<div class="borRight" style="height:100%">
						<img src="<%=basePath %>img/fx.png" />
						<div class="b3">
							<p>风向</p>
							<h2 id="windDir" style="margin-top: 35px;">无</h2>
						</div>	
					</div>
				</div>
				<div class="b22">
					<div class="borRight" style="height:100%">
						<img src="<%=basePath %>img/fs.png" />
						<div class="b3">
							<p>风速(m/s)</p>
							<h2 id="windSpeed" style="margin-top: 35px;">0级</h2>
						</div>	
					</div>
				</div>
				<div class="b22">
					<img src="<%=basePath %>img/dqyl.png" />
					<div class="b3">
						<p>大气压力(hPa)</p>
						<h2 id="air" style="margin-top: 35px;">0.00</h2>
					</div>	
				</div>
			</div>
			<div class="ene-equ1 bor-radius">
				<div class="a44"><p>辐射数据</p></div>
				<div class="b22">
					<div class="borRight" style="height:100%">
						<img src="<%=basePath %>img/ssfs.png" />
						<div class="b3">
							<p>瞬时辐射(W/㎡)</p>
							<h2 id="htv" style="margin-top: 35px;">0.00</h2>
						</div>	
					</div>
				</div>
				<div class="b22">
					<div class="borRight" style="height:100%">
						<img src="<%=basePath %>img/ssfs.png" />
						<div class="b3">
							<p>日辐射量(kWh/㎡)</p>
							<h2 id="dayHg" style="margin-top: 35px;">0.00</h2>
						</div>	
					</div>
				</div>
				<div class="b22">
					<img src="<%=basePath %>img/ssfs.png" />
					<div class="b3">
						<p>总辐射量(kWh/㎡)</p>
						<h2 id="hg" style="margin-top: 35px;">0.00</h2>
					</div>	
				</div>
				
			</div> --%>
			<div class="dc-current bor-radius" >
				<div class="a44"><p>瞬时辐射</p></div>
				<div id="fsl" style="width:100%;height:274px;float:left;"></div>
			</div>
			<div class="dc-current bor-radius mb50" >
				<div class="a44"><p>风速风向</p></div>
				<div  id="fsfx"  style="width:100%;height:274px;float:left;"></div>
			</div>
		
		</div>
		<div class="dc-right">
			
			<div class="equipment bor-radius">
				<div class="a44"><p>设备信息</p></div>
				<div class="equ bortop matop12">
					<div class="dian1"></div>
					<div class="equ-text">
						<span>设备编号</span>
						<p id="equ_num">无</p>
					</div>
				</div>
				<div class="equ">
					<div class="dian1"></div>
					<div class="equ-text">
						<span>设备型号</span>
						<p id="app_mod">无</p>
					</div>
				</div>
				<div class="equ">
					<div class="dian1"></div>
					<div class="equ-text">
						<span>生产商</span>
						<p id="man_nam">无</p>
					</div>
				</div>
				<div class="equ">
					<div class="dian1"></div>
					<div class="equ-text">
						<span>额定容量</span>
						<p id="rtd_pow">无</p>
					</div>
				</div>
				<div class="equ">
					<div class="dian1"></div>
					<div class="equ-text">
						<span>投运日期</span>
						<p id="pur_tim">无</p>
					</div>
				</div>
			</div>
			<div class="protect bor-radius">
				<div class="a44"><p>保修概况</p></div>
				<div class="pro bortop matop12">
					<div class="dian1"></div>
					<div class="pro-text">
						<span>最后报修时间</span>
						<p id="end_time1">无</p>
					</div>
				</div>
				<div class="pro">
					<div class="dian1"></div>
					<div class="pro-text">
						<span>最后检修时间</span>
						<p id="end_time2">无</p>
					</div>
				</div>
				<div class="pro">
					<div class="dian1"></div>
					<div class="pro-text">
						<span>下次检修时间</span>
						<p id="next_time">无</p>
					</div>
				</div>
			</div>

			<input type="button" value="设备详情" class="xiangqing" onclick="xiangqing()">
		</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/echarts-3.6.0/dist/echarts.min.js?pubVersion=201802070001"></script>
<%-- <script src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script> --%>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/sb.js?pubVersion=201802070001"></script>

<script type="text/javascript">
$(function(){
	getEquNum();
	getReal();
})

function getEquNum(){
	var pws_id=$("#pws_id").val(); 
	var app_typ_id=$("#app_typ_id").val();
	$.ajax({
		url:url+"getEnvLstByPwsEquTyp.htm",
		type:"post",
		data:"pws_id="+pws_id+"&app_typ_id="+app_typ_id,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data.length > 0 ){
					var d = data.data[0];
					sessionStorage.setItem("environmentEquNum",d.equ_num);
					getEqu(d.equ_num);
					/* getRelFauLst(d.equ_num); */
					
					getRealFx(d.equ_num);
					getReal(d.equ_num);
					$("#equNum").val(d.equ_num);
					getIntEquOpeInf();
				}
			}else{
				layer.alert(data.desc);
			}
		}
	})
}
function getReal(equNum){
	var pws_id=$("#pws_id").val(); 
	var app_typ_id=$("#app_typ_id").val();
	$.ajax({
		url:url+"getEnvInfoNew.htm",
		type:"post",
		data:"pws_id="+pws_id+"&equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data){
					for(var i=0;i<data.data.length;i++){
						var t=data.data[i];
						if(t != undefined){
							var stat = t.stat == 0 ?"通讯中断": t.stat == 1 ? "正常运行" : "--";
							var healthStat = t.healthStat == 1 ? "优秀" : t.healthStat == 2 ? "良好":t.healthStat == 3 ? "中等":t.healthStat == 4 ? "差" : "--"   
		 					$("#healthStat").html(healthStat);
							$("#stat").html(stat);
							$("#humi").html(getFixedNum(t.humi));
							$("#temp").html(getFixInt(t.temp));
							$("#tempPV").html(getFixInt(t.tempPV));
							$("#windDir").html(t.windDirStr);
							$("#windSpeed").html(getFixedNum(t.windSpeed));
							$("#air").html(getFixedNum(t.air));
							$("#hgv").html(getFixedNum(t.hgv));
							$("#hg").html(getFixedNum(t.hg));
							$("#crtTim").html(getLocalDateAndTime(t.crtTim,6));
							$("#dayHg").html(getFixedNum(t.dayHg));
						}
						
					}
				}
				setChart(data.data);
			}else{
				layer.alert(data.desc);
			}
		}
	})
}
function getRealFx(equNum){
	$.ajax({
		url:url+"getEnvInfoNew24Hours.htm",
		type:"post",
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				setChartFsfx(data.data);
			}else{
				layer.alert(data.desc);
			}
		}
	})
}


function getEqu(equNum){
	
	$.ajax({
		url:url+"getEquInfByEquNum.htm",
		type:"post",
		data:"equ_num="+equNum,
		//data:"equ_num="+1,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var a=data.data[0];
				if(a != null){
					$("#rtd_pow").html(getFixedNum(a.rtd_pow)+"kW");
					$("#app_mod").html(getIsNull(a.app_mod));
					$("#man_nam").html(getIsNull(a.man_nam));
					$("#equ_num").html(getIsNull(a.equ_cod));
					$("#pur_tim").html(getIsNull(getLocalDateAndTime(a.ope_tim,2)));
				}else{
					$("#rtd_pow").html("无");
					$("#app_mod").html("无");
					$("#man_nam").html("无");
					$("#equ_num").html("无");
					$("#pur_tim").html("无");
				}
					
			}else{
	               layer.alert(data.desc);
			}
		}
	})
}

function setChart(data){
 	var xTime=[];
 	var hgv=[];
 	var htv=[];
 	if(data.length > 0 && data[0].envLst){
	 	for(var i=0;i<data[0].envLst.length;i++){
	 		var a=data[0].envLst[i];
	 		xTime.push(getLocalDateAndTime(a.tol_tim,6));
	 		hgv.push(getFixedNum5(a.hgv));
	 		htv.push(getFixedNum5(a.htv));
	 	}
 	}
 	var myChart = echarts.init(document.getElementById('fsl'), 'shine');
	option = {
			legend: {
		        data: ['水平面瞬时辐射','斜面瞬时辐射'],
		        top: 10,
		    },
			tooltip : {
				trigger : 'axis'
			},
			grid : {
				show : true,
				left : '80',
				top : '60',
				right : '80',
				bottom : '30'
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				boundaryGap : false,
				data : xTime
			} ],
			yAxis : {
				type : 'value',
				name : '瞬时辐射(W/㎡)',
				axisLabel : {
					formatter : '{value}'
				}, 
	            axisLine: {
	                lineStyle: {
	                    color: '#666'
	                }
	            },
	            splitLine: {
	                lineStyle: {
	                    color: '#ddd'
	                }
	            }
			},
			series : [ {
				name : '水平面瞬时辐射',
				type : 'line',
				smooth : true,
				data : hgv,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			},
			{
				name : '斜面瞬时辐射',
				type : 'line',
				smooth : true,
				data : htv,
				symbol : 'none',
				 itemStyle : {
					normal : {
						color : '#07CB47'
					}
				}  
			}

			]
		};

		myChart.setOption(option);
}

function setChartFsfx(data2){
 	var	rawData = {}   ;
  
 	/* if(data2.length > 0 && data2[0]){
 		rawData = data2[0] ; 
 	} */
	 
 	rawData = data2;
 	
	var myChart = echarts.init(document.getElementById('fsfx'), 'shine');

    var data = [] ; 
   	$.each(rawData, function (i,entry) {
    	 var fatp = [];
    	 if(entry.tol_tim != '' && entry.tol_tim != undefined && entry.windSpeed != '' && entry.windSpeed != undefined && entry.windDirNSEW != '' && entry.windDirNSEW != undefined){
	    		fatp.push(getLocalDateAndTime(entry.tol_tim,1));
	    		fatp.push(getFixedNum(entry.windSpeed));
	    		fatp.push(entry.windDirNSEW);
	    		data.push(fatp);
    	  }else{
	    		fatp.push(getLocalDateAndTime(entry.tol_tim,1));
	    		fatp.push("-");
	    		fatp.push("-");
	    		data.push(fatp);
    	  }
    });
 	if(data.length > 0 ){
 		var directionMap = {};
 	    echarts.util.each(
 	        [ 'N', 'NNW', 'NW', 'WNW','W', 'WSW', 'SW', 'SSW', 'S', 'SSE', 'SE', 'ESE' , 'E', 'ENE', 'NE', 'NNE' ],
 	        function (name, index) {
 	         
 	        	console.log(Math.PI / 8 * index);
 	            directionMap[name] = Math.PI / 8 * index;
 	        }
 	    );
 	    
 		 var dims = {
 	    		tol_tim: 0,
 		        windSpeed: 1,
 		        windDirNSEW: 2
 		    };
 		    var arrowSize = 20;
 		    var weatherIconSize = 45;

 		    function renderArrow(param, api) {
 		        var point = api.coord([
 		            api.value(dims.tol_tim),
 		            api.value(dims.windSpeed) 
 		        ]);
 		       console.log(point);
 		        return {
 		            type: 'image',
	 		        shape: {
 		               // pathData: 'M31 16l-15-15v9h-26v12h26v9z',
 		                x: -arrowSize / 2,
 		                y: -arrowSize / 2,
 		                width: arrowSize,
 		                height: arrowSize
 		            },
 		            rotation: directionMap[api.value(dims.windDirNSEW)],
 		            position:[ point[0]+10,point[1]+10 ],
 		            style: api.style({
 		            	image: '../../../images/fxb.png',
 		                stroke: '#fff',
 		                lineWidth: 1
 		            })  
 		        };
 		    }
 		 
 		    option = {
 		        title: {
 		            text: '', 
 		            left: 'center'
 		        },
 		        tooltip: {
 		            trigger: 'axis',
 		            formatter: function (params) {
 		                return [
 		                    params[0].value[dims.tol_tim],
 		                    '风速：' + params[0].value[dims.windSpeed],
 		                    '风向：' + params[0].value[dims.windDirNSEW]
 		                ].join('<br>');
 		            }
 		        },
 		        grid: {
 		        	show : true,
 					left : '80',
 					top : '60',
 					right : '80',
 					bottom : '50'
 		        },
 		        xAxis: {
 		            type: 'time', 
 		            splitLine: {
 		                lineStyle: {
 		                    color: '#ddd'
 		                }
 		            },
 		            splitNumber : data.length,
 		           axisLabel : {
 		        	   formatter : function(params){
 		        		   
 		        		  return getLocalDateAndTime(params,6); 
 		        		  //return '00:15'
 		        	   }
 		           }
 		        },
 		        yAxis: [{
 		            name: '风速', 
 		            axisLine: {
 		                lineStyle: {
 		                    color: '#666'
 		                }
 		            },
 		            splitLine: {
 		                lineStyle: {
 		                    color: '#ddd'
 		                }
 		            }
 		        },{
 		            axisLine: {show: false},
 		            axisTick: {show: false},
 		            axisLabel: {show: false},
 		            splitLine: {show: false}
 		        }], 
 		        series: [ {
 		            type: 'custom',
 		            renderItem: renderArrow,
 		            encode: {
 		                x: dims.tol_tim,
 		                y: dims.windSpeed
 		            },
 		            data: data,
 		            z: 10
 		        }, {
 		            type: 'line',
 		            symbol: 'none',
 		            encode: {
 		                x: dims.tol_tim,
 		                y: dims.windSpeed
 		            },
 		            areaStyle: {
 		                normal: {
 		                    color: {
 		                        type: 'linear',
 		                        x: 0,
 		                        y: 0,
 		                        x2: 0,
 		                        y2: 1,
 		                        colorStops: [{
 		                            offset: 0, color: 'rgba(88,160,253,1)'
 		                        }, {
 		                            offset: 0.5, color: 'rgba(88,160,253,0.7)'
 		                        }, {
 		                            offset: 1, color: 'rgba(88,160,253,0)'
 		                        }]
 		                    }
 		                }
 		            },
 		            lineStyle: {
 		                normal: {
 		                    color: '#aaa' 
 		                }
 		            },
 		            data: data,
 		            z: 1
 		        }]
 		    };
   	}else{
   		var xTime=[];
   	 	var hgv=[];
   	 	var htv=[];
   	 	if(data2.length > 0 && data2[0]){
	   	 	$.each(data2, function (i,entry) {
		       	 if(entry.tol_tim != '' && entry.tol_tim != undefined ){
	       			xTime.push(getLocalDateAndTime(entry.tol_tim,6));
	       			hgv.push("-");
	       			htv.push("-");
		       	  }
	       });
   	 	} 
   	 var myChart = echarts.init(document.getElementById('fsfx'), 'shine');
 	option = {
 			legend: {
 		        data: ['风速','风向'],
 		        top: 10,
 		    },
 			tooltip : {
 				trigger : 'axis'
 			},
 			grid : {
 				left : '80',
 				top : '60',
 				right : '80',
 				bottom : '30'
 			},
 			calculable : true,
 			xAxis : [ {
 				type : 'category',
 				boundaryGap : false,
 				data : xTime,
 				splitNumber : 5 ,
 				min : 0 ,
 				max  : 1 ,
 				splitArea  : true
 			} ],
 			yAxis : [{
 				type : 'value',
 				name : '风速(m/s)',
 				axisLabel : {
 				formatter : '{value}'
 				}
 			},{
 				type : 'value',
 				name : '风向',
 				axisLabel : {
 				formatter : '{value}'
 				}
 			}],
 			series : [ {
 				name : '风速',
 				type : 'line',
 				smooth : true,
 				data : hgv,
 				 symbol : 'none' ,
 					itemStyle : {
 						normal : {
 							color : '#EDB213'
 						}
 					}
 			},
 			{
 				name : '风向',
 				type : 'line',
 				smooth : true,
 				data : htv,
 				symbol : 'none',
 				yAxisIndex:1,
 				 itemStyle : {
 					normal : {
 						color : '#07CB47'
 					}
 				}  
 			}

 			]
 		};

   	}
	   
    myChart.setOption(option);
    
    
}

function getRight(id){
	$.ajax({
		url:url+"getEnvInfoNewById.htm",
		type:"post",
		dataType:"json",
		data:"id="+id,
		success:function(data){
			if(data.resultcode=="USR000"){
				 if(data.data){
    				 for(var i=0;i<data.data.length;i++){
    					 var d=data.data[i];
    					 /*设备信息*/
        				 $("#app_mod").html(d.app_mod);
        				 $("#rtd_pow").html(getFixedNum(d.rtd_pow)+"kW");
        				 $("#man_nam").html(d.man_nam);
        				 $("#pur_tim").html(getLocalDateAndTime(d.ope_tim,2));
        				 $("#equ_num").html(d.equ_cod);
        				 sessionStorage.setItem("environmentEquNum",d.equ_num);
    				 }
    			 }
			}else{
	            layer.alert(data.desc);
			}
		}
	})
	
}
 
function xiangqing(){
	var equNum=$("#equNum").val();
	
		layer.open({
			  type: 2,
			  skin: 'layer-class' ,
			  title:"设备详情",
			  shadeClose: false,
			  area: ['770px','450px'],
			  content: "<%=basePath%>/commens/zhjk/sb/xq/hjjcy.htm?equNum="+equNum   //iframe的url
		});
		
	
}
</script>		

</body>
</html>