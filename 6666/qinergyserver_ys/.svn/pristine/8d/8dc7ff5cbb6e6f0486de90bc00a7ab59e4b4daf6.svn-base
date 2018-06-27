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
						<input type="text" id="sta_tim"  placeholder="请选择时间" class="fr  Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData,maxDate:'%y-%M-%d'})" >
					</div>
					<div class="his-img" id="dydl"></div>
				</div>
			 	<!-- <div class="his-table"> -->
				<!-- <div style="height:285px;" >
					<table  width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>序号</th>
							<th>时间</th>
							<th>交流电压(V)</th>
							<th>交流电流(A)</th>
							<th>直流电压(V)</th>
							<th>直流电流(A)</th>
							<th>有功功率(kW)</th>
							<th>无功功率(kVar)</th>
							<th>总直流功率(kW)</th>
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
							</tr>
						</tbody>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode1"></div>  -->
			 <!-- </div> -->
			 </div>
			 <div class="cler"></div>
			<div style="width:100%; float:left;">
				<div class="his-table-body">
					<div class="a44">
						<p>有功无功</p>
						<!-- <input type="text" id="sta_tim2" placeholder="请选择时间" class="fr  Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData2,maxDate:'%y-%M-%d'})"> -->
					</div>
					<div class="his-img" id="ygwg"></div>
				</div>
				<div class="his-table" >
				<div style="height:285px;">
					<table  width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>序号</th>
							<th>时间</th>
							<th>交流电压(V)</th>
							<th>交流电流(A)</th>
							<th>直流电压(V)</th>
							<th>直流电流(A)</th>
							<th>有功功率(kW)</th>
							<th>无功功率(kVar)</th>
							<th>总直流功率(kW)</th>
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
$(function(){
	var result=getDateToday();
	$("#sta_tim").val(result);
	$("#sta_tim2").val(result);
	getData();
	/* getData2();*/
	
	$("#sta_tim_bw").val(result);
	$("#end_tim_bw").val(result);
	getBwData() ;
})

function getData(){
	var sta_tim = $("#sta_tim").val();
	var equNum = $("#equNum").val();
 
	var param="equ_num="+equNum ;
	 
	if(sta_tim != undefined && sta_tim != ""){
		param += "&date="+sta_tim;
		$.ajax({
			url:url+"getIscsPvsAcDcPIVDisRateCurvesHistory.htm",
			type:"post",
			data:param,
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					setChart(data.data);
				}else{
					layer.alert(data.desc);
				}
			}
		})
	}else{
		layer.alert("请选择时间");
		return;
	}
	getData2();
	currentPage  = 1;
	getGraph();
}
var countAll = 0;
var currentPage  = 1;
function getGraph(){
	var sta_tim = $("#sta_tim").val();
	var equNum = $("#equNum").val();
 
	var param="equ_num="+equNum ;
	 
	if(sta_tim != undefined && sta_tim != ""){
		param += "&date="+sta_tim;
		param += "&currentPage="+currentPage;
		$.ajax({
			url:url+"getIscsPvsAcDcPIVDisRateCurvesHistoryLst.htm",
			type:"post",
			data:param,
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
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
								"<td>"+getFixedNum5(lst.uab)+"</td>"+
								"<td>"+getFixedNum5(lst.ia)+"</td>"+
								"<td>"+getFixedNum5(lst.udc1)+"</td>"+
								"<td>"+getFixedNum5(lst.idc1+lst.idc2+lst.idc3+lst.idc4+lst.idc5+lst.idc6+lst.idc7+lst.idc8+lst.idc9+lst.idc10)+"</td>"+
								"<td>"+getFixedNum5(lst.psum)+"</td>"+
								"<td>"+getFixedNum5(lst.qsum)+"</td>"+
								"<td>"+getFixedNum5(lst.pdcSum)+"</td>"+
								"<td>"+getFixedNum5(lst.disRate)+"</td>"+
								"</tr>";
    						  $("#list1").append(htmlList1);
    					 }
    					 
	    				 
	   					$("#tcdPageCode1").createPage({
	 				        pageCount:countAll,
	 				        current:currentPage,
	 				        backFn:function(p){
	 				        	currentPage = p;
	 				        	getGraph();
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
				}else{
					layer.alert(data.desc);
				}
			}
		})
	}else{
		layer.alert("请选择时间");
		return;
	}
}

function getData2(){
	var sta_tim2 = $("#sta_tim").val();
	var equNum = $("#equNum").val();
 
	var param="equ_num="+equNum ;
	 
	if(sta_tim2 != undefined && sta_tim2 != ""){
		param += "&date="+sta_tim2;
		$.ajax({
			url:url+"getIscsPvsAcDcPIVDisRateCurvesHistory.htm",
			type:"post",
			data:param,
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					setChart3(data.data);
				}else{
					layer.alert(data.desc);
				}
				 
			}
		})
	}else{
		layer.alert("请选择时间");
		return;
	}
	
}

function setChart(chartData) {

	var xTime = [];
	var yU = [];
	var yA = [];
	var yZU = [];
	var yZA = [];
	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		xTime.push(getLocalDateAndTime(one.tol_tim, 6));
		yU.push(getFixedNum5(one.uab));
		yA.push(getFixedNum5(one.ia));
		yZU.push(getFixedNum5(one.udc1));
		yZA.push(getFixedNum5(one.idc1+one.idc2+one.idc3+one.idc4+one.idc5+one.idc6+one.idc7+one.idc8+one.idc9+one.idc10));
	}

	var myChart = echarts.init(document.getElementById('dydl'), 'shine');
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
	        data: ['交流电压', '交流电流','直流电压', '直流电流'],
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
					color : '#EDB213'
				}
			}  
		}, {
			name : '交流电流',
			type : 'line',
			smooth : true,
			yAxisIndex : 1,
			data : yA,
			symbol : 'none',
			itemStyle : {
				normal : {
					color : '#35BEB5'
				}
			}  
		}, {
			name : '直流电压',
			type : 'line',
			smooth : true,
			data : yZU,
			symbol : 'none',
			itemStyle : {
				normal : {
					color : '#5FB0E3'
				}
			}  
		}, {
			name : '直流电流',
			type : 'line',
			smooth : true,
			yAxisIndex : 1,
			data : yZA,
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


function setChart3(chartData) {

	var xTime = [];
	var yP = [];
	var yQ = [];
	
 
	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		xTime.push(getLocalDateAndTime(one.tol_tim, 6));
		yP.push(getFixedNum5(one.psum));
		yQ.push(getFixedNum5(one.qsum));
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
				},
				{
					type : 'value',
					name : '无功(KVar)',
					axisLabel : {
					formatter : '{value}'
					}
				} 
		],
		series : [ {
			name : '有功',
			type : 'line',
			smooth : true,
			data : yP,
			symbol : 'none',
			itemStyle : {
				normal : {
					color : '#35BEB5'
				}
			}  
		}, {
			name : '无功',
			type : 'line',
			smooth : true,
			yAxisIndex : 1,
			data : yQ,
			symbol : 'none',
			itemStyle : {
				normal : {
					color : '#5FB0E3' 
                }
			} ,
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


function setChart2(chartData) {

	var xTime = [];
	var yw = [];
	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		xTime.push(getLocalDateAndTime(one.crtTim, 2));
		yw.push(one.powerDay);
	}

	var myChart2 = echarts.init(document.getElementById('dl'), 'shine');
	option2 = {

		tooltip : {
			trigger : 'axis'
		},
		grid : {
			left : '60',
			top : '10',
			right : '60',
			bottom : '20'
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
						name : '电量',
						axisLabel : {
						formatter : '{value}'
						}
					}
		],
		series : [ {
			name : '电压',
			type : 'bar',
			smooth : true,
			 symbol : 'none',
			data : yw
		}

		]
	};

	myChart2.setOption(option2);

}		
 	
</script>		
		
	</body>
</html>
