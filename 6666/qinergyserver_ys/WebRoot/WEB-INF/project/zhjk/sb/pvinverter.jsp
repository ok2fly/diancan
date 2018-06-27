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
<title>光伏逆变器</title>
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />

</head>
<body class="pl8t0 bgfc">
	<input type="hidden" id="id" value="${id}">
	<input type="hidden" id="equNum" value="${equNum}">
	<div class="dc-center">
		<div class="dc-warm bor-radius" >
			<div class="a4">
				<p>告警牌</p>
			</div>
			<div class="c1">
				<div class="borNoleft " >
					<table id="gjp1" style="margin-top:8px;">
					</table>
				</div>
			</div>
			<div class="c1"  >
				<div class="borleft">
					<table id="gjp2" style="margin-top:8px;">
						 
					</table>
				</div>
			</div>
			<div class="c1"   >
				<div class="borleft">
					<table id="gjp3" style="margin-top:8px;">
						 
					</table>
				</div>
			</div>
		</div>
		<div class="ene-equ bor-radius">
				
				<div class="a44"><p>工作状态</p></div>
				<div class="b1 borRight" >
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
			<div class="dc-high bor-radius">
				<div class="a4"><p>直流侧</p></div>
				<div class="a1">
					<div class="borleft">
						<img src="<%=basePath %>img/z-57.png"/>
						<div class="a5">
							<p>电压(V)</p>
							<h1 id="udc1">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a1">
					<div class="borleft">
						<img src="<%=basePath %>img/z-56.png"/>
						<div class="a5">
							<p>电流(A)</p>
							<h1 id="idcSum">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a1">
					<div class="borleft">
						<img src="<%=basePath %>img/z-58.png"/>
						<div class="a5">
							<p>功率(kW)</p>
							<h1 id="pdcSum">0.00</h1>
						</div>
					</div>
				</div>
				
			</div>
			<div class="dc-high2 bor-radius">
				<div class="a4"><p>交流侧</p></div>
				<div class="a11">
					<div class="borleft">
						<img src="<%=basePath %>img/z-57.png"/>
						<div class="a5">
							<p>电压(V)</p>
							<h1 id="ua">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a11">
					<div class="borleft">
						<img src="<%=basePath %>img/z-56.png"/>
						<div class="a5">
							<p>电流(A)</p>
							<h1 id="ia">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a11" >
					<div class="borleft" >
						<img src="<%=basePath %>img/z-58.png"/>
						<div class="a5">
							<p>功率(kW)</p>
							<h1 id="pa">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a11">
					<div class="borleft">
						<img src="<%=basePath %>img/plicon.png" width="50px"/>
						<div class="a5">
						<p>频率(Hz)</p>						
						<h1 id="freq">0.00</h1>
						</div>
					</div>
				</div>
				<div class="a11"  >
					<div class="borleft">
						<img src="<%=basePath %>img/glysicon.png" width="50px"/>
						<div class="a5">
						<p>功率因素</p>						
						<h1 id="pf">0.000</h1>
						</div>
					</div>
				</div>
				<div class="a11" >
					 <div class="borleft">
					 </div>
				</div>
			</div>
			
			<%-- <div class="ene-equ bor-radius">
				
				<div class="a44"><p>实时数据</p></div>
				<div class="b1 " >
						<img src="<%=basePath %>img/gzms-.png" />
					
				</div>
				<div class="b1">
					
					<div class="b3" style="margin-top: 14px;">
						<p>累计运行时间</p>
						<h1 id="timeAll" style="margin-top: 25px;">0h</h1>
					</div>
				</div>
			</div> --%>
			<div class="ene-table bor-radius">
				<div class="a4"><p>累计量</p></div>
				<div class="box">
					<div class="box-box11">
						<div class="borNoleft">
							<img src="<%=basePath %>img/yg.png" width="50px"/>
							<div class="box-test">
							<p>日发电量(kWh)</p>						
							<h1 id="powerDay">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box11">
						<div class="borleft">
							<img src="<%=basePath %>img/yg.png" width="50px"/>
							<div class="box-test">
							<p>总发电量(kWh)</p>						
							<h1 id="powerAll">0.00</h1>
							</div>
						</div>
					</div>
					<div class="box-box11">
						<div class="borleft">
							<img src="<%=basePath %>img/gzms-.png"  width="50px"/>
							<div class="box-test">
								<p>累计运行时间(h)</p>
								<h1 id="timeAll" >0</h1>
							</div>
						</div>
					</div>
					
				</div>

			</div>
		<div class="dc-current bor-radius">
			<div class="a44">
				<p>日发电量</p>
			</div>
			<div class="zxfx" id="dl"></div>
		</div>
		<div class="dc-current bor-radius">
			<div class="a44">
				<p>电压 电流</p>
			</div>
			<div class="zxfx" id="dydl"></div>
		</div>
		<div class="dc-current bor-radius mb50">
			<div class="a44">
				<p>离散率</p>
			</div>
			<div class="zxfx" id="lsl"></div>
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
				<div class="a44" ><p>保修概况</p></div>
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
	getEqu(equNum);
	getIscsInf(equNum);
	getIscsCurves(equNum);
	getIscsPower(equNum);
	getRelFauLst(equNum);
	
	setInterval(function(){
		getEqu(equNum);
		getIscsInf(equNum);
		getIscsCurves(equNum);
		getIscsPower(equNum);
		getRelFauLst(equNum);
	},60000);
	
})
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
function getIscsInf(equNum){
	$.ajax({
		url:url+"getIscsPvsInfByEquNumTopOne.htm",
		type:"post",
		data:"equ_num="+equNum,
		//data:"equ_num="+1,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				if(data.data.length > 0){
					var a=data.data[0];
					if(a != undefined ){
						var stat = a.stat == 0 ?"通讯中断": a.stat == 1 ? "正常运行" :a.stat == 2 ? "正常停机" : a.stat == 3 ? "告警运行":a.stat == 4 ? "故障停机" : a.stat == 5 ? "限电运行" : "--";
						var healthStat = a.healthStat == 1 ? "优秀" :a.healthStat == 2 ? "良好" : a.healthStat == 3 ? "中等":a.healthStat == 4 ? "差" : "--";
		
						$("#stat").html(stat);
						$("#healthStat").html(healthStat);
						$("#ua").html(getFixedNum(a.uab));
						$("#ia").html(getFixedNum(a.ia));
						$("#pa").html(getFixedNum(a.psum));
						$("#pf").html(getFixedNum2(a.pf));
						$("#freq").html(getFixedNum(a.freq));
						$("#powerDay").html(getFixedNum(a.powerDay));
						$("#powerAll").html(getFixedNum(a.powerAll));
						$("#timeAll").html(a.timeAll);
						
						$("#udc1").html(getFixedNum(a.udc1));
						$("#idcSum").html(getFixedNum(a.idc1+a.idc2+a.idc3+a.idc4+a.idc5+a.idc6+a.idc7+a.idc8+a.idc9+a.idc10));
						$("#pdcSum").html(getFixedNum(a.pdcSum));
					}
				}
			
		}else{
            layer.alert(data.desc);
		}
	}
	})
}

function getIscsCurves(equNum){
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({
		url:url+"getIscsPvsAcDcPIVDisRateCurves.htm",
		type:"post",
		data:"equ_num="+equNum,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var a=data.data[0];
				/* $("#psum").html(getIsZero(a.psum)+"KW");
				$("#qsum").html(getIsZero(a.qsum)+"KW");
				$("#pdcSum").html(getIsZero(a.pdcSum));
				$("#disRate").html(getIsZero(a.disRate));
				$("#tol_tim").html(getIsZero(a.tol_tim)); */
				setChart1(data.data);
				setChart3(data.data);
				layer.close(indexlayer);
			}else{
				layer.close(indexlayer);
	               layer.alert(data.desc);
			}
		}
	})
}

function setChart1(data){
	var xTime=[];
	var yU=[];
	var yA=[];
	var yZU=[];
	var yZA=[];
	
	for(var i=0;i<data.length;i++){
		var d=data[i];
		xTime.push(getLocalDateAndTime(d.tol_tim,6));
		yU.push(getFixedNum5(d.uab));
		yA.push(getFixedNum5(d.ia));
		yZU.push(getFixedNum5(d.udc1));
		yZA.push(getFixedNum5(d.idc1+d.idc2+d.idc3+d.idc4+d.idc5+d.idc6+d.idc7+d.idc8+d.idc9+d.idc10));
	}
	var myChart1 = echarts.init(document.getElementById('dydl'), 'shine');
	option1 = {
			 legend: {
			        data: ['交流电压', '交流电流', '直流电压', '直流电流'],
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
				name : '交流电压',
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
				name : '交流电流',
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
			}, {
				name : '直流电压',
				type : 'line',
				smooth : true,
				data :  yZU ,
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
				data :  yZA ,
				 symbol : 'none',
				 itemStyle : {
					normal : {
						color : '#FE784E'
					}
				}  
			}
			]
		};

		myChart1.setOption(option1);
}
function setChart2(data){
	var xTime=[];
	var ypowerall=[];
	for(var i=0;i<data.length;i++){
		var d=data[i];
		xTime.push(getLocalDateAndTime(d.tol_tim,6));
		ypowerall.push(getFixedNum5(d.powerDay));
	}
	var myChart2 = echarts.init(document.getElementById('dl'), 'shine');
	option2 = {
			legend: {
		        data: ['电量'],
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
			calculable : false,
			xAxis : [ {
				type : 'category',
				boundaryGap : true, //柱状图时此参数为true 折现时为false
				data : xTime 
			} ],
			yAxis : {
				type : 'value',
				name : '电量(kWh)',
				axisLabel : {
					formatter : '{value}'
				}
			},
			series : [{
				name : '电量',
				type : 'bar',
				data : ypowerall,
				barWidth : 20,
				itemStyle : {
					normal : {
						color : '#5FB0E3' 
                    }
				} ,
			   symbol : 'none'
			}

			]
		};

		myChart2.setOption(option2);
	}
	function getIscsPower(equNum) {
		$.ajax({
			url : url + "getIscsPvsDayPowerHistogram.htm",
			//data:"equ_num="+equ_num,
			data : "equ_num=" + equNum,
			dataType : "json",
			type : "post",
			success : function(data) {
				if (data.resultcode == "USR000") {
					setChart2(data.data);
				} else {
					layer.alert(data.desc);
				}
			}
		})
	}
	function setChart3(data) {
		var xTime = [];
		var y = [];
		for (var i = 0; i < data.length; i++) {
			var a = data[i];
			xTime.push(getLocalDateAndTime(a.tol_tim, 6));
			y.push(getFixedNum5(a.disRate))
		}
		var myChart3 = echarts.init(document.getElementById('lsl'), 'shine');
		option3 = {
			legend : {
				data : [ '离散率' ],
				top : 10,
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
			yAxis : {
				type : 'value',
				name : '离散率(%)',
				axisLabel : {
					formatter : '{value}'
				},
				min : 0 ,
				max :100 
			},
			series : [ {
				name : '离散率',
				type : 'line',
				smooth : true,
				data :    y,
			 	symbol : 'none',
				itemStyle : {
					normal : {
						color : '#5FB0E3'
					}
				}  
			}

			]
		};

		myChart3.setOption(option3);
	}

	/* 获取告警牌信息  */
	function getRelFauLst(equNum) {
		$.ajax({
			url : url + "getRelFauLst.htm",
			//data : "equ_num=CNNBQ-2017001",
			data : "equ_num=" + equNum,
			dataType : "json",
			type : "post",
			success : function(data) {
				if (data.resultcode == "USR000") {
					if (data.data.length > 0) {
						var html1 = '';
						var html2 = '';
						var html3 = '';
						for (var i = 0; i < data.data.length; i++) {
							if(i < 32){
								var d = data.data[i];
								var cls = '';
								if (d.is_dpl == 1) {
									cls = ' gjp'
								}
								var h = '<tr class="tr3">' + '<td>'
										+ '<div class="dian2 '+cls+'"></div>'
										+ '</td>' + '<td><span>' + d.ala_info
										+ '</span></td>' + '</tr>';
								if (i % 3 == 0) {
									html1 += h;
								}
								if (i % 3 == 1) {
									html2 += h;
								}
								if (i % 3 == 2) {
									html3 += h;
								}
							}
						}
						$("#gjp1").html(html1);
						$("#gjp2").html(html2);
						$("#gjp3").html(html3);
					}
				} else {
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
				  content: "<%=basePath%>/commens/zhjk/sb/xq/gf.htm?equNum="+equNum   //iframe的url
			});
			
		
	}	
</script>
</body>
</html>