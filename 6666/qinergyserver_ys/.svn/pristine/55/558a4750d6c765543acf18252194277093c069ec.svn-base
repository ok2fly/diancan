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
							<th>A相电压(V)</th>
							<td id="ua"></td>
							<th>B相电压(V)</th>
							<td id="ub"></td>
						</tr>
						<tr>
							<th>C相电压(V)</th>
							<td id="uc"></td>
							<th>A相电流(A)</th>
							<td id="ia"></td>
						</tr>
						<tr>
							<th>B相电流(A)</th>
							<td id="ib"></td>
							<th>C相电流(A)</th>
							<td id="ic"></td>
						</tr>
						<tr>
							<th>有功功率(P)</th>
							<td id="psum"></td>
							<th>无功功率(P)</th>
							<td id="qsum"></td>
						</tr>
						<tr>
							<th>视在功率(P)</th>
							<td id="ssum"></td>
							<th>频率(Hz)</th>
							<td id="freq"></td>
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
			url:url+"getLnepttInfByEquNum.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length>0){
						var d=data.data[0];
						var stat= d.stat == 0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "故障保护" :"--";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"--";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#faultCode").html(d.faultCode);
						$("#uab").html(d.uab);
						$("#ubc").html(d.ubc);
						$("#uca").html(d.uca);
						$("#ua").html(d.ua);
						$("#ub").html(d.ub);
						$("#uc").html(d.uc);
						$("#ia").html(d.ia);
						$("#ib").html(d.ib);
						$("#ic").html(d.ic);
						$("#psum").html(d.psum);
						$("#qsum").html(d.qsum);
						$("#ssum").html(d.ssum);
						$("#freq").html(d.freq);
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