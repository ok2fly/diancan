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
		<title>汇流箱</title>
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/rcbg.css?pubVersion=201802070001">
		
	</head>
	<body class="pl8t0 bgfc">
		<input type="hidden" id="equNum" value="${equNum}">
		<div class="dc-center">
			<div class="dc-warm1 bor-radius ">
					<div class="a4"><p>告警牌</p></div>
					<div class="c1" >
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
					<div class="c1" >
						<div class="borleft">
							<table id="gjp3" style="margin-top:8px;">
								 
							</table>
						</div>
					</div>
			</div>
			<div class="ene-equ bor-radius">
				
				<div class="a44"><p>工作状态</p></div>
				<div class="b1" style="width:50%">
						<img src="<%=basePath %>img/jkicon.png" />
					<div class="b3">
						<p>健康状态</p>
						<h1 id="healthStat"  style="margin-top: 25px;">--</h1>
					</div>
				</div>
				<div class="b1 borleft" style="border-top:none; ">
					<img src="<%=basePath %>img/sbyxicon.png" />
					<div class="b3">
						<p>设备状态</p>
						<h1 id="stat" style="margin-top: 25px;">--</h1>
					</div>
				</div>
			</div>
			<div class="dc-realtime bor-radius">
					<div class="a4"><p>工作信息</p></div>
					<div class="b1" style="width:50%;">
						<div class="borNoleft">
							<img src="<%=basePath %>img/C.png"/>
							<div class="b3">
								<p>温度(°C)</p>
								<h2 id="temp" style="margin-top: 25px;">0</h2>
							</div>
						</div>
					</div>
					<div class="b1"style="width:50%;">
						<div class="borleft">
							<img src="<%=basePath %>img/dyicon.png" />
							<div class="b3">
								<p>电压(V)</p>
								<h2 id="udc"  style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
		
					<div class="b1"style="width:50%;">
						<div class="borNoleft ">
							<img src="<%=basePath %>img/dlicon.png" />
							<div class="b3">
								<p>电流(A)</p>
								<h2 id="idc" style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
					<div class="b1"style="width:50%;">
						<div class="borleft">
							<img src="<%=basePath %>img/yg.png"/>
							<div class="b3">
								<p>功率(kW)</p>
								<h2 id="pdc" style="margin-top: 25px;">0.00</h2>
							</div>
						</div>
					</div>
			</div>
			<div class="dl bor-radius" style="margin-top:13px;">
				<div class="a44"><p>支路信息</p></div>
				<div class="cler wauto" style="padding:10px 4%;">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list"  >
						<tr>
							<th>支路</th>
							<th>电流(A)</th>
							<th>支路</th>
							<th>电流(A)</th>
						</tr>
						<tbody id="zlsj">
						
						</tbody>
					</table>
				</div>
			</div>
			<div class="sto-foot11  bor-radius" style="margin-top:13px;">
				<div class="a44"><P>温度</P></div>
				<div class="dydl"  id="tem"></div>
			</div>
			<div class="sto-foot11 bor-radius mb50" style="margin-top:13px;">
				<div class="a44"><p>离散率</p></div>
				<div class="dydl"  id="rat"></div>
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

<script type="text/javascript">
	$(function(){
		var equ_num=$("#equNum").val();
		getRelFauLst(equ_num);
		$.ajax({
			url:url+"getEquInfByEquNum.htm",
			type:"post",
			data:"equ_num="+equ_num,
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
		
		$.ajax({
			url:url+"getIscsBoxInfByEquNumTopOne.htm",
			data:"equ_num="+equ_num,
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length > 0 ){
						var d= data.data[0];
						if(d != undefined){
							var stat = d.stat == 0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "告警运行" :"--";
							$("#stat").html(stat);
							var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" : "--"   
							$("#healthStat").html(healthStat);
							$("#udc").html(getFixedNum(d.udc));
							$("#idc").html(getFixedNum(d.idc));
							$("#pdc").html(getFixedNum(d.pdc));
							$("#temp").html(getFixInt(d.temp));
							
							//循环显示支路
							var h = '';
							var coun =  0 ;
							for(var i= 0 ; i < d.branchNum ;i++){
								var c = (i+1);
								var val = d['idc'+(c)] ;
								if(val == 0 ){
									if(coun % 2 == 0){
										h += '<tr>'+
										 '<td>'+c+'</td>'+
										 '<td>'+getFixedNum(val)+'</td>';
										coun++;
									}else{
										h +=  '<td>'+c+'</td>'+
										 		'<td>'+getFixedNum(val)+'</td>'+
										 		'</tr>';
										coun = 0 ;
									}
								}else{
									if(val != undefined && val != ""){
										if(coun % 2 == 0){
											h += '<tr>'+
											 '<td>'+c+'</td>'+
											 '<td>'+getFixedNum(val)+'</td>';
											coun++;
										}else{
											h +=  '<td>'+c+'</td>'+
											 		'<td>'+getFixedNum(val)+'</td>'+
											 		'</tr>';
											coun = 0 ;
										}
									}
								}
								
							}
							if(coun % 2 > 0 && h != ''){
								h +=    '<td>&nbsp;</td>'+
								 		'<td>&nbsp;</td>'+
								 		'</tr>';
							}
							$("#zlsj").html(h);
						}
					}
					 
				}else{
					layer.alert(data.desc);
				}
			}
		})
		
		$.ajax({
			url:url+"getIscsBoxTempDisRateCurves.htm",
			data:"equ_num="+equ_num,
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.resultcode=="USR000"){
					setChart(data.data);
				}else{
					layer.alert(data.desc);
				}
				
			}
		})
		
		
	})
	
	function setChart(data){
		var xTime=[];
		var temp=[];
		var disRate=[];
		for(var i=0;i<data.length;i++){
			var a=data[i];
			xTime.push(getLocalDateAndTime(a.tol_tim,6));
			temp.push(getFixedNum5(a.temp));
			disRate.push(getFixedNum5(a.disRate));
		}
		
		
 		var myChart1=echarts.init(document.getElementById('tem'),'shine');
 		var myChart2=echarts.init(document.getElementById('rat'),'shine');
 		option1 = {
 			    tooltip : {
 			        trigger: 'axis'
 			    },
 			    calculable : true, 
 			   grid : {
 					left : '80',
 					top : '60',
 					right : '80',
 					bottom : '30'
 				},
 			    xAxis : [
 			        {
 			            type : 'category',
 			            data : xTime,
 						boundaryGap : false
 			        }
 			    ],
 			    yAxis : [
 			        {
 			            type : 'value',
 			            name : '温度(℃)',
 			            axisLabel : {
 			                formatter: '{value}'
 			            }
 			        }
 			    ],
 			   legend: {
			        data:['温度'],
			        top:10
			    },
 			    series : [
 			        {
 			            name:'温度',
 			            type:'line',
 			            data:temp,
 			           smooth : true,
 			           symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#EDB213'
 							}
 						}
 			        }
 			    ]
 			};
 		option2 = {
 				tooltip : {
 					trigger : 'axis'
 				},
 				 legend: {
 				        data: ['离散率'],
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
 								name : '离散率(%)',
 								axisLabel : {
 									formatter : '{value}'
 								},
 			 					min : 0 ,
 			 					max :100 
 							} 
 				],
 				series : [ {
 					name : '离散率',
 					type : 'line',
 					smooth : true,
 					data : disRate,
 					 symbol : 'none' ,
 						itemStyle : {
 							normal : {
 								color : '#5FB0E3'
 							}
 						}
 				} 
 				]
 			};
		  myChart1.setOption(option1);
 		  myChart2.setOption(option2);
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
				  content: "<%=basePath%>/commens/zhjk/sb/xq/hlx.htm?equNum="+equNum   //iframe的url
			});
			
		
	}
</script>		

</body>
</html>