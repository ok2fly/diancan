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
			<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
			<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
			 
	</head>
	<body class="bg-e9"  >
	<input type="hidden" id="app_typ_id" value="${app_typ_id}">
	<input type="hidden" id="pws_id" value="${pws_id}">
	<input type="hidden" id="typ_ide" value="${typ_ide}">
	<input type="hidden" id="goJumpType" value="${goJumpType}">
	<input type="hidden" id="id" value="${id}">
	<input type="hidden" id="equNum" value="${equNum}">
	<div class="sb-main">
		<div class="sb-top bgff bor-radius">
			 <div class="a4 mlfont">设备状态</div>
			 <div class="d5" onclick="getData(2)">	
			 	<div class="circle brgreen">
			 		<a class="brgreena" href="javascript:void(0);" >0</a>
			 	</div>
			 	<p>充电中</p>
			 </div>
			 <div class="d5" onclick="getData(3)">
			 	<div class="circle bryel">
			 		<a class="bryela"  href="javascript:void(0);">0</a>
			 	</div>
			 	<p>告警运行</p>
			 </div>
			 <div class="d5">
			 	<div class="circle brblack" onclick="getData(0)">
			 		<a class="brblacka"  href="javascript:void(0);" >0</a>
			 	</div>
			 	<p>离线</p>
			 </div>
			 <div class="d5">
			 	<div class="circle brred" onclick="getData(4)">
			 		<a class="brreda"  href="javascript:void(0);" >0</a>
			 	</div>
			 	<p>预约</p>
			 </div>
			 <div class="d5">
			 	<div class="circle brgray" onclick="getData(1)">
			 		<a class="brgraya"  href="javascript:void(0);" >0</a>
			 	</div>
			 	<p>空闲</p>
			 </div>
		</div>
		<div class="sb-center bg-e9 mb50">
			
		</div>
		<div class="tcdPageCode" id="tcdPageCode1"></div> 
	</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/sb.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>

<script type="text/javascript">
	var app_typ_id= "";
	var pws_id= "";
	var typ_ide= "";
	var stat = "";
	
	//跳转页面
	var gourl = jumpPageUrl+"commens/zhjk/sb/dcz.htm";;
 	$(function (){
 		app_typ_id=$("#app_typ_id").val();
 		pws_id=$("#pws_id").val(); 
 		typ_ide=$("#typ_ide").val();  
 		getData(stat);
 	})
 	
 	
 	function getData(stat){
 		var param = "";
 		if(stat === "" || stat == undefined || stat == null ){
 			param = "app_typ_id="+app_typ_id+"&pws_id="+pws_id;
 		}else{
 			param = "app_typ_id="+app_typ_id+"&pws_id="+pws_id+"&stat="+stat;
 		}
 		currentPage = 1;
 		getJlCdzData(param,stat);
 	}
 	 
	var pageData ;
 	
 	var countAll = 0;
 	var currentPage  = 1;
 	
 	var everyPageCount = 12 ;
 	/*储能*/
 	function getJlCdzData(param,stat){
 		$.ajax({
	    	url:url+"getAcchpInfLst.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			  if(data.data.length > 0 ){
	    				  if(data.data[0].acchpEquLst){
	    					  if(stat === "" || stat == undefined || stat == null ){
	    						  /*显示各个状态的数量*/
		    					  $(".brgreena").html(getIsZero(data.data[0].inChargeStatCount));
		    					  $(".bryela").html(getIsZero(data.data[0].alaStatCount));
		    					  $(".brblacka").html(getIsZero(data.data[0].offlineStatCount));
		    					  $(".brreda").html(getIsZero(data.data[0].bookingStatCount));
		    					  $(".brgraya").html(getIsZero(data.data[0].idleStatCount));
	    				 	  }
	    					  
	    					  /*表格数据 */
	    					  var html = '';
	    					  for(var i=0;i<data.data[0].acchpEquLst.length;i++){
	    						  if(i < (currentPage*everyPageCount)){
		    						  var pcs = data.data[0].acchpEquLst[i];
		    						  var sta ="";
		    						  var cls ="";
		    						  if(pcs.stat == 0){
		    							  sta = "离线";
		    							  cls ="bd2";
		    						  }else if(pcs.stat == 1){
		    							  sta = "空闲";
		    							  cls ="bd0";
		    						  }else if(pcs.stat == 2){
		    							  sta = "充电中";
		    							  cls ="bd1";
		    						  }else if(pcs.stat == 3){
		    							  sta = "告警运行";
		    							  cls ="bd3";
		    						  }else if(pcs.stat == 4){
		    							  sta = "预约";
		    							  cls ="bd4";
		    						  } 
		    						  html +='<div class="lie1">'+
		    						  			'<div class="sb-sbh bgff bor-radius" onclick="jumpPage('+pcs.id+',\''+pcs.equ_num+'\')">'+
					    							'<div class="a4 mlfont"><a href="javascript:void(0);" onclick="jumpPage('+pcs.id+',\''+pcs.equ_num+'\')" style="color:#000;">'+pcs.equ_nam+'</a></div>'+
					    							'<div class="a4-lief bortopccc">'+
					    							'<div class="img-box">'+
					    							'<img src="'+jumpPageUrl+'img/sb/sb-cd.png">'+
					    							'<a class="bd '+cls+'">'+sta+'</a>'+
					    							'</div>'+
					    							'</div>'+
					    							'<div class="a4-right1 bortopccc">'+
					    								'<p>充电时间</p>'+
					    								'<p>充电电量</p>'+
					    								'<p>充电金额</p>'+
					    								'<p>有效小时数</p>'+
					    								'<p>运行时间</p>'+
					    							'</div>'+
					    							'<div class="a4-right2 bortopccc">'+
					    								'<div>'+getFixedNum(pcs.cumTime)+'</div><p class="dw">h</p>'+
					    								'<div>'+getFixedNum(pcs.cumPower)+'</div><p class="dw">kWh</p>'+
					    								'<div>'+getFixedNum(getFixedNum(pcs.cumMoney)/100)+'</div><p class="dw">元</p>'+
					    								'<div>'+getFixedNum(pcs.validTime)+'</div><p class="dw">h</p>'+
					    								'<div>'+getFixedNum(pcs.runTime)+'</div><p class="dw">h</p>'+
					    							'</div>'+
		    									'</div>'+
		    								'</div>';
	    						  }
	    					  }
	    					  $(".sb-center").empty().html(html);

		    				  pageData = data.data[0].acchpEquLst;
		    				  //算出总页数
		    				  countAll = 0 ;
	    					  if(pageData.length/everyPageCount > parseInt(pageData.length/everyPageCount)){   
	    						  countAll=parseInt(pageData.length/everyPageCount)+1;   
	    				      }else{   
	    				    	  countAll=parseInt(pageData.length/everyPageCount);   
	    				       };
		    				  //countAll = data.totalPage;
		    				  $("#tcdPageCode1").createPage({
		 				        	pageCount:countAll,
			 				        current:currentPage,
			 				        backFn:function(p){
			 				        	currentPage = p;
			 				        	getPagedData();
			 				        }
		 			    		  }); 
			    			  }
	    				  }else{
	    					  $(".sb-center").empty();
	    				  }
	    				  
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 	
 	function getPagedData(){
		var html = '';
		if ( (currentPage*everyPageCount) >  pageData.length-1 ){
			 max = pageData.length; 
		 }else{
			 max = (currentPage*everyPageCount) ;
		 }
		for(var i=((currentPage-1)*everyPageCount);i<max;i++){
 			 var pcs = pageData[i];
			  var sta ="";
			  var cls ="";
			  if(pcs.stat == 0){
				  sta = "离线";
				  cls ="bd0";
			  }else if(pcs.stat == 1){
				  sta = "空闲";
				  cls ="bd1";
			  }else if(pcs.stat == 2){
				  sta = "充电中";
				  cls ="bd2";
			  }else if(pcs.stat == 3){
				  sta = "告警运行";
				  cls ="bd3";
			  }else if(pcs.stat == 4){
				  sta = "预约";
				  cls ="bd4";
			  } 
			  html +='<div class="lie1">'+
			  			'<div class="sb-sbh bgff bor-radius" onclick="jumpPage('+pcs.id+',\''+pcs.equ_num+'\')">'+
							'<div class="a4 mlfont"><a href="javascript:void(0);" onclick="jumpPage('+pcs.id+',\''+pcs.equ_num+'\')" style="color:#000;">'+pcs.equ_nam+'</a></div>'+
							'<div class="a4-lief bortopccc">'+
							'<div class="img-box">'+
							'<img src="'+jumpPageUrl+'img/sb/sb-cd.png">'+
							'<a class="bd '+cls+'">'+sta+'</a>'+
							'</div>'+
							'</div>'+
							'<div class="a4-right1 bortopccc">'+
								'<p>充电时间</p>'+
								'<p>充电电量</p>'+
								'<p>充电金额</p>'+
								'<p>有效小时数</p>'+
								'<p>运行时间</p>'+
							'</div>'+
							'<div class="a4-right2 bortopccc">'+
								'<div>'+getFixedNum(pcs.cumTime)+'</div><p class="dw">h</p>'+
								'<div>'+getFixedNum(pcs.cumPower)+'</div><p class="dw">kWh</p>'+
								'<div>'+getFixedNum(getFixedNum(pcs.cumMoney)/100)+'</div><p class="dw">元</p>'+
								'<div>'+getFixedNum(pcs.validTime)+'</div><p class="dw">h</p>'+
								'<div>'+getFixedNum(pcs.runTime)+'</div><p class="dw">h</p>'+
							'</div>'+
						'</div>'+
					'</div>';
		  }
		  $(".sb-center").empty().html(html);
 	}
</script>	
	
</body>
</html>