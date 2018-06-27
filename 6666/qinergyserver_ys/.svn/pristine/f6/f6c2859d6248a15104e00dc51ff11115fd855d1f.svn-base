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
						<p>温度</p>
						<input type="text" id="dateTime_sta" placeholder="请选择时间" class="fr  Wdate"    onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData,maxDate:'%y-%M-%d'})">
					</div>
					<div class="his-img" id="wd"></div>
				</div>
				<div class="his-table-body">
					<div class="a44">
						<p>电压电流</p>
					</div>
					<div class="his-img" id="transfDyDl"></div>
				</div>
				<div class="his-table">
					<div style="height:285px;">
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>温度1(℃)</th>
								<th>温度2(℃)</th>
								<th>温度3(℃)</th>
								<th>电压1()</th>
								<th>电压2(V)</th>
								<th>电压3(V)</th>
								<th>电流1(A)</th>
								<th>电流2(A)</th>
								<th>电流3(A)</th>
							</tr>
							<tbody id="list2">
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
			<div style="width:100%; float:left;">
				<div class="his-table-body">
					<div class="a44">
						<p>有功无功</p>
					</div>
					<div class="his-img" id="ygwg"></div>
				</div>
				<div class="his-table">
					<div style="height:285px;">
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>有功功率1(kW)</th>
								<th>有功功率2(kW)</th>
								<th>有功功率3(kW)</th>
								<th>无功功率1(kVar)</th>
								<th>无功功率2(kVar)</th>
								<th>无功功率3(kVar)</th>
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
 		//getData2();
 		
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
	 		param += "&currentPage="+currentPage;
		} 
 		$.ajax({
	    	url:url+"getTransfHistoryInf.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data.length> 0){
	    				countAll = data.totalPage;
	 					currentPage = data.currentPage;
    					 $("#list1").empty();
    					 for(var i = 0 ; i < data.data.length ; i++){
    						 var htmlList1 = "";
    						 var lst = data.data[i];
    						 htmlList1 += "<tr>"+
    							"<td>"+((currentPage-1)*10+i+1)+"</td>"+
    						 	"<td>"+getLocalDateAndTime(lst.crtTim,6)+"</td>"+
								"<td>"+getFixedNum5(lst.psum1)+"</td>"+
								"<td>"+getFixedNum5(lst.psum2)+"</td>"+
								"<td>"+getFixedNum5(lst.psum3)+"</td>"+
								"<td>"+getFixedNum5(lst.qsum1)+"</td>"+
								"<td>"+getFixedNum5(lst.qsum2)+"</td>"+
								"<td>"+getFixedNum5(lst.qsum3)+"</td>"+
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
						"</tr>";
					$("#list1").html(h);
					$("#tcdPageCode1").empty();
				}
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	    getData2();
	    getGraph2();
 	}
 	
 	
 	var countAll2 = 0;
	var currentPage2  = 1;
 	
 	function getData2(){
 		equNum=$("#equNum").val();
 		var param = "equ_num="+equNum;
 	 
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&day="+dateTime_sta;
	 		param += "&currentPage="+currentPage2;
		} 
 		$.ajax({
	    	url:url+"getTransfHistoryInf.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data.length> 0){
	    				countAll2 = data.totalPage;
	 					currentPage2 = data.currentPage;
	    				 if(data.data.length > 0 ){
	    					 $("#list2").empty();
	    					 for(var i = 0 ; i < data.data.length ; i++){
	    						 var htmlList2 = "";
	    						 var lst = data.data[i];
	    						  
	    						  htmlList2 += "<tr>"+
	    							"<td>"+((currentPage-1)*10+i+1)+"</td>"+
	    						 	"<td>"+getLocalDateAndTime(lst.crtTim,6)+"</td>"+
									"<td>"+getFixedNum3(lst.temp1)+"</td>"+
									"<td>"+getFixedNum3(lst.temp2)+"</td>"+
									"<td>"+getFixedNum3(lst.temp3)+"</td>"+
									"<td>"+getFixedNum5(lst.uab1)+"</td>"+
									"<td>"+getFixedNum5(lst.uab2)+"</td>"+
									"<td>"+getFixedNum5(lst.uab3)+"</td>"+
									"<td>"+getFixedNum5(lst.ia1)+"</td>"+
									"<td>"+getFixedNum5(lst.ia2)+"</td>"+
									"<td>"+getFixedNum5(lst.ia3)+"</td>"+
									"</tr>";
	    						  $("#list2").append(htmlList2);
	    					 }
	    				 }
	    				 $("#tcdPageCode2").createPage({
	 				        pageCount:countAll2,
	 				        current:currentPage2,
	 				        backFn:function(p){
	 				        	currentPage2 = p;
	 				        	getData2();
	 				        }
	 			    	});
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
	    	url:url+"getTransfHistoryGraph.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data.length> 0){
	    				countAll = data.totalPage;
	 					currentPage = data.currentPage;
	    				/*  var da = data.data[0]; */
	    				 if(data.data.length > 0 ){
	    					 setChart1(data.data);
	    					 setChart2(data.data);
	    				 }
	    			 }
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 	
 	function getGraph2(){
 		var param = "equ_num="+equNum;
 	 
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&day="+dateTime_sta;
		} 
 		
 		
 		$.ajax({
	    	url:url+"getTransfHistoryGraph.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data.length> 0){
	    				/*  var da = data.data[0]; */
	    				 if(data.data.length > 0 ){
	    					 setChart3(data.data);
	    				 }
	    			 }
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 	
 	function setChart1(dydl) {

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
			        data: ['电压1','电压2', '电压3', '电流1', '电流2', '电流3'],
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
				name : '电压1',
				type : 'line',
				smooth : true,
				data : yU1,
				symbol : 'none',
				itemStyle : {
					normal : {
						color : '#EDB213'
					}
				}  
			}, 
			{
				name : '电压2',
				type : 'line',
				smooth : true,
				data : yU2,
				symbol : 'none',
				itemStyle : {
					normal : {
						color : '#07CB47'
					}
				}  
			},
			{
				name : '电压3',
				type : 'line',
				smooth : true,
				data : yU3,
				symbol : 'none',
				itemStyle : {
					normal : {
						color : '#FE784E'
					}
				}  
			},
			{
				name : '电流1',
				type : 'line',
				smooth : true,
				yAxisIndex : 1,
				data : yA1,
			 	symbol : 'none',
				itemStyle : {
					normal : {
						color : '#5FB0E3'
					}
				}  
			},
			{
				name : '电流2',
				type : 'line',
				smooth : true,
				yAxisIndex : 1,
				data : yA2,
			 	symbol : 'none',
				itemStyle : {
					normal : {
						color : '#7A057A'
					}
				}  
			},
			{
				name : '电流3',
				type : 'line',
				smooth : true,
				yAxisIndex : 1,
				data : yA3,
			 	symbol : 'none',
				itemStyle : {
					normal : {
						color : '#F4350D'
					}
				}  
			},

			]
		};

		myChart1.setOption(option);

	}
 	
 	function setChart2(dydl) {

		var xTime = [];
		var yTemp1 = [];
		var yTemp2 = [];
		var yTemp3 = [];
	 
		for (var i = 0; i < dydl.length; i++) {
			var d = dydl[i];
			xTime.push(getLocalDateAndTime(d.tol_tim, 6));
			yTemp1.push(getFixedNum3(d.temp1));
			yTemp2.push(getFixedNum3(d.temp2));
			yTemp3.push(getFixedNum3(d.temp3));

		}

		var myChart1 = echarts.init(document.getElementById('wd'), 'shine');
		option = {

			tooltip : {
				trigger : 'axis'
			},
			 legend: {
			        data: ['温度1', '温度2','温度3'],
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
					name : '温度(℃)',
					axisLabel : {
					formatter : '{value}'
					}
				} 
			],
		
			series : [ {
				name : '温度1',
				type : 'line',
				smooth : true,
				data : yTemp1,
				symbol : 'none',
				itemStyle : {
					normal : {
						color : '#EDB213'
					}
				}  
			}, 
			{
				name : '温度2',
				type : 'line',
				smooth : true,
				data : yTemp2,
				symbol : 'none',
				itemStyle : {
					normal : {
						color : '#07CB47'
					}
				}  
			},
			{
				name : '温度3',
				type : 'line',
				smooth : true,
				data : yTemp3,
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
 	
 	function setChart3(ygwg) {

		var xTime = [];
		var yPsum1 = [];
		var yPsum2 = [];
		var yPsum3 = [];
	 
		var yQsum1 = [];
		var yQsum2 = [];
		var yQsum3 = [];
	 
		for (var i = 0; i < ygwg.length; i++) {
			var d = ygwg[i];
			xTime.push(getLocalDateAndTime(d.tol_tim, 6));
			yPsum1.push(getFixedNum5(d.psum1));
			yPsum2.push(getFixedNum5(d.psum2));
			yPsum3.push(getFixedNum5(d.psum3));
			yQsum1.push(getFixedNum5(d.qsum1));
			yQsum2.push(getFixedNum5(d.qsum2));
			yQsum3.push(getFixedNum5(d.qsum3));

		}

		var myChart1 = echarts.init(document.getElementById('ygwg'), 'shine');
		option = {

			tooltip : {
				trigger : 'axis'
			},
			 legend: {
			        data: ['有功1', '有功2','有功3','无功1','无功2','无功3'],
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
				name : '有功1',
				type : 'line',
				smooth : true,
				data : yPsum1,
				symbol : 'none',
				itemStyle : {
					normal : {
						color : '#EDB213'
					}
				}  
			}, 
			{
				name : '有功2',
				type : 'line',
				smooth : true,
				data : yPsum2,
				symbol : 'none',
				itemStyle : {
					normal : {
						color : '#07CB47'
					}
				}  
			},
			{
				name : '有功3',
				type : 'line',
				smooth : true,
				data : yPsum3,
				symbol : 'none',
				itemStyle : {
					normal : {
						color : '#FE784E'
					}
				}  
			} ,
			{
				name : '无功1',
				type : 'line',
				smooth : true,
				yAxisIndex : 1,
				data : yQsum1,
			 	symbol : 'none',
				itemStyle : {
					normal : {
						color : '#5FB0E3'
					}
				}  
			},
			{
				name : '无功2',
				type : 'line',
				smooth : true,
				yAxisIndex : 1,
				data : yQsum2,
			 	symbol : 'none',
				itemStyle : {
					normal : {
						color : '#7A057A'
					}
				}  
			},
			{
				name : '无功3',
				type : 'line',
				smooth : true,
				yAxisIndex : 1,
				data : yQsum3,
			 	symbol : 'none',
				itemStyle : {
					normal : {
						color : '#F4350D'
					}
				}  
			},
			]
		};

		myChart1.setOption(option);

	}
</script>		
		
	</body>
</html>
