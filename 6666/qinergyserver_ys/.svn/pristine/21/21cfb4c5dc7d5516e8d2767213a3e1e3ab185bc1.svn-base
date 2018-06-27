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
						<input type="text" id="crtTim" placeholder="请选择时间" class="fr  Wdate"    onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData,maxDate:'%y-%M-%d'})">
					</div>
					<div class="his-img" id="wd"></div>
				</div>
				<div class="his-table-body">
					<div class="a44">
						<p>离散率</p>
						<!-- <input type="text" id="crtTim" placeholder="请选择时间" class="fr  Wdate"    onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData})"> -->
					</div>
					<div class="his-img" id="lsl"></div>
				</div>
			</div>
			
			<div class="his-table">
				<div >
					<table  width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>序号</th>
							<th>时间</th>
							<th>电压(V)</th>
							<th>电流(A)</th>
							<th>功率(kW)</th>
							<th>温度(℃)</th>
							<th>离散率(%)</th>
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
							</tr>
							<tr>
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
							</tr>
							<tr>
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
							</tr>
							<tr>
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
							</tr>
							<tr>
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
$(function(){
	var result=getDateToday();
	$("#crtTim").val(result);
	getData();
	
	$("#sta_tim_bw").val(result);
	$("#end_tim_bw").val(result);
	getBwData()
})

function getGraph(){
	var equNum = $("#equNum").val();
	var crtTim = $("#crtTim").val();
	var param = "equ_num="+equNum;
	if(crtTim != undefined && crtTim != ""){
		param += "&date="+crtTim;
		$.ajax({
			url:url+"getIscsBoxTempDisRateCurvesHistory.htm",
			type:"post",
			data:param,
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					setChart(data.data);
				}else{
					layer.alert(data.desc);
				}
				//$("#list1").html(html);
			}
		})
	}else{
		layer.alert("请选择时间");
	}
} 

var countAll = 0;
var currentPage  = 1;
function getData(){
	var equNum = $("#equNum").val();
	var crtTim = $("#crtTim").val();
	var param = "equ_num="+equNum;
	if(crtTim != undefined && crtTim != ""){
		param += "&date="+crtTim;
		param += "&currentPage="+currentPage;
		$.ajax({
			url:url+"getIscsBoxTempDisRateCurvesHistoryLst.htm",
			type:"post",
			data:param,
			dataType:"json",
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
								"<td>"+getLocalDateAndTime(lst.tol_tim,6)+"</td>"+
								"<td>"+getFixedNum5(lst.udc)+"</td>"+
								"<td>"+getFixedNum5(lst.idc)+"</td>"+
								"<td>"+getFixedNum5(lst.pdc)+"</td>"+
								"<td>"+getFixedNum3(lst.temp)+"</td>"+
								"<td>"+getFixedNum5(lst.disRate)+"</td>"+
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
		layer.alert("请选择时间");
	}
} 

function setChart(chartData) {

	var xTime = [];
	var y1 = [];
	var y2 = [];
	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		xTime.push(getLocalDateAndTime(one.tol_tim, 6));
		y1.push(getFixedNum3(one.temp));
		y2.push(getFixedNum5(one.disRate));
		 
	}

	var myChart = echarts.init(document.getElementById('wd'), 'shine');
	var myChart2 = echarts.init(document.getElementById('lsl'), 'shine');

	option = {
		grid : {
			left : '60',
			top : '40',
			right : '60',
			bottom : '30'
		},
		tooltip : {
			trigger : 'axis'
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
	 	legend: {
	        data:['温度'],
	        top: 10,
	    },
		series : [ {
			name : '温度',
			type : 'line',
			smooth : true,
			data : y1,
			symbol : 'none',
			itemStyle : {
				normal : {
					color : '#EDB213'
				}
			}  
		} 
		]
	};
	
	
	option2 = {
			grid : {
				left : '60',
				top : '40',
				right : '60',
				bottom : '30'
			},
			tooltip : {
				trigger : 'axis'
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
							name : '离散率(%)',
							axisLabel : {
							formatter : '{value}'
							}
						},
					
			],
			legend: {
		        data:['离散率'],
		        top: 10,
		    },
			series : [ {
				name : '离散率',
				type : 'line',
				smooth : true,
				data : y2,
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
	myChart2.setOption(option2);


}		 	 
 	
</script>		
		
	</body>
</html>
