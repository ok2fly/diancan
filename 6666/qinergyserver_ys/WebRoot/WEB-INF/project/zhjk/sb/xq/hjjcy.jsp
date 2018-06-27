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
							<th>水平面瞬时辐射(W/㎡)</th>
							<td id="hgv"></td>
							<th>水平面总辐射量(W/㎡)</th>
							<td id="hg"></td>
						</tr>
						<tr>
							<th>倾斜面瞬时辐射(W/㎡)</th>
							<td id="htv"></td>
							<th>倾斜面总辐射量(W/㎡)</th>
							<td id="ht"></td>
						</tr>
						<tr>
							<th>环境温度(°C)</th>
							<td id="temp"></td>
							<th>环境湿度(%)</th>
							<td id="humi"></td>
						</tr>
						<tr>
							<th>组件温度(°C)</th>
							<td id="tempPV"></td>
							<th>风速(m/s)</th>
							<td id="windSpeed"></td>
						</tr>
						<tr>
							<th>风向</th>
							<td id="windDir"></td>
							<th>大气压力(hPa)</th>
							<td id="air"></td>
						</tr>
						<tr>
							<th>平均风速(m/s)</th>
							<td id="vmean"></td>
							<th>平均气温(°C)</th>
							<td id="tammean"></td>
						</tr>
						<tr>
							<th>平均湿度(%)</th>
							<td id="rh"></td>
							<th>累计日照时数(h)</th>
							<td id="accHs"></td>
						</tr>
						<tr>
							<th>日照时数(h)</th>
							<td id="hs"></td>
							<th>峰值日照时数(h)</th>
							<td id="pekHs"></td>
						</tr>
						<tr>
							<th>0-100W/m2辐射量(W/㎡)</th>
							<td id="rad0-100W-2m"></td>
							<th>100-200W/m2辐射量(W/㎡)</th>
							<td id="rad100-200W-2m"></td>
						</tr>
						<tr>
							<th>200-300W/m2辐射量(W/㎡)</th>
							<td id="rad200-300W-2m"></td>
							<th>300-400W/m2辐射量(W/㎡)</th>
							<td id="rad300-400W-2m"></td>
						</tr>
						<tr>
							<th>400-500W/m2辐射量(W/㎡)</th>
							<td id="rad400-500W-2m"></td>
							<th>500-600W/m2辐射量(W/㎡)</th>
							<td id="rad500-600W-2m"></td>
						</tr>
						<tr>
							<th>600-700W/m2辐射量(W/㎡)</th>
							<td id="rad600-700W-2m"></td>
							<th>700-800W/m2辐射量(W/㎡)</th>
							<td id="rad700-800W-2m"></td>
						</tr>
						<tr>
							<th>800-900W/m2辐射量(W/㎡)</th>
							<td id="rad800-900W-2m"></td>
							<th>900-1000W/m2辐射量(W/㎡)</th>
							<td id="rad900-1000W-2m"></td>
						</tr>
						<tr>
							<th>大于1000W/m2辐射量(W/㎡)</th>
							<td id="rad1000W-2mThan"></td>
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
		var equ_num = sessionStorage.getItem("environmentEquNum");
		 
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getEnvInfByEquNumNew.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length>0){
						var d=data.data[0];
						var stat=d.stat==0?"通讯中断":d.stat==1?"正常运行":"";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#hgv").html(d.hgv);
						$("#hg").html(d.hg);
						$("#htv").html(d.htv);
						$("#ht").html(d.ht);
						$("#temp").html(d.temp);
						$("#humi").html(d.humi);
						$("#tempPV").html(d.tempPV);
						$("#windSpeed").html(d.windSpeed);
						$("#windDir").html(d.windDir);
						$("#air").html(d.air);
						$("#vmean").html(d.vmean);
						$("#tammean").html(d.tammean);
						$("#rh").html(d.rh);
						$("#accHs").html(d.accHs);
						$("#hs").html(d.hs);
						$("#pekHs").html(d.pekHs);
						$("#rad0-100W-2m").html(d['rad0-100W-2m']);
						$("#rad100-200W-2m").html(d['rad100-200W-2m']);
						$("#rad200-300W-2m").html(d['rad200-300W-2m']);
						$("#rad300-400W-2m").html(d['rad300-400W-2m']);
						$("#rad400-500W-2m").html(d['rad400-500W-2m']);
						$("#rad500-600W-2m").html(d['rad500-600W-2m']);
						$("#rad600-700W-2m").html(d['rad600-700W-2m']);
						$("#rad700-800W-2m").html(d['rad700-800W-2m']);
						$("#rad800-900W-2m").html(d['rad800-900W-2m']);
						$("#rad900-1000W-2m").html(d['rad900-1000W-2m']);
						$("#rad1000W-2mThan").html(d['rad1000W-2mThan']);
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