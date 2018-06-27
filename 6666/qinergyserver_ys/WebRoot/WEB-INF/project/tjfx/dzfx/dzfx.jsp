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
	</head>
	<body class="bgfc" >
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
                  	  <h4 class="chart-title">功率预测与限电分析</h4>
	                  <div class="fr mtf25">
	                  	  <input type="text"   placeholder="请输入.." id="gfTime" class="fl  tjfx-inp Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getPower})"> 
						  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getPower();"> -->
	                  </div>
                	  <div class="h250 w100 fl borbot"   id="gccd"></div>
                	  <div class="h305 w100 fl mt10"   >
                	  		<div class="tjfx-table">
								<table  width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<th>时间</th>
										<th>光伏实际功率(kW)</th>
										<th>光伏功率预测(kW)</th>
										<th>调度下发功率(kW)</th>
									</tr>
									<tbody id="list-gf">
										<tr>
											<td>暂无数据</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
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
										</tr>
										<tr>
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
										</tr>
										<tr>
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
										</tr>
										<tr>
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
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="tcdPageCode" id="tcdPageCode1">
                	  </div> 
	              </div>
	            </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
	              <div   class="h650"> 
	                 	<h4 class="chart-title">储能分析</h4>
	                 	<div class="fr mtf25">
		                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" id="cnTime"  onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getEnergy})"> 
							 <!--  <input class="tjfx-btn"  type="submit" value="查询" onclick="return getEnergy();"> -->
	                  	 </div>
	                  	 <div class="h250 w100 fl borbot"   id="cnfx"></div>
	                  	 <div class="h305 w100 fl mt10"   >
                	  		<div class="tjfx-table">
								<table  width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<th>时间</th>
										<th>计划充电(kWh)</th>
										<th>计划放电(kWh)</th>
										<th>实际充电(kWh)</th>
										<th>实际放电(kWh)</th>
									</tr>
									<tbody id="list1">
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
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius mb50 tjfx-box">
	              <div   class="h250"> 
	                 	<h4 class="chart-title">电站功率曲线</h4>
	                 	<div class="fr mtf25">
		                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" id="gcTime"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getStor})"> 
							 <!--  <input class="tjfx-btn"  type="submit" value="查询" onclick="return getStor();"> -->
	                  	 </div>
	                  	 <div class="h200 w100 fl"   id="cnxt"></div>
	              </div>
	            </div>
	            
			 </div>
		</div>
	</body>
	<script type="text/javascript" src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/tjfxCheckCom.js?pubVersion=201802070001"></script>
	<script>
		var pws_id = "";
		$(function(){
			/* pws_id = $("#pws_id").val();
			pws_id = 1; */
			//getPower();
			/* getEnergy();
			getStor(); */
			
			var year=getDateYear();
			var yearAndMouth=getDateYearAndMouth();
			var today=getDateToday();
			
			$("#gfTime").val(today);
			$("#cnTime").val(year);
			$("#gcTime").val(today);
			
			getCompanyOne();
			
			$("#companyPws").on("change",function(){
				var pws_id = $("#companyPws").val();
				if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
					getTjfxData();
				}  
			})
		})
		
		
		function getTjfxData(){
			getPower();
			getEnergy();
			getStor();
		}
		
		
	    var powerPageData ;
		var countAll = 0;
		var currentPage  = 1;
		var everyPageCount = 10 ;

		function getPower(){
		
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var gfTime = $("#gfTime").val();
			if(gfTime != '' && gfTime != undefined){
				param += "&tim_type="+1+"&tim_point="+gfTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getPowerRation.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 
		    			 if(data.data.dispList.length>0){
		    				 powerPageData = data.data;
		    				 $("#list-gf").empty();
		    				 var htm = "";
		    				 for(var i = 0 ; i < data.data.dispList.length ; i++){
	    						 var lst = data.data.loadList[i];
	    						 var lst2 = data.data.pVList[i];
	    						 var lst3 = data.data.dispList[i];
	    						 if(i < (currentPage*everyPageCount)){
	    							 var s = '-';
	    							 var s2 = '-';
	    							 var s3 = '-';
	    							 var tim = '-';
		    						 if(lst != undefined ){
		    							 s = getFixedNum5(lst.fct_value) ;
		    							 tim = lst.tol_tim;
		    						 }
		    						 if(lst2 != undefined ){
		    							 s2 = getFixedNum5(lst2.fct_value);
		    							 tim = lst2.tol_tim;
		    						 }
		    						 if(lst3 != undefined ){
		    							 s3 = getFixedNum5(lst3.fct_value);
		    							 tim = lst3.tol_tim;
		    						 }
		    						 var hour = getIsNull(tim).split(" ")[1];
		    						 htm += "<tr>"+
		    						 "<td>"+(hour.split(":")[0]+":"+hour.split(":")[1])+"</td>"+
		    						 "<td>"+s+"</td>"+
		    						 "<td>"+s2+"</td>"+
		    						 "<td>"+s3+"</td>"+
		    						 "</tr>";
	    						 }
	    					 }
		    				 $("#list-gf").html(htm);
		    				 powerPageData = data.data;
		    				  //算出总页数
		    				  countAll = 0 ;
		    				  
	    					  if(powerPageData.loadList.length/everyPageCount > parseInt(powerPageData.loadList.length/everyPageCount)){   
	    						  countAll=parseInt(powerPageData.loadList.length/everyPageCount)+1;   
	    				      }else{   
	    				    	  countAll=parseInt(powerPageData.loadList.length/everyPageCount);   
	    				       };
		    				  //countAll = data.totalPage;
		    				  $("#tcdPageCode1").createPage({
		 				        pageCount:countAll,
		 				        current:currentPage,
		 				        backFn:function(p){
		 				        	currentPage = p;
		 				        	powerPageData1();
		 				        }
		 			    	});
		    			 }
		    			setChart3(data.data);	
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		
		function powerPageData1(){
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			 $("#list-gf").empty();
			 var htm = "";
			 var max = 0 ;
			 if ( (currentPage*everyPageCount) >  powerPageData.loadList.length-1 ){
				 max = powerPageData.loadList.length; 
			 }else{
				 max = (currentPage*everyPageCount) ;
			 }
			 for(var i=((currentPage-1)*everyPageCount);i<max;i++){
				 
				 var lst = powerPageData.loadList[i];
				 var lst2 = powerPageData.pVList[i];
				 var lst3 =powerPageData.dispList[i];
				 
				 var s = '-';
				 var s2 = '-';
				 var s3 = '-';
				 var tim = '-';
				 if(lst != undefined ){
					 s = getFixedNum5(lst.fct_value) ;
					 tim = lst.tol_tim;
				 }
				 if(lst2 != undefined ){
					 s2 = getFixedNum5(lst2.fct_value);
					 tim = lst2.tol_tim;
				 }
				 if(lst3 != undefined ){
					 s3 = getFixedNum5(lst3.fct_value);
					 tim = lst3.tol_tim;
				 }
				 var hour = getIsNull(tim).split(" ")[1];
				 htm += "<tr>"+
				 "<td>"+(hour.split(":")[0]+":"+hour.split(":")[1])+"</td>"+
				 "<td>"+s+"</td>"+
				 "<td>"+s2+"</td>"+
				 "<td>"+s3+"</td>"+
				 "</tr>";
			 }
			 $("#list-gf").html(htm);
			 layer.close(indexlayer);  //关闭 loading 
		}
		function setChart3(data){
			var xTime=[];
			var y1=[];
			var y2=[];
			var y3=[];
			
			for(var i=0;i<data.dispList.length;i++){
				var d=data.pVList[i];
				var d2=data.loadList[i];
				var d3=data.dispList[i];
				 var s = '-';
				 var s2 = '-';
				 var s3 = '-';
				 var tim = '-';
				 if(d != undefined ){
					 s = getFixedNum5(d.fct_value) ;
					 tim = d.tol_tim;
				 }
				 if(d2 != undefined ){
					 s2 = getFixedNum5(d2.fct_value);
					 tim = d2.tol_tim;
				 }
				 if(d3 != undefined ){
					 s3 = getFixedNum5(d3.fct_value);
					 tim = d3.tol_tim;
				 }
				 var hour = getIsNull(tim).split(" ")[1];
				 xTime.push(hour.split(":")[0]+":"+hour.split(":")[1]);
				 y1.push(s);
				 y2.push(s2);
				 y3.push(s3);
			}
			var myChart3 = echarts.init(document.getElementById('gccd'),'shine');
			var option3 = {
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
			        data: ['光伏实际功率','光伏功率预测','调度下发功率'],
			        top: 10,
			    },
			    xAxis:  {
			        type: 'category',
			        data:xTime 
			    },
			    yAxis: {
			    	type : 'value',
					name : '功率',
					axisLabel : {
					formatter : '{value}'
					}
			    },
			    series: [
			        {
			            name: '光伏实际功率',
			            type: 'line',
			            data: y2,
						symbol : 'none',
						itemStyle : {
							normal : {
								color : '#35BEB5'
							}
						}  
		           },{
			            name: '光伏功率预测',
			            type: 'line',
			            data: y1,
						symbol : 'none',
						itemStyle : {
							normal : {
								color : '#EDB213'
							}
						}  
			        },
			        {
			            name: '调度下发功率',
			            type: 'line',
			            data: y3,
						symbol : 'none',
						itemStyle : {
							normal : {
								color : '#07CB47'
							}
						}  
		           }
		         ]
			    
			};
	                    
			myChart3.setOption(option3);
		}
		
		function getEnergy(){
			
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var cnTime = $("#cnTime").val();
			if(cnTime != '' && cnTime != undefined){
				cnTime=cnTime+"-01-01"
				param += "&tim_type="+3+"&tim_point="+cnTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getEnergyStorage.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 if(data.data.length> 0){
		    				 $("#list1").empty();
		    				 var htm = "";
		    				 for(var i = 0 ; i < data.data.length ; i++){
	    						 var lst = data.data[i];
	    						 htm += "<tr>"+
	    						 "<td>"+(getIsNull(lst.tol_tim)).split("-")[0]+"-"+(getIsNull(lst.tol_tim)).split("-")[1]+"</td>"+
	    						 "<td>"+getFixedNum5(lst.plan_phi)+"</td>"+
	    						 "<td>"+getFixedNum5(lst.plan_phe)+"</td>"+
	    						 "<td>"+getFixedNum5(lst.pcs_phi)+"</td>"+
	    						 "<td>"+getFixedNum5(lst.pcs_phe)+"</td>"+
	    						 "</tr>"
	    						/*  $("#pws_id").html(lst.pws_id);
	    						 $("#plan_phi").html(lst.plan_phi);
	    						 $("#plan_phe").html(lst.plan_phe);
	    						 $("#plan_tim").html(lst.plan_tim); */
	    						
	    					 }
		    				 $("#list1").html(htm);
		    			 }
		    			setChart5(data.data);	
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
			var y3=[];
			var y4=[];
		
			for(var i = 0; i < data.length; i++){
				var d=data[i];
				xTime.push((getIsNull(d.tol_tim)).split("-")[1]+"月");
				y1.push(getFixedNum5(d.plan_phi));
				y2.push(getFixedNum5(d.plan_phe));
				y3.push(getFixedNum5(d.pcs_phi));
				y4.push(getFixedNum5(d.pcs_phe));
			}
			var myChart5 = echarts.init(document.getElementById('cnfx'),'shine');
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
				legend: {
			        data: ['计划充电量','计划放电量','实际充电量','实际放电量'],
			        top: 10,
			    },
			    xAxis:  {
				        type: 'category',
				        data: xTime,//后台传的名称
				        splitLine:{show: false},
				        axisLine:false,
				        show:true,
				    },
			    yAxis: {
			    	type : 'value',
					name : '电量(kWh)',
					axisLabel : {
						formatter : '{value}'
					}
			    },
			    series:[ {
					name : '计划充电量',
					type : 'bar',
					smooth : true,
					data : y1,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#EDB213'
						}
					}  
				}, 
				{
					name : '计划放电量',
					type : 'bar',
					smooth : true,
					data : y2,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#07CB47'
						}
					}  
				}, 
				{
					name : '实际充电量',
					type : 'bar',
					smooth : true,
					data : y3,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#FE784E'
						}
					}  
				}, 
				{
					name : '实际放电量',
					type : 'bar',
					smooth : true,
					data : y4,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#5FB0E3'
						}
					}  
				}

				]
			    
			};
			myChart5.setOption(option5);
		}
		
		
		function getStor(){

			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var gcTime = $("#gcTime").val();
			if(gcTime != '' && gcTime != undefined){
				param += "&tim_type="+3+"&tim_point="+gcTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getStorNetCharge.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 
		    			setChart1(data.data);	
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		function setChart1(data){
			var xTime=[];
			var y1=[];
			var y2=[];
			var y3=[];
			var y4=[];
			var y5=[];
		
			for(var i = 0; i < data.length; i++){
				var d=data[i];
				xTime.push(getLocalDateAndTime(d.tol_tim,6));
				y1.push(getFixedNum5(d.pv_power));
				y2.push(getFixedNum5(d.pc_power));
				y3.push(getFixedNum5(d.line_power));
				y4.push(getFixedNum5(d.load_power));
				y5.push(getFixedNum5(d.chp_power));
				
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
			        data: ['光伏功率','储能功率','充电桩功率','并网功率','负荷功率'],
			        top: 10,
			    },
			    xAxis:  {
			        type: 'category',
			        data: xTime 
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
				}, 
				{
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
				}, 
				{
					name : '充电桩功率',
					type : 'line',
					smooth : true,
					data : y5,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#5FB0E3'
						}
					}  
				}, 
				{
					name : '并网功率',
					type : 'line',
					smooth : true,
					data : y3,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#FE784E'
						}
					}  
				}, 
				{
					name : '负荷功率',
					type : 'line',
					smooth : true,
					data : y4,
					symbol : 'none',
					itemStyle : {
						normal : {
							color : '#7A057A'
						}
					}  
				}
			    
			    ]
			};
	                    
			myChart1.setOption(option);
		}
		
	</script>
</html>
