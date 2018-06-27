<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>故障类型管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop-edit-pas.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="mod_use_id" >
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden" id="loginName"  value="${user.acc_num  }" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<!-- <tr>
			<th>登陆名</th>
			<td><input type="text" placeholder="请输入登陆名"  id="loginName"   class="popinput quinputcol requiredInp" ></td>
		</tr> -->
		<tr>
			<th>旧密码</th>
			<td><input type="password" placeholder="请输入旧密码"  id="passwordOld"   class="popinput quinputcol requiredInpEditPas" ></td>
		</tr>
		<tr>
			<th>新密码</th>
			<td><input type="password" placeholder="请输入新密码"  id="passwordNew"   class="popinput quinputcol requiredInpEditPas" ></td>
		</tr>
		<tr>
			<th>确认密码</th>
			<td><input type="password" placeholder="请再次输入密码"  id="passwordNewCon"   class="popinput quinputcol requiredInpEditPas" ></td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()">确定</button>
	</div>
</div>

<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>



function update(){
	
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInpEditPas").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	}
	  		if(reFlag){
	  			return false;
	  		}
	}); 
	if(reFlag){
	   return false;
	}
	var param="";

	  var loginName=$("#loginName").val(); 

	 var passwordOld = $("#passwordOld").val()
	 var  passwordNew = $("#passwordNew").val();
	 var  passwordNewCon = $("#passwordNewCon").val();
	 param+="&loginName="+loginName+"&passwordOld="+passwordOld+"&passwordNew="+passwordNew+"&passwordNewCon="+passwordNewCon; 
	/* param+="passwordOld="+passwordOld+"&passwordNew="+passwordNew+"&passwordNewCon="+passwordNewCon; */
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});			
		$.ajax({
	    	url:url+"updateUserPassWd.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);
	    		if (data.resultcode=="USR000") {
	    			layer.alert("修改密码成功");
	    			top.location.href = jumpPageUrl; 
				} else {
	               layer.alert(data.desc);
				}
	    	}
		});
	 }
	

</Script>
</body>
</html>
