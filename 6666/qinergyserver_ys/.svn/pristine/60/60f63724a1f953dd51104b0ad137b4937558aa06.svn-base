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
						<p>电压</p>
						<input type="text" id="dateTime_sta" placeholder="请选择时间" class="fr  Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData,maxDate:'%y-%M-%d'})">
					</div>
					<div class="his-img" id="dy"></div>
				</div>
				<div class="his-table">
					<div   style="height:285px;">
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>A相电压1(V)</th>
								<th>B相电压1(V)</th>
								<th>C相电压1(V)</th>
								<th>A相电压2(V)</th>
								<th>B相电压2(V)</th>
								<th>C相电压2(V)</th>
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
				<div class="tcdPageCode" id="tcdPageCode1">
				
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
 		$("#dateTime_sta").val(result);
 		getData();
 		
 		$("#sta_tim_bw").val(result);
 		$("#end_tim_bw").val(result);
 		getBwData()
 	})
 	
 	function getGraph(){
 		var param = "equ_num="+equNum;
 	 
 		var sjlx = 3;
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&year="+dateTime_sta+"&type="+sjlx;
			$.ajax({
		    	url:url+"getDctdevInfoByDayGraph.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			 setChart(data.data);
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
 	}
 	
 	var countAll = 0;
	var currentPage  = 1;
 	function getData(){
 		var param = "equ_num="+equNum;
 	 
 		var sjlx = 3;
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&year="+dateTime_sta+"&type="+sjlx;
			param += "&currentPage="+currentPage;
			$.ajax({
		    	url:url+"getDctdevInfoByDayList.htm",
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
	    						 if(i < 10){
		    						 htmlList1 += "<tr>"+
		    						 	"<td>"+((currentPage-1)*10+i+1)+"</td>"+
		    						 	"<td>"+getLocalDateAndTime(lst.crtTim, 6)+"</td>"+
										"<td>"+getFixedNum5(lst.ua1)+"</td>"+
										"<td>"+getFixedNum5(lst.ub1)+"</td>"+
										"<td>"+getFixedNum5(lst.uc1)+"</td>"+
										"<td>"+getFixedNum5(lst.ua2)+"</td>"+
										"<td>"+getFixedNum5(lst.ub2)+"</td>"+
										"<td>"+getFixedNum5(lst.uc2)+"</td>"+
										"</tr>";
		    						  $("#list1").append(htmlList1);
	    						 }
	    					 }
	    					 $("#tcdPageCode1").createPage({
	 	 				        pageCount:countAll,
	 	 				        current:currentPage,
	 	 				        backFn:function(p){
	 	 				        	currentPage = p;
	 	 				        	getData(equNum);
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
		    			 getGraph();
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}else{
			$.ajax({
		    	url:url+"getDctdevNow.htm",
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
									"<td>"+getLocalDateAndTime(lst.crtTim, 6)+"</td>"+
									"<td>"+getFixedNum5(lst.ua1)+"</td>"+
									"<td>"+getFixedNum5(lst.ub1)+"</td>"+
									"<td>"+getFixedNum5(lst.uc1)+"</td>"+
									"<td>"+getFixedNum5(lst.ua2)+"</td>"+
									"<td>"+getFixedNum5(lst.ub2)+"</td>"+
									"<td>"+getFixedNum5(lst.uc2)+"</td>"+
									"</tr>";
	    						  $("#list1").append(htmlList1);
	    					 }
	    					 $("#tcdPageCode1").createPage({
		 	 				        pageCount:countAll,
		 	 				        current:currentPage,
		 	 				        backFn:function(p){
		 	 				        	currentPage = p;
		 	 				        	getData(equNum);
		 	 				        }
		 	 			    	});
		    			 }
		    			 
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
 	
 	}
 	

 	function setChart(chartData) {

 		var xTime = [];
 		var ua1 = [];
 		var ub1 = [];
 		var uc1 = [];
 		var ua2 = [];
 		var ub2 = [];
 		var uc2 = [];
 		for (var i = 0; i < chartData.length; i++) {
 			var one = chartData[i];
 			xTime.push(getLocalDateAndTime(one.tol_tim, 6));
 			ua1.push(getFixedNum5(one.ua1));
 			ub1.push(getFixedNum5(one.ub1));
 			uc1.push(getFixedNum5(one.uc1));
 			ua2.push(getFixedNum5(one.ua2));
 			ub2.push(getFixedNum5(one.ub2));
 			uc2.push(getFixedNum5(one.uc2));
 		}

 		var myChart = echarts.init(document.getElementById('dy'), 'shine');
 		option = {

 			tooltip : {
 				trigger : 'axis'
 			},
 			grid : {
 				left : '60',
 				top : '40',
 				right : '60',
 				bottom : '30'
 			},
 			 legend: {
 			        data: ['电压1', '电压2'],
 			        top: 10,
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
 					} 
 			],
 			series : [ {
 				name : '电压1',
 				type : 'line',
 				smooth : true,
 				data : ua1,
 				symbol : 'none',
 				itemStyle : {
 					normal : {
 						color : '#EDB213'
 					}
 				}  
 			}, {
 				name : '电压2',
 				type : 'line',
 				smooth : true,
 				data : ua2,
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
</script>		
		
	</body>
</html>
