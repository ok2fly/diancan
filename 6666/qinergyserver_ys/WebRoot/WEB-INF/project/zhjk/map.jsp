<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>

<!doctype html>
<html>
<head> 
<meta charset="utf-8">
<title>综合监控</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<body class="bg-e9" >
	<input type="hidden" id="userId" value="${user.id}">	
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >	
    <div class="header">
		<div class="topnav">
			<!-- <input class="search bor-shadow bor-radius" type="text" placeholder="请输入关键字" />
			<i class="bor-shadow bor-radius"></i> -->
			 <div class="topnav-center bor-shadow bor-radius ml150" style="display:none;">
				<span>运维公司</span>
				<select class="nav-select"  id="companyOne" onchange="setCompanytwo(this.value);" >
					<option>请选择</option>
				</select>
			</div> 
			<div class="topnav-center bor-shadow bor-radius">
				<span>所属公司</span>
				<select class="nav-select" id="companyTwo" onchange="setCompanyThree(this.value);">
					<option>请选择</option>
				</select>
			</div>
			<div class="topnav-center bor-shadow bor-radius" >
				<span>子公司</span>
				<select class="nav-select" id="companyThree" onchange="setPws(this.value);">
					<option>请选择</option>
				</select>
			</div>
		</div>
	</div>
	<div class="header-right">
		<div class="topnav-right">
			 <a style = "width: 100%;height: 100%;display: block;" href="<%=basePath %>/commens/maplist.htm"></a>
			 <div class="checkarea-map checkarea bor-shadow bor-radius">
				<ul>
					<li style="border-bottom:1px solid #ccc;">
						<input type="checkbox" id="check-zd" checked="checked"> 电站
					</li>
					<li>
						<input type="checkbox" id="check-ry" checked="checked"> 人员
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="leftnav dz" style="display: none;">
		<div class="lefttop">
			<span class="tit" title="密云大厂光伏电站" id="pws_name">密云大厂光伏电站</span>
			<span class="subtit" >业主：<span id="pws_comName" title="启能光科公司">启能光科公司</span></span>
		</div>
		<div class="letsoso">
			<span class="img">
				 
			</span>
			<span  id="pws_add">位置： 密云北关环岛出口左侧电力局旁边的A口</span> 
			<span  id="pws_remark">简述： 独立运维独立运维独立运维独立运维独立运维独立运维独立运维独立运维独立运维独立运维独立运维独立运维</span> 
			<span  id="pws_state">状态： 正常 </span>
			<div class="det">
				<a class="detbut"  href="<%=basePath %>/commens/detail.htm" id="pws_detail">查看详情</a>
			</div>
		</div>
		<span class="openbut lf-zk" id="lf-openbut"></span>
	</div>
	<div class="leftnav per" style="display: none;" >
		<div class="lefttop">
			<span class="tit" id="per_name">张艺兴</span>
			<span class="subtit" id="star">
				<i class="active"></i>
				<i class="active"></i>
				<i class="active"></i>
				<i></i>
				<i></i>
			</span>
			<i class="head"></i>
		</div>
		<div class="letsoso">
			<span  id="per_posName" >职位：  总经理</span> 
			<span  id="per_comName" >公司： 启能光科公司</span> 
			<span  id="per_sex">性别： 男</span> 
			<span id="per_workYear" >工龄： 10年</span> 
		</div>
		<span class="openbut lf-zk" id="lf-openbut2"></span>
	</div>
	<div class="rightnav"  >
		 <div class="righttop">概况</div>
		 <div class="rightarea">
		 	<div class="bor-top">
		 		<div class="statname">电站数量(座)</div>
		 		<div class="statlist">
		 			<div class="h100 w50 fl" id="dzsl"></div>
		 			<div class="h100 w50 fl"  >
			 			<div  class="h100 mt10 fl mainright-smail" >
								<dl  class="rightdl">
									<dd  >
										<a class="i1"></a>
										<div class="ti" >
											  已投运
										</div>
										<div class="val" id="tysl">16座电站</div>
									</dd>
									<dd class=""  >
										<a class="i2"></a>
										<div class="ti" >
											  在建
										</div>
										<div class="val" id="zjsl">16座电站</div>
										</dd>
									<dd class=""   >
										<a class="i3" style='width:20px!important;'></a>
										<div class="ti"  >
											 计划
										</div>
										<div class="val" id="jhsl">16座电站</div>
									</dd>
								</dl>
							</div>
		 			</div>
		 		</div>
		 		<div class="statname">电站容量(MW)</div>
		 		<div class="statlist" >
	 				<div class="h100 w50 fl" id="dzrl"></div>
	 				<div class="h100 w50 fl"  >
	 					<div  class="h100 mt10 fl" >
								<dl class="rightdl">
									<dd class="" >
										<a class="i1"></a>
										<div class="ti" >
											  已投运
										</div>
										<div class="val" id="tyrl">260</div>
									</dd>
									<dd class="" >
										<a class="i2"></a>
										<div class="ti" >
											  在建
										</div>
										<div class="val" id="zjrl">260</div>
									</dd>
									<dd class=""  >
										<a class="i3" style='width: 20px!important;'></a>
										<div class="ti"  >
											 计划
										</div>
										<div class="val" id="jhrl">260</div>
									</dd>
								</dl>
							</div>
	 				</div>
		 		</div>
		 	</div>
		 	<div class="cler"> </div>
		 	<div class="bor-top">
		 		<div class="statname" style="float:left;border-bottom:0;height: 30px;line-height: 30px;padding: 6px 20px 0;">安全运行天数(天)</div><span class="statnum" id="aqyxts" style="float:left;padding-top: 6px;height: 30px;line-height: 30px;"></span>
		 		 
		 		<div class="statname" style="float:left;border-bottom:0;height: 40px;line-height: 40px;padding: 0 20px;">累计收益(元)</div><span class="statnum" id="ljsy" style="float:left;"></span>
		 		 
		 	</div>
		 	<div class="cler"> </div>
		 	<div class="bor-top">
		 		<div class="statname">光储充概况(MW)</div>
		 		<div class="statlist">
		 			<ul>
		 				<li>
		 					<i class="i1"></i>
		 					<span class="nam">光伏功率</span>
		 					<span class="va"  id="gfgl">2680</span>
		 				</li>
		 				<li>
		 					<i class="i2"></i>
		 					<span class="nam">储能功率</span>
		 					<span class="va"  id="cngl">2680</span>
		 				</li>
		 				<li>
		 					<i class="i3"></i>
		 					<span class="nam">充电功率</span>
		 					<span class="va"  id="cdgl">2680</span>
		 				</li>
		 			</ul>
		 		</div>
		 	</div>
		 	<div class="bor-top">
		 		<div class="statname">社会贡献</div>
		 		<div class="statlist">
		 			<ul>
		 				<li>
		 					<i class="i4"></i>
		 					<span class="nam">等效植树</span>
		 					<span class="va" id="dxzs">260棵</span>
		 				</li>
		 				<li>
		 					<i class="i5"></i>
		 					<span class="nam">二氧化碳</span>
		 					<span class="va" id="eyht">260吨</span>
		 				</li>
		 				<li>
		 					<i class="i6"></i>
		 					<span class="nam">节约标煤</span>
		 					<span class="va" id="jybm">260吨</span>
		 				</li>
		 			</ul>
		 		</div>
		 	</div>
		 </div>
		 <span class="openbut2 rg-zk" id="rg-openbut"></span>
	</div>  
	<div id="map" class="map" ></div>
</body>
	<script type="text/javascript" src="<%=basePath %>js/jquery.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath %>js/layer/layer.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath %>js/jsall.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath %>js/echarts.min.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4&ak=spS1jTrhDurkl3nOFkx5YcgMMfXbWalP"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/TextIconOverlay/1.2/src/TextIconOverlay_min.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/MarkerClusterer/1.2/src/MarkerClusterer_min.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath %>js/zhjkCheckCom.js?pubVersion=201802070001" ></script>
	<script>
	

	function bindMenuClickEvent(){
		$("#pws_detail").click(function(){
			var menuName = $("#pws_name").text();
			var menuHref = $(this).attr("href");
			if(menuHref !="#"){
				var TwoMenu =  '<a class="bottom-nav" href="'+menuHref+'"  target="main" id="twoLevel" style="padding-left: 0;max-width: 40%;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;" ><i style="font-style: normal;font-size: 14px;width: 10px;height: 38px;margin-right: 5px;padding-right: 0;background: url('+jumpPageUrl+'/images/jiantou.png) no-repeat;background-size: 7px 15px;margin-top: 2px;float: left;"></i><i class="bdf"></i>'+menuName+'</a>';
				$(parent.frames["bottom"].document).find("#nav-bot").append(TwoMenu);
			}
		})
	}
	
	$(function(){
		var userId = $("#userId").val();
	 
		
		//设置地图宽高
		var Screenheight  = (document.documentElement.clientHeight);  
		//设置地图高
		if(Screenheight > 660 ){
			$("#map").css("height",Screenheight);
		}else{
			$("#map").css("height",660);
		}
		
		map_init();
		
		showRight();
		
		getCompanyOne();
		
		bindMenuClickEvent();
		
		 
		$("#lf-openbut").click(function(){
			if($(this).hasClass("lf-zk"))
			{
				
				$(this).removeClass("lf-zk").addClass("lf-sh");
				$(".dz").addClass("w0");
				
			}else
			{
				$(this).addClass("lf-zk").removeClass("lf-sh");	
				$(".dz").removeClass("w0");
			}
		})
		
		$("#lf-openbut2").click(function(){
			if($(this).hasClass("lf-zk"))
			{
				
				$(this).removeClass("lf-zk").addClass("lf-sh");
				$(".per").addClass("w0");
				
			}else
			{
				$(this).addClass("lf-zk").removeClass("lf-sh");	
				$(".per").removeClass("w0");
			}
		})
		
		$("#rg-openbut").click(function(){
			if($(this).hasClass("rg-zk"))
			{
				
				$(this).removeClass("rg-zk").addClass("rg-sh");
				$(".rightnav").addClass("w0");
				
			}else
			{
				$(this).addClass("rg-zk").removeClass("rg-sh");	
				$(".rightnav").removeClass("w0");
			}
		}) 
		
		
		$("#check-zd").click(function(){
			//$(this).is(':checked')?$(".list-zd").show():$(".list-zd").hide();
			map_init();
		});
		
		$("#check-ry").click(function(){
			//$(this).is(':checked')?$(".list-person").show():$(".list-person").hide();
			map_init();
		});
	})
	
	//全局变量
	var longitude=116.3;
	var latitude=39.9;
	
	var lev = 8 ;
	function map_init(){
		if(markerArr.length == 1 ){
			longitude=markerArr[0].point.split(",")[0];
			latitude=markerArr[0].point.split(",")[1];
			
			lev = 10;
		}
		
		// 百度地图API功能
		var map = new BMap.Map("map");    // 创建Map实例
		map.centerAndZoom(new BMap.Point(longitude, latitude), lev);  // 初始化地图,设置中心点坐标和地图级别
		/* map.addControl(new BMap.MapTypeControl());   //添加地图类型控件 */
		map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
			
		
		//存放标注点经纬信息的数组
		var point = new Array(); 
		//存放提示信息窗口对象的数组
		info = new Array();
		//设置地图标注点 
		var marker = new Array(); 
		
		//人员的marker
		var markerP = new Array();
		
	 	//图标
		var myIcon = new BMap.Icon("<%=basePath %>images/person.png", new BMap.Size(40, 45));
		var myIcon1 = new BMap.Icon("<%=basePath %>images/zc111.png", new BMap.Size(25, 45));
		var myIcon2 = new BMap.Icon("<%=basePath %>images/gz111.png", new BMap.Size(25, 45));
		var myIcon3 = new BMap.Icon("<%=basePath %>images/wfz111.png", new BMap.Size(25, 45));
		
		/* var geoc = new BMap.Geocoder();    

		map.addEventListener("click", function(e){        
			var pt = e.point;
			geoc.getLocation(pt, function(rs){
				console.log(rs);
				var addComp = rs.addressComponents;
				console.log(addComp);
				alert( addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
			});        
		}); */
		
		for (var i = 0; i < markerArr.length; i++) {
				var p0 = markerArr[i].point.split(",")[0]; //
				var p1 = markerArr[i].point.split(",")[1]; //按照原数组的point格式将地图点坐标的经纬度分别提出来
				point[i] = new window.BMap.Point(p0, p1); //循环生成新的地图点
				if(markerArr[i].type == 1){
					if($("#check-zd").is(':checked')){
						var marCou = marker.length ;
						if(markerArr[i].state == 1){
							marker[marCou] = new window.BMap.Marker(point[i], {
							
									  icon : myIcon1
							});
						}else if(markerArr[i].state == 2){
							marker[marCou] = new window.BMap.Marker(point[i], {
									  icon : myIcon3
							});
						}else if(markerArr[i].state == 3){
							marker[marCou] = new window.BMap.Marker(point[i], {
									  icon : myIcon2
							});
						}
						
						//按照地图点坐标生成标记
						map.addOverlay(marker[marCou]);
						showInfo(marker[marCou],markerArr[i]);
						marker[marCou].setTop(true);
					}
				}else{
				  	if($("#check-ry").is(':checked')){
				  		var marpCou = markerP.length ;
				  		markerP[marpCou] = new window.BMap.Marker(point[i], {
									  icon : myIcon
						});
						//按照地图点坐标生成标记
						map.addOverlay(markerP[marpCou]);
						showInfo(markerP[marpCou],markerArr[i]);
					}  
				}
				
	 	}
		
		//最简单的用法，生成一个marker数组，然后调用markerClusterer类即可。
		var markerClusterer = new BMapLib.MarkerClusterer(map, {markers:marker});
		
		
		if(markerArr.length > 1 ){
			//让所有点在视野范围内
			map.setViewport(point);
		}
		
		
		
	}
	 
	
	
	 function showInfo(markerT,obj) {
		markerT.addEventListener("click",function() {
		
			if(obj.type == 1){
				 $("#pws_name").html(obj.name);
				 $("#pws_name").attr("title",obj.name);
				 $("#pws_comName").html(obj.comName);
				 $("#pws_comName").attr("title",obj.comName);
				 $("#pws_add").html("位置："+obj.pos);
				 $("#pws_remark").html("简述 ："+obj.remark);
				 var sta = obj.state == 1 ? "计划" :   obj.state == 2 ? "在建" : "投运" ;
				 $("#pws_state").html("状态："+sta);
				 var hrefv = obj.state == 1 ? "#" :   obj.state == 2 ? "#" : jumpPageUrl+"commens/detail.htm?id="+obj.id ;
				 $("#pws_detail").attr("href",hrefv);
				 
				 //加图片
				 var ht = '';
				 if(obj.picS.length > 0 ){
					 for(var i = 0 ; i < obj.picS.length ;i++){
						 var oo = obj.picS[i];
						 if(i < 2){
							 var stylec =  i == 0 ? "width : 50%;" : "width:50%";
							 ht += '<img src="'+oo.pic_url+'" style="'+stylec+'">';
						 }
					 }
				 }else{
					 ht = '<img src="'+jumpPageUrl+'img/gf1.png" style="width:50%"><img src="'+jumpPageUrl+'img/gf2.png" style="width:50%">';
				 }
				 
				 $(".img").html(ht);
				 $(".leftnav").hide();
				 $(".dz").show();
				 //判断是否隐藏掉了 ，如果是，则显示出来
				 if($("#lf-openbut").hasClass("lf-sh")){
					 $("#lf-openbut").click();
				 }
			}else if(obj.type == 2){
				 $("#per_name").html(obj.name);
				 $("#per_posName").html("职位 ："+obj.pos);
				 $("#per_comName").html("公司 ："+obj.comName);
				 var sex = obj.sex == 1 ? "男" : "女" ;
				 $("#per_sex").html("性别 ："+sex);
				 $("#per_workYear").html("工龄 ："+obj.workYear+"年");
				 
				 //加图片
				 if(obj.pic_url != '' && obj.pic_url != undefined ){
					 $(".head").css("background","url("+obj.pic_url+") no-repeat");
					 $(".head").css("background-size","70px 70px");
				 } 
				 
				 //加评分
				 if(obj.useScore != '' && obj.useScore != undefined){
					 if(obj.useScore > 0 && obj.useScore <= 100  ){
						$("#star").find("i").removeClass("active");
						var star =  (obj.useScore/20).toFixed(0);
						for(var i = 0 ; i < star ;i++){
							$("#star").find("i").eq(i).addClass("active");
						}
					 
						
					 }else{
						 $("#star").find("i").removeClass("active");
					 }
				 }
				 
				 $(".leftnav").hide();
				 $(".per").show();
				 //判断是否隐藏掉了 ，如果是，则显示出来
				 if($("#lf-openbut2").hasClass("lf-sh")){
					 $("#lf-openbut2").click();
				 }
			}
		});
	} 
	 

	/*function showInfo(obj){
		if(obj.type == 1){
			 $(".leftnav").hide();
			 $(".dz").show();
		}else if(obj.type == 2){
			 $(".leftnav").hide();
			 $(".per").show();
		}
	}*/
	
	function chart(serData,zsl){
		 
		var myChart5=echarts.init(document.getElementById('dzsl'),'shine');
		 var option5 = {
				 title: {
				        text: zsl,
				        x: 'center',
				        y: 'center',
				        itemGap: 15,
				        textStyle : {
				            color : 'rgba(0,0,0,0.8)', 
				            fontSize : 14 
				        },
				        subtextStyle : {
				        	 fontSize : 14 
				        }
				    },
		    series : [
		        {
		            name:'电站数量',
		            type:'pie',
		            radius : ['65%', '75%'],
		            itemStyle : {
		                normal : {
		                    label : {
		                        show : false
		                    },
		                    labelLine : {
		                        show : false
		                    }
		                } 
		            },
		            data: serData
		        }
		    ]
		};
		myChart5.setOption(option5);
		////////////////////////////////////////////////////////////
	}
	
	function chart1(serData,zrl){
		var myChart6=echarts.init(document.getElementById('dzrl'),'shine');
		 var option5 = {
			 title: {
			        text: zrl,
			        x: 'center',
			        y: 'center',
			        itemGap: 15,
			        textStyle : {
			            color : 'rgba(0,0,0,0.8)', 
			            fontSize : 14 
			        },
			        subtextStyle : {
			        	 fontSize : 14 
			        }
			    },
		    series : [
		        {
		            name:'电站容量',
		            type:'pie',
		            radius : ['65%', '75%'] ,
		            itemStyle : {
		                normal : {
		                    label : {
		                        show : false
		                    },
		                    labelLine : {
		                        show : false
		                    }
		                } 
		            },
		            data:serData
		        }
		    ]
		};
		myChart6.setOption(option5);
		////////////////////////////////////////////////////////////
	}
	</script> 
</html>
