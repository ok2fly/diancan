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
	<input type = "hidden" value="${id}" name="" id="knwId">
	<input type = "hidden" value="${user.id}" name="" id="useId">
 	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
				<th>知识名称</th>
				<td><input type="text"   id="knwName" class="popinput quinputcol" readonly="readonly"></td>
				<th>知识描述</th>
				<td><input type="text"    id="knwDec"   class="popinput quinputcol"></td>
			</tr>
			<tr>
				<th>知识库类型</th> 
				<td><select class="popinput" id="typeId"   ></select></td>
				<th>备注</th>
				<td><input type="text"  id="remarke"    class="popinput quinputcol"></td>
			</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()" >确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script>
$(function(){
	var id = $("#knwId").val();
	getById(id);  
	getType();
})

function getById(id){
	 $.ajax({
	    	url:url+"getKnwInfoById.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	   	    		 $("#knwName").val(data.data.knw_nam);
	   	    		 $("#knwDec").val(data.data.knw_dec);
	   	    		 $("#remarke").val(data.data.remark);
	   	    		 var typeId = data.data.typeId;
	   	    		 getType(typeId);
				} else {
	               layer.alert(data.desc);
				}
	    	}
  })
}


function getType(typeId){
	 $.ajax({
	    	url:url+"KnwType.htm",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				if(typeId == d.id ){
			    					 htmls +=  "<option value='"+d.id+"' selected >"+d.knw_typ_nam+"</option>";
			    				}else{
			    					 htmls +=  "<option value='"+d.id+"'>"+d.knw_typ_nam+"</option>";
			    				}
		    			 }
	    			 } 
	   	    		 
	   	    	     $("#typeId").html(htmls);
	    			
				} else {
	               layer.alert(data.desc);
				}
	    	}
 	})
}

function update(){
	var knwId = $("#knwId").val();
	var typeId = $("#typeId").val();
	var knwDec = $("#knwDec").val();
	var useId = $("#useId").val();
	var remarke = $("#remarke").val();
	 $.ajax({
	    	url:url+"updateKnw.htm",
	    	data : "knwId="+knwId+
	    			"&&typeId="+typeId+
	    			"&&knwDec="+knwDec+
	    			"&&useId="+useId+
	    			"&&remarke="+remarke,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			  layer.alert("修改成功");
	    			  $(".cancle").click();
				} else {
	               layer.alert(data.desc);
				}
	    	}
})
}

</script>
</body>
</html>
