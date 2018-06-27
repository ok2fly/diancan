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
		<title></title>
			<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
			
	</head>
<body class="pl8t0 bgfc">
		<input type="hidden" id="id" value="${id}"> 
		<input type="hidden" id="equNum" value="${equNum}">
		
		<div class="dc-center">
			<div class="ene-equ bor-radius">
				<div class="a44"><p>工作状态</p></div>
				<div class="b1 borRight">
						<img src="<%=basePath %>img/jkicon.png" />
						<div class="b3">
							<p>健康状态</p>
							<h1 id="healthStat"  style="margin-top: 25px;">--</h1>
						</div>
				</div>
				<div class="b1">
					<img src="<%=basePath %>img/sbyxicon.png" />
					<div class="b3">
						<p>设备状态</p>
						<h1 id="stat"  style="margin-top: 25px;">--</h1>
					</div>
				</div>
			</div>
			
			<div class="ene-table bor-radius">
				<div class="a4"><p>工作信息</p></div>
				<div class="box">
					<div class="box-box1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/dyicon.png" width="50px"/>
							<div class="box-test">
							<p>电压1(V)</p>						
							<h1 id="ua1">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/dyicon.png" width="50px"/>
							<div class="box-test">
							<p>电压2(V)</p>						
							<h1 id="ua2">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/plicon.png" width="50px"/>
							<div class="box-test">
							<p>频率1(Hz)</p>						
							<h1 id="freq1">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/plicon.png" width="50px"/>
							<div class="box-test">
							<p>频率2(Hz)</p>						
							<h1 id="freq2">0.00</h1>
							</div>
						</div>
					</div>
					
				</div>

			</div>
			<%-- 
			<div class="dc-realtime bor-radius">
					<div class="a4"><p>实时数据</p></div>
					<div class="b1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/plicon.png" />
							<div class="b3">
								<p>频率1(Hz)</p>
								<h2 id="freq1" style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
					<div class="b1">
						<div class="borleft">
							<img src="<%=basePath %>img/plicon.png" />
							<div class="b3">
								<p>频率2(Hz)</p>
								<h2 id="freq2" style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
		
					<div class="b1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/dyicon.png"/>
							<div class="b3">
								<p>电压1(V)</p>
								<h2 id="ua1" style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
					<div class="b1">
						<div class="borleft">
							<img src="<%=basePath %>img/dyicon.png"/>
							<div class="b3">
								<p>电压2(V)</p>
								<h2 id="ua2" style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
			</div>
					 --%>
			<div class="sto-foot11 bor-radius mb50">
				<div class="a44"><p>电压</p></div>
				<div class="dydl" id="abc"></div>
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

<script>
$(function(){
	var id=$("#id").val();
	var equNum=$("#equNum").val();
	getReal(equNum);
	getEqu(equNum);
	getUABC(equNum);
})

function getReal(equNum){
	$.ajax({
		url:url+"getDctdevId.htm",
		type:"post",
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data){
					for(var i=0;i<data.data.length;i++){
						var d=data.data[i];
						if(d != undefined){
							var stat = d.stat == 0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "设备告警" : d.stat == 3 ? "解列保护" :"--";
							$("#stat").html(stat);
							var healthStat = d.healthStat == 1 ?"优秀": d.healthStat == 2 ? "良好" :d.healthStat == 3 ? "中" : d.healthStat == 4 ? "差" :"--";
							$("#healthStat").html(healthStat);
							$("#ua1").html(getFixedNum(d.ua1));
							$("#ub1").html(getFixedNum(d.ub1));
							$("#uc1").html(getFixedNum(d.uc1));
							$("#ua2").html(getFixedNum(d.ua2));
							$("#ub2").html(getFixedNum(d.ub2));
							$("#uc2").html(getFixedNum(d.uc2));
							$("#freq1").html(getFixedNum(d.freq1));
							$("#freq2").html(getFixedNum(d.freq2));
							$("#crtTim").html(getLocalDateAndTime(d.crtTim,3)); 
						}
					}
				}
			
			}else{
				layer.alert(data.data);
			}
		}
	})
}

function getEqu(equNum){
	$.ajax({
		url:url+"getDctdevInfoNewById.htm",
		type:"post",
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data){
					for(var i=0;i<data.data.length;i++){
						var a=data.data[0];
						if(a != null){
							$("#rtd_pow").html(getFixedNum(a.rtd_pow)+"kW");
							$("#app_mod").html(getIsNull(a.app_mod));
							$("#man_nam").html(getIsNull(a.man_nam));
							$("#equ_num").html(getIsNull(a.equ_cod));
							$("#pur_tim").html(getIsNull(getLocalDateAndTime(a.ope_tim,2)));
						}else{
							$("#rtd_pow").html("无");
							$("#app_mod").html("无");
							$("#man_nam").html("无");
							$("#equ_num").html("无");
							$("#pur_tim").html("无");
						}
					
					}
					setChart(data.data);
				}
				
			}else{
				layer.alert(data.desc);
			}
		}
		
	})
}


function getUABC(equNum){
	$.ajax({
		url:url+"getDctdevNow.htm",
		type:"post",
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data){
					setChart(data.data);
				}
				
			}else{
				layer.alert(data.desc);
			}
		}
		
	})
}
function setChart(chartData) {

	var xTime = [];
	var yua1 = [];
	var yua2 = [];

	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		xTime.push(getLocalDateAndTime(one.tol_tim, 6));
		yua1.push(getFixedNum5(one.ua1));
		yua2.push(getFixedNum5(one.ua2));

	}

	var myChart = echarts.init(document.getElementById('abc'), 'shine');
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
		} ],
		legend: {
		     data:['电压1','电压2'],
		     top:10
		},
		series : [ {
			name : '电压1',
			type : 'line',
			smooth : true,
			data : yua1,
			symbol : 'none' ,
			itemStyle : {
				normal : {
					color : '#EDB213'
				}
			}
		}, {
			name : '电压2',
			type : 'line',
			smooth : true,
			data : yua2,
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

 
function xiangqing(){
	var equNum=$("#equNum").val();
	
		layer.open({
			  type: 2,
			  skin: 'layer-class' ,
			  title:"设备详情",
			  shadeClose: false,
			  area: ['770px','450px'],
			  content: "<%=basePath%>/commens/zhjk/sb/xq/jl.htm?equNum="+equNum   //iframe的url
		});
		
	
}
</script>
</body>
</html>