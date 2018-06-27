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
		<title>电站故障率等对比分析</title>
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
	</head>
	<body class="bgfc">
		<input type="hidden" id="userId" value="${user.id}"> 
		<div class="w100 fl mt15">
			 <div class="pl15 ml15 mr15">
	            <div class="pr8 mt10  ">
	              <div   class="w100 bg-ff bor-ccc" style="	height: auto;overflow: hidden;"> 
	              	 <div class="w90 fl mt15">
	              	 	<div class="tj-query">
                  	   		<span>时间：</span>
                  	   		<div   class="sz-area">
                  	   			 <select class="fl quinput w20"  id="timeType" style="margin-left:22px;" onchange="changeTime(this.value);">
                  	   			 	<option value="1">选年统计</option>
                  	   			 	<option value="2">选月统计</option>
                  	   			 	<!-- <option value="3">选日统计</option> -->
                  	   			 </select>
                  	   			 <input type="text"  placeholder="请输入.."  id="time" class="fl  fx  Wdate" style="margin-left:15px;" onFocus="WdatePicker({dateFmt:'yyyy'})">
                  	   		</div>
	              		</div>
	              		<div class="tj-query">
                  	   		<span>参数：</span>
                  	   		<div id="param" class="sz-area">
                  	   			<div>
                  	   				<div class="kuai">
	                  	   				<div class="kuai2"  id="type1"></div>
	               	   				</div>
	               	   				<div class="sz-name">故障设备数</div>
                  	   			</div>
                  	   		</div>
	              		</div>
                  	   <div class="tj-query">
                  	   		<span>地区：</span>
                  	   		<div id="area" class="sz-area">
               	   				<!-- <div class="area-box">
                  	   				<div class="kuai">
	                  	   				<div class="kuai2"></div>
	               	   				</div>
	               	   				<div class="sz-name">北京市海淀区 </div>
                  	   			</div> -->
                  	   			<select class="fl quinput w20"  style="margin-left:22px;"  id="sheng"   onchange="getShi(this.value)">
                  	   				<option value='qxz' >-请选择省-</option>
                  	   			</select> 
                  	   			<select class="fl quinput w20"  style="margin-left:22px;"  id="shi"   onchange="getQu(this.value)">
                  	   				<option value='qxz' >-请选择市-</option>
                  	   			</select>
                  	   			<select class="fl quinput w20"   style="margin-left:22px;" id="qu" onchange="getPwsC(this.value)">
                  	   				<option value='qxz' >-请选择区-</option>
                  	   			</select>
                  	   		</div>
	              		</div>
	              		<div class="tj-query">
                  	   		<span>电站：</span>
                  	   		<div id="psw" class="sz-area">
                  	   			<!-- <div>
                  	   				<div class="kuai">
	                  	   				<div class="sta5"></div>
	               	   				</div>
	               	   				<div class="sz-name">北京市海淀区 </div>
                  	   			</div>  -->
                  	   		</div>
	              		</div>
	              		<div class="tj-query">
                  	   		<span>已选电站：</span>
                  	   		<div  class="sz-area" id="pswcheck">
	               	   				
               	   					
                  	   		</div>
	              		</div>
              		</div>
              		<div class="w10 fr mt10" >
              			 <input class="tjfx-btn"  type="submit" onclick="return subTj();" value="对比">
              		</div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-ccc" id="gzsbs" style="display:none;">
	              <div   class="h300"> 
	                 	<h4 class="chart-title">故障设备数</h4>
	                  	 <div class="h250 w100 fl"   id="gzsbs-chart"></div>
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
	<script>
		var userId = "";
		$(function(){
			userId = $("#userId").val();
			//getPlan();
			getArea();
			$("#param").children().find(".kuai").click(function(){
				 if( $(this).find("div").hasClass("kuai2")){
					 $(this).find("div").removeClass("kuai2");
				 }else{
					 $(this).find("div").addClass("kuai2");
				 }
			 });
			
		})
		
		function changeTime(val){
			 $("#time").val('');
			 if(val == "1"){
				 $("#time").attr("onFocus","WdatePicker({dateFmt:'yyyy'})");
				 $("#time").attr("onclick","WdatePicker({dateFmt:'yyyy'})");
			 }else if(val == "2"){
				 $("#time").attr("onFocus","WdatePicker({dateFmt:'yyyy-MM'})");
				 $("#time").attr("onclick","WdatePicker({dateFmt:'yyyy-MM'})");
			 }else if(val == "3"){
				 $("#time").attr("onFocus","WdatePicker({dateFmt:'yyyy-MM-dd'})");
				 $("#time").attr("onclick","WdatePicker({dateFmt:'yyyy-MM-dd'})");
			 } 
		}
		
		function getArea(){
			var param  = "use_id="+userId;
			$.ajax({
		    	url:url+"getPwsStaInfoByUseId.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			useData = data.data;
		    			 if(data.data.length> 0){
		    				 var html = "<option value='qxz' >-请选择省-</option>";
	    					$.each(data.data,function(index,reg){
	    						html += "<option value="+reg.pro_id+">"+reg.pro_nam+"</option>"
	    					})
	    					$("#sheng").empty().append(html);
		    			 }
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		
		function getShi(reg_ide){
			var html = "<option value='qxz' >-请选择市-</option>";
			if("qxz" == reg_ide){
				$("#shi").empty().append(html);
				$("#qu").empty().append(html);
				$("#psw").empty();
				return ;
			}
			if(useData != null){
				$.each(useData,function(index,reg){
					if(reg.pro_id == reg_ide){
						$.each(reg.citLst,function(index,shi){
							html += "<option value="+shi.cit_id+">"+shi.cit_nam+"</option>"
						})
					}
				})
				$("#shi").empty().append(html);
			}
	}

	function getQu(reg_ide){
		var html = "<option value='qxz' >-请选择区-</option>";
		if("qxz" == reg_ide){
			$("#qu").empty().append(html);
			$("#psw").empty();
			return ;
		}
		if(useData != null){
			$.each(useData,function(index,reg){
				$.each(reg.citLst,function(index,shi){
					if(shi.cit_id == reg_ide){
						$.each(shi.areLst,function(index,qu){
							html += "<option value="+qu.are_id+">"+qu.are_nam+"</option>"
						})
					}
				})
			})
			$("#qu").empty().append(html);
		}
	}
	
	function getPwsC(quId){
		var htm = '';
		if("qxz" == quId){
			$("#psw").empty();
			return ;
		}
		if(useData != null){
			$.each(useData,function(index,reg){
				$.each(reg.citLst,function(index,shi){
					$.each(shi.areLst,function(index,qu){
						if(qu.are_id == quId){
							$.each(qu.pwsInfLst,function(index,lst){
								var clsCheck = '';
	    						 if($.inArray(lst.id+"", checkPsw) > -1){
	    							 clsCheck = 'kuai2';
	    						 }
	    						 var sty = ''
	    						 if(index != 0 && index != 3 && index%3 == 0){
	    							 sty = 'style="margin-left:75px;"' ;
	    						 }
	    						 htm +=  '<div class="area-box" '+sty+'>'+
	                  	   				'<div class="kuai">'+
		               	   				'<div class="sta5 '+clsCheck+'" id="psw_'+lst.id+'"  name="'+lst.pws_nam+'"></div>'+
		            	   				'</div>'+
		            	   				'<div class="sz-name">'+lst.pws_nam+'</div>'+
		           	   					'</div>';
							})
						}
					})
				})
			})
			$("#psw").html(htm);
			$("#psw").find(".area-box").find(".kuai").unbind('click').click(function(){
				 var  idt = $(this).find("div").attr("id");
				 var  name = $(this).find("div").attr("name");
				 if( $(this).find("div").hasClass("kuai2")){
					 var id = idt.split("psw_")[1];
					 delToCheck(id,name);
					 $(this).find("div").removeClass("kuai2");
				 }else{
					 $(this).find("div").addClass("kuai2");
					 var id = idt.split("psw_")[1];
					 addToCheck(id,name);
				 }
			 });
		}
	}
	
	
		/*查询出对比的站*/
		function getPws(p,cit,com){
			var param = "pro_id="+p+"&cit_id="+cit+"&com_id="+com;
			$.ajax({
		    	url:url+"getStaByPws.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			 $("#psw").empty();
		    			 if(data.data.length> 0){
		    				 var htm = "";
		    				 for(var i = 0 ; i < data.data.length ; i++){
	    						 var lst = data.data[i];
	    						 var clsCheck = '';
	    						 if($.inArray(lst.id+"", checkPsw) > -1){
	    							 clsCheck = 'kuai2';
	    						 }
	    						 htm +=  '<div class="area-box">'+
	                  	   				'<div class="kuai">'+
		               	   				'<div class="sta5 '+clsCheck+'" id="psw_'+lst.id+'"  name="'+lst.pws_nam+'"></div>'+
		            	   				'</div>'+
		            	   				'<div class="sz-name">'+lst.pws_nam+'</div>'+
		           	   					'</div>';
	    					 }
		    				 $("#psw").html(htm);
		    				 
		    				 $("#psw").find(".area-box").find(".kuai").unbind('click').click(function(){
		    					 var  idt = $(this).find("div").attr("id");
		    					 var  name = $(this).find("div").attr("name");
		    					 if( $(this).find("div").hasClass("kuai2")){
		    						 var id = idt.split("psw_")[1];
		    						 delToCheck(id,name);
			    					 $(this).find("div").removeClass("kuai2");
		    					 }else{
		    						 $(this).find("div").addClass("kuai2");
		    						 var id = idt.split("psw_")[1];
			    					 addToCheck(id,name);
		    					 }
		    				 });
		    				 
		    				 
		    			 }
		    				
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		
		var checkPsw = new Array();
		
		/*添加到已选电站*/
		function addToCheck(id,name){
			//判断是第几个
			var index = (checkPsw.length);
			var sty = ''
		 	if(index != 0 && index != 3 && index%3 == 0){
			  	sty = 'style="margin-left:75px;"' ;
		 	}
			if(name.length > 18){
				name = name.substring(0,15)+'...';
			}
			var h = '<div class="sz-name-check" '+sty+' ><em>'+name+'<i id="checkPsw_'+id+'" name="'+name+'">X</i></em></div>';
			$("#pswcheck").append(h);
			checkPsw.push(id);
			
			$("#pswcheck").find("em").find("i").unbind('click').click(function(){
				var idt = $(this).attr("id");
				var name = $(this).attr("name");
				var id = idt.split("checkPsw_")[1];
				delToCheck(id,name);
			});
		}
		
		/*删除已选电站*/
		function delToCheck(id,name){
			$("#checkPsw_"+id).parent().parent().remove();
			//删除之后循环已选站点，修改样式
			$("#pswcheck").find(".sz-name-check").each(function(index,ea){
			 	if(index != 0 && index != 3 && index%3 == 0){
				  	$(ea).css("margin-left","75px");
			 	}else{
			 		$(ea).css("margin-left","0");
			 	}
			})
			checkPsw.splice($.inArray(id+"", checkPsw), 1);
			if($("#psw_"+id).hasClass("kuai2")){
				$("#psw_"+id).removeClass("kuai2");
			};
		}
		
		
		 		
		var  colorList = [
                          '#EDB213','#35BEB5','#5FB0E3','#07CB47','#FE784E','#7A057A'
                         ];

		var xData = [];
		var gzsbsYDataSer = [];
	  	var legend = []; 

		function subTj() {
			var timeType = $("#timeType").val();
			var checkTime = $("#time").val();
			var checkType = [];
			$("#param").children().find(".kuai2").each(function() {
				var idTyp = $(this).attr("id");
				checkType.push(idTyp);
			});
			if (checkType.length < 1) {
				layer.alert("请选择对比参数");
				return;
			}

			if (checkPsw.length < 1) {
				layer.alert("请至少选择1个对比场站");
				return;
			}

			if (checkTime == "" || checkTime == undefined || checkTime == null) {
				layer.alert("请选择统计时间");
				return;
			}
			
			xData = [];
			gzsbsYDataSer = [];
			legend = [];
			
			var pswId = ''
			for (var i = 0; i < checkPsw.length; i++) {
				pswId += checkPsw[i]+'-';
			}
			pswId = pswId.substring(0,pswId.length-1);
			
			var par = "type=" + timeType + "&year=" + checkTime + "&id="
					+ pswId;
			
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url : url + "getSatInfoByStaId.htm",
				data : par,
				dataType : "json",
				async : false,
				type : "post",
				success : function(data) {
					layer.close(indexlayer);  //关闭 loading 
					if (data.resultcode == "USR000") {
						if (data.data.length > 0) {
							var  name1 = "";
							for (var i = 0; i < data.data.length; i++) {
								var lst = data.data[i];

								name1 = lst.pws_nam;
								if(name1.length > 18){
									name1 = name1.substring(0,5)+"..."+name1.substring(10,15)+"..."+name1.substring(name1.length-5,name1.length);
								}
								legend.push(name1);
								
								
								//加载echarts
								var gzsbsYData = [];

								for (var cc = 0; cc < lst.saInfLst.length; cc++) {
									var o = lst.saInfLst[cc];
									if(i == 0 ){
										if(o.tol_tim.indexOf("-")> -1){
											if(timeType == 1){
												var v = o.tol_tim.split("-")[1]+"月";
												xData.push(v);
											}else if(timeType == 2){
												var v = o.tol_tim.split("-")[2]+"日";
												xData.push(v);
											}
										}
									}
									//发电量
									if ($.inArray("type1", checkType) > -1) {
										gzsbsYData.push(getIsNull(o.fal_equ_num));
									} 
								}
								
								 
								//发电量
								if ($.inArray("type1", checkType) > -1) {
									gzsbsYDataSer.push({
										name : name1,
										type : 'bar',
										itemStyle : {
							                normal: {
							                    color : colorList[i]
							                }
										},
										data : gzsbsYData
									});
								}
							}
						}
						
					} else {
						layer.alert(data.desc);
					}
				}
			})

			//发电量
			if ($.inArray("type1", checkType) > -1) {
				$("#gzsbs").show();
				gzsbsSetChart();
			} else {
				$("#gzsbs").hide();
			}

		}

		function gzsbsSetChart() {
			var myChart = echarts.init(document.getElementById('gzsbs-chart'),
					'shine');
			var option = {
				tooltip : {
					trigger : 'axis',
					axisPointer : { // 坐标轴指示器，坐标轴触发有效
						type : 'show' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				legend: {
			        data:legend,
			        top: 10
			    },
			    grid : {
			    	left : '80',
					top : '60',
					right : '20',
					bottom : '20'
				},
				xAxis : {
					type : 'category',
					data : xData
				},
				yAxis : [
			         {
			             type : 'value',
			             name : '故障数(个)',
			             axisLabel : {
			                 formatter: '{value}'
			             }
			         }
			     ],
				series : gzsbsYDataSer
			};

			myChart.setOption(option);
		}
　
	</script>
</html>
