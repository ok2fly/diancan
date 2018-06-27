<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充电量分析</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
</head>
<body  class="bgfc">
	<input type="hidden" id="userId" value="${user.id}" >
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<a style="display:none" href="#" id="exportExcel"></a>
	<div  class="pl15 ml15 mr15 mt15">
		<div class="w100 h670">
			<div class="bg-ff pb18 pl15 pt10 clr pl8 tjfx-box">
				<div class="query">
					<div class="fl">
						 <select class="fl quinput w20"  id="companyOne"  onchange="setCompanytwo(this.value);">
           	   			 	<option value="qxz">请选择一级公司</option>
           	   			 </select>
           	   			 <select class="fl quinput w20"  id="companyTwo" style="margin-left:10px;" onchange="setCompanyThree(this.value);">
           	   			 	<option value="qxz">请选择二级公司</option>
           	   			 </select>
           	   			 <select class="fl quinput w20"  id="companyThree" style="margin-left:10px;" onchange="setPws(this.value);">
           	   			 	<option value="qxz">请选择三级公司</option>
           	   			 </select>
           	   			  <select class="fl quinput w20"  id="companyPws" style="margin-left:10px;"  >
           	   			 	<option value="qxz">请选择电站</option>
           	   			 </select>
					</div>
				</div>
				<div class="query mt15">
					<div class="fl">
						<select class="fl quinput w20"  id="type"  onchange="changeTime(this.value)"  >
           	   			 	<option value="2">按月统计</option>
           	   			 	<option value="3">按年统计</option>
           	   			 </select>
						<input type="text" value="" id="time" placeholder="请输入时间" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM'})" >
						<!-- <input type="text" value="" id="app_mod" placeholder="请输入设备型号" class="fl quinput" style="margin-left:10px;">  -->
						 <select class="fl quinput w20"  id="app_mod"  style="margin-left:10px;"  >
           	   			 	 <option value='qxz'>-设备型号-</option>
           	   			 </select>
						<input type="text" value="" id="flagValue" placeholder="请输入标记电量" class="fl quinput" style="margin-left:10px;">   
					</div>
				</div>
				<div class="query mt15">
					<div class="fl">
						<input type="text" value="" id="sta_rtd_pow" placeholder="请输入开始容量值" class="fl quinput" > 
						<input type="text" value="" id="end_rtd_pow" placeholder="请输入结束容量值" class="fl quinput" style="margin-left:10px;" > 
					</div>
					<div class="fr pr30">
						<input type="button" value="查询" class="querybut" onclick="return getData();">
						<input type="button" value="下载" class="querybut down" onclick="getDataDown()">
					</div>
				</div>
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10 mb50 bb-box">
				<div class="clr wauto" style="overflow-x:scroll" >
					<table border="0" width="100%" cellpadding="0" cellspacing="0" class="table-list" id="datalist">
						<tr>
							<td >暂无数据</td>
						</tr>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode1"></div> 
			</div>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"  id="datalist2" style="display:none;">
				 <tr>
					<td >暂无数据</td>
				</tr>
			</table>
			<div class="blank0"></div>
		</div>
	</div>
	<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/checkCom.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/exportExcel.js?pubVersion=201802070001"></script>
	<script>
	$(function(){
		getCompanyOne();
		getAppType('ZLCDZ');
		getAppType('JLCDZ');
	});
	
	function changeTime(val){
		$("#time").val('');
		 if(val == "2"){
			 $("#time").attr("onFocus","WdatePicker({dateFmt:'yyyy-MM'})");
			 $("#time").attr("onclick","WdatePicker({dateFmt:'yyyy-MM'})");
		 }else if(val == "3"){
			 $("#time").attr("onFocus","WdatePicker({dateFmt:'yyyy'})");
			 $("#time").attr("onclick","WdatePicker({dateFmt:'yyyy'})");
		 } 
	}
	
	/*统计分析的报表 需要的设备型号*/
	function getAppType(val){
		 if(val != "0" && val != undefined){
			 var param = "app_typ_ide="+val;
				$.ajax({
			    	url:url+"getBasAppByAppTypIde.htm",
			    	data : param,
			    	dataType:"json",
			    	type:"post",
			    	success:function(data){
			    		if (data.resultcode=="USR000") {
			    			 var htmls = "";
			    			 if(data.data){
			    				 if(data.data.length > 0 ){
			        				 for(var i = 0; i< data.data.length ; i++){
			    		    				var d =  data.data[i];
			    		    				htmls +=  "<option value='"+d.id+"'>"+d.app_mod+"</option>";
			    	    			 }
			        				 $("#app_mod").append(htmls); 
			        			 } 
			    			 } 
						} else {
			               layer.alert(data.desc);
						}
			    	}
			    })
		 }
		 
	}
	
	function getDataDown(){
		var param="";
		var pws_id = $("#companyPws").val();
		if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
		}
		var time = $("#time").val();
		if(time != '' && time != undefined ){
			 if($("#type").val() == "2"){
				 time = time+"-01";
			 }else if($("#type").val() == "3"){
				 time = time+"-01-01";
			 } 
			param  += "&&date="+time;
		}else{
			layer.alert("请选择统计时间");
			return;
		}
		
		if($("#type").val()!=""){
			param+="&&type="+$("#type").val();
		}
		if($("#sta_rtd_pow").val()!=""){
			param+="&&sta_rtd_pow="+$("#sta_rtd_pow").val();
		}
		if($("#end_rtd_pow").val()!=""){
			param+="&&end_rtd_pow="+$("#end_rtd_pow").val();
		}
		if($("#app_mod").val()!="" &&$("#app_mod").val()!="qxz" && $("#app_mod").val()!= undefined  ){
			param+="&&app_mod="+$("#app_mod").val();
		}
		if($("#flagValue").val()!=""){
			param+="&&flagValue="+$("#flagValue").val();
		}
		console.log("param="+param);
		param += "&currentPage="+currentPage;
		layer.confirm("确定下载？",function(){
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url:url+"getChpStaMonYear.htm",
				data:param,
				type:"post",
				dataType:"json",
				success:function(data){
					if(data.resultcode=="USR000"){
						countAll = data.totalPage;
						currentPage = data.currentPage;
						var htmlsHeater = "";
						var htmls0 = "";
						var htmls1 = "";
						var htmls2 = "";
						var htmls3 = "";
						var htmls4 = "";
						var htmls= '';
						if( data.data.length > 0 ){
							var d=data.data[0];
							htmlsHeater += '<tr>'+
									 '<td colspan="2">设备编号</td>';
						/* 	htmls0 += '<tr>'+
										'<td rowspan="5">统计</td>'+
									   '</tr>'; */
						    htmls1 += '<tr>'+
						    			'<td rowspan="4">统计</td>'+
										'<td>最大</td>';
							htmls2 += '<tr>'+
										'<td>最小</td>';
							htmls3 += '<tr>'+
										'<td>平均</td>';
							htmls4 += '<tr>'+
										'<td>合计</td>';
							for(var i =0 ; i<d.maxMinAvgSumAndChpLst.length;i++){
								var s = d.maxMinAvgSumAndChpLst[i];
								var dd = "";
								
								if((s.tol_tim).split("-")){
									if($("#type").val() == 2){
										dd = (s.tol_tim).split("-")[2]+"日";
									}else if($("#type").val() == 3){
										dd = (s.tol_tim).split("-")[1]+"月";
									}
									
									//表格头
									htmlsHeater +=  '<td>'+dd+'</td>';
									
									//拼接合计、平均、最大、最小数据
									htmls1 +=  '<td>'+getIsNull2(s.max_cha_vol)+'</td>';
									htmls2 +=  '<td>'+getIsNull2(s.min_cha_vol)+'</td>';
									htmls3 +=  '<td>'+getIsNull2(s.avg_cha_vol)+'</td>';
									htmls4 +=  '<td>'+getIsNull2(s.sum_cha_vol)+'</td>';
								}
								
							}
							htmlsHeater +='<th>合计</th>';
							htmlsHeater +='</tr>';
							
							htmls1 +=  '<td>无</td>';
							htmls2 +=  '<td>无</td>';
							htmls3 +=  '<td>无</td>';
							htmls4 +=  '<td>'+getFixedNum5(d.staTolLst[0].sum_cha_vol)+'</td>';
							
							htmls1 +='</tr>';
							htmls2 +='</tr>';
							htmls3 +='</tr>';
							htmls4 +='</tr>';
							
							 
							for(var i=0;i<d.chpTolLst.length;i++){
								  var s = d.chpTolLst[i];
								  htmls += '<tr>'+
												'<td colspan="2">'+s.equ_nam+'</td>';
								  for(var k=0; k < d.maxMinAvgSumAndChpLst.length ; k++ ){
										var ss = d.maxMinAvgSumAndChpLst[k];
										if((ss.tol_tim).split("-")){//判断为了跟表头数据一致
											for(var p = 0;p<ss.chpLst.length;p++){
												var oo = ss.chpLst[p];
												if(oo.equ_num == s.equ_num){
													var trColor  = oo.color == 1 ? "background:red ;color:#fff; " :oo.color == 2 ? "background:blue;color:#fff;" : oo.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;
													htmls += '<td style="'+trColor+'">'+getIsNull2(oo.cha_vol)+'</td>'
												}
											}
										}
								   }
								   var trColor2  = oo.color == 1 ? "background:red ;color:#fff; " :oo.color == 2 ? "background:blue;color:#fff;" : oo.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;	
									 htmls += '<td style="'+trColor2+'">'+getIsNull2(s.tol_cha_vol)+'</td>'
									 htmls += '</tr>'	;
							  }
							 
						  	var totleHtml = htmlsHeater + htmls0 + htmls1 + htmls2 + htmls3 + htmls4 + htmls ;
							$("#datalist2").html(totleHtml);
							 
							layer.close(indexlayer);
							 
							downLoadFile("datalist2","充电量报表");
							 
						}else{
							$("#datalist2").empty();
							layer.close(indexlayer);
							layer.alert("暂无数据");
						}
					}else{
						layer.close(indexlayer);
						layer.alert(data.desc);
					}
				}
			})
		})
	} 
	
	var getPageData ;
	var countAll = 0;
	var currentPage  = 1;
	var everyPageCount = 25 ;
	function getData(){
		var param="";
		var pws_id = $("#companyPws").val();
		if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
		}
		var time = $("#time").val();
		if(time != '' && time != undefined ){
			 if($("#type").val() == "2"){
				 time = time+"-01";
			 }else if($("#type").val() == "3"){
				 time = time+"-01-01";
			 } 
			param  += "&&date="+time;
		}else{
			layer.alert("请选择统计时间");
			return;
		}
		
		if($("#type").val()!=""){
			param+="&&type="+$("#type").val();
		}
		if($("#sta_rtd_pow").val()!=""){
			param+="&&sta_rtd_pow="+$("#sta_rtd_pow").val();
		}
		if($("#end_rtd_pow").val()!=""){
			param+="&&end_rtd_pow="+$("#end_rtd_pow").val();
		}
		if($("#app_mod").val()!="" &&$("#app_mod").val()!="qxz" && $("#app_mod").val()!= undefined  ){
			param+="&&app_mod="+$("#app_mod").val();
		}
		if($("#flagValue").val()!=""){
			param+="&&flagValue="+$("#flagValue").val();
		}
		console.log("param="+param);
		param += "&currentPage="+currentPage;
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getChpStaMonYear.htm",
			data:param,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					countAll = data.totalPage;
					currentPage = data.currentPage;
					var htmlsHeater = "";
					var htmls0 = "";
					var htmls1 = "";
					var htmls2 = "";
					var htmls3 = "";
					var htmls4 = "";
					var htmls= '';
					if( data.data.length > 0 ){
						var d=data.data[0];
						htmlsHeater += '<tr>'+
								 '<th colspan="2">设备编号</th>';
						/* htmls0 += '<tr>'+
									'<td rowspan="5">统计</td>'+
								   '</tr>'; */
					    htmls1 += '<tr>'+
					    			'<td rowspan="4">统计</td>'+
									'<td>最大</td>';
						htmls2 += '<tr>'+
									'<td>最小</td>';
						htmls3 += '<tr>'+
									'<td>平均</td>';
						htmls4 += '<tr>'+
									'<td>合计</td>';
						for(var i =0 ; i<d.maxMinAvgSumAndChpLst.length;i++){
							var s = d.maxMinAvgSumAndChpLst[i];
							var dd = "";
							
							if((s.tol_tim).split("-")){
								if($("#type").val() == 2){
									dd = (s.tol_tim).split("-")[2]+"日";
								}else if($("#type").val() == 3){
									dd = (s.tol_tim).split("-")[1]+"月";
								}
								
								//表格头
								htmlsHeater +=  '<th>'+dd+'</th>';
								
								//拼接合计、平均、最大、最小数据
								htmls1 +=  '<td>'+getIsNull2(s.max_cha_vol)+'</td>';
								htmls2 +=  '<td>'+getIsNull2(s.min_cha_vol)+'</td>';
								htmls3 +=  '<td>'+getIsNull2(s.avg_cha_vol)+'</td>';
								htmls4 +=  '<td>'+getIsNull2(s.sum_cha_vol)+'</td>';
							}
							
						}
						htmlsHeater +='<th>合计</th>';
						htmlsHeater +='</tr>';
						
						htmls1 +=  '<td>无</td>';
						htmls2 +=  '<td>无</td>';
						htmls3 +=  '<td>无</td>';
						htmls4 +=  '<td>'+getFixedNum5(d.staTolLst[0].sum_cha_vol)+'</td>';
						
						htmls1 +='</tr>';
						htmls2 +='</tr>';
						htmls3 +='</tr>';
						htmls4 +='</tr>';
						
						 
						for(var i=0;i<d.chpTolLst.length;i++){
							  var s = d.chpTolLst[i];
							  if(i < (currentPage*everyPageCount)){
								  htmls += '<tr>'+
												'<td colspan="2">'+s.equ_nam+'</td>';
								  for(var k=0; k < d.maxMinAvgSumAndChpLst.length ; k++ ){
										var ss = d.maxMinAvgSumAndChpLst[k];
										if((ss.tol_tim).split("-")){//判断为了跟表头数据一致
											for(var p = 0;p<ss.chpLst.length;p++){
												var oo = ss.chpLst[p];
												if(oo.equ_num == s.equ_num){
													var trColor  = oo.color == 1 ? "background:red ;color:#fff; " :oo.color == 2 ? "background:blue;color:#fff;" : oo.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;
													htmls += '<td style="'+trColor+'">'+getIsNull2(oo.cha_vol)+'</td>' 
													/* htmls += '<td style="'+trColor+'">'+(k+1)+'</td>' */
												}
											}
										}
								   }
								   var trColor2  = oo.color == 1 ? "background:red ;color:#fff; " :oo.color == 2 ? "background:blue;color:#fff;" : oo.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;	
									htmls += '<td style="'+trColor2+'">'+getIsNull2(s.tol_cha_vol)+'</td>' 
									/*  htmls += '<td style="'+trColor2+'">'+34+'</td>' */
									 htmls += '</tr>'	;
							  }
						  }
						 
					  	var totleHtml = htmlsHeater + htmls0 + htmls1 + htmls2 + htmls3 + htmls4 + htmls ;
						$("#datalist").html(totleHtml);
						
						getPageData = data.data;
    				   //算出总页数
    				   countAll = 0 ;
   					   if(getPageData[0].chpTolLst.length/everyPageCount > parseInt(getPageData[0].chpTolLst.length/everyPageCount)){   
   						  countAll=parseInt(getPageData[0].chpTolLst.length/everyPageCount)+1;   
   				       }else{   
   				    	  countAll=parseInt(getPageData[0].chpTolLst.length/everyPageCount);   
   				       };
    				   //countAll = data.totalPage;
    				   $("#tcdPageCode1").createPage({
	 				        pageCount:countAll,
	 				        current:currentPage,
	 				        backFn:function(p){
	 				        	currentPage = p;
	 				        	getPageData1();
	 				        }
 			    		});
    				   
						layer.close(indexlayer);
						//设置宽高
		   	    		var ScreenWidth  = (document.documentElement.clientWidth);  
		   	    		ScreenWidth = ScreenWidth;
		   	    		
						var tab = $('.table-list');
						var td = $(tab.find('tr')[2]).find('td');
						if(td.length * 60 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
							tab[0].width = td.length * 60;
						}
						 
					}else{
						layer.close(indexlayer);
						$("#datalist").html("<tr><td colspan='6'>暂无数据</td></tr>");
						$("#tcdPageCode1").empty();
					}
				}else{
					layer.close(indexlayer);
					layer.alert(data.desc);
				}
			}
		})
	} 
	
	function getPageData1(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		var htmlsHeater = "";
		var htmls0 = "";
		var htmls1 = "";
		var htmls2 = "";
		var htmls3 = "";
		var htmls4 = "";
		var htmls= '';
		 
		var d=getPageData[0];
		htmlsHeater += '<tr>'+
				 '<th colspan="2">设备编号</th>';
		/* htmls0 += '<tr>'+
					'<td rowspan="5">统计</td>'+
				   '</tr>'; */
		   htmls1 += '<tr>'+
		   			'<td rowspan="4">统计</td>'+
					'<td>最大</td>';
		htmls2 += '<tr>'+
					'<td>最小</td>';
		htmls3 += '<tr>'+
					'<td>平均</td>';
		htmls4 += '<tr>'+
					'<td>合计</td>';
		for(var i =0 ; i<d.maxMinAvgSumAndChpLst.length;i++){
			var s = d.maxMinAvgSumAndChpLst[i];
			var dd = "";
			
			if((s.tol_tim).split("-")){
				if($("#type").val() == 2){
					dd = (s.tol_tim).split("-")[2]+"日";
				}else if($("#type").val() == 3){
					dd = (s.tol_tim).split("-")[1]+"月";
				}
				
				//表格头
				htmlsHeater +=  '<th>'+dd+'</th>';
				
				//拼接合计、平均、最大、最小数据
				htmls1 +=  '<td>'+getIsNull2(s.max_cha_vol)+'</td>';
				htmls2 +=  '<td>'+getIsNull2(s.min_cha_vol)+'</td>';
				htmls3 +=  '<td>'+getIsNull2(s.avg_cha_vol)+'</td>';
				htmls4 +=  '<td>'+getIsNull2(s.sum_cha_vol)+'</td>';
			}
			
		}
		htmlsHeater +='<th>合计</th>';
		htmlsHeater +='</tr>';
		
		htmls1 +=  '<td>无</td>';
		htmls2 +=  '<td>无</td>';
		htmls3 +=  '<td>无</td>';
		htmls4 +=  '<td>'+d.staTolLst[0].sum_cha_vol+'</td>';
		
		htmls1 +='</tr>';
		htmls2 +='</tr>';
		htmls3 +='</tr>';
		htmls4 +='</tr>';
		
		var htmlss = "";
		var max = 0 ;
		if ( (currentPage*everyPageCount) >  getPageData[0].chpTolLst.length-1 ){
		 	max = getPageData[0].chpTolLst.length; 
		}else{
			max = (currentPage*everyPageCount) ;
		}
			 
			 
			 
		 for(var i=((currentPage-1)*everyPageCount);i<max;i++){
			 var s=getPageData[0].chpTolLst[i];
			  htmls += '<tr>'+
							'<td colspan="2">'+s.equ_nam+'</td>';
			  for(var k=0; k < d.maxMinAvgSumAndChpLst.length ; k++ ){
					var ss = d.maxMinAvgSumAndChpLst[k];
					if((ss.tol_tim).split("-")){//判断为了跟表头数据一致
						for(var p = 0;p<ss.chpLst.length;p++){
							var oo = ss.chpLst[p];
							if(oo.equ_num == s.equ_num){
								var trColor  = oo.color == 1 ? "background:red ;color:#fff; " :oo.color == 2 ? "background:blue;color:#fff;" : oo.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;
								htmls += '<td style="'+trColor+'">'+getIsNull2(oo.cha_vol)+'</td>'
							}
						}
					}
			   }
			   var trColor2  = oo.color == 1 ? "background:red ;color:#fff; " :oo.color == 2 ? "background:blue;color:#fff;" : oo.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;	
				 htmls += '<td style="'+trColor2+'">'+getIsNull2(s.tol_cha_vol)+'</td>'
				 htmls += '</tr>'	;
		}
		 
	  	var totleHtml = htmlsHeater + htmls0 + htmls1 + htmls2 + htmls3 + htmls4 + htmls ;
		$("#datalist").html(totleHtml);
		
		layer.close(indexlayer);
		
			 
						 
	} 
	 
	</script>
</body>
</html>