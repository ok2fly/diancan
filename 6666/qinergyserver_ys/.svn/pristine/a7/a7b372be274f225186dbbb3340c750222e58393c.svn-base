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
			 <div class="d5" style="width:16%;" onclick="getData(1)">	
			 	<div class="circle brgreen">
			 		<a class="brgreena"  href="javascript:void(0);" >0</a>
			 	</div>
			 	<p>正常运行</p>
			 </div>
			 <div class="d5" style="width:16%;" onclick="getData(5)">	
			 	<div class="circle brgreen">
			 		<a class="brgreena2" href="javascript:void(0);" >0</a>
			 	</div>
			 	<p>限电运行</p>
			 </div>
			 <div class="d5" style="width:16%;" onclick="getData(3)">
			 	<div class="circle bryel">
			 		<a class="bryela"  href="javascript:void(0);" >0</a>
			 	</div>
			 	<p>告警运行</p>
			 </div>
			 <div class="d5" style="width:16%;" onclick="getData(2)">
			 	<div class="circle brblack">
			 		<a class="brblacka"  href="javascript:void(0);"  >0</a>
			 	</div>
			 	<p>正常停机</p>
			 </div>
			 <div class="d5" style="width:16%;" onclick="getData(4)" >
			 	<div class="circle brred">
			 		<a class="brreda"  href="javascript:void(0);" >0</a>
			 	</div>
			 	<p>故障停机</p>
			 </div>
			 <div class="d5" style="width:16%;" onclick="getData(0)">
			 	<div class="circle brgray">
			 		<a class="brgraya"  href="javascript:void(0);"  >0</a>
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
	var app_typ_id= "1";
	var pws_id= "";
	var typ_ide= "GFNBQ";
	var stat = "";
	
	//跳转页面
	var gourl = jumpPageUrl+"commens/zhjk/sb/pvinverter.htm";
	
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
 		getPVSData(param,stat);
 	}
 	
 	var pageData ;
 	
 	var countAll = 0;
 	var currentPage  = 1;
 	
 	var everyPageCount = 12 ;
 	/*电池*/
 	function getPVSData(param,stat){
 		$.ajax({
	    	url:url+"getPvsInfLst.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			  if(data.data.length > 0 ){
	    				  if(data.data[0].pvsEquLst ){
	    					  if(stat === "" || stat == undefined || stat == null ){
	    						  /*显示各个状态的数量*/
		    					  $(".brgreena").html(getIsZero(data.data[0].norStatCount));
		    					  $(".brgreena2").html(getIsZero(data.data[0].ratPowerStatCount));
		    					  $(".bryela").html(getIsZero(data.data[0].alaStatCount));
		    					  $(".brblacka").html(getIsZero(data.data[0].downStatCount));
		    					  $(".brreda").html(getIsZero(data.data[0].fauStatCount));
		    					  $(".brgraya").html(getIsZero(data.data[0].commStatCount));
	    				 	  }
	    					  
	    					  /*表格数据 */
	    					  var html = '';
	    					  for(var i= 0;i<data.data[0].pvsEquLst.length;i++){
	    						  if(i < (currentPage*everyPageCount)){
	    							  var pvs = data.data[0].pvsEquLst[i];
		    						  var sta ="";
		    						  var cls ="";
		    						  if(pvs.stat == 0){
		    							  sta = "通讯中断";
		    							  cls ="bd0";
		    						  }else if(pvs.stat == 1){
		    							  sta = "正常运行";
		    							  cls ="bd1";
		    						  }else if(pvs.stat == 2){
		    							  sta = "正常停机";
		    							  cls ="bd2";
		    						  }else if(pvs.stat == 3){
		    							  sta = "告警运行";
		    							  cls ="bd3";
		    						  }else if(pvs.stat == 4){
		    							  sta = "故障停机";
		    							  cls ="bd4";
		    						  }else if(pvs.stat == 5){
		    							  sta = "限电运行";
		    							  cls ="bd5";
		    						  } 
		    						  html +='<div class="lie1">'+
		    						  			'<div class="sb-sbh bgff bor-radius" onclick="jumpPage('+pvs.id+',\''+pvs.equ_num+'\')">'+
					    							'<div class="a4 mlfont"><a href="javascript:void(0);" onclick="jumpPage('+pvs.id+',\''+pvs.equ_num+'\')" style="color:#000;">'+pvs.equ_nam+'</a></div>'+
					    							'<div class="a4-lief bortopccc">'+
					    							'<div class="img-box">'+
					    							'<img src="'+jumpPageUrl+'img/sb/sb-gf.png">'+
					    							'<a class="bd '+cls+'">'+sta+'</a>'+
					    							'</div>'+
					    							'</div>'+
					    							'<div class="a4-right1 bortopccc">'+
					    								'<p>电压</p>'+
					    								'<p>电流</p>'+
					    								'<p>功率</p>'+
					    								'<p>日发电量</p>'+
					    								'<p>频率</p>'+
					    							'</div>'+
					    							'<div class="a4-right2 bortopccc">'+
					    								'<div>'+getFixedNum(pvs.uab)+'</div><p class="dw">V</p>'+
					    								'<div>'+getFixedNum(pvs.ia)+'</div><p class="dw">A</p>'+
					    								'<div>'+getFixedNum(pvs.psum)+'</div><p class="dw">kW</p>'+
					    								'<div>'+getFixedNum(pvs.powerDay)+'</div><p class="dw">kWh</p>'+
					    								'<div>'+getFixedNum(pvs.freq)+'</div><p class="dw">Hz</p>'+
					    							'</div>'+
		    									'</div>'+
		    								'</div>';
		    					  }
    						  }
	    					  $(".sb-center").empty().html(html);
	    					  
	    					  pageData = data.data[0].pvsEquLst;
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
	    					  $(".sb-center").empty().html(html);
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
				  var pvs = pageData[i];
				  var sta ="";
				  var cls ="";
				  if(pvs.stat == 0){
					  sta = "通讯中断";
					  cls ="bd0";
				  }else if(pvs.stat == 1){
					  sta = "正常运行";
					  cls ="bd1";
				  }else if(pvs.stat == 2){
					  sta = "正常停机";
					  cls ="bd2";
				  }else if(pvs.stat == 3){
					  sta = "告警运行";
					  cls ="bd3";
				  }else if(pvs.stat == 4){
					  sta = "故障停机";
					  cls ="bd4";
				  }else if(pvs.stat == 5){
					  sta = "限电运行";
					  cls ="bd5";
				  } 
				  html +='<div class="lie1">'+
				  			'<div class="sb-sbh bgff bor-radius" onclick="jumpPage('+pvs.id+',\''+pvs.equ_num+'\')">'+
  							'<div class="a4 mlfont"><a href="javascript:void(0);" onclick="jumpPage('+pvs.id+',\''+pvs.equ_num+'\')" style="color:#000;">'+pvs.equ_nam+'</a></div>'+
  							'<div class="a4-lief bortopccc">'+
  							'<div class="img-box">'+
  							'<img src="'+jumpPageUrl+'img/sb/sb-gf.png">'+
  							'<a class="bd '+cls+'">'+sta+'</a>'+
  							'</div>'+
  							'</div>'+
  							'<div class="a4-right1 bortopccc">'+
  								'<p>电压</p>'+
  								'<p>电流</p>'+
  								'<p>功率</p>'+
  								'<p>日发电量</p>'+
  								'<p>频率</p>'+
  							'</div>'+
  							'<div class="a4-right2 bortopccc">'+
  								'<div>'+getFixedNum(pvs.uab)+'</div><p class="dw">V</p>'+
  								'<div>'+getFixedNum(pvs.ia)+'</div><p class="dw">A</p>'+
  								'<div>'+getFixedNum(pvs.psum)+'</div><p class="dw">kW</p>'+
  								'<div>'+getFixedNum(pvs.powerDay)+'</div><p class="dw">kWh</p>'+
  								'<div>'+getFixedNum(pvs.freq)+'</div><p class="dw">Hz</p>'+
  							'</div>'+
							'</div>'+
						'</div>';
		  }
		  $(".sb-center").empty().html(html);
 	}
 	 
</script>	
	
</body>
</html>