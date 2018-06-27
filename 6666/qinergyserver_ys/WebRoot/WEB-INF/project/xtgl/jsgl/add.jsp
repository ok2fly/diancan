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
	<input type="hidden" name = "com_id" id="com_id" value="${user.com_id}" >
	<input type="hidden" name = "crt_use_id" id="crt_use_id" value="${user.id}" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>角色名称</th>
			<td><input type="text" placeholder="请输入角色名称" id="rol_nam" class="popinput quinputcol requiredInp"></td>
			<th>角色标识</th>
			<td><input type="text" placeholder="请输入角色标识" id="rol_ide" class="popinput quinputcol requiredInp"></td>
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
		<button class="popbut" onclick="insert()" >确定</button>
		<input class="popbut" type="reset" value="重置" class="cz" onclick="reset()">
	</div>
	
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script>
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
	 
	 
	 var  crt_use_id = parseInt($("#crt_use_id").val());
	 var  com_id = parseInt($("#com_id").val());
	 var  rol_nam = $("#rol_nam").val();
	 var  rol_ide = $("#rol_ide").val();
	 var  remark = $("#remark").val();
	 
	   	layer.confirm("是否添加？",function(){

	 var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
		$.ajax({
	    	url:url+"insertUserRole.htm",
	    	data:"rol_nam="+rol_nam+"&rol_ide="+rol_ide+"&com_id="+com_id+"&remark="+remark+"&use_id="+crt_use_id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1 ; 
	    			window.parent.getData();	
	    			layer.alert("保存成功");
				} else {
	               layer.alert(data.desc);
				}
	    	}
		})
	   	})
}
function reset(){
	window.location.reload();
}
</script>
</body>
</html>
