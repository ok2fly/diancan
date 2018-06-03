<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<title>智慧云餐厅操作系统</title>
    <link rel='Shortcut Icon' type='image/x-icon' href='${basePath}/win10-ui/img/windows.ico'>
    <script type="text/javascript" src="${basePath}/win10-ui/js/jquery-2.2.4.min.js"></script>
    <link href="${basePath}/win10-ui/css/animate.css" rel="stylesheet">
    <script type="text/javascript" src="${basePath}/win10-ui/component/layer-v3.0.3/layer/layer.js"></script>
    <link rel="stylesheet" href="${basePath}/win10-ui/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="${basePath}/win10-ui/css/default.css" rel="stylesheet">
    <script type="text/javascript" src="${basePath}/win10-ui/js/win10.js"></script>
    <style>
        * {
            font-family: "Microsoft YaHei", 微软雅黑, "MicrosoftJhengHei", 华文细黑, STHeiti, MingLiu
        }

        /*磁贴自定义样式*/
         .win10-block-content-text {
             line-height: 44px;
             text-align: center;
             font-size: 16px;
         }
    </style>
    <script>
        Win10.onReady(function () {

            //设置壁纸
            Win10.setBgUrl({
                main: '${basePath}/win10-ui/img/wallpapers/main.jpg',
                mobile: '${basePath}/win10-ui/img/wallpapers/mobile.jpg',
            });

            Win10.setAnimated([
                'animated flip',
                'animated bounceIn',
            ], 0.01);
        });
        
        
        function openWin(th){
        	/// onclick="Win10.openUrl('${app.app_url}?token=${token}','<img class=\'icon\' src=\'${basePath}/${app.icon}\'/>${app.app_name}')"
        	var openurl = $(th).attr("openurl");
        	var openimg = $(th).attr("openimg");
        	var openname = $(th).attr("openname");
        	var img = "<img class='icon' src='"+openimg+"'/>"+openname;
        	Win10.openUrl(openurl,img,'',function(){
        		$(".layui-layer-setwin").find("span").each(function(){
        			//alert($(this).text());
        			$(this).css("margin-top","10px");
        		});


        	});
        	
        	
        	
        }
        
  	var exitfun = function(){
        	location.href = "${basePath}/console/frontLoginout.action";
        };
        
        /*
        document.body.onbeforeunload = function(event){
            var rel = Win10.lang( '系统可能不会保存您所做的更改','The system may not save the changes you have made.');
            if(!window.event){
                event.returnValue=rel;
            }else{
                window.event.returnValue=rel;
            }
        };
        */
    </script>
</head>
<body>
<div id="win10">
    <div class="desktop">
        <div id="win10-shortcuts" class="shortcuts-hidden">
               <c:forEach var="app" items="${apps}">
				<div class="shortcut" openurl="${app.app_url}?token=${token}"  openimg="${basePath}/${app.icon}" openname="${app.app_name}"
		                 onclick="openWin(this);">
		                <img class="icon" src="${basePath}/${app.icon}"/>
		                <div class="title">${app.app_name}</div>
           		 </div>
         	</c:forEach>
          
        </div>
        
        <div id="win10-desktop-scene"></div>
    </div>
    <div id="win10-menu" class="hidden">
        <div class="list win10-menu-hidden animated animated-slideOutLeft">
        <!-- 
            <div class="item"
                 onclick="Win10.exit()">
         -->
            <div class="item"
                 onclick="Win10.exit(exitfun) ">
                <i class="black icon fa fa-power-off fa-fw"></i><span class="title">关闭</span>
            </div>
        <div id="win10-menu-switcher"></div>
    </div>
    <div id="win10_command_center" class="hidden_right">
        <div class="title">
            <h4 style="float: left">消息中心 </h4>
            <span id="win10_btn_command_center_clean_all">全部清除</span>
        </div>
        <div class="msgs"></div>
    </div>
    <div id="win10_task_bar">
        <div id="win10_btn_group_left" class="btn_group">
            <div id="win10_btn_win" class="btn"><span class="fa fa-windows"></span></div>
        </div>
        <div id="win10_btn_group_middle" class="btn_group"></div>
        <div id="win10_btn_group_right" class="btn_group">
            <div class="btn" id="win10_btn_time"></div>
            <div class="btn" id="win10_btn_command"><span id="win10-msg-nof" class="fa fa-comment-o"></span></div>
            <div class="btn" id="win10_btn_show_desktop"></div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">

</script>
</html>