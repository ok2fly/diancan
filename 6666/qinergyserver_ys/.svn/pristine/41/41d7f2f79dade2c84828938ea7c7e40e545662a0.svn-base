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
<title>安全管理添加类型</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="userId" name="useId">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>安全类型</th>
			<td><input type="text" placeholder="请输入安全类型"  id="sctTypeName" name="sctTypeName" class="popinput quinputcol requiredInp"></td>
			<th>&nbsp;&nbsp;</th>
			<td>&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
					<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea"></textarea>
			</td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert();">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
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
	
	var userId = $("#userId").val();
	var sctTypeName = $("#sctTypeName").val();
	var remark=$("#remark").val();
	var param="";
	if(!isNull(sctTypeName)){
		param+="&sctTypeName="+sctTypeName;
	}
	
	layer.confirm("确定保存？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		var remark = $("#remark").val();
		 $.ajax({
		    	url:url+"addSctType.htm",
		    	data : param+"&&remark="+remark+"&&userId="+userId,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 window.parent.currentPage = 1 ;
		    			 window.parent.getTypeData();
		    			 layer.alert("保存安全类型成功",function(){
		    				 $(".cancle").click();
		    			 });
					} else {
						layer.close(indexlayer);
		               layer.alert(data.desc);
					}
		    	}
	 	})
 	})
}
</Script>
</body>
</html>
