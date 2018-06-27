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
						<input type="text" id="dateTime_sta" placeholder="请选择时间" class="fr  Wdate"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData,maxDate:'%y-%M-%d'})"> 
					</div>
					<div class="his-img" id="dldyChart">暂无数据</div>
				</div>
				<div class="his-table">
					<div  style="height:285px;">
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>电压(V)</th>
								<th>电流(A)</th>
								<th>功率(kW)</th>
								<th>soc(%)</th>
							</tr>
							<tbody id="list1">
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
		getData(equNum);
		
		$("#sta_tim_bw").val(result);
		$("#end_tim_bw").val(result);
		getBwData()
 	})
 	 
 	 
 	var countAll = 0;
 	var currentPage  = 1;
 	function getData(){
 		equNum=$("#equNum").val();
 		var param = "equ_num="+equNum;
 	 
 		var sjlx = 3;
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&year="+dateTime_sta+"&type="+sjlx;
			param += "&currentPage="+currentPage;
		}
 	
 		$.ajax({
	    	url:url+"getBmsInfoByYearList.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			countAll = data.totalPage;
					currentPage = data.currentPage;
	    			 if(data.data){
	    				 var da = data.data;
	    				 if(da.length > 0 ){
	    					 $("#list1").empty();
	    					 for(var i = 0 ; i < da.length ; i++){
	    						 var htmlList1 = "";
	    						 var lst = da[i];
	    						 htmlList1 += "<tr>"+
	    							"<td>"+((currentPage-1)*10+i+1)+"</td>"+
									"<td>"+getLocalDateAndTime(lst.crtTim,6)+"</td>"+
									"<td>"+getFixedNum5(lst.udc)+"</td>"+
									"<td>"+getFixedNum5(lst.idc)+"</td>"+
									"<td>"+getFixedNum5(lst.pdc)+"</td>"+
									"<td>"+getFixedNum5(lst.soc)+"</td>"+
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
	    				 }else{
			 					var h = "<tr>"+
								"<td>暂无数据</td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
								"<td></td>"+
							"</tr>";
							$("#list1").html(h);
							$("#tcdPageCode1").empty();
						}
	    			 }
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	    setChart();
 	}
 	
 	function setChart(){
 		equNum=$("#equNum").val();
 		var param = "equ_num="+equNum;
 	 	 
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&year="+dateTime_sta;
		}
 		
 		$.ajax({
	    	url:url+"getBmsInfoByDayGraph.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 
	    			 if(data.data.length> 0){
	    				var xData= [];
    			 		var yDlData= [];
    			 		var yDyData= [];
    					for(var i = 0 ; i<data.data.length;i++){
	    				 	var da = data.data[i];
    			 			xData.push(getLocalDateAndTime(da.tol_tim,6));
    			 			yDlData.push(getFixedNum5(da.idc));
    			 			yDyData.push(getFixedNum5(da.udc));
    					}
    			 		var myChart=echarts.init(document.getElementById('dldyChart'),'shine');
    			 		option = {
    			 			    tooltip : {
    			 			        trigger: 'axis'
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
    			 			            name:'电流',
    			 			            type:'line',
    			 			            yAxisIndex: 1,
    			 			            data:yDlData,
    			 						symbol : 'none',
    			 						itemStyle : {
    			 							normal : {
    			 								color : '#EDB213'
    			 							}
    			 						}  
    			 			        }, 
    			 			        {
    			 			            name:'电压',
    			 			            type:'line',
    			 			            data:yDyData,
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
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 			                    
 	}
 	
</script>		
		
	</body>
</html>
