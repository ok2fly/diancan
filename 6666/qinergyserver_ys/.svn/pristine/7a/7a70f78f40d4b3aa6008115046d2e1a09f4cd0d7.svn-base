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
							<th>电池状态</th>
							<td id="statBatts"></td>
							<th>告警码</th>
							<td id="faultCode"></td>
						</tr>
						<tr>
							<th>温度模块数量</th>
							<td id="tempNum"></td>
							<th>单体电池数量</th>
							<td id="ucellNum"></td>
						</tr>
						<tr>
							<th>最高电压位置</th>
							<td id="hvSN"></td>
							<th>最低电压位置</th>
							<td id="mvSN"></td>
						</tr>
						<tr>
							<th>最高温度位置</th>
							<td id="htSN"></td>
							<th>最低温度位置</th>
							<td id="mtSN"></td>
						</tr>
						<tr>
							<th>总电压(V)</th>
							<td id="udc"></td>
							<th>总电流(A)</th>
							<td id="idc"></td>
						</tr>
						<tr>
							<th>总功率(P)</th>
							<td id="pdc"></td>
							<th>SOC</th>
							<td id="soc"></td>
						</tr>
						<tr>
							<th>额定容量(AH)</th>
							<td id="capacity"></td>
							<th>累计充电电量(kWh)</th>
							<td id="chg"></td>
						</tr>
						<tr>
							<th>累计放电电量(kWh)</th>
							<td id="dischg"></td>
							<th>可充电电量(kWh)</th>
							<td id="rechg"></td>
						</tr>
						<tr>
							<th>可放电电量(kWh)</th>
							<td id="redischg"></td>
							<th>最高电压(V)</th>
							<td id="uHigh"></td>
						</tr>
						<tr>
							<th>最低电压(V)</th>
							<td id="uLow"></td>
							<th>最高温度(°C)</th>
							<td id="tempHigh"></td>
						</tr>
						<tr>
							<th>最低温度(°C)</th>
							<td id="tempLow"></td>
							<th>最大允许充电电流(A)</th>
							<td id="iChgMax"></td>
						</tr>
						<tr>
							<th>最大允许放电电流(A)</th>
							<td id="iDischgMax"></td>
							<th>最高允许工作温度(°C)</th>
							<td id="tempHighLimit"></td>
						</tr>
						<tr>
							<th>最低允许工作温度(°C)</th>
							<td id="tempLowLimit"></td>
							<th>最高允许充电单体电压(V)</th>
							<td id="uHighCell"></td>
						</tr>
						<tr>
							<th>最低允许充电单体电压(V)</th>
							<td id="ulowCell"></td>
							<th>数据入库时间</th>
							<td id="crtTim"></td>
						</tr>
						<tr>
							<th>温度1(°C)</th>
							<td id="tempce111"></td>
							<th>温度2(°C)</th>
							<td id="tempce112"></td>
						</tr>
						<tr>
							<th>温度3(°C)</th>
							<td id="tempce113"></td>
							<th>温度4(°C)</th>
							<td id="tempce114"></td>
						</tr>
						<tr>
							<th>温度5(°C)</th>
							<td id="tempce115"></td>
							<th>温度6(°C)</th>
							<td id="tempce116"></td>
						</tr>
						<tr>
							<th>温度7(°C)</th>
							<td id="tempce117"></td>
							<th>温度8(°C)</th>
							<td id="tempce118"></td>
						</tr>
						<tr>
							<th>温度9(°C)</th>
							<td id="tempce119"></td>
							<th>温度10(°C)</th>
							<td id="tempce120"></td>
						</tr>
						<tr>
							<th>温度11(°C)</th>
							<td id="tempce121"></td>
							<th>温度12(°C)</th>
							<td id="tempce122"></td>
						</tr>
						<tr>
							<th>温度13(°C)</th>
							<td id="tempce123"></td>
							<th>温度14(°C)</th>
							<td id="tempce124"></td>
						</tr>
						<tr>
							<th>温度15(°C)</th>
							<td id="tempce125"></td>
							<th>温度16(°C)</th>
							<td id="tempce126"></td>
						</tr>
						<tr>
							<th>温度17(°C)</th>
							<td id="tempce127"></td>
							<th>温度18(°C)</th>
							<td id="tempce128"></td>
						</tr>
						<tr>
							<th>温度19(°C)</th>
							<td id="tempce129"></td>
							<th>温度20(°C)</th>
							<td id="tempce130"></td>
						</tr>
						<tr>
							<th>温度21(°C)</th>
							<td id="tempce131"></td>
							<th>温度22(°C)</th>
							<td id="tempce132"></td>
						</tr>
						<tr>
							<th>温度23(°C)</th>
							<td id="tempce133"></td>
							<th>温度24(°C)</th>
							<td id="tempce134"></td>
						</tr>
						<tr>
							<th>温度25(°C)</th>
							<td id="tempce135"></td>
							<th>温度26(°C)</th>
							<td id="tempce136"></td>
						</tr>
						<tr>
							<th>温度27(°C)</th>
							<td id="tempce137"></td>
							<th>温度28(°C)</th>
							<td id="tempce138"></td>
						</tr>
						<tr>
							<th>温度29(°C)</th>
							<td id="tempce139"></td>
							<th>温度30(°C)</th>
							<td id="tempce140"></td>
						</tr>
						<tr>
							<th>温度31(°C)</th>
							<td id="tempce141"></td>
							<th>温度32(°C)</th>
							<td id="tempce142"></td>
						</tr>
						<tr>
							<th>温度33(°C)</th>
							<td id="tempce143"></td>
							<th>温度34(°C)</th>
							<td id="tempce144"></td>
						</tr>
						<tr>
							<th>温度35(°C)</th>
							<td id="tempce145"></td>
							<th>温度36(°C)</th>
							<td id="tempce146"></td>
						</tr>
						<tr>
							<th>温度37(°C)</th>
							<td id="tempce147"></td>
							<th>温度38(°C)</th>
							<td id="tempce148"></td>
						</tr>
						<tr>
							<th>温度39(°C)</th>
							<td id="tempce149"></td>
							<th>温度40(°C)</th>
							<td id="tempce150"></td>
						</tr>
						<tr>
							<th>温度41(°C)</th>
							<td id="tempce151"></td>
							<th>温度42(°C)</th>
							<td id="tempce152"></td>
						</tr>
						<tr>
							<th>温度43(°C)</th>
							<td id="tempce153"></td>
							<th>温度44(°C)</th>
							<td id="tempce154"></td>
						</tr>
						<tr>
							<th>温度45(°C)</th>
							<td id="tempce155"></td>
							<th>温度46(°C)</th>
							<td id="tempce156"></td>
						</tr>
						<tr>
							<th>温度47(°C)</th>
							<td id="tempce157"></td>
							<th>温度48(°C)</th>
							<td id="tempce158"></td>
						</tr>
						<tr>
							<th>温度49(°C)</th>
							<td id="tempce159"></td>
							<th>温度50(°C)</th>
							<td id="tempce160"></td>
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
			url:url+"getBmsInfoByEquNumNew.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length>0){
						var d=data.data[0];
						var stat=d.stat==0?"通信中断":d.stat==1?"正常运行":d.stat==2?"正常停机":d.stat==3?"告警运行":d.stat==4?"故障停机":"--";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"--";
						var statBatts = d.statBatts == 0 ? "充电允许" : d.statBatts == 1 ? "放电允许":d.statBatts == 2 ? "继电器闭合":d.statBatts == 3 ? "充满电维护请求" :
							d.statBatts == 4 ? "放完电维护请求" :d.statBatts == 5 ? "熔断器断开" :d.statBatts == 6 ? "风机开启" :"--";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#statBatts").html(statBatts);
						$("#faultCode").html(d.faultCode);
						$("#tempNum").html(d.tempNum);
						$("#ucellNum").html(d.ucellNum);
						$("#hvSN").html(d.hvSN);
						$("#mvSN").html(d.mvSN);
						$("#htSN").html(d.htSN);
						$("#mtSN").html(d.mtSN);
						$("#udc").html(d.udc);
						$("#idc").html(d.idc);
						$("#pdc").html(d.pdc);
						$("#soc").html(d.soc);
						$("#capacity").html(d.capacity);
						$("#chg").html(d.chg);
						$("#dischg").html(d.dischg);
						$("#rechg").html(d.rechg);
						$("#redischg").html(d.redischg);
						$("#uHigh").html(d.uHigh);
						$("#uLow").html(d.uLow);
						$("#tempHigh").html(d.tempHigh);
						$("#tempLow").html(d.tempLow);
						$("#iChgMax").html(d.iChgMax);
						$("#iDischgMax").html(d.iDischgMax);
						$("#tempHighLimit").html(d.tempHighLimit);
						$("#tempLowLimit").html(d.tempLowLimit);
						$("#uHighCell").html(d.uHighCell);
						$("#ulowCell").html(d.ulowCell);
						$("#crtTim").html(getLocalDateAndTime(d.crtTim,1));
						
						$("#tempce111").html(d.tempce111);
						$("#tempce112").html(d.tempce112);
						$("#tempce113").html(d.tempce113);
						$("#tempce114").html(d.tempce114);
						$("#tempce115").html(d.tempce115);
						$("#tempce116").html(d.tempce116);
						$("#tempce117").html(d.tempce117);
						$("#tempce118").html(d.tempce118);
						$("#tempce119").html(d.tempce119);
						$("#tempce120").html(d.tempce120);
						$("#tempce121").html(d.tempce121);
						$("#tempce122").html(d.tempce122);
						$("#tempce123").html(d.tempce123);
						$("#tempce124").html(d.tempce124);
						$("#tempce125").html(d.tempce125);
						$("#tempce126").html(d.tempce126);
						$("#tempce127").html(d.tempce127);
						$("#tempce128").html(d.tempce128);
						$("#tempce129").html(d.tempce129);
						$("#tempce130").html(d.tempce130);
						$("#tempce131").html(d.tempce131);
						$("#tempce132").html(d.tempce132);
						$("#tempce133").html(d.tempce133);
						$("#tempce134").html(d.tempce134);
						$("#tempce135").html(d.tempce135);
						$("#tempce136").html(d.tempce136);
						$("#tempce137").html(d.tempce137);
						$("#tempce138").html(d.tempce138);
						$("#tempce139").html(d.tempce139);
						$("#tempce140").html(d.tempce140);
						$("#tempce141").html(d.tempce141);
						$("#tempce142").html(d.tempce142);
						$("#tempce143").html(d.tempce143);
						$("#tempce144").html(d.tempce144);
						$("#tempce145").html(d.tempce145);
						$("#tempce146").html(d.tempce146);
						$("#tempce147").html(d.tempce147);
						$("#tempce148").html(d.tempce148);
						$("#tempce149").html(d.tempce149);
						$("#tempce150").html(d.tempce150);
						$("#tempce151").html(d.tempce151);
						$("#tempce152").html(d.tempce152);
						$("#tempce153").html(d.tempce153);
						$("#tempce154").html(d.tempce154);
						$("#tempce155").html(d.tempce155);
						$("#tempce156").html(d.tempce156);
						$("#tempce157").html(d.tempce157);
						$("#tempce158").html(d.tempce158);
						$("#tempce159").html(d.tempce159);
						$("#tempce160").html(d.tempce160);

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