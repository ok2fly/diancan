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
			 <div class="d5" >	
			 	<div class="circle brgreen" onclick="getData(1)">
			 		<a class="brgreena" href="javascript:void(0);">0</a>
			 	</div>
			 	<p>正常运行</p>
			 </div>
			<!--  <div class="d5">
			 	<div class="circle bryel" onclick="getData(3)">
			 		<a class="bryela"  href="javascript:void(0);">0</a>
			 	</div>
			 	<p>告警运行</p>
			 </div>
			 <div class="d5">
			 	<div class="circle brblack" onclick="getData(2)" >
			 		<a class="brblacka"  href="javascript:void(0);">0</a>
			 	</div>
			 	<p>正常停机</p>
			 </div>
			 <div class="d5">
			 	<div class="circle brred" onclick="getData(4)" >
			 		<a class="brreda"  href="javascript:void(0);">0</a>
			 	</div>
			 	<p>故障停机</p>
			 </div> -->
			 <div class="d5">
			 	<div class="circle brgray" onclick="getData(0)" >
			 		<a class="brgraya"  href="javascript:void(0);">0</a>
			 	</div>
			 	<p>通讯中断</p>
			 </div>
		</div>
		<div class="sb-center bg-e9 mb50">
			
		</div>
		<div class="tcdPageCode" id="tcdPageCode1"></div> 
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
 		getKongZhiQiData(param,stat);
 	}
 	
	var pageData ;
 	
 	var countAll = 0;
 	var currentPage  = 1;
 	
 	var everyPageCount = 12 ;
 	/* 控制器  */
 	function getKongZhiQiData(param,stat){
 		$.ajax({
	    	url:url+"getCtlInfo.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			  if(data.data.length > 0 ){
	    				  if(data.data[0].ctlEquLst.length > 0 ){
	    					  if(stat === "" || stat == undefined || stat == null ){
	    						  /*显示各个状态的数量*/
		    					  $(".brgreena").html(getIsZero(data.data[0].norStatCount));
		    					  $(".bryela").html(getIsZero(data.data[0].alaStatCount));
		    					  $(".brblacka").html(getIsZero(data.data[0].downStatCount));
		    					  $(".brreda").html(getIsZero(data.data[0].fauStatCount));
		    					  $(".brgraya").html(getIsZero(data.data[0].commStatCount));
	    				 	  }
	    					  
	    					  /*表格数据 */
	    					  var html = '';
	    					  for(var i=0;i<data.data[0].ctlEquLst.length;i++){
	    						  if(i < (currentPage*everyPageCount)){
		    						  var bms = data.data[0].ctlEquLst[i];
		    						  var sta ="";
		    						  var cls ="";
		    						  if(bms.stat == 0){
		    							  sta = "通讯中断";
		    							  cls ="bd0";
		    						  }else if(bms.stat == 1){
		    							  sta = "正常运行";
		    							  cls ="bd1";
		    						  }
		    						  /* else if(bms.stat == 2){
		    							  sta = "正常停机";
		    							  cls ="bd2";
		    						  }else if(bms.stat == 3){
		    							  sta = "告警运行";
		    							  cls ="bd3";
		    						  }else if(bms.stat == 4){
		    							  sta = "故障停机";
		    							  cls ="bd4";
		    						  }  */
		    						  
		    						  var uplink = "";
		    						  var downlink = "";
		    						  var signal = "";
		    						  
		    						  if(bms.uplink>1000 || bms.uplink==1000){
		    							  
		    							  uplink = '<div title="'+getFixedNum(bms.uplink)+'">'+getFixedNum(bms.uplink/1000)+'</div><p class="dw">MB</p>';
		    						  }else{
		    							  
		    							  uplink = '<div title="'+getFixedNum(bms.uplink)+'">'+getFixedNum(bms.uplink)+'</div><p class="dw">KB</p>';
		    							  
		    						  }
		    						  
		    						  if(bms.downlink>1000 || bms.downlink==1000){
		    							  
		    							  downlink = '<div title="'+getFixedNum(bms.downlink)+'">'+getFixedNum(bms.downlink/1000)+'</div><p class="dw">MB</p>';
		    						  }else{
		    							  
		    							  downlink = '<div title="'+getFixedNum(bms.downlink)+'">'+getFixedNum(bms.downlink)+'</div><p class="dw">KB</p>';
		    							  
		    						  }
		    						 
		    						  var signal = bms.signal == 1 ?"无": bms.signal == 2 ? "差" :bms.signal == 3 ? "一般" : bms.signal == 4 ? "较强":bms.signal == 5 ? "强" :"强";
		    						 
		    						  html +='<div class="lie1">'+
		    						  			'<div class="sb-sbh bgff bor-radius">'+
					    							'<div class="a4 mlfont"><a href="#" style="color:#000;">'+bms.equ_nam+'</a></div>'+
					    							'<div class="a4-lief bortopccc">'+
					    							'<div class="img-box">'+
					    							'<img src="'+jumpPageUrl+'img/sb/sb-ctl.png">'+
					    							'<a class="bd '+cls+'">'+sta+'</a>'+
					    							'</div>'+
					    							'</div>'+
					    							'<div class="a4-right1 bortopccc">'+
					    								'<p>信号强度</p>'+
					    								'<p>上行流量</p>'+
					    								'<p>下行流量</p>'+
					    								'<p>ICCID</p>'+
					    								'<p>卡号</p>'+
					    							'</div>'+
					    							'<div class="a4-right2 bortopccc">'+
					    								'<div title="'+signal+'">'+signal+'</div><p class="dw">&nbsp;</p>'+
					    								uplink+
					    								downlink+
					    								'<div style="width: 70%;" title="'+getIsNull2(bms.iccid)+'">'+getIsNull2(bms.iccid)+'</div>'+
					    								'<div style="width: 70%;" title="'+getIsNull2(bms.phone)+'">'+getIsNull2(bms.phone)+'</div>'+
					    							'</div>'+
		    									'</div>'+
		    								'</div>';
	    						  }
	    					  }
	    					  $(".sb-center").empty().html(html);

		    				  pageData = data.data[0].ctlEquLst;
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
	    				  }else{
	    					  $(".sb-center").empty();
	    				  }
	    				  
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
 			var bms = pageData[i];
			  var sta ="";
			  var cls ="";
			  if(bms.stat == 0){
				  sta = "通讯中断";
				  cls ="bd0";
			  }else if(bms.stat == 1){
				  sta = "正常运行";
				  cls ="bd1";
			  }else if(bms.stat == 2){
				  sta = "正常停机";
				  cls ="bd2";
			  }else if(bms.stat == 3){
				  sta = "告警运行";
				  cls ="bd3";
			  }else if(bms.stat == 4){
				  sta = "故障停机";
				  cls ="bd4";
			  } 
			  html +='<div class="lie1">'+
			  			'<div class="sb-sbh bgff bor-radius">'+
							'<div class="a4 mlfont"><a href="#" style="color:#000;">'+bms.equ_nam+'</a></div>'+
							'<div class="a4-lief bortopccc">'+
							'<div class="img-box">'+
							'<img src="'+jumpPageUrl+'img/sb/sb-jl.png">'+
							'<a class="bd '+cls+'">'+sta+'</a>'+
							'</div>'+
							'</div>'+
							'<div class="a4-right1 bortopccc">'+
								'<p>信号强度</p>'+
								'<p>上行流量</p>'+
								'<p>下行流量</p>'+
								'<p>ICCID</p>'+
								'<p>卡号</p>'+
							'</div>'+
							'<div class="a4-right2 bortopccc">'+
								'<div>'+getFixedNum(bms.signal)+'</div><p class="dw">&nbsp;</p>'+
								'<div>'+getFixedNum(bms.uplink)+'</div><p class="dw">MB</p>'+
								'<div>'+getFixedNum(bms.downlink)+'</div><p class="dw">MB</p>'+
								'<div>'+getFixedNum5(bms.iccid)+'</div><p class="dw">&nbsp;</p>'+
								'<div>'+getFixedNum5(bms.phone)+'</div><p class="dw">&nbsp;</p>'+
							'</div>'+
						'</div>'+
					'</div>';
		  }
		  $(".sb-center").empty().html(html);
 	}
</script>	
	
</body>
</html>