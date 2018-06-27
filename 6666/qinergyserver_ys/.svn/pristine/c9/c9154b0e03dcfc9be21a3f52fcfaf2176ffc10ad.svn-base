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
							<th>支路数量</th>
							<td id="branchNum"></td>
							<th>告警码</th>
							<td id="faultCode"></td>
						</tr>
						<tr>
							<th>直流电压(V)</th>
							<td id="udc"></td>
							<th>直流电流(A)</th>
							<td id="idc"></td>
						</tr>
						<tr>
							<th>直流功率(A)</th>
							<td id="pdc"></td>
							<th>机内温度(°C)</th>
							<td id="temp"></td>
						</tr>
						<tr>
							<th>离散率(%)</th>
							<td id="disRate"></td>
							<th>创建时间</th>
							<td id="crtTim"></td>
						</tr>
						<tr>
							<th>第1路电流(A)</th>
							<td id="Idc1"></td>
							<th>第2路电流(A)</th>
							<td id="Idc2"></td>
						</tr>
						<tr>
							<th>第3路电流(A)</th>
							<td id="Idc3"></td>
							<th>第4路电流(A)</th>
							<td id="Idc4"></td>
						</tr>
						<tr>
							<th>第5路电流(A)</th>
							<td id="Idc5"></td>
							<th>第6路电流(A)</th>
							<td id="Idc6"></td>
						</tr>
						<tr>
							<th>第7路电流(A)</th>
							<td id="Idc7"></td>
							<th>第8路电流(A)</th>
							<td id="Idc8"></td>
						</tr>
						<tr>
							<th>第9路电流(A)</th>
							<td id="Idc9"></td>
							<th>第10路电流(A)</th>
							<td id="Idc10"></td>
						</tr>
						<tr>
							<th>第11路电流(A)</th>
							<td id="Idc11"></td>
							<th>第12路电流(A)</th>
							<td id="Idc12"></td>
						</tr>
						<tr>
							<th>第13路电流(A)</th>
							<td id="Idc13"></td>
							<th>第14路电流(A)</th>
							<td id="Idc14"></td>
						</tr>
						<tr>
							<th>第15路电流(A)</th>
							<td id="Idc15"></td>
							<th>第16路电流(A)</th>
							<td id="Idc16"></td>
						</tr>
						<tr>
							<th>第17路电流(A)</th>
							<td id="Idc17"></td>
							<th>第18路电流(A)</th>
							<td id="Idc18"></td>
						</tr>
						<tr>
							<th>第19路电流(A)</th>
							<td id="Idc19"></td>
							<th>第20路电流(A)</th>
							<td id="Idc20"></td>
						</tr>
						<tr>
							<th>第21路电流(A)</th>
							<td id="Idc21"></td>
							<th>第22路电流(A)</th>
							<td id="Idc22"></td>
						</tr>
						<tr>
							<th>第23路电流(A)</th>
							<td id="Idc23"></td>
							<th>第24路电流(A)</th>
							<td id="Idc24"></td>
						</tr>
						<tr>
							<th>第25路电流(A)</th>
							<td id="Idc25"></td>
							<th>第26路电流(A)</th>
							<td id="Idc26"></td>
						</tr>
						<tr>
							<th>第27路电流(A)</th>
							<td id="Idc27"></td>
							<th>第28路电流(A)</th>
							<td id="Idc28"></td>
						</tr>
						<tr>
							<th>第29路电流(A)</th>
							<td id="Idc29"></td>
							<th>第30路电流(A)</th>
							<td id="Idc30"></td>
						</tr>
						<tr>
							<th>第31路电流(A)</th>
							<td id="Idc31"></td>
							<th>第32路电流(A)</th>
							<td id="Idc32"></td>
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
			url:url+"getIscsBoxInfByEquNumNew.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length>0){
						var d=data.data[0];
						var stat=d.stat == 0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "告警运行" :"--";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"--";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#branchNum").html(d.branchNum);
						$("#faultCode").html(d.faultCode);
						$("#udc").html(d.udc);
						$("#idc").html(d.idc);
						$("#pdc").html(d.pdc);
						$("#temp").html(d.temp);
						$("#disRate").html(d.disRate);
						$("#crtTim").html(getLocalDateAndTime(d.crtTim,1));
						
						$("#Idc1").html(d.Idc1);
						$("#Idc2").html(d.Idc2);
						$("#Idc3").html(d.Idc3);
						$("#Idc4").html(d.Idc4);
						$("#Idc5").html(d.Idc5);
						$("#Idc6").html(d.Idc6);
						$("#Idc7").html(d.Idc7);
						$("#Idc8").html(d.Idc8);
						$("#Idc9").html(d.Idc9);
						$("#Idc10").html(d.Idc10);
						$("#Idc11").html(d.Idc11);
						$("#Idc12").html(d.Idc12);
						$("#Idc13").html(d.Idc13);
						$("#Idc14").html(d.Idc14);
						$("#Idc15").html(d.Idc15);
						$("#Idc16").html(d.Idc16);
						$("#Idc17").html(d.Idc17);
						$("#Idc18").html(d.Idc18);
						$("#Idc19").html(d.Idc19);
						$("#Idc20").html(d.Idc20);
						$("#Idc21").html(d.Idc21);
						$("#Idc22").html(d.Idc22);
						$("#Idc23").html(d.Idc23);
						$("#Idc24").html(d.Idc24);
						$("#Idc25").html(d.Idc25);
						$("#Idc26").html(d.Idc26);
						$("#Idc27").html(d.Idc27);
						$("#Idc28").html(d.Idc28);
						$("#Idc29").html(d.Idc29);
						$("#Idc30").html(d.Idc30);
						$("#Idc31").html(d.Idc31);
						$("#Idc32").html(d.Idc32);


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