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
		<title>直流充电桩</title>
			<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
			
</head>
<body class="pl8t0 bgfc">
		<input type="hidden" id="id" value="${id}"> 
		<input type="hidden" id="equNum" value="${equNum}">
		<div class="dc-center">
			<div class="dc-warm1 bor-radius">
				
					<div class="a4"><p>告警牌</p></div>
					<div class="c1">
						<div class="borNoleft ">
							<table id="gjp1"  style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
					<div class="c1">
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
						<h1 id="healthStat"  style="margin-top: 25px;">--</h1>
					</div>
				</div>
				<div class="b1">
					<img src="<%=basePath %>img/sbyxicon.png" />
					<div class="b3">
						<p>运行状态</p>
						<h1 id="stat"  style="margin-top: 25px;">--</h1>
					</div>
				</div>
			</div>
			<div class="ene-table2 bor-radius fl" style="margin-top:16px;">
					<div class="a44"><p>累计信息</p></div>
					<div class="box fl" style="border-bottom:1px solid #ccc;">
						<div class="box-box2" style="border-right:1px solid #ccc;">
							<img src="<%=basePath %>img/youxiao.png"   width="50px"/>
							<div class="box-test">
								<p>累计充电时间(h)</p>						
								<h1 id="cumTime">0.00</h1>
							</div>
						</div>
						<div class="box-box2">
							<img src="<%=basePath %>img/d.png"   width="50px"/>
							<div class="box-test">
								<p>累计充电电量(kWh)</p>						
								<h1 id="cumPower">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box fl" >
						<div class="box-box2" style="border-right:1px solid #ccc;">
							<img src="<%=basePath %>img/je--.png"   width="50px"/>
							<div class="box-test">
								<p>累计充电金额(元)</p>						
								<h1 id="cumMoney">0.00</h1>
							</div>
						</div>
						<div class="box-box2"  >
							<img src="<%=basePath %>img/youxiao.png"   width="50px"/>
							<div class="box-test">
								<p>有效充电小时数(h)</p>						
								<h1 id="validTime">0.00</h1>
							</div>
						</div>
					</div>
			</div>
			<%-- <div class="dc-realtime bor-radius">
					<div class="a44"><p>待机数据</p></div>
					<div class="b6">
						<div class="borRight" style="height:100%;  border-bottom: 1px solid #ccc;">
							<img src="<%=basePath %>img/je--.png" />
							<div class="b3">
								<p>累计充电金额(元)</p>
								<h2 id="cumMoney" style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
					<div class="b6">
						<div  style="height:100%;  border-bottom: 1px solid #ccc;">
							<img src="<%=basePath %>img/youxiao.png" />
							<div class="b3">
								<p>有效充电小时(h)</p>
								<h2 id="validTime" style="margin-top: 25px;">0.00</h2>
								
							</div>
						</div>
					</div>
					<div class="b2">
						<div class="borRight " style="height:100%;">
							<img src="<%=basePath %>img/d.png" />
							<div class="b3">
								<p>累计充电电量(kWh)</p>
								<h2 id="cumPower" style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
					<div class="b2">
						<div class="borRight" style="height:100%;">
							<img src="<%=basePath %>img/d.png" />
							<div class="b3">
								<p>累计充电时间(h)</p>
								<h2 id="cumTime" style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
					<div class="b2">
						<div class="" style="height:100%;">
							<img src="<%=basePath %>img/d.png" />
							<div class="b3">
								<p>枪运行状态</p>	
								<h2 id="gunStat" style="margin-top: 25px;">运行</h2>
							</div>
						</div>	
					</div>
			</div>	 --%>			
			<div class="ene-table bor-radius">
				<div class="a4"><p>实时数据</p></div>
				<div class="box">
					<div class="box-box1">
						<div class="borNoleft">
							<img src="<%=basePath %>img/dyicon.png" width="50px"/>
							<div class="box-test">
							<p>充电电压(V)</p>						
							<h1 id="udc">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/dlicon.png" width="50px"/>
							<div class="box-test">
							<p>充电电流(A)</p>						
							<h1 id="idc">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/yg.png" width="50px"/>
							<div class="box-test">
							<p>充电功率(kW)</p>						
							<h1 id="pdc">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft">
							<img src="<%=basePath %>img/youxiao.png" width="50px"/>
							<div class="box-test">
							<p>充电时长(h)</p>						
							<h1 id="time">0.00</h1>
							</div>
						</div>
					</div>
					
				</div>

			</div>
			<div class="ene-table bor-radius">
				<div class="box">
					
					<div class="box-box1">
						<div class="borNoleft borNotop">
							<img src="<%=basePath %>img/dyicon.png" width="50px"/>
							<div class="box-test">
							<p>BMS需求电压(V)</p>						
							<h1 id="udcBMS">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft borNotop">
							<img src="<%=basePath %>img/dlicon.png" width="50px"/>
							<div class="box-test">
							<p>BMS需求电流(A)</p>						
							<h1 id="idcBMS">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft borNotop">
							<img src="<%=basePath %>img/yg.png" width="50px"/>
							<div class="box-test">
							<p>BMS充电模式</p>						
							<h1 id="modeBMS">无</h1>
							</div>
						</div>
					</div>
					<div class="box-box1">
						<div class="borleft borNotop">
							<img src="<%=basePath %>img/youxiao.png" width="50px"/>
							<div class="box-test">
							<p>剩余充电时间(h)</p>						
							<h1 id="remTime">0.00</h1>
							</div>
						</div>
					</div>
					
				</div>

			</div>
			<div class="ene-table bor-radius">
				<div class="a8">
					<div class="sto-box3">
						<div class="a4"><p style=" float: right;margin-right: 20%;margin-top:10px;">当前soc(%)</p></div>
						<img src="<%=basePath %>img/dck.png" >
						<div class="sto-box4">
						<h2 id="SOC">0.00</h2>
						</div>
					</div>
					<div class="sto-box3">
						<div class="a4"><p style=" float: right;margin-right: 20%;margin-top:10px;">本次累计充电费(元)</p></div>
						<img src="<%=basePath %>img/jine.png" >
						<div class="sto-box4" style="margin-top:-40px;">
						<h2 id="money">0.00</h2>
						</div>
					</div>
					<div class="sto-box3">
						<div class="a4"><p style=" float: right;margin-right: 20%;margin-top:10px;">本次累计充电量(kWh)</p></div>
						<img src="<%=basePath %>img/rl.png" >
						<div class="sto-box4" style="margin-top:-40px;">
						<h2 id="power">0.00</h2>
						</div>
					</div>
				</div>
			</div>
			<div class="dc-current bor-radius mb50">
				<div class="a44"><p>电压电流</p></div>
				<div class="dydl2" id="dydl"></div>
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
	var equNum = $("#equNum").val();
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});

	getEqu(equNum);
	getData(equNum);
	getRelFauLst(equNum);

	layer.close(indexlayer);
	setInterval(function(){
		getEqu(equNum);
		getData(equNum);
		getRelFauLst(equNum);
	},60000);
	
})

function getData(equNum){
	
	$.ajax({
		url:url+"getIscsDcchpStdInfByEquNumTopOne.htm",
		type:"post",
		//data:"equ_num="+equ_num,
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data.length > 0){
					var d=data.data[0];
					if(d != undefined ){
						var stat = d.stat == 0 ?"离线": d.stat == 1 ? "空闲" :d.stat == 2 ? "充电中" : d.stat == 3 ? "告警运行":d.stat == 4 ? "预约"  : "--";
						$("#stat").html(stat);
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" : "--"   
						$("#healthStat").html(healthStat);
						//var gunStat = d.gunStat == 0 ? "未连接" :d.gunStat == 1 ? "连接未充电" :d.gunStat == 2 ? "充电中" : "" ;
						//$("#gunStat").html(gunStat);
						$("#cumTime").html(getFixedNum(d.cumTime));
						$("#cumPower").html(getFixedNum(d.cumPower));
						$("#cumMoney").html(getFixedNum(d.cumMoney)/100);
						$("#validTime").html(getFixedNum(d.validTime));
					}
				}
			}else{
				layer.alert(data.desc);
			}
		}
		
	})
	
	$.ajax({
		url:url+"getIscsDcchpRelInfByEquNumTopOne.htm",
		type:"post",
		//data:"equ_num="+equ_num,
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var d=data.data[0];
				$("#udc").html(getFixedNum(d.udc));
				$("#idc").html(getFixedNum(d.idc));
				$("#pdc").html(getFixedNum(d.pdc));
				$("#time").html(getFixedNum(getFixedNum(d.time)/3600));
				$("#udcBMS").html(getFixedNum(d.udcBMS));
				$("#idcBMS").html(getFixedNum(d.idcBMS));
				var bms = d.modeBMS == 1 ? '恒压' : d.modeBMS == 2 ?  '恒流' : '无';
				$("#modeBMS").html(bms);
				$("#remTime").html(getFixedNum(getFixedNum(d.remTime)/3600));
				$("#SOC").html(getFixedNum(d.SOC));
				$("#money").html(getFixedNum(d.money));
				$("#power").html(getFixedNum(d.power));
			}else{
				layer.alert(data.desc);
			}
		}
	})
	
	$.ajax({
		url:url+"getIscsDcchpRelUICurves.htm",
		type:"post",
		//data:"equ_num="+equ_num,
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				for(var i=0;i<data.data.length;i++){
					var d=data.data[i];
				
				}
				setChart(data.data);
			
			}else{
				layer.alert(data.desc);
			}
		}
	})
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
				}else{
					$("#rtd_pow").html("无");
					$("#app_mod").html("无");
					$("#man_nam").html("无");
					$("#equ_num").html("无");
					$("#pur_tim").html("无");
				}
				
			}else{
	               layer.alert(data.desc);
			}
		}
	})
}

function setChart(chartData) {

	var xTime = [];
	var yU = [];
	var yA = [];
	for (var i = 0; i < chartData.length; i++) {
		var one = chartData[i];
		xTime.push(getLocalDateAndTime(one.tol_tim, 6));
		yU.push(getFixedNum5(one.udc));
		yA.push(getFixedNum5(one.idc));
	}

	var myChart = echarts.init(document.getElementById('dydl'), 'shine');
	option = {
			 legend: {
			        data: ['电压', '电流'],
			        top: 10,
			    },
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
			yAxis : [ 
			         {
						type : 'value',
						name : '电压(V)',
						axisLabel : {
							formatter : '{value}'
						}
					},{
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
				data :   yU ,
				 symbol : 'none' ,
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
				data :  yA ,
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
			  content: "<%=basePath%>/commens/zhjk/sb/xq/zlcdz.htm?equNum="+equNum   //iframe的url
		});
		
	
}
</script>
</body>
</html>

