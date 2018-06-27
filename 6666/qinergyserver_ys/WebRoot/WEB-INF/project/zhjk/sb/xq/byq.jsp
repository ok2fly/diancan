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
						<tr class="rzs1">
							<th>温度(°c)</th>
							<td id="temp1"></td>
							<th>电压(V)</th>
							<td id="uab1"></td>
						</tr>
						<tr class="rzs1">
							<th>电流(A)</th>
							<td id="ia1"></td>
							<th>功率因数</th>
							<td id="pf1"></td>
						</tr>
						<tr class="rzs1">
							<th>频率(Hz)</th>
							<td id="freq1"></td>
						</tr>
						<tr class="rzs2">
							<th>温度(°c)</th>
							<td id="temp2"></td>
							<th>电压(V)</th>
							<td id="uab2"></td>
						</tr>
						<tr class="rzs2">
							<th>电流(A)</th>
							<td id="ia2"></td>
							<th>功率因数</th>
							<td id="pf2"></td>
						</tr>
						<tr class="rzs2">
							<th>频率(Hz)</th>
							<td id="freq2"></td>
						</tr>
						<tr class="rzs3">
							<th>温度(°c)</th>
							<td id="temp3"></td>
							<th>电压(V)</th>
							<td id="uab3"></td>
						</tr>
						<tr class="rzs3">
							<th>电流(A)</th>
							<td id="ia3"></td>
							<th>功率因数</th>
							<td id="pf3"></td>
						</tr>
						<tr class="rzs3">
							<th>频率(Hz)</th>
							<td id="freq3"></td>
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
		var id=$("#id").val();
		var equNum=$("#equNum").val();
		getTransformer(equNum);
		getEqu(equNum);
		//getRelFauLst();
	})
	
function getEqu(equNum){

$.ajax({
	url:url+"getEquInfByEquNum.htm",
	type:"post",
	data:"equ_num="+equNum,
	//data:"equ_num="+1,
	dataType:"json",
	success:function(data){
		if(data.resultcode=="USR000"){
				var a=data.data[0];
				$("#rtd_pow").html(getFixedNum(a.rtd_pow)+"kW");
				$("#app_mod").html(getIsNull(a.app_mod));
				$("#man_nam").html(getIsNull(a.man_nam));
				$("#equ_num").html(getIsNull(a.equ_cod));
				$("#pur_tim").html(getIsNull(a.pro_tim));
			
		}else{
               layer.alert(data.desc);
		}
	}
})
}

	function getTransformer(equNum){
	$.ajax({
		url:url+"getTransfRealInf.htm",
		data:"equ_num="+equNum,
		dataType:"json",
		type:"post",
		success:function(data){
			if (data.resultcode=="USR000"){
				if(data.data.transfReal){
					var t=data.data.transfReal;
					 if(t){
						 
	    				 /*实时*/
	    				 var stat = t.stat == 0 ?"通讯中断": t.stat == 1 ? "正常运行" :t.stat == 2 ? "设备告警" : "--";
						 var healthStat = t.healthStat == 1 ? "优秀" :t.healthStat == 2 ? "良好" : t.healthStat == 3 ? "中等":t.healthStat == 4 ? "差" : "其它";
						 $("#stat").html(stat);
	    				 $("#healthStat").html(healthStat);
	    				 /*告警*/
	    				 $("#faultCode").html(getIsNull(t.faultCode));
	    				 /*绕组数量*/
	    				 //$("#branchNum").html(t.branchNum);
	    				 
	    				 
	    				 if(t && t.branchNum > 2){
	    					 /*电压 电流 功率 频率*/
		    				 $("#temp1").html(getFixedNum(t.temp1));
		    				 $("#uab1").html(getFixedNum(t.uab1));
		    				 $("#ia1").html(getFixedNum(t.ia1));
		    				 $("#pf1").html(getFixedNum2(t.pf1));
		    				 $("#freq1").html(getFixedNum(t.freq1));
		    				 $("#uab2").html(getFixedNum(t.uab2));
		    				 $("#temp2").html(getFixedNum(t.temp2)); 
		    				 $("#ia2").html(getFixedNum(t.ia2));
		    				 $("#pf2").html(getFixedNum2(t.pf2));
		    				 $("#freq2").html(getFixedNum(t.freq2));
		    				 $("#temp3").html(getFixedNum(t.temp3)); 
		    				 $("#uab3").html(getFixedNum(t.uab3));
		    				 $("#ia3").html(getFixedNum(t.ia3));
		    				 $("#pf3").html(getFixedNum2(t.pf3));
		    				 $("#freq3").html(getFixedNum(t.freq3));
		    				 $(".rzs1").show();
		    				 $(".rzs2").show();
		    				 $(".rzs3").show();
	    				 }else if(t && t.branchNum == 1 ){
	    					 $("#temp1").html(getFixedNum(t.temp1));
		    				 $("#uab1").html(getFixedNum(t.uab1));
		    				 $("#ia1").html(getFixedNum(t.ia1));
		    				 $("#pf1").html(getFixedNum2(t.pf1));
		    				 $("#freq1").html(getFixedNum(t.freq1));
		    				 $(".rzs1").show();
		    				 $(".rzs2").hide();
		    				 $(".rzs3").hide();
	    				 }else if(t && t.branchNum == 2 ){
	    					 $("#temp1").html(getFixedNum(t.temp1));
		    				 $("#uab1").html(getFixedNum(t.uab1));
		    				 $("#ia1").html(getFixedNum(t.ia1));
		    				 $("#pf1").html(getFixedNum2(t.pf1));
		    				 $("#freq1").html(getFixedNum(t.freq1));
		    				 $("#temp2").html(getFixedNum(t.temp2)); 
		    				 $("#uab2").html(getFixedNum(t.uab2));
		    				 $("#ia2").html(getFixedNum(t.ia2));
		    				 $("#pf2").html(getFixedNum2(t.pf2));
		    				 $("#freq2").html(getFixedNum(t.freq2));
		    				 $(".rzs1").show();
		    				 $(".rzs2").show();
		    				 $(".rzs3").hide();
	    				 }
	    				 
					 }
				}
				if(t && t.branchNum > 0){
					setChart(data.data.transfRealList,t.branchNum);
					setChart1(data.data.transfRealList,t.branchNum);
					setChart3(data.data.transfRealList,t.branchNum);
				}else{
					setChartnoData(data.data.transfRealList);
					setChartnoData1(data.data.transfRealList);
					setChartnoData3(data.data.transfRealList);
				}				}else{
               layer.alert(data.desc);
			}
		} 
	})
}
</script>		

</body>
</html>