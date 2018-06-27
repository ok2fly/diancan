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
		<title>配电柜</title>
			<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
			
	</head>
	<body class="pl8t0 bgfc">
		<input type="hidden" id="id" value="${id}"> 
		<input type="hidden" id="equNum" value="${equNum}"> 
		<div class="dc-center">
			<div class="shebei bor-radius">
				<div class="a4"><p>工作状态</p></div>
				<div class="b4">
						<div class="borNoleft">
							<img src="<%=basePath %>img/sbyxicon.png" />
							<div class="b7">
								<p>健康状态</p>
								<h1 id="healthStat" style="margin-top:25px;">--</h1>
							</div>
						</div>
				</div>
			</div>
			<div class="duanluqi bor-radius mb50">
				<div class="a4"><p>断路器状态</p></div>
				<div class="b4 borNoleft">
				   <div class="dlq stat1" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					 1#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open1">
				   					<div class='close1 open-outside'> 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
				   		</div>
				   </div>
				   <div class="dlq stat2" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					 2#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open2">
				   					<div class='close1 open-outside'> 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
				   		</div>
				   </div>
				   <div class="dlq stat3" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					 3#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open3">
				   					<div class='close1 open-outside' > 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
				   		</div>
				   </div>
				   <div class="dlq stat4" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					 4#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open4">
				   					<div class='close1 open-outside'> 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
				   		</div>
				   </div>
				   <div class="dlq stat5" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					 5#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open5">
				   					<div class='close1 open-outside'> 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
				   		</div>
				   </div>
				   <div class="dlq stat6" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					 6#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open6">
				   					<div class='close1 open-outside'> 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
				   		</div>
				   </div>
				   <div class="dlq stat7" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					7#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open7">
				   					<div class='close1 open-outside'> 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
				   		</div>
				   </div>
				   <div class="dlq stat8" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					 8#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open8">
				   					<div class='close1 open-outside'> 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
				   		</div>
				   </div>
				   <div class="dlq stat9" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					 9#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open9">
				   					<div class='close1 open-outside'> 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
				   		</div>
				   </div>
				   <div class="dlq stat10" style="display: none">
				   		<div class="pl20">
				   			<div class="w50 fl">
				   				<div class="dlq-nam">
				   					 10#断路器
				   				</div>
				   			</div>
				   			<div class="w50 fl">
				   				<div class="dlq-open" id="dlq-open10">
				   					<div class='close1 open-outside'> 
				        			 	<div  class='close2 open-inside'  ></div> 
				       			    </div>		
				   				</div>
				   			</div>
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
				<div class="pro bortopequ bortop">
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

			<!-- <div class="qtxq bor-radius">其他详情</div> -->
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
 		getEqu(equNum);
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
 	
 	function getData(equNum){
 		$.ajax({
	    	url:url+"getDcdbById.htm",
	    	data : "equ_num="+equNum,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 
	    			 if(data.data.length> 0){
	    				 
	    				 var da = data.data[0];
	    				 if(da != undefined){
		    				 /*实时数据*/
		    				 var healthStat = da.healthStat == 1 ? "优秀" : da.healthStat == 2 ? "良好":da.healthStat == 3 ? "中等":da.healthStat == 4 ? "差" : "--"  
		    				 $("#healthStat").html(healthStat);
		    				  
		    				 
		    				 $("#rechg").html(da.rechg);
		    				 $("#redischg").html(da.redischg);
		    				 $("#iChgMax").html(da.iChgMax);
		    				 $("#iDischgMax").html(da.iDischgMax);
		    				 
		    				 $("#tempHigh").html(da.tempHigh);
		    				 $("#tempLow").html(da.tempLow);
		    				 $("#tempHighLimit").html(da.tempHighLimit);
		    				 $("#tempLowLimit").html(da.tempLowLimit);
		    				 
		    				 $("#uHigh").html(da.uHigh);
		    				 $("#uLow").html(da.uLow);
		    				 $("#uLow").html(da.uLow);
		    				 $("#ulowCell").html(da.ulowCell);
		    				 
		    				 for(var i = 1 ; i < da.branchNum+1 ; i++){
		    					 $(".stat"+(i)).show();
		    					 if(da['stat'+(i)] == "1"){
			    					 $("#dlq-open"+(i)).find(".open-outside").removeClass("close1").addClass("open1");
			    					 $("#dlq-open"+(i)).find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
			    				 }
		    				 }
	    				 }
	    				 
	    				 
	    				/*  if(da.stat1){
	    					 $(".stat1").show();
	    					 if(da.stat1 == "1"){
		    					 $("#dlq-open1").find(".open-outside").removeClass("close1").addClass("open1");
		    					 $("#dlq-open1").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
		    				 }
	    				 }
	    				 if(da.stat2){
	    					 $(".stat2").show();
	    					 if(da.stat2 == "1"){
		    					 $("#dlq-open2").find(".open-outside").removeClass("close1").addClass("open1");
		    					 $("#dlq-open2").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
		    				 }
	    				 }
	    				 
	    				 if(da.stat3){
	    					 $(".stat3").show();
	    					 if(da.stat3 == "1"){
		    					 $("#dlq-open3").find(".open-outside").removeClass("close1").addClass("open1");
		    					 $("#dlq-open3").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
		    				 }
	    				 }
	    				 
	    				 if(da.stat4){
	    					 $(".stat4").show();
	    					 if(da.stat4 == "1"){
		    					 $("#dlq-open4").find(".open-outside").removeClass("close1").addClass("open1");
		    					 $("#dlq-open4").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
		    				 }
	    				 }
	    				 
	    				 if(da.stat5){
	    					 $(".stat5").show();
	    					 if(da.stat5 == "1"){
		    					 $("#dlq-open5").find(".open-outside").removeClass("close1").addClass("open1");
		    					 $("#dlq-open5").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
		    				 }
	    				 }
	    				 
	    				 if(da.stat6){
	    					 $(".stat6").show();
	    					 if(da.stat6 == "1"){
		    					 $("#dlq-open6").find(".open-outside").removeClass("close1").addClass("open1");
		    					 $("#dlq-open6").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
		    				 }
	    				 }
	    				 
	    				 if(da.stat7){
	    					 $(".stat7").show();
	    					 if(da.stat7 == "1"){
		    					 $("#dlq-open7").find(".open-outside").removeClass("close1").addClass("open1");
		    					 $("#dlq-open7").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
		    				 }
	    				 }
	    				 
	    				 if(da.stat8){
	    					 $(".stat8").show();
	    					 if(da.stat8 == "1"){
		    					 $("#dlq-open8").find(".open-outside").removeClass("close1").addClass("open1");
		    					 $("#dlq-open8").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
		    				 }
	    				 }
	    				 
	    				 if(da.stat9){
	    					 $(".stat9").show();
	    					 if(da.stat9 == "1"){
	    					 $("#dlq-open9").find(".open-outside").removeClass("close1").addClass("open1");
	    					 $("#dlq-open9").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
	    				 	 }
	    				}
	    				 
	    				 if(da.stat10){
	    					 $(".stat10").show();
	    					 if(da.stat10 == "1"){
		    					 $("#dlq-open10").find(".open-outside").removeClass("close1").addClass("open1");
		    					 $("#dlq-open10").find(".open-outside").find(".open-inside").removeClass("close2").addClass("open2");
		    				 }
	    				 } */
	    			 }
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 
</script>		

</body>
</html>