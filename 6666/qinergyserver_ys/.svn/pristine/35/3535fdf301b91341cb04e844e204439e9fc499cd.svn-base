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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="userId" name="created_id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		
		<tr>
			<th>反馈描述</th>
			<td colspan="3">
				<textarea    cols="3"  rows="10" placeholder="请输入反馈描述" id="feedBack"    class="poptextarea requiredInp"></textarea>
			</td>
		</tr>
		<!-- <tr>
			<th></th>
			<td><div id="fileid"></div></td>
		</tr> -->
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert();">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>

function insert(){
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
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
	 var  feedBack = parseInt($("#feedBack").val());
	layer.confirm("确定保存？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		/* var option = {
	     　　 	url : url+'insertFeedBack.htm',
	     　　 	data:"feedBack="+feedBack,
	    　　  	type : 'POST',
	     　　 	dataType : 'json',
	      　　	contentType: false,
	       processData: false,
	    　　  	success : function(data) {
	       　　 			layer.close(indexlayer);  //关闭 loading 
			    	if(data.resultcode=="USR000"){
			    		layer.alert("保存成功");
		            	$(".cancle").click();
		            	window.parent.getData();
			    	}else{
			    		layer.alert(data.desc);
			    	}
	  },
	  error: function(res){  
		    	layer.close(indexlayer);  //关闭 loading 
		  }  
		}
		$("#uploadModel").ajaxSubmit(option);
	}); */
	
	  var  userId = $("#userId").val();
	 var  feedBack = $("#feedBack").val();
	
		$.ajax({
	    	url:url+"insertFeedBack.htm",
	    	data:"userId="+userId+"&feedBack="+feedBack,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			layer.alert("保存成功");
	            	$(".cancle").click();
	            	window.parent.currentPage  = 1;;
	            	window.parent.getData();
	    			
				} else {
	               layer.alert(data.desc);
				}
	    	}
		})
	}) 
	
	 
}
</Script>
</body>
</html>
