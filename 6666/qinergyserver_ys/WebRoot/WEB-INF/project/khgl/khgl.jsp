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
<title>电表报表</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>js/circle/css/normalize.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>js/circle/css/default.css?pubVersion=201802070001"> 
<link rel="stylesheet" href="<%=basePath %>js/circle/css/percircle.css?pubVersion=201802070001"> 
<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
</head>
<style>
.ml2mt3{
 	margin-left: 10%;
    margin-top: 20px;
}
</style>
<body>
	<input type="hidden" id="userId" value="${user.id}" >
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<div>
		<input type = "hidden" value="${pws_id}" name="" id="pws_id">
		<div class="bg-ff pb18 pl15 pt10 clr pl8">
				<div class="query">
					<div class="fl" style="margin-left: 2%;">
						 <select class="fl quinput w20"  id="companyOne"  onchange="setCompanytwo(this.value);">
           	   			 	<option value="qxz">请选择一级公司</option>
           	   			 </select>
           	   			 <select class="fl quinput w20"  id="companyTwo" style="margin-left:10px;" onchange="setCompanyThree(this.value);">
           	   			 	<option value="qxz">请选择二级公司</option>
           	   			 </select>
           	   			 <select class="fl quinput w20"  id="companyThree" style="margin-left:10px;" onchange="setPws(this.value);">
           	   			 	<option value="qxz">请选择三级公司</option>
           	   			 </select>
           	   			  <select class="fl quinput w20"  id="companyPws" style="margin-left:10px;"  >
           	   			 	<option value="qxz">请选择电站</option>
           	   			 </select>
					</div>
				</div>
				<div class="query mt15">
					<div class="fr" style="margin-right: 2%;">
						<input type="text" value="" id="end_tim" placeholder="请选择时间" class="fl fx Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM',onpicked:getData})">
					</div>
				</div>
				
		</div>
		<div class="kaohe1">
			<div class="a44">
				<p>考核评分</p>
			</div>
			<div class="w100" style="float: left; height: 165px;">
				<div class="kh2"  style="width: 19%;">
					<!-- <div id="circle1" class="c100 p30 yel" style="margin-left: 3%;margin-top:20px;">
						<span id="ass_score">0%</span>
						<div class="slice">
							<div class="bar" style="transform: rotate(36deg);"></div>
							<div class="fill"></div>
						</div>
					</div> -->  
					 <div class="w100 h140 ml2mt3" id="chart1"></div>
				</div>

				<div  style="width: 78%;margin-right: 3%;margin-left: auto;margin-top: 28px;">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list">
						<tr>
							<th>1月</th>
							<th>2月</th>
							<th>3月</th>
							<th>4月</th>
							<th>5月</th>
							<th>6月</th>
							<th>7月</th>
							<th>8月</th>
							<th>9月</th>
							<th>10月</th>
							<th>11月</th>
							<th>12月</th>
						</tr>
						<tbody id="datas">
							<tr><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td></tr>
						</tbody>
						
					</table>
				</div>
			</div>
		</div>

		<div class="kaohe2">
			<div class="a44"><p>缺陷处理</p></div>
			<div class="w100" style="float: left; height: 165px;">
				<div class="kh2">
					<!-- <div id="circle2" class="c100 p50 gre" style="margin-left: 3%;margin-top:20px;">
						<span id="def_tre_com">0%</span>
						<div class="slice">
							<div class="bar" style="transform: rotate(36deg);"></div>
							<div class="fill"></div>
						</div>
					</div>   -->
					 <div class="w100 h140 ml2mt3" id="chart2"></div>
				</div>
				<div class="kh1">
					<div class="pf"><h1 style="padding-top: 25px">评分</h1></div>
					<div class="pf2"><h2 style="padding-top: 25px" id="def_tre_score">0分</h2></div>
				</div>
				<div class="kh2">
					<div class="pf4" style="padding-top: 4%;">
						<p class="p1" style="margin-right:3px;" id="def_tre_rep_hour">0h</p>
						<p style="margin-right:3px;">维修响应时长</p>
					</div>
					<div class="pf4">
						<p class="p1" style="margin-right:3px;" id="mat_tsk_com_num">0次</p>
						<p style="margin-right:3px;">维修任务完成数</p>
					</div>
					<div class="pf4">
						<p class="p1" style="margin-right:3px;" id="mat_tsk_gen_num">0次</p>
						<p style="margin-right:3px;">维修任务生成数</p>
					</div>
				</div>
			</div>
		</div>
		<div class="kaohe2">
			<div class="a44"><p>计划电量完成率</p></div>
			<div class="w100" style="float: left; height: 165px;">
				<div class="kh2">
					<!-- <div id="circle3" class="c100 p70 blu" style="margin-left: 3%;margin-top:20px;">
						<span id="plan_power_com">0%</span>
						<div class="slice">
							<div class="bar" style="transform: rotate(36deg);"></div>
							<div class="fill"></div>
						</div>
					</div>   -->
					 <div class="w100 h140 ml2mt3" id="chart3"></div>
				</div>
				<div class="kh1">
					<div class="pf"><h1 style="padding-top: 25px">评分</h1></div>
					<div class="pf2" ><h2 style="padding-top: 25px" id="plan_power_score">0分</h2></div>
				</div>
				<div class="kh2">
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="year_rel_power">0MWh</p>
						<p style="padding-top: 15px;margin-right:3px;">年实际发电量</p>
					</div>
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="year_plan_power">0MWh</p>
						<p style="padding-top: 15px;margin-right:3px;">年计划发电量</p>
					</div>
				</div>
			</div>
		</div>
		<div class="kaohe2">
			<div class="a44"><p>安全检查完成率</p></div>
			<div class="w100" style="float: left; height: 165px;">
				<div class="kh2">
					<!-- <div id="circle4" class="c100 p80 gre" style="margin-left: 3%;margin-top:20px;">
						<span id="sec_che_com">0%</span>
						<div class="slice">
							<div class="bar" style="transform: rotate(36deg);"></div>
							<div class="fill"></div>
						</div>
					</div>   -->
					 <div class="w100 h140 ml2mt3" id="chart4"></div>
				</div>
				<div class="kh1">
					<div class="pf"><h1 style="padding-top: 25px">评分</h1></div>
					<div class="pf2" ><h2 style="padding-top: 25px" id="sec_che_score">0分</h2></div>
				</div>
				<div class="kh2">
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="mon_rel_sec_che_num">0次</p>
						<p style="padding-top: 15px;margin-right:3px;">当月实际安全检查完成数</p>
					</div>
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="mon_plan_sec_che_num">0次</p>
						<p style="padding-top: 15px;margin-right:3px;">当月安全检查计划数</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>
		<div class="kaohe2">
			<div class="a44"><p>检查（保养）完成率</p></div>
			<div class="w100" style="float: left; height: 165px;">
				<div class="kh2">
					<!-- <div id="circle5" class="c100 p90 yel" style="margin-left: 3%;margin-top:20px;">
						<span id="mat_com">0%</span>
						<div class="slice">
							<div class="bar" style="transform: rotate(36deg);"></div>
							<div class="fill"></div>
						</div>
					</div>   -->
					 <div class="w100 h140 ml2mt3" id="chart5"></div>
				</div>
				<div class="kh1">
					<div class="pf"><h1 style="padding-top: 25px">评分</h1></div>
					<div class="pf2"><h2 style="padding-top: 25px" id="mat_score">0分</h2></div>
				</div>
				<div class="kh2">
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="matd_num">0次</p>
						<p style="padding-top: 15px;margin-right:3px;">检修过的数量</p>
					</div>
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="shd_mat_num">0次</p>
						<p style="padding-top: 15px;margin-right:3px;">需要检修的数量</p>
					</div>
				</div>
			</div>
		</div>
		<div class="kaohe2">
			<div class="a44"><p>培训完成率</p></div>
			<div class="w100" style="float: left; height: 165px;">
				<div class="kh2">
					<!-- <div id="circle6" class="c100 p100 gre" style="margin-left: 3%;margin-top:20px;">
						<span id="tra_com">0%</span>
						<div class="slice">
							<div class="bar" style="transform: rotate(36deg);"></div>
							<div class="fill"></div>
						</div>
					</div>  --> 
					 <div class="w100 h140 ml2mt3" id="chart6"></div>
				</div>
				<div class="kh1">
					<div class="pf"><h1 style="padding-top: 25px">评分</h1></div>
					<div class="pf2"><h2 style="padding-top: 25px"id="tra_score">0分</h2></div>
				</div>
				<div class="kh2">
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="mon_rel_tra_num">0%</p>
						<p style="padding-top: 15px;margin-right:3px;">当月实际培训完成数</p>
					</div>
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="mon_plan_tra_num">0次</p>
						<p style="padding-top: 15px;margin-right:3px;">当月培训计划数</p>
					</div>
				</div>
			</div>
		</div>
		<div class="kaohe2">
			<div class="a44"><p>物资采购完成率</p></div>
			<div class="w100" style="float: left; height: 165px;">
				<div class="kh2">
					<!-- <div id="circle7" class="c100 p20 yel" style="margin-left: 3%;margin-top:20px;">
						<span id="mat_pur_com">0%</span>
						<div class="slice">
							<div class="bar" style="transform: rotate(36deg);"></div>
							<div class="fill"></div>
						</div>
					</div>   -->
					 <div class="w100 h140 ml2mt3" id="chart7"></div>
				</div>
				<div class="kh1">
					<div class="pf"><h1 style="padding-top: 25px">评分</h1></div>
					<div class="pf2"><h2 style="padding-top: 25px" id="mat_pur_score">0分</h2></div>
				</div>
				<div class="kh2">
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="mon_rel_mat_pur_num">0%</p>
						<p style="padding-top: 15px;margin-right:3px;">当月实际物资采购完成数</p>
					</div>
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="mon_plan_mat_pur_num">0次</p>
						<p style="padding-top: 15px;margin-right:3px;">当月物资采购计划数</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>
		<div class="kaohe2">
			<div class="a44"><p>巡视完成率</p></div>
			<div class="w100" style="float: left; height: 165px;">
				<div class="kh2">
					<!-- <div id="circle8" class="c100 p44 blu" style="margin-left: 3%;margin-top:20px;">
						<span id="pat_com">0%</span>
						<div class="slice">
							<div class="bar" style="transform: rotate(36deg);"></div>
							<div class="fill"></div>
						</div>
					</div> -->  
					 <div class="w100 h140 ml2mt3" id="chart8"></div>
				</div>
				<div class="kh1">
					<div class="pf"><h1 style="padding-top: 25px">评分</h1></div>
					<div class="pf2"><h2 style="padding-top: 25px" id="pat_score">0分</h2></div>
				</div>
				<div class="kh2">
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="mon_rel_pat_num">0%</p>
						<p style="padding-top: 15px;margin-right:3px;">当月实际巡视完成数</p>
					</div>
					<div class="pf3">
						<p class="p1" style="padding-top: 15px;margin-right:3px;" id="mon_plan_pat_num">0次</p>
						<p style="padding-top: 15px;margin-right:3px;">当月巡视计划数</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="cler mb50"></div>
	<script type="text/javascript" src="<%=basePath %>js/jquery.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath %>js/jsall.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath %>js/echarts.min.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath%>js/circle/js/percircle.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath%>js/checkCom.js?pubVersion=201802070001"></script>
	<script>
		$(function(){
			getCompanyOne();
			
			//图表显示出来
			setChart1(0);
			setChart2(0);
			setChart3(0);
			setChart4(0);
			setChart5(0);
			setChart6(0);
			setChart7(0);
			setChart8(0);
			
			$("#companyPws").change(function(){
				if($("#companyPws").val()!="" && $("#companyPws").val()!="qxz" && $("#companyPws").val()!= undefined && $("#end_tim").val()!="" ){
					getData();
				}
			})
		})
		
		function getData(){
			var param="";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "&pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			 
			if($("#end_tim").val()!=""){
				param+="&&date="+$("#end_tim").val()+"-01";
			}else{
				layer.alert("请选择时间");
				return;
			}
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url:url+"getPwsAssMagInfByPwsId.htm",
				data:param,
				type:"post",
				dataTyoe:"json",
				success:function(data){
					if(data.resultcode=="USR000"){
						
						var d=data.data[0];
						if(d !="" && d != undefined ){
							$("#ass_score").html(getFixedNum4(d.ass_score)+"%");
							var tmp1 = mathRound(getIsZero(d.ass_score));
	   						//$("#circle1").removeClass("p10").addClass("p"+getFixedNum4(tmp1));
							setChart1(getFixedNum4(tmp1));
							//缺陷
							$("#def_tre_score").html(getFixedNum4(d.def_tre_score)+"分");
							$("#def_tre_rep_hour").html(getFixedNum4(d.def_tre_rep_hour)+"h");
							$("#mat_tsk_com_num").html(getFixedNum4(d.mat_tsk_com_num)+"次");
							$("#mat_tsk_gen_num").html(getFixedNum4(d.mat_tsk_gen_num)+"次");
							$("#def_tre_com").html(getFixedNum4(d.def_tre_com)+"%");
							var tmp2 = mathRound(getIsZero(d.def_tre_com));
	   						//$("#circle2").removeClass("p10").addClass("p"+getFixedNum4(tmp2));
							setChart2(getFixedNum4(tmp2));
							//计划
							$("#plan_power_score").html(getFixedNum4(d.plan_power_score)+"分");
							$("#year_rel_power").html(getFixedNum(d.year_rel_power/1000)+"MWh");
							$("#year_plan_power").html(getFixedNum(d.year_plan_power/1000)+"MWh");
							$("#plan_power_com").html(getFixedNum4(d.plan_power_com)+"%");
							var tmp3 = mathRound(getIsZero(d.plan_power_com));
	   						//$("#circle3").removeClass("p10").addClass("p"+getFixedNum4(tmp3));
							setChart3(getFixedNum4(tmp3));
							//安全
							$("#sec_che_score").html(getFixedNum4(d.sec_che_score)+"分");
							$("#mon_rel_sec_che_num").html(getFixedNum4(d.mon_rel_sec_che_num)+"次");
							$("#mon_plan_sec_che_num").html(getFixedNum4(d.mon_plan_sec_che_num)+"次");
							$("#sec_che_com").html(getFixedNum4(d.sec_che_com)+"%");
							var tmp4 = mathRound(getIsZero(d.sec_che_com));
	   						//$("#circle4").removeClass("p10").addClass("p"+getFixedNum4(tmp4));
							setChart4(getFixedNum4(tmp4));
							//检查
							$("#mat_score").html(getFixedNum4(d.mat_score)+"分");
							$("#matd_num").html(getFixedNum4(d.matd_num)+"次");
							$("#shd_mat_num").html(getFixedNum4(d.shd_mat_num)+"次");
							$("#mat_com").html(getFixedNum4(d.mat_com)+"%");
							var tmp5 = mathRound(getIsZero(d.mat_com));
	   						//$("#circle5").removeClass("p10").addClass("p"+getFixedNum4(tmp5));
							setChart5(getFixedNum4(tmp5));
							//培训
							$("#tra_score").html(getFixedNum4(d.tra_score)+"分");
							$("#mon_rel_tra_num").html(getFixedNum4(d.mon_rel_tra_num)+"次");
							$("#mon_plan_tra_num").html(getFixedNum4(d.mon_plan_tra_num)+"次");
							$("tra_com").html(getFixedNum4(d.tra_com)+"%");
							var tmp6 = mathRound(getIsZero(d.tra_com));
	   						//$("#circle6").removeClass("p10").addClass("p"+getFixedNum4(tmp6));
							setChart6(getFixedNum4(tmp6));
							//物资
							$("#mat_pur_score").html(getFixedNum4(d.mat_pur_score)+"分");
							$("#mon_rel_mat_pur_num").html(getFixedNum(d.mon_rel_mat_pur_num)+"次");
							$("#mon_plan_mat_pur_num").html(getFixedNum4(d.mon_plan_mat_pur_num)+"次");
							$("#mat_pur_com").html(getFixedNum4(d.mat_pur_com)+"%");
							var tmp7 = mathRound(getIsZero(d.mat_pur_com));
	   						//$("#circle7").removeClass("p10").addClass("p"+getFixedNum4(tmp7));
							setChart7(getFixedNum4(tmp7));
							//巡视
							$("#pat_score").html(getFixedNum4(d.pat_score)+"分");
							$("#mon_rel_pat_num").html(getFixedNum4(d.mon_rel_pat_num)+"次");
							$("#mon_plan_pat_num").html(getFixedNum4(d.mon_plan_pat_num)+"次");
							$("#pat_com").html(getFixedNum4(d.pat_com)+"%");
							var tmp8 = mathRound(getIsZero(d.pat_com));
	   						//$("#circle8").removeClass("p10").addClass("p"+getFixedNum4(tmp8));
							setChart8(getFixedNum4(tmp8));
							
							if(d.pwsAssMagLst){
								var htmls="<tr>";
								for(var i=0;i<12;i++){
									var a=d.pwsAssMagLst[i];
									
									htmls+="<td>"+getFixedNum5(a.ass_score)+"</td>";
								}
								htmls+="</tr>";
								
							}
							$("#datas").html(htmls);
						}else{
							$("#ass_score").html(0+"%");
							var tmp1 = mathRound(0);
	   						//$("#circle1").removeClass("p10").addClass("p"+getFixedNum4(tmp1));
							setChart1(getFixedNum4(tmp1));
				
							$("#plan_power_com").html(0+"%");
							var tmp2 = mathRound(getIsZero(0));
	   						//$("#circle2").removeClass("p10").addClass("p"+getFixedNum4(tmp2));
							setChart2(getFixedNum4(tmp2));
							
							$("#plan_power_score").html(0+"分");
							$("#year_rel_power").html(0+"MWh");
							$("#year_plan_power").html(0+"MWh");
							$("#sec_che_com").html(0+"%");
							var tmp3 = mathRound(0);
	   						//$("#circle3").removeClass("p10").addClass("p"+getFixedNum4(tmp3));
							setChart3(getFixedNum4(tmp3));
							
							$("#sec_che_score").html(0+"分");
							$("#mon_rel_sec_che_num").html(0+"次");
							$("#mon_plan_sec_che_num").html(0+"次");
							$("#tra_com").html(0+"%");
							var tmp4 = mathRound(0);
	   						//$("#circle4").removeClass("p10").addClass("p"+getFixedNum4(tmp4));
							setChart4(getFixedNum4(tmp4));
							
							$("#tra_score").html(0+"分");
							$("#mon_rel_tra_num").html(0+"次");
							$("#mon_plan_tra_num").html(0+"次");
							$("#mat_pur_com").html(0+"%");
							var tmp5 = mathRound(0);
	   						//$("#circle5").removeClass("p10").addClass("p"+getFixedNum4(tmp5));
							setChart5(getFixedNum4(tmp5));
							
							$("#mat_pur_score").html(0+"分");
							$("#mon_rel_mat_pur_num").html(0+"次");
							$("#mon_plan_mat_pur_num").html(0+"次");
							$("#def_tre_com").html(0+"%");
							var tmp6 = mathRound(0);
	   						//$("#circle6").removeClass("p10").addClass("p"+getFixedNum4(tmp6));
							setChart6(getFixedNum4(tmp6));
							
							$("#def_tre_score").html(0+"分");
							$("#def_tre_rep_hour").html(0+"h");
							$("#mat_tsk_com_num").html(0+"次");
							$("#mat_tsk_gen_num").html(0+"次");
							$("#mat_com").html(0+"%");
							var tmp7 = mathRound(0);
	   						//$("#circle7").removeClass("p10").addClass("p"+getFixedNum4(tmp7));
							setChart7(getFixedNum4(tmp7));
							
							$("#mat_score").html(0+"分");
							$("#matd_num").html(0+"次");
							$("#shd_mat_num").html(0+"次");
							$("#pat_com").html(0+"%");
							var tmp8 = mathRound(0);
	   						//$("#circle8").removeClass("p10").addClass("p"+getFixedNum4(tmp8));
							setChart8(getFixedNum4(tmp8));
							
							$("#pat_score").html(0+"分");
							$("#mon_rel_pat_num").html(0+"次");
							$("#mon_plan_pat_num").html(0+"次");
							
							var htmls="<tr>";
							for(var i=0;i<12;i++){
								htmls+="<td>-</td>";
							}
							htmls+="</tr>";
							
							$("#datas").html(htmls);
						}
						
						layer.close(indexlayer);
						
					}else{
						layer.close(indexlayer);
						layer.alert(data.desc);
					}
				}
			})
		}
		
		
		var labelFromatter = {
			    normal : {
			        label : {
			            formatter : function (params){
			                return toDecimal(100 - toDecimal(params.value)) + '%'
			            },
			            textStyle: {
			                baseline : 'center'
			            }
			        }
			    },
			}
		var labelTop = {
			    normal : {
			    	color: '#FF764D',
			        label : {
			            show : true,
			            position : 'center',
			            formatter : '{b}',
			            textStyle: {
			            	color: '#1FBBA6',
			            	fontSize : '20',
			                baseline : 'bottom'
			            }
			        },
			        labelLine : {
			            show : false
			        }
			    }
			};
		var labelTop2 = {
			    normal : {
			    	color: '#1FBBA6',
			        label : {
			            show : true,
			            position : 'center',
			            formatter : '{b}',
			            textStyle: {
			            	color: '#1FBBA6',
			            	fontSize : '20',
			                baseline : 'bottom'
			            }
			        },
			        labelLine : {
			            show : false
			        }
			    }
			};
		var labelTop3 = {
			    normal : {
			    	color: '#5FAEE3',
			        label : {
			            show : true,
			            position : 'center',
			            formatter : '{b}',
			            textStyle: {
			            	color: '#1FBBA6',
			            	fontSize : '20',
			                baseline : 'bottom'
			            }
			        },
			        labelLine : {
			            show : false
			        }
			    }
			};
		var labelBottom = {
			    normal : {
			        color: '#888888',
			        label : {
			            show : true,
			            position : 'bottom',
			            textStyle: {
			            	color: '#fff',
			            	fontSize : '18',
			                baseline : 'bottom'
			            }
			        },
			        labelLine : {
			            show : false
			        }
			    },
			    emphasis: {
			        color: 'rgba(136,136,136)'
			    }
			};
		var radius = [50, 60];
			
			
		function setChart1(d){
			var otherD = 100 - d ;
			if(d > 100){
				otherD = 0 ;
			}
			var myChart66=echarts.init(document.getElementById('chart1'),'shine');
			var option66 = { 
			    series : [
			        {
			            type : 'pie',
			            center : ['70px', '60px'],
			            radius : radius,
			            x: '0%', // for funnel
			            itemStyle : labelFromatter,
			            data : [
							{name:d+"%", value:d,itemStyle : labelTop},
			                {name:'other', value:otherD, itemStyle : labelBottom}
			            ]
			        } 
			    ]
			};
			myChart66.setOption(option66);   
		}
		function setChart2(d){
			var otherD = 100 - d ;
			if(d > 100){
				otherD = 0 ;
			}
			var myChart66=echarts.init(document.getElementById('chart2'),'shine');
			var option66 = { 
			    series : [
			        {
			            type : 'pie',
			            center : ['70px', '60px'],
			            radius : radius,
			            x: '0%', // for funnel
			            itemStyle : labelFromatter,
			            data : [
							{name:d+"%", value:d,itemStyle : labelTop3},
			                {name:'other', value:otherD, itemStyle : labelBottom}
			            ]
			        } 
			    ]
			};
			myChart66.setOption(option66);   
		}
		function setChart3(d){
			var otherD = 100 - d ;
			if(d > 100){
				otherD = 0 ;
			}
			var myChart66=echarts.init(document.getElementById('chart3'),'shine');
			var option66 = { 
			    series : [
			        {
			            type : 'pie',
			            center : ['70px', '60px'],
			            radius : radius,
			            x: '0%', // for funnel
			            itemStyle : labelFromatter,
			            data : [
							{name:d+"%", value:d,itemStyle : labelTop2},
			                {name:'other', value:otherD, itemStyle : labelBottom}
			            ]
			        } 
			    ]
			};
			myChart66.setOption(option66);   
		}
		function setChart4(d){
			var otherD = 100 - d ;
			if(d > 100){
				otherD = 0 ;
			}
			var myChart66=echarts.init(document.getElementById('chart4'),'shine');
			var option66 = { 
			    series : [
			        {
			            type : 'pie',
			            center : ['70px', '60px'],
			            radius : radius,
			            x: '0%', // for funnel
			            itemStyle : labelFromatter,
			            data : [
							{name:d+"%", value:d,itemStyle : labelTop},
			                {name:'other', value:otherD, itemStyle : labelBottom}
			            ]
			        } 
			    ]
			};
			myChart66.setOption(option66);   
		}
		function setChart5(d){
			var otherD = 100 - d ;
			if(d > 100){
				otherD = 0 ;
			}
			var myChart66=echarts.init(document.getElementById('chart5'),'shine');
			var option66 = { 
			    series : [
			        {
			            type : 'pie',
			            center : ['70px', '60px'],
			            radius : radius,
			            x: '0%', // for funnel
			            itemStyle : labelFromatter,
			            data : [
							{name:d+"%", value:d,itemStyle : labelTop3},
			                {name:'other', value:otherD, itemStyle : labelBottom}
			            ]
			        } 
			    ]
			};
			myChart66.setOption(option66);   
		}
		function setChart6(d){
			var otherD = 100 - d ;
			if(d > 100){
				otherD = 0 ;
			}
			var myChart66=echarts.init(document.getElementById('chart6'),'shine');
			var option66 = { 
			    series : [
			        {
			            type : 'pie',
			            center : ['70px', '60px'],
			            radius : radius,
			            x: '0%', // for funnel
			            itemStyle : labelFromatter,
			            data : [
							{name:d+"%", value:d,itemStyle : labelTop2},
			                {name:'other', value:otherD, itemStyle : labelBottom}
			            ]
			        } 
			    ]
			};
			myChart66.setOption(option66);   
		}
		function setChart7(d){
			var otherD = 100 - d ;
			if(d > 100){
				otherD = 0 ;
			}
			var myChart66=echarts.init(document.getElementById('chart7'),'shine');
			var option66 = { 
			    series : [
			        {
			            type : 'pie',
			            center : ['70px', '60px'],
			            radius : radius,
			            x: '0%', // for funnel
			            itemStyle : labelFromatter,
			            data : [
							{name:d+"%", value:d,itemStyle : labelTop},
			                {name:'other', value:otherD, itemStyle : labelBottom}
			            ]
			        } 
			    ]
			};
			myChart66.setOption(option66);   
		}
		function setChart8(d){
			var otherD = 100 - d ;
			if(d > 100){
				otherD = 0 ;
			}
			var myChart66=echarts.init(document.getElementById('chart8'),'shine');
			var option66 = { 
			    series : [
			        {
			            type : 'pie',
			            center : ['70px', '60px'],
			            radius : radius,
			            x: '0%', // for funnel
			            itemStyle : labelFromatter,
			            data : [
							{name:d+"%", value:d,itemStyle : labelTop3},
			                {name:'other', value:otherD, itemStyle : labelBottom}
			            ]
			        } 
			    ]
			};
			myChart66.setOption(option66);   
		}
	</script>

</body>
</html>