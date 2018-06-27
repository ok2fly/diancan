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
			<input type = "hidden" value="${id}" name="" id="id">
			<input type="hidden" id="equNum" value="${equNum}"> 
			
	
		<div class="dc-center">
			<div class="ene-equ bor-radius">
				
				<div class="a44"><p>工作状态</p></div>
				<div class="b1">
					<div class="borRight" style="height:100%">
						<img src="<%=basePath %>img/jkicon.png" />
						<div class="b3">
							<p>健康状态</p>
							<h1 id="healthStat" style="margin-top: 25px;">--</h1>
						</div>
					</div>
				</div>
				<div class="b1">
					<img src="<%=basePath %>img/sbyxicon.png" />
					<div class="b3">
						<p>设备状态</p>
						<h1 id="stat"  style="margin-top: 25px;">--</h1>
					</div>
				</div>
			</div>
			<div class="ene-table2 bor-radius fr" style="margin-top:16px;">
				<div class="a44"><p>工作信息</p></div>
				<div class="box1 fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath%>img/dyicon.png"  width="50px"/>
						<div class="box-test">
							<p>电压(V)</p>						
							<h1 id="ua">0.00</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/dlicon.png"  width="50px"/>
						<div class="box-test">
						<p>电流(A)</p>						
						<h1 id="ia">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box1 fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/yg.png"  width="50px"/>
						<div class="box-test">
						<p>有功功率(kW)</p>						
						<h1 id="psum">0.00</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/wg.png"  width="50px"/>
						<div class="box-test">
							<p>无功功率(kVar)</p>						
							<h1 id="qsum">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box1 fl">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/glysicon.png"  width="50px"/>
						<div class="box-test">
							<p>功率因数</p>						
							<h1 id="pf">0.000</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/plicon.png"  width="50px"/>
						<div class="box-test">
						<p>频率(Hz)</p>						
						<h1 id="freq">0.00</h1>
						</div>
					</div>
				</div>
			</div>
			<div class="ene-table2 bor-radius fl" style="margin-top:16px;">
				<div class="a44"><p>电度信息</p></div>
				<div class="box fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/yg.png"   width="50px"/>
						<div class="box-test">
							<p>正向有功电度(kWh)</p>						
							<h1 id="phi">0.00</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/wg.png"   width="50px"/>
						<div class="box-test">
							<p>正向无功电度(kVarh)</p>						
							<h1 id="qhi">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box fl" >
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/yg.png"   width="50px"/>
						<div class="box-test">
							<p>反向有功电度(kWh)</p>						
							<h1 id="phe">0.00</h1>
						</div>
					</div>
					<div class="box-box2"  >
						<img src="<%=basePath %>img/wg.png"   width="50px"/>
						<div class="box-test">
							<p>反向无功电度(kVarh)</p>						
							<h1 id="qhe">0.00</h1>
						</div>
					</div>
					 
				</div>
			</div>	
			<div class="dc-current bor-radius">
				<div class="a44"><p>电压电流</p></div>
				<div class="dydl" id="watch"></div>
				
			</div>
			<div class="dc-current bor-radius ">
				<div class="a44"><p>有功无功</p></div>
				<div class="ygwg" id="ygwg" style="height:264px;"></div>
			</div>
			<div class="dc-current bor-radius mb50">
				<div class="a44"><p>电度</p></div>
				<div class="zxfx" id="zxfx" style="height:264px;"></div>
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
<script src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>


<script >
$(function (){
		var id=$("#id").val();
		var equNum=$("#equNum").val();
		getWatch(equNum);
		getWatch2(equNum);
		getEqu(equNum);
	})

	
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
function getWatch(equNum){
	$.ajax({
		url:url+"getMeterRealInf.htm",
		data:"equ_num="+equNum,
		dataType:"json",
		type:"post",
		success:function(data){
			if (data.resultcode=="USR000"){
				if(data.data.meterReal){
					var real=data.data.meterReal;
					
					if(real!=null && real != undefined ){
						var stat = real.stat == 0 ?"通讯中断": real.stat == 1 ? "正常运行"  : "--";
						var healthStat = real.healthStat == 1 ? "优秀" : real.healthStat == 2 ? "良好":real.healthStat == 3 ? "中等":real.healthStat == 4 ? "差" : "--"   
						$("#stat").html(stat);
						$("#healthStat").html(healthStat);
						$("#ua").html(getFixedNum(real.uab));
						$("#ia").html(getFixedNum(real.ia));
						
						$("#freq").html(getFixedNum(real.freq));
						$("#pf").html(getFixedNum2(real.pf));
						$("#psum").html(getFixedNum(real.psum));
						$("#qsum").html(getFixedNum(real.qsum));
						
						$("#phi").html(getFixedNum(real.phi));
						$("#qhi").html(getFixedNum(real.qhi));
						$("#phe").html(getFixedNum(real.phe));
						$("#qhe").html(getFixedNum(real.qhe));
					}
				}
				
				setChart(data.data.meterRealList);
				setChart2(data.data.meterRealList);

			}else{
	               layer.alert(data.desc);
			}
		}
		
	})
}

function getWatch2(equNum){
	$.ajax({
		url:url+"getMeterRealListMonth.htm",
		data:"equ_num="+equNum,
		dataType:"json",
		type:"post",
		success:function(data){
			if (data.resultcode=="USR000"){
				
				setChart1(data.data);

			}else{
	               layer.alert(data.desc);
			}
		}
		
	})
}

function setChart(chartData) {

	var xTime = [];
	var yU = [];
	var yA = [];
	if(chartData != null){
		for (var i = 0; i < chartData.length; i++) {
			var one = chartData[i];
			if(one != null){
				xTime.push(getLocalDateAndTime(one.tol_tim, 6));
				yU.push(getFixedNum5(one.uab));
				yA.push(getFixedNum5(one.ia));
			}
			
		}
	}
	

	var myChart = echarts.init(document.getElementById('watch'), 'shine');
	option = {

		tooltip : {
			trigger : 'axis'
		},
		 legend: {
		        data: ['电压', '电流'],
		        top: 10,
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
			data : xTime
		} ],
		yAxis : [ 
		         {
						type : 'value',
						name : '电压(V)',
						axisLabel : {
						formatter : '{value}'
						}
					},
					{
						type : 'value',
						name : '电流(A)',
						axisLabel : {
						formatter : '{value}'
						}
					} 
		],
		series : [ {
			name : '电压',
			type : 'line',
			smooth : true,
			data : yU,
			 symbol : 'none' ,
				itemStyle : {
					normal : {
						color : '#EDB213'
					}
				}
		}, {
			name : '电流',
			type : 'line',
			smooth : true,
			yAxisIndex:1,
			data : yA,
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

function setChart2(chartData) {

	var xTime = [];
	var yU = [];
	var yA = [];
	if(chartData != null){
		for (var i = 0; i < chartData.length; i++) {
			var one = chartData[i];
			if(one != null){
				xTime.push(getLocalDateAndTime(one.tol_tim, 6));
				yU.push(getFixedNum5(one.psum));
				yA.push(getFixedNum5(one.qsum));
			}
		}
	}

	var myChart2 = echarts.init(document.getElementById('ygwg'), 'shine');
	option = {

		tooltip : {
			trigger : 'axis'
		},
		legend: {
		        data:['有功','无功'],
		    	top:10
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
			data : xTime
		} ],
		yAxis : [ 
		         {
						type : 'value',
						name : '有功(kW)',
						axisLabel : {
						formatter : '{value}'
						}
					},
					{
						type : 'value',
						name : '无功(kVar)',
						axisLabel : {
						formatter : '{value}'
						}
					} 
		],
		series : [ {
			name : '有功',
			type : 'line',
			smooth : true,
			data : yU,
			 symbol : 'none' ,
				itemStyle : {
					normal : {
						color : '#EDB213'
					}
				}
		}, {
			name : '无功',
			type : 'line',
			smooth : true,
			yAxisIndex:1,
			data : yA,
			symbol : 'none',
			 itemStyle : {
				normal : {
					color : '#07CB47'
				}
			}  
			
		}

		]
	};
	var maxVal = 0 ;
	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		if(one.psum > maxVal){
			maxVal = one.psum
		}
	}
	if(maxVal > 0 ){
		var maxV = getMaxVal(maxVal);
		option.yAxis[0].max = maxV;
		option.yAxis[0].min = -10;
		option.yAxis[1].max = maxV;
		option.yAxis[1].min = -10;
		option.xAxis[0].axisLine= { onZero : false };
	}
	myChart2.setOption(option);

}	

function setChart1(diandu) {

	var xTime = [];
	var yphi  = [];
	var yqhi  = [];
	var yphe  = [];
	var yqhe  = [];
	if(diandu != null){
		for (var i = 0; i < diandu.length; i++) {
			var d = diandu[i];
			if(d != null){
				xTime.push(getLocalDateAndTime(d.tol_tim, 10)+"日");
				yphi.push(getFixedNum5(d.phi));
				yqhi.push(getFixedNum5(d.phe));
				yphe.push(getFixedNum5(d.qhi));
				yqhe.push(getFixedNum5(d.qhe));
			}

		}
	}
	
	
	var myChart1 = echarts.init(document.getElementById('zxfx'), 'shine');
	option = {

		tooltip : {
			trigger : 'axis'
		},
		 legend: {
			  	data: ['正向有功电度', '反向有功电度','正向无功电度', '反向无功电度'],
		        top: 10,
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
			boundaryGap : true, //柱状图时此参数为true 折现时为false
			data : xTime
		} ],
		yAxis : [ 
		         {
					type : 'value',
					name : '有功电度(kWh)',
					axisLabel : {
					formatter : '{value}'
					}
				},{
					type : 'value',
					name : '无功电度(kVarh)',
					axisLabel : {
					formatter : '{value}'
					}
				}
		],
		series : [ {
			name : '正向有功电度',
			type : 'bar',
			smooth : true,
			data : yphi,
			 symbol : 'none' ,
				itemStyle : {
					normal : {
						color : '#EDB213'
					}
				}
		}, {
			name : '反向有功电度',
			type : 'bar',
			smooth : true,
			data : yphe,
			symbol : 'none',
			 itemStyle : {
				normal : {
					color : '#07CB47'
				}
			} 
		}, {
			name : '正向无功电度',
			type : 'bar',
			smooth : true,
			yAxisIndex : 1,
			data : yqhi,
			symbol : 'none',
			itemStyle : {
				normal : {
					color : '#5FB0E3'
				}
			}  
		}, {
			name : '反向无功电度',
			type : 'bar',
			smooth : true,
			yAxisIndex : 1,
			data : yqhe,
			symbol : 'none',
			itemStyle : {
				normal : {
					color : '#FE784E'
				}
			}  
		}

		]
	};

	myChart1.setOption(option);

}	

function xiangqing(){
	var equNum=$("#equNum").val();
	
		layer.open({
			  type: 2,
			  skin: 'layer-class' ,
			  title:"设备详情",
			  shadeClose: false,
			  area: ['770px','450px'],
			  content: "<%=basePath%>/commens/zhjk/sb/xq/db.htm?equNum="+equNum   //iframe的url
		});
		
	
}
</script>		
	</body>
</html>
