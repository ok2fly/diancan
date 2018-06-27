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
	</head>
	<body>
		<div class="leftnav" >
			<div class="twoleftnav">
				<dl>
					<c:forEach items="${menu }" var="m" varStatus="status">
							<c:choose>
							<c:when test = "${status.index == 0}">
								<dd class="active">
							</c:when>
							<c:otherwise>
								<dd >
							</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test = "${empty m.menu}">
									<span class="parent_">
								</c:when>
								<c:otherwise>
									 <span class="parent_" style="background:none;" >
								</c:otherwise>
							</c:choose>
									<!-- 为了点击时，显示第一个子节点菜单 -->
									<c:choose>
										<c:when test = "${empty m.menu}">
											<a href="<%=basePath%>${m.module_url }?menu_id=${m.id }&&is_button=${m.is_button }"  target="right"><img src="<%=basePath%>images/menu/tytb.png"><p>${m.module_name }</p></a>
										</c:when>
										<c:otherwise>
											<c:forEach items="${m.menu }" var="n" varStatus="status">
												<c:if test = "${status.index == 0}">
													 <a  href="javascript:void(0);"  onclick="childPage(this)"  target="right"><img src="<%=basePath%>images/menu/tytb.png"><p>${m.module_name }</p><i class="active"></i></a>
												</c:if>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</span>
								<ul>
									<c:forEach items="${m.menu }" var="n">
										<li><a href="<%=basePath%>${n.module_url }?menu_id=${n.id }&&is_button=${n.is_button }" target="right" class="rightClass">${n.module_name }</a></li>
									</c:forEach>
								</ul>
							</dd>
					</c:forEach>
				</dl>
			</div>
		</div>
	</body>
	<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
	<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
	<script>
	$(function(){
		//设置宽高
		var Screenheight  = (document.documentElement.clientHeight);  
		//设置地图高
		$(".leftnav").css("height",Screenheight);
		
		$(".twoleftnav dd").find("span").click(function(){
			$(this).parent().addClass("active").siblings().removeClass("active");
		});
		
		 $(".rightClass").each(function(i,data){
		   $(this).click(function(){			   
			   $(this).parent().parent().find("li").removeClass("active");
			   $(this).parent().addClass("active");
			   var name = $(this).text();
			   $(parent.frames["tophead"].document).find("#title").html(name);
		   })
	   	})
	   	
	   	$(".parent_").click(function(){
	   		var name =  "";
   			if($(this).parent().find("ul").find("li").length > 0 ){
   				name = $($(this).parent().find("ul").find("li")[0]).find(".rightClass").text();
   			}else{
   				name = $(this).find("a").text();
   			}
   		 	$(parent.frames["tophead"].document).find("#title").html(name);
	   	})
	   	
	   	//默认是第一个菜单点击事件
	   	//$($("dd.active").find(".parent_")[0]).find("a").click();
		//document.getElementsByTagName("dd").getElementsByClassName("active")[0].getElementsByClassName("parent_").getElementsByTagName("a")[0].click();
		//$($("dd.active").find(".parent_")[0]).getElementsByTagName("a")[0].click()
	   	var a = document.querySelector("dd.active");
		var b = a.getElementsByClassName("parent_")[0];
		b.getElementsByTagName("a")[0].click();
	   	
	})
		
	function childPage(a){
		a.parentNode.parentNode.getElementsByTagName("ul")[0].getElementsByTagName("li")[0].getElementsByTagName("a")[0].click();
		console.log(123)
	}	   
		  
	</script>
</html>
