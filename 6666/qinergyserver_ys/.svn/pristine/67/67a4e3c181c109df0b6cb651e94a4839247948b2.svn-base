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
	<form  action="" id="uploadModel"  enctype="multipart/form-data" > 
		<input type="hidden" value="${def_num}" id="def_num" name="def_num">
		<input type="hidden" value="${user.id}" id="userId" name="use_id">
		<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
			<tr>
				<th>文件</th> 
				<td><input type="file"  name="file"  placeholder="请选择文件" id="file" class="popinput quinputcol requiredInp"></td>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<th>备注</th>
				<td colspan="3">
					<textarea    cols="3"  rows="3"   placeholder="请输入描述"  id="remark" name="remark"  class="poptextarea"></textarea>
				</td>
			</tr> 
		</table>
		<div class="tc popbutbox">
			<input class="popbut cancle" value="取消"  >
			<input class="popbut" onclick="insert()"  value="确定" > 
		</div>
	</form>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-form.js?pubVersion=201802070001"></script>
<Script>


$(function(){
	
})
 
function insert(){
	 var  useId = parseInt($("#userId").val());
	 var  def_num = $("#def_num").val();
	 var  remark = $("#remark").val();
	 
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
	
	layer.confirm("确定上传？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 
		var  maxSize = 1024 * 1024 * 100 ;
		var size = document.getElementById('file').files[0].size;
        var filesize = (size).toFixed(2);
        
        if(filesize < maxSize){ 
			var option = {
		        　　 	url : url+'uploadDef.htm',
		       　　  	type : 'POST',
		        　　 	dataType : 'json',
		         　　	contentType: false,
		        processData: false,
		       　　  	success : function(data) {
		          　　 			layer.close(indexlayer);  //关闭 loading 
				    	if(data.resultcode=="USR000"){
				            	$(".cancle").click();
				            	window.parent.getData();
				            	window.parent.layer.alert("上传成功");
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
        }else{
        	layer.close(indexlayer);  //关闭 loading 
        	layer.alert('请检查文件,请勿上传>100M的文件');
        }
		return false;
	})
}	
</Script>
</body>
</html>
