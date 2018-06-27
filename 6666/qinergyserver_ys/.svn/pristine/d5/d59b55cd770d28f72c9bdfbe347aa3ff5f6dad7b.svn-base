<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
 
<script>
$(function() {
	var userId = $("#user_id").val();
	getGjData();
	getGg();
	getNotice();
	getMenuData();
	
	window.setInterval(function(){
		getGjData();
	},60000);
	
	window.setInterval(function(){
		getGg();
	},60000);
	
	window.setInterval(function(){
		getNotice();
	},60000);
	
	
})
function getMenuData(){
	var rol_id = $("#rol_id").val();
	$.ajax({
		url:url+"getUserAuthorityPC.htm",
		data : "role_id="+rol_id,
		success:function(data){
			if(data.data.length>0){
				var html='<div class="winmenu">'+
				'<ul margin-top="8px">';
				for(var i=0;i<data.data.length;i++){
					var d=data.data[i];
					var typ = '';
					
					if(d.is_dsp == "1"){
						if(i == 10 || i == 11 || i == 12){
							typ = '2';
		 					html+='<li class="menuli dd'+(i+1)+' "  typ='+typ+' data-href="'+jumpPageUrl+d.module_url+'" onclick="jumpUrl(this)"><i ></i><a href="javascript:void(0);">'+d.module_name+'</a></li>';

						}else{
							
		 					html+='<li class="menuli dd'+(i+1)+'"  data-href="'+jumpPageUrl+d.module_url+'" onclick="jumpUrl(this)"><i ></i><a href="javascript:void(0);">'+d.module_name+'</a></li>';
						}
					}
					
 				}
				html+='<li class="menuli dd14" data-href="<%=basePath%>commens/index.htm" onclick="jumpUrl(this)"><i></i><a href="javascript:void(0);"  >首页</a></li>'+
					'</ul></div>';
			}
			if(data.data.length > 0){
				 $(".home").click(function(){
					openMenu(html);
				 })
			 }
		}
	})
	
}
function openMenu(html){
	var isShow = false;
	var isShow2 = false;
	
	if($(parent.frames["main"].document).find("body").html()!= undefined){
		if($(parent.frames["main"].document).find("body").find(".winmenu").html()!= undefined){
			isShow = true ; 
		}
	}else{
		if($(parent.frames["main"].frames["left"].document).find("body").find(".winmenu").html()!= undefined){
			isShow2 = true ; 
		}
	}
	
	if(isShow || isShow2){
		if($(parent.frames["main"].document).find("body").html()!= undefined){
			$(parent.frames["main"].document).find("body").find(".winmenu").remove();
		}else{
			$(parent.frames["main"].frames["left"].document).find("body").find(".winmenu").remove();
		}
	}else{
		if($(parent.frames["main"].document).find("body").html()!= undefined){
			$(parent.frames["main"].document).find("body").find(".winmenu").remove();
			$(parent.frames["main"].document).find("body").append(html);
		}else{
			$(parent.frames["main"].frames["left"].document).find("body").find(".winmenu").remove();
			$(parent.frames["main"].frames["left"].document).find("body").append(html);
		}
	}
}
function getGg(){
	//获取公告
	$.ajax({
		url:url+"getAnnInfLst.htm",
		data : "ann_typ="+1,
		success: function(datas){
			 /* var html = ''; 
			 for(var i = 0 ; i < datas.data.length ; i++){
				 var d = datas.data[i];
				 html += '<li><a href="javascript:void(0);">'+d.ann_cont+'</a></li>';
			 } 
			 $("#mq").find("ul").empty().html(html);
			 bindMsgClickEvent(); */
			 
			 var html = ''; 
			 for(var i = 0 ; i < datas.data.length ; i++){
				 var d = datas.data[i];
				 html += (i+1)+":"+d.ann_cont+" ";
			 } 
			 $(".ggggd").html(html);
		},
		error : function(){
			
		}
	}); 
}
function getGjData(){
	//获取告警数量
	var userId = $("#user_id").val();
	var is_def_sta = $("#is_def_sta").val();
	$.ajax({
		url:url+"getNoticeInfByUseId.htm",
		data : "use_id="+userId+"&is_def_sta="+is_def_sta,
		success: function(datas){
			 console.log("datas.data.length=="+datas.data.length);
			 if(datas.data.length > 99 ){
				 $(".gj").find("i").html("99+");
			 }else{
				 $(".gj").find("i").html(datas.data.length);
			 }
			 var html = '';
			 for(var i = 0 ;i<datas.data.length ; i++){
				 var d = datas.data[i];
				 var color = d.fau_level == 1 ? '#F1AC45' : d.fau_level == 2 ? 'red' : 'red';
				 html += '<div class="gj_info"  hrefData="'+jumpPageUrl+'/commens/zhjk/main.htm?app_typ_id='+d.app_typ_id+'&pws_id='+d.pws_id+'&typ_ide='+d.app_typ_ide+'&equNum='+d.equ_num+'&id='+d.equ_id+'&goJumpType=2" onclick="setNoticePage('+d.id+',this);" >'+
							'<div class="h30 pl8 pr8 pt8">'+
				 			'<div class="fl"><a style="display: block;  width: 270px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">'+d.pws_nam+'</a></div>'+
					 		'</div>'+
					 		'<div class="h20 pl14 pr14 pt8">'+
				 			'<div class="fl"><a style="color: #333;" target="main">'+d.equ_nam+'</a></div>'+
				 			'<div class="fr" style="font-size: 14px;color:'+color+';">'+d.fau_info+'</div>'+
					 		'</div>'+
					 		'<div class="h20 pl14  pr14">'+
				 			'<div class="fl" style="font-size: 12px;color: #333;">'+getLocalDateAndTime(d.crt_tim,1)+'</div>'+
				 			'<div class="fr" ><a  href="javascript:void(0);" onclick="setNoticeState(event,'+d.id+',this);" style="color: #7DCADC;" target="main">关闭</a></div>'+
				 			'</div>'+
			 			'</div>';
			 }
			 var htmlss = '<div class="winbox" >'+
			 '<div class="pl8 pr8 pb18">'+
			 	'<div style="width: 100%;">'+
			 		'<h3>告警列表<div class="fr qxgj" ></div></h3>'+ 
				 '</div>'+
				 '<div style="overflow:auto;width: 100%;margin-top: 10px;height:431px;" >'+html+'</div>'+
			 '</div>'+
			'</div>';
			
			 if(datas.data.length > 0){
				 $(".gj").click(function(){
					 bindGjClickEvent(htmlss);
				 })
			 }else{
				 $(".gj").unbind("click");
			 }
			 
			 //刷新数据时，判断窗口是否打开，如果打开，就要刷新数据
			 /* if($(parent.frames["main"].document).find("body").html()!= undefined){
				if($(parent.frames["main"].document).find("body").find(".winbox")){
					$(parent.frames["main"].document).find("body").find(".winbox").remove();
					$(parent.frames["main"].document).find("body").append(htmlss);
				}
			 }else{
				if($(parent.frames["main"].frames["right"].document).find("body").find(".winbox")){
					$(parent.frames["main"].frames["right"].document).find("body").find(".winbox").remove();
					$(parent.frames["main"].frames["right"].document).find("body").append(htmlss);
				}
			 } */
			 
		},
		error : function(){
			
		}
	}); 
}
/*
 * 获取告警数据
 */
function bindGjClickEvent(h){
	if($(parent.frames["main"].document).find("body").html()!= undefined){
		$(parent.frames["main"].document).find("body").find(".winbox").remove();
		$(parent.frames["main"].document).find("body").append(h);
	}else{
		$(parent.frames["main"].frames["right"].document).find("body").find(".winbox").remove();
		$(parent.frames["main"].frames["right"].document).find("body").append(h);
	}
}

var noticeS = [];
/*获取通知数据*/
function getNotice(){
	//获取告警数量
	var userId = $("#user_id").val();
	$.ajax({
		url:url+"getSysNoticeInfByUseId.htm",
		data : "use_id="+userId,
		success: function(datas){
			if(datas.data.length > 99 ){
				$(".notice").find("i").html("99+");
			 }else{
				 $(".notice").find("i").html(datas.data.length);
			 }
			 $(".notice").find("i").html(datas.data.length);
			 var html = '';
			 for(var i = 0 ;i<datas.data.length ; i++){
				 var d = datas.data[i];
				 var nocC = d.notice_con ;
				 if(d.notice_con.length > 55 ){
					 nocC = d.notice_con.substring(0,55)+"...";
				 }
				 html += '<div class="gj_info" "height:100%;">'+
					 		'<div class="pl8 pr8 pt8">'+
				 			'<div class="" style="padding: 2px 0;text-indent: 24px; text-overflow: ellipsis;overflow: hidden;height: 52px;width: 100%; display: block;float: left;"><a href="javascript:void(0);" target="main">'+nocC+'</a></div>'+
					 		'<div class="fr"><a href="javascript:void(0);" onclick="setNoticeState2(event,'+d.id+',this);" style="color: #7DCADC;margin-right:10px;" target="main">关闭</a></div>'+
					 		'</div>'+
			 			'</div>';
				 noticeS.push(d.id);
			 }
			 var htmlss = '<div class="winbox" style="overflow:auto;" >'+
			 '<div class="pl8 pr8 pb18">'+
			 '<h3>消息列表<div class="fr qxgj" ></div></h3>'+ 
			 '</div>'+
			 '<div style="overflow:auto;width: 100%;margin-top: 10px;height:431px;" >'+html+'</div>'+
			'</div>';
			
			 if(datas.data.length > 0){
				 $(".notice").click(function(){
					 bindNoticeClickEvent(htmlss);
				 })
			 }else{
				 $(".notice").unbind("click");
			 }
			 
			 /* //刷新数据时，判断窗口是否打开，如果打开，就要刷新数据
			 if($(parent.frames["main"].document).find("body").html()!= undefined){
				 if($(parent.frames["main"].document).find("body").find(".winbox")){
					$(parent.frames["main"].document).find("body").find(".winbox").remove();
					$(parent.frames["main"].document).find("body").append(htmlss);
				 }
			 }else{
				 if($(parent.frames["main"].frames["right"].document).find("body").find(".winbox")){
					$(parent.frames["main"].frames["right"].document).find("body").find(".winbox").remove();
					$(parent.frames["main"].frames["right"].document).find("body").append(htmlss);
				 }
			 } */
		},
		error : function(){
			
		}
	}); 
}
 
function bindNoticeClickEvent(h){
	if($(parent.frames["main"].document).find("body").html()!= undefined){
		$(parent.frames["main"].document).find("body").find(".winbox").remove();
		$(parent.frames["main"].document).find("body").append(h);
	}else{
		$(parent.frames["main"].frames["right"].document).find("body").find(".winbox").remove();
		$(parent.frames["main"].frames["right"].document).find("body").append(h);
	}
	
	 /* //把消息设置成已读
	for(var i = 0 ; i < noticeS.length ; i++){
		var notId = noticeS[i];
		$.ajax({
			url:url+"updSysNoticeState.htm",
			data : "not_id="+notId,
			success: function(datas){
				getNotice();
			},
			error : function(){
				
			}
		}); 
	}   */
}
/**
 * 绑定消息事件
 */
function bindMsgClickEvent(){
	var $this = $("#mq");
	var scrollTimer;
	$this.hover(function() {
		clearInterval(scrollTimer);
	}, function() {
		scrollTimer = setInterval(function() {
		scrollNews($this);
	}, 2000);
	}).trigger("mouseleave");
	function scrollNews(obj) {
		var $self = obj.find("ul");
		var lineHeight = $self.find("li:first").height(); 
		$self.animate({
			"marginTop": -lineHeight + "px"
		}, 600, function() {
			$self.css({
				marginTop: 0
			}).find("li:first").appendTo($self);
		})
	}
}


//清空菜单导航
$(document).on('click','#oneLevel',function(){  
	$(this).parent().find("#twoLevel").remove();
	$(this).parent().find("#threeLevel").remove();
});  

$(document).on('click','#twoLevel',function(){  
	$(this).parent().find("#threeLevel").remove();
});  
</script>
</head>
<body>
	<input type="hidden" id="rol_id" value="${user.rol_id}">
	<input type="hidden" id="user_id" value="${user.id}">
	<input type="hidden" id="is_def_sta" value="${user.is_def_sta}" >
	<div class="topbottom">
		<div class="w40 h38 fl" style="position: relative;  width:48%; ">
			<!-- <div style="position: absolute;">
					<ul>
						<li>dafsdf</li>
						<li>dafsdf</li>
						<li>dafsdf</li>
						<li>dafsdf</li>
						<li>dafsdf</li>
					</ul>
				</div> -->
			<a class="home" style="background:#000;" <%-- href="<%=basePath%>commens/index.htm" --%>  onclick="" target="main"><i></i></a>
			<div id="nav-bot">
				 
			</div>
		</div>
		<div class="w40 h38 fl" style="width:38%;">
			 <a  class="gg" style="background: url(<%=basePath%>images/gg.png) no-repeat center;background-size: 20px 18px;"></a>
			 <a  class="ggf" >公告栏：</a>
			 <div id="mq" class="ggf">
			 	 <marquee class="ggggd"> </marquee>
               <!-- <ul>
	               <li><a href="">1.我是消息通知11</a></li>
	               <li><a href="">2.消息2消息2消息2消息2消息2消息2</a></li>
	               <li> <a href="">3.消息3消息3消息3消息3消息3消息3</a></li>
	               <li> <a href="">4.消息4消息4消息4消息4消息4消息4</a></li>
	               <li> <a href="">5.消息5消息5消息5消息5消息5消息5</a></li>
               </ul> -->
             </div>
		</div>
		<div class="w10 h38 fr">
			 <a class="gj msg" >
				 <i>0</i>
			 </a>
			  <a class="notice msg"  >
			 	<i>0</i>
			 </a> 
		</div>
		
	</div>
</body>
</html>