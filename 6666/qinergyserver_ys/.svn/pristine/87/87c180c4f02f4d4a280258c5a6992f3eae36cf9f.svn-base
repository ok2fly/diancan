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
	
	//跳转页面
	var gourl = jumpPageUrl +  "commens/zhjk/sb/peidiangui.htm";
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
 		getZhiLiuPdData(param,stat);
 	}
 	 
	var pageData ;
 	
 	var countAll = 0;
 	var currentPage  = 1;
 	
 	var everyPageCount = 12 ;
 	/*直流配电柜*/
 	function getZhiLiuPdData(param,stat){
 		$.ajax({
	    	url:url+"getDcdbInfByEquNum.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			  if(data.data.length > 0 ){
	    				  if(data.data[0].dcdbEquLst.length > 0 ){
	    					  if(stat === "" || stat == undefined || stat == null ){
	    						  /*显示各个状态的数量*/
		    					  $(".brgreena").html(getIsZero(data.data[0].norStatCount));
		    					  $(".brgraya").html(getIsZero(data.data[0].commStatCount));
	    				 	  }
	    					  
	    					  /*表格数据 */
	    					  var html = '';
	    					  for(var i=0;i<data.data[0].dcdbEquLst.length;i++){
	    						  if(i < (currentPage*everyPageCount)){
		    						  var bms = data.data[0].dcdbEquLst[i];
		    						  var sta ="";
		    						  var cls ="";
		    						  if(bms.stat == 0){
		    							  sta = "通讯中断";
		    							  cls ="bd0";
		    						  }else if(bms.stat == 1){
		    							  sta = "正常运行";
		    							  cls ="bd1";
		    						  }
		    						  var stat1Dw = bms.stat1 == 0 ? '断开' :   bms.stat1 == 1 ?  '闭合' : '其他' ;
		    						  var stat2Dw = bms.stat2 == 0 ? '断开' :   bms.stat2 == 1 ?  '闭合' : '其他' ;
		    						  var stat3Dw = bms.stat3 == 0 ? '断开' :   bms.stat3 == 1 ?  '闭合' : '其他' ;
		    						  var stat4Dw = bms.stat4 == 0 ? '断开' :   bms.stat4 == 1 ?  '闭合' : '其他' ;
		    						  var stat5Dw = bms.stat5 == 0 ? '断开' :   bms.stat5 == 1 ?  '闭合' : '其他' ;
		    						  html +='<div class="lie1">'+
		    						  			'<div class="sb-sbh bgff bor-radius" onclick="jumpPage('+bms.id+',\''+bms.equ_num+'\')">'+
					    							'<div class="a4 mlfont"><a href="javascript:void(0);" onclick="jumpPage('+bms.id+',\''+bms.equ_num+'\')" style="color:#000;">'+bms.equ_nam+'</a></div>'+
					    							'<div class="a4-lief bortopccc">'+
					    							'<div class="img-box">'+
					    							'<img src="'+jumpPageUrl+'img/sb/sb-zl.png">'+
					    							'<a class="bd '+cls+'">'+sta+'</a>'+
					    							'</div>'+
					    							'</div>'+
					    							'<div class="a4-right1 bortopccc">'+
					    								'<p>1#断路器</p>'+
					    								'<p>2#断路器</p>'+
					    								'<p>3#断路器</p>'+
					    								'<p>4#断路器</p>'+
					    								'<p>5#断路器</p>'+
					    								/* '<p>6#断路器</p>'+ */
					    							'</div>'+
					    							'<div class="a4-right2 bortopccc">'+
					    							'<div>'+stat1Dw+'</div><p class="dw">&nbsp;</p>'+
				    								'<div>'+stat2Dw+'</div><p class="dw">&nbsp;</p>'+
				    								'<div>'+stat3Dw+'</div><p class="dw">&nbsp;</p>'+
				    								'<div>'+stat4Dw+'</div><p class="dw">&nbsp;</p>'+
				    								'<div>'+stat5Dw+'</div><p class="dw">&nbsp;</p>'+
					    								/* '<p>'+getIsNull(bms.stat6)+'</p>'+ */
					    							'</div>'+
		    									'</div>'+
		    								'</div>';
	    						  }
	    					  }
	    					  $(".sb-center").empty().html(html);
	    					  
	    					  pageData = data.data[0].dcdbEquLst;
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
			  } 
			  var stat1Dw = bms.stat1 == 0 ? '断开' :   bms.stat1 == 1 ?  '闭合' : '其他' ;
			  var stat2Dw = bms.stat2 == 0 ? '断开' :   bms.stat2 == 1 ?  '闭合' : '其他' ;
			  var stat3Dw = bms.stat3 == 0 ? '断开' :   bms.stat3 == 1 ?  '闭合' : '其他' ;
			  var stat4Dw = bms.stat4 == 0 ? '断开' :   bms.stat4 == 1 ?  '闭合' : '其他' ;
			  var stat5Dw = bms.stat5 == 0 ? '断开' :   bms.stat5 == 1 ?  '闭合' : '其他' ;
			  html +='<div class="lie1">'+
			  			'<div class="sb-sbh bgff bor-radius" onclick="jumpPage('+bms.id+',\''+bms.equ_num+'\')">'+
							'<div class="a4 mlfont"><a href="javascript:void(0);" onclick="jumpPage('+bms.id+',\''+bms.equ_num+'\')" style="color:#000;">'+bms.equ_nam+'</a></div>'+
							'<div class="a4-lief bortopccc">'+
							'<div class="img-box">'+
							'<img src="'+jumpPageUrl+'img/sb/sb-zl.png">'+
							'<a class="bd '+cls+'">'+sta+'</a>'+
							'</div>'+
							'</div>'+
							'<div class="a4-right1 bortopccc">'+
								'<p>1#断路器</p>'+
								'<p>2#断路器</p>'+
								'<p>3#断路器</p>'+
								'<p>4#断路器</p>'+
								'<p>5#断路器</p>'+
								/* '<p>6#断路器</p>'+ */
							'</div>'+
							'<div class="a4-right2 bortopccc">'+
							'<div>'+stat1Dw+'</div><p class="dw">&nbsp;</p>'+
							'<div>'+stat2Dw+'</div><p class="dw">&nbsp;</p>'+
							'<div>'+stat3Dw+'</div><p class="dw">&nbsp;</p>'+
							'<div>'+stat4Dw+'</div><p class="dw">&nbsp;</p>'+
							'<div>'+stat5Dw+'</div><p class="dw">&nbsp;</p>'+
								/* '<p>'+getIsNull(bms.stat6)+'</p>'+ */
							'</div>'+
						'</div>'+
					'</div>';
		  }
		  $(".sb-center").empty().html(html);
 	}
</script>	
	
</body>
</html>