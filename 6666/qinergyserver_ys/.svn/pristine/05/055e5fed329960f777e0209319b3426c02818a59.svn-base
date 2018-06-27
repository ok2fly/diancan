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
			<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
			
</head>
<body class="pl8t0 bgfc">
			<input type = "hidden" value="${id}" name="" id="id">
			<input type="hidden" id="equNum" value="${equNum}">
		<div class="dc-center">
			<div class="dc-warm bor-radius">
				
					<div class="a4"><p>告警牌</p></div>
					<div class="c1">
						<div class="borNoleft ">
							<table id="gjp1" style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
					<div class="c1">
						<div class="borleft">
							<table id="gjp2" style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
					<div class="c1">
						<div class="borleft">
							<table id="gjp3" style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
			</div>
			<div class="dc-realtime bor-radius">
					<div class="a4"><p>工作状态</p></div>
					<div class="b1">
						<div class="borNoleft ">
							<img src="<%=basePath %>img/jkicon.png" />
							<div class="b3">
								<p>健康状态</p>
								<h1 id="healthStat" style="margin-top: 25px;">--</h1>
							</div>
						</div>
					</div>
					<div class="b1">
						<div class="borleft">
							<img src="<%=basePath %>img/sbyxicon.png" />
							<div class="b3">
								<p>设备状态</p>
								<h1 id="stat" style="margin-top: 25px;">--</h1>
							</div>
						</div>
					</div>
		
					<div class="b1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/gzzt.png"/>
							<div class="b3">
								<p>并离网状态</p>
								<h1 id="gridStat" style="margin-top: 25px;">--</h1>
							</div>
						</div>
					</div>
					<div class="b1">
						<div class="borleft">
							<img src="<%=basePath %>img/gzms-.png"/>
							<div class="b3">
								<p>工作模式</p>
								<h1 id="mode" style="margin-top: 25px;">--</h1>
							</div>
						</div>
					</div>
			</div>
							
			<div class="ene-table bor-radius">
				<div class="a4"><p>工作信息</p></div>
				<div class="box">
					
					<div class="box-box1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/yg.png" width="50px"/>
							<div class="box-test">
							<p>电网总有功(kW)</p>						
							<h1 id="pGrid">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/yg.png" width="50px"/>
							<div class="box-test">
							<p>负荷总有功(kW)</p>						
							<h1 id="pLoad">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/yg.png" width="50px"/>
							<div class="box-test">
							<p>储能总有功(kW)</p>						
							<h1 id="pBatts">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/yg.png" width="50px"/>
							<div class="box-test">
							<p>光伏总有功(kW)</p>						
							<h1 id="pPV">0.00</h1>
							</div>
						</div>
					</div>
					
				</div>
				<div class="box">
					<div class="box-box1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/yg.png" width="50px"/>
							<div class="box-test">
							<p>充电桩总有功(kW)</p>						
							<h1 id="pEV">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						 <div class="borleft">
						 </div>
					</div>
					<div class="box-box1">
						 <div class="borleft">
						 </div>
					</div>
					<div class="box-box1">
						 <div class="borleft">
						 </div>
					</div>
				</div>
			</div>
			<div class="ene-table bor-radius ">
				<div class="a4"><p>电量信息</p></div>
				<div class="box">
					<div class="box-box1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/nbq1.png" width="50px"/>
							<div class="box-test">
							<p>电网输入电量(kWh)</p>						
							<h1 id="power4Grid">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/nbq1.png" width="50px"/>
							<div class="box-test">
							<p>馈网电量(kWh)</p>						
							<h1 id="power2Grid">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/nbq1.png" width="50px"/>
							<div class="box-test">
							<p>负荷用电量(kWh)</p>						
							<h1 id="powerLoad">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/nbq1.png" width="50px"/>
							<div class="box-test">
							<p>储能充电量(kWh)</p>						
							<h1 id="powerCharge">0.00</h1>
							</div>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="box-box1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/nbq1.png" width="50px"/>
							<div class="box-test">
							<p>储能放电量(kWh)</p>						
							<h1 id="powerDisCharge">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/nbq1.png" width="50px"/>
							<div class="box-test">
							<p>光伏发电量(kWh)</p>						
							<h1 id="powerPV">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/nbq1.png" width="50px"/>
							<div class="box-test">
							<p>充电桩充电量(kWh)</p>						
							<h1 id="powerEV">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						 <div class="borleft">
						 </div>
					</div>
				</div>
			</div>
			 
			
			<div class="dc-current bor-radius">
				<div class="a44"><p>有功功率</p>
					<div class="zxfx" id="zg"></div>
				</div>
			</div>
			<div class="dc-current bor-radius mb50">
				<div class="a44"><p>电量数据</p>
					<div class="zxfx" id="zdl"></div>
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

			<!-- <div class="qtxq bor-radius">其他详情</div> -->
		</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
<script>
	$(function (){
 		var id=$("#id").val();
 		var equNum=$("#equNum").val();
 		getMic(equNum);
 		getRelFauLst(equNum);
 		getEqu(equNum);
 		getIntEquOpeInf();
 		setInterval(function(){
	 		getMic(equNum);
	 		getRelFauLst(equNum);
	 		getEqu(equNum);
 		},60000);
 	})
 	
 	
function  getIntEquOpeInf(){
	var equ_num=$("#equNum").val();
	param="equ_num="+equ_num;
	$.ajax({
		url:url+"getIntEquOpeInf.htm",
		type:"post",
		data:param,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var d=data.data[0];
				if(d.lasMaintenanceLst != null && d.lasMaintenanceLst.length>0){
					var a=d.lasMaintenanceLst[0];
					/*$("#end_time1").html(getLocalDateAndTime(a.end_time,2)+' '+getLocalDateAndTime(a.end_time,3));*/
					$("#end_time1").html(getLocalDateAndTime(a.end_time,2));
				}
				if(d.lastOverhaulLst != null && d.lastOverhaulLst.length>0){
					var a=d.lastOverhaulLst[0];
					/*$("#end_time2").html(getLocalDateAndTime(a.end_time,2)+' '+getLocalDateAndTime(a.end_time,3));*/
					$("#end_time2").html(getLocalDateAndTime(a.end_time,2));
				}
				if(d.nextOverhaulLst != null && d.nextOverhaulLst.length>0){
					var a=d.nextOverhaulLst[0];
					/*$("#next_time").html(getLocalDateAndTime(a.next_time,2)+' '+getLocalDateAndTime(a.next_time,3));*/
					$("#next_time").html(a.next_time,2);
				}
				if(d.alaStaLst != null && d.alaStaLst.length>0){
					var a=d.alaStaLst[0];
					$("#info").html(getIsNull(a.info));
				}
				if(d.tolMaintenanceCountLst != null && d.tolMaintenanceCountLst.length>0){
					var a=d.tolMaintenanceCountLst[0];
					$("#cou").html(getIsNull(a.cou));
				}
			}else{
				layer.alert(data.desc);
			}
		}
	})
	
	
	
}
	
 	function getMic(equNum){
		$.ajax({
			url:url+"getMicSysRealInf.htm",
			data:"equ_num="+equNum,
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data){
						var real=data.data.micSysReal;
						if(real){
							var stat = real.stat == 0 ?"通讯中断": real.stat == 1 ? "正常运行" :real.stat == 2 ? "正常停机" :real.stat == 3 ? "告警运行" :real.stat == 4 ? "故障停止" : "--";
							
							$("#stat").html(stat); 
							
							var healthStat = real.healthStat == 1 ? "优秀" : real.healthStat == 2 ? "良好":real.healthStat == 3 ? "中等":real.healthStat == 4 ? "差" : "--";
							
							$("#healthStat").html(healthStat); 
							
							var mode = real.mode == 1 ? "光伏平滑" : real.mode == 2 ? "削峰填谷":real.mode == 3 ? "负荷追踪":real.mode == 4 ? "PCC点平滑" : "--";
							
							$("#mode").html(mode); 
							
							var gridStat = real.gridStat == 0 ? "离网":real.gridStat == 1 ? "并网" : "--";
							
							$("#gridStat").html(gridStat); 
							$("#faultNum").html(real.faultNum); 
							$("#pGrid").html(getFixedNum(real.pGrid)); 
							$("#pLoad").html(getFixedNum(real.pLoad)); 
							$("#pBatts").html(getFixedNum(real.pBatts)); 
							$("#pPV").html(getFixedNum(real.pPV)); 
							$("#pEV").html(getFixedNum(real.pEV)); 
							$("#power4Grid").html(getFixedNum(real.power4Grid)); 
							$("#power2Grid").html(getFixedNum(real.power2Grid)); 
							$("#powerLoad").html(getFixedNum(real.powerLoad)); 
							$("#powerCharge").html(getFixedNum(real.powerCharge)); 
							$("#powerDisCharge").html(getFixedNum(real.powerDisCharge)); 
							$("#powerPV").html(getFixedNum(real.powerPV)); 
							$("#powerEV").html(getFixedNum(real.powerEV)); 
						}
						
					}
					setChart1(data.data.micSysRealList)
					setChart2(data.data.micSysReal)
				}else{
		               layer.alert(data.desc);
				}
			}
		})
	}
	function setChart1(data){
		var xTime=[];
		var yw1=[];
		var yw2=[];
		var yw3=[];
		var yw4=[];
		var yw5=[];
		
		for(var i=0;i<data.length;i++){
			var a=data[i];
			xTime.push(getLocalDateAndTime(a.tol_tim,6));
			yw1.push(getFixedNum5(a.pGrid));
			yw2.push(getFixedNum5(a.pLoad));
			yw3.push(getFixedNum5(a.pBatts));
			yw4.push(getFixedNum5(a.pPV));
			yw5.push(getFixedNum5(a.pEV));
		}
 		var myChart1=echarts.init(document.getElementById('zg'),'shine');
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
		        legend: {
			        data: ['电网总有功', '负荷总有功', '储能总有功', '光伏总有功', '充电桩总有功'],
			        top: 10,
			    },
 			    calculable : true, 
 			    xAxis : [
 			        {
 			            type : 'category',
 			            boundaryGap : false,
 			            data : xTime
 			        }
 			    ],
 			    yAxis : [
 			        {
 			            type : 'value',
 			            name : '功率(kW)',
 			            axisLabel : {
 			                formatter: '{value}'
 			            }
 			        }
 			    ],
 			    series : [
 			        {
 			            name:'电网总有功',
 			            type:'line',
 			            data:yw1,
 						symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#EDB213'
 							}
 						}
 			        },
 			       {
 			            name:'负荷总有功',
 			            type:'line',
 			            data:yw2,
 						 symbol : 'none',
 						 itemStyle : {
 							normal : {
 								color : '#07CB47'
 							}
 						}  
 			        },
 			        {
 			            name:'储能总有功',
 			            type:'line',
 			            data:yw3,
 					 	symbol : 'none',
 						itemStyle : {
 							normal : {
 								color : '#5FB0E3'
 							}
 						}  
 			        },
 			        {
 			            name:'光伏总有功',
 			            type:'line',
 			            data:yw4,
 					 	symbol : 'none',
 						itemStyle : {
 							normal : {
 								color : '#FE784E'
 							}
 						}  
 			        },
 			        {
 			            name:'充电桩总有功',
 			            type:'line',
 			            data:yw5,
 					 	symbol : 'none',
 						itemStyle : {
 							normal : {
 								color : '#7A057A'
 							}
 						}  
 			        }
 			    ]
 			};
 		
 		  myChart1.setOption(option1);
	}
	function setChart2(data){
		var xTime=[];
		var yu1;
		var yu2;
		var yu3;
		var yu4;
		var yu5;
		var yu6;
		var yu7;
		 
		if(data && data!= undefined){
			var a = data;
			yu1=getFixedNum5(a.power4Grid);
			yu2=getFixedNum5(a.power2Grid);
			yu3=getFixedNum5(a.powerLoad);
			yu4=getFixedNum5(a.powerCharge);
			yu5=getFixedNum5(a.powerDisCharge);
			yu6=getFixedNum5(a.powerPV);
			yu7=getFixedNum5(a.powerEV);
			 
			
			
			xTime.push(getFixedNum5(a.power4Grid));
			xTime.push(getFixedNum5(a.power2Grid));
			xTime.push(getFixedNum5(a.powerLoad));
			xTime.push(getFixedNum5(a.powerCharge));
			xTime.push(getFixedNum5(a.powerDisCharge));
			xTime.push(getFixedNum5(a.powerPV));
			xTime.push(getFixedNum5(a.powerEV));
		}else{
			yu1='-';
			yu2='-';
			yu3='-';
			yu4='-';
			yu5='-';
			yu6='-';
			yu7='-';
			
			xTime.push('-');
			xTime.push('-');
			xTime.push('-');
			xTime.push('-');
			xTime.push('-');
			xTime.push('-');
			xTime.push('-');
		}
			
		/* for(var i=0;i<data.length;i++){
			var a=data[i];
			xTime.push(getLocalDateAndTime(a.tol_tim,6));
			yu1.push(getFixedNum5(a.power4Grid));
			yu2.push(getFixedNum5(a.power2Grid));
			yu3.push(getFixedNum5(a.powerLoad));
			yu4.push(getFixedNum5(a.powerCharge));
			yu5.push(getFixedNum5(a.powerDisCharge));
			yu6.push(getFixedNum5(a.powerPV));
			yu7.push(getFixedNum5(a.powerEV));

		} */
 		var myChart2=echarts.init(document.getElementById('zdl'),'shine');
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
 				legend: {
 			        data: [],
 			        top: 10,
 			    },
 			    calculable : true, 
 			    xAxis : [
 			        {
 			            type : 'category',
 			            data :['电网输入电量', '馈网电量', '负荷用电量', '储能充电量', '储能放电量', '光伏发电量', '充电桩充电量'],
 			            splitLine:{show: false},
 				        axisLine:false 
 			        }
 			    ],
 			    yAxis : [
 			        {
 			            type : 'value',
 			            name : '电量(kWh)',
 			            axisLabel : {
 			                formatter: '{value}'
 			            }
 			        }
 			    ],
 			    series : [
						{
						     name:'',
						     type:'bar',
						     itemStyle: {
					                normal: {
					                    color: function(params) {
					                        // build a color map as your need.
					                        var colorList = [
					                          '#EDB213','#07CB47','#5FB0E3','#FE784E','#7A057A',
					                           '#F4350D','#000080'
					                        ];
					                        return colorList[params.dataIndex]
					                    },
					                    label: {
					                        show: false,
					                        position: 'inside' 
					                    }
					                }
					            },
						     data:[yu1,yu2,yu3,yu4
						           ,yu5,yu6,yu7],
							symbol : 'none'  
						 },
 			       /*  {
 			            name:'电网输入电量',
 			            type:'bar',
 			            data:yu1
 						symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#EDB213'
 							}
 						}
 			        },
 			       {
 			            name:'馈网电量',
 			            type:'bar',
 			            data:yu2,
 						symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#07CB47'
 							}
 						}
 			        },
 			       {
 			            name:'负荷用电量',
 			            type:'bar',
 			            data:yu3,
 						symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#5FB0E3'
 							}
 						}
 			        },
 			       {
 			            name:'储能充电量',
 			            type:'bar',
 			            data:yu4,
 						symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#FE784E'
 							}
 						}
 			        },
 			       {
 			            name:'储能放电量',
 			            type:'bar',
 			            data:yu5,
 						symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#7A057A'
 							}
 						}
 			        },
 			       {
 			            name:'光伏发电量',
 			            type:'bar',
 			            data:yu6,
 						symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#F4350D'
 							}
 						}
 			        },
 			       {
 			            name:'充电桩充电量',
 			            type:'bar',
 			            data:yu7,
 						symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#000080'
 							}
 						}
 			        } */
 			    ]
 			};
 		
 		  myChart2.setOption(option2);
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
	/* 获取告警牌信息  */
	function getRelFauLst(equNum){
		$.ajax({
			url:url+"getRelFauLst.htm",
			//data : "equ_num=CNNBQ-2017001",
			data:"equ_num="+equNum,
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.resultcode=="USR000"){
					 if(data.data.length > 0 ){
						 var html1 = '';
						 var html2 = '';
						 var html3 = '';
						 for(var i=0; i<data.data.length ;i++){
							 if(i < 32){
								 var d = data.data[i];
								 var cls = '';
								 if(d.is_dpl == 1 ){
									 cls = ' gjp'
								 }
								 var h = '<tr class="tr3">'+
										  '<td>'+
										  '<div class="dian2 '+cls+'"></div>'+
										  '</td>'+
										  '<td><span>'+d.ala_info+'</span></td>'+
										  '</tr>' ;
								 if(i%3 == 0 ){
									 html1 += h;
								 }
								 if(i%3 == 1 ){
									 html2 += h;
								 }
								 if(i%3 == 2 ){
									 html3 += h;
								 }
							 }
						 }
						 $("#gjp1").html(html1);
						 $("#gjp2").html(html2);
						 $("#gjp3").html(html3);
					 }
				}else{
					layer.alert(data.desc);
				}
			}
		})
	}

</script>
</body>
</html>