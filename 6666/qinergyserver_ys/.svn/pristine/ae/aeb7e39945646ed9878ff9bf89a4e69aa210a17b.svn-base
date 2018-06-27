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
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
		
	</head>
	<body >
		<input type="hidden" id="equNum" value="${equNum}">
		<div class="pt18 fl " style="width: 100%">
				<div class=" tabxq ">
					 	<table cellpadding="0" cellspacing="0" border="0" width="100%"  >
						<tr>
							<th>设备编号</th>
							<td id="equ_num"></td>
							<th>设备状态</th>
							<td id="stat"></td>
						</tr>
						<tr>
							<th>工作状态</th>
							<td id="workStat"></td>
							<th>工作模式</th>
							<td id="mode"></td>
						</tr>
						<tr>
							<th>告警码</th>
							<td id="faultCode"></td>
							<th>高压侧电压(V)</th>
							<td id="uHigh"></td>
						</tr>
						<tr>
							<th>高压侧电流(A)</th>
							<td id="iHigh"></td>
							<th>高压侧功率(P)</th>
							<td id="pHigh"></td>
						</tr>
						<tr>
							<th>低压侧电压(V)</th>
							<td id="uLow"></td>
							<th>低压侧电流(A)</th>
							<td id="iLow"></td>
						</tr>
						<tr>
							<th>低压侧功率(P)</th>
							<td id="pLow"></td>
							<th>创建时间</th>
							<td id="crtTim"></td>
						</tr>
						
					</table>
				</div>
		</div>
		
		
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>
<script type="text/javascript">
	$(function (){
		var equ_num=$("#equNum").val();
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getDCDCOtherInf.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data){
						var d=data.data;
						var stat = d.stat == 0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "正常停机" : d.stat == 3 ? "告警运行":d.stat == 4 ? "故障停机" : d.stat == 5 ? "限电运行" : "--";
						var workStat=d.workStat==0?"停止":d.workStat==1?"故障":d.workStat==2?"充电":d.workStat==3?"待机":d.workStat==4?"放电":"";
						var mode=d.mode==0?"恒流模式":d.mode==1?"恒压模式":d.mode==2?"恒功率模式":d.mode==3?"下垂模式":d.mode==4?"MPPT":d.mode==5?"负荷模式":"";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#workStat").html(workStat);
						$("#mode").html(mode);
						$("#faultCode").html(d.faultCode);
						$("#uHigh").html(d.uHigh);
						$("#iHigh").html(d.iHigh);
						$("#pHigh").html(d.pHigh);
						$("#uLow").html(d.uLow);
						$("#iLow").html(d.iLow);
						$("#pLow").html(d.pLow);
						$("#crtTim").html(getLocalDateAndTime(d.crtTim,1));

					}
						
					
					//$("#").val(d.);
					layer.close(indexlayer);

				}else{
					layer.close(indexlayer);
					layer.alert(data.desc);
				}
			}
		})
	})
</script>		

</body>
</html>