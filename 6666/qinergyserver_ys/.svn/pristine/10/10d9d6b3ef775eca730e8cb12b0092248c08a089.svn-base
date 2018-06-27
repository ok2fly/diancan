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
							<th>告警码</th>
							<td id="faultCode"></td>
							<th>工作模式</th>
							<td id="mode"></td>
						</tr>
						<tr>
							<th>并离网状态</th>
							<td id="gridStat"></td>
							<th>直流电压(V)</th>
							<td id="udc"></td>
						</tr>
						<tr>
							<th>直流电流(V)</th>
							<td id="idc"></td>
							<th>直流功率(p)</th>
							<td id="pdc"></td>
						</tr>
						<tr>
							<th>Uab线电压(V)</th>
							<td id="uab"></td>
							<th>Ubc线电压(V)</th>
							<td id="ubc"></td>
						</tr>
						<tr>
							<th>Uca线电压(V)</th>
							<td id="uca"></td>
							<th>A相电压(V)</th>
							<td id="ua"></td>
						</tr>
						<tr>
							<th>B相电压(V)</th>
							<td id="ub"></td>
							<th>C相电压(V)</th>
							<td id="uc"></td>
						</tr>
						<tr>
							<th>A相电流(A)</th>
							<td id="ia"></td>
							<th>B相电流(A)</th>
							<td id="ib"></td>
						</tr>
						<tr>
							<th>C相电流(A)</th>
							<td id="ic"></td>
							<th>A相有功(kW)</th>
							<td id="pa"></td>
						</tr>
						<tr>
							<th>B相有功(kW)</th>
							<td id="pb"></td>
							<th>C相有功(kW)</th>
							<td id="pc"></td>
						</tr>
						<tr>
							<th>有功功率(P)</th>
							<td id="psum"></td>
							<th>A相无功(kVar)</th>
							<td id="qa"></td>
						</tr>
						<tr>
							<th>B相无功(kVar)</th>
							<td id="qb"></td>
							<th>C相无功(kVar)</th>
							<td id="qc"></td>
						</tr>
						<tr>
							<th>无功功率(P)</th>
							<td id="qsum"></td>
							<th>累计输入电量(kWh)</th>
							<td id="phi"></td>
						</tr>
						<tr>
							<th>累计输出电量(kWh)</th>
							<td id="phe"></td>
							<th>效率</th>
							<td id="eff"></td>
						</tr>
						<tr>
							<th>功率因数</th>
							<td id="pf"></td>
							<th>频率(Hz)</th>
							<td id="freq"></td>
						</tr>
						<tr>
							<th>机内温度(°C)</th>
							<td id="temp"></td>
							<th>模块温度(°C)</th>
							<td id="tempMod"></td>
						</tr>
						<tr>
							<th>累计正常运行时间(h)</th>
							<td id="goodRunTime"></td>
							<th>累计正常停机时间(h)</th>
							<td id="downTime"></td>
						</tr>
						<tr>
							<th>累计告警运行时间(h)</th>
							<td id="faultTime"></td>
							<th>累计故障停机时间(h)</th>
							<td id="failureTime"></td>
						</tr>
						<tr>
							<th>累计通讯中断时间(h)</th>
							<td id="comIntTime"></td>
							<th>累计运行时间(h)</th>
							<td id="runTime"></td>
						</tr>
						<tr>
							<th>累计充电时间(h)</th>
							<td id="chargeTime"></td>
							<th>累计放电时间(h)</th>
							<td id="dischargeTime"></td>
						</tr>
						<tr>
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
			url:url+"getPcsInfByEquNumNew.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length>0){
						var d=data.data[0];
						var stat=d.stat==0?"通讯中断":d.stat==1?"正常运行":d.stat==2?"正常停机":d.stat==3?"告警运行":d.stat==4?"故障停机":"--";
						var mode=d.mode==0?"P/Q":d.mode==1?"V/F":d.mode==2?"虚拟同步发电机":d.mode==3?"直流恒压":"--";
						var gridStat=d.gridStat==0?"离网":d.gridStat==1?"并网":"--";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"--";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#faultCode").html(d.faultCode);
						$("#mode").html(mode);
						$("#gridStat").html(gridStat);
						$("#udc").html(d.udc);
						$("#idc").html(d.idc);
						$("#pdc").html(d.pdc);
						$("#uab").html(d.uab);
						$("#ubc").html(d.ubc);
						$("#uca").html(d.uca);
						$("#ua").html(d.ua);
						$("#ub").html(d.ub);
						$("#uc").html(d.uc);
						$("#ia").html(d.ia);
						$("#ib").html(d.ib);
						$("#ic").html(d.ic);
						$("#pa").html(d.pa);
						$("#pb").html(d.pb);
						$("#pc").html(d.pc);
						$("#psum").html(d.psum);
						$("#qa").html(d.qa);
						$("#qb").html(d.qb);
						$("#qc").html(d.qc);
						$("#qsum").html(d.qsum);
						$("#phi").html(d.phi);
						$("#phe").html(d.phe);
						$("#eff").html(d.eff);
						$("#pf").html(d.pf);
						$("#freq").html(d.freq);
						$("#temp").html(d.temp);
						$("#tempMod").html(d.tempMod);
						$("#goodRunTime").html(d.goodRunTime);
						$("#downTime").html(d.downTime);
						$("#faultTime").html(d.faultTime);
						$("#failureTime").html(d.failureTime);
						$("#comIntTime").html(d.comIntTime);
						$("#runTime").html(d.runTime);
						$("#chargeTime").html(d.chargeTime);
						$("#dischargeTime").html(d.dischargeTime);
						
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