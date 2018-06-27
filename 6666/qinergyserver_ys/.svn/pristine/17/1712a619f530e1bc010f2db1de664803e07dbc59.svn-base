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
<title>月报</title>
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
				<div class="query">
					<div class="fl">
						<input type="text" value="" id="date" placeholder="请输入时间" class="fl quinput Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM'})"> 
					</div>
					<div class="fr pr30">
						<input type="button" value="查询"  onclick="currentPage  = 1; getData();" class="querybut">
						<input type="button" value="下载" class="querybut down" onclick="getDataDown()" >
					</div>
				</div>
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10 mb50 bb-box">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list" id="datalist1">
						 <tr >
							<th rowspan="2">日期</th>
							<th colspan="3">辐射</th>
							<th colspan="2">光伏</th>
							<th colspan="2">储能</th>
							<th colspan="3">充电桩</th>
						</tr>
						<tr >
							<th rowspan="1">日照小时数(h)</th>
							<th rowspan="1">峰日照小时数(h)</th>
							<th rowspan="1">总辐射量(kWh/㎡)</th>
							<th rowspan="1">发电量(kWh)</th>
							<th rowspan="1">等效利用小时数(h)</th>
							<th rowspan="1">充电量(kWh)</th>
							<th rowspan="1">放电量(kWh)</th>
							<th rowspan="1">充电量(kWh)</th>
							<th rowspan="1">充电时间(h)</th>
							<th rowspan="1">充电有效小时数(h)</th>
						</tr>
						<tbody id="datalist">
							<tr><td colspan="11">暂无数据</td></tr>
						</tbody>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode1"></div> 
			</div>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list" id="datalist3" style="display:none;">
				 <tr >
					<th rowspan="2">日期</th>
					<th colspan="3">辐射</th>
					<th colspan="2">光伏</th>
					<th colspan="2">储能</th>
					<th colspan="3">充电桩</th>
				</tr>
				<tr >
					<th rowspan="1">日照小时数(h)</th>
					<th rowspan="1">峰日照小时数(h)</th>
					<th rowspan="1">总辐射量(kWh/㎡)</th>
					<th rowspan="1">发电量(kWh)</th>
					<th rowspan="1">等效利用小时数(h)</th>
					<th rowspan="1">充电量(kWh)</th>
					<th rowspan="1">放电量(kWh)</th>
					<th rowspan="1">充电量(kWh)</th>
					<th rowspan="1">充电时间(h)</th>
					<th rowspan="1">充电有效小时数(h)</th>
				</tr>
				<tbody id="datalist2">
					<tr><td colspan="11">暂无数据</td></tr>
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
	})
	
	function getDataDown(){
		var param="";
		var pws_id = $("#companyPws").val();
		if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "type=1&&pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
		}
		var date = $("#date").val();
		if(date != "" && date != undefined ){
			date=date+"-01";
			param += "&&date="+date;
		}else{
			layer.alert("请选择时间");
			return;
		}
		layer.confirm("确定下载？",function(){
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url:url+"getPwsYearMonthReportInfLst.htm",
				data:param,
				type:"post",
				dataType:"json",
				success:function(data){
					if(data.resultcode=="USR000"){
						var html="";
						if(data.data.length > 0 ){
							for(var i=0;i<data.data.length;i++){
								var d = data.data[i];
								html+="<tr>"+
								"<td>"+d.tol_tim+"</td>"+
								"<td>"+getFixedNum5(d.pvs_sun_hour)+"</td>"+
								"<td>"+getFixedNum5(d.pvs_pek_sun_hour)+"</td>"+
								"<td>"+getFixedNum5(d.pvs_radiation_tol)+"</td>"+
								"<td>"+getFixedNum5(d.power)+"</td>"+
								"<td>"+getFixedNum5(d.pow_gen_eff_hours)+"</td>"+
								"<td>"+getFixedNum5(d.phi)+"</td>"+
								"<td>"+getFixedNum5(d.phe)+"</td>"+
								"<td>"+getFixedNum5(d.cha_vol)+"</td>"+
								"<td>"+getFixedNum5(d.cha_tim)+"</td>"+
								"<td>"+getFixedNum5(d.cha_gen_eff_hours)+"</td>"+
								"</tr>";
							}
							$("#datalist2").html(html);
							 
							layer.close(indexlayer);
						  	 
							downLoadFile("datalist3","运行月报");
						}else{
							$("#datalist2").empty();
							layer.close(indexlayer);
							layer.alert("暂无数据");
						}
					 
					}else{
						layer.alert(data.desc);
					}
				}
			})
		})
	}
	
	var getPageData;
	var countAll = 0;
	var currentPage  = 1;
	var everyPageCount = 25 ;
	function getData(flag){
		var param="";
		var pws_id = $("#companyPws").val();
		if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "type=1&&pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
		}
		var date = $("#date").val();
		if(date != "" && date != undefined ){
			date=date+"-01";
			param += "&&date="+date;
		}else{
			layer.alert("请选择时间");
			return;
		}
		param += "&currentPage="+currentPage;
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getPwsYearMonthReportInfLst.htm",
			data:param,
			type:"post",
			dataType:"json",
			success:function(data){
				layer.close(indexlayer);
				if(data.resultcode=="USR000"){
					var html="";
					if(data.data.length > 0 ){
						for(var i=0;i<data.data.length;i++){
							var d = data.data[i];
							if(i<(currentPage*everyPageCount)){
								html+="<tr>"+
								"<td>"+d.tol_tim+"</td>"+
								"<td>"+getFixedNum5(d.pvs_sun_hour)+"</td>"+
								"<td>"+getFixedNum5(d.pvs_pek_sun_hour)+"</td>"+
								"<td>"+getFixedNum5(d.pvs_radiation_tol)+"</td>"+
								"<td>"+getFixedNum5(d.power)+"</td>"+
								"<td>"+getFixedNum5(d.pow_gen_eff_hours)+"</td>"+
								"<td>"+getFixedNum5(d.phi)+"</td>"+
								"<td>"+getFixedNum5(d.phe)+"</td>"+
								"<td>"+getFixedNum5(d.cha_vol)+"</td>"+
								"<td>"+getFixedNum5(d.cha_tim)+"</td>"+
								"<td>"+getFixedNum5(d.cha_gen_eff_hours)+"</td>"+
								"</tr>";
							}
						}
						$("#datalist").html(html);
						getPageData=data.data;
					    countAll = 0 ;
					    if(getPageData.length/everyPageCount > parseInt(getPageData.length/everyPageCount)){   
						    countAll=parseInt(getPageData.length/everyPageCount)+1;   
				        }else{   
				    	    countAll=parseInt(getPageData.length/everyPageCount);   
				        };
				        $("#tcdPageCode1").createPage({
	 				        pageCount:countAll,
	 				        current:currentPage,
	 				        backFn:function(p){
	 				        	currentPage = p;
	 				        	getPageData1();
	 				        }
	 			    	});
					}else{
						layer.close(indexlayer);
						$("#datalist").html("<tr><td colspan='11'>暂无数据</td></tr>");
						$("#tcdPageCode1").empty();
					}

				  	 
				}else{
					layer.alert(data.desc);
				}
			}
		})
	}
	function getPageData1(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		if ( (currentPage*everyPageCount) >  getPageData.length-1 ){
			 max = getPageData.length; 
		 }else{
			 max = (currentPage*everyPageCount) ;
		 }
		 var html="";
		 for(var i=((currentPage-1)*everyPageCount);i<max;i++){
			 var d = getPageData[i];
			 
			 html+="<tr>"+
				"<td>"+d.tol_tim+"</td>"+
				"<td>"+getFixedNum5(d.pvs_sun_hour)+"</td>"+
				"<td>"+getFixedNum5(d.pvs_pek_sun_hour)+"</td>"+
				"<td>"+getFixedNum5(d.pvs_radiation_tol)+"</td>"+
				"<td>"+getFixedNum5(d.pow_gen_eff_hours)+"</td>"+
				"<td>"+getFixedNum5(d.power)+"</td>"+
				"<td>"+getFixedNum5(d.phi)+"</td>"+
				"<td>"+getFixedNum5(d.phe)+"</td>"+
				"<td>"+getFixedNum5(d.cha_vol)+"</td>"+
				"<td>"+getFixedNum5(d.cha_tim)+"</td>"+
				"<td>"+getFixedNum5(d.cha_gen_eff_hours)+"</td>"+
				"</tr>";
		 }
		 $("#datalist").html(html);
		 layer.close(indexlayer);

	}
	
 
	</script>
</body>
</html>