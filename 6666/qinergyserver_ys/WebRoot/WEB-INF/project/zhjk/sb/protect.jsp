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
		<title>线路 保护</title>
			<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
			
	</head>
<body class="pl8t0 bgfc">
		<input type="hidden" id="id" value="${id}"> 
		<input type="hidden" id="equNum" value="${equNum}"> 
		<div class="dc-center">
			<div class="dc-warm1 bor-radius ">
					<div class="a4"><p>告警牌</p></div>
					<div class="c1"  >
						<div class="borNoleft ">
							<table id="gjp1" style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
					<div class="c1" >
						<div class="borleft">
							<table id="gjp2" style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
					<div class="c1"  >
						<div class="borleft">
							<table id="gjp3" style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
			</div>
			<div class="ene-equ bor-radius">
				
				<div class="a44"><p>工作状态</p></div>
				<div class="b1 borRight">
						<img src="<%=basePath %>img/jkicon.png" />
					<div class="b3">
						<p>健康状态</p>
						<h1 id="healthStat" style="margin-top: 25px;">--</h1>
					</div>
				</div>
				<div class="b1">
					<img src="<%=basePath %>img/sbyxicon.png" />
					<div class="b3">
						<p>设备状态</p>
						<h1 id="stat" style="margin-top: 25px;">--</h1>
					</div>
				</div>
			</div>
			
			<div class="dc-high2 bor-radius">
				<div class="a4"><p>待机数据</p></div>
				<div class="a11">
					<div class="borleft">
						<img src="<%=basePath %>img/dyicon.png" width="50px"/>
						<div class="a5">
							<p>电压(V)</p>
							<h1 id="ua">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a11">
					<div class="borleft">
						<img src="<%=basePath %>img/dlicon.png" width="50px"/>
						<div class="a5">
							<p>电流(A)</p>
							<h1 id="ia">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a11" >
					<div class="borleft" >
						<img src="<%=basePath %>img/yg.png" width="50px"/>
						<div class="a5">
							<p>有功(kW)</p>
							<h1 id="psum">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a11">
					<div class="borleft">
						<img src="<%=basePath %>img/yg.png" width="50px"/>
						<div class="a5">
						<p>无功(kVar)</p>						
						<h1 id="qsum">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a11"  >
					<div class="borleft">
						<img src="<%=basePath %>img/plicon.png" width="50px"/>
						<div class="a5">
						<p>频率(Hz)</p>						
						<h1 id="freq">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a11" >
					 <div class="borleft">
					 </div>
				</div>
			</div>
			
			<div class="sto-foot11 bor-radius">
				<div class="a44"><P>电压电流</P></div>
				<div class="dydl" id="didy"></div>
			</div>
			<div class="sto-foot11 bor-radius mb50">
				<div class="a44"><p>有功无功</p></div>
				<div class="dydl" id="gl"></div>
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

<script >
$(function(){
	var id=$("#id").val();
	var equNum=$("#equNum").val();
	getEqu(equNum);
	getReal(equNum);
	getRelFauLst(equNum);

})
function getReal(equNum){
	$.ajax({
		url:url+"getLnepttById.htm",
		type:"post",
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data){
					for(var i=0;i<data.data.length;i++){
						var d=data.data[i];
						if(d != undefined ){
							$("#equ_num").html(d.equ_num);
							$("#faultCode").html(d.faultCode);
							
							$("#ua").html(getFixedNum(d.uab));
							$("#ia").html(getFixedNum(d.ia));
							$("#psum").html(getFixedNum(d.psum));
							$("#qsum").html(getFixedNum(d.qsum));
							$("#ssum").html(getFixedNum(d.ssum));
							$("#freq").html(getFixedNum(d.freq));
							var stat = d.stat == 0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "故障保护" :"--";
							$("#stat").html(stat);
							var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" : "--";   
							$("#healthStat").html(healthStat);
							$("#crtTim").html(getLocalDateAndTime(d.crtTim,2));
						}
					}
					getGraph(equNum);
					/* setChar(data.data);
					setChar2(data.data); */

				}
			}else{
				layer.alert(data.desc);
			}
		}
	})
}
function getGraph(equNum){
	$.ajax({
		url:url+"getLnepttNow.htm",
		type:"post",
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data){
					setChar(data.data);
					setChar2(data.data);
				}
			}else{
				layer.alert(data.desc);
			}
		}
	})
}

function setChar(chartData){
	var xTime=[];
	var yU1=[];
	var yI1=[];
	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		xTime.push(getLocalDateAndTime(one.tol_tim, 6));
		yU1.push(getFixedNum5(one.uab));
		yI1.push(getFixedNum5(one.ia));

	}

	var myChart = echarts.init(document.getElementById('didy'), 'shine');
	option = {

		tooltip : {
			trigger : 'axis'
		},
		grid : {
			left : '80',
			top : '60',
			right : '80',
			bottom : '30'
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xTime
		} ],
		yAxis : [ {
			type : 'value',
			name : '电压(V)',
			axisLabel : {
				formatter : '{value}'
			}
		} ,
		{
			type : 'value',
			name : '电流(A)',
			axisLabel : {
				formatter : '{value}'
			}
		} ],
		legend: {
		     data:['电压','电流'],
		     top : 10
		},
		series : [ {
			name : '电压',
			type : 'line',
			smooth : true,
			data : yU1,
		 	symbol : 'none' ,
			itemStyle : {
				normal : {
					color : '#EDB213'
				}
			}
		},{
			name : '电流',
			type : 'line',
			smooth : true,
			yAxisIndex : 1,
			data : yI1,
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

function setChar2(chartData){
	var xTime=[];
	var yP=[];
	var yQ=[];
	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		xTime.push(getLocalDateAndTime(one.tol_tim, 6));
		yP.push(getFixedNum5(one.psum));
		yQ.push(getFixedNum5(one.qsum));

	}

	var myChart2 = echarts.init(document.getElementById('gl'), 'shine');
	option = {

		tooltip : {
			trigger : 'axis'
		},
		grid : {
			left : '80',
			top : '60',
			right : '80',
			bottom : '30'
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xTime
		} ],
		yAxis : [ {
			type : 'value',
			name : '有功(kW)',
			axisLabel : {
				formatter : '{value}'
			}
		} ,{
			type : 'value',
			name : '无功(kVar)',
			axisLabel : {
				formatter : '{value}'
			}
		} ],
		legend: {
		     data:['有功','无功'],
		     top : 10
		},
		series : [ {
			name : '有功',
			type : 'line',
			smooth : true,
			data : yP,
		 	symbol : 'none' ,
			itemStyle : {
				normal : {
					color : '#EDB213'
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
					color : '#07CB47'
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
	myChart2.setOption(option);

}


function getEqu(equNum){
	
	$.ajax({
		url:url+"getEquInfByEquNum.htm",
		type:"post",
		data:"equ_num="+equNum,
		//data:"equ_num="+1,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
					var a=data.data[0];
					if(a != null){
						$("#rtd_pow").html(getFixedNum(a.rtd_pow)+"kW");
						$("#app_mod").html(getIsNull(a.app_mod));
						$("#man_nam").html(getIsNull(a.man_nam));
						$("#equ_num").html(getIsNull(a.equ_cod));
						$("#pur_tim").html(getIsNull(getLocalDateAndTime(a.ope_tim,2)));
						$("#lst_mat_tim").html(getLocalDateAndTime(a.lst_mat_tim,2));
						$("#fnl_mat_tim").html(getLocalDateAndTime(a.fnl_mat_tim,2));
						$("#nxt_mat_tim").html(getLocalDateAndTime(a.nxt_mat_tim,2));
					}else{
						$("#rtd_pow").html("无");
						$("#app_mod").html("无");
						$("#man_nam").html("无");
						$("#equ_num").html("无");
						$("#pur_tim").html("无");
						$("#lst_mat_tim").html("无");
						$("#fnl_mat_tim").html("无");
						$("#nxt_mat_tim").html("无");
					}
				
			}else{
	               layer.alert(data.desc);
			}
		}
	})
}
/* 获取告警牌信息  */
function getRelFauLst(equNum){
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
			  content: "<%=basePath%>/commens/zhjk/sb/xq/xlbh.htm?equNum="+equNum   //iframe的url
		});
		
	
}
</script>
</body>
</html>