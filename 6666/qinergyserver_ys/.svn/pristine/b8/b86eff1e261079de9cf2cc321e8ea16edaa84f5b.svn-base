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
				<div class="tabxq">
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
							<th>支路数量</th>
							<td id="branchNum"></td>
						</tr>
						<tr>
							<th>直流电压 1(V)</th>
							<td id="udc1"></td>
							<th>直流电压 2(V)</th>
							<td id="udc2"></td>
						</tr>
						<tr>
							<th>直流电压3(V)</th>
							<td id="udc3"></td>
							<th>直流电压4(V)</th>
							<td id="udc4"></td>
						</tr>
						<tr>
							<th>直流电压5(V)</th>
							<td id="udc5"></td>
							<th>直流电压6(V)</th>
							<td id="udc6"></td>
						</tr>
						<tr>
							<th>直流电压 7(V)</th>
							<td id="udc7"></td>
							<th>直流电压 8(V)</th>
							<td id="udc8"></td>
						</tr>
						<tr>
							<th>直流电压9(V)</th>
							<td id="udc9"></td>
							<th>直流电压 10(V)</th>
							<td id="udc10"></td>
						</tr>
						<tr>
							<th>直流电流1(A)</th>
							<td id="idc1"></td>
							<th>直流电流2(A)</th>
							<td id="idc2"></td>
						</tr>
						<tr>
							<th>直流电流3(A)</th>
							<td id="idc3"></td>
							<th>直流电流4(A)</th>
							<td id="idc4"></td>
						</tr>
						<tr>
							<th>直流电流5(A)</th>
							<td id="idc5"></td>
							<th>直流电流6(A)</th>
							<td id="idc6"></td>
						</tr>
						<tr>
							<th>直流电流7(A)</th>
							<td id="idc7"></td>
							<th>直流电流8(A)</th>
							<td id="idc8"></td>
						</tr>
						<tr>
							<th>直流电流9(A)</th>
							<td id="idc9"></td>
							<th>直流电流10(A)</th>
							<td id="idc10"></td>
						</tr>
						<tr>
							<th>直流功率1(P)</th>
							<td id="pdc1"></td>
							<th>直流功率2(P)</th>
							<td id="pdc2"></td>
						</tr>
						<tr>
							<th>直流功率3(P)</th>
							<td id="pdc3"></td>
							<th>直流功率4(P)</th>
							<td id="pdc4"></td>
						</tr>
						<tr>
							<th>直流功率5(P)</th>
							<td id="pdc5"></td>
							<th>直流功率6(P)</th>
							<td id="pdc6"></td>
						</tr>
						<tr>
							<th>直流功率7(P)</th>
							<td id="pdc7"></td>
							<th>直流功率8(P)</th>
							<td id="pdc8"></td>
						</tr>
						<tr>
							<th>直流功率9(P)</th>
							<td id="pdc9"></td>
							<th>直流功率10(P)</th>
							<td id="pdc10"></td>
						</tr>
						<tr>
							<th>总直流功率(P)</th>
							<td id="pdcSum"></td>
							<th>Uab线电压(V)</th>
							<td id="uab"></td>
						</tr>
						<tr>
							<th>Ubc线电压(V)</th>
							<td id="ubc"></td>
							<th>Uca线电压(V)</th>
							<td id="uca"></td>
						</tr>
						<tr>
							<th>A 相电压(V)</th>
							<td id="ua"></td>
							<th>B 相电压(V)</th>
							<td id="ub"></td>
						</tr>
						<tr>
							<th>C 相电压(V)</th>
							<td id="uc"></td>
							<th>A 相电流(A)</th>
							<td id="ia"></td>
						</tr>
						<tr>
							<th>B 相电流(A)</th>
							<td id="ib"></td>
							<th>C 相电流(A)</th>
							<td id="ic"></td>
						</tr>
						<tr>
							<th>A相有功(kW)</th>
							<td id="pa"></td>
							<th>B相有功(kW)</th>
							<td id="Pb"></td>
						</tr>
						<tr>
							<th>C相有功(kW)</th>
							<td id="pc"></td>
							<th>有功功率(P)</th>
							<td id="psum"></td>
						</tr>
						<tr>
							<th>无功功率(kVar)</th>
							<td id="qsum"></td>
							<th>视在功率(kVar)</th>
							<td id="ssum"></td>
						</tr>
						<tr>
							<th>功率因数</th>
							<td id="pf"></td>
							<th>效率</th>
							<td id="eff"></td>
						</tr>
						<tr>
							<th>频率(Hz)</th>
							<td id="freq"></td>
							<th>离散率(%)</th>
							<td id="disRate"></td>
						</tr>
						<tr>
							<th>日发电量(kWh)</th>
							<td id="powerDay"></td>
							<th>总发电量(kWh)</th>
							<td id="powerAll"></td>
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
							<th>累计故障时长(h)</th>
							<td id="failureTime"></td>
						</tr>
						<tr>
							<th>累计通讯中断时间(h)</th>
							<td id="comIntTime"></td>
							<th>累计限电运行时间(h)</th>
							<td id="eleRunTime"></td>
						</tr>
						<tr>
							<th>累计运行时间(h)</th>
							<td id="timeAll"></td>
							<th>机内温度(°C)</th>
							<td id="temp"></td>
						</tr>
						<tr>
							<th>模块 1 温度(°C)</th>
							<td id="temp1"></td>
							<th>模块 2温度(°C)</th>
							<td id="temp2"></td>
						</tr>
						<tr>
							<th>模块 3温度(°C)</th>
							<td id="temp3"></td>
							<th>模块 4温度(°C)</th>
							<td id="temp4"></td>
						</tr>
						<tr>
							<th>模块 5温度(°C)</th>
							<td id="temp5"></td>
							<th>模块 6温度(°C)</th>
							<td id="temp6"></td>
						</tr>
						<tr>
							<th>正极对地阻抗值</th>
							<td id="imp1"></td>
							<th>负极对地阻抗值</th>
							<td id="imp2"></td>
						</tr>
						<tr>
							<th>限功率实际值</th>
							<td id="plimit"></td>
							<th>无功调节实际值</th>
							<td id="qlimit"></td>
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
			url:url+"getPvsInfByEquNumNew.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length>0){
						var d=data.data[0];
						var stat=d.stat==0?"通讯中断":d.stat==1?"正常运行":d.stat==2?"正常停机":d.stat==3?"告警运行":d.stat==4?"故障停机":d.stat==5?"限电运行":"--";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"--";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#faultCode").html(d.faultCode);
						$("#branchNum").html(d.branchNum);
						$("#udc1").html(d.udc1);
						$("#udc2").html(d.udc2);
						$("#udc3").html(d.udc3); 
						$("#udc4").html(d.udc4);
						$("#udc5").html(d.udc5);
						$("#udc6").html(d.udc6);
						$("#udc7").html(d.udc7); 
						$("#udc8").html(d.udc8);
						$("#udc9").html(d.udc9);
						$("#udc10").html(d.udc10);
						$("#idc1").html(d.idc1);
						$("#idc2").html(d.idc2);
						$("#idc3").html(d.idc3);
						$("#idc4").html(d.idc4);
						$("#idc5").html(d.idc5);
						$("#idc6").html(d.idc6);
						$("#idc7").html(d.idc7);
						$("#idc8").html(d.idc8);
						$("#idc9").html(d.idc9);
						$("#idc10").html(d.idc10);
						$("#pdc1").html(d.pdc1);
						$("#pdc2").html(d.pdc2);
						$("#pdc3").html(d.pdc3);
						$("#pdc4").html(d.pdc4);
						$("#pdc5").html(d.pdc5);
						$("#pdc6").html(d.pdc6);
						$("#pdc7").html(d.pdc7);
						$("#pdc8").html(d.pdc8);
						$("#pdc9").html(d.pdc9);
						$("#pdc10").html(d.pdc10);
						$("#pdcSum").html(d.pdcSum);
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
						$("#Pb").html(d.Pb);
						$("#pc").html(d.pc);
						$("#psum").html(d.psum);
						$("#qsum").html(d.qsum);
						$("#ssum").html(d.ssum);
						$("#pf").html(d.pf);
						$("#eff").html(d.eff);
						$("#freq").html(d.freq);
						$("#disRate").html(d.disRate);
						$("#powerDay").html(d.powerDay);
						$("#powerAll").html(d.powerAll);
						$("#goodRunTime").html(d.goodRunTime);
						
						$("#downTime").html(d.downTime);
						$("#faultTime").html(d.faultTime);
						$("#failureTime").html(d.failureTime);
						$("#comIntTime").html(d.comIntTime);
						$("#eleRunTime").html(d.eleRunTime);
						$("#timeAll").html(d.timeAll);
						$("#temp").html(d.temp);
						$("#temp1").html(d.temp1);
						$("#temp2").html(d.temp2);
						$("#temp3").html(d.temp3);
						$("#temp4").html(d.temp4);
						$("#temp5").html(d.temp5);
						$("#temp6").html(d.temp6);
						$("#imp1").html(d.imp1);
						$("#imp2").html(d.imp2);
						$("#plimit").html(d.plimit);
						$("#qlimit").html(d.qlimit);
						
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