<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采集数据报表</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />

</head>
<iframe id="iframe_id" style="display:none;"><!doctype html><html><head><meta charset="utf-8"><title></title></head><body></body></html></iframe>
<body class="bgfc">

	<input type="hidden" id="userId" value="${user.id}" >
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<div  class="pl15 ml15 mr15 mt15">
		<div class="w100 h670">
			<div class="bg-ff pb18 pl15 pt10 clr pl8 tjfx-box">
				 <div class="query">
			          <div class="fl">
			          	 	<select class="fl quinput w20"  id="companyOne"  onchange="setCompanytwo(this.value);">
	        	   			 	<option value="qxz">请选择一级公司</option>
	        	   			 </select>
	        	   			 <select class="fl quinput w20"  id="companyTwo" style="margin-left:15px;" onchange="setCompanyThree(this.value);">
	        	   			 	<option value="qxz">请选择二级公司</option>
	        	   			 </select>
	        	   			 <select class="fl quinput w20"  id="companyThree" style="margin-left:15px;" onchange="setPws(this.value);">
	        	   			 	<option value="qxz">请选择三级公司</option>
	        	   			 </select>
	        	   			  <select class="fl quinput w20"  id="companyPws" style="margin-left:22px;"   >
	        	   			 	<option value="qxz">请选择电站</option>
	        	   			 </select>
			          </div>
	            </div>
				<div class="query">
					<div class="fl">
						<select  value="" id="typ_ide"  class="fl quinput"  >
							<option value="qxz">-请选择查询类型-</option>
							<option value="CNNBQ">储能逆变器</option>
							<option value="DCDC">DC/DC</option>
							<option value="BYQ">变压器</option>
							<option value="DB">电表</option>
							<option value="DNZLJCZZ">电能质量检测</option>
							<option value="HLX">汇流箱</option>
							<option value="GFNBQ">光伏逆变器</option>
							<option value="JLPDG">交流配电柜</option>
							<option value="ZLPDG">直流配电柜</option>
							<option value="HJJCY">环境检测仪</option>
							<option value="CNDC">储能电池</option>
							<option value="JLZZ">解列</option>
							<option value="XLBH">线路保护</option>
							<option value="ZLCDZLC">直流充电桩充电流程信息</option>
							<option value="ZLCDZSS">直流充电桩充电实时数据</option>
							<option value="ZLCDZDJ">直流充电桩待机状态</option>
							<option value="JLCDZLC">交流充电桩充电流程</option>
							<option value="JLCDZSS">交流充电桩充电实时数据</option>
							<option value="JLCDZDJ">交流充电桩待机状态</option>
							<option value="DDQCGC">电动汽车充电过程信息</option>
							<option value="DDQCSS">电动汽车充电信息实时数据</option>
							<option value="KZQ">控制器</option>
							<option value="WWXT">微网系统</option>
						</select> 
						<input type="text" value="" id="equ_num" placeholder="请输入设备编号" class="fl quinput" style="margin-left:15px;"> 
							<input type="text" value="" id="sta_tim" placeholder="请输入开始时间" class="fl quinput Wdate" style="margin-left:15px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim\')}'})"> 
						<input type="text" value="" id="end_tim" placeholder="请输入结束时间" class="fl quinput Wdate" style="margin-left:15px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sta_tim\')}'})"> 
					</div>
				</div>
				<div class="query">
						<div class="fr">
							<input type="button" value="查询" class="querybut" onclick="currentPage  = 1;getData();" >
						<input type="button" value="下载" class="querybut down" onclick="download()" >
						</div>
				</div>
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10 mb50 bb-box">
				<div class="clr wauto"  style="overflow-x:scroll">
					<table border="0" cellspacing="0" class="table-list" id="tab" width="100%">
						<tr>
							<td >暂无数据</td>
						</tr>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode1"></div> 
				
			</div>
			<div class="blank0"></div>
		</div>
	</div>
	<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/checkCom.js?pubVersion=201802070001"></script>
<script>
	$(function(){
		getCompanyOne();
	})
	
	var countAll = 0;
	var currentPage  = 1;
	function getData(param2,typ_ide_old){
		
		var typ_ide = "" ;
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
			typ_ide = typ_ide_old ; 
		}else{
			
			if($("#companyPws").val()!="" && $("#companyPws").val()!="qxz" && $("#companyPws").val()!= undefined ){
				curParam+="&&pws_id="+$("#companyPws").val();
			}else{
				layer.alert("请选择电站");
				return false;
			}
			
			typ_ide=$("#typ_ide").val();
			if($("#typ_ide").val()!=""&&$("#typ_ide").val()!="qxz"){
				curParam+="&&typ_ide="+$("#typ_ide").val();
			}else{
				layer.alert("请选择查询类型");
				return false;
			}
			
			if($("#equ_num").val()!=""){
				curParam+="&&equ_num="+$("#equ_num").val();
			}
			if($("#sta_tim").val()!=""){
				curParam+="&&sta_tim="+$("#sta_tim").val();
			}
			if($("#end_tim").val()!=""){
				curParam+="&&end_tim="+$("#end_tim").val();
			}
			
		}
		
		
		var param  = curParam + "&currentPage="+currentPage;
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getCollectDataLst.htm",
			data:param,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					countAll = data.totalPage;
					currentPage = data.currentPage;
					var html="";
					
					if( data.data.length>0 ){
							if(typ_ide == "GFNBQ"){
								html="<tr>"+
								"<th>序号</th>"+
								"<th>设备编号</th>"+
								"<th>设备状态</th>"+
								"<th>告警码</th>"+
								"<th>支路数量</th>"+
								"<th>直流电压1</th>"+
								"<th>直流电压2</th>"+
								"<th>直流电压3</th>"+
								"<th>直流电压4</th>"+
								"<th>直流电压5</th>"+
								"<th>直流电压6</th>"+
								"<th>直流电压7</th>"+
								"<th>直流电压8</th>"+
								"<th>直流电压9</th>"+
								"<th>直流电压10</th>"+
								
								"<th>直流电流1</th>"+
								"<th>直流电流2</th>"+
								"<th>直流电流3</th>"+
								"<th>直流电流4</th>"+
								"<th>直流电流5</th>"+
								"<th>直流电流6</th>"+
								"<th>直流电流7</th>"+
								"<th>直流电流8</th>"+
								"<th>直流电流9</th>"+
								"<th>直流电流10</th>"+
								
								"<th>直流功率1</th>"+
								"<th>直流功率2</th>"+
								"<th>直流功率3</th>"+
								"<th>直流功率4</th>"+
								"<th>直流功率5</th>"+
								"<th>直流功率6</th>"+
								"<th>直流功率7</th>"+
								"<th>直流功率8</th>"+
								"<th>直流功率9</th>"+
								"<th>直流功率10</th>"+
								
								"<th>总直流功率</th>"+
								"<th>Uab线电压</th>"+
								"<th>Ubc线电压</th>"+
								"<th>Uca线电压</th>"+
								"<th>A相电压</th>"+
								"<th>B相电压</th>"+
								"<th>C相电压</th>"+
								"<th>A相电流</th>"+
								"<th>B相电流</th>"+
								"<th>C相电流</th>"+
								"<th>A相有功</th>"+
								"<th>B相有功</th>"+
								"<th>C相有功</th>"+
								"<th>有功功率</th>"+
								"<th>无功功率</th>"+
								"<th>视在功率</th>"+
								"<th>功率因数</th>"+
								"<th>效率</th>"+
								"<th>频率</th>"+
								"<th>离散率</th>"+
								"<th>日发电量</th>"+
								"<th>总发电量</th>"+
								"<th>累计正常运行时间</th>"+
								"<th>累计正常停机时间</th>"+
								"<th>累计告警运行时间</th>"+
								"<th>累计故障时长</th>"+
								"<th>累计通讯中断时间</th>"+
								"<th>累计限电运行时间</th>"+
								"<th>累计运行时间</th>"+
								"<th>机内温度</th>"+
								"<th>模块1温度</th>"+
								"<th>模块2温度</td>"+
								"<th>模块3温度</th>"+
								"<th>模块4温度</td>"+
								"<th>模块5温度</th>"+
								"<th>模块6温度</td>"+
								"<th>正极对地阻抗值</th>"+
								"<th>负极对地阻抗值</td>"+
								"<th>限功率实际值</th>"+
								"<th>无功调节实际值</td>"+
								"<th>健康状态</th>"+
								"<th>创建时间</td>"+
								"</tr>";
								for(var i=0;i<data.data.length;i++){
									var lst=data.data[i];
									var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "正常停机" : lst.stat == 3 ? "告警运行":lst.stat == 4 ? "故障停机" :lst.stat == 4 ? "限电运行":"";
									var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  
									html+="<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+lst.faultCode+"</td>"+
										"<td>"+lst.branchNum+"</td>"+
										"<td>"+getFixedNum5(lst.udc1)+"</td>"+
										"<td>"+getFixedNum5(lst.udc2)+"</td>"+
										"<td>"+getFixedNum5(lst.udc3)+"</td>"+
										"<td>"+getFixedNum5(lst.udc4)+"</td>"+
										"<td>"+getFixedNum5(lst.udc5)+"</td>"+
										"<td>"+getFixedNum5(lst.udc6)+"</td>"+
										"<td>"+getFixedNum5(lst.udc7)+"</td>"+
										"<td>"+getFixedNum5(lst.udc8)+"</td>"+
										"<td>"+getFixedNum5(lst.udc9)+"</td>"+
										"<td>"+getFixedNum5(lst.udc10)+"</td>"+
										"<td>"+getFixedNum5(lst.idc1)+"</td>"+
										"<td>"+getFixedNum5(lst.idc2)+"</td>"+
										"<td>"+getFixedNum5(lst.idc3)+"</td>"+
										"<td>"+getFixedNum5(lst.idc4)+"</td>"+
										"<td>"+getFixedNum5(lst.idc5)+"</td>"+
										"<td>"+getFixedNum5(lst.idc6)+"</td>"+
										"<td>"+getFixedNum5(lst.idc7)+"</td>"+
										"<td>"+getFixedNum5(lst.idc8)+"</td>"+
										"<td>"+getFixedNum5(lst.idc9)+"</td>"+
										"<td>"+getFixedNum5(lst.idc10)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc1)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc2)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc3)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc4)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc5)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc6)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc7)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc8)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc9)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc10)+"</td>"+
										"<td>"+getFixedNum5(lst.pdcSum)+"</td>"+
										"<td>"+getFixedNum5(lst.uab)+"</td>"+
										"<td>"+getFixedNum5(lst.ubc)+"</td>"+
										"<td>"+getFixedNum5(lst.uca)+"</td>"+
										"<td>"+getFixedNum5(lst.ua)+"</td>"+
										"<td>"+getFixedNum5(lst.ub)+"</td>"+
										"<td>"+getFixedNum5(lst.uc)+"</td>"+
										"<td>"+getFixedNum5(lst.ia)+"</td>"+
										"<td>"+getFixedNum5(lst.ib)+"</td>"+
										"<td>"+getFixedNum5(lst.ic)+"</td>"+
										"<td>"+getFixedNum5(lst.pa)+"</td>"+
										"<td>"+getFixedNum5(lst.Pb)+"</td>"+
										"<td>"+getFixedNum5(lst.pc)+"</td>"+
										"<td>"+getFixedNum5(lst.psum)+"</td>"+
										"<td>"+getFixedNum5(lst.qsum)+"</td>"+
										"<td>"+getFixedNum5(lst.ssum)+"</td>"+
										"<td>"+getFixedNum5(lst.pf)+"</td>"+
										"<td>"+getFixedNum5(lst.eff)+"</td>"+
										"<td>"+getFixedNum5(lst.freq)+"</td>"+
										"<td>"+getFixedNum5(lst.disRate)+"</td>"+
										"<td>"+getFixedNum5(lst.powerDay)+"</td>"+
										"<td>"+getFixedNum5(lst.powerAll)+"</td>"+
										"<td>"+getFixedNum5(lst.goodRunTime)+"</td>"+
										"<td>"+getFixedNum5(lst.downTime)+"</td>"+
										"<td>"+getFixedNum5(lst.faultTime)+"</td>"+
										"<td>"+getFixedNum5(lst.failureTime)+"</td>"+
										"<td>"+getFixedNum5(lst.comIntTime)+"</td>"+
										"<td>"+getFixedNum5(lst.eleRunTime)+"</td>"+
										"<td>"+getFixedNum5(lst.timeAll)+"</td>"+
										"<td>"+getFixedNum5(lst.temp)+"</td>"+
										"<td>"+getFixedNum5(lst.temp1)+"</td>"+
										"<td>"+getFixedNum5(lst.temp2)+"</td>"+
										"<td>"+getFixedNum5(lst.temp3)+"</td>"+
										"<td>"+getFixedNum5(lst.temp4)+"</td>"+
										"<td>"+getFixedNum5(lst.temp5)+"</td>"+
										"<td>"+getFixedNum5(lst.temp6)+"</td>"+
										"<td>"+getFixedNum5(lst.imp1)+"</td>"+
										"<td>"+getFixedNum5(lst.imp2)+"</td>"+
										"<td>"+getFixedNum5(lst.plimit)+"</td>"+
										"<td>"+getFixedNum5(lst.qlimit)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
								}
	    					 }else if(typ_ide == "CNNBQ"){
	    						 html="<tr>"+
	    						 	"<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>告警码</th>"+
									"<th>工作模式</th>"+
									"<th>并离网状态</th>"+
									"<th>直流电压</th>"+
									"<th>直流电流</th>"+
									"<th>直流功率</th>"+
									"<th>Uab线电压</th>"+
									"<th>Ubc线电压</th>"+
									"<th>Uca线电压</th>"+
									"<th>A相电压</th>"+
									"<th>B相电压</th>"+
									"<th>C相电压</th>"+
									"<th>A相电流</th>"+
									"<th>B相电流</th>"+
									"<th>C相电流</th>"+
									"<th>A相有功</th>"+
									"<th>B相有功</th>"+
									"<th>C相有功</th>"+
									"<th>有功功率</th>"+
									"<th>A相无功</th>"+
									"<th>B相无功</th>"+
									"<th>C相无功</th>"+
									"<th>无功功率</th>"+
									"<th>累计输入电量</th>"+
									"<th>累计输出电量</th>"+
									"<th>效率</th>"+
									"<th>功率因数</th>"+
									"<th>频率</th>"+
									"<th>机内温度</th>"+
									"<th>模块温度</th>"+
									"<th>累计正常运行时间</th>"+
									"<th>累计正常停机时间</th>"+
									"<th>累计告警运行时间</th>"+
									"<th>累计故障停机时间</th>"+
									"<th>累计通讯中断时间</th>"+
									"<th>累计运行时间</th>"+
									"<th>累计充电时间</th>"+
									"<th>累计放电时间</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</td>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "正常停机" : lst.stat == 3 ? "告警运行":lst.stat == 4 ? "故障停机" :"";
										var mode = lst.mode == 0 ?"P/Q": lst.mode == 1 ? "V/F" :lst.mode == 2 ? "虚拟同步发电机" : lst.mode == 3 ? "直流恒压":"";
										var gridStat = lst.gridStat == 0 ?"离网": lst.gridStat == 1 ? "并网" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html +=	"<tr>"+
											"<td>"+(i+1)+"</td>"+
											"<td>"+lst.equ_num+"</td>"+
											"<td>"+stat+"</td>"+
											"<td>"+lst.faultCode+"</td>"+
											"<td>"+mode+"</td>"+
											"<td>"+gridStat+"</td>"+
											"<td>"+getFixedNum5(lst.udc)+"</td>"+
											"<td>"+getFixedNum5(lst.idc)+"</td>"+
											"<td>"+getFixedNum5(lst.pdc)+"</td>"+
											"<td>"+getFixedNum5(lst.uab)+"</td>"+
											"<td>"+getFixedNum5(lst.ubc)+"</td>"+
											"<td>"+getFixedNum5(lst.uca)+"</td>"+
											"<td>"+getFixedNum5(lst.ua)+"</td>"+
											"<td>"+getFixedNum5(lst.ub)+"</td>"+
											"<td>"+getFixedNum5(lst.uc)+"</td>"+
											"<td>"+getFixedNum5(lst.ia)+"</td>"+
											"<td>"+getFixedNum5(lst.ib)+"</td>"+
											"<td>"+getFixedNum5(lst.ic)+"</td>"+
											"<td>"+getFixedNum5(lst.pa)+"</td>"+
											"<td>"+getFixedNum5(lst.pb)+"</td>"+
											"<td>"+getFixedNum5(lst.pc)+"</td>"+
											"<td>"+getFixedNum5(lst.psum)+"</td>"+
											"<td>"+getFixedNum5(lst.qa)+"</td>"+
											"<td>"+getFixedNum5(lst.qb)+"</td>"+
											"<td>"+getFixedNum5(lst.qc)+"</td>"+
											"<td>"+getFixedNum5(lst.qsum)+"</td>"+
											"<td>"+getFixedNum5(lst.phi)+"</td>"+
											"<td>"+getFixedNum5(lst.phe)+"</td>"+
											"<td>"+getFixedNum5(lst.eff)+"</td>"+
											"<td>"+getFixedNum5(lst.pf)+"</td>"+
											"<td>"+getFixedNum5(lst.freq)+"</td>"+
											"<td>"+getFixedNum5(lst.temp)+"</td>"+
											"<td>"+getFixedNum5(lst.tempMod)+"</td>"+
											"<td>"+getFixedNum5(lst.goodRunTime)+"</td>"+
											"<td>"+getFixedNum5(lst.downTime)+"</td>"+
											"<td>"+getFixedNum5(lst.faultTime)+"</td>"+
											"<td>"+getFixedNum5(lst.failureTime)+"</td>"+
											"<td>"+getFixedNum5(lst.comIntTime)+"</td>"+
											"<td>"+getFixedNum5(lst.runTime)+"</td>"+
											"<td>"+getFixedNum5(lst.chargeTime)+"</td>"+
											"<td>"+getFixedNum5(lst.dischargeTime)+"</td>"+
											"<td>"+healthStat+"</td>"+
											"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
											"</tr>";
									}
	    					 }else if(typ_ide == "CNDC"){
	    						 html="<tr>"+
	    						 	"<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>电池状态</th>"+
									"<th>告警码</th>"+
									"<th>温度模块数量</th>"+
									"<th>单体电池数量</th>"+
									"<th>最高电压位置</th>"+
									"<th>最低电压位置</th>"+
									"<th>最高温度位置</th>"+
									"<th>最低温度位置</th>"+
									"<th>总电压</th>"+
									"<th>总电流</th>"+
									"<th>总功率</th>"+
									"<th>SOC</th>"+
									"<th>额定容量</th>"+
									"<th>累计充电电量</th>"+
									"<th>累计放电电量</th>"+
									"<th>可充电电量</th>"+
									"<th>可放电电量</th>"+
									"<th>最高电压</th>"+
									"<th>最低电压</th>"+
									"<th>最高温度</th>"+
									"<th>最低温度</th>"+
									"<th>最大允许充电电流</th>"+
									"<th>最大允许放电电流</th>"+
									"<th>最高允许工作温度</th>"+
									"<th>最低允许工作温度</th>"+
									"<th>最高允许充电单体电压</th>"+
									"<th>最低允许充电单体电压</th>"+
									"<th>温度1</th>"+
									"<th>温度2</th>"+
									"<th>温度3</th>"+
									"<th>温度4</th>"+
									"<th>温度5</th>"+
									"<th>温度6</th>"+
									"<th>温度7</th>"+
									"<th>温度8</th>"+
									"<th>温度9</th>"+
									"<th>温度10</th>"+
									"<th>温度11</th>"+
									"<th>温度12</th>"+
									"<th>温度13</th>"+
									"<th>温度14</th>"+
									"<th>温度15</th>"+
									"<th>温度16</th>"+
									"<th>温度17</th>"+
									"<th>温度18</th>"+
									"<th>温度19</th>"+
									"<th>温度20</th>"+
									"<th>温度21</th>"+
									"<th>温度22</th>"+
									"<th>温度23</th>"+
									"<th>温度24</th>"+
									"<th>温度25</th>"+
									"<th>温度26</th>"+
									"<th>温度27</th>"+
									"<th>温度28</th>"+
									"<th>温度29</th>"+
									"<th>温度30</th>"+
									"<th>温度31</th>"+
									"<th>温度32</th>"+
									"<th>温度33</th>"+
									"<th>温度34</th>"+
									"<th>温度35</th>"+
									"<th>温度36</th>"+
									"<th>温度37</th>"+
									"<th>温度38</th>"+
									"<th>温度39</th>"+
									"<th>温度40</th>"+
									"<th>温度41</th>"+
									"<th>温度42</th>"+
									"<th>温度43</th>"+
									"<th>温度44</th>"+
									"<th>温度45</th>"+
									"<th>温度46</th>"+
									"<th>温度47</th>"+
									"<th>温度48</th>"+
									"<th>温度49</th>"+
									"<th>温度50</th>"+
									"<th>电池模块1电压</th>"+
									"<th>电池模块2电压</th>"+
									"<th>电池模块3电压</th>"+
									"<th>电池模块4电压</th>"+
									"<th>电池模块5电压</th>"+
									"<th>电池模块6电压</th>"+
									"<th>电池模块7电压</th>"+
									"<th>电池模块8电压</th>"+
									"<th>电池模块9电压</th>"+
									"<th>电池模块10电压</th>"+
									"<th>电池模块11电压</th>"+
									"<th>电池模块12电压</th>"+
									"<th>电池模块13电压</th>"+
									"<th>电池模块14电压</th>"+
									"<th>电池模块15电压</th>"+
									"<th>电池模块16电压</th>"+
									"<th>电池模块17电压</th>"+
									"<th>电池模块18电压</th>"+
									"<th>电池模块19电压</th>"+
									"<th>电池模块20电压</th>"+
									"<th>电池模块21电压</th>"+
									"<th>电池模块22电压</th>"+
									"<th>电池模块23电压</th>"+
									"<th>电池模块24电压</th>"+
									"<th>电池模块25电压</th>"+
									"<th>电池模块26电压</th>"+
									"<th>电池模块27电压</th>"+
									"<th>电池模块28电压</th>"+
									"<th>电池模块29电压</th>"+
									"<th>电池模块30电压</th>"+
									"<th>电池模块31电压</th>"+
									"<th>电池模块32电压</th>"+
									"<th>电池模块33电压</th>"+
									"<th>电池模块34电压</th>"+
									"<th>电池模块35电压</th>"+
									"<th>电池模块36电压</th>"+
									"<th>电池模块37电压</th>"+
									"<th>电池模块38电压</th>"+
									"<th>电池模块39电压</th>"+
									"<th>电池模块40电压</th>"+
									"<th>电池模块41电压</th>"+
									"<th>电池模块42电压</th>"+
									"<th>电池模块43电压</th>"+
									"<th>电池模块44电压</th>"+
									"<th>电池模块45电压</th>"+
									"<th>电池模块46电压</th>"+
									"<th>电池模块47电压</th>"+
									"<th>电池模块48电压</th>"+
									"<th>电池模块49电压</th>"+
									"<th>电池模块50电压</th>"+
									"<th>电池模块51电压</th>"+
									"<th>电池模块52电压</th>"+
									"<th>电池模块53电压</th>"+
									"<th>电池模块54电压</th>"+
									"<th>电池模块55电压</th>"+
									"<th>电池模块56电压</th>"+
									"<th>电池模块57电压</th>"+
									"<th>电池模块58电压</th>"+
									"<th>电池模块59电压</th>"+
									"<th>电池模块60电压</th>"+
									"<th>电池模块61电压</th>"+
									"<th>电池模块62电压</th>"+
									"<th>电池模块63电压</th>"+
									"<th>电池模块64电压</th>"+
									"<th>电池模块65电压</th>"+
									"<th>电池模块66电压</th>"+
									"<th>电池模块67电压</th>"+
									"<th>电池模块68电压</th>"+
									"<th>电池模块69电压</th>"+
									"<th>电池模块70电压</th>"+
									"<th>电池模块71电压</th>"+
									"<th>电池模块72电压</th>"+
									"<th>电池模块73电压</th>"+
									"<th>电池模块74电压</th>"+
									"<th>电池模块75电压</th>"+
									"<th>电池模块76电压</th>"+
									"<th>电池模块77电压</th>"+
									"<th>电池模块78电压</th>"+
									"<th>电池模块79电压</th>"+
									"<th>电池模块80电压</th>"+
									"<th>电池模块81电压</th>"+
									"<th>电池模块82电压</th>"+
									"<th>电池模块83电压</th>"+
									"<th>电池模块84电压</th>"+
									"<th>电池模块85电压</th>"+
									"<th>电池模块86电压</th>"+
									"<th>电池模块87电压</th>"+
									"<th>电池模块88电压</th>"+
									"<th>电池模块89电压</th>"+
									"<th>电池模块90电压</th>"+
									"<th>电池模块91电压</th>"+
									"<th>电池模块92电压</th>"+
									"<th>电池模块93电压</th>"+
									"<th>电池模块94电压</th>"+
									"<th>电池模块95电压</th>"+
									"<th>电池模块96电压</th>"+
									"<th>电池模块97电压</th>"+
									"<th>电池模块98电压</th>"+
									"<th>电池模块99电压</th>"+
									"<th>电池模块100电压</th>"+
									"<th>电池模块101电压</th>"+
									"<th>电池模块102电压</th>"+
									"<th>电池模块103电压</th>"+
									"<th>电池模块104电压</th>"+
									"<th>电池模块105电压</th>"+
									"<th>电池模块106电压</th>"+
									"<th>电池模块107电压</th>"+
									"<th>电池模块108电压</th>"+
									"<th>电池模块109电压</th>"+
									"<th>电池模块110电压</th>"+
									"<th>电池模块111电压</th>"+
									"<th>电池模块112电压</th>"+
									"<th>电池模块113电压</th>"+
									"<th>电池模块114电压</th>"+
									"<th>电池模块115电压</th>"+
									"<th>电池模块116电压</th>"+
									"<th>电池模块117电压</th>"+
									"<th>电池模块118电压</th>"+
									"<th>电池模块119电压</th>"+
									"<th>电池模块120电压</th>"+
									"<th>电池模块121电压</th>"+
									"<th>电池模块122电压</th>"+
									"<th>电池模块123电压</th>"+
									"<th>电池模块124电压</th>"+
									"<th>电池模块125电压</th>"+
									"<th>电池模块126电压</th>"+
									"<th>电池模块127电压</th>"+
									"<th>电池模块128电压</th>"+
									"<th>电池模块129电压</th>"+
									"<th>电池模块130电压</th>"+
									"<th>电池模块131电压</th>"+
									"<th>电池模块132电压</th>"+
									"<th>电池模块133电压</th>"+
									"<th>电池模块134电压</th>"+
									"<th>电池模块135电压</th>"+
									"<th>电池模块136电压</th>"+
									"<th>电池模块137电压</th>"+
									"<th>电池模块138电压</th>"+
									"<th>电池模块139电压</th>"+
									"<th>电池模块140电压</th>"+
									"<th>电池模块141电压</th>"+
									"<th>电池模块142电压</th>"+
									"<th>电池模块143电压</th>"+
									"<th>电池模块144电压</th>"+
									"<th>电池模块145电压</th>"+
									"<th>电池模块146电压</th>"+
									"<th>电池模块147电压</th>"+
									"<th>电池模块148电压</th>"+
									"<th>电池模块149电压</th>"+
									"<th>电池模块150电压</th>"+
									"<th>电池模块151电压</th>"+
									"<th>电池模块152电压</th>"+
									"<th>电池模块153电压</th>"+
									"<th>电池模块154电压</th>"+
									"<th>电池模块155电压</th>"+
									"<th>电池模块156电压</th>"+
									"<th>电池模块157电压</th>"+
									"<th>电池模块158电压</th>"+
									"<th>电池模块159电压</th>"+
									"<th>电池模块160电压</th>"+
									"<th>电池模块161电压</th>"+
									"<th>电池模块162电压</th>"+
									"<th>电池模块163电压</th>"+
									"<th>电池模块164电压</th>"+
									"<th>电池模块165电压</th>"+
									"<th>电池模块166电压</th>"+
									"<th>电池模块167电压</th>"+
									"<th>电池模块168电压</th>"+
									"<th>电池模块169电压</th>"+
									"<th>电池模块170电压</th>"+
									"<th>电池模块171电压</th>"+
									"<th>电池模块172电压</th>"+
									"<th>电池模块173电压</th>"+
									"<th>电池模块174电压</th>"+
									"<th>电池模块175电压</th>"+
									"<th>电池模块176电压</th>"+
									"<th>电池模块177电压</th>"+
									"<th>电池模块178电压</th>"+
									"<th>电池模块179电压</th>"+
									"<th>电池模块180电压</th>"+
									"<th>电池模块181电压</th>"+
									"<th>电池模块182电压</th>"+
									"<th>电池模块183电压</th>"+
									"<th>电池模块184电压</th>"+
									"<th>电池模块185电压</th>"+
									"<th>电池模块186电压</th>"+
									"<th>电池模块187电压</th>"+
									"<th>电池模块188电压</th>"+
									"<th>电池模块189电压</th>"+
									"<th>电池模块190电压</th>"+
									"<th>电池模块191电压</th>"+
									"<th>电池模块192电压</th>"+
									"<th>电池模块193电压</th>"+
									"<th>电池模块194电压</th>"+
									"<th>电池模块195电压</th>"+
									"<th>电池模块196电压</th>"+
									"<th>电池模块197电压</th>"+
									"<th>电池模块198电压</th>"+
									"<th>电池模块199电压</th>"+
									"<th>电池模块200电压</th>"+
									"<th>电池模块201电压</th>"+
									"<th>电池模块202电压</th>"+
									"<th>电池模块203电压</th>"+
									"<th>电池模块204电压</th>"+
									"<th>电池模块205电压</th>"+
									"<th>电池模块206电压</th>"+
									"<th>电池模块207电压</th>"+
									"<th>电池模块208电压</th>"+
									"<th>电池模块209电压</th>"+
									"<th>电池模块210电压</th>"+
									"<th>电池模块211电压</th>"+
									"<th>电池模块212电压</th>"+
									"<th>电池模块213电压</th>"+
									"<th>电池模块214电压</th>"+
									"<th>电池模块215电压</th>"+
									"<th>电池模块216电压</th>"+
									"<th>电池模块217电压</th>"+
									"<th>电池模块218电压</th>"+
									"<th>电池模块219电压</th>"+
									"<th>电池模块220电压</th>"+
									"<th>电池模块221电压</th>"+
									"<th>电池模块222电压</th>"+
									"<th>电池模块223电压</th>"+
									"<th>电池模块224电压</th>"+
									"<th>电池模块225电压</th>"+
									"<th>电池模块226电压</th>"+
									"<th>电池模块227电压</th>"+
									"<th>电池模块228电压</th>"+
									"<th>电池模块229电压</th>"+
									"<th>电池模块230电压</th>"+
									"<th>电池模块231电压</th>"+
									"<th>电池模块232电压</th>"+
									"<th>电池模块233电压</th>"+
									"<th>电池模块234电压</th>"+
									"<th>电池模块235电压</th>"+
									"<th>电池模块236电压</th>"+
									"<th>电池模块237电压</th>"+
									"<th>电池模块238电压</th>"+
									"<th>电池模块239电压</th>"+
									"<th>电池模块240电压</th>"+
									"<th>电池模块241电压</th>"+
									"<th>电池模块242电压</th>"+
									"<th>电池模块243电压</th>"+
									"<th>电池模块244电压</th>"+
									"<th>电池模块245电压</th>"+
									"<th>电池模块246电压</th>"+
									"<th>电池模块247电压</th>"+
									"<th>电池模块248电压</th>"+
									"<th>电池模块249电压</th>"+
									"<th>电池模块250电压</th>"+
									"<th>电池模块251电压</th>"+
									"<th>电池模块252电压</th>"+
									"<th>电池模块253电压</th>"+
									"<th>电池模块254电压</th>"+
									"<th>电池模块255电压</th>"+
									"<th>电池模块256电压</th>"+
									"<th>电池模块257电压</th>"+
									"<th>电池模块258电压</th>"+
									"<th>电池模块259电压</th>"+
									"<th>电池模块260电压</th>"+
									"<th>电池模块261电压</th>"+
									"<th>电池模块262电压</th>"+
									"<th>电池模块263电压</th>"+
									"<th>电池模块264电压</th>"+
									"<th>电池模块265电压</th>"+
									"<th>电池模块266电压</th>"+
									"<th>电池模块267电压</th>"+
									"<th>电池模块268电压</th>"+
									"<th>电池模块269电压</th>"+
									"<th>电池模块270电压</th>"+
									"<th>电池模块271电压</th>"+
									"<th>电池模块272电压</th>"+
									"<th>电池模块273电压</th>"+
									"<th>电池模块274电压</th>"+
									"<th>电池模块275电压</th>"+
									"<th>电池模块276电压</th>"+
									"<th>电池模块277电压</th>"+
									"<th>电池模块278电压</th>"+
									"<th>电池模块279电压</th>"+
									"<th>电池模块280电压</th>"+
									"<th>电池模块281电压</th>"+
									"<th>电池模块282电压</th>"+
									"<th>电池模块283电压</th>"+
									"<th>电池模块284电压</th>"+
									"<th>电池模块285电压</th>"+
									"<th>电池模块286电压</th>"+
									"<th>电池模块287电压</th>"+
									"<th>电池模块288电压</th>"+
									"<th>电池模块289电压</th>"+
									"<th>电池模块290电压</th>"+
									"<th>电池模块291电压</th>"+
									"<th>电池模块292电压</th>"+
									"<th>电池模块293电压</th>"+
									"<th>电池模块294电压</th>"+
									"<th>电池模块295电压</th>"+
									"<th>电池模块296电压</th>"+
									"<th>电池模块297电压</th>"+
									"<th>电池模块298电压</th>"+
									"<th>电池模块299电压</th>"+
									"<th>电池模块300电压</th>"+
									"<th>电池模块301电压</th>"+
									"<th>电池模块302电压</th>"+
									"<th>电池模块303电压</th>"+
									"<th>电池模块304电压</th>"+
									"<th>电池模块305电压</th>"+
									"<th>电池模块306电压</th>"+
									"<th>电池模块307电压</th>"+
									"<th>电池模块308电压</th>"+
									"<th>电池模块309电压</th>"+
									"<th>电池模块310电压</th>"+
									"<th>电池模块311电压</th>"+
									"<th>电池模块312电压</th>"+
									"<th>电池模块313电压</th>"+
									"<th>电池模块314电压</th>"+
									"<th>电池模块315电压</th>"+
									"<th>电池模块316电压</th>"+
									"<th>电池模块317电压</th>"+
									"<th>电池模块318电压</th>"+
									"<th>电池模块319电压</th>"+
									"<th>电池模块320电压</th>"+
									"<th>电池模块321电压</th>"+
									"<th>电池模块322电压</th>"+
									"<th>电池模块323电压</th>"+
									"<th>电池模块324电压</th>"+
									"<th>电池模块325电压</th>"+
									"<th>电池模块326电压</th>"+
									"<th>电池模块327电压</th>"+
									"<th>电池模块328电压</th>"+
									"<th>电池模块329电压</th>"+
									"<th>电池模块330电压</th>"+
									"<th>电池模块331电压</th>"+
									"<th>电池模块332电压</th>"+
									"<th>电池模块333电压</th>"+
									"<th>电池模块334电压</th>"+
									"<th>电池模块335电压</th>"+
									"<th>电池模块336电压</th>"+
									"<th>电池模块337电压</th>"+
									"<th>电池模块338电压</th>"+
									"<th>电池模块339电压</th>"+
									"<th>电池模块340电压</th>"+
									"<th>电池模块341电压</th>"+
									"<th>电池模块342电压</th>"+
									"<th>电池模块343电压</th>"+
									"<th>电池模块344电压</th>"+
									"<th>电池模块345电压</th>"+
									"<th>电池模块346电压</th>"+
									"<th>电池模块347电压</th>"+
									"<th>电池模块348电压</th>"+
									"<th>电池模块349电压</th>"+
									"<th>电池模块350电压</th>"+
									"<th>电池模块351电压</th>"+
									"<th>电池模块352电压</th>"+
									"<th>电池模块353电压</th>"+
									"<th>电池模块354电压</th>"+
									"<th>电池模块355电压</th>"+
									"<th>电池模块356电压</th>"+
									"<th>电池模块357电压</th>"+
									"<th>电池模块358电压</th>"+
									"<th>电池模块359电压</th>"+
									"<th>电池模块360电压</th>"+
									"<th>电池模块361电压</th>"+
									"<th>电池模块362电压</th>"+
									"<th>电池模块363电压</th>"+
									"<th>电池模块364电压</th>"+
									"<th>电池模块365电压</th>"+
									"<th>电池模块366电压</th>"+
									"<th>电池模块367电压</th>"+
									"<th>电池模块368电压</th>"+
									"<th>电池模块369电压</th>"+
									"<th>电池模块370电压</th>"+
									"<th>电池模块371电压</th>"+
									"<th>电池模块372电压</th>"+
									"<th>电池模块373电压</th>"+
									"<th>电池模块374电压</th>"+
									"<th>电池模块375电压</th>"+
									"<th>电池模块376电压</th>"+
									"<th>电池模块377电压</th>"+
									"<th>电池模块378电压</th>"+
									"<th>电池模块379电压</th>"+
									"<th>电池模块380电压</th>"+
									"<th>电池模块381电压</th>"+
									"<th>电池模块382电压</th>"+
									"<th>电池模块383电压</th>"+
									"<th>电池模块384电压</th>"+
									"<th>电池模块385电压</th>"+
									"<th>电池模块386电压</th>"+
									"<th>电池模块387电压</th>"+
									"<th>电池模块388电压</th>"+
									"<th>电池模块389电压</th>"+
									"<th>电池模块390电压</th>"+
									"<th>电池模块391电压</th>"+
									"<th>电池模块392电压</th>"+
									"<th>电池模块393电压</th>"+
									"<th>电池模块394电压</th>"+
									"<th>电池模块395电压</th>"+
									"<th>电池模块396电压</th>"+
									"<th>电池模块397电压</th>"+
									"<th>电池模块398电压</th>"+
									"<th>电池模块399电压</th>"+
									"<th>电池模块400电压</th>"+
									"<th>电池模块401电压</th>"+
									"<th>电池模块402电压</th>"+
									"<th>电池模块403电压</th>"+
									"<th>电池模块404电压</th>"+
									"<th>电池模块405电压</th>"+
									"<th>电池模块406电压</th>"+
									"<th>电池模块407电压</th>"+
									"<th>电池模块408电压</th>"+
									"<th>电池模块409电压</th>"+
									"<th>电池模块410电压</th>"+
									"<th>电池模块411电压</th>"+
									"<th>电池模块412电压</th>"+
									"<th>电池模块413电压</th>"+
									"<th>电池模块414电压</th>"+
									"<th>电池模块415电压</th>"+
									"<th>电池模块416电压</th>"+
									"<th>电池模块417电压</th>"+
									"<th>电池模块418电压</th>"+
									"<th>电池模块419电压</th>"+
									"<th>电池模块420电压</th>"+
									"<th>电池模块421电压</th>"+
									"<th>电池模块422电压</th>"+
									"<th>电池模块423电压</th>"+
									"<th>电池模块424电压</th>"+
									"<th>电池模块425电压</th>"+
									"<th>电池模块426电压</th>"+
									"<th>电池模块427电压</th>"+
									"<th>电池模块428电压</th>"+
									"<th>电池模块429电压</th>"+
									"<th>电池模块430电压</th>"+
									"<th>电池模块431电压</th>"+
									"<th>电池模块432电压</th>"+
									"<th>电池模块433电压</th>"+
									"<th>电池模块434电压</th>"+
									"<th>电池模块435电压</th>"+
									"<th>电池模块436电压</th>"+
									"<th>电池模块437电压</th>"+
									"<th>电池模块438电压</th>"+
									"<th>电池模块439电压</th>"+
									"<th>电池模块440电压</th>"+
									"<th>电池模块441电压</th>"+
									"<th>电池模块442电压</th>"+
									"<th>电池模块443电压</th>"+
									"<th>电池模块444电压</th>"+
									"<th>电池模块445电压</th>"+
									"<th>电池模块446电压</th>"+
									"<th>电池模块447电压</th>"+
									"<th>电池模块448电压</th>"+
									"<th>电池模块449电压</th>"+
									"<th>电池模块450电压</th>"+
									"<th>电池模块451电压</th>"+
									"<th>电池模块452电压</th>"+
									"<th>电池模块453电压</th>"+
									"<th>电池模块454电压</th>"+
									"<th>电池模块455电压</th>"+
									"<th>电池模块456电压</th>"+
									"<th>电池模块457电压</th>"+
									"<th>电池模块458电压</th>"+
									"<th>电池模块459电压</th>"+
									"<th>电池模块460电压</th>"+
									"<th>电池模块461电压</th>"+
									"<th>电池模块462电压</th>"+
									"<th>电池模块463电压</th>"+
									"<th>电池模块464电压</th>"+
									"<th>电池模块465电压</th>"+
									"<th>电池模块466电压</th>"+
									"<th>电池模块467电压</th>"+
									"<th>电池模块468电压</th>"+
									"<th>电池模块469电压</th>"+
									"<th>电池模块470电压</th>"+
									"<th>电池模块471电压</th>"+
									"<th>电池模块472电压</th>"+
									"<th>电池模块473电压</th>"+
									"<th>电池模块474电压</th>"+
									"<th>电池模块475电压</th>"+
									"<th>电池模块476电压</th>"+
									"<th>电池模块477电压</th>"+
									"<th>电池模块478电压</th>"+
									"<th>电池模块479电压</th>"+
									"<th>电池模块480电压</th>"+
									"<th>电池模块481电压</th>"+
									"<th>电池模块482电压</th>"+
									"<th>电池模块483电压</th>"+
									"<th>电池模块484电压</th>"+
									"<th>电池模块485电压</th>"+
									"<th>电池模块486电压</th>"+
									"<th>电池模块487电压</th>"+
									"<th>电池模块488电压</th>"+
									"<th>电池模块489电压</th>"+
									"<th>电池模块490电压</th>"+
									"<th>电池模块491电压</th>"+
									"<th>电池模块492电压</th>"+
									"<th>电池模块493电压</th>"+
									"<th>电池模块494电压</th>"+
									"<th>电池模块495电压</th>"+
									"<th>电池模块496电压</th>"+
									"<th>电池模块497电压</th>"+
									"<th>电池模块498电压</th>"+
									"<th>电池模块499电压</th>"+
									"<th>电池模块500电压</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "正常停机" : lst.stat == 3 ? "告警运行":lst.stat == 4 ? "故障停机" :"";
										var statBatts = lst.statBatts ==0 ?"充电允许": lst.statBatts == 1 ? "放电允许" :lst.statBatts == 2 ? "继电器闭合" : lst.statBatts == 3 ? "充满电维护请求":lst.statBatts == 4 ? "放完电维护请求":lst.statBatts == 5 ? "熔断器断开":lst.statBatts == 6 ? "风机开启":"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+lst.statBatts+"</td>"+
										"<td>"+lst.faultCode+"</td>"+
										"<td>"+lst.tempNum+"</td>"+
										"<td>"+lst.ucellNum+"</td>"+
										"<td>"+getFixedNum5(lst.hvSN)+"</td>"+
										"<td>"+getFixedNum5(lst.mvSN)+"</td>"+
										"<td>"+getFixedNum5(lst.htSN)+"</td>"+
										"<td>"+getFixedNum5(lst.mtSN)+"</td>"+
										"<td>"+getFixedNum5(lst.udc)+"</td>"+
										"<td>"+getFixedNum5(lst.idc)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc)+"</td>"+
										"<td>"+getFixedNum5(lst.soc)+"</td>"+
										"<td>"+getFixedNum5(lst.capacity)+"</td>"+
										"<td>"+getFixedNum5(lst.chg)+"</td>"+
										"<td>"+getFixedNum5(lst.dischg)+"</td>"+
										"<td>"+getFixedNum5(lst.rechg)+"</td>"+
										"<td>"+getFixedNum5(lst.redischg)+"</td>"+
										"<td>"+getFixedNum5(lst.uHigh)+"</td>"+
										"<td>"+getFixedNum5(lst.uLow)+"</td>"+
										"<td>"+getFixedNum5(lst.tempHigh)+"</td>"+
										"<td>"+getFixedNum5(lst.tempLow)+"</td>"+
										"<td>"+getFixedNum5(lst.iChgMax)+"</td>"+
										"<td>"+getFixedNum5(lst.iDischgMax)+"</td>"+
										"<td>"+getFixedNum5(lst.tempHighLimit)+"</td>"+
										"<td>"+getFixedNum5(lst.tempLowLimit)+"</td>"+
										"<td>"+getFixedNum5(lst.uHighCell)+"</td>"+
										"<td>"+getFixedNum5(lst.ulowCell)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce111)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce112)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce113)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce114)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce115)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce116)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce117)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce118)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce119)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce120)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce121)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce122)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce123)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce124)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce125)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce126)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce127)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce128)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce129)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce130)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce131)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce132)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce133)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce134)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce135)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce136)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce137)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce138)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce139)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce140)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce141)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce142)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce143)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce144)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce145)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce146)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce147)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce148)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce149)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce150)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce151)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce152)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce153)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce154)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce155)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce156)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce157)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce158)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce159)+"</td>"+
										"<td>"+getFixedNum5(lst.tempce160)+"</td>"+

										"<td>"+getFixedNum5(lst.uce111)+"</td>"+
										"<td>"+getFixedNum5(lst.uce112)+"</td>"+
										"<td>"+getFixedNum5(lst.uce113)+"</td>"+
										"<td>"+getFixedNum5(lst.uce114)+"</td>"+
										"<td>"+getFixedNum5(lst.uce115)+"</td>"+
										"<td>"+getFixedNum5(lst.uce116)+"</td>"+
										"<td>"+getFixedNum5(lst.uce117)+"</td>"+
										"<td>"+getFixedNum5(lst.uce118)+"</td>"+
										"<td>"+getFixedNum5(lst.uce119)+"</td>"+
										"<td>"+getFixedNum5(lst.uce120)+"</td>"+
										"<td>"+getFixedNum5(lst.uce121)+"</td>"+
										"<td>"+getFixedNum5(lst.uce122)+"</td>"+
										"<td>"+getFixedNum5(lst.uce123)+"</td>"+
										"<td>"+getFixedNum5(lst.uce124)+"</td>"+
										"<td>"+getFixedNum5(lst.uce125)+"</td>"+
										"<td>"+getFixedNum5(lst.uce126)+"</td>"+
										"<td>"+getFixedNum5(lst.uce127)+"</td>"+
										"<td>"+getFixedNum5(lst.uce128)+"</td>"+
										"<td>"+getFixedNum5(lst.uce129)+"</td>"+
										"<td>"+getFixedNum5(lst.uce130)+"</td>"+
										"<td>"+getFixedNum5(lst.uce131)+"</td>"+
										"<td>"+getFixedNum5(lst.uce132)+"</td>"+
										"<td>"+getFixedNum5(lst.uce133)+"</td>"+
										"<td>"+getFixedNum5(lst.uce134)+"</td>"+
										"<td>"+getFixedNum5(lst.uce135)+"</td>"+
										"<td>"+getFixedNum5(lst.uce136)+"</td>"+
										"<td>"+getFixedNum5(lst.uce137)+"</td>"+
										"<td>"+getFixedNum5(lst.uce138)+"</td>"+
										"<td>"+getFixedNum5(lst.uce139)+"</td>"+
										"<td>"+getFixedNum5(lst.uce140)+"</td>"+
										"<td>"+getFixedNum5(lst.uce141)+"</td>"+
										"<td>"+getFixedNum5(lst.uce142)+"</td>"+
										"<td>"+getFixedNum5(lst.uce143)+"</td>"+
										"<td>"+getFixedNum5(lst.uce144)+"</td>"+
										"<td>"+getFixedNum5(lst.uce145)+"</td>"+
										"<td>"+getFixedNum5(lst.uce146)+"</td>"+
										"<td>"+getFixedNum5(lst.uce147)+"</td>"+
										"<td>"+getFixedNum5(lst.uce148)+"</td>"+
										"<td>"+getFixedNum5(lst.uce149)+"</td>"+
										"<td>"+getFixedNum5(lst.uce150)+"</td>"+
										"<td>"+getFixedNum5(lst.uce151)+"</td>"+
										"<td>"+getFixedNum5(lst.uce152)+"</td>"+
										"<td>"+getFixedNum5(lst.uce153)+"</td>"+
										"<td>"+getFixedNum5(lst.uce154)+"</td>"+
										"<td>"+getFixedNum5(lst.uce155)+"</td>"+
										"<td>"+getFixedNum5(lst.uce156)+"</td>"+
										"<td>"+getFixedNum5(lst.uce157)+"</td>"+
										"<td>"+getFixedNum5(lst.uce158)+"</td>"+
										"<td>"+getFixedNum5(lst.uce159)+"</td>"+
										"<td>"+getFixedNum5(lst.uce160)+"</td>"+
										"<td>"+getFixedNum5(lst.uce161)+"</td>"+
										"<td>"+getFixedNum5(lst.uce162)+"</td>"+
										"<td>"+getFixedNum5(lst.uce163)+"</td>"+
										"<td>"+getFixedNum5(lst.uce164)+"</td>"+
										"<td>"+getFixedNum5(lst.uce165)+"</td>"+
										"<td>"+getFixedNum5(lst.uce166)+"</td>"+
										"<td>"+getFixedNum5(lst.uce167)+"</td>"+
										"<td>"+getFixedNum5(lst.uce168)+"</td>"+
										"<td>"+getFixedNum5(lst.uce169)+"</td>"+
										"<td>"+getFixedNum5(lst.uce170)+"</td>"+
										"<td>"+getFixedNum5(lst.uce171)+"</td>"+
										"<td>"+getFixedNum5(lst.uce172)+"</td>"+
										"<td>"+getFixedNum5(lst.uce173)+"</td>"+
										"<td>"+getFixedNum5(lst.uce174)+"</td>"+
										"<td>"+getFixedNum5(lst.uce175)+"</td>"+
										"<td>"+getFixedNum5(lst.uce176)+"</td>"+
										"<td>"+getFixedNum5(lst.uce177)+"</td>"+
										"<td>"+getFixedNum5(lst.uce178)+"</td>"+
										"<td>"+getFixedNum5(lst.uce179)+"</td>"+
										"<td>"+getFixedNum5(lst.uce180)+"</td>"+
										"<td>"+getFixedNum5(lst.uce181)+"</td>"+
										"<td>"+getFixedNum5(lst.uce182)+"</td>"+
										"<td>"+getFixedNum5(lst.uce183)+"</td>"+
										"<td>"+getFixedNum5(lst.uce184)+"</td>"+
										"<td>"+getFixedNum5(lst.uce185)+"</td>"+
										"<td>"+getFixedNum5(lst.uce186)+"</td>"+
										"<td>"+getFixedNum5(lst.uce187)+"</td>"+
										"<td>"+getFixedNum5(lst.uce188)+"</td>"+
										"<td>"+getFixedNum5(lst.uce189)+"</td>"+
										"<td>"+getFixedNum5(lst.uce190)+"</td>"+
										"<td>"+getFixedNum5(lst.uce191)+"</td>"+
										"<td>"+getFixedNum5(lst.uce192)+"</td>"+
										"<td>"+getFixedNum5(lst.uce193)+"</td>"+
										"<td>"+getFixedNum5(lst.uce194)+"</td>"+
										"<td>"+getFixedNum5(lst.uce195)+"</td>"+
										"<td>"+getFixedNum5(lst.uce196)+"</td>"+
										"<td>"+getFixedNum5(lst.uce197)+"</td>"+
										"<td>"+getFixedNum5(lst.uce198)+"</td>"+
										"<td>"+getFixedNum5(lst.uce199)+"</td>"+
										"<td>"+getFixedNum5(lst.uce200)+"</td>"+
										"<td>"+getFixedNum5(lst.uce201)+"</td>"+
										"<td>"+getFixedNum5(lst.uce202)+"</td>"+
										"<td>"+getFixedNum5(lst.uce203)+"</td>"+
										"<td>"+getFixedNum5(lst.uce204)+"</td>"+
										"<td>"+getFixedNum5(lst.uce205)+"</td>"+
										"<td>"+getFixedNum5(lst.uce206)+"</td>"+
										"<td>"+getFixedNum5(lst.uce207)+"</td>"+
										"<td>"+getFixedNum5(lst.uce208)+"</td>"+
										"<td>"+getFixedNum5(lst.uce209)+"</td>"+
										"<td>"+getFixedNum5(lst.uce210)+"</td>"+
										"<td>"+getFixedNum5(lst.uce211)+"</td>"+
										"<td>"+getFixedNum5(lst.uce212)+"</td>"+
										"<td>"+getFixedNum5(lst.uce213)+"</td>"+
										"<td>"+getFixedNum5(lst.uce214)+"</td>"+
										"<td>"+getFixedNum5(lst.uce215)+"</td>"+
										"<td>"+getFixedNum5(lst.uce216)+"</td>"+
										"<td>"+getFixedNum5(lst.uce217)+"</td>"+
										"<td>"+getFixedNum5(lst.uce218)+"</td>"+
										"<td>"+getFixedNum5(lst.uce219)+"</td>"+
										"<td>"+getFixedNum5(lst.uce220)+"</td>"+
										"<td>"+getFixedNum5(lst.uce221)+"</td>"+
										"<td>"+getFixedNum5(lst.uce222)+"</td>"+
										"<td>"+getFixedNum5(lst.uce223)+"</td>"+
										"<td>"+getFixedNum5(lst.uce224)+"</td>"+
										"<td>"+getFixedNum5(lst.uce225)+"</td>"+
										"<td>"+getFixedNum5(lst.uce226)+"</td>"+
										"<td>"+getFixedNum5(lst.uce227)+"</td>"+
										"<td>"+getFixedNum5(lst.uce228)+"</td>"+
										"<td>"+getFixedNum5(lst.uce229)+"</td>"+
										"<td>"+getFixedNum5(lst.uce230)+"</td>"+
										"<td>"+getFixedNum5(lst.uce231)+"</td>"+
										"<td>"+getFixedNum5(lst.uce232)+"</td>"+
										"<td>"+getFixedNum5(lst.uce233)+"</td>"+
										"<td>"+getFixedNum5(lst.uce234)+"</td>"+
										"<td>"+getFixedNum5(lst.uce235)+"</td>"+
										"<td>"+getFixedNum5(lst.uce236)+"</td>"+
										"<td>"+getFixedNum5(lst.uce237)+"</td>"+
										"<td>"+getFixedNum5(lst.uce238)+"</td>"+
										"<td>"+getFixedNum5(lst.uce239)+"</td>"+
										"<td>"+getFixedNum5(lst.uce240)+"</td>"+
										"<td>"+getFixedNum5(lst.uce241)+"</td>"+
										"<td>"+getFixedNum5(lst.uce242)+"</td>"+
										"<td>"+getFixedNum5(lst.uce243)+"</td>"+
										"<td>"+getFixedNum5(lst.uce244)+"</td>"+
										"<td>"+getFixedNum5(lst.uce245)+"</td>"+
										"<td>"+getFixedNum5(lst.uce246)+"</td>"+
										"<td>"+getFixedNum5(lst.uce247)+"</td>"+
										"<td>"+getFixedNum5(lst.uce248)+"</td>"+
										"<td>"+getFixedNum5(lst.uce249)+"</td>"+
										"<td>"+getFixedNum5(lst.uce250)+"</td>"+
										"<td>"+getFixedNum5(lst.uce251)+"</td>"+
										"<td>"+getFixedNum5(lst.uce252)+"</td>"+
										"<td>"+getFixedNum5(lst.uce253)+"</td>"+
										"<td>"+getFixedNum5(lst.uce254)+"</td>"+
										"<td>"+getFixedNum5(lst.uce255)+"</td>"+
										"<td>"+getFixedNum5(lst.uce256)+"</td>"+
										"<td>"+getFixedNum5(lst.uce257)+"</td>"+
										"<td>"+getFixedNum5(lst.uce258)+"</td>"+
										"<td>"+getFixedNum5(lst.uce259)+"</td>"+
										"<td>"+getFixedNum5(lst.uce260)+"</td>"+
										"<td>"+getFixedNum5(lst.uce261)+"</td>"+
										"<td>"+getFixedNum5(lst.uce262)+"</td>"+
										"<td>"+getFixedNum5(lst.uce263)+"</td>"+
										"<td>"+getFixedNum5(lst.uce264)+"</td>"+
										"<td>"+getFixedNum5(lst.uce265)+"</td>"+
										"<td>"+getFixedNum5(lst.uce266)+"</td>"+
										"<td>"+getFixedNum5(lst.uce267)+"</td>"+
										"<td>"+getFixedNum5(lst.uce268)+"</td>"+
										"<td>"+getFixedNum5(lst.uce269)+"</td>"+
										"<td>"+getFixedNum5(lst.uce270)+"</td>"+
										"<td>"+getFixedNum5(lst.uce271)+"</td>"+
										"<td>"+getFixedNum5(lst.uce272)+"</td>"+
										"<td>"+getFixedNum5(lst.uce273)+"</td>"+
										"<td>"+getFixedNum5(lst.uce274)+"</td>"+
										"<td>"+getFixedNum5(lst.uce275)+"</td>"+
										"<td>"+getFixedNum5(lst.uce276)+"</td>"+
										"<td>"+getFixedNum5(lst.uce277)+"</td>"+
										"<td>"+getFixedNum5(lst.uce278)+"</td>"+
										"<td>"+getFixedNum5(lst.uce279)+"</td>"+
										"<td>"+getFixedNum5(lst.uce280)+"</td>"+
										"<td>"+getFixedNum5(lst.uce281)+"</td>"+
										"<td>"+getFixedNum5(lst.uce282)+"</td>"+
										"<td>"+getFixedNum5(lst.uce283)+"</td>"+
										"<td>"+getFixedNum5(lst.uce284)+"</td>"+
										"<td>"+getFixedNum5(lst.uce285)+"</td>"+
										"<td>"+getFixedNum5(lst.uce286)+"</td>"+
										"<td>"+getFixedNum5(lst.uce287)+"</td>"+
										"<td>"+getFixedNum5(lst.uce288)+"</td>"+
										"<td>"+getFixedNum5(lst.uce289)+"</td>"+
										"<td>"+getFixedNum5(lst.uce290)+"</td>"+
										"<td>"+getFixedNum5(lst.uce291)+"</td>"+
										"<td>"+getFixedNum5(lst.uce292)+"</td>"+
										"<td>"+getFixedNum5(lst.uce293)+"</td>"+
										"<td>"+getFixedNum5(lst.uce294)+"</td>"+
										"<td>"+getFixedNum5(lst.uce295)+"</td>"+
										"<td>"+getFixedNum5(lst.uce296)+"</td>"+
										"<td>"+getFixedNum5(lst.uce297)+"</td>"+
										"<td>"+getFixedNum5(lst.uce298)+"</td>"+
										"<td>"+getFixedNum5(lst.uce299)+"</td>"+
										"<td>"+getFixedNum5(lst.uce300)+"</td>"+
										"<td>"+getFixedNum5(lst.uce301)+"</td>"+
										"<td>"+getFixedNum5(lst.uce302)+"</td>"+
										"<td>"+getFixedNum5(lst.uce303)+"</td>"+
										"<td>"+getFixedNum5(lst.uce304)+"</td>"+
										"<td>"+getFixedNum5(lst.uce305)+"</td>"+
										"<td>"+getFixedNum5(lst.uce306)+"</td>"+
										"<td>"+getFixedNum5(lst.uce307)+"</td>"+
										"<td>"+getFixedNum5(lst.uce308)+"</td>"+
										"<td>"+getFixedNum5(lst.uce309)+"</td>"+
										"<td>"+getFixedNum5(lst.uce310)+"</td>"+
										"<td>"+getFixedNum5(lst.uce311)+"</td>"+
										"<td>"+getFixedNum5(lst.uce312)+"</td>"+
										"<td>"+getFixedNum5(lst.uce313)+"</td>"+
										"<td>"+getFixedNum5(lst.uce314)+"</td>"+
										"<td>"+getFixedNum5(lst.uce315)+"</td>"+
										"<td>"+getFixedNum5(lst.uce316)+"</td>"+
										"<td>"+getFixedNum5(lst.uce317)+"</td>"+
										"<td>"+getFixedNum5(lst.uce318)+"</td>"+
										"<td>"+getFixedNum5(lst.uce319)+"</td>"+
										"<td>"+getFixedNum5(lst.uce320)+"</td>"+
										"<td>"+getFixedNum5(lst.uce321)+"</td>"+
										"<td>"+getFixedNum5(lst.uce322)+"</td>"+
										"<td>"+getFixedNum5(lst.uce323)+"</td>"+
										"<td>"+getFixedNum5(lst.uce324)+"</td>"+
										"<td>"+getFixedNum5(lst.uce325)+"</td>"+
										"<td>"+getFixedNum5(lst.uce326)+"</td>"+
										"<td>"+getFixedNum5(lst.uce327)+"</td>"+
										"<td>"+getFixedNum5(lst.uce328)+"</td>"+
										"<td>"+getFixedNum5(lst.uce329)+"</td>"+
										"<td>"+getFixedNum5(lst.uce330)+"</td>"+
										"<td>"+getFixedNum5(lst.uce331)+"</td>"+
										"<td>"+getFixedNum5(lst.uce332)+"</td>"+
										"<td>"+getFixedNum5(lst.uce333)+"</td>"+
										"<td>"+getFixedNum5(lst.uce334)+"</td>"+
										"<td>"+getFixedNum5(lst.uce335)+"</td>"+
										"<td>"+getFixedNum5(lst.uce336)+"</td>"+
										"<td>"+getFixedNum5(lst.uce337)+"</td>"+
										"<td>"+getFixedNum5(lst.uce338)+"</td>"+
										"<td>"+getFixedNum5(lst.uce339)+"</td>"+
										"<td>"+getFixedNum5(lst.uce340)+"</td>"+
										"<td>"+getFixedNum5(lst.uce341)+"</td>"+
										"<td>"+getFixedNum5(lst.uce342)+"</td>"+
										"<td>"+getFixedNum5(lst.uce343)+"</td>"+
										"<td>"+getFixedNum5(lst.uce344)+"</td>"+
										"<td>"+getFixedNum5(lst.uce345)+"</td>"+
										"<td>"+getFixedNum5(lst.uce346)+"</td>"+
										"<td>"+getFixedNum5(lst.uce347)+"</td>"+
										"<td>"+getFixedNum5(lst.uce348)+"</td>"+
										"<td>"+getFixedNum5(lst.uce349)+"</td>"+
										"<td>"+getFixedNum5(lst.uce350)+"</td>"+
										"<td>"+getFixedNum5(lst.uce351)+"</td>"+
										"<td>"+getFixedNum5(lst.uce352)+"</td>"+
										"<td>"+getFixedNum5(lst.uce353)+"</td>"+
										"<td>"+getFixedNum5(lst.uce354)+"</td>"+
										"<td>"+getFixedNum5(lst.uce355)+"</td>"+
										"<td>"+getFixedNum5(lst.uce356)+"</td>"+
										"<td>"+getFixedNum5(lst.uce357)+"</td>"+
										"<td>"+getFixedNum5(lst.uce358)+"</td>"+
										"<td>"+getFixedNum5(lst.uce359)+"</td>"+
										"<td>"+getFixedNum5(lst.uce360)+"</td>"+
										"<td>"+getFixedNum5(lst.uce361)+"</td>"+
										"<td>"+getFixedNum5(lst.uce362)+"</td>"+
										"<td>"+getFixedNum5(lst.uce363)+"</td>"+
										"<td>"+getFixedNum5(lst.uce364)+"</td>"+
										"<td>"+getFixedNum5(lst.uce365)+"</td>"+
										"<td>"+getFixedNum5(lst.uce366)+"</td>"+
										"<td>"+getFixedNum5(lst.uce367)+"</td>"+
										"<td>"+getFixedNum5(lst.uce368)+"</td>"+
										"<td>"+getFixedNum5(lst.uce369)+"</td>"+
										"<td>"+getFixedNum5(lst.uce370)+"</td>"+
										"<td>"+getFixedNum5(lst.uce371)+"</td>"+
										"<td>"+getFixedNum5(lst.uce372)+"</td>"+
										"<td>"+getFixedNum5(lst.uce373)+"</td>"+
										"<td>"+getFixedNum5(lst.uce374)+"</td>"+
										"<td>"+getFixedNum5(lst.uce375)+"</td>"+
										"<td>"+getFixedNum5(lst.uce376)+"</td>"+
										"<td>"+getFixedNum5(lst.uce377)+"</td>"+
										"<td>"+getFixedNum5(lst.uce378)+"</td>"+
										"<td>"+getFixedNum5(lst.uce379)+"</td>"+
										"<td>"+getFixedNum5(lst.uce380)+"</td>"+
										"<td>"+getFixedNum5(lst.uce381)+"</td>"+
										"<td>"+getFixedNum5(lst.uce382)+"</td>"+
										"<td>"+getFixedNum5(lst.uce383)+"</td>"+
										"<td>"+getFixedNum5(lst.uce384)+"</td>"+
										"<td>"+getFixedNum5(lst.uce385)+"</td>"+
										"<td>"+getFixedNum5(lst.uce386)+"</td>"+
										"<td>"+getFixedNum5(lst.uce387)+"</td>"+
										"<td>"+getFixedNum5(lst.uce388)+"</td>"+
										"<td>"+getFixedNum5(lst.uce389)+"</td>"+
										"<td>"+getFixedNum5(lst.uce390)+"</td>"+
										"<td>"+getFixedNum5(lst.uce391)+"</td>"+
										"<td>"+getFixedNum5(lst.uce392)+"</td>"+
										"<td>"+getFixedNum5(lst.uce393)+"</td>"+
										"<td>"+getFixedNum5(lst.uce394)+"</td>"+
										"<td>"+getFixedNum5(lst.uce395)+"</td>"+
										"<td>"+getFixedNum5(lst.uce396)+"</td>"+
										"<td>"+getFixedNum5(lst.uce397)+"</td>"+
										"<td>"+getFixedNum5(lst.uce398)+"</td>"+
										"<td>"+getFixedNum5(lst.uce399)+"</td>"+
										"<td>"+getFixedNum5(lst.uce400)+"</td>"+
										"<td>"+getFixedNum5(lst.uce401)+"</td>"+
										"<td>"+getFixedNum5(lst.uce402)+"</td>"+
										"<td>"+getFixedNum5(lst.uce403)+"</td>"+
										"<td>"+getFixedNum5(lst.uce404)+"</td>"+
										"<td>"+getFixedNum5(lst.uce405)+"</td>"+
										"<td>"+getFixedNum5(lst.uce406)+"</td>"+
										"<td>"+getFixedNum5(lst.uce407)+"</td>"+
										"<td>"+getFixedNum5(lst.uce408)+"</td>"+
										"<td>"+getFixedNum5(lst.uce409)+"</td>"+
										"<td>"+getFixedNum5(lst.uce410)+"</td>"+
										"<td>"+getFixedNum5(lst.uce411)+"</td>"+
										"<td>"+getFixedNum5(lst.uce412)+"</td>"+
										"<td>"+getFixedNum5(lst.uce413)+"</td>"+
										"<td>"+getFixedNum5(lst.uce414)+"</td>"+
										"<td>"+getFixedNum5(lst.uce415)+"</td>"+
										"<td>"+getFixedNum5(lst.uce416)+"</td>"+
										"<td>"+getFixedNum5(lst.uce417)+"</td>"+
										"<td>"+getFixedNum5(lst.uce418)+"</td>"+
										"<td>"+getFixedNum5(lst.uce419)+"</td>"+
										"<td>"+getFixedNum5(lst.uce420)+"</td>"+
										"<td>"+getFixedNum5(lst.uce421)+"</td>"+
										"<td>"+getFixedNum5(lst.uce422)+"</td>"+
										"<td>"+getFixedNum5(lst.uce423)+"</td>"+
										"<td>"+getFixedNum5(lst.uce424)+"</td>"+
										"<td>"+getFixedNum5(lst.uce425)+"</td>"+
										"<td>"+getFixedNum5(lst.uce426)+"</td>"+
										"<td>"+getFixedNum5(lst.uce427)+"</td>"+
										"<td>"+getFixedNum5(lst.uce428)+"</td>"+
										"<td>"+getFixedNum5(lst.uce429)+"</td>"+
										"<td>"+getFixedNum5(lst.uce430)+"</td>"+
										"<td>"+getFixedNum5(lst.uce431)+"</td>"+
										"<td>"+getFixedNum5(lst.uce432)+"</td>"+
										"<td>"+getFixedNum5(lst.uce433)+"</td>"+
										"<td>"+getFixedNum5(lst.uce434)+"</td>"+
										"<td>"+getFixedNum5(lst.uce435)+"</td>"+
										"<td>"+getFixedNum5(lst.uce436)+"</td>"+
										"<td>"+getFixedNum5(lst.uce437)+"</td>"+
										"<td>"+getFixedNum5(lst.uce438)+"</td>"+
										"<td>"+getFixedNum5(lst.uce439)+"</td>"+
										"<td>"+getFixedNum5(lst.uce440)+"</td>"+
										"<td>"+getFixedNum5(lst.uce441)+"</td>"+
										"<td>"+getFixedNum5(lst.uce442)+"</td>"+
										"<td>"+getFixedNum5(lst.uce443)+"</td>"+
										"<td>"+getFixedNum5(lst.uce444)+"</td>"+
										"<td>"+getFixedNum5(lst.uce445)+"</td>"+
										"<td>"+getFixedNum5(lst.uce446)+"</td>"+
										"<td>"+getFixedNum5(lst.uce447)+"</td>"+
										"<td>"+getFixedNum5(lst.uce448)+"</td>"+
										"<td>"+getFixedNum5(lst.uce449)+"</td>"+
										"<td>"+getFixedNum5(lst.uce450)+"</td>"+
										"<td>"+getFixedNum5(lst.uce451)+"</td>"+
										"<td>"+getFixedNum5(lst.uce452)+"</td>"+
										"<td>"+getFixedNum5(lst.uce453)+"</td>"+
										"<td>"+getFixedNum5(lst.uce454)+"</td>"+
										"<td>"+getFixedNum5(lst.uce455)+"</td>"+
										"<td>"+getFixedNum5(lst.uce456)+"</td>"+
										"<td>"+getFixedNum5(lst.uce457)+"</td>"+
										"<td>"+getFixedNum5(lst.uce458)+"</td>"+
										"<td>"+getFixedNum5(lst.uce459)+"</td>"+
										"<td>"+getFixedNum5(lst.uce460)+"</td>"+
										"<td>"+getFixedNum5(lst.uce461)+"</td>"+
										"<td>"+getFixedNum5(lst.uce462)+"</td>"+
										"<td>"+getFixedNum5(lst.uce463)+"</td>"+
										"<td>"+getFixedNum5(lst.uce464)+"</td>"+
										"<td>"+getFixedNum5(lst.uce465)+"</td>"+
										"<td>"+getFixedNum5(lst.uce466)+"</td>"+
										"<td>"+getFixedNum5(lst.uce467)+"</td>"+
										"<td>"+getFixedNum5(lst.uce468)+"</td>"+
										"<td>"+getFixedNum5(lst.uce469)+"</td>"+
										"<td>"+getFixedNum5(lst.uce470)+"</td>"+
										"<td>"+getFixedNum5(lst.uce471)+"</td>"+
										"<td>"+getFixedNum5(lst.uce472)+"</td>"+
										"<td>"+getFixedNum5(lst.uce473)+"</td>"+
										"<td>"+getFixedNum5(lst.uce474)+"</td>"+
										"<td>"+getFixedNum5(lst.uce475)+"</td>"+
										"<td>"+getFixedNum5(lst.uce476)+"</td>"+
										"<td>"+getFixedNum5(lst.uce477)+"</td>"+
										"<td>"+getFixedNum5(lst.uce478)+"</td>"+
										"<td>"+getFixedNum5(lst.uce479)+"</td>"+
										"<td>"+getFixedNum5(lst.uce480)+"</td>"+
										"<td>"+getFixedNum5(lst.uce481)+"</td>"+
										"<td>"+getFixedNum5(lst.uce482)+"</td>"+
										"<td>"+getFixedNum5(lst.uce483)+"</td>"+
										"<td>"+getFixedNum5(lst.uce484)+"</td>"+
										"<td>"+getFixedNum5(lst.uce485)+"</td>"+
										"<td>"+getFixedNum5(lst.uce486)+"</td>"+
										"<td>"+getFixedNum5(lst.uce487)+"</td>"+
										"<td>"+getFixedNum5(lst.uce488)+"</td>"+
										"<td>"+getFixedNum5(lst.uce489)+"</td>"+
										"<td>"+getFixedNum5(lst.uce490)+"</td>"+
										"<td>"+getFixedNum5(lst.uce491)+"</td>"+
										"<td>"+getFixedNum5(lst.uce492)+"</td>"+
										"<td>"+getFixedNum5(lst.uce493)+"</td>"+
										"<td>"+getFixedNum5(lst.uce494)+"</td>"+
										"<td>"+getFixedNum5(lst.uce495)+"</td>"+
										"<td>"+getFixedNum5(lst.uce496)+"</td>"+
										"<td>"+getFixedNum5(lst.uce497)+"</td>"+
										"<td>"+getFixedNum5(lst.uce498)+"</td>"+
										"<td>"+getFixedNum5(lst.uce499)+"</td>"+
										"<td>"+getFixedNum5(lst.uce500)+"</td>"+
										"<td>"+getFixedNum5(lst.uce501)+"</td>"+
										"<td>"+getFixedNum5(lst.uce502)+"</td>"+
										"<td>"+getFixedNum5(lst.uce503)+"</td>"+
										"<td>"+getFixedNum5(lst.uce504)+"</td>"+
										"<td>"+getFixedNum5(lst.uce505)+"</td>"+
										"<td>"+getFixedNum5(lst.uce506)+"</td>"+
										"<td>"+getFixedNum5(lst.uce507)+"</td>"+
										"<td>"+getFixedNum5(lst.uce508)+"</td>"+
										"<td>"+getFixedNum5(lst.uce509)+"</td>"+
										"<td>"+getFixedNum5(lst.uce510)+"</td>"+
										"<td>"+getFixedNum5(lst.uce511)+"</td>"+
										"<td>"+getFixedNum5(lst.uce512)+"</td>"+
										"<td>"+getFixedNum5(lst.uce513)+"</td>"+
										"<td>"+getFixedNum5(lst.uce514)+"</td>"+
										"<td>"+getFixedNum5(lst.uce515)+"</td>"+
										"<td>"+getFixedNum5(lst.uce516)+"</td>"+
										"<td>"+getFixedNum5(lst.uce517)+"</td>"+
										"<td>"+getFixedNum5(lst.uce518)+"</td>"+
										"<td>"+getFixedNum5(lst.uce519)+"</td>"+
										"<td>"+getFixedNum5(lst.uce520)+"</td>"+
										"<td>"+getFixedNum5(lst.uce521)+"</td>"+
										"<td>"+getFixedNum5(lst.uce522)+"</td>"+
										"<td>"+getFixedNum5(lst.uce523)+"</td>"+
										"<td>"+getFixedNum5(lst.uce524)+"</td>"+
										"<td>"+getFixedNum5(lst.uce525)+"</td>"+
										"<td>"+getFixedNum5(lst.uce526)+"</td>"+
										"<td>"+getFixedNum5(lst.uce527)+"</td>"+
										"<td>"+getFixedNum5(lst.uce528)+"</td>"+
										"<td>"+getFixedNum5(lst.uce529)+"</td>"+
										"<td>"+getFixedNum5(lst.uce530)+"</td>"+
										"<td>"+getFixedNum5(lst.uce531)+"</td>"+
										"<td>"+getFixedNum5(lst.uce532)+"</td>"+
										"<td>"+getFixedNum5(lst.uce533)+"</td>"+
										"<td>"+getFixedNum5(lst.uce534)+"</td>"+
										"<td>"+getFixedNum5(lst.uce535)+"</td>"+
										"<td>"+getFixedNum5(lst.uce536)+"</td>"+
										"<td>"+getFixedNum5(lst.uce537)+"</td>"+
										"<td>"+getFixedNum5(lst.uce538)+"</td>"+
										"<td>"+getFixedNum5(lst.uce539)+"</td>"+
										"<td>"+getFixedNum5(lst.uce540)+"</td>"+
										"<td>"+getFixedNum5(lst.uce541)+"</td>"+
										"<td>"+getFixedNum5(lst.uce542)+"</td>"+
										"<td>"+getFixedNum5(lst.uce543)+"</td>"+
										"<td>"+getFixedNum5(lst.uce544)+"</td>"+
										"<td>"+getFixedNum5(lst.uce545)+"</td>"+
										"<td>"+getFixedNum5(lst.uce546)+"</td>"+
										"<td>"+getFixedNum5(lst.uce547)+"</td>"+
										"<td>"+getFixedNum5(lst.uce548)+"</td>"+
										"<td>"+getFixedNum5(lst.uce549)+"</td>"+
										"<td>"+getFixedNum5(lst.uce550)+"</td>"+
										"<td>"+getFixedNum5(lst.uce551)+"</td>"+
										"<td>"+getFixedNum5(lst.uce552)+"</td>"+
										"<td>"+getFixedNum5(lst.uce553)+"</td>"+
										"<td>"+getFixedNum5(lst.uce554)+"</td>"+
										"<td>"+getFixedNum5(lst.uce555)+"</td>"+
										"<td>"+getFixedNum5(lst.uce556)+"</td>"+
										"<td>"+getFixedNum5(lst.uce557)+"</td>"+
										"<td>"+getFixedNum5(lst.uce558)+"</td>"+
										"<td>"+getFixedNum5(lst.uce559)+"</td>"+
										"<td>"+getFixedNum5(lst.uce560)+"</td>"+
										"<td>"+getFixedNum5(lst.uce561)+"</td>"+
										"<td>"+getFixedNum5(lst.uce562)+"</td>"+
										"<td>"+getFixedNum5(lst.uce563)+"</td>"+
										"<td>"+getFixedNum5(lst.uce564)+"</td>"+
										"<td>"+getFixedNum5(lst.uce565)+"</td>"+
										"<td>"+getFixedNum5(lst.uce566)+"</td>"+
										"<td>"+getFixedNum5(lst.uce567)+"</td>"+
										"<td>"+getFixedNum5(lst.uce568)+"</td>"+
										"<td>"+getFixedNum5(lst.uce569)+"</td>"+
										"<td>"+getFixedNum5(lst.uce570)+"</td>"+
										"<td>"+getFixedNum5(lst.uce571)+"</td>"+
										"<td>"+getFixedNum5(lst.uce572)+"</td>"+
										"<td>"+getFixedNum5(lst.uce573)+"</td>"+
										"<td>"+getFixedNum5(lst.uce574)+"</td>"+
										"<td>"+getFixedNum5(lst.uce575)+"</td>"+
										"<td>"+getFixedNum5(lst.uce576)+"</td>"+
										"<td>"+getFixedNum5(lst.uce577)+"</td>"+
										"<td>"+getFixedNum5(lst.uce578)+"</td>"+
										"<td>"+getFixedNum5(lst.uce579)+"</td>"+
										"<td>"+getFixedNum5(lst.uce580)+"</td>"+
										"<td>"+getFixedNum5(lst.uce581)+"</td>"+
										"<td>"+getFixedNum5(lst.uce582)+"</td>"+
										"<td>"+getFixedNum5(lst.uce583)+"</td>"+
										"<td>"+getFixedNum5(lst.uce584)+"</td>"+
										"<td>"+getFixedNum5(lst.uce585)+"</td>"+
										"<td>"+getFixedNum5(lst.uce586)+"</td>"+
										"<td>"+getFixedNum5(lst.uce587)+"</td>"+
										"<td>"+getFixedNum5(lst.uce588)+"</td>"+
										"<td>"+getFixedNum5(lst.uce589)+"</td>"+
										"<td>"+getFixedNum5(lst.uce590)+"</td>"+
										"<td>"+getFixedNum5(lst.uce591)+"</td>"+
										"<td>"+getFixedNum5(lst.uce592)+"</td>"+
										"<td>"+getFixedNum5(lst.uce593)+"</td>"+
										"<td>"+getFixedNum5(lst.uce594)+"</td>"+
										"<td>"+getFixedNum5(lst.uce595)+"</td>"+
										"<td>"+getFixedNum5(lst.uce596)+"</td>"+
										"<td>"+getFixedNum5(lst.uce597)+"</td>"+
										"<td>"+getFixedNum5(lst.uce598)+"</td>"+
										"<td>"+getFixedNum5(lst.uce599)+"</td>"+
										"<td>"+getFixedNum5(lst.uce600)+"</td>"+
										"<td>"+getFixedNum5(lst.uce601)+"</td>"+
										"<td>"+getFixedNum5(lst.uce602)+"</td>"+
										"<td>"+getFixedNum5(lst.uce603)+"</td>"+
										"<td>"+getFixedNum5(lst.uce604)+"</td>"+
										"<td>"+getFixedNum5(lst.uce605)+"</td>"+
										"<td>"+getFixedNum5(lst.uce606)+"</td>"+
										"<td>"+getFixedNum5(lst.uce607)+"</td>"+
										"<td>"+getFixedNum5(lst.uce608)+"</td>"+
										"<td>"+getFixedNum5(lst.uce609)+"</td>"+
										"<td>"+getFixedNum5(lst.uce610)+"</td>"+

										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "HJJCY"){
	    						 html="<tr>"+
	    						 	"<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>水平面瞬时辐射</th>"+
									"<th>水平面总辐射量</th>"+
									"<th>倾斜面瞬时辐射</th>"+
									"<th>倾斜面总辐射量</th>"+
									"<th>环境温度</th>"+
									"<th>环境湿度</th>"+
									"<th>组件温度</th>"+
									"<th>风速</th>"+
									"<th>风向</th>"+
									"<th>大气压力</th>"+
									"<th>平均风速</th>"+
									"<th>平均气温</th>"+
									"<th>平均湿度</th>"+
									"<th>累计日照时数</th>"+
									"<th>日照时数</th>"+
									"<th>峰值日照时数</th>"+
									"<th>0-100W/m2辐射量</th>"+
									"<th>100-200W/m2辐射量</th>"+
									"<th>200-300W/m2辐射量</th>"+
									"<th>300-400W/m2辐射量</th>"+
									"<th>400-500W/m2辐射量</th>"+
									"<th>500-600W/m2辐射量</th>"+
									"<th>600-700W/m2辐射量</th>"+
									"<th>700-800W/m2辐射量</th>"+
									"<th>800-900W/m2辐射量</th>"+
									"<th>900-1000W/m2辐射量</th>"+
									"<th>大于1000W/m2辐射量</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getFixedNum5(lst.hgv)+"</td>"+
										"<td>"+getFixedNum5(lst.hg)+"</td>"+
										"<td>"+getFixedNum5(lst.htv)+"</td>"+
										"<td>"+getFixedNum5(lst.ht)+"</td>"+
										"<td>"+getFixedNum5(lst.temp)+"</td>"+
										"<td>"+getFixedNum5(lst.humi)+"</td>"+
										"<td>"+getFixedNum5(lst.tempPV)+"</td>"+
										"<td>"+getFixedNum5(lst.windSpeed)+"</td>"+
										"<td>"+getFixedNum5(lst.windDir)+"</td>"+
										"<td>"+getFixedNum5(lst.air)+"</td>"+
										"<td>"+getFixedNum5(lst.vmean)+"</td>"+
										"<td>"+getFixedNum5(lst.tammean)+"</td>"+
										"<td>"+getFixedNum5(lst.rh)+"</td>"+
										"<td>"+getFixedNum5(lst.accHs)+"</td>"+
										"<td>"+getFixedNum5(lst.hs)+"</td>"+
										"<td>"+getFixedNum5(lst.pekHs)+"</td>"+
										"<td>"+lst['rad0-100W-2m']+"</td>"+
										"<td>"+lst['rad100-200W-2m']+"</td>"+
										"<td>"+lst['rad200-300W-2m']+"</td>"+
										"<td>"+lst['rad300-400W-2m']+"</td>"+
										"<td>"+lst['rad400-500W-2m']+"</td>"+
										"<td>"+lst['rad500-600W-2m']+"</td>"+
										"<td>"+lst['rad600-700W-2m']+"</td>"+
										"<td>"+lst['rad700-800W-2m']+"</td>"+
										"<td>"+lst['rad800-900W-2m']+"</td>"+
										"<td>"+lst['rad900-1000W-2m']+"</td>"+
										"<td>"+lst['rad1000W-2mThan']+"</td>"+ 
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "DCDC"){
	    						 html="<tr>"+
	    						 	"<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>工作状态</th>"+
									"<th>工作模式</th>"+
									"<th>告警码</th>"+
									"<th>高压侧电压</th>"+
									"<th>高压侧电流</th>"+
									"<th>高压侧功率</th>"+
									"<th>低压侧电压</th>"+
									"<th>低压侧电流</th>"+
									"<th>低压侧功率</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "正常停机" : lst.stat == 3 ? "告警运行":lst.stat == 4 ? "故障停机" :"";
										var workStat = lst.workStat == 0 ?"停止": lst.workStat == 1 ? "故障" :lst.workStat == 2 ? "充电" : lst.workStat == 3 ? "待机":lst.workStat == 4 ? "放电" :"";
										var mode = lst.mode == 0 ?"恒流模式": lst.mode == 1 ? "恒压模式" :lst.mode == 2 ? "恒功率模式" : lst.mode == 3 ? "下垂模式":lst.mode == 4 ? "MPPT" :lst.mode == 5 ? "负荷模式" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+workStat+"</td>"+
										"<td>"+mode+"</td>"+
										"<td>"+getIsNull(lst.faultCode)+"</td>"+
										"<td>"+getFixedNum5(lst.uHigh)+"</td>"+
										"<td>"+getFixedNum5(lst.iHigh)+"</td>"+
										"<td>"+getFixedNum5(lst.pHigh)+"</td>"+
										"<td>"+getFixedNum5(lst.uLow)+"</td>"+
										"<td>"+getFixedNum5(lst.iLow)+"</td>"+
										"<td>"+getFixedNum5(lst.pLow)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "BYQ"){
	    						 html="<tr>"+
	    						 	"<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>绕组数量</th>"+
									"<th>Uab线电压</th>"+
									"<th>Ubc线电压</th>"+
									"<th>Uca线电压</th>"+
									"<th>A相电压</th>"+
									"<th>B相电压</th>"+
									"<th>C相电压</th>"+
									"<th>A相电流</th>"+
									"<th>B相电流</th>"+
									"<th>C相电流</th>"+
									"<th>有功功率</th>"+
									"<th>无功功率</th>"+
									"<th>频率</th>"+
									"<th>功率因数</th>"+
									"<th>A相温度</th>"+
									"<th>B相温度</th>"+
									"<th>C相温度</th>"+
									"<th>温度</th>"+
									"<th>正向有功电度</th>"+
									"<th>正向无功电度</th>"+
									"<th>反向有功电度</th>"+
									"<th>反向无功电度</th>"+
									"<th>Uab线电压</th>"+
									"<th>Ubc线电压</th>"+
									"<th>Uca线电压</th>"+
									"<th>A相电压</th>"+
									"<th>B相电压</th>"+
									"<th>C相电压</th>"+
									"<th>A相电流</th>"+
									"<th>B相电流</th>"+
									"<th>C相电流</th>"+
									"<th>有功功率</th>"+
									"<th>无功功率</th>"+
									"<th>频率</th>"+
									"<th>功率因数</th>"+
									"<th>A相温度</th>"+
									"<th>B相温度</th>"+
									"<th>C相温度</th>"+
									"<th>温度</th>"+
									"<th>正向有功电度</th>"+
									"<th>正向无功电度</th>"+
									"<th>反向有功电度</th>"+
									"<th>反向无功电度</th>"+
									"<th>Uab线电压</th>"+
									"<th>Ubc线电压</th>"+
									"<th>Uca线电压</th>"+
									"<th>A相电压</th>"+
									"<th>B相电压</th>"+
									"<th>C相电压</th>"+
									"<th>A相电流</th>"+
									"<th>B相电流</th>"+
									"<th>C相电流</th>"+
									"<th>有功功率</th>"+
									"<th>无功功率</th>"+
									"<th>频率</th>"+
									"<th>功率因数</th>"+
									"<th>A相温度</th>"+
									"<th>B相温度</th>"+
									"<th>C相温度</th>"+
									"<th>温度</th>"+
									"<th>正向有功电度</th>"+
									"<th>正向无功电度</th>"+
									"<th>反向有功电度</th>"+
									"<th>反向无功电度</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "设备告警" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getFixedNum5(lst.branchNum)+"</td>"+
										"<td>"+getFixedNum5(lst.uab1)+"</td>"+
										"<td>"+getFixedNum5(lst.ubc1)+"</td>"+
										"<td>"+getFixedNum5(lst.uca1)+"</td>"+
										"<td>"+getFixedNum5(lst.ua1)+"</td>"+
										"<td>"+getFixedNum5(lst.ub1)+"</td>"+
										"<td>"+getFixedNum5(lst.uc1)+"</td>"+
										"<td>"+getFixedNum5(lst.ia1)+"</td>"+
										"<td>"+getFixedNum5(lst.ib1)+"</td>"+
										"<td>"+getFixedNum5(lst.ic1)+"</td>"+
										"<td>"+getFixedNum5(lst.psum1)+"</td>"+
										"<td>"+getFixedNum5(lst.qsum1)+"</td>"+
										"<td>"+getFixedNum5(lst.freq1)+"</td>"+
										"<td>"+getFixedNum5(lst.pf1)+"</td>"+
										"<td>"+getFixedNum5(lst.tempa1)+"</td>"+
										"<td>"+getFixedNum5(lst.tempb1)+"</td>"+
										"<td>"+getFixedNum5(lst.tempc1)+"</td>"+
										"<td>"+getFixedNum5(lst.temp1)+"</td>"+
										"<td>"+getFixedNum5(lst.phi1)+"</td>"+
										"<td>"+getFixedNum5(lst.qhi1)+"</td>"+
										"<td>"+getFixedNum5(lst.phe1)+"</td>"+
										"<td>"+getFixedNum5(lst.qhe1)+"</td>"+
										"<td>"+getFixedNum5(lst.uab2)+"</td>"+
										"<td>"+getFixedNum5(lst.ubc2)+"</td>"+
										"<td>"+getFixedNum5(lst.uca2)+"</td>"+
										"<td>"+getFixedNum5(lst.ua2)+"</td>"+
										"<td>"+getFixedNum5(lst.ub2)+"</td>"+
										"<td>"+getFixedNum5(lst.uc2)+"</td>"+
										"<td>"+getFixedNum5(lst.ia2)+"</td>"+
										"<td>"+getFixedNum5(lst.ib2)+"</td>"+
										"<td>"+getFixedNum5(lst.ic2)+"</td>"+
										"<td>"+getFixedNum5(lst.psum2)+"</td>"+
										"<td>"+getFixedNum5(lst.qsum2)+"</td>"+
										"<td>"+getFixedNum5(lst.freq2)+"</td>"+
										"<td>"+getFixedNum5(lst.pf2)+"</td>"+
										"<td>"+getFixedNum5(lst.tempa2)+"</td>"+
										"<td>"+getFixedNum5(lst.tempb2)+"</td>"+
										"<td>"+getFixedNum5(lst.tempc2)+"</td>"+
										"<td>"+getFixedNum5(lst.temp2)+"</td>"+
										"<td>"+getFixedNum5(lst.phi2)+"</td>"+
										"<td>"+getFixedNum5(lst.qhi2)+"</td>"+
										"<td>"+getFixedNum5(lst.phe2)+"</td>"+
										"<td>"+getFixedNum5(lst.qhe2)+"</td>"+
										"<td>"+getFixedNum5(lst.uab3)+"</td>"+
										"<td>"+getFixedNum5(lst.ubc3)+"</td>"+
										"<td>"+getFixedNum5(lst.uca3)+"</td>"+
										"<td>"+getFixedNum5(lst.ua3)+"</td>"+
										"<td>"+getFixedNum5(lst.ub3)+"</td>"+
										"<td>"+getFixedNum5(lst.uc3)+"</td>"+
										"<td>"+getFixedNum5(lst.ia3)+"</td>"+
										"<td>"+getFixedNum5(lst.ib3)+"</td>"+
										"<td>"+getFixedNum5(lst.ic3)+"</td>"+
										"<td>"+getFixedNum5(lst.psum3)+"</td>"+
										"<td>"+getFixedNum5(lst.qsum3)+"</td>"+
										"<td>"+getFixedNum5(lst.freq3)+"</td>"+
										"<td>"+getFixedNum5(lst.pf3)+"</td>"+
										"<td>"+getFixedNum5(lst.tempa3)+"</td>"+
										"<td>"+getFixedNum5(lst.tempb3)+"</td>"+
										"<td>"+getFixedNum5(lst.tempc3)+"</td>"+
										"<td>"+getFixedNum5(lst.temp3)+"</td>"+
										"<td>"+getFixedNum5(lst.phi3)+"</td>"+
										"<td>"+getFixedNum5(lst.qhi3)+"</td>"+
										"<td>"+getFixedNum5(lst.phe3)+"</td>"+
										"<td>"+getFixedNum5(lst.qhe3)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "DB"){
	    						 html="<tr>"+
	    						 	"<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>电压变比</th>"+
									"<th>电流变比</th>"+
									"<th>Uab线电压</th>"+
									"<th>Ubc线电压</th>"+
									"<th>Uca线电压</th>"+
									"<th>A相电压</th>"+
									"<th>B相电压</th>"+
									"<th>C相电压</th>"+
									"<th>A相电流</th>"+
									"<th>B相电流</th>"+
									"<th>C相电流</th>"+
									"<th>A相有功</th>"+
									"<th>B相有功</th>"+
									"<th>C相有功</th>"+
									"<th>有功功率</th>"+
									"<th>无功功率</th>"+
									"<th>视在功率</th>"+
									"<th>正向有功电度表值</th>"+
									"<th>反向有功电度表值</th>"+
									"<th>正向无功电度表值</th>"+
									"<th>反向无功电度表值</th>"+
									"<th>正向有功电度</th>"+
									"<th>反向有功电度</th>"+
									"<th>正向无功电度</th>"+
									"<th>反向无功电度</th>"+
									"<th>峰正向有功电度</th>"+
									"<th>峰反向有功电度</th>"+
									"<th>峰正向无功电度</th>"+
									"<th>峰反向无功电度</th>"+
									"<th>谷正向有功电度</th>"+
									"<th>谷反向有功电度</th>"+
									"<th>谷正向无功电度</th>"+
									"<th>谷反向无功电度</th>"+
									"<th>平正向有功电度</th>"+
									"<th>平反向有功电度</th>"+
									"<th>平正向无功电度</th>"+
									"<th>平反向无功电度</th>"+
									"<th>尖正向有功电度</th>"+
									"<th>尖反向有功电度</th>"+
									"<th>尖正向无功电度</th>"+
									"<th>尖反向无功电度</th>"+
									"<th>频率</th>"+
									"<th>功率因数</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getFixedNum5(lst.pt)+"</td>"+
										"<td>"+getFixedNum5(lst.ct)+"</td>"+
										"<td>"+getFixedNum5(lst.uab)+"</td>"+
										"<td>"+getFixedNum5(lst.ubc)+"</td>"+
										"<td>"+getFixedNum5(lst.uca)+"</td>"+
										"<td>"+getFixedNum5(lst.ua)+"</td>"+
										"<td>"+getFixedNum5(lst.ub)+"</td>"+
										"<td>"+getFixedNum5(lst.uc)+"</td>"+
										"<td>"+getFixedNum5(lst.ia)+"</td>"+
										"<td>"+getFixedNum5(lst.ib)+"</td>"+
										"<td>"+getFixedNum5(lst.ic)+"</td>"+
										"<td>"+getFixedNum5(lst.pa)+"</td>"+
										"<td>"+getFixedNum5(lst.pb)+"</td>"+
										"<td>"+getFixedNum5(lst.pc)+"</td>"+
										"<td>"+getFixedNum5(lst.psum)+"</td>"+
										"<td>"+getFixedNum5(lst.qsum)+"</td>"+
										"<td>"+getFixedNum5(lst.ssum)+"</td>"+
										"<td>"+getFixedNum5(lst.phiValue)+"</td>"+
										"<td>"+getFixedNum5(lst.pheValue)+"</td>"+
										"<td>"+getFixedNum5(lst.qhiValue)+"</td>"+
										"<td>"+getFixedNum5(lst.qheValue)+"</td>"+
										"<td>"+getFixedNum5(lst.phi)+"</td>"+
										"<td>"+getFixedNum5(lst.phe)+"</td>"+
										"<td>"+getFixedNum5(lst.qhi)+"</td>"+
										"<td>"+getFixedNum5(lst.qhe)+"</td>"+
										"<td>"+getFixedNum5(lst.phiTop)+"</td>"+
										"<td>"+getFixedNum5(lst.pheTop)+"</td>"+
										"<td>"+getFixedNum5(lst.qhiTop)+"</td>"+
										"<td>"+getFixedNum5(lst.qheTop)+"</td>"+
										"<td>"+getFixedNum5(lst.phiVal)+"</td>"+
										"<td>"+getFixedNum5(lst.pheVal)+"</td>"+
										"<td>"+getFixedNum5(lst.qhiVal)+"</td>"+
										"<td>"+getFixedNum5(lst.qheVal)+"</td>"+
										"<td>"+getFixedNum5(lst.phiFlat)+"</td>"+
										"<td>"+getFixedNum5(lst.pheFlat)+"</td>"+
										"<td>"+getFixedNum5(lst.qhiFlat)+"</td>"+
										"<td>"+getFixedNum5(lst.qheFlat)+"</td>"+
										"<td>"+getFixedNum5(lst.phiPeak)+"</td>"+
										"<td>"+getFixedNum5(lst.phePeak)+"</td>"+
										"<td>"+getFixedNum5(lst.qhiPeak)+"</td>"+
										"<td>"+getFixedNum5(lst.qhePeak)+"</td>"+
										"<td>"+getFixedNum5(lst.freq)+"</td>"+
										"<td>"+getFixedNum5(lst.pf)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "DNZLJCZZ"){
	    						 html="<tr>"+
	    							 "<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>Uab线电压</th>"+
									"<th>Ubc线电压</th>"+
									"<th>Uca线电压</th>"+
									"<th>A相电压</th>"+
									"<th>B相电压</th>"+
									"<th>C相电压</th>"+
									"<th>A相基波电压</th>"+
									"<th>B相基波电压</th>"+
									"<th>C相基波电压</th>"+
									"<th>A相电流</th>"+
									"<th>B相电流</th>"+
									"<th>C相电流</th>"+
									"<th>A相基波电流</th>"+
									"<th>B相基波电流</th>"+
									"<th>C相基波电流</th>"+
									"<th>A相真有功</th>"+
									"<th>B相真有功</th>"+
									"<th>C相真有功</th>"+
									"<th>A相基波有功</th>"+
									"<th>B相基波有功</th>"+
									"<th>C相基波有功</th>"+
									"<th>有功功率</th>"+
									"<th>A相真无功</th>"+
									"<th>B相真无功</th>"+
									"<th>C相真无功</th>"+
									"<th>A相基波无功</th>"+
									"<th>B相基波无功</th>"+
									"<th>C相基波无功</th>"+
									"<th>无功功率</th>"+
									"<th>正向有功电能</th>"+
									"<th>反向有功电能</th>"+
									"<th>正向无功电能</th>"+
									"<th>反向无功电能</th>"+
									"<th>A相功率因数</th>"+
									"<th>B相功率因数</th>"+
									"<th>C相功率因数</th>"+
									"<th>功率因数</th>"+
									"<th>频率</th>"+
									"<th>正序电压</th>"+
									"<th>负序电压</th>"+
									"<th>零序电压</th>"+
									"<th>正序电流</th>"+
									"<th>负序电流</th>"+
									"<th>零序电流</th>"+
									"<th>电压不平衡度</th>"+
									"<th>电流不平衡度</th>"+
									"<th>A相电压波动</th>"+
									"<th>B相电压波动</th>"+
									"<th>C相电压波动</th>"+
									"<th>A相短时闪变</th>"+
									"<th>B相短时闪变</th>"+
									"<th>C相短时闪变</th>"+
									"<th>A相长时闪变</th>"+
									"<th>B相长时闪变</th>"+
									"<th>C相长时闪变</th>"+
									"<th>A相电压总谐波畸变率</th>"+
									"<th>B相电压总谐波畸变率</th>"+
									"<th>C相电压总谐波畸变率</th>"+
									"<th>A相电流总谐波畸变率</th>"+
									"<th>B相电流总谐波畸变率</th>"+
									"<th>C相电流总谐波畸变率</th>"+
									"<th>A相电压2次谐波</th>"+
									"<th>B相电压2次谐波</th>"+
									"<th>C相电压2次谐波</th>"+
									"<th>A相电流2次谐波</th>"+
									"<th>B相电流2次谐波</th>"+
									"<th>C相电流2次谐波</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "设备告警" : "";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getFixedNum5(lst.uab)+"</td>"+
										"<td>"+getFixedNum5(lst.ubc)+"</td>"+
										"<td>"+getFixedNum5(lst.uca)+"</td>"+
										"<td>"+getFixedNum5(lst.ua)+"</td>"+
										"<td>"+getFixedNum5(lst.ub)+"</td>"+
										"<td>"+getFixedNum5(lst.uc)+"</td>"+
										"<td>"+getFixedNum5(lst.fua)+"</td>"+
										"<td>"+getFixedNum5(lst.fub)+"</td>"+
										"<td>"+getFixedNum5(lst.fuc)+"</td>"+
										"<td>"+getFixedNum5(lst.ia)+"</td>"+
										"<td>"+getFixedNum5(lst.ib)+"</td>"+
										"<td>"+getFixedNum5(lst.ic)+"</td>"+
										"<td>"+getFixedNum5(lst.fia)+"</td>"+
										"<td>"+getFixedNum5(lst.fib)+"</td>"+
										"<td>"+getFixedNum5(lst.fic)+"</td>"+
										"<td>"+getFixedNum5(lst.pa)+"</td>"+
										"<td>"+getFixedNum5(lst.pb)+"</td>"+
										"<td>"+getFixedNum5(lst.pc)+"</td>"+
										"<td>"+getFixedNum5(lst.fpa)+"</td>"+
										"<td>"+getFixedNum5(lst.fpb)+"</td>"+
										"<td>"+getFixedNum5(lst.fpc)+"</td>"+
										"<td>"+getFixedNum5(lst.psum)+"</td>"+
										"<td>"+getFixedNum5(lst.qa)+"</td>"+
										"<td>"+getFixedNum5(lst.qb)+"</td>"+
										"<td>"+getFixedNum5(lst.qc)+"</td>"+
										"<td>"+getFixedNum5(lst.fqa)+"</td>"+
										"<td>"+getFixedNum5(lst.fqb)+"</td>"+
										"<td>"+getFixedNum5(lst.fqc)+"</td>"+
										"<td>"+getFixedNum5(lst.qsum)+"</td>"+
										"<td>"+getFixedNum5(lst.phi)+"</td>"+
										"<td>"+getFixedNum5(lst.phe)+"</td>"+
										"<td>"+getFixedNum5(lst.qhi)+"</td>"+
										"<td>"+getFixedNum5(lst.qhe)+"</td>"+
										"<td>"+getFixedNum5(lst.pfa)+"</td>"+
										"<td>"+getFixedNum5(lst.pfb)+"</td>"+
										"<td>"+getFixedNum5(lst.pfc)+"</td>"+
										"<td>"+getFixedNum5(lst.pf)+"</td>"+
										"<td>"+getFixedNum5(lst.freq)+"</td>"+
										"<td>"+getFixedNum5(lst.psv)+"</td>"+
										"<td>"+getFixedNum5(lst.nsv)+"</td>"+
										"<td>"+getFixedNum5(lst.zsv)+"</td>"+
										"<td>"+getFixedNum5(lst.psc)+"</td>"+
										"<td>"+getFixedNum5(lst.nsc)+"</td>"+
										"<td>"+getFixedNum5(lst.zsc)+"</td>"+
										"<td>"+getFixedNum5(lst.ublk)+"</td>"+
										"<td>"+getFixedNum5(lst.iblk)+"</td>"+
										"<td>"+getFixedNum5(lst.vfa)+"</td>"+
										"<td>"+getFixedNum5(lst.vfb)+"</td>"+
										"<td>"+getFixedNum5(lst.vfc)+"</td>"+
										"<td>"+getFixedNum5(lst.psta)+"</td>"+
										"<td>"+getFixedNum5(lst.pstb)+"</td>"+
										"<td>"+getFixedNum5(lst.pstc)+"</td>"+
										"<td>"+getFixedNum5(lst.plta)+"</td>"+
										"<td>"+getFixedNum5(lst.pltb)+"</td>"+
										"<td>"+getFixedNum5(lst.pltc)+"</td>"+
										"<td>"+getFixedNum5(lst.thdua)+"</td>"+
										"<td>"+getFixedNum5(lst.thdub)+"</td>"+
										"<td>"+getFixedNum5(lst.thduc)+"</td>"+
										"<td>"+getFixedNum5(lst.thdia)+"</td>"+
										"<td>"+getFixedNum5(lst.thdib)+"</td>"+
										"<td>"+getFixedNum5(lst.thdic)+"</td>"+
										"<td>"+getFixedNum5(lst.thdua2)+"</td>"+
										"<td>"+getFixedNum5(lst.thdub2)+"</td>"+
										"<td>"+getFixedNum5(lst.thduc2)+"</td>"+
										"<td>"+getFixedNum5(lst.thdia2)+"</td>"+
										"<td>"+getFixedNum5(lst.thdib2)+"</td>"+
										"<td>"+getFixedNum5(lst.thdic2)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "HLX"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>告警码</th>"+
									"<th>支路数量</th>"+
									"<th>直流电压</th>"+
									"<th>直流电流</th>"+
									"<th>直流功率</th>"+
									"<th>机内温度</th>"+
									"<th>离散率</th>"+
									"<th>第1路电流</th>"+
									"<th>第2路电流</th>"+
									"<th>第3路电流</th>"+
									"<th>第4路电流</th>"+
									"<th>第5路电流</th>"+
									"<th>第6路电流</th>"+
									"<th>第7路电流</th>"+
									"<th>第8路电流</th>"+
									"<th>第9路电流</th>"+
									"<th>第10路电流</th>"+
									"<th>第11路电流</th>"+
									"<th>第12路电流</th>"+
									"<th>第13路电流</th>"+
									"<th>第14路电流</th>"+
									"<th>第15路电流</th>"+
									"<th>第16路电流</th>"+
									"<th>第17路电流</th>"+
									"<th>第18路电流</th>"+
									"<th>第19路电流</th>"+
									"<th>第20路电流</th>"+
									"<th>第21路电流</th>"+
									"<th>第22路电流</th>"+
									"<th>第23路电流</th>"+
									"<th>第24路电流</th>"+
									"<th>第25路电流</th>"+
									"<th>第26路电流</th>"+
									"<th>第27路电流</th>"+
									"<th>第28路电流</th>"+
									"<th>第29路电流</th>"+
									"<th>第30路电流</th>"+
									"<th>第31路电流</th>"+
									"<th>第32路电流</th>"+
									"<th>创建时间</th>"+
									"<th>健康状态</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "设备告警" : "";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getIsNull(lst.faultCode)+"</td>"+
										"<td>"+getIsNull(lst.branchNum)+"</td>"+
										"<td>"+getFixedNum5(lst.udc)+"</td>"+
										"<td>"+getFixedNum5(lst.idc)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc)+"</td>"+
										"<td>"+getFixedNum5(lst.temp)+"</td>"+
										"<td>"+getFixedNum5(lst.disRate)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc1)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc2)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc3)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc4)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc5)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc6)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc7)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc8)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc9)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc10)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc11)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc12)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc13)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc14)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc15)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc16)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc17)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc18)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc19)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc20)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc21)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc22)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc23)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc24)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc25)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc26)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc27)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc28)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc29)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc30)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc31)+"</td>"+
										"<td>"+getFixedNum5(lst.Idc32)+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "JLPDG"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>支路数量</th>"+
									"<th>1#断路器</th>"+
									"<th>2#断路器</th>"+
									"<th>3#断路器</th>"+
									"<th>4#断路器</th>"+
									"<th>5#断路器</th>"+
									"<th>6#断路器</th>"+
									"<th>7#断路器</th>"+
									"<th>8#断路器</th>"+
									"<th>9#断路器</th>"+
									"<th>10#断路器</th>"+
									"<th>数据入库时间</th>"+
									"<th>健康状态</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getIsNull(lst.branchNum)+"</td>"+
										"<td>"+getIsNull(lst.stat1)+"</td>"+
										"<td>"+getIsNull(lst.stat2)+"</td>"+
										"<td>"+getIsNull(lst.stat3)+"</td>"+
										"<td>"+getIsNull(lst.stat4)+"</td>"+
										"<td>"+getIsNull(lst.stat5)+"</td>"+
										"<td>"+getIsNull(lst.stat6)+"</td>"+
										"<td>"+getIsNull(lst.stat7)+"</td>"+
										"<td>"+getIsNull(lst.stat8)+"</td>"+
										"<td>"+getIsNull(lst.stat9)+"</td>"+
										"<td>"+getIsNull(lst.stat10)+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "ZLPDG"){
	    						 html="<tr>"+
	    						 	"<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>支路数量</th>"+
									"<th>1#断路器</th>"+
									"<th>2#断路器</th>"+
									"<th>3#断路器</th>"+
									"<th>4#断路器</th>"+
									"<th>5#断路器</th>"+
									"<th>6#断路器</th>"+
									"<th>7#断路器</th>"+
									"<th>8#断路器</th>"+
									"<th>9#断路器</th>"+
									"<th>10#断路器</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getIsNull(lst.branchNum)+"</td>"+
										"<td>"+getIsNull(lst.stat1)+"</td>"+
										"<td>"+getIsNull(lst.stat2)+"</td>"+
										"<td>"+getIsNull(lst.stat3)+"</td>"+
										"<td>"+getIsNull(lst.stat4)+"</td>"+
										"<td>"+getIsNull(lst.stat5)+"</td>"+
										"<td>"+getIsNull(lst.stat6)+"</td>"+
										"<td>"+getIsNull(lst.stat7)+"</td>"+
										"<td>"+getIsNull(lst.stat8)+"</td>"+
										"<td>"+getIsNull(lst.stat9)+"</td>"+
										"<td>"+getIsNull(lst.stat10)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
										
	    						 }
	    					 }else if(typ_ide == "JLZZ"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>设备状态</th>"+
									"<th>A 相电压1</th>"+
									"<th>B 相电压1</th>"+
									"<th>C 相电压1</th>"+
									"<th>A 相电压2</th>"+
									"<th>B 相电压2</th>"+
									"<th>C 相电压2</th>"+
									"<th>频率1</th>"+
									"<th>频率2</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "正常停机" : lst.stat == 3 ? "设备告警":lst.stat == 4 ? "解列保护" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getFixedNum5(lst.ua1)+"</td>"+
										"<td>"+getFixedNum5(lst.ub1)+"</td>"+
										"<td>"+getFixedNum5(lst.uc1)+"</td>"+
										"<td>"+getFixedNum5(lst.ua2)+"</td>"+
										"<td>"+getFixedNum5(lst.ub2)+"</td>"+
										"<td>"+getFixedNum5(lst.uc2)+"</td>"+
										"<td>"+getFixedNum5(lst.freq1)+"</td>"+
										"<td>"+getFixedNum5(lst.freq2)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
										
	    						 }
	    					 }else if(typ_ide == "XLBH"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>运行状态</th>"+
									"<th>告警码</th>"+
									"<th>Uab线电压</th>"+
									"<th>Ubc线电压</th>"+
									"<th>Uca线电压</th>"+
									"<th>A相电压</th>"+
									"<th>B相电压</th>"+
									"<th>C相电压</th>"+
									"<th>A相电流</th>"+
									"<th>B相电流</th>"+
									"<th>C相电流</th>"+
									"<th>有功功率</th>"+
									"<th>无功功率</th>"+
									"<th>视在功率</th>"+
									"<th>频率</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "故障保护" : "";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getIsNull(lst.faultCode)+"</td>"+
										"<td>"+getFixedNum5(lst.uab)+"</td>"+
										"<td>"+getFixedNum5(lst.ubc)+"</td>"+
										"<td>"+getFixedNum5(lst.uca)+"</td>"+
										"<td>"+getFixedNum5(lst.ua)+"</td>"+
										"<td>"+getFixedNum5(lst.ub)+"</td>"+
										"<td>"+getFixedNum5(lst.uc)+"</td>"+
										"<td>"+getFixedNum5(lst.ia)+"</td>"+
										"<td>"+getFixedNum5(lst.ib)+"</td>"+
										"<td>"+getFixedNum5(lst.ic)+"</td>"+
										"<td>"+getFixedNum5(lst.psum)+"</td>"+
										"<td>"+getFixedNum5(lst.qsum)+"</td>"+
										"<td>"+getFixedNum5(lst.ssum)+"</td>"+
										"<td>"+getFixedNum5(lst.freq)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "ZLCDZLC"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>充电单号</th>"+
									"<th>充电桩编号</th>"+
									"<th>设备状态</th>"+
									"<th>充电过程</th>"+
									"<th>告警码</th>"+
									"<th>充电枪口号</th>"+
									"<th>枪连接状态</th>"+
									"<th>付款方式</th>"+
									"<th>预付金额</th>"+
									"<th>卡号</th>"+
									"<th>卡余额</th>"+
									"<th>用户账号</th>"+
									"<th>充电方式</th>"+
									"<th>充电方式参数</th>"+
									"<th>充电开始时间</th>"+
									"<th>最高输出电压</th>"+
									"<th>最低输出电压</th>"+
									"<th>最大电流</th>"+
									"<th>最小电流</th>"+
									"<th>初始SOC</th>"+
									"<th>初始电表读数</th>"+
									"<th>充电结束时间</th>"+
									"<th>充电时长</th>"+
									"<th>充电电量</th>"+
									"<th>充电金额</th>"+
									"<th>结束soc</th>"+
									"<th>充电结束原因</th>"+
									"<th>充电后电表读数</th>"+
									"<th>充电后卡余额</th>"+
									"<th>创建时间</th>"+
									"<th></th>"+
									
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"离线": lst.stat == 1 ? "空闲" :lst.stat == 2 ? "充电中" : lst.stat == 3 ? "告警":lst.stat == 4 ? "预约" :"";
										var chgStat　 =  lst.chgStat　 == 1 ? "启动充电" :lst.chgStat　 == 2 ? "充电中" : lst.chgStat　 == 3 ? "结算":"";
										var gunStat　 =  lst.gunStat　 == 0 ? "未连接" :lst.gunStat　 == 0 ? "连接" :"";
										var payWay　 =  lst.payWay　 == 0 ? "刷卡" :lst.payWay　 == 1 ? "扫码" :"";
										var chgType　 =  lst.chgType　 == 1 ? "充满" :lst.chgType　 == 2 ? "按时间" :lst.chgType　 == 3 ? "按金额" :lst.chgType　 == 4 ? "按电量" :"";

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.orderNo+"</td>"+
										"<td>"+lst.pileNo+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+chgStat　+"</td>"+
										"<td>"+lst.faultCode+"</td>"+
										"<td>"+lst.gunNo+"</td>"+
										"<td>"+gunStat+"</td>"+
										"<td>"+payWay+"</td>"+
										"<td>"+lst.prePayMoney+"</td>"+
										"<td>"+lst.cardNo+"</td>"+
										"<td>"+getFixedNum5(lst.cardMoney)+"</td>"+
										"<td>"+getFixedNum5(lst.userAccount)+"</td>"+
										"<td>"+getFixedNum5(lst.chgType)+"</td>"+
										"<td>"+getFixedNum5(lst.chgTypeParam)+"</td>"+
										"<td>"+getFixedNum5(lst.beginTime)+"</td>"+
										"<td>"+getFixedNum5(lst.uMax)+"</td>"+
										"<td>"+getFixedNum5(lst.uMin)+"</td>"+
										"<td>"+getFixedNum5(lst.iMax)+"</td>"+
										"<td>"+getFixedNum5(lst.iMin)+"</td>"+
										"<td>"+getFixedNum5(lst.beginSOC)+"</td>"+
										"<td>"+getFixedNum5(lst.initPower)+"</td>"+
										"<td>"+getFixedNum5(lst.endTime)+"</td>"+
										"<td>"+getFixedNum5(lst.time)+"</td>"+
										"<td>"+getFixedNum5(lst.power)+"</td>"+
										"<td>"+getFixedNum5(lst.money)+"</td>"+
										"<td>"+getFixedNum5(lst.endSOC)+"</td>"+
										"<td>"+getFixedNum5(lst.endReason　)+"</td>"+
										"<td>"+getFixedNum5(lst.endPower　)+"</td>"+
										"<td>"+getFixedNum5(lst.cardRemMoney)+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "ZLCDZSS"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>充电单号</th>"+
									"<th>充电桩编号</th>"+
									"<th>设备状态</th>"+
									"<th>告警码</th>"+
									"<th>当前SOC</th>"+
									"<th>当前电表读数</th>"+
									"<th>充电电压</th>"+
									"<th>充电电流</th>"+
									"<th>充电功率</th>"+
									"<th>BMS需求电压</th>"+
									"<th>BMS需求电流</th>"+
									"<th>BMS充电模式</th>"+
									"<th>充电时长</th>"+
									"<th>剩余充电时间</th>"+
									"<th>本次累计充电费</th>"+
									"<th>本次累计充电量</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"离线": lst.stat == 1 ? "空闲" :lst.stat == 2 ? "充电中" : lst.stat == 3 ? "告警":lst.stat == 4 ? "预约" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.orderNo+"</td>"+
										"<td>"+lst.pileNo+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getIsNull(lst.faultCode)+"</td>"+
										"<td>"+getFixedNum5(lst.SOC)+"</td>"+
										"<td>"+getFixedNum5(lst.currPower)+"</td>"+
										"<td>"+getFixedNum5(lst.udc)+"</td>"+
										"<td>"+getFixedNum5(lst.idc)+"</td>"+
										"<td>"+getFixedNum5(lst.pdc)+"</td>"+
										"<td>"+getFixedNum5(lst.udcBMS)+"</td>"+
										"<td>"+getFixedNum5(lst.idcBMS)+"</td>"+
										"<td>"+getFixedNum5(lst.modeBMS)+"</td>"+
										"<td>"+getFixedNum5(lst.time)+"</td>"+
										"<td>"+getFixedNum5(lst.remTime)+"</td>"+
										"<td>"+getFixedNum5(lst.money)+"</td>"+
										"<td>"+getFixedNum5(lst.power)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "ZLCDZDJ"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>充电桩编号</th>"+
									"<th>设备状态</th>"+
									"<th>枪链接状态</th>"+
									"<th>告警码</th>"+
									"<th>累计充电时间</th>"+
									"<th>累计充电电量</th>"+
									"<th>累计充电金额</th>"+
									"<th>有效充电小时数</th>"+
									"<th>累计正常运行时间</th>"+
									"<th>累计正常停机时间</th>"+
									"<th>累计告警运行时间</th>"+
									"<th>累计故障停机时间</th>"+
									"<th>累计通讯中断时间</th>"+
									"<th>累计运行时间</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"离线": lst.stat == 1 ? "空闲" :lst.stat == 2 ? "充电中" : lst.stat == 3 ? "告警":lst.stat == 4 ? "预约" :"";
										var gunStat = lst.gunStat == 0 ?"未连接": lst.gunStat == 1 ? "连接未充电" :lst.gunStat == 2 ? "充电中" : "";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.pileNo+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+gunStat+"</td>"+
										"<td>"+getIsNull(lst.faultCode)+"</td>"+
										"<td>"+getFixedNum5(lst.cumTime)+"</td>"+
										"<td>"+getFixedNum5(lst.cumPower)+"</td>"+
										"<td>"+getFixedNum5(lst.cumMoney)+"</td>"+
										"<td>"+getFixedNum5(lst.validTime)+"</td>"+
										"<td>"+getFixedNum5(lst.goodRunTime)+"</td>"+
										"<td>"+getFixedNum5(lst.downTime)+"</td>"+
										"<td>"+getFixedNum5(lst.faultTime)+"</td>"+
										"<td>"+getFixedNum5(lst.failureTime)+"</td>"+
										"<td>"+getFixedNum5(lst.comIntTime)+"</td>"+
										"<td>"+getFixedNum5(lst.runTime)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "DDQCSS"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>充电单号</th>"+
									"<th>充电桩编号</th>"+
									"<th>充电过程</th>"+
									"<th>车辆VIN</th>"+
									"<th>车辆生产国家</th>"+
									"<th>车辆制造商</th>"+
									"<th>车辆种类</th>"+
									"<th>车辆型号</th>"+
									"<th>车辆发动机</th>"+
									"<th>车辆功率</th>"+
									"<th>充电桩与BMS通信协议版本号</th>"+
									"<th>BMS与充电桩通信协议版本号</th>"+
									"<th>充电桩与BMS握手结果</th>"+
									"<th>电池类型</th>"+
									"<th>最高允许温度</th>"+
									"<th>BMS最高允许充电电压</th>"+
									"<th>单体最高允许充电电压</th>"+
									"<th>最高允许充电电流</th>"+
									"<th>额定总电压</th>"+
									"<th>当前电压</th>"+
									"<th>额定容量</th>"+
									"<th>标称能量</th>"+
									"<th>开始SOC</th>"+
									"<th>停止原因</th>"+
									"<th>BMS中止充电原因</th>"+
									"<th>BMS充电故障原因</th>"+
									"<th>BMS中止错误原因</th>"+
									"<th>中止荷电状态SOC</th>"+
									"<th>中止荷电单体最低电压</th>"+
									"<th>中止荷电单体最高电压</th>"+
									"<th>中止荷电最高温度</th>"+
									"<th>中止荷电最低温度</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										
										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.orderNo+"</td>"+
										"<td>"+lst.pileNo+"</td>"+
										"<td>"+lst.chgStat+"</td>"+
										"<td>"+getIsNull(lst.carVin)+"</td>"+
										"<td>"+getIsNull(lst.carMadeIn)+"</td>"+
										"<td>"+getIsNull(lst.carManu)+"</td>"+
										"<td>"+getIsNull(lst.carType)+"</td>"+
										"<td>"+getIsNull(lst.carModel)+"</td>"+
										"<td>"+getIsNull(lst.carEngine)+"</td>"+
										"<td>"+getIsNull(lst.carCapacity)+"</td>"+
										"<td>"+getIsNull(lst.versionPile)+"</td>"+
										"<td>"+getIsNull(lst.versionBMS)+"</td>"+
										"<td>"+getIsNull(lst.handshake)+"</td>"+
										"<td>"+getIsNull(lst.battType)+"</td>"+
										"<td>"+getFixedNum5(lst.allowMaxTemp)+"</td>"+
										"<td>"+getFixedNum5(lst.allowMaxU)+"</td>"+
										"<td>"+getFixedNum5(lst.allowSingleMaxU)+"</td>"+
										"<td>"+getFixedNum5(lst.allowMaxI)+"</td>"+
										"<td>"+getFixedNum5(lst.rateU)+"</td>"+
										"<td>"+getFixedNum5(lst.currU)+"</td>"+
										"<td>"+getFixedNum5(lst.capacity)+"</td>"+
										"<td>"+getFixedNum5(lst.ratePower)+"</td>"+
										"<td>"+getFixedNum5(lst.startSOC)+"</td>"+
										"<td>"+getFixedNum5(lst.stopReason)+"</td>"+
										"<td>"+getFixedNum5(lst.bmsStopReason)+"</td>"+
										"<td>"+getFixedNum5(lst.bmsFaultReason)+"</td>"+
										"<td>"+getFixedNum5(lst.bmsFaultChaReason)+"</td>"+
										"<td>"+getFixedNum5(lst.stopSOC)+"</td>"+
										"<td>"+getFixedNum5(lst.stopSingleMinU)+"</td>"+
										"<td>"+getFixedNum5(lst.stopSingleMaxU)+"</td>"+
										"<td>"+getFixedNum5(lst.stopMaxTemper)+"</td>"+
										"<td>"+getFixedNum5(lst.stopMinTemper)+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "DDQCGC"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>充电单号</th>"+
									"<th>充电桩编号</th>"+
									"<th>当前SOC</th>"+
									"<th>电池组最低温度</th>"+
									"<th>电池组最高温度</th>"+
									"<th>单体电池最高电压</th>"+
									"<th>单体电池最低电压</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										
										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.orderNo+"</td>"+
										"<td>"+lst.pileNo+"</td>"+
										"<td>"+getFixedNum5(lst.currSOC)+"</td>"+
										"<td>"+getFixedNum5(lst.minTemp)+"</td>"+
										"<td>"+getFixedNum5(lst.maxTemp)+"</td>"+
										"<td>"+getFixedNum5(lst.battMaxU)+"</td>"+
										"<td>"+getFixedNum5(lst.battMinU)+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "JLCDZLC"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>充电桩编号</th>"+
									"<th>充电单号</th>"+
									"<th>设备状态</th>"+
									"<th>充电过程</th>"+
									"<th>枪连接状态</th>"+
									"<th>付款方式</th>"+
									"<th>预付金额</th>"+
									"<th>卡号</th>"+
									"<th>卡余额</th>"+
									"<th>用户账号</th>"+
									"<th>充电开始时间</th>"+
									"<th>初始电表读数</th>"+
									"<th>充电结束时间</th>"+
									"<th>充电时长</th>"+
									"<th>充电电量</th>"+
									"<th>充电金额</th>"+
									"<th>充电结束原因</th>"+
									"<th>充电后电表读数</th>"+
									"<th>充电后卡余额</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"离线": lst.stat == 1 ? "空闲" :lst.stat == 2 ? "充电中" : lst.stat == 3 ? "告警":lst.stat == 4 ? "预约" :"";

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.pileNo+"</td>"+
										"<td>"+lst.orderNo+"</td>"+
										"<td>"+lst.stat+"</td>"+
										"<td>"+lst.chgStat+"</td>"+
										"<td>"+lst.gunStat+"</td>"+
										"<td>"+lst.payWay+"</td>"+
										"<td>"+getFixedNum5(lst.prePayMoney)+"</td>"+
										"<td>"+getFixedNum5(lst.cardNo)+"</td>"+
										"<td>"+getFixedNum5(lst.cardMoney)+"</td>"+
										"<td>"+getFixedNum5(lst.userAccount)+"</td>"+
										"<td>"+getFixedNum5(lst.beginTime)+"</td>"+
										"<td>"+getFixedNum5(lst.initPower)+"</td>"+
										"<td>"+getFixedNum5(lst.endTime)+"</td>"+
										"<td>"+getFixedNum5(lst.time)+"</td>"+
										"<td>"+getFixedNum5(lst.power)+"</td>"+
										"<td>"+getFixedNum5(lst.money)+"</td>"+
										"<td>"+getFixedNum5(lst.endReason)+"</td>"+
										"<td>"+getFixedNum5(lst.endPower)+"</td>"+
										"<td>"+getFixedNum5(lst.cardRemMoney)+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "JLCDZSS"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>充电单号</th>"+
									"<th>充电桩编号</th>"+
									"<th>设备状态</th>"+
									"<th>告警码</th>"+
									"<th>交流A相充电电压</th>"+
									"<th>交流B相充电电压</th>"+
									"<th>交流C相充电电压</th>"+
									"<th>交流A相充电电流</th>"+
									"<th>交流B相充电电流</th>"+
									"<th>交流C相充电电流</th>"+
									"<th>充电功率</th>"+
									"<th>当前电表读数</th>"+
									"<th>本次累计充电费</th>"+
									"<th>本次累计充电量</th>"+
									"<th>充电时长</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"离线": lst.stat == 1 ? "空闲" :lst.stat == 2 ? "充电中" : lst.stat == 3 ? "告警":lst.stat == 4 ? "预约" :"";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.orderNo+"</td>"+
										"<td>"+lst.pileNo+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+getIsNull(lst.faultCode)+"</td>"+
										"<td>"+getFixedNum5(lst.ua)+"</td>"+
										"<td>"+getFixedNum5(lst.ub)+"</td>"+
										"<td>"+getFixedNum5(lst.uc)+"</td>"+
										"<td>"+getFixedNum5(lst.ia)+"</td>"+
										"<td>"+getFixedNum5(lst.ib)+"</td>"+
										"<td>"+getFixedNum5(lst.ic)+"</td>"+
										"<td>"+getFixedNum5(lst.power)+"</td>"+
										"<td>"+getFixedNum5(lst.currPower)+"</td>"+
										"<td>"+getFixedNum5(lst.money)+"</td>"+
										"<td>"+getFixedNum5(lst.tolPower)+"</td>"+
										"<td>"+getFixedNum5(lst.time)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "JLCDZDJ"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>充电桩编号</th>"+
									"<th>设备状态</th>"+
									"<th>枪链接状态</th>"+
									"<th>告警码</th>"+
									"<th>累计充电时间</th>"+
									"<th>累计充电电量</th>"+
									"<th>累计充电金额</th>"+
									"<th>有效充电小时数</th>"+
									"<th>累计正常运行时间</th>"+
									"<th>累计正常停机时间</th>"+
									"<th>累计告警运行时间</th>"+
									"<th>累计故障停机时间</th>"+
									"<th>累计通讯中断时间</th>"+
									"<th>累计运行时间</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"<th>累计充电次数</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"离线": lst.stat == 1 ? "空闲" :lst.stat == 2 ? "充电中" : lst.stat == 3 ? "告警":lst.stat == 4 ? "预约" :"";
										var gunStat = lst.gunStat == 0 ?"未连接": lst.gunStat == 1 ? "连接未充电" :lst.gunStat == 2 ? "充电中" : "";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.pileNo+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+gunStat+"</td>"+
										"<td>"+getIsNull(lst.faultCode)+"</td>"+
										"<td>"+getFixedNum5(lst.cumTime)+"</td>"+
										"<td>"+getFixedNum5(lst.cumPower)+"</td>"+
										"<td>"+getFixedNum5(lst.cumMoney)+"</td>"+
										"<td>"+getFixedNum5(lst.validTime)+"</td>"+
										"<td>"+getFixedNum5(lst.goodRunTime)+"</td>"+
										"<td>"+getFixedNum5(lst.downTime)+"</td>"+
										"<td>"+getFixedNum5(lst.faultTime)+"</td>"+
										"<td>"+getFixedNum5(lst.failureTime)+"</td>"+
										"<td>"+getFixedNum5(lst.comIntTime)+"</td>"+
										"<td>"+getFixedNum5(lst.runTime)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"<td>"+getIsZero(lst.chpCnt)+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "KZQ"){
	    						 html="<tr>"+
	    						 "<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>信号强度</th>"+
									"<th>上行流量</th>"+
									"<th>下行流量</th>"+
									"<th>ICCID</th>"+
									"<th>卡号</th>"+
									"<th>健康状态</th>"+
									"<th>创建时间</th>"+
									"<th>设备状态</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "设备告警" : "";
										var healthStat = lst.healthStat == 1 ? "优秀" : lst.healthStat == 2 ? "良好":lst.healthStat == 3 ? "中等":lst.healthStat == 4 ? "差" : "无" ;  

										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+getFixedNum5(lst.signal)+"</td>"+
										"<td>"+getFixedNum5(lst.uplink)+"</td>"+
										"<td>"+getFixedNum5(lst.downlink)+"</td>"+
										"<td>"+getIsNull(lst.iccid)+"</td>"+
										"<td>"+getIsNull(lst.phone)+"</td>"+
										"<td>"+healthStat+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"<td>"+stat+"</td>"+
										"</tr>";
	    						 }
	    					 }else if(typ_ide == "WWXT"){
	    						 html="<tr>"+
	    							"<th>序号</th>"+
									"<th>设备编号</th>"+
									"<th>运行状态</th>"+
									"<th>工作模式</th>"+
									"<th>并离网状态</th>"+
									"<th>告警码</th>"+
									"<th>信号强度</th>"+
									"<th>上行流量</th>"+
									"<th>下行流量</th>"+
									"<th>ICCID</th>"+
									"<th>卡号</th>"+
									"<th>电网总有功</th>"+
									"<th>电网总无功</th>"+
									"<th>负荷总有功</th>"+
									"<th>负荷总无功</th>"+
									"<th>储能总有功</th>"+
									"<th>储能总无功</th>"+
									"<th>光伏总有功</th>"+
									"<th>光伏总无功</th>"+
									"<th>充电桩总有功</th>"+
									"<th>充电桩总无功</th>"+
									"<th>电网输入电量</th>"+
									"<th>馈网电量</th>"+
									"<th>负荷用电电量</th>"+
									"<th>储能充电电量</th>"+
									"<th>储能放电电量</th>"+
									"<th>光伏发电电量</th>"+
									"<th>充电桩用电电量</th>"+
									"<th>创建时间</th>"+
									"</tr>";
	    						 for(var i=0;i<data.data.length;i++){
										var lst=data.data[i];
										var stat = lst.stat == 0 ?"通讯中断": lst.stat == 1 ? "正常运行" :lst.stat == 2 ? "正常停机" :lst.stat == 3 ? "告警运行" :lst.stat == 4 ? "故障停止" : "--";
										var mode = lst.mode == 1 ? "光伏平滑" : lst.mode == 2 ? "削峰填谷":lst.mode == 3 ? "负荷追踪":lst.mode == 4 ? "PCC点平滑" : "--";
										var gridStat = lst.gridStat == 0 ? "离网":lst.gridStat == 1 ? "并网" : "--";
										html += "<tr>"+
										"<td>"+(i+1)+"</td>"+
										"<td>"+lst.equ_num+"</td>"+
										"<td>"+stat+"</td>"+
										"<td>"+mode+"</td>"+
										"<td>"+gridStat+"</td>"+
										"<td>"+lst.faultNum+"</td>"+
										"<td>"+getFixedNum5(lst.signal)+"</td>"+
										"<td>"+getFixedNum5(lst.uplink)+"</td>"+
										"<td>"+getFixedNum5(lst.downlink)+"</td>"+
										"<td>"+getIsNull(lst.iccid)+"</td>"+
										"<td>"+getIsNull(lst.phone)+"</td>"+
										"<td>"+getFixedNum5(lst.pGrid)+"</td>"+
										"<td>"+getFixedNum5(lst.qGrid)+"</td>"+
										"<td>"+getFixedNum5(lst.pLoad)+"</td>"+
										"<td>"+getFixedNum5(lst.qLoad)+"</td>"+
										"<td>"+getFixedNum5(lst.pBatts)+"</td>"+
										"<td>"+getFixedNum5(lst.qBatts)+"</td>"+
										"<td>"+getFixedNum5(lst.pPV)+"</td>"+
										"<td>"+getFixedNum5(lst.qPV)+"</td>"+
										"<td>"+getFixedNum5(lst.pEV)+"</td>"+
										"<td>"+getFixedNum5(lst.qEV)+"</td>"+
										"<td>"+getFixedNum5(lst.power4Grid)+"</td>"+
										"<td>"+getFixedNum5(lst.power2Grid)+"</td>"+
										"<td>"+getFixedNum5(lst.powerLoad)+"</td>"+
										"<td>"+getFixedNum5(lst.powerCharge)+"</td>"+
										"<td>"+getFixedNum5(lst.powerDisCharge)+"</td>"+
										"<td>"+getFixedNum5(lst.powerPV)+"</td>"+
										"<td>"+getFixedNum5(lst.powerEV)+"</td>"+
										"<td>"+getLocalDateAndTime(lst.crtTim,1)+"</td>"+
										"</tr>";
	    						 }
	    					 }
							$("#tab").html(html);
							$("#tcdPageCode1").createPage({
		 				        pageCount:countAll,
		 				        current:currentPage,
		 				        backFn:function(p){
		 				        	currentPage = p;
		 				        	getData(curParam,typ_ide);
		 				        }
		 			    	});
							layer.close(indexlayer);
				   	    		
				}else{
					layer.close(indexlayer);
					$("#tab").html("<tr><td colspan='9'>暂无数据</td></tr>");
					$("#tcdPageCode1").empty();
				}
				//设置宽高
   	    		var ScreenWidth  = (document.documentElement.clientWidth);  
   	    		ScreenWidth = ScreenWidth;
   	    		
				var tab = $('.table-list');
				var td = $(tab.find('tr')[1]).find('td');
				if(td.length * 90 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
					tab[0].width = td.length * 90;
				}else{
					tab[0].width = ScreenWidth - 50;
				}
			}else{
				layer.close(indexlayer);
				layer.alert(data.desc);
			}
		}
	})
}
 function download(){
		var pws_id=$("#companyPws").val();
		var equ_num=$("#equ_num").val();
		var sta_tim=$("#sta_tim").val();
		var end_tim=$("#end_tim").val();
		var typ_ide=$("#typ_ide").val();
    	var layC = layer.confirm("确定下载？",function(){
    		
	   		layer.close(layC);
	    		
		    var indexlayer = layer.load(1, {
	   			  shade: [0.5,'#fff'] //0.1透明度的白色背景
	  			});
		    
		    setTimeout(function(){
		    	 layer.close(indexlayer);
		    },20000)
		   
		    
		    location.href = url + "CollectDataLstExport.htm?pws_id="+pws_id+"&equ_num="+equ_num+"&sta_tim="+sta_tim+"&end_tim="+end_tim+"&typ_ide="+typ_ide;  
   		    
		})
	} 
	</script>
</body>
</html>