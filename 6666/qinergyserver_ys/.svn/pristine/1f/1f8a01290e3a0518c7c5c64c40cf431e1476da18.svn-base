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
		<title>变压器</title>
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
	</head>
	<body class="pl8t0 bgfc">
		<input type = "hidden" value="${id}" name="" id="id">
		<input type = "hidden" value="${equNum}" name="" id="equNum">
		<div class="dc-center">
			<div class="ene-equ bor-radius">
				<div class="a44"><p>工作状态</p></div>
				<div class="b1 borRight" >
					<img src="<%=basePath %>img/jkicon.png" />
					<div class="b3">
						<p>健康状态</p>
						<h1 id="healthStat"  style="margin-top: 25px;">--</h1>
					</div>
				</div>
				<div class="b1"  >
					<img src="<%=basePath %>img/sbyxicon.png" />
					<div class="b3">
						<p>设备运行状态</p>
						<h1 id="stat"  style="margin-top: 25px;">--</h1>
					</div>
				</div>
			</div>
			<div class="sto-table bor-radius" id="rzs1"  >
				<div class="a4"><p>原编</p></div>
				<div class="sto1">
					<div class="borNoleft">
						<img src="<%=basePath %>img/byqwdicon.png" width="50px"/>
						<div class="a5">
							<p>温度(°c)</p>						
							<h2 id="temp1">0</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/dyicon.png" width="50px"/>
						<div class="a5">
							<p>电压(V)</p>						
							<h2 id="uab1">0.00</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/dlicon.png" width="50px"/>
						<div class="a5">
							<p>电流(A)</p>						
							<h2 id="ia1">0.00</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/glysicon.png" width="50px"/>
						<div class="a5">
							<p>功率因数</p>						
							<h2 id="pf1">0.000</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/plicon.png" width="50px"/>
						<div class="a5">
							<p>频率(Hz)</p>						
							<h2 id="freq1">0.00</h2>
						</div>
					</div>
				</div>
			</div>
			<div class="sto-table bor-radius" id="rzs2" style="display:none;">
				<div class="a4"><p>副编1</p></div>
				<div class="sto1">
					<div class="borNoleft">
						<img src="<%=basePath %>img/byqwdicon.png" width="50px"/>
						<div class="a5">
							<p>温度(°c)</p>						
							<h2 id="temp2">0</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/dyicon.png" width="50px"/>
						<div class="a5">
							<p>电压(V)</p>						
							<h2 id="uab2">0.00</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/dlicon.png" width="50px"/>
						<div class="a5">
							<p>电流(A)</p>						
							<h2 id="ia2">0.00</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/glysicon.png" width="50px"/>
						<div class="a5">
							<p>功率因数</p>						
							<h2 id="pf2">0.00</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/plicon.png" width="50px"/>
						<div class="a5">
							<p>频率(Hz)</p>						
							<h2 id="freq2">0.00</h2>
						</div>
					</div>
				</div>
			</div>
			 <div class="sto-table bor-radius" id="rzs3" style="display:none;">
					<div class="a4"><p>副编2</p></div>
					<div class="sto1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/byqwdicon.png" width="50px"/>
							<div class="a5">
								<p>温度(°c)</p>						
								<h2 id="temp3">0</h2>
							</div>
						</div>
					</div>
					<div class="sto1">
						<div class="borccc">
							<img src="<%=basePath %>img/dyicon.png" width="50px"/>
							<div class="a5">
								<p>电压(V)</p>						
								<h2 id="uab3">0.00</h2>
							</div>
						</div>
					</div>
					<div class="sto1">
						<div class="borccc">
							<img src="<%=basePath %>img/dlicon.png" width="50px"/>
							<div class="a5">
								<p>电流(A)</p>						
								<h2 id="ia3">0.00</h2>
							</div>
						</div>
					</div>
					<div class="sto1">
						<div class="borccc">
							<img src="<%=basePath %>img/glysicon.png" width="50px"/>
							<div class="a5">
								<p>功率因数</p>						
								<h2 id="pf3">0.000</h2>
							</div>
						</div>
					</div>
					<div class="sto1">
						<div class="borccc">
							<img src="<%=basePath %>img/plicon.png" width="50px"/>
							<div class="a5">
								<p>频率(Hz)</p>						
								<h2 id="freq3">0.00</h2>
							</div>
						</div>
					</div>
				</div>
			<div class="sto-foot11 bor-radius">
				<div class="a44"><p>温度</p></div>
				<div class="dydl" id="transf" ></div>
			</div>	
			<div class="sto-foot11 bor-radius">
				<div class="a44"><p>电压电流</p></div>
				<div class="dydl" id="transfDyDl"></div>
			</div>
			<div class="sto-foot11 bor-radius mb50" >
				<div class="a44"><p>有功无功</p></div>
				<div class="dydl" id="transfW"></div>
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

<script>
	$(function (){
 		var id=$("#id").val();
 		var equNum=$("#equNum").val();
 		getTransformer(equNum);
 		getEqu(equNum);
 		//getRelFauLst();
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

 	function getTransformer(equNum){
		$.ajax({
			url:url+"getTransfRealInf.htm",
			data:"equ_num="+equNum,
			dataType:"json",
			type:"post",
			success:function(data){
				if (data.resultcode=="USR000"){
					if(data.data.transfReal){
						var t=data.data.transfReal;
						 if(t){
							 
		    				 /*实时*/
		    				 var stat = t.stat == 0 ?"通讯中断": t.stat == 1 ? "正常运行" :t.stat == 2 ? "设备告警" : "--";
							 var healthStat = t.healthStat == 1 ? "优秀" :t.healthStat == 2 ? "良好" : t.healthStat == 3 ? "中等":t.healthStat == 4 ? "差" : "--";
							 $("#stat").html(stat);
		    				 $("#healthStat").html(healthStat);
		    				 /*告警*/
		    				 $("#faultCode").html(getIsNull(t.faultCode));
		    				 /*绕组数量*/
		    				 //$("#branchNum").html(t.branchNum);
		    				 
		    				 
		    				 if(t && t.branchNum > 2){
		    					 /*电压 电流 功率 频率*/
			    				 $("#temp1").html(getFixedNum(t.temp1));
			    				 $("#uab1").html(getFixedNum(t.uab1));
			    				 $("#ia1").html(getFixedNum(t.ia1));
			    				 $("#pf1").html(getFixedNum2(t.pf1));
			    				 $("#freq1").html(getFixedNum(t.freq1));
			    				 $("#uab2").html(getFixedNum(t.uab2));
			    				 $("#temp2").html(getFixedNum(t.temp2)); 
			    				 $("#ia2").html(getFixedNum(t.ia2));
			    				 $("#pf2").html(getFixedNum2(t.pf2));
			    				 $("#freq2").html(getFixedNum(t.freq2));
			    				 $("#temp3").html(getFixedNum(t.temp3)); 
			    				 $("#uab3").html(getFixedNum(t.uab3));
			    				 $("#ia3").html(getFixedNum(t.ia3));
			    				 $("#pf3").html(getFixedNum2(t.pf3));
			    				 $("#freq3").html(getFixedNum(t.freq3));
			    				 $("#rzs1").show();
			    				 $("#rzs2").show();
			    				 $("#rzs3").show();
		    				 }else if(t && t.branchNum == 1 ){
		    					 $("#temp1").html(getFixedNum(t.temp1));
			    				 $("#uab1").html(getFixedNum(t.uab1));
			    				 $("#ia1").html(getFixedNum(t.ia1));
			    				 $("#pf1").html(getFixedNum2(t.pf1));
			    				 $("#freq1").html(getFixedNum(t.freq1));
			    				 $("#rzs1").show();
			    				 $("#rzs2").hide();
			    				 $("#rzs3").hide();
		    				 }else if(t && t.branchNum == 2 ){
		    					 $("#temp1").html(getFixedNum(t.temp1));
			    				 $("#uab1").html(getFixedNum(t.uab1));
			    				 $("#ia1").html(getFixedNum(t.ia1));
			    				 $("#pf1").html(getFixedNum2(t.pf1));
			    				 $("#freq1").html(getFixedNum(t.freq1));
			    				 $("#temp2").html(getFixedNum(t.temp2)); 
			    				 $("#uab2").html(getFixedNum(t.uab2));
			    				 $("#ia2").html(getFixedNum(t.ia2));
			    				 $("#pf2").html(getFixedNum2(t.pf2));
			    				 $("#freq2").html(getFixedNum(t.freq2));
			    				 $("#rzs1").show();
			    				 $("#rzs2").show();
			    				 $("#rzs3").hide();
		    				 }
		    				 
						 }
					}
					if(t && t.branchNum > 0){
						setChart(data.data.transfRealList,t.branchNum);
						setChart1(data.data.transfRealList,t.branchNum);
						setChart3(data.data.transfRealList,t.branchNum);
					}else{
						setChartnoData(data.data.transfRealList);
						setChartnoData1(data.data.transfRealList);
						setChartnoData3(data.data.transfRealList);
					}				}else{
	               layer.alert(data.desc);
				}
			} 
		})
	}

 	function setChartnoData(chartData) {
 		var xTime = [];
		var ytemp1 = [];
		for (var i = 0; i < chartData.length; i++) {
			var one = chartData[i];
			xTime.push(getLocalDateAndTime(one.tol_tim, 6));
			ytemp1.push(getFixedNum5(one.temp1));
		}
 		var myChart = echarts.init(document.getElementById('transf'), 'shine');
		option = {
			tooltip : {
				trigger : 'axis'
			},
		 	legend: {
		        data: ['温度'],
		        top: 5,
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
			yAxis : [ {
				type : 'value',
				name : '温度(°C)',
				axisLabel : {
					formatter : '{value}'
				}
			} ],
			series : [{
				name : '温度',
				type : 'line',
				smooth : true,
				data : ytemp1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			}]
		};
		myChart.setOption(option);
 	}
 	
 	function setChartnoData1(dydl) {
 		var xTime = [];
		var yU1 = [];
		var yA1 = [];
		
		for (var i = 0; i < dydl.length; i++) {
			var d = dydl[i];
			xTime.push(getLocalDateAndTime(d.tol_tim, 6));
			yU1.push(getFixedNum5(d.ua1));
			yA1.push(getFixedNum5(d.ia1));
		}
		
 		var myChart = echarts.init(document.getElementById('transfDyDl'), 'shine');
		option = {
			tooltip : {
				trigger : 'axis'
			},
		 	legend: {
		        data: ['电压','电流'],
		        top: 5,
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
			yAxis : [{
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
			} ],
			series : [{
				name : '电压',
				type : 'line',
				smooth : true,
				data : yU1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			},{
				name : '电流',
				type : 'line',
				smooth : true,
				data : yA1,
				yAxisIndex:1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			}]
		};
		myChart.setOption(option);
 	}
 	
 	function setChartnoData3(wdata) {
 		var xTime = [];
		var yyW1 = [];

		var ywW1 = [];
		for (var i = 0; i < wdata.length; i++) {
			var d = wdata[i];
			xTime.push(getLocalDateAndTime(d.tol_tim, 6));
			/*有功*/
			yyW1.push(getFixedNum5(d.psum1));
			/*无功*/
			ywW1.push(getFixedNum5(d.qsum1));


		}
 		var myChart = echarts.init(document.getElementById('transfW'), 'shine');
		option = {
			tooltip : {
				trigger : 'axis'
			},
		 	legend: {
		        data: ['有功','无功'],
		        top: 5,
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
			series : [{
				name : '有功',
				type : 'line',
				smooth : true,
				data : [],
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			},{
				name : '无功',
				type : 'line',
				smooth : true,
				data : [],
				yAxisIndex:1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			}]
		};
		myChart.setOption(option);
 	}
 	
	function setChart(chartData,num) {

		var xTime = [];
		var ytemp1 = [];
		var ytemp2 = [];
		var ytemp3 = [];
		for (var i = 0; i < chartData.length; i++) {
			var one = chartData[i];
			xTime.push(getLocalDateAndTime(one.tol_tim, 6));
			ytemp1.push(getFixedNum5(one.temp1));
			ytemp2.push(getFixedNum5(one.temp2));
			ytemp3.push(getFixedNum5(one.temp3));
		}

		var myChart = echarts.init(document.getElementById('transf'), 'shine');
		option = {

			tooltip : {
				trigger : 'axis'
			},
		 	legend: {
		        data: [],
		        top: 5,
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
			yAxis : [ {
				type : 'value',
				name : '温度(°C)',
				axisLabel : {
					formatter : '{value}'
				}
			} ],
			series : []
		};
		if(num > 2){
			option.legend.data.push("温度1");
			option.legend.data.push("温度2");
			option.legend.data.push("温度3");
			option.series.push({
				name : '温度1',
				type : 'line',
				smooth : true,
				data : ytemp1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			});
			option.series.push({
				name : '温度2',
				type : 'line',
				smooth : true,
				data : ytemp2,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			});
			option.series.push({
				name : '温度3',
				type : 'line',
				smooth : true,
				data : ytemp3,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#FE784E'
						}
					}
			});
		}else if(num == 2){
			option.legend.data.push("温度1");
			option.legend.data.push("温度2");
			option.series.push({
				name : '温度1',
				type : 'line',
				smooth : true,
				data : ytemp1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			});
			option.series.push({
				name : '温度2',
				type : 'line',
				smooth : true,
				data : ytemp2,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			});
		}else if(num == 1){
			option.legend.data.push("温度1");
			option.series.push({
				name : '温度1',
				type : 'line',
				smooth : true,
				data : ytemp1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			});
		}
		myChart.setOption(option);
	}
	
	function setChart1(dydl,num) {

		var xTime = [];
		var yU1 = [];
		var yU2 = [];
		var yU3 = [];
		var yA1 = [];
		var yA2 = [];
		var yA3 = [];
		
		for (var i = 0; i < dydl.length; i++) {
			var d = dydl[i];
			xTime.push(getLocalDateAndTime(d.tol_tim, 6));
			yU1.push(getFixedNum5(d.uab1));
			yU2.push(getFixedNum5(d.uab2));
			yU3.push(getFixedNum5(d.uab3));
			yA1.push(getFixedNum5(d.ia1));
			yA2.push(getFixedNum5(d.ia2));
			yA3.push(getFixedNum5(d.ia3));
		}

		var myChart1 = echarts.init(document.getElementById('transfDyDl'), 'shine');
		option = {

			tooltip : {
				trigger : 'axis'
			},
			 legend: {
			        data: [],
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
		
			series : []
		};
		
		if(num > 2){
			option.legend.data.push("电压1");
			option.legend.data.push("电压2");
			option.legend.data.push("电压3");
			option.legend.data.push("电流1");
			option.legend.data.push("电流2");
			option.legend.data.push("电流3");
			option.series.push({
				name : '电压1',
				type : 'line',
				smooth : true,
				data : yU1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			});
			option.series.push({
				name : '电压2',
				type : 'line',
				smooth : true,
				data : yU2,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			});
			option.series.push({
				name : '电压3',
				type : 'line',
				smooth : true,
				data : yU3,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#FE784E'
						}
					}
			});
			option.series.push({
				name : '电流1',
				type : 'line',
				smooth : true,
				data : yA1,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#5FB0E3'
						}
					}
			});
			option.series.push({
				name : '电流2',
				type : 'line',
				smooth : true,
				data : yA2,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#7A057A'
						}
					}
			});
			option.series.push({
				name : '电流3',
				type : 'line',
				smooth : true,
				data : yA3,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#F4350D'
						}
					}
			});
		}else if(num == 2){
			option.legend.data.push("电压1");
			option.legend.data.push("电压2");
			option.legend.data.push("电流1");
			option.legend.data.push("电流2");
			option.series.push({
				name : '电压1',
				type : 'line',
				smooth : true,
				data : yU1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			});
			option.series.push({
				name : '电压2',
				type : 'line',
				smooth : true,
				data : yU2,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			});
			option.series.push({
				name : '电流1',
				type : 'line',
				smooth : true,
				data : yA1,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#FE784E'
						}
					}
			});
			option.series.push({
				name : '电流2',
				type : 'line',
				smooth : true,
				data : yA2,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#5FB0E3'
						}
					}
			});
		}else if(num == 1){
			option.legend.data.push("电压1");
			option.legend.data.push("电流1");
			option.series.push({
				name : '电压1',
				type : 'line',
				smooth : true,
				data : yU1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			});
			option.series.push({
				name : '电流1',
				type : 'line',
				smooth : true,
				data : yA1,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			});
		}
		
		myChart1.setOption(option);

	}
	
	
	function setChart3(wdata,num) {

		var xTime = [];
		var yyW1 = [];
		var yyW2 = [];
		var yyW3 = [];

		var ywW1 = [];
		var ywW2 = [];
		var ywW3 = [];
		for (var i = 0; i < wdata.length; i++) {
			var d = wdata[i];
			xTime.push(getLocalDateAndTime(d.tol_tim, 6));
			/*有功*/
			yyW1.push(getFixedNum5(d.psum1));
			yyW2.push(getFixedNum5(d.psum2));
			yyW3.push(getFixedNum5(d.psum3));
			/*无功*/
			ywW1.push(getFixedNum5(d.qsum1));
			ywW2.push(getFixedNum5(d.qsum2));
			ywW3.push(getFixedNum5(d.qsum3));


		}

		var myChart3 = echarts.init(document.getElementById('transfW'), 'shine');
		option = {

			tooltip : {
				trigger : 'axis'
			},
			 legend: {
			        data: [],
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
		
			series : [ ]
		};
		var maxVal = 0 ;
		for (var i = 0; i < wdata.length; i++) {
			var one = wdata[i];
			if(one.psum1 > maxVal){
				maxVal = one.psum1
			}
			if(one.psum2 > maxVal){
				maxVal = one.psum2
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
		
		if(num > 2){
			option.legend.data.push("有功1");
			option.legend.data.push("有功2");
			option.legend.data.push("有功3");
			option.legend.data.push("无功1");
			option.legend.data.push("无功2");
			option.legend.data.push("无功3");
			option.series.push({
				name : '有功1',
				type : 'line',
				smooth : true,
				data : yyW1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			});
			option.series.push({
				name : '有功2',
				type : 'line',
				smooth : true,
				data : yyW2,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			});
			option.series.push({
				name : '有功3',
				type : 'line',
				smooth : true,
				data : yyW3,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#FE784E'
						}
					}
			});
			option.series.push({
				name : '无功1',
				type : 'line',
				smooth : true,
				data : ywW1,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#5FB0E3'
						}
					}
			});
			option.series.push({
				name : '无功2',
				type : 'line',
				smooth : true,
				data : ywW2,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#7A057A'
						}
					}
			});
			option.series.push({
				name : '无功3',
				type : 'line',
				smooth : true,
				data : ywW3,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#F4350D'
						}
					}
			});
		}else if(num == 2){
			option.legend.data.push("有功1");
			option.legend.data.push("有功2");
			option.legend.data.push("无功1");
			option.legend.data.push("无功2");
			option.series.push({
				name : '有功1',
				type : 'line',
				smooth : true,
				data : ywW1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			});
			option.series.push({
				name : '有功2',
				type : 'line',
				smooth : true,
				data : ywW2,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			});
			option.series.push({
				name : '无功1',
				type : 'line',
				smooth : true,
				data : ywW1,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#FE784E'
						}
					}
			});
			option.series.push({
				name : '无功2',
				type : 'line',
				smooth : true,
				data : ywW2,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#5FB0E3'
						}
					}
			});
		}else if(num == 1){
			option.legend.data.push("有功1");
			option.legend.data.push("无功1");
			option.series.push({
				name : '有功1',
				type : 'line',
				smooth : true,
				data : ywW1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			});
			option.series.push({
				name : '无功1',
				type : 'line',
				smooth : true,
				data : ywW1,
				yAxisIndex : 1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}
			});
		}
		
		myChart3.setOption(option);

	}
 
  
 	function xiangqing(){
		var equNum=$("#equNum").val();
		
			layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"设备详情",
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: "<%=basePath%>/commens/zhjk/sb/xq/byq.htm?equNum="+equNum   //iframe的url
			});
			
		
	}
</script>
	</body>
</html>
