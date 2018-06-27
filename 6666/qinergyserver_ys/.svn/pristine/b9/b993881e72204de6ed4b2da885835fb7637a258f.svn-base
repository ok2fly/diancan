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
						<input type="text" id="date" placeholder="请选择时间" class="fr  Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData2,maxDate:'%y-%M-%d'})"> 
					</div>
					<div class="his-img" id="dldy"></div>
				</div>
			 	<div class="his-table-body">
					<div class="a44">
						<p>有功无功</p>
						
					</div>
					<div class="his-img" id="zxfx"></div>
				</div>
				<div class="his-table">
					<div style="height:285px;">
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>电压(V)</th>
								<th>电流(A)</th>
								<th>有功功率(kW)</th>
								<th>无功功率(kVar)</th>
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
								</tr>
							</tbody>
						</table>
					</div>
					<div class="tcdPageCode" id="tcdPageCode1"></div> 
				</div>
			</div>
			<div class="cler"></div>
			<div style="width:100%; float:left;">
			 	<div class="his-table-body">
					<div class="a44">
						<p>电度</p>
						<input type="text" id="dateTime_sta" placeholder="请选择时间" class="fr  Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM',onpicked:getData,maxDate:'%y-%M-%d'})"> 
					</div>
					<div class="his-img" id="zfdd"></div>
				</div>
			 
				<div class="his-table">
					<div style="height:285px;">
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>正向有功电度(kWh)</th>
								<th>反向有功电度(kWh)</th>
								<th>正向无功电度(kVarh)</th>
								<th>反向无功电度(kVarh)</th>
							</tr>
							<tbody id="list2">
								<tr>
									<td>暂无数据</td>
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
								</tr>
								<tr>
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
								</tr>
								<tr>
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
								</tr>
								<tr>
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
 		var result2=getDateYearAndMouth();
 		var result=getDateToday();
 		$("#dateTime_sta").val(result2);
 		$("#date").val(result);
 		getData();
 		getData2();
 		
 		$("#sta_tim_bw").val(result);
 		$("#end_tim_bw").val(result);
 		getBwData()
 	})
 	 
 	var countAll = 0;
	var currentPage  = 1;
 	function getData(){
 		equNum=$("#equNum").val();
 		var param = "equ_num="+equNum;
 	 
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&date="+dateTime_sta+"-01";
			param += "&currentPage="+currentPage;
		} 

 		$.ajax({
	    	url:url+"getMeterHistoryListMonth.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		
	    		if (data.resultcode=="USR000") {
	    			countAll2 = data.totalPage;
					currentPage2 = data.currentPage;
	    			 if(data.data.length> 0){
    					 $("#list2").empty();
    					 for(var i = 0 ; i < data.data.length ; i++){
	   						 var htmlList1 = "";
    						 var lst = data.data[i];
    						 htmlList1 += "<tr>"+
    						 	"<td>"+((currentPage2-1)*10+i+1)+"</td>"+
    						 	"<td>"+(lst.tol_tim)+"</td>"+
								"<td>"+getFixedNum5(lst.phi_power)+"</td>"+
								"<td>"+getFixedNum5(lst.phe_power)+"</td>"+
								"<td>"+getFixedNum5(lst.qhi_power)+"</td>"+
								"<td>"+getFixedNum5(lst.qhe_power)+"</td>"+
								"</tr>";
    						  $("#list2").append(htmlList1);
    						  $("#tcdPageCode2").createPage({
    		 				        pageCount:countAll2,
    		 				        current:currentPage2,
    		 				        backFn:function(p){
    		 				        	currentPage2 = p;
    		 				        	getData2();
    		 				        }
    		 			    	});
    					 }
	    			 }else{
		 					var h = "<tr>"+
							"<td>暂无数据</td>"+
							"<td></td>"+
							"<td></td>"+
							"<td></td>"+
							"<td></td>"+
							"<td></td>"+
						"</tr>";
						$("#list2").html(h);
						$("#tcdPageCode2").empty();
					}
	    			 
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 		
 		
	    getGraphData2();
 	}
 	
 	var countAll2 = 0;
	var currentPage2  = 1;
 	function getData2(){
 		equNum=$("#equNum").val();
 		var param = "equ_num="+equNum;
 	 
 		var date = $("#date").val();
 		
 		if(date != undefined && date != ""){
			param += "&day="+date;
			param += "&currentPage="+currentPage;
		} 
 		
 		$.ajax({
	    	url:url+"getMeterHistoryInf.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		
	    		if (data.resultcode=="USR000") {
	    			countAll = data.totalPage;
					currentPage = data.currentPage;
	    			 if(data.data.length> 0){
    					 $("#list1").empty();
   						 var htmlList1 = "";
    					 for(var i = 0 ; i < data.data.length ; i++){
    						 var lst = data.data[i];
    						 htmlList1 += "<tr>"+
    						 	"<td>"+((currentPage-1)*10+i+1)+"</td>"+
    						 	"<td>"+getLocalDateAndTime(lst.crtTim,6)+"</td>"+
    						 	"<td>"+getFixedNum5(lst.uab)+"</td>"+
								"<td>"+getFixedNum5(lst.ia)+"</td>"+
								"<td>"+getFixedNum5(lst.psum)+"</td>"+
								"<td>"+getFixedNum5(lst.qsum)+"</td>"+
								"<td>"+getFixedNum6(lst.pf)+"</td>"+
								"<td>"+getFixedNum5(lst.freq)+"</td>"+
								"</tr>";
    					 }
   						  $("#list1").append(htmlList1);
	    			 }
	    			 $("#tcdPageCode1").createPage({
 				        pageCount:countAll,
 				        current:currentPage,
 				        backFn:function(p){
 				        	currentPage = p;
 				        	getData2();
 				        }
 			    	});
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	    
	    getGraphData();
 	}
 	
 	function getGraphData(){
 		var param = "equ_num="+equNum;
 	 
 		
		var date = $("#date").val();
 		
 		if(date != undefined && date != ""){
			param += "&day="+date;
		} 
 		
 		
 		$.ajax({
	    	url:url+"getMeterHistoryGraph.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 setChart1(data.data);
	    			 setChart3(data.data);
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 	
 	
 	function getGraphData2(){
 		equNum=$("#equNum").val();
 		var param = "equ_num="+equNum;
 		
		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&date="+dateTime_sta+"-01";
		} 
 		
 		$.ajax({
	    	url:url+"getMeterHistoryMonthGraph.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 setChart2(data.data);
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 	
 	function setChart1(diandu) {

 		var xTime = [];
 		var ypsum  = [];
 		var yqsum  = [];
 		if(diandu != null){
 			for (var i = 0; i < diandu.length; i++) {
 				var d = diandu[i];
 				if(d != null){
 					xTime.push(getLocalDateAndTime(d.tol_tim, 6));
 					ypsum.push(getFixedNum5(d.psum));
 					yqsum.push(getFixedNum5(d.qsum));
 				}

 			}
 		}
 		
 		var myChart1 = echarts.init(document.getElementById('zxfx'), 'shine');
 		option = {

 			tooltip : {
 				trigger : 'axis'
 			},
 			 legend: {
 				  	data: ['有功功率', '无功功率'],
 			        top: 10,
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
						name : '有功功率(kW)',
						axisLabel : {
						formatter : '{value}'
						}
					},
					{
						type : 'value',
						name : '无功功率(kVar)',
						axisLabel : {
						formatter : '{value}'
						}
					} 
 			],
 			series : [ {
 				name : '有功功率',
 				type : 'line',
 				smooth : true,
 				data : ypsum,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#EDB213'
 					}
 				}  
 			}, {
 				name : '无功功率',
 				type : 'line',
 				smooth : true,
 				data : yqsum,
 				yAxisIndex:1,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#35BEB5'
 					}
 				}  
 			}

 			]
 		};

 		var maxVal = 0 ;
 		for (var i = 0; i < diandu.length; i++) {
 			var one = diandu[i];
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
 		myChart1.setOption(option);

 	}	
 	
 	function setChart3(diandu) {

 		var xTime = [];
 		var yua  = [];
 		var yia  = [];
 		if(diandu != null){
 			for (var i = 0; i < diandu.length; i++) {
 				var d = diandu[i];
 				if(d != null){
 					xTime.push(getLocalDateAndTime(d.tol_tim, 6));
 					yua.push(getFixedNum5(d.uab));
 					yia.push(getFixedNum5(d.ia));
 				}

 			}
 		}
 		
 		var myChart3 = echarts.init(document.getElementById('dldy'), 'shine');
 		option = {

 			tooltip : {
 				trigger : 'axis'
 			},
 			 legend: {
 				  	data: ['电压', '电流'],
 			        top: 10,
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
 				name : '电压',
 				type : 'line',
 				smooth : true,
 				data : yua,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#EDB213'
 					}
 				}  
 			}, {
 				name : '电流',
 				type : 'line',
 				smooth : true,
 				data : yia,
 				yAxisIndex:1,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#35BEB5'
 					}
 				}  
 			}

 			]
 		};

 		myChart3.setOption(option);

 	}	
 	
 	
 	
 	function setChart2(diandu) {

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
 					yphe.push(getFixedNum5(d.phe));
 					yqhi.push(getFixedNum5(d.qhi));
 					yqhe.push(getFixedNum5(d.qhe));
 				}

 			}
 		}
 		
 		var myChart2 = echarts.init(document.getElementById('zfdd'), 'shine');
 		option = {

 			tooltip : {
 				trigger : 'axis'
 			},
 			 legend: {
 				  	data: ['正向有功电度', '反向有功电度','正向无功电度', '反向无功电度'],
 			        top: 10,
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
 							name : '有功电度(kWh)',
 							axisLabel : {
 							formatter : '{value}'
 							}
 						}, {
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
 				symbol : 'none',
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
 						color : '#35BEB5'
 					}
 				}  
 			}, {
 				name : '正向无功电度',
 				type : 'bar',
 				smooth : true,
 				data : yqhi,
 				yAxisIndex : 1,
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

 		myChart2.setOption(option);

 	}	
 	 
</script>		
		
	</body>
</html>
