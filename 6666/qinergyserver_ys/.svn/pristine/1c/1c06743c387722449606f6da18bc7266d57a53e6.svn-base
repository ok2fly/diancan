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
		
		<link rel="stylesheet" type="text/css" href="<%=basePath %>js/circle/css/normalize.css?pubVersion=201802070001" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>js/circle/css/default.css?pubVersion=201802070001">
		<link rel="stylesheet" href="<%=basePath %>js/circle/css/percircle.css?pubVersion=201802070001">
	</head>
	<body class="bgfc" style="height:100%;" >
		<input type="hidden" id="userId" value="${user.id}" >
		<input type="hidden" id="use_typ" value="${user.use_typ}" >
		<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
		<div class="w100 fl mt15">
			 <div class="pl15 ml15 mr15">
			 	 <div   class="h80 w100 tjfx-box"> 
	              	 <div class="w100 fl" style="margin-top: 15px;">
	              		<div class="tj-query">
                  	   		<div class="sz-area">
                  	   			 <select class="fl quinput w20"  id="companyOne"  onchange="setCompanytwo(this.value);">
                  	   			 	<option value="qxz">请选择一级公司</option>
                  	   			 </select>
                  	   			 <select class="fl quinput w20"  id="companyTwo" style="margin-left:15px;" onchange="setCompanyThree(this.value);">
                  	   			 	<option value="qxz">请选择二级公司</option>
                  	   			 </select>
                  	   			 <select class="fl quinput w20"  id="companyThree" style="margin-left:15px;" onchange="setPws(this.value);">
                  	   			 	<option value="qxz">请选择三级公司</option>
                  	   			 </select>
                  	   			  <select class="fl quinput w20"  id="companyPws" style="margin-left:22px;"  >
                  	   			 	<option value="qxz">请选择电站</option>
                  	   			 </select>
                  	   		</div>
	              		</div>
              		</div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
	              <div   class="h650 w100" > 
                  	  <h4 class="chart-title">综合效率分析</h4>
	                  <div class="fr mtf25">
	                  	  <input type="text"   placeholder="请输入.." id="zhxlTime" class="fl  tjfx-inp Wdate"   onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getZhxl})"> 
						  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getZhxl();"> -->
	                  </div>
                	  <div class="h250 w100 fl borbot"   id="gccd"></div>
                	  <div class="h305 w100 fl mt10"   >
                	  		<div class="tjfx-table">
								<table  width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<th>统计时间</th>
										<th>光伏-总发电量(MWh)</th>
										<th>上网电量(MWh)</th>
										<th>等效时(h)</th>
										<th>综合效率(%)</th>
										<th>计划完成率(%)</th>
										<th>辐射量(MJ/m2)</th>
									</tr>
									<tbody id="list-zh">
										<tr>
											<td>暂无数据</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
                	  </div> 
                	 <!-- 
                	  	<span class="disabled">上一页</span><span class="current">1</span><a href="javascript:;" class="tcdNumber">2</a><a href="javascript:;" class="tcdNumber">3</a><a href="javascript:;" class="tcdNumber">4</a><span>...</span><a href="javascript:;" class="tcdNumber">15</a><a href="javascript:;" class="nextPage">下一页</a>
                	  </div>   -->
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
	              <div   class="h250"> 
	                	 <h4 class="chart-title">计划完成率</h4>
	                	 <div class="fr mtf25">
		                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" id="jhwcTime"  onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getPlan})"> 
							  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getPlan();"> -->
	                  	 </div>
	                	 <div class="h200 w70 fl"  id="bwxt"></div>
	                	 <div class="h200 w30 fl" >
		                 	<div id="circle" class="c100 p10 green" style="margin-left: 35%; margin-top: 25px;"> 
			                    <span class="circle" id="planRate">0%</span>
			                    <div class="slice">
			                        <div class="bar"></div>
			                        <div class="fill"></div>
			                    </div>
			                </div>
		                 </div>
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
	              <div   class="h650"> 
	                 	<h4 class="chart-title">弃光率</h4>
	                 	<div class="fr mtf25">
		                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate"  id="qglTime" onFocus="WdatePicker({dateFmt:'yyyy-MM',onpicked:getDiscard})"> 
							  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getDiscard();"> -->
	                  	 </div>
	                  	 <div class="h250 w100 fl borbot"   id="mrfdlzzt"></div>
	                  	 <div class="h305 w100 fl mt10"   >
                	  		<div class="tjfx-table">
								<table  width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<th>统计时间</th>
										<th>检修弃光电量(kWh)</th>
										<th>故障弃光电量(kWh)</th>
										<th>限电弃光电量(kWh)</th>
										<th>弃光率(%)</th>
										<th>检修弃光率(%)</th>
										<th>故障弃光率(%)</th>
										<th>限电弃光率(%)</th>
									</tr>
									<tbody id="list-qgl">
										<tr>
											<td>暂无数据</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
                	  </div> 
                	  <div class="tcdPageCode" id="tcdPageCode1">
                	  </div>  
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
	              <div   class="h650"> 
	                 	<h4 class="chart-title">损耗分析</h4>
	                 	<div class="fr mtf25">
		                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" id="shfxTime"  onFocus="WdatePicker({dateFmt:'yyyy-MM',onpicked:getLoss})"> 
							  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getLoss();" > -->
	                  	 </div>
	                  	 <div class="h250 w100 fl borbot"   id="cnxt"></div>
	                  	 <div class="h305 w100 fl mt10"   >
                	  		<div class="tjfx-table">
								<table  width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<th>时间</th>
										<th>总消耗等价时(h)</th>
										<th>升压站损耗等价时(h)</th>
										<th>逆变器损耗等价时(h)</th>
										<th>光伏方阵吸收损耗等价时(h)</th>
										<th>上网电量等价时(h)</th>
										<th>综合效率(%)</th>
									</tr>
									<tbody id="list-sh">
										<tr>
											<td>暂无数据</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="tcdPageCode" id="tcdPageCode2">
                	  </div> 
	              </div>
	            </div>
	            </div>
	            <div  class="mt10 h350 mb50"  style="margin-bottom:20px;">
	            	<div class="w60  fl">
		            	<div class="pl8 pr8 bor-radius bg-ff h350 tjfx-box">
			                 <h4 class="chart-title">太阳能资源</h4>
			                 <div class="fr mtf25">
			                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" id="tynTime"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getSolar})"> 
								  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getSolar();"> -->
		                  	 </div>
		                 	 <div class="h268 w100" id="ycdxq"></div>
		                 </div>
		            </div>
		            <div class="w40  fl">
		            	<div class="pl8 pr8 bor-radius bg-ff ml15 h350 tjfx-box">
			            	<h4 class="chart-title">逆变器等效时</h4>
			            	<div class="fr mtf25">
			                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" id="nbqTime" onFocus="WdatePicker({dateFmt:'yyyy-MM',onpicked:getInverter})"> 
<!-- 			                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" style="width:80px;" id="nbqTime" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})">  -->
								  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getInverter();" > -->
		                  	 </div>
		                  	 <div class="h268 w20 fl mt20">
		                  	 	  <div class="inv-box col-y"  >
		                  	 	  	   <div class="inv-boxin">
		                  	 	  	   		优:<span id="you">0</span> 
		                  	 	  	   </div>
		                  	 	  	   <div class="inv-per" id="you-bfb">
		                  	 	  	   		0%
		                  	 	  	   </div>
		                  	 	  </div>
		                  	 	  
		                  	 	  <div class="inv-box mt80 col-z"  >
		                  	 	  	   <div class="inv-boxin">
		                  	 	  	   		中:<span  id="zhong">0</span> 
		                  	 	  	   </div>
		                  	 	  	   <div class="inv-per" id="zhong-bfb">
		                  	 	  	   		0%
		                  	 	  	   </div>
		                  	 	  </div>
		                  	 </div>
			                <div class="h268 w60 fl mt20" id="nbqdxs"></div>
			                <div class="h268 w20 fl mt20">
			                	<div class="inv-box col-l"  >
		                  	 	  	   <div class="inv-boxin">
		                  	 	  	   		良:<span id="liang">0</span> 
		                  	 	  	   </div>
		                  	 	  	   <div class="inv-per" id="liang-bfb">
		                  	 	  	   		0%
		                  	 	  	   </div>
		                  	 	  </div>
		                  	 	  
		                  	 	  <div class="inv-box mt80 col-c"  >
		                  	 	  	   <div class="inv-boxin">
		                  	 	  	   		差:<span id="cha">0</span> 
		                  	 	  	   </div>
		                  	 	  	   <div class="inv-per" id="cha-bfb">
		                  	 	  	   		0%
		                  	 	  	   </div>
		                  	 	  </div>
		                  	</div>
		                 </div>
		            </div>
	            </div>
		</div>
	</body>
	<script type="text/javascript" src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/circle/js/percircle.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/tjfxCheckCom.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
	<script>
		$(function(){
			/* getZhxl();
			getPlan();
			getDiscard();
			getLoss();
			getSolar();
			getInverter(); */
			var year=getDateYear();
			var yearAndMouth=getDateYearAndMouth();
			var today=getDateToday();
			
			$("#zhxlTime").val(year);
			$("#jhwcTime").val(year);
			$("#qglTime").val(yearAndMouth);
			$("#shfxTime").val(yearAndMouth);
			$("#tynTime").val(today);
			$("#nbqTime").val(yearAndMouth);
			
			getCompanyOne();
			
			$("#companyPws").on("change",function(){
				var pws_id = $("#companyPws").val();
				if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
					getTjfxData();
				} 
			})
		})
		
		function getTjfxData(){
			getZhxl();
			getPlan();
			getDiscard();
			getLoss();
			getSolar();
			getInverter();
		}
		 
		function getZhxl(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}
			else{
				layer.alert("请选择电站");
				return;
			} 
			
			var zhxlTime = $("#zhxlTime").val();
			if(zhxlTime != '' && zhxlTime != undefined){
				zhxlTime=zhxlTime+"-01-01";
				param += "&tim_type="+3+"&tim_point="+zhxlTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getOverallEffic.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);
		    		if (data.resultcode=="USR000") {
		    			 
		    			 if(data.data.length> 0){
		    				 $("#list-zh").empty();
		    				 var htm = "";
		    				 for(var i = 0 ; i < data.data.length ; i++){
	    						 var lst = data.data[i];
		    					 htm += "<tr>"+
 						 		"<td>"+lst.tol_tim+"</td>"+
 						 		"<td>"+getFixedNum5(lst.pvs_power/1000) +"</td>"+
 						 		"<td>"+getFixedNum5(lst.int_cha/1000) +"</td>"+
 						 		"<td>"+getFixedNum5(lst.whe_equ)+"</td>"+
 						 		"<td>"+getFixedNum5(lst.com_eff)+"</td>"+
 						 		"<td>"+getFixedNum5(lst.plan_com_rate)+"</td>"+
 						 		"<td>"+getFixedNum5(lst.radiation)+"</td>"+
 						 		"</tr>";
	    					 }
		    				 $("#list-zh").html(htm)
		    			 }
		    			setchart3(data.data);	
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		
		function setchart3(data){
			var xtol_tim=[];
			var ypvs_power =[];
			var ycom_eff=[];
			for(var i=0;i<data.length;i++){
				var d=data[i];
				xtol_tim.push((getIsNull(d.tol_tim)).split("-")[1]+"月");
				ypvs_power.push(getFixedNum5(d.int_cha/1000));
				ycom_eff.push(getFixedNum5(d.com_eff));
			}
		
			var myChart3 = echarts.init(document.getElementById('gccd'),'shine');
			option3 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid : {
					left : '60',
					top : '40',
					right : '60',
					bottom : '30'
				},
				legend: {
			        data: ['上网电量', '综合效率'],
			        top: 10,
			    },
			    xAxis:  {
			        type: 'category',
			        boundaryGap : true, //柱状图时此参数为true 折现时为false
			        data: xtol_tim 
			    },
			    yAxis:[ {
			    	type : 'value',
					name : '上网电量(MWh)',
					axisLabel : {
						formatter : '{value}'
					}
			    },{
			    	type : 'value',
					name : '综合效率(%)',
					axisLabel : {
						formatter : '{value}'
					},
					max : 100 
			    }],
			    series: [{
					name : '上网电量',
					type : 'bar',
					smooth : true,
					data : ypvs_power,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}  
				},{
					name : '综合效率',
					type : 'line',
					smooth : true,
					yAxisIndex : 1,
					data : ycom_eff,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#35BEB5'
						}
					}  
				}
			      
		        ]
			    
			};
	                    
			myChart3.setOption(option3);
		}
		
		function getPlan(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var jhwcTime = $("#jhwcTime").val(); 
			if(jhwcTime != '' && jhwcTime != undefined){
				jhwcTime=jhwcTime+"-01-01";
				param += "&tim_type="+3+"&tim_point="+jhwcTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				data:param,
				url:url+"getPlanComplRate.htm",
				type:"post",
				dataType:"json",
					success:function(data){
						layer.close(indexlayer);  //关闭 loading 
			    		if (data.resultcode=="USR000") {
			    				for(var i=0;i<data.data.length;i++){
			    				var d=data.data[i];
			    					if(d.planRate){
				    					$("#planRate").html(getFixedNum5(d.planRate)+"%");
				    					/* $("#planRate").html(90); */
				    					$("#circle").removeClass("p10").addClass("p");
			    						
			    					}
			    				}
		    					setChart2(data.data);
						} else {
			               layer.alert(data.desc);
						}
			    	}
			})
		}
		function setChart2(data){
			var xtol_tim=[];
			var ypvs_power=[];
			var yplan_power=[];
			for(var i=0;i<12;i++){
				var d=data[i];
				xtol_tim.push((getIsNull(d.tol_tim)).split("-")[1]+"月")
				ypvs_power.push(getFixedNum5(d.pvs_power/1000));
				yplan_power.push(getFixedNum5(d.plan_power/1000));
			}
			
			var myChart2 = echarts.init(document.getElementById('bwxt'),'shine');
			var option2 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid : {
					left : '60',
					top : '40',
					right : '60',
					bottom : '30'
				},
				legend: {
			        data: ['总发电量', '计划发电量'],
			        top: 10,
			    },
			    xAxis:  {
			        type: 'category',
			        data: xtol_tim 
			    },
			    yAxis: {
			    	type : 'value',
					name : '电量(MWh)',
					axisLabel : {
					formatter : '{value}'
					}
			    },
			    series: [{
			    	name:"总发电量",
			    	type:"bar",
			    	smooth:true,
			    	data:ypvs_power,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}  
			    },{
			    	name:"计划发电量",
			    	type:"bar",
			    	smooth:true,
			    	data:yplan_power,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#35BEB5'
						}
					}  
			    }]
			      
			    
			};
	                    
			myChart2.setOption(option2);
		}
		
		var discardPageData ;
		var countAll = 0;
	 	var currentPage  = 1;
	 	
	 	var everyPageCount = 10 ;
		function getDiscard(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var qglTime = $("#qglTime").val(); 
			if(qglTime != '' && qglTime != undefined){
				qglTime=qglTime+"-01";
				param += "&tim_type="+2+"&tim_point="+qglTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				data:param,
				url:url+"getDiscardRate.htm",
				type:"post",
				dataType:"json",
					success:function(data){
						layer.close(indexlayer);  //关闭 loading 
			    		if (data.resultcode=="USR000") {
			    			 if(data.data.length> 0){
			    				 discardPageData = data.data;
			    				 $("#list-qgl").empty();
			    				 var htm = "";
			    				 for(var i = 0 ; i < data.data.length ; i++){
		    						 var lst = data.data[i];
		    						  if(i < (currentPage*everyPageCount)){
				    					 htm += "<tr>"+
		 						 		"<td>"+lst.tol_tim +"</td>"+
		 						 		"<td>"+getFixedNum5(lst.mai_dis_power)+"</td>"+
		 						 		"<td>"+getFixedNum5(lst.fal_dis_power)+"</td>"+
		 						 		"<td>"+getFixedNum5(lst.rat_dis_power) +"</td>"+
		 						 		"<td>"+getFixedNum5(lst.dis_rate)+"</td>"+
		 						 		"<td>"+getFixedNum5(lst.mai_dis_rate)+"</td>"+
		 						 		"<td>"+getFixedNum5(lst.fal_dis_rate)+"</td>"+
		 						 		"<td>"+getFixedNum5(lst.rat_dis_rate)+"</td>"+
		 						 		"</tr>";
		    						  }
		    					 }
			    				 $("#list-qgl").html(htm);
			    				 discardPageData = data.data;
			    				  //算出总页数
			    				  countAll = 0 ;
		    					  if(discardPageData.length/everyPageCount > parseInt(discardPageData.length/everyPageCount)){   
		    						  countAll=parseInt(discardPageData.length/everyPageCount)+1;   
		    				      }else{   
		    				    	  countAll=parseInt(discardPageData.length/everyPageCount);   
		    				       };
			    				  //countAll = data.totalPage;
			    				  $("#tcdPageCode1").createPage({
			 				        pageCount:countAll,
			 				        current:currentPage,
			 				        backFn:function(p){
			 				        	currentPage = p;
			 				        	getPagedData();
			 				        }
			 			    	});
			    			 }
		    				setChart5(data.data);
						} else {
			               layer.alert(data.desc);
						}
			    	}
			})
		}
		function getPagedData(){
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			 $("#list-qgl").empty();
			 var htm = "";
			 var max = 0 ;
			 if ( (currentPage*everyPageCount) >  discardPageData.length-1 ){
				 max = discardPageData.length; 
			 }else{
				 max = (currentPage*everyPageCount) ;
			 }
			 for(var i=((currentPage-1)*everyPageCount);i<max;i++){
				 var lst = discardPageData[i];
				 
				 htm += "<tr>"+
				 "<td>"+lst.tol_tim +"</td>"+
			 		"<td>"+getFixedNum5(lst.mai_dis_power)+"</td>"+
			 		"<td>"+getFixedNum5(lst.fal_dis_power)+"</td>"+
			 		"<td>"+getFixedNum5(lst.rat_dis_power) +"</td>"+
			 		"<td>"+getFixedNum5(lst.dis_rate)+"</td>"+
			 		"<td>"+getFixedNum5(lst.mai_dis_rate)+"</td>"+
			 		"<td>"+getFixedNum5(lst.fal_dis_rate)+"</td>"+
			 		"<td>"+getFixedNum5(lst.rat_dis_rate)+"</td>"+
			 		"</tr>";
			 }
			 $("#list-qgl").html(htm);
			 layer.close(indexlayer);  //关闭 loading 
		}
		function setChart5(data){
			var xtol_tim=[];
			var ydis_rate=[];
			var ymai_dis_power=[];
			var yfal_dis_power=[];
			var yrat_dis_power=[];
			for (var i = 0; i < data.length; i++) {
				var d = data[i];
				xtol_tim.push((getIsNull(d.tol_tim)).split("-")[2]+"日");
				ydis_rate.push(getFixedNum5(d.dis_rate));
				ymai_dis_power.push(getFixedNum5(d.mai_dis_power));
				yfal_dis_power.push(getFixedNum5(d.fal_dis_power));
				yrat_dis_power.push(getFixedNum5(d.rat_dis_power));

			}
			var myChart5 = echarts.init(document.getElementById('mrfdlzzt'),'shine');
			var option4 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid : {
					left : '60',
					top : '40',
					right : '60',
					bottom : '30'
				},
				legend: {
			        data: ['检修弃光电量','故障弃光电量','限电弃光电量','弃光率'],
			        top: 10,
			    },
			    xAxis:  {
			        type: 'category',
			        data: xtol_tim 
			    },
			    yAxis: [{
			    	type : 'value',
					name : '电量(kWh)',
					axisLabel : {
						formatter : '{value}'
					}
			    },{
			    	type : 'value',
					name : '弃光率(%)',
					axisLabel : {
						formatter : '{value}'
					}
			    }],
			    series: 
		        [{
			    	name : '检修弃光电量',
					type : 'bar',
					smooth : true,
					data : ymai_dis_power,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}  
		        },{
			    	name : '故障弃光电量',
					type : 'bar',
					smooth : true,
					data : yfal_dis_power,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#35BEB5'
						}
					}  
		        },{
			    	name : '限电弃光电量',
					type : 'bar',
					smooth : true,
					data : yrat_dis_power,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#5FB0E3'
						}
					}  
		        },{
			    	name : '弃光率',
					type : 'line',
					smooth : true,
					yAxisIndex : 1,
					data : ydis_rate,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#FE784E'
						}
					}  
		        }]
			    
			};
	                    
			
			myChart5.setOption(option4);
		}
		
		var lossPageData ;
		var countAll2 = 0;
		var currentPage2  = 1;
		var everyPageCount2 = 10 ;
		function getLoss(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			 
			var shfxTime = $("#shfxTime").val(); 
			if(shfxTime != '' && shfxTime != undefined){
				shfxTime=shfxTime+"-01";
				param += "&tim_type="+2+"&tim_point="+shfxTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				data:param,
				url:url+"getLossAnalysis.htm",
				type:"post",
				dataType:"json",
					success:function(data){
						layer.close(indexlayer);  //关闭 loading 
			    		if (data.resultcode=="USR000") {
			    			 
			    			 if(data.data.length> 0){
			    				 lossPageData = data.data;
			    				 $("#list-sh").empty();
			    				 var htm = "";
			    				 for(var i = 0 ; i < data.data.length ; i++){
		    						 var lst = data.data[i];
		    						 if(i < (currentPage2*everyPageCount2)){
				    					 htm += "<tr>"+
		 						 		"<td>"+lst.tol_tim +"</td>"+
		 						 		"<td>"+getFixedNum5(lst.loss_tol_whe_equ)  +"</td>"+
		 						 		"<td>"+getFixedNum5(lst.loss_bot_sta_whe_equ) +"</td>"+
		 						 		"<td>"+getFixedNum5(lst.loss_inv_whe_equ)  +"</td>"+
		 						 		"<td>"+getFixedNum5(lst.loss_pv_arr_abs_whe_equ) +"</td>"+
		 						 		"<td>"+getFixedNum5(lst.net_power_whe_equ) +"</td>"+
		 						 		"<td>"+getFixedNum5(lst.com_eff) +"</td>"+
		 						 		"</tr>";
		    						 }
		    					 }
			    				 $("#list-sh").html(htm);
			    				 lossPageData = data.data;
			    				//算出总页数
			    				  countAll2 = 0 ;
		    					  if(lossPageData.length/everyPageCount2 > parseInt(lossPageData.length/everyPageCount2)){   
		    						  countAll2=parseInt(lossPageData.length/everyPageCount2)+1;   
		    				      }else{   
		    				    	  countAll2=parseInt(lossPageData.length/everyPageCount2);   
		    				       };
			    				  //countAll = data.totalPage;
			    				  $("#tcdPageCode2").createPage({
			 				        pageCount:countAll2,
			 				        current:currentPage2,
			 				        backFn:function(p){
			 				        	currentPage2 = p;
			 				        	lossPageData1();
			 				        }
			 			    	});
			    			 }
			    			setChart1(data.data);
						} else {
			               layer.alert(data.desc);
						}
			    	}
			})
		}
		function lossPageData1(){
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			 $("#list-sh").empty();
			 var htm = "";
			 var max = 0 ;
			 if ( (currentPage2*everyPageCount2) >  lossPageData.length-1 ){
				 max = lossPageData.length; 
			 }else{
				 max = (currentPage2*everyPageCount2) ;
			 }
			 for(var i=((currentPage2-1)*everyPageCount2);i<max;i++){
				 var lst = lossPageData[i];
				 
				 htm += "<tr>"+
			 		"<td>"+lst.tol_tim +"</td>"+
			 		"<td>"+getFixedNum5(lst.loss_tol_whe_equ)  +"</td>"+
			 		"<td>"+getFixedNum5(lst.loss_bot_sta_whe_equ) +"</td>"+
			 		"<td>"+getFixedNum5(lst.loss_inv_whe_equ)  +"</td>"+
			 		"<td>"+getFixedNum5(lst.loss_pv_arr_abs_whe_equ) +"</td>"+
			 		"<td>"+getFixedNum5(lst.net_power_whe_equ) +"</td>"+
			 		"<td>"+getFixedNum5(lst.com_eff) +"</td>"+
			 		"</tr>";
			 }
			 $("#list-sh").html(htm);
			 layer.close(indexlayer);  //关闭 loading 
		}
		
		function setChart1(data){
			var xtol_tim=[];
			var y1=[];
			var y2=[];
			var y3=[];
			var y4=[];
			var y5=[];
			var y6=[];
			var y7=[];
			for (var i = 0; i < data.length; i++) {
				var d = data[i];
				xtol_tim.push((getIsNull(d.tol_tim)).split("-")[2]+"日");
				y1.push(getFixedNum5(d.loss_tol_whe_equ));
				y2.push(getFixedNum5(d.loss_pv_arr_abs_whe_equ));
				y3.push(getFixedNum5(d.loss_inv_whe_equ));
				y4.push(getFixedNum5(d.loss_sel_bxch_whe_equ));
				y5.push(getFixedNum5(d.loss_bot_sta_whe_equ));
				y6.push(getFixedNum5(d.com_eff));
				y7.push(getFixedNum5(d.net_power_whe_equ))

			}
			var myChart1 = echarts.init(document.getElementById('cnxt'),'shine');

			var option = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    grid : {
						left : '60',
						top : '40',
						right : '60',
						bottom : '30'
					},
					legend: {
				       // data: ['总损耗等价时','光伏方阵吸收损耗等价时','逆变器损耗等价时','集电线路及箱变损耗等价时','升压站损耗等价时','综合效率'],
				       data: [ '光伏方阵吸收损耗等价时','逆变器损耗等价时','上网电量等价时','升压站损耗等价时','综合效率'],
				        top: 10,
				    },
				    xAxis:  {
				        type: 'category',
				        data: xtol_tim 
				    },
				    yAxis: [{
				    	type : 'value',
						name : '损耗等价时(h)',
						axisLabel : {
							formatter : '{value}'
						}
				    },{
				    	type : 'value',
						name : '综合效率(h)',
						axisLabel : {
							formatter : '{value}'
						}
				    }],
				    series: 
				       [ 
				        /*  {
					    	name : '总损耗等价时',
							type : 'bar',
							smooth : true,
							data : y1,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#5FB0E3'
								}
							}  
				        }, */
				        {
					    	name : '光伏方阵吸收损耗等价时',
							type : 'bar',
							smooth : true,
							data : y2,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#EDB213'
								}
							}  
				        },{
					    	name : '逆变器损耗等价时',
							type : 'bar',
							smooth : true,
							data : y3,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#07CB47'
								}
							}  
				        },{
					    	name : '上网电量等价时',
							type : 'bar',
							smooth : true,
							data : y7,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#FE784E'
								}
							}  
				        },{
					    	name : '升压站损耗等价时',
							type : 'bar',
							smooth : true,
							data : y5,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#7A057A'
								}
							}  
				        },{
					    	name : '综合效率',
							type : 'line',
							smooth : true,
							yAxisIndex : 1,
							data : y6,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#F4350D'
								}
							}  
				        }]
				    
				};
		                    
				myChart1.setOption(option);
		}
		function getSolar(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var tynTime = $("#tynTime").val(); 
			if(tynTime != '' && tynTime != undefined){
				param += "&tim_point="+tynTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				data:param,
				url:url+"getSolarEnergyRes.htm",
				type:"post",
				dataType:"json",
					success:function(data){
						layer.close(indexlayer);  //关闭 loading 
			    		if (data.resultcode=="USR000") {
			    			 
			    			 /* if(data.data.length> 0){
			    				 var htm = "";
			    				 for(var i = 0 ; i < data.data.length ; i++){
		    						 var lst = data.data[i];
			    					 
			    					 htm += "<tr>"+
	 						 		"<td>"+lst.hv +"</td>"+
	 						 		"<td>"+lst.line_power  +"</td>"+
	 						 		"<td>"+lst.crt_tim +"</td>"+
	 						 		"</tr>";
		    					 }
			    			 } */
			    			setChart4(data.data);	
						} else {
			               layer.alert(data.desc);
						}
			    	}
			})
		}
		function setChart4(data){
			var xTime = [];
			var y1=[];
			var y2=[];
			for (var i = 0; i < data.length; i++) {
				var d = data[i];
				xTime.push(getLocalDateAndTime(d.tol_tim, 6));
				y1.push(getFixedNum5(d.hv));
				y2.push(getFixedNum5(d.line_power));

			}
			var myChart4 = echarts.init(document.getElementById('ycdxq'),'shine');
			var option4 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid : {
					left : '60',
					top : '40',
					right : '60',
					bottom : '30'
				},
				legend: {
			        data: ['并网功率', '瞬时辐射'],
			        top: 10,
			    },
			    xAxis:  {
			        type: 'category',
			        data: xTime 
			    },
			    yAxis: [{
			    	type : 'value',
					name : '功率(kW)',
					axisLabel : {
					formatter : '{value}'
					}
			    },{
			    	type : 'value',
					name : '辐射(W/m2)',
					axisLabel : {
					formatter : '{value}'
					}
			    }],
			    series : [
			    {
					name : '并网功率',
					type : 'line',
					smooth : true,
					data : y2,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}  
				},
				{
					name : '瞬时辐射',
					type : 'line',
					smooth : true,
					yAxisIndex : 1,
					data : y1,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#35BEB5'
						}
					}  
				}
			       
		         ]
			    
			};
	                    
			myChart4.setOption(option4);
		}
		function getInverter(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var nbqTime = $("#nbqTime").val(); 
			if(nbqTime != '' && nbqTime != undefined){
				param += "&tim_point="+nbqTime+"-01";
			}else{
				layer.alert("请选择时间");
				return;
			}
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				data:param,
				url:url+"getInverterProp.htm",
				type:"post",
				dataType:"json",
					success:function(data){
						layer.close(indexlayer);  //关闭 loading 
			    		if (data.resultcode=="USR000") {
			    			 
			    			if(data.data && data.data.length > 0 ){
			    				var d=data.data[0];
			    				$("#you").html(d.inv_whe_equ_exc_value);
			    				$("#you-bfb").html(d.inv_whe_equ_exc_rate);
			    				$("#zhong").html(d.inv_whe_equ_med_value);
			    				$("#zhong-bfb").html(d.inv_whe_equ_med_rate);
			    				$("#liang").html(d.inv_whe_equ_good_value);
			    				$("#liang-bfb").html(d.inv_whe_equ_good_rate);
			    				$("#cha").html(d.inv_whe_equ_bad_value);
			    				$("#cha-bfb").html(d.inv_whe_equ_bad_rate);
			    				
			    			}else{
			    				$("#you").html(0);
			    				$("#you-bfb").html(0);
			    				$("#zhong").html(0);
			    				$("#zhong-bfb").html(0);
			    				$("#liang").html(0);
			    				$("#liang-bfb").html(0);
			    				$("#cha").html(0);
			    				$("#cha-bfb").html(0);
			    			}
			    			setChart12(data.data);	
						} else {
			               layer.alert(data.desc);
						}
			    	}
			})
		}	
		function setChart12(data){
			
			var yy=[];
			var yz=[];
			var yl=[];
			var yc=[];
			for(var i=0;i<data.length;i++){
				var d=data[i];
				yy.push(getFixedNum5(d.inv_whe_equ_exc_rate));
				yz.push(getFixedNum5(d.inv_whe_equ_med_rate));
				yl.push(getFixedNum5(d.inv_whe_equ_good_rate));
				yc.push(getFixedNum5(d.inv_whe_equ_bad_rate));
			}
			var placeHolderStyle = {
					normal : {
				        color: '#E86B8D' 
				    }
				}
				var placeHolderStyle1 = {
					normal : {
				        color: '#F1AC45' 
				    }
				}
				var placeHolderStyle2 = {
					normal : {
				        color: '#35AA3A' 
				    }
				}
				var placeHolderStyle3 = {
					normal : {
				        color: '#36ABD8' 
				    }
				}
			 var myChart12=echarts.init(document.getElementById('nbqdxs'),'shine');
			 var option11 = {
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    calculable : true,
				    series : [
				        {
				            name:'逆变器等效时',
				            type:'pie',
				            radius : ['50%', '70%'],
				            data:[
				                {value:yy, name:'优',itemStyle : placeHolderStyle2},
				                {value:yz, name:'中',itemStyle : placeHolderStyle1},
				                {value:yl, name:'良',itemStyle :placeHolderStyle3 },
				                {value:yc, name:'差',itemStyle : placeHolderStyle} 
				            ]
				        }
				    ]
				};
				myChart12.setOption(option11);
		}
		
	</script>
</html>
