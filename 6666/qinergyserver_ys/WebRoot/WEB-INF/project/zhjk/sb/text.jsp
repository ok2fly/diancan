<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智慧能源运维管家</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/text.css?pubVersion=201802070001"/>
</head>
<body  class="bg-blue">
	<input type="hidden" id="ro_id" value="${user.rol_id}" >
	<input type="hidden" id="userId" value="${user.id}" >
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<div class="w100p pt10" style="margin-top:20px">
		<div class="lf w38p bor1" style="margin-left: 1%; padding: 10px 0.5%;">
			<div class="top bg_filter boxsha"><p>光伏概况</p></div>
			<div class="w32p h70 bor2 fl" style="margin: 15px 0.4% ;position: relative;">
				<div class="bor-point-left2"></div>
				<div class="bor-point-right2"></div>
				<div class="top1 fl"><p>累计发电量</p></div>
				<div class="fl" style="width: 100%;text-align: center"><p style="font-size:20px;" id="ljfdl">0<span style="font-size:16px;">MWh</span></p></div>
			</div>
			<div class="w32p h70 bor2 fl" style="margin: 15px 0.4% ;position: relative;">
				<div class="bor-point-left2"></div>
				<div class="bor-point-right2"></div>
				<div class="top1"><p>年发电量</p></div>
				<div class="fl" style="width: 100%;text-align: center"><p style="font-size:20px;" id="nfdl">0<span style="font-size:16px;">MWh</span></p></div>
			</div>
			<div class="w32p h70 bor2 fl" style="margin: 15px 0.4% ;position: relative;"> 
				<div class="bor-point-left2"></div>
				<div class="bor-point-right2"></div>
				<div class="top1"><p>月发电量</p></div>
				<div class="fl" style="width: 100%;text-align: center"><p style="font-size:20px;" id="yfdl">0<span style="font-size:16px;">MWh</span></p></div>
			</div>
			<div class="h190 w98p fl bor2"  style="margin:10px 0.5%;position: relative;" >
				<div class="bor-point-left"></div>
				<div class="bor-point-right"></div>
				<div class="top2">当前功率曲线</div>
				<div class="fl h150 w100p" id="glqx"></div>
			</div>
			
			<div class="h190 w98p fl bor2"  style="margin:10px 0.5%;position: relative;" >
				<div class="bor-point-left"></div>
				<div class="bor-point-right"></div>
				<div class="top2">年计划完成率</div>
				<div class="fl h150 w100p" id="njhwcl"></div>
			</div>
			<div class="h160 w98p fl bor2"  style="margin:10px 0.5%;position: relative;" >
				<div class="bor-point-left3"></div>
				<div class="bor-point-right3"></div>
				<div class="top3">电站效率</div>
				<div class="fl h130 w100p" id="dzxl">
					<div class="w32p h100 fl " style="margin: 15px 0.5% ;">
						<div class="fl h100 w50p" >
							<div class="column2" id="zxxlbar" style="margin-top: 60px;">
								<div class="val" ></div>
							</div>
						</div>
						<div  class="fl  w32p txt" >
							<p>最小效率</p>
							<p id="zxxl">0%</p>
						</div>
					
					</div>
					<div class="w32p h100 fl " style="margin: 15px 0.5% ;">
						<div class="fl h100 w50p" >
							<div class="column2" id="zdxlbar" style="margin-top: 60px;">
								<div class="val"></div>
							</div>
						</div>
						<div  class="fl  w32p txt" >
							<p>最大效率</p>
							<p id="zdxl">0%</p>
						</div>
					
					</div>
					<div class="w32p h100 fl " style="margin: 15px 0.5% ;">
						<div class="fl h100 w50p" >
							<div class="column2" id="pjzbar" style="margin-top: 60px; ">
								<div class="val"></div>
							</div>
						</div>
						<div  class="fl  w32p txt" >	
							<p>平均值</p>
							<p id="pjz">0%</p>
						</div>
					
					</div>
				</div>
				
			</div>
			<div class="h200 w98p fl bor2"  style="margin:10px 0.5%;position: relative;">
				<div class="bor-point-left3"></div>
				<div class="bor-point-right3"></div>
				<div class="top3">设备状态数</div>
				<div class="w32p h160 fl" style="margin:10px 0.5%;">
					<div class="circle yellow">
						<div style="margin-top: 24px;text-align: center;">
							<h1 id="gfgjsl">0</h1>
							<h4>告警</h4>
						</div>
					</div>
				</div> 
				<div class="w32p h160 fl" style="margin:10px 0.5%;">
					<div class="circle red">
						<div style="margin-top: 24px;text-align: center;">
							<h1 id="gfgzsl">0</h1>
							<h4>故障</h4>
						</div>
					</div>
				</div> 
				<div class="w32p h160 fl" style="margin:10px 0.5%;">
					<div class="circle brgreen">
						<div style="margin-top: 24px;text-align: center;">
							<h1  id="gfzcsl">0</h1>
							<h4>正常</h4>
						</div>
					</div>
				</div> 
			</div>
		</div>
		<div class="lf w57p bor1 h290" style="margin-left:1%; padding: 10px 0.5%;">
				<div class="top bg_filter boxsha"><p>储能概况</p></div>
				<div class="w48p bor2 h200 fl" style="margin-top: 20px;margin-left: 1%;position: relative;" >
					<div class="bor-point-left"></div>
					<div class="bor-point-right"></div>
					<div class="top2" id="cfd"><p>充放电概况</p></div>
					<div class="fl w100p h150" id="cfdgk"></div>
				</div>
				<div class="w48p bor2 h200 fl" style="margin-top: 20px;margin-left: 1.5%;position: relative;">
					<div class="bor-point-left"></div>
					<div class="bor-point-right"></div>
					<div class="top2">设备状态数</div>
					<div class="w32p h160 fl" style="margin:10px 0.5%;">
						<div class="circle yellow">
							<div style="margin-top: 24px;text-align: center;">
								<h1 id="cngjsl">0</h1>
								<h4>告警</h4>
							</div>
						</div>
					</div> 
					<div class="w32p h160 fl" style="margin:10px 0.5%;">
						<div class="circle red">
							<div style="margin-top: 24px;text-align: center;">
								<h1 id="cngzsl">0</h1>
								<h4>故障</h4>
							</div>
						</div>
					</div> 
					<div class="w32p h160 fl" style="margin:10px 0.5%;">
						<div class="circle brgreen">
							<div style="margin-top: 24px;text-align: center;">
								<h1 id="cnzcsl">0</h1>
								<h4>正常</h4>
							</div>
						</div>
					</div> 
			</div>
		</div>
		
		<div class="lf w57p bor1" style="margin: 10px 0 0 1% ; padding: 10px 0.5%;position: relative;">
			<div class="top bg_filter  boxsha"><p>充电桩概况</p></div>
			<div class="w32p h130 fl " style="margin: 15px 0.5% ;">
				<div class="fl h100 w100p" >
					<div style="text-align: center;font-size:18px;"><p id="ljcdxss">0h</p></div>
					<div class="column"  id="ljcdxssCol">
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
						<div class="val green"></div>
					</div>
				</div>
				<div style="text-align: center;"><p>累计充电小时数</p></div>
				
			</div>
			<div class="w32p h130 fl " style="margin: 15px 0.5% ;">
				<div class="fl h100 w100p" >
					<div style="text-align: center;font-size:18px;"><p id="ljcdl">0kWh</p></div>
					<div class="column" style="margin-top: 30px;"   id="ljcdlCol">
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
						<div class="val yel"></div>
					</div>
				</div>
				<div style="text-align: center;"><p>累计充电量</p></div>
			</div>
			<div class="w32p h130 fl " style="margin: 15px 0.5% ;">
				<div class="fl h100 w100p" >
					<div style="text-align: center;font-size:18px;"><p id="ljcdcs">0次</p></div>
					<div class="column" style="margin-top: 40px;" id="ljcdcsCol">
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
						<div class="val red1"></div>
					</div>
				</div>
				<div style="text-align: center;"><p>累计充电次数</p></div>
			</div>
			
			<div class="w23p h200 fl bor2" style="margin: 10px 1% ;" >
				<div class="top bg_filter"><p id="city1Name">无</p></div>
				<div class="fl h160 w100p" id="city1">
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city1y1">0</p></div>
							<div class="column"   style="margin-top: 78px;">
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电桩数量</p></div>
					</div>
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city1y2">0h</p></div>
							<div class="column"   style="margin-top: 78px;">
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电有效小时数</p></div>
					</div>
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city1y3">0</p></div>
							<div class="column"   style="margin-top: 78px;">
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电次数</p></div>
					</div>
				
				</div>
			</div>
			<div class="w23p h200 fl bor2" style="margin: 10px 0.9% ;">
				<div class="top bg_filter"><p id="city2Name">无</p></div>
				<div class="fl h160 w100p" id="city2">
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city2y1">0</p></div>
							<div class="column"  style="margin-top: 78px;">
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电桩数量</p></div>
					</div>
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city2y2">0h</p></div>
							<div class="column"   style="margin-top: 78px;">
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电有效小时数</p></div>
					</div>
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city2y3">0</p></div>
							<div class="column"  style="margin-top: 78px;" >
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电次数</p></div>
					</div>
				</div>
			</div>
			<div class="w23p h200 fl bor2" style="margin: 10px 0.9% ;">
				<div class="top bg_filter"><p id="city3Name">无</p></div>
				<div class="fl h160 w100p" id="city3">
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city3y1">0</p></div>
							<div class="column"  style="margin-top: 78px;" >
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电桩数量</p></div>
					</div>
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city3y2">0h</p></div>
							<div class="column"   style="margin-top: 78px;">
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电有效小时数</p></div>
					</div>
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city3y3">0</p></div>
							<div class="column"   style="margin-top: 78px;">
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电次数</p></div>
					</div>
				</div>
			</div>
			<div class="w23p h200 fl bor2" style="margin: 10px 0.6% ;">
				<div class="top bg_filter"><p id="city4Name">无</p></div>
				<div class="fl h160 w100p" id="city4">
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city4y1">0</p></div>
							<div class="column"  style="margin-top: 78px;" >
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
								<div class="val green"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电桩数量</p></div>
					</div>
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city4y2">0h</p></div>
							<div class="column"  style="margin-top: 78px;" >
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
								<div class="val yel"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电有效小时数</p></div>
					</div>
					<div class="fl h160 w32p" >
						<div class="fl h100 w100p"  >
							<div style="text-align: center;font-size:16px;"><p id="city4y3">0</p></div>
							<div class="column"  style="margin-top: 78px;" >
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
								<div class="val red1"></div>
							</div>
						</div>
						<div style="text-align: center;"><p>充电次数</p></div>
					</div>
				</div>
			</div>
			
			<div class="h200 w98p fl bor2"  style="margin:10px 1%;position: relative;">
				<div class="bor-point-left3"></div>
				<div class="bor-point-right3"></div>
				<div class="top3">设备状态数</div>
				<div class="w23p h160 fl" style="margin:10px 0.5%;">
					<div class="circle yellow">
						<div style="margin-top: 24px;text-align: center;">
							<h1 id="cdzgjsl">0</h1>
							<h4>告警</h4>
						</div>
					</div>
				</div> 
				<div class="w23p h160 fl" style="margin:10px 0.5%;">
					<div class="circle red">
						<div style="margin-top: 24px;text-align: center;">
							<h1 id="cdzkxsl">0</h1>
							<h4>空闲</h4>
						</div>
					</div>
				</div> 
				<div class="w23p h160 fl" style="margin:10px 0.5%;">
					<div class="circle brgreen">
						<div style="margin-top: 24px;text-align: center;">
							<h1 id="cdzcdzsl">0</h1>
							<h4>充电中</h4>
						</div>
					</div>
				</div> 
				<div class="w23p h160 fl" style="margin:10px 0.5%;">
					<div class="circle gray">
						<div style="margin-top: 24px;text-align: center;">
							<h1 id="cdzlxsl">0</h1>
							<h4>离线</h4>
						</div>
					</div>
				</div> 
			</div>
		
		</div>
	</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>

<script type="text/javascript">

$(function(){
	$(window).resize(function() {
		window.location.reload();
	});
	getUseData();
	
	setInterval(function(){
		getUseData();
	},60000*15);
	
})

function getUseData(){
	var userId = $("#userId").val(); 
	var param = "use_id="+userId;
	$.ajax({
    	url:url+"getBigSceensInf2.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data.length > 0 ){
    				 var d  = data.data[0];
    				 
    				 /**
    				  *光伏数据
    				  */
    				 $("#ljfdl").html(getFixedNum5(d.tol_power/1000)+"<span style='font-size:16px;'>MWh</span>");
    				 $("#nfdl").html(getFixedNum5(d.year_power/1000)+"<span style='font-size:16px;'>MWh</span>");
    				 $("#yfdl").html(getFixedNum5(d.mon_power/1000)+"<span style='font-size:16px;'>MWh</span>");
    				 
    				 
    				 $("#zxxl").html(getFixedNum(d.minComEff)+"%");
    				 $("#zdxl").html(getFixedNum(d.maxComEff)+"%");
    				 $("#pjz").html(getFixedNum(d.avgComEff)+"%");
    				 //计算根据数据显示柱状的高度，以及距离上边的距离
    				 $("#zxxlbar").css("margin-top",100 - getFixedNum(d.minComEff));
    				 $("#zxxlbar .val").css("height",getFixedNum(d.minComEff));
    				 $("#zdxlbar").css("margin-top",100 - getFixedNum(d.maxComEff));
    				 $("#zdxlbar .val").css("height",getFixedNum(d.maxComEff));
    				 $("#pjzbar").css("margin-top",100 - getFixedNum(d.avgComEff));
    				 $("#pjzbar .val").css("height",getFixedNum(d.avgComEff));
    				 
    				 $("#gfzcsl").html(d.norStatCountPV);
    				 $("#gfgjsl").html(d.alaStatCountPV);
    				 $("#gfgzsl").html(d.fauStatCountPV);
    				 
    				  //当前功率曲线
    				  setChartGlqx(d.pv15MinPowerLst);
    				  
    				  //年计划完成率
    				  setChartNjhwcl(d.planPVSLst);
    				  
    				  /**
     				    *储能数据
     				  */
    				  $("#cnzcsl").html(d.norStatCountPC);
    				  $("#cngjsl").html(d.alaStatCountPC);
    				  $("#cngzsl").html(d.fauStatCountPC);
    				  
   					  //充放电概括
    				  setChartCfdgk(d.phiPhePCSLst);
    				  
    				  
    				  /**
    				    *充电桩数据
    				  */
    				  $("#cdzlxsl").html(d.offlineStatCount);
    				  $("#cdzkxsl").html(d.idleStatCount);
    				  $("#cdzcdzsl").html(d.inChargeStatCount);
    				  $("#cdzgjsl").html(d.alaStatCount);
    				
    				
    				  $("#ljcdxss").html(getFixedNum(d.tolCumTime)+"h");
    				  $("#ljcdl").html(getFixedNum(d.tolCumPower/1000)+"MWh");
    				  $("#ljcdcs").html(d.tolChpCnt+"次");
    				  //计算根据数据显示柱状的高度，以及距离上边的距离 柱状的高度为75px 根据数据算比例显示
    				 
    				  if(d.tolCumTime == 0 ){
    					  $("#ljcdxssCol").css("margin-top","75px")  ;
    				  }else{
    					  if(d.tolCumTime < 75){
    						  $("#ljcdxssCol").css("margin-top",75-d.tolCumTime+"px") ;
    					  }else{
    						  $("#ljcdxssCol").css("margin-top","0")  ;
    					  }
    				  }
    				  
    				  if(d.tolCumPower == 0 ){
    					  $("#ljcdlCol").css("margin-top","75px");    
    				  }else{
    					  if(d.tolCumPower < 75){
    						  $("#ljcdlCol").css("margin-top",75-d.tolCumPower+"px") ;
    					  }else{
    						  $("#ljcdlCol").css("margin-top","0")  ;
    					  }
    				  }
    				  
    				  if(d.tolChpCnt == 0 ){
    					  $("#ljcdcsCol").css("margin-top","75px") ;
    				  }else{
    					  if(d.tolChpCnt < 75){
    						  $("#ljcdcsCol").css("margin-top",75-d.tolChpCnt+"px"); 
    					  }else{
    						  $("#ljcdcsCol").css("margin-top","0")  ;
    					  }
    				  }
    				  
    				  setChartCity(d.rankLst);
    			 } 
    			 
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}


function setChartGlqx(data){
	var xTime=[];
	var y1=[];
	for(var i=0;i<data.length;i++){
		var d=data[i];
		var xD = getLocalDateAndTime(d.tol_tim,6);
		xTime.push(xD);
		y1.push(getFixedNum5(d.power));
	}
	var myChart1 = echarts.init(document.getElementById('glqx'), 'shine');
	
	option1 = {

			tooltip : {
				trigger : 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
		        }
			},
			grid : {
				left : '70',
				top : '30',
				right : '40',
				bottom : '20'
			},
			xAxis : [ {
				type : 'category',
				data  : xTime,
				axisLine :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        },
		        splitLine:{show: false}, 
		        splitArea : {show : false},//保留网格区域 */
		        axisTick :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        },
				axisLabel : {
					textStyle : {
						color : '#fff'
					}
				}
			} ],
			yAxis : [ {
				type : 'value',
				name : '功率(kW)',
				axisLabel : {
					formatter : '{value}',
					textStyle : {
						color : '#fff'
					}
				},
				axisLine :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        },
		        axisTick :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        }
			} ],
			series : [ {
				name : '功率',
				type : 'line',
				smooth : true,
	            data: y1,
	            symbol : 'none',
				itemStyle : {
					normal : {
						color : '#07CB47'
					}
				} //后台传的数据
			}
			]
		};
		myChart1.setOption(option1);
	
}
function setChartNjhwcl(data){
	var xTime=[];
	var y1=[];
	var y2=[];
	for(var i=0;i<data.length;i++){
		var d=data[i];
		var xD = d.tol_tim.indexOf("-") > -1 ? d.tol_tim.split("-")[1]+"月" : d.tol_tim ;
		xTime.push(xD);
		y1.push(getFixedNum5(d.pvs_power/1000));
		y2.push(getFixedNum5(d.plan_power/1000));
	}
	var myChart2 = echarts.init(document.getElementById('njhwcl'), 'shine');
	
	option1 = {

			tooltip : {
				trigger : 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
		        }
			},
			grid : {
				left : '70',
				top : '30',
				right : '40',
				bottom : '20'
			},
			xAxis : [ {
				type : 'category',
				data : xTime,
				axisLine :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        },
		        splitLine:{show: false}, 
		        splitArea : {show : false},//保留网格区域 */
		        axisTick :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        },
				axisLabel : {
					textStyle : {
						color : '#fff'
					}
				}
			} ],
			yAxis : [ {
				type : 'value',
				name : '发电量(MWh)',
				axisLabel : {
					formatter : '{value}',
					textStyle : {
						color : '#fff'
					}
				},
				axisLine :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        },
		        axisTick :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        }
			} ],
			series : [ {
				name : '实际发电量',
				type : 'bar',
				smooth : true,
	            data: y1,
	            symbol : 'none',
				itemStyle : {
					normal : {
						color : '#EDB213'
					}
				} //后台传的数据
			},{
				name : '计划发电量',
				type : 'bar',
				smooth : true,
	            data: y2,
	            symbol : 'none',
				itemStyle : {
					normal : {
						color : '#07CB47'
					}
				} //后台传的数据
			}
			]
		};
		myChart2.setOption(option1);
	
}
function setChartCfdgk(data){
	var xTime=[];
	var y1=[];
	var y2=[];
	for(var i=0;i<data.length;i++){
		var d=data[i];
		var xD = d.tol_tim.indexOf("-") > -1 ? d.tol_tim.split("-")[1]+"月" : d.tol_tim ;;
		xTime.push(xD);
		y1.push(getFixedNum5(d.phi/1000));
		y2.push(getFixedNum5(d.phe/1000));
	}
	var myChart10 = echarts.init(document.getElementById('cfdgk'), 'shine');
	
	option1 = {

			tooltip : {
				trigger : 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
		        }
			},
		 	grid: {
		    	left : '50',
				top : '30',
				right : '20',
				bottom : '20'
	        },
			xAxis : [ {
				type : 'category',
				data : xTime,
				axisLine :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        },
		        splitLine:{show: false}, 
		        splitArea : {show : false},//保留网格区域 */
		        axisTick :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        },
				axisLabel : {
					textStyle : {
						color : '#fff'
					}
				}
			} ],
			yAxis : [ {
				type : 'value',
				name : '电量(MWh)',
				axisLabel : {
					formatter : '{value}',
					textStyle : {
						color : '#fff'
					}
				},
				axisLine :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        },
		        axisTick :{
		        	show : true , 
					lineStyle : {
						color:'#fff'
					}
		        }
			} ],
			series : [ {
				name : '充电量',
				type : 'bar',
				smooth : true,
	            data: y1,
	            symbol : 'none',
				itemStyle : {
					normal : {
						color : '#07CB47'
					}
				} //后台传的数据
			},
			{
				name : '放电量',
				type : 'bar',
				smooth : true,
	            data: y2,
	            symbol : 'none',
				itemStyle : {
					normal : {
						color : '#EDB213'
					}
				} //后台传的数据
			}
			]
		};
	myChart10.setOption(option1);
	
}


function setChartCity(data){
	var xTime = ['充电桩数量','充电有效小时数','充电次数'];
	
	var city1y1 = 0 ;
	var city1y2 = 0 ;
	var city1y3 = 0 ;
	var city2y1 = 0 ;
	var city2y2 = 0 ;
	var city2y3 = 0 ;
	var city3y1 = 0 ;
	var city3y2 = 0 ;
	var city3y3 = 0 ;
	var city4y1 = 0 ;
	var city4y2 = 0 ;
	var city4y3 = 0 ;
	 
	for(var i = 0 ; i < data.length ; i++){
		var d = data[i];
		if(i == 0 ){
			city1y1 = (d.chpEquCnt);
			city1y2 = (d.cumTime);
			city1y3 = (d.chpCnt);
			$("#city1Name").html(getIsNull(d.pro_nam));
			var max1 = 0 ; 
			if(city1y1 > 0 ){
				max1 = city1y1 ; 
			}
			if(city1y2 > max1 ){
				max1 = city1y2 ; 
			} 
			if(city1y3 > max1 ){
				max1 = city1y3 ; 
			} 
			$("#city1y1").html(city1y1);
			$("#city1y2").html(city1y2+"h");
			$("#city1y3").html(city1y3);
			if(max1 == 0){
				$("#city1y1").parent().parent().find(".column").css("margin-top","78px");
				$("#city1y2").parent().parent().find(".column").css("margin-top","78px");
				$("#city1y3").parent().parent().find(".column").css("margin-top","78px");
			}else{
				var c1 = (78-(city1y1/max1*78))+"px";
				var c2 = (78-(city1y2/max1*78))+"px";
				var c3 = (78-(city1y3/max1*78))+"px";
				$("#city1y1").parent().parent().find(".column").css("margin-top",c1);
				$("#city1y2").parent().parent().find(".column").css("margin-top",c2);
				$("#city1y3").parent().parent().find(".column").css("margin-top",c3);
			}
		}else if(i == 1 ){
			city2y1 = (d.chpEquCnt);
			city2y2 = (d.cumTime);
			city2y3 = (d.chpCnt);
			$("#city2Name").html(getIsNull(d.pro_nam));
			var max2 = 0 ; 
			if(city2y1 > 0 ){
				max2 = city2y1 ; 
			}
			if(city2y2 > max1 ){
				max2 = city2y2 ; 
			} 
			if(city2y3 > max1 ){
				max2 = city2y3 ; 
			} 
			$("#city2y1").html(city2y1);
			$("#city2y2").html(city2y2+"h");
			$("#city2y3").html(city2y3);
			if(max2 == 0){
				$("#city2y1").parent().parent().find(".column").css("margin-top","78px");
				$("#city2y2").parent().parent().find(".column").css("margin-top","78px");
				$("#city2y3").parent().parent().find(".column").css("margin-top","78px");
			}else{
				var c1 = (78-(city2y1/max2*78))+"px";
				var c2 = (78-(city2y2/max2*78))+"px";
				var c3 = (78-(city2y3/max2*78))+"px";
				$("#city2y1").parent().parent().find(".column").css("margin-top",c1);
				$("#city2y2").parent().parent().find(".column").css("margin-top",c2);
				$("#city2y3").parent().parent().find(".column").css("margin-top",c3);
			}
		}else if(i == 2 ){
			city3y1 = (d.chpEquCnt);
			city3y2 = (d.cumTime);
			city3y3 = (d.chpCnt);
			$("#city3Name").html(getIsNull(d.pro_nam));
			var max3 = 0 ; 
			if(city3y1 > 0 ){
				max3 = city3y1 ; 
			}
			if(city3y2 > max1 ){
				max3 = city3y2 ; 
			} 
			if(city3y3 > max1 ){
				max3 = city3y3 ; 
			} 
			$("#city3y1").html(city3y1);
			$("#city3y2").html(city3y2+"h");
			$("#city3y3").html(city3y3);
			if(max3 == 0){
				$("#city3y1").parent().parent().find(".column").css("margin-top","78px");
				$("#city3y2").parent().parent().find(".column").css("margin-top","78px");
				$("#city3y3").parent().parent().find(".column").css("margin-top","78px");
			}else{
				var c1 = (78-(city3y1/max3*78))+"px";
				var c2 = (78-(city3y2/max3*78))+"px";
				var c3 = (78-(city3y3/max3*78))+"px";
				$("#city3y1").parent().parent().find(".column").css("margin-top",c1);
				$("#city3y2").parent().parent().find(".column").css("margin-top",c2);
				$("#city3y3").parent().parent().find(".column").css("margin-top",c3);
			}
		}else if(i == 3 ){
			city4y1 = (d.chpEquCnt);
			city4y2 = (d.cumTime);
			city4y3 = (d.chpCnt);
			$("#city4Name").html(getIsNull(d.pro_nam));
			var max4 = 0 ; 
			if(city4y1 > 0 ){
				max4 = city4y1 ; 
			}
			if(city4y2 > max1 ){
				max4 = city4y2 ; 
			} 
			if(city4y3 > max1 ){
				max4 = city4y3 ; 
			} 
			$("#city4y1").html(city4y1);
			$("#city4y2").html(city4y2+"h");
			$("#city4y3").html(city4y3);
			if(max4 == 0){
				$("#city4y1").parent().parent().find(".column").css("margin-top","78px");
				$("#city4y2").parent().parent().find(".column").css("margin-top","78px");
				$("#city4y3").parent().parent().find(".column").css("margin-top","78px");
			}else{
				var c1 = (78-(city4y1/max4*78))+"px";
				var c2 = (78-(city4y2/max4*78))+"px";
				var c3 = (78-(city4y3/max4*78))+"px";
				$("#city4y1").parent().parent().find(".column").css("margin-top",c1);
				$("#city4y2").parent().parent().find(".column").css("margin-top",c2);
				$("#city4y3").parent().parent().find(".column").css("margin-top",c3);
			}
		}  
	}
 
	
}

 
</script>
</body>
</html>