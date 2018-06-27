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
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden"  value="${user.id}"  id="crt_use_id" name="crt_use_id">
	<input type="hidden"   id="equ_num" name="equ_num">
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>设备编号:</th>
			<td id="equ_num_name"></td>
		</tr>
		<tr>
			<th>第一次审核人</th>
			<td>
				<select class="popinput requiredInp" placeholder="请输入第一次审核人" id="one_check_use_id">
		 			
				</select>
			</td>
			<th>处理意见</th>
			<td><input type="text" placeholder="请输入处理意见" id="scrap_opinion"  class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>报废原因</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入报废原因" id="scrap_resaon" name="scrap_resaon"  class="poptextarea requiredInp"></textarea>
			</td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3"  placeholder="请输入备注" id="remark" class="poptextarea requiredInp"></textarea>
			</td>
		</tr>
		<tbody id="fileimg"></tbody>
	</table>
	</form>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	var id = $("#id").val();
	getById(id);
})

function getById(id){
	$.ajax({
    	url:url+"selScrapById.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
   				 if(data.data.lstMap ){
       				 var d =  data.data.lstMap[0];
       				 $("#scrap_resaon").val(d.scrap_resaon);
       				 $("#remark").val(d.remark);
       				 $("#equ_num_name").html(d.equ_num);
       				 $("#equ_num").val(d.equ_num);
       				$("#scrap_opinion").val(d.scrap_opinion);
       				getPerson(d.one_check_use_id);
       			 }
   				var htmfil="";
    			if(data.data.lstFile){
    				for(var i=0;i<data.data.lstFile.length;i++){
    					var fil=data.data.lstFile[i];
    					htmfil='<tr>'+
    					'<th>文件</th>'+
    					'<td><span>'+fil.file_name+'</span></td>'+
    					'<th></th>'+
    					'<td></td>';
    				}

    			}
    			var htmimg="";
    			if(data.data.lstImg){
    				for(var i=0;i<data.data.lstImg.length;i++){
    					var img=data.data.lstImg[i];
    					htmimg='<tr>'+
    					'<th>图片</th>'+
    					//'<td><img src="'+img.image_path+'"  width="200px" height="100px"></td>'+
    					'<td><span>'+img.tour_image_name+'</span></td>'+
    					'<th></th>'+
    					'<td></td>';
    				}
    			}
    			var html=htmfil+htmimg;
    			$("#fileimg").html(html);
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}

 
 
function getPerson(id){
	$.ajax({
    	url:url+"selUserNameTourCheck.htm",
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
   				 if(data.data.length > 0 ){
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				if(d.id == id){
	   		    				htmls += "<option value='"+d.id+"' selected>"+d.use_nam+"</option>";
   		    				}else{
   		    					htmls += "<option value='"+d.id+"'>"+d.use_nam+"</option>";
   		    				}
   	    			 }
       			 }else{
       					htmls +=  "<option value='qxz'>选择第一次审核人</option>";
       			 }
    			
   	    		$("#one_check_use_id").html(htmls); 
    			
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
		   	}else{
		   		if($(this).attr("id") == "one_check_use_id" ){
	 		 		if($(this).val() == "qxz"){
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
	
	
	var id = $("#id").val();
	var equ_num  = $("#equ_num").val();
	var scrap_resaon  = $("#scrap_resaon").val();
	var crt_use_id  = $("#crt_use_id").val();
	var one_check_use_id  = $("#one_check_use_id").val();
	var scrap_opinion  = $("#scrap_opinion").val();
	var remark  = $("#remark").val();
	
	var param = "id="+id+"&crt_use_id="+crt_use_id;
	
	//equ_num  = 2;
	if(equ_num != '' && equ_num != undefined && equ_num != 'qxz'){
		param += "&equ_num="+equ_num;
	}else{
		layer.alert("设备编号不能为空");
		return ;
	}
	
	if(one_check_use_id != '' && one_check_use_id != undefined && one_check_use_id != 'qxz'){
		param += "&one_check_use_id="+one_check_use_id;
	}else{
		layer.alert("请选择第一次审核人");
		return ;
	} 
	
	if(remark != '' && remark != undefined){
		param += "&remark="+remark;
	} 
	
	if(scrap_resaon != '' && scrap_resaon != undefined){
		param += "&scrap_resaon="+scrap_resaon;
	}  
	
	if(scrap_opinion != '' && scrap_opinion != undefined ){
		param += "&scrap_opinion="+scrap_opinion;
	} 
	layer.confirm("确定修改？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"updateScrap.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		 layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.document.getElementById("type").value=1;
	            	window.parent.getData();
	   	    		$(".cancle").click();
	   	    		window.parent.layer.alert("保存成功");
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
