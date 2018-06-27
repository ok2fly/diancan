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
		<title>电站排行</title>
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
	</head>
	<body class="bgfc">
		<input type="hidden" id="userId" value="${user.id}" >
		<input type="hidden" id="use_typ" value="${user.use_typ}" >
		<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
		<div class="w100 fl mt15">
			 <div class="pl15 ml15 mr15">
	            <div class="pr8 mt10  ">
	              <div   class="h140 w100  bg-ff bor-ccc" > 
	              	 <div class="w90 fl mt15">
	              	 	<div class="tj-query">
                  	   		<span>时间：</span>
                  	   		<div   class="sz-area">
                  	   			 <select class="fl quinput w20"  id="timeType" style="margin-left:22px;" onchange="changeTime(this.value);">
                  	   			 	<option value="1">选年统计</option>
                  	   			 	<option value="2">选月统计</option>
                  	   			 </select>
                  	   			 <input type="text"  placeholder="请输入.."  id="time" class="fl  fx  Wdate" style="margin-left:15px;" onFocus="WdatePicker({dateFmt:'yyyy'})">
                  	   		</div>
	              		</div>
	              		<div class="tj-query">
                  	   		<span>公司：</span>
                  	   		<div class="sz-area">
                  	   			 <select class="fl quinput w20"  id="companyOne" style="margin-left:22px;" onchange="setCompanytwo(this.value);">
                  	   			 	<option value="qxz">请选择一级公司</option>
                  	   			 </select>
                  	   			 <select class="fl quinput w20"  id="companyTwo" style="margin-left:15px;" onchange="setCompanyThree(this.value);">
                  	   			 	<option value="qxz">请选择二级公司</option>
                  	   			 </select>
                  	   			 <select class="fl quinput w20"  id="companyThree" style="margin-left:15px;" onchange="setPws(this.value);">
                  	   			 	<option value="qxz">请选择三级公司</option>
                  	   			 </select>
                  	   		</div>
	              		</div>
	              		<div class="tj-query" style="display:none;">
                  	   		<span>电站：</span>
                  	   		<div  class="sz-area">
                  	   			  <select class="fl quinput w20"  id="companyPwsNew"  style="margin-left:22px;"  >
                  	   			 	<option value="qxz">请选择电站</option>
                  	   			 </select>
                  	   		</div>
	              		</div>
              		</div>
              		<div class="w10 fr mt10" >
              			 <input class="tjfx-btn"  type="submit" onclick="return subTj();" value="查询">
              		</div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-ccc " id="gzsph" style="display:none;">
	              <div   class="h200"> 
	                 	<h4 class="chart-title">故障设备数排行(排行中单位为：台)</h4>
	                  	 <div class="h160 w50 fl borbot"  >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl"  id="gzsph-chart-top"></div>
	                  	 	</div>
	                  	 </div>
	                  	 <div class="h160 w50 fl borbot" >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl"  id="gzsph-chart-bottom"></div>
	                  	 	</div>
	                  	 </div>
	              </div>
	               <div   class="h200" id="fdlph" style="display:none;"> 
	                 	<h4 class="chart-title">发电量排行(排行中单位为：kWh)</h4>
	                  	 <div class="h160 w50 fl borbot"   >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl"  id="fdlph-chart-top"></div>
	                  	 	</div>
	                  	 </div>
	                  	 <div class="h160 w50 fl borbot"   >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl"  id="fdlph-chart-bottom"></div>
	                  	 	</div>
	                  	 </div>
	              </div>
	               <div   class="h200" id="fdyxxssph" style="display:none;"> 
	                 	<h4 class="chart-title">发电有效小时数排行(排行中单位为：h)</h4>
	                  	 <div class="h160 w50 fl borbot"   >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl"  id="fdyxxssph-chart-top"></div>
	                  	 	</div>
	                  	 </div>
	                  	 <div class="h160 w50 fl borbot"   >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl"  id="fdyxxssph-chart-bottom"></div>
	                  	 	</div>
	                  	 </div>
	              </div>
	               <div   class="h200" id="cdlph" style="display:none;"> 
	                 	<h4 class="chart-title">充电量排行(排行中单位为：kWh)</h4>
	                  	 <div class="h160 w50 fl borbot"   >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl"  id="cdlph-chart-top"></div>
	                  	 	</div>
                  	 	</div>
	                  	 <div class="h160 w50 fl borbot"  >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl"  id="cdlph-chart-bottom"></div>
	                  	 	</div>
	                  	 </div>
	              </div>
	               <div   class="h200" id="cdyxxssph" style="display:none;"> 
	                 	<h4 class="chart-title">充电有效小时数排行(排行中单位为：h)</h4>
	                  	 <div class="h160 w50 fl"  >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl"  id="cdyxxssph-chart-top"></div>
	                  	 	</div>
	                  	 </div>
	                  	 <div class="h160 w50 fl"   >
	                  	 	<div class="pl14 pr14">
	                  	 		<div class="h160 w100 fl" id="cdyxxssph-chart-bottom"></div>
	                  	 	</div>
	                  	 </div>
	              </div>
	            </div>
	            <div class="mb50"></div>
			 </div>
		</div>
	</body>
	<script type="text/javascript" src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/dzphCheckCom.js?pubVersion=201802070001"></script>
	<script>
		var userId = "";
		$(function(){
			userId = $("#userId").val();
			//userId = 7;
			getCompanyOne();
			
			
			$("#companyOne").change(function(){
				setPwsNew($(this).val(),1);
			})
			$("#companyTwo").change(function(){
				setPwsNew($(this).val(),2);
			})
			$("#companyThree").change(function(){
				setPwsNew($(this).val(),3);
			})
		})
		
		function setPwsNew(val,lev){
			if(val == 'qxz'){
				 if(lev == 1){
					 $("#companyPwsNew").empty().append('<option value="qxz">请选择电站</option');
					 return ;
				 }else if(lev == 2){
					 val = $("#companyOne").val();
				 }else if(lev == 3){
					 val = $("#companyTwo").val();
				 }
			} 
				 
			var html = '<option value="qxz">请选择电站</option>';
			var use_id = $("#userId").val();
			var param = 'com_id='+val+"&use_id="+use_id;
			$.ajax({
		    	url:url+"getPwsIdByComId.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			for (var l = 0; l < data.data.length; l++) {
							 var pws = data.data[l];
							 var selectHtm = "";
							 /* if(sessionStorage.getItem("pwsIdXt") && sessionStorage.getItem("pwsIdXt") == pws.id){
								   selectHtm = "selected";
							 } */
							 html += '<option value="'+pws.id+'" '+selectHtm+'>'+pws.pws_nam+'</option>'
						 }
		    			$("#companyPwsNew").empty().append(html);
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
			 
		}
		
		
		function changeTime(val){
			 $("#time").val('');
			 if(val == "1"){
				 $("#time").attr("onFocus","WdatePicker({dateFmt:'yyyy'})");
				 $("#time").attr("onclick","WdatePicker({dateFmt:'yyyy'})");
			 }else if(val == "2"){
				 $("#time").attr("onFocus","WdatePicker({dateFmt:'yyyy-MM'})");
				 $("#time").attr("onclick","WdatePicker({dateFmt:'yyyy-MM'})");
			 } 
		}
		
		 		
		var  itemStyle = {
                normal: {
                    color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                          '#0c9','#0cc','#3cc','#3cf','#39f'
                        ];
                        return colorList[params.dataIndex]
                    }
                }
		};

		var xData = [];
		var gzsbsYDataSer = [];
	 

		function subTj() {
			var timeType = $("#timeType").val();
			var checkTime = $("#time").val();
		  
			
			var companyThree = $("#companyThree").val();
			
			
			if (checkTime == "" || checkTime == undefined || checkTime == null) {
				layer.alert("请选择统计时间");
				return;
			}
			
			/* if (companyThree == "qxz" || companyThree == undefined || companyThree == null || companyThree == "") {
				layer.alert("请选择三级公司");
				return;
			} */
			var companyOne = $("#companyOne").val();
			if (companyOne == "qxz" || companyOne == undefined || companyOne == null || companyOne == "") {
				layer.alert("请至少选择一级公司");
				return;
			}
			var companyPws = '';
			$("#companyPwsNew option").each(function (){  
		            var txt = $(this).val();  
		            if(txt != 'qxz'){  
		            	companyPws += txt + ",";
		            }  
	        });  
			if (companyPws == "qxz" || companyPws == undefined || companyPws == null || companyPws == "") {
				layer.alert("该公司下无电站，请重新选择");
				return;
			}else{
				companyPws = companyPws.substring(0,companyPws.length-1);
			}
			
			
		 	if(timeType == 1){
				
				checkTime = checkTime+"-01-01"
			}else if(timeType == 2){
				
				checkTime = checkTime+"-01"
			}
			 
			var param  = "type="+timeType+"&date="+checkTime+"&use_id="+userId+"&pws_id="+companyPws;
			
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getPowerRankByComOwner.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 if(data.data.length> 0){
		    				 setTopBottom(data.data);
		    			 }
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
			
		}

		function setTopBottom(data) {
			if(data.length > 0 ){
				$("#gzsph").show();
				$("#fdlph").show();
				$("#fdyxxssph").show();
				$("#cdlph").show();
				$("#cdyxxssph").show();
				
				var gzsphTop = data[0].faultListTop;
				var gzsphbottom = data[0].faultListBottom;
				var fdlphTop = data[0].powerListTop;
				var fdlphbottom = data[0].powerListBottom;
				var fdyxxssphTop = data[0].powGenEffHourListTop;
				var fdyxxssphbottom = data[0].powGenEffHourListBottom;
				var cdlphTop = data[0].chaVolListTop;
				var cdlphbottom = data[0].chaVolListBottom;
				var cdyxxssphTop = data[0].chaGenEffHourListTop;
				var cdyxxssphbottom = data[0].chaGenEffHourListBottom;
				gzsphChart(gzsphTop,gzsphbottom);
				fdlphChart(fdlphTop,fdlphbottom);
				fdyxxssphChart(fdyxxssphTop,fdyxxssphbottom);
				cdlphChart(cdlphTop,cdlphbottom);
				cdyxxssphChart(cdyxxssphTop,cdyxxssphbottom);
			} 
			
		}
		function 	gzsphChart(gzsphTop,gzsphbottom){		
			var xdataTop = [];
			var ydataTop = [];
			if(gzsphTop && gzsphTop != undefined){
				for(var i = 0 ; i < gzsphTop.length ; i++){
					var pw = gzsphTop[i].pws_nam ;
					if(gzsphTop[i].pws_nam.length > 14 ){
						pw = gzsphTop[i].pws_nam.substring(0,14)+"..."
					}
					xdataTop.push(pw);
					ydataTop.push(getFixedNumNew5(gzsphTop[i].fal_equ_num));
				}
			}
			var xdataBottom = [];
			var ydataBottom = [];
			if(gzsphbottom && gzsphbottom != undefined){
				for(var i = 0 ; i < gzsphbottom.length ; i++){
					var pw = gzsphbottom[i].pws_nam ;
					if(gzsphbottom[i].pws_nam.length > 14 ){
						pw = gzsphbottom[i].pws_nam.substring(0,14)+"..."
					}
					xdataBottom.push(pw);
					ydataBottom.push(getFixedNumNew5(gzsphbottom[i].fal_equ_num));
				}
			}
			xdataTop.reverse();
			ydataTop.reverse();
			xdataBottom.reverse();
			ydataBottom.reverse();
			//top5歪柱状图
			var myChart1 = echarts.init(document.getElementById('gzsph-chart-top'),'shine');
			var option = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataTop,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: [
			       
			        {
			            name: '故障数',
			            type: 'bar',
			            barWidth :20,//设置宽度
			            data: ydataTop,//后台传的数据
		                itemStyle: {
			                normal: {
			                	 label: {
					                    show: true,
					                    position: 'insideRight'
						         },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#0c9','#0cc','#3cc','#3cf','#39f'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }]
			    
			};
			myChart1.setOption(option);
			//////////////////////////////////////////////////////////////////////////
			//bottom5歪柱状图
			var myChart2 = echarts.init(document.getElementById('gzsph-chart-bottom'),'shine');
			var option2 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataBottom,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: [
			       
			        {
			            name: '故障数',
			            type: 'bar',
			       
			            barWidth :20,//设置宽度
			            data: ydataBottom,//后台传的数据
		                itemStyle: {
			                normal: {
			                	label: {
				                    show: true,
				                    position: 'insideRight'
					           },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#cc6','#fc0','#f90','#f60','#f00'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }]
			    
			};
			myChart2.setOption(option2);
		}
　
		function 	fdlphChart(fdlphTop,fdlphbottom){		
			var xdataTop = [];
			var ydataTop = [];
			if(fdlphTop && fdlphTop != undefined ){
				for(var i = 0 ; i < fdlphTop.length ; i++){
					var pw = fdlphTop[i].pws_nam ;
					if(fdlphTop[i].pws_nam.length > 14 ){
						pw = fdlphTop[i].pws_nam.substring(0,14)+"..."
					}
					xdataTop.push(pw);
					ydataTop.push(getFixedNumNew5(fdlphTop[i].power));
				}
			}
			var xdataBottom = [];
			var ydataBottom = [];
			if(fdlphbottom && fdlphbottom != undefined ){
				for(var i = 0 ; i < fdlphbottom.length ; i++){
					var pw = fdlphbottom[i].pws_nam ;
					if(fdlphbottom[i].pws_nam.length > 14 ){
						pw = fdlphbottom[i].pws_nam.substring(0,14)+"..."
					}
					xdataBottom.push(pw);
					ydataBottom.push(getFixedNumNew5(fdlphbottom[i].power));
				}
			}
			xdataTop.reverse();
			ydataTop.reverse();
			xdataBottom.reverse();
			ydataBottom.reverse();
			//top5歪柱状图
			var myChart1 = echarts.init(document.getElementById('fdlph-chart-top'),'shine');
			var option = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataTop,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: [
			       
			        {
			            name: '发电量',
			            type: 'bar',
			            barWidth :20,//设置宽度
			            data: ydataTop,//后台传的数据
		                itemStyle: {
			                normal: {
			                	label: {
				                    show: true,
				                    position: 'insideRight'
					           },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#0c9','#0cc','#3cc','#3cf','#39f'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }]
			    
			};
			myChart1.setOption(option);
			//////////////////////////////////////////////////////////////////////////
			//bottom5歪柱状图
			var myChart2 = echarts.init(document.getElementById('fdlph-chart-bottom'),'shine');
			var option2 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataBottom,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: 
			       [
			        {
			            name: '发电量',
			            type: 'bar',
			       
			            barWidth :20,//设置宽度
			            data: ydataBottom,//后台传的数据
		                itemStyle: {
			                normal: {
			                	label: {
				                    show: true,
				                    position: 'insideRight'
					           },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#cc6','#fc0','#f90','#f60','#f00'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }]
			    
			};
			myChart2.setOption(option2);
		}
		
		function 	fdyxxssphChart(fdyxxssphTop,fdyxxssphbottom){		
			var xdataTop = [];
			var ydataTop = [];
			if(fdyxxssphTop && fdyxxssphTop != undefined ){
				for(var i = 0 ; i < fdyxxssphTop.length ; i++){
					var pw = fdyxxssphTop[i].pws_nam ;
					if(fdyxxssphTop[i].pws_nam.length > 14 ){
						pw = fdyxxssphTop[i].pws_nam.substring(0,14)+"..."
					}
					xdataTop.push(pw);
					ydataTop.push(getFixedNumNew5(fdyxxssphTop[i].pow_gen_eff_hours));
				}
			}
			var xdataBottom = [];
			var ydataBottom = [];
			if(fdyxxssphbottom && fdyxxssphbottom != undefined){
				for(var i = 0 ; i < fdyxxssphbottom.length ; i++){
					var pw = fdyxxssphbottom[i].pws_nam ;
					if(fdyxxssphbottom[i].pws_nam.length > 14 ){
						pw = fdyxxssphbottom[i].pws_nam.substring(0,14)+"..."
					}
					xdataBottom.push(pw);
					ydataBottom.push(getFixedNumNew5(fdyxxssphbottom[i].pow_gen_eff_hours));
				}
			}
			xdataTop.reverse();
			ydataTop.reverse();
			xdataBottom.reverse();
			ydataBottom.reverse();
			//top5歪柱状图
			var myChart1 = echarts.init(document.getElementById('fdyxxssph-chart-top'),'shine');
			var option = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataTop,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: 
			       [
			        {
			            name: '发电有效小时数',
			            type: 'bar',
			            barWidth :20,//设置宽度
			            data: ydataTop,//后台传的数据
		                itemStyle: {
			                normal: {
			                	label: {
				                    show: true,
				                    position: 'insideRight'
					         },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#0c9','#0cc','#3cc','#3cf','#39f'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }
			    ]
			};
			myChart1.setOption(option);
			//////////////////////////////////////////////////////////////////////////
			//bottom5歪柱状图
			var myChart2 = echarts.init(document.getElementById('fdyxxssph-chart-bottom'),'shine');
			var option2 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataBottom,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: 
			       [
			        {
			            name: '发电有效小时数',
			            type: 'bar',
			       
			            barWidth :20,//设置宽度
			            data: ydataBottom,//后台传的数据
		                itemStyle: {
			                normal: {
			                	label: {
				                    show: true,
				                    position: 'insideRight'
					         },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#cc6','#fc0','#f90','#f60','#f00'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }]
			    
			};
			myChart2.setOption(option2);
		}
		
		function 	cdlphChart(cdlphTop,cdlphbottom){		
			var xdataTop = [];
			var ydataTop = [];
			if(cdlphTop && cdlphTop != undefined){
				for(var i = 0 ; i < cdlphTop.length ; i++){
					var pw = cdlphTop[i].pws_nam ;
					if(cdlphTop[i].pws_nam.length > 14 ){
						pw = cdlphTop[i].pws_nam.substring(0,14)+"..."
					}
					xdataTop.push(pw);
					ydataTop.push(getFixedNumNew5(cdlphTop[i].cha_vol));
				}
			}
			var xdataBottom = [];
			var ydataBottom = [];
			if(cdlphbottom && cdlphbottom != undefined ){
				for(var i = 0 ; i < cdlphbottom.length ; i++){
					var pw = cdlphbottom[i].pws_nam ;
					if(cdlphbottom[i].pws_nam.length > 14 ){
						pw = cdlphbottom[i].pws_nam.substring(0,14)+"..."
					}
					xdataBottom.push(pw);
					ydataBottom.push(getFixedNumNew5(cdlphbottom[i].cha_vol));
				}
			}
			xdataTop.reverse();
			ydataTop.reverse();
			xdataBottom.reverse();
			ydataBottom.reverse();
			//top5歪柱状图
			var myChart1 = echarts.init(document.getElementById('cdlph-chart-top'),'shine');
			var option = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataTop,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: 
			       [
			        {
			            name: '充电量',
			            type: 'bar',
			            barWidth :20,//设置宽度
			            data: ydataTop,//后台传的数据
		                itemStyle: {
			                normal: {
			                	label: {
				                    show: true,
				                    position: 'insideRight'
					         },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#0c9','#0cc','#3cc','#3cf','#39f'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }]
			    
			};
			myChart1.setOption(option);
			//////////////////////////////////////////////////////////////////////////
			//bottom5歪柱状图
			var myChart2 = echarts.init(document.getElementById('cdlph-chart-bottom'),'shine');
			var option2 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataBottom,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: 
			       [
			        {
			            name: '充电量',
			            type: 'bar',
			       
			            barWidth :20,//设置宽度
			            data: ydataBottom,//后台传的数据
		                itemStyle: {
			                normal: {
			                	label: {
				                    show: true,
				                    position: 'insideRight'
					         },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#cc6','#fc0','#f90','#f60','#f00'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }]
			    
			};
			myChart2.setOption(option2);
		}
		
		function 	cdyxxssphChart(cdyxxssphTop,cdyxxssphbottom){		
			var xdataTop = [];
			var ydataTop = [];
			if(cdyxxssphTop && cdyxxssphTop != undefined){
				for(var i = 0 ; i < cdyxxssphTop.length ; i++){
					var pw = cdyxxssphTop[i].pws_nam ;
					if(cdyxxssphTop[i].pws_nam.length > 14 ){
						pw = cdyxxssphTop[i].pws_nam.substring(0,14)+"..."
					}
					xdataTop.push(pw);
					ydataTop.push(getFixedNumNew5(cdyxxssphTop[i].cha_gen_eff_hours));
				}	
			}
			
			var xdataBottom = [];
			var ydataBottom = [];
			if(cdyxxssphbottom && cdyxxssphbottom != undefined){
				for(var i = 0 ; i < cdyxxssphbottom.length ; i++){
					var pw = cdyxxssphbottom[i].pws_nam ;
					if(cdyxxssphbottom[i].pws_nam.length > 14 ){
						pw = cdyxxssphbottom[i].pws_nam.substring(0,14)+"..."
					}
					xdataBottom.push(pw);
					ydataBottom.push(getFixedNumNew5(cdyxxssphbottom[i].cha_gen_eff_hours));
				}
			}
			xdataTop.reverse();
			ydataTop.reverse();
			xdataBottom.reverse();
			ydataBottom.reverse();
			//top5歪柱状图
			var myChart1 = echarts.init(document.getElementById('cdyxxssph-chart-top'),'shine');
			var option = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataTop,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: 
			       [
			        {
			            name: '充电有效小时数',
			            type: 'bar',
			            barWidth :20,//设置宽度
			            data: ydataTop,//后台传的数据
		                itemStyle: {
			                normal: {
			                	label: {
				                    show: true,
				                    position: 'insideRight'
					         },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#0c9','#0cc','#3cc','#3cf','#39f'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }]
			    
			};
			myChart1.setOption(option);
			//////////////////////////////////////////////////////////////////////////
			//bottom5歪柱状图
			var myChart2 = echarts.init(document.getElementById('cdyxxssph-chart-bottom'),'shine');
			var option2 = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'show'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			            left: '0',
			            top: '0',
			            right: '0',
			            bottom: '0',
			            containLabel: true
			        },
			    xAxis:  {
			        type: 'value',
			        splitLine:{show: false},
			        axisLine:false,
			        show:false,
			    
			    },
			    yAxis: {
			        type: 'category',
			        data: xdataBottom,//后台传的名称
			        splitLine:{show: false},
			        axisLine:false,
			        axisTick:false
			    },

			    series: 
			       [
			        {
			            name: '充电有效小时数',
			            type: 'bar',
			       
			            barWidth :20,//设置宽度
			            data: ydataBottom,//后台传的数据
		                itemStyle: {
			                normal: {
			                	label: {
				                    show: true,
				                    position: 'insideRight'
					         },
			                    color: function(params) {
			                        // build a color map as your need.
			                        var colorList = [
			                          '#cc6','#fc0','#f90','#f60','#f00'
			                        ];
			                        return colorList[params.dataIndex]
			                    }
			                }
			            }
			        }]
			    
			};
			myChart2.setOption(option2);
		}
	</script>
</html>
