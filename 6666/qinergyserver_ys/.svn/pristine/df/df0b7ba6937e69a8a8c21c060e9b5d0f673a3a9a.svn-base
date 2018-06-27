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
							<th>充电桩编号</th>
							<td id="pileNo"></td>
							<th>设备状态</th>
							<td id="stat"></td>
						</tr>
						<tr>
							<th>枪链接状态</th>
							<td id="gunStat"></td>
							<th>告警码</th>
							<td id="faultCode"></td>
						</tr>
						<tr>
							<th>累计充电时间(h)</th>
							<td id="cumTime"></td>
							<th>累计充电电量(kWh)</th>
							<td id="cumPower"></td>
						</tr>
						<tr>
							<th>累计充电金额(元)</th>
							<td id="cumMoney"></td>
							<th>有效充电小时数(h)</th>
							<td id="validTime"></td>
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
							<th>创建时间</th>
							<td id="crtTim"></td>
							<th>累计充电次数(次)</th>
							<td id="chpCnt"></td>
						</tr>
					</table>
				</div>
		</div>
		<div class="pt18 fl" style="width: 100%">
				 <div class="a4" style="text-align: center;font-weight:bold;color:#333">充电中实时数据</div>
				<div class="tabxq">
					 	<table cellpadding="0" cellspacing="0" border="0" width="100%" >
						<tr>
							<th>充电单号</th>
							<td id="orderNo2"></td>
							<th>充电桩编号</th>
							<td id="pileNo2"></td>
						</tr>
						<tr>
							<th>设备状态</th>
							<td id="stat2"></td>
							<th>告警码</th>
							<td id="faultCode2"></td>
						</tr>
						<tr>
							<th>当前SOC(%)</th>
							<td id="SOC2"></td>
							<th>当前电表读数(kWh)</th>
							<td id="currPower2"></td>
						</tr>
						<tr>
							<th>充电电压(V)</th>
							<td id="udc2"></td>
							<th>充电电流(A)</th>
							<td id="idc2"></td>
						</tr>
						<tr>
							<th>充电功率(kW)</th>
							<td id="pdc2"></td>
							<th>BMS需求电压(V)</th>
							<td id="udcBMS2"></td>
						</tr>
						<tr>
							<th>BMS需求电流(A)</th>
							<td id="idcBMS2"></td>
							<th>BMS充电模式</th>
							<td id="modeBMS2"></td>
						</tr>
						<tr>
							<th>充电时长(h)</th>
							<td id="time2"></td>
							<th>剩余充电时间(h)</th>
							<td id="remTime2"></td>
						</tr>
						<tr>
							<th>本次累计充电费(元)</th>
							<td id="money2"></td>
							<th>本次累计充电量(kWh)</th>
							<td id="power2"></td>
						</tr>
						<tr>
							<th>创建时间</th>
							<td id="crtTim2"></td>
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
			url:url+"getIscsDcchpStdAndRelByEquNumNew.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					
					if(data.data.stdLst.length>0){
						var d=data.data.stdLst[0];
					var stat=d.stat==0?"离线":d.stat==1?"空闲":d.stat==2?"充电中":d.stat==3?"告警":d.stat==4?"预约":"--";
					var gunStat=d.gunStat==0?"未连接":d.gunStat==1?"连接未充电":d.gunStat==2?"充电中":"--";
					var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差":"--" ; 
						$("#pileNo").html(d.pileNo);
						$("#stat").html(stat);
						$("#gunStat").html(gunStat);
						$("#faultCode").html(d.faultCode);
						$("#cumTime").html(d.cumTime);
						$("#cumPower").html(d.cumPower);
						$("#cumMoney").html(d.cumMoney);
						$("#validTime").html(d.validTime);
						$("#goodRunTime").html(d.goodRunTime);
						$("#downTime").html(d.downTime);
						$("#faultTime").html(d.faultTime);
						$("#failureTime").html(d.failureTime);
						$("#comIntTime").html(d.comIntTime);
						$("#runTime").html(d.runTime);
						$("#crtTim").html(getLocalDateAndTime(d.crtTim,1));
						$("#chpCnt").html(d.chpCnt);
					}
					 if(data.data.relLst.length>0){
						 var a=data.data.relLst[0];
							var stat2=a.stat==0?"离线":a.stat==1?"空闲":a.stat==2?"充电中":a.stat==3?"告警":a.stat==4?"预约":"";
							var healthStat2 = a.healthStat == 1 ? "优秀" : a.healthStat == 2 ? "良好":a.healthStat == 3 ? "中等":a.healthStat == 4 ? "差" :""; 
							
						$("#orderNo2").html(a.orderNo);
						$("#pileNo2").html(a.pileNo);
						$("#stat2").html(stat2);
						$("#faultCode2").html(a.faultCode);
						$("#SOC2").html(getFixedNum5(a.SOC));
						$("#currPower2").html(getFixedNum5(a.currPower));
						$("#udc2").html(getFixedNum5(a.udc));
						$("#idc2").html(getFixedNum5(a.idc));
						$("#pdc2").html(getFixedNum5(a.pdc));
						$("#udcBMS2").html(getFixedNum5(a.udcBMS));
						$("#idcBMS2").html(getFixedNum5(a.idcBMS));
						var bms = a.modeBMS == 1 ? '恒压' : a.modeBMS == 2 ?  '恒流' : '无';
						$("#modeBMS2").html(bms);
						 
						$("#time2").html(getFixedNum5(a.time/3600));
						$("#remTime2").html(getFixedNum5(a.remTime/3600));
						$("#money2").html(getFixedNum5(a.money));
						$("#power2").html(getFixedNum5(a.power));
						$("#crtTim2").html(getLocalDateAndTime(a.crtTim,1));
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