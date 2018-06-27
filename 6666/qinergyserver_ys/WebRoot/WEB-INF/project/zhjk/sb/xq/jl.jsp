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
							<th>A 相电压1(V)</th>
							<td id="ua1"></td>
							<th>B 相电压1(V)</th>
							<td id="ub1"></td>
						</tr>
						<tr>
							<th>C 相电压1(V)</th>
							<td id="uc1"></td>
							<th>A 相电压2(V)</th>
							<td id="ua2"></td>
						</tr>
						<tr>
							<th>B 相电压2(V)</th>
							<td id="ub2"></td>
							<th>C 相电压2(V)</th>
							<td id="uc2"></td>
						</tr>
						<tr>
							<th>频率1(Hz)</th>
							<td id="freq1"></td>
							<th>频率2(Hz)</th>
							<td id="freq2"></td>
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
			url:url+"getDctdevInfByEquNumNew.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length>0){
						var d=data.data[0];
						var stat=d.stat == 0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "设备告警" : d.stat == 3 ? "解列保护" :"--";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"--";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#ua1").html(d.ua1);
						$("#ub1").html(d.ub1);
						$("#uc1").html(d.uc1);
						$("#ua2").html(d.ua2);
						$("#ub2").html(d.ub2);
						$("#uc2").html(d.uc2);
						$("#freq1").html(d.freq1);
						$("#freq2").html(d.freq2);
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