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
		<title>储能电池</title>
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
	</head>
	<body class="pl8t0 bgfc">
		<input type="hidden" id="id" value="${id}"> 
		<input type="hidden" id="equNum" value="${equNum}"> 
		
		<div class="dc-center">
			<div class="dc-warm bor-radius">
					<div class="a4"><p>告警牌</p></div>
					<div class="c1">
						<div class="borNoleft ">
							<table id="gjp1" style="margin-top:8px;">
								 
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
				<div class="ene-realtime bor-radius">
					<div class="a4"><p>电池状态</p></div>
					<div class="enertySta">
						 <div class="enertySta-box" style="border-left:none;">
						 	<table width="100%" style="margin-top:15px;">
								<tr class="tr4">
									<td>
										<div class="kuai" ><div class="sta0"></div></div>
									</td>
									<td>
										<span>充电允许</span>
									</td>
									
								</tr>
								<tr class="tr4">
									<td>
										<div class="kuai"><div class="sta1"></div></div>
									</td>
									<td>
										<span>放电允许</span>
									</td>
								</tr>
								<tr class="tr4">
									<td>
										<div class="kuai"><div class="sta2"></div></div>
									</td>
									<td>
										<span>继电器闭合</span>
									</td>
								</tr>
								<tr class="tr4">
									<td>
										<div class="kuai"><div class="sta3"></div></div>
									</td>
									<td>
										<span>充满电维护请求</span>
									</td>
								</tr>
							</table>
						 </div>
					</div>
					<div class="enertySta">
						 <div class="enertySta-box">
						 	<table width="100%" style="margin-top:15px;">
								<tr class="tr4">
									<td>
										<div class="kuai"><div class="sta4"></div></div>
									</td>
									<td>
										<span>放完电维护请求</span>
									</td>
									
								</tr>
								<tr class="tr4">
									<td>
										<div class="kuai"><div class="sta5"></div></div>
									</td>
									<td>
										<span>熔断器断开</span>
									</td>
								</tr>
								<tr class="tr4">
									<td>
										<div class="kuai"><div class="sta6"></div></div>
									</td>
									<td>
										<span>风机开启</span>
									</td>
								</tr>
							</table>
						 </div>
					</div>
				</div>
			</div>
			<div class="ene-table bor-radius">
				<div class="a44"><p>电量信息</p></div>
				<div class="box">
					<div class="sto-box1 posRel">
						<div class="positBackGrd"> </div>
						<img src="<%=basePath %>img/dck.png" height="72px">
						<div class="box-box"> 
							<p>soc(%)</p>
							<h1 id="soc" style="font-size: 20px;">0.00</h1>
						</div>
					</div>
					<div class="sto-box1">
						<div class="borleft borNotop">
							<img src="<%=basePath %>img/cndc.png" height="72px">
							<div class="box-box"> 
								<p>额定容量(AH)</p>
								<h1 id="capacity" style="font-size: 20px;">0.00</h1>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div class="ene-table2 bor-radius fl mb50">
				<div class="a44"><p>工作信息</p></div>
				<div class="box fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/C.png" width="50px"/>
						<div class="box-test">
							<p>最高温度(°c)</p>						
							<h1 id="tempHigh">0</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/C.png" width="50px"/>
						<div class="box-test">
						<p>最低温度(°c)</p>						
						<h1 id="tempLow">0</h1>
						</div>
					</div>
				</div>
				<div class="box fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/dyicon.png" width="50px"/>
						<div class="box-test">
						<p>最高电压(V)</p>						
						<h1 id="uHigh">0.00</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/dyicon.png" width="50px"/>
						<div class="box-test">
						<p>最低电压(V)</p>						
						<h1 id="uLow">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box fl">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/d.png" width="50px"/>
							<div class="box-test">
							<p>可充电电量(kWh)</p>						
							<h1 id="rechg">0.00</h1>
							</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/d.png" width="50px"/>
						<div class="box-test">
						<p>可放电电量(kWh)</p>						
						<h1 id="redischg">0.00</h1>
						</div>
					</div>
				</div>
			</div>
			
			<div class="ene-table2 bor-radius fr mb50" >
				<div class="a44"><p>工作范围</p></div>
				<div class="box fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/C.png" width="50px"/>
						<div class="box-test">
						<p>最高允许工作温度(°c)</p>						
						<h1 id="tempHighLimit">0</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/C.png" width="50px"/>
						<div class="box-test">
						<p>最低允许工作温度(°c)</p>						
						<h1 id="tempLowLimit">0</h1>
						</div>
					</div>
				</div>
				<div class="box fl" style="border-bottom:1px solid #ccc;">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/dyicon.png" width="50px"/>
						<div class="box-test">
						<p>最高充电单体电压(V)</p>						
						<h1 id="uHighCell">0.00</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/dyicon.png" width="50px"/>
						<div class="box-test">
						<p>最低充电单体电压(V)</p>						
						<h1 id="ulowCell">0.00</h1>
						</div>
					</div>
				</div>
				<div class="box fl">
					<div class="box-box2" style="border-right:1px solid #ccc;">
						<img src="<%=basePath %>img/z-56.png" width="50px"/>
						<div class="box-test">
						<p>最大允许充电电流(A)</p>						
						<h1 id="iChgMax">0.00</h1>
						</div>
					</div>
					<div class="box-box2">
						<img src="<%=basePath %>img/z-56.png" width="50px"/>
						<div class="box-test">
						<p>最大允许放电电流(A)</p>						
						<h1 id="iDischgMax">0.00</h1>
						</div>
					</div>
				</div>
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
	var id="";
	var equNum="";
 	$(function (){
 		id=$("#id").val();
 		equNum=$("#equNum").val();
 		getData(equNum);
 		getSb(id);
 		setChart(equNum);
 		getRelFauLst();
 		setInterval(function(){
 			getData(id);
 	 		getSb(id);
 	 		setChart(equNum);
	 		getRelFauLst();
 		},60000);
 	})
 	
 	function getSb(id){
 		$.ajax({
	    	url:url+"getBmsInfoListById.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 
	    			 if(data.data.length> 0){
	    				 
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
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 	
 	function getData(equNum){
 		$.ajax({
	    	url:url+"getBmsInfoNew.htm",
	    	data : "equ_num="+equNum,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 
	    			 if(data.data.length> 0){
	    				 
	    				 var da = data.data[0];
	    				 if(da != undefined){
		    				 var healthStat = da.healthStat == 1 ? "优秀" : da.healthStat == 2 ? "良好":da.healthStat == 3 ? "中等":da.healthStat == 4 ? "差" : "--" ;  
		 					 $("#healthStat").html(healthStat);
		    				 /*设备状态*/
		    				 //设备状态（0：通讯中断、1：正常运行、2：正常停机、3：告警运行、4：故障停机）
		    				 var state =  "--";
		    				 if(da.stat == 0){
		    					 state = "通信中断";
		    				 }else if(da.stat == 1){
		    					 state = "正常运行";
		    				 }else if(da.stat == 2){
		    					 state = "正常停机";
		    				 }else if(da.stat == 3){
		    					 state = "告警运行";
		    				 }else if(da.stat == 4){
		    					 state = "故障停机";
		    				 }
		    				//电池状态(bit0：充电允许，bit1：放电允许，bit2：继电器闭合，bit3：充满电维护请求，bit4：放完电维护请求，bit5：熔断器断开，bit6：风机开启)
		    				 var bat =  "--";
		    				 if(da.statBatts == 0){
		    					 bat = "充电允许";
		    				 }else if(da.statBatts == 1){
		    					 bat = "放电允许";
		    				 }else if(da.statBatts == 2){
		    					 bat = "继电器闭合";
		    				 }else if(da.statBatts == 3){
		    					 bat = "充满电维护请求";
		    				 }else if(da.statBatts == 4){
		    					 bat = "放完电维护请求";
		    				 }else if(da.statBatts == 5){
		    					 bat = "熔断器断开";
		    				 }else if(da.statBatts == 6){
		    					 bat = "风机开启";
		    				 }
		    				 $("#stat").html(state);
		    				 $("#statBatts").html(bat);
		    				 
		    				 $(".kuai").find("div").removeClass("kuai2");
		    				 $(".sta"+da.statBatts).addClass("kuai2");
		    				 
		    				 /*实时数据*/
		    				 $("#soc").html(da.soc);
		    				 var wid = (da.soc)/100*114;
		    				 $(".positBackGrd").css("width",wid);
		    				 $(".positBackGrd").css("max-width",100);
		    				 $("#capacity").html(getFixedNum(da.capacity));
		    				 
		    				 $("#rechg").html(getFixedNum(da.rechg));
		    				 $("#redischg").html(getFixedNum(da.redischg));
		    				 $("#iChgMax").html(getFixedNum(da.iChgMax));
		    				 $("#iDischgMax").html(getFixedNum(da.iDischgMax));
		    				 
		    				 $("#tempHigh").html(getFixInt(da.tempHigh));
		    				 $("#tempLow").html(getFixInt(da.tempLow));
		    				 $("#tempHighLimit").html(getFixInt(da.tempHighLimit));
		    				 $("#tempLowLimit").html(getFixInt(da.tempLowLimit));
		    				 
		    				 $("#uHigh").html(getFixedNum(da.uHigh));
		    				 $("#uLow").html(getFixedNum(da.uLow));
		    				 $("#uHighCell").html(getFixedNum(da.uHighCell));
		    				 $("#ulowCell").html(getFixedNum(da.ulowCell));
	    				 }
	    				 
	    			 }
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 	
 	function setChart(equNum){
 		$.ajax({
	    	url:url+"getBmsInfoList.htm",
	    	data : "equ_num="+equNum,
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
    			 			xData.push(getLocalDateAndTime(da.crtTim,6));
    			 			yDlData.push(da.idc);
    			 			yDyData.push(da.udc);
    					}
	    			 }
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 			                    
 	}
 	/* 获取告警牌信息  */
 	function getRelFauLst(){
 		var equNum=$("#equNum").val();
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
				  content: "<%=basePath%>/commens/zhjk/sb/xq/cndc.htm?equNum="+equNum   //iframe的url
			});
			
		
	}	
</script>		
	</body>
</html>
