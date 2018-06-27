<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">  
		<meta name="renderer" content="webkit">  
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/main.css?pubVersion=201802070001" />
		<style>
			body{
				/* filter:alpha(opacity=100 finishopacity=50 style=1 startx=0,starty=0,finishx=0,finishy=150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=red,endcolorstr=blue,gradientType=0);	
			    -ms-filter:alpha(opacity=100 finishopacity=50 style=1 startx=0,starty=0,finishx=0,finishy=150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=red,endcolorstr=blue,gradientType=0);	
				background:#164A57;  一些不支持背景渐变的浏览器   
			    background:-moz-linear-gradient(top, #164A57, rgba(45, 59, 96, 0.5));  
			    background:-webkit-gradient(linear, 0 0, 0 bottom, from(#0E121E), to(rgba(45, 59, 96, 0.5)));
			    margin: 0;
			    padding: 0;
			    min-height: 100vh;
			    background-size: cover; */
			    
			    background-image: url("../images/index.png");
			    background-attachment: fixed;
				background-repeat: no-repeat;
				background-size: cover;
			}	 
		</style>
	</head>
	<body  >
		<input type="hidden" id="ro_id" value="${user.rol_id}" >
		<input type="hidden" id="userId" value="${user.id}" >
		<input type="hidden" id="comId" value="${user.com_id}" >
		<input type="hidden" id="use_typ" value="${user.use_typ}" >
		<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
		<div class="header">
			<a href="#" target="_self" class="logo" title="">
				<img id="compLogo"  style="max-width: 175px;max-height: 55px; margin-left: 80px;margin-top: 20px;">
			</a>  
			<a  href="#" target="_self" class="system-name">请输入平台名称</a>	
			<div class="headrigh-sys"> 
				 <span>${user.com_nam } | ${user.rol_nam } | ${user.acc_num }   </span>
			</div>

			<div class="headrigh">  
			</div>
			<div class="test"></div>
			<div class="head-menu">
				<ul>
				 	<li><a  href='javascript:void(0);' onclick="updPas()" >修改密码</a> </li>
				 	<li><a href="javascript:void(0);" onclick="return exitUse();">注销</a></li>

				 </ul>
			</div>
			 
		</div>
		<div class="main">
				<div class="mainleft">
					<div class="main-menu" style="padding-left: 10%;">
						<%-- <ul class="main-item">
							<li class="bd1"><a href="<%=basePath %>commens/ywgl/main.htm">运维管理</a><i></i></li>
							<li class="bd2"><a href="<%=basePath %>commens/tjfx/main.htm">统计分析</a><i></i></li>
							<li class="bd3"><a href="<%=basePath %>commens/xtgl/main.htm">系统配置</a><i></i></li>
							<li class="bd4"><a href="<%=basePath %>commens/rygl/main.htm">人员管理</a><i></i></li>
						</ul>
						<ul class="main-item">
							<li class="hei bd5"><a href="<%=basePath %>commens/map.htm">综合监控</a><i></i></li>
							<li class="bd6"><a href="<%=basePath %>commens/jhgl/main.htm">计划管理</a><i></i></li>
							<li class="bd7"><a href="<%=basePath %>commens/xtgl/main.htm">系统管理</a><i></i></li>
						</ul>
						<ul class="main-item">
							<li class="bd8"><a href="<%=basePath %>commens/aqgl/main.htm">安全管理</a><i></i></li>
							<li class="wid bd9"><a href="<%=basePath %>commens/zsk/main.htm">知识库</a><i></i></li>
							<li class="wid1 bd10"><a href="<%=basePath %>commens/rcbg/main.htm">日常办公</a><i></i></li>
						</ul> --%>
					</div>	
				</div>
				<div class="mainright">
					<ul style="float:right;padding-right: 15%;">
						<li class="bd2"><a class="fl">电站概况</a>
							<div class="h190 mt10 fl mt15" style="width:220px;" id="dzsl">
							</div>
							<div  class="h190 mt10 fl mainright-smail" style="width:211px;margin-left: 25px;">
								<ul>
									<li class="" style="border:1px solid #E86B8D;">
										<div class="ti" style="background:#E86B8D;">
											 已投运
										</div>
										<div class="val" id="tyrl">260mw</div>
										<div class="val" id="tysl">16个电站</div>
									</li>
									<li class="" style="border:1px solid #F1AC45;" >
										<div class="ti" style="background:#F1AC45;border:1px solid #F1AC45;">
											 在建
										</div>
										<div class="val" id="zjrl">260mw</div>
										<div class="val" id="zjsl">16个电站</div>
										</li>
									<li class="" style="border:1px solid #35AA3A;"  >
										<div class="ti" style="background:#35AA3A;border:1px solid #35AA3A;">
											 计划
										</div>
										<div class="val" id="jhrl">260mw</div>
										<div class="val" id="jhsl">16个电站</div>
									</li>
								</ul>
							</div>
						</li>
						<li class="bd1"><a>运维概况</a>
							<div class="h190 mt10" >
								<div class="w60 fl">
									<div class="main-bar">
										<span class="color-bl">缺陷数</span>
										<div class="bar">
											<div class="bar1"></div>
										</div>
										<span id="qxs">0</span>
									</div>
									<div class="main-bar" >
										<span class="color-bl">消缺数</span>
										<div class="bar" >
											<div class="bar2"></div>
										</div>
										<span id="xqs">0</span>
									</div>
									<div class="main-bar mt30" >
										<span class="color-bl">消缺率</span>
										<div class="barT" style="width:50%;" >
											<div class="bar2" id="xqlbar">
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
												<div class="barItem"  ></div>
											</div>
										</div>
										<span class="bat"  id="xql" >60</span>%
									</div>
								</div>
								<div class="w40 fl">
									<div class="main-barrig">
										<span class="color-bl">设备健康状态</span>
										<span id="sbjkzt">良好</span>
										<span  class="color-bl">设备健康率</span>
										<span id="sbjkl">80%</span>
									</div>
								</div>
							</div>
						</li>  
					</ul>
				</div>
		</div>
		 <!-- <div class="winmenu" >
			<ul>
				<li class="menuli"><i></i><a >系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
				<li class="menuli"><i></i><a>系统管理</a></li>
			</ul>
		
		</div>  -->
		<!-- <div class="winbox" style="overflow:auto" >
			<div class="pl8 pr8 pb18">
			 <h3>告警列表 <div class="fr qxgj" >X</div></h3>
			
			 <div class="gj_info">
			 		<div class="h20 pl8 pr8 pt8">
			 			<div class="fl"><a href="http://localhost:8080/qinergyserver/commens/zhjk/main.htm?app_typ_id=1&pws_id=9&typ_ide=CNNBQ&equNum=A1234321&id=9&goJumpType=2" target="main">equ_012453</a></div>
			 			<div class="fr">告警码</div>
			 		</div>
			 		<div class="h20 pr8">
			 			<div class="fr">2017-10-12</div>
			 		</div>
			 </div>
			 <div class="gj_info">
			 		<div class="h20 pl8 pr8 pt8">
			 			<div class="fl">equ_012453</div>
			 			<div class="fr">告警码</div>
			 		</div>
			 		<div class="h20 pr8">
			 			<div class="fr">2017-10-12</div>
			 		</div>
			 </div>
			 <div class="gj_info">
			 		<div class="h20 pl8 pr8 pt8">
			 			<div class="fl">equ_012453</div>
			 			<div class="fr">告警码</div>
			 		</div>
			 		<div class="h20 pr8">
			 			<div class="fr">2017-10-12</div>
			 		</div>
			 </div>
			 <div class="gj_info">
			 		<div class="h20 pl8 pr8 pt8">
			 			<div class="fl">equ_012453</div>
			 			<div class="fr">告警码</div>
			 		</div>
			 		<div class="h20 pr8">
			 			<div class="fr">2017-10-12</div>
			 		</div>
			 </div>
			 <div class="gj_info">
			 		<div class="h20 pl8 pr8 pt8">
			 			<div class="fl">equ_012453</div>
			 			<div class="fr">告警码</div>
			 		</div>
			 		<div class="h20 pr8">
			 			<div class="fr">2017-10-12</div>
			 		</div>
			 </div>
			 <div class="gj_info">
			 		<div class="h20 pl8 pr8 pt8">
			 			<div class="fl">equ_012453</div>
			 			<div class="fr">告警码</div>
			 		</div>
			 		<div class="h20 pr8">
			 			<div class="fr">2017-10-12</div>
			 		</div>
			 </div>
			 <div class="gj_info">
			 		<div class="h20 pl8 pr8 pt8">
			 			<div class="fl">equ_012453</div>
			 			<div class="fr">告警码</div>
			 		</div>
			 		<div class="h20 pr8">
			 			<div class="fr">2017-10-12</div>
			 		</div>
			 </div>
			 <div class="gj_info">
			 		<div class="h20 pl8 pr8 pt8">
			 			<div class="fl">equ_012453</div>
			 			<div class="fr">告警码</div>
			 		</div>
			 		<div class="h20 pr8">
			 			<div class="fr">2017-10-12</div>
			 		</div>
			 </div>
		  </div>
		</div>   -->
		<div class="clr"></div>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js?pubVersion=201802070001" ></script>
		<script type="text/javascript" src="<%=basePath %>js/jsall.js?pubVersion=201802070001" ></script>
		<script type="text/javascript" src="<%=basePath %>js/layer/layer.js?pubVersion=201802070001" ></script>
		<script type="text/javascript" src="<%=basePath %>js/echarts.min.js?pubVersion=201802070001" ></script>
		<script>
		$(function(){
			$(parent.frames["bottom"].document).find("#nav-bot").html("");
			
			/* //设置宽高
			var Screenheight  = (document.documentElement.clientHeight);  
			
			//设置地图高
			$(".main").css("height",Screenheight-115); */
			
			$(".headrigh").on("click",function(){
				$(".head-menu").toggle(500);
				$(".test").toggle(500);
			})
			
			var ro_id = $("#ro_id").val();
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url:url+"getUserAuthorityPC.htm",
				data : "role_id="+ro_id,
				success: function(datas){
					if (datas.data.length > 0 ) {
						var cou = 0 ;
						var html = "";
						for (var i=0;i<datas.data.length ;i++) {
							var one = datas.data[i];
							if(cou%4  == 0){
								cou = 0 ;
								html += "<ul class='main-item'>";
							}
							var h = ""
							var clr ="";
							if(i == 4 ){
								h  = "hei";
								cou = cou + 2 ;
							}else if(i == 8 ){
								h  = "wid";
								cou = cou + 0.5 ;
							}else if(i == 9){
								h  = "wid1";
								cou = cou + 0.5 ;
							}else if(i == 10 ){
								h  = "wid";
								cou = cou + 0.5 ;
							}else if(i == 11){
								h  = "wid1";
								cou = cou + 0.5 ;
							}else if(i == 12){
								h  = "wid";
								cou = cou + 1 ;
							}else{
								cou++;
							}
							if(i == 10 ){
								clr  = "cler";
							}
							if(i == 12 ){
								clr  = "cler";
							}
							//<li class="hbd1 clr" onclick="window.open('jumpPageUrl+one.module_url');"><a>
							//html += '<li class="'+h+" bd"+(i+1)+" "+clr+'"'+ "onclick="+'"'+"window.location.href='"+jumpPageUrl+one.module_url+"';"+'"><a>'+one.module_name+"</a><i></i></li>";
							//html += "<li class='"+h+" bd"+(i+1)+"  "+clr+"'><a href='"+jumpPageUrl+one.module_url+"'>"+one.module_name+"</a><i></i></li>";
							var typ = ''
							if(i == 10 || i == 11 || i == 12){
								typ = '2';
							}
							if(one.is_dsp == "1"){
								html += "<li class='"+h+" bd"+(i+1)+" "+clr+"'  typ='"+typ+"'  data-href='"+jumpPageUrl+one.module_url+"' onclick='tiaoZhuan(this)' style='cursor: pointer;'><a href='javascript:void(0);'>"+one.module_name+"</a><i></i></li>";
							}else if(one.is_dsp == "0"){
								html += "<li class='"+h+" bd"+(i+1)+" "+clr+"'   data-href='"+jumpPageUrl+one.module_url+"' style='background:#8e8e8e;'  ><a href='javascript:void(0);' style='cursor: default;'>"+one.module_name+"</a><i></i></li>";
							}
							if(i == 12){
								html += "<li class='wid1 bd14'   ><a href='javascript:void(0);' style='cursor: default;'>更多</a><i></i></li>";
							}
							if(cou >=  4){
								html += "</ul>";
								cou = 0 ;
							}
						} 
						layer.close(indexlayer);  //关闭 loading 
					}
					$(".main-menu").append(html);
					
					//bindMenuClickEvent();
				},
				error : function(){
					layer.close(indexlayer);  //关闭 loading 
				}
			}); 
			
			getCompLog();
			getDzData();
			getYwData();
			
		})
		
		function getCompLog(){
			var  comId = $("#comId").val();
			$.ajax({
				url:url+"getComLogoImgById.htm",
				data : "id="+comId,
				success: function(datas){
					if (datas.data.length > 0 ) {
						var d = datas.data[0];
						var imgSrc = d.com_pic_thum;
						$("#compLogo").attr("src",imgSrc);
						$(".system-name").html(d.com_pjt_nam);
					}
				},
				error : function(){
					
				}
			}); 
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
			 
			function chart(serData,zrl,zsl){
				//zrl = "100239.21";
				if(zrl && zrl.indexOf(".") > -1){
					if(zrl.split(".")[0].length > 3){
						zrl =  zrl.split(".")[0];
					}
				}
				
				var myChart5=echarts.init(document.getElementById('dzsl'),'shine');
				
				 var option5 = {
					 title: {
					        text: zrl,
					        subtext:'MW',
					        x: 'center',
					        y: '70',
					        itemGap: 10,
					        textStyle : {
					            color : 'rgba(255,255,255,0.8)',
					            fontFamily : '微软雅黑',
					            fontSize : 24,
					            fontWeight : 'bolder'
					        },
					        subtextStyle : {
					        	 fontSize : 14 
					        }
					    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    grid: {
				    	left : '30',
						top : '0',
						right : '10',
						bottom : '0'
			        },
				    calculable : true,
				    series : [
				        {
				            name:'电站数量',
				            type:'pie',
				            radius : ['50%', '60%'],
				            data:serData
				        }
				    ]
				};
				myChart5.setOption(option5);
				////////////////////////////////////////////////////////////
			}
			
			function tiaoZhuan(a){
				var menuName = $(a).find("a").text();
				var menuHref = $(a).attr("data-href");
				if(menuName  === "综合监控" ){
					var oneMenu =  '<a class="bottom-nav" href="'+menuHref+'"  target="main" id="oneLevel" ><i class="bdf"></i>'+menuName+'</a>';
					$(parent.frames["bottom"].document).find("#nav-bot").append(oneMenu);
				}
				if($(a).attr("typ") && $(a).attr("typ") == "2" ){
					window.open(menuHref) ; 
				}else{
					window.location.href = menuHref ; 
				}
				
			}
			
			/* function bindMenuClickEvent(){
				$(".main-item").find("li").find("a").click(function(){
					var menuName = $(this).text();
					var menuHref = $(this).attr("href");
					if(menuName === "综合监控"){
						var oneMenu =  '<a class="bottom-nav" href="'+menuHref+'"  target="main" id="oneLevel" ><i class="bdf"></i>'+menuName+'</a>';
						$(parent.frames["bottom"].document).find("#nav-bot").append(oneMenu);
					}
				})
			}
			 */
			
			function exitUse(){
				layer.confirm("确定注销账号？",function(){
					top.location.href = url + "exitLogin.htm";
				})
			}
			
			 function updPas(){
				 var userId  = $("#userId").val();
				 layer.open({
					  type: 2,
					  skin: 'layer-class' ,
					  title:"修改密码",
					  shadeClose: false,
					  area: ["300px","280px"],
					  content: "<%=basePath%>commens/resetPwd.htm?id="+userId 
				});
			 }
			function getDzData(){
				var userId = $("#userId").val();
				var param  = "use_id="+userId;
				$.ajax({
			    	url:url+"getIntMonLeftSide.htm",
			    	data : param,
			    	dataType:"json",
			    	type:"post",
			    	success:function(data){
			    		if (data.resultcode=="USR000") {
			    			 if(data.data.length > 0 ){
			    				 var d  = data.data[0];
			    				 var serData = [];
			    				 serData.push({
			    					 value:d.pwsOptCou, 
			    					 name:'已投运',
			    					 itemStyle : placeHolderStyle 
			    				 });
			    				 serData.push({
			    					 value:d.pwsConCou, 
			    					 name:'在建',
			    					 itemStyle : placeHolderStyle1
			    				 });
			    				 serData.push({
			    					 value:d.pwsPlaCou, 
			    					 name:'计划',
			    					 itemStyle : placeHolderStyle2 
			    				 });
			    				 
			    				 
			    				 
			    				 $("#tyrl").html(getFixedNum5(d.pwsOptCap/1000)+"MW");
			    				 $("#tysl").html(d.pwsOptCou+"个电站");
			    				 $("#zjrl").html(getFixedNum5(d.pwsConCap/1000)+"MW");
			    				 $("#zjsl").html(d.pwsConCou+"个电站");
			    				 $("#jhrl").html(getFixedNum5(d.pwsPlaCap/1000)+"MW");
			    				 $("#jhsl").html(d.pwsPlaCou+"个电站");
			    				 
			    				 var zrl = getFixedNum5(((d.pwsOptCap)+(d.pwsConCap)+(d.pwsPlaCap))/1000);
			    				 var zsl = (d.pwsOptCou)+(d.pwsConCou)+(d.pwsPlaCou);
			    				 chart(serData,zrl,zsl);
			    				 
			    			 } 
			    			 
						} else {
			               layer.alert(data.desc);
						}
			    	}
			    })
			}
			
			function getYwData(){
				var userId = $("#userId").val();
				var param  = "use_id="+userId;
				$.ajax({
			    	url:url+"getFstPagOptInf.htm",
			    	data : param,
			    	dataType:"json",
			    	type:"post",
			    	success:function(data){
			    		if (data.resultcode=="USR000") {
			    			 if(data.data  ){
			    				 var d  = data.data;
			    			 	$("#qxs").html(d.defCou);
			    			 	$("#xqs").html(d.elmDefCou);
			    			 	$("#xql").html(toDecimal(d.elmDefRate*100));
			    			 	
			    			 	var  w1 = 0;
			    			 	if(d.defCou == 0){
			    			 		w1 = 1;
			    			 	}else{
			    			 		w1 = d.defCou;
			    			 	}
			   
			    			 	$(".bar1").css("width",w1+"%");
			    			 	
			    			 	/* var  w2 = 0;
			    			 	if(d.elmDefCou == 0){
			    			 		w2 = 1;
			    			 	}else{
			    			 		w2 = d.elmDefCou;
			    			 	}
			   
			    			 	$(".bar2").css("width",w2+"%"); */
			    			 
			    			 	var  w3 = 0;
			    			 	
			    			 	if(d.elmDefRate*100 == 0){
			    			 		w3 = 1;
			    			 	}else{
			    			 		w3 = d.elmDefRate*100;
			    			 	}
			    			 	//w3 = 90;
			    			 	$("#xqlbar").css("width",toDecimal(w3)+"%");
			    			 	
			    			 	$(".bar2").css("width",toDecimal(w3)+"%");
			    			 } 
			    			 
						} else {
			               layer.alert(data.desc);
						}
			    	}
			    })
			    
			    $.ajax({
			    	url:url+"getEquHealthScor.htm",
			    	data : param,
			    	dataType:"json",
			    	type:"post",
			    	success:function(data){
			    		if (data.resultcode=="USR000") {
			    			 if(data.data  ){
			    			 	var d = data.data[0];
			    			 	if(d.equHealthRate){
			    			 		$("#sbjkzt").html(d.equHealthSta);
			    			 	}
			    			 	
								if(d.equHealthSta){
			    			 		$("#sbjkl").html(getFixedNum(d.equHealthRate*100)+"%");
			    			 	}
			    			 	 
							 } else {
				               layer.alert(data.desc);
							 }
			    		}
			    	}
			    })
			    
			}
	    
		</script>
	</body>
</html>
