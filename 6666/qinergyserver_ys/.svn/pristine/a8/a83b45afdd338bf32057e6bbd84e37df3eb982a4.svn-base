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
	<body class="bgfc">
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
						<h4 class="chart-title">当月电量概括</h4>
	                 	<div class="fr mtf25">
	                 		  <input type="text"   placeholder="请选择.." class="fl  tjfx-inp Wdate"  id="dygk" onFocus="WdatePicker({dateFmt:'yyyy-MM',onpicked:getElecStatistics})"> 
							  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getElecStatistics();"> -->
	                  	 </div>
						<div class="h300">
							<div class="wcl" style="border-right : 1px solid #ccc;">
								<div class="w100 h160">
									<div  id="yelcircle" class="c100 p0 orange" style="margin-left: 35%; margin-top: 25px;"> 
					                    <span class="circle" id="gen_plt_use_ele_rate">0%</span>
					                    <div class="slice">
					                        <div class="bar"></div>
					                        <div class="fill"></div>
					                    </div>
				                	</div>
			                	</div>
			                	<div class="w100 yeltit"  >综合厂用电率</div>
			                	<div class="w100 h120 mt30">
				                	<div class="fl pl8 yelist">
				                		<span class="va" id="gen_plt_use_ele">0</span>
				                		<span class="nam" >综合厂用电量(MWh)</span>
				                	</div>
				                	<div class="fr pr8 yelist">
				                		<span class="va" id="gen_plt_use_ele_year">0</span>
				                		<span class="nam" >年综合厂用电量(MWh)</span>
				                	</div>
				                </div>
							</div>
							<div class="wcl" style="border-right : 1px solid #ccc;">
								<div class="w100 h160">
									<div id="bluecircle" class="c100 p0 blue" style="margin-left: 35%; margin-top: 25px;"> 
					                    <span class="circle" id="plt_pow_con_rate">0%</span>
					                    <div class="slice">
					                        <div class="bar"></div>
					                        <div class="fill"></div>
					                    </div>
				                	</div>
			                	</div>
			                	<div class="w100 yeltit blue"  >厂用电率</div>
			                	<div class="w100 h120 mt30">
				                	<div class="fl pl8 yelist">
				                		<span class="va blue" id="plt_pow_con">0</span>
				                		<span class="nam blue" >厂用电量(MWh)</span>
				                	</div>
				                	<div class="fr pr8 yelist">
				                		<span class="va blue" id="plt_pow_con_year">0</span>
				                		<span class="nam blue" >年厂用电量(MWh)</span>
				                	</div>
				                </div>
							</div>
							<div class="wcl">
								<div class="w100 h160">
									<div id="greencircle"  class="c100 p0 green" style="margin-left: 35%; margin-top: 25px;"> 
					                    <span class="circle" id="pur_net_ele_rate">0%</span>
					                    <div class="slice">
					                        <div class="bar"></div>
					                        <div class="fill"></div>
					                    </div>
				                	</div>
			                	</div>
			                	<div class="w100 yeltit green"  >购网电率</div>
			                	<div class="w100 h120 mt30">
				                	<div class="fl pl8 yelist">
				                		<span class="va green" id="pur_net_ele">0</span>
				                		<span class="nam green" >购网电量(MWh)</span>
				                	</div>
				                	<div class="fr pr8 yelist">
				                		<span class="va green" id="pur_net_ele_year">0</span>
				                		<span class="nam green" >年购网电量(MWh)</span>
				                	</div>
				                </div>
							</div>
						</div>
					</div>
					<div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
		              <div   class="h650"> 
		                 	<h4 class="chart-title">综合厂用电量分析</h4>
		                 	<div class="fr mtf25">
			                  	  <input type="text"   placeholder="请选择.." class="fl  tjfx-inp Wdate"  id="cydlTime" onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getSynthElecAnalysis})"> 
								  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getSynthElecAnalysis();"> -->
		                  	 </div>
		                  	 <div class="h250 w100 fl borbot"   id="zhdl"></div>
		                  	 <div class="h305 w100 fl mt10"   >
	                	  		<div class="tjfx-table">
									<table  width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<th>时间</th>
											<th>综合厂用电量(MWh)</th>
											<th>厂用电量(MWh)</th>
											<th>购网电量(MWh)</th>
											<th>综合厂用电率(%)</th>
										</tr>
										<tbody id="list-zhdl">
											<tr>
												<td>暂无数据</td>
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
											</tr>
											<tr>
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
											</tr>
											<tr>
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
											</tr>
											<tr>
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
											</tr>
											<tr>
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
											</tr>
										</tbody>
									</table>
								</div>
	                	  </div> 
		              </div>
	            </div>
					
					<div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
		              <div   class="h400"> 
		                 	<h4 class="chart-title">厂用电量分析(单位：MWh)</h4>
		                 	<div class="fr mtf25">
			                  	  <input type="text"   placeholder="请选择.." class="fl  tjfx-inp Wdate"  id="cydlTime2" onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getElecAnalysis})"> 
								  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getElecAnalysis();"> -->
		                  	 </div>
		                  	 <div class="h250 w100 fl borbot"   id="cydlchart"></div>
		                  	 <div class="h160 w100 fl mt10"   >
	                	  		<div class="tjfx-table">
									<table  width="100%" border="0" cellpadding="0"  >
										<tr>
											<th>年</th>
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
										<tbody id="list-cydl">
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
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</tbody>
									</table>
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
	<script>
		 
		$(function(){
			/* pws_id = $("#pws_id").val();
			pws_id = 9; */
			
			 
			var year=getDateYear();
			var yearAndMouth=getDateYearAndMouth();
			var today=getDateToday();
			
			$("#dygk").val(yearAndMouth);
			$("#cydlTime").val(year);
			$("#cydlTime2").val(year);
			
			
			getCompanyOne();
			
			
			$("#companyPws").on("change",function(){
				var pws_id = $("#companyPws").val();
				if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
					getTjfxData();
				}  
			})
			
		})
		
		function getTjfxData(){
			getElecStatistics();
			getSynthElecAnalysis();
			getElecAnalysis();
		}
		
		function getElecStatistics(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			var dygk = $("#dygk").val();
			if(dygk != '' && dygk != undefined){
				dygk=dygk+"-01";
				param += "&tim_point="+dygk;
			}else{
				layer.alert("请选择时间");
				return;
			}
			
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			
			$.ajax({
		    	url:url+"getElecStatistics.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			if(data.data != null){
	    					var d=data.data;
	    					$("#gen_plt_use_ele").html(getFixedNum5(d.gen_plt_use_ele/1000));
	    					$("#gen_plt_use_ele_rate").html(getFixedNum5(d.gen_plt_use_ele_rate)+"%");
	    					$("#gen_plt_use_ele_year").html(getFixedNum5(d.gen_plt_use_ele_tol/1000));
	    					$("#yelcircle").removeClass("p10").addClass("p"+getFixedNum5(d.gen_plt_use_ele_rate));
	    					
	    					$("#plt_pow_con").html(getFixedNum5(d.plt_pow_con/1000));
	    					$("#plt_pow_con_rate").html(getFixedNum5(d.plt_pow_con_rate)+"%");
	    					$("#plt_pow_con_year").html(getFixedNum5(d.plt_pow_con_tol/1000));
	    					$("#bluecircle").removeClass("p10").addClass("p"+getFixedNum5(d.gen_plt_use_ele_rate));
	    					
	    					$("#pur_net_ele").html(getFixedNum5(d.pur_net_ele/1000));
	    					$("#pur_net_ele_rate").html(getFixedNum5(d.pur_net_ele_rate)+"%");
	    					$("#pur_net_ele_year").html(getFixedNum5(d.pur_net_ele_tol/1000));
	    					$("#greencircle").removeClass("p10").addClass("p"+getFixedNum5(d.gen_plt_use_ele_rate));
		    			}
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		function getSynthElecAnalysis(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var cydlTime = $("#cydlTime").val();
			if(cydlTime != '' && cydlTime != undefined){
				cydlTime=cydlTime+"-01-01";
				param += "&tim_point="+cydlTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getSynthElecAnalysis.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
	    				 if(data.data!=null&&data.data!="null"){
			    			 if(data.data.length> 0){
			    				 var htm = "";
			    				 for(var i = 0 ; i < data.data.length ; i++){
		    						 var lst = data.data[i];
		    						 if(lst != null){
		    							 htm += "<tr>"+
			 						 		"<td>"+getLocalDateAndTime(lst.tol_tim,4) +"</td>"+
			 						 		"<td>"+getFixedNum5(lst.gen_plt_use_ele/1000)+"</td>"+
			 						 		"<td>"+getFixedNum5(lst.plt_pow_con/1000)+"</td>"+
			 						 		"<td>"+getFixedNum5(lst.pur_net_ele/1000)+"</td>"+
			 						 		"<td>"+getFixedNum5(lst.gen_plt_use_ele_rate)+"</td>"+
			 						 		"</tr>";
		    						 }
		    					 }
			    				 $("#list-zhdl").html(htm);
		    				 }
		    				setChart4(data.data);	
		    			 }
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		function setChart4(data){
			var xTime=[];
			var y1=[];
			var y2=[];
			var y3=[];
			var y4=[];
			for(var i=0;i<data.length;i++){
				var d=data[i];
				if( d != null){
					xTime.push(getLocalDateAndTime(d.tol_tim,9)+"月");
					y1.push(getFixedNum5(d.gen_plt_use_ele/1000));
					y2.push(getFixedNum5(d.plt_pow_con/1000));
					y3.push(getFixedNum5(d.pur_net_ele/1000));
					y4.push(getFixedNum5(d.gen_plt_use_ele_rate));
				}
			}
			var myChart4 = echarts.init(document.getElementById('zhdl'),'shine');
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
				        data: ['综合厂用电量','厂用电量','购网电量','综合厂用电率'],
				        top:10
				    },
				    xAxis:  {
				        type: 'category',
				        data: xTime 
				    },
				    yAxis: [{
				    	type : 'value',
						name : '电量(MWh)',
						axisLabel : {
						formatter : '{value}'
						}
				    },{
				    	type : 'value',
						name : '综合厂用电率(%)',
						axisLabel : {
							formatter : '{value}'
						},
						max : 100
				    }],
				    series: [
				        {
				            name: '综合厂用电量',
				            type: 'bar',
				            smooth : true,
				            data: y1,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#EDB213'
								}
							}  
				        },
				        {
				            name: '厂用电量',
				            type: 'bar',
				            smooth : true,
				            data: y2,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#35BEB5'
								}
							}  
			           },
				        {
				            name: '购网电量',
				            type: 'bar',
				            smooth : true,
				            data: y3,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#5FB0E3'
								}
							}  
			           },
				        {
				            name: '综合厂用电率',
				            type: 'line',
				            smooth : true,
				            yAxisIndex : 1,
				            data: y4,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#FE784E'
								}
							}  
			           }
			         ]
				    
				};
		                    
				myChart4.setOption(option4);
			}
		
		function getElecAnalysis(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var cydlTime2 = $("#cydlTime2").val();
			if(cydlTime2 != '' && cydlTime2 != undefined){
				cydlTime2=cydlTime2+"-01-01";
				param += "&tim_point="+cydlTime2;
			}else{
				layer.alert("请选择时间");
				return;
			}
			
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getElecAnalysis.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
	    				 if(data.data  != null ){
	    					 var html1="";
			    			 var html2="";
			    			 if(data.data.mapElec1){
			    				 var a=data.data.mapElec1;
			    				 html1="<tr>"+
			    				 '<td>'+getIsZero(a.year)+'</td>'+
			    				 "<td>"+getFixedNum5(a['1']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['2']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['3']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['4']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['5']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['6']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['7']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['8']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['9']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['10']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['11']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(a['12']/1000)+"</td>"+
		    					 "</tr>";
			    			 }
			    			 if(data.data.mapElec2){
			    				 var b=data.data.mapElec2;
			    				 html2="<tr>"+
			    				 '<td>'+getIsZero(b.year)+'</td>'+
		    					 "<td>"+getFixedNum5(b['1']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['2']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['3']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['4']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['5']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['6']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['7']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['8']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['9']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['10']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['11']/1000)+"</td>"+
		    					 "<td>"+getFixedNum5(b['12']/1000)+"</td>"+
		    					 "</tr>";
			    			 }
			    			
			    			var htmls=html1+html2;
			    			if(htmls!=""){
			    				$("#list-cydl").html(htmls);
			    			}
			    			setChart5(data.data);	
	    				 }
		    			
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		function setChart5(data){
			var xTime=[];
			var y1=[];
			var y2=[];
			
			for(var i=1;i<13;i++){
				var d = data.mapElec1;
				xTime.push(i+"月");
				y1.push(getFixedNum5(d[i]/1000));
			}
			for(var i=1;i<13;i++){
				var d = data.mapElec2;
				y2.push(getFixedNum5(d[i]/1000));
			}
			
			var lengData = 
			{
		      /*   data: ['2017','2018'], */
		        data: [''+data.mapElec1.year+'',''+data.mapElec2.year+''], 
		        top: 10
		    };
			var seri = [{
		            name: data.mapElec1.year,
		            type: 'bar',
		            smooth : true,
		            data: y1,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}  
	           },{
		            name: data.mapElec2.year,
		            type: 'bar',
		            smooth : true,
		            data: y2,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#35BEB5'
						}
					}  
	           }]
			var myChart5 = echarts.init(document.getElementById('cydlchart'),'shine');
			var option5 = {
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
					legend :[],
				    xAxis:  {
				        type: 'category',
				        data: xTime 
				    },
				    yAxis: {
				    	type : 'value',
						name : '电量(MWh)',
						axisLabel : {
						formatter : '{value}'
						}
				    },
				    series: []
				};
				option5.legend=lengData;      
				option5.series=seri;      
				console.log(option5);
				myChart5.setOption(option5,true);
			}
	</script>
</html>