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
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/uploadify/uploadify.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>知识名称</th>
			<td><input type="text" placeholder="请输入知识名称"  id="knwName" class="popinput quinputcol"></td>
			<th>知识描述</th>
			<td><input type="text" placeholder="请输入知识描述"  id="knwDec"   class="popinput quinputcol"></td>
		</tr>
		<tr>
			<th>知识库类型</th> 
			<td><select class="popinput"   id="typeId" ></select></td>
			<th>备注</th>
			<td><input type="text" placeholder="请输入备注"   id="remarke"  class="popinput quinputcol"></td>
		</tr>
		<tr>
			<th>文件</th> 
			<td><input type="file"  name="file"  id="file" class="popinput quinputcol"></td>
		</tr>
		<tr>
			<th></th>
			<td><div id="fileid"></div></td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert();">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/ajaxfileupload.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/uploadify/jquery.uploadify.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	getType();
    $('#file').uploadify({
    	'swf'  :  '<%=basePath%>/js/uploadify/uploadify.swf',
        'uploader': url+'createKnw.htm',
        'buttonText'  : '选择文件', // 设置按钮上显示的文本'
        'auto': false,
        'queueID':'fileid',
        'method' : 'post', // 设置提交的方法
        'multi': true,
        'progressData':'percentage',
        'fileObjName':'file',
        'onQueueComplete':function(queueData){
        	layer.alert("上传成功"+queueData.uploadsSuccessful+"个文件,失败"+queueData.uploadsErrored+"个文件");
        	setTimeout(function(){
        		$(".cancle").click();
        		window.parent.getData();
       		},1000);
        }	

    });
})

function getType(){
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
			    				 htmls +=  "<option value='"+d.id+"'>"+d.knw_typ_nam+"</option>";
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
	 var  useId = parseInt($("#user_id").val());
	 var  knwName = $("#knwName").val();
	 var  knwDec = $("#knwDec").val();
	 var  typeId = parseInt($("#typeId").val());
	 var  remarke = $("#remarke").val();
	if($("#file").data('uploadify').queueData.queueLength > 0){
		 var j = {
				 typeId : typeId,
				 knwName : knwName,
				 knwDec : knwDec,
				 useId : useId,
				 remarke : remarke
		 }
		 $('#file').uploadify('settings','formData',j);
		 $('#file').uploadify('upload','*');
	}else{
		$.ajax({
	    	url:url+"KnwType.htm",
	    	data:"useId="+useId+"&knwName="+knwName+"&knwDec="+knwDec+"&typeId="+typeId+"&remarke="+remarke,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			layer.alert("保存成功");
	            	$(".cancle").click();
	            	window.parent.getData();
	    			
				} else {
	               layer.alert(data.desc);
				}
	    	}
		});
	}
	
	 
}
</Script>
</body>
</html>
