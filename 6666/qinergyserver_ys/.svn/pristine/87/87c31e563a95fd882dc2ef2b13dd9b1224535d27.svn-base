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
			 <div class="d5" >
			 	<div class="circle bryel" onclick="getData(3)">
			 		<a class="bryela"  href="javascript:void(0);">0</a>
			 	</div>
			 	<p>告警运行</p>
			 </div>
			 <div class="d5"  >
			 	<div class="circle brblack" onclick="getData(2)">
			 		<a class="brblacka"  href="javascript:void(0);">0</a>
			 	</div>
			 	<p>正常停机</p>
			 </div>
			 <div class="d5" >
			 	<div class="circle brred" onclick="getData(4)">
			 		<a class="brreda"  href="javascript:void(0);" >0</a>
			 	</div>
			 	<p>故障停机</p>
			 </div>
			 <div class="d5" >
			 	<div class="circle brgray" onclick="getData(0)">
			 		<a class="brgraya"  href="javascript:void(0);" >0</a>
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
	
	//跳转页面
	var gourl = jumpPageUrl+"commens/zhjk/sb/storage.htm";;
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
 		getChuNengData(param,stat);
 	}
 	 
	var pageData ;
 	
 	var countAll = 0;
 	var currentPage  = 1;
 	
 	var everyPageCount = 12 ;
 	/*储能*/
 	function getChuNengData(param,stat){
 		$.ajax({
	    	url:url+"getPcsInfLst.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			  if(data.data.length > 0 ){
	    				  if(data.data[0].pcsEquLst){
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
	    					  for(var i=0;i<data.data[0].pcsEquLst.length;i++){
	    						  if(i < (currentPage*everyPageCount)){
		    						  var pcs = data.data[0].pcsEquLst[i];
		    						  var sta ="";
		    						  var cls ="";
		    						  if(pcs.stat == 0){
		    							  sta = "通讯中断";
		    							  cls ="bd0";
		    						  }else if(pcs.stat == 1){
		    							  sta = "正常运行";
		    							  cls ="bd1";
		    						  }else if(pcs.stat == 2){
		    							  sta = "正常停机";
		    							  cls ="bd2";
		    						  }else if(pcs.stat == 3){
		    							  sta = "告警运行";
		    							  cls ="bd3";
		    						  }else if(pcs.stat == 4){
		    							  sta = "故障停机";
		    							  cls ="bd4";
		    						  } 
		    						  html +='<div class="lie1">'+
		    						  			'<div class="sb-sbh bgff bor-radius" onclick="jumpPage('+pcs.id+',\''+pcs.equ_num+'\')">'+
					    							'<div class="a4 mlfont"><a href="javascript:void(0);" onclick="jumpPage('+pcs.id+',\''+pcs.equ_num+'\')" style="color:#000;">'+pcs.equ_nam+'</a></div>'+
					    							'<div class="a4-lief bortopccc">'+
					    							'<div class="img-box">'+
					    							'<img src="'+jumpPageUrl+'img/sb/sb-cn.png">'+
					    							'<a class="bd '+cls+'">'+sta+'</a>'+
					    							'</div>'+
					    							'</div>'+
					    							'<div class="a4-right1 bortopccc">'+
					    								'<p>电压</p>'+
					    								'<p>电流</p>'+
					    								'<p>功率</p>'+
					    								'<p>功率因数</p>'+
					    								'<p>频率</p>'+
					    							'</div>'+
					    							'<div class="a4-right2 bortopccc">'+
					    								'<div>'+getFixedNum(pcs.uab)+'</div><p class="dw">V</p>'+
					    								'<div>'+getFixedNum(pcs.ia)+'</div><p class="dw">A</p>'+
					    								'<div>'+getFixedNum(pcs.psum)+'</div><p class="dw">kW</p>'+
					    								'<div>'+getFixedNum2(pcs.pf)+'</div><p class="dw">&nbsp</p>'+
					    								'<div>'+getFixedNum(pcs.freq)+'</div><p class="dw">Hz</p>'+
					    							'</div>'+
		    									'</div>'+
		    								'</div>';
	    						  }
	    					  }
	    					  $(".sb-center").empty().html(html);
	    					  
	    					  pageData = data.data[0].pcsEquLst;
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
 			var pcs = pageData[i];
			  var sta ="";
			  var cls ="";
			  if(pcs.stat == 0){
				  sta = "通讯中断";
				  cls ="bd0";
			  }else if(pcs.stat == 1){
				  sta = "正常运行";
				  cls ="bd1";
			  }else if(pcs.stat == 2){
				  sta = "正常停机";
				  cls ="bd2";
			  }else if(pcs.stat == 3){
				  sta = "告警运行";
				  cls ="bd3";
			  }else if(pcs.stat == 4){
				  sta = "故障停机";
				  cls ="bd4";
			  } 
			  html +='<div class="lie1">'+
			  			'<div class="sb-sbh bgff bor-radius" onclick="jumpPage('+pcs.id+',\''+pcs.equ_num+'\')">'+
							'<div class="a4 mlfont"><a href="javascript:void(0);" onclick="jumpPage('+pcs.id+',\''+pcs.equ_num+'\')" style="color:#000;">'+pcs.equ_nam+'</a></div>'+
							'<div class="a4-lief bortopccc">'+
							'<div class="img-box">'+
							'<img src="'+jumpPageUrl+'img/sb/sb-cn.png">'+
							'<a class="bd '+cls+'">'+sta+'</a>'+
							'</div>'+
							'</div>'+
							'<div class="a4-right1 bortopccc">'+
								'<p>电压</p>'+
								'<p>电流</p>'+
								'<p>功率</p>'+
								'<p>功率因数</p>'+
								'<p>频率</p>'+
							'</div>'+
							'<div class="a4-right2 bortopccc">'+
								'<div>'+getFixedNum(pcs.uab)+'</div><p class="dw">V</p>'+
								'<div>'+getFixedNum(pcs.ia)+'</div><p class="dw">A</p>'+
								'<div>'+getFixedNum(pcs.psum)+'</div><p class="dw">kW</p>'+
								'<div>'+getFixedNum(pcs.pf)+'</div><p class="dw">&nbsp</p>'+
								'<div>'+getFixedNum(pcs.freq)+'</div><p class="dw">Hz</p>'+
							'</div>'+
						'</div>'+
					'</div>';
		  }
		  $(".sb-center").empty().html(html);
 	}
 	 
</script>	
	
</body>
</html>