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
		<input type = "hidden" value="${equNum}" name="" id="equNum">
		<input type = "hidden" value="${id}" name="" id="id">
		<div class="dc-center">
			<div class="dc-warm bor-radius">
				
					<div class="a4"><p>告警牌</p></div>
					<div class="c1">
						<div class="borNoleft ">
							<table id="gjp1"  style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
					<div class="c1">
						<div class="borleft">
							<table id="gjp2"  style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
					<div class="c1">
						<div class="borleft">
							<table id="gjp3"  style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
			</div>
			<div class="dc-realtime bor-radius">
					<div class="a4"><p>工作状态</p></div>
					<div class="b1" style="width: 50%;">
						<div class="borNoleft">
							<img src="<%=basePath %>img/jkicon.png" />
							<div class="b3">
								<p>健康状态</p>
								<h1 id="healthStat" style="margin-top: 25px;">--</h1>
							</div>
						</div>
					</div>
					<div class="b1" style="width: 50%;">
						<div class="borleft">
							<img src="<%=basePath %>img/sbyxicon.png" />
							<div class="b3">
								<p>设备状态</p>
								<h1 id="stat"  style="margin-top: 25px;">--</h1>
							</div>
						</div>
					</div>
		
					<div class="b1" style="width: 50%;">
						<div class="borNoleft">
							<img src="<%=basePath %>img/gzzt.png"/>
							<div class="b3">
								<p>工作状态</p>
								<h1 id="workStat"  style="margin-top: 25px;">--</h1>
							</div>
						</div>
					</div>
					<div class="b1" style="width: 50%;">
						<div class="borleft">
							<img src="<%=basePath %>img/gzms-.png"/>
							<div class="b3">
								<p>工作模式</p>
								<h1 id="mode"  style="margin-top: 25px;">--</h1>
							</div>
						</div>
					</div>
			</div>
			
			
			<div class="dc-high bor-radius">
				<div class="a4"><p>高压侧</p></div>
				<div class="a1">
					<div class="borleft" style="border-left:none;">
						<img src="<%=basePath %>img/z-57.png"/>
						<div class="a5">
							<p>电压(V)</p>
							<h2 id="uHigh">0.00</h2>
						</div>
					</div>
				</div>
				<div class="a1">
					<div class="borleft">
						<img src="<%=basePath %>img/z-56.png"/>
						<div class="a5">
							<p>电流(A)</p>
							<h2 id="iHigh">0.00</h2>
						</div>
					</div>
				</div>
				<div class="a1">
					<div class="borleft">
						<img src="<%=basePath %>img/z-58.png"/>
						<div class="a5">
							<p>功率(kW)</p>
							<h2 id="pHigh" >0.00</h2>
						</div>
					</div>
				</div>
			</div>
			<div class="dc-low bor-radius">
				<div class="a4"><p>低压侧</p></div>
				<div class="a1">
					<div class="borleft" style="border-left:none;">
						<img src="<%=basePath %>img/z-57.png"/>
						<div class="a5">
							<p>电压(V)</p>
							<h2 id="uLow" >0.00</h2>
						</div>
					</div>
				</div>
				<div class="a1">
					<div class="borleft">
						<img src="<%=basePath %>img/z-56.png"/>
						<div class="a5">
							<p>电流(A)</p>
							<h2 id="iLow" >0.00</h2>
						</div>
					</div>
				</div>
				<div class="a1">
					<div class="borleft">
						<img src="<%=basePath %>img/z-58.png"/>
						<div class="a5">
							<p>功率(kW)</p>
							<h2 id="pLow" >0.00</h2>
						</div>
					</div>
				</div>
				
			</div>
			<div class="dc-current bor-radius mb50" style="height:300px">
				<div class="a44"><p>电压电流</p></div>
				<div class="zxfx" id="dldyChart" style="height:264px"></div>
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
 	$(function (){
 		var equ_num=$("#equ_num").val();
 		var id=$("#id").val();
 		getDC(id);
 		getRelFauLst();
 	})
 	
 	function getDC(id){
 		var equNum=$("#equNum").val();
 		$.ajax({
	    	url:url+"getDCDCRealInf.htm",
	    	data : "equ_num="+equNum,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 
	    			 if(data.data.dcdcReal){
	    				 var real = data.data.dcdcReal;
	    				 var stat = real.stat == 0 ?"通讯中断": real.stat == 1 ? "正常运行" :real.stat == 2 ? "正常停机" : real.stat == 3 ? "告警运行":real.stat == 4 ? "故障停机" : real.stat == 5 ? "限电运行" : "--";
	    				 var healthStat = real.healthStat == 1 ? "优秀" :real.healthStat == 2 ? "良好" : real.healthStat == 3 ? "中等":real.healthStat == 4 ? "差" : "--";
	    				 var workStat = real.workStat == 0 ?"停止": real.workStat == 1 ? "故障" :real.workStat == 2 ? "充电" : real.workStat == 3 ? "待机":real.workStat == 4 ? "放电" : "--";
	    				 var mode = real.mode == 0 ?"恒流模式": real.mode == 1 ? "恒压模式" :real.mode == 2 ? "恒功率模式" : real.mode == 3 ? "下垂模式":real.mode == 4 ? "MPPT" : real.mode == 5 ? "负荷模式" : "--";
	    				 /*实时数据*/
	    				 $("#stat").html(stat);
	    				 $("#workStat").html(workStat);
	    				 $("#mode").html(mode);
	    				 $("#healthStat").html(healthStat);
	    				 
	    				 /*高低压侧 电压电流功率*/
	    				 $("#uHigh").html(getFixedNum(real.uHigh));
	    				 $("#iHigh").html(getFixedNum(real.iHigh));
	    				 $("#pHigh").html(getFixedNum(real.pHigh));
	    				 $("#uLow").html(getFixedNum(real.uLow));
	    				 $("#iLow").html(getFixedNum(real.iLow));
	    				 $("#pLow").html(getFixedNum(real.pLow));
	    			 }
	    			 
	    			 if(data.data.dcdcEqu){
	    				 var equ = data.data.dcdcEqu;
	    				 /*设备信息*/
	    				 $("#app_mod").html(equ.app_mod);
	    				 $("#rtd_pow").html(getFixedNum(equ.rtd_pow)+"kW");
	    				 $("#man_nam").html(equ.man_nam);
	    				 $("#pur_tim").html(getLocalDateAndTime(equ.ope_tim,2));
	    				 $("#equ_num").html(equ.equ_cod);
	    			 }
	    			 
	    			 
	    			 setChart(data.data.dcdcRealList);
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 	
 	function setChart(chartData){
 		
 		var xData= [];
 		var yGyDlData= [];
 		var yDyDlData= [];
 		var yGyDyData= [];
 		var yDyDyData= [];
 		for(var i = 0 ; i<chartData.length;i++){
 			var one = chartData[i];
 			xData.push(getLocalDateAndTime(one.tol_tim,6));
 			yGyDlData.push(getFixedNum5(one.iHigh));
 			yDyDlData.push(getFixedNum5(one.iLow));
 			yGyDyData.push(getFixedNum5(one.uHigh ));
 			yDyDyData.push(getFixedNum5(one.uLow));
 		}
 		
 		var myChart=echarts.init(document.getElementById('dldyChart'),'shine');
 		option = {
 			    tooltip : {
 			        trigger: 'axis'
 			    },
 			   legend: {
 			        data: ['高压侧电流','低压侧电流','高压侧电压','低压侧电压'],
 			        top: 10,
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
 			            data : xData,
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
 			        },{
 			            type : 'value',
 			            name : '电流(A)',
 			            axisLabel : {
 			                formatter: '{value}'
 			            }
 			        }
 			    ],
 			    series : [
 			        {
 			            name:'高压侧电流',
 			            type:'line',
 			            data:yGyDlData,
 			           symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#EDB213'
 							}
 						}
 			        },
 			       {
 			            name:'低压侧电流',
 			            type:'line',
 			            data:yDyDlData,
 			           symbol : 'none',
 						 itemStyle : {
 							normal : {
 								color : '#07CB47'
 							}
 						}  
 			        },
 			        {
 			            name:'高压侧电压',
 			            type:'line',
 			            yAxisIndex: 1,
 			            data:yGyDyData,
 			           symbol : 'none',
 						itemStyle : {
 							normal : {
 								color : '#5FB0E3'
 							}
 						}  
 			        },
 			        {
 			            name:'低压侧电压',
 			            type:'line',
 			            yAxisIndex: 1,
 			            data:yDyDyData,
 			           symbol : 'none',
						itemStyle : {
							normal : {
								color : '#FE784E'
							}
						}  
 			        }
 			    ]
 			};
 		
 		  myChart.setOption(option);
 			                    
 	}
 	
 	/* 获取告警牌信息  */
 	function getRelFauLst(){
 		var equNum=$("#equNum").val();
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
 	
 	function xiangqing(){
		var equNum=$("#equNum").val();
		
			layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"设备详情",
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: "<%=basePath%>/commens/zhjk/sb/xq/dcdc.htm?equNum="+equNum   //iframe的url
			});
			
		
	}
</script>		
	</body>
</html>
