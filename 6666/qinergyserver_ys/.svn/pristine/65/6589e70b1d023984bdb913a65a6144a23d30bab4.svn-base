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
			<div class="his-table" style="height: 390px;">
				<div class="a1"  >
					<div class="fl"><h4 style="line-height:35px;font-weight: normal;">充电订单信息</h4></div>
					<div class="fr"> 
						<input type="text"  id="sta_tim"  placeholder="开始时间" class=" Wdate" style="width: 108px;padding-left: 5px;height: 30px; line-height: 30px;    border-radius: 3px;"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim\')||\'%y-%M-%d\'}'})">
						<span style="color:#999">---</span>
						<input type="text"  id="end_tim" placeholder="结束时间" class=" Wdate" style="width: 108px;padding-left: 5px;height: 30px; line-height: 30px;    border-radius: 3px;"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sta_tim\')}',maxDate:'%y-%M-%d'})"> 
						<input class="his-btn"  id="his-btn" type="submit" value="查询">
					</div>
				</div>
				<div  style="height:285px;">
					<table  width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>序号</th>
							<th>订单号</th>
							<th>充电开始时间</th>
							<th>充电结束时间</th>
							<th>充电时长(h)</th>
							<th>充电电量(kWh)</th>
							<th>充电金额(元)</th>
							<th>操作</th>
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
				<div class="tcdPageCode" id="tcdPageCode">
				
				</div> 
			</div>
			<div class="cler"></div>
			<div id="dydlqx" style="display:none" >
				<div class="his-table" style="height:230px;">
					<div class="a44">
						<p>详细信息</p>
					</div>
					<table  width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>订单号</th>
							<td id="orderNo"></td>
							<th>充电开始时间</th>
							<td id="beginTime"></td>
						</tr>
						<tr>
							<th>充电结束时间</th>
							<td id="endTime"></td>
							<th>充电时长(h)</th>
							<td id="time"></td>
						</tr>
						<tr>
							<th>充电电量(kWh)</th>
							<td id="power"></td>
							<th>充电金额(元)</th>
							<td id="money"></td>
						</tr>
						<tr>
							<th>结束原因</th>
							<td id="endReason"></td>
							<th>支付方式</th>
							<td id="payWay"></td>
						</tr>
						<tr>
							<th>创建时间</th>
							<td id="tol_tim" ></td>
							<th>&nbsp;&nbsp;</th>
							<td >&nbsp;&nbsp;</td>
						</tr>
					</table>
				</div>
				<div class="his-table-body">
					<div class="a44">
						<p>电压电流</p>
						<!-- <input type="text" id="sta_tim2" placeholder="请选择时间" class="fr  Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData2,maxDate:'%y-%M-%d'})"> -->
					</div>
					<div class="his-img" id="dydl"></div>
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
	$("#end_tim").val(result);
	getData();
	
	$("#sta_tim_bw").val(result);
	$("#end_tim_bw").val(result);
	getBwData();
	
	$("#his-btn").click(function(){
		currentPage  = 1;
		getData();
	})
})

var countAll = 0;
var currentPage  = 1;
function getData(){
	var equNum = $("#equNum").val();
	var sta_tim = $("#sta_tim").val();
	var end_tim = $("#end_tim").val();
	var param = "equ_num="+equNum;
	if($("#sta_tim").val()!=""){
		param+="&&sta_tim="+$("#sta_tim").val();
	}
	if($("#end_tim").val()!=""){
		param+="&&end_tim="+$("#end_tim").val();
	}
	
	param +="&currentPage="+currentPage;
	if($("#end_tim").val()!="" && $("#sta_tim").val()!=""){
		$.ajax({
			url:url+"getIscsAcchpOrdInfLst.htm",
			type:"post",
			data:param,
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length > 0){
						countAll = data.totalPage;
						currentPage = data.currentPage;
						var html="";
						for(var i=0;i<data.data.length;i++){
							var d =  data.data[i];
							var payWay = d.payWay == 0 ? "刷卡" : d.payWay == 1 ? "扫码"  : "无" ;
							html+="<tr>"+
							"<td>"+((currentPage-1)*10+i+1)+"</td>"+
							"<td>"+d.orderNo+"</td>"+
							"<td>"+getLocalDateAndTime(d.beginTime,1)+"</td>"+
							"<td>"+getLocalDateAndTime(d.endTime,1)+"</td>"+
							"<td>"+getFixedNum5(d.time/3600)+"</td>"+
							"<td>"+getFixedNum5(d.power)+"</td>"+
							"<td>"+getFixedNum5(d.money)+"</td>"+
							"<td><a onclick='showDet(&quot;"+d.orderNo+"&quot;,&quot;"+getLocalDateAndTime(d.beginTime,1)+"&quot;,&quot;"+getLocalDateAndTime(d.endTime,1)+"&quot;,&quot;"+getFixedNum(d.time)+"&quot;,&quot;"+getFixedNum(d.power)+"&quot;,&quot;"+getFixedNum(d.money)+"&quot;,&quot;"+d.endReason+"&quot;,&quot;"+payWay+"&quot;,&quot;"+getLocalDateAndTime(d.tol_tim,1)+"&quot;)'>查看详情</a></td>"+
							"</tr>" 
						}
						$("#list1").html(html);
						 
	  					$("#tcdPageCode").createPage({
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
						$("#tcdPageCode").empty();
					}
				}else{
					layer.alert(data.desc);
				}
			}
		})
	}else{
		layer.alert("请选择时间");
	}
}

function showDet(orderNo,beginTime,endTime,time,power,money,endReason,payWay,tol_tim){
	$("#orderNo").html(orderNo);
	$("#beginTime").html(beginTime);
	$("#endTime").html(endTime);
	$("#time").html(time);
	$("#power").html(power);
	$("#money").html(money);
	$("#endReason").html(endReason);
	$("#payWay").html(payWay);
	$("#tol_tim").html(tol_tim);
	showLine(orderNo);
}


function showLine(orderNo){
	var param  = "orderNo="+orderNo ;
	
	$.ajax({
		url:url+"getIscsAcchpRelUICurvesHistory.htm",
		type:"post",
		data:param,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				 setDldyChart(data.data);
			}else{
				layer.alert(data.desc);
			}
		}
	})
	
	$("#dydlqx").show();
}
 
function setDldyChart(chartData) {

	var xTime = [];
	var yU = [];
	var yA = [];
	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		xTime.push(getLocalDateAndTime(one.tol_tim, 3));
		yU.push(getFixedNum5(one.ua));
		yA.push(getFixedNum5(one.ia));
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
	        data: ['电压', '电流'],
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
			name : '电压',
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
			name : '电流',
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
		}

		]
	};

	myChart.setOption(option);

}		 
 	
</script>		
		
	</body>
</html>
