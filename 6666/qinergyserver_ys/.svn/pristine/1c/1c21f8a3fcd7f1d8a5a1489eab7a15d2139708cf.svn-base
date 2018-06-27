<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath%>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath%>css/menu.css?pubVersion=201802070001" />
		<style>
</style>
	</head>
	<body>
		<input type="hidden" id="app_typ_id" value="${app_typ_id}">
		<input type="hidden" id="pws_id" value="${pws_id}">
		<input type="hidden" id="typ_ide" value="${typ_ide}">
		<input type="hidden" id="goJumpType" value="${goJumpType}">
		<input type="hidden" id="id" value="${id}">
		<input type="hidden" id="equNum" value="${equNum}">
		<div class="leftnav" >
			<div class="twoleftnav">
				<dl id="menu">
					<%-- <c:forEach items="${menu }" var="m" varStatus="status">
							<c:choose>
							<c:when test = "${status.index == 0}">
								<dd class="active">
							</c:when>
							<c:otherwise>
								<dd >
							</c:otherwise>
							</c:choose>
								<span class="parent_">
									<!-- 为了点击时，显示第一个子节点菜单 -->
									<a href="<%=basePath%>${m.module_url }?pws_id=${pws_id}" target="right">${m.module_name }</a>
									<i class="active"></i>
								</span>
							</dd>
					</c:forEach> --%>
				</dl>
			</div>
		</div>
	</body>
	<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
	<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
	<script>
	var paramUrl = "";
	$(function(){
		var pws_id = $("#pws_id").val();
		var typ_ide = $("#typ_ide").val();
		var app_typ_id = $("#app_typ_id").val();
		var goJumpType = $("#goJumpType").val();  
		var id = $("#id").val();  
		var equNum =$("#equNum").val();  
		$.ajax({
	    	url:url+"getPwsAllAppTypByPwsId.htm",
	    	data : "pws_id="+pws_id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data.length> 0){
	    				 var htm = "";
	    				 for(var i = 0 ; i < data.data.length ; i++){
    						 var lst = data.data[i];
	    					 var gourl = jumpPageUrl;
	    					 var imgSrc = "";
	    					 if(lst.typ_ide == "GFNBQ"){
	    						 gourl += "commens/zhjk/sb/sb-gf.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/gf.png"
	    					 }else if(lst.typ_ide == "CNNBQ"){
	    						 gourl += "commens/zhjk/sb/sb-storage.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/cn.png"
	    					 }else if(lst.typ_ide == "CNDC"){
	    						 gourl += "commens/zhjk/sb/sb-energy.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/dianc.png"
	    					 }else if(lst.typ_ide == "HJJCY"){
	    						 gourl += "commens/zhjk/sb/environment.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/hj.png"
	    					 }else if(lst.typ_ide == "DCDC"){
	    						 gourl += "commens/zhjk/sb/sb-dc.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/DC.png"
	    					 }else if(lst.typ_ide == "BYQ"){
	    						 gourl += "commens/zhjk/sb/sb-transformer.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/by.png"
	    					 }else if(lst.typ_ide == "DB"){
	    						 gourl += "commens/zhjk/sb/sb-enwatch.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/db.png"
	    					 }else if(lst.typ_ide == "DNZLJCZZ"){
	    						 gourl += "commens/zhjk/sb/sb-powercheck.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/dnzl.png"
	    					 }else if(lst.typ_ide == "HLX"){
	    						 gourl += "commens/zhjk/sb/sb-headerbox.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/hl.png"
	    					 }else if(lst.typ_ide == "JLPDG"){
	    						 gourl += "commens/zhjk/sb/sb-peidiangui.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/jl.png"
	    					 }else if(lst.typ_ide == "ZLPDG"){
	    						 gourl += "commens/zhjk/sb/sb-zlpeidiangui.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/zl.png"
	    					 }else if(lst.typ_ide == "JLZZ"){
	    						 gourl += "commens/zhjk/sb/sb-jielie.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/jiel.png"
	    					 }else if(lst.typ_ide == "XLBH"){
	    						 gourl += "commens/zhjk/sb/sb-protect.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/xlbh.png"
	    					 }else if(lst.typ_ide == "JLCDZ"){
	    						 gourl += "commens/zhjk/sb/sb-dcz.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/cd.png"
	    					 }else if(lst.typ_ide == "ZLCDZ"){
	    						 gourl += "commens/zhjk/sb/sb-acz.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/cd.png"
	    					 }else if(lst.typ_ide == "KZQ"){
	    						 gourl += "commens/zhjk/sb/sb-kzq.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/kzq.png";
	    					 }else if(lst.typ_ide == "WWXT"){
	    						 gourl += "commens/zhjk/sb/sb-microgrid.htm";
	    						 imgSrc = jumpPageUrl+"images/menu/ww.png";
	    					 } 
	    					 
	    					 
	    					 gourl += "?typ_ide="+lst.typ_ide+"&pws_id="+pws_id+"&app_typ_id="+lst.app_typ_id;
		    				 
	    					 
    						 if(typ_ide == lst.typ_ide){
    							  htm +='<dd class="active">';
    						 }else{
    							 htm +='<dd>';
    						 }
    						 
    						 htm +='<span class="parent_">'+
								 '<a data-href="'+gourl+'" href="javascript:void(0);" typ_ide="'+lst.typ_ide+'" app_typ_id="'+lst.app_typ_id+'" >'+
								 '<img src="'+imgSrc+'" >'+
								 '<p>'+lst.equ_typ_nam+'</p>'+
								 '</a>'+
								 '</span>'+
								 '</dd>';
    					 }
	    				 $("#menu").html(htm);
	    			 }
	    			 
				} else {
	               layer.alert(data.desc);
				}
	    		
	    		
	    		//设置宽高
				var Screenheight  = (document.documentElement.clientHeight);  
				//设置地图高
				$(".leftnav").css("height",Screenheight);
				
				$(".twoleftnav dd").find("span").click(function(){
					$(this).parent().addClass("active").siblings().removeClass("active");
					
					//头部选中的菜单名称和tab标签清空
					var name =   $(this).find("a").text();
		   		 	$(parent.frames["tophead"].document).find("#title").html(name);
		   		 	var typ_ide =   $(this).find("a").attr("typ_ide");
		   		 	if(typ_ide == "HJJCY"){
		   		 		 var url_p = "?app_typ_id="+app_typ_id+"&pws_id="+pws_id;
			   		 	 var html = '<a  href="'+jumpPageUrl+'commens/zhjk/sb/environment.htm'+url_p+'" class="active" target="right">实时检测</a>'+
			 		 	'<a  href="'+jumpPageUrl+'commens/zhjk/sb/environmenthistory.htm'+url_p+'" target="right">历史分析</a>'+
			 		 	'<a  href="'+jumpPageUrl+'commens/zhjk/sb/environmenthealthy.htm'+url_p+'"  target="right">健康状况</a>';
			   		 	$(parent.frames["tophead"].document).find("#tab").html(html);
		   		 	}else{
		   		 		$(parent.frames["tophead"].document).find("#tab").html("");
		   		 	}
		   		 	
		   		 	//切换图标
		   		 	//清空其他图标选中的样式
					$(this).parent().parent().find("img").each(function(i,data){
					    if($(this).attr("src").indexOf("-c") > 0){
					    	var t = $(this).attr("src").split(".png")[0].split("-c")[0];
					    	$(this).attr("src",t+".png");
					    }
				   	})
		   		 	//为当前菜单加上样式
		   		 	var imgsrc = $(this).find("a").find("img").attr("src");
		   		 	var newImgsrc = '';
		   		 	if(imgsrc.split(".png")[0].indexOf("-c") > 0){
		   		 		newImgsrc = imgsrc.split(".png")[0]+".png";
		   		 	}else{
		   		 		newImgsrc = imgsrc.split(".png")[0]+"-c.png";
		   		 	}
		   		 	$(this).find("a").find("img").attr("src",newImgsrc);
		   		 	
		   			//切换底部导航的数据
		   		 	//加载底部导航
		   		 	var menuName =  $(this).find("a").text();
   					var typ_ide =   $(this).find("a").attr("typ_ide");
   					var menuHref = "<%=basePath %>commens/zhjk/main.htm?app_typ_id="+app_typ_id+"&pws_id="+pws_id+"&typ_ide="+typ_ide;; 
   					var ThreeMenu =  '<a class="bottom-nav" href="'+menuHref+'"  target="main" id="threeLevel" style="padding-left: 0;"><i style="font-style: normal;font-size: 14px;width: 10px;height: 38px;margin-right: 5px;padding-right: 0;background: url('+jumpPageUrl+'/images/jiantou.png) no-repeat;background-size: 7px 15px;margin-top: 2px;float: left;"></i><i class="bdf"></i>'+menuName+'</a>';
   					$(top.frames['bottom'].document).find("#nav-bot").find("#threeLevel").remove();
   					$(top.frames['bottom'].document).find("#nav-bot").append(ThreeMenu);
   					
   					
		   		 	//跳转页面
		   		 	var dataHref =   $(this).find("a").attr("data-href");
		   		 	//判断是否是从告警列表跳转到当前页面的，如果是，加上可以跳转到具体设备实时数据页面你的参数 
					if(goJumpType !="" && goJumpType != undefined){
					 	paramUrl = "&goJumpType="+goJumpType+"&id="+id+"&equNum="+equNum;
					}else{
						paramUrl = "";
					}  
		   		 	
		   		 	// 请求跳转
		   			parent.frames["right"].window.location.href= dataHref+paramUrl;
		   			
		   		    //then  只跳转一次，以后再点击就是正常的点击流程 -  置空数据
		   		    if(paramUrl != ""){
		   		    	$("#goJumpType").val("");
			   			goJumpType = "";
		   		    }
		   			
				});
				
				$("#menu .active").find("span").click(); 
	    	}
		
		})
	})
			
		
	
		
		   
		  
	</script>
</html>
