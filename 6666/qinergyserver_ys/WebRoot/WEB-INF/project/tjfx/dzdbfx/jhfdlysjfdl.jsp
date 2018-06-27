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
		<title>计划发电量与实际发电量</title>
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
	</head>
	<body class="bgfc">
		<input type="hidden" id="userId" value="${user.id}" >
		<input type="hidden" id="use_typ" value="${user.use_typ}" >
		<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
		<div class="w100 fl mt15">
			 <div class="pl15 ml15 mr15">
	            <div class="pr8 mt10 ">
	              <div   class="h140 w100 bg-ff bor-ccc"  > 
	              	 <div class="w90 fl mt15">
	              	 	<div class="tj-query">
                  	   		<span>时间：</span>
                  	   		<div   class="sz-area">
                  	   			 <input type="text"  placeholder="请输入.."  id="time" class="fl  fx  Wdate" style="margin-left:22px;" onFocus="WdatePicker({dateFmt:'yyyy'})">
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
	              		<div class="tj-query">
                  	   		<span>电站：</span>
                  	   		<div  class="sz-area">
                  	   			  <select class="fl quinput w20"  id="companyPws" style="margin-left:22px;"  >
                  	   			 	<option value="qxz">请选择电站</option>
                  	   			 </select>
                  	   		</div>
	              		</div>
              		</div>
              		<div class="w10 fr mt10" >
              			 <input class="tjfx-btn"  type="submit" onclick="return subTj();" value="查询">
              		</div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-ccc" id="jhhsjfdl" style="display:none;">
	              <div   class="h300"> 
	                 	<h4 class="chart-title">计划与实际发电量</h4>
	                  	 <div class="h250 w100 fl" id="jhhsjfdl-chart" >
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
	<script type="text/javascript" src="<%=basePath%>js/checkCom.js?pubVersion=201802070001"></script>
	<script>
		var userId = "";
		$(function(){
			userId = $("#userId").val();
			//userId = 7;
			getCompanyOne();
			
		})
		

		function subTj() {
			var checkTime = $("#time").val();
		  
			var companyPws = $("#companyPws").val();
			
			if (checkTime == "" || checkTime == undefined || checkTime == null) {
				layer.alert("请选择统计时间");
				return;
			}
		 
			if (companyPws == "qxz" || companyPws == undefined || companyPws == null || companyPws == "") {
				layer.alert("请选择电站");
				return;
			}
			
			checkTime=checkTime+"-01-01";
			var param  = "year="+checkTime+"&id="+companyPws;
			
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			 
			$.ajax({
		    	url:url+"getPowerNew.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 if(data.data.length> 0){
		    				 $("#jhhsjfdl").show();
		    				 var xData = []; 
		    				 var ydata1 = [];
		    				 var ydata2 = [];
		    				 for(var i = 0 ; i < data.data.length ; i++){
		    					 var d  = data.data[i];
		    					 xData.push((getIsNull(d.staTim)).split("-")[1]+"月");
		    					 ydata1.push(getFixedNum5(d.plan_power/1000));
		    					 ydata2.push(getFixedNum5(d.real_power/1000));
		    				 }
		    				 var myChart = echarts.init(document.getElementById('jhhsjfdl-chart'),'shine');
				 			var option = {
				 				tooltip : {
				 					trigger : 'axis',
				 					axisPointer : { // 坐标轴指示器，坐标轴触发有效
				 						type : 'show' // 默认为直线，可选为：'line' | 'shadow'
				 					}
				 				},
				 			   grid : {
				 					left : '60',
				 					top : '40',
				 					right : '60',
				 					bottom : '30'
				 				},
				 				legend: {
				 			        data: ['计划发电量','实际发电量'],
				 			        top: 10,
				 			    },
				 				xAxis : {
				 					type : 'category',
				 					data : xData 
				 				},
				 				yAxis : [
			 				         {
			 				             type : 'value',
			 				             name : '电量(MWh)',
			 				             axisLabel : {
			 				                 formatter: '{value}'
			 				             }
			 				         }
			 				     ],
				 				series : [{
									name : "计划发电量",
									type : 'bar',
									data : ydata1,
									symbol : 'none',
									itemStyle : {
										normal : {
											color : '#EDB213'
										}
									}  
								},{
									name : "实际发电量",
									type : 'bar',
									data : ydata2,
									symbol : 'none',
									itemStyle : {
										normal : {
											color : '#35BEB5'
										}
									}  
								}]
				 			};
		
				 			myChart.setOption(option);
		    			 }else{
		    				 $("#jhhsjfdl").hide();
		    			 }
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
			
		}
 
	</script>
</html>
