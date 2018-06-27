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
	<input type="hidden" value="${user.id}" id="useId" name="useId">
	<input type="hidden" value="${id}" id="id" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>字典类型</th>
			<td><input type="text"  placeholder="请输入字典类型"  id="dic_typ_nam" name="dic_typ_nam" class="popinput quinputcol requiredInp"></td>
			<th>字典唯一标识</th>
			<td><input type="text"  placeholder="请输入字典唯一标识"  id="dic_typ_ide" name="dic_typ_ide"  class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>排序号</th>
			<td><input type="number"   placeholder="请输入排序号"  id="sor_num" name="sor_num" class="popinput quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
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
		<button class="popbut" onclick="edit();">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<Script>

$(function(){
	var id = $("#id").val();
	getDescData(id);
})

 function getDescData(id){
	$.ajax({
    	url:url+"getDataDicTypList.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			for(var i = 0 ; i<data.data.length;i++){
    				var d = data.data[i];
    				if(d.id == id ){
    					$("#dic_typ_nam").val(d.dic_typ_nam);
    					$("#dic_typ_ide").val(d.dic_typ_ide);
    					$("#sor_num").val(d.sor_num);
    					$("#remark").val(d.remark);
    				}
    			}
			} else {
               layer.alert(data.desc);
			}
    	}
	}) 
}


function edit(){
	
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
	 
	 
	var id = $("#id").val();
	var userId = $("#useId").val();
	var dic_typ_nam =  $("#dic_typ_nam").val();
	var dic_typ_ide = $("#dic_typ_ide").val();
	var sor_num = $("#sor_num").val();
	var remark = $("#remark").val();
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	
	layer.confirm("确认修改？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
		    	url:url+"updDataDicTyp.htm",
		    	data : "id="+id+"&&dic_typ_nam="+dic_typ_nam+"&&dic_typ_ide="+dic_typ_ide+"&&sor_num="+sor_num+"&&remark="+remark,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer); //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 window.parent.currentPage = 1 ; 
		    			 window.parent.getTypeData();
		    			 window.parent.getData();
		    			 layer.alert("修改数据字典类型成功",function(){
		    				 $(".cancle").click();
		    			 });
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
