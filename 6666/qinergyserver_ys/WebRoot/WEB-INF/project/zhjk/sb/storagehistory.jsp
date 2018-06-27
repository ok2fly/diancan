<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc-history.css?pubVersion=201802070001" />
	</head>
	<body class="pl8t0 bgfc">
		<input type="hidden" value="${id}" id="id"> 
		<input type="hidden" value="${equNum}" id="equNum"> 
		<div class="his-body">
			<div class="his-tit">历史分析</div>
			<div style="width:100%; float:left;">
				<div class="his-table-body">
					<div class="a44">
						<p>电压电流</p>
						<input type="text" id="dateTime_sta" placeholder="请选择时间" class="fr  Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData,maxDate:'%y-%M-%d'})"> 
					</div>
					<div class="his-img" id="dydl"></div>
				</div>
				<div class="his-table-body">
					<div class="a44">
						<p>有功无功</p>
					</div>
					<div class="his-img" id="ygwg"></div>
				</div>
				<div class="his-table">
					<div style="height:285px;"  >
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>直流电压(V)</th>
								<th>直流电流(A)</th>
								<th>直流功率(kW)</th>
								<th>电压(V)</th>
								<th>电流(A)</th>
								<th>功率(kW)</th>
								<th>功率因数</th>
								<th>频率(Hz)</th>
							</tr>
							<tbody id="list1">
								<tr>
									<td>暂无数据</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								
							</tbody>
						</table>
					</div>
					<div class="tcdPageCode" id="tcdPageCode1"></div> 
				</div>
			</div>
			<div class="cler"></div>
			<div  style="width:100%; float:left; ">
				<div class="his-table-body">
					<div class="a44">
						<p>输入输出电量</p>
						<input type="text" id="dateTime_sta2" placeholder="请选择时间" class=" Wdate fr "   onFocus="WdatePicker({dateFmt:'yyyy-MM',onpicked:getData2,maxDate:'%y-%M-%d'})">
					</div>
					<div class="his-img" id="srsc"></div>
				</div>
				<div class="his-table">
					<div style="height:285px;" >
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>输入电量(kWh)</th>
								<th>输出电量(kWh)</th>
							</tr>
							<tbody id="list2">
								<tr>
									<td>暂无数据</td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="tcdPageCode" id="tcdPageCode2"></div> 
				</div>
			</div>
		 	<div class="cler"></div>
			<div class="his-table mb50" style="height: 390px;">
				<div class="a1"  >
					<div class="fl"><h4 style="line-height:35px;font-weight: normal;">变位历史信息</h4></div>
					<div class="fr"> 
						<input type="text"  id="sta_tim_bw"  placeholder="开始时间" class=" Wdate" style="width: 108px;padding-left: 5px;height: 30px; line-height: 30px;    border-radius: 3px;"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim_bw\')||\'%y-%M-%d\'}'})">
						<span style="color:#999">---</span>
						<input type="text"  id="end_tim_bw" placeholder="结束时间" class=" Wdate" style="width: 108px;padding-left: 5px;height: 30px; line-height: 30px;    border-radius: 3px;"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sta_tim_bw\')}',maxDate:'%y-%M-%d'})"> 
						<input class="his-btn"  id="his-btn3" type="submit" value="查询">
					</div>
				</div>
				<div  style="height:285px;">
					<table  width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>序号</th>
							<th>变位时间</th>
							<th>设备编号</th>
							<th>设备名称</th>
							<th>设备类型</th>
							<th>变位码</th>
							<th>变位信息</th>
							<th>初始状态</th>
							<th>当前状态</th>
						</tr>
						<tbody id="list3_bw">
							<tr>
								<td>暂无数据</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode-bw">
				
				</div> 
			</div>
		</div>
	
<script type="text/javascript" src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/sb-history.js?pubVersion=201802070001"></script>
<script type="text/javascript">
	var id="";
	var equNum="";
 	$(function (){
 		id=$("#id").val();
 		equNum=$("#equNum").val();
 		var result=getDateToday();
 		var result2=getDateYearAndMouth();
 		$("#dateTime_sta").val(result);
 		$("#dateTime_sta2").val(result2);
		getData();
		getData2();
		
		$("#sta_tim_bw").val(result);
		$("#end_tim_bw").val(result);
		getBwData()
 	})
 	 
 	
 	function getGraph(){
 		var param = "equ_num="+equNum;
 	 
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&year="+dateTime_sta;
			$.ajax({
		    	url:url+"getPcsInfoByDayGraph.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			 if(data.data.length> 0){
	    					 setChart1(data.data);
	    					 setChart3(data.data);
		    			 }
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}else{
			layer.alert("请选择时间");
		}
 	}
 	var countAll = 0;
 	var currentPage  = 1;
 	function getData(){
 		
 		var param = "equ_num="+equNum;
 	 
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&year="+dateTime_sta;
			param += "&currentPage="+currentPage;
			$.ajax({
		    	url:url+"getPcsInfoByYearList.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			countAll = data.totalPage;
						currentPage = data.currentPage;
		    			 if(data.data.length> 0){
	    					$("#list1").empty();
	    					 for(var i = 0 ; i < data.data.length ; i++){
	    						 var htmlList1 = "";
	    						 var lst = data.data[i];
	    						 htmlList1 += "<tr>"+
	    						 	"<td>"+((currentPage-1)*10+i+1)+"</td>"+
									"<td>"+getLocalDateAndTime(lst.crtTim,6)+"</td>"+
									"<td>"+getFixedNum5(lst.udc)+"</td>"+
									"<td>"+getFixedNum5(lst.idc)+"</td>"+
									"<td>"+getFixedNum5(lst.pdc)+"</td>"+
									"<td>"+getFixedNum5(lst.ua)+"</td>"+
									"<td>"+getFixedNum5(lst.ia)+"</td>"+
									"<td>"+getFixedNum5(lst.pa)+"</td>"+
									"<td>"+getFixedNum6(lst.pf)+"</td>"+
									"<td>"+getFixedNum5(lst.freq)+"</td>"+
									"</tr>";
	    						  $("#list1").append(htmlList1);
	    					 }
	    					 $("#tcdPageCode1").createPage({
	 	 				        pageCount:countAll,
	 	 				        current:currentPage,
	 	 				        backFn:function(p){
	 	 				        	currentPage = p;
	 	 				        	getData();
	 	 				        }
	 	 			    	});
		    			 }else{
			 					var h = "<tr>"+
								"<td>暂无数据</td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
							"</tr>";
							$("#list1").html(h);
							$("#tcdPageCode1").empty();
						}
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}else{
			layer.alert("请选择时间");
		}
 		getGraph();
 	}
 	
 	 
 	function getGraph2(){
 		
 		var param = "equ_num="+equNum;
 	 
 		var sjlx2 = $("#sjlx2").val();
 		var dateTime_sta2 = $("#dateTime_sta2").val();
 		
 		if(dateTime_sta2 != undefined && dateTime_sta2 != ""){
			param += "&date="+dateTime_sta2+"-01";
			
			$.ajax({
		    	url:url+"getPcsHistoryMonth.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			 if(data.data ){
		    				 setChart2(data.data);
		    			 }
		    			 
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		    
		}else{
			layer.alert("请选择时间");
		} 
 	}
 	
 	var countAll2 = 0;
 	var currentPage2  = 1;
 	function getData2(){
 		
 		var param = "equ_num="+equNum;
 	 
 		var sjlx2 = $("#sjlx2").val();
 		var dateTime_sta2 = $("#dateTime_sta2").val();
 		
 		if(dateTime_sta2 != undefined && dateTime_sta2 != ""){
 			
			param += "&date="+dateTime_sta2+"-01";
			param += "&currentPage="+currentPage2;
			
			$.ajax({
		    	url:url+"getPcsHistoryMonthLst.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			countAll2 = data.totalPage;
						currentPage2 = data.currentPage;
		    			 if(data.data ){
	   						 var htmlList1 = "";
	    					 for(var i = 0 ; i < data.data.length ; i++){
	    						 var lst = data.data[i];
	    						 htmlList1 += "<tr>"+
	    							"<td>"+((currentPage2-1)*10+i+1)+"</td>"+
									"<td>"+lst.tol_tim+"</td>"+
									"<td>"+getFixedNum5(lst.phi)+"</td>"+
									"<td>"+getFixedNum5(lst.phe)+"</td>"+
									"</tr>";
	    					 } 
	    					 if(htmlList1 != ""){
	    						 $("#list2").empty().append(htmlList1);
		    					 $("#tcdPageCode2").createPage({
		 	 				        pageCount:countAll2,
		 	 				        current:currentPage2,
		 	 				        backFn:function(p){
		 	 				        	currentPage2 = p;
		 	 				        	getData2();
		 	 				        }
		 	 			    	});
	    					 }
		    			 }
		    			 
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		    
		}else{
			layer.alert("请选择时间");
		} 
 		getGraph2();
 	}
 	
 	
 	function setChart1(chartData) {

 		var xTime = [];
 		var yU = [];
 		var yA = [];
 		var yU2 = [];
 		var yA2 = [];
 		for (var i = 0; i < chartData.length; i++) {
 			var one = chartData[i];
 			xTime.push(getLocalDateAndTime(one.tol_tim, 6));
 			yU.push(getFixedNum5(one.uab));
 			yA.push(getFixedNum5(one.ia));
 			yU2.push(getFixedNum5(one.udc));
 			yA2.push(getFixedNum5(one.idc));
 		}

 		var myChart = echarts.init(document.getElementById('dydl'), 'shine');
 		option = {
 				legend: {
 			        data: ['直流电压', '直流电流','交流电压', '交流电流'],
 			        top: 10,
 			    },
 			tooltip : {
 				trigger : 'axis'
 			},
 			grid : {
 				left : '60',
 				top : '40',
 				right : '60',
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
 				name : '交流电压',
 				type : 'line',
 				smooth : true,
 				data : yU,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#5FB0E3'
 					}
 				}  
 			}, {
 				name : '交流电流',
 				type : 'line',
 				yAxisIndex :1 ,
 				smooth : true,
 				data : yA,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#FE784E'
 					}
 				}  
 			},
 			{
 				name : '直流电压',
 				type : 'line',
 				smooth : true,
 				data : yU2,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#EDB213'
 					}
 				}  
 			}, {
 				name : '直流电流',
 				type : 'line',
 				yAxisIndex :1 ,
 				smooth : true,
 				data : yA2,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#35BEB5'
 					}
 				}  
 			}

 			]
 		};

 		myChart.setOption(option);

 	}	
 	
 	function setChart2(chartData){
 		
 		var xTime = [];
 		var yI = [];
 		var yE = [];
 		for (var i = 0; i < chartData.length; i++) {
	 			var one = chartData[i];
	 			xTime.push(getLocalDateAndTime(one.tol_tim,10)+"日");
	 			yI.push(getFixedNum5(one.phi));
	 			yE.push(getFixedNum5(one.phe));
	 		}
 		var myChart = echarts.init(document.getElementById('srsc'), 'shine');
 		option = {
 				legend: {
 			        data: ['有功电量', '无功电量'],
 			        top: 10,
 			    },

 			tooltip : {
 				trigger : 'axis'
 			},
 			grid : {
 				left : '60',
 				top : '40',
 				right : '60',
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
 						name : '电量(kWh)',
 						axisLabel : {
 						formatter : '{value}'
 						}
 					} 
 			],
 			series : [ {
 				name : '输入电量',
 				type : 'bar',
 				smooth : true,
 				data : yI,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#EDB213'
 					}
 				}  
 			}, {
 				name : '输出电量',
 				type : 'bar',
 				smooth : true,
 				data : yE,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#35BEB5'
 					}
 				}  
 			}

 			]
 		};

 		myChart.setOption(option);
 	}
 	
function setChart3(chartData){
 		
 		var xTime = [];
 		var yI = [];
 		var yE = [];
 		for (var i = 0; i < chartData.length; i++) {
	 			var one = chartData[i];
	 			xTime.push(getLocalDateAndTime(one.tol_tim, 6));
	 			yI.push(getFixedNum5(one.psum));
	 			yE.push(getFixedNum5(one.qsum));
	 		}
 		var myChart = echarts.init(document.getElementById('ygwg'), 'shine');
 		option = {
 				legend: {
 			        data: ['有功', '无功'],
 			        top: 10,
 			    },

 			tooltip : {
 				trigger : 'axis'
 			},
 			grid : {
 				left : '60',
 				top : '40',
 				right : '60',
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
 					} ,
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
 				data : yI,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#EDB213'
 					}
 				}  
 			}, {
 				name : '无功',
 				type : 'line',
 				smooth : true,
 				data : yE,
 				symbol : 'none',
 				yAxisIndex :1,
 				itemStyle : {
 					normal : {
 						color : '#35BEB5'
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
 		myChart.setOption(option);
 	}
 	
</script>		
		
	</body>
</html>
