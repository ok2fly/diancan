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
	              <div   class="h300 w100" > 
                  	  <h4 class="chart-title">25年预测(上网电量单位：MWh，收益单位：万元)</h4>
	                  <div class="fr mtf25">
	                  	  <input type="text"   placeholder="请输入.." id="zhxlTime" class="fl  tjfx-inp Wdate"   onFocus="WdatePicker({dateFmt:'yyyy',onpicked:get25Year})"> 
						  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return get25Year();"> -->
	                  </div>
                	  <div class="h200 w100 fl mt10"   >
                	  		<div class="tjfx-table2" style="overflow-x:scroll; "  >
								<table  width="100%" border="0" cellpadding="0" class="table-list" id="25year" >
									<tr>
										<th>类别</th>
										<th>指标</th>
										<th>2014</th>
										<th>2015</th>
										<th>2016</th>
										<th>2017</th>
									</tr>
									<tbody id="list-25yc">
										<tr>
											<td rowspan="2">理论电量</td>
											<td>上网电量</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>收益</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td rowspan="2">实际电量</td>
											<td>上网电量</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>收益</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td rowspan="2">预测电量</td>
											<td>上网电量</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>收益</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td rowspan="2">理论与实际差额电量</td>
											<td>上网电量</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>收益</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
                	  </div> 
                	  <div class="blank0"></div>
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
	              <div   class="h300"> 
	                 	<h4 class="chart-title">理论与实际上网电量</h4>
	                 	<div class="fr mtf25">
		                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" id="kyAndSjTime"  onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getKyAndSj})"> 
							  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getKyAndSj();"> -->
	                  	 </div>
	                  	 <div class="h250 w100 fl"   id="mrfdlzzt"></div>
	              </div>
	            </div>
	            <div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
	              <div  class="h200"> 
	                 	<h4 class="chart-title">预测下年上网电量(根据往年电量，单位：MWh)</h4>
	                 	<div class="fr mtf25">
		                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate"  id="ycNextTime"  onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getYcNext})"> 
							  <!-- <input class="tjfx-btn"  type="submit" value="查询"  onclick="return getYcNext();"> -->
	                  	 </div>
	                  	 <div class="h160 w100 fl mt10"   >
                	  		<div class="tjfx-table">
								<table  width="100%" border="0" cellpadding="0"  >
									<tr>
										<th>年</th>
										<th>全年</th>
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
									<tbody id="list-xn">
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
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
                	  </div> 
	              </div>
	            </div>
	             <div class="pl8 pr8 mt10 bg-ff  bor-radius tjfx-box">
	              <div  class="h200"> 
	                 	<h4 class="chart-title">预测下年上网电量(根据往年辐射量，单位：MWh)</h4>
	                 	<div class="fr mtf25">
		                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate" id="ycNextTime2"  onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getYcNext2})"> 
							  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getYcNext2();"> -->
	                  	 </div>
	                  	 <div class="h160 w100 fl mt10"   >
                	  		<div class="tjfx-table">
								<table  width="100%" border="0" cellpadding="0"  >
									<tr>
										<th>年</th>
										<th>全年</th>
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
									<tbody id="list-sn">
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
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
                	  </div> 
	              </div>
	            </div>
	             <div class="pl8 pr8 mt10 bg-ff  bor-radius mb50 tjfx-box">
	              <div  class="h200"> 
	                 	<h4 class="chart-title">计划上网电量(单位：MWh)</h4>
	                 	<div class="fr mtf25">
		                  	  <input type="text"   placeholder="请输入.." class="fl  tjfx-inp Wdate"  id="planTime" onFocus="WdatePicker({dateFmt:'yyyy',onpicked:getPlan})"> 
							  <!-- <input class="tjfx-btn"  type="submit" value="查询" onclick="return getPlan();"> -->
	                  	 </div>
	                  	 <div class="h160 w100 fl mt10"   >
                	  		<div class="tjfx-table"  >
								<table  width="100%" border="0" cellpadding="0"  >
									<tr>
										<th>年</th>
										<th>全年</th>
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
									<tbody id="list-swdl">
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

			//设置宽高
	   		var ScreenWidth  = (document.documentElement.clientWidth);  
	   		ScreenWidth = ScreenWidth;
	   		
	   		//设置地图高
	   		$(".wauto").css("width",ScreenWidth-20);
	   		var tab = $('.table-list');
	   		var td = $(tab.find('tr')[0]).find('th');
	   		if(td.length * 90 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
	   			tab[0].width = td.length *90;
	   		}
	   		

			var year=getDateYear();
			
			$("#zhxlTime").val(year);
			$("#kyAndSjTime").val(year);
			$("#ycNextTime").val(year);
			$("#ycNextTime2").val(year);
			$("#planTime").val(year);
	   		
			getCompanyOne();
			
		 
			
			$("#companyPws").on("change",function(){
				var pws_id = $("#companyPws").val();
				if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
					getTjfxData();
				}  
			})
		})
		
		
		function getTjfxData(){
			getPlan();
			get25Year();
			getKyAndSj();
			getYcNext();
			getYcNext2();
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
			
			var planTime = $("#planTime").val();
			if(planTime != '' && planTime != undefined){
				param += "&tim_point="+planTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getPlanElecAnalysis.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
	    				 var html1="";
   				  		 var html2="";
   				  		if(data.data.firstYear){
   				  		 var a=data.data.firstYear;
	   				  	 html1="<tr>"+
						 "<td>"+getIsNull(a.year)+"</td>"+
						 "<td>"+getFixedNum5(a.sum/1000)+"</td>"+
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
		    			if(data.data.sceondYear){
		    				var b=data.data.sceondYear;
		    				html2="<tr>"+
	    					 "<td>"+getIsNull(b.year)+"</td>"+
	    					 "<td>"+getFixedNum5(b.sum/1000)+"</td>"+
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
		    			if(data.data.thredYear){
		    				var c=data.data.thredYear;
		    				html3="<tr>"+
	    					 "<td>"+getIsNull(c.year)+"</td>"+
	    					 "<td>"+getFixedNum5(c.sum/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['1']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['2']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['3']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['4']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['5']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['6']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['7']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['8']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['9']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['10']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['11']/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c['12']/1000)+"</td>"+
	    					 "</tr>";
		    			}
		    			
		    			var htmls=html1+html2+html3;
		    			if(htmls!=""){
		    				$("#list-swdl").html(htmls);
		    			}
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		
		function get25Year(){
			 
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var zhxlTime = $("#zhxlTime").val();
			if(zhxlTime != '' && zhxlTime != undefined){
				param += "&tim_type="+4+"&tim_point="+zhxlTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getElecAnalysisBy25Year.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			var html = ''; //头
		    			var html1 = '';//理论电量
		    			var html2 = '';//理论收益
		    			var html3 = '';//实际电量
		    			var html4 = '';//实际收益
		    			var html5 = '';//预测电量
		    			var html6 = '';//预测收益
		    			var html7 = '';//差额电量
		    			var html8 = '';//差额收益
		    			
		    			 html +='<tr>'+
								'<th>类别</th>'+
								'<th>指标</th>';
						 html1 +='<tr>'+
									'<td rowspan="2">理论电量</td>'+
									'<td>上网电量</td>';
						html2 +='<tr>'+
									'<td>收益</td>';
						html3 +='<tr>'+
									'<td rowspan="2">实际电量</td>'+
									'<td>上网电量</td>';
						html4 +='<tr>'+
									'<td>收益</td>';
						html5 +='<tr>'+
									'<td rowspan="2">预测电量</td>'+
									'<td>上网电量</td>';
						html6 +='<tr>'+
									'<td>收益</td>';
						html7 +='<tr>'+
									'<td rowspan="2">理论与实际差额电量</td>'+
									'<td>上网电量</td>';
						html8 +='<tr>'+
									'<td>收益</td>';
		    			 for(var i = 0;i<data.data.length;i++){
		    				 var d = data.data[i];
		    				 if((d.tol_tim).split("-")[0]){
		    					 html +='<th>'+(d.tol_tim).split("-")[0]+'年</th>';
		    					 
		    					 if(d.fsb_cha === "" || d.fsb_cha === undefined || d.fsb_cha === null || d.fsb_cha === "undefined"){
		    						 html1 +='<td>'+getFixedNum5(d.fsb_cha)+'</td>';
		    					 }else{
			    					 html1 +='<td>'+getFixedNum5(getIsZero(d.fsb_cha)/1000)+'</td>';
		    					 }
		    					 
		    					 if(d.fsb_amo === "" || d.fsb_amo === undefined || d.fsb_amo === null || d.fsb_amo === "undefined"){
			    					 html2 +='<td>'+getFixedNum5(d.fsb_amo)+'</td>';
		    					 }else{
			    					 html2 +='<td>'+getFixedNum5(getIsZero(d.fsb_amo)/10000)+'</td>';
		    					 }
		    					 
		    					 if(d.int_cha === "" || d.int_cha === undefined || d.int_cha === null || d.int_cha === "undefined"){
			    					 html3 +='<td>'+getFixedNum5(d.int_cha)+'</td>';
		    					 }else{
			    					 html3 +='<td>'+getFixedNum5(getIsZero(d.int_cha)/1000)+'</td>';
		    					 }
		    					 
		    					 if(d.int_amo === "" || d.int_amo === undefined || d.int_amo === null || d.int_amo === "undefined"){
			    					 html4 +='<td>'+getFixedNum5(d.int_amo)+'</td>';
		    					 }else{
			    					 html4 +='<td>'+getFixedNum5(getIsZero(d.int_amo)/10000)+'</td>';
		    					 }
		    					 
		    					 if(d.fct_cha === "" || d.fct_cha === undefined || d.fct_cha === null || d.fct_cha === "undefined"){
			    					 html5 +='<td>'+getFixedNum5(d.fct_cha)+'</td>';
		    					 }else{
			    					 html5 +='<td>'+getFixedNum5(getIsZero(d.fct_cha)/1000)+'</td>';
		    					 }
		    					 
		    					 if(d.fct_amo === "" || d.fct_amo === undefined || d.fct_amo === null || d.fct_amo === "undefined"){
			    					 html6 +='<td>'+getFixedNum5(d.fct_amo)+'</td>';
		    					 }else{
			    					 html6 +='<td>'+getFixedNum5(getIsZero(d.fct_amo)/10000)+'</td>';
		    					 }
		    					 if((d.fsb_cha == "" 
		    							 || d.fsb_cha == undefined 
		    							 || d.fsb_cha == null 
		    							 || d.fsb_cha == "undefined" 
		    							 || d.fsb_cha == "null")
		    							 &&(d.int_cha == "" 
			    							 || d.int_cha == undefined 
			    							 || d.int_cha == null 
			    							 || d.int_cha == "undefined" 
			    							 || d.int_cha == "null")){
		    					 	html7 +='<td>'+"-"+'</td>';
		    					 }else if(d.fct_cha == "" 
	    							 || d.fsb_cha == undefined 
	    							 || d.fsb_cha == null 
	    							 || d.fsb_cha == "undefined" 
	    							 || d.fsb_cha == "null"){
		    						 
		    						 html7 +='<td>'+getFixedNum5(getIsZero(d.int_cha)/1000)+'</td>';
		    					 }else if(d.int_cha == "" 
	    							 || d.int_cha == undefined 
	    							 || d.int_cha == null 
	    							 || d.int_cha == "undefined" 
	    							 || d.int_cha == "null"){
		    						 
		    						 html7 +='<td>'+"-"+getFixedNum5(getIsZero(d.fsb_cha)/1000)+'</td>';
		    					 }else{
		    						 
			    					 html7 +='<td>'+getFixedNum5((getIsZero(d.int_cha)/1000)-(getIsZero(d.fsb_cha)/1000))+'</td>';
		    					 }
		    					 
		    					 
		    					 
		    					 if((d.fsb_amo == "" 
	    							 || d.fsb_amo == undefined 
	    							 || d.fsb_amo == null 
	    							 || d.fsb_amo == "undefined" 
	    							 || d.fsb_amo == "null")
	    							 &&(d.int_amo == "" 
		    							 || d.int_amo == undefined 
		    							 || d.int_amo == null 
		    							 || d.int_amo == "undefined" 
		    							 || d.int_amo == "null")){
		    						 html8 +='<td>'+"-"+'</td>';
		    					 }else if(d.fsb_amo == "" 
	    							 || d.fsb_amo == undefined 
	    							 || d.fsb_amo == null 
	    							 || d.fsb_amo == "undefined" 
	    							 || d.fsb_amo == "null"){
		    						 
		    						 html8 +='<td>'+getIsZero(d.int_amo/10000)+'</td>';
		    					 }else if(d.int_cha == "" 
	    							 || d.int_amo == undefined 
	    							 || d.int_amo == null 
	    							 || d.int_amo == "undefined" 
	    							 || d.int_amo == "null"){
		    						 
		    						 html8 +='<td>'+"-"+getFixedNum5(getIsZero(d.fsb_amo/10000))+'</td>';
		    					 }else{
		    						 
			    					 html8 +='<td>'+getFixedNum5(getIsZero(d.int_amo/10000)-getIsZero(d.fsb_amo/10000))+'</td>';
		    					 }
		    				 }
		    			 }
		    			 html +='</tr>';
    					 html1 +='</tr>';
    					 html2 +='</tr>';
    					 html3 +='</tr>';
    					 html4 +='</tr>';
    					 html5 +='</tr>';
    					 html6 +='</tr>';
    					 html7 +='</tr>';
    					 html8 +='</tr>';
    					 
    					 var h = html+html1+html2+html3+html4+html5+html6+html7+html8;
    					 $("#25year").empty().html(h);
    						//设置宽高
			   	    		var ScreenWidth  = (document.documentElement.clientWidth);  
			   	    		ScreenWidth = ScreenWidth;
			   	    		//设置地图高
			   	    		$(".wauto").css("width",ScreenWidth-20);
			   	    		var tab = $('.table-list');
			   	    		var td = $(tab.find('tr')[1]).find('td');
			   	    		if(td.length * 90 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
			   	    			tab[0].width = td.length *90;
			   	    		}
    					 /*  setChart(data.data); */
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		function setChart(data){
			var fsb_cha=[];
			var int_cha=[];
			var x=[];
			for(var i=0;i<data.length;i++){
				var a=data[i];
				if((a.tol_tim).split("-")[0]){
					x.push((a.tol_tim).split("-")[0]);
					fsb_cha.push(getFixedNum5(a.fsb_cha/1000));
					int_cha.push(getFixedNum5(a.int_cha/1000));
				}
				
			}
			var myChart = echarts.init(document.getElementById('mrfdlzzt'),'shine');
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
				        data: ['理论电量','实际电量'],
				        top: 10,
				    },
				    xAxis:  {
				        type: 'category',
				        data: x 
				    },
				    yAxis: {
							type : 'value',
							name : '电量(MWh)',
							axisLabel : {
							formatter : '{value}'
							}
				    },
				    series: 
				    	 [ {
				 			name : '理论电量',
				 			type : 'bar',
				 			smooth : true,
				 			data : fsb_cha,
							symbol : 'none',
							itemStyle : {
								normal : {
									color : '#5FB0E3'
								}
							}  
				 		}, {
				 			name : '实际电量',
				 			type : 'bar',
				 			smooth : true,
				 			data : int_cha,
							itemStyle : {
								normal : {
									color : '#EDB213'
								}
							}  
				 		}

				 		]
				    
				};
		                    
				
				myChart.setOption(option);
		}
		
		
		function getKyAndSj(){
			 
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var kyAndSjTime = $("#kyAndSjTime").val();
			if(kyAndSjTime != '' && kyAndSjTime != undefined){
				param += "&tim_type="+4+"&tim_point="+kyAndSjTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			 var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getElecAnalysisBy25Year.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 
		    			 if(data.data.length> 0){
		    				 setChart(data.data);
		    			 }
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		
		
		function getYcNext(){
			 
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var ycNextTime = $("#ycNextTime").val();
			if(ycNextTime != '' && ycNextTime != undefined){
				param += "&tim_point="+ycNextTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getForeElecAnalysisByElec.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 var html1="";
		    			 var html2="";
		    			 var html3="";
		    			 if(data.data.firstYear){
		    				 var a=data.data.firstYear;
		    				 html1="<tr>"+
	    					 '<td>'+getIsNull(a.year)+'</td>'+
	    					
	    					 "<td>"+getFixedNum5(a.sum_fct_value/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value1/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value2/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value3/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value4/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value5/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value6/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value7/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value8/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value9/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value10/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value11/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value12/1000)+"</td>"+
	    					 "</tr>";
		    			 }
		    			 if(data.data.sceondYear){
		    				 var b=data.data.sceondYear;
		    				 html2="<tr>"+
	    					 '<td>'+getIsNull(b.year)+'</td>'+
	    					 "<td>"+getFixedNum5(b.sum_fct_value/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value1/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value2/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value3/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value4/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value5/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value6/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value7/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value8/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value9/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value10/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value11/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value12/1000)+"</td>"+
	    					 "</tr>";
		    			 }
		    			 if(data.data.thredYear){
		    				 var c=data.data.thredYear;
		    				 html3="<tr>"+
	    					 '<td>'+getIsNull(c.year)+'</td>'+
	    					 "<td>"+getFixedNum5(c.sum_fct_value/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value1/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value2/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value3/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value4/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value5/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value6/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value7/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value8/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value9/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value10/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value11/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value12/1000)+"</td>"+
	    					 "</tr>";
		    			 }
		    			
		    			var htmls=html1+html2+html3;
		    			if(htmls!=""){
		    				$("#list-xn").html(htmls);
		    			}
		    			
		    			
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		 
		function getYcNext2(){
			 
			var param  = "";
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				param  += "pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var ycNextTime = $("#ycNextTime2").val();
			if(ycNextTime != '' && ycNextTime != undefined){
				param += "&tim_point="+ycNextTime;
			}else{
				layer.alert("请选择时间");
				return;
			}
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
		    	url:url+"getForeElecAnalysisByHv.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    		
	    				 var html1="";
		    			 var html2="";
		    			 var html3="";
		    			 if(data.data.firstYear){
		    				 var a=data.data.firstYear;
		    				 html1="<tr>"+
		    				 '<td>'+getIsNull(a.year)+'</td>'+
	    					 "<td>"+getFixedNum5(a.sum_fct_value/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value1/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value2/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value3/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value4/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value5/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value6/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value7/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value8/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value9/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value10/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value11/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(a.fct_value12/1000)+"</td>"+
	    					 "</tr>";
		    			 }
		    			 if(data.data.sceondYear){
		    				 var b=data.data.sceondYear;
		    				 html2="<tr>"+
		    				 '<td>'+getIsNull(b.year)+'</td>'+
	    					 "<td>"+getFixedNum5(b.sum_fct_value/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value1/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value2/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value3/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value4/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value5/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value6/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value7/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value8/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value9/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value10/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value11/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(b.fct_value12/1000)+"</td>"+
	    					 "</tr>";
		    			 }
		    			 
		    			 if(data.data.thredYear){
		    				 var c=data.data.thredYear;
		    				 html3="<tr>"+
		    				 '<td>'+getIsNull(c.year)+'</td>'+
	    					 "<td>"+getFixedNum5(c.sum_fct_value/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value1/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value2/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value3/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value4/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value5/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value6/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value7/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value8/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value9/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value10/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value11/1000)+"</td>"+
	    					 "<td>"+getFixedNum5(c.fct_value12/1000)+"</td>"+
	    					 "</tr>";
		    			 }
		    			
		    			var htmls=html1+html2+html3;
		    			if(htmls!=""){
		    				$("#list-sn").html(htmls);
		    			}
				    			
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		}
		 
	</script>
</html>
