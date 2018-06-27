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
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>js/circle/css/normalize.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>js/circle/css/default.css?pubVersion=201802070001"> 
		<link rel="stylesheet" href="<%=basePath %>js/circle/css/percircle.css?pubVersion=201802070001"> 
	</head>
	<style>
	.circle {
	    width: 90px;
	    height: 90px;
	    background-color: #fff;
	    border: 10px solid #23B747;
	    border-radius: 90px;
	    -webkit-border-radius: 90px;
	    margin: 12px auto 5px;
	}
	
	.circle a{
	    height: 30px;
	    line-height :90px;
	    font-size:18px;
	    margin: 0 auto;
	    color:#000;
	}
	.qy-circle{
		margin-top:45px;
	}
	.qy-circle a{
		display:block;
		height: 45px;
	    line-height :45px;
	    font-size:16px;
	    margin: 0 auto;
	    color:#000;
	}
	.brgreen{
		border: 6px solid #23B747;
	}
	.bryel{
		border: 6px solid #E8C709;
	}
	.brblack{
		border: 6px solid #5B5B5B;
	}
	.brred{
		border: 6px solid #DD2C2B;
	}
	.brgray{
		border: 6px solid #C0C0C0;
	}
	.brblue{
		border: 6px solid #9BC9D6;
	}
	
	.bor-radius{
		border: 1px solid #e8e8e8!important;
    	border-radius: 5px;
    	-moz-border-radius: 5px;
    	-webkit-border-radius: 5px;
	}
	</style>
	<body style="background: #F3F3F3;">
		<input type="hidden" id="pws_id" value="${id}"> 
		<input type="hidden" id="userId" value="${user.id}">	
		<input type="hidden" id="use_typ" value="${user.use_typ}" >
		<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >	
		<div class="bg-ff h60">
			<a class="dettile">电站详情</a>
		</div>
		<div class="w75 fl">
			 <div class="pl15 ml15">
			 	<div class="pl8 pr8 mt10 bg-ff  bor-radius">
	              <div class="h250"> 
	                	<div class="h250 w70 fl pt10"  >
	                		<h4 class="title fl" id="pws_nam" >北京分公司大兴电站</h4>
	                		<div class="fl zdsta" id="cur_sta">正常运行</div>
	                		<div class="clr"></div>
	                		<table width="70%" border="0" cellpadding="0" cellspacing="0" class="tabbg">
	                			<tr>
					                <th>业主：</th>
						            <td><span id="con_nam">--</span></td>
						            <th style="width: 19%;padding-left: 1%;">运维负责人：</th>
						            <td><span id="use_nam">--</span></td>
					            </tr>
                			</table>
                			<table width="45%" border="0" cellpadding="0" cellspacing="0" class="tabrig fl borrig" style="margin-left: 5%;">
	                			<tr>
					                <th>地址：</th>
						            <td style="padding-right: 5%;">&nbsp;</td>
					            </tr>
					            <tr>
					                <th style="width:100%;text-align: right;padding-right: 5%;" colspan='2'><span id="pws_add">--</span></th>
					            </tr>
					            <tr>
					                <th>电话：</th>
						            <td style="padding-right: 5%;"><span id="con_mob">--</span></td>
					            </tr>
					            <tr>
					                <th>电站类型：</th>
						            <td style="padding-right: 5%;"><span id="typ_nam">--</span></td>
					            </tr>
					            <tr>
					                <th>电站容量：</th>
						            <td style="padding-right: 5%;"><span id="are_cov">0 kW</span></td>
					            </tr>
                			</table>
                			<table width="45%" border="0" cellpadding="0" cellspacing="0" class="tabrig fl" style="margin-left: 1%;">
	                			<tr>
					                <th>运维项目公司：</th>
						            <td>&nbsp;</td>
					            </tr>
					            <tr>
					                <th style="width:100%;text-align: right;padding-right: 1%;" colspan='2'><span id="opt_com_nam">--</span></th>
					            </tr>
					            <tr>
					                <th>安全运维天数：</th>
						            <td><span id="sec_ope">--天</span></td>
					            </tr>
					            <tr>
					                <th>维护时间：</th>
						            <td><span id="fnl_mat_tim">2017-11-20</span></td>
					            </tr>
					            <tr>
					                <th>下次计划维护时间：</th>
						            <td><span id="nxt_mat_tim">2018-01-15</span></td>
					            </tr>
                			</table>
	                	</div>
	                	<div class="h250 w30 fl">
	                		<div class="h230 pt10">
	                			<div class="h230 bg-ff borg">
	                				<div class="dzimg"> </div>  
	                			</div>
	                		</div>
	                	</div>
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius">
	              <div   class="h360"  > 
	                  <h4 class="subtitle">电站功率曲线</h4>
                	  <div class="h300 w70 fl"  style="width:87%;" id="gccd"></div>
                	   <div class="w30 fl detnum"  style="width:13%;">
		                 	<ul   style="margin-top: 20px;">
	                  			<li>
	                  				<span class="num" id="gfgl">--kW</span>
	                  				<span>光伏功率</span>
	                  			</li>
	                  			<li>
	                  				<span class="num mt10" id="cngl">--kW</span>
	                  				<span>储能功率</span>
	                  			</li>
	                  			<li>
	                  				<span class="num" id="cdzgl">--kW</span>
	                  				<span>充电桩功率</span>
                  				</li>
	                  			<li>
	                  				<span class="num mt10" id="dwgl">--kW</span>
	                  				<span>电网功率</span>
	                  			</li>
	                  			<li>
	                  				<span class="num" id="fhgl">--kW</span>
	                  				<span>负荷功率</span>
	                  			</li>
	                  		</ul>
		                 </div>
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius">
	              <div   class="h360"> 
	                	 <h4 class="subtitle">并网系统</h4>
	                	 <div class="h300 w80 fl" style="width:87%;"   id="bwxt"></div>
	                	 <div class="w20 fl detnum" style="width:13%;" >
		                 	<ul  style="margin-top:20px;">
	                  			<li>
	                  				<span class="num" id="tol_feed_net_power">--kWh</span>
	                  				<span>累计馈网电量</span>
	                  				<span class="num mt10" id="tol_ipt_power">--kWh</span>
	                  				<span>累计输入电量</span>
	                  			</li>
	                  		</ul>
		                 </div>
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius">
	              <div   class="h600" style="height:660px;"> 
	                 	<h4 class="subtitle">光伏系统</h4>
	                 	<div class="h300 w100" >
                 	 		<div class="h300" id="gffdqx"></div>
                 	 	</div>
                 	 	<div class="h300">
                 	 		<div class="w50 h300 fl" style="margin-top:20px;width: 45%;">
                 	 			<table width="40%" border="0" cellpadding="0" cellspacing="0" class="tab0bor fl" style="margin-left:8%;">
						            <tr>
						                <th>日发电量：</th>
							            <td><span id="power">--MWh</span></td>
						            </tr>
						            <tr>
						                <th>月发电量：</th>
							            <td><span id="mon_power">--MWh</span></td>
						            </tr>
						            <tr>
						             	<th>年发电量：</th>
							            <td><span id="year_power">--MWh</span></td>
						            </tr>
						            <tr>
						             	<th>累计发电量：</th>
							            <td><span id="ljfdl">--MWh</span></td>
						            </tr>
					            </table>
					            <div class="fl h230" style="margin-top: 25px;width:45%;margin-left:1%;">
					            	 <div id="circle1" class="c100 p10 green" style="margin-left: 33%;font-size: 100px;margin-bottom: 5px;margin-top: 19px;"> 
					                    <span  id="year_plan_com_rate">10%</span>
					                    <div class="slice">
					                        <div class="bar" style="transform: rotate(36deg);"></div>
					                        <div class="fill"></div>
					                    </div>
				                	</div>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tab0bor2">
							             <tr>
							                <th>计划月发电量：</th>
								            <td style="width: 40%;"><span id="jhyfdl">--MWh</span></td>
							            </tr>
							            <tr>
								            <th>计划年发电量：</th>
								            <td style="width: 40%;"><span id="jhnfdl">--MWh</span></td>
							            </tr>
						            </table>
					            </div>
                 	 		</div>
                 	 		<div class="w50 h300 fl" style="width: 50%;">
                 	 			<div class="h268" id="mrfdlzzt"></div>
                 	 		</div>
                 	 	</div>
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius">
	              <div   class="h360"> 
	                 <h4 class="subtitle">储能系统</h4>
	                 <div class="h300 w80 fl"  style="width:87%;"   id="cnxt"></div>
	                 <div class="w20 fl detnum"  style="width:13%;" >
	                 	<ul  style="margin-top:20px;">
                  			<li>
                  				<span class="num" id="tol_phi">--kWh</span>
                  				<span>累计放电量</span>
                  				<span class="num mt10" id="tol_phe">--kWh</span>
                  				<span>累计充电量</span>
                  			</li>
                  		</ul>
	                 </div>
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius">
	              <div   class="h360" > 
	                 <h4 class="subtitle">充电系统</h4>
	                 <div class="w40 fl h200" style="padding-top:70px;text-align: center; ">
	                 	 <div class="w31 h160 fl mt15" style="margin-left: 5%;" id="cdzsj1">
				              <div  id="circle2" class="circle brgreen" >
							 		<a href="javascript:void(0);" id="tol_cha_vol" style="cursor: default;" onfocus="this.blur();">0</a>
							 	</div>
							 	<p style="text-align: center;">累计充电量(MWh)</p>
	                 	 </div>
	                 	 <div class="w31 h160 fl mt15"  id="cdzsj2">
	                 	 		<div  id="circle3" class="circle brred" >
							 		<a href="javascript:void(0);"  id="tol_cha_tim" style="cursor: default; " onfocus="this.blur();">0</a>
							 	</div>
							 	<p style="text-align: center;">累计充电时(h)</p>
	                 	 </div>
	                 	 <div class="w31 h160 fl mt15" id="cdzsj3">
	                 		 <div  id="circle4" class="circle bryel" >
						 		<a  href="javascript:void(0);" id="tol_cha_gen_eff_hours"  style="cursor: default;" onfocus="this.blur();">0</a>
						 	</div>
						 	<p style="text-align: center;">充电有效时(h)</p>
	                 	 </div>
	                 </div>
	                <div class="w60 fl" >
	                 	 <div class="h300 w100" id="ycdxq"></div>
	                 </div>
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius">
	              <div   class="h360"> 
	                  <h4 class="subtitle">负荷系统</h4>
	                  <div class="h300 w80 fl"   style="width:87%;"  id="fhxt"></div>
	                  <div class="w20 fl detnum"  style="width:13%;"  >
	                  		<ul  style="margin-top:20px;"  >
	                  			<li>
	                  				<span class="num" id="fhydl">--MWh</span>
	                  				<span>累计用电量</span>
	                  			</li>
	                  		</ul>
	                  </div>
	              </div>
	            </div>
	            <div style="height:50px;"></div>
			 </div>
		</div>
		<div class="w25 fl">
			<div class="mr15" style="margin-left:10px;">
				<div class="mt10 bg-ff " style="border-top-left-radius: 5px; border-top-right-radius: 5px;">
					<h4 class="rigtitle" style="border-top-left-radius: 5px; border-top-right-radius: 5px;">设备列表</h4>
	              	<div  class="sblist"> 
	              		<dl id="sbList" class="" style="min-height:213px;">
			              	 
			            </dl>
	              	</div>
	            </div>
	            <div class="cler"></div>
	            <div class="mt10 bg-ff  bor-radius">
	              <h4 class="rigtitle">环境信息</h4>
	              <div  class="h350"> 
	              	 <div class="w50 h230 fl" id="ssdqy" style="text-align: center;">
	              	 		<div  class="circle brblue qy-circle"   >
						 		<a href="javascript:void(0);" style="border-bottom:1px solid #9BC9D6;line-height :60px;width:80%;cursor: default;" onfocus="this.blur();"  id="windLvl">--</a>
						 		<a href="javascript:void(0);" style="line-height :35px; cursor: default; " onfocus="this.blur();"  id="windDirStr">--</a>
						 	</div>
						 	<p style="text-align: center;margin-top:10px;">大气压:<span id="air">0.00hPa</span></p>
	              	 </div>
	              	 <div class="w50 h230 fl hjinfo">
	              	 	<dl>
			              	<dd> 
			                	<span>环境温度：<em id="temp">0℃</em></span>
			              	</dd>
			              	<dd> 
			                	<span>环境湿度：<em id="humi">0%</em></span> 
			              	</dd>
			              	<dd> 
			                	<span>组件温度：<em id="tempPV">0℃</em></span> 
			              	</dd>
			              	<dd> 
			                	<span>瞬时辐射：<em id="htv">0.00W/㎡</em></span>
			              	</dd>
			            </dl>
	              	 </div>
	              	  <div class="w100 h100 fl hjinfo">
	              	 	<dl>
			              	<dd> 
			                	<span style="margin-left: 10%;">日辐射量：<em id="dayHg">0.00kWh/㎡</em></span> 
			              	</dd>
			              	<dd> 
			                	<span style="margin-left: 10%;">总辐射量：<em id="hg">0.00kWh/㎡</em></span>
			              	</dd>
			            </dl>
	              	 </div>
	              </div>
	            </div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="<%=basePath %>js/jquery.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath %>js/layer/layer.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath %>js/jsall.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath %>js/echarts.min.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath%>js/circle/js/percircle.js?pubVersion=201802070001"></script>
	
	<script>
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$(function(){
			getSb();
		    showRight();
			getRealHj();
			
			setInterval(function(){
				getSb();
			    showRight();
				getRealHj();
			},60000*15);
		})
		
function getSb(){
		var pws_id = $("#pws_id").val();
		$.ajax({
	    	url:url+"getPwsAllAppTypByPwsId.htm",
	    	data : "pws_id="+pws_id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000"){
	    			 
	    			 if(data.data.length> 0){
	    				 var htm = "";
	    				 for(var i = 0 ; i < data.data.length ; i++){
    						 var lst = data.data[i];
	    					 var cls = "";
	    					 /*
	    					 光伏逆变器	GFNBQ           sb1
							储能逆变器	CNNBQ           sb2
							储能电池	CNDC            sb12
							环境监测仪	HJJCY           sb10
							DC/DC	DCDC            sb6
							变压器	BYQ                 sb7
							电表	DB                  sb8
							电能质量检测装置	DNZLJCZZ    sb14
							汇流箱	HLX                 sb9
							交流配电柜	JLPDG           sb3
							直流配电柜	ZLPDG           sb4
							解列装置	JLZZ            sb11
							线路保护	XLBH            sb13
							交流充电桩	JLCDZ           sb5
							直流充电桩	ZLCDZ           sb5
							控制器	KZQ                 sb15
							微网系统	WWXT            sb16
							*/
	    					 if(lst.typ_ide == "GFNBQ"){
	    						 cls = "sb1";
	    					 }else if(lst.typ_ide == "CNNBQ"){
	    						 cls = "sb2";
	    					 }else if(lst.typ_ide == "CNDC"){
	    						 cls = "sb12";
	    					 }else if(lst.typ_ide == "HJJCY"){
	    						 cls = "sb10";
	    					 }else if(lst.typ_ide == "DCDC"){
	    						 cls = "sb6";
	    					 }else if(lst.typ_ide == "BYQ"){
	    						 cls = "sb7";
	    					 }else if(lst.typ_ide == "DB"){
	    						 cls = "sb8";
	    					 }else if(lst.typ_ide == "DNZLJCZZ"){
	    						 cls = "sb14";
	    					 }else if(lst.typ_ide == "HLX"){
	    						 cls = "sb9";
	    					 }else if(lst.typ_ide == "JLPDG"){
	    						 cls = "sb3";
	    					 }else if(lst.typ_ide == "ZLPDG"){
	    						 cls = "sb4";
	    					 }else if(lst.typ_ide == "JLZZ"){
	    						 cls = "sb11";
	    					 }else if(lst.typ_ide == "XLBH"){
	    						 cls = "sb13";
	    					 }else if(lst.typ_ide == "JLCDZ"){
	    						 cls = "sb5";
	    					 }else if(lst.typ_ide == "ZLCDZ"){
	    						 cls = "sb5";
	    					 }else if(lst.typ_ide == "KZQ"){
	    						 cls = "sb15";
	    					 }else if(lst.typ_ide == "WWXT"){
	    						 cls = "sb16";
	    					 } 
    						 htm += "<dd id="+lst.app_typ_id+" typ_ide="+lst.typ_ide+"  typ_name="+lst.equ_typ_nam+"><i class="+cls+"></i>"+
    						 		"<p>"+
				                	"<span>"+lst.equ_typ_nam+"</span> "+
				                	"<span><em>"+lst.equ_count+"</em>&nbsp;台</span>"+
				                	"</p>"+
				              		"</dd>";
    					 }
	    				 if(data.data.length%2 > 0){
	    					 htm += "<dd id='noclick' > "+
			              			"</dd>";
	    				 }
	    				 $("#sbList").html(htm);
	    			 }
	    			 
	    			 $(".sblist dd").hover(function(){
	    				 var id = $(this).attr("id");
	    				 if("noclick" != id){
    						$(this).addClass("backOp");
	    				 }
    				 },function(){
	    				$(this).removeClass("backOp");
    				 })
	    				
	    			 $(".sblist dd").click(function(){
    					var app_typ_id = $(this).attr("id");
    					if("noclick" != app_typ_id){
	    					var typ_ide = $(this).attr("typ_ide");
	    					var utlP =  "<%=basePath %>commens/zhjk/main.htm?app_typ_id="+app_typ_id+"&pws_id="+pws_id+"&typ_ide="+typ_ide;
	    					
	    					//加载底部导航
	    					var menuName = $(this).attr("typ_name");
	    					var menuHref = utlP; 
	    					var ThreeMenu =  '<a class="bottom-nav" href="'+menuHref+'"  target="main" id="threeLevel"  style="padding-left: 0;"><i style="font-style: normal;font-size: 14px;width: 10px;height: 38px;margin-right: 5px;padding-right: 0;background: url('+jumpPageUrl+'/images/jiantou.png) no-repeat;background-size: 7px 15px;margin-top: 2px;float: left;"></i><i class="bdf"></i>'+menuName+'</a>';
	    					$(parent.frames["bottom"].document).find("#nav-bot").append(ThreeMenu);
	    					
	    					//加载之后跳转页面
	    					location.href = utlP ;
    					}
    				})
    				getPws(pws_id);	
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
}
		
function showRight(){
	var userId = $("#userId").val();
	var param  = "use_id="+userId;
	$.ajax({
    	url:url+"getIntMonLeftSide.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data.length > 0 ){
    				 var d  = data.data[0];
    				 $("#sec_ope").html(getIsZero(d.safeRunDays)+"天");
    			 }else{
    				 $("#sec_ope").html("0天");
    			 }
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
		
		
		function getPws(pws_id){
			 
			$.ajax({
				url:url+"getPwsInfByPwsId.htm",
				type:"post",
				data:"pws_id="+pws_id,
				dataType:"json",
				success:function(data){
					if(data.resultcode=="USR000"){
						var data=data.data[0];
						if(data.pwsInfLst){
							 for(var i=0;i<data.pwsInfLst.length;i++){
								 var d=data.pwsInfLst[i];
								 $("#pws_nam").html(d.pws_nam);
		    					 var sta = '正常运行';
		    					 if(d.cur_sta == 1){
		    						 $("#cur_sta").removeClass("yel").removeClass("red").addClass("blue");
		    						 sta = '计划';
		    					 }else if(d.cur_sta == 2){
		    						 $("#cur_sta").removeClass("red").removeClass("blue").addClass("yel");
		    						 sta = '在建';
		    					 }else if(d.cur_sta == 3){
		    						 $("#cur_sta").removeClass("yel").removeClass("blue").addClass("red");
		    						 sta = '投运';
		    					 }
		    					 $("#cur_sta").html(sta);
		    					 $("#con_nam").html(getIsNull(d.con_nam));
		    					 $("#con_mob").html(getIsNull(d.con_mob));
		    					 $("#com_nam").html(getIsNull(d.com_nam));
		    					 $("#pws_add").html(getIsNull(d.pws_add));
		    					 $("#typ_nam").html(getIsNull(d.typ_nam));
		    					 $("#use_nam").html(getIsNull(d.dev_add_num));
		    					 $("#opt_com_nam").html(getIsNull(d.opt_com_nam));
		    					 //$("#sec_ope").html(getFixedNum(d.sec_ope)+"天");
		    					 $("#fnl_mat_tim").html(getLocalDateAndTime(d.fnl_mat_tim,2));
		    					 $("#nxt_mat_tim").html(getLocalDateAndTime(d.nxt_mat_tim,2));
		    					 $("#are_cov").html(getFixedNum(d.rat_pow)+"kW");
							 }
		    			 }
		    			 if(data.pwsPicInfLst){
		    				 for(var i=0;i<data.pwsPicInfLst.length;i++){
								 var d=data.pwsPicInfLst[0];
								 $(".dzimg").css("background","url("+d.pic_url+") no-repeat");
								 $(".dzimg").css("background-size","cover");
		    				 }
		    			 }
		    			 if(data.pvPcChaLoadLineInfLst){
		    				 for(var i=0;i<data.pvPcChaLoadLineInfLst.length;i++){
								 var d=data.pvPcChaLoadLineInfLst[i];
								 $("#pv_power").html(getFixedNum(d.pv_power)+"kW");
		    					 $("#chp_power").html(getFixedNum(d.chp_power)+"kW");
		    					 $("#load_power").html(getFixedNum(d.load_power)+"kW");
		    					 $("#pc_power").html(getFixedNum(d.pc_power)+"kW");
		    					 $("#line_power").html(getFixedNum(d.line_power)+"kW");
		    					 $("#tol_tim").html(d.tol_tim);
		    				 }
		    			 }
		    			 if(data.pvPcChaLoadLineInfTop1Lst){
		    				 for(var i=0;i<data.pvPcChaLoadLineInfTop1Lst.length;i++){
								 var d=data.pvPcChaLoadLineInfTop1Lst[i];
								
		    					 $("#gfgl").html(getFixedNum(d.pv_power)+"kW");
		    					 $("#cdzgl").html(getFixedNum(d.chp_power)+"kW");
		    					 $("#fhgl").html(getFixedNum(d.load_power)+"kW");
		    					 $("#cngl").html(getFixedNum(d.pc_power)+"kW");
		    					 $("#dwgl").html(getFixedNum(d.line_power)+"kW");
		    					 $("#tol_tim").html(d.tol_tim);
		    				 }
		    				 
		    			 }
		    			 if(data.pvPcChaLodMonPowerLst){
		    				 for(var i=0;i<data.pvPcChaLodMonPowerLst.length;i++){
								 var d=data.pvPcChaLodMonPowerLst[i];
		    				 /* $("#power").html(d.power); */
	    					 $("#feed_net_power").html(getFixedNum(d.feed_net_power)+"kWh");
		    				 $("#phi").html(getFixedNum(d.phi)+"kWh");
		    				 $("#phe").html(getFixedNum(d.phe)+"kWh");
		    				 $("#cha_vol").html(getFixedNum(d.cha_vol)+"kWh");
		    				 $("#ele_con").html(getFixedNum(d.ele_con)+"kWh");
		    				 $("#tol_tim").html(d.tol_tim);
		    				 }
		    			 }
		    			 if(data.pvFctPowerLst){
		    				 for(var i=0;i<data.pvFctPowerLst.length;i++){
								 var d=data.pvFctPowerLst[i];
								 $("#pv_fct_power").html(getFixedNum(d.pv_fct_power)+"kWh");
		    					 $("#tol_tim").html(d.tol_tim);
		    				 }
		    				 
		    			 }
		    			 if(data.schPowerLst){
		    				 for(var i=0;i<data.schPowerLst.length;i++){
								 var d=data.schPowerLst[i];
								 $("#sch_power").html(getFixedNum(d.sch_power)+"kWh");
		    					 $("#tol_tim").html(d.tol_tim);
		    				 }
		    				 
		    			 }
		    			 if(data.hvRealPowerLst){
		    				 for(var i=0;i<data.hvRealPowerLst.length;i++){
								 var d=data.hvRealPowerLst[i];
								 $("#hv").html(getFixedNum(d.hv)+"Wh/㎡");
	    					 	$("#pv_power").html(getFixedNum(d.pv_power)+"kW");
		    				 }
		    			 }
		    			 if(data.pwsInfTolTop1Lst){
		    				 for(var i=0;i<data.pwsInfTolTop1Lst.length;i++){
								 var d=data.pwsInfTolTop1Lst[i];
		    					 $("#tol_feed_net_power").html(getFixedNum(getFixedNum(d.tol_feed_net_power)/1000)+"MWh");
	    						 $("#tol_ipt_power").html(getFixedNum(getFixedNum(d.tol_ipt_power)/1000)+"MWh");
		    					 $("#fdl").html(getFixedNum(d.power/1000)+"MWh");
		    					 $("#mon_power").html(getFixedNum(d.mon_power/1000)+"MWh");
		    					 $("#year_power").html(getFixedNum(d.year_power/1000)+"MWh");
		    					 $("#power").html(getFixedNum(d.power/1000)+"MWh");
		    					 $("#ljfdl").html(getFixedNum(d.tol_power/1000)+"MWh");
		    					 /*圈1*/
		    					 $("#year_plan_com_rate").html(getFixedNum5(d.year_plan_com_rate)+"%");
		    					 //$("#year_plan_com_rate").html(90);
		    					 var tmp = mathRound(getFixedNum(d.year_plan_com_rate));
		    					 $("#circle1").removeClass("p10").addClass("p"+tmp);
		    					
		    					 $("#tol_phi").html(getFixedNum(d.tol_phi)+"kWh");
		    					 $("#tol_phe").html(getFixedNum(d.tol_phe)+"kWh");
		    					 /*圈2*/
		    					 $("#tol_cha_vol").html(getFixedNum(getFixedNum(d.tol_cha_vol)/1000));
		    					 //$("#tol_cha_vol").html(90);
		    					 //$("#circle2").removeClass("p10").addClass("p"+90);
		    					/*  var tmp1 = mathRound(getFixedNum(d.tol_cha_vol));
								 $("#circle2").removeClass("p10").addClass("p"+tmp1); */
								 /*圈3*/
		    					 $("#tol_cha_tim").html(getFixedNum(d.tol_cha_tim));
		    					// $("#tol_cha_tim").html(90);
								 //$("#circle3").removeClass("p10").addClass("p"+90);
								/*  var tmp2 = mathRound(d.tol_cha_tim);
								 $("#circle3").removeClass("p10").addClass("p"+tmp2); */
								 /*圈4*/
		    					 $("#tol_cha_gen_eff_hours").html(getFixedNum(d.tol_cha_gen_eff_hours));
		    					 //$("#tol_cha_gen_eff_hours").html(90);
		    					 //$("#circle4").removeClass("p10").addClass("p"+90);
		    					 /* var tmp3 = mathRound(getFixedNum(d.tol_cha_gen_eff_hours));
								 $("#circle4").removeClass("p10").addClass("p"+tmp3); */
								 
								 $("#fhydl").html(getFixedNum5(d.tol_ele_con/1000)+"MWh");
		    				 }
		    			 }
		    			 if(data.pwsPlanMonPowerLst){
		    				 for(var i=0;i<data.pwsPlanMonPowerLst.length;i++){
								 var d=data.pwsPlanMonPowerLst[i];
								 if(d != null){
									 $("#jhyfdl").html(getFixedNum(d.plan_power/1000)+"MWh");
								 }else{
									 $("#jhyfdl").html(0+"MWh");
								 }
		    				 }
		    				
		    			 }
		    			 if(data.pwsPlanYearPowerLst){
		    				 for(var i=0;i<data.pwsPlanYearPowerLst.length;i++){
								 var d=data.pwsPlanYearPowerLst[i];
		    					 $("#jhnfdl").html(getFixedNum(d.plan_power/1000)+"MWh");
		    				 }
		    			 }
		    			 setChart(data.pvPcChaLodMonPowerLst);
		    			 setChart1(data.pvPcChaLodMonPowerLst);
		    			 setChart2(data.pvPcChaLodMonPowerLst);
		    			 setChart3(data.pvPcChaLoadLineInfLst);
		    			 setChart6(data.hvRealPowerLst,data.schPowerLst,data.hvRealPowerLst);
		    			 setChart4(data.pvPcChaLodMonPowerLst);
		    			 setChart5(data.pvPcChaLodMonPowerLst);
		    			 layer.close(indexlayer);
					}else{
						 layer.close(indexlayer);
						layer.alert(data.desc);
					}
				}
				
			})
		}
		function setChart(data){
			var xTime=[];
			var y1=[];
			for(var a=0;a<data.length;a++){
				var d=data[a];
				var dT = '';
				if(d.tol_tim.indexOf("-")> -1 ){
					dT = d.tol_tim.split("-")[1]+"-"+d.tol_tim.split("-")[2];
				} 
				xTime.push(dT);
				y1.push(getFixedNum5(d.ele_con));
			}
			var myChart = echarts.init(document.getElementById('fhxt'),'shine');
			var option = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    legend: {
				        data: ['负荷用电量'],
				        top: 10
				    },
				    grid: {
				    	left : '80',
						top : '60',
						right : '20',
						bottom : '20'
			        },
				    xAxis:  {
				        type: 'category',
				        data: xTime,//后台传的名称
				        splitLine:{show: false},
				        axisLine:false,
				    },
				    yAxis: {
						type : 'value',
						name : '电量(kWh)',
						axisLabel : {
							formatter : '{value}'
						}
					},
				    series: 
				    {
						name : '负荷用电量',
						type : 'bar',
						smooth : true,
						data : y1,
						symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#07CB47'
							}
						} 
					}
				    
				};
		                    
				myChart.setOption(option);
		}
		function setChart1(data){
			xTime=[];
			y1=[];
			y2=[];
			for(var a=0;a<data.length;a++){
				var d=data[a];
				var dT = '';
				if(d.tol_tim.indexOf("-")> -1 ){
					dT = d.tol_tim.split("-")[1]+"-"+d.tol_tim.split("-")[2];
				} 
				xTime.push(dT);
				y1.push(getFixedNum5(d.phi));
				y2.push(getFixedNum5(d.phe));
			}
			var myChart1 = echarts.init(document.getElementById('cnxt'),'shine');
			var option = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    grid: {
				    	left : '80',
						top : '60',
						right : '20',
						bottom : '20'
			        },
			        legend: {
				        data: [ '储能充电量','储能放电量'],
				        top: 10,
				    },
				    xAxis:  {
				        type: 'category',
				        data: xTime,//后台传的名称
				        splitLine:{show: false},
				        axisLine:false,
				    },
				    yAxis: {
						type : 'value',
						name : '电量(kWh)',
						axisLabel : {
							formatter : '{value}'
						}
					},
				    series:[ 
				    {
						name : '储能充电量',
						type : 'bar',
						smooth : true,
						data : y1,
						 symbol : 'none' ,
							itemStyle : {
								normal : {
									color : '#EDB213'
								}
							}
					}, {
						name : '储能放电量',
						type : 'bar',
						smooth : true,
						data : y2,
						symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#07CB47'
							}
						} 
					}]
			};
		                    
				myChart1.setOption(option);
		}
		function setChart2(data){
			xTime=[];
			y1=[];
			y2=[];
			for(var a=0;a<data.length;a++){
				var d=data[a];
				var dT = '';
				if(d.tol_tim.indexOf("-")> -1 ){
					dT = d.tol_tim.split("-")[1]+"-"+d.tol_tim.split("-")[2];
				} 
				xTime.push(dT);
				y1.push(getFixedNum5(d.feed_net_power));
				y2.push(getFixedNum5(d.ipt_power));
			}
			var myChart2 = echarts.init(document.getElementById('bwxt'),'shine');
			var option = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    legend: {
				        data: ['馈网电量','输入电量'],
				        top: 10,
				    },
				    grid: {
				    	left : '80',
						top : '60',
						right : '20',
						bottom : '20'
				        },
				    xAxis:  {
				        type: 'category',
				        data: xTime,//后台传的名称
				        splitLine:{show: false},
				        axisLine:false,
				    },
				    yAxis: {
				    	type : 'value',
						name : '电量(kWh)',
						axisLabel : {
							formatter : '{value}'
						}
				    },
				    series: 
				    [{
						name : '馈网电量',
						type : 'bar',
						smooth : true,
						data : y1,
						symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#EDB213'
							}
						} 
					},{
						name : '输入电量',
						type : 'bar',
						smooth : true,
						data : y2,
						symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#07CB47'
							}
						} 
					}]
				    
				};
		                    
				myChart2.setOption(option);
		}
		function setChart3(data){
			var xTime=[];
			var y1=[];
			var y2=[];
			var y3=[];
			var y4=[];
			var y5=[];
			for(var i=0;i<data.length;i++){
				var d=data[i];
				xTime.push(getLocalDateAndTime(d.tol_tim,6));
				y1.push(getFixedNum5(d.pv_power));
				y2.push(getFixedNum5(d.pc_power));
				y3.push(getFixedNum5(d.chp_power));
				y4.push(getFixedNum5(d.line_power));
				y5.push(getFixedNum5(d.load_power));
			}
			var myChart3 = echarts.init(document.getElementById('gccd'),'shine');
			var option3 = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    legend: {
				        data: ['光伏功率', '储能功率', '充电桩功率', '并网功率', '负荷功率'],
				        top: 10,
				    },
				    grid: {
				    	left : '80',
						top : '60',
						right : '20',
						bottom : '20'
				        },
				    xAxis:  {
				        type: 'category',
				        data: xTime,//后台传的名称
				        splitLine:{show: false},
				        axisLine:false,
				    },
				    yAxis: {
				    	type : 'value',
						name : '功率(kW)',
						axisLabel : {
							formatter : '{value}'
						}
				    },
				    series: [
				        {
						name : '光伏功率',
						type : 'line',
						smooth : true,
						data : y1,
						symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#EDB213'
							}
						} 
					},{
						name : '储能功率',
						type : 'line',
						smooth : true,
						data : y2,
						symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#07CB47'
							}
						}  
					},{
						name : '充电桩功率',
						type : 'line',
						smooth : true,
						data : y3,
						symbol : 'none',
						itemStyle : {
							normal : {
								color : '#5FB0E3'
							}
						}  
					},{
						name : '并网功率',
						type : 'line',
						smooth : true,
						data : y4,
						symbol : 'none',
						itemStyle : {
							normal : {
								color : '#FE784E'
							}
						}
					},{
						name : '负荷功率',
						type : 'line',
						smooth : true,
						data : y5,
						symbol : 'none',
						itemStyle : {
							normal : {
								color : '#7A057A'
							}
						} 
					}
			         ]
				    
				};
		       myChart3.setOption(option3);
		}
		function setChart6(data,data2,data3){
			var xTime=[];
			var y1=[];
			var y2=[];
			var y3=[];
			var y4=[];
			for(i=0;i<data.length;i++){
				var d=data[i];
				xTime.push(getLocalDateAndTime(d.tol_tim,6));
				y1.push(getFixedNum5(d.hv));
				y2.push(getFixedNum5(d.pv_power));
			}
			/* for(i=0;i<data2.length;i++){
				var d2=data2[i];
				y3.push(d2.pv_fct_power);
			} */
			/* for(i=0;i<data3.length;i++){
				var d3=data3[i];
				y4.push(d3.sch_power);
			} */
			
			var myChart6 = echarts.init(document.getElementById('gffdqx'),'shine');
			var option6 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			    	left : '80',
					top : '60',
					right : '80',
					bottom : '30'
			        },
		        legend: {
			        data: ['瞬时辐射', '光伏功率'],
			        top: 10,
			    },
			    xAxis:  {
			        type: 'category',
			        data: xTime,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			    },
			    yAxis: [{
			    	type : 'value',
					name : '功率(kW)',
					axisLabel : {
						formatter : '{value}'
					}
			    },{
				    	type : 'value',
						name : '瞬时辐射(W/㎡)',
						axisLabel : {
							formatter : '{value}'
						},
						min : 0 ,
						max : 1000
			    }
			    ],
			    series: [
			        {
						name : '瞬时辐射',
						type : 'line',
						smooth : true,
						yAxisIndex: 1,
						data : y1,
						symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#EDB213'
							}
						} 
					},
			        {
			            name: '光伏功率',
			            type: 'line',
						smooth : true,
			            data: y2 ,
			            symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#07CB47'
							}
						} //后台传的数据
		           },
			       /*  {
			            name: '光伏预测功率',
			            type: 'line',
						smooth : true,
			            data: y3 //后台传的数据
		           }, */
			       /*  {
			            name: '调度功率',
			            type: 'line',
						smooth : true,
			            data: y4 //后台传的数据
		           } */
					]
			    
			};
			myChart6.setOption(option6);
		}
		function setChart4(data){
			var xTime=[];
			var y1=[];
			for(var i=0;i<data.length;i++){
				var d=data[i];
				var dT = '';
				if(d.tol_tim.indexOf("-")> -1 ){
					dT = d.tol_tim.split("-")[1]+"-"+d.tol_tim.split("-")[2];
				} 
				xTime.push(dT);
				y1.push(getFixedNum5(d.cha_vol));
			}
			var myChart4 = echarts.init(document.getElementById('ycdxq'),'shine');
			var option4 = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    legend : {
						data : [ '充电量' ],
						top : 10,
					},
					grid: {
				    	left : '60',
						top : '60',
						right : '20',
						bottom : '20'
				        },
				    xAxis:  {
				        type: 'category',
				        data:xTime,//后台传的名称
				        splitLine:{show: false},
				        axisLine:false,
				    },
				    yAxis: {
				    	type : 'value',
						name : '电量(kWh)',
						axisLabel : {
							formatter : '{value}'
						}
				    },
				    series: 
				    {
			            name: '充电量',
			            type: 'bar',
						smooth : true,
			            data: y1,
			            symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#EDB213'
							}
						} //后台传的数据
		           } 
				    
				};
		                    
				myChart4.setOption(option4);
		}
		function setChart5(data){
			var xTime=[];
			var y1=[];
			for(var i=0;i<data.length;i++){
				var d=data[i];
				var dT = '';
				if(d.tol_tim.indexOf("-")> -1 ){
					dT = d.tol_tim.split("-")[1]+"-"+d.tol_tim.split("-")[2];
				} 
				xTime.push(dT);
				y1.push(getFixedNum5(d.power));
			}
			var myChart5 = echarts.init(document.getElementById('mrfdlzzt'),'shine');
			var option5 = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    legend : {
						data : [ '发电量' ],
						top : 10,
					},
					 grid: {
					    	left : '60',
							top : '60',
							right : '20',
							bottom : '20'
					        },
				    xAxis:  {
				        type: 'category',
				        data: xTime,//后台传的名称
				        splitLine:{show: false},
				        axisLine:false,
				    },
				    yAxis: {
				    	type : 'value',
						name : '电量(kWh)',
						axisLabel : {
							formatter : '{value}'
						}
				    },
				    series: 
				    {
			            name: '发电量',
			            type: 'bar',
						smooth : true,
			            data: y1,
			            symbol : 'none',
						 itemStyle : {
							normal : {
								color : '#EDB213'
							}
						} //后台传的数据
		           } 
				    
				};
		                    
				myChart5.setOption(option5);
		}
		
		
		
		function getRealHj(){
			var pws_id = $("#pws_id").val();
			$.ajax({
				url:url+"getEnvInfoNew.htm",
				type:"post",
				data:"pws_id="+pws_id,
				dataType:"json",
				success:function(data){
					if(data.resultcode=="USR000"){
						if(data.data){
							for(var i=0;i<data.data.length;i++){
								var t=data.data[i];
								$("#humi").html(getFixInt(t.humi)+"%");
								$("#temp").html(getFixInt(t.temp)+"℃");
								$("#tempPV").html(getFixInt(t.tempPV)+"℃");
								$("#htv").html(getFixedNum(t.hgv)+"W/㎡");
								$("#hg").html(getFixedNum(t.hg)+"kWh/㎡");
								$("#dayHg").html(getFixedNum(t.dayHg)+"kWh/㎡");
								
								
								$("#windDirStr").html(t.windDirStr);
								$("#windLvl").html(t.windLvl);
								$("#air").html(getFixInt(t.air)+"hPa");
							}
							getHjChart(data.data);
						}
					}else{
						layer.alert(data.desc);
					}
				}
			})
		}
		
		
		function getHjChart(data){
			var setData = [];
			if(data[0] != "" && data[0] != undefined){
				setData.push({value:getFixedNum(data[0].temp), name:'环境温度'})
				setData.push({value:getFixedNum(data[0].humi), name:'环境湿度'})
				setData.push({value:getFixedNum(data[0].tempPV), name:'机内温度'})
				setData.push({value:getFixedNum(data[0].htv), name:'瞬时辐射'})
				setData.push({value:getFixedNum(data[0].dayHg), name:'日辐射量'})
				setData.push({value:getFixedNum(data[0].hg), name:'总辐射量'})
			}else{
				setData.push({value:0, name:'环境温度'})
				setData.push({value:0, name:'环境湿度'})
				setData.push({value:0, name:'机内温度'})
				setData.push({value:0, name:'瞬时辐射'})
				setData.push({value:0, name:'日辐射量'})
				setData.push({value:0, name:'总辐射量'})
			}
			
			/* var myChart11 = echarts.init(document.getElementById('ssdqy'),'shine');
			option7 = {
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    }, 
			    series : [
			        {
			            name:'',
			            type:'pie',
			            radius : ['50%', '70%'],
			            itemStyle : {
			                normal : {
			                    label : {
			                        show : false
			                    },
			                    labelLine : {
			                        show : false
			                    }
			                },
			                emphasis : {
			                    label : {
			                        show : false,
			                        position : 'left',
			                        textStyle : {
			                            fontSize : '12' 
			                        }
			                    }
			                }
			            },
			            data:setData
			        }
			    ]
			};
			myChart11.setOption(option7); */
		}
	</script>
</html>
