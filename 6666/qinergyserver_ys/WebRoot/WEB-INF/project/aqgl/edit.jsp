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
<title>安全管理修改</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type = "hidden" value="${id}" name="" id="id">
	<input type = "hidden" value="${user.id}" name="" id="use_id">
 	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
			<tr>
				<th>安全类型</th> 
				<td><select class="popinput requiredInp" id="typeId"    placeholder="请选择安全类型"  ></select></td>
				<th>名称</th>
				<td><input type="text"   id="sctName"  placeholder="请输入名称" class="popinput quinputcol requiredInp" ></td>
			</tr>
			<tr>
				<th>描述</th>
				<td colspan="3">
					<textarea    cols="3"  rows="3" placeholder="请输入描述" id="sctDec"   name="sctDec"  class="poptextarea"></textarea>
				</td>
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
	var id = $("#id").val();
	getById(id);  
})

function getById(id){
	 $.ajax({
	    	url:url+"getSct.htm",
	    	data : "sctId="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 for(var i = 0; i< data.data.length ; i++){
	    				 var d =  data.data[i];
	    				 if(d.id == id){
	    					 $("#sctName").val(d.sct_nam);
	    	   	    		 $("#sctDec").val(d.sct_dec);
	    	   	    		 var typeId = d.typeId;
	    	   	    		 getType(typeId);
	    				 }
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
  })
}


function getType(typeId){
	 $.ajax({
	    	url:url+"sctType.htm",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				if(typeId == d.id ){
			    					 htmls +=  "<option value='"+d.id+"' selected >"+d.sct_typ_nam+"</option>";
			    				}else{
			    					 htmls +=  "<option value='"+d.id+"'>"+d.sct_typ_nam+"</option>";
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
	var typeId = $("#typeId").val();
	var sctName = $("#sctName").val();
	var sctDec = $("#sctDec").val();
	var use_id = $("#use_id").val();
	var remark = $("#remark").val();
	layer.confirm("确定修改？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
		    	url:url+"updateSctInfo.htm",
		    	data : "id="+id+
		    			"&&sct_nam="+sctName+
		    			"&&sct_typ_id="+typeId+
		    			"&&sct_dec="+sctDec+
		    			"&&use_id="+use_id,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			  window.parent.currentPage = 1 ; 
		    			  window.parent.getData();	
		    			  layer.alert("修改成功",function(){
		  	            		$(".cancle").click();
		  	              });
	
					} else {
		               layer.alert(data.desc);
					}
		    	}
		})	
	})
	
}

</script>
</body>
</html>
