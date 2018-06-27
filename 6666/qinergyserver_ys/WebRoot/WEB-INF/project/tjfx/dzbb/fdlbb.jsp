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
<title>发电量报表</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />

</head>
<body class="bgfc">
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
						<input type="text" value="" id="time" placeholder="请输入时间" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM'})">
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
						<input type="button" value="查询" class="querybut" onclick="currentPage =1 ;  getData();">
						<input type="button" value="下载" class="querybut down" onclick="getDataDown()" >
					</div>
				</div>
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10 mb50 bb-box">
				<div class="clr wauto" style="overflow-x:scroll">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list" id="datalist" >
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
		
		getAppType('GFNBQ');
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
			    			 var htmls = "<option value='qxz'>-设备型号-</option>";
			    			 if(data.data){
			    				 if(data.data.length > 0 ){
			        				 for(var i = 0; i< data.data.length ; i++){
			    		    				var d =  data.data[i];
			    		    				htmls +=  "<option value='"+d.id+"'>"+d.app_mod+"</option>";
			    	    			 }
			        				 $("#app_mod").html(htmls); 
			        			 } 
			    			 } 
						} else {
			               layer.alert(data.desc);
						}
			    	}
			    })
		 }
	}
	
	//下载时 渲染数据
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
		layer.confirm("确定下载？",function(){
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url:url+"getPVStaMonYear.htm",
				data:param,
				type:"post",
				//async : false,
				dataType:"json",
				success:function(data){
					if(data.resultcode=="USR000"){
						getPageData = data.data;
						
						var html="";
						var html1="";
						var html2="";
						var html3="";
						var html4="";
						var html5="";
						var htmls="";
						if(data.data.length>0){
							
							html+='<tr>'+
							 '<td colspan="2">光伏逆变器</td>';
							/* html1 += '<tr>'+
								'<td rowspan="5">统计</td>'+
							   '</tr>'; */
						    html2 += '<tr>'+
						    			'<td rowspan="4">统计</td>'+
										'<td>最大</td>';
							html3 += '<tr>'+
										'<td>最小</td>';
							html4 += '<tr>'+
										'<td>平均</td>';
							html5 += '<tr>'+
										'<td>合计</td>';
							for(var i=0;i<data.data[0].maxMinAvgSumAndPowerLst.length;i++){
								var d=data.data[0].maxMinAvgSumAndPowerLst[i];
								var dd = "";
								if((d.tol_tim).split("-")){
									if($("#type").val() == 2){
										dd = (d.tol_tim).split("-")[2]+"日";
									}else if($("#type").val() == 3){
										dd = (d.tol_tim).split("-")[1]+"月";
									}
									
									html+='<td>'+dd+'</td>';
									
								 	html2 +="<td>"+getFixedNum5(d.max_power)+"</td>";
								 	html3 +="<td>"+getFixedNum5(d.min_power)+"</td>";
								 	html4 +="<td>"+getFixedNum5(d.avg_power)+"</td>";
								 	html5 +="<td>"+getFixedNum5(d.sum_power)+"</td>";
								}
								
							}
							html+='<td>合计</td></tr>';
						
							
							html2 +=  '<td>无</td></tr>';
							html3 +=  '<td>无</td></tr>';
							html4 +=  '<td>无</td></tr>';
							html5 +=  '<td>'+getFixedNum5(data.data[0].staTolLst[0].sum_power)+'</td></tr>';
							
							for(var i=0;i<data.data[0].powerTolLst.length;i++){
								var d=data.data[0].powerTolLst[i];
								htmls+="<tr>"+
								'<td colspan="2">'+d.equ_nam+"</td>";
								for(var j=0;j<data.data[0].maxMinAvgSumAndPowerLst.length;j++){
									var a=data.data[0].maxMinAvgSumAndPowerLst[j];
									if((a.tol_tim).split("-")){//判断为了跟表头数据一致
										for(var p = 0;p<a.powerLst.length;p++){
											var oo = a.powerLst[p];
											if(oo.equ_num == d.equ_num){
												var trColor  = oo.color == 1 ? "background:red ;color:#fff; " :oo.color == 2 ? "background:blue;color:#fff;" : oo.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;
												htmls += '<td style="'+trColor+'">'+getFixedNum5(oo.power)+'</td>';
											}
										}
									}
								}
								var trColor2  = d.color == 1 ? "background:red ;color:#fff; " :d.color == 2 ? "background:blue;color:#fff;" : d.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;	
								htmls += '<td style="'+trColor2+'">'+getFixedNum5(d.tol_power)+'</td>';
								htmls += '</tr>'	;
								 
							}
							
							var totleHtml = html + html1 + html2 + html3 + html4 + html5 + htmls ;
							$("#datalist2").html(totleHtml);
							 
							layer.close(indexlayer);
							
							//设置宽高
			   	    		var ScreenWidth  = (document.documentElement.clientWidth);  
			   	    		ScreenWidth = ScreenWidth;
			   	    		
							var tab = $('.table-list');
							var td = $(tab.find('tr')[2]).find('td');
							if(td.length * 60 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
								tab[0].width = td.length * 60;
							}
	
							downLoadFile('datalist2',"发电量报表");
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
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getPVStaMonYear.htm",
			data:param,
			type:"post",
			//async : false,
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					getPageData = data.data;
					
					var html="";
					var html1="";
					var html2="";
					var html3="";
					var html4="";
					var html5="";
					var htmls="";
					if(data.data.length>0){
						
						html+='<tr>'+
						 '<th colspan="2">光伏逆变器</th>';
						/* html1 += '<tr>'+
							'<td rowspan="5">统计</td>'+
						   '</tr>'; */
					    html2 += '<tr>'+
					    			'<td rowspan="4">统计</td>'+
									'<td>最大</td>';
						html3 += '<tr>'+
									'<td>最小</td>';
						html4 += '<tr>'+
									'<td>平均</td>';
						html5 += '<tr>'+
									'<td>合计</td>';
						for(var i=0;i<data.data[0].maxMinAvgSumAndPowerLst.length;i++){
							var d=data.data[0].maxMinAvgSumAndPowerLst[i];
							var dd = "";
							if((d.tol_tim).split("-")){
								if($("#type").val() == 2){
									dd = (d.tol_tim).split("-")[2]+"日";
								}else if($("#type").val() == 3){
									dd = (d.tol_tim).split("-")[1]+"月";
								}
								
								html+='<th>'+dd+'</th>';
								
							 	html2 +="<td>"+getFixedNum5(d.max_power)+"</td>";
							 	html3 +="<td>"+getFixedNum5(d.min_power)+"</td>";
							 	html4 +="<td>"+getFixedNum5(d.avg_power)+"</td>";
							 	html5 +="<td>"+getFixedNum5(d.sum_power)+"</td>";
							}
							
						}
						html+='<th>合计</th></tr>';
					
						
						html2 +=  '<td>无</td></tr>';
						html3 +=  '<td>无</td></tr>';
						html4 +=  '<td>无</td></tr>';
						html5 +=  '<td>'+getFixedNum5(data.data[0].staTolLst[0].sum_power)+'</td></tr>';
						
						for(var i=0;i<data.data[0].powerTolLst.length;i++){
							var d=data.data[0].powerTolLst[i];
							if(i < (currentPage*everyPageCount)){
								htmls+="<tr>"+
								'<td colspan="2">'+d.equ_nam+"</td>";
								for(var j=0;j<data.data[0].maxMinAvgSumAndPowerLst.length;j++){
									var a=data.data[0].maxMinAvgSumAndPowerLst[j];
									if((a.tol_tim).split("-")){//判断为了跟表头数据一致
										for(var p = 0;p<a.powerLst.length;p++){
											var oo = a.powerLst[p];
											if(oo.equ_num == d.equ_num){
												var trColor  = oo.color == 1 ? "background:red ;color:#fff; " :oo.color == 2 ? "background:blue;color:#fff;" : oo.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;
												htmls += '<td style="'+trColor+'">'+getFixedNum5(oo.power)+'</td>';
											}
										}
									}
								}
								var trColor2  = d.color == 1 ? "background:red ;color:#fff; " :d.color == 2 ? "background:blue;color:#fff;" : d.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;	
								htmls += '<td style="'+trColor2+'">'+getFixedNum5(d.tol_power)+'</td>';
								htmls += '</tr>'	;
							}
						}
						
						var totleHtml = html + html1 + html2 + html3 + html4 + html5 + htmls ;
						$("#datalist").html(totleHtml);
						
						getPageData = data.data;
    				   //算出总页数
    				   countAll = 0 ;
   					   if(getPageData[0].powerTolLst.length/everyPageCount > parseInt(getPageData[0].powerTolLst.length/everyPageCount)){   
   						  countAll=parseInt(getPageData[0].powerTolLst.length/everyPageCount)+1;   
   				       }else{   
   				    	  countAll=parseInt(getPageData[0].powerTolLst.length/everyPageCount);   
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
						$("#datalist").html("<tr><td colspan='9'>暂无数据</td></tr>");
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
		 var html="";
		var html1="";
		var html2="";
		var html3="";
		var html4="";
		var html5="";
		html+='<tr>'+
		 '<th colspan="2">逆变器</th>';
		/* html1 += '<tr>'+
			'<td rowspan="5">统计</td>'+
		   '</tr>'; */
	    html2 += '<tr>'+
	    			'<td rowspan="4">统计</td>'+
					'<td>最大</td>';
		html3 += '<tr>'+
					'<td>最小</td>';
		html4 += '<tr>'+
					'<td>平均</td>';
		html5 += '<tr>'+
					'<td>合计</td>';
		for(var i=0;i<getPageData[0].maxMinAvgSumAndPowerLst.length;i++){
			var d=getPageData[0].maxMinAvgSumAndPowerLst[i];
			var dd = "";
			if((d.tol_tim).split("-")){
				if($("#type").val() == 2){
					dd = (d.tol_tim).split("-")[2]+"日";
				}else if($("#type").val() == 3){
					dd = (d.tol_tim).split("-")[1]+"月";
				}
				
				html+='<th>'+dd+'</th>';
				
			 	html2 +="<td>"+getFixedNum5(d.max_power)+"</td>";
			 	html3 +="<td>"+getFixedNum5(d.min_power)+"</td>";
			 	html4 +="<td>"+getFixedNum5(d.avg_power)+"</td>";
			 	html5 +="<td>"+getFixedNum5(d.sum_power)+"</td>";
			}
			
		}
		html+='<th>合计</th></tr>';
		
		
		html2 +=  '<td>无</td></tr>';
		html3 +=  '<td>无</td></tr>';
		html4 +=  '<td>无</td></tr>';
		html5 +=  '<td>'+getFixedNum5(getPageData[0].staTolLst[0].sum_power)+'</td></tr>';
			
			
		 var htmls = "";
		 var max = 0 ;
		 if ( (currentPage*everyPageCount) >  getPageData[0].powerTolLst.length-1 ){
			 max = getPageData[0].powerTolLst.length; 
		 }else{
			 max = (currentPage*everyPageCount) ;
		 }
		 
		 for(var i=((currentPage-1)*everyPageCount);i<max;i++){
			 var d=getPageData[0].powerTolLst[i];
				htmls+="<tr>"+
				'<td colspan="2">'+d.equ_nam+"</td>";
				for(var j=0;j<getPageData[0].maxMinAvgSumAndPowerLst.length;j++){
					var a=getPageData[0].maxMinAvgSumAndPowerLst[j];
					if((a.tol_tim).split("-")){//判断为了跟表头数据一致
						for(var p = 0;p<a.powerLst.length;p++){
							var oo = a.powerLst[p];
							if(oo.equ_num == d.equ_num){
								var trColor  = oo.color == 1 ? "background:red ;color:#fff; " :oo.color == 2 ? "background:blue;color:#fff;" : oo.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;
								htmls += '<td style="'+trColor+'">'+getFixedNum5(oo.power)+'</td>';
							}
						}
					}
				}
				var trColor2  = d.color == 1 ? "background:red ;color:#fff; " :d.color == 2 ? "background:blue;color:#fff;" : d.color == 3 ? "background:#E8C709;color:#fff;"  : "" ;	
				htmls += '<td style="'+trColor2+'">'+getFixedNum5(d.tol_power)+'</td>';
				htmls += '</tr>'	;
		 }
		 var totleHtml = html + html1 + html2 + html3 + html4 + html5 + htmls ;
		 $("#datalist").html(totleHtml);
		// $("#datalist").html(htmls);
		 layer.close(indexlayer);  //关闭 loading 
	}
	 
	</script>
</body>
</html>