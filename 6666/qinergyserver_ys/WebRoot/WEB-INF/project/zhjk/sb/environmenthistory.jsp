<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc-history.css?pubVersion=201802070001" />
	</head>
	<body class="pl8t0 bgfc">
		<input type="hidden" value="${app_typ_id}" id="app_typ_id"> 
		<input type="hidden" value="${pws_id}" id="pws_id"> 
		<input type="hidden" value="${equNum}" id="equNum"> 
		<div class="his-body">
			<div class="his-tit">历史分析</div>
			<div style="width:100%; float:left;">
				<div class="his-table-body">
					<div class="a44">
						<p>辐射量</p>
						<input type="text" id="dateTime_sta" placeholder="请选择时间" class="fr  Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData,maxDate:'%y-%M-%d'})"> 
					</div>
					<div class="his-img" id="fsl"></div>
				</div>
				 <div class="cler"></div>
				<div class="his-table-body">
					<div class="a44">
						<p>风速风向</p>
						<!-- <input type="text" id="sta_tim2" placeholder="请选择时间" class="fr  Wdate"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:getData2,maxDate:'%y-%M-%d'})"> -->
					</div>
					<div class="his-img" id="fsfx"></div>
				</div>
				<div class="his-table">
					<div style="height:285px;" >
						<table  width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th>序号</th>
								<th>时间</th>
								<th>倾斜面瞬时辐射(W/㎡)</th>
								<th>水平面瞬时辐射(W/㎡)</th>
								<th>风速(m/s)</th>
								<th>风向(°)</th>
							</tr>
							<tbody id="list1">
								<tr>
									<td>暂无数据</td>
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
								</tr>
								<tr>
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
								</tr>
								<tr>
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
								</tr>
								<tr>
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
								</tr>
							</tbody>
						</table>
					</div>
					<div class="tcdPageCode" id="tcdPageCode1"></div> 
				</div>
			</div>
			<div class="cler"></div>
			<div class="his-table mb50" style="height: 390px;">
				<div class="a1"  >
					<div class="fl"><h4 style="line-height:35px;font-weight: normal;">变位历史信息</h4></div>
					<div class="fr"> 
						<input type="text"  id="sta_tim_bw"  placeholder="开始时间" class=" Wdate" style="width: 108px;padding-left: 5px;height: 30px; line-height: 30px;    border-radius: 3px;"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim_bw\')||\'%y-%M-%d\'}'})">
						<span style="color:#999">---</span>
						<input type="text"  id="end_tim_bw" placeholder="结束时间" class=" Wdate" style="width: 108px;padding-left: 5px;height: 30px; line-height: 30px;    border-radius: 3px;"   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sta_tim_bw\')}',maxDate:'%y-%M-%d'})"> 
						<input class="his-btn"  id="his-btn3" type="submit" value="查询">
					</div>
				</div>
				<div  style="height:285px;">
					<table  width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>序号</th>
							<th>变位时间</th>
							<th>设备编号</th>
							<th>设备名称</th>
							<th>设备类型</th>
							<th>变位码</th>
							<th>变位信息</th>
							<th>初始状态</th>
							<th>当前状态</th>
						</tr>
						<tbody id="list3_bw">
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
				<div class="tcdPageCode" id="tcdPageCode-bw">
				
				</div> 
			</div>
		</div>
	
<script type="text/javascript" src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<%-- <script type="text/javascript" src="<%=basePath%>js/echarts.min.js?pubVersion=201802070001"></script> --%>
<script src="<%=basePath%>js/echarts-3.6.0/dist/echarts.min.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/sb-history.js?pubVersion=201802070001"></script>
<script type="text/javascript">
	var pws_id="";
	var app_typ_id="";
	
	var equNum = "";
 	$(function (){
 		pws_id=$("#pws_id").val();
 		app_typ_id=$("#app_typ_id").val(); 
 		
 		var result=getDateToday();
 		$("#dateTime_sta").val(result);
		getData(equNum);
		
		$("#sta_tim_bw").val(result);
		$("#end_tim_bw").val(result);
		getBwData()
			
 	})
 	 
 	
 	var countAll = 0;
	var currentPage  = 1;
 	
 	function getData(equNum){
 		equNum = sessionStorage.getItem("environmentEquNum");
 		$("#equNum").val(sessionStorage.getItem("environmentEquNum"));
 		if(sessionStorage.getItem("environmentEquNum") == undefined || sessionStorage.getItem("environmentEquNum") == '' || sessionStorage.getItem("environmentEquNum") == null){
 			/* getReal(pws_id,app_typ_id) */
 		}else{
 			equNum = sessionStorage.getItem("environmentEquNum");
 			/* getData(equNum); */
 		}
 		var param = "equ_num="+equNum;
 	 
 		var sjlx = 3;
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&year="+dateTime_sta+"&type="+sjlx;
		}
 		param += "&currentPage="+currentPage;
 		$.ajax({
	    	url:url+"getEnvInfoByYearList.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			countAll = data.totalPage;
					currentPage = data.currentPage;
	    			 if(data.data.length> 0){
    					 $("#list1").empty();
    					 for(var i = 0 ; i < data.data.length ; i++){
	    					 var htmlList1 = "";
    						 var lst = data.data[i];
    						 htmlList1 += "<tr>"+
    						 	"<td>"+((currentPage-1)*10+i+1)+"</td>"+
								"<td>"+getLocalDateAndTime(lst.crtTim,6)+"</td>"+
								"<td>"+getFixedNum5(lst.htv)+"</td>"+
								"<td>"+getFixedNum5(lst.hgv)+"</td>"+
								"<td>"+getFixedNum5(lst.windSpeed)+"</td>"+
								"<td>"+getFixedNum5(lst.windDir)+"</td>"+
								"</tr>";
    						  $("#list1").append(htmlList1);
    					 }
    					 
	    				 
	   					$("#tcdPageCode1").createPage({
	 				        pageCount:countAll,
	 				        current:currentPage,
	 				        backFn:function(p){
	 				        	currentPage = p;
	 				        	getData(equNum);
	 				        }
	 			    	});
	    			 }else{
		 					var h = "<tr>"+
							"<td>暂无数据</td>"+
							"<td></td>"+
							"<td></td>"+
							"<td></td>"+
							"<td></td>"+
							"<td></td>"+
						"</tr>";
						$("#list1").html(h);
						$("#tcdPageCode1").empty();
					}
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	    getGraph(equNum);
 	}
 	 
 	

 	function getReal(pws_id,app_typ_id){
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
 							var id = t.id;
 							getRight(id);
 						}
 					}
 				}else{
 					layer.alert(data.desc);
 				}
 			}
 		})
 	}


 	function getRight(id){
 		$.ajax({
 			url:url+"getEnvInfoNewById.htm",
 			type:"post",
 			dataType:"json",
 			data:"id="+id,
 			success:function(data){
 				if(data.resultcode=="USR000"){
 					 if(data.data){
 	    				 for(var i=0;i<data.data.length;i++){
 	    					 var d=data.data[i];
	 	    				 equNum =  d.equ_num;
	 	    				 getData(equNum);
 	    				 }
 	    			 }
 				}else{
 		            layer.alert(data.desc);
 				}
 			}
 		})
 	}
 	
 	function getGraph(equNum){
 		var param = "equ_num="+equNum;
 	 
 		var dateTime_sta = $("#dateTime_sta").val();
 		
 		if(dateTime_sta != undefined && dateTime_sta != ""){
			param += "&year="+dateTime_sta;
		}
 		$.ajax({
	    	url:url+"getEnvInfoByYearGraph.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			setChart(data.data);
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 		$.ajax({
	    	url:url+"getEnvInfoByYear24HoursGraph.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			setChartFsfx(data.data);
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
 	}
 	
 	
 	
 	function setChart(data){
 	 	var xTime=[];
 	 	var hgv=[];
 	 	var htv=[];
 	 	for(var i=0;i<data.length;i++){
 	 		var a=data[i];
 	 		xTime.push(getLocalDateAndTime(a.tol_tim,6));
 	 		hgv.push(getFixedNum5(a.hgv));
 	 		htv.push(getFixedNum5(a.htv));
 	 		
 	 		
 	 	}
 	 	var myChart = echarts.init(document.getElementById('fsl'), 'shine');
 		option = {
 				legend: {
 			        data: ['水平面瞬时辐射','斜面瞬时辐射'],
 			        top: 10,
 			    },
 				tooltip : {
 					trigger : 'axis'
 				},
 				grid : {
 					show : true,
 					left : '60',
 					top : '40',
 					right : '60',
 					bottom : '30'
 				},
 				calculable : true,
 				xAxis : [ {
 					type : 'category',
 					boundaryGap : false,
 					data : xTime
 				} ],
 				yAxis : {
 					type : 'value',
 					name : '',
 					axisLabel : {
 					formatter : '{value}'
 					}
 				},
 				series : [ {
 					name : '水平面瞬时辐射',
 					type : 'line',
 					smooth : true,
 					data : hgv,
 					symbol : 'none',
 					itemStyle : {
 						normal : {
 							color : '#EDB213'
 						}
 					}  
 				},
 				{
 					name : '斜面瞬时辐射',
 					type : 'line',
 					smooth : true,
 					data : htv,
 					symbol : 'none',
 					itemStyle : {
 						normal : {
 							color : '#35BEB5'
 						}
 					}  
 				}

 				]
 			};

 			myChart.setOption(option);
 	}
 	
 	function setChartFsfx(data2){
 		var	rawData = {}   ;
 	  
 	 	if(data2.length > 0){
 	 		rawData = data2 ; 
 	 	}
 		var myChart = echarts.init(document.getElementById('fsfx'), 'shine');
 		
 		  
	    var data = [] ; 
   		$.each(rawData, function (i,entry) {
	    	 var fatp = [];
	    	if(entry.tol_tim != '' && entry.tol_tim != undefined && entry.windSpeed != '' && entry.windSpeed != undefined && entry.windDirNSEW != '' && entry.windDirNSEW != undefined){
	    		fatp.push(getLocalDateAndTime(entry.tol_tim,1));
	    		fatp.push(getFixedNum(entry.windSpeed));
	    		fatp.push(entry.windDirNSEW);
	    		data.push(fatp);
	    	}else{
	    		fatp.push(getLocalDateAndTime(entry.tol_tim,1));
	    		fatp.push("-");
	    		fatp.push("-");
	    		data.push(fatp);
    	  }
	    	
	    });
   		if(data.length > 0 ){
   			var directionMap = {};
   		    echarts.util.each(
   		    		[ 'N', 'NNW', 'NW', 'WNW','W', 'WSW', 'SW', 'SSW', 'S', 'SSE', 'SE', 'ESE' , 'E', 'ENE', 'NE', 'NNE' ],
   		        function (name, index) {
   		            directionMap[name] = Math.PI / 8 * index;
   		        }
   		    );
 		    
 		    var dims = {
 	    		tol_tim: 0,
 		        windSpeed: 1,
 		        windDirNSEW: 2
 		    };
 		    var arrowSize = 20;
 		    var weatherIconSize = 45;

 		    function renderArrow(param, api) {
 		        var point = api.coord([
 		            api.value(dims.tol_tim),
 		            api.value(dims.windSpeed)
 		        ]);
				
 		        return {
 		           // type: 'path',
 		            type: 'image',
 		            shape: {
 		                //pathData: 'M31 16l-15-15v9h-26v12h26v9z',
 		                x: -arrowSize / 2,
 		                y: -arrowSize / 2,
 		                width: arrowSize,
 		                height: arrowSize
 		            },
 		            rotation: directionMap[api.value(dims.windDirNSEW)],
 		            position:[ point[0]+10,point[1]+10 ],
 		            style: api.style({
 		            	image: '../../../images/fxb.png',
 		                stroke: '#fff',
 		                lineWidth: 1
 		            })
 		        };
 		    }
 		 	 
 		    option = {
 		        title: {
 		            text: '', 
 		            left: 'center'
 		        },
 		        tooltip: {
 		            trigger: 'axis',
 		            formatter: function (params) {
 		                return [
 		                    params[0].value[dims.tol_tim],
 		                    '风速：' + params[0].value[dims.windSpeed],
 		                    '风向：' + params[0].value[dims.windDirNSEW]
 		                ].join('<br>');
 		            }
 		        },
 		        grid: {
 		        	show : true,
 		        	left : '60',
 					top : '40',
 					right : '60',
 					bottom : '30'
 		        },
 		        xAxis: {
 		            type: 'time', 
 		            splitLine: {
 		                lineStyle: {
 		                    color: '#ddd'
 		                }
 		            },
 		           splitNumber : data.length,
 		           axisLabel : {
 		        	   formatter : function(params){
 		        		   
 		        		  return getLocalDateAndTime(params,6); 
 		        		  //return '00:15'
 		        	   }
 		           }
 		        },
 		        yAxis: [{
 		            name: '风速', 
 		            axisLine: {
 		                lineStyle: {
 		                    color: '#666'
 		                }
 		            },
 		            splitLine: {
 		                lineStyle: {
 		                    color: '#ddd'
 		                }
 		            }
 		        },{
 		            axisLine: {show: false},
 		            axisTick: {show: false},
 		            axisLabel: {show: false},
 		            splitLine: {show: false}
 		        }], 
 		        series: [ {
 		            type: 'custom',
 		            renderItem: renderArrow,
 		            encode: {
 		                x: dims.tol_tim,
 		                y: dims.windSpeed
 		            },
 		            data: data,
 		            z: 10
 		        }, {
 		            type: 'line',
 		            symbol: 'none',
 		            encode: {
 		                x: dims.tol_tim,
 		                y: dims.windSpeed
 		            },
 		            areaStyle: {
 		                normal: {
 		                    color: {
 		                        type: 'linear',
 		                        x: 0,
 		                        y: 0,
 		                        x2: 0,
 		                        y2: 1,
 		                        colorStops: [{
 		                            offset: 0, color: 'rgba(88,160,253,1)'
 		                        }, {
 		                            offset: 0.5, color: 'rgba(88,160,253,0.7)'
 		                        }, {
 		                            offset: 1, color: 'rgba(88,160,253,0)'
 		                        }]
 		                    }
 		                }
 		            },
 		            lineStyle: {
 		                normal: {
 		                    color: '#aaa' 
 		                }
 		            },
 		            data: data,
 		            z: 1
 		        }]
 		    };
 		    
 		    
 	}else{
   		var xTime=[];
   	 	var hgv=[];
   	 	var htv=[];
   	 	if(data2.length > 0 && data2[0]){
	   	 	$.each(data2, function (i,entry) {
		       	 if(entry.tol_tim != '' && entry.tol_tim != undefined ){
	       			xTime.push(getLocalDateAndTime(entry.tol_tim,6));
	       			hgv.push(getFixedNum5(entry.windSpeed));
	       			htv.push(getFixedNum5(entry.windDir));
		       	  }
	       });
   	 	}
   	 var myChart = echarts.init(document.getElementById('fsfx'), 'shine');
	 option = {
 			legend: {
 		        data: ['风速','风向'],
 		        top: 10,
 		    },
 			tooltip : {
 				trigger : 'axis'
 			},
 			grid : {
 				show : true,
				left : '60',
				top : '40',
				right : '60',
				bottom : '30'
 			},
 			calculable : true,
 			xAxis : [ {
 				type : 'category',
 				boundaryGap : false,
 				data : xTime
 			} ],
 			yAxis : [{
 				type : 'value',
 				name : '风速(m/s)',
 				axisLabel : {
 				formatter : '{value}'
 				}
 			},{
 				type : 'value',
 				name : '风向',
 				axisLabel : {
 				formatter : '{value}'
 				}
 			}],
 			series : [ {
 				name : '风速',
 				type : 'line',
 				smooth : true,
 				data : hgv,
 				 symbol : 'none' ,
 					itemStyle : {
 						normal : {
 							color : '#EDB213'
 						}
 					}
 			},
 			{
 				name : '风向',
 				type : 'line',
 				smooth : true,
 				data : htv,
 				symbol : 'none',
 				yAxisIndex:1,
 				 itemStyle : {
 					normal : {
 						color : '#07CB47'
 					}
 				}  
 			}

 			]
 		};

   	}
    
    myChart.setOption(option); 
 	    
 	 /*   var json = {
 			    "data": [
 			             {
 			                 "time": "2017-06-27",
 			                 "windSpeed": 9,
 			                 "R": "NNW",
 			                 "waveHeight": 2.64
 			             },
 			             {
 			                 "time": "2017-06-28",
 			                 "windSpeed": 10,
 			                 "R": "NNW",
 			                 "waveHeight": 2.57
 			             },
 			             {
 			                 "time": "2017-06-28",
 			                 "windSpeed": 12,
 			                 "R": "NNW",
 			                 "waveHeight": 2.49
 			             },
 			             {
 			                 "time": "2017-06-30",
 			                 "windSpeed": 12,
 			                 "R": "NNW",
 			                 "waveHeight": 2.44
 			             },
 			             {
 			                 "time": "2017-06-31",
 			                 "windSpeed": 11,
 			                 "R": "NNW",
 			                 "waveHeight": 2.38
 			             },
 			             {
 			                 "time": "2017-07-01",
 			                 "windSpeed": 10,
 			                 "R": "NNW",
 			                 "waveHeight": 2.34
 			             },
 			             {
 			                 "time": "2017-07-02",
 			                 "windSpeed": 10,
 			                 "R": "N",
 			                 "waveHeight": 2.3
 			             },
 			             {
 			                 "time": "2017-07-03",
 			                 "windSpeed": 11,
 			                 "R": "NNW",
 			                 "waveHeight": 2.26
 			             },
 			             {
 			                 "time": "2017-07-04",
 			                 "windSpeed": 12,
 			                 "R": "NNW",
 			                 "waveHeight": 2.22
 			             },
 			             {
 			                 "time": "2017-07-05",
 			                 "windSpeed": 12,
 			                 "R": "N",
 			                 "waveHeight": 2.18
 			             },
 			             {
 			                 "time": "2017-07-06",
 			                 "windSpeed": 12,
 			                 "R": "N",
 			                 "waveHeight": 2.13
 			             },
 			             {
 			                 "time": "2017-07-07",
 			                 "windSpeed": 12,
 			                 "R": "N",
 			                 "waveHeight": 2.09
 			             },
 			             {
 			                 "time": "2017-07-08",
 			                 "windSpeed": 12,
 			                 "R": "NNE",
 			                 "waveHeight": 2.04
 			             },
 			             {
 			                 "time": "2017-07-09",
 			                 "windSpeed": 10,
 			                 "R": "N",
 			                 "waveHeight": 2.01
 			             },
 			             {
 			                 "time": "2017-07-10",
 			                 "windSpeed": 9,
 			                 "R": "N",
 			                 "waveHeight": 1.99
 			             },
 			             {
 			                 "time": "2017-07-11",
 			                 "windSpeed": 8,
 			                 "R": "NNW",
 			                 "waveHeight": 2
 			             },
 			             {
 			                 "time": "2017-07-12",
 			                 "windSpeed": 8,
 			                 "R": "NW",
 			                 "waveHeight": 2.01
 			             },
 			             {
 			                 "time": "2017-07-13",
 			                 "windSpeed": 8,
 			                 "R": "NW",
 			                 "waveHeight": 2.06
 			             },
 			             {
 			                 "time": "2017-07-14",
 			                 "windSpeed": 9,
 			                 "R": "WNW",
 			                 "waveHeight": 2.12
 			             },
 			             {
 			                 "time": "2017-07-15",
 			                 "windSpeed": 10,
 			                 "R": "WNW",
 			                 "waveHeight": 2.19
 			             },
 			             {
 			                 "time": "2017-07-16",
 			                 "windSpeed": 11,
 			                 "R": "WNW",
 			                 "waveHeight": 2.27
 			             },
 			             {
 			                 "time": "2017-07-17",
 			                 "windSpeed": 12,
 			                 "R": "WNW",
 			                 "waveHeight": 2.33
 			             },
 			             {
 			                 "time": "2017-07-18",
 			                 "windSpeed": 13,
 			                 "R": "NW",
 			                 "waveHeight": 2.39
 			             },
 			             {
 			                 "time": "2017-07-19",
 			                 "windSpeed": 13,
 			                 "R": "NW",
 			                 "waveHeight": 2.43
 			             },
 			             {
 			                 "time": "2017-07-20",
 			                 "windSpeed": 14,
 			                 "R": "NW",
 			                 "waveHeight": 2.46
 			             },
 			             {
 			                 "time": "2017-07-21",
 			                 "windSpeed": 16,
 			                 "R": "NW",
 			                 "waveHeight": 2.48
 			             },
 			             {
 			                 "time": "2017-07-22",
 			                 "windSpeed": 18,
 			                 "R": "NNW",
 			                 "waveHeight": 2.49
 			             },
 			             {
 			                 "time": "2017-07-23",
 			                 "windSpeed": 20,
 			                 "R": "WNW",
 			                 "waveHeight": 2.53
 			             },
 			             {
 			                 "time": "2017-07-24",
 			                 "windSpeed": 22,
 			                 "R": "W",
 			                 "waveHeight": 2.58
 			             },
 			             {
 			                 "time": "2017-07-25",
 			                 "windSpeed": 26,
 			                 "R": "WSW",
 			                 "waveHeight": 2.89
 			             },
 			             {
 			                 "time": "2017-07-26",
 			                 "windSpeed": 30,
 			                 "R": "WSW",
 			                 "waveHeight": 3.21
 			             },
 			             {
 			                 "time": "2017-07-27",
 			                 "windSpeed": 30,
 			                 "R": "SW",
 			                 "waveHeight": 3.58
 			             },
 			             {
 			                 "time": "2017-07-28",
 			                 "windSpeed": 29,
 			                 "R": "SW",
 			                 "waveHeight": 3.94
 			             },
 			             {
 			                 "time": "2017-07-29",
 			                 "windSpeed": 29,
 			                 "R": "SW",
 			                 "waveHeight": 4.08
 			             },
 			             {
 			                 "time": "2017-07-30",
 			                 "windSpeed": 29,
 			                 "R": "SW",
 			                 "waveHeight": 4.22
 			             },
 			             {
 			                 "time": "2017-07-31",
 			                 "windSpeed": 28,
 			                 "R": "SW",
 			                 "waveHeight": 4.25
 			             },
 			             {
 			                 "time": "2017-08-01",
 			                 "windSpeed": 28,
 			                 "R": "SW",
 			                 "waveHeight": 4.28
 			             },
 			             {
 			                 "time": "2017-08-02",
 			                 "windSpeed": 29,
 			                 "R": "SSW",
 			                 "waveHeight": 4.37
 			             },
 			             {
 			                 "time": "2017-08-03",
 			                 "windSpeed": 30,
 			                 "R": "SSW",
 			                 "waveHeight": 4.45
 			             },
 			             {
 			                 "time": "2017-08-04",
 			                 "windSpeed": 29,
 			                 "R": "SSW",
 			                 "waveHeight": 4.45
 			             },
 			             {
 			                 "time": "2017-08-05",
 			                 "windSpeed": 27,
 			                 "R": "SSW",
 			                 "waveHeight": 4.45
 			             } 
 			             
 			         ] 
 			     }
 		 //var objs  = JSON.stringify(json); 
 	   var myChart = echarts.init(document.getElementById('fsfx'), 'shine');
 	   
 	   var directionMap = {};
		    echarts.util.each(
		        ['W', 'WSW', 'SW', 'SSW', 'S', 'SSE', 'SE', 'ESE', 'E', 'ENE', 'NE', 'NNE', 'N', 'NNW', 'NW', 'WNW'],
		        function (name, index) {
		            directionMap[name] = Math.PI / 8 * index;
		        }
		    );

		    var data = echarts.util.map(json.data, function (entry) {
		        return [entry.time, entry.windSpeed,  entry.R ];
		    });
		    
		    var dims = {
	    		time: 0,
		        windSpeed: 1,
		        R: 2
		    };
		    var arrowSize = 18;
		    var weatherIconSize = 45;

		    function renderArrow(param, api) {
		        var point = api.coord([
		            api.value(dims.time),
		            api.value(dims.windSpeed)
		        ]);

		        return {
		            type: 'path',
		            shape: {
		                pathData: 'M31 16l-15-15v9h-26v12h26v9z',
		                x: -arrowSize / 2,
		                y: -arrowSize / 2,
		                width: arrowSize,
		                height: arrowSize
		            },
		            rotation: directionMap[api.value(dims.R)],
		            position: point,
		            style: api.style({
		                stroke: '#555',
		                lineWidth: 1
		            })
		        };
		    }
		 
		    option = {
		        title: {
		            text: '', 
		            left: 'center'
		        },
		        tooltip: {
		            trigger: 'axis',
		            formatter: function (params) {
		                return [
		                    params[0].value[dims.time],
		                    '风速：' + params[0].value[dims.windSpeed],
		                    '风向：' + params[0].value[dims.R]
		                ].join('<br>');
		            }
		        },
		        grid: {
		        	show : true,
		        	left : '60',
					top : '40',
					right : '60',
					bottom : '30'
		        },
		        xAxis: {
		            type: 'time', 
		            splitLine: {
		                lineStyle: {
		                    color: '#ddd'
		                }
		            }
		        },
		        yAxis: [{
		            name: '风速', 
		            axisLine: {
		                lineStyle: {
		                    color: '#666'
		                }
		            },
		            splitLine: {
		                lineStyle: {
		                    color: '#ddd'
		                }
		            }
		        },{
		            axisLine: {show: false},
		            axisTick: {show: false},
		            axisLabel: {show: false},
		            splitLine: {show: false}
		        }], 
		        series: [ {
		            type: 'custom',
		            renderItem: renderArrow,
		            encode: {
		                x: dims.time,
		                y: dims.windSpeed
		            },
		            data: data,
		            z: 10
		        }, {
		            type: 'line',
		            symbol: 'none',
		            encode: {
		                x: dims.time,
		                y: dims.windSpeed
		            },
		            areaStyle: {
		                normal: {
		                    color: {
		                        type: 'linear',
		                        x: 0,
		                        y: 0,
		                        x2: 0,
		                        y2: 1,
		                        colorStops: [{
		                            offset: 0, color: 'rgba(88,160,253,1)'
		                        }, {
		                            offset: 0.5, color: 'rgba(88,160,253,0.7)'
		                        }, {
		                            offset: 1, color: 'rgba(88,160,253,0)'
		                        }]
		                    }
		                }
		            },
		            lineStyle: {
		                normal: {
		                    color: '#aaa' 
		                }
		            },
		            data: data,
		            z: 1
		        }]
		    };
	  	  myChart.setOption(option); 
 		   */
 	}
</script>		
		
	</body>
</html>
