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
					<div class="his-img" id="dldyChart"></div>
				</div>
				<div class="his-table" >
					<div style="height:285px;">
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>高压侧电压(V)</th>
								<th>高压侧电流(A)</th>
								<th>高压侧功率(kW)</th>
								<th>低压侧电压(V)</th>
								<th>低压侧电流(A)</th>
								<th>低压侧功率(kW)</th>
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
							</tbody>
						</table>
					</div>
					<div class="tcdPageCode" id="tcdPageCode1"></div> 
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
								<td >暂无数据</td>
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
 		var result=getDateToday();
 		$("#dateTime_sta").val(result);
		getData();
		
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
			param += "&day="+dateTime_sta;
		} 
 		
 		param += "&currentPage="+currentPage;
 		$.ajax({
	    	url:url+"getDCDCHistoryInf.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			countAll = data.totalPage;
					currentPage = data.currentPage;
	    			 if(data.data.length> 0){
	    				 if(data.data.length > 0 ){
	    					 $("#list1").empty();
	    					 for(var i = 0 ; i < data.data.length ; i++){
	    						 var htmlList1 = "";
	    						 var lst = data.data[i];
	    						 htmlList1 += "<tr>"+
	    						 	"<td>"+((currentPage-1)*10+i+1)+"</td>"+
	    						 	"<td>"+getLocalDateAndTime(lst.crtTim,6)+"</td>"+
									"<td>"+getFixedNum5(lst.uHigh)+"</td>"+
									"<td>"+getFixedNum5(lst.iHigh)+"</td>"+
									"<td>"+getFixedNum5(lst.pHigh)+"</td>"+
									"<td>"+getFixedNum5(lst.uLow)+"</td>"+
									"<td>"+getFixedNum5(lst.iLow)+"</td>"+
									"<td>"+getFixedNum5(lst.pLow)+"</td>"+
									"</tr>";
	    						  $("#list1").append(htmlList1);
	    					 }
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
						"</tr>";
						$("#list1").html(h);
						$("#tcdPageCode1").empty();
					}
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	    getGraph();
 	}
 	
 	
 	function getGraph(){
 		var param = "equ_num="+equNum;
 	 
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&day="+dateTime_sta;
		} 
 		
 		$.ajax({
	    	url:url+"getDCDCHistoryGraph.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data.length> 0){
	    				 
	    				 setChart(data.data);
	    			 }
	    			 
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
 			yGyDyData.push(getFixedNum5(one.uHigh));
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
 					left : '60',
 					top : '40',
 					right : '60',
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
 			        },
 			        {
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
 			            yAxisIndex: 1,
 			            data:yGyDlData,
 			            symbol : 'none',
 						itemStyle : {
 							normal : {
 								color : '#EDB213'
 							}
 						}  
 			        },
 			       {
 			            name:'低压侧电流',
 			            type:'line',
 			            yAxisIndex: 1,
 			            data:yDyDlData,
 						symbol : 'none',
 						itemStyle : {
 							normal : {
 								color : '#35BEB5'
 							}
 						}  
 			        },
 			        {
 			            name:'高压侧电压',
 			            type:'line',
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
</script>		
		
	</body>
</html>
