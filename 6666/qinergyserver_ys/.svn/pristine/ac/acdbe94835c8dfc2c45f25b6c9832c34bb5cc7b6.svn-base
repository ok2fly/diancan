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
<title>知识库添加</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${type}" id="type">
	<input type="hidden" value="${user.id}" id="useId" name="useId">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>知识名称</th>
			<td><input type="text" placeholder="请输入知识名称"  id="knwName" name="knwName"  class="popinput quinputcol requiredInp"></td>
			<th>知识库类型</th> 
			<td><select class="popinput requiredInp" placeholder="请选择知识库类型"  name="typeId" id="typeId" ></select></td>
		</tr>
		<tr>
			<th>知识描述</th>
			<td colspan="3">
				<textarea    cols="3"  rows="3" placeholder="请输入知识描述"  id="knwDec"   name="knwDec" class="poptextarea"></textarea>
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
$(function(){
	getType();
})

function getType(){
	 var type=$("#type").val();

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
			    				if(type==d.id){
				    				 htmls +=  "<option value='"+d.id+"' selected>"+d.knw_typ_nam+"</option>";

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

function insert(){
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	}else{
		   		if($(this).attr("id") == "pro_id" || $(this).attr("id") == "cit_id" || $(this).attr("id") == "are_id" ){
	 		 		if($(this).val() == "0"){
	 		 		   reFlag = true;
					   layer.alert($(this).attr("placeholder"))
					   return false;
	 		 		}
	 		 	} 
		   	}
	  		if(reFlag){
	  			return false;
	  		}
	}); 

	 if(reFlag){
		return false;
	 }
	 	var  useId = $("#useId").val();
		var knwName=$("#knwName").val();
		var knwDec=$("#knwDec").val();
		var typeId=$("#typeId").val();

	layer.confirm("确定新增？",function(){
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			
			$.ajax({
				url:url+"createKnw.htm",
				data:"knwName="+knwName+"&knwDec="+knwDec+"&typeId="+typeId+"&useId="+useId,
				type:"post",
				dataType:"json",
				success:function(data){
					layer.close(indexlayer);
					if(data.resultcode=="USR000"){
						window.parent.currentPage  = 1;
						window.parent.getData();
		    			layer.alert("保存成功",function(){
		    				$(".cancle").click();
		    			});
					}else{
						layer.alert(data.desc);
					}
				}
			})
			
	})
	 
	 
}
</Script>
</body>
</html>
