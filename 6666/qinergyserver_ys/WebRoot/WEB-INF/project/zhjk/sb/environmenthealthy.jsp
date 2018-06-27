<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc-healthy.css?pubVersion=201802070001"> 
		<script type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
	</head>
	<body class="pl8t0 bgfc">
		<input type="hidden" id="pws_id" value="${pws_id}">
		<input type="hidden" id="app_typ_id" value="${app_typ_id}"> 
		<input type="hidden" id="equNum" value="${equNum}"> 
		<div class="hea-body">
			<div class="his-tit">健康状况</div>
			<div class="hea-main">
				<div class="top-left">
					<div class="pro borbot matop12">
						<div class="dian1"></div>
						<div class="pro-text">
							<div>最后报修时间</div>
							<p id="end_time1">无</p>
						</div>
					</div>
					<div class="pro borbot matop12">
						<div class="dian1"></div>
						<div class="pro-text">
							<div>最后检修时间</div>
							<p id="end_time2">无</p>
						</div>
					</div>
					<div class="pro borbot matop12">
						<div class="dian1"></div>
						<div class="pro-text">
							<div>下次检修时间</div>
							<p id="next_time">无</p>
						</div>
					</div>
					<div class="pro borbot matop12">
						<div class="dian1"></div>
						<div class="pro-text">
							<div>告警状态</div>
							<p id="info">无</p>
						</div>
					</div>
					<div class="pro  matop12">
						<div class="dian1"></div>
						<div class="pro-text">
							<div>累计报修数量</div>
							<p id="cou">无</p>
						</div>
					</div>
				</div>
				<div class="top-right" id="abc">
				</div>
			<div class="cler"></div>
			<div class="hea-table">
				<div class="a1" style="margin-left:15px;">
					<div class="fl">历史告警记录</div>
					<div class="fr">
						<input type="text"  id="sta_tim_gj" placeholder="开始时间" class=" Wdate"   onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'end_tim_gj\')}'})"> 
						<span  style="color:#999; ">---</span>
						<input type="text"  id="end_tim_gj" placeholder="结束时间" class="Wdate"    onFocus="WdatePicker({minDate:'#F{$dp.$D(\'sta_tim_gj\')}',maxDate:'%y-%M-%d'})"> 
						<input class="his-btn" type="submit" value="查询" onclick="currentPage = 1 ;getAlaHistoryLst();">
					</div>
					
				</div>
				<div style="height: 305px;">
				<table  width="100%" border="0" cellpadding="0" cellspacing="0" >
					<tr>
						<th>序号</th>
						<th>告警信息</th>
						<th>告警级别</th>
						<th>动作</th>
						<th>发生告警时间</th>
						
					</tr>
					<tbody id="tab1">
						<tr>
							<td colspan="5" >暂无数据</td>
							
						</tr>
					</tbody>
				</table>
				</div>
				<div class="tcdPageCode" id="tcdPage1">
				</div> 
			</div>
			<div class="cler"></div>
			<div class="hea-table">
				<div class="a1" style="margin-left:15px;">
					<div class="fl">设备维修记录</div>
					<div class="fr">
						<input type="text" id="dateTime_sta_wx" placeholder="开始时间" class="Wdate"    onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'dateTime_end_wx\')}'})"> 
						<span  style="color:#999; ">---</span>
						<input type="text" id="dateTime_end_wx" placeholder="结束时间" class=" Wdate"   onFocus="WdatePicker({minDate:'#F{$dp.$D(\'dateTime_sta_wx\')}',maxDate:'%y-%M-%d'})"> 
						<input class="his-btn" type="submit" value="查询" onclick="currentPage2 = 1 ; getMaintenanceLst();">
					</div>	
				</div>
				<div  style="height: 305px;">
				<table  width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>序号</th>
						<th>维修时间</th>
						<th>故障信息</th>
						<th>维修人员</th>
						<th>维修描述</th>
					</tr>
					<tbody id="tab2">
						<tr>
							<td colspan="5" >暂无数据</td>
							
						</tr>
					</tbody>
					
				</table>
				</div>
				<div class="tcdPageCode" id="tcdPage2"></div> 
			</div>
			<div class="cler"></div>
			<div class="hea-table mb50">
				<div class="a1" style="margin-left:15px;">
					<div class="fl">设备保养记录</div>
					<div class="fr">
						<input type="text" id="dateTime_sta_by" placeholder="开始时间" class=" Wdate"   onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'dateTime_end_by\')}'})"> 
						<span  style="color:#999; ">---</span>
						<input type="text" id="dateTime_end_by" placeholder="结束时间" class=" Wdate"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'dateTime_sta_by\')}',maxDate:'%y-%M-%d'})"> 
						<input class="his-btn" type="submit" value="查询" onclick="currentPage3 = 1;getOverhaulLst();">
					</div>
				</div>
				<div  style="height: 305px;">
				<table  width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>序号</th>
						<th>检修开始时间</th>
						<th>检修结束时间</th>
						<th>检修人员</th>
						<th>维修描述信息</th>
					</tr>
					<tbody id="tab3">
						<tr>
							<td colspan="5">暂无数据</td>
						</tr>
					</tbody>
					
				</table>
				</div>
				<div class="tcdPageCode" id="tcdPage3"></div> 
			</div>
			
			</div>
		</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>
<script type="text/javascript">
$(function(){
	var equ_num = sessionStorage.getItem("environmentEquNum")
	$("#equNum").val(equ_num);
	stateLine();
	getIntEquOpeInf();
	
	var result=getDateToday();
	
	$("#sta_tim_gj").val(result);
	$("#end_tim_gj").val(result);
	getAlaHistoryLst();
	
	$("#dateTime_sta_wx").val(result);
	$("#dateTime_end_wx").val(result);
	getMaintenanceLst();

	$("#dateTime_sta_by").val(result);
	$("#dateTime_end_by").val(result);
	getOverhaulLst();
	
});

 
</script>
	</body>
</html>
