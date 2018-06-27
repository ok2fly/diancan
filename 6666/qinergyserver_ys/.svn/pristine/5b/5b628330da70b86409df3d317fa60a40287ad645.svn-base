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
							<th>电压变比</th>
							<td id="pt"></td>
							<th>电流变比</th>
							<td id="ct"></td>
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
							<th>A 相电压(V)</th>
							<td id="ua"></td>
						</tr>
						<tr>
							<th>B 相电压(V)</th>
							<td id="ub"></td>
							<th>C 相电压(V)</th>
							<td id="uc"></td>
						</tr>
						<tr>
							<th>A 相电流(A)</th>
							<td id="ia"></td>
							<th>B 相电流(A)</th>
							<td id="ib"></td>
						</tr>
						<tr>
							<th>C 相电流(A)</th>
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
							<th>无功功率(p)</th>
							<td id="qsum"></td>
						</tr>
						<tr>
							<th>视在功率(p)</th>
							<td id="ssum"></td>
							<th>正向有功电度表值</th>
							<td id="phiValue"></td>
						</tr>
						<tr>
							<th>反向有功电度表值</th>
							<td id="pheValue"></td>
							<th>正向无功电度表值</th>
							<td id="qhiValue"></td>
						</tr>
						<tr>
							<th>反向无功电度表值</th>
							<td id="qheValue"></td>
							<th>正向有功电度(kWh)</th>
							<td id="phi"></td>
						</tr>
						<tr>
							<th>反向有功电度(kWh)</th>
							<td id="phe"></td>
							<th>正向无功电度(kVarh)</th>
							<td id="qhi"></td>
						</tr>
						<tr>
							<th>反向无功电度(kVarh)</th>
							<td id="qhe"></td>
							<th>峰正向有功电度(kWh)</th>
							<td id="phiTop"></td>
						</tr>
						<tr>
							<th>峰反向有功电度(kWh)</th>
							<td id="pheTop"></td>
							<th>峰正向无功电度(kVarh)</th>
							<td id="qhiTop"></td>
						</tr>
						<tr>
							<th>峰反向无功电度(kVarh)</th>
							<td id="qheTop"></td>
							<th>谷正向有功电度(kWh)</th>
							<td id="phiVal"></td>
						</tr>
						<tr>
							<th>谷反向有功电度(kWh)</th>
							<td id="pheVal"></td>
							<th>谷正向无功电度(kVarh)</th>
							<td id="qhiVal"></td>
						</tr>
						<tr>
							<th>谷反向无功电度(kVarh)</th>
							<td id="qheVal"></td>
							<th>平正向有功电度(kWh)</th>
							<td id="phiFlat"></td>
						</tr>
						<tr>
							<th>平反向有功电度(kWh)</th>
							<td id="pheFlat"></td>
							<th>平正向无功电度(kVarh)</th>
							<td id="qhiFlat"></td>
						</tr>
						<tr>
							<th>平反向无功电度(kVarh)</th>
							<td id="qheFlat"></td>
							<th>尖正向有功电度(kWh)</th>
							<td id="phiPeak"></td>
						</tr>
						<tr>
							<th>尖反向有功电度(kWh)</th>
							<td id="phePeak"></td>
							<th>尖正向无功电度(kVarh)</th>
							<td id="qhiPeak"></td>
						</tr>
						<tr>
							<th>尖反向无功电度(kVarh)</th>
							<td id="qhePeak"></td>
							<th>频率(Hz)</th>
							<td id="freq"></td>
						</tr>
						<tr>
							<th>功率因数</th>
							<td id="pf"></td>
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
			url:url+"getMeterOtherInf.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data){
						var d=data.data;
						var stat=d.stat==0?"通讯中断":d.stat==1?"正常运行": "--";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"--";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#pt").html(d.pt);
						$("#ct").html(d.ct);
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
						$("#qsum").html(d.qsum);
						$("#ssum").html(d.ssum);
						$("#phiValue").html(d.phiValue);
						$("#pheValue").html(d.pheValue);
						$("#qhiValue").html(d.qhiValue);
						$("#qheValue").html(d.qheValue);
						$("#phi").html(d.phi);
						$("#phe").html(d.phe);
						$("#qhi").html(d.qhi);
						$("#qhe").html(d.qhe);
						$("#phiTop").html(d.phiTop);
						$("#pheTop").html(d.pheTop);
						$("#qhiTop").html(d.qhiTop);
						$("#qheTop").html(d.qheTop);
						$("#phiVal").html(d.phiVal);
						$("#pheVal").html(d.pheVal);
						$("#qhiVal").html(d.qhiVal);
						$("#qheVal").html(d.qheVal);
						$("#phiFlat").html(d.phiFlat);
						$("#pheFlat").html(d.pheFlat);
						$("#qhiFlat").html(d.qhiFlat);
						$("#qheFlat").html(d.qheFlat);
						$("#phiPeak").html(d.phiPeak);
						$("#phePeak").html(d.phePeak);
						$("#qhiPeak").html(d.qhiPeak);
						$("#qhePeak").html(d.qhePeak);
						$("#freq").html(d.freq);
						$("#pf").html(d.pf);
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