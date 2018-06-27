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
<title>电表报表</title>
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
						<select value="" id="meter_typ"  class="fl quinput">
							<option value="0">-请选择电表类型-</option>
							<option value="1">关口表</option>
							<option value="2">光伏表</option>
							<option value="3">充电表</option>
							<option value="4">负荷表</option>
							<option value="5">储能表</option>
						</select> 
						<input type="text" value="" id="sta_tim" placeholder="请输入开始时间" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim\')}'})"> 
						<input type="text" value="" id="end_tim" placeholder="请输入结束时间" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sta_tim\')}'})"> 
					</div>
				</div>
				<div class="query mt15">
						<input type="text" value="" id="sta_rtd_pow" placeholder="请输入开始容量值" class="fl quinput"  > 
						<input type="text" value="" id="end_rtd_pow" placeholder="请输入结束容量值" class="fl quinput" style="margin-left:10px;">
						<div class="fr pr30">
							<input type="button" value="查询" class="querybut" onclick="return getData();">
						<input type="button" value="下载" class="querybut down" onclick="getDataDown()" >
						</div>
				</div> 
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10 mb50 bb-box">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list" id="datalist1">
						 <tr >
							<th rowspan="2">电表</th>
							<th rowspan="2">倍率</th>
							<th colspan="3">正向有功</th>
							<th colspan="3">反向有功</th>
							<th colspan="3">正向无功</th>
							<th colspan="3">反向无功</th>
						</tr>
						<tr rowspan="2">
							<th rowspan="1">起始码表值</th>
							<th rowspan="1">码表值</th>
							<th rowspan="1">电量</th>
							<th rowspan="1">起始码表值</th>
							<th rowspan="1">码表值</th>
							<th rowspan="1">电量</th>
							<th rowspan="1">起始码表值</th>
							<th rowspan="1">码表值</th>
							<th rowspan="1">电量</th>
							<th rowspan="1">起始码表值</th>
							<th rowspan="1">码表值</th>
							<th rowspan="1">电量</th>
						</tr>
						
						<tbody id="datalist">
							<tr><td colspan="14">暂无数据</td></tr>
						</tbody>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode1"></div> 
			</div>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list" id="datalist3" style="display:none;">
				<tr >
							<td rowspan="2">电表</td>
							<td rowspan="2">倍率</td>
							<td colspan="3">正向有功</td>
							<td colspan="3">反向有功</td>
							<td colspan="3">正向无功</td>
							<td colspan="3">反向无功</td>
						</tr>
						<tr rowspan="2">
							<td rowspan="1">起始码表值</td>
							<td rowspan="1">码表值</td>
							<td rowspan="1">电量</td>
							<td rowspan="1">起始码表值</td>
							<td rowspan="1">码表值</td>
							<td rowspan="1">电量</td>
							<td rowspan="1">起始码表值</td>
							<td rowspan="1">码表值</td>
							<td rowspan="1">电量</td>
							<td rowspan="1">起始码表值</td>
							<td rowspan="1">码表值</td>
							<td rowspan="1">电量</td>
						</tr>
				<tbody id="datalist2">
					<tr>
						<td colspan="14">暂无数据</td>
					</tr>
				</tbody>
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
		
		var dayy=getDateToday();
		
		$("#sta_tim").val(dayy);
		$("#end_tim").val(dayy);
	});
	
	function getDataDown(){
		var param="";
		var pws_id = $("#companyPws").val();
		if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
		}
		var meter_typ=$("#meter_typ").val()
		if($("#meter_typ").val()=="0"){
			 
		}else{
			param+="&&meter_typ="+$("#meter_typ").val();
		}
		
		if($("#sta_tim").val()!=""){
			param+="&&sta_tim="+$("#sta_tim").val();
		}else{
			layer.alert("请选择开始时间");
			return;
		}
		if($("#end_tim").val()!=""){
			param+="&&end_tim="+$("#end_tim").val();
		}else{
			layer.alert("请选择结束时间");
			return;
		}
		
		if($("#sta_rtd_pow").val()!=""){
			param+="&&sta_rtd_pow="+$("#sta_rtd_pow").val();
		}
		if($("#end_rtd_pow").val()!=""){
			param+="&&end_rtd_pow="+$("#end_rtd_pow").val();
		}
		layer.confirm("确定下载？",function(){
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url:url+"getPwsMeterReportInfLst.htm",
				data:param,
				type:"post",
				dataType:"json",
				success:function(data){
					if(data.resultcode=="USR000"){
						var htmls="";
						if(data.data.length > 0){
							for(var i=0;i<data.data.length;i++){
								var d=data.data[i];
								htmls+="<tr>"+
								"<td>"+d.equ_nam+"</td>";
								if(d.meterInfLst){
									var a=d.meterInfLst[0];
									if(a){
										
										htmls+="<td>"+getFixedNum5(a.ratio)+"</td>"+
										"<td>"+getFixedNum5(a.phi_sta_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.phi_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.phi_power)+"</td>"+
										"<td>"+getFixedNum5(a.phe_sta_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.phe_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.phe_power)+"</td>"+
										"<td>"+getFixedNum5(a.qhi_sta_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.qhi_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.qhi_power)+"</td>"+
										"<td>"+getFixedNum5(a.qhe_sta_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.qhe_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.qhe_power)+"</td>";
									}else{
										htmls+="<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>";
									}
								}
								htmls+="</tr>";
								
							}
							$("#datalist2").html(htmls);
							 
							layer.close(indexlayer);
							
							downLoadFile("datalist3","电表报表");
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
		var meter_typ=$("#meter_typ").val()
		if($("#meter_typ").val()=="0"){
			 
		}else{
			param+="&&meter_typ="+$("#meter_typ").val();
		}
		
		if($("#sta_tim").val()!=""){
			param+="&&sta_tim="+$("#sta_tim").val();
		}else{
			layer.alert("请选择开始时间");
			return;
		}
		if($("#end_tim").val()!=""){
			param+="&&end_tim="+$("#end_tim").val();
		}else{
			layer.alert("请选择结束时间");
			return;
		}
		
		if($("#sta_rtd_pow").val()!=""){
			param+="&&sta_rtd_pow="+$("#sta_rtd_pow").val();
		}
		if($("#end_rtd_pow").val()!=""){
			param+="&&end_rtd_pow="+$("#end_rtd_pow").val();
		}
		param += "&currentPage="+currentPage;
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getPwsMeterReportInfLst.htm",
			data:param,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					getPageData = data.data;
					var htmls="";
					if(data.data.length > 0){
						for(var i=0;i<data.data.length;i++){
							var d=data.data[i];
							if(i < (currentPage*everyPageCount)){
								htmls+="<tr>"+
								"<td>"+d.equ_nam+"</td>";
								if(d.meterInfLst){
									var a=d.meterInfLst[0];
									if(a){
										
										htmls+="<td>"+getFixedNum5(a.ratio)+"</td>"+
										"<td>"+getFixedNum5(a.phi_sta_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.phi_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.phi_power)+"</td>"+
										"<td>"+getFixedNum5(a.phe_sta_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.phe_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.phe_power)+"</td>"+
										"<td>"+getFixedNum5(a.qhi_sta_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.qhi_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.qhi_power)+"</td>"+
										"<td>"+getFixedNum5(a.qhe_sta_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.qhe_clk_val)+"</td>"+
										"<td>"+getFixedNum5(a.qhe_power)+"</td>";
									}else{
										htmls+="<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>"+
										"<td>"+"-"+"</td>";
									}
								}
								htmls+="</tr>";
							}
						}
						
						$("#datalist").html(htmls);
						getPageData = data.data;
	    				//算出总页数
	    				countAll = 0 ;
  					  	if(getPageData.length/everyPageCount > parseInt(getPageData.length/everyPageCount)){   
  						  	countAll=parseInt(getPageData.length/everyPageCount)+1;   
  				      	}else{   
  				    	  	countAll=parseInt(getPageData.length/everyPageCount);   
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
						
					}else{
						layer.close(indexlayer);
						$("#datalist").html("<tr><td colspan='14'>暂无数据</td></tr>");
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
		 var htmls="";
		 var max = 0 ;
		 if ( (getPageData*everyPageCount) >  getPageData.length-1 ){
			 max = getPageData.length; 
		 }else{
			 max = (currentPage*everyPageCount) ;
		 }
		 for(var i=((currentPage-1)*everyPageCount);i<max;i++){
			 var d=getPageData[i];
			 htmls+="<tr>"+
				"<td>"+d.equ_nam+"</td>";
				if(d.meterInfLst){
					var a=d.meterInfLst[0];
					if(a){
						
						htmls+="<td>"+getFixedNum5(a.ratio)+"</td>"+
						"<td>"+getFixedNum5(a.phi_sta_clk_val)+"</td>"+
						"<td>"+getFixedNum5(a.phi_clk_val)+"</td>"+
						"<td>"+getFixedNum5(a.phi_power)+"</td>"+
						"<td>"+getFixedNum5(a.phe_sta_clk_val)+"</td>"+
						"<td>"+getFixedNum5(a.phe_clk_val)+"</td>"+
						"<td>"+getFixedNum5(a.phe_power)+"</td>"+
						"<td>"+getFixedNum5(a.qhi_sta_clk_val)+"</td>"+
						"<td>"+getFixedNum5(a.qhi_clk_val)+"</td>"+
						"<td>"+getFixedNum5(a.qhi_power)+"</td>"+
						"<td>"+getFixedNum5(a.qhe_sta_clk_val)+"</td>"+
						"<td>"+getFixedNum5(a.qhe_clk_val)+"</td>"+
						"<td>"+getFixedNum5(a.qhe_power)+"</td>";
					}else{
						htmls+="<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>"+
						"<td>"+"-"+"</td>";
					}
				}
				htmls+="</tr>";
		 }
		 $("#datalist").html(htmls);
		 layer.close(indexlayer);  //关闭 loading 
	}
	 
	</script>
</body>
</html>