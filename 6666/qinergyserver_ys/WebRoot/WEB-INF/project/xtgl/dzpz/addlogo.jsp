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
<title>电站配置</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
<form  action="" id="uploadModel"  enctype="multipart/form-data" >
	<input type="hidden" value="${id}" id="id"  name="pws_id">
	<input type="hidden" value="${user.id}" name="user_id">
	
 	<table cellpadding="0"   border="0" width="100%" class="poptable">
 		
		<tr> 
			<th>附件</th>
			<td><input type="file" name="file" id="file" placeholder="请选择文件" class="popinput quinputcol requiredInp"> </td>
			<th></th>
			<td></td>
		</tr>
		<tr> 
			<th>描述</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark" name="remark"  onfocus="" class="poptextarea quinputcol"></textarea>
			</td>
		</tr>
		<tbody id="fileimg"></tbody>
	</table>
</form>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="uploadImg()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-form.js?pubVersion=201802070001"></script>

<Script>

function uploadImg(){
	
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
	 
	layer.confirm("是否上传",function(){
		var id=$("#id").val();
		var comPjtNam=$("#comPjtNam").val();
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		var option = {
	     　　 	url : url+'insertPwsPic.htm',
	    　　  	type : 'POST',
	     　　 	dataType : 'json',
	      　　	contentType: false,
	       	processData: false,
	    　　  	success : function(data) {
	       　　 			layer.close(indexlayer);  //关闭 loading 
			    	if(data.resultcode=="USR000"){
			    		window.parent.currentPage  = 1;
			    		window.parent.getData();
			    		layer.alert("保存成功",function(){
			    			$(".cancle").click();
			    		});
			    	}else{
			    		layer.alert(data.desc);
			    	}
			  },
			  error: function(res){  
			    	layer.close(indexlayer);  //关闭 loading 
			    	layer.alert("请检查文件,请勿上传>100M的文件");
		  }  
		}
		$("#uploadModel").ajaxSubmit(option);
	})
}
</Script>
</body>
</html>