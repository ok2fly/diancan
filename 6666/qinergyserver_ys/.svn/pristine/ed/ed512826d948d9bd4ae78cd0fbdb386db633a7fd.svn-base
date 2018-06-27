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
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="userId" name="useId">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>设备类型名称 </th>
			<td><input type="text" placeholder="请输入设备类型名称 "  id="typ_nam" name="typ_nam" class="popinput quinputcol"></td>
			<th>唯一标识</th>
			<td><input type="text" placeholder="请输入唯一标识"  id="typ_ide" name="typ_ide"  class="popinput quinputcol"></td>
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
	var userId = $("#userId").val();
	var typ_nam = $("#typ_nam").val();
	var typ_ide = $("#typ_ide").val();
	var remark = $("#remark").val();
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	 $.ajax({
	    	url:url+"insAppTyp.htm",
	    	data : "typ_nam="+typ_nam+"&&typ_ide="+typ_ide+"&&remark="+remark+"&userId="+userId,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			 layer.alert("保存设备类型成功");
	    			 $(".cancle").click();
	    			 window.parent.getTypeData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
 	})
}
</Script>
</body>
</html>
