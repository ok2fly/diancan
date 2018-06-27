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
		<title>储能逆变器</title>
			<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
			
	</head>
	<body class="pl8t0 bgfc">
		<input type="hidden" id="id" value="${id}"> 
		<input type="hidden" id="equNum" value="${equNum}">
		<div class="dc-center">
			<div class="dc-warm bor-radius" >
					<div class="a4"><p>告警牌</p></div>
					<div class="c1">
						<div class="borNoleft ">
							<table id="gjp1" style="margin-top:8px;" >
								 
							</table>
						</div>
					</div>
					<div class="c1">
						<div class="borleft">
							<table id="gjp2" style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
					<div class="c1">
						<div class="borleft">
							<table id="gjp3" style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
			</div>
			<div class="dc-realtime bor-radius">
					<div class="a4"><p>工作状态</p></div>
					<div class="b1" style="width: 50%;">
						<div class="borNoleft">
							<img src="<%=basePath %>img/jkicon.png" />
							<div class="b3">
								<p>健康状态</p>
								<h2 id="healthStat" style="margin-top: 25px;">--</h2>
							</div>
						</div>
					</div>
					<div class="b1" style="width: 50%;">
						<div class="borleft">
							<img src="<%=basePath %>img/yx.png" width="66px" height="66px"/>
							<div class="b3">
								<p>设备状态</p>
								<h2 id="stat" style="margin-top: 25px;">--</h2>
							</div>
						</div>
					</div>
				
			
					<div class="b1" style="width: 50%;">
						<div class="borNoleft">
							<img src="<%=basePath %>img/gzzt.png"/>
							<div class="b3">
								<p>工作模式</p>
								<h2 id="mode" style="margin-top: 25px;">--</h2>
							</div>
						</div>
					</div>
					<div class="b1" style="width: 50%;">
						<div class="borleft">
							<img src="<%=basePath %>img/gzms-.png"/>
							<div class="b3">
								<p>并离网状态</p>
								<h2 id="gridStat" style="margin-top: 25px;">--</h2>
							</div>
						</div>
					</div>
			</div>
			
			
			<div class="dc-high bor-radius">
				<div class="a4"><p>直流侧</p></div>
				<div class="a1">
					<div class="borNoleft" >
						<img src="<%=basePath %>img/z-57.png"/>
						<div class="a5">
							<p>电压(V)</p>
							<h2 id="udc" style="margin-top: 25px;">0.00</h2>
						</div>
					</div>
				</div>
				<div class="a1" >
					<div class="borleft">
						<img src="<%=basePath %>img/z-56.png"/>
						<div class="a5">
							<p>电流(A)</p>
							<h2 id="idc" style="margin-top: 25px;">0.00</h2>
						</div>
					</div>
				</div>
				<div class="a1" >
					<div class="borleft">
						<img src="<%=basePath %>img/z-58.png"/>
						<div class="a5">
							<p>功率(kW)</p>
							<h2 id="pdc" style="margin-top: 25px;">0.00</h2>
						</div>
					</div>
				</div>
				
			</div>
			<div class="sto-table bor-radius">
				<div class="a4"><p>交流侧</p></div>
				<div class="sto1">
					<div class="borNoleft">
						<img src="<%=basePath %>img/z-57.png"/>
						<div class="a5">
							<p>电压(V)</p>
							<h2 id="ua" style="margin-top: 25px;">0.00</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/z-56.png"/>
						<div class="a5">
							<p>电流(A)</p>
							<h2 id="ia" style="margin-top: 25px;">0.00</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/z-58.png"/>
						<div class="a5">
							<p>功率(kW)</p>
							<h2 id="pa" style="margin-top: 25px;">0.00</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/glysicon.png"/>
						<div class="a5">
							<p>功率因数</p>
							<h2 id="pf" style="margin-top: 25px;">0.000</h2>
						</div>
					</div>
				</div>
				<div class="sto1">
					<div class="borccc">
						<img src="<%=basePath %>img/plicon.png"/>
						<div class="a5">
							<p>频率(Hz)</p>
							<h2 id="freq" style="margin-top: 25px;">0.00</h2>
						</div>
					</div>
				</div>
				
			</div>
			<div class="sto-bot bor-radius">
				<div class="a44"><p>电量信息</p></div>
				<div class="a6">
					<div class="sto-box1">
						<img src="<%=basePath %>img/nbq2.png"  >
						<div class="sto-box2 fl" style="margin-top: -60px;">
						<p>输入电量(kWh)</p>
						<h2 id="phi">0.00</h2>
						</div>
					</div>
					<div class="sto-box1">
						<img src="<%=basePath %>img/nbq1.png" >
						<div class="sto-box2 fl" style="margin-top: -60px;">
						<p>输出电量(kWh)</p>
						<h2 id="phe">0.00</h2>
						</div>
					</div>
				</div>
			
				<div class="a7" id="dl"></div>			
			</div>
			<div class="sto-foot11 bor-radius">
				<div class="a44"><p>电压电流</p></div>
				<div class="dydl" id="dldy"></div>
			</div>
			<div class="sto-foot11 bor-radius mb50">
				<div class="a44"><p>有功无功</p></div>
				<div class="dydl" id="ygwg"></div>
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
	var equNum = $("#equNum").val();
	getData();
	getRelFauLst(equNum);
	getEqu();
	setInterval(function(){
		getData();
		getRelFauLst(equNum);
	},60000);
})

function getData(){
	var id=$("#id").val();
	var equNum = $("#equNum").val();
	$.ajax({
		url:url+"getPcsInfoById.htm",
		data:"equ_num="+equNum,
		dataType:"json",
		Type:"post",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data){
					for(var i=0;i<data.data.length;i++){
						var d=data.data[i];
						if( d != undefined ){
							var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" : "--"   
							$("#healthStat").html(healthStat);
							var stat = d.stat == 0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "正常停机" : d.stat == 3 ? "告警运行":d.stat == 4 ? "故障停机" :"--";
							$("#stat").html(stat);
							var mode = d.mode == 0 ? "P/Q" : d.mode == 1 ? "V/F":d.mode == 2 ? "虚拟同步发电机":d.mode == 3 ? "直流恒压" : "--"   
							$("#mode").html(mode);
							var gridStat = d.gridStat == 0 ?"离网": d.gridStat == 1 ? "并网" :"--";
							$("#gridStat").html(gridStat);
							$("#idc").html(getFixedNum(d.idc));
							$("#udc").html(getFixedNum(d.udc));
							$("#pdc").html(getFixedNum(d.pdc));
							$("#faultCode").html(getIsNull(d.faultCode));
							$("#ia").html(getFixedNum(d.ia));
							$("#ua").html(getFixedNum(d.uab));
							$("#pa").html(getFixedNum(d.psum));
							$("#pf").html(getFixedNum2(d.pf));
							$("#freq").html(getFixedNum(d.freq));
							$("#phi").html(getFixedNum(d.phi));
							$("#phe").html(getFixedNum(d.phe));
							$("#ub").html(getFixedNum(d.ub));
							$("#uc").html(getFixedNum(d.uc));
							$("#ib").html(getFixedNum(d.ib));
							$("#ic").html(getFixedNum(d.ic));
							$("#psum").html(getFixedNum(d.psum));
							$("#qsum").html(getFixedNum(d.qsum));
						}
						
       					/* $("#app_mod").html(d.app_mod);
       				 	$("#rtd_pow").html(d.rtd_pow+"kW");
       				 	$("#man_nam").html(d.man_nam);
       				 	$("#pur_tim").html(getLocalDateAndTime(d.pro_tim,2));
       				 	$("#equ_num").html(d.equ_num); */
					}
				}else{
		            layer.alert(data.desc);
				}
			}
		}
	})
	setEchart(equNum);
	setEchart4(equNum);
}

function getEqu(){
	var equNum = $("#equNum").val();
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

function setEchart(equNum) {
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({
		url:url+"getPcsNow.htm",
		data:"equ_num="+equNum,
		dataType:"json",
		Type:"post",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data){
					setEchart1(data.data);
					setEchart2(data.data);
					//setEchart3(data.data);
					layer.close(indexlayer);

				}else{
					layer.close(indexlayer);
		            layer.alert(data.desc);
				}
			}
		}
	})
}

function setEchart4(equNum) {
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({
		url:url+"getPcsNowMonth.htm",
		data:"equ_num="+equNum,
		dataType:"json",
		Type:"post",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data){
					setEchart3(data.data);
					layer.close(indexlayer);
				}else{
					layer.close(indexlayer);
		            layer.alert(data.desc);
				}
			}
		}
	})
}


function setEchart1(dydl){
	
		var xTime = [];
		var yU1 = [];
		var yA1 = [];
		var yU2 = [];
		var yA2 = [];
		for (var i = 0; i < dydl.length; i++) {
			var d = dydl[i];
			xTime.push(getLocalDateAndTime(d.tol_tim, 6));
			yU1.push(getFixedNum5(d.udc));
			yA1.push(getFixedNum5(d.idc));
			yU2.push(getFixedNum5(d.uab));
			yA2.push(getFixedNum5(d.ia));
		}

		var myChart = echarts.init(document.getElementById('dldy'), 'shine');
		option = {

			tooltip : {
				trigger : 'axis'
			},
			 legend: {
			        data: ['直流电压', '直流电流','交流电压', '交流电流'],
			        top: 10,
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
				name : '直流电压',
				type : 'line',
				smooth : true,
				data : yU1,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}
			},
			{
				name : '直流电流',
				type : 'line',
				yAxisIndex: 1,
				smooth : true,
				data : yA1,
				 symbol : 'none',
				 itemStyle : {
					normal : {
						color : '#07CB47'
					}
				}
			},
			{
				name : '交流电压',
				type : 'line',
				smooth : true,
				data : yU2,
				 symbol : 'none' ,
					itemStyle : {
						normal : {
							color : '#5FB0E3'
						}
					}
			},
			{
				name : '交流电流',
				type : 'line',
				yAxisIndex: 1,
				smooth : true,
				data : yA2,
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
	
function setEchart2(ygwg) {

	var xTime = [];
	var yp = [];
	var yq = [];
	for (var i = 0; i < ygwg.length; i++) {
		var d = ygwg[i];
		xTime.push(getLocalDateAndTime(d.tol_tim, 6));
		yp.push(getFixedNum5(d.psum));
		yq.push(getFixedNum5(d.qsum));
	}

	var myChart1 = echarts.init(document.getElementById('ygwg'), 'shine');
	option = {

		tooltip : {
			trigger : 'axis'
		},
		 legend: {
		        data: ['有功', '无功'],
		        top: 10,
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
				name : '有功(kW)',
				axisLabel : {
				formatter : '{value}'
				}
			},
			 {
				type : 'value',
				name : '无功(kVar)',
				axisLabel : {
				formatter : '{value}'
				}
			} 
		],
	
		series : [ {
			name : '有功',
			type : 'line',
			smooth : true,
			data : yp,
			itemStyle : {
				normal : {
					color : '#EDB213' 
                }
			} ,
		   symbol : 'none'
		}, 
		{
			name : '无功',
			type : 'line',
			smooth : true,
			yAxisIndex : 1,
			data : yq,
			itemStyle : {
				normal : {
					color : '#07CB47' 
                }
			} ,
		   symbol : 'none'
		},

		]
	};
	var maxVal = 0 ;
	for (var i = 0; i < ygwg.length; i++) {
		var one = ygwg[i];
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
	/* 
	var maxVal = 0 ;
	var minVal = 0 ;
	for (var i = 0; i < ygwg.length; i++) {
		var one = ygwg[i];
		if(one.psum > maxVal){
			maxVal = one.psum
		}
		
		if(one.psum < minVal){
			minVal = one.psum
		}
	}
	if(maxVal > 0 ){
		var maxV = getMaxVal(maxVal);
		var minV = 0 ;
		if(minVal < 0 ){
			minV = getMinVal(minVal);
		}
		option.yAxis[0].max = maxV;
		option.yAxis[0].min = minV;
		option.yAxis[1].max = maxV;
		option.yAxis[1].min = minV;
	} */
	myChart1.setOption(option);

}


function setEchart3(dl) {

	var xTime = [];
	var yphi = [];
	var yphe = [];
	for (var i = 0; i < dl.length; i++) {
		var d = dl[i];
		xTime.push(getLocalDateAndTime(d.tol_tim, 10)+"日");
		yphi.push(getFixedNum5(d.phi));
		yphe.push(getFixedNum5(d.phe));
	}

	var myChart1 = echarts.init(document.getElementById('dl'), 'shine');
	option = {

		tooltip : {
			trigger : 'axis'
		},
		 legend: {
		        data: ['输入电量','输出电量'],
		        top:10,
		    },
		    grid : {
				left : '80',
				top : '50',
				right : '80',
				bottom : '30'
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
				name : '电量(kWh)',
				axisLabel : {
				formatter : '{value}'
				}
			}
		],
	
		series : [ {
			name : '输入电量',
			type : 'bar',
			smooth : true,
			data : yphi,
			 symbol : 'none' ,
				itemStyle : {
					normal : {
						color : '#EDB213'
					}
				}
		}, 
		{
			name : '输出电量',
			type : 'bar',
			smooth : true,
			data : yphe,
			 symbol : 'none' ,
				itemStyle : {
					normal : {
						color : '#07CB47'
					}
				}
		},

		]
	};

	myChart1.setOption(option);

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
			  content: "<%=basePath%>/commens/zhjk/sb/xq/cnnbq.htm?equNum="+equNum   //iframe的url
		});
		
	
}
</script>
	</body>
</html>
