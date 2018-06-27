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
		              <div   class="h400"> 
		                 	<h4 class="chart-title">实际辐射量与理论辐射量对比</h4>
		                 	<div class="fr mtf25">
			                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" id="fsTime"  onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getSolarResources})"> 
								 <!--  <input class="tjfx-btn"  type="submit" value="查询" onclick="return getSolarResources();"> -->
		                  	 </div>
		                  	 <div class="h250 w100 fl borbot"   id="db"></div>
		                  	 <div class="h100 w100 fl mt10"   >
	                	  		<div class="tjfx-table">
									<table  width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<th>类别</th>
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
										<tbody id="list-fs">
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
				<div class="pl8 pr8 mt10 bg-ff  bor-radius mb50 tjfx-box">
		              <div   class="h650"> 
		                 	<h4 class="chart-title">太阳能资源分布柱状图</h4>
		                 	<div class="fr mtf25">
			                  	  <!-- <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate"  id="tynTime" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getSolarData})">  -->
								  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getSolarData();"> -->
		                  	 </div>
		                  	 <div class="h250 w100 fl borbot"   id="tynm"></div>
		                  	 <div class="h250 w100 fl mt10"   >
	                	  		<div class="tjfx-table">
									<table  width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<th>瞬时辐射区间</th>
											<th>辐射量(kWh/㎡)</th>
											<th>占比(%)</th>
										</tr>
										<tbody id="list-tyn">
											<tr>
												<td>0~100</td>
												<td id="rad0100W2m"></td>
												<td id="zb1"></td>
											</tr>
											<tr>
												<td>100~200</td>
												<td id="rad100200W2m"></td>
												<td id="zb2"></td>
											</tr>
											<tr>
												<td>200~300</td>
												<td id="rad200300W2m"></td>
												<td id="zb3"></td>
											</tr>
											
											<tr>
												<td>300~400</td>
												<td id="rad300400W2m"></td>
												<td id="zb4"></td>
											</tr>
												<td>400500</td>
												<td id="rad400500W2m"></td>
												<td id="zb5"></td>
											</tr>
											<tr>
												<td>500~600</td>
												<td id="rad500600W2m"></td>
												<td id="zb6"></td>
											</tr>
											<tr>
												<td>600~700</td>
												<td id="rad600700W2m"></td>
												<td id="zb7"></td>
											</tr>
											<tr>
												<td>700~800</td>
												<td id="rad700800W2m"></td>
												<td id="zb8"></td>
											</tr>
											<tr>
												<td>800~900</td>
												<td id="rad800900W2m"></td>
												<td id="zb9"></td>
											</tr>
											<tr>
												<td>900~1000</td>
												<td id="rad9001000W2m"></td>
												<td id="zb10"></td>
											</tr>
											<tr>
												<td>>1000</td>
												<td id="rad1000W2mThan"></td>
												<td id="zb11"></td>
											</tr>
											<tr>
												<td>合计</td>
												<td id="radSum"></td>
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
	<script type="text/javascript" src="<%=basePath%>js/tjfxCheckCom.js?pubVersion=201802070001"></script>
	<script>
	$(function(){
		/* pws_id = $("#pws_id").val();
		pws_id = 4; */
		/* getSolarResources();
		getSolarData(); */
		
		var year=getDateYear();
		var today=getDateToday();
		
		$("#fsTime").val(year);
		$("#tynTime").val(today);
		
		getCompanyOne();
		
		$("#companyPws").on("change",function(){
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				getTjfxData();
			}  
		})
		
	}) 
	
	function getTjfxData(){
		getSolarResources();
		getSolarData();
	}
		
	function getSolarResources(){
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var fsTime = $("#fsTime").val();
			if(fsTime != '' && fsTime != undefined){
				param += "&tim_point="+fsTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getSolarResources.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 
		    			 if(data.data!= null){
		    				 var html1="";
			    			 var html2="";
			    			 if(data.data.mapFre1){
			    				 var a=data.data.mapFre1;
			    				 html1="<tr>"+
			    				 '<td>理论辐射量</td>'+
			    				 "<td>"+getFixedNum5(a['1'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['2'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['3'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['4'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['5'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['6'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['7'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['8'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['9'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['10'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['11'])+"</td>"+
		    					 "<td>"+getFixedNum5(a['12'])+"</td>"+
		    					 "</tr>";
			    			 }
			    			 if(data.data.mapReal1){
			    				 var b=data.data.mapReal1;
			    				 html2="<tr>"+
			    				 '<td>实际辐射量</td>'+
		    					 "<td>"+getFixedNum5(b['1'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['2'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['3'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['4'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['5'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['6'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['7'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['8'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['9'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['10'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['11'])+"</td>"+
		    					 "<td>"+getFixedNum5(b['12'])+"</td>"+
		    					 "</tr>";
			    			 }
			    			var htmls=html1+html2;
			    			if(htmls!=""){
			    				$("#list-fs").html(htmls);
			    			}
		    				 
		    			 }
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

		for(var i=1;i<13;i++){
			var d = data.mapFre1;
			xTime.push(i+"月");
			y1.push(getFixedNum5(d[i]));
		}
		for(var i=1;i<13;i++){
			var d = data.mapReal1;
			y2.push(getFixedNum5(d[i]));
		}
		
		var myChart1 = echarts.init(document.getElementById('db'),'shine');
		var option1 = {
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
			        data: ['理论辐射量', '实际辐射量'],
			        top: 10,
			    },
			    xAxis:  {
			        type: 'category',
			        data: xTime 
			    },
			    yAxis: {
			    	type : 'value',
					name : '辐射量(kWh/㎡)',
					axisLabel : {
					formatter : '{value}'
					}
			    },
			    series: [{
			            name: '理论辐射量',
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
			            name: '实际辐射量',
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
			};
			myChart1.setOption(option1);
	}
	
	function getSolarData(){
		var param  = "";
		var pws_id = $("#companyPws").val();
		if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
		}
	
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"getSolarDataByEnvInfo.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);  //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			 
	    			 if(data.data){
	    				var d=data.data;
	    				 $("#rad0100W2m").html(getFixedNum5(d.rad0100W2m/1000));
	    				 $("#rad100200W2m").html(getFixedNum5(d.rad100200W2m/1000));
	    				 $("#rad200300W2m").html(getFixedNum5(d.rad200300W2m/1000));
	    				 $("#rad300400W2m").html(getFixedNum5(d.rad300400W2m/1000));
	    				 $("#rad400500W2m").html(getFixedNum5(d.rad400500W2m/1000));
	    				 $("#rad500600W2m").html(getFixedNum5(d.rad500600W2m/1000));
	    				 $("#rad600700W2m").html(getFixedNum5(d.rad600700W2m/1000));
	    				 $("#rad700800W2m").html(getFixedNum5(d.rad700800W2m/1000));
	    				 $("#rad800900W2m").html(getFixedNum5(d.rad800900W2m/1000));
	    				 $("#rad9001000W2m").html(getFixedNum5(d.rad9001000W2m/1000));
	    				 $("#rad1000W2mThan").html(getFixedNum5(d.rad1000W2mThan/1000));
	    				 $("#radSum").html(getFixedNum(d.radSum/1000));
	    				 var zzb1=(d.rad0100W2m/d.radSum).toString();
	    				 var zzb2=d.rad100200W2m/d.radSum;
	    				 var zzb3=d.rad200300W2m/d.radSum;
	    				 var zzb4=d.rad300400W2m/d.radSum;
	    				 var zzb5=d.rad400500W2m/d.radSum;
	    				 var zzb6=d.rad500600W2m/d.radSum;
	    				 var zzb7=d.rad600700W2m/d.radSum;
	    				 var zzb8=d.rad700800W2m/d.radSum;
	    				 var zzb9=d.rad800900W2m/d.radSum;
	    				 var zzb10=d.rad9001000W2m/d.radSum;
	    				 var zzb11=d.rad1000W2mThan/d.radSum;
	    				 $("#zb1").html(parseFloat(zzb1*100).toFixed(2));
	    				 $("#zb2").html(parseFloat(zzb2*100).toFixed(2));
	    				 $("#zb3").html(parseFloat(zzb3*100).toFixed(2));
	    				 $("#zb4").html(parseFloat(zzb4*100).toFixed(2));
	    				 $("#zb5").html(parseFloat(zzb5*100).toFixed(2));
	    				 $("#zb6").html(parseFloat(zzb6*100).toFixed(2));
	    				 $("#zb7").html(parseFloat(zzb7*100).toFixed(2));
	    				 $("#zb8").html(parseFloat(zzb8*100).toFixed(2));
	    				 $("#zb9").html(parseFloat(zzb9*100).toFixed(2));
	    				 $("#zb10").html(parseFloat(zzb10*100).toFixed(2));
	    				 $("#zb11").html(parseFloat(zzb11*100).toFixed(2));
						 setChart2(data.data);	
	    			 }
	    			
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	}
	function setChart2(data){
		 rad0100W2m=0;
		 rad100200W2m=0;
		 rad200300W2m=0;
		 rad300400W2m=0;
		 rad400500W2m=0;
		 rad500600W2m=0;
		 rad600700W2m=0;
		 rad700800W2m=0;
		 rad800900W2m=0;
		 rad9001000W2m=0;
		 rad1000W2mThan=0;
		 zb1=0;
		 zb2=0;
		 zb3=0;
		 zb4=0;
 		 zb5=0;
		 zb6=0;
		 zb7=0;
		 zb8=0;
		 zb9=0;
		 zb10=0;
		 zb11=0;
		 
			var d=data ;
			rad0100W2m=(getFixedNum(d.rad0100W2m/1000));
			rad100200W2m=(getFixedNum(d.rad100200W2m/1000));
			rad200300W2m=(getFixedNum(d.rad200300W2m/1000));
			rad300400W2m=(getFixedNum(d.rad300400W2m/1000));
			rad400500W2m=(getFixedNum(d.rad400500W2m/1000));
			rad500600W2m=(getFixedNum(d.rad500600W2m/1000));
			rad600700W2m=(getFixedNum(d.rad600700W2m/1000));
			rad700800W2m=(getFixedNum(d.rad700800W2m/1000));
			rad800900W2m=(getFixedNum(d.rad800900W2m/1000));
			rad9001000W2m=(getFixedNum(d.rad9001000W2m/1000));
			rad1000W2mThan=(getFixedNum(d.rad1000W2mThan/1000));
			zb1=((d.rad0100W2m/d.radSum)*100);
			zb2=((d.rad100200W2m/d.radSum)*100);
			zb3=((d.rad200300W2m/d.radSum)*100);
			zb4=((d.rad300400W2m/d.radSum)*100);
			zb5=((d.rad400500W2m/d.radSum)*100);
			zb6=((d.rad500600W2m/d.radSum)*100);
			zb7=((d.rad600700W2m/d.radSum)*100);
			zb8=((d.rad700800W2m/d.radSum)*100);
			zb9=((d.rad800900W2m/d.radSum)*100);
			zb10=((d.rad9001000W2m/d.radSum)*100);
			zb11=((d.rad1000W2mThan/d.radSum)*100);
		 
		var myChart2 = echarts.init(document.getElementById('tynm'),'shine');
		var option1 = {
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
					bottom : '50'
				},
				legend: {
			        data: ['辐射量', '占比'],
			        top: 10,
			    },
			    xAxis: [
			            {
			                type: 'category',
			                data: ['0~100','100~200','200~300','300~400','400~500','500~600','600~700','700~800','800~900','900~1000','>1000'],
			                axisPointer: {
			                    type: 'shadow'
			                }
			            }
			        ],
			    yAxis: [{
			    	type : 'value',
					name : '辐射量(kWh/㎡)',
					axisLabel : {
					formatter : '{value}'
					}
			    },{
			    	type : 'value',
					name : '占比(%)',
					axisLabel : {
					formatter : '{value}'
					},
					max : 100
			    }],
			    series: [
			            {name: ['辐射量'],
			            	type: 'bar',
			            	smooth : true, 
			            	data: [rad0100W2m,rad100200W2m,rad200300W2m,rad300400W2m,rad400500W2m,rad500600W2m,
			            	       rad600700W2m,rad700800W2m,rad800900W2m,rad9001000W2m,rad1000W2mThan],
			            	symbol : 'none',
							itemStyle : {
								normal : {
									color : '#35BEB5'
									}
			            	}
			            },
						
				        { 
			            	name: ['占比'],
				            type: 'line',
				            smooth : true, 
				            yAxisIndex : 1, 
				            data: [getFixedNum5(zb1),getFixedNum5(zb2),getFixedNum5(zb3),getFixedNum5(zb4),getFixedNum5(zb5),getFixedNum5(zb6),getFixedNum5(zb7),getFixedNum5(zb8),getFixedNum5(zb9),getFixedNum5(zb10),getFixedNum5(zb11)],
				            symbol : 'none',
							itemStyle : {
								normal : {
									color : '#EDB213'
									}
			            		}
			            	}
			       ]
			};
	                    
			myChart2.setOption(option1);
	}
	</script>
</html>