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
<title>光伏逆变器</title>
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
						<input type="text" value="" id="sta_tim" placeholder="请输入开始时间" class="fl quinput Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim\')}'})"> 
						<input type="text" value="" id="end_tim" placeholder="请输入结束时间" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sta_tim\')}'})">
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
						<input type="button" value="查询" class="querybut" onclick="currentPage  = 1; getData();">
						<input type="button" value="下载" class="querybut down" onclick="getDataDown()" >
					</div>
				</div>
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10 mb50 bb-box">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list" id="datalist1">
						 <tr >
							<th colspan="2">设备编号</th>
							<th>发电量</th>
							<th>转换效率</th>
							<th>等价发电时</th>
							<th>支路电流离散率</th>
							<th>正常运行时长</th>
							<th>告警运行时长</th>
							<th>故障运行时长</th>
							<th>通讯中断时长</th>
						</tr>
						<tbody id="datalist">
							<tr>
								<td colspan="10">暂无数据</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode1"></div> 
			</div>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list" id="datalist3" style="display:none;">
				 <tr >
					<td colspan="2">设备编号</td>
					<td>发电量</td>
					<td>转换效率</td>
					<td>等价发电时</td>
					<td>支路电流离散率</td>
					<td>正常运行时长</td>
					<td>告警运行时长</td>
					<td>故障运行时长</td>
					<td>通讯中断时长</td>
				</tr>
				<tbody id="datalist2">
					<tr>
						<td colspan="10">暂无数据</td>
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
		getAppType('GFNBQ');
		
		var dayy=getDateToday();
		
		$("#sta_tim").val(dayy);
		$("#end_tim").val(dayy);
	});
	
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
	
	function getDataDown(){
		var param="";
		var pws_id = $("#companyPws").val();
		if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
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
		if($("#app_mod").val()!="" &&$("#app_mod").val()!="qxz" && $("#app_mod").val()!= undefined  ){
			param+="&&app_mod="+$("#app_mod").val();
		}
		if($("#flagValue").val()!=""){
			param+="&&flagValue="+$("#flagValue").val();
		}
		layer.confirm("确定下载？",function(){
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url:url+"getPVInfStaBetweenDay.htm",
				data:param,
				type:"post",
				dataType:"json",
				success:function(data){
					if(data.resultcode=="USR000"){
						getPageData = data.data;
						var htmls='';
						if( data.data.length > 0 ){
							var d=data.data[0];
								htmls+= 
										'<tr>'+
											'<td rowspan="4">统计</td>'+
											'<td>最大</td>'+
											'<td>'+getFixedNum5(d.max_power)+'</td>'+
											'<td>'+getFixedNum5(d.max_cnv_eff)+'</td>'+
											'<td>'+getFixedNum5(d.max_power_whe_equ)+'</td>'+
											'<td>'+getFixedNum5(d.max_bra_u_dis_rate)+'</td>'+
											'<td>'+getFixedNum5(d.max_good_run_time)+'</td>'+
											'<td>'+getFixedNum5(d.max_fault_time)+'</td>'+
											'<td>'+getFixedNum5(d.max_failure_time)+'</td>'+
											'<td>'+getFixedNum5(d.max_com_int_time)+'</td>'+
										'</tr>'+
										'<tr>'+
											'<td>最小</td>'+
											'<td>'+getFixedNum5(d.min_power)+'</td>'+
											'<td>'+getFixedNum5(d.min_cnv_eff)+'</td>'+
											'<td>'+getFixedNum5(d.min_power_whe_equ)+'</td>'+
											'<td>'+getFixedNum5(d.min_bra_u_dis_rate)+'</td>'+
											'<td>'+getFixedNum5(d.min_good_run_time)+'</td>'+
											'<td>'+getFixedNum5(d.min_fault_time)+'</td>'+
											'<td>'+getFixedNum5(d.min_failure_time)+'</td>'+
											'<td>'+getFixedNum5(d.min_com_int_time)+'</td>'+
										'</tr>'+
										'<tr>'+
											'<td>平均</td>'+
											'<td>'+getFixedNum5(d.avg_power)+'</td>'+
											'<td>'+getFixedNum5(d.avg_cnv_eff)+'</td>'+
											'<td>'+getFixedNum5(d.avg_power_whe_equ)+'</td>'+
											'<td>'+getFixedNum5(d.avg_bra_u_dis_rate)+'</td>'+
											'<td>'+getFixedNum5(d.avg_good_run_time)+'</td>'+
											'<td>'+getFixedNum5(d.avg_fault_time)+'</td>'+
											'<td>'+getFixedNum5(d.avg_failure_time)+'</td>'+
											'<td>'+getFixedNum5(d.avg_com_int_time)+'</td>'+
										'</tr>'+
										'<tr>'+
											'<td>合计</td>'+
											'<td>'+getFixedNum5(d.sum_power)+'</td>'+
											'<td>-</td>'+
											'<td>'+getFixedNum5(d.sum_power_whe_equ)+'</td>'+
											'<td>-</td>'+
											'<td>'+getFixedNum5(d.sum_good_run_time)+'</td>'+
											'<td>'+getFixedNum5(d.sum_fault_time)+'</td>'+
											'<td>'+getFixedNum5(d.sum_failure_time)+'</td>'+
											'<td>'+getFixedNum5(d.sum_com_int_time)+'</td>'+
										'</tr>';
								  for(var i=0;i<d.pvLst.length;i++){
									  var s = d.pvLst[i];
									  var trColor = "";
									  var trColor2 = "";
									  var trColor3 = "";
									  var trColor4= "";
									  var trColor5 = "";
									  var trColor6 = "";
									  var trColor7 = "";
									  var trColor8 = "";
									  if(s!=null){
										  if(s.color!=null && s.color!= undefined ){
											  trColor  = s.color == 1 ? "background:red ;color:#fff;  " :s.color == 2 ? "background:blue ;color:#fff;" : s.color == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_ce!=null&& s.color_ce!= undefined ){
											  trColor2  = s.color_ce == 1 ? "background:red ;color:#fff;  " :s.color_ce == 2 ? "background:blue ;color:#fff;" : s.color_ce == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_we!=null&& s.color_we!= undefined ){
											  trColor3  = s.color_we == 1 ? "background:red ;color:#fff;  " :s.color_we == 2 ? "background:blue ;color:#fff;" : s.color_we == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_budr!=null&& s.color_budr!= undefined ){
											  trColor4  = s.color_budr == 1 ? "background:red ;color:#fff;  " :s.color_budr == 2 ? "background:blue ;color:#fff;" : s.color_budr == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_grt!=null&& s.color_grt!= undefined ){
											  trColor5  = s.color_grt == 1 ? "background:red ;color:#fff;  " :s.color_grt == 2 ? "background:blue ;color:#fff;" : s.color_grt == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_ft!=null&& s.color_ft!= undefined ){
											  trColor6  = s.color_ft == 1 ? "background:red ;color:#fff;  " :s.color_ft == 2 ? "background:blue ;color:#fff;" : s.color_ft == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_flt!=null&& s.color_flt!= undefined ){
											  trColor7  = s.color_flt == 1 ? "background:red ;color:#fff;  " :s.color_flt == 2 ? "background:blue ;color:#fff;" : s.color_flt == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_cit!=null&& s.color_cit!= undefined ){
											  trColor8  = s.color_cit == 1 ? "background:red ;color:#fff;  " :s.color_cit == 2 ? "background:blue ;color:#fff;" : s.color_cit == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  htmls += '<tr>'+
														'<td colspan="2" style="mso-number-format:\'\@\';">'+s.equ_nam+'</td>'+
														'<td style="'+trColor+'">'+getFixedNum5(s.power)+'</td>'+
														'<td style="'+trColor2+'">'+getFixedNum5(s.cnv_eff)+'</td>'+
														'<td style="'+trColor3+'">'+getFixedNum5(s.power_whe_equ)+'</td>'+
														'<td style="'+trColor4+'">'+getFixedNum5(s.bra_u_dis_rate)+'</td>'+
														'<td style="'+trColor5+'">'+getFixedNum5(s.good_run_time)+'</td>'+
														'<td style="'+trColor6+'">'+getFixedNum5(s.fault_time)+'</td>'+
														'<td style="'+trColor7+'">'+getFixedNum5(s.failure_time)+'</td>'+
														'<td style="'+trColor8+'">'+getFixedNum5(s.com_int_time)+'</td>'+
													'</tr>';
									  }
								  }
							 
							  $("#datalist2").html(htmls);
							  
							  layer.close(indexlayer);
							  
						 	  downLoadFile('datalist3',"光伏逆变器报表");
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
		if($("#app_mod").val()!="" &&$("#app_mod").val()!="qxz" && $("#app_mod").val()!= undefined  ){
			param+="&&app_mod="+$("#app_mod").val();
		}
		if($("#flagValue").val()!=""){
			param+="&&flagValue="+$("#flagValue").val();
		}
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getPVInfStaBetweenDay.htm",
			data:param,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					getPageData = data.data;
					var htmls='';
					if( data.data.length > 0 ){
						var d=data.data[0];
							htmls+= 
									'<tr>'+
										'<td rowspan="4">统计</td>'+
										'<td>最大</td>'+
										'<td>'+getFixedNum5(d.max_power)+'</td>'+
										'<td>'+getFixedNum5(d.max_cnv_eff)+'</td>'+
										'<td>'+getFixedNum5(d.max_power_whe_equ)+'</td>'+
										'<td>'+getFixedNum5(d.max_bra_u_dis_rate)+'</td>'+
										'<td>'+getFixedNum5(d.max_good_run_time)+'</td>'+
										'<td>'+getFixedNum5(d.max_fault_time)+'</td>'+
										'<td>'+getFixedNum5(d.max_failure_time)+'</td>'+
										'<td>'+getFixedNum5(d.max_com_int_time)+'</td>'+
									'</tr>'+
									'<tr>'+
										'<td>最小</td>'+
										'<td>'+getFixedNum5(d.min_power)+'</td>'+
										'<td>'+getFixedNum5(d.min_cnv_eff)+'</td>'+
										'<td>'+getFixedNum5(d.min_power_whe_equ)+'</td>'+
										'<td>'+getFixedNum5(d.min_bra_u_dis_rate)+'</td>'+
										'<td>'+getFixedNum5(d.min_good_run_time)+'</td>'+
										'<td>'+getFixedNum5(d.min_fault_time)+'</td>'+
										'<td>'+getFixedNum5(d.min_failure_time)+'</td>'+
										'<td>'+getFixedNum5(d.min_com_int_time)+'</td>'+
									'</tr>'+
									'<tr>'+
										'<td>平均</td>'+
										'<td>'+getFixedNum5(d.avg_power)+'</td>'+
										'<td>'+getFixedNum5(d.avg_cnv_eff)+'</td>'+
										'<td>'+getFixedNum5(d.avg_power_whe_equ)+'</td>'+
										'<td>'+getFixedNum5(d.avg_bra_u_dis_rate)+'</td>'+
										'<td>'+getFixedNum5(d.avg_good_run_time)+'</td>'+
										'<td>'+getFixedNum5(d.avg_fault_time)+'</td>'+
										'<td>'+getFixedNum5(d.avg_failure_time)+'</td>'+
										'<td>'+getFixedNum5(d.avg_com_int_time)+'</td>'+
									'</tr>'+
									'<tr>'+
										'<td>合计</td>'+
										'<td>'+getFixedNum5(d.sum_power)+'</td>'+
										'<td>-</td>'+
										'<td>'+getFixedNum5(d.sum_power_whe_equ)+'</td>'+
										'<td>-</td>'+
										'<td>'+getFixedNum5(d.sum_good_run_time)+'</td>'+
										'<td>'+getFixedNum5(d.sum_fault_time)+'</td>'+
										'<td>'+getFixedNum5(d.sum_failure_time)+'</td>'+
										'<td>'+getFixedNum5(d.sum_com_int_time)+'</td>'+
									'</tr>';
							  for(var i=0;i<d.pvLst.length;i++){
								  var s = d.pvLst[i];
								  if(i < (currentPage*everyPageCount)){
									  var trColor = "";
									  var trColor2 = "";
									  var trColor3 = "";
									  var trColor4= "";
									  var trColor5 = "";
									  var trColor6 = "";
									  var trColor7 = "";
									  var trColor8 = "";
									  if(s!=null){
										  if(s.color!=null && s.color!= undefined ){
											  trColor  = s.color == 1 ? "background:red ;color:#fff;  " :s.color == 2 ? "background:blue ;color:#fff;" : s.color == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_ce!=null&& s.color_ce!= undefined ){
											  trColor2  = s.color_ce == 1 ? "background:red ;color:#fff;  " :s.color_ce == 2 ? "background:blue ;color:#fff;" : s.color_ce == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_we!=null&& s.color_we!= undefined ){
											  trColor3  = s.color_we == 1 ? "background:red ;color:#fff;  " :s.color_we == 2 ? "background:blue ;color:#fff;" : s.color_we == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_budr!=null&& s.color_budr!= undefined ){
											  trColor4  = s.color_budr == 1 ? "background:red ;color:#fff;  " :s.color_budr == 2 ? "background:blue ;color:#fff;" : s.color_budr == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_grt!=null&& s.color_grt!= undefined ){
											  trColor5  = s.color_grt == 1 ? "background:red ;color:#fff;  " :s.color_grt == 2 ? "background:blue ;color:#fff;" : s.color_grt == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_ft!=null&& s.color_ft!= undefined ){
											  trColor6  = s.color_ft == 1 ? "background:red ;color:#fff;  " :s.color_ft == 2 ? "background:blue ;color:#fff;" : s.color_ft == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_flt!=null&& s.color_flt!= undefined ){
											  trColor7  = s.color_flt == 1 ? "background:red ;color:#fff;  " :s.color_flt == 2 ? "background:blue ;color:#fff;" : s.color_flt == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  if(s.color_cit!=null&& s.color_cit!= undefined ){
											  trColor8  = s.color_cit == 1 ? "background:red ;color:#fff;  " :s.color_cit == 2 ? "background:blue ;color:#fff;" : s.color_cit == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
										  }
										  htmls += '<tr >'+
														'<td colspan="2">'+s.equ_nam+'</td>'+
														'<td style="'+trColor+'" >'+getFixedNum5(s.power)+'</td>'+
														'<td style="'+trColor2+'" >'+getFixedNum5(s.cnv_eff)+'</td>'+
														'<td style="'+trColor3+'" >'+getFixedNum5(s.power_whe_equ)+'</td>'+
														'<td style="'+trColor4+'" >'+getFixedNum5(s.bra_u_dis_rate)+'</td>'+
														'<td style="'+trColor5+'" >'+getFixedNum5(s.good_run_time)+'</td>'+
														'<td style="'+trColor6+'" >'+getFixedNum5(s.fault_time)+'</td>'+
														'<td style="'+trColor7+'" >'+getFixedNum5(s.failure_time)+'</td>'+
														'<td style="'+trColor8+'" >'+getFixedNum5(s.com_int_time)+'</td>'+
													'</tr>';
									  }
								  }
							  }
						 
						  $("#datalist").html(htmls);
						  getPageData = data.data;
	    				  //算出总页数
	    				  countAll = 0 ;
    					  if(getPageData[0].pvLst.length/everyPageCount > parseInt(getPageData[0].pvLst.length/everyPageCount)){   
    						  countAll=parseInt(getPageData[0].pvLst.length/everyPageCount)+1;   
    				      }else{   
    				    	  countAll=parseInt(getPageData[0].pvLst.length/everyPageCount);   
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
						$("#datalist").html("<tr><td colspan='10'>暂无数据</td></tr>");
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
		 var d=getPageData[0];
		 htmls +=  
		'<tr>'+	
			'<td rowspan="4">统计</td>'+
			'<td>最大</td>'+
			'<td>'+getFixedNum5(d.max_power)+'</td>'+
			'<td>'+getFixedNum5(d.max_cnv_eff)+'</td>'+
			'<td>'+getFixedNum5(d.max_power_whe_equ)+'</td>'+
			'<td>'+getFixedNum5(d.max_bra_u_dis_rate)+'</td>'+
			'<td>'+getFixedNum5(d.max_good_run_time)+'</td>'+
			'<td>'+getFixedNum5(d.max_fault_time)+'</td>'+
			'<td>'+getFixedNum5(d.max_failure_time)+'</td>'+
			'<td>'+getFixedNum5(d.max_com_int_time)+'</td>'+
		'</tr>'+
		'<tr>'+
			'<td>最小</td>'+
			'<td>'+getFixedNum5(d.min_power)+'</td>'+
			'<td>'+getFixedNum5(d.min_cnv_eff)+'</td>'+
			'<td>'+getFixedNum5(d.min_power_whe_equ)+'</td>'+
			'<td>'+getFixedNum5(d.min_bra_u_dis_rate)+'</td>'+
			'<td>'+getFixedNum5(d.min_good_run_time)+'</td>'+
			'<td>'+getFixedNum5(d.min_fault_time)+'</td>'+
			'<td>'+getFixedNum5(d.min_failure_time)+'</td>'+
			'<td>'+getFixedNum5(d.min_com_int_time)+'</td>'+
		'</tr>'+
		'<tr>'+
			'<td>平均</td>'+
			'<td>'+getFixedNum5(d.avg_power)+'</td>'+
			'<td>'+getFixedNum5(d.avg_cnv_eff)+'</td>'+
			'<td>'+getFixedNum5(d.avg_power_whe_equ)+'</td>'+
			'<td>'+getFixedNum5(d.avg_bra_u_dis_rate)+'</td>'+
			'<td>'+getFixedNum5(d.avg_good_run_time)+'</td>'+
			'<td>'+getFixedNum5(d.avg_fault_time)+'</td>'+
			'<td>'+getFixedNum5(d.avg_failure_time)+'</td>'+
			'<td>'+getFixedNum5(d.avg_com_int_time)+'</td>'+
		'</tr>'+
		'<tr>'+
			'<td>合计</td>'+
			'<td>'+getFixedNum5(d.sum_power)+'</td>'+
			'<td>'+getFixedNum5(d.sum_cnv_eff)+'</td>'+
			'<td>'+getFixedNum5(d.sum_power_whe_equ)+'</td>'+
			'<td>'+getFixedNum5(d.sum_bra_u_dis_rate)+'</td>'+
			'<td>'+getFixedNum5(d.sum_good_run_time)+'</td>'+
			'<td>'+getFixedNum5(d.sum_fault_time)+'</td>'+
			'<td>'+getFixedNum5(d.sum_failure_time)+'</td>'+
			'<td>'+getFixedNum5(d.sum_com_int_time)+'</td>'+
		'</tr>';
		
		 var max = 0 ;
		 if ( (currentPage*everyPageCount) >  getPageData[0].pvLst.length-1 ){
			 max = getPageData[0].pvLst.length; 
		 }else{
			 max = (currentPage*everyPageCount) ;
		 }
		for(var i=((currentPage-1)*everyPageCount);i<max;i++){
			  var s = getPageData[0].pvLst[i];
			  if(i < (currentPage*everyPageCount)){
				  var trColor = "";
				  var trColor2 = "";
				  var trColor3 = "";
				  var trColor4= "";
				  var trColor5 = "";
				  var trColor6 = "";
				  var trColor7 = "";
				  var trColor8 = "";
				  if(s!=null){
					  if(s.color!=null && s.color!= undefined ){
						  trColor  = s.color == 1 ? "background:red ;color:#fff;  " :s.color == 2 ? "background:blue ;color:#fff;" : s.color == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
					  }
					  if(s.color_ce!=null&& s.color_ce!= undefined ){
						  trColor2  = s.color_ce == 1 ? "background:red ;color:#fff;  " :s.color_ce == 2 ? "background:blue ;color:#fff;" : s.color_ce == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
					  }
					  if(s.color_we!=null&& s.color_we!= undefined ){
						  trColor3  = s.color_we == 1 ? "background:red ;color:#fff;  " :s.color_we == 2 ? "background:blue ;color:#fff;" : s.color_we == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
					  }
					  if(s.color_budr!=null&& s.color_budr!= undefined ){
						  trColor4  = s.color_budr == 1 ? "background:red ;color:#fff;  " :s.color_budr == 2 ? "background:blue ;color:#fff;" : s.color_budr == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
					  }
					  if(s.color_grt!=null&& s.color_grt!= undefined ){
						  trColor5  = s.color_grt == 1 ? "background:red ;color:#fff;  " :s.color_grt == 2 ? "background:blue ;color:#fff;" : s.color_grt == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
					  }
					  if(s.color_ft!=null&& s.color_ft!= undefined ){
						  trColor6  = s.color_ft == 1 ? "background:red ;color:#fff;  " :s.color_ft == 2 ? "background:blue ;color:#fff;" : s.color_ft == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
					  }
					  if(s.color_flt!=null&& s.color_flt!= undefined ){
						  trColor7  = s.color_flt == 1 ? "background:red ;color:#fff;  " :s.color_flt == 2 ? "background:blue ;color:#fff;" : s.color_flt == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
					  }
					  if(s.color_cit!=null&& s.color_cit!= undefined ){
						  trColor8  = s.color_cit == 1 ? "background:red ;color:#fff;  " :s.color_cit == 2 ? "background:blue ;color:#fff;" : s.color_cit == 3 ? "background:#E8C709 ;color:#fff;"  : "" ;
					  }
					  htmls += '<tr >'+
								'<td colspan="2">'+s.equ_nam+'</td>'+
								'<td style="'+trColor+'" >'+getFixedNum5(s.power)+'</td>'+
								'<td style="'+trColor2+'" >'+getFixedNum5(s.cnv_eff)+'</td>'+
								'<td style="'+trColor3+'" >'+getFixedNum5(s.power_whe_equ)+'</td>'+
								'<td style="'+trColor4+'" >'+getFixedNum5(s.bra_u_dis_rate)+'</td>'+
								'<td style="'+trColor5+'" >'+getFixedNum5(s.good_run_time)+'</td>'+
								'<td style="'+trColor6+'" >'+getFixedNum5(s.fault_time)+'</td>'+
								'<td style="'+trColor7+'" >'+getFixedNum5(s.failure_time)+'</td>'+
								'<td style="'+trColor8+'" >'+getFixedNum5(s.com_int_time)+'</td>'+
							'</tr>';
				  }
			  }
		  }
		 $("#datalist").html(htmls);
		 layer.close(indexlayer);  //关闭 loading 
	}
	
	</script>
</body>
</html>