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
		<title>电能检测</title>
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
		
	</head>
<body class="pl8t0 bgfc">
<input type="hidden" id="equNum" value="${equNum}">

	<div class="dc-center">
		<div class="ene-equ bor-radius">
			<div class="a44" ><p>工作状态</p></div>
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
					<h1 id="stat" style="margin-top: 25px;">--</h1>
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
						<h1 id="pfa">0.000</h1>
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
		<%-- <div class="ene-equ1 bor-radius" >
			<div class="a44"><p>电压电流</p></div>
			<div class="b1">
				<div class="borRight" style="height:100%">
					<img src="<%=basePath %>img/dyicon.png" />
					<div class="b3">
						<p>电压(V)</p>
						<h2 id="ua" style="margin-top: 25px;">0.00</h2>
					</div>
				</div>
			</div>
			<div class="b1">
				<img src="<%=basePath %>img/dlicon.png" />
				<div class="b3">
					<p>电流(A)</p>
					<h2 id="ia" style="margin-top: 25px;">0.00</h2>
				</div>
			</div>
		</div>
		<div class="ene-table bor-radius">
			<div class="a4"><p>实时数据</p></div>
			<div class="box">
				
				<div class="box-box1">
					<div class="borNoleft">
						<img src="<%=basePath %>img/glysicon.png" width="50px"/>
						<div class="box-test">
						<p>功率因数</p>						
						<h1 id="pfa">0.000</h1>
						</div>
					</div>
				</div>
				<div class="box-box1">
					<div class="borleft">
						<img src="<%=basePath %>img/plicon.png" width="50px"/>
						<div class="box-test">
						<p>频率(Hz)</p>						
						<h1 id="freq">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box-box1">
					<div class="borleft">
						<img src="<%=basePath %>img/yg.png" width="50px"/>
						<div class="box-test">
						<p>有功功率(kW)</p>						
						<h1 id="psum">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box-box1">
					<div class="borleft">
						<img src="<%=basePath %>img/wg.png" width="50px"/>
						<div class="box-test">
						<p>无功功率(kW)</p>						
						<h1 id="qsum">0.00</h1>
						</div>
					</div>
				</div>
				
			</div>

		</div> --%>
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
		<%-- <div class="ene-table bor-radius">
			<div class="a4"><p>电度数据</p></div>
			<div class="box">
				
				<div class="box-box1">
					<div class="borNoleft">
						<img src="<%=basePath %>img/yg.png" width="50px"/>
						<div class="box-test">
						<p>有功电度(kWh)</p>						
						<h1 id="phi">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box-box1">
					<div class="borleft">
						<img src="<%=basePath %>img/wg.png" width="50px"/>
						<div class="box-test">
						<p>无功电度(kWh)</p>						
						<h1 id="qhi">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box-box1">
					<div class="borleft">
						<img src="<%=basePath %>img/yg.png" width="50px"/>
						<div class="box-test">
						<p>有功电度(kWh)</p>						
						<h1 id="phe">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box-box1">
					<div class="borleft">
						<img src="<%=basePath %>img/wg.png" width="50px"/>
						<div class="box-test">
						<p>无功电度(kWh)</p>						
						<h1 id="qhe">0.00</h1>
						</div>
					</div>
				</div>
				
			</div>

		</div>	 --%>	
		<div class="sto-foot11 bor-radius">
			<div class="a44"><p>电压电流</p>
			<div class="dydl" id="dydl"></div>
			</div>
		</div>
		<div class="sto-foot11 bor-radius">
			<div class="a44"><p>有功无功</p>
			<div class="dydl" id="w"></div>
			</div>
		</div>
		<div class="dc-current bor-radius" >
			<div class="a44"><p>电压谐波畸变率</p>
			<div class="dydl" id="ua50" ></div>
			</div>
		</div>
		<div class="dc-current bor-radius mb50">
			<div class="a44"><p>电流谐波畸变率</p>
			<div class="dydl" id="ub50"></div>
			</div>
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

<script type="text/javascript">		
$(function(){
	var equ_num=$("#equNum").val();
	$.ajax({
		url:url+"getIscsPqsmsInfByEquNumTopOne.htm",
		type:"post",
		data:"equ_num="+equ_num,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
					var d=data.data[0];
					if(d){
						var stat = d.stat == 0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "告警运行" :"--";
						$("#stat").html(stat);
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" : "--"   
						$("#healthStat").html(healthStat);
						$("#ia").html(getFixedNum(d.ia));
						$("#ua").html(getFixedNum(d.uab));
						$("#pfa").html(getFixedNum2(d.pf));
						$("#freq").html(getFixedNum(d.freq));
						$("#psum").html(getFixedNum(d.psum));
						$("#qsum").html(getFixedNum(d.qsum));
						$("#phi").html(getFixedNum(d.phi));
						$("#phe").html(getFixedNum(d.phe));
						$("#qhi").html(getFixedNum(d.qhi));
						$("#qhe").html(getFixedNum(d.qhe));
					}
			}else{
				layer.alert(data.desc);
			}
		}
	})
	
	$.ajax({
		url:url+"getIscsPqsmsUIPQsumCurves.htm",
		type:"post",
		data:"equ_num="+equ_num,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				for(var i=0;i<data.data.length;i++){
					var d=data.data[0];
				}
			}else{
				layer.alert(data.desc);
			}
			setChart1(data.data);
			
		}
	})
	
	$.ajax({
		url:url+"getIscsPqsmsThdUIABCHistogramLst.htm",
		type:"post",
		data:"equ_num="+equ_num,
		//data:"equ_num=370800030061",
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				setChart2(data.data);
			}else{
				layer.alert(data.desc);
			}
			
		}
	})
	
	$.ajax({
		url:url+"getEquInfByEquNum.htm",
		type:"post",
		data:"equ_num="+equ_num,
		//data:"equ_num=370800030061",
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
})



	function setChart1(data){
		var xTime=[];
		var ua=[];
		var ia=[];
		var psum=[];
		var qsum=[];
		for(var i=0;i<data.length;i++){
			var a=data[i];
			xTime.push(getLocalDateAndTime(a.tol_tim,6));
			ua.push(getFixedNum5(a.uab));
			ia.push(getFixedNum5(a.ia));
			psum.push(getFixedNum5(a.psum));
			qsum.push(getFixedNum5(a.qsum));
		}
		
 		var myChart1=echarts.init(document.getElementById('dydl'),'shine');
 		var myChart2=echarts.init(document.getElementById('w'),'shine');

 		option1 = {
 			    tooltip : {
 			        trigger: 'axis'
 			    },
 			   grid : {
					left : '80',
					top : '60',
					right : '80',
					bottom : '30'
				},
 			    calculable : true, 
 			    xAxis : [
 			        {
 			            type : 'category',
 			            data : xTime,
 			            splitLine:{show: false},
 				        axisLine:false 
 			        }
 			    ],
 			    yAxis : [
 			        {
 			            type : 'value',
 			            name : '电压(V)',
 			            axisLabel : {
 			                formatter: '{value}'
 			            }
 			        },
 			        {
 			            type : 'value',
 			            name : '电流(A)',
 			            axisLabel : {
 			                formatter: '{value}'
 			            }
 			        }
 			    ],
 			    legend: {
 			        data:['电流','电压'],
 			    	top:10
 			    },
 			    series : [{
 			            name:'电流',
 			            type:'line',
 			            yAxisIndex:1,
 			            data:ia,
 			           symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#EDB213'
 							}
 						}
 			        },
 			        {
 			            name:'电压',
 			            type:'line',
 			            data:ua,
 			           symbol : 'none',
 						 itemStyle : {
 							normal : {
 								color : '#07CB47'
 							}
 						}
 			        }
 			       
 			    ]
 			};
 		
 		  myChart1.setOption(option1);
 		
 		  option2 = {
  			    tooltip : {
  			        trigger: 'axis'
  			    },
  			  grid : {
					left : '80',
					top : '60',
					right : '80',
					bottom : '30'
				},
  			    calculable : true, 
  			    xAxis : [
  			        {
  			            type : 'category',
  			            data : xTime,
  			            splitLine:{show: false},
  				        axisLine:false 
  			        }
  			    ],
  			    yAxis : [
  			        {
  			            type : 'value',
  			            name : '有功(kW)',
  			            axisLabel : {
  			                formatter: '{value}'
  			            }
  			        },
  			       {
  			            type : 'value',
  			            name : '无功(kVar)',
  			            axisLabel : {
  			                formatter: '{value}'
  			            }
  			        }
  			    ],
  			    legend: {
			        data:['有功','无功'],
			        top:10
			    },
  			    series : [
  			        {
  			            name:'有功',
  			            type:'line',
  			            data:psum,
  			          symbol : 'none' ,
  					itemStyle : {
  						normal : {
  							color : '#EDB213'
  						}
  					}
  			        },
  			       {
  			            name:'无功',
  			            type:'line',
  			            yAxisIndex:1,
  			            data:qsum,
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
  		for (var i = 0; i < data.length; i++) {
  			var one = data[i];
  			if(one.psum > maxVal){
  				maxVal = one.psum
  			}
  		}
  		if(maxVal > 0 ){
  			var maxV = getMaxVal(maxVal);
  			option2.yAxis[0].max = maxV;
  			option2.yAxis[0].min = -10;
  			option2.yAxis[1].max = maxV;
  			option2.yAxis[1].min = -10;
  			option2.xAxis[0].axisLine= { onZero : false };
  		}
 		 myChart1.setOption(option1);
  		 myChart2.setOption(option2);
	}
	
	function setChart2(data){
		var xTime=[];
		
		var uaData  = [];
		var ubData  = [];
		var ucData  = [];
		var iaData  = [];
		var ibData  = [];
		var icData  = [];
		//加载第一个图表的数据，x轴以第一条数据的长度为准
		if(data.length > 0 ){
			for(var i=0;i<data[0].thduaLst.length;i++){
				var a=data[0].thduaLst[i];
				var xVal = a.key ;
				
				if(xVal && xVal.substring(5,xVal.length)){
					xTime.push(xVal.substring(5,xVal.length)+"次");
				}
				uaData.push(a.value);
				
				//以第一条数据的长度，新增其他数据的数据
				ubData.push(data[0].thdubLst[i].value);
				ucData.push(data[0].thducLst[i].value);
				
				iaData.push(data[0].thdiaLst[i].value);
				ibData.push(data[0].thdibLst[i].value);
				icData.push(data[0].thdicLst[i].value);
			}
			var myChart1=echarts.init(document.getElementById('ua50'),'shine');
	 		var myChart2=echarts.init(document.getElementById('ub50'),'shine');
	 		 
	 		option1 = {
	 				tooltip : {
	 					trigger : 'axis'
	 				},
	 				grid : {
	 					left : '80',
	 					top : '60',
	 					right : '80',
	 					bottom : '30'
	 				},
	 		       legend: {
				        data:['A相电压谐波畸变率',
				              'B相电压谐波畸变率',
				              'C相电压谐波畸变率'
				              ],
				        top:10
				    },
	 			    calculable : true, 
	 			    xAxis : [
	 			        {
	 			            type : 'category',
	 			            boundaryGap : true, //柱状图时此参数为true 折现时为false
	 			            data : xTime  
	 			        }
	 			    ],
	 			    yAxis : [
	 			        {
	 			            type : 'value',
	 			            name : '谐波畸变率(%)',
	 			            axisLabel : {
	 			                formatter: '{value}'
	 			            } 
	 			        }
	 			    ],
	 			    series : [{
	 					name : 'A相电压谐波畸变率',
	 					type : 'bar',
	 					barWidth : 3 ,
	 					data : uaData,
	 					symbol : 'none',
	 					itemStyle : {
	 						normal : {
	 							color : '#EDB213' 
	 	                    }
	 					}
	 			    },
	 			   {
	 					name : 'B相电压谐波畸变率',
	 					type : 'bar',
	 					barWidth : 3 ,
	 					data : ubData,
	 					symbol : 'none',
	 					itemStyle : {
	 						normal : {
	 							color : '#07CB47' 
	 	                    }
	 					}
	 			    },
	 			   {
	 					name : 'C相电压谐波畸变率',
	 					type : 'bar',
	 					barWidth : 3 ,
	 					data : ucData,
	 					symbol : 'none',
	 					itemStyle : {
	 						normal : {
	 							color : 'red' 
	 	                    }
	 					}
	 			    }]
	 			};
	 			option2 = {
 					tooltip : {
 						trigger : 'axis'
 					},
					grid : {
	 					left : '80',
	 					top : '60',
	 					right : '80',
	 					bottom : '30'
	 				},
	 		       legend: {
				        data:['A相电流谐波畸变率',
				              'B相电流谐波畸变率',
				              'C相电流谐波畸变率'
				              ],
				        top:10
				    },
	 			    xAxis : [
	 			        {
	 			            type : 'category',
	 			            boundaryGap : true, //柱状图时此参数为true 折现时为false
	 			            data : xTime 
	 			        }
	 			    ],
	 			    yAxis : [
						{
						     type : 'value',
						     name : '谐波畸变率(%)',
						     axisLabel : {
						         formatter: '{value}'
						     } 
						 }
	 			    ],
	 			    series : [{
	 					name : 'A相电流谐波畸变率',
	 					type : 'bar',
	 					barWidth : 3 ,
	 					data : iaData,
	 					symbol : 'none',
	 					itemStyle : {
	 						normal : {
	 							color : '#EDB213' 
	 	                    }
	 					}
	 			    },
	 			   {
	 					name : 'B相电流谐波畸变率',
	 					type : 'bar',
	 					barWidth : 3 ,
	 					data : ibData,
	 					symbol : 'none',
	 					itemStyle : {
	 						normal : {
	 							color : '#07CB47' 
	 	                    }
	 					}
	 			    },
	 			   {
	 					name : 'C相电流谐波畸变率',
	 					type : 'bar',
	 					barWidth : 3 ,
	 					data : icData,
	 					symbol : 'none',
	 					itemStyle : {
	 						normal : {
	 							color : 'red' 
	 	                    }
	 					}
	 			    }]
	 			};
	 		myChart1.setOption(option1);
	 		myChart2.setOption(option2);
		}
		
}
	function xiangqing(){
		var equNum=$("#equNum").val();
		
			layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"设备详情",
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: "<%=basePath%>/commens/zhjk/sb/xq/dnzljc.htm?equNum="+equNum   //iframe的url
			});
			
		
	}
</script>
</body>
</html>